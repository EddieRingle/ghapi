package org.idlesoft.libraries.ghapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class APIAbstract {
	public GitHubAPI api;
	public String login, password;

	public static class Response {
		public int statusCode;
		public String resp;
		public String url;
	}

	public APIAbstract(GitHubAPI a)
	{
		api = a;
	}

	/**
	 * Sets login details
	 *
	 * @param l - String containing Github username
	 * @param p - String containing username's Github password
	 */
	public void login(String l, String p)
	{
		login = l;
		password = p;
	}

	/**
	 * Sends a HTTP POST request
	 * 
	 * @param url
	 * @param postData
	 * @return Response object containing status code and response body.
	 */
	public Response HTTPPost(String url, String postData)
	{
		Response response = new Response();
		try {
			// Setup connection
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			// Add authentication details if we know them
			if (api.api.login != null && api.api.password != null) {
				conn.setRequestProperty("Authorization", "Basic "
										+ Base64.encodeBase64String(
													(api.api.login + ":" + api.api.password).getBytes()).replaceAll("\\n",""));
			}
			conn.connect();

			// Send POST data to the server
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			out.write(postData);
			out.flush();

			// Get the response from the server
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();

			for (String line = in.readLine(); line != null; line = in.readLine()) {
				sb.append(line + '\n');
			}

			// Store response information in Response object
			try {
				response.statusCode = conn.getResponseCode();
			} catch (IOException e) {
				response.statusCode = 401;
			}
			response.resp = sb.toString();

			// Clean up
			conn.disconnect();
			conn = null;
			out = null;
			in = null;
			sb = null;
		} catch (IOException e) {
			response.statusCode = 401;
		}
		response.url = url;
		return response;
	}

	/**
	 * Sends a HTTP GET request
	 * 
	 * @param url
	 * @return Response object containing status code and response body.
	 */
	public Response HTTPGet(String url)
	{
		Response response = new Response();
		try {
			// Setup connection
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			conn.setRequestMethod("GET");
			// Add authentication details if we know them
			if (api.api.login != null && api.api.password != null) {
				conn.setRequestProperty("Authorization", "Basic "
										+ Base64.encodeBase64String(
													(api.api.login + ":" + api.api.password).getBytes()).replaceAll("\\n",""));
			}
			conn.connect();

			// Get response from the server
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();

			for (String line = in.readLine(); line != null; line = in.readLine()) {
				sb.append(line + '\n');
			}

			// Store response in a Response object
			try {
				response.statusCode = conn.getResponseCode();
			} catch (IOException e) {
				response.statusCode = 401;
			}
			response.resp = sb.toString();

			// Clean up
			conn.disconnect();
			conn = null;
			in = null;
			sb = null;
		} catch (IOException e) {
			response.statusCode = 401;
		}
		response.url = url;
		return response;
	}

	public static String encode(String str)
	{
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return URLEncoder.encode(str);
		}
	}
}
