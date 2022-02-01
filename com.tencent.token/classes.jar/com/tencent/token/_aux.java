package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.meri.service.monitor.AccessibilityDispatcher;

public final class aux
{
  public auy a;
  
  private void b()
  {
    if (this.a == null) {
      this.a = new a();
    }
  }
  
  public final auy a()
  {
    b();
    return this.a;
  }
  
  final class a
    implements auy
  {
    a()
    {
      AccessibilityDispatcher.a = new kx()
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
    
    public final void a(Context paramContext, apa paramapa, aqz.a parama)
    {
      AccessibilityDispatcher.a(paramContext, paramapa, parama);
    }
  }
  
  public static final class b
  {
    private static final aux a = new aux((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aux
 * JD-Core Version:    0.7.0.1
 */