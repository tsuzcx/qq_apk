package net.openid.appauth.browser;

import android.support.annotation.NonNull;

public final class AnyBrowserMatcher
  implements BrowserMatcher
{
  public static final AnyBrowserMatcher INSTANCE = new AnyBrowserMatcher();
  
  public boolean matches(@NonNull BrowserDescriptor paramBrowserDescriptor)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.AnyBrowserMatcher
 * JD-Core Version:    0.7.0.1
 */