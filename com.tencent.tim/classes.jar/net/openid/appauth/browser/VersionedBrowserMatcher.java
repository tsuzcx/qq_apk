package net.openid.appauth.browser;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.Set;

public class VersionedBrowserMatcher
  implements BrowserMatcher
{
  public static final VersionedBrowserMatcher CHROME_BROWSER = new VersionedBrowserMatcher("com.android.chrome", Browsers.Chrome.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
  public static final VersionedBrowserMatcher CHROME_CUSTOM_TAB = new VersionedBrowserMatcher("com.android.chrome", Browsers.Chrome.SIGNATURE_SET, true, VersionRange.atLeast(Browsers.Chrome.MINIMUM_VERSION_FOR_CUSTOM_TAB));
  public static final VersionedBrowserMatcher FIREFOX_BROWSER = new VersionedBrowserMatcher("org.mozilla.firefox", Browsers.Firefox.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
  public static final VersionedBrowserMatcher SAMSUNG_BROWSER = new VersionedBrowserMatcher("com.sec.android.app.sbrowser", Browsers.SBrowser.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
  public static final VersionedBrowserMatcher SAMSUNG_CUSTOM_TAB = new VersionedBrowserMatcher("com.sec.android.app.sbrowser", Browsers.SBrowser.SIGNATURE_SET, true, VersionRange.ANY_VERSION);
  private String mPackageName;
  private Set<String> mSignatureHashes;
  private boolean mUsingCustomTab;
  private VersionRange mVersionRange;
  
  public VersionedBrowserMatcher(@NonNull String paramString1, @NonNull String paramString2, boolean paramBoolean, @NonNull VersionRange paramVersionRange)
  {
    this(paramString1, Collections.singleton(paramString2), paramBoolean, paramVersionRange);
  }
  
  public VersionedBrowserMatcher(@NonNull String paramString, @NonNull Set<String> paramSet, boolean paramBoolean, @NonNull VersionRange paramVersionRange)
  {
    this.mPackageName = paramString;
    this.mSignatureHashes = paramSet;
    this.mUsingCustomTab = paramBoolean;
    this.mVersionRange = paramVersionRange;
  }
  
  public boolean matches(@NonNull BrowserDescriptor paramBrowserDescriptor)
  {
    return (this.mPackageName.equals(paramBrowserDescriptor.packageName)) && (this.mUsingCustomTab == paramBrowserDescriptor.useCustomTab.booleanValue()) && (this.mVersionRange.matches(paramBrowserDescriptor.version)) && (this.mSignatureHashes.equals(paramBrowserDescriptor.signatureHashes));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.VersionedBrowserMatcher
 * JD-Core Version:    0.7.0.1
 */