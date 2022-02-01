package net.openid.appauth.browser;

import android.support.annotation.NonNull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BrowserBlacklist
  implements BrowserMatcher
{
  private List<BrowserMatcher> mBrowserMatchers;
  
  public BrowserBlacklist(BrowserMatcher... paramVarArgs)
  {
    this.mBrowserMatchers = Arrays.asList(paramVarArgs);
  }
  
  public boolean matches(@NonNull BrowserDescriptor paramBrowserDescriptor)
  {
    Iterator localIterator = this.mBrowserMatchers.iterator();
    while (localIterator.hasNext()) {
      if (((BrowserMatcher)localIterator.next()).matches(paramBrowserDescriptor)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.BrowserBlacklist
 * JD-Core Version:    0.7.0.1
 */