package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.meri.service.monitor.AccessibilityDispatcher;

public final class atz
{
  public aua a;
  
  private void b()
  {
    if (this.a == null) {
      this.a = new a();
    }
  }
  
  public final aua a()
  {
    b();
    return this.a;
  }
  
  final class a
    implements aua
  {
    a()
    {
      AccessibilityDispatcher.a = new kj()
      {
        public final HandlerThread a()
        {
          return new HandlerThread("AccessibilityDispatcher");
        }
        
        public final Handler b()
        {
          HandlerThread localHandlerThread = new HandlerThread("MonitorCallbackHandler");
          localHandlerThread.start();
          return new Handler(localHandlerThread.getLooper());
        }
      };
    }
    
    public final int a(Context paramContext)
    {
      return AccessibilityDispatcher.a(paramContext);
    }
    
    public final void a() {}
    
    public final void a(Context paramContext, aoc paramaoc, aqb.a parama)
    {
      AccessibilityDispatcher.a(paramContext, paramaoc, parama);
    }
  }
  
  public static final class b
  {
    private static final atz a = new atz((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atz
 * JD-Core Version:    0.7.0.1
 */