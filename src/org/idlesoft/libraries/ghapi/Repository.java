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
	public static Response search(String query)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/search/" + encode(query));
	}

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

	public static Response info(String owner, String repositoryName)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(owner) + "/"
						+ encode(repositoryName));
	}
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

	public static Response list(String target)
	{
		return HTTPGet("http://github.com/api/v2/json/repos/show/"
						+ encode(target));
	}
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
}