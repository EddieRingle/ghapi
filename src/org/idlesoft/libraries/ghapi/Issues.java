/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;


public class Issues extends APIAbstract {

	public Issues(GitHubAPI a)
	{
		super(a);
	}

	/**
	 * Searches for issues for a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @param state
	 * @param query
	 * @return
	 */
	public Response search(String owner, String repositoryName, String state, String query)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/search/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state) + "/" + encode(query));
	}
	/**
	 * Fetches a list of open or closed issues for a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @param state
	 * @return
	 */
	public Response list(String owner, String repositoryName, String state)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/list/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(state));
	}
	/**
	 * View an individual issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public Response issue(String owner, String repositoryName, int number)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/show/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""));
	}
	/**
	 * Fetches a list of comments for a specific issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public Response list_comments(String owner, String repositoryName, int number)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/comments/"
				+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""));
	}
	/**
	 * Opens a new issue with given title and body text
	 *
	 * @param owner
	 * @param repositoryName
	 * @param title
	 * @param body
	 * @return
	 */
	public Response open(String owner, String repositoryName, String title, String body)
	{
		return HTTPPost("https://github.com/api/v2/json/issues/open/"
						+ encode(owner) + "/" + encode(repositoryName),
						"title=" + encode(title) + "&body=" + encode(body));
	}
	/**
	 * Reopens an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public Response reopen(String owner, String repositoryName, int number)
	{
		return HTTPPost("https://github.com/api/v2/json/issues/reopen/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + number, "");
	}
	/**
	 * Closes an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @return
	 */
	public Response close(String owner, String repositoryName, int number)
	{
		return HTTPPost("https://github.com/api/v2/json/issues/close/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + number, "");
	}
	/**
	 * Edits an issue with given title and body text
	 *
	 * @param owner
	 * @param repositoryName
	 * @param title
	 * @param body
	 * @return
	 */
	public Response edit(String owner, String repositoryName, int number, String title, String body)
	{
		return HTTPPost("https://github.com/api/v2/json/issues/edit/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + number,
						"title=" + encode(title) + "&body=" + encode(body));
	}
	/**
	 * Fetches a list of issue labels associated with a repository
	 *
	 * @param owner
	 * @param repositoryName
	 * @return
	 */
	public Response labels(String owner, String repositoryName)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/labels/"
						+ encode(owner) + "/" + encode(repositoryName));
	}
	/**
	 * Adds a label to an issue, creating it if it does not exist
	 *
	 * @param owner
	 * @param repositoryName
	 * @param label
	 * @param number
	 * @return
	 */
	public Response add_label(String owner, String repositoryName, String label, int number)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/label/add/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(label) + "/" + encode("" + number + ""));
	}
	/**
	 * Removes a label from an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param label
	 * @param number
	 * @return
	 */
	public Response remove_label(String owner, String repositoryName, String label, int number)
	{
		return HTTPGet("https://github.com/api/v2/json/issues/label/remove/"
						+ encode(owner) + "/" + encode(repositoryName) + "/" + encode(label) + "/" + encode("" + number + ""));
	}
	/**
	 * Adds a comment to an issue
	 *
	 * @param owner
	 * @param repositoryName
	 * @param number
	 * @param body
	 * @return
	 */
	public Response add_comment(String owner, String repositoryName, int number, String body)
	{
		return HTTPPost("https://github.com/api/v2/json/issues/comment/"
							+ encode(owner) + "/" + encode(repositoryName) + "/" + encode("" + number + ""),
							"comment=" + encode(body));
	}
}