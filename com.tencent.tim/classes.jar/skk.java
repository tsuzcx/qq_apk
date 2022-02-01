import android.content.ComponentName;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class skk
  implements ServiceConnection
{
  skk(skj paramskj) {}
  
  /* Error */
  public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder arg2)
  {
    // Byte code:
    //   0: new 22	android/os/Messenger
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 25	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
    //   8: astore_1
    //   9: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 33
    //   17: iconst_2
    //   18: ldc 35
    //   20: invokestatic 39	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: iconst_1
    //   25: invokestatic 45	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   28: astore_2
    //   29: aload_2
    //   30: aload_0
    //   31: getfield 12	skk:f	Lskj;
    //   34: getfield 51	skj:mMessenger	Landroid/os/Messenger;
    //   37: putfield 54	android/os/Message:replyTo	Landroid/os/Messenger;
    //   40: new 56	android/os/Bundle
    //   43: dup
    //   44: invokespecial 57	android/os/Bundle:<init>	()V
    //   47: astore_3
    //   48: aload_3
    //   49: ldc 59
    //   51: invokestatic 63	skj:getCurrentProcessName	()Ljava/lang/String;
    //   54: invokevirtual 67	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_2
    //   58: aload_3
    //   59: putfield 71	android/os/Message:obj	Ljava/lang/Object;
    //   62: aload_1
    //   63: aload_2
    //   64: invokevirtual 75	android/os/Messenger:send	(Landroid/os/Message;)V
    //   67: aload_0
    //   68: getfield 12	skk:f	Lskj;
    //   71: astore_2
    //   72: aload_2
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 12	skk:f	Lskj;
    //   78: aload_1
    //   79: putfield 78	skj:mService	Landroid/os/Messenger;
    //   82: new 80	java/util/ArrayList
    //   85: dup
    //   86: aload_0
    //   87: getfield 12	skk:f	Lskj;
    //   90: getfield 84	skj:mQueue	Ljava/util/List;
    //   93: invokespecial 87	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   96: astore_3
    //   97: aload_0
    //   98: getfield 12	skk:f	Lskj;
    //   101: getfield 84	skj:mQueue	Ljava/util/List;
    //   104: invokeinterface 92 1 0
    //   109: aload_2
    //   110: monitorexit
    //   111: aload_3
    //   112: invokeinterface 96 1 0
    //   117: ifle +52 -> 169
    //   120: aload_3
    //   121: invokeinterface 100 1 0
    //   126: astore_2
    //   127: aload_2
    //   128: invokeinterface 105 1 0
    //   133: ifeq +36 -> 169
    //   136: aload_1
    //   137: aload_2
    //   138: invokeinterface 109 1 0
    //   143: checkcast 41	android/os/Message
    //   146: invokevirtual 75	android/os/Messenger:send	(Landroid/os/Message;)V
    //   149: goto -22 -> 127
    //   152: astore_1
    //   153: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +13 -> 169
    //   159: ldc 33
    //   161: iconst_2
    //   162: aload_1
    //   163: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: return
    //   170: astore_1
    //   171: aload_2
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	skk
    //   0	175	1	paramComponentName	ComponentName
    //   47	74	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	152	java/lang/Exception
    //   23	74	152	java/lang/Exception
    //   111	127	152	java/lang/Exception
    //   127	149	152	java/lang/Exception
    //   173	175	152	java/lang/Exception
    //   74	111	170	finally
    //   171	173	170	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.f.mService = null;
    this.f.callbacks.clear();
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skk
 * JD-Core Version:    0.7.0.1
 */