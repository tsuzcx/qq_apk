package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, JSONArray paramJSONArray)
  {
    paramdp.c.put("param.reportdns.domain", paramJSONArray);
  }
  
  protected String a()
  {
    String str1 = cb.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new Process[2];
        Object localObject1 = new String[2];
        localObject2[0] = Runtime.getRuntime().exec("getprop net.dns1");
        localObject2[1] = Runtime.getRuntime().exec("getprop net.dns2");
        i = 0;
        Object localObject3;
        if (i < 2)
        {
          localObject3 = new BufferedReader(new InputStreamReader(localObject2[i].getInputStream()));
          localObject1[i] = "";
          String str2 = ((BufferedReader)localObject3).readLine();
          if (str2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject1[i]);
            localStringBuilder.append(str2);
            localObject1[i] = localStringBuilder.toString();
            continue;
          }
        }
        else
        {
          localObject2[0].destroy();
          localObject2[1].destroy();
          localObject2 = new JSONArray();
          i = 0;
          if (i < this.d.length())
          {
            ((JSONArray)localObject2).put(InetAddress.getByName(this.d.getString(i)).getHostAddress());
            i += 1;
            continue;
          }
          long l = 0L;
          localObject3 = cs.a().e();
          if (localObject3 != null) {
            l = ((QQUser)localObject3).mRealUin;
          }
          i = cc.a + 1;
          cc.a = i;
          this.e = i;
          localObject1 = l.a(new Object[] { "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cd.c().s() / 1000L), "uin", Long.valueOf(l), "dns_ip1", localObject1[0], "dns_ip2", localObject1[1], "domain_list", this.d, "ret_ip_list", localObject2, "MNC", i.l(RqdApplication.n()), "MCC", i.k(RqdApplication.n()), "net_type", l.k() });
          if (localObject1 == null)
          {
            this.a.a(10000, "encrypt imei failed");
            return null;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("?aq_base_sid=");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append("&data=");
          ((StringBuilder)localObject2).append((String)localObject1);
          str1 = ((StringBuilder)localObject2).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(c.e());
          ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_report_dns_v2");
          ((StringBuilder)localObject1).append(str1);
          str1 = ((StringBuilder)localObject1).toString();
          return str1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((JSONArray)paramdp.c.get("param.reportdns.domain"));
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