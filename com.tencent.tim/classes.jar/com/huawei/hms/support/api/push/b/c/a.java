package com.huawei.hms.support.api.push.b.c;

import android.annotation.TargetApi;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.HMSLog;

public class a
{
  /* Error */
  private static int a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    // Byte code:
    //   0: new 18	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 28	android/content/Context:getPackageName	()Ljava/lang/String;
    //   11: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 34
    //   16: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 11
    //   24: ldc 39
    //   26: new 18	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   33: ldc 41
    //   35: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 11
    //   40: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 43
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 11
    //   60: invokestatic 55	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   63: invokevirtual 59	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   66: astore 12
    //   68: ldc 39
    //   70: new 18	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   77: ldc 61
    //   79: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 12
    //   84: arraylength
    //   85: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload 12
    //   96: arraylength
    //   97: istore 5
    //   99: iconst_0
    //   100: istore 4
    //   102: iload 4
    //   104: iload 5
    //   106: if_icmpge +372 -> 478
    //   109: aload 12
    //   111: iload 4
    //   113: aaload
    //   114: astore 10
    //   116: aload 10
    //   118: invokevirtual 67	java/lang/Class:getName	()Ljava/lang/String;
    //   121: aload 11
    //   123: invokevirtual 73	java/lang/String:length	()I
    //   126: iconst_1
    //   127: iadd
    //   128: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   131: astore 13
    //   133: ldc 39
    //   135: new 18	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   142: ldc 79
    //   144: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 13
    //   149: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 81
    //   154: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 10
    //   159: invokevirtual 67	java/lang/Class:getName	()Ljava/lang/String;
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_2
    //   172: aload 13
    //   174: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifeq +68 -> 245
    //   180: aload 10
    //   182: ifnull +72 -> 254
    //   185: aload 10
    //   187: aload_1
    //   188: invokevirtual 89	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   191: aload_3
    //   192: invokevirtual 95	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   195: istore 4
    //   197: iload 4
    //   199: istore 5
    //   201: iload 4
    //   203: istore 6
    //   205: iload 4
    //   207: istore 7
    //   209: iload 4
    //   211: istore 8
    //   213: iload 4
    //   215: istore 9
    //   217: ldc 39
    //   219: new 18	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   226: ldc 97
    //   228: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 4
    //   233: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: iload 4
    //   244: ireturn
    //   245: iload 4
    //   247: iconst_1
    //   248: iadd
    //   249: istore 4
    //   251: goto -149 -> 102
    //   254: ldc 39
    //   256: ldc 99
    //   258: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: new 18	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   268: aload_0
    //   269: invokevirtual 28	android/content/Context:getPackageName	()Ljava/lang/String;
    //   272: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 101
    //   277: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore_0
    //   288: ldc 39
    //   290: new 18	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   297: ldc 103
    //   299: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 43
    //   308: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: invokestatic 55	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   325: aload_1
    //   326: invokevirtual 89	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   329: aload_3
    //   330: invokevirtual 95	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   333: istore 4
    //   335: iload 4
    //   337: istore 5
    //   339: iload 4
    //   341: istore 6
    //   343: iload 4
    //   345: istore 7
    //   347: iload 4
    //   349: istore 8
    //   351: iload 4
    //   353: istore 9
    //   355: ldc 39
    //   357: new 18	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   364: ldc 105
    //   366: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: iload 4
    //   371: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: iload 4
    //   382: ireturn
    //   383: astore_0
    //   384: ldc 39
    //   386: ldc 107
    //   388: aload_0
    //   389: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   392: iload 5
    //   394: ireturn
    //   395: astore_0
    //   396: iconst_0
    //   397: istore 9
    //   399: ldc 39
    //   401: ldc 113
    //   403: aload_0
    //   404: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   407: iload 9
    //   409: ireturn
    //   410: astore_0
    //   411: iconst_0
    //   412: istore 8
    //   414: ldc 39
    //   416: ldc 115
    //   418: aload_0
    //   419: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   422: iload 8
    //   424: ireturn
    //   425: astore_0
    //   426: iconst_0
    //   427: istore 7
    //   429: ldc 39
    //   431: ldc 117
    //   433: aload_0
    //   434: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   437: iload 7
    //   439: ireturn
    //   440: astore_0
    //   441: iconst_0
    //   442: istore 6
    //   444: ldc 39
    //   446: ldc 119
    //   448: aload_0
    //   449: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   452: iload 6
    //   454: ireturn
    //   455: astore_0
    //   456: goto -12 -> 444
    //   459: astore_0
    //   460: goto -31 -> 429
    //   463: astore_0
    //   464: goto -50 -> 414
    //   467: astore_0
    //   468: goto -69 -> 399
    //   471: astore_0
    //   472: iconst_0
    //   473: istore 5
    //   475: goto -91 -> 384
    //   478: aconst_null
    //   479: astore 10
    //   481: goto -301 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramString1	String
    //   0	484	2	paramString2	String
    //   0	484	3	paramObject	Object
    //   100	281	4	i	int
    //   97	377	5	j	int
    //   203	250	6	k	int
    //   207	231	7	m	int
    //   211	212	8	n	int
    //   215	193	9	i1	int
    //   114	366	10	localClass	java.lang.Class
    //   22	100	11	str1	String
    //   66	44	12	arrayOfClass	java.lang.Class[]
    //   131	42	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   217	242	383	java/lang/ClassNotFoundException
    //   355	380	383	java/lang/ClassNotFoundException
    //   0	99	395	java/lang/NoSuchFieldException
    //   116	180	395	java/lang/NoSuchFieldException
    //   185	197	395	java/lang/NoSuchFieldException
    //   254	335	395	java/lang/NoSuchFieldException
    //   0	99	410	java/lang/IllegalAccessException
    //   116	180	410	java/lang/IllegalAccessException
    //   185	197	410	java/lang/IllegalAccessException
    //   254	335	410	java/lang/IllegalAccessException
    //   0	99	425	java/lang/IllegalArgumentException
    //   116	180	425	java/lang/IllegalArgumentException
    //   185	197	425	java/lang/IllegalArgumentException
    //   254	335	425	java/lang/IllegalArgumentException
    //   0	99	440	java/lang/IndexOutOfBoundsException
    //   116	180	440	java/lang/IndexOutOfBoundsException
    //   185	197	440	java/lang/IndexOutOfBoundsException
    //   254	335	440	java/lang/IndexOutOfBoundsException
    //   217	242	455	java/lang/IndexOutOfBoundsException
    //   355	380	455	java/lang/IndexOutOfBoundsException
    //   217	242	459	java/lang/IllegalArgumentException
    //   355	380	459	java/lang/IllegalArgumentException
    //   217	242	463	java/lang/IllegalAccessException
    //   355	380	463	java/lang/IllegalAccessException
    //   217	242	467	java/lang/NoSuchFieldException
    //   355	380	467	java/lang/NoSuchFieldException
    //   0	99	471	java/lang/ClassNotFoundException
    //   116	180	471	java/lang/ClassNotFoundException
    //   185	197	471	java/lang/ClassNotFoundException
    //   254	335	471	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public static android.graphics.Bitmap a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: ifnull +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   23: ifnull +164 -> 187
    //   26: aload_1
    //   27: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   30: invokevirtual 73	java/lang/String:length	()I
    //   33: ifle +154 -> 187
    //   36: iconst_0
    //   37: istore_2
    //   38: aload_1
    //   39: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   42: new 18	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   49: ldc 134
    //   51: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 136	com/huawei/hms/support/api/push/b/b/a:a	()Ljava/lang/String;
    //   58: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +79 -> 146
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   75: ldc 138
    //   77: new 140	android/R$drawable
    //   80: dup
    //   81: invokespecial 141	android/R$drawable:<init>	()V
    //   84: invokestatic 143	com/huawei/hms/support/api/push/b/c/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)I
    //   87: istore_3
    //   88: iload_3
    //   89: istore_2
    //   90: iload_3
    //   91: ifne +19 -> 110
    //   94: aload_0
    //   95: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   98: aload_1
    //   99: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   102: ldc 138
    //   104: ldc 149
    //   106: invokevirtual 155	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   109: istore_2
    //   110: ldc 39
    //   112: new 18	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   119: ldc 157
    //   121: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 132	com/huawei/hms/support/api/push/b/b/a:l	()Ljava/lang/String;
    //   128: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 159
    //   133: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 49	com/huawei/hms/support/log/HMSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iload_2
    //   147: ifeq +13 -> 160
    //   150: aload_0
    //   151: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   154: iload_2
    //   155: invokestatic 165	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   158: astore 4
    //   160: getstatic 171	com/huawei/hms/android/HwBuildEx$VERSION:EMUI_SDK_INT	I
    //   163: bipush 11
    //   165: if_icmplt +28 -> 193
    //   168: ldc 39
    //   170: ldc 173
    //   172: invokestatic 176	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 4
    //   177: areturn
    //   178: astore 4
    //   180: ldc 39
    //   182: ldc 178
    //   184: invokestatic 180	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aconst_null
    //   188: astore 4
    //   190: goto -30 -> 160
    //   193: aload 4
    //   195: ifnonnull +144 -> 339
    //   198: ldc 182
    //   200: aload_1
    //   201: invokevirtual 184	com/huawei/hms/support/api/push/b/b/a:i	()Ljava/lang/String;
    //   204: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +132 -> 339
    //   210: ldc 39
    //   212: new 18	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   219: ldc 186
    //   221: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: invokevirtual 184	com/huawei/hms/support/api/push/b/b/a:i	()Ljava/lang/String;
    //   228: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 176	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: invokevirtual 190	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   241: aload_1
    //   242: invokevirtual 184	com/huawei/hms/support/api/push/b/b/a:i	()Ljava/lang/String;
    //   245: invokevirtual 196	android/content/pm/PackageManager:getApplicationIcon	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   248: checkcast 198	android/graphics/drawable/BitmapDrawable
    //   251: invokevirtual 202	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   254: astore_0
    //   255: aload_0
    //   256: areturn
    //   257: astore_1
    //   258: aload 5
    //   260: astore_0
    //   261: ldc 39
    //   263: new 18	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   270: ldc 134
    //   272: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 203	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   279: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: aload_1
    //   286: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   289: aload_0
    //   290: areturn
    //   291: astore_1
    //   292: aload 6
    //   294: astore_0
    //   295: ldc 39
    //   297: new 18	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   304: ldc 134
    //   306: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_1
    //   310: invokevirtual 204	java/lang/Exception:toString	()Ljava/lang/String;
    //   313: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: aload_1
    //   320: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload_0
    //   324: areturn
    //   325: astore_1
    //   326: aload 4
    //   328: astore_0
    //   329: goto -34 -> 295
    //   332: astore_1
    //   333: aload 4
    //   335: astore_0
    //   336: goto -75 -> 261
    //   339: aload 4
    //   341: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	Context
    //   0	342	1	parama	com.huawei.hms.support.api.push.b.b.a
    //   37	118	2	i	int
    //   87	4	3	j	int
    //   7	169	4	localBitmap1	android.graphics.Bitmap
    //   178	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   188	152	4	localBitmap2	android.graphics.Bitmap
    //   1	258	5	localObject1	Object
    //   4	289	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   150	160	178	java/lang/OutOfMemoryError
    //   19	36	257	android/content/pm/PackageManager$NameNotFoundException
    //   38	88	257	android/content/pm/PackageManager$NameNotFoundException
    //   94	110	257	android/content/pm/PackageManager$NameNotFoundException
    //   110	146	257	android/content/pm/PackageManager$NameNotFoundException
    //   150	160	257	android/content/pm/PackageManager$NameNotFoundException
    //   180	187	257	android/content/pm/PackageManager$NameNotFoundException
    //   19	36	291	java/lang/Exception
    //   38	88	291	java/lang/Exception
    //   94	110	291	java/lang/Exception
    //   110	146	291	java/lang/Exception
    //   150	160	291	java/lang/Exception
    //   180	187	291	java/lang/Exception
    //   160	175	325	java/lang/Exception
    //   198	255	325	java/lang/Exception
    //   160	175	332	android/content/pm/PackageManager$NameNotFoundException
    //   198	255	332	android/content/pm/PackageManager$NameNotFoundException
  }
  
  @TargetApi(23)
  public static void a(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.b.b.a parama)
  {
    if ((paramContext == null) || (paramBuilder == null) || (parama == null))
    {
      HMSLog.e("PushSelfShowLog", "msg is null");
      return;
    }
    if (d(paramContext, parama))
    {
      HMSLog.i("PushSelfShowLog", "get small icon from " + parama.i());
      Icon localIcon = c(paramContext, parama);
      if (localIcon != null)
      {
        paramBuilder.setSmallIcon(localIcon);
        return;
      }
      paramBuilder.setSmallIcon(b(paramContext, parama));
      return;
    }
    paramBuilder.setSmallIcon(b(paramContext, parama));
  }
  
  private static int b(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    int i = 0;
    if ((paramContext == null) || (parama == null)) {
      HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
    }
    int j;
    do
    {
      do
      {
        return i;
        j = paramContext.getApplicationInfo().icon;
        i = j;
      } while (j != 0);
      j = paramContext.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
      HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
      i = j;
    } while (j != 0);
    HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
    return 17301651;
  }
  
  @TargetApi(23)
  private static Icon c(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      HMSLog.e("PushSelfShowLog", "getSmallIcon, context is null");
      return null;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      HMSLog.i("PushSelfShowLog", "getSmallIcon failed, Build.VERSION less than 23");
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = Icon.createWithResource(parama.i(), paramContext.getApplicationInfo(parama.i(), 0).icon);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("PushSelfShowLog", paramContext.toString());
      return null;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushSelfShowLog", paramContext.toString(), paramContext);
    }
    return null;
  }
  
  private static boolean d(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    return (!"com.huawei.android.pushagent".equals(parama.i())) && (Build.VERSION.SDK_INT >= 23) && ((com.huawei.hms.support.api.push.b.d.a.a(paramContext)) || (com.huawei.hms.support.api.push.b.d.a.b(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.c.a
 * JD-Core Version:    0.7.0.1
 */