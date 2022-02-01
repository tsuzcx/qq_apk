package wf7;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import java.util.LinkedList;

public class ei
  extends es
{
  private static ei mt = null;
  private Handler mHandler = new ei.1(this, ea.getLooper());
  private long mm = 0L;
  private boolean mn = false;
  private NetworkInfo.State mo = NetworkInfo.State.UNKNOWN;
  private String mp = null;
  private String mq = null;
  private LinkedList<a> mr = new LinkedList();
  private LinkedList<b> ms = new LinkedList();
  
  private void bL()
  {
    ea.bV().b(new ei.2(this), "network_change");
  }
  
  public static ei cI()
  {
    if (mt == null) {}
    try
    {
      if (mt == null) {
        mt = new ei();
      }
      mt.cL();
      return mt;
    }
    finally {}
  }
  
  private void cJ()
  {
    ea.bV().b(new ei.3(this), "network_disconnected");
  }
  
  private void cK()
  {
    ea.bV().b(new ei.4(this), "network_connected");
  }
  
  private void cL()
  {
    try
    {
      Context localContext = ea.cr();
      if (localContext != null) {
        j(localContext);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  private void j(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	wf7/ei:mn	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +74 -> 82
    //   11: invokestatic 128	wf7/fi:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +69 -> 85
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 134	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   24: putfield 47	wf7/ei:mo	Landroid/net/NetworkInfo$State;
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 138	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   32: putfield 49	wf7/ei:mp	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 141	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   40: putfield 51	wf7/ei:mq	Ljava/lang/String;
    //   43: new 143	android/content/IntentFilter
    //   46: dup
    //   47: invokespecial 144	android/content/IntentFilter:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: ldc 146
    //   54: invokevirtual 150	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: ldc 151
    //   60: invokevirtual 155	android/content/IntentFilter:setPriority	(I)V
    //   63: aload_1
    //   64: aload_0
    //   65: aload_3
    //   66: invokevirtual 161	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   74: putfield 38	wf7/ei:mm	J
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 40	wf7/ei:mn	Z
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getstatic 170	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   89: putfield 47	wf7/ei:mo	Landroid/net/NetworkInfo$State;
    //   92: goto -49 -> 43
    //   95: astore_3
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: goto -23 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ei
    //   0	108	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   14	52	3	localObject	Object
    //   95	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	15	95	java/lang/Exception
    //   19	43	95	java/lang/Exception
    //   85	92	95	java/lang/Exception
    //   2	7	99	finally
    //   11	15	99	finally
    //   19	43	99	finally
    //   43	82	99	finally
    //   85	92	99	finally
    //   43	82	104	java/lang/Throwable
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()));
        if ((this.mm <= 0L) || (System.currentTimeMillis() - this.mm > 2000L)) {
          break;
        }
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      localObject = (NetworkInfo)paramContext.getParcelable("networkInfo");
    } while (localObject == null);
    paramContext = ((NetworkInfo)localObject).getState();
    paramIntent = ((NetworkInfo)localObject).getTypeName();
    Object localObject = ((NetworkInfo)localObject).getSubtypeName();
    if (paramContext == NetworkInfo.State.CONNECTED) {
      if (this.mo != NetworkInfo.State.CONNECTED) {
        cK();
      }
    }
    for (;;)
    {
      this.mo = paramContext;
      this.mp = paramIntent;
      this.mq = ((String)localObject);
      return;
      eh.cE().cF();
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      break;
      if ((paramContext == NetworkInfo.State.DISCONNECTED) && (this.mo != NetworkInfo.State.DISCONNECTED)) {
        cJ();
      }
    }
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.mr)
    {
      if (!this.mr.contains(parama)) {
        this.mr.add(parama);
      }
      return;
    }
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.ms)
    {
      if (!this.ms.contains(paramb)) {
        this.ms.add(paramb);
      }
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface b
  {
    public abstract void cM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ei
 * JD-Core Version:    0.7.0.1
 */