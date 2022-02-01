package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class CloudManager
{
  public static final String KEY_CONFIG = "cloud";
  private static Context a;
  private String A = null;
  private String b = null;
  private long c = -1L;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private long i = 0L;
  private long j = 0L;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private String q = null;
  private String r = null;
  private String s = null;
  private String t = null;
  private String u = null;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private String y = null;
  private JSONArray z = null;
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      PushPreferences.putInt(paramContext, paramString, paramInt);
      return;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.d("CloudManager", "unexpected for putCloudConfig:" + paramString);
    }
  }
  
  private int b(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return paramInt;
    }
    try
    {
      int i1 = PushPreferences.getInt(paramContext, paramString, paramInt);
      return i1;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.d("CloudManager", "unexpected for getCloudConfig:" + paramString);
    }
    return paramInt;
  }
  
  private boolean b()
  {
    if ((d() == 20) || (e() == 1)) {}
    int i1;
    do
    {
      return true;
      i1 = Math.max(d(), e());
    } while ((i1 > 0) && (new Random().nextInt(100) < i1));
    return false;
  }
  
  private int c()
  {
    if (this.d == -1) {
      this.d = b(a, "cloud_control_keepAlive", 0);
    }
    return this.d;
  }
  
  private int d()
  {
    if (this.e == -1) {
      this.e = b(a, "cloud_control_packetLoss", 0);
    }
    return this.e;
  }
  
  private int e()
  {
    if (this.h == -1) {
      this.h = b(a, "cloud_control_losePkt", 0);
    }
    return this.h;
  }
  
  private long f()
  {
    if (this.i == 0L) {
      this.i = b(a, "cloud_control_loseStart", 0);
    }
    return this.i;
  }
  
  private long g()
  {
    if (this.j == 0L) {
      this.j = b(a, "cloud_control_loseStart", 0);
    }
    return this.j;
  }
  
  public static CloudManager getInstance(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getApplicationContext();
    }
    return CloudManagerHolder.instance;
  }
  
  private int h()
  {
    if (this.g == -1) {
      this.g = b(a, "cloud_control_appAlive", 0);
    }
    return this.g;
  }
  
  private int i()
  {
    if (this.m == -1) {
      this.m = b(a, "cloud_control_collData", 0);
    }
    return this.m;
  }
  
  private int j()
  {
    if (this.n == -1) {
      this.n = b(a, "cloud_control_shrBugly", 0);
    }
    return this.n;
  }
  
  private String k()
  {
    if (this.y == null) {
      this.y = PushPreferences.getString(a, "cloud_control_conf_pull_arr", "");
    }
    return this.y;
  }
  
  private String l()
  {
    if (this.q == null) {
      this.q = PushPreferences.getString(a, "cloud_control_addrCfg", "");
    }
    return this.q;
  }
  
  public void clearGuid()
  {
    this.u = null;
    this.q = null;
    try
    {
      PushPreferences.remove(a, "cloud_control_addrCfg");
      return;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.w("CloudManager", "unexpected for clearGuid");
    }
  }
  
  public boolean disableCollData()
  {
    return i() == 1;
  }
  
  public boolean disablePullMsg()
  {
    if (this.v == -1) {
      this.v = b(a, "cloud_control_pullMsg", 0);
    }
    return this.v == 1;
  }
  
  public boolean disablePullUp()
  {
    return (c() == 10) || (h() == 1);
  }
  
  public boolean disableRepLanuEv()
  {
    if (this.p == -1) {
      this.p = b(a, "cloud_control_repoLanuEv", 0);
    }
    return this.p == 1;
  }
  
  public boolean disableReptErrCode()
  {
    int i1 = getReptErrCode();
    if (i1 == 1) {}
    while ((i1 > 0) && (new Random().nextInt(100) < i1)) {
      return true;
    }
    return false;
  }
  
  public boolean disableReptLog()
  {
    if (this.w == -1) {
      this.w = b(a, "cloud_control_reptLog", 0);
    }
    return this.w == 1;
  }
  
  public boolean disableShareBugly()
  {
    return j() == 1;
  }
  
  public int getAppClsAlive()
  {
    if (this.o == -1) {
      this.o = b(a, "cloud_control_appClsAlive", 0);
    }
    return this.o;
  }
  
  public String getCloud()
  {
    return this.b;
  }
  
  public long getCloudVersion()
  {
    if (this.c == -1L) {
      this.c = PushPreferences.getLong(a, "cloud_control_version", 0L);
    }
    return this.c;
  }
  
  public int getCompressLevel()
  {
    if (this.x == -1) {
      this.x = b(a, "cloud_control_compress", 0);
    }
    return this.x;
  }
  
  public String getCustom()
  {
    if (!Util.isNullOrEmptyString(this.s)) {
      return this.s;
    }
    try
    {
      if (Util.isNullOrEmptyString(l())) {
        return this.s;
      }
      this.s = new JSONObject(l()).getString("custom");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getCustom");
      }
    }
    return this.s;
  }
  
  public String getGuid()
  {
    if (!Util.isNullOrEmptyString(this.u)) {
      return this.u;
    }
    try
    {
      if (Util.isNullOrEmptyString(l())) {
        return this.u;
      }
      this.u = new JSONObject(l()).getString("guid");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getGuid");
      }
    }
    return this.u;
  }
  
  public int getInterval()
  {
    if (this.f == -1) {
      this.f = PushPreferences.getInt(a, "cloud_control_interval", 0);
    }
    return this.f;
  }
  
  public String getLog()
  {
    if (!Util.isNullOrEmptyString(this.t)) {
      return this.t;
    }
    try
    {
      if (Util.isNullOrEmptyString(l())) {
        return this.t;
      }
      this.t = new JSONObject(l()).getString("log");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getLog");
      }
    }
    return this.t;
  }
  
  public JSONArray getPullupArrProviderAndActivity()
  {
    if (this.z != null) {
      return this.z;
    }
    try
    {
      if (Util.isNullOrEmptyString(k())) {
        return null;
      }
      this.z = new JSONArray(this.y);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getPullupJSONArr");
      }
    }
    return this.z;
  }
  
  public String getPullupBlackList()
  {
    try
    {
      if (this.A == null) {
        this.A = PushPreferences.getString(a, "cloud_control_conf_pull_black_list", "");
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getPullupBlackList");
      }
    }
  }
  
  public int getRecons()
  {
    if (this.k == -1) {
      this.k = b(a, "cloud_control_recons", 0);
    }
    return this.k;
  }
  
  public int getReptErrCode()
  {
    if (this.l == -1) {
      this.l = b(a, "cloud_control_reptErrCode", 0);
    }
    return this.l;
  }
  
  public String getStat()
  {
    if (!Util.isNullOrEmptyString(this.r)) {
      return this.r;
    }
    try
    {
      if (Util.isNullOrEmptyString(l())) {
        return this.r;
      }
      this.r = new JSONObject(l()).getString("stat");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TBaseLogger.d("CloudManager", "unexpected for getStat");
      }
    }
    return this.r;
  }
  
  public void parseCloudConfig(String paramString, long paramLong)
  {
    if ((Util.isNullOrEmptyString(paramString)) || (a == null)) {
      return;
    }
    CommonWorkingThread.getInstance().execute(new CloudManager.1(this, paramString, paramLong));
  }
  
  public void reset()
  {
    this.b = null;
    this.c = -1L;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    this.g = -1;
    this.h = -1;
    this.k = -1;
    this.l = -1;
    this.m = -1;
    this.n = -1;
    this.o = -1;
    this.x = -1;
    this.v = -1;
    this.w = -1;
    this.q = null;
    this.y = null;
    try
    {
      PushPreferences.remove(a, "cloud_control_keepAlive");
      PushPreferences.remove(a, "cloud_control_packetLoss");
      PushPreferences.remove(a, "cloud_control_version");
      PushPreferences.remove(a, "cloud_control_interval");
      PushPreferences.remove(a, "cloud_control_appAlive");
      PushPreferences.remove(a, "cloud_control_losePkt");
      PushPreferences.remove(a, "cloud_control_recons");
      PushPreferences.remove(a, "cloud_control_reptErrCode");
      PushPreferences.remove(a, "cloud_control_collData");
      PushPreferences.remove(a, "cloud_control_shrBugly");
      PushPreferences.remove(a, "cloud_control_appClsAlive");
      PushPreferences.remove(a, "cloud_control_repoLanuEv");
      PushPreferences.remove(a, "cloud_control_compress");
      PushPreferences.remove(a, "cloud_control_pullMsg");
      PushPreferences.remove(a, "cloud_control_reptLog");
      PushPreferences.remove(a, "cloud_control_addrCfg");
      PushPreferences.remove(a, "cloud_control_conf_pull_arr");
      PushPreferences.remove(a, "cloud_control_conf_pull_black_list");
      return;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.w("CloudManager", "unexpected for reset", localThrowable);
    }
  }
  
  public boolean shouldRefuse()
  {
    if (!b()) {
      TBaseLogger.d("CloudManager", "shouldRefuse | isCloudRefuse : false");
    }
    long l1;
    do
    {
      return false;
      f();
      g();
      l1 = System.currentTimeMillis();
    } while (((l1 > this.j) || (l1 < this.i)) && ((this.i != 0L) || (this.j != 0L)) && ((l1 > this.j) || (this.i != 0L)) && ((l1 < this.i) || (this.j != 0L)));
    TBaseLogger.d("CloudManager", "shouldRefuse | refuse ");
    return true;
  }
  
  public static class CloudManagerHolder
  {
    public static CloudManager instance = new CloudManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.CloudManager
 * JD-Core Version:    0.7.0.1
 */