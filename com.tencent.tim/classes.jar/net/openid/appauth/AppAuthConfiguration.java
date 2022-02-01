package net.openid.appauth;

import android.support.annotation.NonNull;
import net.openid.appauth.browser.AnyBrowserMatcher;
import net.openid.appauth.browser.BrowserMatcher;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;

public class AppAuthConfiguration
{
  public static final AppAuthConfiguration DEFAULT = new Builder().build();
  @NonNull
  private final BrowserMatcher mBrowserMatcher;
  @NonNull
  private final ConnectionBuilder mConnectionBuilder;
  
  private AppAuthConfiguration(@NonNull BrowserMatcher paramBrowserMatcher, @NonNull ConnectionBuilder paramConnectionBuilder)
  {
    this.mBrowserMatcher = paramBrowserMatcher;
    this.mConnectionBuilder = paramConnectionBuilder;
  }
  
  @NonNull
  public BrowserMatcher getBrowserMatcher()
  {
    return this.mBrowserMatcher;
  }
  
  @NonNull
  public ConnectionBuilder getConnectionBuilder()
  {
    return this.mConnectionBuilder;
  }
  
  public static class Builder
  {
    private BrowserMatcher mBrowserMatcher = AnyBrowserMatcher.INSTANCE;
    private ConnectionBuilder mConnectionBuilder = DefaultConnectionBuilder.INSTANCE;
    
    @NonNull
    public AppAuthConfiguration build()
    {
      return new AppAuthConfiguration(this.mBrowserMatcher, this.mConnectionBuilder, null);
    }
    
    @NonNull
    public Builder setBrowserMatcher(@NonNull BrowserMatcher paramBrowserMatcher)
    {
      Preconditions.checkNotNull(paramBrowserMatcher, "browserMatcher cannot be null");
      this.mBrowserMatcher = paramBrowserMatcher;
      return this;
    }
    
    @NonNull
    public Builder setConnectionBuilder(@NonNull ConnectionBuilder paramConnectionBuilder)
    {
      Preconditions.checkNotNull(paramConnectionBuilder, "connectionBuilder cannot be null");
      this.mConnectionBuilder = paramConnectionBuilder;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AppAuthConfiguration
 * JD-Core Version:    0.7.0.1
 */