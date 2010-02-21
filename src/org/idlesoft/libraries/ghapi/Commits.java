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

public class Commits extends APIBase {
	/**
	 * Fetches a list of commits for a given branch of a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param branch
	 * @return a Response object containing the list of commits
	 */
	public static Response list(String owner, String repositoryName, String branch)
	{
		return HTTPGet("http://github.com/api/v2/json/commits/list/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch));
	}
	/**
	 * Fetches a list of commits for a given branch of a repository, includes private repositories
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param branch
	 * @param user
	 * @param token
	 * @return a Response object containing the list of commits
	 */
	public static Response list(String owner, String repositoryName, String branch, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/commits/list/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches a list of commits that modified a given file
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param branch
	 * @param path
	 * @return a Response object containing the list of commits
	 */
	public static Response list_for_file(String owner, String repositoryName, String branch, String path)
	{
		return HTTPGet("http://github.com/api/v2/json/commits/list/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch) + "/" + encode(path));
	}
	/**
	 * Fetches a list of commits that modified a given file, includes private repositories
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param branch
	 * @param path
	 * @param user
	 * @param token
	 * @return a Response object containing the list of commits
	 */
	public static Response list_for_file(String owner, String repositoryName, String branch, String path, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/commits/list/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch) + "/" + encode(path)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches details of a commit, given it's SHA hash
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the information for the commit
	 */
	public static Response commit(String owner, String repositoryName, String sha)
	{
		return HTTPGet("http://github.com/api/v2/json/commits/show/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
	}
	/**
	 * Fetches details of a commit, given it's SHA hash, includes private repositories
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @param user
	 * @param token
	 * @return a Response object containing the information for the commit
	 */
	public static Response commit(String owner, String repositoryName, String sha, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/commits/show/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
}