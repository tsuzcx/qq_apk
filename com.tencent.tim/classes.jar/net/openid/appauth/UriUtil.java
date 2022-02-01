package net.openid.appauth;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class UriUtil
{
  public static void appendQueryParameterIfNotNull(@NonNull Uri.Builder paramBuilder, @NonNull String paramString, @Nullable Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.toString() == null) {
      return;
    }
    paramBuilder.appendQueryParameter(paramString, paramObject.toString());
  }
  
  public static String formUrlEncode(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localArrayList.add((String)localEntry.getKey() + "=" + URLEncoder.encode((String)localEntry.getValue(), "utf-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Logger.error("Could not utf-8 encode.", new Object[0]);
      }
    }
    return TextUtils.join("&", localArrayList);
  }
  
  public static Long getLongQueryParameter(@NonNull Uri paramUri, @NonNull String paramString)
  {
    paramUri = paramUri.getQueryParameter(paramString);
    if (paramUri != null) {
      return Long.valueOf(Long.parseLong(paramUri));
    }
    return null;
  }
  
  public static Uri parseUriIfAvailable(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.UriUtil
 * JD-Core Version:    0.7.0.1
 */