package net.openid.appauth.browser;

import android.support.annotation.NonNull;

public class ExactBrowserMatcher
  implements BrowserMatcher
{
  private BrowserDescriptor mBrowser;
  
  public ExactBrowserMatcher(BrowserDescriptor paramBrowserDescriptor)
  {
    this.mBrowser = paramBrowserDescriptor;
  }
  
  public boolean matches(@NonNull BrowserDescriptor paramBrowserDescriptor)
  {
    return this.mBrowser.equals(paramBrowserDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.ExactBrowserMatcher
 * JD-Core Version:    0.7.0.1
 */