import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class aipu
  implements aips
{
  private aipu.a a;
  private final AtomicInteger bt = new AtomicInteger(-1);
  private WeakReference<aipq> ck;
  private volatile boolean clm;
  private WeakReference<aipp> hk;
  private WeakReference<aipt> hl;
  private WeakReference<aipr> hm;
  private AppRuntime mApp;
  private Messenger mClientMessenger;
  private ServiceConnection mConnection = new aipv(this);
  private Context mContext;
  private Messenger mService;
  
  public aipu(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.mContext = paramContext;
    this.mApp = paramAppRuntime;
  }
  
  private void Lo(boolean paramBoolean)
  {
    if (this.hl != null)
    {
      aipt localaipt = (aipt)this.hl.get();
      if (localaipt != null) {
        localaipt.Lj(paramBoolean);
      }
    }
  }
  
  private void Qb(int paramInt)
  {
    if (this.hk != null)
    {
      aipp localaipp = (aipp)this.hk.get();
      if (localaipp != null) {
        localaipp.PZ(paramInt);
      }
    }
  }
  
  private void at(String paramString, int paramInt1, int paramInt2)
  {
    if (this.hm != null)
    {
      aipr localaipr = (aipr)this.hm.get();
      if (localaipr != null) {
        localaipr.ar(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  private void cg(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.hl != null)
    {
      aipt localaipt = (aipt)this.hl.get();
      if (localaipt != null) {
        localaipt.cf(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  /* Error */
  private void doDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	aipu:clm	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 139
    //   22: iconst_2
    //   23: ldc 141
    //   25: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 147	aipu:a	Laipu$a;
    //   32: ifnull +18 -> 50
    //   35: aload_0
    //   36: getfield 147	aipu:a	Laipu$a;
    //   39: invokevirtual 151	aipu$a:getLooper	()Landroid/os/Looper;
    //   42: invokevirtual 156	android/os/Looper:quit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 147	aipu:a	Laipu$a;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 82	aipu:mClientMessenger	Landroid/os/Messenger;
    //   55: aload_0
    //   56: getfield 53	aipu:mContext	Landroid/content/Context;
    //   59: aload_0
    //   60: getfield 51	aipu:mConnection	Landroid/content/ServiceConnection;
    //   63: invokevirtual 162	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   66: aload_0
    //   67: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   70: iconst_m1
    //   71: invokevirtual 165	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 85	aipu:mService	Landroid/os/Messenger;
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   84: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   87: invokespecial 92	aipu:Qb	(I)V
    //   90: goto -79 -> 11
    //   93: astore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: astore_2
    //   99: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +12 -> 114
    //   105: ldc 139
    //   107: iconst_2
    //   108: ldc 170
    //   110: aload_2
    //   111: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   118: iconst_m1
    //   119: invokevirtual 165	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 85	aipu:mService	Landroid/os/Messenger;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   132: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   135: invokespecial 92	aipu:Qb	(I)V
    //   138: goto -127 -> 11
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   146: iconst_m1
    //   147: invokevirtual 165	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 85	aipu:mService	Landroid/os/Messenger;
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   160: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   163: invokespecial 92	aipu:Qb	(I)V
    //   166: aload_2
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	aipu
    //   6	2	1	bool	boolean
    //   93	4	2	localObject1	Object
    //   98	13	2	localException	java.lang.Exception
    //   141	26	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	93	finally
    //   14	28	93	finally
    //   28	50	93	finally
    //   50	55	93	finally
    //   66	90	93	finally
    //   114	138	93	finally
    //   142	168	93	finally
    //   55	66	98	java/lang/Exception
    //   55	66	141	finally
    //   99	114	141	finally
  }
  
  private void e(ISong paramISong)
  {
    if (this.ck != null)
    {
      aipq localaipq = (aipq)this.ck.get();
      if (localaipq != null) {
        localaipq.b(paramISong);
      }
    }
  }
  
  private void eR(String paramString, int paramInt)
  {
    if (this.hl != null)
    {
      aipt localaipt = (aipt)this.hl.get();
      if (localaipt != null) {
        localaipt.eS(paramString, paramInt);
      }
    }
  }
  
  private void sendMessage(Message paramMessage)
  {
    Intent localIntent = new Intent(this.mContext, QQMusicPlayService.class);
    localIntent.putExtra("key_message", paramMessage);
    try
    {
      this.mContext.startService(localIntent);
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("QQMusicPlay.QQMusicPlayClient", 1, "sendMessage exception===>", paramMessage);
    }
  }
  
  public int FH()
  {
    return QQMusicPlayService.FH();
  }
  
  public void a(aipp paramaipp)
  {
    if (paramaipp != null)
    {
      this.hk = new WeakReference(paramaipp);
      return;
    }
    this.hk = null;
  }
  
  public void a(aipq paramaipq)
  {
    if (paramaipq != null)
    {
      this.ck = new WeakReference(paramaipq);
      return;
    }
    this.ck = null;
  }
  
  public void a(aipr paramaipr)
  {
    if (paramaipr != null)
    {
      this.hm = new WeakReference(paramaipr);
      return;
    }
    this.hm = null;
  }
  
  public void a(aipt paramaipt)
  {
    if (paramaipt != null)
    {
      this.hl = new WeakReference(paramaipt);
      return;
    }
    this.hl = null;
  }
  
  public boolean a(ISong paramISong)
  {
    boolean bool = false;
    try
    {
      if (QLog.isColorLevel())
      {
        if (this.mService != null) {
          bool = true;
        }
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->startPlay song=[%s] connected=%b", new Object[] { paramISong, Boolean.valueOf(bool) }));
      }
      Message localMessage = Message.obtain(null, 6);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_song", paramISong);
      localMessage.setData(localBundle);
      sendMessage(localMessage);
      return true;
    }
    finally {}
  }
  
  public boolean apr()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->pausePlay");
      }
      sendMessage(Message.obtain(null, 7));
      return true;
    }
    finally {}
  }
  
  public boolean aps()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->resumePlay");
      }
      sendMessage(Message.obtain(null, 8));
      return true;
    }
    finally {}
  }
  
  public int getPlayState()
  {
    return QQMusicPlayService.getPlayState();
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 118	aipu:clm	Z
    //   7: aload_0
    //   8: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: istore_1
    //   15: iload_1
    //   16: iflt +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 139
    //   30: iconst_2
    //   31: ldc_w 265
    //   34: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: new 267	android/os/HandlerThread
    //   40: dup
    //   41: ldc_w 269
    //   44: invokespecial 272	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 275	android/os/HandlerThread:start	()V
    //   52: aload_0
    //   53: new 8	aipu$a
    //   56: dup
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 276	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   62: invokespecial 279	aipu$a:<init>	(Laipu;Landroid/os/Looper;)V
    //   65: putfield 147	aipu:a	Laipu$a;
    //   68: aload_0
    //   69: new 281	android/os/Messenger
    //   72: dup
    //   73: aload_0
    //   74: getfield 147	aipu:a	Laipu$a;
    //   77: invokespecial 284	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   80: putfield 82	aipu:mClientMessenger	Landroid/os/Messenger;
    //   83: new 188	android/content/Intent
    //   86: dup
    //   87: aload_0
    //   88: getfield 53	aipu:mContext	Landroid/content/Context;
    //   91: ldc 190
    //   93: invokespecial 193	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 53	aipu:mContext	Landroid/content/Context;
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 51	aipu:mConnection	Landroid/content/ServiceConnection;
    //   106: iconst_1
    //   107: invokevirtual 288	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   110: pop
    //   111: aload_0
    //   112: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   115: iconst_0
    //   116: invokevirtual 165	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   124: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   127: invokespecial 92	aipu:Qb	(I)V
    //   130: goto -111 -> 19
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 291	java/lang/Exception:printStackTrace	()V
    //   143: ldc 139
    //   145: iconst_1
    //   146: ldc_w 293
    //   149: aload_2
    //   150: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   158: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   161: invokespecial 92	aipu:Qb	(I)V
    //   164: goto -145 -> 19
    //   167: astore_2
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   173: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   176: invokespecial 92	aipu:Qb	(I)V
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	aipu
    //   14	2	1	i	int
    //   47	55	2	localObject1	Object
    //   133	4	2	localObject2	Object
    //   138	12	2	localException	java.lang.Exception
    //   167	13	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	133	finally
    //   22	37	133	finally
    //   37	97	133	finally
    //   119	130	133	finally
    //   153	164	133	finally
    //   168	181	133	finally
    //   97	119	138	java/lang/Exception
    //   97	119	167	finally
    //   139	153	167	finally
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	aipu:bt	Ljava/util/concurrent/atomic/AtomicInteger;
    //   8: invokevirtual 168	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   11: istore_1
    //   12: iload_1
    //   13: iconst_1
    //   14: if_icmpne +7 -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	aipu
    //   11	4	1	i	int
    //   1	22	2	bool	boolean
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	12	26	finally
  }
  
  public boolean stopPlay()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->stopPlay");
      }
      this.clm = true;
      sendMessage(Message.obtain(null, 10));
      return true;
    }
    finally {}
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<aipu> bs;
    
    a(aipu paramaipu, Looper paramLooper)
    {
      super();
      this.bs = new WeakReference(paramaipu);
    }
    
    public void handleMessage(Message paramMessage)
    {
      aipu localaipu = (aipu)this.bs.get();
      if (localaipu == null) {
        super.handleMessage(paramMessage);
      }
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            super.handleMessage(paramMessage);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->handleMessage[MSG_FROM_SERVICE]");
        return;
        paramMessage = paramMessage.getData();
        paramMessage.setClassLoader(ISong.class.getClassLoader());
        paramMessage = (ISong)paramMessage.getParcelable("key_song");
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_SONG_CHANGE] %s", new Object[] { paramMessage.getId() }));
        }
        aipu.a(localaipu, paramMessage);
        return;
        paramMessage = paramMessage.getData();
        String str = paramMessage.getString("key_id");
        i = paramMessage.getInt("key_play_state", -1);
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_STATE_CHANGE] %s %s", new Object[] { str, aipo.bA(i) }));
        }
        aipu.a(localaipu, str, i);
      } while ((i != 4) || (!aipu.a(localaipu)));
      aipu.a(localaipu);
      return;
      boolean bool1 = paramMessage.getData().getBoolean("key_net_state", false);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_NET_STATE_CHANGE] %b", new Object[] { Boolean.valueOf(bool1) }));
      }
      aipu.a(localaipu, bool1);
      return;
      paramMessage = paramMessage.getData();
      bool1 = paramMessage.getBoolean("key_focus_state", false);
      boolean bool2 = paramMessage.getBoolean("key_focus_transient", false);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_FOCUS_STATE_CHANGE] %b_%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      aipu.a(localaipu, bool1, bool2);
      return;
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("key_position", -1);
      int j = paramMessage.getInt("key_duration", -1);
      paramMessage = paramMessage.getString("key_id");
      if (((i <= 0) || (j <= 0)) && (QLog.isColorLevel())) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PROGRESS_CHANGE] [%d/%d] %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramMessage }));
      }
      aipu.a(localaipu, paramMessage, i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipu
 * JD-Core Version:    0.7.0.1
 */