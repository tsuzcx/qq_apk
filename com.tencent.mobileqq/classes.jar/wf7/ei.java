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
  private static ei mt;
  private Handler mHandler = new ei.1(this, ea.getLooper());
  private long mm = 0L;
  private boolean mn = false;
  private NetworkInfo.State mo = NetworkInfo.State.UNKNOWN;
  private String mp = null;
  private String mq = null;
  private LinkedList<ei.a> mr = new LinkedList();
  private LinkedList<ei.b> ms = new LinkedList();
  
  private void bL()
  {
    ea.bV().b(new ei.2(this), "network_change");
  }
  
  public static ei cI()
  {
    if (mt == null) {
      try
      {
        if (mt == null) {
          mt = new ei();
        }
      }
      finally {}
    }
    mt.cL();
    return mt;
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
    //   3: getfield 32	wf7/ei:mn	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +84 -> 92
    //   11: invokestatic 124	wf7/fi:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +30 -> 46
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 130	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   24: putfield 39	wf7/ei:mo	Landroid/net/NetworkInfo$State;
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 134	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   32: putfield 41	wf7/ei:mp	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 137	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   40: putfield 43	wf7/ei:mq	Ljava/lang/String;
    //   43: goto +10 -> 53
    //   46: aload_0
    //   47: getstatic 140	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   50: putfield 39	wf7/ei:mo	Landroid/net/NetworkInfo$State;
    //   53: new 142	android/content/IntentFilter
    //   56: dup
    //   57: invokespecial 143	android/content/IntentFilter:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: ldc 145
    //   64: invokevirtual 149	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   67: aload_3
    //   68: ldc 150
    //   70: invokevirtual 154	android/content/IntentFilter:setPriority	(I)V
    //   73: aload_1
    //   74: aload_0
    //   75: aload_3
    //   76: invokevirtual 160	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   79: pop
    //   80: aload_0
    //   81: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   84: putfield 30	wf7/ei:mm	J
    //   87: aload_0
    //   88: iconst_1
    //   89: putfield 32	wf7/ei:mn	Z
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_3
    //   101: goto -48 -> 53
    //   104: astore_1
    //   105: goto -13 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ei
    //   0	108	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   14	62	3	localObject	Object
    //   100	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	95	finally
    //   11	15	95	finally
    //   19	43	95	finally
    //   46	53	95	finally
    //   53	92	95	finally
    //   11	15	100	java/lang/Exception
    //   19	43	100	java/lang/Exception
    //   46	53	100	java/lang/Exception
    //   53	92	104	java/lang/Throwable
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
      {
        if ((this.mm <= 0L) || (System.currentTimeMillis() - this.mm > 2000L))
        {
          eh.cE().cF();
          this.mHandler.removeMessages(1);
          this.mHandler.sendEmptyMessageDelayed(1, 5000L);
        }
        paramContext = paramIntent.getExtras();
        if (paramContext == null) {
          return;
        }
        Object localObject = (NetworkInfo)paramContext.getParcelable("networkInfo");
        if (localObject == null) {
          return;
        }
        paramContext = ((NetworkInfo)localObject).getState();
        paramIntent = ((NetworkInfo)localObject).getTypeName();
        localObject = ((NetworkInfo)localObject).getSubtypeName();
        if (paramContext == NetworkInfo.State.CONNECTED)
        {
          if (this.mo != NetworkInfo.State.CONNECTED) {
            cK();
          }
        }
        else if ((paramContext == NetworkInfo.State.DISCONNECTED) && (this.mo != NetworkInfo.State.DISCONNECTED)) {
          cJ();
        }
        this.mo = paramContext;
        this.mp = paramIntent;
        this.mq = ((String)localObject);
      }
    }
  }
  
  public void a(ei.a parama)
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
  
  public void a(ei.b paramb)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ei
 * JD-Core Version:    0.7.0.1
 */