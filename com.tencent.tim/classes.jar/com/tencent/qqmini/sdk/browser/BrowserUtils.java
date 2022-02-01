package com.tencent.qqmini.sdk.browser;

import android.text.TextUtils;

public class BrowserUtils
{
  public static String getSchemeFromUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserUtils
 * JD-Core Version:    0.7.0.1
 */