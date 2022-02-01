package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class cb
{
  private static String TAG = "HttpNetworkManager";
  private final Object V = new Object();
  private cl he;
  private dp hf;
  private boolean hi = false;
  private int hj = 0;
  private LinkedList<a> hk = new LinkedList();
  private Context mContext;
  private Handler mHandler = new Handler(cx.getLooper())
  {
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      }
      for (;;)
      {
        synchronized (cb.a(cb.this))
        {
          if (cb.b(cb.this) >= 4) {
            break label164;
          }
          cb.a locala = (cb.a)cb.c(cb.this).poll();
          if (locala != null)
          {
            eh.f(cb.aS(), "[http_control]handleMessage(), allow start, running tasks: " + cb.b(cb.this));
            cb.d(cb.this);
            cb.a(cb.this, locala.b, locala.a, locala.c);
            return;
          }
        }
        eh.e(cb.aS(), "[http_control]handleMessage(), allow start but no data to send, running tasks: " + cb.b(cb.this));
        continue;
        label164:
        eh.g(cb.aS(), "[http_control]handleMessage(), not allow start, running tasks(>=4): " + cb.b(cb.this));
      }
    }
  };
  
  public cb(Context paramContext, cl paramcl, dp paramdp, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.he = paramcl;
    this.hf = paramdp;
    this.hi = paramBoolean;
  }
  
  private void b(final cy.f paramf, final byte[] paramArrayOfByte, final ca.a parama)
  {
    paramf = new Runnable()
    {
      public void run()
      {
        ??? = new AtomicReference();
        try
        {
          i = new ca(cb.e(cb.this), cb.f(cb.this), cb.g(cb.this), cb.h(cb.this)).a(paramf, paramArrayOfByte, (AtomicReference)???);
          ??? = new Runnable()
          {
            public void run()
            {
              if (cb.2.this.c != null) {
                cb.2.this.c.a(i, this.b);
              }
            }
          };
          ee localee = ee.cT();
          if (cx.ay()) {
            localee.addUrgentTask((Runnable)???, "shark-http-callback");
          }
        }
        catch (Throwable localThrowable)
        {
          synchronized (cb.a(cb.this))
          {
            for (;;)
            {
              cb.i(cb.this);
              if (cb.c(cb.this).size() > 0) {
                cb.j(cb.this).sendEmptyMessage(1);
              }
              eh.e(cb.aS(), "[http_control]-------- send finish, running tasks: " + cb.b(cb.this) + ", waiting tasks: " + cb.c(cb.this).size());
              return;
              localThrowable = localThrowable;
              eh.b(cb.aS(), "sendDataAsyn(), exception:", localThrowable);
              final int i = -1200;
            }
            localThrowable.addTask((Runnable)???, "shark-http-callback");
          }
        }
      }
    };
    paramArrayOfByte = ee.cT();
    if (cx.ay())
    {
      paramArrayOfByte.addUrgentTask(paramf, "shark-http-send");
      return;
    }
    paramArrayOfByte.addTask(paramf, "shark-http-send");
  }
  
  public void a(cy.f paramf, byte[] paramArrayOfByte, ca.a parama)
  {
    synchronized (this.V)
    {
      this.hk.add(new a(paramArrayOfByte, paramf, parama));
      eh.i(TAG, "[http_control]sendDataAsyn(), waiting tasks: " + this.hk.size());
      this.mHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  private class a
  {
    public byte[] a = null;
    public cy.f b = null;
    public ca.a c = null;
    
    public a(byte[] paramArrayOfByte, cy.f paramf, ca.a parama)
    {
      this.a = paramArrayOfByte;
      this.b = paramf;
      this.c = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cb
 * JD-Core Version:    0.7.0.1
 */