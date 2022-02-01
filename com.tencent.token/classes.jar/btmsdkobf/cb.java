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
    public final void handleMessage(Message arg1)
    {
      if (???.what != 1) {
        return;
      }
      synchronized (cb.a(cb.this))
      {
        Object localObject1;
        Object localObject3;
        if (cb.b(cb.this) < 4)
        {
          localObject1 = (cb.a)cb.c(cb.this).poll();
          if (localObject1 != null)
          {
            localObject3 = cb.aS();
            StringBuilder localStringBuilder = new StringBuilder("[http_control]handleMessage(), allow start, running tasks: ");
            localStringBuilder.append(cb.b(cb.this));
            eh.f((String)localObject3, localStringBuilder.toString());
            cb.d(cb.this);
            cb.a(cb.this, ((cb.a)localObject1).b, ((cb.a)localObject1).a, ((cb.a)localObject1).c);
          }
          else
          {
            localObject1 = cb.aS();
            localObject3 = new StringBuilder("[http_control]handleMessage(), allow start but no data to send, running tasks: ");
            ((StringBuilder)localObject3).append(cb.b(cb.this));
            eh.e((String)localObject1, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          localObject1 = cb.aS();
          localObject3 = new StringBuilder("[http_control]handleMessage(), not allow start, running tasks(>=4): ");
          ((StringBuilder)localObject3).append(cb.b(cb.this));
          eh.g((String)localObject1, ((StringBuilder)localObject3).toString());
        }
        return;
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
      public final void run()
      {
        ??? = new AtomicReference();
        final int i;
        try
        {
          i = new ca(cb.e(cb.this), cb.f(cb.this), cb.g(cb.this), cb.h(cb.this)).a(paramf, paramArrayOfByte, (AtomicReference)???);
        }
        catch (Throwable localThrowable)
        {
          eh.b(cb.aS(), "sendDataAsyn(), exception:", localThrowable);
          i = -1200;
        }
        ??? = new Runnable()
        {
          public final void run()
          {
            if (cb.2.this.c != null) {
              cb.2.this.c.a(i, this.b);
            }
          }
        };
        Object localObject2 = ee.cT();
        if (cx.ay()) {
          ((ee)localObject2).addUrgentTask((Runnable)???, "shark-http-callback");
        } else {
          ((ee)localObject2).addTask((Runnable)???, "shark-http-callback");
        }
        synchronized (cb.a(cb.this))
        {
          cb.i(cb.this);
          if (cb.c(cb.this).size() > 0) {
            cb.j(cb.this).sendEmptyMessage(1);
          }
          localObject2 = cb.aS();
          StringBuilder localStringBuilder = new StringBuilder("[http_control]-------- send finish, running tasks: ");
          localStringBuilder.append(cb.b(cb.this));
          localStringBuilder.append(", waiting tasks: ");
          localStringBuilder.append(cb.c(cb.this).size());
          eh.e((String)localObject2, localStringBuilder.toString());
          return;
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
      paramf = TAG;
      paramArrayOfByte = new StringBuilder("[http_control]sendDataAsyn(), waiting tasks: ");
      paramArrayOfByte.append(this.hk.size());
      eh.i(paramf, paramArrayOfByte.toString());
      this.mHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  final class a
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