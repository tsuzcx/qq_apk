package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import org.json.JSONObject;

public class ProtoUploadRealNameFile
  extends d
{
  public static String d = "";
  public static String e = "";
  public static long f;
  public static long g;
  public static int h;
  private static int i;
  
  protected String a()
  {
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_check";
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        g.c("parseJSON  decodeData=" + paramJSONObject.toString());
        if (i == 1) {
          if (paramJSONObject.getInt("live_result") == 0) {
            a(j, paramJSONObject.getString("info"));
          }
        }
      }
      for (;;)
      {
        g.a("ProtoUploadRealNameFile upload success");
        return;
        this.a.c();
        continue;
        if (i == 2)
        {
          d = paramJSONObject.getString("ocr_name");
          e = paramJSONObject.getString("ocr_card");
          this.a.c();
        }
        else if (i == 5)
        {
          f = paramJSONObject.getLong("submit_time");
          g = paramJSONObject.getLong("complete_time");
          h = paramJSONObject.getInt("time_left");
          this.a.c();
        }
        else
        {
          this.a.c();
          continue;
          g.c("parseJSON error decodeData=" + paramJSONObject);
          a(10022, RqdApplication.l().getString(2131230925));
        }
      }
    }
    a(j, paramJSONObject.getString("info"));
    g.a("ProtoUploadRealNameFile upload fail errCode=" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoUploadRealNameFile
 * JD-Core Version:    0.7.0.1
 */