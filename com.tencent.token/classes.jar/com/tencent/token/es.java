package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import org.json.JSONObject;

public final class es
  extends bm
{
  private String c;
  
  protected final String a()
  {
    int i = 0;
    String str3 = "mp.weixin.qq.com";
    String str1 = str3;
    if (this.c != null)
    {
      str1 = str3;
      if (this.c.length() > 0) {
        str1 = this.c;
      }
    }
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (str3 = ax.c; str3 == null; str3 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    try
    {
      localObject2 = new Process[2];
      localObject1 = new String[2];
      localObject2[0] = Runtime.getRuntime().exec("getprop net.dns1");
      localObject2[1] = Runtime.getRuntime().exec("getprop net.dns2");
      if (i < 2)
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localObject2[i].getInputStream()));
        localObject1[i] = "";
        for (;;)
        {
          String str4 = localBufferedReader.readLine();
          if (str4 == null) {
            break;
          }
          localObject1[i] = (localObject1[i] + str4);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        return null;
        i += 1;
      }
      localObject2[0].destroy();
      localObject2[1].destroy();
      Object localObject2 = InetAddress.getByName(localIOException);
      String str2 = s.a(new Object[] { "dns_ip1", localObject1[0], "dns_ip2", localObject1[1], "domain", localIOException, "ret_ip", ((InetAddress)localObject2).getHostAddress(), "net_type", s.i() });
      if (str2 == null)
      {
        this.a.a(10000, "encrypt imei failed", null);
        return null;
      }
      long l = 0L;
      Object localObject1 = ax.a().e();
      if (localObject1 != null) {
        l = ((QQUser)localObject1).mRealUin;
      }
      str2 = "?aq_base_sid=" + str3 + "&data=" + str2 + "&uin=" + l;
      str2 = b.c() + "/cn/mbtoken3/mbtoken3_report_dns" + str2;
      return str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((String)paramfs.c.get("param.reportdns.domain"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    t.a(System.currentTimeMillis() / 1000L);
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.es
 * JD-Core Version:    0.7.0.1
 */