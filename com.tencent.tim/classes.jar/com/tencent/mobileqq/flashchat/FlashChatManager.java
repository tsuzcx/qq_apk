package com.tencent.mobileqq.flashchat;

import acbn;
import acle;
import aehx;
import aeif;
import aeij;
import aeju;
import ahei;
import ahel;
import aheq;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import anot;
import aqhq;
import aqul;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import ocp;
import org.json.JSONObject;

public class FlashChatManager
  implements Manager
{
  public static SparseArray<Integer> cE;
  public static SparseArray<Long> cF;
  public b a = new b();
  public CopyOnWriteArrayList<MessageForArkFlashChat> af = new CopyOnWriteArrayList();
  QQAppInterface app;
  aeij b = aeij.a("flashchat");
  MessageForArkFlashChat c = null;
  public SparseArray<String> cD = new SparseArray();
  public AtomicBoolean cU = new AtomicBoolean(false);
  public boolean cgr = true;
  boolean cgs;
  public ArrayList<FlashChatItem> ed;
  public ConcurrentHashMap<Long, Long> fp = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> fq = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> fr = new ConcurrentHashMap();
  boolean isLoaded = false;
  private HashMap<String, String> kV = new HashMap();
  int[] lr = { 3, 4, 2, 1, 0 };
  private boolean mLoaded;
  String rootDir;
  
  public FlashChatManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    ThreadManager.post(new FlashChatManager.1(this), 8, null, true);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, FlashChatItem paramFlashChatItem)
  {
    int i = 0;
    int j = ((acle)paramQQAppInterface.getBusinessHandler(13)).AX();
    switch (paramFlashChatItem.feedType)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramQQAppInterface = null;
      if (i == 0)
      {
        paramQQAppInterface = "LTMCLUB";
        if (paramFlashChatItem.feedType == 5) {
          paramQQAppInterface = "CJCLUBT";
        }
      }
      return paramQQAppInterface;
      if (j == 3) {}
      for (i = 1;; i = 0) {
        break;
      }
      if ((j == 1) || (j == 3)) {
        i = 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "SourceClickHandler clickWebMsg  url = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("url", paramString1);
    paramContext.startActivity(localIntent);
    if (paramMessageRecord != null)
    {
      ocp.a(paramMessageRecord, localIntent, paramString1);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    }
    return true;
  }
  
  /* Error */
  public static boolean clickAppMsg(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +46 -> 49
    //   6: ldc 156
    //   8: iconst_2
    //   9: new 158	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   16: ldc 245
    //   18: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 247
    //   27: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 249
    //   36: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_2
    //   50: aload_3
    //   51: invokestatic 253	com/tencent/mobileqq/flashchat/FlashChatManager:parsePackageNameAndData	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: invokevirtual 257	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   59: astore_2
    //   60: aload_2
    //   61: aload_1
    //   62: iconst_0
    //   63: aaload
    //   64: iconst_1
    //   65: invokevirtual 263	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   68: ifnull +170 -> 238
    //   71: aload_2
    //   72: aload_1
    //   73: iconst_0
    //   74: aaload
    //   75: invokevirtual 267	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   78: astore_2
    //   79: aload_2
    //   80: ifnonnull +5 -> 85
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_2
    //   86: ldc_w 268
    //   89: invokevirtual 272	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   92: pop
    //   93: aload_1
    //   94: iconst_1
    //   95: aaload
    //   96: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +14 -> 113
    //   102: aload_2
    //   103: aload_1
    //   104: iconst_1
    //   105: aaload
    //   106: invokestatic 278	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   109: invokevirtual 282	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   112: pop
    //   113: aload 4
    //   115: bipush 23
    //   117: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   120: checkcast 284	acly
    //   123: astore_3
    //   124: aload_2
    //   125: ldc_w 286
    //   128: ldc_w 288
    //   131: invokevirtual 207	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   134: pop
    //   135: aload_2
    //   136: ldc_w 290
    //   139: ldc 226
    //   141: invokevirtual 207	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   144: pop
    //   145: aload_2
    //   146: ldc_w 292
    //   149: ldc_w 294
    //   152: invokevirtual 207	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_2
    //   157: ldc_w 296
    //   160: ldc_w 298
    //   163: invokevirtual 207	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   166: pop
    //   167: aload_2
    //   168: ldc_w 300
    //   171: aload_0
    //   172: invokevirtual 304	java/lang/Object:getClass	()Ljava/lang/Class;
    //   175: invokevirtual 309	java/lang/Class:getName	()Ljava/lang/String;
    //   178: invokevirtual 207	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   181: pop
    //   182: aload_3
    //   183: aload_1
    //   184: iconst_0
    //   185: aaload
    //   186: invokevirtual 312	java/lang/String:trim	()Ljava/lang/String;
    //   189: aload_0
    //   190: aload_2
    //   191: invokevirtual 315	acly:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_1
    //   197: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc_w 317
    //   206: iconst_2
    //   207: ldc_w 319
    //   210: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_0
    //   214: aload_2
    //   215: invokevirtual 215	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   218: goto -24 -> 194
    //   221: astore_0
    //   222: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +13 -> 238
    //   228: ldc 156
    //   230: iconst_2
    //   231: aload_0
    //   232: invokevirtual 322	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   235: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_0
    //   241: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq -6 -> 238
    //   247: ldc 156
    //   249: iconst_2
    //   250: aload_0
    //   251: invokevirtual 323	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   254: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -19 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramContext	Context
    //   0	260	1	paramString1	String
    //   0	260	2	paramString2	String
    //   0	260	3	paramString3	String
    //   0	260	4	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   113	194	196	java/lang/Exception
    //   60	79	221	android/content/pm/PackageManager$NameNotFoundException
    //   85	113	221	android/content/pm/PackageManager$NameNotFoundException
    //   113	194	221	android/content/pm/PackageManager$NameNotFoundException
    //   197	213	221	android/content/pm/PackageManager$NameNotFoundException
    //   213	218	221	android/content/pm/PackageManager$NameNotFoundException
    //   60	79	240	java/lang/RuntimeException
    //   85	113	240	java/lang/RuntimeException
    //   113	194	240	java/lang/RuntimeException
    //   197	213	240	java/lang/RuntimeException
    //   213	218	240	java/lang/RuntimeException
  }
  
  /* Error */
  private void fn(String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 6
    //   12: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +39 -> 54
    //   18: ldc 156
    //   20: iconst_2
    //   21: new 158	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 329
    //   31: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 331
    //   41: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: new 333	java/io/File
    //   57: dup
    //   58: new 158	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   65: aload_2
    //   66: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 336	java/io/File:separator	Ljava/lang/String;
    //   72: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore 7
    //   83: aload 7
    //   85: invokevirtual 342	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 7
    //   93: invokevirtual 345	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload 11
    //   99: astore 8
    //   101: aload 10
    //   103: astore 7
    //   105: new 347	com/tencent/commonsdk/zip/QZipFile
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 348	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   113: astore 12
    //   115: aload 11
    //   117: astore 8
    //   119: aload 10
    //   121: astore 7
    //   123: aload 12
    //   125: invokevirtual 354	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   128: astore 13
    //   130: aload 11
    //   132: astore 8
    //   134: aload 10
    //   136: astore 7
    //   138: sipush 8192
    //   141: newarray byte
    //   143: astore 10
    //   145: aload 9
    //   147: astore_1
    //   148: aload 6
    //   150: astore 8
    //   152: aload_1
    //   153: astore 7
    //   155: aload 13
    //   157: invokeinterface 359 1 0
    //   162: ifeq +521 -> 683
    //   165: aload 6
    //   167: astore 8
    //   169: aload_1
    //   170: astore 7
    //   172: aload 13
    //   174: invokeinterface 363 1 0
    //   179: checkcast 365	java/util/zip/ZipEntry
    //   182: astore 14
    //   184: aload 6
    //   186: astore 8
    //   188: aload_1
    //   189: astore 7
    //   191: aload 14
    //   193: invokevirtual 366	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   196: astore 9
    //   198: aload 9
    //   200: ifnull -52 -> 148
    //   203: aload 6
    //   205: astore 8
    //   207: aload_1
    //   208: astore 7
    //   210: aload 9
    //   212: ldc_w 368
    //   215: invokevirtual 371	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   218: ifne -70 -> 148
    //   221: aload 6
    //   223: astore 8
    //   225: aload_1
    //   226: astore 7
    //   228: new 158	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   235: aload_2
    //   236: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: getstatic 336	java/io/File:separator	Ljava/lang/String;
    //   242: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 9
    //   247: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore 11
    //   255: aload 6
    //   257: astore 8
    //   259: aload_1
    //   260: astore 7
    //   262: aload 14
    //   264: invokevirtual 374	java/util/zip/ZipEntry:isDirectory	()Z
    //   267: ifeq +52 -> 319
    //   270: aload 6
    //   272: astore 8
    //   274: aload_1
    //   275: astore 7
    //   277: new 333	java/io/File
    //   280: dup
    //   281: aload 11
    //   283: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore 9
    //   288: aload 6
    //   290: astore 8
    //   292: aload_1
    //   293: astore 7
    //   295: aload 9
    //   297: invokevirtual 342	java/io/File:exists	()Z
    //   300: ifne +436 -> 736
    //   303: aload 6
    //   305: astore 8
    //   307: aload_1
    //   308: astore 7
    //   310: aload 9
    //   312: invokevirtual 377	java/io/File:mkdir	()Z
    //   315: pop
    //   316: goto +420 -> 736
    //   319: aload 6
    //   321: astore 8
    //   323: aload_1
    //   324: astore 7
    //   326: aload 11
    //   328: getstatic 336	java/io/File:separator	Ljava/lang/String;
    //   331: invokevirtual 381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   334: istore_3
    //   335: aload 6
    //   337: astore 8
    //   339: aload_1
    //   340: astore 7
    //   342: aload 11
    //   344: iconst_0
    //   345: iload_3
    //   346: invokevirtual 385	java/lang/String:substring	(II)Ljava/lang/String;
    //   349: astore 9
    //   351: aload 6
    //   353: astore 8
    //   355: aload_1
    //   356: astore 7
    //   358: aload 11
    //   360: iload_3
    //   361: iconst_1
    //   362: iadd
    //   363: invokevirtual 388	java/lang/String:substring	(I)Ljava/lang/String;
    //   366: ldc_w 390
    //   369: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   372: ifne -224 -> 148
    //   375: aload 6
    //   377: astore 8
    //   379: aload_1
    //   380: astore 7
    //   382: new 333	java/io/File
    //   385: dup
    //   386: aload 9
    //   388: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   391: astore 9
    //   393: aload 6
    //   395: astore 8
    //   397: aload_1
    //   398: astore 7
    //   400: aload 9
    //   402: invokevirtual 342	java/io/File:exists	()Z
    //   405: ifne +16 -> 421
    //   408: aload 6
    //   410: astore 8
    //   412: aload_1
    //   413: astore 7
    //   415: aload 9
    //   417: invokevirtual 377	java/io/File:mkdir	()Z
    //   420: pop
    //   421: aload 6
    //   423: astore 8
    //   425: aload_1
    //   426: astore 7
    //   428: new 333	java/io/File
    //   431: dup
    //   432: new 158	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   439: aload 11
    //   441: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 392
    //   447: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: astore 9
    //   458: aload 6
    //   460: astore 8
    //   462: aload_1
    //   463: astore 7
    //   465: new 333	java/io/File
    //   468: dup
    //   469: aload 11
    //   471: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   474: astore 11
    //   476: aload 6
    //   478: astore 8
    //   480: aload_1
    //   481: astore 7
    //   483: aload 9
    //   485: invokevirtual 342	java/io/File:exists	()Z
    //   488: ifeq +16 -> 504
    //   491: aload 6
    //   493: astore 8
    //   495: aload_1
    //   496: astore 7
    //   498: aload 9
    //   500: invokevirtual 395	java/io/File:delete	()Z
    //   503: pop
    //   504: aload 6
    //   506: astore 8
    //   508: aload_1
    //   509: astore 7
    //   511: new 397	java/io/FileOutputStream
    //   514: dup
    //   515: aload 9
    //   517: invokespecial 400	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   520: astore 6
    //   522: aload 12
    //   524: aload 14
    //   526: invokevirtual 404	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   529: astore 7
    //   531: lconst_0
    //   532: lstore 4
    //   534: aload 7
    //   536: astore_1
    //   537: aload 7
    //   539: aload 10
    //   541: iconst_0
    //   542: aload 10
    //   544: arraylength
    //   545: invokevirtual 410	java/io/InputStream:read	([BII)I
    //   548: istore_3
    //   549: iload_3
    //   550: iconst_m1
    //   551: if_icmpeq +57 -> 608
    //   554: lload 4
    //   556: iload_3
    //   557: i2l
    //   558: ladd
    //   559: lstore 4
    //   561: aload 7
    //   563: astore_1
    //   564: aload 6
    //   566: aload 10
    //   568: iconst_0
    //   569: iload_3
    //   570: invokevirtual 414	java/io/FileOutputStream:write	([BII)V
    //   573: goto -39 -> 534
    //   576: astore_2
    //   577: aload 6
    //   579: astore 8
    //   581: aload_1
    //   582: astore 7
    //   584: aload_2
    //   585: astore_1
    //   586: aload 8
    //   588: ifnull +8 -> 596
    //   591: aload 8
    //   593: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   596: aload 7
    //   598: ifnull +8 -> 606
    //   601: aload 7
    //   603: invokevirtual 418	java/io/InputStream:close	()V
    //   606: aload_1
    //   607: athrow
    //   608: aload 7
    //   610: astore_1
    //   611: aload 6
    //   613: invokevirtual 421	java/io/FileOutputStream:flush	()V
    //   616: aload 7
    //   618: astore_1
    //   619: aload 6
    //   621: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   624: aload 7
    //   626: astore_1
    //   627: aload 7
    //   629: invokevirtual 418	java/io/InputStream:close	()V
    //   632: aconst_null
    //   633: astore 7
    //   635: aconst_null
    //   636: astore 8
    //   638: aload 7
    //   640: astore_1
    //   641: aload 8
    //   643: astore 6
    //   645: aload 9
    //   647: aload 11
    //   649: invokestatic 427	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   652: ifne +94 -> 746
    //   655: aload 9
    //   657: aload 11
    //   659: invokestatic 430	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   662: pop
    //   663: aload 7
    //   665: astore_1
    //   666: aload 8
    //   668: astore 6
    //   670: goto +76 -> 746
    //   673: astore_1
    //   674: aconst_null
    //   675: astore 7
    //   677: aconst_null
    //   678: astore 8
    //   680: goto -94 -> 586
    //   683: aload 6
    //   685: ifnull +8 -> 693
    //   688: aload 6
    //   690: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   693: aload_1
    //   694: ifnull +7 -> 701
    //   697: aload_1
    //   698: invokevirtual 418	java/io/InputStream:close	()V
    //   701: return
    //   702: astore_2
    //   703: aload_2
    //   704: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   707: goto -14 -> 693
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   715: return
    //   716: astore_2
    //   717: aload_2
    //   718: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   721: goto -125 -> 596
    //   724: astore_2
    //   725: aload_2
    //   726: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   729: goto -123 -> 606
    //   732: astore_1
    //   733: goto -147 -> 586
    //   736: aload 6
    //   738: astore 7
    //   740: aload_1
    //   741: astore 6
    //   743: aload 7
    //   745: astore_1
    //   746: aload 6
    //   748: astore 7
    //   750: aload_1
    //   751: astore 6
    //   753: aload 7
    //   755: astore_1
    //   756: goto -608 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	759	0	this	FlashChatManager
    //   0	759	1	paramString1	String
    //   0	759	2	paramString2	String
    //   334	236	3	i	int
    //   532	28	4	l	long
    //   10	742	6	localObject1	Object
    //   81	673	7	localObject2	Object
    //   99	580	8	localObject3	Object
    //   4	652	9	localObject4	Object
    //   1	566	10	arrayOfByte	byte[]
    //   7	651	11	localObject5	Object
    //   113	410	12	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   128	45	13	localEnumeration	java.util.Enumeration
    //   182	343	14	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   522	531	576	finally
    //   537	549	576	finally
    //   564	573	576	finally
    //   611	616	576	finally
    //   619	624	576	finally
    //   627	632	576	finally
    //   645	663	673	finally
    //   688	693	702	java/io/IOException
    //   697	701	710	java/io/IOException
    //   591	596	716	java/io/IOException
    //   601	606	724	java/io/IOException
    //   105	115	732	finally
    //   123	130	732	finally
    //   138	145	732	finally
    //   155	165	732	finally
    //   172	184	732	finally
    //   191	198	732	finally
    //   210	221	732	finally
    //   228	255	732	finally
    //   262	270	732	finally
    //   277	288	732	finally
    //   295	303	732	finally
    //   310	316	732	finally
    //   326	335	732	finally
    //   342	351	732	finally
    //   358	375	732	finally
    //   382	393	732	finally
    //   400	408	732	finally
    //   415	421	732	finally
    //   428	458	732	finally
    //   465	476	732	finally
    //   483	491	732	finally
    //   498	504	732	finally
    //   511	522	732	finally
  }
  
  public static final int k(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkFlashChat)) {
      return 1;
    }
    if ((paramMessageRecord instanceof MessageForHiBoom)) {
      return 2;
    }
    if ((paramMessageRecord instanceof MessageForScribble)) {
      return 0;
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return 3;
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return 4;
    }
    return -1;
  }
  
  public static String lj(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    int k = paramString.length() - 1;
    int i = 0;
    while ((i <= k) && (paramString.charAt(i) == ' ')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (paramString.charAt(j) == ' '))
      {
        j -= 1;
      }
      else
      {
        if (i == 0)
        {
          str = paramString;
          if (j == k) {
            break;
          }
        }
        if (i <= j) {
          return paramString.substring(i, j + 1);
        }
        return "";
        j = k;
      }
    }
  }
  
  public static String lk(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  protected static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label47;
      }
    }
    label47:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label58;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label58:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void JU(String paramString)
  {
    this.kV.put(this.app.getCurrentAccountUin(), paramString);
  }
  
  public void JV(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "loadConfig l :" + paramString);
    }
    try
    {
      this.a = ((b)aeij.a(paramString, b.class));
      this.app.notifyObservers(ahei.class, 969, true, null);
      this.app.notifyObservers(ahei.class, 970, true, null);
      return;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("FlashChat", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
      }
    }
  }
  
  public void OY(int paramInt)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
    String str = "flashchat." + paramInt + ".cfg";
    this.fr.put(str, String.valueOf(paramInt));
    localVasQuickUpdateManager.downloadItem(1002L, str, "initChatResource");
  }
  
  public void V(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForArkFlashChat)) && (!paramChatMessage.isread)) {
      a((MessageForArkFlashChat)paramChatMessage);
    }
  }
  
  public ArkFlashChatMessage a(String paramString, int paramInt1, int paramInt2)
  {
    ArkFlashChatMessage localArkFlashChatMessage = null;
    Object localObject3;
    if (!aN(this.app)) {
      localObject3 = localArkFlashChatMessage;
    }
    do
    {
      do
      {
        return localObject3;
        localObject3 = localArkFlashChatMessage;
      } while (paramString == null);
      localObject3 = localArkFlashChatMessage;
    } while (TextUtils.isEmpty(paramString.trim()));
    for (;;)
    {
      try
      {
        localObject1 = this.ed;
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        localObject1 = (FlashChatItem)((Iterator)localObject3).next();
        if ((localObject1 == null) || (((FlashChatItem)localObject1).id != paramInt2)) {
          continue;
        }
        localObject3 = a(this.app, (FlashChatItem)localObject1);
        if (localObject3 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        Object localObject2 = null;
        continue;
      }
      localObject3 = localArkFlashChatMessage;
      if (localObject1 == null) {
        break;
      }
      localArkFlashChatMessage = new ArkFlashChatMessage();
      localArkFlashChatMessage.appMinVersion = ((FlashChatItem)localObject1).ver;
      localArkFlashChatMessage.appName = ((FlashChatItem)localObject1).appName;
      localArkFlashChatMessage.appView = ((FlashChatItem)localObject1).mainView;
      localArkFlashChatMessage.appDesc = ((FlashChatItem)localObject1).name;
      localArkFlashChatMessage.appResId = ((FlashChatItem)localObject1).id;
      localArkFlashChatMessage.promptText = paramString;
      localArkFlashChatMessage.config = "config";
      localObject3 = localArkFlashChatMessage;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FlashChat", 1, "sendMessage");
      return localArkFlashChatMessage;
      JU("");
      localObject1 = null;
    }
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord)
  {
    b localb = this.a;
    String str1 = localb.url;
    String str2 = localb.bKd;
    String str3 = localb.bKe;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "clickQIMSource clickAppMsg url = " + str1 + ", actionData = " + str2 + ", actionDataA = " + str3 + paramMessageRecord);
    }
    if (clickAppMsg(paramContext, str1, str2, str3, this.app)) {}
    while (!a(paramContext, str1, localb.name, paramMessageRecord)) {
      return;
    }
  }
  
  public void a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "setNeedAnim i");
    }
    if ((paramMessageForArkFlashChat != null) && ((this.c == null) || (this.c.uniseq != paramMessageForArkFlashChat.uniseq))) {
      if (paramMessageForArkFlashChat == null) {
        break label64;
      }
    }
    label64:
    for (Long localLong = Long.valueOf(paramMessageForArkFlashChat.uniseq);; localLong = null)
    {
      m(localLong);
      this.c = paramMessageForArkFlashChat;
      return;
    }
  }
  
  public void a(ArrayList<FlashChatItem> paramArrayList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 2, "onGetFlashItems begin " + paramBoolean);
    }
    if (paramArrayList != null)
    {
      if (paramBoolean) {
        this.b.b("FlashItems", paramArrayList);
      }
      paramArrayList.add(0, FlashChatItem.sDefaultItem);
      this.ed = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfByte = (FlashChatItem)paramArrayList.next();
        if (QLog.isColorLevel()) {
          QLog.i("FlashChat", 2, "onGetFlashItems item = " + paramArrayOfByte);
        }
        if ((paramArrayOfByte.id != -100001) && (paramArrayOfByte.id != -100000)) {
          i(paramArrayOfByte.id, paramArrayOfByte.appName, paramArrayOfByte.ver);
        }
      }
    }
  }
  
  public boolean a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    return (this.c != null) && (this.c.uniseq == paramMessageForArkFlashChat.uniseq);
  }
  
  public boolean aN(QQAppInterface paramQQAppInterface)
  {
    if (!aheq.a(paramQQAppInterface).aP(paramQQAppInterface)) {}
    do
    {
      return false;
      paramQQAppInterface = aheq.a(paramQQAppInterface).a(paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
    paramQQAppInterface = paramQQAppInterface.iterator();
    boolean bool = false;
    if (paramQQAppInterface.hasNext())
    {
      if (((Integer)paramQQAppInterface.next()).intValue() != 1) {
        break label72;
      }
      bool = true;
    }
    label72:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public boolean amX()
  {
    dmT();
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "isSwitchUser g " + this.a.entry + " u " + this.cgr);
    }
    return this.cgr;
  }
  
  public boolean amY()
  {
    boolean bool2 = false;
    b localb = this.a;
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localb.bKe)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean amZ()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.cgt;
    }
    return false;
  }
  
  public boolean ana()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.cgu;
    }
    return false;
  }
  
  public void b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if ((Long)this.fp.get(Long.valueOf(paramMessageForArkFlashChat.uniseq)) == null) {
      this.fp.put(Long.valueOf(paramMessageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
    }
    this.af.add(paramMessageForArkFlashChat);
  }
  
  public boolean b(int paramInt, MessageRecord paramMessageRecord)
  {
    SparseArray localSparseArray2 = cE;
    SparseArray localSparseArray1 = cF;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    long l1;
    if ((localSparseArray2 == null) || (localSparseArray1 == null))
    {
      localSparseArray2 = new SparseArray();
      localSparseArray1 = new SparseArray();
      localObject1 = this.app.getApp().getSharedPreferences("sp_flashchat_source", 0);
      localObject2 = this.lr;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        int m = ((SharedPreferences)localObject1).getInt("use_count_" + k, 0);
        l1 = ((SharedPreferences)localObject1).getLong("use_lasttime_" + k, 0L);
        localSparseArray2.put(k, Integer.valueOf(m));
        localSparseArray1.put(k, Long.valueOf(l1));
        i += 1;
      }
    }
    for (;;)
    {
      long l2;
      switch (paramInt)
      {
      default: 
        i = 0;
        l1 = 0L;
        j = 0;
        l2 = 0L;
        localObject1 = (Integer)localSparseArray2.get(paramInt);
        localObject2 = (Long)localSparseArray1.get(paramInt);
        if (localObject1 != null) {
          j = ((Integer)localObject1).intValue();
        }
        if (localObject2 != null) {
          l2 = ((Long)localObject2).longValue();
        }
        if ((j >= i) || (Math.abs(System.currentTimeMillis() - l2) <= l1)) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FlashChat", 2, "hasLeftCount type " + paramInt + " ," + bool + ", " + j + ", " + i + ", " + l2 + ", " + l1);
        }
        if (bool)
        {
          l1 = System.currentTimeMillis();
          localSparseArray2.put(paramInt, Integer.valueOf(j + 1));
          localSparseArray1.put(paramInt, Long.valueOf(l1));
          paramMessageRecord.saveExtInfoToExtStr("qim_source", "1");
          anot.a(this.app, "dc00898", "", "", "0X8008278", "0X8008278", paramInt, 0, "", "", "", "");
        }
        cE = localSparseArray2;
        cF = localSparseArray1;
        return bool;
        i = this.a.cZB;
        l1 = 0L;
        break;
        i = this.a.cZC;
        l1 = 0L;
        break;
        i = this.a.cZA;
        l1 = 0L;
        break;
        i = this.a.cZD;
        l1 = this.a.cZF;
        l1 *= 1000L;
        break;
        i = this.a.cZE;
        l1 = this.a.cZG;
        l1 *= 1000L;
        break;
      }
    }
  }
  
  public boolean b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    paramMessageForArkFlashChat = (Long)this.fp.get(Long.valueOf(paramMessageForArkFlashChat.uniseq));
    return (paramMessageForArkFlashChat != null) && (System.currentTimeMillis() - paramMessageForArkFlashChat.longValue() < 600L);
  }
  
  public boolean c(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    Iterator localIterator = this.af.iterator();
    while (localIterator.hasNext()) {
      if (((MessageForArkFlashChat)localIterator.next()).uniseq == paramMessageForArkFlashChat.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  public ArrayList<FlashChatItem> cS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getItemList");
    }
    if (this.ed == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(FlashChatItem.sDefaultItem);
      return localArrayList;
    }
    return this.ed;
  }
  
  public void dmT()
  {
    if (this.mLoaded) {}
    for (;;)
    {
      return;
      this.mLoaded = true;
      Object localObject1 = (aeju)aeif.a().o(168);
      if (localObject1 == null)
      {
        localObject1 = "";
        JV((String)localObject1);
      }
      try
      {
        localObject1 = (ArrayList)this.b.a("FlashItems", ArrayList.class, 0);
        a((ArrayList)localObject1, false, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("loadFromCacheOnce ");
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
          QLog.i("FlashChat", 2, localObject1);
          return;
          localObject1 = ((aeju)localObject1).byc;
        }
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageInstantiateException);
          Object localObject2 = null;
        }
      }
      catch (QStorageSafeDeleteException localQStorageSafeDeleteException)
      {
        for (;;)
        {
          QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageSafeDeleteException);
          String str = null;
          continue;
          str = "null";
        }
      }
    }
  }
  
  public void dmU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestAIOFlashItems");
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ahel.class);
    localNewIntent.putExtra("req_type", 1);
    this.app.startServlet(localNewIntent);
  }
  
  public void eK(String arg1, int paramInt)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "parseJson isMainThread scid " + ??? + " errCode " + paramInt);
    }
    if (??? != null)
    {
      if (!???.endsWith(".cfg")) {
        break label227;
      }
      str1 = (String)this.fr.get(???);
      if (paramInt == 0) {}
    }
    else
    {
      try
      {
        i = Integer.valueOf(str1).intValue();
        paramInt = i;
      }
      catch (Exception ???)
      {
        for (;;)
        {
          QLog.e("FlashChat", 2, "onCompleteDownload" + paramInt, ???);
          paramInt = -1;
        }
      }
      ??? = new Bundle();
      ???.putInt("resourceId", paramInt);
      this.app.notifyObservers(ahei.class, 968, false, ???);
    }
    label227:
    while (!???.endsWith(".zip"))
    {
      do
      {
        return;
        ??? = a.a(aqhq.readFileContent(new File(li(???))));
      } while ((??? == null) || (???.bKb == null) || (str1 == null));
      this.fq.put(???.bKb, str1);
      ((VasQuickUpdateManager)this.app.getManager(184)).downloadItem(1002L, ???.bKb, "FlashChatManager");
      return;
    }
    Object localObject3 = (String)this.fq.get(???);
    if (paramInt != 0)
    {
      try
      {
        int j = Integer.valueOf((String)localObject3).intValue();
        paramInt = j;
      }
      catch (Exception ???)
      {
        for (;;)
        {
          QLog.e("FlashChat", 2, "onCompleteDownload" + paramInt, ???);
          paramInt = i;
        }
      }
      ??? = new Bundle();
      ???.putInt("resourceId", paramInt);
      this.app.notifyObservers(ahei.class, 968, false, ???);
      return;
    }
    String str1 = li(???);
    ??? = lk(???);
    String str2 = getRootDir() + ??? + File.separator;
    this.cU.set(true);
    synchronized (str2.intern())
    {
      localFile = new File(str2);
      try
      {
        fn(str1, str2);
        paramInt = Integer.valueOf((String)localObject3).intValue();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("resourceId", paramInt);
        this.app.notifyObservers(ahei.class, 968, true, (Bundle)localObject3);
        new File(str1).delete();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (0 != 0) {
            throw new NullPointerException();
          }
          if (localFile != null) {
            localFile.delete();
          }
          this.cU.set(false);
        }
      }
      finally
      {
        this.cU.set(false);
      }
      return;
    }
  }
  
  public String getRootDir()
  {
    int i;
    if (this.rootDir == null)
    {
      localObject = BaseApplicationImpl.getContext();
      i = 0;
    }
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        localException.printStackTrace();
        continue;
        localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
      }
    }
    localStringBuilder = new StringBuilder();
    if (i != 0)
    {
      localObject = aqul.getSDKPrivatePath(acbn.SDCARD_PATH);
      this.rootDir = ((String)localObject + File.separator + "flashchat" + File.separator);
      new File(this.rootDir).mkdirs();
      return this.rootDir;
    }
  }
  
  public String i(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = (String)this.cD.get(paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + paramInt + " path " + (String)localObject1 + " version" + paramString2 + " name" + paramString1);
    }
    localObject1 = a.a(aqhq.readFileContent(new File(li("flashchat." + paramInt + ".cfg"))));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal cfg not exist ...");
      }
      return null;
    }
    Object localObject2 = getRootDir() + lk(((a)localObject1).bKb) + File.separator + paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal installPath: " + (String)localObject2 + "cfg info : " + localObject1);
    }
    localObject1 = new File((String)localObject2);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appDir not exist ...");
      }
      return null;
    }
    localObject2 = ((File)localObject1).listFiles();
    int i;
    if (localObject2 != null)
    {
      int j = localObject2.length;
      i = 0;
      label291:
      if (i < j)
      {
        localObject1 = localObject2[i];
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).getName().endsWith(".app")) || (!((File)localObject1).getName().contains(paramString2))) {}
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appFile not exist ...");
        }
        return null;
        i += 1;
        break label291;
      }
      localObject2 = ((File)localObject1).getAbsolutePath();
      if (localObject2 != null) {
        this.cD.put(paramInt, localObject2);
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + paramInt + " path " + (String)localObject2 + " version" + paramString2 + " name" + paramString1);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public String li(String paramString)
  {
    return getRootDir() + paramString;
  }
  
  public void m(Long paramLong)
  {
    Object localObject = (CopyOnWriteArrayList)this.af.clone();
    this.af.clear();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((Iterator)localObject).next();
        if ((paramLong == null) || (paramLong.longValue() != localMessageForArkFlashChat.uniseq))
        {
          String str = localMessageForArkFlashChat.ark_app_message.appName;
          ArkAppCenter.a().post(str, new FlashChatManager.2(this, localMessageForArkFlashChat));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.mLoaded = false;
    this.cgs = false;
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("sp_flashchat_source", 0).edit();
    SparseArray localSparseArray1 = cE;
    SparseArray localSparseArray2 = cF;
    if (localSparseArray1 != null)
    {
      int[] arrayOfInt = this.lr;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        Integer localInteger = (Integer)localSparseArray1.get(k);
        Long localLong = (Long)localSparseArray2.get(k);
        if (localInteger != null)
        {
          int m = localInteger.intValue();
          localEditor.putInt("use_count_" + k, m);
        }
        if (localLong != null) {
          localEditor.putLong("use_lasttime_" + k, localLong.longValue());
        }
        i += 1;
      }
    }
    localEditor.commit();
  }
  
  public String we()
  {
    String str2 = (String)this.kV.get(this.app.getCurrentAccountUin());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public String wf()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.bKg;
    }
    return "";
  }
  
  public static final class StopTask
    implements Runnable
  {
    public Long W;
    public CopyOnWriteArrayList<MessageForArkFlashChat> ag;
    
    public void run()
    {
      if (this.ag == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.ag.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)localIterator.next();
          if ((this.W == null) || (this.W.longValue() != localMessageForArkFlashChat.uniseq)) {
            localMessageForArkFlashChat.stopAnim();
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public String bKb;
    public String version;
    
    /* Error */
    public static a a(String paramString)
    {
      // Byte code:
      //   0: new 2	com/tencent/mobileqq/flashchat/FlashChatManager$a
      //   3: dup
      //   4: invokespecial 19	com/tencent/mobileqq/flashchat/FlashChatManager$a:<init>	()V
      //   7: astore_3
      //   8: new 21	org/json/JSONObject
      //   11: dup
      //   12: aload_0
      //   13: invokespecial 24	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   16: astore_0
      //   17: aload_0
      //   18: ldc 26
      //   20: invokevirtual 30	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   23: astore 4
      //   25: aload_3
      //   26: aload_0
      //   27: ldc 31
      //   29: invokevirtual 35	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   32: putfield 37	com/tencent/mobileqq/flashchat/FlashChatManager$a:version	Ljava/lang/String;
      //   35: aload 4
      //   37: ldc 39
      //   39: invokevirtual 43	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   42: astore_0
      //   43: iconst_0
      //   44: istore_1
      //   45: iload_1
      //   46: aload_0
      //   47: invokevirtual 49	org/json/JSONArray:length	()I
      //   50: if_icmpge +52 -> 102
      //   53: aload_0
      //   54: iload_1
      //   55: invokevirtual 52	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
      //   58: astore 4
      //   60: aload_3
      //   61: aload 4
      //   63: ldc 54
      //   65: invokevirtual 35	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   68: putfield 56	com/tencent/mobileqq/flashchat/FlashChatManager$a:bKb	Ljava/lang/String;
      //   71: aload 4
      //   73: ldc 58
      //   75: invokevirtual 61	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   78: astore 4
      //   80: aload 4
      //   82: ifnull +22 -> 104
      //   85: ldc 63
      //   87: aload 4
      //   89: ldc 65
      //   91: invokevirtual 68	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   94: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   97: istore_2
      //   98: iload_2
      //   99: ifeq +5 -> 104
      //   102: aload_3
      //   103: areturn
      //   104: iload_1
      //   105: iconst_1
      //   106: iadd
      //   107: istore_1
      //   108: goto -63 -> 45
      //   111: astore_0
      //   112: aload_0
      //   113: athrow
      //   114: astore_0
      //   115: aconst_null
      //   116: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	paramString	String
      //   44	64	1	i	int
      //   97	2	2	bool	boolean
      //   7	96	3	locala	a
      //   23	65	4	localJSONObject	JSONObject
      // Exception table:
      //   from	to	target	type
      //   0	43	111	finally
      //   45	80	111	finally
      //   85	98	111	finally
      //   0	43	114	java/lang/Exception
      //   45	80	114	java/lang/Exception
      //   85	98	114	java/lang/Exception
    }
    
    public String toString()
    {
      return "FlashPackCfg{version='" + this.version + '\'' + ", zipScid='" + this.bKb + '\'' + '}';
    }
  }
  
  public static class b
    implements aehx<String>
  {
    public String bKc = "";
    public String bKd = "";
    public String bKe = "";
    public String bKf = "1";
    public String bKg = "";
    public int cZA = 2;
    public int cZB = 2;
    public int cZC = 2;
    public int cZD = 3;
    public int cZE = 3;
    public int cZF = 60;
    public int cZG = 60;
    public boolean cgt;
    public boolean cgu;
    public String entry = "1";
    public String icon = "";
    public String name = "";
    public String url = "";
    
    public void lR(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.entry = paramString.optString("entry", "1");
        this.name = paramString.optString("name", null);
        this.icon = paramString.optString("icon", null);
        this.bKd = paramString.optString("actionI", null);
        this.bKe = paramString.optString("actionA", null);
        this.url = paramString.optString("url", null);
        this.cZA = paramString.optInt("scC", 2);
        this.cZB = paramString.optInt("hiC", 2);
        this.cZC = paramString.optInt("flC", 2);
        this.cZD = paramString.optInt("piC", 3);
        this.cZE = paramString.optInt("tvC", 3);
        this.bKf = paramString.optString("recordRule", "1");
        this.cZF = paramString.optInt("pIn", 60);
        this.cZG = paramString.optInt("tvI", 60);
        this.cgt = "1".equals(paramString.optString("qimNotifyEnable", "0"));
        this.cgu = "1".equals(paramString.optString("qimPopUpEnable", "0"));
        this.bKg = paramString.optString("qimNotifySource", "");
        this.bKc = paramString.optString("qimNotifyLogo", "");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("FlashChat", 1, "handleFlashChatConfig failed" + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager
 * JD-Core Version:    0.7.0.1
 */