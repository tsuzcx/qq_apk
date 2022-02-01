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
    return a.gN;
  }
  
  private void aw() {}
  
  public b A()
  {
    return gK.u().A();
  }
  
  public void a(Context paramContext, b paramb)
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
  
  static abstract interface a
  {
    public static final bz gN = new bz(null);
  }
  
  public static abstract interface b
  {
    public abstract bz.c aA();
    
    public abstract be aB();
    
    public abstract bc aC();
    
    public abstract au aD();
    
    public abstract cc ay();
    
    public abstract bd.a az();
    
    public abstract av v();
    
    public abstract ax w();
    
    public abstract as x();
    
    public abstract at y();
    
    public abstract ar z();
  }
  
  public static abstract interface c
  {
    public abstract boolean aE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.bz
 * JD-Core Version:    0.7.0.1
 */