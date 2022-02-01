package com.tencent.token;

import android.content.SharedPreferences.Editor;
import java.io.File;
import org.json.JSONObject;

public final class wi
  extends tj
{
  private static String d;
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ww.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_log_upload");
    return localStringBuilder.toString();
  }
  
  public final void a(aaq paramaaq) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(d);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        zw.a(paramJSONObject);
      }
      zz.b("debug.file.uploadfiledate").commit();
      xa.a("log upload success");
      return;
    }
    xa.a("log upload fail errCode=".concat(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wi
 * JD-Core Version:    0.7.0.1
 */