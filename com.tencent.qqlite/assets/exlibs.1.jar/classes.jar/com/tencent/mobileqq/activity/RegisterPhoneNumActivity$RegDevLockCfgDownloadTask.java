package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public class RegisterPhoneNumActivity$RegDevLockCfgDownloadTask
  extends AsyncTask
{
  WeakReference a = null;
  
  public RegisterPhoneNumActivity$RegDevLockCfgDownloadTask(RegisterPhoneNumActivity paramRegisterPhoneNumActivity)
  {
    this.a = new WeakReference(paramRegisterPhoneNumActivity);
  }
  
  /* Error */
  protected java.lang.Void a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 24	java/io/File
    //   5: dup
    //   6: invokestatic 30	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   9: invokevirtual 36	android/content/Context:getFilesDir	()Ljava/io/File;
    //   12: ldc 38
    //   14: invokespecial 41	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 4
    //   19: aconst_null
    //   20: ldc 43
    //   22: aload 4
    //   24: invokestatic 48	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   27: ifne +19 -> 46
    //   30: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +11 -> 44
    //   36: ldc 56
    //   38: iconst_2
    //   39: ldc 58
    //   41: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aconst_null
    //   45: areturn
    //   46: ldc 64
    //   48: astore_1
    //   49: invokestatic 70	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   52: astore 5
    //   54: aload 5
    //   56: invokevirtual 74	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   59: aload 4
    //   61: invokevirtual 80	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/File;)Lorg/w3c/dom/Document;
    //   64: invokeinterface 86 1 0
    //   69: astore 5
    //   71: aload 5
    //   73: ldc 88
    //   75: invokeinterface 94 2 0
    //   80: iconst_0
    //   81: invokeinterface 100 2 0
    //   86: checkcast 90	org/w3c/dom/Element
    //   89: invokeinterface 104 1 0
    //   94: iconst_0
    //   95: invokeinterface 100 2 0
    //   100: checkcast 106	org/w3c/dom/Text
    //   103: invokeinterface 110 1 0
    //   108: invokestatic 116	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: iconst_1
    //   112: if_icmpne +307 -> 419
    //   115: iconst_1
    //   116: istore_2
    //   117: aload 5
    //   119: ldc 118
    //   121: invokeinterface 94 2 0
    //   126: astore 6
    //   128: aload 6
    //   130: invokeinterface 122 1 0
    //   135: ifle +34 -> 169
    //   138: aload 6
    //   140: iconst_0
    //   141: invokeinterface 100 2 0
    //   146: checkcast 90	org/w3c/dom/Element
    //   149: invokeinterface 104 1 0
    //   154: iconst_0
    //   155: invokeinterface 100 2 0
    //   160: checkcast 106	org/w3c/dom/Text
    //   163: invokeinterface 110 1 0
    //   168: astore_1
    //   169: aload 5
    //   171: ldc 124
    //   173: invokeinterface 94 2 0
    //   178: iconst_0
    //   179: invokeinterface 100 2 0
    //   184: checkcast 90	org/w3c/dom/Element
    //   187: invokeinterface 104 1 0
    //   192: iconst_0
    //   193: invokeinterface 100 2 0
    //   198: checkcast 106	org/w3c/dom/Text
    //   201: invokeinterface 110 1 0
    //   206: invokestatic 116	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   209: iconst_1
    //   210: if_icmpne +214 -> 424
    //   213: aload 5
    //   215: ldc 126
    //   217: invokeinterface 94 2 0
    //   222: iconst_0
    //   223: invokeinterface 100 2 0
    //   228: checkcast 90	org/w3c/dom/Element
    //   231: invokeinterface 104 1 0
    //   236: iconst_0
    //   237: invokeinterface 100 2 0
    //   242: checkcast 106	org/w3c/dom/Text
    //   245: invokeinterface 110 1 0
    //   250: astore 6
    //   252: aload 5
    //   254: ldc 128
    //   256: invokeinterface 94 2 0
    //   261: iconst_0
    //   262: invokeinterface 100 2 0
    //   267: checkcast 90	org/w3c/dom/Element
    //   270: invokeinterface 104 1 0
    //   275: iconst_0
    //   276: invokeinterface 100 2 0
    //   281: checkcast 106	org/w3c/dom/Text
    //   284: invokeinterface 110 1 0
    //   289: astore 7
    //   291: aload 5
    //   293: ldc 130
    //   295: invokeinterface 94 2 0
    //   300: iconst_0
    //   301: invokeinterface 100 2 0
    //   306: checkcast 90	org/w3c/dom/Element
    //   309: invokeinterface 104 1 0
    //   314: iconst_0
    //   315: invokeinterface 100 2 0
    //   320: checkcast 106	org/w3c/dom/Text
    //   323: invokeinterface 110 1 0
    //   328: astore 8
    //   330: new 132	android/os/Bundle
    //   333: dup
    //   334: invokespecial 133	android/os/Bundle:<init>	()V
    //   337: astore 5
    //   339: aload 5
    //   341: ldc 135
    //   343: iload_2
    //   344: invokevirtual 139	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   347: aload 5
    //   349: ldc 141
    //   351: aload_1
    //   352: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 5
    //   357: ldc 147
    //   359: iload_3
    //   360: invokevirtual 139	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   363: aload 5
    //   365: ldc 149
    //   367: aload 6
    //   369: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 5
    //   374: ldc 151
    //   376: aload 7
    //   378: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload 5
    //   383: ldc 153
    //   385: aload 8
    //   387: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload_0
    //   391: getfield 13	com/tencent/mobileqq/activity/RegisterPhoneNumActivity$RegDevLockCfgDownloadTask:a	Ljava/lang/ref/WeakReference;
    //   394: invokevirtual 157	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   397: checkcast 159	com/tencent/mobileqq/activity/RegisterPhoneNumActivity
    //   400: astore_1
    //   401: aload_1
    //   402: ifnull +9 -> 411
    //   405: aload_1
    //   406: aload 5
    //   408: invokevirtual 162	com/tencent/mobileqq/activity/RegisterPhoneNumActivity:a	(Landroid/os/Bundle;)V
    //   411: aload 4
    //   413: invokevirtual 165	java/io/File:delete	()Z
    //   416: pop
    //   417: aconst_null
    //   418: areturn
    //   419: iconst_0
    //   420: istore_2
    //   421: goto -304 -> 117
    //   424: iconst_0
    //   425: istore_3
    //   426: goto -213 -> 213
    //   429: astore_1
    //   430: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +11 -> 444
    //   436: ldc 56
    //   438: iconst_2
    //   439: ldc 167
    //   441: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: aload_1
    //   445: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   448: aload 4
    //   450: invokevirtual 165	java/io/File:delete	()Z
    //   453: pop
    //   454: aconst_null
    //   455: areturn
    //   456: astore_1
    //   457: aload 4
    //   459: invokevirtual 165	java/io/File:delete	()Z
    //   462: pop
    //   463: aload_1
    //   464: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	RegDevLockCfgDownloadTask
    //   0	465	1	paramVarArgs	java.lang.Void[]
    //   116	305	2	bool1	boolean
    //   1	425	3	bool2	boolean
    //   17	441	4	localFile	java.io.File
    //   52	355	5	localObject1	java.lang.Object
    //   126	242	6	localObject2	java.lang.Object
    //   289	88	7	str1	java.lang.String
    //   328	58	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   54	115	429	java/lang/Exception
    //   117	128	429	java/lang/Exception
    //   128	169	429	java/lang/Exception
    //   169	213	429	java/lang/Exception
    //   213	401	429	java/lang/Exception
    //   405	411	429	java/lang/Exception
    //   54	115	456	finally
    //   117	128	456	finally
    //   128	169	456	finally
    //   169	213	456	finally
    //   213	401	456	finally
    //   405	411	456	finally
    //   430	444	456	finally
    //   444	448	456	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity.RegDevLockCfgDownloadTask
 * JD-Core Version:    0.7.0.1
 */