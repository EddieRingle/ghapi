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

public class Organizations extends APIAbstract {

	public Organizations(GitHubAPI a)
	{
		super(a);
	}

	public Response info(String organization) {
		return HTTPGet("https://github.com/api/v2/json/organizations/"
						+ encode(organization));
	}

	public Response update(String organization, String name, String email, String blog, String company, String location, String billing_email) {
		String post = "";
		if (!name.equals("")) {
			post += "organization[name]=" + name;
		}
		if (!email.equals("")) {
			if (post.equals("")) {
				post += "&";
			}
			post += "organization[email]=" + email;
		}
		if (!blog.equals("")) {
			if (post.equals("")) {
				post += "&";
			}
			post += "organization[blog]=" + blog;
		}
		if (!company.equals("")) {
			if (post.equals("")) {
				post += "&";
			}
			post += "organization[company]=" + company;
		}
		if (!location.equals("")) {
			if (post.equals("")) {
				post += "&";
			}
			post += "organization[location]=" + location;
		}
		if (!billing_email.equals("")) {
			if (post.equals("")) {
				post += "&";
			}
			post += "organization[billing_email]=" + billing_email;
		}
		return HTTPPost("https://github.com/api/v2/json/organizations/"
						+ encode(organization), encode(post));
	}

	public Response userOrganizations(String user) {
		return HTTPGet("https://github.com/api/v2/json/organizations/" + encode(user));
	}

	public Response myOrganizations() {
		return HTTPGet("https://github.com/api/v2/json/organizations");
	}

	public Response repositories() {
		return HTTPGet("https://github.com/api/v2/json/organizations/repositories");
	}

	public Response publicRepositories(String organization) {
		return HTTPGet("https://github.com/api/v2/json/organizations/" + encode(organization) + "/public_repositories");
	}

	public Response publicMembers(String organization) {
		return HTTPGet("https://github.com/api/v2/json/organizations/" + encode(organization) + "/public_members");
	}

	public Response listTeams(String organization) {
		return HTTPGet("https://github.com/api/v2/json/organizations/" + encode(organization) + "/teams");
	}

	public Response createTeam(String organization, String name, String permission, String... repo_names)
	{
		if (organization.equals("") || name.equals("") || permission.equals("") || repo_names.length == 0) {
			throw new InvalidParameterException("Missing information");
		}
		String post = "team[name]=" + encode(name) + "&team[permission]=" + encode(name);
		for (int i = 0; i < repo_names.length; i++) {
			post += "&team[repo_names][]=" + encode(repo_names[i]);
		}
		return HTTPPost("https://github.com/api/v2/json/organizations/" + encode(organization) + "/teams", post);
	}

	public Response teamInfo(int teamId) {
		return HTTPGet("https://github.com/api/v2/json/teams/" + teamId);
	}

	public Response teamMembers(int teamId) {
		return HTTPGet("https://github.com/api/v2/json/teams/" + teamId + "/members");
	}

	public Response teamRepositories(int teamId) {
		return HTTPGet("https://github.com/api/v2/json/teams/" + teamId + "/repositories");
	}
}