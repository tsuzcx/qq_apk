import android.content.ComponentName;
import android.content.ServiceConnection;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ra
  implements ServiceConnection
{
  public ra(TroopMemberApiClient paramTroopMemberApiClient) {}
  
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
    //   31: getfield 12	ra:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   34: getfield 50	com/tencent/biz/troop/TroopMemberApiClient:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   37: putfield 53	android/os/Message:replyTo	Landroid/os/Messenger;
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 57	android/os/Messenger:send	(Landroid/os/Message;)V
    //   45: aload_0
    //   46: getfield 12	ra:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   49: astore_2
    //   50: aload_2
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 12	ra:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   56: aload_1
    //   57: putfield 60	com/tencent/biz/troop/TroopMemberApiClient:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   60: new 62	java/util/ArrayList
    //   63: dup
    //   64: aload_0
    //   65: getfield 12	ra:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   68: getfield 65	com/tencent/biz/troop/TroopMemberApiClient:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   71: invokespecial 68	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   74: astore_3
    //   75: aload_0
    //   76: getfield 12	ra:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   79: getfield 65	com/tencent/biz/troop/TroopMemberApiClient:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   82: invokeinterface 73 1 0
    //   87: aload_2
    //   88: monitorexit
    //   89: aload_3
    //   90: invokeinterface 77 1 0
    //   95: ifle +52 -> 147
    //   98: aload_3
    //   99: invokeinterface 81 1 0
    //   104: astore_2
    //   105: aload_2
    //   106: invokeinterface 86 1 0
    //   111: ifeq +36 -> 147
    //   114: aload_1
    //   115: aload_2
    //   116: invokeinterface 90 1 0
    //   121: checkcast 41	android/os/Message
    //   124: invokevirtual 57	android/os/Messenger:send	(Landroid/os/Message;)V
    //   127: goto -22 -> 105
    //   130: astore_1
    //   131: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +13 -> 147
    //   137: ldc 33
    //   139: iconst_2
    //   140: aload_1
    //   141: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: return
    //   148: astore_1
    //   149: aload_2
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ra
    //   0	153	1	paramComponentName	ComponentName
    //   74	25	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	23	130	java/lang/Exception
    //   23	52	130	java/lang/Exception
    //   89	105	130	java/lang/Exception
    //   105	127	130	java/lang/Exception
    //   151	153	130	java/lang/Exception
    //   52	89	148	finally
    //   149	151	148	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_b_of_type_AndroidOsMessenger = null;
    this.a.jdField_a_of_type_JavaUtilMap.clear();
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ra
 * JD-Core Version:    0.7.0.1
 */