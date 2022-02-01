package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import aeib;
import ajqp;
import android.text.TextUtils;
import aqdv;
import aqep;
import aqiw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static Object cH = new Object();
  private static final int[] kp = { 2130841275, 2130851797, 2130851798, 2130851799 };
  private MqqHandler D = new MqqHandler(ThreadManager.getSubThreadLooper());
  private QQAppInterface app;
  private FriendListHandler e;
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
    this.e = paramFriendListHandler;
  }
  
  private String a(QQHeadInfo paramQQHeadInfo, String paramString)
  {
    String str;
    if (paramQQHeadInfo.dstUsrType == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramQQHeadInfo.dstUsrType == 32) {
        return "stranger_" + Integer.toString(paramQQHeadInfo.idType) + "_" + paramString;
      }
      str = paramString;
    } while (paramQQHeadInfo.dstUsrType != 16);
    return "qcall_" + Integer.toString(paramQQHeadInfo.idType) + "_" + paramString;
  }
  
  private void a(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if ((paramBoolean2) || (!paramBoolean1))
    {
      if (paramQQHeadInfo.dstUsrType == 11) {
        this.e.notifyUI(39, true, new Object[] { paramString1 });
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 4)
    {
      this.e.notifyUI(30, true, new Object[] { paramString1 });
      this.app.k(4, paramString1, 0, paramString2);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.e.notifyUI(5, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      this.e.notifyUI(104, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), paramString3 });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.e.notifyUI(6, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      return;
    }
    this.app.k(1, paramString1, 0, paramString2);
    if (paramString1.equals(this.app.getCurrentAccountUin())) {
      this.app.l(1, paramString1, 0, paramString2);
    }
    this.e.notifyUI(4, true, new Object[] { paramString1 });
  }
  
  private void a(QQHeadInfo paramQQHeadInfo, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramQQHeadInfo.dstUsrType == 4) {
        this.app.y(4, paramString, paramQQHeadInfo.idType);
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.app.y(32, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.app.y(16, paramString, paramQQHeadInfo.idType);
      return;
    }
    this.app.y(1, paramString, paramQQHeadInfo.idType);
  }
  
  public static void cNP() {}
  
  /* Error */
  private void d(int paramInt, File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iload_1
    //   7: iflt +13 -> 20
    //   10: iload_1
    //   11: istore_3
    //   12: iload_1
    //   13: getstatic 28	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:kp	[I
    //   16: arraylength
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 151	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 28	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:kp	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 157	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 159	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 168	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 172	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 180
    //   95: iconst_2
    //   96: ldc 182
    //   98: aload 5
    //   100: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 189	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 189	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 189	java/io/InputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: goto -23 -> 145
    //   171: astore 6
    //   173: aload_2
    //   174: astore 5
    //   176: aload 6
    //   178: astore_2
    //   179: goto -34 -> 145
    //   182: astore 6
    //   184: aload_2
    //   185: astore 5
    //   187: aload 6
    //   189: astore_2
    //   190: goto -45 -> 145
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -110 -> 87
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -117 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QQHeadDownloadHandler
    //   0	207	1	paramInt	int
    //   0	207	2	paramFile	File
    //   11	25	3	i	int
    //   4	157	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   85	66	5	localException1	java.lang.Exception
    //   174	12	5	localFile	File
    //   193	1	5	localException2	java.lang.Exception
    //   200	1	5	localException3	java.lang.Exception
    //   40	36	6	localObject3	Object
    //   171	6	6	localObject4	Object
    //   182	6	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	85	java/lang/Exception
    //   74	82	85	java/lang/Exception
    //   22	42	141	finally
    //   46	62	167	finally
    //   62	70	171	finally
    //   74	82	171	finally
    //   87	103	182	finally
    //   22	42	193	java/lang/Exception
    //   46	62	200	java/lang/Exception
  }
  
  private int gG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 9207;
    case 1: 
      return 9206;
    case 4: 
      return 9202;
    case 33: 
      return 9208;
    }
    return 9204;
  }
  
  /* Error */
  protected void a(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	com/tencent/mobileqq/util/FaceInfo:b	LAvatarInfo/QQHeadInfo;
    //   4: astore 35
    //   6: aload_0
    //   7: getfield 57	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:e	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   10: aload 35
    //   12: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 35
    //   17: getfield 209	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 213	com/tencent/mobileqq/app/FriendListHandler:i	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 36
    //   25: aload_0
    //   26: getfield 57	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:e	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   29: iconst_0
    //   30: aload 36
    //   32: aload 35
    //   34: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 217	com/tencent/mobileqq/app/FriendListHandler:c	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 220	com/tencent/mobileqq/util/FaceInfo:dYF	I
    //   45: invokevirtual 224	com/tencent/mobileqq/util/FaceInfo:Xq	(I)V
    //   48: iconst_0
    //   49: istore 28
    //   51: iconst_0
    //   52: istore 29
    //   54: iconst_0
    //   55: istore 30
    //   57: iconst_0
    //   58: istore 27
    //   60: iconst_0
    //   61: istore 8
    //   63: iconst_0
    //   64: istore 5
    //   66: iconst_0
    //   67: istore 17
    //   69: iconst_0
    //   70: istore 18
    //   72: iconst_0
    //   73: istore 13
    //   75: iconst_0
    //   76: istore 6
    //   78: aload 35
    //   80: getfield 227	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   83: astore 33
    //   85: iconst_0
    //   86: istore 15
    //   88: iconst_0
    //   89: istore 12
    //   91: iconst_0
    //   92: istore 16
    //   94: iconst_0
    //   95: istore 9
    //   97: iconst_0
    //   98: istore 19
    //   100: iconst_0
    //   101: istore 4
    //   103: iconst_0
    //   104: istore 14
    //   106: iconst_0
    //   107: istore 21
    //   109: iconst_0
    //   110: istore 22
    //   112: iconst_0
    //   113: istore 20
    //   115: iconst_0
    //   116: istore_2
    //   117: iload 15
    //   119: istore 10
    //   121: iload 18
    //   123: istore 7
    //   125: aload 33
    //   127: astore 32
    //   129: iload 22
    //   131: istore_3
    //   132: iload 29
    //   134: istore 25
    //   136: aload 35
    //   138: getfield 227	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   141: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +2430 -> 2574
    //   147: iload 15
    //   149: istore 10
    //   151: iload 18
    //   153: istore 7
    //   155: aload 33
    //   157: astore 32
    //   159: iload 22
    //   161: istore_3
    //   162: iload 29
    //   164: istore 25
    //   166: aload_0
    //   167: aload 35
    //   169: aload 36
    //   171: aload_0
    //   172: aload 35
    //   174: aload 36
    //   176: invokespecial 235	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;)Ljava/lang/String;
    //   179: iconst_0
    //   180: invokevirtual 238	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/Object;
    //   183: astore 31
    //   185: iload 15
    //   187: istore 10
    //   189: iload 18
    //   191: istore 7
    //   193: aload 33
    //   195: astore 32
    //   197: iload 22
    //   199: istore_3
    //   200: iload 29
    //   202: istore 25
    //   204: aload 31
    //   206: iconst_0
    //   207: aaload
    //   208: checkcast 114	java/lang/Boolean
    //   211: invokevirtual 241	java/lang/Boolean:booleanValue	()Z
    //   214: istore 24
    //   216: iload 15
    //   218: istore 10
    //   220: iload 18
    //   222: istore 7
    //   224: aload 33
    //   226: astore 32
    //   228: iload 22
    //   230: istore_3
    //   231: iload 29
    //   233: istore 25
    //   235: aload 31
    //   237: iconst_1
    //   238: aaload
    //   239: checkcast 243	com/tencent/mobileqq/data/Setting
    //   242: astore 37
    //   244: iload 15
    //   246: istore 10
    //   248: iload 18
    //   250: istore 7
    //   252: aload 33
    //   254: astore 32
    //   256: iload 22
    //   258: istore_3
    //   259: iload 29
    //   261: istore 25
    //   263: aload_0
    //   264: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   270: invokevirtual 253	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   273: invokestatic 259	aqgu:bO	(Landroid/content/Context;)Z
    //   276: ifeq +128 -> 404
    //   279: iload 15
    //   281: istore 10
    //   283: iload 18
    //   285: istore 7
    //   287: aload 33
    //   289: astore 32
    //   291: iload 22
    //   293: istore_3
    //   294: iload 29
    //   296: istore 25
    //   298: invokestatic 264	aqfo:isExistSDCard	()Z
    //   301: ifeq +103 -> 404
    //   304: iload 15
    //   306: istore 10
    //   308: iload 18
    //   310: istore 7
    //   312: aload 33
    //   314: astore 32
    //   316: iload 22
    //   318: istore_3
    //   319: iload 29
    //   321: istore 25
    //   323: getstatic 35	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:cH	Ljava/lang/Object;
    //   326: astore 31
    //   328: iload 15
    //   330: istore 10
    //   332: iload 18
    //   334: istore 7
    //   336: aload 33
    //   338: astore 32
    //   340: iload 22
    //   342: istore_3
    //   343: iload 29
    //   345: istore 25
    //   347: aload 31
    //   349: monitorenter
    //   350: aload_0
    //   351: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   354: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   357: invokevirtual 253	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   360: invokestatic 259	aqgu:bO	(Landroid/content/Context;)Z
    //   363: ifeq +24 -> 387
    //   366: invokestatic 264	aqfo:isExistSDCard	()Z
    //   369: istore 23
    //   371: iload 23
    //   373: ifeq +14 -> 387
    //   376: ldc_w 266
    //   379: getstatic 271	acbn:bmC	Ljava/lang/String;
    //   382: iconst_1
    //   383: invokestatic 276	aqhq:c	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   386: pop
    //   387: aload_0
    //   388: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   391: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   394: invokevirtual 253	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   397: iconst_0
    //   398: invokestatic 280	aqgu:H	(Landroid/content/Context;Z)V
    //   401: aload 31
    //   403: monitorexit
    //   404: iload 15
    //   406: istore 10
    //   408: iload 18
    //   410: istore 7
    //   412: aload 33
    //   414: astore 32
    //   416: iload 22
    //   418: istore_3
    //   419: iload 29
    //   421: istore 25
    //   423: aload_0
    //   424: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: aload 37
    //   429: aload 35
    //   431: getfield 86	AvatarInfo/QQHeadInfo:idType	I
    //   434: invokevirtual 283	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;I)Ljava/lang/String;
    //   437: astore 31
    //   439: iload 15
    //   441: istore 10
    //   443: iload 18
    //   445: istore 7
    //   447: aload 33
    //   449: astore 32
    //   451: iload 22
    //   453: istore_3
    //   454: iload 29
    //   456: istore 25
    //   458: new 285	java/io/File
    //   461: dup
    //   462: aload 31
    //   464: iconst_0
    //   465: aload 31
    //   467: ldc_w 287
    //   470: invokevirtual 291	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   473: invokevirtual 295	java/lang/String:substring	(II)Ljava/lang/String;
    //   476: invokespecial 298	java/io/File:<init>	(Ljava/lang/String;)V
    //   479: astore 34
    //   481: aload 34
    //   483: ifnull +55 -> 538
    //   486: iload 15
    //   488: istore 10
    //   490: iload 18
    //   492: istore 7
    //   494: aload 33
    //   496: astore 32
    //   498: iload 22
    //   500: istore_3
    //   501: iload 29
    //   503: istore 25
    //   505: aload 34
    //   507: invokevirtual 301	java/io/File:exists	()Z
    //   510: ifne +28 -> 538
    //   513: iload 15
    //   515: istore 10
    //   517: iload 18
    //   519: istore 7
    //   521: aload 33
    //   523: astore 32
    //   525: iload 22
    //   527: istore_3
    //   528: iload 29
    //   530: istore 25
    //   532: aload 34
    //   534: invokevirtual 304	java/io/File:mkdirs	()Z
    //   537: pop
    //   538: iload 15
    //   540: istore 10
    //   542: iload 18
    //   544: istore 7
    //   546: aload 33
    //   548: astore 32
    //   550: iload 22
    //   552: istore_3
    //   553: iload 29
    //   555: istore 25
    //   557: new 285	java/io/File
    //   560: dup
    //   561: aload 31
    //   563: invokespecial 298	java/io/File:<init>	(Ljava/lang/String;)V
    //   566: astore 38
    //   568: iload 24
    //   570: istore 23
    //   572: iload 24
    //   574: ifne +37 -> 611
    //   577: iload 15
    //   579: istore 10
    //   581: iload 18
    //   583: istore 7
    //   585: aload 33
    //   587: astore 32
    //   589: iload 22
    //   591: istore_3
    //   592: iload 29
    //   594: istore 25
    //   596: aload 38
    //   598: invokevirtual 301	java/io/File:exists	()Z
    //   601: istore 23
    //   603: iload 23
    //   605: ifne +933 -> 1538
    //   608: iconst_1
    //   609: istore 23
    //   611: iload 23
    //   613: ifeq +1454 -> 2067
    //   616: iload 16
    //   618: istore 11
    //   620: iload 17
    //   622: istore 8
    //   624: aload 33
    //   626: astore 34
    //   628: iload 21
    //   630: istore 4
    //   632: iload 28
    //   634: istore 26
    //   636: iload 15
    //   638: istore 10
    //   640: iload 18
    //   642: istore 7
    //   644: aload 33
    //   646: astore 32
    //   648: iload 22
    //   650: istore_3
    //   651: iload 29
    //   653: istore 25
    //   655: aload_0
    //   656: aload 35
    //   658: getfield 227	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   661: aload 35
    //   663: getfield 307	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   666: aload 35
    //   668: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   671: aload 35
    //   673: getfield 310	AvatarInfo/QQHeadInfo:originUsrType	I
    //   676: invokevirtual 313	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   679: astore 33
    //   681: iload 16
    //   683: istore 11
    //   685: iload 17
    //   687: istore 8
    //   689: aload 33
    //   691: astore 34
    //   693: iload 21
    //   695: istore 4
    //   697: iload 28
    //   699: istore 26
    //   701: iload 15
    //   703: istore 10
    //   705: iload 18
    //   707: istore 7
    //   709: aload 33
    //   711: astore 32
    //   713: iload 22
    //   715: istore_3
    //   716: iload 29
    //   718: istore 25
    //   720: ldc_w 315
    //   723: aload 33
    //   725: invokestatic 321	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   728: astore 33
    //   730: iload 16
    //   732: istore 11
    //   734: iload 17
    //   736: istore 8
    //   738: aload 33
    //   740: astore 34
    //   742: iload 21
    //   744: istore 4
    //   746: iload 28
    //   748: istore 26
    //   750: iload 15
    //   752: istore 10
    //   754: iload 18
    //   756: istore 7
    //   758: aload 33
    //   760: astore 32
    //   762: iload 22
    //   764: istore_3
    //   765: iload 29
    //   767: istore 25
    //   769: new 69	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   776: aload 33
    //   778: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc_w 323
    //   784: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   790: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   793: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: astore 33
    //   798: aload 35
    //   800: getfield 335	AvatarInfo/QQHeadInfo:cHeadType	B
    //   803: ifne +829 -> 1632
    //   806: aload 35
    //   808: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   811: istore_3
    //   812: iload_3
    //   813: iconst_4
    //   814: if_icmpne +818 -> 1632
    //   817: aload 38
    //   819: invokevirtual 301	java/io/File:exists	()Z
    //   822: ifne +14 -> 836
    //   825: aload_0
    //   826: aload 35
    //   828: getfield 339	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   831: aload 38
    //   833: invokespecial 341	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:d	(ILjava/io/File;)V
    //   836: iconst_1
    //   837: istore 24
    //   839: iload 12
    //   841: istore 5
    //   843: iload 9
    //   845: istore 11
    //   847: iload 6
    //   849: istore 8
    //   851: aload 33
    //   853: astore 34
    //   855: iload_2
    //   856: istore 4
    //   858: iload 24
    //   860: istore 26
    //   862: iload 5
    //   864: istore 10
    //   866: iload 6
    //   868: istore 7
    //   870: aload 33
    //   872: astore 32
    //   874: iload_2
    //   875: istore_3
    //   876: iload 24
    //   878: istore 25
    //   880: aload_0
    //   881: aload 35
    //   883: aload 36
    //   885: iload 24
    //   887: invokespecial 343	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Z)V
    //   890: iload 6
    //   892: istore 4
    //   894: aload 33
    //   896: astore_1
    //   897: iload_2
    //   898: istore_3
    //   899: iload 5
    //   901: istore_2
    //   902: iload 9
    //   904: istore 5
    //   906: aload_0
    //   907: aload 35
    //   909: aload 36
    //   911: aload 31
    //   913: iload 23
    //   915: iload 24
    //   917: aload_1
    //   918: invokespecial 345	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    //   921: iload 24
    //   923: istore 25
    //   925: aload_1
    //   926: astore 33
    //   928: iload 4
    //   930: istore 6
    //   932: aload 31
    //   934: astore_1
    //   935: iload 23
    //   937: istore 24
    //   939: iload 25
    //   941: istore 23
    //   943: iload 5
    //   945: istore 4
    //   947: iload_3
    //   948: istore 5
    //   950: iload 6
    //   952: istore_3
    //   953: new 6	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   956: dup
    //   957: aload_0
    //   958: iload_2
    //   959: aload 36
    //   961: aload 35
    //   963: getfield 86	AvatarInfo/QQHeadInfo:idType	I
    //   966: aload 35
    //   968: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   971: iconst_4
    //   972: iload_3
    //   973: aload 33
    //   975: iload 5
    //   977: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   980: invokespecial 348	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   983: aconst_null
    //   984: iconst_0
    //   985: invokestatic 352	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   988: aload_0
    //   989: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: sipush 199
    //   995: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   998: checkcast 358	aczr
    //   1001: astore 31
    //   1003: iload_2
    //   1004: istore_3
    //   1005: aload 33
    //   1007: astore 32
    //   1009: iload 4
    //   1011: istore 5
    //   1013: iload 23
    //   1015: istore 25
    //   1017: iload 24
    //   1019: istore 26
    //   1021: aload_1
    //   1022: astore 34
    //   1024: iload 23
    //   1026: ifne +92 -> 1118
    //   1029: iload_2
    //   1030: istore_3
    //   1031: aload 33
    //   1033: astore 32
    //   1035: iload 4
    //   1037: istore 5
    //   1039: iload 23
    //   1041: istore 25
    //   1043: iload 24
    //   1045: istore 26
    //   1047: aload_1
    //   1048: astore 34
    //   1050: aload 31
    //   1052: ifnull +66 -> 1118
    //   1055: iload_2
    //   1056: istore_3
    //   1057: aload 33
    //   1059: astore 32
    //   1061: iload 4
    //   1063: istore 5
    //   1065: iload 23
    //   1067: istore 25
    //   1069: iload 24
    //   1071: istore 26
    //   1073: aload_1
    //   1074: astore 34
    //   1076: aload 31
    //   1078: invokevirtual 361	aczr:adh	()Z
    //   1081: ifeq +37 -> 1118
    //   1084: aload 31
    //   1086: aload 35
    //   1088: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   1091: invokestatic 364	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1094: invokevirtual 367	aczr:Gg	(Ljava/lang/String;)V
    //   1097: aload_1
    //   1098: astore 34
    //   1100: iload 24
    //   1102: istore 26
    //   1104: iload 23
    //   1106: istore 25
    //   1108: iload 4
    //   1110: istore 5
    //   1112: aload 33
    //   1114: astore 32
    //   1116: iload_2
    //   1117: istore_3
    //   1118: ldc 180
    //   1120: iconst_2
    //   1121: new 69	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1128: ldc_w 369
    //   1131: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: iload 25
    //   1136: invokevirtual 372	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1139: ldc_w 374
    //   1142: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: iload_3
    //   1146: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1149: ldc_w 379
    //   1152: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: aload 35
    //   1157: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   1160: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1163: ldc_w 381
    //   1166: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: iload 26
    //   1171: invokevirtual 372	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1174: ldc_w 383
    //   1177: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: aload 35
    //   1182: getfield 209	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1185: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: ldc_w 385
    //   1191: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: aload 35
    //   1196: getfield 335	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1199: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc_w 387
    //   1205: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: aload 35
    //   1210: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1213: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1216: ldc_w 389
    //   1219: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload 35
    //   1224: getfield 339	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1227: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1230: ldc_w 391
    //   1233: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: iload 5
    //   1238: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1241: ldc_w 393
    //   1244: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: aload 35
    //   1249: getfield 396	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1252: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1255: ldc_w 398
    //   1258: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: aload 34
    //   1263: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: ldc_w 400
    //   1269: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: aload 32
    //   1274: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: ldc_w 402
    //   1280: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: aload 35
    //   1285: getfield 227	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1288: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: ldc_w 404
    //   1294: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload 35
    //   1299: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1302: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1305: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1308: return
    //   1309: astore 32
    //   1311: aload 32
    //   1313: invokevirtual 413	java/lang/Exception:printStackTrace	()V
    //   1316: goto -929 -> 387
    //   1319: astore_1
    //   1320: aload 31
    //   1322: monitorexit
    //   1323: iload 15
    //   1325: istore 10
    //   1327: iload 18
    //   1329: istore 7
    //   1331: aload 33
    //   1333: astore 32
    //   1335: iload 22
    //   1337: istore_3
    //   1338: iload 29
    //   1340: istore 25
    //   1342: aload_1
    //   1343: athrow
    //   1344: astore_1
    //   1345: iconst_0
    //   1346: istore_2
    //   1347: iconst_0
    //   1348: istore 23
    //   1350: aconst_null
    //   1351: astore_1
    //   1352: iload 14
    //   1354: istore_3
    //   1355: aload 33
    //   1357: astore 31
    //   1359: iload 5
    //   1361: istore 8
    //   1363: sipush 9204
    //   1366: istore 4
    //   1368: new 6	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1371: dup
    //   1372: aload_0
    //   1373: sipush 9204
    //   1376: aload 36
    //   1378: aload 35
    //   1380: getfield 86	AvatarInfo/QQHeadInfo:idType	I
    //   1383: aload 35
    //   1385: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1388: iconst_4
    //   1389: iload 8
    //   1391: aload 31
    //   1393: iload_3
    //   1394: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   1397: invokespecial 348	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   1400: aconst_null
    //   1401: iconst_0
    //   1402: invokestatic 352	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1405: aload_0
    //   1406: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1409: sipush 199
    //   1412: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1415: checkcast 358	aczr
    //   1418: astore 33
    //   1420: iload 4
    //   1422: istore_3
    //   1423: aload 31
    //   1425: astore 32
    //   1427: iload_2
    //   1428: istore 5
    //   1430: iload 23
    //   1432: istore 25
    //   1434: iload 24
    //   1436: istore 26
    //   1438: aload_1
    //   1439: astore 34
    //   1441: iload 23
    //   1443: ifne -325 -> 1118
    //   1446: iload 4
    //   1448: istore_3
    //   1449: aload 31
    //   1451: astore 32
    //   1453: iload_2
    //   1454: istore 5
    //   1456: iload 23
    //   1458: istore 25
    //   1460: iload 24
    //   1462: istore 26
    //   1464: aload_1
    //   1465: astore 34
    //   1467: aload 33
    //   1469: ifnull -351 -> 1118
    //   1472: iload 4
    //   1474: istore_3
    //   1475: aload 31
    //   1477: astore 32
    //   1479: iload_2
    //   1480: istore 5
    //   1482: iload 23
    //   1484: istore 25
    //   1486: iload 24
    //   1488: istore 26
    //   1490: aload_1
    //   1491: astore 34
    //   1493: aload 33
    //   1495: invokevirtual 361	aczr:adh	()Z
    //   1498: ifeq -380 -> 1118
    //   1501: aload 33
    //   1503: aload 35
    //   1505: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   1508: invokestatic 364	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1511: invokevirtual 367	aczr:Gg	(Ljava/lang/String;)V
    //   1514: iload 4
    //   1516: istore_3
    //   1517: aload 31
    //   1519: astore 32
    //   1521: iload_2
    //   1522: istore 5
    //   1524: iload 23
    //   1526: istore 25
    //   1528: iload 24
    //   1530: istore 26
    //   1532: aload_1
    //   1533: astore 34
    //   1535: goto -417 -> 1118
    //   1538: iconst_0
    //   1539: istore 23
    //   1541: goto -930 -> 611
    //   1544: astore_1
    //   1545: new 6	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1548: dup
    //   1549: aload_0
    //   1550: sipush 9202
    //   1553: aload 36
    //   1555: aload 35
    //   1557: getfield 86	AvatarInfo/QQHeadInfo:idType	I
    //   1560: aload 35
    //   1562: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1565: iconst_4
    //   1566: iconst_0
    //   1567: aload 33
    //   1569: iconst_0
    //   1570: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   1573: invokespecial 348	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   1576: aconst_null
    //   1577: iconst_0
    //   1578: invokestatic 352	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1581: aload_0
    //   1582: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1585: sipush 199
    //   1588: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1591: checkcast 358	aczr
    //   1594: astore_1
    //   1595: aload_1
    //   1596: ifnull -288 -> 1308
    //   1599: aload_1
    //   1600: invokevirtual 361	aczr:adh	()Z
    //   1603: ifeq -295 -> 1308
    //   1606: aload_1
    //   1607: aload 35
    //   1609: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   1612: invokestatic 364	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1615: invokevirtual 367	aczr:Gg	(Ljava/lang/String;)V
    //   1618: return
    //   1619: astore_1
    //   1620: sipush 9202
    //   1623: istore 5
    //   1625: iload 27
    //   1627: istore 24
    //   1629: goto -786 -> 843
    //   1632: aload_0
    //   1633: aload 33
    //   1635: aload 38
    //   1637: aload_1
    //   1638: iconst_0
    //   1639: invokevirtual 416	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   1642: istore_2
    //   1643: iload_2
    //   1644: ifeq +927 -> 2571
    //   1647: iconst_1
    //   1648: invokestatic 422	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   1651: iconst_3
    //   1652: if_icmpne +919 -> 2571
    //   1655: aload_0
    //   1656: aload 35
    //   1658: getfield 227	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1661: aload 35
    //   1663: getfield 307	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   1666: aload 35
    //   1668: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1671: aload 35
    //   1673: getfield 310	AvatarInfo/QQHeadInfo:originUsrType	I
    //   1676: iconst_1
    //   1677: invokevirtual 425	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   1680: astore 32
    //   1682: aload 32
    //   1684: astore 33
    //   1686: aload 33
    //   1688: astore 32
    //   1690: aload 33
    //   1692: astore 34
    //   1694: ldc_w 315
    //   1697: aload 33
    //   1699: invokestatic 321	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1702: astore 33
    //   1704: aload 33
    //   1706: astore 32
    //   1708: aload 33
    //   1710: astore 34
    //   1712: new 69	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1719: aload 33
    //   1721: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: ldc_w 323
    //   1727: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   1733: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1736: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: astore 33
    //   1741: aload 33
    //   1743: astore 32
    //   1745: aload 33
    //   1747: astore 34
    //   1749: aload_0
    //   1750: aload 33
    //   1752: aload 38
    //   1754: aload_1
    //   1755: iconst_0
    //   1756: invokevirtual 416	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/util/FaceInfo;Z)I
    //   1759: istore_3
    //   1760: iload_3
    //   1761: istore_2
    //   1762: iload 16
    //   1764: istore 11
    //   1766: iload 17
    //   1768: istore 8
    //   1770: aload 33
    //   1772: astore 34
    //   1774: iload_2
    //   1775: istore 4
    //   1777: iload 28
    //   1779: istore 26
    //   1781: iload 15
    //   1783: istore 10
    //   1785: iload 18
    //   1787: istore 7
    //   1789: aload 33
    //   1791: astore 32
    //   1793: iload_2
    //   1794: istore_3
    //   1795: iload 29
    //   1797: istore 25
    //   1799: ldc 180
    //   1801: iconst_1
    //   1802: new 69	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1809: ldc_w 427
    //   1812: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: aload 33
    //   1817: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: ldc_w 429
    //   1823: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: iload_2
    //   1827: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1830: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1833: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1836: iload_2
    //   1837: ifne +191 -> 2028
    //   1840: iload 16
    //   1842: istore 11
    //   1844: iload 17
    //   1846: istore 8
    //   1848: aload 33
    //   1850: astore 34
    //   1852: iload_2
    //   1853: istore 4
    //   1855: iload 28
    //   1857: istore 26
    //   1859: iload 15
    //   1861: istore 10
    //   1863: iload 18
    //   1865: istore 7
    //   1867: aload 33
    //   1869: astore 32
    //   1871: iload_2
    //   1872: istore_3
    //   1873: iload 29
    //   1875: istore 25
    //   1877: aload 38
    //   1879: invokevirtual 432	java/io/File:length	()J
    //   1882: l2i
    //   1883: istore 6
    //   1885: iconst_1
    //   1886: istore 27
    //   1888: iconst_1
    //   1889: istore 28
    //   1891: iconst_1
    //   1892: istore 24
    //   1894: iload 16
    //   1896: istore 11
    //   1898: iload 6
    //   1900: istore 8
    //   1902: aload 33
    //   1904: astore 34
    //   1906: iload_2
    //   1907: istore 4
    //   1909: iload 27
    //   1911: istore 26
    //   1913: iload 15
    //   1915: istore 10
    //   1917: iload 6
    //   1919: istore 7
    //   1921: aload 33
    //   1923: astore 32
    //   1925: iload_2
    //   1926: istore_3
    //   1927: iload 28
    //   1929: istore 25
    //   1931: aload_0
    //   1932: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1935: aload 37
    //   1937: invokevirtual 435	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   1940: iload 16
    //   1942: istore 11
    //   1944: iload 6
    //   1946: istore 8
    //   1948: aload 33
    //   1950: astore 34
    //   1952: iload_2
    //   1953: istore 4
    //   1955: iload 27
    //   1957: istore 26
    //   1959: iload 15
    //   1961: istore 10
    //   1963: iload 6
    //   1965: istore 7
    //   1967: aload 33
    //   1969: astore 32
    //   1971: iload_2
    //   1972: istore_3
    //   1973: iload 28
    //   1975: istore 25
    //   1977: aload_0
    //   1978: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:D	Lmqq/os/MqqHandler;
    //   1981: new 9	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   1984: dup
    //   1985: aload_0
    //   1986: aload 37
    //   1988: aload_1
    //   1989: invokespecial 438	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   1992: invokevirtual 442	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   1995: pop
    //   1996: iload 12
    //   1998: istore 5
    //   2000: goto -1157 -> 843
    //   2003: astore_1
    //   2004: iload 11
    //   2006: istore_2
    //   2007: aload 31
    //   2009: astore_1
    //   2010: iload 23
    //   2012: istore 24
    //   2014: aload 34
    //   2016: astore 31
    //   2018: iload 4
    //   2020: istore_3
    //   2021: iload 26
    //   2023: istore 23
    //   2025: goto -662 -> 1363
    //   2028: iload 15
    //   2030: istore 10
    //   2032: iload 18
    //   2034: istore 7
    //   2036: aload 33
    //   2038: astore 32
    //   2040: iload_2
    //   2041: istore_3
    //   2042: iload 29
    //   2044: istore 25
    //   2046: aload_0
    //   2047: iload_2
    //   2048: invokespecial 444	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:gG	(I)I
    //   2051: istore 4
    //   2053: iload 4
    //   2055: istore 5
    //   2057: iload_2
    //   2058: istore 9
    //   2060: iload 27
    //   2062: istore 24
    //   2064: goto -1221 -> 843
    //   2067: iload 16
    //   2069: istore 11
    //   2071: iload 17
    //   2073: istore 8
    //   2075: aload 33
    //   2077: astore 34
    //   2079: iload 21
    //   2081: istore 4
    //   2083: iload 28
    //   2085: istore 26
    //   2087: iload 15
    //   2089: istore 10
    //   2091: iload 18
    //   2093: istore 7
    //   2095: aload 33
    //   2097: astore 32
    //   2099: iload 22
    //   2101: istore_3
    //   2102: iload 29
    //   2104: istore 25
    //   2106: aload_0
    //   2107: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2110: aload 37
    //   2112: invokevirtual 435	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   2115: iload 16
    //   2117: istore 11
    //   2119: iload 17
    //   2121: istore 8
    //   2123: aload 33
    //   2125: astore 34
    //   2127: iload 21
    //   2129: istore 4
    //   2131: iload 28
    //   2133: istore 26
    //   2135: iload 15
    //   2137: istore 10
    //   2139: iload 18
    //   2141: istore 7
    //   2143: aload 33
    //   2145: astore 32
    //   2147: iload 22
    //   2149: istore_3
    //   2150: iload 29
    //   2152: istore 25
    //   2154: aload_0
    //   2155: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:D	Lmqq/os/MqqHandler;
    //   2158: new 9	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2161: dup
    //   2162: aload_0
    //   2163: aload 37
    //   2165: aload_1
    //   2166: invokespecial 438	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   2169: invokevirtual 442	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2172: pop
    //   2173: iconst_0
    //   2174: istore 5
    //   2176: iconst_0
    //   2177: istore 4
    //   2179: aload 33
    //   2181: astore_1
    //   2182: iconst_0
    //   2183: istore_2
    //   2184: iconst_0
    //   2185: istore 24
    //   2187: iload 19
    //   2189: istore_3
    //   2190: goto -1284 -> 906
    //   2193: astore_1
    //   2194: iload 10
    //   2196: istore_2
    //   2197: new 6	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2200: dup
    //   2201: aload_0
    //   2202: iload_2
    //   2203: aload 36
    //   2205: aload 35
    //   2207: getfield 86	AvatarInfo/QQHeadInfo:idType	I
    //   2210: aload 35
    //   2212: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2215: iconst_4
    //   2216: iload 7
    //   2218: aload 32
    //   2220: iload_3
    //   2221: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   2224: invokespecial 348	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   2227: aconst_null
    //   2228: iconst_0
    //   2229: invokestatic 352	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2232: aload_0
    //   2233: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2236: sipush 199
    //   2239: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2242: checkcast 358	aczr
    //   2245: astore 31
    //   2247: iload 25
    //   2249: ifne +29 -> 2278
    //   2252: aload 31
    //   2254: ifnull +24 -> 2278
    //   2257: aload 31
    //   2259: invokevirtual 361	aczr:adh	()Z
    //   2262: ifeq +16 -> 2278
    //   2265: aload 31
    //   2267: aload 35
    //   2269: getfield 205	AvatarInfo/QQHeadInfo:uin	J
    //   2272: invokestatic 364	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2275: invokevirtual 367	aczr:Gg	(Ljava/lang/String;)V
    //   2278: aload_1
    //   2279: athrow
    //   2280: astore_1
    //   2281: iconst_0
    //   2282: istore_2
    //   2283: aload 33
    //   2285: astore 32
    //   2287: iload 13
    //   2289: istore 7
    //   2291: iload 20
    //   2293: istore_3
    //   2294: iload 30
    //   2296: istore 25
    //   2298: goto -101 -> 2197
    //   2301: astore_1
    //   2302: iload_2
    //   2303: istore_3
    //   2304: iconst_0
    //   2305: istore_2
    //   2306: aload 33
    //   2308: astore 32
    //   2310: iload 13
    //   2312: istore 7
    //   2314: iload 30
    //   2316: istore 25
    //   2318: goto -121 -> 2197
    //   2321: astore_1
    //   2322: iload_2
    //   2323: istore_3
    //   2324: iconst_0
    //   2325: istore_2
    //   2326: iload 13
    //   2328: istore 7
    //   2330: iload 30
    //   2332: istore 25
    //   2334: goto -137 -> 2197
    //   2337: astore 31
    //   2339: iload 4
    //   2341: istore 7
    //   2343: aload_1
    //   2344: astore 32
    //   2346: aload 31
    //   2348: astore_1
    //   2349: iload 24
    //   2351: istore 25
    //   2353: goto -156 -> 2197
    //   2356: astore_1
    //   2357: iconst_0
    //   2358: istore_2
    //   2359: iconst_0
    //   2360: istore 23
    //   2362: aconst_null
    //   2363: astore_1
    //   2364: iconst_0
    //   2365: istore 24
    //   2367: iload 5
    //   2369: istore 8
    //   2371: aload 33
    //   2373: astore 31
    //   2375: iload 14
    //   2377: istore_3
    //   2378: goto -1015 -> 1363
    //   2381: astore_1
    //   2382: iconst_0
    //   2383: istore_2
    //   2384: iconst_0
    //   2385: istore 23
    //   2387: aload 31
    //   2389: astore_1
    //   2390: iload 5
    //   2392: istore 8
    //   2394: aload 33
    //   2396: astore 31
    //   2398: iload 14
    //   2400: istore_3
    //   2401: goto -1038 -> 1363
    //   2404: astore_1
    //   2405: iconst_0
    //   2406: istore_2
    //   2407: iconst_0
    //   2408: istore 25
    //   2410: iload 23
    //   2412: istore 24
    //   2414: aload 31
    //   2416: astore_1
    //   2417: iload 5
    //   2419: istore 8
    //   2421: aload 33
    //   2423: astore 31
    //   2425: iload 14
    //   2427: istore_3
    //   2428: iload 25
    //   2430: istore 23
    //   2432: goto -1069 -> 1363
    //   2435: astore_1
    //   2436: iconst_0
    //   2437: istore 4
    //   2439: iconst_0
    //   2440: istore 25
    //   2442: iload 23
    //   2444: istore 24
    //   2446: aload 31
    //   2448: astore_1
    //   2449: iload 5
    //   2451: istore 8
    //   2453: aload 33
    //   2455: astore 31
    //   2457: iload_2
    //   2458: istore_3
    //   2459: iload 4
    //   2461: istore_2
    //   2462: iload 25
    //   2464: istore 23
    //   2466: goto -1103 -> 1363
    //   2469: astore_1
    //   2470: iconst_0
    //   2471: istore 4
    //   2473: iconst_0
    //   2474: istore 25
    //   2476: aload 31
    //   2478: astore_1
    //   2479: iload 23
    //   2481: istore 24
    //   2483: iload 5
    //   2485: istore 8
    //   2487: aload 34
    //   2489: astore 31
    //   2491: iload_2
    //   2492: istore_3
    //   2493: iload 4
    //   2495: istore_2
    //   2496: iload 25
    //   2498: istore 23
    //   2500: goto -1137 -> 1363
    //   2503: astore_1
    //   2504: iload_2
    //   2505: istore 4
    //   2507: iconst_0
    //   2508: istore 25
    //   2510: aload 31
    //   2512: astore_1
    //   2513: iload 23
    //   2515: istore 24
    //   2517: iload 5
    //   2519: istore 8
    //   2521: aload 33
    //   2523: astore 31
    //   2525: iload_2
    //   2526: istore_3
    //   2527: iload 4
    //   2529: istore_2
    //   2530: iload 25
    //   2532: istore 23
    //   2534: goto -1171 -> 1363
    //   2537: astore 32
    //   2539: iload 5
    //   2541: istore_2
    //   2542: iload 23
    //   2544: istore 25
    //   2546: aload 31
    //   2548: astore 32
    //   2550: iload 4
    //   2552: istore 8
    //   2554: aload_1
    //   2555: astore 31
    //   2557: iload 24
    //   2559: istore 23
    //   2561: iload 25
    //   2563: istore 24
    //   2565: aload 32
    //   2567: astore_1
    //   2568: goto -1205 -> 1363
    //   2571: goto -735 -> 1836
    //   2574: iconst_0
    //   2575: istore 6
    //   2577: iconst_0
    //   2578: istore 23
    //   2580: aconst_null
    //   2581: astore_1
    //   2582: iconst_0
    //   2583: istore 24
    //   2585: iconst_0
    //   2586: istore_2
    //   2587: iload 8
    //   2589: istore_3
    //   2590: iload 4
    //   2592: istore 5
    //   2594: iload 6
    //   2596: istore 4
    //   2598: goto -1645 -> 953
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2601	0	this	QQHeadDownloadHandler
    //   0	2601	1	paramFaceInfo	FaceInfo
    //   116	2471	2	i	int
    //   131	2459	3	j	int
    //   101	2496	4	k	int
    //   64	2529	5	m	int
    //   76	2519	6	n	int
    //   123	2219	7	i1	int
    //   61	2527	8	i2	int
    //   95	1964	9	i3	int
    //   119	2076	10	i4	int
    //   618	1500	11	i5	int
    //   89	1908	12	i6	int
    //   73	2254	13	i7	int
    //   104	2322	14	i8	int
    //   86	2050	15	i9	int
    //   92	2024	16	i10	int
    //   67	2053	17	i11	int
    //   70	2070	18	i12	int
    //   98	2090	19	i13	int
    //   113	2179	20	i14	int
    //   107	2021	21	i15	int
    //   110	2038	22	i16	int
    //   369	2210	23	bool1	boolean
    //   214	2370	24	bool2	boolean
    //   134	2428	25	bool3	boolean
    //   634	1500	26	bool4	boolean
    //   58	2003	27	bool5	boolean
    //   49	2083	28	bool6	boolean
    //   52	2099	29	bool7	boolean
    //   55	2276	30	bool8	boolean
    //   183	2083	31	localObject1	Object
    //   2337	10	31	localObject2	Object
    //   2373	183	31	localObject3	Object
    //   127	1146	32	localObject4	Object
    //   1309	3	32	localException	java.lang.Exception
    //   1333	1012	32	localObject5	Object
    //   2537	1	32	localThrowable	Throwable
    //   2548	18	32	localObject6	Object
    //   83	2439	33	localObject7	Object
    //   479	2009	34	localObject8	Object
    //   4	2264	35	localQQHeadInfo	QQHeadInfo
    //   23	2181	36	str	String
    //   242	1922	37	localSetting	Setting
    //   566	1312	38	localFile	File
    // Exception table:
    //   from	to	target	type
    //   376	387	1309	java/lang/Exception
    //   350	371	1319	finally
    //   376	387	1319	finally
    //   387	404	1319	finally
    //   1311	1316	1319	finally
    //   1320	1323	1319	finally
    //   235	244	1344	java/lang/Throwable
    //   263	279	1344	java/lang/Throwable
    //   298	304	1344	java/lang/Throwable
    //   323	328	1344	java/lang/Throwable
    //   347	350	1344	java/lang/Throwable
    //   423	439	1344	java/lang/Throwable
    //   1342	1344	1344	java/lang/Throwable
    //   423	439	1544	java/lang/Exception
    //   458	481	1544	java/lang/Exception
    //   505	513	1544	java/lang/Exception
    //   532	538	1544	java/lang/Exception
    //   557	568	1544	java/lang/Exception
    //   596	603	1544	java/lang/Exception
    //   817	836	1619	java/lang/Exception
    //   655	681	2003	java/lang/Throwable
    //   720	730	2003	java/lang/Throwable
    //   769	798	2003	java/lang/Throwable
    //   880	890	2003	java/lang/Throwable
    //   1799	1836	2003	java/lang/Throwable
    //   1877	1885	2003	java/lang/Throwable
    //   1931	1940	2003	java/lang/Throwable
    //   1977	1996	2003	java/lang/Throwable
    //   2106	2115	2003	java/lang/Throwable
    //   2154	2173	2003	java/lang/Throwable
    //   136	147	2193	finally
    //   166	185	2193	finally
    //   204	216	2193	finally
    //   235	244	2193	finally
    //   263	279	2193	finally
    //   298	304	2193	finally
    //   323	328	2193	finally
    //   347	350	2193	finally
    //   423	439	2193	finally
    //   458	481	2193	finally
    //   505	513	2193	finally
    //   532	538	2193	finally
    //   557	568	2193	finally
    //   596	603	2193	finally
    //   655	681	2193	finally
    //   720	730	2193	finally
    //   769	798	2193	finally
    //   880	890	2193	finally
    //   1342	1344	2193	finally
    //   1799	1836	2193	finally
    //   1877	1885	2193	finally
    //   1931	1940	2193	finally
    //   1977	1996	2193	finally
    //   2046	2053	2193	finally
    //   2106	2115	2193	finally
    //   2154	2173	2193	finally
    //   798	812	2280	finally
    //   817	836	2280	finally
    //   1632	1643	2280	finally
    //   1647	1682	2301	finally
    //   1694	1704	2321	finally
    //   1712	1741	2321	finally
    //   1749	1760	2321	finally
    //   906	921	2337	finally
    //   136	147	2356	java/lang/Throwable
    //   166	185	2356	java/lang/Throwable
    //   204	216	2356	java/lang/Throwable
    //   458	481	2381	java/lang/Throwable
    //   505	513	2381	java/lang/Throwable
    //   532	538	2381	java/lang/Throwable
    //   557	568	2381	java/lang/Throwable
    //   596	603	2381	java/lang/Throwable
    //   798	812	2404	java/lang/Throwable
    //   817	836	2404	java/lang/Throwable
    //   1632	1643	2404	java/lang/Throwable
    //   1647	1682	2435	java/lang/Throwable
    //   1694	1704	2469	java/lang/Throwable
    //   1712	1741	2469	java/lang/Throwable
    //   1749	1760	2469	java/lang/Throwable
    //   2046	2053	2503	java/lang/Throwable
    //   906	921	2537	java/lang/Throwable
  }
  
  public Object[] a(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    Setting localSetting2 = this.app.b(paramString2);
    Setting localSetting1 = localSetting2;
    if (localSetting2 == null)
    {
      localSetting1 = new Setting();
      localSetting1.uin = paramString2;
      paramBoolean = true;
    }
    localSetting1.bFaceFlags = paramQQHeadInfo.dwFaceFlgas;
    localSetting1.bUsrType = paramQQHeadInfo.dstUsrType;
    localSetting1.url = paramQQHeadInfo.downLoadUrl;
    localSetting1.updateTimestamp = System.currentTimeMillis();
    byte b;
    if (paramQQHeadInfo.cHeadType == 0)
    {
      b = 0;
      localSetting1.bSourceType = b;
      if (paramBoolean) {
        break label318;
      }
      if (localSetting1.bHeadType == paramQQHeadInfo.cHeadType) {
        break label262;
      }
      paramBoolean = true;
      label109:
      bool = paramBoolean;
      if (paramQQHeadInfo.dstUsrType != 32)
      {
        bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (localSetting1.bHeadType == 1)
          {
            bool = paramBoolean;
            if (paramQQHeadInfo.cHeadType == 0)
            {
              paramString1 = new File(this.app.getCustomFaceFilePath(localSetting1.bUsrType, paramString1, paramQQHeadInfo.idType));
              bool = paramBoolean;
              if (paramString1 != null)
              {
                bool = paramBoolean;
                if (paramString1.exists()) {
                  paramString1.delete();
                }
              }
            }
          }
        }
      }
    }
    label262:
    label318:
    for (boolean bool = paramBoolean;; bool = paramBoolean)
    {
      localSetting1.bHeadType = paramQQHeadInfo.cHeadType;
      localSetting1.systemHeadID = paramQQHeadInfo.systemHeadID;
      localSetting1.headImgTimestamp = paramQQHeadInfo.dwTimestamp;
      return new Object[] { Boolean.valueOf(bool), localSetting1 };
      b = paramQQHeadInfo.headLevel;
      break;
      if (paramQQHeadInfo.cHeadType == 0)
      {
        if (localSetting1.systemHeadID != paramQQHeadInfo.systemHeadID)
        {
          paramBoolean = true;
          break label109;
        }
        paramBoolean = false;
        break label109;
      }
      if (localSetting1.headImgTimestamp != paramQQHeadInfo.dwTimestamp)
      {
        paramBoolean = true;
        break label109;
      }
      paramBoolean = false;
      break label109;
    }
  }
  
  public String rR()
  {
    return aeib.dR(1);
  }
  
  public String rz()
  {
    return aeib.dR(0);
  }
  
  class HeadCostStatRunnable
    implements Runnable
  {
    int cwZ;
    int cyV;
    String downloadUrl;
    int errCode;
    String id;
    int idType;
    int resultCode = 0;
    int state;
    long time;
    
    public HeadCostStatRunnable(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, long paramLong)
    {
      this.resultCode = paramInt1;
      this.id = paramString1;
      this.idType = paramInt2;
      this.cyV = paramInt3;
      this.state = paramInt4;
      this.cwZ = paramInt5;
      this.downloadUrl = paramString2;
      this.errCode = paramInt6;
      this.time = paramLong;
    }
    
    public void run()
    {
      QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).a(this.resultCode, this.id, this.cyV, 4, this.cwZ, this.downloadUrl, this.errCode, this.time);
      String str = this.cyV + "_" + this.id;
      if (this.cyV == 32) {
        str = "stranger_" + String.valueOf(this.idType) + "_" + this.id;
      }
      for (;;)
      {
        QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).bD(str, true);
        return;
        if (this.cyV == 16) {
          str = "qcall_" + String.valueOf(this.idType) + "_" + this.id;
        }
      }
    }
  }
  
  class UpdateSettingRunnable
    implements Runnable
  {
    QQHeadInfo jdField_a_of_type_AvatarInfoQQHeadInfo;
    Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
    FaceInfo c;
    
    public UpdateSettingRunnable(Setting paramSetting, FaceInfo paramFaceInfo)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
      this.jdField_a_of_type_AvatarInfoQQHeadInfo = paramFaceInfo.b;
      this.c = paramFaceInfo;
    }
    
    public void run()
    {
      int i = 0;
      if (QLog.isColorLevel()) {
        QLog.i("UpdateSettingRunnable", 2, "run start. | uin=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.uin + ", updateTimestamp=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.updateTimestamp + ", usrtype=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.bUsrType + ", headImgTimestamp=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.headImgTimestamp + ", usrtype=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType + ", status=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.getStatus() + ", id=" + this.jdField_a_of_type_ComTencentMobileqqDataSetting.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
      }
      localObject1 = QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).a().createEntityManager();
      String str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSetting.getStatus() == 1000)
      {
        ((EntityManager)localObject1).persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataSetting);
        ((EntityManager)localObject1).close();
        if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType == 32)
        {
          localObject1 = QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).a().a(true);
          if (localObject1 != null) {
            ((aqdv)localObject1).Y(32, this.c.uin, this.c.idType);
          }
        }
        localObject1 = QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).i(this.jdField_a_of_type_AvatarInfoQQHeadInfo.uin, this.jdField_a_of_type_AvatarInfoQQHeadInfo.phoneNum);
        str1 = QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).getCustomFaceFilePath(this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType, (String)localObject1, this.jdField_a_of_type_AvatarInfoQQHeadInfo.idType);
        Object localObject2 = str1.substring(0, str1.lastIndexOf("/"));
        String str2 = str1.substring(str1.lastIndexOf("/") + 1);
        if ((!TextUtils.isEmpty(str2)) && (str2.endsWith("jpg_")))
        {
          localObject2 = new File((String)localObject2 + File.separator + str2.substring(0, str2.lastIndexOf("jpg_")) + "png");
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
        }
      }
      for (;;)
      {
        try
        {
          int j = aqiw.getNetworkType(QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).getApp());
          if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType != 1) {
            continue;
          }
          k = (int)new File(str1).length();
          if (k > 0) {
            QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).sendAppDataIncerment(QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).getCurrentAccountUin(), false, j, 131074, i, k + 126 + 239);
          }
        }
        catch (Throwable localThrowable)
        {
          int k;
          localThrowable.printStackTrace();
          continue;
          if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType != 16) {
            continue;
          }
          localObject1 = "qcall_" + this.jdField_a_of_type_AvatarInfoQQHeadInfo.idType + "_" + (String)localObject1;
          aqep.rg((String)localObject1);
          aqep.rh((String)localObject1);
          aqep.bd(QQHeadDownloadHandler.a(QQHeadDownloadHandler.this), (String)localObject1);
          continue;
          aqep.rg((String)localObject1);
          aqep.rh((String)localObject1);
          aqep.bd(QQHeadDownloadHandler.a(QQHeadDownloadHandler.this), (String)localObject1);
          continue;
        }
        if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType != 32) {
          continue;
        }
        localObject1 = "stranger_" + this.jdField_a_of_type_AvatarInfoQQHeadInfo.idType + "_" + (String)localObject1;
        aqep.rg((String)localObject1);
        aqep.rh((String)localObject1);
        aqep.bd(QQHeadDownloadHandler.a(QQHeadDownloadHandler.this), (String)localObject1);
        QQHeadDownloadHandler.a(QQHeadDownloadHandler.this).notifyUI(45, true, this.jdField_a_of_type_ComTencentMobileqqDataSetting);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting.getStatus() != 1001) && (this.jdField_a_of_type_ComTencentMobileqqDataSetting.getStatus() != 1002)) {
          break;
        }
        ((EntityManager)localObject1).update(this.jdField_a_of_type_ComTencentMobileqqDataSetting);
        break;
        if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType == 4)
        {
          i = 1;
        }
        else if (this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType == 11)
        {
          i = 3;
        }
        else
        {
          k = this.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType;
          if (k == 32) {
            i = 1003;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */