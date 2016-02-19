package com.github.scribejava.apis;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

public class LoveFilmApi extends DefaultApi10a {

    private static final String REQUEST_TOKEN_URL = "http://openapi.lovefilm.com/oauth/request_token";
    private static final String ACCESS_TOKEN_URL = "http://openapi.lovefilm.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://www.lovefilm.com/activate?oauth_token=%s";

    protected LoveFilmApi() {
    }

    private static class InstanceHolder {
        private static final LoveFilmApi INSTANCE = new LoveFilmApi();
    }

    public static LoveFilmApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
