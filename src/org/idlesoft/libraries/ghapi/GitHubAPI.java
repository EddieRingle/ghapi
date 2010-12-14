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
	public APIAbstract api = new APIAbstract(this);
	public Repository repo;
	public User user;
	public Commits commits;
	public Issues issues;
	public org.idlesoft.libraries.ghapi.Object object;
	public Gists gists;

	public GitHubAPI()
	{
		loadAPIs();
	}

	public GitHubAPI loadAPIs()
	{
		repo = new Repository(this);
		user = new User(this);
		commits = new Commits(this);
		issues = new Issues(this);
		object = new org.idlesoft.libraries.ghapi.Object(this);
		gists = new Gists(this);

		return this;
	}

	public void authenticate(String login, String password)
	{
		api.login(login, password);
	}

	public void goStealth()
	{
		api.login(null, null);
	}

	public String getLogin()
	{
		return api.login;
	}
}