/**
 * ghapi
 * A Java wrapper for the GitHub API
 * 
 * Copyright (c) 2010 Idlesoft.
 * 
 * Licensed under the New BSD License.
 */

package org.idlesoft.libraries.ghapi;

public class GitHubAPI {
	public Repository Repository;

	public GitHubAPI(String user, String token)
	{
		Repository = new Repository();
	}
}
