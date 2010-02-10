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

public class Repository extends APIBase {

	/**
	 * Searches GitHub for repositories matching supplied query
	 * 
	 * @param query
	 * @return a Response object containing status code and search results
	 */
	public static Response search(String query)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/search/" + encode(query));
	}

	/**
	 * Searches GitHub for repositories matching supplied query, includes private repositories
	 * 
	 * @param query
	 * @param user
	 * @param token
	 * @return a Response object containing status code and search results
	 */
	public static Response search(String query, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/search/"
							+ encode(query) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Fetches info for a given repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and repository information
	 */
	public static Response info(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(owner) + "/"
						+ encode(repositoryName));
	}

	/**
	 * Fetches info for a given repository, includes private repositories
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param user
	 * @param token
	 * @return a Response object containing status code and repository information
	 */
	public static Response info(String owner, String repositoryName, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/show/"
							+ encode(owner) + "/"
							+ encode(repositoryName) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Lists repositories of a given user
	 * 
	 * @param target
	 * @return a Response object containing status code and list of repositories
	 */
	public static Response list(String target)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(target));
	}

	/**
	 * Lists repositories of a given user, includes private repositories
	 * 
	 * @param target
	 * @param user
	 * @param token
	 * @return a Response object containing status code and list of repositories
	 */
	public static Response list(String target, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/show/"
							+ encode(target) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Watches a given repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param user
	 * @param token
	 * @return a Response object containing status code and updated repository information
	 */
	public static Response watch(String owner, String repositoryName, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/watch/"
							+ encode(owner) + "/"
							+ encode(repositoryName) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Unwatches a given repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param user
	 * @param token
	 * @return a Response object containing status code and updated repository information
	 */
	public static Response unwatch(String owner, String repositoryName, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/unwatch/"
							+ encode(owner) + "/"
							+ encode(repositoryName) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Forks a given repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param user
	 * @param token
	 * @return a Response object containing status code and information about the new fork
	 */
	public static Response fork(String owner, String repositoryName, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/repos/fork/"
							+ encode(owner) + "/"
							+ encode(repositoryName) + "?login="
							+ encode(user) + "&token="
							+ encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}

	/**
	 * Fetches list of collaborators for a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and list of collaborators
	 */
	public static Response collaborators(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(owner) + "/"
						+ encode(repositoryName) + "/collaborators");
	}

	/**
	 * Fetches list of forks for a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and list of forks
	 */
	public static Response network(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(owner) + "/"
						+ encode(repositoryName) + "/network");
	}

	/**
	 * Fetches a list of languages used in a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and list of languages
	 */
	public static Response languages(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
				+ encode(owner) + "/"
				+ encode(repositoryName) + "/languages");
	}

	/**
	 * Fetches a list of tags on a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and list of tags
	 */
	public static Response tags(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
				+ encode(owner) + "/"
				+ encode(repositoryName) + "/tags");
	}

	/**
	 * Fetches a list of branches for a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @return a Response object containing status code and list of branches
	 */
	public static Response branches(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
				+ encode(owner) + "/"
				+ encode(repositoryName) + "/branches");
	}
}