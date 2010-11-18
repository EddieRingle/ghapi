/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;


public class Object extends APIAbstract {

	public Object(GitHubAPI a)
	{
		super(a);
	}

	/**
	 * Fetches the contents of the tree given the tree SHA
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the contents of the tree
	 */
	public Response tree(String owner, String repositoryName, String sha)
	{
		return HTTPGet("https://github.com/api/v2/json/tree/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
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
	public Response blob(String owner, String repositoryName, String treeSha, String path)
	{
		return HTTPGet("https://github.com/api/v2/json/blob/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha) + "/" + encode(path));
	}
	/**
	 * Fetches a list of all blobs for a certain tree SHA
	 *
	 * @param owner
	 * @param repositoryName
	 * @param treeSha
	 * @return a Response object containing the list of blobs
	 */
	public Response list_blobs(String owner, String repositoryName, String treeSha)
	{
		return HTTPGet("https://github.com/api/v2/json/blob/all/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(treeSha));
	}
	/**
	 * Get the raw data of a blob
	 *
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the raw data
	 */
	public Response raw(String owner, String repositoryName, String sha)
	{
		return HTTPGet("https://github.com/api/v2/json/blob/show/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
	}
}