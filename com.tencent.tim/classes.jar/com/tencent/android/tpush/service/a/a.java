package com.tencent.android.tpush.service.a;

import android.content.Context;
import java.util.Map;
import org.json.JSONArray;

public class a
{
  private static volatile a L = null;
  public int A = 60000;
  public int B = 1;
  public int C = 1;
  public int D = 1;
  public int E = -1;
  public int F = -1;
  public int G = -1;
  public int H = -1;
  public String I = "xiaomi";
  public JSONArray J = null;
  public Map<String, String> K;
  private Context M = null;
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public String u;
  public int v;
  public int w;
  public String x = null;
  public int y = 1;
  public int z = 1;
  
  private a() {}
  
  private a(Context paramContext)
  {
    this.M = paramContext.getApplicationContext();
  }
  
  public static a a(Context paramContext)
  {
    if (L == null) {}
    try
    {
      if (L == null) {
        L = new a(paramContext);
      }
      return L;
    }
    finally {}
  }
  
  public String toString()
  {
    return "ConfigurationManager [context=" + this.M + ", configurationVersion=" + this.a + ", receiveTimeout=" + this.b + ", heartbeatInterval=" + this.c + ", httpHeartbeatInterval=" + this.d + ", speedTestInterval=" + this.e + ", channelMessageExpires=" + this.f + ", freqencySuccess=" + this.g + ", freqencyFailed=" + this.h + ", reportInterval=" + this.i + ", reportMaxCount=" + this.j + ", httpRetryCount=" + this.k + ", ackMaxCount=" + this.l + ", ackDuration=" + this.m + ", loadIpInerval=" + this.n + ", redirectConnectTimeOut=" + this.o + ", redirectSoTimeOut=" + this.p + ", strategyExpiredTime=" + this.q + ", logLevel=" + this.r + ", logFileSizeLimit=" + this.s + ", errCount=" + this.t + ", logUploadDomain=" + this.u + ", rptLive=" + this.v + ", rptLiveIntvl=" + this.w + ", disableXG=" + this.x + ", enableNewWd=" + this.y + ", enableMonitor=" + this.z + ", monitorFreg=" + this.A + ", enableReport=" + this.B + ", abTestVersion=" + this.C + ", isHttpDNSEnable=" + this.D + ", isLBSEnable=" + this.E + ", isAPPListEnable=" + this.F + ", isNotificatiobStatusEnable=" + this.G + ", isQgameEnable=" + this.H + ", pullup_Arr_ProviderAndActivty=" + this.J + ", pullup_packges_map=" + this.K + ", wakeupCtrl=" + this.I + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.a
 * JD-Core Version:    0.7.0.1
 */