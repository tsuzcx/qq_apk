import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(9)
public class aeah
{
  public static boolean bSF;
  public static boolean bSG = true;
  
  public static Bitmap H(Bitmap paramBitmap)
  {
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio bmpWidth=" + j + " bmpHeight=" + i + " screenWidth=" + ankt.SCREEN_WIDTH + " screenHeight=" + ankt.cIE);
    }
    if (i < j) {
      return paramBitmap;
    }
    double d = ankt.cIE * 1.0D / ankt.SCREEN_WIDTH;
    if (d > i * 1.0D / j)
    {
      k = (int)(i / d);
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetWidth=" + k + " bmpWidth=" + j);
      }
      return Bitmap.createBitmap(paramBitmap, 0, 0, k, i);
    }
    int k = (int)(d * j);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetHeight=" + k + " bmpHeight=" + i);
    }
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, k);
  }
  
  public static int a(aeab paramaeab, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    Camera.CameraInfo localCameraInfo = paramaeab.a()[paramInt1];
    if (localCameraInfo.facing == 1) {
      return (paramaeab.a().av(paramInt1, localCameraInfo.orientation) - i + 360) % 360;
    }
    return (paramaeab.a().av(paramInt1, localCameraInfo.orientation) + i) % 360;
  }
  
  @TargetApi(10)
  public static Bitmap a(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
    throws IOException, OutOfMemoryError
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    double d4;
    double d5;
    double d1;
    double d2;
    double d3;
    if (j > i)
    {
      paramInt = 1;
      d4 = 1.0D * Math.max(i, j) / Math.min(i, j);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = j;
      d2 = i;
      if (d4 <= d5) {
        break label337;
      }
      if (paramInt == 0) {
        break label319;
      }
      d3 = d5 * d2;
      d1 = d2;
      d2 = d3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + j + " bh=" + i + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      d3 = (j - d2) / 2.0D;
      d4 = (j + d2) / 2.0D;
      d5 = (i - d1) / 2.0D;
      double d6 = (i + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        return paramRect;
        paramInt = 0;
        break;
        label319:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label337:
        if (d4 >= d5) {
          break label451;
        }
        if (paramInt != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5 * d2;
        d1 = d2;
        d2 = d3;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D));
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label451:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramMatrix.reset();
    int i;
    int j;
    if (paramInt2 < paramInt3)
    {
      i = 1;
      j = paramInt2;
      if (i != 0)
      {
        j = paramInt2;
        if (paramInt4 != 0) {
          j = paramInt3 * paramInt5 / paramInt4;
        }
      }
      if (!paramBoolean) {
        break label100;
      }
    }
    label100:
    for (float f = -1.0F;; f = 1.0F)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt1);
      paramMatrix.postScale(j / 2000.0F, paramInt3 / 2000.0F);
      paramMatrix.postTranslate(j / 2.0F, paramInt3 / 2.0F);
      return;
      i = 0;
      break;
    }
  }
  
  /* Error */
  private static boolean a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
    throws XmlPullParserException, IOException
  {
    // Byte code:
    //   0: ldc 34
    //   2: iconst_4
    //   3: ldc 222
    //   5: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_1
    //   9: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: ldc 34
    //   17: iconst_4
    //   18: ldc 230
    //   20: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iconst_0
    //   26: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: astore 6
    //   31: aload 6
    //   33: astore 5
    //   35: invokestatic 244	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   38: invokevirtual 248	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   41: astore 7
    //   43: aload 6
    //   45: astore 5
    //   47: aload 7
    //   49: new 250	java/io/StringReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 253	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   57: invokeinterface 259 2 0
    //   62: aload 6
    //   64: astore 5
    //   66: aload 7
    //   68: invokeinterface 262 1 0
    //   73: istore_3
    //   74: aload 6
    //   76: astore 5
    //   78: aload_0
    //   79: invokeinterface 268 1 0
    //   84: astore 8
    //   86: aload 6
    //   88: astore 5
    //   90: aload 8
    //   92: invokeinterface 273 1 0
    //   97: pop
    //   98: aload 6
    //   100: astore 5
    //   102: aload 8
    //   104: ldc_w 275
    //   107: iload_2
    //   108: invokeinterface 279 3 0
    //   113: pop
    //   114: aload 6
    //   116: astore 5
    //   118: invokestatic 284	aeag:a	()Laeag;
    //   121: invokevirtual 287	aeag:ta	()Ljava/lang/String;
    //   124: astore 9
    //   126: aload 6
    //   128: astore 5
    //   130: new 36	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   137: aload 9
    //   139: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 289
    //   145: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 295	android/os/Build:DISPLAY	Ljava/lang/String;
    //   151: ldc_w 297
    //   154: ldc_w 289
    //   157: invokevirtual 303	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   160: invokevirtual 306	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   163: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 10
    //   171: aload 6
    //   173: astore 5
    //   175: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +737 -> 915
    //   181: aload 6
    //   183: astore 5
    //   185: ldc 34
    //   187: iconst_4
    //   188: new 36	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 308
    //   198: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 9
    //   203: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 310
    //   209: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 10
    //   214: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: goto +692 -> 915
    //   226: aload_0
    //   227: astore 5
    //   229: aload 7
    //   231: invokeinterface 313 1 0
    //   236: istore_2
    //   237: goto +686 -> 923
    //   240: goto -14 -> 226
    //   243: aload 7
    //   245: invokeinterface 316 1 0
    //   250: astore_1
    //   251: aload_1
    //   252: aload 9
    //   254: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   257: ifeq +342 -> 599
    //   260: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +51 -> 314
    //   266: ldc 34
    //   268: iconst_4
    //   269: new 36	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 322
    //   279: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 324
    //   289: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 9
    //   294: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 310
    //   300: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 10
    //   305: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload 7
    //   316: invokeinterface 330 1 0
    //   321: istore_3
    //   322: iconst_0
    //   323: istore_2
    //   324: iload_2
    //   325: iload_3
    //   326: if_icmpge +263 -> 589
    //   329: aload 7
    //   331: iload_2
    //   332: invokeinterface 334 2 0
    //   337: astore_1
    //   338: aload 7
    //   340: iload_2
    //   341: invokeinterface 337 2 0
    //   346: astore 5
    //   348: aload_1
    //   349: ldc_w 339
    //   352: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   355: ifeq +74 -> 429
    //   358: aload 5
    //   360: invokestatic 342	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   363: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   366: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   369: istore 4
    //   371: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +589 -> 963
    //   377: ldc 34
    //   379: iconst_4
    //   380: new 36	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 347
    //   390: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_2
    //   394: iconst_1
    //   395: iadd
    //   396: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: ldc_w 349
    //   402: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_1
    //   406: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 351
    //   412: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 5
    //   417: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: goto +537 -> 963
    //   429: aload_1
    //   430: ldc_w 353
    //   433: invokevirtual 356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   436: ifeq +40 -> 476
    //   439: aload 8
    //   441: aload_1
    //   442: aload 5
    //   444: invokestatic 362	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   447: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: invokevirtual 368	java/lang/Integer:intValue	()I
    //   453: invokeinterface 279 3 0
    //   458: pop
    //   459: goto -88 -> 371
    //   462: astore_0
    //   463: ldc 34
    //   465: iconst_1
    //   466: aload_0
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   474: aload_0
    //   475: athrow
    //   476: aload_1
    //   477: ldc_w 373
    //   480: invokevirtual 356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   483: ifeq +34 -> 517
    //   486: aload 8
    //   488: aload_1
    //   489: aload 5
    //   491: invokestatic 376	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   494: invokeinterface 380 3 0
    //   499: pop
    //   500: goto -129 -> 371
    //   503: astore_0
    //   504: ldc 34
    //   506: iconst_1
    //   507: aload_0
    //   508: iconst_0
    //   509: anewarray 4	java/lang/Object
    //   512: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: athrow
    //   517: aload 8
    //   519: aload_1
    //   520: aload 5
    //   522: invokestatic 342	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   525: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   528: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   531: invokeinterface 384 3 0
    //   536: pop
    //   537: goto -166 -> 371
    //   540: astore_1
    //   541: ldc 34
    //   543: iconst_1
    //   544: aload_1
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   552: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +29 -> 584
    //   558: ldc 34
    //   560: iconst_4
    //   561: new 36	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 386
    //   571: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: aload_0
    //   585: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   588: ireturn
    //   589: iconst_1
    //   590: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   593: astore_1
    //   594: aload_1
    //   595: astore_0
    //   596: goto -370 -> 226
    //   599: ldc_w 391
    //   602: aload_1
    //   603: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   606: ifeq +354 -> 960
    //   609: aload 7
    //   611: invokeinterface 330 1 0
    //   616: istore_3
    //   617: iconst_0
    //   618: istore_2
    //   619: iload_2
    //   620: iload_3
    //   621: if_icmpge +356 -> 977
    //   624: aload 7
    //   626: iload_2
    //   627: invokeinterface 334 2 0
    //   632: astore_1
    //   633: aload 7
    //   635: iload_2
    //   636: invokeinterface 337 2 0
    //   641: astore 5
    //   643: aload_1
    //   644: ldc_w 339
    //   647: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   650: ifeq +74 -> 724
    //   653: aload 5
    //   655: invokestatic 342	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   658: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   661: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   664: istore 4
    //   666: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +301 -> 970
    //   672: ldc 34
    //   674: iconst_4
    //   675: new 36	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 393
    //   685: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload_2
    //   689: iconst_1
    //   690: iadd
    //   691: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: ldc_w 349
    //   697: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload_1
    //   701: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: ldc_w 351
    //   707: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload 5
    //   712: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: goto +249 -> 970
    //   724: aload_1
    //   725: ldc_w 353
    //   728: invokevirtual 356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   731: ifeq +26 -> 757
    //   734: aload 8
    //   736: aload_1
    //   737: aload 5
    //   739: invokestatic 362	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   742: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   745: invokevirtual 368	java/lang/Integer:intValue	()I
    //   748: invokeinterface 279 3 0
    //   753: pop
    //   754: goto -88 -> 666
    //   757: aload_1
    //   758: ldc_w 373
    //   761: invokevirtual 356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   764: ifeq +20 -> 784
    //   767: aload 8
    //   769: aload_1
    //   770: aload 5
    //   772: invokestatic 376	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   775: invokeinterface 380 3 0
    //   780: pop
    //   781: goto -115 -> 666
    //   784: aload 8
    //   786: aload_1
    //   787: aload 5
    //   789: invokestatic 342	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   792: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   795: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   798: invokeinterface 384 3 0
    //   803: pop
    //   804: goto -138 -> 666
    //   807: aload_0
    //   808: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   811: ifeq +54 -> 865
    //   814: aload 8
    //   816: ldc_w 339
    //   819: iload 4
    //   821: invokeinterface 384 3 0
    //   826: pop
    //   827: ldc 34
    //   829: iconst_1
    //   830: new 36	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   837: ldc_w 395
    //   840: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: iload 4
    //   845: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   848: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: aload 8
    //   856: invokeinterface 401 1 0
    //   861: pop
    //   862: goto -310 -> 552
    //   865: aload 8
    //   867: ldc_w 339
    //   870: iload 4
    //   872: invokeinterface 384 3 0
    //   877: pop
    //   878: ldc 34
    //   880: iconst_1
    //   881: new 36	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 403
    //   891: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: iload 4
    //   896: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   899: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: goto -51 -> 854
    //   908: astore_1
    //   909: aload 5
    //   911: astore_0
    //   912: goto -371 -> 541
    //   915: aload 6
    //   917: astore_0
    //   918: iconst_0
    //   919: istore 4
    //   921: iload_3
    //   922: istore_2
    //   923: iload_2
    //   924: iconst_1
    //   925: if_icmpeq -118 -> 807
    //   928: iload_2
    //   929: tableswitch	default:+31 -> 960, 0:+-689->240, 1:+31->960, 2:+-686->243, 3:+51->980
    //   961: <illegal opcode>
    //   962: fload_0
    //   963: iload_2
    //   964: iconst_1
    //   965: iadd
    //   966: istore_2
    //   967: goto -643 -> 324
    //   970: iload_2
    //   971: iconst_1
    //   972: iadd
    //   973: istore_2
    //   974: goto -355 -> 619
    //   977: goto -751 -> 226
    //   980: goto -754 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	983	0	paramSharedPreferences	SharedPreferences
    //   0	983	1	paramString	String
    //   0	983	2	paramInt	int
    //   73	849	3	i	int
    //   369	551	4	bool	boolean
    //   33	877	5	localObject	Object
    //   29	887	6	localBoolean	java.lang.Boolean
    //   41	593	7	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   84	782	8	localEditor	SharedPreferences.Editor
    //   124	169	9	str1	String
    //   169	135	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   35	43	462	org/xmlpull/v1/XmlPullParserException
    //   47	62	462	org/xmlpull/v1/XmlPullParserException
    //   66	74	462	org/xmlpull/v1/XmlPullParserException
    //   78	86	462	org/xmlpull/v1/XmlPullParserException
    //   90	98	462	org/xmlpull/v1/XmlPullParserException
    //   102	114	462	org/xmlpull/v1/XmlPullParserException
    //   118	126	462	org/xmlpull/v1/XmlPullParserException
    //   130	171	462	org/xmlpull/v1/XmlPullParserException
    //   175	181	462	org/xmlpull/v1/XmlPullParserException
    //   185	223	462	org/xmlpull/v1/XmlPullParserException
    //   229	237	462	org/xmlpull/v1/XmlPullParserException
    //   243	314	462	org/xmlpull/v1/XmlPullParserException
    //   314	322	462	org/xmlpull/v1/XmlPullParserException
    //   329	371	462	org/xmlpull/v1/XmlPullParserException
    //   371	426	462	org/xmlpull/v1/XmlPullParserException
    //   429	459	462	org/xmlpull/v1/XmlPullParserException
    //   476	500	462	org/xmlpull/v1/XmlPullParserException
    //   517	537	462	org/xmlpull/v1/XmlPullParserException
    //   589	594	462	org/xmlpull/v1/XmlPullParserException
    //   599	617	462	org/xmlpull/v1/XmlPullParserException
    //   624	666	462	org/xmlpull/v1/XmlPullParserException
    //   666	721	462	org/xmlpull/v1/XmlPullParserException
    //   724	754	462	org/xmlpull/v1/XmlPullParserException
    //   757	781	462	org/xmlpull/v1/XmlPullParserException
    //   784	804	462	org/xmlpull/v1/XmlPullParserException
    //   807	854	462	org/xmlpull/v1/XmlPullParserException
    //   854	862	462	org/xmlpull/v1/XmlPullParserException
    //   865	905	462	org/xmlpull/v1/XmlPullParserException
    //   35	43	503	java/io/IOException
    //   47	62	503	java/io/IOException
    //   66	74	503	java/io/IOException
    //   78	86	503	java/io/IOException
    //   90	98	503	java/io/IOException
    //   102	114	503	java/io/IOException
    //   118	126	503	java/io/IOException
    //   130	171	503	java/io/IOException
    //   175	181	503	java/io/IOException
    //   185	223	503	java/io/IOException
    //   229	237	503	java/io/IOException
    //   243	314	503	java/io/IOException
    //   314	322	503	java/io/IOException
    //   329	371	503	java/io/IOException
    //   371	426	503	java/io/IOException
    //   429	459	503	java/io/IOException
    //   476	500	503	java/io/IOException
    //   517	537	503	java/io/IOException
    //   589	594	503	java/io/IOException
    //   599	617	503	java/io/IOException
    //   624	666	503	java/io/IOException
    //   666	721	503	java/io/IOException
    //   724	754	503	java/io/IOException
    //   757	781	503	java/io/IOException
    //   784	804	503	java/io/IOException
    //   807	854	503	java/io/IOException
    //   854	862	503	java/io/IOException
    //   865	905	503	java/io/IOException
    //   243	314	540	java/lang/Exception
    //   314	322	540	java/lang/Exception
    //   329	371	540	java/lang/Exception
    //   371	426	540	java/lang/Exception
    //   429	459	540	java/lang/Exception
    //   476	500	540	java/lang/Exception
    //   517	537	540	java/lang/Exception
    //   589	594	540	java/lang/Exception
    //   599	617	540	java/lang/Exception
    //   624	666	540	java/lang/Exception
    //   666	721	540	java/lang/Exception
    //   724	754	540	java/lang/Exception
    //   757	781	540	java/lang/Exception
    //   784	804	540	java/lang/Exception
    //   807	854	540	java/lang/Exception
    //   854	862	540	java/lang/Exception
    //   865	905	540	java/lang/Exception
    //   35	43	908	java/lang/Exception
    //   47	62	908	java/lang/Exception
    //   66	74	908	java/lang/Exception
    //   78	86	908	java/lang/Exception
    //   90	98	908	java/lang/Exception
    //   102	114	908	java/lang/Exception
    //   118	126	908	java/lang/Exception
    //   130	171	908	java/lang/Exception
    //   175	181	908	java/lang/Exception
    //   185	223	908	java/lang/Exception
    //   229	237	908	java/lang/Exception
  }
  
  public static boolean afY()
  {
    int i = 2;
    Object localObject;
    boolean bool1;
    if (bSG)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
      }
      localObject = aeag.a().ta();
      String str = aeag.a().tb();
      QLog.i("Q.camera.CameraUtils", 1, "My Phone: " + (String)localObject + ",  Model: " + str);
      bool1 = aeaf.b().afX();
      boolean bool2 = afZ();
      if ((!bool1) && (bool2)) {
        break label277;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 0, qcameraDisabled=" + bool1 + " sysVerSupported=" + bool2);
      }
      if (bool1) {
        i = 1;
      }
      bool1 = false;
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "qcamera_choice_type", false, 0L, 0L, (HashMap)localObject, "");
      QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + bool1 + " choiceResult: " + i);
      bSF = bool1;
      bSG = false;
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera final: " + bSF);
      }
      return bSF;
      label277:
      if (aeaf.b().afV())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
        }
        bool1 = false;
        i = 3;
      }
      else if (aga())
      {
        bool1 = true;
        i = 10;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
        }
        bool1 = false;
        i = 4;
      }
    }
  }
  
  public static boolean afZ()
  {
    return Build.VERSION.SDK_INT >= aeaf.b().Cd();
  }
  
  public static boolean aga()
  {
    boolean bool3 = false;
    for (;;)
    {
      int i;
      try
      {
        int j = aeaf.b().getNumberOfCameras();
        if (j < 1) {
          return false;
        }
        SharedPreferences localSharedPreferences = g(BaseApplicationImpl.getContext());
        boolean bool2 = localSharedPreferences.getBoolean("localsp_camera_back_exist", false);
        bool1 = bool2;
        if (!bool2)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            Camera.getCameraInfo(i, localCameraInfo);
            if (localCameraInfo.facing == 0) {
              bool1 = true;
            }
          }
          else
          {
            localSharedPreferences.edit().putBoolean("localsp_camera_back_exist", bool1).commit();
          }
        }
        else
        {
          if (bool1) {
            break;
          }
          bool1 = bool3;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: failed");
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: OK");
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public static boolean agb()
  {
    try
    {
      int j = aeaf.b().getNumberOfCameras();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(i, localCameraInfo);
          if (localCameraInfo != null)
          {
            int k = localCameraInfo.facing;
            if (1 == k) {
              return true;
            }
          }
          i += 1;
        }
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.camera.CameraUtils", 1, "hasFrontCamera error, ", localRuntimeException);
    }
  }
  
  public static void ak(Context paramContext, int paramInt)
  {
    f(paramContext).edit().putInt("qcamera_conf_version", paramInt).commit();
  }
  
  public static int as(Context paramContext)
  {
    return f(paramContext).getInt("qcamera_conf_version", 0);
  }
  
  @TargetApi(10)
  public static Bitmap b(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
    throws IOException, OutOfMemoryError
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    int i;
    double d4;
    double d5;
    double d1;
    double d2;
    if (k > j)
    {
      i = 1;
      d4 = 1.0D * Math.max(j, k) / Math.min(j, k);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = k;
      d2 = j;
      if (d4 <= d5) {
        break label391;
      }
      if (i == 0) {
        break label373;
      }
      d1 = d2;
      d2 = d5 * d2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + k + " bh=" + j + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      double d3 = (k - d2) / 2.0D;
      d4 = (k + d2) / 2.0D;
      d5 = (j - d1) / 2.0D;
      double d6 = (j + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        paramArrayOfByte = new Matrix();
        paramArrayOfByte.setRotate(paramInt, paramRect.getWidth() / 2.0F, paramRect.getHeight() / 2.0F);
        if (paramBoolean) {
          paramArrayOfByte.postScale(-1.0F, 1.0F);
        }
        return Bitmap.createBitmap(paramRect, 0, 0, paramRect.getWidth(), paramRect.getHeight(), paramArrayOfByte, false);
        i = 0;
        break;
        label373:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label391:
        if (d4 >= d5) {
          break label548;
        }
        if (i != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5;
        d1 = d2;
        d2 = d3 * d2;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = new Matrix();
        paramRect.setRotate(paramInt, paramArrayOfByte.getWidth() / 2.0F, paramArrayOfByte.getHeight() / 2.0F);
        if (paramBoolean) {
          paramRect.postScale(-1.0F, 1.0F);
        }
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D), paramRect, false);
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label548:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static boolean b(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static boolean bh(Context paramContext)
  {
    return f(paramContext).getBoolean("disableCameraSDK", true);
  }
  
  public static boolean c(Context paramContext, String paramString, int paramInt)
    throws XmlPullParserException, IOException
  {
    a(f(paramContext), paramString, paramInt);
    aeaf.b().GX(true);
    bSG = true;
    return true;
  }
  
  public static SharedPreferences f(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_pref", 4);
  }
  
  public static SharedPreferences g(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_local", 4);
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if ((paramInt == 0) || (paramInt == 360)) {
        return paramBitmap;
      }
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
        if ((paramBoolean) && (paramBitmap != localObject1)) {}
        localOutOfMemoryError1.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          b(paramBitmap);
          return localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            paramBitmap = localOutOfMemoryError1;
            Object localObject2 = localOutOfMemoryError2;
          }
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramBitmap = null;
      }
      QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", localOutOfMemoryError1);
      return paramBitmap;
    }
    return null;
  }
  
  public static byte[] v(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "[decodeXML] + BEGIN");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    f(paramContext).edit().putBoolean("disableCameraSDK", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeah
 * JD-Core Version:    0.7.0.1
 */