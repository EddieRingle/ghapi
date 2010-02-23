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

public class User extends APIBase {

	/**
	 * Searches GitHub for users matching supplied query
	 * 
	 * @param query
	 * @return a Response object containing status code and search results
	 */
	public static Response search(String query)
	{
		return HTTPGet("http://github.com/api/v2/json/user/search/" + encode(query));
	}

	/**
	 * Fetches info for a given user
	 * 
	 * @param username
	 * @return a Response object containing status code and user information
	 */
	public static Response info(String username)
	{
		return HTTPGet("http://github.com/api/v2/json/user/show/"
						+ encode(username));
	}

	/**
	 * Fetches info for a given user, includes private information
	 * 
	 * @param username
	 * @param token
	 * @return a Response object containing status code and user information
	 */
	public static Response info(String username, String token)
	{
		if (!token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/user/show/"
							+ encode(username) + "?login="
							+ encode(username) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Fetch a list of people a user is following
	 * 
	 * @param username
	 * @return a Response object containing status code and following list
	 */
	public static Response following(String username) {
		return HTTPGet("http://github.com/api/v2/json/user/show/"
						+ encode(username) + "/following");
	}

	/**
	 * Fetch a list of a user's followers
	 * 
	 * @param username
	 * @return a Response object containing status code and list of followers
	 */
	public static Response followers(String username) {
		return HTTPGet("http://github.com/api/v2/json/user/show/"
						+ encode(username) + "/followers");
	}

	/**
	 * Follows a given user
	 * 
	 * @param username
	 * @param user
	 * @param token
	 * @return a Response object containing status code and response body
	 */
	public static Response follow(String username, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/user/follow/" + encode(username),
							"login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Unfollows a given user
	 * 
	 * @param username
	 * @param user
	 * @param token
	 * @return a Response object containing status code and response body
	 */
	public static Response unfollow(String username, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPPost("http://github.com/api/v2/json/user/unfollow/" + encode(username),
							"login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Fetches a list of repositories a user is watching
	 * 
	 * @param username
	 * @return a Response object containing status code and list of watched repositories
	 */
	public static Response watching(String username)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/watched/" + encode(username));
	}

	/**
	 * Fetches a list of repositories a user is watching, will include a user's private repos
	 *
	 * @param username
	 * @param user
	 * @param token
	 * @return a Response object containing a list of watched repositories
	 */
	public static Response watching(String username, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/watched/" + encode(username)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Fetches a user's public activity feed
	 * 
	 * @param username
	 * @return a Response object containing status code and public activity feed
	 */
	public static Response activity(String username)
	{
		return HTTPGet("http://query.yahooapis.com/v1/public/yql?q=" + encode("select * from atom where url='http://github.com/"
						+ username + ".atom'") + "&format=json&diagnostics=false");
	}

	/**
	 * Fetches a user's private activity feed
	 * 
	 * @param username
	 * @param token
	 * @return a Response object containing status code and private activity feed
	 */
	public static Response activity(String username, String token)
	{
		if (!token.equals("")) {
			return HTTPGet("http://query.yahooapis.com/v1/public/yql?q=" + encode("select * from atom where url='http://github.com/"
					+ username + ".private.atom?token=" + token + "'") + "&format=json&diagnostics=false");
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
}