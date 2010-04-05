/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;

import java.security.InvalidParameterException;

public class Issues extends APIBase {
	/**
	 * Searches for issues for a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @param state
	 * @param query
	 * @return
	 */
	public static Response search(String owner, String repositoryName, String state, String query)
	{
		return HTTPGet("http://github.com/api/v2/json/issues/search/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state) + "/" + encode(query));
	}
	public static Response search(String owner, String repositoryName, String state, String query, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/search/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state) + "/" + encode(query)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches a list of open or closed issues for a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @param state
	 * @return
	 */
	public static Response list(String owner, String repositoryName, String state)
	{
		return HTTPGet("http://github.com/api/v2/json/issues/list/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state));
	}
	public static Response list(String owner, String repositoryName, String state, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/list/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * View an individual issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public static Response issue(String owner, String repositoryName, int number)
	{
		return HTTPGet("http://github.com/api/v2/json/issues/show/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""));
	}
	public static Response issue(String owner, String repositoryName, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/show/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + "")
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches a list of comments for a specific issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public static Response list_comments(String owner, String repositoryName, int number)
	{
		return HTTPGet("http://github.com/api/v2/json/issues/comments/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""));
	}
	public static Response list_comments(String owner, String repositoryName, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/comments/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + "")
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Opens a new issue with given title and body text
	 *
	 * @param owner
	 * @param repositoryName
	 * @param title
	 * @param body
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response open(String owner, String repositoryName, String title, String body, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/issues/open/"
							+ encode(owner) + "/" + encode(repositoryName),
							"login=" + encode(user) + "&token=" + encode(token) + "&title=" + encode(title) + "&body=" + encode(body));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Reopens an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response reopen(String owner, String repositoryName, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/issues/reopen/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + number,
							"login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Closes an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response close(String owner, String repositoryName, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/issues/close/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + number,
							"login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Edits an issue with given title and body text
	 *
	 * @param owner
	 * @param repositoryName
	 * @param title
	 * @param body
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response edit(String owner, String repositoryName, int number, String title, String body, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/issues/edit/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + number,
							"login=" + encode(user) + "&token=" + encode(token) + "&title=" + encode(title) + "&body=" + encode(body));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches a list of issue labels associated with a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @return
	 */
	public static Response labels(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/issues/labels/"
						+ encode(owner) + "/" + encode(repositoryName));
	}
	public static Response labels(String owner, String repositoryName, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/labels/"
							+ encode(owner) + "/" + encode(repositoryName)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Adds a label to an issue, creating it if it does not exist
	 *
	 * @param owner
	 * @param repositoryName
	 * @param label
	 * @param number
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response add_label(String owner, String repositoryName, String label, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/label/add/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(label) + "/" + encode("" + number + "")
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Removes a label from an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param label
	 * @param number
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response remove_label(String owner, String repositoryName, String label, int number, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/issues/label/remove/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(label) + "/" + encode("" + number + "")
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Adds a comment to an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @param body
	 * @param user
	 * @param token
	 * @return
	 */
	public static Response add_comment(String owner, String repositoryName, int number, String body, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/issues/comment/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""),
							"login=" + encode(user) + "&token=" + encode(token) + "&comment=" + encode(body));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
}