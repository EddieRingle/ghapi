/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;

public class Commits extends APIAbstract {

	public Commits(GitHubAPI a)
	{
		super(a);
	}

	/**
	 * Fetches a list of commits for a given branch of a repository
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param branch
	 * @return a Response object containing the list of commits
	 */
	public Response list(String owner, String repositoryName, String branch)
	{
		return HTTPGet("https://github.com/api/v2/json/commits/list/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch));
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
	public Response list_for_file(String owner, String repositoryName, String branch, String path)
	{
		return HTTPGet("https://github.com/api/v2/json/commits/list/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(branch) + "/" + encode(path));
	}
	/**
	 * Fetches details of a commit, given it's SHA hash
	 * 
	 * @param owner
	 * @param repositoryName
	 * @param sha
	 * @return a Response object containing the information for the commit
	 */
	public Response commit(String owner, String repositoryName, String sha)
	{
		return HTTPGet("https://github.com/api/v2/json/commits/show/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(sha));
	}
}