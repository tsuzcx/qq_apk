package com.tencent.token.core.protocolcenter.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
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
  
  public static void a(dn paramdn, String paramString)
  {
    d = paramString;
  }
  
  protected String a()
  {
    return c.e() + "/cn/mbtoken3/mbtoken3_log_upload";
  }
  
  protected void a(dn paramdn) {}
  
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
    g.a("log upload fail errCode=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile
 * JD-Core Version:    0.7.0.1
 */