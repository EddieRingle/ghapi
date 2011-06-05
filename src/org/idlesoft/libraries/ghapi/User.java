/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;

public class User extends APIAbstract {

	public User(GitHubAPI a)
	{
		super(a);
	}

	/**
	 * Searches GitHub for users matching supplied query
	 * 
	 * @param query
	 * @return a Response object containing status code and search results
	 */
	public Response search(String query)
	{
		return HTTPGet("https://github.com/api/v2/json/user/search/" + query);
	}

	/**
	 * Fetches info for a given user
	 * 
	 * @param username
	 * @return a Response object containing status code and user information
	 */
	public Response info(String username)
	{
		return HTTPGet("https://github.com/api/v2/json/user/show/"
						+ encode(username));
	}

	/**
	 * Fetch a list of people a user is following
	 * 
	 * @param username
	 * @return a Response object containing status code and following list
	 */
	public Response following(String username) {
		return HTTPGet("https://github.com/api/v2/json/user/show/"
						+ encode(username) + "/following");
	}

	/**
	 * Fetch a list of a user's followers
	 * 
	 * @param username
	 * @return a Response object containing status code and list of followers
	 */
	public Response followers(String username) {
		return HTTPGet("https://github.com/api/v2/json/user/show/"
						+ encode(username) + "/followers");
	}

	/**
	 * Follows a given user
	 * 
	 * @param username
	 * @return a Response object containing status code and response body
	 */
	public Response follow(String username)
	{
		return HTTPPost("https://github.com/api/v2/json/user/follow/" + encode(username), "");
	}

	/**
	 * Unfollows a given user
	 * 
	 * @param username
	 * @return a Response object containing status code and response body
	 */
	public Response unfollow(String username)
	{
		return HTTPPost("https://github.com/api/v2/json/user/unfollow/" + encode(username), "");
	}

	/**
	 * Fetches a list of repositories a user is watching
	 * 
	 * @param username
	 * @return a Response object containing status code and list of watched repositories
	 */
	public Response watching(String username)
	{
		return HTTPGet("https://github.com/api/v2/json/repos/watched/" + encode(username));
	}

	/**
	 * Fetches a user's public activity feed
	 * 
	 * @param username
	 * @return a Response object containing status code and public activity feed
	 */
	public Response activity(String username)
	{
		return HTTPGet("https://github.com/" + encode(username) + ".json");
	}

	/**
	 * Fetches a user's private activity feed
	 * 
	 * @param username
	 * @param token
	 * @return a Response object containing status code and private activity feed
	 */
	public Response private_activity()
	{
		return HTTPGet("https://github.com/" + encode(api.api.login) + ".private.json");
	}

	/**
	 * Fetches GitHub's public timeline
	 *
	 * @return a Response object containing status code and timeline feed
	 */
	public Response timeline()
	{
		return HTTPGet("https://github.com/timeline.json");
	}
}