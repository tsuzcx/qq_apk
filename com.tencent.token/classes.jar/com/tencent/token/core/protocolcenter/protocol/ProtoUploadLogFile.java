package com.tencent.token.core.protocolcenter.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.c;
import com.tencent.token.global.g;
import com.tencent.token.utils.e;
import com.tencent.token.utils.i;
import java.io.File;
import org.json.JSONObject;

public class ProtoUploadLogFile
  extends d
{
  private static String d;
  
  public static void a(dp paramdp, String paramString)
  {
    d = paramString;
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_log_upload");
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(d);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        e.a(paramJSONObject);
      }
      i.a("debug.file.uploadfiledate").commit();
      g.a("log upload success");
      return;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("log upload fail errCode=");
    paramJSONObject.append(i);
    g.a(paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile
 * JD-Core Version:    0.7.0.1
 */