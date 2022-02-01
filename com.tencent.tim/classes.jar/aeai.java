import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

public class aeai
  implements EIPCResultCallback
{
  private static aeai a;
  
  public static aeai a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aeai();
      }
      return a;
    }
    finally {}
  }
  
  public void Hk(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_confess");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      localBundle.putString("tag", paramString);
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_clear_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  public void LO(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("nSwitchValue", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_update_switch", localBundle);
    if (QLog.isColorLevel()) {
      QLog.i("CampusCircleIpcClient", 2, "updateConfessSwitch nSwitchValue: " + paramInt);
    }
  }
  
  public Object[] b(String paramString)
  {
    label241:
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcClient", 2, "getTroopMembers " + paramString);
        }
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putString("troopUin", paramString);
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_get_troop_members", (Bundle)localObject1);
        if ((localObject1 != null) && (((EIPCResult)localObject1).code == 0))
        {
          Object localObject2 = ((EIPCResult)localObject1).data;
          if (localObject2 != null)
          {
            try
            {
              localObject2 = (List)((EIPCResult)localObject1).data.getSerializable("troopUin");
              boolean bool1 = ((EIPCResult)localObject1).data.getBoolean("isAdmin", false);
              boolean bool2 = ((EIPCResult)localObject1).data.getBoolean("enableMemInvite", false);
              if (QLog.isColorLevel()) {
                QLog.i("CampusCircleIpcClient", 2, String.format("getTroopMembers troopUin:%s isAdmin:%s enableInvite:%s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
              }
              paramString = new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject2 };
              return paramString;
            }
            catch (Exception paramString)
            {
              if (!QLog.isColorLevel()) {
                break label241;
              }
            }
            QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err", paramString);
            break label241;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err");
        }
        paramString = null;
        continue;
        paramString = null;
      }
      finally {}
    }
  }
  
  public void bUo()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "reportMedalRedPoint");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_medal_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  public void cVt()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_allPeopleVote");
      }
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_allpeoplevote_clearredpoint", new Bundle());
      return;
    }
    finally {}
  }
  
  /* Error */
  public Object[] g()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: new 35	android/os/Bundle
    //   9: dup
    //   10: invokespecial 36	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: invokestatic 52	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   18: invokevirtual 56	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   21: ldc 58
    //   23: ldc 166
    //   25: aload 5
    //   27: invokevirtual 79	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +95 -> 129
    //   37: aload 5
    //   39: getfield 114	eipc/EIPCResult:code	I
    //   42: ifne +87 -> 129
    //   45: aload 5
    //   47: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   50: ifnull +79 -> 129
    //   53: aload 5
    //   55: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   58: ldc 168
    //   60: iconst_0
    //   61: invokevirtual 130	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   64: istore 4
    //   66: iload_3
    //   67: istore_1
    //   68: iload 4
    //   70: istore_2
    //   71: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +34 -> 108
    //   77: ldc 27
    //   79: iconst_2
    //   80: new 81	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   87: ldc 170
    //   89: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 4
    //   94: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   97: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload 4
    //   105: istore_2
    //   106: iload_3
    //   107: istore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: iload_1
    //   117: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: iload_2
    //   124: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   127: aastore
    //   128: areturn
    //   129: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +11 -> 143
    //   135: ldc 27
    //   137: iconst_2
    //   138: ldc 175
    //   140: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iconst_0
    //   144: istore_1
    //   145: goto -37 -> 108
    //   148: astore 5
    //   150: aload_0
    //   151: monitorexit
    //   152: aload 5
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	aeai
    //   67	78	1	bool1	boolean
    //   3	121	2	bool2	boolean
    //   1	106	3	bool3	boolean
    //   64	40	4	bool4	boolean
    //   13	41	5	localObject1	Object
    //   148	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	148	finally
    //   37	66	148	finally
    //   71	103	148	finally
    //   129	143	148	finally
  }
  
  /* Error */
  public void iY(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 27
    //   10: iconst_2
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc 179
    //   20: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: lload_1
    //   34: lconst_0
    //   35: lcmp
    //   36: ifge +14 -> 50
    //   39: ldc 27
    //   41: iconst_1
    //   42: ldc 184
    //   44: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new 35	android/os/Bundle
    //   53: dup
    //   54: invokespecial 36	android/os/Bundle:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: ldc 186
    //   61: lload_1
    //   62: invokevirtual 190	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   65: invokestatic 52	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   68: ldc 58
    //   70: ldc 192
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 157	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   77: goto -30 -> 47
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	aeai
    //   0	85	1	paramLong	long
    //   57	16	3	localBundle	Bundle
    //   80	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	80	finally
    //   39	47	80	finally
    //   50	77	80	finally
  }
  
  /* Error */
  public Bundle m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 27
    //   10: iconst_2
    //   11: ldc 196
    //   13: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 35	android/os/Bundle
    //   19: dup
    //   20: invokespecial 36	android/os/Bundle:<init>	()V
    //   23: astore_1
    //   24: invokestatic 52	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   27: invokevirtual 56	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   30: ldc 58
    //   32: ldc 198
    //   34: aload_1
    //   35: invokevirtual 79	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +26 -> 66
    //   43: aload_1
    //   44: invokevirtual 201	eipc/EIPCResult:isSuccess	()Z
    //   47: ifeq +19 -> 66
    //   50: aload_1
    //   51: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -6 -> 62
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	aeai
    //   23	45	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	71	finally
    //   16	39	71	finally
    //   43	62	71	finally
  }
  
  /* Error */
  public Bundle n()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 27
    //   12: iconst_2
    //   13: ldc 204
    //   15: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: new 35	android/os/Bundle
    //   21: dup
    //   22: invokespecial 36	android/os/Bundle:<init>	()V
    //   25: astore_3
    //   26: invokestatic 52	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   29: invokevirtual 56	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   32: ldc 58
    //   34: ldc 206
    //   36: aload_3
    //   37: invokevirtual 79	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   40: astore_3
    //   41: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +64 -> 108
    //   47: new 81	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   54: ldc 208
    //   56: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: astore 4
    //   61: aload_3
    //   62: ifnull +73 -> 135
    //   65: iconst_1
    //   66: istore_1
    //   67: aload 4
    //   69: iload_1
    //   70: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: ldc 210
    //   75: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +59 -> 140
    //   84: aload_3
    //   85: invokevirtual 201	eipc/EIPCResult:isSuccess	()Z
    //   88: ifeq +52 -> 140
    //   91: iload_2
    //   92: istore_1
    //   93: ldc 27
    //   95: iconst_4
    //   96: aload 4
    //   98: iload_1
    //   99: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_3
    //   109: ifnull +36 -> 145
    //   112: aload_3
    //   113: invokevirtual 201	eipc/EIPCResult:isSuccess	()Z
    //   116: ifeq +29 -> 145
    //   119: aload_3
    //   120: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   123: ifnull +22 -> 145
    //   126: aload_3
    //   127: getfield 118	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: areturn
    //   135: iconst_0
    //   136: istore_1
    //   137: goto -70 -> 67
    //   140: iconst_0
    //   141: istore_1
    //   142: goto -49 -> 93
    //   145: aconst_null
    //   146: astore_3
    //   147: goto -16 -> 131
    //   150: astore_3
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	aeai
    //   66	76	1	bool1	boolean
    //   1	91	2	bool2	boolean
    //   25	122	3	localObject1	Object
    //   150	4	3	localObject2	Object
    //   59	38	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	18	150	finally
    //   18	61	150	finally
    //   67	80	150	finally
    //   84	91	150	finally
    //   93	108	150	finally
    //   112	131	150	finally
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCallback, result=").append(paramEIPCResult).append(", data=");
      if (paramEIPCResult != null) {
        break label50;
      }
    }
    label50:
    for (paramEIPCResult = "null";; paramEIPCResult = paramEIPCResult.data)
    {
      QLog.d("CampusCircleIpcClient", 2, paramEIPCResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeai
 * JD-Core Version:    0.7.0.1
 */