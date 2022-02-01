package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.upload.i;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProtoReportDnsInfo
  extends d
{
  private JSONArray d;
  private int e;
  
  public static void a(do paramdo, JSONArray paramJSONArray)
  {
    paramdo.c.put("param.reportdns.domain", paramJSONArray);
  }
  
  protected String a()
  {
    int j = 0;
    String str1 = ca.a().b();
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
      Object localObject3 = cr.a().e();
      if (localObject3 == null) {
        break label239;
      }
      l = ((QQUser)localObject3).mRealUin;
      i = cb.a + 1;
      cb.a = i;
      this.e = i;
      localObject1 = l.a(new Object[] { "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cc.c().s() / 1000L), "uin", Long.valueOf(l), "dns_ip1", localObject1[0], "dns_ip2", localObject1[1], "domain_list", this.d, "ret_ip_list", localObject2, "MNC", i.l(RqdApplication.l()), "MCC", i.k(RqdApplication.l()), "net_type", l.k() });
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
  
  protected void a(do paramdo)
  {
    this.d = ((JSONArray)paramdo.c.get("param.reportdns.domain"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    m.a(System.currentTimeMillis() / 1000L);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoReportDnsInfo
 * JD-Core Version:    0.7.0.1
 */