import android.content.Context;
import android.content.Intent;
import com.tencent.open.business.base.appreport.AppReportReceiver;

public class fdn
  implements Runnable
{
  public fdn(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 8
    //   2: istore_1
    //   3: aload_0
    //   4: getfield 16	fdn:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   7: invokevirtual 33	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload 5
    //   20: ldc 35
    //   22: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +211 -> 236
    //   28: aload_0
    //   29: getfield 18	fdn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   32: ldc 43
    //   34: invokevirtual 49	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 51	android/app/ActivityManager
    //   40: iconst_1
    //   41: invokevirtual 55	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   44: astore_3
    //   45: aload_3
    //   46: invokeinterface 61 1 0
    //   51: iconst_1
    //   52: if_icmplt +80 -> 132
    //   55: aload_3
    //   56: iconst_0
    //   57: invokeinterface 65 2 0
    //   62: checkcast 67	android/app/ActivityManager$RunningTaskInfo
    //   65: getfield 71	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   68: invokevirtual 76	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   71: astore_3
    //   72: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +28 -> 103
    //   78: ldc 84
    //   80: iconst_2
    //   81: new 86	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   88: ldc 89
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +28 -> 132
    //   107: aload_3
    //   108: invokevirtual 103	java/lang/String:length	()I
    //   111: ifle +21 -> 132
    //   114: aload_3
    //   115: ldc 105
    //   117: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   120: ifne +323 -> 443
    //   123: aload_3
    //   124: ldc 111
    //   126: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifne +314 -> 443
    //   132: aload_0
    //   133: getfield 16	fdn:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   136: invokevirtual 115	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +302 -> 443
    //   144: aload_3
    //   145: ldc 117
    //   147: invokevirtual 123	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   150: astore 4
    //   152: aload_3
    //   153: ldc 125
    //   155: invokevirtual 129	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: aload 4
    //   160: invokestatic 134	com/tencent/open/business/base/appreport/AppReportReceiver:a	(Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   163: ifeq +280 -> 443
    //   166: aload_0
    //   167: getfield 14	fdn:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   170: aload 4
    //   172: invokevirtual 137	com/tencent/open/business/base/appreport/AppReportReceiver:a	(Ljava/util/ArrayList;)Z
    //   175: istore_2
    //   176: iload_2
    //   177: ifeq +266 -> 443
    //   180: invokestatic 142	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   183: ifnull +15 -> 198
    //   186: invokestatic 142	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   189: invokevirtual 145	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:unRegisterMsfService	()V
    //   192: invokestatic 142	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   195: invokevirtual 148	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:unbindMsfService	()V
    //   198: aload_0
    //   199: getfield 16	fdn:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   202: ldc 150
    //   204: iconst_0
    //   205: invokevirtual 154	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   208: ifne +235 -> 443
    //   211: aload_0
    //   212: getfield 14	fdn:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   215: invokevirtual 156	com/tencent/open/business/base/appreport/AppReportReceiver:a	()V
    //   218: return
    //   219: astore_3
    //   220: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +220 -> 443
    //   226: ldc 158
    //   228: iconst_2
    //   229: ldc 160
    //   231: aload_3
    //   232: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: return
    //   236: aload_0
    //   237: getfield 16	fdn:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   240: ldc 165
    //   242: iconst_0
    //   243: invokevirtual 154	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   246: istore_2
    //   247: aload_0
    //   248: getfield 16	fdn:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   251: invokevirtual 168	android/content/Intent:getDataString	()Ljava/lang/String;
    //   254: astore_3
    //   255: aload_3
    //   256: ifnull +187 -> 443
    //   259: aload_3
    //   260: ldc 170
    //   262: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   265: ifeq +178 -> 443
    //   268: aload_3
    //   269: bipush 8
    //   271: invokevirtual 178	java/lang/String:substring	(I)Ljava/lang/String;
    //   274: astore_3
    //   275: aload_3
    //   276: ldc 180
    //   278: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +162 -> 443
    //   284: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   287: invokevirtual 189	com/tencent/common/app/BaseApplicationImpl:getFirstSimpleAccount	()Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   290: invokevirtual 194	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   293: astore 4
    //   295: aload 5
    //   297: ldc 196
    //   299: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +82 -> 384
    //   305: iload_2
    //   306: ifne +78 -> 384
    //   309: aload_3
    //   310: ldc 198
    //   312: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore_2
    //   316: iload_2
    //   317: ifeq +121 -> 438
    //   320: aload_0
    //   321: getfield 18	fdn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   324: invokevirtual 202	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   327: aload 4
    //   329: invokestatic 207	com/tencent/open/business/base/StaticAnalyz:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   332: iconst_2
    //   333: istore_1
    //   334: new 209	android/content/IntentFilter
    //   337: dup
    //   338: invokespecial 210	android/content/IntentFilter:<init>	()V
    //   341: astore 5
    //   343: aload 5
    //   345: ldc 35
    //   347: invokevirtual 214	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   350: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   353: aload_0
    //   354: getfield 14	fdn:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   357: aload 5
    //   359: invokevirtual 218	com/tencent/common/app/BaseApplicationImpl:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   362: pop
    //   363: getstatic 222	com/tencent/common/app/BaseApplicationImpl:b	Z
    //   366: ifeq +51 -> 417
    //   369: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +71 -> 443
    //   375: ldc 224
    //   377: iconst_2
    //   378: ldc 226
    //   380: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: return
    //   384: aload 5
    //   386: ldc 228
    //   388: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +7 -> 398
    //   394: iload_2
    //   395: ifeq -61 -> 334
    //   398: aload 5
    //   400: ldc 230
    //   402: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +38 -> 443
    //   408: iload_2
    //   409: ifeq +34 -> 443
    //   412: iconst_4
    //   413: istore_1
    //   414: goto -80 -> 334
    //   417: aload_0
    //   418: getfield 18	fdn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   421: invokevirtual 202	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   424: aload_3
    //   425: iload_1
    //   426: aconst_null
    //   427: aconst_null
    //   428: aload 4
    //   430: invokestatic 235	com/tencent/open/business/base/appreport/AppReport:a	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)V
    //   433: return
    //   434: astore_3
    //   435: goto -237 -> 198
    //   438: iconst_2
    //   439: istore_1
    //   440: goto -106 -> 334
    //   443: return
    //   444: astore 5
    //   446: iconst_2
    //   447: istore_1
    //   448: goto -114 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	fdn
    //   2	446	1	i	int
    //   175	234	2	bool	boolean
    //   44	109	3	localObject1	Object
    //   219	13	3	localThrowable	java.lang.Throwable
    //   254	171	3	str	java.lang.String
    //   434	1	3	localException1	java.lang.Exception
    //   150	279	4	localObject2	Object
    //   10	389	5	localObject3	Object
    //   444	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	12	219	java/lang/Throwable
    //   18	103	219	java/lang/Throwable
    //   107	132	219	java/lang/Throwable
    //   132	140	219	java/lang/Throwable
    //   144	176	219	java/lang/Throwable
    //   180	198	219	java/lang/Throwable
    //   198	218	219	java/lang/Throwable
    //   236	255	219	java/lang/Throwable
    //   259	305	219	java/lang/Throwable
    //   309	316	219	java/lang/Throwable
    //   320	332	219	java/lang/Throwable
    //   334	383	219	java/lang/Throwable
    //   384	394	219	java/lang/Throwable
    //   398	408	219	java/lang/Throwable
    //   417	433	219	java/lang/Throwable
    //   180	198	434	java/lang/Exception
    //   320	332	444	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdn
 * JD-Core Version:    0.7.0.1
 */