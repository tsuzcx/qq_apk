package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import com.tencent.token.global.e;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLogin;

public final class r
{
  private static r c;
  private static boolean j = false;
  GameLogin a;
  Handler b = new s(this);
  private boolean d = false;
  private boolean e = false;
  private CallbackPushStruct f;
  private int g;
  private Handler h;
  private long i = 0L;
  
  private r(Context paramContext, String paramString)
  {
    if (this.a == null) {
      this.a = new GameLogin();
    }
    boolean bool = this.a.init(paramContext, 34, paramString, 1);
    j = bool;
    if (!bool) {
      return;
    }
    this.a.setRespLimitTime(60000L);
    this.a.setWaitPushTime(180000L);
    this.a.setNetworkCallback(new t(this));
  }
  
  public static r a(Context paramContext)
  {
    if ((c == null) || (!j)) {
      c = new r(paramContext, com.tencent.token.utils.s.j());
    }
    return c;
  }
  
  public final void a(long paramLong)
  {
    if (!j) {
      return;
    }
    this.d = false;
    this.e = false;
    e.a("game login get flow type appid=" + paramLong);
    this.a.sendGetFlowType(paramLong);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt, Handler paramHandler)
  {
    if (!j) {
      return;
    }
    this.g = paramInt;
    this.h = paramHandler;
    e.b("game login confirm send: " + paramString + "|" + paramArrayOfByte + "|" + paramInt);
    this.a.sendGameConfirm(paramString, paramArrayOfByte, paramInt);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!j) {}
    while ((!this.e) || (!this.d)) {
      return;
    }
    e.c("game login info uin=" + paramString1 + ", guid=" + paramArrayOfByte + ", qrcode=" + paramString2);
    this.a.sendGameLoginInfo(paramString1, paramArrayOfByte, paramString2);
  }
  
  public final boolean a()
  {
    return (this.e) && (this.d);
  }
  
  public final boolean b()
  {
    return (this.f == null) || (this.i <= 0L) || (ag.c().r() - this.i >= this.f.expirtTime * 1000);
  }
  
  public final int c()
  {
    if ((this.f != null) && (this.i > 0L)) {
      return (int)((ag.c().r() - this.i) / 1000L);
    }
    return 0;
  }
  
  public final CallbackPushStruct d()
  {
    return this.f;
  }
  
  public final void e()
  {
    this.f = null;
    this.i = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.r
 * JD-Core Version:    0.7.0.1
 */