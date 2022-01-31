package wf7;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;

public class bz
{
  private static ap gK;
  Handler gL;
  
  public static final bz av()
  {
    return bz.a.gN;
  }
  
  private void aw() {}
  
  public bz.b A()
  {
    return gK.u().A();
  }
  
  public void a(Context paramContext, bz.b paramb)
  {
    gK = new ap(paramContext, paramb);
    ca.a((WifiManager)gK.t().getApplicationContext().getSystemService("wifi"));
    by.a(A().aC());
    ch.aP().a(A().aD());
    ce.a(A().ay());
    bd.a(A().az());
    bf.a(A().aB());
    paramContext = gK.u().v().newFreeHandlerThread("WifiWorkThread", 0);
    paramContext.start();
    this.gL = new bt(paramContext.getLooper());
    this.gL.post(new bz.1(this));
  }
  
  public Handler ax()
  {
    return this.gL;
  }
  
  public Context t()
  {
    return gK.t();
  }
  
  public aq u()
  {
    return gK.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.bz
 * JD-Core Version:    0.7.0.1
 */