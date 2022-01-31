package com.tencent.mobileqq.jsp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONObject;

public class MediaApiPlugin
  extends WebViewPlugin
  implements QQProgressDialog.Callback
{
  static final byte jdField_a_of_type_Byte = 1;
  static final String jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  static final byte jdField_b_of_type_Byte = 2;
  static final String jdField_b_of_type_JavaLangString = "getPictureParam";
  static final String c = "callback";
  static final String d = "match";
  static final String e = "data";
  static final String f = "imageID";
  static final String g = "retCode";
  static final String h = "msg";
  static final String i = "statusCode";
  static final String j = "scaleMode";
  static final String k = "getPictureV2";
  static final String l = "getLocalImageV2";
  public QQProgressDialog a;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public static String a(String paramString, int paramInt)
  {
    CompressInfo localCompressInfo = new CompressInfo();
    localCompressInfo.a = 1006;
    localCompressInfo.c = paramString;
    localCompressInfo.g = paramInt;
    CompressOperator.a(localCompressInfo);
    return localCompressInfo.e;
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 88	java/io/File
    //   6: dup
    //   7: getstatic 93	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   10: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 100	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 103	java/io/File:canWrite	()Z
    //   23: ifne +13 -> 36
    //   26: new 86	java/io/IOException
    //   29: dup
    //   30: ldc 105
    //   32: invokespecial 106	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: new 108	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 109	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: iconst_1
    //   46: putfield 113	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_1
    //   50: iconst_0
    //   51: aload_1
    //   52: arraylength
    //   53: aload_3
    //   54: invokestatic 119	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload_3
    //   59: getfield 122	android/graphics/BitmapFactory$Options:outWidth	I
    //   62: ifle +10 -> 72
    //   65: aload_3
    //   66: getfield 125	android/graphics/BitmapFactory$Options:outHeight	I
    //   69: ifgt +13 -> 82
    //   72: new 127	java/lang/IllegalArgumentException
    //   75: dup
    //   76: ldc 129
    //   78: invokespecial 130	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: ldc 132
    //   84: aload_3
    //   85: getfield 135	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   88: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +132 -> 223
    //   94: ldc 143
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull +221 -> 319
    //   101: new 145	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   108: getstatic 93	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   111: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 152
    //   116: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: aload_3
    //   126: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: new 88	java/io/File
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 5
    //   145: new 166	java/io/FileOutputStream
    //   148: dup
    //   149: aload 5
    //   151: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_3
    //   155: aload_3
    //   156: aload_1
    //   157: invokevirtual 173	java/io/FileOutputStream:write	([B)V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 176	java/io/FileOutputStream:close	()V
    //   168: iconst_1
    //   169: istore_2
    //   170: aload 4
    //   172: astore_1
    //   173: iload_2
    //   174: ifeq +308 -> 482
    //   177: new 178	android/content/Intent
    //   180: dup
    //   181: ldc 180
    //   183: invokespecial 181	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   186: astore_3
    //   187: aload_3
    //   188: new 145	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   195: ldc 183
    //   197: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 189	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   210: invokevirtual 193	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   213: pop
    //   214: invokestatic 199	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   217: aload_3
    //   218: invokevirtual 205	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   221: aload_1
    //   222: areturn
    //   223: ldc 207
    //   225: aload_3
    //   226: getfield 135	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   229: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +9 -> 241
    //   235: ldc 209
    //   237: astore_3
    //   238: goto -141 -> 97
    //   241: ldc 211
    //   243: aload_3
    //   244: getfield 135	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   247: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +9 -> 259
    //   253: ldc 213
    //   255: astore_3
    //   256: goto -159 -> 97
    //   259: ldc 215
    //   261: aload_3
    //   262: getfield 135	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   265: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   268: ifeq +254 -> 522
    //   271: ldc 217
    //   273: astore_3
    //   274: goto -177 -> 97
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_3
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 176	java/io/FileOutputStream:close	()V
    //   288: aload 5
    //   290: invokevirtual 220	java/io/File:exists	()Z
    //   293: ifeq +9 -> 302
    //   296: aload 5
    //   298: invokevirtual 223	java/io/File:delete	()Z
    //   301: pop
    //   302: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +12 -> 317
    //   308: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: iconst_2
    //   312: ldc 230
    //   314: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_1
    //   318: athrow
    //   319: new 145	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   326: getstatic 93	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   329: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc 152
    //   334: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   340: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: ldc 143
    //   345: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: astore_3
    //   352: new 88	java/io/File
    //   355: dup
    //   356: aload_3
    //   357: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore 6
    //   362: new 166	java/io/FileOutputStream
    //   365: dup
    //   366: aload 6
    //   368: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   371: astore 5
    //   373: aload_1
    //   374: iconst_0
    //   375: aload_1
    //   376: arraylength
    //   377: invokestatic 236	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   380: getstatic 242	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   383: bipush 75
    //   385: aload 5
    //   387: invokevirtual 248	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   390: istore_2
    //   391: aload 5
    //   393: ifnull +8 -> 401
    //   396: aload 5
    //   398: invokevirtual 176	java/io/FileOutputStream:close	()V
    //   401: iload_2
    //   402: ifne +115 -> 517
    //   405: aload 6
    //   407: invokevirtual 220	java/io/File:exists	()Z
    //   410: ifeq +9 -> 419
    //   413: aload 6
    //   415: invokevirtual 223	java/io/File:delete	()Z
    //   418: pop
    //   419: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +95 -> 517
    //   425: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: iconst_2
    //   429: ldc 250
    //   431: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_3
    //   435: astore_1
    //   436: goto -263 -> 173
    //   439: astore_1
    //   440: aload 4
    //   442: astore_3
    //   443: aload_3
    //   444: ifnull +7 -> 451
    //   447: aload_3
    //   448: invokevirtual 176	java/io/FileOutputStream:close	()V
    //   451: aload 6
    //   453: invokevirtual 220	java/io/File:exists	()Z
    //   456: ifeq +9 -> 465
    //   459: aload 6
    //   461: invokevirtual 223	java/io/File:delete	()Z
    //   464: pop
    //   465: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +12 -> 480
    //   471: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   474: iconst_2
    //   475: ldc 250
    //   477: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_1
    //   481: athrow
    //   482: new 86	java/io/IOException
    //   485: dup
    //   486: invokespecial 251	java/io/IOException:<init>	()V
    //   489: athrow
    //   490: astore_1
    //   491: goto -323 -> 168
    //   494: astore_3
    //   495: goto -207 -> 288
    //   498: astore_1
    //   499: goto -98 -> 401
    //   502: astore_3
    //   503: goto -52 -> 451
    //   506: astore_1
    //   507: aload 5
    //   509: astore_3
    //   510: goto -67 -> 443
    //   513: astore_1
    //   514: goto -234 -> 280
    //   517: aload_3
    //   518: astore_1
    //   519: goto -346 -> 173
    //   522: aconst_null
    //   523: astore_3
    //   524: goto -427 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	MediaApiPlugin
    //   0	527	1	paramArrayOfByte	byte[]
    //   169	233	2	bool	boolean
    //   13	435	3	localObject1	Object
    //   494	1	3	localIOException1	IOException
    //   502	1	3	localIOException2	IOException
    //   509	15	3	localObject2	Object
    //   1	440	4	str	String
    //   143	365	5	localObject3	Object
    //   360	100	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   145	155	277	finally
    //   362	373	439	finally
    //   164	168	490	java/io/IOException
    //   284	288	494	java/io/IOException
    //   396	401	498	java/io/IOException
    //   447	451	502	java/io/IOException
    //   373	391	506	finally
    //   155	160	513	finally
  }
  
  public static JSONObject a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new File(paramString);
    if (((File)localObject1).length() < 3L) {
      throw new IOException();
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    int m = ((BitmapFactory.Options)localObject2).outWidth;
    int n = ((BitmapFactory.Options)localObject2).outHeight;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 realWidth: " + m + ", realHeight: " + n + ", realSize: " + ((File)localObject1).length());
    }
    if ((m < 0) || (n < 0)) {
      throw new IOException();
    }
    Object localObject3 = a(paramString, paramInt);
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject2 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if (QLog.isColorLevel())
    {
      localObject3 = new File((String)localObject3);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 curWidth: " + ((BitmapFactory.Options)localObject1).outWidth + ", curHeight: " + ((BitmapFactory.Options)localObject1).outHeight + ", realSize: " + ((File)localObject3).length());
    }
    localObject3 = new ByteArrayOutputStream(1024);
    localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
    if (("image/png".equalsIgnoreCase((String)localObject1)) || ("image/gif".equals(localObject1)) || ("image/bmp".equals(localObject1)))
    {
      localObject1 = new StringBuilder("data:image/png;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      ((StringBuilder)localObject1).append(Base64Util.a(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
      localJSONObject.put("match", 0);
      localJSONObject.put("data", localObject1);
      localJSONObject.put("imageID", paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - l1));
      }
      return localJSONObject;
      localObject1 = new StringBuilder("data:image/jpeg;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 254	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 255	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: new 88	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 10
    //   19: aload 10
    //   21: invokevirtual 258	java/io/File:length	()J
    //   24: ldc2_w 259
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 86	java/io/IOException
    //   34: dup
    //   35: invokespecial 251	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 108	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 109	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 9
    //   48: aload 9
    //   50: iconst_1
    //   51: putfield 113	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 9
    //   57: invokestatic 264	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 9
    //   63: getfield 122	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 7
    //   68: aload 9
    //   70: getfield 125	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 8
    //   75: iload 7
    //   77: iflt +8 -> 85
    //   80: iload 8
    //   82: ifge +11 -> 93
    //   85: new 86	java/io/IOException
    //   88: dup
    //   89: invokespecial 251	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 7
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 8
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 11
    //   107: ldc 20
    //   109: iconst_1
    //   110: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 11
    //   116: areturn
    //   117: iload 7
    //   119: iload_3
    //   120: if_icmpgt +337 -> 457
    //   123: iload 8
    //   125: iload 4
    //   127: if_icmpgt +330 -> 457
    //   130: new 319	java/io/FileInputStream
    //   133: dup
    //   134: aload 10
    //   136: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 10
    //   141: aload 10
    //   143: invokevirtual 326	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 10
    //   149: invokevirtual 326	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 10
    //   155: invokevirtual 326	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +104 -> 267
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +97 -> 267
    //   173: new 145	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 316
    //   180: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: astore 9
    //   185: aload 9
    //   187: iconst_3
    //   188: newarray byte
    //   190: dup
    //   191: iconst_0
    //   192: iload_1
    //   193: i2b
    //   194: bastore
    //   195: dup
    //   196: iconst_1
    //   197: iload_2
    //   198: i2b
    //   199: bastore
    //   200: dup
    //   201: iconst_2
    //   202: iload_3
    //   203: i2b
    //   204: bastore
    //   205: iconst_2
    //   206: invokestatic 306	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   209: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: sipush 30720
    //   216: newarray byte
    //   218: astore 12
    //   220: aload 10
    //   222: aload 12
    //   224: invokevirtual 329	java/io/InputStream:read	([B)I
    //   227: istore_1
    //   228: iload_1
    //   229: iconst_m1
    //   230: if_icmpeq +186 -> 416
    //   233: invokestatic 335	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   236: invokevirtual 338	java/lang/Thread:isInterrupted	()Z
    //   239: ifeq +125 -> 364
    //   242: new 340	java/lang/InterruptedException
    //   245: dup
    //   246: invokespecial 341	java/lang/InterruptedException:<init>	()V
    //   249: athrow
    //   250: astore_0
    //   251: aload 10
    //   253: astore 9
    //   255: aload 9
    //   257: ifnull +8 -> 265
    //   260: aload 9
    //   262: invokevirtual 342	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: iload_1
    //   268: bipush 66
    //   270: if_icmpne +24 -> 294
    //   273: iload_2
    //   274: bipush 77
    //   276: if_icmpne +18 -> 294
    //   279: new 145	java/lang/StringBuilder
    //   282: dup
    //   283: ldc_w 344
    //   286: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: goto -106 -> 185
    //   294: iload_1
    //   295: sipush 137
    //   298: if_icmpne +24 -> 322
    //   301: iload_2
    //   302: bipush 80
    //   304: if_icmpne +18 -> 322
    //   307: new 145	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 290
    //   314: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: astore 9
    //   319: goto -134 -> 185
    //   322: iload_1
    //   323: bipush 71
    //   325: if_icmpne +24 -> 349
    //   328: iload_2
    //   329: bipush 73
    //   331: if_icmpne +18 -> 349
    //   334: new 145	java/lang/StringBuilder
    //   337: dup
    //   338: ldc_w 346
    //   341: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: astore 9
    //   346: goto -161 -> 185
    //   349: new 145	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 348
    //   356: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: astore 9
    //   361: goto -176 -> 185
    //   364: iload_1
    //   365: sipush 30720
    //   368: if_icmpge +33 -> 401
    //   371: iload_1
    //   372: newarray byte
    //   374: astore 13
    //   376: aload 12
    //   378: iconst_0
    //   379: aload 13
    //   381: iconst_0
    //   382: iload_1
    //   383: invokestatic 352	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   386: aload 9
    //   388: aload 13
    //   390: iconst_2
    //   391: invokestatic 306	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   394: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: goto -178 -> 220
    //   401: aload 9
    //   403: aload 12
    //   405: iconst_2
    //   406: invokestatic 306	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   409: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: goto -193 -> 220
    //   416: aload 11
    //   418: ldc 20
    //   420: iconst_0
    //   421: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 11
    //   427: ldc 23
    //   429: aload 9
    //   431: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload 11
    //   437: ldc 26
    //   439: aload_0
    //   440: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 10
    //   446: ifnull -332 -> 114
    //   449: aload 10
    //   451: invokevirtual 342	java/io/InputStream:close	()V
    //   454: aload 11
    //   456: areturn
    //   457: iload 7
    //   459: iload_3
    //   460: idiv
    //   461: iload 8
    //   463: iload 4
    //   465: idiv
    //   466: invokestatic 358	java/lang/Math:max	(II)I
    //   469: istore_1
    //   470: aload 9
    //   472: iconst_0
    //   473: putfield 113	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   476: iload_1
    //   477: iload_1
    //   478: iconst_1
    //   479: iushr
    //   480: ior
    //   481: istore_1
    //   482: iload_1
    //   483: iload_1
    //   484: iconst_2
    //   485: iushr
    //   486: ior
    //   487: istore_1
    //   488: iload_1
    //   489: iload_1
    //   490: iconst_4
    //   491: iushr
    //   492: ior
    //   493: istore_1
    //   494: iload_1
    //   495: iload_1
    //   496: bipush 8
    //   498: iushr
    //   499: ior
    //   500: istore_1
    //   501: aload 9
    //   503: iload_1
    //   504: iload_1
    //   505: bipush 16
    //   507: iushr
    //   508: ior
    //   509: iconst_1
    //   510: iadd
    //   511: iconst_1
    //   512: iushr
    //   513: putfield 361	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   516: aload_0
    //   517: aload 9
    //   519: invokestatic 264	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   522: astore 12
    //   524: iload 7
    //   526: iload 4
    //   528: imul
    //   529: iload 8
    //   531: iload_3
    //   532: imul
    //   533: if_icmple +247 -> 780
    //   536: iload_3
    //   537: i2f
    //   538: aload 12
    //   540: invokevirtual 364	android/graphics/Bitmap:getWidth	()I
    //   543: i2f
    //   544: fdiv
    //   545: fstore 5
    //   547: new 366	android/graphics/Matrix
    //   550: dup
    //   551: invokespecial 367	android/graphics/Matrix:<init>	()V
    //   554: astore 10
    //   556: new 369	android/media/ExifInterface
    //   559: dup
    //   560: aload_0
    //   561: invokespecial 370	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   564: ldc_w 372
    //   567: iconst_1
    //   568: invokevirtual 376	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   571: tableswitch	default:+410 -> 981, 2:+224->795, 3:+255->826, 4:+276->847, 5:+289->860, 6:+311->882, 7:+332->903, 8:+354->925
    //   613: lconst_1
    //   614: fload 5
    //   616: fload 5
    //   618: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   621: aload 12
    //   623: iconst_0
    //   624: iconst_0
    //   625: aload 12
    //   627: invokevirtual 364	android/graphics/Bitmap:getWidth	()I
    //   630: aload 12
    //   632: invokevirtual 383	android/graphics/Bitmap:getHeight	()I
    //   635: aload 10
    //   637: iconst_1
    //   638: invokestatic 387	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   641: astore 10
    //   643: aload 12
    //   645: aload 10
    //   647: if_acmpeq +8 -> 655
    //   650: aload 12
    //   652: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   655: new 281	java/io/ByteArrayOutputStream
    //   658: dup
    //   659: sipush 1024
    //   662: invokespecial 284	java/io/ByteArrayOutputStream:<init>	(I)V
    //   665: astore 12
    //   667: aload 9
    //   669: getfield 135	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   672: astore 9
    //   674: ldc 211
    //   676: aload 9
    //   678: invokevirtual 288	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   681: ifne +23 -> 704
    //   684: ldc 215
    //   686: aload 9
    //   688: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifne +13 -> 704
    //   694: ldc 207
    //   696: aload 9
    //   698: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   701: ifeq +245 -> 946
    //   704: new 145	java/lang/StringBuilder
    //   707: dup
    //   708: ldc_w 290
    //   711: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   714: astore 9
    //   716: aload 10
    //   718: getstatic 294	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   721: bipush 100
    //   723: aload 12
    //   725: invokevirtual 248	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   728: pop
    //   729: aload 10
    //   731: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   734: aload 9
    //   736: aload 12
    //   738: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   741: iconst_2
    //   742: invokestatic 306	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   745: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: ldc 20
    //   753: iconst_0
    //   754: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   757: pop
    //   758: aload 11
    //   760: ldc 23
    //   762: aload 9
    //   764: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload 11
    //   770: ldc 26
    //   772: aload_0
    //   773: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   776: pop
    //   777: aload 11
    //   779: areturn
    //   780: iload 4
    //   782: i2f
    //   783: aload 12
    //   785: invokevirtual 383	android/graphics/Bitmap:getHeight	()I
    //   788: i2f
    //   789: fdiv
    //   790: fstore 5
    //   792: goto -245 -> 547
    //   795: fload 5
    //   797: fneg
    //   798: fstore 6
    //   800: aload 10
    //   802: fload 6
    //   804: fload 5
    //   806: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   809: goto -188 -> 621
    //   812: astore 13
    //   814: aload 10
    //   816: fload 5
    //   818: fload 5
    //   820: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   823: goto -202 -> 621
    //   826: aload 10
    //   828: fload 5
    //   830: fload 5
    //   832: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   835: aload 10
    //   837: ldc_w 388
    //   840: invokevirtual 392	android/graphics/Matrix:postRotate	(F)Z
    //   843: pop
    //   844: goto -223 -> 621
    //   847: aload 10
    //   849: fload 5
    //   851: fload 5
    //   853: fneg
    //   854: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   857: goto -236 -> 621
    //   860: aload 10
    //   862: fload 5
    //   864: fload 5
    //   866: fneg
    //   867: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   870: aload 10
    //   872: ldc_w 393
    //   875: invokevirtual 392	android/graphics/Matrix:postRotate	(F)Z
    //   878: pop
    //   879: goto -258 -> 621
    //   882: aload 10
    //   884: fload 5
    //   886: fload 5
    //   888: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   891: aload 10
    //   893: ldc_w 393
    //   896: invokevirtual 392	android/graphics/Matrix:postRotate	(F)Z
    //   899: pop
    //   900: goto -279 -> 621
    //   903: aload 10
    //   905: fload 5
    //   907: fneg
    //   908: fload 5
    //   910: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   913: aload 10
    //   915: ldc_w 393
    //   918: invokevirtual 392	android/graphics/Matrix:postRotate	(F)Z
    //   921: pop
    //   922: goto -301 -> 621
    //   925: aload 10
    //   927: fload 5
    //   929: fload 5
    //   931: invokevirtual 380	android/graphics/Matrix:setScale	(FF)V
    //   934: aload 10
    //   936: ldc_w 394
    //   939: invokevirtual 392	android/graphics/Matrix:postRotate	(F)Z
    //   942: pop
    //   943: goto -322 -> 621
    //   946: new 145	java/lang/StringBuilder
    //   949: dup
    //   950: ldc_w 316
    //   953: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   956: astore 9
    //   958: aload 10
    //   960: getstatic 242	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   963: bipush 80
    //   965: aload 12
    //   967: invokevirtual 248	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   970: pop
    //   971: goto -242 -> 729
    //   974: astore_0
    //   975: aconst_null
    //   976: astore 9
    //   978: goto -723 -> 255
    //   981: goto -369 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramString	String
    //   0	984	1	paramInt1	int
    //   0	984	2	paramInt2	int
    //   0	984	3	paramInt3	int
    //   0	984	4	paramInt4	int
    //   545	385	5	f1	float
    //   798	5	6	f2	float
    //   66	463	7	m	int
    //   73	460	8	n	int
    //   46	931	9	localObject1	Object
    //   17	942	10	localObject2	Object
    //   7	771	11	localJSONObject	JSONObject
    //   218	748	12	localObject3	Object
    //   374	15	13	arrayOfByte	byte[]
    //   812	1	13	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   141	159	250	finally
    //   173	185	250	finally
    //   185	220	250	finally
    //   220	228	250	finally
    //   233	250	250	finally
    //   279	291	250	finally
    //   307	319	250	finally
    //   334	346	250	finally
    //   349	361	250	finally
    //   371	398	250	finally
    //   401	413	250	finally
    //   416	444	250	finally
    //   556	612	812	java/io/IOException
    //   612	621	812	java/io/IOException
    //   800	809	812	java/io/IOException
    //   826	844	812	java/io/IOException
    //   847	857	812	java/io/IOException
    //   860	879	812	java/io/IOException
    //   882	900	812	java/io/IOException
    //   903	922	812	java/io/IOException
    //   925	943	812	java/io/IOException
    //   130	141	974	finally
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: aload_3
    //   4: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +1123 -> 1130
    //   10: ldc_w 411
    //   13: aload 4
    //   15: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifne +13 -> 31
    //   21: ldc 41
    //   23: aload 4
    //   25: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +500 -> 528
    //   31: aload 5
    //   33: arraylength
    //   34: iconst_1
    //   35: if_icmpne +493 -> 528
    //   38: new 254	org/json/JSONObject
    //   41: dup
    //   42: aload 5
    //   44: iconst_0
    //   45: aaload
    //   46: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: ldc 41
    //   52: aload 4
    //   54: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +13 -> 70
    //   60: aload_1
    //   61: ldc_w 414
    //   64: aload 4
    //   66: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload_1
    //   71: ldc 17
    //   73: invokevirtual 418	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_3
    //   78: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +5 -> 86
    //   84: iconst_1
    //   85: ireturn
    //   86: aload_1
    //   87: ldc_w 426
    //   90: iconst_0
    //   91: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   94: istore 6
    //   96: invokestatic 199	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   99: astore_2
    //   100: iload 6
    //   102: ifne +163 -> 265
    //   105: aload_0
    //   106: getfield 433	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   109: invokevirtual 438	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   112: astore 4
    //   114: aload 4
    //   116: instanceof 440
    //   119: ifeq +123 -> 242
    //   122: new 178	android/content/Intent
    //   125: dup
    //   126: invokespecial 441	android/content/Intent:<init>	()V
    //   129: astore_3
    //   130: aload_3
    //   131: aload 4
    //   133: ldc_w 443
    //   136: invokevirtual 447	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   139: pop
    //   140: aload_3
    //   141: ldc_w 449
    //   144: aload 4
    //   146: invokevirtual 455	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 458	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 462	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_3
    //   157: ldc_w 464
    //   160: ldc_w 466
    //   163: invokevirtual 462	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   166: pop
    //   167: aload_1
    //   168: ldc_w 467
    //   171: iconst_1
    //   172: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   175: istore 6
    //   177: aload_3
    //   178: ldc_w 469
    //   181: iload 6
    //   183: invokevirtual 472	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   186: pop
    //   187: iload 6
    //   189: iconst_1
    //   190: if_icmpne +12 -> 202
    //   193: aload_3
    //   194: ldc_w 474
    //   197: iconst_1
    //   198: invokevirtual 477	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   201: pop
    //   202: aload 4
    //   204: checkcast 440	com/tencent/mobileqq/activity/QQBrowserActivity
    //   207: aload_0
    //   208: aload_3
    //   209: iconst_2
    //   210: invokevirtual 480	com/tencent/mobileqq/activity/QQBrowserActivity:a	(Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin;Landroid/content/Intent;B)V
    //   213: aload_2
    //   214: invokestatic 486	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   217: invokeinterface 492 1 0
    //   222: ldc 14
    //   224: aload_1
    //   225: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   228: invokeinterface 499 3 0
    //   233: invokeinterface 502 1 0
    //   238: pop
    //   239: goto +893 -> 1132
    //   242: aload_0
    //   243: aload_3
    //   244: iconst_2
    //   245: anewarray 137	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: ldc_w 504
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: ldc_w 506
    //   259: aastore
    //   260: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   263: iconst_1
    //   264: ireturn
    //   265: iload 6
    //   267: iconst_1
    //   268: if_icmpne +864 -> 1132
    //   271: new 88	java/io/File
    //   274: dup
    //   275: new 145	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   282: getstatic 513	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   285: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 515
    //   291: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: astore 4
    //   302: aload 4
    //   304: invokevirtual 220	java/io/File:exists	()Z
    //   307: ifne +46 -> 353
    //   310: aload 4
    //   312: invokevirtual 100	java/io/File:mkdirs	()Z
    //   315: ifne +38 -> 353
    //   318: aload_2
    //   319: ldc_w 516
    //   322: iconst_0
    //   323: invokestatic 521	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   326: invokevirtual 524	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   329: pop
    //   330: aload_0
    //   331: aload_3
    //   332: iconst_2
    //   333: anewarray 137	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: ldc_w 504
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: ldc_w 506
    //   347: aastore
    //   348: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   351: iconst_1
    //   352: ireturn
    //   353: new 145	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   360: getstatic 513	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   363: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 515
    //   369: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   375: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: ldc 143
    //   380: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore_3
    //   387: new 88	java/io/File
    //   390: dup
    //   391: aload_3
    //   392: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   395: invokestatic 528	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   398: astore 4
    //   400: new 178	android/content/Intent
    //   403: dup
    //   404: ldc_w 530
    //   407: invokespecial 181	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   410: astore 5
    //   412: aload 5
    //   414: ldc_w 532
    //   417: aload 4
    //   419: invokevirtual 535	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   422: pop
    //   423: aload 5
    //   425: ldc_w 537
    //   428: bipush 100
    //   430: invokevirtual 472	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   433: pop
    //   434: aload_1
    //   435: ldc_w 539
    //   438: iconst_0
    //   439: invokevirtual 543	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   442: ifeq +13 -> 455
    //   445: aload 5
    //   447: ldc_w 545
    //   450: iconst_1
    //   451: invokevirtual 472	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   454: pop
    //   455: aload_0
    //   456: aload 5
    //   458: iconst_1
    //   459: invokevirtual 549	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   462: aload_2
    //   463: invokestatic 486	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   466: invokeinterface 492 1 0
    //   471: ldc_w 551
    //   474: aload_3
    //   475: invokeinterface 499 3 0
    //   480: ldc 14
    //   482: aload_1
    //   483: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   486: invokeinterface 499 3 0
    //   491: invokeinterface 502 1 0
    //   496: pop
    //   497: goto +635 -> 1132
    //   500: astore_1
    //   501: aload_1
    //   502: invokevirtual 554	java/lang/Exception:printStackTrace	()V
    //   505: aload_2
    //   506: ldc_w 555
    //   509: iconst_0
    //   510: invokestatic 521	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   513: invokevirtual 524	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   516: pop
    //   517: goto +615 -> 1132
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 556	org/json/JSONException:printStackTrace	()V
    //   525: goto +607 -> 1132
    //   528: ldc_w 558
    //   531: aload 4
    //   533: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   536: ifne +13 -> 549
    //   539: ldc 44
    //   541: aload 4
    //   543: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   546: ifeq +221 -> 767
    //   549: aload 5
    //   551: arraylength
    //   552: iconst_1
    //   553: if_icmpne +214 -> 767
    //   556: new 254	org/json/JSONObject
    //   559: dup
    //   560: aload 5
    //   562: iconst_0
    //   563: aaload
    //   564: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   567: astore_1
    //   568: aload_1
    //   569: ldc 17
    //   571: invokevirtual 418	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   574: astore_2
    //   575: aload_1
    //   576: ldc 26
    //   578: invokevirtual 418	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: astore_3
    //   582: aload_2
    //   583: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   586: ifne +548 -> 1134
    //   589: aload_3
    //   590: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   593: ifeq +6 -> 599
    //   596: goto +538 -> 1134
    //   599: aload_0
    //   600: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   603: ifnonnull +54 -> 657
    //   606: aload_0
    //   607: getfield 433	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   610: invokevirtual 438	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   613: astore 5
    //   615: aload_0
    //   616: new 562	com/tencent/mobileqq/widget/QQProgressDialog
    //   619: dup
    //   620: aload 5
    //   622: aload 5
    //   624: invokevirtual 568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   627: ldc_w 569
    //   630: invokevirtual 575	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   633: invokespecial 578	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   636: putfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   639: aload_0
    //   640: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   643: ldc_w 579
    //   646: invokevirtual 581	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   649: aload_0
    //   650: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   653: aload_0
    //   654: invokevirtual 584	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   657: aload_0
    //   658: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   661: invokevirtual 587	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   664: ifne +10 -> 674
    //   667: aload_0
    //   668: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   671: invokevirtual 590	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   674: ldc 44
    //   676: aload 4
    //   678: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifeq +34 -> 715
    //   684: new 592	dwm
    //   687: dup
    //   688: aload_0
    //   689: aload_2
    //   690: aload_1
    //   691: ldc 38
    //   693: iconst_0
    //   694: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   697: aload_3
    //   698: invokespecial 595	dwm:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   701: invokevirtual 598	dwm:start	()V
    //   704: goto +428 -> 1132
    //   707: astore_1
    //   708: aload_1
    //   709: invokevirtual 556	org/json/JSONException:printStackTrace	()V
    //   712: goto +420 -> 1132
    //   715: new 600	dwl
    //   718: dup
    //   719: aload_0
    //   720: aload_2
    //   721: aload_1
    //   722: ldc_w 602
    //   725: sipush 1280
    //   728: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   731: aload_1
    //   732: ldc_w 604
    //   735: sipush 1280
    //   738: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   741: aload_1
    //   742: ldc_w 606
    //   745: iconst_1
    //   746: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   749: aload_1
    //   750: ldc_w 608
    //   753: iconst_1
    //   754: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   757: aload_3
    //   758: invokespecial 611	dwl:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   761: invokevirtual 612	dwl:start	()V
    //   764: goto +368 -> 1132
    //   767: ldc_w 614
    //   770: aload 4
    //   772: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   775: ifeq +357 -> 1132
    //   778: aload 5
    //   780: arraylength
    //   781: iconst_1
    //   782: if_icmpne +350 -> 1132
    //   785: aconst_null
    //   786: astore_2
    //   787: new 616	java/util/concurrent/atomic/AtomicBoolean
    //   790: dup
    //   791: iconst_0
    //   792: invokespecial 619	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   795: astore_3
    //   796: aload_2
    //   797: astore_1
    //   798: new 254	org/json/JSONObject
    //   801: dup
    //   802: aload 5
    //   804: iconst_0
    //   805: aaload
    //   806: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   809: astore 4
    //   811: aload_2
    //   812: astore_1
    //   813: aload 4
    //   815: ldc 17
    //   817: invokevirtual 418	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   820: astore_2
    //   821: aload_2
    //   822: astore_1
    //   823: aload 4
    //   825: ldc_w 621
    //   828: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   831: astore 4
    //   833: aload_2
    //   834: astore_1
    //   835: aload 4
    //   837: ldc_w 626
    //   840: invokevirtual 629	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   843: ifne +16 -> 859
    //   846: aload_2
    //   847: astore_1
    //   848: aload 4
    //   850: ldc_w 631
    //   853: invokevirtual 629	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   856: ifeq +213 -> 1069
    //   859: aload_2
    //   860: astore_1
    //   861: aload_0
    //   862: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   865: ifnonnull +62 -> 927
    //   868: aload_2
    //   869: astore_1
    //   870: aload_0
    //   871: getfield 433	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   874: invokevirtual 438	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   877: astore 5
    //   879: aload_2
    //   880: astore_1
    //   881: aload_0
    //   882: new 562	com/tencent/mobileqq/widget/QQProgressDialog
    //   885: dup
    //   886: aload 5
    //   888: aload 5
    //   890: invokevirtual 568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   893: ldc_w 569
    //   896: invokevirtual 575	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   899: invokespecial 578	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   902: putfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   905: aload_2
    //   906: astore_1
    //   907: aload_0
    //   908: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   911: ldc_w 579
    //   914: invokevirtual 581	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   917: aload_2
    //   918: astore_1
    //   919: aload_0
    //   920: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   923: aload_0
    //   924: invokevirtual 584	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   927: aload_2
    //   928: astore_1
    //   929: aload_0
    //   930: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   933: invokevirtual 587	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   936: ifne +12 -> 948
    //   939: aload_2
    //   940: astore_1
    //   941: aload_0
    //   942: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   945: invokevirtual 590	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   948: aload_2
    //   949: astore_1
    //   950: new 633	dwh
    //   953: dup
    //   954: aload_0
    //   955: aload 4
    //   957: aload_2
    //   958: aload_3
    //   959: invokespecial 636	dwh:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   962: invokestatic 641	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)V
    //   965: goto +167 -> 1132
    //   968: astore_2
    //   969: invokestatic 644	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   972: ifeq +30 -> 1002
    //   975: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   978: iconst_4
    //   979: new 145	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   986: ldc_w 646
    //   989: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: aload_2
    //   993: invokevirtual 649	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   996: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1002: aload_1
    //   1003: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +126 -> 1132
    //   1009: aload_3
    //   1010: iconst_0
    //   1011: iconst_1
    //   1012: invokevirtual 653	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1015: ifeq +117 -> 1132
    //   1018: new 254	org/json/JSONObject
    //   1021: dup
    //   1022: invokespecial 255	org/json/JSONObject:<init>	()V
    //   1025: astore_2
    //   1026: aload_2
    //   1027: ldc 29
    //   1029: iconst_m1
    //   1030: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1033: pop
    //   1034: aload_2
    //   1035: ldc 32
    //   1037: invokestatic 199	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   1040: ldc_w 654
    //   1043: invokevirtual 657	android/content/Context:getString	(I)Ljava/lang/String;
    //   1046: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1049: pop
    //   1050: aload_0
    //   1051: aload_1
    //   1052: iconst_1
    //   1053: anewarray 137	java/lang/String
    //   1056: dup
    //   1057: iconst_0
    //   1058: aload_2
    //   1059: invokevirtual 493	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1062: aastore
    //   1063: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1066: goto +66 -> 1132
    //   1069: aload_2
    //   1070: astore_1
    //   1071: new 659	dwi
    //   1074: dup
    //   1075: aload_0
    //   1076: aload 4
    //   1078: aload_2
    //   1079: aload_3
    //   1080: invokespecial 660	dwi:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1083: invokestatic 662	com/tencent/mobileqq/app/ThreadManager:b	(Ljava/lang/Runnable;)V
    //   1086: goto +46 -> 1132
    //   1089: astore_1
    //   1090: invokestatic 644	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1093: ifeq +39 -> 1132
    //   1096: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1099: iconst_4
    //   1100: new 145	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1107: ldc_w 646
    //   1110: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_1
    //   1114: invokevirtual 649	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1123: goto +9 -> 1132
    //   1126: astore_3
    //   1127: goto -77 -> 1050
    //   1130: iconst_0
    //   1131: ireturn
    //   1132: iconst_1
    //   1133: ireturn
    //   1134: iconst_1
    //   1135: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	MediaApiPlugin
    //   0	1136	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	1136	2	paramString1	String
    //   0	1136	3	paramString2	String
    //   0	1136	4	paramString3	String
    //   0	1136	5	paramVarArgs	String[]
    //   94	175	6	m	int
    // Exception table:
    //   from	to	target	type
    //   455	497	500	java/lang/Exception
    //   38	70	520	org/json/JSONException
    //   70	84	520	org/json/JSONException
    //   86	100	520	org/json/JSONException
    //   105	187	520	org/json/JSONException
    //   193	202	520	org/json/JSONException
    //   202	239	520	org/json/JSONException
    //   242	263	520	org/json/JSONException
    //   271	351	520	org/json/JSONException
    //   353	455	520	org/json/JSONException
    //   455	497	520	org/json/JSONException
    //   501	517	520	org/json/JSONException
    //   556	596	707	org/json/JSONException
    //   599	657	707	org/json/JSONException
    //   657	674	707	org/json/JSONException
    //   674	704	707	org/json/JSONException
    //   715	764	707	org/json/JSONException
    //   798	811	968	java/lang/OutOfMemoryError
    //   813	821	968	java/lang/OutOfMemoryError
    //   823	833	968	java/lang/OutOfMemoryError
    //   835	846	968	java/lang/OutOfMemoryError
    //   848	859	968	java/lang/OutOfMemoryError
    //   861	868	968	java/lang/OutOfMemoryError
    //   870	879	968	java/lang/OutOfMemoryError
    //   881	905	968	java/lang/OutOfMemoryError
    //   907	917	968	java/lang/OutOfMemoryError
    //   919	927	968	java/lang/OutOfMemoryError
    //   929	939	968	java/lang/OutOfMemoryError
    //   941	948	968	java/lang/OutOfMemoryError
    //   950	965	968	java/lang/OutOfMemoryError
    //   1071	1086	968	java/lang/OutOfMemoryError
    //   798	811	1089	org/json/JSONException
    //   813	821	1089	org/json/JSONException
    //   823	833	1089	org/json/JSONException
    //   835	846	1089	org/json/JSONException
    //   848	859	1089	org/json/JSONException
    //   861	868	1089	org/json/JSONException
    //   870	879	1089	org/json/JSONException
    //   881	905	1089	org/json/JSONException
    //   907	917	1089	org/json/JSONException
    //   919	927	1089	org/json/JSONException
    //   929	939	1089	org/json/JSONException
    //   941	948	1089	org/json/JSONException
    //   950	965	1089	org/json/JSONException
    //   1071	1086	1089	org/json/JSONException
    //   1026	1050	1126	org/json/JSONException
  }
  
  /* Error */
  public void onActivityResult(android.content.Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 666	com/tencent/mobileqq/webviewplugin/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpeq +8 -> 17
    //   12: iload_2
    //   13: iconst_2
    //   14: if_icmpne +83 -> 97
    //   17: invokestatic 199	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   20: astore 6
    //   22: aload 6
    //   24: invokestatic 486	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   27: astore 7
    //   29: aload 7
    //   31: ldc_w 551
    //   34: ldc_w 668
    //   37: invokeinterface 671 3 0
    //   42: astore 8
    //   44: aload 7
    //   46: ldc 14
    //   48: ldc_w 668
    //   51: invokeinterface 671 3 0
    //   56: astore 7
    //   58: aload 6
    //   60: invokestatic 486	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   63: invokeinterface 492 1 0
    //   68: ldc_w 551
    //   71: invokeinterface 675 2 0
    //   76: ldc 14
    //   78: invokeinterface 675 2 0
    //   83: invokeinterface 502 1 0
    //   88: pop
    //   89: aload 7
    //   91: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +4 -> 98
    //   97: return
    //   98: new 254	org/json/JSONObject
    //   101: dup
    //   102: aload 7
    //   104: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 17
    //   113: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: invokestatic 424	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: istore 5
    //   125: iload 5
    //   127: ifne -30 -> 97
    //   130: iload_3
    //   131: iconst_m1
    //   132: if_icmpne +428 -> 560
    //   135: iload_2
    //   136: iconst_1
    //   137: if_icmpne +111 -> 248
    //   140: iconst_1
    //   141: anewarray 137	java/lang/String
    //   144: astore_1
    //   145: aload_1
    //   146: iconst_0
    //   147: aload 8
    //   149: aastore
    //   150: aload 7
    //   152: ldc_w 677
    //   155: iconst_0
    //   156: invokevirtual 543	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   159: ifeq +207 -> 366
    //   162: new 679	org/json/JSONArray
    //   165: dup
    //   166: invokespecial 680	org/json/JSONArray:<init>	()V
    //   169: astore 7
    //   171: aload_1
    //   172: arraylength
    //   173: istore 4
    //   175: iconst_0
    //   176: istore_3
    //   177: iload_3
    //   178: iload 4
    //   180: if_icmpge +137 -> 317
    //   183: aload_1
    //   184: iload_3
    //   185: aaload
    //   186: astore 8
    //   188: new 254	org/json/JSONObject
    //   191: dup
    //   192: invokespecial 255	org/json/JSONObject:<init>	()V
    //   195: astore 9
    //   197: aload 9
    //   199: ldc 23
    //   201: ldc_w 668
    //   204: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 9
    //   210: ldc 26
    //   212: aload 8
    //   214: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 9
    //   220: ldc 20
    //   222: iconst_0
    //   223: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 7
    //   229: aload 9
    //   231: invokevirtual 683	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   234: pop
    //   235: iload_3
    //   236: iconst_1
    //   237: iadd
    //   238: istore_3
    //   239: goto -62 -> 177
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 556	org/json/JSONException:printStackTrace	()V
    //   247: return
    //   248: aload_1
    //   249: ifnull +45 -> 294
    //   252: aload_1
    //   253: ldc_w 685
    //   256: invokevirtual 689	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +10 -> 271
    //   264: aload_1
    //   265: invokevirtual 694	java/util/ArrayList:size	()I
    //   268: ifne +31 -> 299
    //   271: aload_0
    //   272: aload 6
    //   274: iconst_2
    //   275: anewarray 137	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 504
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: ldc_w 506
    //   289: aastore
    //   290: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   293: return
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -36 -> 260
    //   299: aload_1
    //   300: aload_1
    //   301: invokevirtual 694	java/util/ArrayList:size	()I
    //   304: anewarray 137	java/lang/String
    //   307: invokevirtual 698	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   310: checkcast 700	[Ljava/lang/String;
    //   313: astore_1
    //   314: goto -164 -> 150
    //   317: aload_0
    //   318: aload 6
    //   320: iconst_2
    //   321: anewarray 137	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 702
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload 7
    //   334: invokevirtual 703	org/json/JSONArray:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   341: return
    //   342: astore_1
    //   343: aload_0
    //   344: aload 6
    //   346: iconst_2
    //   347: anewarray 137	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: ldc_w 504
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: ldc_w 506
    //   361: aastore
    //   362: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   365: return
    //   366: aload_0
    //   367: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   370: ifnonnull +54 -> 424
    //   373: aload_0
    //   374: getfield 433	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   377: invokevirtual 438	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   380: astore 8
    //   382: aload_0
    //   383: new 562	com/tencent/mobileqq/widget/QQProgressDialog
    //   386: dup
    //   387: aload 8
    //   389: aload 8
    //   391: invokevirtual 568	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   394: ldc_w 569
    //   397: invokevirtual 575	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   400: invokespecial 578	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   403: putfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   406: aload_0
    //   407: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   410: ldc_w 579
    //   413: invokevirtual 581	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   416: aload_0
    //   417: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   420: aload_0
    //   421: invokevirtual 584	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   424: aload_0
    //   425: getfield 396	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   428: ifnull +10 -> 438
    //   431: aload_0
    //   432: getfield 396	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   435: invokevirtual 399	java/lang/Thread:interrupt	()V
    //   438: aload_0
    //   439: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   442: invokevirtual 587	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifne +10 -> 455
    //   448: aload_0
    //   449: getfield 560	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   452: invokevirtual 590	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   455: ldc 41
    //   457: aload 7
    //   459: ldc_w 414
    //   462: invokevirtual 418	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +34 -> 502
    //   471: aload_0
    //   472: new 705	dwk
    //   475: dup
    //   476: aload_0
    //   477: aload 6
    //   479: aload 7
    //   481: ldc 38
    //   483: iconst_0
    //   484: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   487: aload_1
    //   488: invokespecial 708	dwk:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;I[Ljava/lang/String;)V
    //   491: putfield 396	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   494: aload_0
    //   495: getfield 396	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   498: invokevirtual 709	java/lang/Thread:start	()V
    //   501: return
    //   502: aload_0
    //   503: new 711	dwj
    //   506: dup
    //   507: aload_0
    //   508: aload 6
    //   510: aload 7
    //   512: ldc_w 602
    //   515: sipush 1280
    //   518: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   521: aload 7
    //   523: ldc_w 604
    //   526: sipush 1280
    //   529: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   532: aload 7
    //   534: ldc_w 606
    //   537: iconst_1
    //   538: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   541: aload 7
    //   543: ldc_w 608
    //   546: iconst_1
    //   547: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   550: aload_1
    //   551: invokespecial 714	dwj:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIII[Ljava/lang/String;)V
    //   554: putfield 396	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   557: goto -63 -> 494
    //   560: aload_0
    //   561: aload 6
    //   563: iconst_2
    //   564: anewarray 137	java/lang/String
    //   567: dup
    //   568: iconst_0
    //   569: ldc_w 716
    //   572: aastore
    //   573: dup
    //   574: iconst_1
    //   575: ldc_w 506
    //   578: aastore
    //   579: invokevirtual 510	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   582: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	MediaApiPlugin
    //   0	583	1	paramIntent	android.content.Intent
    //   0	583	2	paramByte	byte
    //   0	583	3	paramInt	int
    //   173	8	4	m	int
    //   123	3	5	bool	boolean
    //   20	542	6	localObject1	Object
    //   27	515	7	localObject2	Object
    //   42	348	8	localObject3	Object
    //   195	35	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   98	125	242	org/json/JSONException
    //   162	175	342	org/json/JSONException
    //   188	235	342	org/json/JSONException
    //   317	341	342	org/json/JSONException
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */