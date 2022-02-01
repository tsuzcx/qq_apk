package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_realname_check");
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      StringBuilder localStringBuilder;
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseJSON  decodeData=");
        localStringBuilder.append(paramJSONObject.toString());
        g.c(localStringBuilder.toString());
        int k = i;
        if (k == 1)
        {
          if (paramJSONObject.getInt("live_result") == 0) {
            a(j, paramJSONObject.getString("info"));
          } else {
            this.a.c();
          }
        }
        else if (k == 2)
        {
          d = paramJSONObject.getString("ocr_name");
          e = paramJSONObject.getString("ocr_card");
          this.a.c();
        }
        else if (k == 5)
        {
          f = paramJSONObject.getLong("submit_time");
          g = paramJSONObject.getLong("complete_time");
          h = paramJSONObject.getInt("time_left");
          this.a.c();
        }
        else
        {
          this.a.c();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseJSON error decodeData=");
        localStringBuilder.append(paramJSONObject);
        g.c(localStringBuilder.toString());
        a(10022, RqdApplication.n().getString(2131493068));
      }
      g.a("ProtoUploadRealNameFile upload success");
      return;
    }
    a(j, paramJSONObject.getString("info"));
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("ProtoUploadRealNameFile upload fail errCode=");
    paramJSONObject.append(j);
    g.a(paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoUploadRealNameFile
 * JD-Core Version:    0.7.0.1
 */