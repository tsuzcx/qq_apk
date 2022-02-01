package com.tencent.token;

import android.content.SharedPreferences.Editor;
import java.io.File;
import org.json.JSONObject;

public final class wj
  extends tk
{
  private static String d;
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(wx.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_log_upload");
    return localStringBuilder.toString();
  }
  
  public final void a(aar paramaar) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(d);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        zx.a(paramJSONObject);
      }
      aaa.b("debug.file.uploadfiledate").commit();
      xb.a("log upload success");
      return;
    }
    xb.a("log upload fail errCode=".concat(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wj
 * JD-Core Version:    0.7.0.1
 */