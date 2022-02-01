package com.tencent.token;

import android.content.SharedPreferences.Editor;
import java.io.File;
import org.json.JSONObject;

public final class xc
  extends ud
{
  private static String d;
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(xr.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_log_upload");
    return localStringBuilder.toString();
  }
  
  public final void a(abm paramabm) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(d);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        aas.a(paramJSONObject);
      }
      aav.b("debug.file.uploadfiledate").commit();
      xv.a("log upload success");
      return;
    }
    xv.a("log upload fail errCode=".concat(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xc
 * JD-Core Version:    0.7.0.1
 */