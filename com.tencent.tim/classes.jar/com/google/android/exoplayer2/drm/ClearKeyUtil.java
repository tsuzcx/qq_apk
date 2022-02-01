package com.google.android.exoplayer2.drm;

import android.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil
{
  private static final Pattern REQUEST_KIDS_PATTERN = Pattern.compile("\"kids\":\\[\"(.*?)\"]");
  private static final String TAG = "ClearKeyUtil";
  
  public static byte[] adjustRequestData(byte[] paramArrayOfByte)
  {
    if (Util.SDK_INT >= 27) {
      return paramArrayOfByte;
    }
    String str = Util.fromUtf8Bytes(paramArrayOfByte);
    Matcher localMatcher = REQUEST_KIDS_PATTERN.matcher(str);
    if (!localMatcher.find())
    {
      Log.e("ClearKeyUtil", "Failed to adjust request data: " + str);
      return paramArrayOfByte;
    }
    int i = localMatcher.start(1);
    int j = localMatcher.end(1);
    paramArrayOfByte = new StringBuilder(str);
    base64ToBase64Url(paramArrayOfByte, i, j);
    return Util.getUtf8Bytes(paramArrayOfByte.toString());
  }
  
  public static byte[] adjustResponseData(byte[] paramArrayOfByte)
  {
    if (Util.SDK_INT >= 27) {
      return paramArrayOfByte;
    }
    try
    {
      Object localObject = new JSONObject(Util.fromUtf8Bytes(paramArrayOfByte));
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("keys");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        localJSONObject.put("k", base64UrlToBase64(localJSONObject.getString("k")));
        localJSONObject.put("kid", base64UrlToBase64(localJSONObject.getString("kid")));
        i += 1;
      }
      localObject = Util.getUtf8Bytes(((JSONObject)localObject).toString());
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e("ClearKeyUtil", "Failed to adjust response data: " + Util.fromUtf8Bytes(paramArrayOfByte), localJSONException);
    }
    return paramArrayOfByte;
  }
  
  private static void base64ToBase64Url(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      switch (paramStringBuilder.charAt(paramInt1))
      {
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramStringBuilder.setCharAt(paramInt1, '-');
        continue;
        paramStringBuilder.setCharAt(paramInt1, '_');
      }
    }
  }
  
  private static String base64UrlToBase64(String paramString)
  {
    return paramString.replace('-', '+').replace('_', '/');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ClearKeyUtil
 * JD-Core Version:    0.7.0.1
 */