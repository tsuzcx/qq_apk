package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLogin;

public class cj
{
  private static cj c;
  private static boolean j = false;
  GameLogin a;
  Handler b = new ck(this);
  private boolean d = false;
  private boolean e = false;
  private CallbackPushStruct f;
  private int g;
  private Handler h;
  private long i = 0L;
  
  private cj(Context paramContext, String paramString, int paramInt)
  {
    if (this.a == null) {
      this.a = new GameLogin();
    }
    j = this.a.init(paramContext, 34, paramString, paramInt);
    if (!j) {
      return;
    }
    this.a.setRespLimitTime(60000L);
    this.a.setWaitPushTime(180000L);
    this.a.setNetworkCallback(new cl(this));
  }
  
  public static cj a(Context paramContext)
  {
    if ((c == null) || (!j)) {
      c = new cj(paramContext, w.l(), 1);
    }
    return c;
  }
  
  public void a(long paramLong)
  {
    if (!j) {
      return;
    }
    this.d = false;
    this.e = false;
    h.a("game login get flow type appid=" + paramLong);
    this.a.sendGetFlowType(paramLong);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, Handler paramHandler)
  {
    if (!j) {
      return;
    }
    this.g = paramInt;
    this.h = paramHandler;
    h.b("game login confirm send: " + paramString + "|" + paramArrayOfByte + "|" + paramInt);
    this.a.sendGameConfirm(paramString, paramArrayOfByte, paramInt);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!j) {}
    while ((!this.e) || (!this.d)) {
      return;
    }
    h.c("game login info uin=" + paramString1 + ", guid=" + paramArrayOfByte + ", qrcode=" + paramString2);
    this.a.sendGameLoginInfo(paramString1, paramArrayOfByte, paramString2);
  }
  
  public boolean a()
  {
    return (this.e) && (this.d);
  }
  
  public boolean b()
  {
    return (this.f == null) || (this.i <= 0L) || (cx.c().s() - this.i >= this.f.expirtTime * 1000);
  }
  
  public int c()
  {
    if ((this.f != null) && (this.i > 0L)) {
      return (int)((cx.c().s() - this.i) / 1000L);
    }
    return 0;
  }
  
  public CallbackPushStruct d()
  {
    return this.f;
  }
  
  public void e()
  {
    this.f = null;
    this.i = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cj
 * JD-Core Version:    0.7.0.1
 */