package tmsdkdual;

import android.content.SharedPreferences;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackCommon;
import dualsim.common.model.SoftKey;

public class f
{
  static volatile boolean C = false;
  
  private static SoftKey a(j paramj)
  {
    SoftKey localSoftKey = new SoftKey();
    label279:
    for (;;)
    {
      try
      {
        String str4 = (String)paramj.get("pkgName");
        String str3 = (String)paramj.get("appName");
        String str2 = (String)paramj.get("version");
        Integer localInteger2 = (Integer)paramj.get("versionCode");
        String str1 = (String)paramj.get("signatureCermMD5");
        Integer localInteger1 = (Integer)paramj.get("uid");
        Boolean localBoolean = (Boolean)paramj.get("isSystem");
        Long localLong = (Long)paramj.get("size");
        paramj = str4;
        if (str4 == null) {
          paramj = "";
        }
        localSoftKey.softname = paramj;
        paramj = str3;
        if (str3 == null) {
          paramj = "";
        }
        localSoftKey.name = paramj;
        paramj = str2;
        if (str2 == null) {
          paramj = "";
        }
        localSoftKey.version = paramj;
        if (localInteger2 == null)
        {
          i = 0;
          localSoftKey.versioncode = i;
          paramj = str1;
          if (str1 == null) {
            paramj = "";
          }
          localSoftKey.cert = paramj;
          paramj = new StringBuilder().append("");
          if (localInteger1 == null)
          {
            i = 0;
            localSoftKey.uid = i;
            if (localBoolean != null) {
              continue;
            }
            break label279;
            localSoftKey.isbuildin = i;
            if (localLong != null) {
              continue;
            }
            i = 0;
            localSoftKey.filesize = i;
            return localSoftKey;
          }
        }
        else
        {
          i = localInteger2.intValue();
          continue;
        }
        int i = localInteger1.intValue();
        continue;
        if (localBoolean.booleanValue())
        {
          i = 1;
          continue;
          i = localLong.intValue();
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable paramj)
      {
        return localSoftKey;
      }
    }
  }
  
  /* Error */
  public static void g()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 108	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 112	java/lang/Thread:getId	()J
    //   9: lstore_0
    //   10: invokestatic 118	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   13: invokevirtual 121	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   16: invokevirtual 112	java/lang/Thread:getId	()J
    //   19: lstore_2
    //   20: lload_0
    //   21: lload_2
    //   22: lcmp
    //   23: ifne +7 -> 30
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: invokestatic 127	com/tmsdk/dual/TMSDualSDKContext:getApplicaionContext	()Landroid/content/Context;
    //   33: ldc 129
    //   35: invokevirtual 134	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast 136	android/net/ConnectivityManager
    //   41: invokevirtual 140	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   44: invokevirtual 145	android/net/NetworkInfo:isConnected	()Z
    //   47: istore 4
    //   49: iload 4
    //   51: ifeq -25 -> 26
    //   54: getstatic 12	tmsdkdual/f:C	Z
    //   57: ifne -31 -> 26
    //   60: invokestatic 148	tmsdkdual/f:h	()Z
    //   63: ifeq -37 -> 26
    //   66: invokestatic 154	tmsdkdual/k:q	()Ltmsdkdual/k;
    //   69: bipush 25
    //   71: iconst_2
    //   72: invokevirtual 157	tmsdkdual/k:a	(II)Ljava/util/ArrayList;
    //   75: astore 6
    //   77: new 159	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 160	java/util/ArrayList:<init>	()V
    //   84: astore 5
    //   86: aload 6
    //   88: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   91: astore 6
    //   93: aload 6
    //   95: invokeinterface 169 1 0
    //   100: ifeq +72 -> 172
    //   103: aload 6
    //   105: invokeinterface 173 1 0
    //   110: checkcast 26	tmsdkdual/j
    //   113: astore 7
    //   115: aload 7
    //   117: ifnull -24 -> 93
    //   120: aload 5
    //   122: aload 7
    //   124: invokestatic 175	tmsdkdual/f:a	(Ltmsdkdual/j;)Ldualsim/common/model/SoftKey;
    //   127: invokeinterface 181 2 0
    //   132: pop
    //   133: goto -40 -> 93
    //   136: astore 5
    //   138: ldc 182
    //   140: new 72	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   147: ldc 184
    //   149: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 5
    //   154: invokevirtual 187	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 192	tmsdkdual/m:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   166: iconst_0
    //   167: istore 4
    //   169: goto -120 -> 49
    //   172: iconst_1
    //   173: putstatic 12	tmsdkdual/f:C	Z
    //   176: aload 5
    //   178: aload 5
    //   180: invokeinterface 194 1 0
    //   185: new 6	tmsdkdual/f$1
    //   188: dup
    //   189: invokespecial 195	tmsdkdual/f$1:<init>	()V
    //   192: invokestatic 201	com/tmsdk/dual/sharkcpp/SharkCppProxy:reportSoftListAsyn	(Ljava/util/List;ILcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   195: goto -169 -> 26
    //   198: astore 5
    //   200: ldc 2
    //   202: monitorexit
    //   203: aload 5
    //   205: athrow
    //   206: astore 5
    //   208: goto -182 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	12	0	l1	long
    //   19	3	2	l2	long
    //   47	121	4	bool	boolean
    //   84	37	5	localArrayList	java.util.ArrayList
    //   136	43	5	localThrowable1	Throwable
    //   198	6	5	localObject1	Object
    //   206	1	5	localThrowable2	Throwable
    //   75	29	6	localObject2	Object
    //   113	10	7	localj	j
    // Exception table:
    //   from	to	target	type
    //   30	49	136	java/lang/Throwable
    //   3	20	198	finally
    //   30	49	198	finally
    //   54	93	198	finally
    //   93	115	198	finally
    //   120	133	198	finally
    //   138	166	198	finally
    //   172	195	198	finally
    //   3	20	206	java/lang/Throwable
    //   54	93	206	java/lang/Throwable
    //   93	115	206	java/lang/Throwable
    //   120	133	206	java/lang/Throwable
    //   138	166	206	java/lang/Throwable
    //   172	195	206	java/lang/Throwable
  }
  
  static boolean h()
  {
    try
    {
      int i = a.b().g.getInt("sr_g", 3);
      if (i < 0) {
        return false;
      }
      long l1 = System.currentTimeMillis();
      long l2 = a.b().g.getLong("sl", 0L);
      if ((l1 > l2) && (l1 - l2 >= i * 24 * 3600 * 1000)) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.f
 * JD-Core Version:    0.7.0.1
 */