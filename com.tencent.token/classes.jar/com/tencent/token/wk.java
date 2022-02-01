package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import org.json.JSONObject;

public final class wk
  extends tk
{
  public static String d = "";
  public static String e = "";
  public static long f;
  public static long g;
  public static int h;
  private static int i;
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(wx.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_realname_check");
    return localStringBuilder.toString();
  }
  
  public final void a(aar paramaar) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = aad.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        StringBuilder localStringBuilder = new StringBuilder("parseJSON  decodeData=");
        localStringBuilder.append(paramJSONObject.toString());
        xb.c(localStringBuilder.toString());
        int k = i;
        if (k == 1)
        {
          if (paramJSONObject.getInt("live_result") == 0) {
            a(j, paramJSONObject.getString("info"));
          } else {
            this.a.a = 0;
          }
        }
        else
        {
          if (k == 2)
          {
            d = paramJSONObject.getString("ocr_name");
            e = paramJSONObject.getString("ocr_card");
          }
          else if (k == 5)
          {
            f = paramJSONObject.getLong("submit_time");
            g = paramJSONObject.getLong("complete_time");
            h = paramJSONObject.getInt("time_left");
          }
          this.a.a = 0;
        }
      }
      else
      {
        xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
        a(10022, RqdApplication.n().getString(2131493068));
      }
      xb.a("ProtoUploadRealNameFile upload success");
      return;
    }
    a(j, paramJSONObject.getString("info"));
    xb.a("ProtoUploadRealNameFile upload fail errCode=".concat(String.valueOf(j)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wk
 * JD-Core Version:    0.7.0.1
 */