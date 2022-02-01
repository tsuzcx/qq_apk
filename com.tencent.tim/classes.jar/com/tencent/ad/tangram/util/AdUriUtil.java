package com.tencent.ad.tangram.util;

import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdUriUtil
{
  private static final String TAG = "AdUriUtil";
  
  public static String getQueryParameter(Uri paramUri, String paramString)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramUri = paramUri.getQueryParameter(paramString);
      return paramUri;
    }
    catch (Throwable paramUri)
    {
      AdLog.e("AdUriUtil", "getQueryParameter", paramUri);
    }
    return null;
  }
  
  public static Uri parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdUriUtil", "parse", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdUriUtil
 * JD-Core Version:    0.7.0.1
 */