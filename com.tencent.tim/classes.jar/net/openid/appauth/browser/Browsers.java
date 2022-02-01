package net.openid.appauth.browser;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.Set;

public final class Browsers
{
  public static final class Chrome
  {
    public static final DelimitedVersion MINIMUM_VERSION_FOR_CUSTOM_TAB = DelimitedVersion.parse("45");
    public static final String PACKAGE_NAME = "com.android.chrome";
    public static final String SIGNATURE = "7fmduHKTdHHrlMvldlEqAIlSfii1tl35bxj1OXN5Ve8c4lU6URVu4xtSHc3BVZxS6WWJnxMDhIfQN0N0K2NDJg==";
    public static final Set<String> SIGNATURE_SET = Collections.singleton("7fmduHKTdHHrlMvldlEqAIlSfii1tl35bxj1OXN5Ve8c4lU6URVu4xtSHc3BVZxS6WWJnxMDhIfQN0N0K2NDJg==");
    
    public static BrowserDescriptor customTab(@NonNull String paramString)
    {
      return new BrowserDescriptor("com.android.chrome", SIGNATURE_SET, paramString, true);
    }
    
    public static BrowserDescriptor standaloneBrowser(@NonNull String paramString)
    {
      return new BrowserDescriptor("com.android.chrome", SIGNATURE_SET, paramString, false);
    }
  }
  
  public static final class Firefox
  {
    public static final String PACKAGE_NAME = "org.mozilla.firefox";
    public static final String SIGNATURE_HASH = "2gCe6pR_AO_Q2Vu8Iep-4AsiKNnUHQxu0FaDHO_qa178GByKybdT_BuE8_dYk99G5Uvx_gdONXAOO2EaXidpVQ==";
    public static final Set<String> SIGNATURE_SET = Collections.singleton("2gCe6pR_AO_Q2Vu8Iep-4AsiKNnUHQxu0FaDHO_qa178GByKybdT_BuE8_dYk99G5Uvx_gdONXAOO2EaXidpVQ==");
    
    public static BrowserDescriptor standaloneBrowser(@NonNull String paramString)
    {
      return new BrowserDescriptor("org.mozilla.firefox", SIGNATURE_SET, paramString, false);
    }
  }
  
  public static final class SBrowser
  {
    public static final String PACKAGE_NAME = "com.sec.android.app.sbrowser";
    public static final String SIGNATURE_HASH = "ABi2fbt8vkzj7SJ8aD5jc4xJFTDFntdkMrYXL3itsvqY1QIw-dZozdop5rgKNxjbrQAd5nntAGpgh9w84O1Xgg==";
    public static final Set<String> SIGNATURE_SET = Collections.singleton("ABi2fbt8vkzj7SJ8aD5jc4xJFTDFntdkMrYXL3itsvqY1QIw-dZozdop5rgKNxjbrQAd5nntAGpgh9w84O1Xgg==");
    
    public static BrowserDescriptor customTab(@NonNull String paramString)
    {
      return new BrowserDescriptor("com.sec.android.app.sbrowser", SIGNATURE_SET, paramString, true);
    }
    
    public static BrowserDescriptor standaloneBrowser(@NonNull String paramString)
    {
      return new BrowserDescriptor("com.sec.android.app.sbrowser", SIGNATURE_SET, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.browser.Browsers
 * JD-Core Version:    0.7.0.1
 */