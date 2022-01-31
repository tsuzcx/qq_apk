package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.upload.o;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProtoReportDnsInfo
  extends e
{
  private JSONArray d;
  private int e;
  
  public static void a(ev paramev, JSONArray paramJSONArray)
  {
    paramev.c.put("param.reportdns.domain", paramJSONArray);
  }
  
  protected String a()
  {
    int j = 0;
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1;
    try
    {
      localObject2 = new Process[2];
      localObject1 = new String[2];
      localObject2[0] = Runtime.getRuntime().exec("getprop net.dns1");
      localObject2[1] = Runtime.getRuntime().exec("getprop net.dns2");
      i = 0;
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
      Object localObject2 = new JSONArray();
      int i = j;
      while (i < this.d.length())
      {
        ((JSONArray)localObject2).put(InetAddress.getByName(this.d.getString(i)).getHostAddress());
        i += 1;
      }
      long l = 0L;
      Object localObject3 = do.a().e();
      if (localObject3 == null) {
        break label239;
      }
      l = ((QQUser)localObject3).mRealUin;
      i = cw.a + 1;
      cw.a = i;
      this.e = i;
      localObject1 = w.a(new Object[] { "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cx.c().s() / 1000L), "uin", Long.valueOf(l), "dns_ip1", localObject1[0], "dns_ip2", localObject1[1], "domain_list", this.d, "ret_ip_list", localObject2, "MNC", o.l(RqdApplication.l()), "MCC", o.k(RqdApplication.l()), "net_type", w.k() });
      if (localObject1 != null) {
        break label439;
      }
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    catch (Exception localException)
    {
      label239:
      localException.printStackTrace();
      return null;
    }
    if (i < 2)
    {
      localObject3 = new BufferedReader(new InputStreamReader(localObject2[i].getInputStream()));
      localObject1[i] = "";
      for (;;)
      {
        String str3 = ((BufferedReader)localObject3).readLine();
        if (str3 == null) {
          break;
        }
        localObject1[i] = (localObject1[i] + str3);
      }
    }
    label439:
    String str2 = "?aq_base_sid=" + localException + "&data=" + (String)localObject1;
    str2 = c.e() + "/cn/mbtoken3/mbtoken3_report_dns_v2" + str2;
    return str2;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((JSONArray)paramev.c.get("param.reportdns.domain"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    x.a(System.currentTimeMillis() / 1000L);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoReportDnsInfo
 * JD-Core Version:    0.7.0.1
 */