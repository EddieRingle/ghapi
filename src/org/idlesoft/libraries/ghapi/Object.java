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

public class Object extends APIBase {
	/**
	 * Fetches the contents of the tree given the tree SHA
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the contents of the tree
	 */
	public static Response tree(String owner, String repositoryName, String sha)
	{
		return HTTPGet("http://github.com/api/v2/json/tree/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
	}
	/**
	 * Fetches the contents of the tree given the tree SHA, includes private repositories
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @param user
	 * @param token
	 * @return a Response object containing the contents of the tree
	 */
	public static Response tree(String owner, String repositoryName, String sha, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/tree/show/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches data about a blob given it's tree SHA and path
	 *
	 * @param owner
	 * @param repositoryName
	 * @param treeSha
	 * @param path
	 * @return a Response object containing the blob information
	 */
	public static Response blob(String owner, String repositoryName, String treeSha, String path)
	{
		return HTTPGet("http://github.com/api/v2/json/blob/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha) + "/" + encode(path));
	}
	/**
	 * Fetches data about a blob given it's tree SHA and path, includes private repos
	 *
	 * @param owner
	 * @param repositoryName
	 * @param treeSha
	 * @param path
	 * @param user
	 * @param token
	 * @return a Response object containing the blob information
	 */
	public static Response blob(String owner, String repositoryName, String treeSha, String path, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/blob/show/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha) + "/" + encode(path)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Fetches a list of all blobs for a certain tree SHA
	 *
	 * @param owner
	 * @param repositoryName
	 * @param treeSha
	 * @return a Response object containing the list of blobs
	 */
	public static Response list_blobs(String owner, String repositoryName, String treeSha)
	{
		return HTTPGet("http://github.com/api/v2/json/blob/all/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha));
	}
	/**
	 * Fetches a list of all blobs for a certain tree SHA, includes private repos
	 *
	 * @param owner
	 * @param repositoryName
	 * @param treeSha
	 * @param user
	 * @param token
	 * @return a Response object containing the list of blobs
	 */
	public static Response list_blobs(String owner, String repositoryName, String treeSha, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/blob/all/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
	/**
	 * Get the raw data of a blob
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the raw data
	 */
	public static Response raw(String owner, String repositoryName, String sha)
	{
		return HTTPGet("http://github.com/api/v2/json/blob/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
	}
	/**
	 * Get the raw data of a blob, includes private repos
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @param user
	 * @param token
	 * @return a Response object containing the raw data
	 */
	public static Response raw(String owner, String repositoryName, String sha, String user, String token)
	{
		if (!user.equals("") && !token.equals("")) {
			return HTTPGet("http://github.com/api/v2/json/blob/show/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha)
							+ "?login=" + encode(user) + "&token=" + encode(token));
		} else {
			throw new InvalidParameterException("Login details cannot be empty");
		}
	}
}