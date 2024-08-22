package com.example.domainlogicandroidtest.data.api.model;

public class User {

    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private double score;

    // Getters y setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNodeId() { return node_id; }
    public void setNodeId(String node_id) { this.node_id = node_id; }

    public String getAvatarUrl() { return avatar_url; }
    public void setAvatarUrl(String avatar_url) { this.avatar_url = avatar_url; }

    public String getGravatarId() { return gravatar_id; }
    public void setGravatarId(String gravatar_id) { this.gravatar_id = gravatar_id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getHtmlUrl() { return html_url; }
    public void setHtmlUrl(String html_url) { this.html_url = html_url; }

    public String getFollowersUrl() { return followers_url; }
    public void setFollowersUrl(String followers_url) { this.followers_url = followers_url; }

    public String getFollowingUrl() { return following_url; }
    public void setFollowingUrl(String following_url) { this.following_url = following_url; }

    public String getGistsUrl() { return gists_url; }
    public void setGistsUrl(String gists_url) { this.gists_url = gists_url; }

    public String getStarredUrl() { return starred_url; }
    public void setStarredUrl(String starred_url) { this.starred_url = starred_url; }

    public String getSubscriptionsUrl() { return subscriptions_url; }
    public void setSubscriptionsUrl(String subscriptions_url) { this.subscriptions_url = subscriptions_url; }

    public String getOrganizationsUrl() { return organizations_url; }
    public void setOrganizationsUrl(String organizations_url) { this.organizations_url = organizations_url; }

    public String getReposUrl() { return repos_url; }
    public void setReposUrl(String repos_url) { this.repos_url = repos_url; }

    public String getEventsUrl() { return events_url; }
    public void setEventsUrl(String events_url) { this.events_url = events_url; }

    public String getReceivedEventsUrl() { return received_events_url; }
    public void setReceivedEventsUrl(String received_events_url) { this.received_events_url = received_events_url; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isSiteAdmin() { return site_admin; }
    public void setSiteAdmin(boolean site_admin) { this.site_admin = site_admin; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

}
