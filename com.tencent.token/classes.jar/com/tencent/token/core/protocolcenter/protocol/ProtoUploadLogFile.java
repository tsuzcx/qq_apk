package com.tencent.token.core.protocolcenter.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;
import com.tencent.token.utils.t;
import java.io.File;
import org.json.JSONObject;

public class ProtoUploadLogFile
  extends e
{
  private static String d;
  
  public static void a(ev paramev, String paramString)
  {
    d = paramString;
  }
  
  protected String a()
  {
    return c.e() + "/cn/mbtoken3/mbtoken3_log_upload";
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(d);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        i.a(paramJSONObject);
      }
      t.a("debug.file.uploadfiledate").commit();
      h.a("log upload success");
      return;
    }
    h.a("log upload fail errCode=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile
 * JD-Core Version:    0.7.0.1
 */