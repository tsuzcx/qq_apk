package com.tencent.token;

import android.content.SharedPreferences.Editor;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.i;
import com.tencent.token.utils.p;
import java.io.File;
import org.json.JSONObject;

public final class ey
  extends bm
{
  private static String c;
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  protected final String a()
  {
    return b.c() + "/cn/mbtoken3/mbtoken3_log_upload";
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = new File(c);
      if ((paramJSONObject.exists()) && (paramJSONObject.isFile())) {
        i.a(paramJSONObject);
      }
      p.b("debug.file.uploadfiledate").commit();
      e.a("log upload success");
      return;
    }
    e.a("log upload fail errCode=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ey
 * JD-Core Version:    0.7.0.1
 */