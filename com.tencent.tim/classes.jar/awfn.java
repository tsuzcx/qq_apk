import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.1;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.3;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.4;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.7;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class awfn
  extends awfr
  implements avzi
{
  static File bh;
  public static final String cPP = avtc.cNz;
  private static String currentUrl;
  private static int[] tM;
  int BL = 0;
  private List<String> LQ = new ArrayList();
  private List<QzonePhotoInfo> LR = new ArrayList();
  private byte bI = 111;
  private BroadcastReceiver bY = new awfo(this);
  private String cPO;
  String cPQ = "";
  private boolean dqc;
  private boolean dqd;
  private boolean dqe;
  private int eAr = 274;
  private int eAs = 1;
  private int eAt = 30;
  int eAu = 0;
  public Handler handler = new awfp(this);
  private boolean isResume;
  private boolean lK;
  private boolean lL;
  
  public static double a(awfn.a parama)
  {
    if (tM == null) {
      tM = am();
    }
    if (parama != null)
    {
      int i = parama.width;
      int j = parama.height;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        double d3;
        if ((k <= tM[0]) && (j <= tM[1]))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / tM[0];
        }
        for (double d2 = j / tM[1];; d2 = k / tM[1])
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / tM[0];
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      label27:
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      double d1 = 0.0D;
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        d1 = i / paramInt1;
        d2 = j / paramInt2;
        if (d1 > d2) {
          return d1;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      int j;
      do
      {
        int i;
        double d2;
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
        return d2;
        if (paramInt1 != -1) {
          return i / paramInt1;
        }
      } while (paramInt2 == -1);
      return j / paramInt2;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      break label27;
    }
  }
  
  public static BitmapFactory.Options a(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d = a(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d;
    paramInt1 = paramInt2;
    if (d > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getSizeCrop" + paramContext);
      }
    }
  }
  
  public static awfn.a a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inJustDecodeBounds = false;
      return new awfn.a(localOptions.outWidth, localOptions.outHeight);
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getBitmapSize: OutOfMemoryError" + paramString);
      }
    }
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: aload_0
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 201	awfn:a	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 147	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 206	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokestatic 210	awfn:l	(Ljava/lang/String;)I
    //   39: iload 4
    //   41: invokestatic 213	awfn:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IZ)Ljava/lang/String;
    //   44: astore_1
    //   45: aload 5
    //   47: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 5
    //   57: aload 5
    //   59: astore_0
    //   60: ldc 154
    //   62: iconst_1
    //   63: new 156	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   70: ldc 221
    //   72: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload 5
    //   87: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   90: pop
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: astore 5
    //   97: aload_0
    //   98: astore_1
    //   99: aload 5
    //   101: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: astore 5
    //   111: goto -12 -> 99
    //   114: astore_1
    //   115: goto -58 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramContext	Context
    //   0	118	1	paramUri	Uri
    //   0	118	2	paramInt1	int
    //   0	118	3	paramInt2	int
    //   0	118	4	paramBoolean	boolean
    //   23	87	5	localObject	Object
    //   13	18	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   6	25	53	java/lang/Exception
    //   6	25	93	finally
    //   28	45	107	finally
    //   60	85	107	finally
    //   28	45	114	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 228	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 229	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: astore 6
    //   16: aload_1
    //   17: getfield 152	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   20: iconst_1
    //   21: if_icmpgt +25 -> 46
    //   24: aload 7
    //   26: astore 6
    //   28: aload_1
    //   29: getfield 232	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   32: invokestatic 236	awfn:tT	(Ljava/lang/String;)Z
    //   35: ifeq +11 -> 46
    //   38: iload 5
    //   40: istore 4
    //   42: iload_3
    //   43: ifeq +142 -> 185
    //   46: aload 7
    //   48: astore 6
    //   50: aload_1
    //   51: getstatic 242	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   54: putfield 245	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   57: aload 7
    //   59: astore 6
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 248	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   66: aload 7
    //   68: astore 6
    //   70: aload_1
    //   71: iconst_1
    //   72: putfield 251	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   75: aload 7
    //   77: astore 6
    //   79: aload_0
    //   80: aconst_null
    //   81: aload_1
    //   82: invokestatic 120	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: aload 7
    //   89: astore 6
    //   91: ldc 154
    //   93: iconst_1
    //   94: new 156	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   101: ldc 253
    //   103: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: getfield 128	android/graphics/BitmapFactory$Options:outWidth	I
    //   110: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc_w 258
    //   116: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: getfield 131	android/graphics/BitmapFactory$Options:outHeight	I
    //   123: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 8
    //   134: astore_1
    //   135: iload_2
    //   136: ifeq +14 -> 150
    //   139: aload 7
    //   141: astore 6
    //   143: aload 8
    //   145: iload_2
    //   146: invokestatic 265	awfn:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   149: astore_1
    //   150: iload 5
    //   152: istore 4
    //   154: aload_1
    //   155: ifnull +30 -> 185
    //   158: aload 7
    //   160: astore 6
    //   162: aload_1
    //   163: getstatic 271	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   166: bipush 60
    //   168: aload 7
    //   170: invokevirtual 277	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   173: pop
    //   174: aload 7
    //   176: astore 6
    //   178: aload_1
    //   179: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   182: iconst_1
    //   183: istore 4
    //   185: iload 4
    //   187: ifne +102 -> 289
    //   190: aload 7
    //   192: astore 6
    //   194: ldc 154
    //   196: iconst_1
    //   197: ldc_w 282
    //   200: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload 7
    //   205: astore 6
    //   207: sipush 4096
    //   210: newarray byte
    //   212: astore_1
    //   213: aload 7
    //   215: astore 6
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual 286	java/io/InputStream:read	([B)I
    //   222: istore_2
    //   223: iload_2
    //   224: iconst_m1
    //   225: if_icmpeq +64 -> 289
    //   228: aload 7
    //   230: astore 6
    //   232: aload 7
    //   234: aload_1
    //   235: iconst_0
    //   236: iload_2
    //   237: invokevirtual 290	java/io/ByteArrayOutputStream:write	([BII)V
    //   240: goto -27 -> 213
    //   243: astore_0
    //   244: aload 7
    //   246: astore 6
    //   248: ldc 154
    //   250: iconst_1
    //   251: ldc_w 292
    //   254: aload_0
    //   255: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 7
    //   260: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aconst_null
    //   265: areturn
    //   266: astore 8
    //   268: aload 7
    //   270: astore 6
    //   272: ldc 154
    //   274: iconst_1
    //   275: ldc_w 297
    //   278: aload 8
    //   280: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aconst_null
    //   284: astore 8
    //   286: goto -199 -> 87
    //   289: aload 7
    //   291: astore 6
    //   293: aload 7
    //   295: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   298: iconst_2
    //   299: invokestatic 307	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   302: astore_0
    //   303: aload 7
    //   305: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   308: pop
    //   309: aload_0
    //   310: areturn
    //   311: astore_0
    //   312: aconst_null
    //   313: astore 7
    //   315: aload 7
    //   317: astore 6
    //   319: ldc 154
    //   321: iconst_1
    //   322: ldc_w 297
    //   325: aload_0
    //   326: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   329: aload 7
    //   331: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: aconst_null
    //   336: areturn
    //   337: astore_0
    //   338: aconst_null
    //   339: astore 6
    //   341: aload 6
    //   343: invokestatic 219	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: aload_0
    //   348: athrow
    //   349: astore_0
    //   350: goto -9 -> 341
    //   353: astore_0
    //   354: goto -39 -> 315
    //   357: astore_0
    //   358: aconst_null
    //   359: astore 7
    //   361: goto -117 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramInputStream	InputStream
    //   0	364	1	paramOptions	BitmapFactory.Options
    //   0	364	2	paramInt	int
    //   0	364	3	paramBoolean	boolean
    //   40	146	4	i	int
    //   1	150	5	j	int
    //   14	328	6	localByteArrayOutputStream1	ByteArrayOutputStream
    //   10	350	7	localByteArrayOutputStream2	ByteArrayOutputStream
    //   85	59	8	localBitmap	Bitmap
    //   266	13	8	localOutOfMemoryError	OutOfMemoryError
    //   284	1	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	243	java/lang/Exception
    //   28	38	243	java/lang/Exception
    //   50	57	243	java/lang/Exception
    //   61	66	243	java/lang/Exception
    //   70	75	243	java/lang/Exception
    //   79	87	243	java/lang/Exception
    //   91	132	243	java/lang/Exception
    //   143	150	243	java/lang/Exception
    //   162	174	243	java/lang/Exception
    //   178	182	243	java/lang/Exception
    //   194	203	243	java/lang/Exception
    //   207	213	243	java/lang/Exception
    //   217	223	243	java/lang/Exception
    //   232	240	243	java/lang/Exception
    //   272	283	243	java/lang/Exception
    //   293	303	243	java/lang/Exception
    //   79	87	266	java/lang/OutOfMemoryError
    //   3	12	311	java/lang/OutOfMemoryError
    //   3	12	337	finally
    //   16	24	349	finally
    //   28	38	349	finally
    //   50	57	349	finally
    //   61	66	349	finally
    //   70	75	349	finally
    //   79	87	349	finally
    //   91	132	349	finally
    //   143	150	349	finally
    //   162	174	349	finally
    //   178	182	349	finally
    //   194	203	349	finally
    //   207	213	349	finally
    //   217	223	349	finally
    //   232	240	349	finally
    //   248	258	349	finally
    //   272	283	349	finally
    //   293	303	349	finally
    //   319	329	349	finally
    //   16	24	353	java/lang/OutOfMemoryError
    //   28	38	353	java/lang/OutOfMemoryError
    //   50	57	353	java/lang/OutOfMemoryError
    //   61	66	353	java/lang/OutOfMemoryError
    //   70	75	353	java/lang/OutOfMemoryError
    //   91	132	353	java/lang/OutOfMemoryError
    //   143	150	353	java/lang/OutOfMemoryError
    //   162	174	353	java/lang/OutOfMemoryError
    //   178	182	353	java/lang/OutOfMemoryError
    //   194	203	353	java/lang/OutOfMemoryError
    //   207	213	353	java/lang/OutOfMemoryError
    //   217	223	353	java/lang/OutOfMemoryError
    //   232	240	353	java/lang/OutOfMemoryError
    //   272	283	353	java/lang/OutOfMemoryError
    //   293	303	353	java/lang/OutOfMemoryError
    //   3	12	357	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +15 -> 28
    //   16: ldc_w 316
    //   19: iconst_2
    //   20: ldc_w 318
    //   23: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 180	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 10
    //   38: aload 10
    //   40: invokevirtual 187	java/io/File:exists	()Z
    //   43: ifne +15 -> 58
    //   46: ldc_w 316
    //   49: iconst_2
    //   50: ldc_w 320
    //   53: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_1
    //   59: invokestatic 210	awfn:l	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: new 322	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: astore 6
    //   74: aload 10
    //   76: invokestatic 327	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   79: aload_0
    //   80: iload_3
    //   81: iload 4
    //   83: invokestatic 330	awfn:b	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   86: astore_0
    //   87: new 180	java/io/File
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: getstatic 332	awfn:bh	Ljava/io/File;
    //   99: invokevirtual 187	java/io/File:exists	()Z
    //   102: ifne +10 -> 112
    //   105: getstatic 332	awfn:bh	Ljava/io/File;
    //   108: invokevirtual 335	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: aload_1
    //   113: invokevirtual 187	java/io/File:exists	()Z
    //   116: ifne +8 -> 124
    //   119: aload_1
    //   120: invokevirtual 338	java/io/File:createNewFile	()Z
    //   123: pop
    //   124: new 340	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 152	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   137: iconst_1
    //   138: if_icmpgt +13 -> 151
    //   141: aload_0
    //   142: getfield 232	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   145: invokestatic 236	awfn:tT	(Ljava/lang/String;)Z
    //   148: ifne +123 -> 271
    //   151: aload_0
    //   152: getstatic 242	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   155: putfield 245	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 248	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 251	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   168: aload 6
    //   170: aconst_null
    //   171: aload_0
    //   172: invokestatic 120	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore_0
    //   176: aload_0
    //   177: astore_2
    //   178: iload 5
    //   180: ifeq +10 -> 190
    //   183: aload_0
    //   184: iload 5
    //   186: invokestatic 265	awfn:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   189: astore_2
    //   190: aload_2
    //   191: ifnull +47 -> 238
    //   194: aload_2
    //   195: getstatic 271	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 60
    //   200: aload_1
    //   201: invokevirtual 277	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   209: aload_1
    //   210: invokevirtual 346	java/io/OutputStream:close	()V
    //   213: aload 6
    //   215: invokevirtual 125	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 346	java/io/OutputStream:close	()V
    //   226: aload 6
    //   228: ifnull +8 -> 236
    //   231: aload 6
    //   233: invokevirtual 125	java/io/InputStream:close	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: ldc_w 316
    //   241: iconst_2
    //   242: ldc_w 348
    //   245: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 346	java/io/OutputStream:close	()V
    //   256: aload 6
    //   258: ifnull -232 -> 26
    //   261: aload 6
    //   263: invokevirtual 125	java/io/InputStream:close	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_0
    //   269: iconst_0
    //   270: ireturn
    //   271: sipush 1024
    //   274: newarray byte
    //   276: astore_0
    //   277: aload 6
    //   279: aload_0
    //   280: invokevirtual 286	java/io/InputStream:read	([B)I
    //   283: istore_3
    //   284: iload_3
    //   285: iconst_m1
    //   286: if_icmpeq -77 -> 209
    //   289: aload_1
    //   290: aload_0
    //   291: iconst_0
    //   292: iload_3
    //   293: invokevirtual 349	java/io/OutputStream:write	([BII)V
    //   296: goto -19 -> 277
    //   299: astore_2
    //   300: aload_1
    //   301: astore_0
    //   302: aload_2
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   308: ldc_w 316
    //   311: iconst_2
    //   312: new 156	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 352
    //   322: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 346	java/io/OutputStream:close	()V
    //   343: aload 6
    //   345: ifnull -319 -> 26
    //   348: aload 6
    //   350: invokevirtual 125	java/io/InputStream:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_0
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +7 -> 369
    //   365: aload_1
    //   366: invokevirtual 346	java/io/OutputStream:close	()V
    //   369: aload_0
    //   370: athrow
    //   371: astore_1
    //   372: aload 6
    //   374: astore_0
    //   375: aload_1
    //   376: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   379: aload_0
    //   380: ifnull +7 -> 387
    //   383: aload_0
    //   384: invokevirtual 125	java/io/InputStream:close	()V
    //   387: ldc_w 316
    //   390: iconst_2
    //   391: ldc_w 354
    //   394: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 125	java/io/InputStream:close	()V
    //   410: aload_0
    //   411: athrow
    //   412: astore_0
    //   413: aload 7
    //   415: astore_0
    //   416: goto -240 -> 176
    //   419: astore_0
    //   420: goto -164 -> 256
    //   423: astore_0
    //   424: goto -198 -> 226
    //   427: astore_0
    //   428: goto -192 -> 236
    //   431: astore_0
    //   432: goto -89 -> 343
    //   435: astore_1
    //   436: goto -67 -> 369
    //   439: astore_0
    //   440: goto -53 -> 387
    //   443: astore_1
    //   444: goto -34 -> 410
    //   447: astore_0
    //   448: aload 6
    //   450: astore_1
    //   451: goto -49 -> 402
    //   454: astore_2
    //   455: aload_0
    //   456: astore_1
    //   457: aload_2
    //   458: astore_0
    //   459: goto -57 -> 402
    //   462: astore_1
    //   463: aload 9
    //   465: astore_0
    //   466: goto -91 -> 375
    //   469: astore_0
    //   470: goto -109 -> 361
    //   473: astore_2
    //   474: aload_0
    //   475: astore_1
    //   476: aload_2
    //   477: astore_0
    //   478: goto -117 -> 361
    //   481: astore_1
    //   482: aload 8
    //   484: astore_0
    //   485: goto -181 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramContext	Context
    //   0	488	1	paramString1	String
    //   0	488	2	paramString2	String
    //   0	488	3	paramInt1	int
    //   0	488	4	paramInt2	int
    //   62	123	5	i	int
    //   72	377	6	localFileInputStream	FileInputStream
    //   7	407	7	localObject1	Object
    //   1	482	8	localObject2	Object
    //   4	460	9	localObject3	Object
    //   36	39	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   261	266	268	java/io/IOException
    //   133	151	299	java/lang/Exception
    //   151	168	299	java/lang/Exception
    //   168	176	299	java/lang/Exception
    //   183	190	299	java/lang/Exception
    //   194	209	299	java/lang/Exception
    //   209	218	299	java/lang/Exception
    //   238	248	299	java/lang/Exception
    //   271	277	299	java/lang/Exception
    //   277	284	299	java/lang/Exception
    //   289	296	299	java/lang/Exception
    //   348	353	355	java/io/IOException
    //   96	112	358	finally
    //   112	124	358	finally
    //   124	133	358	finally
    //   74	96	371	java/lang/Exception
    //   222	226	371	java/lang/Exception
    //   252	256	371	java/lang/Exception
    //   339	343	371	java/lang/Exception
    //   365	369	371	java/lang/Exception
    //   369	371	371	java/lang/Exception
    //   64	74	399	finally
    //   168	176	412	java/lang/OutOfMemoryError
    //   252	256	419	java/io/IOException
    //   222	226	423	java/io/IOException
    //   231	236	427	java/io/IOException
    //   339	343	431	java/io/IOException
    //   365	369	435	java/io/IOException
    //   383	387	439	java/io/IOException
    //   406	410	443	java/io/IOException
    //   74	96	447	finally
    //   222	226	447	finally
    //   252	256	447	finally
    //   339	343	447	finally
    //   365	369	447	finally
    //   369	371	447	finally
    //   375	379	454	finally
    //   64	74	462	java/lang/Exception
    //   133	151	469	finally
    //   151	168	469	finally
    //   168	176	469	finally
    //   183	190	469	finally
    //   194	209	469	finally
    //   209	218	469	finally
    //   238	248	469	finally
    //   271	277	469	finally
    //   277	284	469	finally
    //   289	296	469	finally
    //   304	335	473	finally
    //   96	112	481	java/lang/Exception
    //   112	124	481	java/lang/Exception
    //   124	133	481	java/lang/Exception
  }
  
  public static float[] a(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new ExifInterface(paramString);
        float[] arrayOfFloat = new float[2];
        boolean bool = paramString.getLatLong(arrayOfFloat);
        if (bool) {
          return arrayOfFloat;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private void aaT(String paramString)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString).optString("callback");
          if ((this.LR == null) || (this.LR.size() <= 0)) {
            break label470;
          }
          localObject1 = new JSONArray();
          int j = this.LR.size();
          i = 0;
          if (i >= j) {
            break;
          }
          localJSONObject = new JSONObject();
          Object localObject2 = (QzonePhotoInfo)this.LR.get(i);
          localObject3 = ((QzonePhotoInfo)localObject2).mAlbumId;
          Object localObject4 = ((QzonePhotoInfo)localObject2).mlloc;
          String str = ((QzonePhotoInfo)localObject2).mBigUrl;
          int k = ((QzonePhotoInfo)localObject2).mBigHeight;
          int m = ((QzonePhotoInfo)localObject2).mBigWidth;
          long l1 = ((QzonePhotoInfo)localObject2).mShootTime;
          long l2 = ((QzonePhotoInfo)localObject2).mUploadTime;
          localJSONObject.put("albumid", localObject3);
          localJSONObject.put("lloc", localObject4);
          localJSONObject.put("url", str);
          localJSONObject.put("height", Integer.valueOf(k));
          localJSONObject.put("width", Integer.valueOf(m));
          localJSONObject.put("shoottime", Long.valueOf(l1));
          localJSONObject.put("uploadtime", Long.valueOf(l2));
          localObject2 = ((QzonePhotoInfo)localObject2).qe;
          if (localObject2 == null) {
            break label338;
          }
          localObject2 = ((Map)localObject2).entrySet().iterator();
          localObject3 = new JSONStringer().object();
          if (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            ((JSONStringer)localObject3).key(String.valueOf(((Map.Entry)localObject4).getKey())).value(((Map.Entry)localObject4).getValue());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      localJSONObject.put("shouzhang_extend_map", ((JSONStringer)localObject3).endObject());
      label338:
      ((JSONArray)localObject1).put(localJSONObject);
      i += 1;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("photoList", localObject1);
    localJSONObject.put("sorttype", this.BL);
    localJSONObject.put("albumtype", this.eAu);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("data", localJSONObject);
    QZLog.d("QzoneDynamicAlbumPlugin", 2, "json:" + ((JSONObject)localObject1).toString());
    this.f.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label470:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.f.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void aaU(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optJSONObject("songInfo");
      paramString = ((JSONObject)localObject).getString("music_id");
      String str1 = ((JSONObject)localObject).getString("lrc_id");
      String str2 = ((JSONObject)localObject).getString("climax_start");
      localObject = ((JSONObject)localObject).getString("climax_endure");
      avzf.a().a().ab(paramString, str1, str2, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void aaV(String paramString)
  {
    int j = 0;
    QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - start");
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.getJSONArray("photosPath");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getString(i);
          if (!((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
            break label215;
          }
          localObject2 = new File(((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", ""));
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - isValid:true");
          if (((File)localObject2).exists()) {
            break label215;
          }
          i = j;
          paramString = paramString.getString("callback");
          localObject1 = new JSONObject();
          if (i != 0)
          {
            QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid SUCCESS!");
            ((JSONObject)localObject1).put("code", 0);
            ((JSONObject)localObject1).put("msg", "success");
            this.f.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid FAILE");
          ((JSONObject)localObject1).put("code", -1);
          ((JSONObject)localObject1).put("msg", "fail");
          continue;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label215:
      i += 1;
    }
  }
  
  private void aaW(String paramString)
  {
    try
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic start:" + paramString + ";isChating:" + this.dqe);
      Object localObject = new JSONObject();
      if (this.dqe)
      {
        ((JSONObject)localObject).put("isCanPlayMusic", "false");
        this.f.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      ((JSONObject)localObject).put("isCanPlayMusic", "true");
      this.f.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if (localObject != null)
      {
        ((AudioManager)localObject).requestAudioFocus(null, 3, 1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("dynamic.Album", 2, new Object[] { "requestPlayMusic get jsonException, cmd:" + paramString });
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic get an Exception, cmd:" + paramString);
      localException.printStackTrace();
    }
  }
  
  private void aaX(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optJSONArray("photoList");
      ((JSONObject)localObject1).getString("callback");
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.get(i);
        if ((localObject2 != null) && ((localObject2 instanceof String)))
        {
          localObject2 = (String)localObject2;
          ((ArrayList)localObject1).add(localObject2);
          if (((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
            localArrayList.add(((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", ""));
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void aaY(String paramString)
  {
    this.cPO = paramString;
    try
    {
      this.eAt = new JSONObject(paramString).optInt("selectedPhotoNum");
      QLog.d("p2vMakeBlog", 1, "hasSelectSize:" + this.eAt);
      paramString = avpw.d.a();
      paramString.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_album_id", this.cPQ);
      localBundle.putLong("key_album_owner_uin", Long.parseLong(paramString.cMP));
      localBundle.putInt("QZ_ALBUM_THEME", this.eAu);
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putInt("PhotoConst.from_h5", 1);
      localBundle.putBoolean("key_is_filter_video", true);
      localBundle.putBoolean("key_is_from_make_blog", true);
      localBundle.putInt("has_select_size", this.eAt);
      int i = awff.a(this.f, this.f.mRuntime, 8);
      avpw.b(this.f.mRuntime.getActivity(), paramString, localBundle, i);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("p2vMakeBlog", 1, "json error cmd:" + paramString);
      }
    }
  }
  
  private void aaZ(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      int k;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("photoList");
        Object localObject1 = paramString.optJSONObject("data");
        String str1 = paramString.getString("callback");
        localJSONObject = new JSONObject();
        ArrayList localArrayList = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = 0;
          paramString = null;
          if (k < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(k);
            localObject3 = ((JSONObject)localObject2).getString("photoUrl");
            if (localObject3 == null) {
              break label782;
            }
            paramString = ((JSONObject)localObject2).getString("albumId");
            str2 = ((JSONObject)localObject2).getString("photoId");
            int j = -1;
            i = 0;
            if (i < this.LR.size())
            {
              if (!((QzonePhotoInfo)this.LR.get(i)).mBigUrl.equals(localObject3)) {
                break label779;
              }
              j = i;
              break label785;
            }
            if ((this.lK) && (j != -1))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), ((QzonePhotoInfo)this.LR.get(j)).mAlbumId, ((QzonePhotoInfo)this.LR.get(j)).mlloc);
              if (paramString == null) {
                break label792;
              }
              localArrayList.add(paramString);
              break label792;
            }
            if ((paramString != null) && (str2 != null))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), paramString, str2);
              continue;
            }
            paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"));
            continue;
          }
        }
        paramString = ((JSONObject)localObject1).getString("mgz_name");
        Object localObject3 = ((JSONObject)localObject1).getString("mgz_desc");
        String str2 = ((JSONObject)localObject1).getString("tmplt_id");
        String str3 = ((JSONObject)localObject1).getString("music_id");
        String str4 = ((JSONObject)localObject1).getString("lrc_id");
        String str5 = ((JSONObject)localObject1).getString("climax_start");
        String str6 = ((JSONObject)localObject1).getString("climax_endure");
        i = ((JSONObject)localObject1).getInt("isDraft");
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("DYNAMIC_ALBUM_PHOTOLIST", localArrayList);
        ((Bundle)localObject2).putString("mgz_name", paramString);
        ((Bundle)localObject2).putString("mgz_desc", (String)localObject3);
        ((Bundle)localObject2).putString("tmplt_id", str2);
        ((Bundle)localObject2).putString("music_id", str3);
        ((Bundle)localObject2).putString("lrc_id", str4);
        ((Bundle)localObject2).putString("climax_start", str5);
        ((Bundle)localObject2).putString("climax_endure", str6);
        ((Bundle)localObject2).putBoolean("EDIT_IMAGE", false);
        ((Bundle)localObject2).putBoolean("APPEND_IMAGE", false);
        ((Bundle)localObject2).putBoolean("SHOW_RECNET_IMAGE", false);
        ((Bundle)localObject2).putString("shareSource", acfp.m(2131713045));
        if (i == 1)
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", true);
          localObject3 = avpw.d.a();
          ((avpw.d)localObject3).cMP = this.f.mRuntime.a().getAccount();
          localObject1 = "";
          paramString = (String)localObject1;
          if (localJSONArray != null)
          {
            paramString = (String)localObject1;
            if (localJSONArray.length() > 0) {
              paramString = localJSONArray.getJSONObject(0).getString("photoUrl");
            }
          }
          if ((localArrayList.size() > 0) && (!TextUtils.isEmpty(paramString)))
          {
            localObject1 = paramString;
            if (paramString.startsWith("https://www.dynamicalbumlocalimage.com")) {
              localObject1 = paramString.replace("https://www.dynamicalbumlocalimage.com", "");
            }
            avpw.a(this.f.mRuntime.getActivity(), (Bundle)localObject2, (avpw.d)localObject3, (String)localObject1, acfp.m(2131713044), null, this.eAr);
            QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync SUCCESS!");
            localJSONObject.put("code", 0);
            localJSONObject.put("msg", "success");
            this.f.callJs(str1, new String[] { localJSONObject.toString() });
          }
        }
        else
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", false);
          continue;
        }
        QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync FAILE");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("msg", "fail");
      continue;
      label779:
      break label785;
      label782:
      continue;
      label785:
      i += 1;
      continue;
      label792:
      k += 1;
    }
  }
  
  private void aba(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.LR != null) && (this.LR.size() > 0))
        {
          localObject = new JSONArray();
          int j = this.LR.size();
          int i = 0;
          while (i < j)
          {
            localJSONObject = new JSONObject();
            QzonePhotoInfo localQzonePhotoInfo = (QzonePhotoInfo)this.LR.get(i);
            String str1 = localQzonePhotoInfo.mAlbumId;
            String str2 = localQzonePhotoInfo.mlloc;
            String str3 = localQzonePhotoInfo.mBigUrl;
            int k = localQzonePhotoInfo.mBigHeight;
            int m = localQzonePhotoInfo.mBigWidth;
            localJSONObject.put("albumid", str1);
            localJSONObject.put("lloc", str2);
            localJSONObject.put("url", str3);
            localJSONObject.put("height", Integer.valueOf(k));
            localJSONObject.put("width", Integer.valueOf(m));
            ((JSONArray)localObject).put(localJSONObject);
            i += 1;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("photoList", localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", localJSONObject);
          this.f.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("code", -1);
        ((JSONObject)localObject).put("msg", "fail");
        this.f.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void abb(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.LQ == null) || (this.LQ.size() <= 0)) {
          break label174;
        }
        localObject1 = new JSONArray();
        localObject2 = this.LQ.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("photoList", localObject1);
    ((JSONObject)localObject2).put("totalNumPreSelected", this.LQ.size());
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", 0);
    ((JSONObject)localObject1).put("msg", "success");
    ((JSONObject)localObject1).put("data", localObject2);
    this.f.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label174:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.f.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void abc(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getString("callback");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).get(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {
              break label255;
            }
            localObject2 = (String)localObject2;
            if (!((String)localObject2).startsWith("https://www.dynamicalbumlocalimage.com")) {
              break label255;
            }
            localObject2 = ((String)localObject2).replace("https://www.dynamicalbumlocalimage.com", "");
            Object localObject3 = a((String)localObject2);
            if (localObject3 == null) {
              return;
            }
            localObject2 = k((String)localObject2, ((awfn.a)localObject3).width, ((awfn.a)localObject3).height);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("code", 0);
              ((JSONObject)localObject3).put("msg", "success");
              ((JSONObject)localObject3).put("data", localObject2);
              this.f.callJs(paramString, new String[] { ((JSONObject)localObject3).toString() });
            }
            else
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("code", -1);
              ((JSONObject)localObject2).put("msg", "fail");
              this.f.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label255:
      i += 1;
    }
  }
  
  private void abd(String paramString)
  {
    try
    {
      this.dqd = true;
      this.cPO = paramString;
      int i = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new Intent(this.f.mRuntime.getActivity(), NewPhotoListActivity.class);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.putExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", true);
      paramString.putExtra("PhotoConst.IS_NO_PANORAMA", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      avpw.ay(paramString);
      localObject = this.f.mRuntime.b();
      if (localObject != null)
      {
        ((WebViewFragment)localObject).a(this.f, paramString, this.bI);
        return;
      }
      ((AbsBaseWebViewActivity)this.f.mRuntime.getActivity()).a(this.f, paramString, this.bI);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int[] am()
  {
    int[] arrayOfInt = new int[2];
    int i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinCpu", 1150);
    long l1 = aqgz.getCpuFrequency();
    long l2 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRam", 700);
    long l3 = aqgz.getSystemTotalMemory() / 1048576L;
    long l4 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRuntimeRam", 150);
    long l5 = aqgz.getSystemAvaialbeMemory() / 1048576L;
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin freeSizeMB " + l5);
    }
    if ((Long.valueOf(l1).longValue() >= i) && (l3 >= l2) && (l5 >= l4))
    {
      arrayOfInt[0] = 1600;
      arrayOfInt[1] = 1600;
      return arrayOfInt;
    }
    arrayOfInt[0] = 640;
    arrayOfInt[1] = 640;
    return arrayOfInt;
  }
  
  public static BitmapFactory.Options b(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d = getOptRatio(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d;
    paramInt1 = paramInt2;
    if (d > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      label80:
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      break label80;
    }
  }
  
  private static InputStream c(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    float f = Math.min(((BitmapFactory.Options)localObject).outWidth / 400, ((BitmapFactory.Options)localObject).outHeight / 300);
    int i = 1;
    while (i < f) {
      i *= 2;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramString = new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 1, "getThumbnail:outOfMemortError " + paramString);
    }
    return null;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString.startsWith("/")) {}
    try
    {
      str1 = "file:///" + Uri.encode(paramString.substring(1));
      paramString = Uri.parse(str1);
      return a(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2, paramBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "compressImage with some: URL encode failed");
        String str2 = paramString;
      }
    }
  }
  
  @TargetApi(11)
  public static WebResourceResponse e(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse start :" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        String str = paramString.replace("https://www.dynamicalbumlocalimage.com", "");
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "image filePath :" + str);
          }
          localFile = new File(str);
          if ((currentUrl != null) && (currentUrl.equals("https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1")))
          {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse -  getThumbnail:" + paramString);
            InputStream localInputStream = c(str);
            if (localInputStream != null) {
              return new WebResourceResponse("image/*", "utf-8", localInputStream);
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          File localFile;
          Object localObject;
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject = null;
          }
          if (!localFile.exists())
          {
            if (QLog.isDevelopLevel())
            {
              QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse local file not exists :" + (String)localObject);
              return null;
            }
          }
          else {
            try
            {
              localObject = new FileInputStream((String)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse ****************** :" + paramString);
              }
              return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject);
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException.printStackTrace();
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneDynamicAlbumPlugin", 2, "getImageResponse get local file fail:" + paramString);
    return null;
  }
  
  private void e(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getParcelableArrayList("param.DynamicCloudPhotolist");
    this.cPQ = paramBundle.getString("key_album_id");
    this.eAu = paramBundle.getInt("QZ_ALBUM_THEME");
    this.BL = paramBundle.getInt("QZ_ALBUM_SORT_TYPE");
    this.LR = ((List)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("p2vMakeBlog", 1, "mJumpToAlbumID:" + this.cPQ + " mJumpToAlbumTheme:" + this.eAu + " mSortType:" + this.BL);
    }
    if (paramBoolean)
    {
      if (this.LR.size() <= 0) {
        break label203;
      }
      localObject2 = ((QzonePhotoInfo)this.LR.get(0)).mAlbumId;
      localObject1 = ((QzonePhotoInfo)this.LR.get(0)).mlloc;
      paramBundle = ((QzonePhotoInfo)this.LR.get(0)).mBigUrl;
    }
    for (;;)
    {
      avzf.a().a().w((String)localObject2, (String)localObject1, paramBundle, this.LR.size());
      return;
      label203:
      Object localObject3 = null;
      localObject2 = null;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
    }
  }
  
  private void eDr()
  {
    avzf.a().a().fu((ArrayList)this.LR);
    this.LR.clear();
  }
  
  private void en(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("param.DynamicMin");
      int j = paramBundle.getInt("param.DynamicMax");
      paramBundle = paramBundle.getString("param.DynamicCmd");
      if (!TextUtils.isEmpty(paramBundle))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("maxNum", j);
        localJSONObject.put("minNum", i);
        this.f.callJs(paramBundle, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void eq(Intent paramIntent)
  {
    e(paramIntent.getExtras(), false);
    if (TextUtils.isEmpty(this.cPO)) {
      return;
    }
    QLog.d("QzoneDynamicAlbumPlugin", 2, "sendBlogCLoudPhotoToH5 | mJSONArgs:" + this.cPO);
    aaT(this.cPO);
  }
  
  private void fv(ArrayList<String> paramArrayList)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage start!");
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      new ArrayList();
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        if (tM == null) {
          tM = am();
        }
        if (bh == null) {
          bh = new File(cPP);
        }
        ThreadManager.post(new QzoneDynamicAlbumPlugin.6(this, paramArrayList, i), 5, null, true);
      }
      return;
    }
  }
  
  public static double getOptRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      if (i < j) {
        if ((j <= paramInt1) && (i <= paramInt2))
        {
          d3 = 0.0D;
          return d3;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      double d3;
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
      double d1;
      if (j > i) {
        d1 = j / paramInt1;
      }
      for (double d2 = i / paramInt2;; d2 = j / paramInt2)
      {
        d3 = d1;
        if (d1 > d2) {
          break;
        }
        return d2;
        d1 = i / paramInt1;
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        continue;
        int k = i;
        int i = j;
        int j = k;
      }
    }
  }
  
  private void hk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aiiw.a(true, this.f.mRuntime.getActivity(), false);
      return;
    }
    aiiw.a(false, this.f.mRuntime.getActivity(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  public static String k(String paramString, int paramInt1, int paramInt2)
  {
    return c(paramString, paramInt1, paramInt2, false);
  }
  
  private String k(String[] paramArrayOfString)
  {
    awfn.a locala = a(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "https://www.dynamicalbumlocalimage.com" + paramArrayOfString[1]);
      if (locala != null)
      {
        localJSONObject.put("width", locala.width);
        localJSONObject.put("height", locala.height);
      }
      paramArrayOfString = a(paramArrayOfString[0]);
      if (paramArrayOfString != null)
      {
        localJSONObject.put("poiX", paramArrayOfString[1]);
        localJSONObject.put("poiY", paramArrayOfString[0]);
        localJSONObject.put("poiName", "");
      }
      paramArrayOfString = localJSONObject.toString();
      return paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return "";
  }
  
  public static int l(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = JpegExifReader.getRotationDegree(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void ow(List<String> paramList)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage " + paramList.size() + " " + (String)paramList.get(0));
      }
      if (tM != null) {}
    }
    else
    {
      return;
    }
    String[] arrayOfString = new String[paramList.size()];
    while (i < paramList.size()) {
      if (paramList.get(i) == null)
      {
        i += 1;
      }
      else
      {
        Object localObject = (String)paramList.get(i);
        int j = l((String)localObject);
        awfn.a locala = a((String)localObject);
        float[] arrayOfFloat = a((String)localObject);
        double d = a(locala);
        if (((j == 90) || (j == 270)) && (locala != null))
        {
          j = locala.width;
          locala.width = locala.height;
          locala.height = j;
        }
        localObject = new JSONObject();
        arrayOfString[i] = (cPP + (new Date().getTime() + i));
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("url", "https://www.dynamicalbumlocalimage.com" + arrayOfString[i]);
            if (locala != null)
            {
              if (d <= 0.0D) {
                continue;
              }
              ((JSONObject)localObject).put("width", (int)(locala.width / d));
              ((JSONObject)localObject).put("height", (int)(locala.height / d));
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
          this.LQ.add(((JSONObject)localObject).toString());
          break;
          ((JSONObject)localObject).put("width", locala.width);
          ((JSONObject)localObject).put("height", locala.height);
        }
      }
    }
    ThreadManager.post(new QzoneDynamicAlbumPlugin.7(this, paramList, arrayOfString), 5, null, true);
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static boolean tT(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void ai(List<String> paramList, int paramInt)
  {
    String str;
    try
    {
      if (TextUtils.isEmpty(this.cPO)) {
        return;
      }
      str = new JSONObject(this.cPO).optString("callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label194;
      }
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
      }
      paramList = new JSONObject();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    paramList.put("photoList", localObject);
    paramList.put("totalNumPreSelected", paramInt);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("msg", "success");
    ((JSONObject)localObject).put("data", paramList);
    this.f.callJs(str, new String[] { ((JSONObject)localObject).toString() });
    return;
    label194:
    paramList = new JSONObject();
    paramList.put("code", -1);
    paramList.put("msg", "fail");
    this.f.callJs(str, new String[] { paramList.toString() });
  }
  
  public void c(WebViewPlugin paramWebViewPlugin)
  {
    super.c(paramWebViewPlugin);
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.mRuntime == null) || (!(paramWebViewPlugin.mRuntime.getActivity() instanceof QQBrowserActivity))) {
      return;
    }
    if (paramWebViewPlugin.mRuntime.b() != null) {}
    for (Object localObject = paramWebViewPlugin.mRuntime.b().mUrl;; localObject = "")
    {
      currentUrl = (String)localObject;
      if ((TextUtils.isEmpty(currentUrl)) || ((!currentUrl.contains("qzone.qq.com/dynamic")) && (!currentUrl.contains("blog")))) {
        break;
      }
      if (bh == null) {
        bh = new File(cPP);
      }
      if (this.dqc) {
        break;
      }
      this.dqc = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
      ((IntentFilter)localObject).addAction("com.tencent.process.starting");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
      paramWebViewPlugin.mRuntime.getActivity().registerReceiver(this.bY, (IntentFilter)localObject);
      avzf.a().a(this);
      paramWebViewPlugin.mRuntime.a().getHandler(awfn.class).post(new QzoneDynamicAlbumPlugin.1(this));
      return;
    }
  }
  
  public void eDs()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.f.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", localJSONObject1, localJSONObject2);
  }
  
  public void eDt()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.f.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", localJSONObject1, localJSONObject2);
  }
  
  public void ha(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (localAudioManager.getRingerMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", i);
        paramString.put("currentVolume", j);
        this.f.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("https://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getImageResponse " + paramString);
      }
      return e(paramString);
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i;
    Object localObject;
    int j;
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.bI) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.eAr)))
    {
      i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      localObject = (Intent)paramMap.get("data");
      j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (i != this.bI) {
        break label179;
      }
      if (j != -1) {
        break label170;
      }
      fv(((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("qzone.qq.com/dynamic")))
      {
        return super.handleEvent(paramString, paramLong, paramMap);
        label170:
        ai(null, 0);
        continue;
        label179:
        if ((i != this.eAr) || (j != -1)) {
          continue;
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("isPublishDynamicMood", true);
          JSONObject localJSONObject = new JSONObject();
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put("*.qzone.qq.com");
          localJSONObject.put("echo", false);
          localJSONObject.put("broadcast", true);
          localJSONObject.put("domains", localJSONArray);
          c("publishDynamicMood", (JSONObject)localObject, localJSONObject);
          if ((this.f.mRuntime != null) && (this.f.mRuntime.getActivity() != null)) {
            this.f.mRuntime.getActivity().finish();
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    if (paramString.contains("qzone.qq.com/dynamic/album/coverList")) {
      avzf.a().a().eCE();
    }
    if (paramLong == 2L)
    {
      this.isResume = true;
      if (this.dqd)
      {
        this.dqd = false;
        ai(null, 0);
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934597L) {
        this.isResume = false;
      } else if (paramLong == 8589934608L) {
        ha("qbrowserVolumeChange", 2);
      } else if (paramLong == 8589934609L) {
        ha("qbrowserVolumeChange", 1);
      } else if ((paramLong == 8589934601L) && (paramString.contains("qzone.qq.com/dynamic/album/preview"))) {
        avzf.a().a().eCC();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (((!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("Qzone"))) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramJsBridgeListener = "" + paramJsBridgeListener.abC;; paramJsBridgeListener = paramVarArgs[0])
    {
      QLog.d("QzoneDynamicAlbumPlugin", 4, "NAMESPACE = " + paramString2 + ";method = " + paramString3 + ";args = " + paramJsBridgeListener);
      if (!"deletePhotos".equals(paramString3)) {
        break;
      }
      aaX(paramJsBridgeListener);
      return true;
    }
    if ("saveDynamicAlbum".equals(paramString3)) {
      return true;
    }
    if ("getPhotos".equals(paramString3))
    {
      QZLog.d("dynamic.Album", 4, "handleJsRequest - getPhotos - isFromAlbum:" + this.lK);
      if (this.lK) {
        aba(paramJsBridgeListener);
      }
      for (;;)
      {
        return true;
        abb(paramJsBridgeListener);
      }
    }
    if ("getBlogCloudPhotoUrls".equals(paramString3))
    {
      aaT(paramJsBridgeListener);
      return true;
    }
    if ("getCloudPhotoUrl".equals(paramString3)) {
      aba(paramJsBridgeListener);
    }
    do
    {
      for (;;)
      {
        return false;
        if ("dynamicSendSuccess".equals(paramString3))
        {
          eDr();
        }
        else
        {
          if (!"isDraftPhotosValid".equals(paramString3)) {
            break;
          }
          aaV(paramJsBridgeListener);
        }
      }
      if ("getSelectNum".equals(paramString3))
      {
        this.f.mRuntime.a().getHandler(awfn.class).post(new QzoneDynamicAlbumPlugin.3(this, paramJsBridgeListener));
        return true;
      }
      if ("entryWriteMoodAsync".equals(paramString3))
      {
        aaZ(paramJsBridgeListener);
        return true;
      }
      if ("blogOpenQzoneImagePicker".equals(paramString3))
      {
        aaY(paramJsBridgeListener);
        return true;
      }
      if ("toBase64".equals(paramString3))
      {
        abc(paramJsBridgeListener);
        return true;
      }
      if ("openImagePicker".equals(paramString3))
      {
        abd(paramJsBridgeListener);
        return true;
      }
      if ("cancel".equals(paramString3))
      {
        this.f.mRuntime.a().getHandler(awfn.class).post(new QzoneDynamicAlbumPlugin.4(this));
        return true;
      }
      if ("requestPlayMusic".equals(paramString3))
      {
        aaW(paramJsBridgeListener);
        return true;
      }
      if ("startPlay".equals(paramString3))
      {
        hk(true);
        return true;
      }
      if ("endPlay".equals(paramString3))
      {
        hk(false);
        return true;
      }
    } while (!"setDynamicAlbumData".equals(paramString3));
    aaU(paramJsBridgeListener);
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == this.bI)
    {
      this.dqd = false;
      if (paramInt == -1) {
        fv(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      }
    }
    while (paramByte != 8)
    {
      return;
      ai(null, 0);
      return;
    }
    eq(paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avzf.a().b(this);
    avzf.a().a().eCB();
    aiiw.a(false, this.f.mRuntime.getActivity(), false);
    try
    {
      this.f.mRuntime.getActivity().unregisterReceiver(this.bY);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 2, "unregiser fail");
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    QZLog.d("dynamic.Album", 4, "onWebEvent: event - " + paramString);
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        this.lK = paramBundle.getBoolean("param.DynamicIsFromAlbum", false);
        boolean bool = paramBundle.getBoolean("param.DynamicIsFromMakeBlog", false);
        this.lL = paramBundle.getBoolean("param.DynamicIsFromAlbumSharePanel", false);
        QZLog.d("dynamic.Album", 4, "onWebEvent - getBoolean - isFromAlbum:" + this.lK + " isFromMakeBlog:" + bool);
        if (this.lK)
        {
          if (bool)
          {
            e(paramBundle, false);
            return;
          }
          e(paramBundle, true);
          return;
        }
        ow(paramBundle.getStringArrayList("param.DynamicPhotolist"));
        return;
      }
      if (paramString.equals("cmd.getDynamicSelnum"))
      {
        en(paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getDynamicCloudPhoto"));
    e(paramBundle, false);
  }
  
  public static class a
  {
    public int height;
    public int width;
    
    public a(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfn
 * JD-Core Version:    0.7.0.1
 */