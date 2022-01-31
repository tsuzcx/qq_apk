package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import org.json.JSONObject;

public final class ez
  extends bm
{
  public static String c = "";
  public static String d = "";
  public static long e;
  public static long f;
  public static int g;
  private static int h;
  
  protected final String a()
  {
    return b.c() + "/cn/mbtoken3/mbtoken3_realname_check";
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = s.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        e.c("parseJSON  decodeData=" + paramJSONObject.toString());
        if (h == 1) {
          if (paramJSONObject.getInt("live_result") == 0) {
            a(i, paramJSONObject.getString("info"));
          }
        }
      }
      for (;;)
      {
        e.a("ProtoUploadRealNameFile upload success");
        return;
        this.a.a = 0;
        continue;
        if (h == 2)
        {
          c = paramJSONObject.getString("ocr_name");
          d = paramJSONObject.getString("ocr_card");
        }
        for (;;)
        {
          this.a.a = 0;
          break;
          if (h == 5)
          {
            e = paramJSONObject.getLong("submit_time");
            f = paramJSONObject.getLong("complete_time");
            g = paramJSONObject.getInt("time_left");
          }
        }
        e.c("parseJSON error decodeData=" + paramJSONObject);
        a(10022, RqdApplication.i().getString(2131361799));
      }
    }
    a(i, paramJSONObject.getString("info"));
    e.a("ProtoUploadRealNameFile upload fail errCode=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */