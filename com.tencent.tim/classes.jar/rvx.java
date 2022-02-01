import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class rvx
{
  public static String aCJ = "addDisSource";
  private static boolean aKd;
  public static int bvz = 1;
  
  private static int a(Bitmap paramBitmap, int paramInt1, int paramInt2, int[] paramArrayOfInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    int j = 0;
    int i;
    boolean bool;
    if ((RecogUtil.getSupportDetectType() >= 0) && (adjn.aeE()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = adjn.a().a(paramBitmap, l, localRect);
      if ((!bool) || (localRect.width() <= 0) || (localRect.height() <= 0)) {
        break label176;
      }
      paramBitmap = new Rect();
      RecogUtil.scaleRect(localRect, paramBitmap, paramInt1, paramInt2, 1.2F);
      paramInt1 = 0x0 | a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, 2, paramBitmap.left, paramBitmap.top, paramBitmap.width(), paramBitmap.height(), paramStringBuilder);
      if (QLog.isColorLevel())
      {
        if ((paramInt1 & 0x2) != 2) {
          break label170;
        }
        bool = true;
        label135:
        QLog.i("ScannerUtils", 2, String.format("detectQQCode detectWithAI true result=%b rect=%s", new Object[] { Boolean.valueOf(bool), paramBitmap }));
      }
    }
    label170:
    label176:
    label210:
    do
    {
      for (;;)
      {
        return paramInt1;
        i = 0;
        break;
        bool = false;
        break label135;
        if (QLog.isColorLevel()) {
          QLog.i("ScannerUtils", 2, String.format("detectQQCode detectWithAI false exec=%b", new Object[] { Boolean.valueOf(bool) }));
        }
        paramInt1 = 0;
      }
      paramInt1 = j;
    } while (!QLog.isColorLevel());
    QLog.i("ScannerUtils", 2, "detectQQCode detectWithAI not supportDetect");
    return 0;
  }
  
  /* Error */
  private static int a(Bitmap paramBitmap, int paramInt, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   10: istore 7
    //   12: iload 4
    //   14: iload 7
    //   16: imul
    //   17: newarray int
    //   19: astore 10
    //   21: iload 4
    //   23: iload 7
    //   25: imul
    //   26: newarray byte
    //   28: astore 11
    //   30: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   33: ifeq +34 -> 67
    //   36: ldc 77
    //   38: iconst_4
    //   39: ldc 117
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 4
    //   49: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: iload 7
    //   57: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: aload 10
    //   70: iconst_0
    //   71: iload 4
    //   73: iconst_0
    //   74: iconst_0
    //   75: iload 4
    //   77: iload 7
    //   79: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   82: aload 10
    //   84: aload 11
    //   86: iload 4
    //   88: iload 7
    //   90: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   93: pop
    //   94: aload 10
    //   96: aload 11
    //   98: iload 4
    //   100: iload 7
    //   102: iload_1
    //   103: aload_2
    //   104: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   107: istore_3
    //   108: iconst_0
    //   109: iload_3
    //   110: ior
    //   111: istore_3
    //   112: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +222 -> 337
    //   118: ldc 77
    //   120: iconst_4
    //   121: ldc 140
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_1
    //   130: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_3
    //   137: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: aload_2
    //   144: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto +183 -> 337
    //   157: invokestatic 27	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 33	adjn:aeE	()Z
    //   166: ifeq +84 -> 250
    //   169: iconst_1
    //   170: istore 6
    //   172: iload 5
    //   174: ifeq +160 -> 334
    //   177: aload_0
    //   178: iload 4
    //   180: iload 7
    //   182: aload 10
    //   184: aload 11
    //   186: aload_2
    //   187: invokestatic 148	rvx:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   190: istore 4
    //   192: iload 4
    //   194: iload_3
    //   195: ior
    //   196: istore_3
    //   197: iload_3
    //   198: istore 4
    //   200: iload_1
    //   201: iconst_2
    //   202: iand
    //   203: ifeq +38 -> 241
    //   206: iload_3
    //   207: istore 4
    //   209: iload 6
    //   211: ifeq +30 -> 241
    //   214: iload 5
    //   216: ifne +40 -> 256
    //   219: iconst_1
    //   220: istore 8
    //   222: iload_3
    //   223: iconst_2
    //   224: iand
    //   225: ifeq +37 -> 262
    //   228: iconst_1
    //   229: istore 9
    //   231: iload 8
    //   233: iload 9
    //   235: invokestatic 154	adjv:bO	(ZZ)V
    //   238: iload_3
    //   239: istore 4
    //   241: iload 4
    //   243: ireturn
    //   244: iconst_0
    //   245: istore 5
    //   247: goto -90 -> 157
    //   250: iconst_0
    //   251: istore 6
    //   253: goto -81 -> 172
    //   256: iconst_0
    //   257: istore 8
    //   259: goto -37 -> 222
    //   262: iconst_0
    //   263: istore 9
    //   265: goto -34 -> 231
    //   268: astore_0
    //   269: iconst_0
    //   270: istore_3
    //   271: iload_3
    //   272: istore 4
    //   274: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -36 -> 241
    //   280: ldc 77
    //   282: iconst_2
    //   283: aload_0
    //   284: invokevirtual 157	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   287: aload_0
    //   288: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: iload_3
    //   292: ireturn
    //   293: astore_0
    //   294: iconst_0
    //   295: istore_3
    //   296: iload_3
    //   297: istore 4
    //   299: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -61 -> 241
    //   305: ldc 77
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 161	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   312: aload_0
    //   313: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: iload_3
    //   317: ireturn
    //   318: astore_0
    //   319: goto -23 -> 296
    //   322: astore_0
    //   323: goto -27 -> 296
    //   326: astore_0
    //   327: goto -56 -> 271
    //   330: astore_0
    //   331: goto -60 -> 271
    //   334: goto -137 -> 197
    //   337: iload_1
    //   338: iconst_2
    //   339: iand
    //   340: iconst_2
    //   341: if_icmpne -97 -> 244
    //   344: iload_3
    //   345: iconst_2
    //   346: iand
    //   347: ifne -103 -> 244
    //   350: iconst_1
    //   351: istore 5
    //   353: goto -196 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramBitmap	Bitmap
    //   0	356	1	paramInt	int
    //   0	356	2	paramStringBuilder	StringBuilder
    //   107	240	3	i	int
    //   4	294	4	j	int
    //   172	180	5	k	int
    //   170	82	6	m	int
    //   10	171	7	n	int
    //   220	38	8	bool1	boolean
    //   229	35	9	bool2	boolean
    //   19	164	10	arrayOfInt	int[]
    //   28	157	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	67	268	java/lang/OutOfMemoryError
    //   67	108	268	java/lang/OutOfMemoryError
    //   12	67	293	java/lang/Throwable
    //   67	108	293	java/lang/Throwable
    //   112	154	318	java/lang/Throwable
    //   157	169	318	java/lang/Throwable
    //   177	192	318	java/lang/Throwable
    //   231	238	322	java/lang/Throwable
    //   112	154	326	java/lang/OutOfMemoryError
    //   157	169	326	java/lang/OutOfMemoryError
    //   177	192	326	java/lang/OutOfMemoryError
    //   231	238	330	java/lang/OutOfMemoryError
  }
  
  public static int a(Bitmap paramBitmap, boolean paramBoolean, int paramInt, SparseArray<Object> paramSparseArray)
  {
    if (paramBitmap == null) {
      paramInt = 0;
    }
    long l1;
    do
    {
      return paramInt;
      if (QLog.isDevelopLevel()) {
        QLog.d("ScannerUtils", 4, String.format("detectQQCodeBmp width=%b height=%b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
      }
      l1 = System.currentTimeMillis();
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i = 0;
      int n = paramInt;
      j = i1;
      k = i2;
      m = i3;
      for (;;)
      {
        try
        {
          if (!asfh.by(paramBitmap.getWidth(), paramBitmap.getHeight())) {
            n = paramInt & 0xFFFFFFFE;
          }
          if ((n & 0x1) == 1)
          {
            j = i1;
            k = i2;
            m = i3;
            ua();
          }
          j = i1;
          k = i2;
          m = i3;
          l2 = System.currentTimeMillis();
          if ((n & 0x2) == 2)
          {
            j = i1;
            k = i2;
            m = i3;
            adjn.a().h(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(adjn.aeD()), Long.valueOf(l2) }));
            }
          }
          j = i1;
          k = i2;
          m = i3;
          localStringBuilder1 = new StringBuilder();
          paramInt = i;
          if (paramBitmap != null)
          {
            j = i1;
            k = i2;
          }
        }
        catch (RuntimeException paramBitmap)
        {
          long l2;
          StringBuilder localStringBuilder1;
          StringBuilder localStringBuilder2;
          paramBitmap.printStackTrace();
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          i = j;
          continue;
          bool = false;
          continue;
          paramBoolean = false;
          continue;
        }
        catch (UnsatisfiedLinkError paramBitmap)
        {
          paramBitmap.printStackTrace();
          i = k;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          i = k;
          continue;
        }
        catch (Throwable paramBitmap)
        {
          paramBitmap.printStackTrace();
          i = m;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          i = m;
          continue;
          if (paramInt < 0) {
            continue;
          }
          if ((paramInt & 0x1) != 1) {
            continue;
          }
          boolean bool = true;
          continue;
          if ((paramInt & 0x2) != 2) {
            continue;
          }
          paramBoolean = true;
          continue;
        }
        try
        {
          paramInt = a(paramBitmap, n, localStringBuilder1);
          paramInt = 0x0 | paramInt;
        }
        catch (Throwable localThrowable)
        {
          paramInt = i;
          j = i1;
          k = i2;
          m = i3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          j = i1;
          k = i2;
          m = i3;
          QLog.i("ScannerUtils.detectQQCodeBmp", 2, localThrowable.getMessage(), localThrowable);
          paramInt = i;
        }
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      if (ab(n, paramInt) <= 0) {
        break label811;
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (i <= 250) {
        break label811;
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      i = (int)Math.ceil(i / 250.0D);
      break label811;
      if ((!bool) || (paramSparseArray == null) || (!paramBoolean)) {
        break label828;
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      paramBitmap = new StringBuilder();
      j = paramInt;
      k = paramInt;
      m = paramInt;
      localStringBuilder2 = new StringBuilder();
      j = paramInt;
      k = paramInt;
      m = paramInt;
      asfh.a(paramBitmap, localStringBuilder2);
      j = paramInt;
      k = paramInt;
      m = paramInt;
      paramSparseArray.put(1, new Pair(localStringBuilder2, paramBitmap));
      break label828;
      if ((paramBoolean) && (paramSparseArray != null))
      {
        j = paramInt;
        k = paramInt;
        m = paramInt;
        paramSparseArray.put(2, localStringBuilder1.toString());
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      if (QLog.isColorLevel())
      {
        j = paramInt;
        k = paramInt;
        m = paramInt;
        QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("result mode=%d result=%d qr=%b mini=%b miniStr=%s", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), localStringBuilder1.toString() }));
      }
      if ((n & 0x1) == 1)
      {
        j = paramInt;
        k = paramInt;
        m = paramInt;
        ub();
      }
      i = paramInt;
      if ((n & 0x2) == 2)
      {
        j = paramInt;
        k = paramInt;
        m = paramInt;
        adjn.a().ak(l2, "ScannerUtils.detectQQCodeBmp");
        i = paramInt;
      }
      paramInt = i;
    } while (!QLog.isDevelopLevel());
    QLog.d("ScannerUtils.detectQQCodeBmp", 4, "cost:" + (System.currentTimeMillis() - l1));
    return i;
  }
  
  public static int a(Uri paramUri, Context paramContext, int paramInt)
  {
    paramInt = a(paramUri, paramContext, false, false, paramInt, null);
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerUtils", 4, "hasQRCode res:" + paramInt);
    }
    return paramInt;
  }
  
  public static int a(Uri paramUri, Context paramContext, int paramInt, SparseArray<Object> paramSparseArray)
  {
    paramInt = a(paramUri, paramContext, true, false, paramInt, paramSparseArray);
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerUtils", 4, "decodeFile res:" + paramInt);
    }
    return paramInt;
  }
  
  public static int a(Uri paramUri, Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramInt = a(paramUri, paramContext, false, paramBoolean, paramInt, null);
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerUtils", 4, "hasQRCode res:" + paramInt);
    }
    return paramInt;
  }
  
  /* Error */
  private static int a(Uri paramUri, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, SparseArray<Object> paramSparseArray)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +9 -> 14
    //   8: iconst_0
    //   9: istore 4
    //   11: iload 4
    //   13: ireturn
    //   14: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   17: lstore 32
    //   19: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   22: ifeq +30 -> 52
    //   25: ldc_w 280
    //   28: iconst_4
    //   29: new 142	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 282
    //   39: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 19
    //   55: iconst_0
    //   56: istore 20
    //   58: iconst_0
    //   59: istore 14
    //   61: iconst_0
    //   62: istore 15
    //   64: iconst_0
    //   65: istore 18
    //   67: iconst_0
    //   68: istore 16
    //   70: iconst_0
    //   71: istore 17
    //   73: iconst_0
    //   74: istore 13
    //   76: aconst_null
    //   77: astore 34
    //   79: aconst_null
    //   80: astore 40
    //   82: aconst_null
    //   83: astore 41
    //   85: aconst_null
    //   86: astore 39
    //   88: iconst_0
    //   89: istore 12
    //   91: iconst_0
    //   92: istore 21
    //   94: iconst_0
    //   95: istore 7
    //   97: iconst_0
    //   98: istore 22
    //   100: iconst_0
    //   101: istore 8
    //   103: iconst_0
    //   104: istore 9
    //   106: iconst_0
    //   107: istore 10
    //   109: iconst_0
    //   110: istore 11
    //   112: iconst_0
    //   113: istore 6
    //   115: ldc2_w 286
    //   118: lstore 30
    //   120: aload 39
    //   122: astore 38
    //   124: aload 34
    //   126: astore 37
    //   128: aload 40
    //   130: astore 35
    //   132: aload 41
    //   134: astore 36
    //   136: aload_1
    //   137: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 39
    //   144: astore 38
    //   146: aload 34
    //   148: astore 37
    //   150: aload 40
    //   152: astore 35
    //   154: aload 41
    //   156: astore 36
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5808 -> 5976
    //   171: aload 34
    //   173: astore 38
    //   175: aload 34
    //   177: astore 37
    //   179: aload 34
    //   181: astore 35
    //   183: aload 34
    //   185: astore 36
    //   187: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   190: lstore 28
    //   192: iload 4
    //   194: iconst_2
    //   195: iand
    //   196: iconst_2
    //   197: if_icmpne +126 -> 323
    //   200: iload 22
    //   202: istore 7
    //   204: invokestatic 47	adjn:a	()Ladjn;
    //   207: invokestatic 183	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   210: lload 28
    //   212: ldc_w 280
    //   215: invokevirtual 189	adjn:h	(Landroid/content/Context;JLjava/lang/String;)V
    //   218: iconst_1
    //   219: istore 24
    //   221: iconst_1
    //   222: istore 25
    //   224: iconst_1
    //   225: istore 23
    //   227: iconst_1
    //   228: istore 26
    //   230: iconst_1
    //   231: istore 27
    //   233: iconst_1
    //   234: istore 22
    //   236: iload 22
    //   238: istore 6
    //   240: iload 24
    //   242: istore 7
    //   244: iload 25
    //   246: istore 8
    //   248: iload 23
    //   250: istore 9
    //   252: iload 26
    //   254: istore 10
    //   256: iload 27
    //   258: istore 11
    //   260: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +60 -> 323
    //   266: iload 24
    //   268: istore 7
    //   270: iload 25
    //   272: istore 8
    //   274: iload 23
    //   276: istore 9
    //   278: iload 26
    //   280: istore 10
    //   282: iload 27
    //   284: istore 11
    //   286: ldc_w 280
    //   289: iconst_2
    //   290: ldc 191
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: invokestatic 194	adjn:aeD	()Z
    //   301: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 28
    //   309: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 22
    //   321: istore 6
    //   323: new 142	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   330: astore 40
    //   332: iload_3
    //   333: ifeq +1053 -> 1386
    //   336: aload_0
    //   337: invokevirtual 304	android/net/Uri:getPath	()Ljava/lang/String;
    //   340: invokestatic 310	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   343: astore 35
    //   345: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   348: ifeq +31 -> 379
    //   351: ldc_w 280
    //   354: iconst_4
    //   355: new 142	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 312
    //   365: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 35
    //   370: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload 35
    //   381: ifnull +5578 -> 5959
    //   384: aload 35
    //   386: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   389: istore 21
    //   391: aload 35
    //   393: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   396: istore 20
    //   398: iload 21
    //   400: iload 20
    //   402: invokestatic 174	asfh:by	(II)Z
    //   405: istore_3
    //   406: iload_3
    //   407: ifne +5545 -> 5952
    //   410: iload 4
    //   412: bipush 254
    //   414: iand
    //   415: istore 8
    //   417: iload 21
    //   419: iload 20
    //   421: imul
    //   422: newarray int
    //   424: astore 36
    //   426: aload 35
    //   428: aload 36
    //   430: iconst_0
    //   431: iload 21
    //   433: iconst_0
    //   434: iconst_0
    //   435: iload 21
    //   437: iload 20
    //   439: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   442: iload 8
    //   444: iconst_1
    //   445: iand
    //   446: iconst_1
    //   447: if_icmpne +5499 -> 5946
    //   450: invokestatic 177	rvx:ua	()I
    //   453: pop
    //   454: iconst_1
    //   455: istore 4
    //   457: iload 4
    //   459: istore 12
    //   461: iload 4
    //   463: istore 13
    //   465: iload 14
    //   467: istore 9
    //   469: iload 4
    //   471: istore 14
    //   473: iload 15
    //   475: istore 10
    //   477: iload 4
    //   479: istore 15
    //   481: iload 18
    //   483: istore 11
    //   485: aload 36
    //   487: aconst_null
    //   488: iload 21
    //   490: iload 20
    //   492: iload 8
    //   494: aload 40
    //   496: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   499: istore 7
    //   501: iload 4
    //   503: istore 12
    //   505: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   508: ifeq +48 -> 556
    //   511: iload 4
    //   513: istore 12
    //   515: ldc_w 280
    //   518: iconst_4
    //   519: ldc_w 317
    //   522: iconst_3
    //   523: anewarray 4	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: iload 8
    //   530: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: iconst_1
    //   536: iload 7
    //   538: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_2
    //   544: aload 40
    //   546: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: aastore
    //   550: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   553: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: iload 4
    //   558: istore 12
    //   560: iload 21
    //   562: iload 20
    //   564: imul
    //   565: newarray byte
    //   567: astore_1
    //   568: iload 4
    //   570: istore 12
    //   572: aload 36
    //   574: aload_1
    //   575: iload 21
    //   577: iload 20
    //   579: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   582: pop
    //   583: iload 8
    //   585: iconst_2
    //   586: iand
    //   587: iconst_2
    //   588: if_icmpne +497 -> 1085
    //   591: iload 7
    //   593: iconst_2
    //   594: iand
    //   595: ifne +490 -> 1085
    //   598: iconst_1
    //   599: istore 9
    //   601: iload 4
    //   603: istore 12
    //   605: invokestatic 27	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   608: iflt +13 -> 621
    //   611: iload 4
    //   613: istore 12
    //   615: invokestatic 194	adjn:aeD	()Z
    //   618: ifeq +3 -> 621
    //   621: iload 9
    //   623: ifeq +5320 -> 5943
    //   626: iload 4
    //   628: istore 12
    //   630: aload 35
    //   632: iload 21
    //   634: iload 20
    //   636: aload 36
    //   638: aload_1
    //   639: aload 40
    //   641: invokestatic 148	rvx:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   644: istore 9
    //   646: iload 7
    //   648: iload 9
    //   650: ior
    //   651: istore 7
    //   653: iload 4
    //   655: istore 12
    //   657: iload 4
    //   659: istore 13
    //   661: iload 7
    //   663: istore 9
    //   665: iload 4
    //   667: istore 14
    //   669: iload 7
    //   671: istore 10
    //   673: iload 4
    //   675: istore 15
    //   677: iload 7
    //   679: istore 11
    //   681: iload 7
    //   683: istore 16
    //   685: iload 7
    //   687: istore 17
    //   689: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   692: ifeq +66 -> 758
    //   695: iload 4
    //   697: istore 12
    //   699: iload 4
    //   701: istore 13
    //   703: iload 7
    //   705: istore 9
    //   707: iload 4
    //   709: istore 14
    //   711: iload 7
    //   713: istore 10
    //   715: iload 4
    //   717: istore 15
    //   719: iload 7
    //   721: istore 11
    //   723: iload 7
    //   725: istore 16
    //   727: iload 7
    //   729: istore 17
    //   731: ldc 77
    //   733: iconst_4
    //   734: new 142	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 319
    //   744: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: iload 7
    //   749: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: iload 4
    //   760: istore 12
    //   762: aload 35
    //   764: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   767: iload 4
    //   769: istore 9
    //   771: iload 7
    //   773: istore 4
    //   775: aload 34
    //   777: astore_1
    //   778: iload 9
    //   780: istore 7
    //   782: iload 8
    //   784: istore 9
    //   786: iload 4
    //   788: iflt +201 -> 989
    //   791: iload 4
    //   793: iconst_1
    //   794: iand
    //   795: iconst_1
    //   796: if_icmpne +3206 -> 4002
    //   799: iconst_1
    //   800: istore_3
    //   801: iload_3
    //   802: ifeq +5191 -> 5993
    //   805: aload 5
    //   807: ifnull +5186 -> 5993
    //   810: iload_2
    //   811: ifeq +5182 -> 5993
    //   814: aload_1
    //   815: astore 34
    //   817: iload 7
    //   819: istore 8
    //   821: new 142	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   828: astore 36
    //   830: aload_1
    //   831: astore 34
    //   833: iload 7
    //   835: istore 8
    //   837: new 142	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   844: astore 35
    //   846: aload_1
    //   847: astore 34
    //   849: iload 7
    //   851: istore 8
    //   853: aload 36
    //   855: aload 35
    //   857: invokestatic 220	asfh:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   860: pop
    //   861: aload_1
    //   862: astore 34
    //   864: iload 7
    //   866: istore 8
    //   868: aload 5
    //   870: iconst_1
    //   871: new 222	android/util/Pair
    //   874: dup
    //   875: aload 35
    //   877: aload 36
    //   879: invokespecial 225	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   882: invokevirtual 231	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   885: goto +5108 -> 5993
    //   888: iload_2
    //   889: ifeq +26 -> 915
    //   892: aload 5
    //   894: ifnull +21 -> 915
    //   897: aload_1
    //   898: astore 34
    //   900: iload 7
    //   902: istore 8
    //   904: aload 5
    //   906: iconst_2
    //   907: aload 40
    //   909: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokevirtual 231	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   915: aload_1
    //   916: astore 34
    //   918: iload 7
    //   920: istore 8
    //   922: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: ifeq +64 -> 989
    //   928: aload_1
    //   929: astore 34
    //   931: iload 7
    //   933: istore 8
    //   935: ldc_w 280
    //   938: iconst_2
    //   939: ldc 233
    //   941: iconst_5
    //   942: anewarray 4	java/lang/Object
    //   945: dup
    //   946: iconst_0
    //   947: iload 9
    //   949: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   952: aastore
    //   953: dup
    //   954: iconst_1
    //   955: iload 4
    //   957: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   960: aastore
    //   961: dup
    //   962: iconst_2
    //   963: iload_3
    //   964: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   967: aastore
    //   968: dup
    //   969: iconst_3
    //   970: iload_2
    //   971: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   974: aastore
    //   975: dup
    //   976: iconst_4
    //   977: aload 40
    //   979: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: aastore
    //   983: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   986: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: iload 7
    //   991: ifeq +7 -> 998
    //   994: invokestatic 236	rvx:ub	()I
    //   997: pop
    //   998: iload 6
    //   1000: ifeq +14 -> 1014
    //   1003: invokestatic 47	adjn:a	()Ladjn;
    //   1006: lload 28
    //   1008: ldc_w 280
    //   1011: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   1014: iload 4
    //   1016: istore 6
    //   1018: aload_1
    //   1019: ifnull +11 -> 1030
    //   1022: aload_1
    //   1023: invokevirtual 327	java/io/InputStream:close	()V
    //   1026: iload 4
    //   1028: istore 6
    //   1030: iload 6
    //   1032: istore 4
    //   1034: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1037: ifeq -1026 -> 11
    //   1040: ldc_w 280
    //   1043: iconst_4
    //   1044: new 142	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   1051: ldc_w 329
    //   1054: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1060: lload 32
    //   1062: lsub
    //   1063: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: ldc_w 331
    //   1069: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload_0
    //   1073: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: iload 6
    //   1084: ireturn
    //   1085: iconst_0
    //   1086: istore 9
    //   1088: goto -487 -> 601
    //   1091: astore_1
    //   1092: iconst_0
    //   1093: istore 9
    //   1095: iload 13
    //   1097: istore 8
    //   1099: iload 4
    //   1101: istore 7
    //   1103: iload 9
    //   1105: istore 4
    //   1107: iload 4
    //   1109: istore 12
    //   1111: iload 4
    //   1113: istore 17
    //   1115: iload 8
    //   1117: istore 16
    //   1119: iload 4
    //   1121: istore 13
    //   1123: iload 8
    //   1125: istore 9
    //   1127: iload 4
    //   1129: istore 14
    //   1131: iload 8
    //   1133: istore 10
    //   1135: iload 4
    //   1137: istore 15
    //   1139: iload 8
    //   1141: istore 11
    //   1143: aload_1
    //   1144: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1147: iload 4
    //   1149: istore 12
    //   1151: iload 4
    //   1153: istore 17
    //   1155: iload 8
    //   1157: istore 16
    //   1159: iload 4
    //   1161: istore 13
    //   1163: iload 8
    //   1165: istore 9
    //   1167: iload 4
    //   1169: istore 14
    //   1171: iload 8
    //   1173: istore 10
    //   1175: iload 4
    //   1177: istore 15
    //   1179: iload 8
    //   1181: istore 11
    //   1183: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1186: ifeq +4820 -> 6006
    //   1189: iload 4
    //   1191: istore 12
    //   1193: iload 4
    //   1195: istore 17
    //   1197: iload 8
    //   1199: istore 16
    //   1201: iload 4
    //   1203: istore 13
    //   1205: iload 8
    //   1207: istore 9
    //   1209: iload 4
    //   1211: istore 14
    //   1213: iload 8
    //   1215: istore 10
    //   1217: iload 4
    //   1219: istore 15
    //   1221: iload 8
    //   1223: istore 11
    //   1225: ldc_w 280
    //   1228: iconst_2
    //   1229: aload_1
    //   1230: invokevirtual 333	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1233: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: goto +4770 -> 6006
    //   1239: iload 4
    //   1241: istore 12
    //   1243: iload 4
    //   1245: istore 17
    //   1247: iload 8
    //   1249: istore 16
    //   1251: iload 4
    //   1253: istore 13
    //   1255: iload 8
    //   1257: istore 9
    //   1259: iload 4
    //   1261: istore 14
    //   1263: iload 8
    //   1265: istore 10
    //   1267: iload 4
    //   1269: istore 15
    //   1271: iload 8
    //   1273: istore 11
    //   1275: aload_1
    //   1276: invokevirtual 259	java/lang/Throwable:printStackTrace	()V
    //   1279: iload 4
    //   1281: istore 12
    //   1283: iload 4
    //   1285: istore 17
    //   1287: iload 8
    //   1289: istore 16
    //   1291: iload 4
    //   1293: istore 13
    //   1295: iload 8
    //   1297: istore 9
    //   1299: iload 4
    //   1301: istore 14
    //   1303: iload 8
    //   1305: istore 10
    //   1307: iload 4
    //   1309: istore 15
    //   1311: iload 8
    //   1313: istore 11
    //   1315: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1318: ifeq +50 -> 1368
    //   1321: iload 4
    //   1323: istore 12
    //   1325: iload 4
    //   1327: istore 17
    //   1329: iload 8
    //   1331: istore 16
    //   1333: iload 4
    //   1335: istore 13
    //   1337: iload 8
    //   1339: istore 9
    //   1341: iload 4
    //   1343: istore 14
    //   1345: iload 8
    //   1347: istore 10
    //   1349: iload 4
    //   1351: istore 15
    //   1353: iload 8
    //   1355: istore 11
    //   1357: ldc_w 280
    //   1360: iconst_2
    //   1361: aload_1
    //   1362: invokevirtual 260	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1365: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: aload 34
    //   1370: astore_1
    //   1371: iload 7
    //   1373: istore 9
    //   1375: iload 4
    //   1377: istore 7
    //   1379: iload 8
    //   1381: istore 4
    //   1383: goto -597 -> 786
    //   1386: new 335	android/graphics/BitmapFactory$Options
    //   1389: dup
    //   1390: invokespecial 336	android/graphics/BitmapFactory$Options:<init>	()V
    //   1393: astore 41
    //   1395: aload 41
    //   1397: iconst_1
    //   1398: putfield 339	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1401: aload 34
    //   1403: aconst_null
    //   1404: aload 41
    //   1406: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1409: pop
    //   1410: aload 34
    //   1412: invokevirtual 327	java/io/InputStream:close	()V
    //   1415: aconst_null
    //   1416: astore_1
    //   1417: aconst_null
    //   1418: astore 35
    //   1420: aconst_null
    //   1421: astore 36
    //   1423: aload_1
    //   1424: astore 34
    //   1426: iload 21
    //   1428: istore 8
    //   1430: aload 41
    //   1432: getfield 348	android/graphics/BitmapFactory$Options:outWidth	I
    //   1435: istore 15
    //   1437: aload_1
    //   1438: astore 34
    //   1440: iload 21
    //   1442: istore 8
    //   1444: aload 41
    //   1446: getfield 351	android/graphics/BitmapFactory$Options:outHeight	I
    //   1449: istore 16
    //   1451: iload 15
    //   1453: sipush 12800
    //   1456: if_icmpgt +11 -> 1467
    //   1459: iload 16
    //   1461: sipush 12800
    //   1464: if_icmple +65 -> 1529
    //   1467: iconst_0
    //   1468: istore 7
    //   1470: iload 6
    //   1472: ifeq +14 -> 1486
    //   1475: invokestatic 47	adjn:a	()Ladjn;
    //   1478: lload 28
    //   1480: ldc_w 280
    //   1483: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   1486: iload 7
    //   1488: istore 4
    //   1490: iconst_0
    //   1491: ifeq -1480 -> 11
    //   1494: new 353	java/lang/NullPointerException
    //   1497: dup
    //   1498: invokespecial 354	java/lang/NullPointerException:<init>	()V
    //   1501: athrow
    //   1502: astore_0
    //   1503: aload_0
    //   1504: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   1507: iload 7
    //   1509: istore 4
    //   1511: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1514: ifeq -1503 -> 11
    //   1517: ldc 77
    //   1519: iconst_2
    //   1520: aload_0
    //   1521: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   1524: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1527: iconst_0
    //   1528: ireturn
    //   1529: aload_1
    //   1530: astore 34
    //   1532: iload 21
    //   1534: istore 8
    //   1536: iload 15
    //   1538: iload 16
    //   1540: invokestatic 174	asfh:by	(II)Z
    //   1543: ifne +4393 -> 5936
    //   1546: iload 4
    //   1548: bipush 254
    //   1550: iand
    //   1551: istore 10
    //   1553: iload 10
    //   1555: iconst_1
    //   1556: iand
    //   1557: iconst_1
    //   1558: if_icmpne +4372 -> 5930
    //   1561: aload_1
    //   1562: astore 34
    //   1564: iload 21
    //   1566: istore 8
    //   1568: invokestatic 177	rvx:ua	()I
    //   1571: pop
    //   1572: iconst_1
    //   1573: istore 7
    //   1575: aload 35
    //   1577: astore_1
    //   1578: aload 41
    //   1580: aload 41
    //   1582: sipush 1280
    //   1585: sipush 1280
    //   1588: invokestatic 362	zti:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1591: putfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1594: aload 35
    //   1596: astore_1
    //   1597: aload 41
    //   1599: iconst_0
    //   1600: putfield 339	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1603: aload 36
    //   1605: astore 34
    //   1607: aload 35
    //   1609: astore_1
    //   1610: aload 42
    //   1612: aload_0
    //   1613: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1616: astore 35
    //   1618: aload 35
    //   1620: astore 34
    //   1622: aload 35
    //   1624: astore_1
    //   1625: aload 35
    //   1627: astore 39
    //   1629: aload 35
    //   1631: astore 37
    //   1633: aload 35
    //   1635: astore 36
    //   1637: aload 35
    //   1639: astore 38
    //   1641: aload 35
    //   1643: aconst_null
    //   1644: aload 41
    //   1646: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1649: astore 43
    //   1651: aload 35
    //   1653: astore 34
    //   1655: aload 35
    //   1657: astore_1
    //   1658: aload 35
    //   1660: astore 39
    //   1662: aload 35
    //   1664: astore 37
    //   1666: aload 35
    //   1668: astore 36
    //   1670: aload 35
    //   1672: astore 38
    //   1674: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1677: ifeq +70 -> 1747
    //   1680: aload 35
    //   1682: astore 34
    //   1684: aload 35
    //   1686: astore_1
    //   1687: aload 35
    //   1689: astore 39
    //   1691: aload 35
    //   1693: astore 37
    //   1695: aload 35
    //   1697: astore 36
    //   1699: aload 35
    //   1701: astore 38
    //   1703: ldc_w 280
    //   1706: iconst_4
    //   1707: ldc_w 367
    //   1710: iconst_3
    //   1711: anewarray 4	java/lang/Object
    //   1714: dup
    //   1715: iconst_0
    //   1716: iload 15
    //   1718: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1721: aastore
    //   1722: dup
    //   1723: iconst_1
    //   1724: iload 16
    //   1726: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1729: aastore
    //   1730: dup
    //   1731: iconst_2
    //   1732: aload 41
    //   1734: getfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1737: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1740: aastore
    //   1741: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1744: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1747: aload 35
    //   1749: astore 34
    //   1751: aload 35
    //   1753: astore_1
    //   1754: aload 35
    //   1756: astore 39
    //   1758: aload 35
    //   1760: astore 37
    //   1762: aload 35
    //   1764: astore 36
    //   1766: aload 35
    //   1768: astore 38
    //   1770: aload 35
    //   1772: invokevirtual 327	java/io/InputStream:close	()V
    //   1775: aconst_null
    //   1776: astore_1
    //   1777: aconst_null
    //   1778: astore 34
    //   1780: iload 20
    //   1782: istore 4
    //   1784: aload 43
    //   1786: ifnull +20 -> 1806
    //   1789: aload 43
    //   1791: iload 10
    //   1793: aload 40
    //   1795: invokestatic 202	rvx:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1798: istore 4
    //   1800: iconst_0
    //   1801: iload 4
    //   1803: ior
    //   1804: istore 4
    //   1806: aconst_null
    //   1807: astore 34
    //   1809: aconst_null
    //   1810: astore 36
    //   1812: aconst_null
    //   1813: astore 35
    //   1815: aload 36
    //   1817: astore_1
    //   1818: iload 4
    //   1820: istore 14
    //   1822: iload 4
    //   1824: istore 12
    //   1826: iload 4
    //   1828: istore 13
    //   1830: iload 4
    //   1832: istore 11
    //   1834: iload 10
    //   1836: iload 4
    //   1838: invokestatic 206	rvx:ab	(II)I
    //   1841: istore 17
    //   1843: iload 17
    //   1845: ifle +4076 -> 5921
    //   1848: iload 15
    //   1850: iload 16
    //   1852: iconst_2
    //   1853: imul
    //   1854: if_icmplt +1098 -> 2952
    //   1857: iload 16
    //   1859: sipush 1280
    //   1862: if_icmpge +1090 -> 2952
    //   1865: iconst_1
    //   1866: istore 8
    //   1868: iload 15
    //   1870: iconst_2
    //   1871: imul
    //   1872: iload 16
    //   1874: if_icmpgt +1084 -> 2958
    //   1877: iload 15
    //   1879: sipush 1280
    //   1882: if_icmpge +1076 -> 2958
    //   1885: iconst_1
    //   1886: istore 9
    //   1888: iload 9
    //   1890: ifeq +1165 -> 3055
    //   1893: aload 36
    //   1895: astore_1
    //   1896: iload 4
    //   1898: istore 14
    //   1900: iload 4
    //   1902: istore 12
    //   1904: iload 4
    //   1906: istore 13
    //   1908: iload 4
    //   1910: istore 11
    //   1912: aload 42
    //   1914: aload_0
    //   1915: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1918: astore 34
    //   1920: aload 34
    //   1922: astore 35
    //   1924: aload 34
    //   1926: astore_1
    //   1927: aload 34
    //   1929: astore 37
    //   1931: iload 4
    //   1933: istore 11
    //   1935: aload 34
    //   1937: astore 36
    //   1939: iload 4
    //   1941: istore 12
    //   1943: aload 34
    //   1945: astore 38
    //   1947: iload 4
    //   1949: istore 13
    //   1951: aload 34
    //   1953: astore 39
    //   1955: iload 4
    //   1957: istore 9
    //   1959: aload 34
    //   1961: invokestatic 370	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1964: astore 43
    //   1966: aload 34
    //   1968: astore 35
    //   1970: aload 34
    //   1972: astore_1
    //   1973: aload 34
    //   1975: astore 37
    //   1977: iload 4
    //   1979: istore 11
    //   1981: aload 34
    //   1983: astore 36
    //   1985: iload 4
    //   1987: istore 12
    //   1989: aload 34
    //   1991: astore 38
    //   1993: iload 4
    //   1995: istore 13
    //   1997: aload 34
    //   1999: astore 39
    //   2001: iload 4
    //   2003: istore 9
    //   2005: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2008: ifeq +70 -> 2078
    //   2011: aload 34
    //   2013: astore 35
    //   2015: aload 34
    //   2017: astore_1
    //   2018: aload 34
    //   2020: astore 37
    //   2022: iload 4
    //   2024: istore 11
    //   2026: aload 34
    //   2028: astore 36
    //   2030: iload 4
    //   2032: istore 12
    //   2034: aload 34
    //   2036: astore 38
    //   2038: iload 4
    //   2040: istore 13
    //   2042: aload 34
    //   2044: astore 39
    //   2046: iload 4
    //   2048: istore 9
    //   2050: ldc_w 280
    //   2053: iconst_4
    //   2054: new 142	java/lang/StringBuilder
    //   2057: dup
    //   2058: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2061: ldc_w 372
    //   2064: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2067: aload 43
    //   2069: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2072: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2075: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2078: aload 34
    //   2080: astore 35
    //   2082: aload 34
    //   2084: astore_1
    //   2085: aload 34
    //   2087: astore 37
    //   2089: iload 4
    //   2091: istore 11
    //   2093: aload 34
    //   2095: astore 36
    //   2097: iload 4
    //   2099: istore 12
    //   2101: aload 34
    //   2103: astore 38
    //   2105: iload 4
    //   2107: istore 13
    //   2109: aload 34
    //   2111: astore 39
    //   2113: iload 4
    //   2115: istore 9
    //   2117: aload 34
    //   2119: invokevirtual 327	java/io/InputStream:close	()V
    //   2122: aconst_null
    //   2123: astore 37
    //   2125: aconst_null
    //   2126: astore 36
    //   2128: aconst_null
    //   2129: astore 34
    //   2131: aconst_null
    //   2132: astore 35
    //   2134: aload 43
    //   2136: ifnull +3791 -> 5927
    //   2139: iload 4
    //   2141: istore 12
    //   2143: iload 4
    //   2145: istore 9
    //   2147: iload 4
    //   2149: istore 11
    //   2151: iload 4
    //   2153: istore 8
    //   2155: iload 4
    //   2157: istore 13
    //   2159: iload 15
    //   2161: iload 15
    //   2163: imul
    //   2164: newarray int
    //   2166: astore 38
    //   2168: iload 4
    //   2170: istore 12
    //   2172: iload 4
    //   2174: istore 9
    //   2176: iload 4
    //   2178: istore 11
    //   2180: iload 4
    //   2182: istore 8
    //   2184: iload 4
    //   2186: istore 13
    //   2188: aload 43
    //   2190: aload 38
    //   2192: iconst_0
    //   2193: iload 15
    //   2195: iconst_0
    //   2196: iconst_0
    //   2197: iload 15
    //   2199: iload 15
    //   2201: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2204: iload 4
    //   2206: istore 12
    //   2208: iload 4
    //   2210: istore 9
    //   2212: iload 4
    //   2214: istore 11
    //   2216: iload 4
    //   2218: istore 8
    //   2220: iload 4
    //   2222: istore 13
    //   2224: iload 15
    //   2226: iload 15
    //   2228: imul
    //   2229: newarray byte
    //   2231: astore_1
    //   2232: iload 4
    //   2234: istore 12
    //   2236: iload 4
    //   2238: istore 9
    //   2240: iload 4
    //   2242: istore 11
    //   2244: iload 4
    //   2246: istore 8
    //   2248: iload 4
    //   2250: istore 13
    //   2252: aload 38
    //   2254: aload_1
    //   2255: iload 15
    //   2257: iload 15
    //   2259: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2262: pop
    //   2263: iload 4
    //   2265: istore 12
    //   2267: iload 4
    //   2269: istore 9
    //   2271: iload 4
    //   2273: istore 11
    //   2275: iload 4
    //   2277: istore 8
    //   2279: iload 4
    //   2281: istore 13
    //   2283: iload 4
    //   2285: aload 38
    //   2287: aload_1
    //   2288: iload 15
    //   2290: iload 15
    //   2292: iload 17
    //   2294: aload 40
    //   2296: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2299: ior
    //   2300: istore 4
    //   2302: iload 4
    //   2304: iconst_1
    //   2305: if_icmpeq +3619 -> 5924
    //   2308: iload 4
    //   2310: istore 12
    //   2312: iload 4
    //   2314: istore 9
    //   2316: iload 4
    //   2318: istore 11
    //   2320: iload 4
    //   2322: istore 8
    //   2324: iload 4
    //   2326: istore 13
    //   2328: aload 43
    //   2330: aload 38
    //   2332: iconst_0
    //   2333: iload 15
    //   2335: iconst_0
    //   2336: iload 16
    //   2338: iload 15
    //   2340: isub
    //   2341: iload 15
    //   2343: iload 15
    //   2345: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2348: iload 4
    //   2350: istore 12
    //   2352: iload 4
    //   2354: istore 9
    //   2356: iload 4
    //   2358: istore 11
    //   2360: iload 4
    //   2362: istore 8
    //   2364: iload 4
    //   2366: istore 13
    //   2368: aload 38
    //   2370: aload_1
    //   2371: iload 15
    //   2373: iload 15
    //   2375: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2378: pop
    //   2379: iload 4
    //   2381: istore 12
    //   2383: iload 4
    //   2385: istore 9
    //   2387: iload 4
    //   2389: istore 11
    //   2391: iload 4
    //   2393: istore 8
    //   2395: iload 4
    //   2397: istore 13
    //   2399: aload 38
    //   2401: aload_1
    //   2402: iload 15
    //   2404: iload 15
    //   2406: iload 17
    //   2408: aload 40
    //   2410: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2413: istore 14
    //   2415: iload 14
    //   2417: iload 4
    //   2419: ior
    //   2420: istore 4
    //   2422: aload 43
    //   2424: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   2427: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2430: ifeq +44 -> 2474
    //   2433: ldc_w 280
    //   2436: iconst_4
    //   2437: ldc_w 374
    //   2440: iconst_3
    //   2441: anewarray 4	java/lang/Object
    //   2444: dup
    //   2445: iconst_0
    //   2446: iload 17
    //   2448: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2451: aastore
    //   2452: dup
    //   2453: iconst_1
    //   2454: iload 4
    //   2456: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2459: aastore
    //   2460: dup
    //   2461: iconst_2
    //   2462: aload 40
    //   2464: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2467: aastore
    //   2468: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2471: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2474: aconst_null
    //   2475: astore 36
    //   2477: aconst_null
    //   2478: astore 34
    //   2480: aconst_null
    //   2481: astore 35
    //   2483: aload 34
    //   2485: astore_1
    //   2486: iload 10
    //   2488: iload 4
    //   2490: invokestatic 206	rvx:ab	(II)I
    //   2493: istore 13
    //   2495: iload 13
    //   2497: ifle +3414 -> 5911
    //   2500: aload 34
    //   2502: astore_1
    //   2503: iload 15
    //   2505: iload 16
    //   2507: invokestatic 211	java/lang/Math:min	(II)I
    //   2510: istore 8
    //   2512: iload 8
    //   2514: sipush 250
    //   2517: if_icmple +3394 -> 5911
    //   2520: aload 34
    //   2522: astore_1
    //   2523: aload 41
    //   2525: iload 8
    //   2527: i2d
    //   2528: ldc2_w 212
    //   2531: ddiv
    //   2532: invokestatic 217	java/lang/Math:ceil	(D)D
    //   2535: d2i
    //   2536: putfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2539: aload 36
    //   2541: astore 35
    //   2543: aload 34
    //   2545: astore_1
    //   2546: aload 42
    //   2548: aload_0
    //   2549: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2552: astore 34
    //   2554: aload 34
    //   2556: astore 35
    //   2558: aload 34
    //   2560: astore_1
    //   2561: aload 34
    //   2563: astore 38
    //   2565: iload 4
    //   2567: istore 11
    //   2569: aload 34
    //   2571: astore 37
    //   2573: iload 4
    //   2575: istore 9
    //   2577: aload 34
    //   2579: astore 36
    //   2581: iload 4
    //   2583: istore 12
    //   2585: aload 34
    //   2587: astore 39
    //   2589: iload 4
    //   2591: istore 8
    //   2593: aload 34
    //   2595: aconst_null
    //   2596: aload 41
    //   2598: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2601: astore 41
    //   2603: aload 34
    //   2605: astore 35
    //   2607: aload 34
    //   2609: astore_1
    //   2610: aload 34
    //   2612: astore 38
    //   2614: iload 4
    //   2616: istore 11
    //   2618: aload 34
    //   2620: astore 37
    //   2622: iload 4
    //   2624: istore 9
    //   2626: aload 34
    //   2628: astore 36
    //   2630: iload 4
    //   2632: istore 12
    //   2634: aload 34
    //   2636: astore 39
    //   2638: iload 4
    //   2640: istore 8
    //   2642: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2645: ifeq +70 -> 2715
    //   2648: aload 34
    //   2650: astore 35
    //   2652: aload 34
    //   2654: astore_1
    //   2655: aload 34
    //   2657: astore 38
    //   2659: iload 4
    //   2661: istore 11
    //   2663: aload 34
    //   2665: astore 37
    //   2667: iload 4
    //   2669: istore 9
    //   2671: aload 34
    //   2673: astore 36
    //   2675: iload 4
    //   2677: istore 12
    //   2679: aload 34
    //   2681: astore 39
    //   2683: iload 4
    //   2685: istore 8
    //   2687: ldc_w 280
    //   2690: iconst_4
    //   2691: new 142	java/lang/StringBuilder
    //   2694: dup
    //   2695: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2698: ldc_w 376
    //   2701: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2704: aload 41
    //   2706: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2709: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2712: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2715: aload 34
    //   2717: astore 35
    //   2719: aload 34
    //   2721: astore_1
    //   2722: aload 34
    //   2724: astore 38
    //   2726: iload 4
    //   2728: istore 11
    //   2730: aload 34
    //   2732: astore 37
    //   2734: iload 4
    //   2736: istore 9
    //   2738: aload 34
    //   2740: astore 36
    //   2742: iload 4
    //   2744: istore 12
    //   2746: aload 34
    //   2748: astore 39
    //   2750: iload 4
    //   2752: istore 8
    //   2754: aload 34
    //   2756: invokevirtual 327	java/io/InputStream:close	()V
    //   2759: aload 41
    //   2761: ifnull +3143 -> 5904
    //   2764: aload 41
    //   2766: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   2769: istore 8
    //   2771: aload 41
    //   2773: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   2776: istore 9
    //   2778: iload 8
    //   2780: iload 9
    //   2782: imul
    //   2783: newarray int
    //   2785: astore_1
    //   2786: aload 41
    //   2788: aload_1
    //   2789: iconst_0
    //   2790: iload 8
    //   2792: iconst_0
    //   2793: iconst_0
    //   2794: iload 8
    //   2796: iload 9
    //   2798: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2801: aload 41
    //   2803: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   2806: aload_1
    //   2807: aconst_null
    //   2808: iload 8
    //   2810: iload 9
    //   2812: iload 13
    //   2814: aload 40
    //   2816: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2819: istore 8
    //   2821: iload 8
    //   2823: iload 4
    //   2825: ior
    //   2826: istore 4
    //   2828: iload 4
    //   2830: istore 8
    //   2832: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2835: ifeq +48 -> 2883
    //   2838: ldc_w 280
    //   2841: iconst_4
    //   2842: ldc_w 378
    //   2845: iconst_3
    //   2846: anewarray 4	java/lang/Object
    //   2849: dup
    //   2850: iconst_0
    //   2851: iload 13
    //   2853: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2856: aastore
    //   2857: dup
    //   2858: iconst_1
    //   2859: iload 4
    //   2861: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2864: aastore
    //   2865: dup
    //   2866: iconst_2
    //   2867: aload 40
    //   2869: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2872: aastore
    //   2873: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2876: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2879: iload 4
    //   2881: istore 8
    //   2883: aconst_null
    //   2884: astore_1
    //   2885: iload 10
    //   2887: istore 9
    //   2889: iload 8
    //   2891: istore 4
    //   2893: goto -2107 -> 786
    //   2896: astore 35
    //   2898: aload 34
    //   2900: astore_1
    //   2901: aload 34
    //   2903: astore 39
    //   2905: aload 34
    //   2907: astore 37
    //   2909: aload 34
    //   2911: astore 36
    //   2913: aload 34
    //   2915: astore 38
    //   2917: aload 35
    //   2919: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2922: aload 34
    //   2924: astore_1
    //   2925: aload 34
    //   2927: astore 39
    //   2929: aload 34
    //   2931: astore 37
    //   2933: aload 34
    //   2935: astore 36
    //   2937: aload 34
    //   2939: astore 38
    //   2941: aload 34
    //   2943: invokevirtual 327	java/io/InputStream:close	()V
    //   2946: iconst_0
    //   2947: istore 4
    //   2949: goto -1143 -> 1806
    //   2952: iconst_0
    //   2953: istore 8
    //   2955: goto -1087 -> 1868
    //   2958: iconst_0
    //   2959: istore 9
    //   2961: goto -1073 -> 1888
    //   2964: astore_1
    //   2965: aload 35
    //   2967: astore 34
    //   2969: aload_1
    //   2970: astore 35
    //   2972: aload 34
    //   2974: astore_1
    //   2975: aload 34
    //   2977: astore 37
    //   2979: iload 4
    //   2981: istore 11
    //   2983: aload 34
    //   2985: astore 36
    //   2987: iload 4
    //   2989: istore 12
    //   2991: aload 34
    //   2993: astore 38
    //   2995: iload 4
    //   2997: istore 13
    //   2999: aload 34
    //   3001: astore 39
    //   3003: iload 4
    //   3005: istore 9
    //   3007: aload 35
    //   3009: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3012: aload 34
    //   3014: astore_1
    //   3015: aload 34
    //   3017: astore 37
    //   3019: iload 4
    //   3021: istore 11
    //   3023: aload 34
    //   3025: astore 36
    //   3027: iload 4
    //   3029: istore 12
    //   3031: aload 34
    //   3033: astore 38
    //   3035: iload 4
    //   3037: istore 13
    //   3039: aload 34
    //   3041: astore 39
    //   3043: iload 4
    //   3045: istore 9
    //   3047: aload 34
    //   3049: invokevirtual 327	java/io/InputStream:close	()V
    //   3052: goto -578 -> 2474
    //   3055: iload 8
    //   3057: ifeq +2864 -> 5921
    //   3060: iload 4
    //   3062: istore 8
    //   3064: aload 36
    //   3066: astore_1
    //   3067: iload 4
    //   3069: istore 14
    //   3071: iload 4
    //   3073: istore 12
    //   3075: iload 4
    //   3077: istore 13
    //   3079: iload 4
    //   3081: istore 11
    //   3083: aload 42
    //   3085: aload_0
    //   3086: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3089: astore 35
    //   3091: aload 35
    //   3093: astore 34
    //   3095: iload 4
    //   3097: istore 8
    //   3099: aload 35
    //   3101: astore_1
    //   3102: aload 35
    //   3104: astore 37
    //   3106: iload 4
    //   3108: istore 11
    //   3110: aload 35
    //   3112: astore 36
    //   3114: iload 4
    //   3116: istore 12
    //   3118: aload 35
    //   3120: astore 38
    //   3122: iload 4
    //   3124: istore 13
    //   3126: aload 35
    //   3128: astore 39
    //   3130: iload 4
    //   3132: istore 9
    //   3134: aload 35
    //   3136: invokestatic 370	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3139: astore 43
    //   3141: aload 35
    //   3143: astore 34
    //   3145: iload 4
    //   3147: istore 8
    //   3149: aload 35
    //   3151: astore_1
    //   3152: aload 35
    //   3154: astore 37
    //   3156: iload 4
    //   3158: istore 11
    //   3160: aload 35
    //   3162: astore 36
    //   3164: iload 4
    //   3166: istore 12
    //   3168: aload 35
    //   3170: astore 38
    //   3172: iload 4
    //   3174: istore 13
    //   3176: aload 35
    //   3178: astore 39
    //   3180: iload 4
    //   3182: istore 9
    //   3184: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3187: ifeq +74 -> 3261
    //   3190: aload 35
    //   3192: astore 34
    //   3194: iload 4
    //   3196: istore 8
    //   3198: aload 35
    //   3200: astore_1
    //   3201: aload 35
    //   3203: astore 37
    //   3205: iload 4
    //   3207: istore 11
    //   3209: aload 35
    //   3211: astore 36
    //   3213: iload 4
    //   3215: istore 12
    //   3217: aload 35
    //   3219: astore 38
    //   3221: iload 4
    //   3223: istore 13
    //   3225: aload 35
    //   3227: astore 39
    //   3229: iload 4
    //   3231: istore 9
    //   3233: ldc_w 280
    //   3236: iconst_4
    //   3237: new 142	java/lang/StringBuilder
    //   3240: dup
    //   3241: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   3244: ldc_w 380
    //   3247: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3250: aload 43
    //   3252: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3255: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3258: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3261: aload 35
    //   3263: astore 34
    //   3265: iload 4
    //   3267: istore 8
    //   3269: aload 35
    //   3271: astore_1
    //   3272: aload 35
    //   3274: astore 37
    //   3276: iload 4
    //   3278: istore 11
    //   3280: aload 35
    //   3282: astore 36
    //   3284: iload 4
    //   3286: istore 12
    //   3288: aload 35
    //   3290: astore 38
    //   3292: iload 4
    //   3294: istore 13
    //   3296: aload 35
    //   3298: astore 39
    //   3300: iload 4
    //   3302: istore 9
    //   3304: aload 35
    //   3306: invokevirtual 327	java/io/InputStream:close	()V
    //   3309: aconst_null
    //   3310: astore 35
    //   3312: aconst_null
    //   3313: astore 36
    //   3315: iload 4
    //   3317: istore 9
    //   3319: aload 43
    //   3321: ifnull +488 -> 3809
    //   3324: aload 36
    //   3326: astore 34
    //   3328: iload 4
    //   3330: istore 8
    //   3332: aload 35
    //   3334: astore_1
    //   3335: iload 4
    //   3337: istore 14
    //   3339: iload 4
    //   3341: istore 12
    //   3343: iload 4
    //   3345: istore 13
    //   3347: iload 4
    //   3349: istore 11
    //   3351: iload 16
    //   3353: iload 16
    //   3355: imul
    //   3356: newarray int
    //   3358: astore 38
    //   3360: aload 36
    //   3362: astore 34
    //   3364: iload 4
    //   3366: istore 8
    //   3368: aload 35
    //   3370: astore_1
    //   3371: iload 4
    //   3373: istore 14
    //   3375: iload 4
    //   3377: istore 12
    //   3379: iload 4
    //   3381: istore 13
    //   3383: iload 4
    //   3385: istore 11
    //   3387: aload 43
    //   3389: aload 38
    //   3391: iconst_0
    //   3392: iload 16
    //   3394: iconst_0
    //   3395: iconst_0
    //   3396: iload 16
    //   3398: iload 16
    //   3400: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3403: aload 36
    //   3405: astore 34
    //   3407: iload 4
    //   3409: istore 8
    //   3411: aload 35
    //   3413: astore_1
    //   3414: iload 4
    //   3416: istore 14
    //   3418: iload 4
    //   3420: istore 12
    //   3422: iload 4
    //   3424: istore 13
    //   3426: iload 4
    //   3428: istore 11
    //   3430: iload 16
    //   3432: iload 16
    //   3434: imul
    //   3435: newarray byte
    //   3437: astore 37
    //   3439: aload 36
    //   3441: astore 34
    //   3443: iload 4
    //   3445: istore 8
    //   3447: aload 35
    //   3449: astore_1
    //   3450: iload 4
    //   3452: istore 14
    //   3454: iload 4
    //   3456: istore 12
    //   3458: iload 4
    //   3460: istore 13
    //   3462: iload 4
    //   3464: istore 11
    //   3466: aload 38
    //   3468: aload 37
    //   3470: iload 16
    //   3472: iload 16
    //   3474: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3477: pop
    //   3478: aload 36
    //   3480: astore 34
    //   3482: iload 4
    //   3484: istore 8
    //   3486: aload 35
    //   3488: astore_1
    //   3489: iload 4
    //   3491: istore 14
    //   3493: iload 4
    //   3495: istore 12
    //   3497: iload 4
    //   3499: istore 13
    //   3501: iload 4
    //   3503: istore 11
    //   3505: iload 4
    //   3507: aload 38
    //   3509: aload 37
    //   3511: iload 16
    //   3513: iload 16
    //   3515: iload 17
    //   3517: aload 40
    //   3519: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3522: ior
    //   3523: istore 9
    //   3525: iload 9
    //   3527: istore 4
    //   3529: iload 9
    //   3531: iconst_1
    //   3532: if_icmpeq +136 -> 3668
    //   3535: aload 36
    //   3537: astore 34
    //   3539: iload 9
    //   3541: istore 8
    //   3543: aload 35
    //   3545: astore_1
    //   3546: iload 9
    //   3548: istore 14
    //   3550: iload 9
    //   3552: istore 12
    //   3554: iload 9
    //   3556: istore 13
    //   3558: iload 9
    //   3560: istore 11
    //   3562: aload 43
    //   3564: aload 38
    //   3566: iconst_0
    //   3567: iload 16
    //   3569: iload 15
    //   3571: iload 16
    //   3573: isub
    //   3574: iconst_0
    //   3575: iload 16
    //   3577: iload 16
    //   3579: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3582: aload 36
    //   3584: astore 34
    //   3586: iload 9
    //   3588: istore 8
    //   3590: aload 35
    //   3592: astore_1
    //   3593: iload 9
    //   3595: istore 14
    //   3597: iload 9
    //   3599: istore 12
    //   3601: iload 9
    //   3603: istore 13
    //   3605: iload 9
    //   3607: istore 11
    //   3609: aload 38
    //   3611: aload 37
    //   3613: iload 16
    //   3615: iload 16
    //   3617: invokestatic 135	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3620: pop
    //   3621: aload 36
    //   3623: astore 34
    //   3625: iload 9
    //   3627: istore 8
    //   3629: aload 35
    //   3631: astore_1
    //   3632: iload 9
    //   3634: istore 14
    //   3636: iload 9
    //   3638: istore 12
    //   3640: iload 9
    //   3642: istore 13
    //   3644: iload 9
    //   3646: istore 11
    //   3648: iload 9
    //   3650: aload 38
    //   3652: aload 37
    //   3654: iload 16
    //   3656: iload 16
    //   3658: iload 17
    //   3660: aload 40
    //   3662: invokestatic 138	rvx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3665: ior
    //   3666: istore 4
    //   3668: aload 36
    //   3670: astore 34
    //   3672: iload 4
    //   3674: istore 8
    //   3676: aload 35
    //   3678: astore_1
    //   3679: iload 4
    //   3681: istore 14
    //   3683: iload 4
    //   3685: istore 12
    //   3687: iload 4
    //   3689: istore 13
    //   3691: iload 4
    //   3693: istore 11
    //   3695: aload 43
    //   3697: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   3700: iload 4
    //   3702: istore 9
    //   3704: aload 36
    //   3706: astore 34
    //   3708: iload 4
    //   3710: istore 8
    //   3712: aload 35
    //   3714: astore_1
    //   3715: iload 4
    //   3717: istore 14
    //   3719: iload 4
    //   3721: istore 12
    //   3723: iload 4
    //   3725: istore 13
    //   3727: iload 4
    //   3729: istore 11
    //   3731: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3734: ifeq +75 -> 3809
    //   3737: aload 36
    //   3739: astore 34
    //   3741: iload 4
    //   3743: istore 8
    //   3745: aload 35
    //   3747: astore_1
    //   3748: iload 4
    //   3750: istore 14
    //   3752: iload 4
    //   3754: istore 12
    //   3756: iload 4
    //   3758: istore 13
    //   3760: iload 4
    //   3762: istore 11
    //   3764: ldc_w 280
    //   3767: iconst_4
    //   3768: ldc_w 382
    //   3771: iconst_3
    //   3772: anewarray 4	java/lang/Object
    //   3775: dup
    //   3776: iconst_0
    //   3777: iload 17
    //   3779: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3782: aastore
    //   3783: dup
    //   3784: iconst_1
    //   3785: iload 4
    //   3787: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3790: aastore
    //   3791: dup
    //   3792: iconst_2
    //   3793: aload 40
    //   3795: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3798: aastore
    //   3799: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3802: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3805: iload 4
    //   3807: istore 9
    //   3809: iload 9
    //   3811: istore 4
    //   3813: goto -1339 -> 2474
    //   3816: astore 35
    //   3818: aload 34
    //   3820: astore_1
    //   3821: aload 34
    //   3823: astore 37
    //   3825: iload 8
    //   3827: istore 11
    //   3829: aload 34
    //   3831: astore 36
    //   3833: iload 8
    //   3835: istore 12
    //   3837: aload 34
    //   3839: astore 38
    //   3841: iload 8
    //   3843: istore 13
    //   3845: aload 34
    //   3847: astore 39
    //   3849: iload 8
    //   3851: istore 9
    //   3853: aload 35
    //   3855: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3858: aload 34
    //   3860: astore_1
    //   3861: aload 34
    //   3863: astore 37
    //   3865: iload 8
    //   3867: istore 11
    //   3869: aload 34
    //   3871: astore 36
    //   3873: iload 8
    //   3875: istore 12
    //   3877: aload 34
    //   3879: astore 38
    //   3881: iload 8
    //   3883: istore 13
    //   3885: aload 34
    //   3887: astore 39
    //   3889: iload 8
    //   3891: istore 9
    //   3893: aload 34
    //   3895: invokevirtual 327	java/io/InputStream:close	()V
    //   3898: iload 8
    //   3900: istore 4
    //   3902: goto -1428 -> 2474
    //   3905: astore_1
    //   3906: aload 35
    //   3908: astore 34
    //   3910: aload_1
    //   3911: astore 35
    //   3913: aload 34
    //   3915: astore_1
    //   3916: aload 34
    //   3918: astore 38
    //   3920: iload 4
    //   3922: istore 11
    //   3924: aload 34
    //   3926: astore 37
    //   3928: iload 4
    //   3930: istore 9
    //   3932: aload 34
    //   3934: astore 36
    //   3936: iload 4
    //   3938: istore 12
    //   3940: aload 34
    //   3942: astore 39
    //   3944: iload 4
    //   3946: istore 8
    //   3948: aload 35
    //   3950: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3953: aload 34
    //   3955: astore_1
    //   3956: aload 34
    //   3958: astore 38
    //   3960: iload 4
    //   3962: istore 11
    //   3964: aload 34
    //   3966: astore 37
    //   3968: iload 4
    //   3970: istore 9
    //   3972: aload 34
    //   3974: astore 36
    //   3976: iload 4
    //   3978: istore 12
    //   3980: aload 34
    //   3982: astore 39
    //   3984: iload 4
    //   3986: istore 8
    //   3988: aload 34
    //   3990: invokevirtual 327	java/io/InputStream:close	()V
    //   3993: aconst_null
    //   3994: astore_1
    //   3995: iload 10
    //   3997: istore 9
    //   3999: goto -3213 -> 786
    //   4002: iconst_0
    //   4003: istore_3
    //   4004: goto -3203 -> 801
    //   4007: iconst_0
    //   4008: istore_2
    //   4009: goto -3121 -> 888
    //   4012: astore_1
    //   4013: aload_1
    //   4014: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4017: iload 4
    //   4019: istore 6
    //   4021: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4024: ifeq -2994 -> 1030
    //   4027: ldc 77
    //   4029: iconst_2
    //   4030: aload_1
    //   4031: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4034: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4037: iload 4
    //   4039: istore 6
    //   4041: goto -3011 -> 1030
    //   4044: astore_1
    //   4045: iconst_0
    //   4046: istore 6
    //   4048: iconst_0
    //   4049: istore 4
    //   4051: aload 38
    //   4053: astore 34
    //   4055: iload 12
    //   4057: istore 7
    //   4059: lload 30
    //   4061: lstore 28
    //   4063: aload_1
    //   4064: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4067: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4070: ifeq +14 -> 4084
    //   4073: ldc_w 280
    //   4076: iconst_2
    //   4077: aload_1
    //   4078: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4081: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4084: iload 7
    //   4086: ifeq +7 -> 4093
    //   4089: invokestatic 236	rvx:ub	()I
    //   4092: pop
    //   4093: iload 6
    //   4095: ifeq +14 -> 4109
    //   4098: invokestatic 47	adjn:a	()Ladjn;
    //   4101: lload 28
    //   4103: ldc_w 280
    //   4106: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   4109: iload 4
    //   4111: istore 6
    //   4113: aload 34
    //   4115: ifnull -3085 -> 1030
    //   4118: aload 34
    //   4120: invokevirtual 327	java/io/InputStream:close	()V
    //   4123: iload 4
    //   4125: istore 6
    //   4127: goto -3097 -> 1030
    //   4130: astore_1
    //   4131: aload_1
    //   4132: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4135: iload 4
    //   4137: istore 6
    //   4139: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4142: ifeq -3112 -> 1030
    //   4145: ldc 77
    //   4147: iconst_2
    //   4148: aload_1
    //   4149: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4152: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4155: iload 4
    //   4157: istore 6
    //   4159: goto -3129 -> 1030
    //   4162: astore_1
    //   4163: ldc2_w 286
    //   4166: lstore 30
    //   4168: iconst_0
    //   4169: istore 6
    //   4171: iconst_0
    //   4172: istore 7
    //   4174: iconst_0
    //   4175: istore 4
    //   4177: aload 37
    //   4179: astore 34
    //   4181: aload 34
    //   4183: astore 5
    //   4185: lload 30
    //   4187: lstore 28
    //   4189: iload 6
    //   4191: istore 9
    //   4193: iload 7
    //   4195: istore 8
    //   4197: aload_1
    //   4198: invokevirtual 252	java/lang/RuntimeException:printStackTrace	()V
    //   4201: aload 34
    //   4203: astore 5
    //   4205: lload 30
    //   4207: lstore 28
    //   4209: iload 6
    //   4211: istore 9
    //   4213: iload 7
    //   4215: istore 8
    //   4217: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4220: ifeq +30 -> 4250
    //   4223: aload 34
    //   4225: astore 5
    //   4227: lload 30
    //   4229: lstore 28
    //   4231: iload 6
    //   4233: istore 9
    //   4235: iload 7
    //   4237: istore 8
    //   4239: ldc_w 280
    //   4242: iconst_2
    //   4243: aload_1
    //   4244: invokevirtual 253	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   4247: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4250: iload 7
    //   4252: ifeq +7 -> 4259
    //   4255: invokestatic 236	rvx:ub	()I
    //   4258: pop
    //   4259: iload 6
    //   4261: ifeq +14 -> 4275
    //   4264: invokestatic 47	adjn:a	()Ladjn;
    //   4267: lload 30
    //   4269: ldc_w 280
    //   4272: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   4275: iload 4
    //   4277: istore 6
    //   4279: aload 34
    //   4281: ifnull -3251 -> 1030
    //   4284: aload 34
    //   4286: invokevirtual 327	java/io/InputStream:close	()V
    //   4289: iload 4
    //   4291: istore 6
    //   4293: goto -3263 -> 1030
    //   4296: astore_1
    //   4297: aload_1
    //   4298: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4301: iload 4
    //   4303: istore 6
    //   4305: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4308: ifeq -3278 -> 1030
    //   4311: ldc 77
    //   4313: iconst_2
    //   4314: aload_1
    //   4315: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4318: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4321: iload 4
    //   4323: istore 6
    //   4325: goto -3295 -> 1030
    //   4328: astore_1
    //   4329: ldc2_w 286
    //   4332: lstore 30
    //   4334: iconst_0
    //   4335: istore 6
    //   4337: iconst_0
    //   4338: istore 7
    //   4340: iconst_0
    //   4341: istore 4
    //   4343: aload 35
    //   4345: astore 34
    //   4347: aload 34
    //   4349: astore 5
    //   4351: lload 30
    //   4353: lstore 28
    //   4355: iload 6
    //   4357: istore 9
    //   4359: iload 7
    //   4361: istore 8
    //   4363: aload_1
    //   4364: invokevirtual 257	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   4367: aload 34
    //   4369: astore 5
    //   4371: lload 30
    //   4373: lstore 28
    //   4375: iload 6
    //   4377: istore 9
    //   4379: iload 7
    //   4381: istore 8
    //   4383: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4386: ifeq +30 -> 4416
    //   4389: aload 34
    //   4391: astore 5
    //   4393: lload 30
    //   4395: lstore 28
    //   4397: iload 6
    //   4399: istore 9
    //   4401: iload 7
    //   4403: istore 8
    //   4405: ldc_w 280
    //   4408: iconst_2
    //   4409: aload_1
    //   4410: invokevirtual 258	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   4413: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4416: iload 7
    //   4418: ifeq +7 -> 4425
    //   4421: invokestatic 236	rvx:ub	()I
    //   4424: pop
    //   4425: iload 6
    //   4427: ifeq +14 -> 4441
    //   4430: invokestatic 47	adjn:a	()Ladjn;
    //   4433: lload 30
    //   4435: ldc_w 280
    //   4438: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   4441: iload 4
    //   4443: istore 6
    //   4445: aload 34
    //   4447: ifnull -3417 -> 1030
    //   4450: aload 34
    //   4452: invokevirtual 327	java/io/InputStream:close	()V
    //   4455: iload 4
    //   4457: istore 6
    //   4459: goto -3429 -> 1030
    //   4462: astore_1
    //   4463: aload_1
    //   4464: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4467: iload 4
    //   4469: istore 6
    //   4471: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4474: ifeq -3444 -> 1030
    //   4477: ldc 77
    //   4479: iconst_2
    //   4480: aload_1
    //   4481: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4484: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4487: iload 4
    //   4489: istore 6
    //   4491: goto -3461 -> 1030
    //   4494: astore_1
    //   4495: ldc2_w 286
    //   4498: lstore 30
    //   4500: iconst_0
    //   4501: istore 6
    //   4503: iconst_0
    //   4504: istore 7
    //   4506: iconst_0
    //   4507: istore 4
    //   4509: aload 36
    //   4511: astore 34
    //   4513: aload 34
    //   4515: astore 5
    //   4517: lload 30
    //   4519: lstore 28
    //   4521: iload 6
    //   4523: istore 9
    //   4525: iload 7
    //   4527: istore 8
    //   4529: aload_1
    //   4530: invokevirtual 259	java/lang/Throwable:printStackTrace	()V
    //   4533: aload 34
    //   4535: astore 5
    //   4537: lload 30
    //   4539: lstore 28
    //   4541: iload 6
    //   4543: istore 9
    //   4545: iload 7
    //   4547: istore 8
    //   4549: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4552: ifeq +30 -> 4582
    //   4555: aload 34
    //   4557: astore 5
    //   4559: lload 30
    //   4561: lstore 28
    //   4563: iload 6
    //   4565: istore 9
    //   4567: iload 7
    //   4569: istore 8
    //   4571: ldc_w 280
    //   4574: iconst_2
    //   4575: aload_1
    //   4576: invokevirtual 260	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4579: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4582: iload 7
    //   4584: ifeq +7 -> 4591
    //   4587: invokestatic 236	rvx:ub	()I
    //   4590: pop
    //   4591: iload 6
    //   4593: ifeq +14 -> 4607
    //   4596: invokestatic 47	adjn:a	()Ladjn;
    //   4599: lload 30
    //   4601: ldc_w 280
    //   4604: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   4607: iload 4
    //   4609: istore 6
    //   4611: aload 34
    //   4613: ifnull -3583 -> 1030
    //   4616: aload 34
    //   4618: invokevirtual 327	java/io/InputStream:close	()V
    //   4621: iload 4
    //   4623: istore 6
    //   4625: goto -3595 -> 1030
    //   4628: astore_1
    //   4629: aload_1
    //   4630: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4633: iload 4
    //   4635: istore 6
    //   4637: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4640: ifeq -3610 -> 1030
    //   4643: ldc 77
    //   4645: iconst_2
    //   4646: aload_1
    //   4647: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4650: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4653: iload 4
    //   4655: istore 6
    //   4657: goto -3627 -> 1030
    //   4660: astore_0
    //   4661: ldc2_w 286
    //   4664: lstore 28
    //   4666: iconst_0
    //   4667: istore 6
    //   4669: iconst_0
    //   4670: istore 7
    //   4672: aconst_null
    //   4673: astore_1
    //   4674: iload 7
    //   4676: ifeq +7 -> 4683
    //   4679: invokestatic 236	rvx:ub	()I
    //   4682: pop
    //   4683: iload 6
    //   4685: ifeq +14 -> 4699
    //   4688: invokestatic 47	adjn:a	()Ladjn;
    //   4691: lload 28
    //   4693: ldc_w 280
    //   4696: invokevirtual 240	adjn:ak	(JLjava/lang/String;)V
    //   4699: aload_1
    //   4700: ifnull +7 -> 4707
    //   4703: aload_1
    //   4704: invokevirtual 327	java/io/InputStream:close	()V
    //   4707: aload_0
    //   4708: athrow
    //   4709: astore_1
    //   4710: aload_1
    //   4711: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   4714: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4717: ifeq -10 -> 4707
    //   4720: ldc 77
    //   4722: iconst_2
    //   4723: aload_1
    //   4724: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   4727: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4730: goto -23 -> 4707
    //   4733: astore_0
    //   4734: ldc2_w 286
    //   4737: lstore 28
    //   4739: iconst_0
    //   4740: istore 6
    //   4742: iconst_0
    //   4743: istore 7
    //   4745: aload 34
    //   4747: astore_1
    //   4748: goto -74 -> 4674
    //   4751: astore_0
    //   4752: iload 7
    //   4754: istore 6
    //   4756: iconst_0
    //   4757: istore 7
    //   4759: aload 34
    //   4761: astore_1
    //   4762: goto -88 -> 4674
    //   4765: astore_0
    //   4766: iconst_0
    //   4767: istore 7
    //   4769: aload 34
    //   4771: astore_1
    //   4772: goto -98 -> 4674
    //   4775: astore_0
    //   4776: iload 12
    //   4778: istore 7
    //   4780: aload 34
    //   4782: astore_1
    //   4783: goto -109 -> 4674
    //   4786: astore_0
    //   4787: iload 8
    //   4789: istore 7
    //   4791: aload 34
    //   4793: astore_1
    //   4794: goto -120 -> 4674
    //   4797: astore_0
    //   4798: goto -124 -> 4674
    //   4801: astore_0
    //   4802: aconst_null
    //   4803: astore_1
    //   4804: goto -130 -> 4674
    //   4807: astore_0
    //   4808: aconst_null
    //   4809: astore_1
    //   4810: goto -136 -> 4674
    //   4813: astore_0
    //   4814: aload 34
    //   4816: astore_1
    //   4817: goto -143 -> 4674
    //   4820: astore_0
    //   4821: aload 5
    //   4823: astore_1
    //   4824: iload 9
    //   4826: istore 6
    //   4828: iload 8
    //   4830: istore 7
    //   4832: goto -158 -> 4674
    //   4835: astore_1
    //   4836: iload 8
    //   4838: istore 6
    //   4840: iconst_0
    //   4841: istore 7
    //   4843: iconst_0
    //   4844: istore 4
    //   4846: lload 28
    //   4848: lstore 30
    //   4850: goto -337 -> 4513
    //   4853: astore_1
    //   4854: iconst_0
    //   4855: istore 7
    //   4857: iconst_0
    //   4858: istore 4
    //   4860: lload 28
    //   4862: lstore 30
    //   4864: goto -351 -> 4513
    //   4867: astore_1
    //   4868: iload 17
    //   4870: istore 7
    //   4872: iload 16
    //   4874: istore 4
    //   4876: lload 28
    //   4878: lstore 30
    //   4880: goto -367 -> 4513
    //   4883: astore_1
    //   4884: iconst_0
    //   4885: istore 7
    //   4887: aconst_null
    //   4888: astore 34
    //   4890: iconst_0
    //   4891: istore 4
    //   4893: lload 28
    //   4895: lstore 30
    //   4897: goto -384 -> 4513
    //   4900: astore_1
    //   4901: aconst_null
    //   4902: astore 34
    //   4904: iconst_0
    //   4905: istore 4
    //   4907: lload 28
    //   4909: lstore 30
    //   4911: goto -398 -> 4513
    //   4914: astore_1
    //   4915: aload 39
    //   4917: astore 34
    //   4919: iconst_0
    //   4920: istore 4
    //   4922: lload 28
    //   4924: lstore 30
    //   4926: goto -413 -> 4513
    //   4929: astore_1
    //   4930: aconst_null
    //   4931: astore 34
    //   4933: iload 14
    //   4935: istore 4
    //   4937: lload 28
    //   4939: lstore 30
    //   4941: goto -428 -> 4513
    //   4944: astore_1
    //   4945: aload 37
    //   4947: astore 34
    //   4949: iload 11
    //   4951: istore 4
    //   4953: lload 28
    //   4955: lstore 30
    //   4957: goto -444 -> 4513
    //   4960: astore_1
    //   4961: iload 12
    //   4963: istore 4
    //   4965: lload 28
    //   4967: lstore 30
    //   4969: goto -456 -> 4513
    //   4972: astore_1
    //   4973: lload 28
    //   4975: lstore 30
    //   4977: goto -464 -> 4513
    //   4980: astore_1
    //   4981: aconst_null
    //   4982: astore 34
    //   4984: lload 28
    //   4986: lstore 30
    //   4988: goto -475 -> 4513
    //   4991: astore_1
    //   4992: aload 38
    //   4994: astore 34
    //   4996: iload 11
    //   4998: istore 4
    //   5000: lload 28
    //   5002: lstore 30
    //   5004: goto -491 -> 4513
    //   5007: astore_1
    //   5008: aconst_null
    //   5009: astore 34
    //   5011: lload 28
    //   5013: lstore 30
    //   5015: goto -502 -> 4513
    //   5018: astore_1
    //   5019: aconst_null
    //   5020: astore 34
    //   5022: lload 28
    //   5024: lstore 30
    //   5026: goto -513 -> 4513
    //   5029: astore 5
    //   5031: aload_1
    //   5032: astore 34
    //   5034: aload 5
    //   5036: astore_1
    //   5037: lload 28
    //   5039: lstore 30
    //   5041: goto -528 -> 4513
    //   5044: astore_1
    //   5045: iload 9
    //   5047: istore 6
    //   5049: iconst_0
    //   5050: istore 7
    //   5052: iconst_0
    //   5053: istore 4
    //   5055: lload 28
    //   5057: lstore 30
    //   5059: goto -712 -> 4347
    //   5062: astore_1
    //   5063: iconst_0
    //   5064: istore 7
    //   5066: iconst_0
    //   5067: istore 4
    //   5069: lload 28
    //   5071: lstore 30
    //   5073: goto -726 -> 4347
    //   5076: astore_1
    //   5077: iload 13
    //   5079: istore 7
    //   5081: iload 9
    //   5083: istore 4
    //   5085: lload 28
    //   5087: lstore 30
    //   5089: goto -742 -> 4347
    //   5092: astore_1
    //   5093: iload 4
    //   5095: istore 8
    //   5097: iload 7
    //   5099: istore 4
    //   5101: lload 28
    //   5103: lstore 30
    //   5105: iload 8
    //   5107: istore 7
    //   5109: goto -762 -> 4347
    //   5112: astore_1
    //   5113: iload 4
    //   5115: istore 8
    //   5117: iload 7
    //   5119: istore 4
    //   5121: lload 28
    //   5123: lstore 30
    //   5125: iload 8
    //   5127: istore 7
    //   5129: goto -782 -> 4347
    //   5132: astore_1
    //   5133: iconst_0
    //   5134: istore 7
    //   5136: aconst_null
    //   5137: astore 34
    //   5139: iconst_0
    //   5140: istore 4
    //   5142: lload 28
    //   5144: lstore 30
    //   5146: goto -799 -> 4347
    //   5149: astore_1
    //   5150: aconst_null
    //   5151: astore 34
    //   5153: iconst_0
    //   5154: istore 4
    //   5156: lload 28
    //   5158: lstore 30
    //   5160: goto -813 -> 4347
    //   5163: astore_1
    //   5164: aload 37
    //   5166: astore 34
    //   5168: iconst_0
    //   5169: istore 4
    //   5171: lload 28
    //   5173: lstore 30
    //   5175: goto -828 -> 4347
    //   5178: astore_1
    //   5179: aconst_null
    //   5180: astore 34
    //   5182: iload 12
    //   5184: istore 4
    //   5186: lload 28
    //   5188: lstore 30
    //   5190: goto -843 -> 4347
    //   5193: astore_1
    //   5194: aload 36
    //   5196: astore 34
    //   5198: iload 12
    //   5200: istore 4
    //   5202: lload 28
    //   5204: lstore 30
    //   5206: goto -859 -> 4347
    //   5209: astore_1
    //   5210: iload 9
    //   5212: istore 4
    //   5214: aload 36
    //   5216: astore 34
    //   5218: lload 28
    //   5220: lstore 30
    //   5222: goto -875 -> 4347
    //   5225: astore_1
    //   5226: aload 36
    //   5228: astore 34
    //   5230: lload 28
    //   5232: lstore 30
    //   5234: goto -887 -> 4347
    //   5237: astore_1
    //   5238: aconst_null
    //   5239: astore 34
    //   5241: lload 28
    //   5243: lstore 30
    //   5245: goto -898 -> 4347
    //   5248: astore_1
    //   5249: aload 37
    //   5251: astore 34
    //   5253: iload 9
    //   5255: istore 4
    //   5257: lload 28
    //   5259: lstore 30
    //   5261: goto -914 -> 4347
    //   5264: astore_1
    //   5265: aconst_null
    //   5266: astore 34
    //   5268: lload 28
    //   5270: lstore 30
    //   5272: goto -925 -> 4347
    //   5275: astore_1
    //   5276: aconst_null
    //   5277: astore 34
    //   5279: lload 28
    //   5281: lstore 30
    //   5283: goto -936 -> 4347
    //   5286: astore 5
    //   5288: aload_1
    //   5289: astore 34
    //   5291: aload 5
    //   5293: astore_1
    //   5294: lload 28
    //   5296: lstore 30
    //   5298: goto -951 -> 4347
    //   5301: astore_1
    //   5302: iload 10
    //   5304: istore 6
    //   5306: iconst_0
    //   5307: istore 7
    //   5309: iconst_0
    //   5310: istore 4
    //   5312: lload 28
    //   5314: lstore 30
    //   5316: goto -1135 -> 4181
    //   5319: astore_1
    //   5320: iconst_0
    //   5321: istore 7
    //   5323: iconst_0
    //   5324: istore 4
    //   5326: lload 28
    //   5328: lstore 30
    //   5330: goto -1149 -> 4181
    //   5333: astore_1
    //   5334: iload 14
    //   5336: istore 7
    //   5338: iload 10
    //   5340: istore 4
    //   5342: lload 28
    //   5344: lstore 30
    //   5346: goto -1165 -> 4181
    //   5349: astore_1
    //   5350: iload 4
    //   5352: istore 8
    //   5354: iload 7
    //   5356: istore 4
    //   5358: lload 28
    //   5360: lstore 30
    //   5362: iload 8
    //   5364: istore 7
    //   5366: goto -1185 -> 4181
    //   5369: astore_1
    //   5370: iload 4
    //   5372: istore 8
    //   5374: iload 7
    //   5376: istore 4
    //   5378: lload 28
    //   5380: lstore 30
    //   5382: iload 8
    //   5384: istore 7
    //   5386: goto -1205 -> 4181
    //   5389: astore_1
    //   5390: iconst_0
    //   5391: istore 7
    //   5393: aconst_null
    //   5394: astore 34
    //   5396: iconst_0
    //   5397: istore 4
    //   5399: lload 28
    //   5401: lstore 30
    //   5403: goto -1222 -> 4181
    //   5406: astore_1
    //   5407: aconst_null
    //   5408: astore 34
    //   5410: iconst_0
    //   5411: istore 4
    //   5413: lload 28
    //   5415: lstore 30
    //   5417: goto -1236 -> 4181
    //   5420: astore_1
    //   5421: aload 36
    //   5423: astore 34
    //   5425: iconst_0
    //   5426: istore 4
    //   5428: lload 28
    //   5430: lstore 30
    //   5432: goto -1251 -> 4181
    //   5435: astore_1
    //   5436: aconst_null
    //   5437: astore 34
    //   5439: iload 13
    //   5441: istore 4
    //   5443: lload 28
    //   5445: lstore 30
    //   5447: goto -1266 -> 4181
    //   5450: astore_1
    //   5451: aload 38
    //   5453: astore 34
    //   5455: iload 13
    //   5457: istore 4
    //   5459: lload 28
    //   5461: lstore 30
    //   5463: goto -1282 -> 4181
    //   5466: astore_1
    //   5467: iload 11
    //   5469: istore 4
    //   5471: aload 37
    //   5473: astore 34
    //   5475: lload 28
    //   5477: lstore 30
    //   5479: goto -1298 -> 4181
    //   5482: astore_1
    //   5483: aload 37
    //   5485: astore 34
    //   5487: lload 28
    //   5489: lstore 30
    //   5491: goto -1310 -> 4181
    //   5494: astore_1
    //   5495: aconst_null
    //   5496: astore 34
    //   5498: lload 28
    //   5500: lstore 30
    //   5502: goto -1321 -> 4181
    //   5505: astore_1
    //   5506: aload 36
    //   5508: astore 34
    //   5510: iload 12
    //   5512: istore 4
    //   5514: lload 28
    //   5516: lstore 30
    //   5518: goto -1337 -> 4181
    //   5521: astore_1
    //   5522: aconst_null
    //   5523: astore 34
    //   5525: lload 28
    //   5527: lstore 30
    //   5529: goto -1348 -> 4181
    //   5532: astore_1
    //   5533: aconst_null
    //   5534: astore 34
    //   5536: lload 28
    //   5538: lstore 30
    //   5540: goto -1359 -> 4181
    //   5543: astore 5
    //   5545: aload_1
    //   5546: astore 34
    //   5548: aload 5
    //   5550: astore_1
    //   5551: lload 28
    //   5553: lstore 30
    //   5555: goto -1374 -> 4181
    //   5558: astore_1
    //   5559: iload 11
    //   5561: istore 6
    //   5563: iconst_0
    //   5564: istore 4
    //   5566: iload 12
    //   5568: istore 7
    //   5570: goto -1507 -> 4063
    //   5573: astore_1
    //   5574: iconst_0
    //   5575: istore 4
    //   5577: iload 12
    //   5579: istore 7
    //   5581: goto -1518 -> 4063
    //   5584: astore_1
    //   5585: iload 15
    //   5587: istore 7
    //   5589: iload 11
    //   5591: istore 4
    //   5593: goto -1530 -> 4063
    //   5596: astore_1
    //   5597: iload 4
    //   5599: istore 8
    //   5601: iload 7
    //   5603: istore 4
    //   5605: iload 8
    //   5607: istore 7
    //   5609: goto -1546 -> 4063
    //   5612: astore_1
    //   5613: iload 4
    //   5615: istore 8
    //   5617: iload 7
    //   5619: istore 4
    //   5621: iload 8
    //   5623: istore 7
    //   5625: goto -1562 -> 4063
    //   5628: astore_1
    //   5629: aconst_null
    //   5630: astore 34
    //   5632: iconst_0
    //   5633: istore 4
    //   5635: iload 12
    //   5637: istore 7
    //   5639: goto -1576 -> 4063
    //   5642: astore_1
    //   5643: aconst_null
    //   5644: astore 34
    //   5646: iconst_0
    //   5647: istore 4
    //   5649: goto -1586 -> 4063
    //   5652: astore_1
    //   5653: aload 38
    //   5655: astore 34
    //   5657: iconst_0
    //   5658: istore 4
    //   5660: goto -1597 -> 4063
    //   5663: astore_1
    //   5664: aconst_null
    //   5665: astore 34
    //   5667: iload 11
    //   5669: istore 4
    //   5671: goto -1608 -> 4063
    //   5674: astore_1
    //   5675: aload 39
    //   5677: astore 34
    //   5679: iload 9
    //   5681: istore 4
    //   5683: goto -1620 -> 4063
    //   5686: astore_1
    //   5687: iload 8
    //   5689: istore 4
    //   5691: aload 35
    //   5693: astore 34
    //   5695: goto -1632 -> 4063
    //   5698: astore_1
    //   5699: aload 35
    //   5701: astore 34
    //   5703: goto -1640 -> 4063
    //   5706: astore_1
    //   5707: aconst_null
    //   5708: astore 34
    //   5710: goto -1647 -> 4063
    //   5713: astore_1
    //   5714: aload 39
    //   5716: astore 34
    //   5718: iload 8
    //   5720: istore 4
    //   5722: goto -1659 -> 4063
    //   5725: astore_1
    //   5726: aconst_null
    //   5727: astore 34
    //   5729: goto -1666 -> 4063
    //   5732: astore_1
    //   5733: aconst_null
    //   5734: astore 34
    //   5736: goto -1673 -> 4063
    //   5739: astore 5
    //   5741: aload_1
    //   5742: astore 34
    //   5744: aload 5
    //   5746: astore_1
    //   5747: goto -1684 -> 4063
    //   5750: astore 35
    //   5752: aconst_null
    //   5753: astore 34
    //   5755: goto -1842 -> 3913
    //   5758: astore 35
    //   5760: aconst_null
    //   5761: astore 34
    //   5763: goto -1850 -> 3913
    //   5766: astore 35
    //   5768: aconst_null
    //   5769: astore 34
    //   5771: iload 13
    //   5773: istore 4
    //   5775: goto -2803 -> 2972
    //   5778: astore 35
    //   5780: aconst_null
    //   5781: astore 34
    //   5783: goto -2811 -> 2972
    //   5786: astore_1
    //   5787: iconst_0
    //   5788: istore 4
    //   5790: iload 8
    //   5792: istore 7
    //   5794: iload 19
    //   5796: istore 8
    //   5798: goto -4559 -> 1239
    //   5801: astore_1
    //   5802: iload 8
    //   5804: istore 7
    //   5806: iload 16
    //   5808: istore 8
    //   5810: goto -4571 -> 1239
    //   5813: astore_1
    //   5814: iload 7
    //   5816: istore 9
    //   5818: iload 8
    //   5820: istore 7
    //   5822: iload 9
    //   5824: istore 8
    //   5826: goto -4587 -> 1239
    //   5829: astore_1
    //   5830: iload 7
    //   5832: istore 9
    //   5834: iload 8
    //   5836: istore 7
    //   5838: iload 9
    //   5840: istore 8
    //   5842: goto -4603 -> 1239
    //   5845: astore_1
    //   5846: iconst_0
    //   5847: istore 4
    //   5849: iload 8
    //   5851: istore 7
    //   5853: iload 13
    //   5855: istore 8
    //   5857: goto -4750 -> 1107
    //   5860: astore_1
    //   5861: iload 8
    //   5863: istore 7
    //   5865: iload 17
    //   5867: istore 8
    //   5869: goto -4762 -> 1107
    //   5872: astore_1
    //   5873: iload 7
    //   5875: istore 9
    //   5877: iload 8
    //   5879: istore 7
    //   5881: iload 9
    //   5883: istore 8
    //   5885: goto -4778 -> 1107
    //   5888: astore_1
    //   5889: iload 7
    //   5891: istore 9
    //   5893: iload 8
    //   5895: istore 7
    //   5897: iload 9
    //   5899: istore 8
    //   5901: goto -4794 -> 1107
    //   5904: iload 4
    //   5906: istore 8
    //   5908: goto -3025 -> 2883
    //   5911: iload 10
    //   5913: istore 9
    //   5915: aload 35
    //   5917: astore_1
    //   5918: goto -5132 -> 786
    //   5921: goto -3447 -> 2474
    //   5924: goto -3502 -> 2422
    //   5927: goto -3453 -> 2474
    //   5930: iconst_0
    //   5931: istore 7
    //   5933: goto -4358 -> 1575
    //   5936: iload 4
    //   5938: istore 10
    //   5940: goto -4387 -> 1553
    //   5943: goto -5185 -> 758
    //   5946: iconst_0
    //   5947: istore 4
    //   5949: goto -5492 -> 457
    //   5952: iload 4
    //   5954: istore 8
    //   5956: goto -5539 -> 417
    //   5959: iconst_0
    //   5960: istore 9
    //   5962: iconst_0
    //   5963: istore 7
    //   5965: iload 4
    //   5967: istore 8
    //   5969: iload 9
    //   5971: istore 4
    //   5973: goto -5206 -> 767
    //   5976: ldc2_w 286
    //   5979: lstore 28
    //   5981: iconst_0
    //   5982: istore 6
    //   5984: iconst_0
    //   5985: istore 4
    //   5987: aload 34
    //   5989: astore_1
    //   5990: goto -5001 -> 989
    //   5993: iload 4
    //   5995: iconst_2
    //   5996: iand
    //   5997: iconst_2
    //   5998: if_icmpne -1991 -> 4007
    //   6001: iconst_1
    //   6002: istore_2
    //   6003: goto -5115 -> 888
    //   6006: aload 34
    //   6008: astore_1
    //   6009: iload 7
    //   6011: istore 9
    //   6013: iload 4
    //   6015: istore 7
    //   6017: iload 8
    //   6019: istore 4
    //   6021: goto -5235 -> 786
    //   6024: astore_1
    //   6025: iconst_0
    //   6026: istore 8
    //   6028: iload 4
    //   6030: istore 7
    //   6032: iload 8
    //   6034: istore 4
    //   6036: iload 19
    //   6038: istore 8
    //   6040: goto -4801 -> 1239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6043	0	paramUri	Uri
    //   0	6043	1	paramContext	Context
    //   0	6043	2	paramBoolean1	boolean
    //   0	6043	3	paramBoolean2	boolean
    //   0	6043	4	paramInt	int
    //   0	6043	5	paramSparseArray	SparseArray<Object>
    //   113	5870	6	i	int
    //   95	5936	7	j	int
    //   101	5938	8	k	int
    //   104	5908	9	m	int
    //   107	5832	10	n	int
    //   110	5558	11	i1	int
    //   89	5547	12	i2	int
    //   74	5780	13	i3	int
    //   59	5276	14	i4	int
    //   62	5524	15	i5	int
    //   68	5739	16	i6	int
    //   71	5795	17	i7	int
    //   65	417	18	i8	int
    //   53	5984	19	i9	int
    //   56	1725	20	i10	int
    //   92	1473	21	i11	int
    //   98	222	22	i12	int
    //   225	50	23	i13	int
    //   219	48	24	i14	int
    //   222	49	25	i15	int
    //   228	51	26	i16	int
    //   231	52	27	i17	int
    //   190	5790	28	l1	long
    //   118	5436	30	l2	long
    //   17	1044	32	l3	long
    //   77	5930	34	localObject1	Object
    //   130	2588	35	localObject2	Object
    //   2896	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2970	776	35	localObject3	Object
    //   3816	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3911	1789	35	localContext	Context
    //   5750	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5758	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5766	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5778	138	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   134	5373	36	localObject4	Object
    //   126	5358	37	localObject5	Object
    //   122	5532	38	localObject6	Object
    //   86	5629	39	localObject7	Object
    //   80	3714	40	localStringBuilder	StringBuilder
    //   83	2719	41	localObject8	Object
    //   140	2944	42	localContentResolver	android.content.ContentResolver
    //   1649	2047	43	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   336	379	1091	java/lang/OutOfMemoryError
    //   384	406	1091	java/lang/OutOfMemoryError
    //   1494	1502	1502	java/io/IOException
    //   1610	1618	2896	java/lang/OutOfMemoryError
    //   1641	1651	2896	java/lang/OutOfMemoryError
    //   1674	1680	2896	java/lang/OutOfMemoryError
    //   1703	1747	2896	java/lang/OutOfMemoryError
    //   1770	1775	2896	java/lang/OutOfMemoryError
    //   1789	1800	2896	java/lang/OutOfMemoryError
    //   1912	1920	2964	java/lang/OutOfMemoryError
    //   1959	1966	2964	java/lang/OutOfMemoryError
    //   2005	2011	2964	java/lang/OutOfMemoryError
    //   2050	2078	2964	java/lang/OutOfMemoryError
    //   2117	2122	2964	java/lang/OutOfMemoryError
    //   3083	3091	3816	java/lang/OutOfMemoryError
    //   3134	3141	3816	java/lang/OutOfMemoryError
    //   3184	3190	3816	java/lang/OutOfMemoryError
    //   3233	3261	3816	java/lang/OutOfMemoryError
    //   3304	3309	3816	java/lang/OutOfMemoryError
    //   3351	3360	3816	java/lang/OutOfMemoryError
    //   3387	3403	3816	java/lang/OutOfMemoryError
    //   3430	3439	3816	java/lang/OutOfMemoryError
    //   3466	3478	3816	java/lang/OutOfMemoryError
    //   3505	3525	3816	java/lang/OutOfMemoryError
    //   3562	3582	3816	java/lang/OutOfMemoryError
    //   3609	3621	3816	java/lang/OutOfMemoryError
    //   3648	3668	3816	java/lang/OutOfMemoryError
    //   3695	3700	3816	java/lang/OutOfMemoryError
    //   3731	3737	3816	java/lang/OutOfMemoryError
    //   3764	3805	3816	java/lang/OutOfMemoryError
    //   2546	2554	3905	java/lang/OutOfMemoryError
    //   2593	2603	3905	java/lang/OutOfMemoryError
    //   2642	2648	3905	java/lang/OutOfMemoryError
    //   2687	2715	3905	java/lang/OutOfMemoryError
    //   2754	2759	3905	java/lang/OutOfMemoryError
    //   1022	1026	4012	java/io/IOException
    //   136	142	4044	java/io/IOException
    //   158	166	4044	java/io/IOException
    //   187	192	4044	java/io/IOException
    //   4118	4123	4130	java/io/IOException
    //   136	142	4162	java/lang/RuntimeException
    //   158	166	4162	java/lang/RuntimeException
    //   187	192	4162	java/lang/RuntimeException
    //   4284	4289	4296	java/io/IOException
    //   136	142	4328	java/lang/UnsatisfiedLinkError
    //   158	166	4328	java/lang/UnsatisfiedLinkError
    //   187	192	4328	java/lang/UnsatisfiedLinkError
    //   4450	4455	4462	java/io/IOException
    //   136	142	4494	java/lang/Throwable
    //   158	166	4494	java/lang/Throwable
    //   187	192	4494	java/lang/Throwable
    //   4616	4621	4628	java/io/IOException
    //   136	142	4660	finally
    //   158	166	4660	finally
    //   4703	4707	4709	java/io/IOException
    //   187	192	4733	finally
    //   204	218	4751	finally
    //   260	266	4751	finally
    //   286	319	4751	finally
    //   323	332	4765	finally
    //   336	379	4765	finally
    //   384	406	4765	finally
    //   417	442	4765	finally
    //   450	454	4765	finally
    //   1386	1415	4765	finally
    //   485	501	4775	finally
    //   505	511	4775	finally
    //   515	556	4775	finally
    //   560	568	4775	finally
    //   572	583	4775	finally
    //   605	611	4775	finally
    //   615	621	4775	finally
    //   630	646	4775	finally
    //   689	695	4775	finally
    //   731	758	4775	finally
    //   762	767	4775	finally
    //   1143	1147	4775	finally
    //   1183	1189	4775	finally
    //   1225	1236	4775	finally
    //   1275	1279	4775	finally
    //   1315	1321	4775	finally
    //   1357	1368	4775	finally
    //   821	830	4786	finally
    //   837	846	4786	finally
    //   853	861	4786	finally
    //   868	885	4786	finally
    //   904	915	4786	finally
    //   922	928	4786	finally
    //   935	989	4786	finally
    //   1430	1437	4786	finally
    //   1444	1451	4786	finally
    //   1536	1546	4786	finally
    //   1568	1572	4786	finally
    //   1578	1594	4797	finally
    //   1597	1603	4797	finally
    //   1610	1618	4797	finally
    //   1641	1651	4797	finally
    //   1674	1680	4797	finally
    //   1703	1747	4797	finally
    //   1770	1775	4797	finally
    //   1789	1800	4797	finally
    //   1834	1843	4797	finally
    //   1912	1920	4797	finally
    //   1959	1966	4797	finally
    //   2005	2011	4797	finally
    //   2050	2078	4797	finally
    //   2117	2122	4797	finally
    //   2486	2495	4797	finally
    //   2503	2512	4797	finally
    //   2523	2539	4797	finally
    //   2546	2554	4797	finally
    //   2593	2603	4797	finally
    //   2642	2648	4797	finally
    //   2687	2715	4797	finally
    //   2754	2759	4797	finally
    //   2917	2922	4797	finally
    //   2941	2946	4797	finally
    //   3007	3012	4797	finally
    //   3047	3052	4797	finally
    //   3083	3091	4797	finally
    //   3134	3141	4797	finally
    //   3184	3190	4797	finally
    //   3233	3261	4797	finally
    //   3304	3309	4797	finally
    //   3351	3360	4797	finally
    //   3387	3403	4797	finally
    //   3430	3439	4797	finally
    //   3466	3478	4797	finally
    //   3505	3525	4797	finally
    //   3562	3582	4797	finally
    //   3609	3621	4797	finally
    //   3648	3668	4797	finally
    //   3695	3700	4797	finally
    //   3731	3737	4797	finally
    //   3764	3805	4797	finally
    //   3853	3858	4797	finally
    //   3893	3898	4797	finally
    //   3948	3953	4797	finally
    //   3988	3993	4797	finally
    //   2159	2168	4801	finally
    //   2188	2204	4801	finally
    //   2224	2232	4801	finally
    //   2252	2263	4801	finally
    //   2283	2302	4801	finally
    //   2328	2348	4801	finally
    //   2368	2379	4801	finally
    //   2399	2415	4801	finally
    //   2422	2474	4801	finally
    //   2764	2821	4807	finally
    //   2832	2879	4807	finally
    //   4063	4084	4813	finally
    //   4197	4201	4820	finally
    //   4217	4223	4820	finally
    //   4239	4250	4820	finally
    //   4363	4367	4820	finally
    //   4383	4389	4820	finally
    //   4405	4416	4820	finally
    //   4529	4533	4820	finally
    //   4549	4555	4820	finally
    //   4571	4582	4820	finally
    //   204	218	4835	java/lang/Throwable
    //   260	266	4835	java/lang/Throwable
    //   286	319	4835	java/lang/Throwable
    //   323	332	4853	java/lang/Throwable
    //   1386	1415	4853	java/lang/Throwable
    //   1143	1147	4867	java/lang/Throwable
    //   1183	1189	4867	java/lang/Throwable
    //   1225	1236	4867	java/lang/Throwable
    //   1275	1279	4867	java/lang/Throwable
    //   1315	1321	4867	java/lang/Throwable
    //   1357	1368	4867	java/lang/Throwable
    //   1430	1437	4883	java/lang/Throwable
    //   1444	1451	4883	java/lang/Throwable
    //   1536	1546	4883	java/lang/Throwable
    //   1568	1572	4883	java/lang/Throwable
    //   1578	1594	4900	java/lang/Throwable
    //   1597	1603	4900	java/lang/Throwable
    //   1610	1618	4900	java/lang/Throwable
    //   1789	1800	4900	java/lang/Throwable
    //   1641	1651	4914	java/lang/Throwable
    //   1674	1680	4914	java/lang/Throwable
    //   1703	1747	4914	java/lang/Throwable
    //   1770	1775	4914	java/lang/Throwable
    //   2917	2922	4914	java/lang/Throwable
    //   2941	2946	4914	java/lang/Throwable
    //   1834	1843	4929	java/lang/Throwable
    //   1912	1920	4929	java/lang/Throwable
    //   3083	3091	4929	java/lang/Throwable
    //   3351	3360	4929	java/lang/Throwable
    //   3387	3403	4929	java/lang/Throwable
    //   3430	3439	4929	java/lang/Throwable
    //   3466	3478	4929	java/lang/Throwable
    //   3505	3525	4929	java/lang/Throwable
    //   3562	3582	4929	java/lang/Throwable
    //   3609	3621	4929	java/lang/Throwable
    //   3648	3668	4929	java/lang/Throwable
    //   3695	3700	4929	java/lang/Throwable
    //   3731	3737	4929	java/lang/Throwable
    //   3764	3805	4929	java/lang/Throwable
    //   1959	1966	4944	java/lang/Throwable
    //   2005	2011	4944	java/lang/Throwable
    //   2050	2078	4944	java/lang/Throwable
    //   2117	2122	4944	java/lang/Throwable
    //   3007	3012	4944	java/lang/Throwable
    //   3047	3052	4944	java/lang/Throwable
    //   3134	3141	4944	java/lang/Throwable
    //   3184	3190	4944	java/lang/Throwable
    //   3233	3261	4944	java/lang/Throwable
    //   3304	3309	4944	java/lang/Throwable
    //   3853	3858	4944	java/lang/Throwable
    //   3893	3898	4944	java/lang/Throwable
    //   2159	2168	4960	java/lang/Throwable
    //   2188	2204	4960	java/lang/Throwable
    //   2224	2232	4960	java/lang/Throwable
    //   2252	2263	4960	java/lang/Throwable
    //   2283	2302	4960	java/lang/Throwable
    //   2328	2348	4960	java/lang/Throwable
    //   2368	2379	4960	java/lang/Throwable
    //   2399	2415	4960	java/lang/Throwable
    //   2422	2474	4972	java/lang/Throwable
    //   2486	2495	4980	java/lang/Throwable
    //   2503	2512	4980	java/lang/Throwable
    //   2523	2539	4980	java/lang/Throwable
    //   2546	2554	4980	java/lang/Throwable
    //   2593	2603	4991	java/lang/Throwable
    //   2642	2648	4991	java/lang/Throwable
    //   2687	2715	4991	java/lang/Throwable
    //   2754	2759	4991	java/lang/Throwable
    //   3948	3953	4991	java/lang/Throwable
    //   3988	3993	4991	java/lang/Throwable
    //   2764	2821	5007	java/lang/Throwable
    //   2832	2879	5018	java/lang/Throwable
    //   821	830	5029	java/lang/Throwable
    //   837	846	5029	java/lang/Throwable
    //   853	861	5029	java/lang/Throwable
    //   868	885	5029	java/lang/Throwable
    //   904	915	5029	java/lang/Throwable
    //   922	928	5029	java/lang/Throwable
    //   935	989	5029	java/lang/Throwable
    //   204	218	5044	java/lang/UnsatisfiedLinkError
    //   260	266	5044	java/lang/UnsatisfiedLinkError
    //   286	319	5044	java/lang/UnsatisfiedLinkError
    //   323	332	5062	java/lang/UnsatisfiedLinkError
    //   336	379	5062	java/lang/UnsatisfiedLinkError
    //   384	406	5062	java/lang/UnsatisfiedLinkError
    //   417	442	5062	java/lang/UnsatisfiedLinkError
    //   450	454	5062	java/lang/UnsatisfiedLinkError
    //   1386	1415	5062	java/lang/UnsatisfiedLinkError
    //   485	501	5076	java/lang/UnsatisfiedLinkError
    //   689	695	5076	java/lang/UnsatisfiedLinkError
    //   731	758	5076	java/lang/UnsatisfiedLinkError
    //   1143	1147	5076	java/lang/UnsatisfiedLinkError
    //   1183	1189	5076	java/lang/UnsatisfiedLinkError
    //   1225	1236	5076	java/lang/UnsatisfiedLinkError
    //   1275	1279	5076	java/lang/UnsatisfiedLinkError
    //   1315	1321	5076	java/lang/UnsatisfiedLinkError
    //   1357	1368	5076	java/lang/UnsatisfiedLinkError
    //   505	511	5092	java/lang/UnsatisfiedLinkError
    //   515	556	5092	java/lang/UnsatisfiedLinkError
    //   560	568	5092	java/lang/UnsatisfiedLinkError
    //   572	583	5092	java/lang/UnsatisfiedLinkError
    //   605	611	5092	java/lang/UnsatisfiedLinkError
    //   615	621	5092	java/lang/UnsatisfiedLinkError
    //   630	646	5092	java/lang/UnsatisfiedLinkError
    //   762	767	5112	java/lang/UnsatisfiedLinkError
    //   1430	1437	5132	java/lang/UnsatisfiedLinkError
    //   1444	1451	5132	java/lang/UnsatisfiedLinkError
    //   1536	1546	5132	java/lang/UnsatisfiedLinkError
    //   1568	1572	5132	java/lang/UnsatisfiedLinkError
    //   1578	1594	5149	java/lang/UnsatisfiedLinkError
    //   1597	1603	5149	java/lang/UnsatisfiedLinkError
    //   1610	1618	5149	java/lang/UnsatisfiedLinkError
    //   1789	1800	5149	java/lang/UnsatisfiedLinkError
    //   1641	1651	5163	java/lang/UnsatisfiedLinkError
    //   1674	1680	5163	java/lang/UnsatisfiedLinkError
    //   1703	1747	5163	java/lang/UnsatisfiedLinkError
    //   1770	1775	5163	java/lang/UnsatisfiedLinkError
    //   2917	2922	5163	java/lang/UnsatisfiedLinkError
    //   2941	2946	5163	java/lang/UnsatisfiedLinkError
    //   1834	1843	5178	java/lang/UnsatisfiedLinkError
    //   1912	1920	5178	java/lang/UnsatisfiedLinkError
    //   3083	3091	5178	java/lang/UnsatisfiedLinkError
    //   3351	3360	5178	java/lang/UnsatisfiedLinkError
    //   3387	3403	5178	java/lang/UnsatisfiedLinkError
    //   3430	3439	5178	java/lang/UnsatisfiedLinkError
    //   3466	3478	5178	java/lang/UnsatisfiedLinkError
    //   3505	3525	5178	java/lang/UnsatisfiedLinkError
    //   3562	3582	5178	java/lang/UnsatisfiedLinkError
    //   3609	3621	5178	java/lang/UnsatisfiedLinkError
    //   3648	3668	5178	java/lang/UnsatisfiedLinkError
    //   3695	3700	5178	java/lang/UnsatisfiedLinkError
    //   3731	3737	5178	java/lang/UnsatisfiedLinkError
    //   3764	3805	5178	java/lang/UnsatisfiedLinkError
    //   1959	1966	5193	java/lang/UnsatisfiedLinkError
    //   2005	2011	5193	java/lang/UnsatisfiedLinkError
    //   2050	2078	5193	java/lang/UnsatisfiedLinkError
    //   2117	2122	5193	java/lang/UnsatisfiedLinkError
    //   3007	3012	5193	java/lang/UnsatisfiedLinkError
    //   3047	3052	5193	java/lang/UnsatisfiedLinkError
    //   3134	3141	5193	java/lang/UnsatisfiedLinkError
    //   3184	3190	5193	java/lang/UnsatisfiedLinkError
    //   3233	3261	5193	java/lang/UnsatisfiedLinkError
    //   3304	3309	5193	java/lang/UnsatisfiedLinkError
    //   3853	3858	5193	java/lang/UnsatisfiedLinkError
    //   3893	3898	5193	java/lang/UnsatisfiedLinkError
    //   2159	2168	5209	java/lang/UnsatisfiedLinkError
    //   2188	2204	5209	java/lang/UnsatisfiedLinkError
    //   2224	2232	5209	java/lang/UnsatisfiedLinkError
    //   2252	2263	5209	java/lang/UnsatisfiedLinkError
    //   2283	2302	5209	java/lang/UnsatisfiedLinkError
    //   2328	2348	5209	java/lang/UnsatisfiedLinkError
    //   2368	2379	5209	java/lang/UnsatisfiedLinkError
    //   2399	2415	5209	java/lang/UnsatisfiedLinkError
    //   2422	2474	5225	java/lang/UnsatisfiedLinkError
    //   2486	2495	5237	java/lang/UnsatisfiedLinkError
    //   2503	2512	5237	java/lang/UnsatisfiedLinkError
    //   2523	2539	5237	java/lang/UnsatisfiedLinkError
    //   2546	2554	5237	java/lang/UnsatisfiedLinkError
    //   2593	2603	5248	java/lang/UnsatisfiedLinkError
    //   2642	2648	5248	java/lang/UnsatisfiedLinkError
    //   2687	2715	5248	java/lang/UnsatisfiedLinkError
    //   2754	2759	5248	java/lang/UnsatisfiedLinkError
    //   3948	3953	5248	java/lang/UnsatisfiedLinkError
    //   3988	3993	5248	java/lang/UnsatisfiedLinkError
    //   2764	2821	5264	java/lang/UnsatisfiedLinkError
    //   2832	2879	5275	java/lang/UnsatisfiedLinkError
    //   821	830	5286	java/lang/UnsatisfiedLinkError
    //   837	846	5286	java/lang/UnsatisfiedLinkError
    //   853	861	5286	java/lang/UnsatisfiedLinkError
    //   868	885	5286	java/lang/UnsatisfiedLinkError
    //   904	915	5286	java/lang/UnsatisfiedLinkError
    //   922	928	5286	java/lang/UnsatisfiedLinkError
    //   935	989	5286	java/lang/UnsatisfiedLinkError
    //   204	218	5301	java/lang/RuntimeException
    //   260	266	5301	java/lang/RuntimeException
    //   286	319	5301	java/lang/RuntimeException
    //   323	332	5319	java/lang/RuntimeException
    //   336	379	5319	java/lang/RuntimeException
    //   384	406	5319	java/lang/RuntimeException
    //   417	442	5319	java/lang/RuntimeException
    //   450	454	5319	java/lang/RuntimeException
    //   1386	1415	5319	java/lang/RuntimeException
    //   485	501	5333	java/lang/RuntimeException
    //   689	695	5333	java/lang/RuntimeException
    //   731	758	5333	java/lang/RuntimeException
    //   1143	1147	5333	java/lang/RuntimeException
    //   1183	1189	5333	java/lang/RuntimeException
    //   1225	1236	5333	java/lang/RuntimeException
    //   1275	1279	5333	java/lang/RuntimeException
    //   1315	1321	5333	java/lang/RuntimeException
    //   1357	1368	5333	java/lang/RuntimeException
    //   505	511	5349	java/lang/RuntimeException
    //   515	556	5349	java/lang/RuntimeException
    //   560	568	5349	java/lang/RuntimeException
    //   572	583	5349	java/lang/RuntimeException
    //   605	611	5349	java/lang/RuntimeException
    //   615	621	5349	java/lang/RuntimeException
    //   630	646	5349	java/lang/RuntimeException
    //   762	767	5369	java/lang/RuntimeException
    //   1430	1437	5389	java/lang/RuntimeException
    //   1444	1451	5389	java/lang/RuntimeException
    //   1536	1546	5389	java/lang/RuntimeException
    //   1568	1572	5389	java/lang/RuntimeException
    //   1578	1594	5406	java/lang/RuntimeException
    //   1597	1603	5406	java/lang/RuntimeException
    //   1610	1618	5406	java/lang/RuntimeException
    //   1789	1800	5406	java/lang/RuntimeException
    //   1641	1651	5420	java/lang/RuntimeException
    //   1674	1680	5420	java/lang/RuntimeException
    //   1703	1747	5420	java/lang/RuntimeException
    //   1770	1775	5420	java/lang/RuntimeException
    //   2917	2922	5420	java/lang/RuntimeException
    //   2941	2946	5420	java/lang/RuntimeException
    //   1834	1843	5435	java/lang/RuntimeException
    //   1912	1920	5435	java/lang/RuntimeException
    //   3083	3091	5435	java/lang/RuntimeException
    //   3351	3360	5435	java/lang/RuntimeException
    //   3387	3403	5435	java/lang/RuntimeException
    //   3430	3439	5435	java/lang/RuntimeException
    //   3466	3478	5435	java/lang/RuntimeException
    //   3505	3525	5435	java/lang/RuntimeException
    //   3562	3582	5435	java/lang/RuntimeException
    //   3609	3621	5435	java/lang/RuntimeException
    //   3648	3668	5435	java/lang/RuntimeException
    //   3695	3700	5435	java/lang/RuntimeException
    //   3731	3737	5435	java/lang/RuntimeException
    //   3764	3805	5435	java/lang/RuntimeException
    //   1959	1966	5450	java/lang/RuntimeException
    //   2005	2011	5450	java/lang/RuntimeException
    //   2050	2078	5450	java/lang/RuntimeException
    //   2117	2122	5450	java/lang/RuntimeException
    //   3007	3012	5450	java/lang/RuntimeException
    //   3047	3052	5450	java/lang/RuntimeException
    //   3134	3141	5450	java/lang/RuntimeException
    //   3184	3190	5450	java/lang/RuntimeException
    //   3233	3261	5450	java/lang/RuntimeException
    //   3304	3309	5450	java/lang/RuntimeException
    //   3853	3858	5450	java/lang/RuntimeException
    //   3893	3898	5450	java/lang/RuntimeException
    //   2159	2168	5466	java/lang/RuntimeException
    //   2188	2204	5466	java/lang/RuntimeException
    //   2224	2232	5466	java/lang/RuntimeException
    //   2252	2263	5466	java/lang/RuntimeException
    //   2283	2302	5466	java/lang/RuntimeException
    //   2328	2348	5466	java/lang/RuntimeException
    //   2368	2379	5466	java/lang/RuntimeException
    //   2399	2415	5466	java/lang/RuntimeException
    //   2422	2474	5482	java/lang/RuntimeException
    //   2486	2495	5494	java/lang/RuntimeException
    //   2503	2512	5494	java/lang/RuntimeException
    //   2523	2539	5494	java/lang/RuntimeException
    //   2546	2554	5494	java/lang/RuntimeException
    //   2593	2603	5505	java/lang/RuntimeException
    //   2642	2648	5505	java/lang/RuntimeException
    //   2687	2715	5505	java/lang/RuntimeException
    //   2754	2759	5505	java/lang/RuntimeException
    //   3948	3953	5505	java/lang/RuntimeException
    //   3988	3993	5505	java/lang/RuntimeException
    //   2764	2821	5521	java/lang/RuntimeException
    //   2832	2879	5532	java/lang/RuntimeException
    //   821	830	5543	java/lang/RuntimeException
    //   837	846	5543	java/lang/RuntimeException
    //   853	861	5543	java/lang/RuntimeException
    //   868	885	5543	java/lang/RuntimeException
    //   904	915	5543	java/lang/RuntimeException
    //   922	928	5543	java/lang/RuntimeException
    //   935	989	5543	java/lang/RuntimeException
    //   204	218	5558	java/io/IOException
    //   260	266	5558	java/io/IOException
    //   286	319	5558	java/io/IOException
    //   323	332	5573	java/io/IOException
    //   336	379	5573	java/io/IOException
    //   384	406	5573	java/io/IOException
    //   417	442	5573	java/io/IOException
    //   450	454	5573	java/io/IOException
    //   1386	1415	5573	java/io/IOException
    //   485	501	5584	java/io/IOException
    //   689	695	5584	java/io/IOException
    //   731	758	5584	java/io/IOException
    //   1143	1147	5584	java/io/IOException
    //   1183	1189	5584	java/io/IOException
    //   1225	1236	5584	java/io/IOException
    //   1275	1279	5584	java/io/IOException
    //   1315	1321	5584	java/io/IOException
    //   1357	1368	5584	java/io/IOException
    //   505	511	5596	java/io/IOException
    //   515	556	5596	java/io/IOException
    //   560	568	5596	java/io/IOException
    //   572	583	5596	java/io/IOException
    //   605	611	5596	java/io/IOException
    //   615	621	5596	java/io/IOException
    //   630	646	5596	java/io/IOException
    //   762	767	5612	java/io/IOException
    //   1430	1437	5628	java/io/IOException
    //   1444	1451	5628	java/io/IOException
    //   1536	1546	5628	java/io/IOException
    //   1568	1572	5628	java/io/IOException
    //   1578	1594	5642	java/io/IOException
    //   1597	1603	5642	java/io/IOException
    //   1610	1618	5642	java/io/IOException
    //   1789	1800	5642	java/io/IOException
    //   1641	1651	5652	java/io/IOException
    //   1674	1680	5652	java/io/IOException
    //   1703	1747	5652	java/io/IOException
    //   1770	1775	5652	java/io/IOException
    //   2917	2922	5652	java/io/IOException
    //   2941	2946	5652	java/io/IOException
    //   1834	1843	5663	java/io/IOException
    //   1912	1920	5663	java/io/IOException
    //   3083	3091	5663	java/io/IOException
    //   3351	3360	5663	java/io/IOException
    //   3387	3403	5663	java/io/IOException
    //   3430	3439	5663	java/io/IOException
    //   3466	3478	5663	java/io/IOException
    //   3505	3525	5663	java/io/IOException
    //   3562	3582	5663	java/io/IOException
    //   3609	3621	5663	java/io/IOException
    //   3648	3668	5663	java/io/IOException
    //   3695	3700	5663	java/io/IOException
    //   3731	3737	5663	java/io/IOException
    //   3764	3805	5663	java/io/IOException
    //   1959	1966	5674	java/io/IOException
    //   2005	2011	5674	java/io/IOException
    //   2050	2078	5674	java/io/IOException
    //   2117	2122	5674	java/io/IOException
    //   3007	3012	5674	java/io/IOException
    //   3047	3052	5674	java/io/IOException
    //   3134	3141	5674	java/io/IOException
    //   3184	3190	5674	java/io/IOException
    //   3233	3261	5674	java/io/IOException
    //   3304	3309	5674	java/io/IOException
    //   3853	3858	5674	java/io/IOException
    //   3893	3898	5674	java/io/IOException
    //   2159	2168	5686	java/io/IOException
    //   2188	2204	5686	java/io/IOException
    //   2224	2232	5686	java/io/IOException
    //   2252	2263	5686	java/io/IOException
    //   2283	2302	5686	java/io/IOException
    //   2328	2348	5686	java/io/IOException
    //   2368	2379	5686	java/io/IOException
    //   2399	2415	5686	java/io/IOException
    //   2422	2474	5698	java/io/IOException
    //   2486	2495	5706	java/io/IOException
    //   2503	2512	5706	java/io/IOException
    //   2523	2539	5706	java/io/IOException
    //   2546	2554	5706	java/io/IOException
    //   2593	2603	5713	java/io/IOException
    //   2642	2648	5713	java/io/IOException
    //   2687	2715	5713	java/io/IOException
    //   2754	2759	5713	java/io/IOException
    //   3948	3953	5713	java/io/IOException
    //   3988	3993	5713	java/io/IOException
    //   2764	2821	5725	java/io/IOException
    //   2832	2879	5732	java/io/IOException
    //   821	830	5739	java/io/IOException
    //   837	846	5739	java/io/IOException
    //   853	861	5739	java/io/IOException
    //   868	885	5739	java/io/IOException
    //   904	915	5739	java/io/IOException
    //   922	928	5739	java/io/IOException
    //   935	989	5739	java/io/IOException
    //   2764	2821	5750	java/lang/OutOfMemoryError
    //   2832	2879	5758	java/lang/OutOfMemoryError
    //   2159	2168	5766	java/lang/OutOfMemoryError
    //   2188	2204	5766	java/lang/OutOfMemoryError
    //   2224	2232	5766	java/lang/OutOfMemoryError
    //   2252	2263	5766	java/lang/OutOfMemoryError
    //   2283	2302	5766	java/lang/OutOfMemoryError
    //   2328	2348	5766	java/lang/OutOfMemoryError
    //   2368	2379	5766	java/lang/OutOfMemoryError
    //   2399	2415	5766	java/lang/OutOfMemoryError
    //   2422	2474	5778	java/lang/OutOfMemoryError
    //   417	442	5786	java/lang/Throwable
    //   450	454	5786	java/lang/Throwable
    //   485	501	5801	java/lang/Throwable
    //   689	695	5801	java/lang/Throwable
    //   731	758	5801	java/lang/Throwable
    //   505	511	5813	java/lang/Throwable
    //   515	556	5813	java/lang/Throwable
    //   560	568	5813	java/lang/Throwable
    //   572	583	5813	java/lang/Throwable
    //   605	611	5813	java/lang/Throwable
    //   615	621	5813	java/lang/Throwable
    //   630	646	5813	java/lang/Throwable
    //   762	767	5829	java/lang/Throwable
    //   417	442	5845	java/lang/OutOfMemoryError
    //   450	454	5845	java/lang/OutOfMemoryError
    //   485	501	5860	java/lang/OutOfMemoryError
    //   689	695	5860	java/lang/OutOfMemoryError
    //   731	758	5860	java/lang/OutOfMemoryError
    //   505	511	5872	java/lang/OutOfMemoryError
    //   515	556	5872	java/lang/OutOfMemoryError
    //   560	568	5872	java/lang/OutOfMemoryError
    //   572	583	5872	java/lang/OutOfMemoryError
    //   605	611	5872	java/lang/OutOfMemoryError
    //   615	621	5872	java/lang/OutOfMemoryError
    //   630	646	5872	java/lang/OutOfMemoryError
    //   762	767	5888	java/lang/OutOfMemoryError
    //   336	379	6024	java/lang/Throwable
    //   384	406	6024	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return asfh.ScanImage(arrayOfByte, paramInt1, paramInt2, 0);
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[paramInt1 * paramInt2];
      ImgProcessScan.TransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    }
    for (paramArrayOfInt = paramArrayOfByte;; paramArrayOfInt = paramArrayOfByte)
    {
      int j = 0;
      int i = j;
      if ((paramInt3 & 0x1) == 1)
      {
        i = j;
        if (asfh.ScanImage(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = adjn.a().decode(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (adjn.kX(paramArrayOfInt))
        {
          if (paramStringBuilder.length() > 0) {
            paramStringBuilder.delete(0, paramStringBuilder.length());
          }
          paramStringBuilder.append(paramArrayOfInt);
          return i | 0x2;
        }
      }
      return i;
    }
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    return a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0, 0, 0, 0, paramStringBuilder);
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Uri paramUri, Context paramContext)
  {
    paramUri = a(paramUri, paramContext, true, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerUtils", 4, "decodeFile res:" + paramUri);
    }
    return paramUri;
  }
  
  /* Error */
  private static Pair<StringBuilder, StringBuilder> a(Uri paramUri, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +9 -> 14
    //   8: aconst_null
    //   9: astore 27
    //   11: aload 27
    //   13: areturn
    //   14: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   17: lstore 25
    //   19: iconst_m1
    //   20: istore 7
    //   22: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   25: ifeq +29 -> 54
    //   28: ldc 77
    //   30: iconst_4
    //   31: new 142	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 409
    //   41: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_3
    //   45: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: astore 32
    //   57: aconst_null
    //   58: astore 34
    //   60: aconst_null
    //   61: astore 36
    //   63: aconst_null
    //   64: astore 33
    //   66: aconst_null
    //   67: astore 35
    //   69: iconst_0
    //   70: istore 21
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 6
    //   78: iconst_0
    //   79: istore 18
    //   81: iconst_0
    //   82: istore 17
    //   84: iconst_0
    //   85: istore 15
    //   87: iconst_0
    //   88: istore 20
    //   90: iconst_0
    //   91: istore 14
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 13
    //   99: iconst_0
    //   100: istore 19
    //   102: iconst_0
    //   103: istore 16
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 35
    //   110: astore 27
    //   112: iload 6
    //   114: istore 12
    //   116: aload 32
    //   118: astore 31
    //   120: iload 18
    //   122: istore 10
    //   124: aload 34
    //   126: astore 30
    //   128: iload 17
    //   130: istore 11
    //   132: aload 36
    //   134: astore 29
    //   136: iload 15
    //   138: istore 9
    //   140: aload 33
    //   142: astore 28
    //   144: iload 20
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 35
    //   156: astore 27
    //   158: iload 6
    //   160: istore 12
    //   162: aload 32
    //   164: astore 31
    //   166: iload 18
    //   168: istore 10
    //   170: aload 34
    //   172: astore 30
    //   174: iload 17
    //   176: istore 11
    //   178: aload 36
    //   180: astore 29
    //   182: iload 15
    //   184: istore 9
    //   186: aload 33
    //   188: astore 28
    //   190: iload 20
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4033 -> 4235
    //   205: iload_3
    //   206: ifeq +802 -> 1008
    //   209: iload 14
    //   211: istore 8
    //   213: iload 13
    //   215: istore 11
    //   217: iload 19
    //   219: istore 10
    //   221: iload 16
    //   223: istore 9
    //   225: aload_0
    //   226: invokevirtual 304	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 310	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore_0
    //   233: iload 14
    //   235: istore 8
    //   237: iload 13
    //   239: istore 11
    //   241: iload 19
    //   243: istore 10
    //   245: iload 16
    //   247: istore 9
    //   249: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   252: ifeq +45 -> 297
    //   255: iload 14
    //   257: istore 8
    //   259: iload 13
    //   261: istore 11
    //   263: iload 19
    //   265: istore 10
    //   267: iload 16
    //   269: istore 9
    //   271: ldc 77
    //   273: iconst_4
    //   274: new 142	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 312
    //   284: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: ifnull +3928 -> 4226
    //   301: iload 14
    //   303: istore 8
    //   305: iload 13
    //   307: istore 11
    //   309: iload 19
    //   311: istore 10
    //   313: iload 16
    //   315: istore 9
    //   317: aload_0
    //   318: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   321: istore 6
    //   323: iload 14
    //   325: istore 8
    //   327: iload 13
    //   329: istore 11
    //   331: iload 19
    //   333: istore 10
    //   335: iload 16
    //   337: istore 9
    //   339: aload_0
    //   340: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   343: istore 12
    //   345: iload 14
    //   347: istore 8
    //   349: iload 13
    //   351: istore 11
    //   353: iload 19
    //   355: istore 10
    //   357: iload 16
    //   359: istore 9
    //   361: iload 6
    //   363: iload 12
    //   365: invokestatic 174	asfh:by	(II)Z
    //   368: istore_3
    //   369: iload_3
    //   370: ifne +44 -> 414
    //   373: aconst_null
    //   374: astore_0
    //   375: aload_0
    //   376: astore 27
    //   378: aload_1
    //   379: ifnull -368 -> 11
    //   382: aload_1
    //   383: invokevirtual 327	java/io/InputStream:close	()V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   393: aload_0
    //   394: astore 27
    //   396: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -388 -> 11
    //   402: ldc 77
    //   404: iconst_2
    //   405: aload_1
    //   406: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   409: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aconst_null
    //   413: areturn
    //   414: iload 14
    //   416: istore 8
    //   418: iload 13
    //   420: istore 11
    //   422: iload 19
    //   424: istore 10
    //   426: iload 16
    //   428: istore 9
    //   430: iload 6
    //   432: iload 12
    //   434: imul
    //   435: newarray int
    //   437: astore 27
    //   439: iload 14
    //   441: istore 8
    //   443: iload 13
    //   445: istore 11
    //   447: iload 19
    //   449: istore 10
    //   451: iload 16
    //   453: istore 9
    //   455: aload_0
    //   456: aload 27
    //   458: iconst_0
    //   459: iload 6
    //   461: iconst_0
    //   462: iconst_0
    //   463: iload 6
    //   465: iload 12
    //   467: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   470: iload 14
    //   472: istore 8
    //   474: iload 13
    //   476: istore 11
    //   478: iload 19
    //   480: istore 10
    //   482: iload 16
    //   484: istore 9
    //   486: aload_0
    //   487: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   490: iload 14
    //   492: istore 8
    //   494: iload 13
    //   496: istore 11
    //   498: iload 19
    //   500: istore 10
    //   502: iload 16
    //   504: istore 9
    //   506: invokestatic 177	rvx:ua	()I
    //   509: pop
    //   510: iconst_1
    //   511: istore 9
    //   513: aload 27
    //   515: aconst_null
    //   516: iload 6
    //   518: iload 12
    //   520: invokestatic 411	rvx:a	([I[BII)I
    //   523: istore 6
    //   525: iload 9
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   536: ifeq +38 -> 574
    //   539: ldc 77
    //   541: iconst_4
    //   542: new 142	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 413
    //   552: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 6
    //   557: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: iload 6
    //   568: istore 8
    //   570: iload 9
    //   572: istore 7
    //   574: iload 7
    //   576: istore 6
    //   578: iload 8
    //   580: istore 7
    //   582: aload_1
    //   583: astore_0
    //   584: iload 7
    //   586: iconst_1
    //   587: if_icmpne +3609 -> 4196
    //   590: iload_2
    //   591: ifeq +2820 -> 3411
    //   594: aload_0
    //   595: astore 27
    //   597: iload 6
    //   599: istore 12
    //   601: aload_0
    //   602: astore 31
    //   604: iload 6
    //   606: istore 10
    //   608: aload_0
    //   609: astore 30
    //   611: iload 6
    //   613: istore 11
    //   615: aload_0
    //   616: astore 29
    //   618: iload 6
    //   620: istore 9
    //   622: aload_0
    //   623: astore 28
    //   625: iload 6
    //   627: istore 8
    //   629: new 142	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   636: astore_1
    //   637: aload_0
    //   638: astore 27
    //   640: iload 6
    //   642: istore 12
    //   644: aload_0
    //   645: astore 31
    //   647: iload 6
    //   649: istore 10
    //   651: aload_0
    //   652: astore 30
    //   654: iload 6
    //   656: istore 11
    //   658: aload_0
    //   659: astore 29
    //   661: iload 6
    //   663: istore 9
    //   665: aload_0
    //   666: astore 28
    //   668: iload 6
    //   670: istore 8
    //   672: new 142	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   679: astore 32
    //   681: aload_0
    //   682: astore 27
    //   684: iload 6
    //   686: istore 12
    //   688: aload_0
    //   689: astore 31
    //   691: iload 6
    //   693: istore 10
    //   695: aload_0
    //   696: astore 30
    //   698: iload 6
    //   700: istore 11
    //   702: aload_0
    //   703: astore 29
    //   705: iload 6
    //   707: istore 9
    //   709: aload_0
    //   710: astore 28
    //   712: iload 6
    //   714: istore 8
    //   716: aload_1
    //   717: aload 32
    //   719: invokestatic 220	asfh:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   722: pop
    //   723: aload_0
    //   724: astore 27
    //   726: iload 6
    //   728: istore 12
    //   730: aload_0
    //   731: astore 31
    //   733: iload 6
    //   735: istore 10
    //   737: aload_0
    //   738: astore 30
    //   740: iload 6
    //   742: istore 11
    //   744: aload_0
    //   745: astore 29
    //   747: iload 6
    //   749: istore 9
    //   751: aload_0
    //   752: astore 28
    //   754: iload 6
    //   756: istore 8
    //   758: new 222	android/util/Pair
    //   761: dup
    //   762: aload 32
    //   764: aload_1
    //   765: invokespecial 225	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   768: astore_1
    //   769: aload_0
    //   770: astore 27
    //   772: iload 6
    //   774: ifeq +7 -> 781
    //   777: invokestatic 236	rvx:ub	()I
    //   780: pop
    //   781: aload_1
    //   782: astore_0
    //   783: aload 27
    //   785: ifnull +10 -> 795
    //   788: aload 27
    //   790: invokevirtual 327	java/io/InputStream:close	()V
    //   793: aload_1
    //   794: astore_0
    //   795: aload_0
    //   796: astore 27
    //   798: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   801: ifeq -790 -> 11
    //   804: ldc 77
    //   806: iconst_4
    //   807: new 142	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 415
    //   817: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   823: lload 25
    //   825: lsub
    //   826: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload_0
    //   836: areturn
    //   837: astore_0
    //   838: iload 21
    //   840: istore 6
    //   842: iload 6
    //   844: istore 8
    //   846: iload 6
    //   848: istore 12
    //   850: iload 6
    //   852: istore 11
    //   854: iload 6
    //   856: istore 10
    //   858: iload 6
    //   860: istore 9
    //   862: aload_0
    //   863: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: iload 6
    //   868: istore 8
    //   870: iload 6
    //   872: istore 12
    //   874: iload 6
    //   876: istore 11
    //   878: iload 6
    //   880: istore 10
    //   882: iload 6
    //   884: istore 9
    //   886: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +3358 -> 4247
    //   892: iload 6
    //   894: istore 8
    //   896: iload 6
    //   898: istore 12
    //   900: iload 6
    //   902: istore 11
    //   904: iload 6
    //   906: istore 10
    //   908: iload 6
    //   910: istore 9
    //   912: ldc 77
    //   914: iconst_2
    //   915: aload_0
    //   916: invokevirtual 333	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   919: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto +3325 -> 4247
    //   925: iload 6
    //   927: istore 8
    //   929: iload 6
    //   931: istore 12
    //   933: iload 6
    //   935: istore 11
    //   937: iload 6
    //   939: istore 10
    //   941: iload 6
    //   943: istore 9
    //   945: aload_0
    //   946: invokevirtual 259	java/lang/Throwable:printStackTrace	()V
    //   949: iload 6
    //   951: istore 8
    //   953: iload 6
    //   955: istore 12
    //   957: iload 6
    //   959: istore 11
    //   961: iload 6
    //   963: istore 10
    //   965: iload 6
    //   967: istore 9
    //   969: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +3288 -> 4260
    //   975: iload 6
    //   977: istore 8
    //   979: iload 6
    //   981: istore 12
    //   983: iload 6
    //   985: istore 11
    //   987: iload 6
    //   989: istore 10
    //   991: iload 6
    //   993: istore 9
    //   995: ldc 77
    //   997: iconst_2
    //   998: aload_0
    //   999: invokevirtual 260	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1002: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto +3255 -> 4260
    //   1008: iload 14
    //   1010: istore 8
    //   1012: iload 23
    //   1014: istore 12
    //   1016: iload 13
    //   1018: istore 11
    //   1020: iload 19
    //   1022: istore 10
    //   1024: iload 16
    //   1026: istore 9
    //   1028: new 335	android/graphics/BitmapFactory$Options
    //   1031: dup
    //   1032: invokespecial 336	android/graphics/BitmapFactory$Options:<init>	()V
    //   1035: astore 43
    //   1037: iload 14
    //   1039: istore 8
    //   1041: iload 23
    //   1043: istore 12
    //   1045: iload 13
    //   1047: istore 11
    //   1049: iload 19
    //   1051: istore 10
    //   1053: iload 16
    //   1055: istore 9
    //   1057: aload 43
    //   1059: iconst_1
    //   1060: putfield 339	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1063: iload 14
    //   1065: istore 8
    //   1067: iload 23
    //   1069: istore 12
    //   1071: iload 13
    //   1073: istore 11
    //   1075: iload 19
    //   1077: istore 10
    //   1079: iload 16
    //   1081: istore 9
    //   1083: aload_1
    //   1084: aconst_null
    //   1085: aload 43
    //   1087: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1090: pop
    //   1091: iload 14
    //   1093: istore 8
    //   1095: iload 23
    //   1097: istore 12
    //   1099: iload 13
    //   1101: istore 11
    //   1103: iload 19
    //   1105: istore 10
    //   1107: iload 16
    //   1109: istore 9
    //   1111: aload_1
    //   1112: invokevirtual 327	java/io/InputStream:close	()V
    //   1115: aconst_null
    //   1116: astore 32
    //   1118: aconst_null
    //   1119: astore_1
    //   1120: aconst_null
    //   1121: astore 39
    //   1123: aconst_null
    //   1124: astore 38
    //   1126: aconst_null
    //   1127: astore 41
    //   1129: aconst_null
    //   1130: astore 40
    //   1132: aconst_null
    //   1133: astore 33
    //   1135: aconst_null
    //   1136: astore 35
    //   1138: aconst_null
    //   1139: astore 36
    //   1141: aconst_null
    //   1142: astore 34
    //   1144: aconst_null
    //   1145: astore 37
    //   1147: aload_1
    //   1148: astore 27
    //   1150: iload 6
    //   1152: istore 12
    //   1154: aload 39
    //   1156: astore 31
    //   1158: iload 18
    //   1160: istore 10
    //   1162: aload 38
    //   1164: astore 30
    //   1166: iload 17
    //   1168: istore 11
    //   1170: aload 41
    //   1172: astore 29
    //   1174: iload 15
    //   1176: istore 9
    //   1178: aload 40
    //   1180: astore 28
    //   1182: iload 20
    //   1184: istore 8
    //   1186: aload 43
    //   1188: getfield 348	android/graphics/BitmapFactory$Options:outWidth	I
    //   1191: istore 14
    //   1193: aload_1
    //   1194: astore 27
    //   1196: iload 6
    //   1198: istore 12
    //   1200: aload 39
    //   1202: astore 31
    //   1204: iload 18
    //   1206: istore 10
    //   1208: aload 38
    //   1210: astore 30
    //   1212: iload 17
    //   1214: istore 11
    //   1216: aload 41
    //   1218: astore 29
    //   1220: iload 15
    //   1222: istore 9
    //   1224: aload 40
    //   1226: astore 28
    //   1228: iload 20
    //   1230: istore 8
    //   1232: aload 43
    //   1234: getfield 351	android/graphics/BitmapFactory$Options:outHeight	I
    //   1237: istore 16
    //   1239: aload_1
    //   1240: astore 27
    //   1242: iload 6
    //   1244: istore 12
    //   1246: aload 39
    //   1248: astore 31
    //   1250: iload 18
    //   1252: istore 10
    //   1254: aload 38
    //   1256: astore 30
    //   1258: iload 17
    //   1260: istore 11
    //   1262: aload 41
    //   1264: astore 29
    //   1266: iload 15
    //   1268: istore 9
    //   1270: aload 40
    //   1272: astore 28
    //   1274: iload 20
    //   1276: istore 8
    //   1278: aload 43
    //   1280: iconst_0
    //   1281: putfield 339	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1284: iload 14
    //   1286: sipush 12800
    //   1289: if_icmpgt +11 -> 1300
    //   1292: iload 16
    //   1294: sipush 12800
    //   1297: if_icmple +46 -> 1343
    //   1300: aconst_null
    //   1301: astore_0
    //   1302: aload_0
    //   1303: astore 27
    //   1305: iconst_0
    //   1306: ifeq -1295 -> 11
    //   1309: new 353	java/lang/NullPointerException
    //   1312: dup
    //   1313: invokespecial 354	java/lang/NullPointerException:<init>	()V
    //   1316: athrow
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   1322: aload_0
    //   1323: astore 27
    //   1325: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1328: ifeq -1317 -> 11
    //   1331: ldc 77
    //   1333: iconst_2
    //   1334: aload_1
    //   1335: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   1338: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aconst_null
    //   1342: areturn
    //   1343: aload_1
    //   1344: astore 27
    //   1346: iload 6
    //   1348: istore 12
    //   1350: aload 39
    //   1352: astore 31
    //   1354: iload 18
    //   1356: istore 10
    //   1358: aload 38
    //   1360: astore 30
    //   1362: iload 17
    //   1364: istore 11
    //   1366: aload 41
    //   1368: astore 29
    //   1370: iload 15
    //   1372: istore 9
    //   1374: aload 40
    //   1376: astore 28
    //   1378: iload 20
    //   1380: istore 8
    //   1382: iload 14
    //   1384: iload 16
    //   1386: invokestatic 174	asfh:by	(II)Z
    //   1389: istore_3
    //   1390: iload_3
    //   1391: ifne +46 -> 1437
    //   1394: aconst_null
    //   1395: astore_0
    //   1396: aload_0
    //   1397: astore 27
    //   1399: iconst_0
    //   1400: ifeq -1389 -> 11
    //   1403: new 353	java/lang/NullPointerException
    //   1406: dup
    //   1407: invokespecial 354	java/lang/NullPointerException:<init>	()V
    //   1410: athrow
    //   1411: astore_1
    //   1412: aload_1
    //   1413: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   1416: aload_0
    //   1417: astore 27
    //   1419: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1422: ifeq -1411 -> 11
    //   1425: ldc 77
    //   1427: iconst_2
    //   1428: aload_1
    //   1429: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   1432: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1435: aconst_null
    //   1436: areturn
    //   1437: aload_1
    //   1438: astore 27
    //   1440: iload 6
    //   1442: istore 12
    //   1444: aload 39
    //   1446: astore 31
    //   1448: iload 18
    //   1450: istore 10
    //   1452: aload 38
    //   1454: astore 30
    //   1456: iload 17
    //   1458: istore 11
    //   1460: aload 41
    //   1462: astore 29
    //   1464: iload 15
    //   1466: istore 9
    //   1468: aload 40
    //   1470: astore 28
    //   1472: iload 20
    //   1474: istore 8
    //   1476: invokestatic 177	rvx:ua	()I
    //   1479: pop
    //   1480: iconst_1
    //   1481: istore 12
    //   1483: iconst_1
    //   1484: istore 11
    //   1486: iconst_1
    //   1487: istore 13
    //   1489: iconst_1
    //   1490: istore 10
    //   1492: iconst_1
    //   1493: istore 9
    //   1495: iload 14
    //   1497: iload 16
    //   1499: imul
    //   1500: ldc_w 416
    //   1503: if_icmple +1169 -> 2672
    //   1506: iload 14
    //   1508: iload 16
    //   1510: imul
    //   1511: i2d
    //   1512: dstore 4
    //   1514: aload 37
    //   1516: astore 27
    //   1518: aload 33
    //   1520: astore_1
    //   1521: iload 10
    //   1523: istore 8
    //   1525: aload 35
    //   1527: astore 28
    //   1529: aload 36
    //   1531: astore 29
    //   1533: aload 34
    //   1535: astore 30
    //   1537: aload 43
    //   1539: dload 4
    //   1541: invokestatic 419	java/lang/Math:sqrt	(D)D
    //   1544: ldc2_w 420
    //   1547: ddiv
    //   1548: invokestatic 217	java/lang/Math:ceil	(D)D
    //   1551: d2i
    //   1552: putfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1555: aload 37
    //   1557: astore 27
    //   1559: aload 33
    //   1561: astore_1
    //   1562: iload 10
    //   1564: istore 8
    //   1566: aload 35
    //   1568: astore 28
    //   1570: aload 36
    //   1572: astore 29
    //   1574: aload 34
    //   1576: astore 30
    //   1578: aload 42
    //   1580: aload_0
    //   1581: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1584: astore 31
    //   1586: aload 31
    //   1588: astore 27
    //   1590: aload 31
    //   1592: astore 32
    //   1594: aload 31
    //   1596: astore_1
    //   1597: iload 10
    //   1599: istore 8
    //   1601: aload 31
    //   1603: astore 28
    //   1605: aload 31
    //   1607: astore 29
    //   1609: aload 31
    //   1611: astore 30
    //   1613: aload 31
    //   1615: aconst_null
    //   1616: aload 43
    //   1618: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1621: astore 33
    //   1623: aload 31
    //   1625: astore 27
    //   1627: aload 31
    //   1629: astore 32
    //   1631: aload 31
    //   1633: astore_1
    //   1634: iload 10
    //   1636: istore 8
    //   1638: aload 31
    //   1640: astore 28
    //   1642: aload 31
    //   1644: astore 29
    //   1646: aload 31
    //   1648: astore 30
    //   1650: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1653: ifeq +93 -> 1746
    //   1656: aload 31
    //   1658: astore 27
    //   1660: aload 31
    //   1662: astore 32
    //   1664: aload 31
    //   1666: astore_1
    //   1667: iload 10
    //   1669: istore 8
    //   1671: aload 31
    //   1673: astore 28
    //   1675: aload 31
    //   1677: astore 29
    //   1679: aload 31
    //   1681: astore 30
    //   1683: ldc 77
    //   1685: iconst_4
    //   1686: new 142	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 423
    //   1696: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload 33
    //   1701: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1704: ldc_w 425
    //   1707: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: iload 14
    //   1712: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: ldc_w 427
    //   1718: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: iload 16
    //   1723: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: ldc_w 429
    //   1729: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: aload 43
    //   1734: getfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1737: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1746: aload 31
    //   1748: astore 27
    //   1750: aload 31
    //   1752: astore 32
    //   1754: aload 31
    //   1756: astore_1
    //   1757: iload 10
    //   1759: istore 8
    //   1761: aload 31
    //   1763: astore 28
    //   1765: aload 31
    //   1767: astore 29
    //   1769: aload 31
    //   1771: astore 30
    //   1773: aload 31
    //   1775: invokevirtual 327	java/io/InputStream:close	()V
    //   1778: iload 7
    //   1780: istore 8
    //   1782: aload 33
    //   1784: ifnull +129 -> 1913
    //   1787: iload 7
    //   1789: istore 6
    //   1791: aload 33
    //   1793: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   1796: istore 8
    //   1798: iload 7
    //   1800: istore 6
    //   1802: aload 33
    //   1804: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   1807: istore 15
    //   1809: iload 7
    //   1811: istore 6
    //   1813: iload 8
    //   1815: iload 15
    //   1817: imul
    //   1818: newarray int
    //   1820: astore_1
    //   1821: iload 7
    //   1823: istore 6
    //   1825: aload 33
    //   1827: aload_1
    //   1828: iconst_0
    //   1829: iload 8
    //   1831: iconst_0
    //   1832: iconst_0
    //   1833: iload 8
    //   1835: iload 15
    //   1837: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1840: iload 7
    //   1842: istore 6
    //   1844: aload 33
    //   1846: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   1849: iload 7
    //   1851: istore 6
    //   1853: aload_1
    //   1854: aconst_null
    //   1855: iload 8
    //   1857: iload 15
    //   1859: invokestatic 411	rvx:a	([I[BII)I
    //   1862: istore 7
    //   1864: iload 7
    //   1866: istore 8
    //   1868: iload 7
    //   1870: istore 6
    //   1872: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1875: ifeq +38 -> 1913
    //   1878: iload 7
    //   1880: istore 6
    //   1882: ldc 77
    //   1884: iconst_4
    //   1885: new 142	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   1892: ldc_w 431
    //   1895: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: iload 7
    //   1900: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1903: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1906: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1909: iload 7
    //   1911: istore 8
    //   1913: iload 8
    //   1915: istore 6
    //   1917: aconst_null
    //   1918: astore 31
    //   1920: aconst_null
    //   1921: astore_1
    //   1922: aconst_null
    //   1923: astore 28
    //   1925: aconst_null
    //   1926: astore 29
    //   1928: aconst_null
    //   1929: astore 30
    //   1931: aconst_null
    //   1932: astore 32
    //   1934: aconst_null
    //   1935: astore 27
    //   1937: iload 6
    //   1939: istore 7
    //   1941: iload 6
    //   1943: iconst_1
    //   1944: if_icmpeq +339 -> 2283
    //   1947: iload 14
    //   1949: iconst_2
    //   1950: imul
    //   1951: iload 16
    //   1953: if_icmpgt +957 -> 2910
    //   1956: iload 14
    //   1958: sipush 1280
    //   1961: if_icmpge +949 -> 2910
    //   1964: iload 10
    //   1966: istore 8
    //   1968: aload 42
    //   1970: aload_0
    //   1971: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1974: astore 31
    //   1976: aload 31
    //   1978: astore 27
    //   1980: aload 31
    //   1982: astore_1
    //   1983: iload 10
    //   1985: istore 8
    //   1987: aload 31
    //   1989: astore 28
    //   1991: aload 31
    //   1993: astore 29
    //   1995: aload 31
    //   1997: astore 30
    //   1999: aload 31
    //   2001: astore 32
    //   2003: aload 31
    //   2005: invokestatic 370	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2008: astore 33
    //   2010: aload 31
    //   2012: astore 27
    //   2014: aload 31
    //   2016: astore_1
    //   2017: iload 10
    //   2019: istore 8
    //   2021: aload 31
    //   2023: astore 28
    //   2025: aload 31
    //   2027: astore 29
    //   2029: aload 31
    //   2031: astore 30
    //   2033: aload 31
    //   2035: astore 32
    //   2037: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2040: ifeq +57 -> 2097
    //   2043: aload 31
    //   2045: astore 27
    //   2047: aload 31
    //   2049: astore_1
    //   2050: iload 10
    //   2052: istore 8
    //   2054: aload 31
    //   2056: astore 28
    //   2058: aload 31
    //   2060: astore 29
    //   2062: aload 31
    //   2064: astore 30
    //   2066: aload 31
    //   2068: astore 32
    //   2070: ldc 77
    //   2072: iconst_4
    //   2073: new 142	java/lang/StringBuilder
    //   2076: dup
    //   2077: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2080: ldc_w 433
    //   2083: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload 33
    //   2088: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2097: aload 31
    //   2099: astore 27
    //   2101: aload 31
    //   2103: astore_1
    //   2104: iload 10
    //   2106: istore 8
    //   2108: aload 31
    //   2110: astore 28
    //   2112: aload 31
    //   2114: astore 29
    //   2116: aload 31
    //   2118: astore 30
    //   2120: aload 31
    //   2122: astore 32
    //   2124: aload 31
    //   2126: invokevirtual 327	java/io/InputStream:close	()V
    //   2129: aload 33
    //   2131: ifnull +2092 -> 4223
    //   2134: iload 6
    //   2136: istore 7
    //   2138: iload 14
    //   2140: iload 14
    //   2142: imul
    //   2143: newarray int
    //   2145: astore 27
    //   2147: iload 6
    //   2149: istore 7
    //   2151: aload 33
    //   2153: aload 27
    //   2155: iconst_0
    //   2156: iload 14
    //   2158: iconst_0
    //   2159: iconst_0
    //   2160: iload 14
    //   2162: iload 14
    //   2164: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2167: iload 6
    //   2169: istore 7
    //   2171: iload 14
    //   2173: iload 14
    //   2175: imul
    //   2176: newarray byte
    //   2178: astore_1
    //   2179: iload 6
    //   2181: istore 7
    //   2183: aload 27
    //   2185: aload_1
    //   2186: iload 14
    //   2188: iload 14
    //   2190: invokestatic 411	rvx:a	([I[BII)I
    //   2193: istore 6
    //   2195: iload 6
    //   2197: iconst_1
    //   2198: if_icmpeq +2022 -> 4220
    //   2201: iload 6
    //   2203: istore 7
    //   2205: aload 33
    //   2207: aload 27
    //   2209: iconst_0
    //   2210: iload 14
    //   2212: iconst_0
    //   2213: iload 16
    //   2215: iload 14
    //   2217: isub
    //   2218: iload 14
    //   2220: iload 14
    //   2222: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2225: iload 6
    //   2227: istore 7
    //   2229: aload 27
    //   2231: aload_1
    //   2232: iload 14
    //   2234: iload 14
    //   2236: invokestatic 411	rvx:a	([I[BII)I
    //   2239: istore 6
    //   2241: aload 33
    //   2243: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   2246: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2249: ifeq +30 -> 2279
    //   2252: ldc 77
    //   2254: iconst_4
    //   2255: new 142	java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2262: ldc_w 435
    //   2265: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: iload 6
    //   2270: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2273: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2276: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2279: iload 6
    //   2281: istore 7
    //   2283: aconst_null
    //   2284: astore 35
    //   2286: aconst_null
    //   2287: astore 37
    //   2289: aconst_null
    //   2290: astore 31
    //   2292: aconst_null
    //   2293: astore 34
    //   2295: aconst_null
    //   2296: astore 33
    //   2298: aconst_null
    //   2299: astore 32
    //   2301: aconst_null
    //   2302: astore 36
    //   2304: iload 7
    //   2306: iconst_1
    //   2307: if_icmpeq +1904 -> 4211
    //   2310: aload 35
    //   2312: astore 27
    //   2314: aload 37
    //   2316: astore_1
    //   2317: iload 10
    //   2319: istore 8
    //   2321: aload 31
    //   2323: astore 28
    //   2325: aload 34
    //   2327: astore 29
    //   2329: aload 33
    //   2331: astore 30
    //   2333: iload 14
    //   2335: iload 16
    //   2337: invokestatic 211	java/lang/Math:min	(II)I
    //   2340: istore 6
    //   2342: iload 6
    //   2344: sipush 250
    //   2347: if_icmple +1864 -> 4211
    //   2350: aload 35
    //   2352: astore 27
    //   2354: aload 37
    //   2356: astore_1
    //   2357: iload 10
    //   2359: istore 8
    //   2361: aload 31
    //   2363: astore 28
    //   2365: aload 34
    //   2367: astore 29
    //   2369: aload 33
    //   2371: astore 30
    //   2373: aload 43
    //   2375: iload 6
    //   2377: i2d
    //   2378: ldc2_w 212
    //   2381: ddiv
    //   2382: invokestatic 217	java/lang/Math:ceil	(D)D
    //   2385: d2i
    //   2386: putfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2389: aload 35
    //   2391: astore 27
    //   2393: aload 37
    //   2395: astore_1
    //   2396: iload 10
    //   2398: istore 8
    //   2400: aload 31
    //   2402: astore 28
    //   2404: aload 34
    //   2406: astore 29
    //   2408: aload 33
    //   2410: astore 30
    //   2412: aload 32
    //   2414: astore 31
    //   2416: aload 42
    //   2418: aload_0
    //   2419: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2422: astore_0
    //   2423: aload_0
    //   2424: astore 27
    //   2426: aload_0
    //   2427: astore_1
    //   2428: iload 10
    //   2430: istore 8
    //   2432: aload_0
    //   2433: astore 28
    //   2435: aload_0
    //   2436: astore 29
    //   2438: aload_0
    //   2439: astore 30
    //   2441: aload_0
    //   2442: astore 31
    //   2444: aload_0
    //   2445: aconst_null
    //   2446: aload 43
    //   2448: invokestatic 345	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2451: astore 32
    //   2453: aload_0
    //   2454: astore 27
    //   2456: aload_0
    //   2457: astore_1
    //   2458: iload 10
    //   2460: istore 8
    //   2462: aload_0
    //   2463: astore 28
    //   2465: aload_0
    //   2466: astore 29
    //   2468: aload_0
    //   2469: astore 30
    //   2471: aload_0
    //   2472: astore 31
    //   2474: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2477: ifeq +51 -> 2528
    //   2480: aload_0
    //   2481: astore 27
    //   2483: aload_0
    //   2484: astore_1
    //   2485: iload 10
    //   2487: istore 8
    //   2489: aload_0
    //   2490: astore 28
    //   2492: aload_0
    //   2493: astore 29
    //   2495: aload_0
    //   2496: astore 30
    //   2498: aload_0
    //   2499: astore 31
    //   2501: ldc 77
    //   2503: iconst_4
    //   2504: new 142	java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2511: ldc_w 437
    //   2514: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: aload 32
    //   2519: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2522: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2528: aload_0
    //   2529: astore 27
    //   2531: aload_0
    //   2532: astore_1
    //   2533: iload 10
    //   2535: istore 8
    //   2537: aload_0
    //   2538: astore 28
    //   2540: aload_0
    //   2541: astore 29
    //   2543: aload_0
    //   2544: astore 30
    //   2546: aload_0
    //   2547: astore 31
    //   2549: aload_0
    //   2550: invokevirtual 327	java/io/InputStream:close	()V
    //   2553: aload 32
    //   2555: ifnull +1649 -> 4204
    //   2558: aload 32
    //   2560: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   2563: istore 8
    //   2565: aload 32
    //   2567: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   2570: istore 6
    //   2572: iload 8
    //   2574: iload 6
    //   2576: imul
    //   2577: newarray int
    //   2579: astore_0
    //   2580: aload 32
    //   2582: aload_0
    //   2583: iconst_0
    //   2584: iload 8
    //   2586: iconst_0
    //   2587: iconst_0
    //   2588: iload 8
    //   2590: iload 6
    //   2592: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2595: aload 32
    //   2597: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   2600: aload_0
    //   2601: aconst_null
    //   2602: iload 8
    //   2604: iload 6
    //   2606: invokestatic 411	rvx:a	([I[BII)I
    //   2609: istore 6
    //   2611: iload 6
    //   2613: istore 7
    //   2615: iload 7
    //   2617: istore 6
    //   2619: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2622: ifeq +34 -> 2656
    //   2625: ldc 77
    //   2627: iconst_4
    //   2628: new 142	java/lang/StringBuilder
    //   2631: dup
    //   2632: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   2635: ldc_w 439
    //   2638: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: iload 7
    //   2643: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2646: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2649: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2652: iload 7
    //   2654: istore 6
    //   2656: iconst_1
    //   2657: istore 8
    //   2659: aconst_null
    //   2660: astore_0
    //   2661: iload 6
    //   2663: istore 7
    //   2665: iload 8
    //   2667: istore 6
    //   2669: goto -2085 -> 584
    //   2672: aload 37
    //   2674: astore 27
    //   2676: aload 33
    //   2678: astore_1
    //   2679: iload 10
    //   2681: istore 8
    //   2683: aload 35
    //   2685: astore 28
    //   2687: aload 36
    //   2689: astore 29
    //   2691: aload 34
    //   2693: astore 30
    //   2695: aload 43
    //   2697: iconst_1
    //   2698: putfield 365	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2701: goto -1146 -> 1555
    //   2704: astore_0
    //   2705: iconst_1
    //   2706: istore 6
    //   2708: aload 27
    //   2710: astore 28
    //   2712: iload 6
    //   2714: istore 8
    //   2716: aload_0
    //   2717: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   2720: aload 27
    //   2722: astore 28
    //   2724: iload 6
    //   2726: istore 8
    //   2728: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2731: ifeq +21 -> 2752
    //   2734: aload 27
    //   2736: astore 28
    //   2738: iload 6
    //   2740: istore 8
    //   2742: ldc 77
    //   2744: iconst_2
    //   2745: aload_0
    //   2746: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   2749: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2752: iload 6
    //   2754: ifeq +7 -> 2761
    //   2757: invokestatic 236	rvx:ub	()I
    //   2760: pop
    //   2761: aload 27
    //   2763: ifnull +1428 -> 4191
    //   2766: aload 27
    //   2768: invokevirtual 327	java/io/InputStream:close	()V
    //   2771: aconst_null
    //   2772: astore_0
    //   2773: goto -1978 -> 795
    //   2776: astore_1
    //   2777: iload 7
    //   2779: istore 6
    //   2781: aload 32
    //   2783: astore 31
    //   2785: aload_1
    //   2786: astore 32
    //   2788: aload 31
    //   2790: astore 27
    //   2792: aload 31
    //   2794: astore_1
    //   2795: iload 10
    //   2797: istore 8
    //   2799: aload 31
    //   2801: astore 28
    //   2803: aload 31
    //   2805: astore 29
    //   2807: aload 31
    //   2809: astore 30
    //   2811: aload 32
    //   2813: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2816: aload 31
    //   2818: astore 27
    //   2820: aload 31
    //   2822: astore_1
    //   2823: iload 10
    //   2825: istore 8
    //   2827: aload 31
    //   2829: astore 28
    //   2831: aload 31
    //   2833: astore 29
    //   2835: aload 31
    //   2837: astore 30
    //   2839: aload 31
    //   2841: invokevirtual 327	java/io/InputStream:close	()V
    //   2844: goto -927 -> 1917
    //   2847: aload 31
    //   2849: astore 27
    //   2851: aload 31
    //   2853: astore_1
    //   2854: iload 10
    //   2856: istore 8
    //   2858: aload 31
    //   2860: astore 28
    //   2862: aload 31
    //   2864: astore 29
    //   2866: aload 31
    //   2868: astore 30
    //   2870: aload 33
    //   2872: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2875: aload 31
    //   2877: astore 27
    //   2879: aload 31
    //   2881: astore_1
    //   2882: iload 10
    //   2884: istore 8
    //   2886: aload 31
    //   2888: astore 28
    //   2890: aload 31
    //   2892: astore 29
    //   2894: aload 31
    //   2896: astore 30
    //   2898: aload 31
    //   2900: invokevirtual 327	java/io/InputStream:close	()V
    //   2903: iload 6
    //   2905: istore 7
    //   2907: goto -624 -> 2283
    //   2910: iload 6
    //   2912: istore 7
    //   2914: iload 14
    //   2916: iload 16
    //   2918: iconst_2
    //   2919: imul
    //   2920: if_icmplt -637 -> 2283
    //   2923: iload 6
    //   2925: istore 7
    //   2927: iload 16
    //   2929: sipush 1280
    //   2932: if_icmpge -649 -> 2283
    //   2935: aload 31
    //   2937: astore 32
    //   2939: iload 10
    //   2941: istore 8
    //   2943: aload 42
    //   2945: aload_0
    //   2946: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2949: astore 31
    //   2951: aload 31
    //   2953: astore 27
    //   2955: aload 31
    //   2957: astore 32
    //   2959: aload 31
    //   2961: astore_1
    //   2962: iload 10
    //   2964: istore 8
    //   2966: aload 31
    //   2968: astore 28
    //   2970: aload 31
    //   2972: astore 29
    //   2974: aload 31
    //   2976: astore 30
    //   2978: aload 31
    //   2980: invokestatic 370	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2983: astore 33
    //   2985: aload 31
    //   2987: astore 27
    //   2989: aload 31
    //   2991: astore 32
    //   2993: aload 31
    //   2995: astore_1
    //   2996: iload 10
    //   2998: istore 8
    //   3000: aload 31
    //   3002: astore 28
    //   3004: aload 31
    //   3006: astore 29
    //   3008: aload 31
    //   3010: astore 30
    //   3012: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3015: ifeq +57 -> 3072
    //   3018: aload 31
    //   3020: astore 27
    //   3022: aload 31
    //   3024: astore 32
    //   3026: aload 31
    //   3028: astore_1
    //   3029: iload 10
    //   3031: istore 8
    //   3033: aload 31
    //   3035: astore 28
    //   3037: aload 31
    //   3039: astore 29
    //   3041: aload 31
    //   3043: astore 30
    //   3045: ldc 77
    //   3047: iconst_4
    //   3048: new 142	java/lang/StringBuilder
    //   3051: dup
    //   3052: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   3055: ldc_w 441
    //   3058: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: aload 33
    //   3063: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3066: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3069: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3072: aload 31
    //   3074: astore 27
    //   3076: aload 31
    //   3078: astore 32
    //   3080: aload 31
    //   3082: astore_1
    //   3083: iload 10
    //   3085: istore 8
    //   3087: aload 31
    //   3089: astore 28
    //   3091: aload 31
    //   3093: astore 29
    //   3095: aload 31
    //   3097: astore 30
    //   3099: aload 31
    //   3101: invokevirtual 327	java/io/InputStream:close	()V
    //   3104: iload 6
    //   3106: istore 8
    //   3108: aload 33
    //   3110: ifnull +170 -> 3280
    //   3113: iload 6
    //   3115: istore 7
    //   3117: iload 16
    //   3119: iload 16
    //   3121: imul
    //   3122: newarray int
    //   3124: astore_1
    //   3125: iload 6
    //   3127: istore 7
    //   3129: aload 33
    //   3131: aload_1
    //   3132: iconst_0
    //   3133: iload 16
    //   3135: iconst_0
    //   3136: iconst_0
    //   3137: iload 16
    //   3139: iload 16
    //   3141: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3144: iload 6
    //   3146: istore 7
    //   3148: iload 16
    //   3150: iload 16
    //   3152: imul
    //   3153: newarray byte
    //   3155: astore 27
    //   3157: iload 6
    //   3159: istore 7
    //   3161: aload_1
    //   3162: aload 27
    //   3164: iload 16
    //   3166: iload 16
    //   3168: invokestatic 411	rvx:a	([I[BII)I
    //   3171: istore 8
    //   3173: iload 8
    //   3175: istore 6
    //   3177: iload 8
    //   3179: iconst_1
    //   3180: if_icmpeq +42 -> 3222
    //   3183: iload 8
    //   3185: istore 7
    //   3187: aload 33
    //   3189: aload_1
    //   3190: iconst_0
    //   3191: iload 16
    //   3193: iload 14
    //   3195: iload 16
    //   3197: isub
    //   3198: iconst_0
    //   3199: iload 16
    //   3201: iload 16
    //   3203: invokevirtual 129	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3206: iload 8
    //   3208: istore 7
    //   3210: aload_1
    //   3211: aload 27
    //   3213: iload 16
    //   3215: iload 16
    //   3217: invokestatic 411	rvx:a	([I[BII)I
    //   3220: istore 6
    //   3222: iload 6
    //   3224: istore 7
    //   3226: aload 33
    //   3228: invokevirtual 322	android/graphics/Bitmap:recycle	()V
    //   3231: iload 6
    //   3233: istore 8
    //   3235: iload 6
    //   3237: istore 7
    //   3239: invokestatic 115	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3242: ifeq +38 -> 3280
    //   3245: iload 6
    //   3247: istore 7
    //   3249: ldc 77
    //   3251: iconst_4
    //   3252: new 142	java/lang/StringBuilder
    //   3255: dup
    //   3256: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   3259: ldc_w 443
    //   3262: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: iload 6
    //   3267: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3270: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3273: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3276: iload 6
    //   3278: istore 8
    //   3280: iload 8
    //   3282: istore 7
    //   3284: goto -1001 -> 2283
    //   3287: astore_1
    //   3288: aload 32
    //   3290: astore 31
    //   3292: aload_1
    //   3293: astore 32
    //   3295: aload 31
    //   3297: astore 27
    //   3299: aload 31
    //   3301: astore_1
    //   3302: iload 10
    //   3304: istore 8
    //   3306: aload 31
    //   3308: astore 28
    //   3310: aload 31
    //   3312: astore 29
    //   3314: aload 31
    //   3316: astore 30
    //   3318: aload 32
    //   3320: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3323: aload 31
    //   3325: astore 27
    //   3327: aload 31
    //   3329: astore_1
    //   3330: iload 10
    //   3332: istore 8
    //   3334: aload 31
    //   3336: astore 28
    //   3338: aload 31
    //   3340: astore 29
    //   3342: aload 31
    //   3344: astore 30
    //   3346: aload 31
    //   3348: invokevirtual 327	java/io/InputStream:close	()V
    //   3351: iload 6
    //   3353: istore 7
    //   3355: goto -1072 -> 2283
    //   3358: aload_0
    //   3359: astore 27
    //   3361: aload_0
    //   3362: astore_1
    //   3363: iload 10
    //   3365: istore 8
    //   3367: aload_0
    //   3368: astore 28
    //   3370: aload_0
    //   3371: astore 29
    //   3373: aload_0
    //   3374: astore 30
    //   3376: aload 32
    //   3378: invokevirtual 332	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3381: aload_0
    //   3382: astore 27
    //   3384: aload_0
    //   3385: astore_1
    //   3386: iload 10
    //   3388: istore 8
    //   3390: aload_0
    //   3391: astore 28
    //   3393: aload_0
    //   3394: astore 29
    //   3396: aload_0
    //   3397: astore 30
    //   3399: aload_0
    //   3400: invokevirtual 327	java/io/InputStream:close	()V
    //   3403: aconst_null
    //   3404: astore_0
    //   3405: iconst_1
    //   3406: istore 6
    //   3408: goto -2824 -> 584
    //   3411: aload_0
    //   3412: astore 27
    //   3414: iload 6
    //   3416: istore 12
    //   3418: aload_0
    //   3419: astore 31
    //   3421: iload 6
    //   3423: istore 10
    //   3425: aload_0
    //   3426: astore 30
    //   3428: iload 6
    //   3430: istore 11
    //   3432: aload_0
    //   3433: astore 29
    //   3435: iload 6
    //   3437: istore 9
    //   3439: aload_0
    //   3440: astore 28
    //   3442: iload 6
    //   3444: istore 8
    //   3446: new 222	android/util/Pair
    //   3449: dup
    //   3450: aconst_null
    //   3451: aconst_null
    //   3452: invokespecial 225	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3455: astore_1
    //   3456: aload_0
    //   3457: astore 27
    //   3459: goto -2687 -> 772
    //   3462: astore_0
    //   3463: iload 12
    //   3465: istore 6
    //   3467: goto -759 -> 2708
    //   3470: astore 27
    //   3472: aload 27
    //   3474: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3477: aload_1
    //   3478: astore_0
    //   3479: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3482: ifeq -2687 -> 795
    //   3485: ldc 77
    //   3487: iconst_2
    //   3488: aload 27
    //   3490: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3493: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3496: aload_1
    //   3497: astore_0
    //   3498: goto -2703 -> 795
    //   3501: astore_0
    //   3502: aload_0
    //   3503: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3506: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3509: ifeq +13 -> 3522
    //   3512: ldc 77
    //   3514: iconst_2
    //   3515: aload_0
    //   3516: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3519: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3522: aconst_null
    //   3523: astore_0
    //   3524: goto -2729 -> 795
    //   3527: astore_0
    //   3528: iload 10
    //   3530: istore 6
    //   3532: aload 31
    //   3534: astore 30
    //   3536: aload 30
    //   3538: astore_1
    //   3539: iload 6
    //   3541: istore 8
    //   3543: aload_0
    //   3544: invokevirtual 252	java/lang/RuntimeException:printStackTrace	()V
    //   3547: aload 30
    //   3549: astore_1
    //   3550: iload 6
    //   3552: istore 8
    //   3554: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3557: ifeq +20 -> 3577
    //   3560: aload 30
    //   3562: astore_1
    //   3563: iload 6
    //   3565: istore 8
    //   3567: ldc 77
    //   3569: iconst_2
    //   3570: aload_0
    //   3571: invokevirtual 253	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3574: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3577: iload 6
    //   3579: ifeq +7 -> 3586
    //   3582: invokestatic 236	rvx:ub	()I
    //   3585: pop
    //   3586: aload 30
    //   3588: ifnull +603 -> 4191
    //   3591: aload 30
    //   3593: invokevirtual 327	java/io/InputStream:close	()V
    //   3596: aconst_null
    //   3597: astore_0
    //   3598: goto -2803 -> 795
    //   3601: astore_0
    //   3602: aload_0
    //   3603: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3606: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3609: ifeq +13 -> 3622
    //   3612: ldc 77
    //   3614: iconst_2
    //   3615: aload_0
    //   3616: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3619: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3622: aconst_null
    //   3623: astore_0
    //   3624: goto -2829 -> 795
    //   3627: astore_0
    //   3628: iload 11
    //   3630: istore 6
    //   3632: aload 30
    //   3634: astore 29
    //   3636: aload 29
    //   3638: astore_1
    //   3639: iload 6
    //   3641: istore 8
    //   3643: aload_0
    //   3644: invokevirtual 257	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3647: aload 29
    //   3649: astore_1
    //   3650: iload 6
    //   3652: istore 8
    //   3654: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3657: ifeq +20 -> 3677
    //   3660: aload 29
    //   3662: astore_1
    //   3663: iload 6
    //   3665: istore 8
    //   3667: ldc 77
    //   3669: iconst_2
    //   3670: aload_0
    //   3671: invokevirtual 258	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3674: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3677: iload 6
    //   3679: ifeq +7 -> 3686
    //   3682: invokestatic 236	rvx:ub	()I
    //   3685: pop
    //   3686: aload 29
    //   3688: ifnull +503 -> 4191
    //   3691: aload 29
    //   3693: invokevirtual 327	java/io/InputStream:close	()V
    //   3696: aconst_null
    //   3697: astore_0
    //   3698: goto -2903 -> 795
    //   3701: astore_0
    //   3702: aload_0
    //   3703: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3706: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3709: ifeq +13 -> 3722
    //   3712: ldc 77
    //   3714: iconst_2
    //   3715: aload_0
    //   3716: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3719: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3722: aconst_null
    //   3723: astore_0
    //   3724: goto -2929 -> 795
    //   3727: astore_0
    //   3728: iload 9
    //   3730: istore 6
    //   3732: aload 29
    //   3734: astore 28
    //   3736: aload 28
    //   3738: astore_1
    //   3739: iload 6
    //   3741: istore 8
    //   3743: aload_0
    //   3744: invokevirtual 259	java/lang/Throwable:printStackTrace	()V
    //   3747: aload 28
    //   3749: astore_1
    //   3750: iload 6
    //   3752: istore 8
    //   3754: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3757: ifeq +20 -> 3777
    //   3760: aload 28
    //   3762: astore_1
    //   3763: iload 6
    //   3765: istore 8
    //   3767: ldc 77
    //   3769: iconst_2
    //   3770: aload_0
    //   3771: invokevirtual 260	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3774: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3777: iload 6
    //   3779: ifeq +7 -> 3786
    //   3782: invokestatic 236	rvx:ub	()I
    //   3785: pop
    //   3786: aload 28
    //   3788: ifnull +403 -> 4191
    //   3791: aload 28
    //   3793: invokevirtual 327	java/io/InputStream:close	()V
    //   3796: aconst_null
    //   3797: astore_0
    //   3798: goto -3003 -> 795
    //   3801: astore_0
    //   3802: aload_0
    //   3803: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3806: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3809: ifeq +13 -> 3822
    //   3812: ldc 77
    //   3814: iconst_2
    //   3815: aload_0
    //   3816: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3819: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3822: aconst_null
    //   3823: astore_0
    //   3824: goto -3029 -> 795
    //   3827: astore_0
    //   3828: aload 28
    //   3830: astore_1
    //   3831: iload 8
    //   3833: ifeq +7 -> 3840
    //   3836: invokestatic 236	rvx:ub	()I
    //   3839: pop
    //   3840: aload_1
    //   3841: ifnull +7 -> 3848
    //   3844: aload_1
    //   3845: invokevirtual 327	java/io/InputStream:close	()V
    //   3848: aload_0
    //   3849: athrow
    //   3850: astore_1
    //   3851: aload_1
    //   3852: invokevirtual 355	java/io/IOException:printStackTrace	()V
    //   3855: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3858: ifeq -10 -> 3848
    //   3861: ldc 77
    //   3863: iconst_2
    //   3864: aload_1
    //   3865: invokevirtual 356	java/io/IOException:toString	()Ljava/lang/String;
    //   3868: invokestatic 256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3871: goto -23 -> 3848
    //   3874: astore_0
    //   3875: goto -44 -> 3831
    //   3878: astore_0
    //   3879: iconst_1
    //   3880: istore 8
    //   3882: goto -51 -> 3831
    //   3885: astore_0
    //   3886: goto -55 -> 3831
    //   3889: astore_0
    //   3890: aconst_null
    //   3891: astore_1
    //   3892: iload 13
    //   3894: istore 8
    //   3896: goto -65 -> 3831
    //   3899: astore_0
    //   3900: aconst_null
    //   3901: astore_1
    //   3902: iload 13
    //   3904: istore 8
    //   3906: goto -75 -> 3831
    //   3909: astore_0
    //   3910: iload 12
    //   3912: istore 6
    //   3914: aload_1
    //   3915: astore 28
    //   3917: goto -181 -> 3736
    //   3920: astore_0
    //   3921: iload 11
    //   3923: istore 6
    //   3925: goto -189 -> 3736
    //   3928: astore_0
    //   3929: aconst_null
    //   3930: astore 28
    //   3932: iload 11
    //   3934: istore 6
    //   3936: goto -200 -> 3736
    //   3939: astore_0
    //   3940: aconst_null
    //   3941: astore 28
    //   3943: iload 11
    //   3945: istore 6
    //   3947: goto -211 -> 3736
    //   3950: astore_0
    //   3951: iload 11
    //   3953: istore 6
    //   3955: aload_1
    //   3956: astore 29
    //   3958: goto -322 -> 3636
    //   3961: astore_0
    //   3962: iconst_1
    //   3963: istore 6
    //   3965: aload_1
    //   3966: astore 29
    //   3968: goto -332 -> 3636
    //   3971: astore_0
    //   3972: iload 12
    //   3974: istore 6
    //   3976: goto -340 -> 3636
    //   3979: astore_0
    //   3980: aconst_null
    //   3981: astore 29
    //   3983: iload 12
    //   3985: istore 6
    //   3987: goto -351 -> 3636
    //   3990: astore_0
    //   3991: aconst_null
    //   3992: astore 29
    //   3994: iload 12
    //   3996: istore 6
    //   3998: goto -362 -> 3636
    //   4001: astore_0
    //   4002: iload 10
    //   4004: istore 6
    //   4006: aload_1
    //   4007: astore 30
    //   4009: goto -473 -> 3536
    //   4012: astore_0
    //   4013: iconst_1
    //   4014: istore 6
    //   4016: aload_1
    //   4017: astore 30
    //   4019: goto -483 -> 3536
    //   4022: astore_0
    //   4023: iload 9
    //   4025: istore 6
    //   4027: goto -491 -> 3536
    //   4030: astore_0
    //   4031: aconst_null
    //   4032: astore 30
    //   4034: iload 9
    //   4036: istore 6
    //   4038: goto -502 -> 3536
    //   4041: astore_0
    //   4042: aconst_null
    //   4043: astore 30
    //   4045: iload 9
    //   4047: istore 6
    //   4049: goto -513 -> 3536
    //   4052: astore_0
    //   4053: aload_1
    //   4054: astore 27
    //   4056: iload 9
    //   4058: istore 6
    //   4060: goto -1352 -> 2708
    //   4063: astore_0
    //   4064: iconst_1
    //   4065: istore 6
    //   4067: aload_1
    //   4068: astore 27
    //   4070: goto -1362 -> 2708
    //   4073: astore_0
    //   4074: aconst_null
    //   4075: astore 27
    //   4077: iconst_1
    //   4078: istore 6
    //   4080: goto -1372 -> 2708
    //   4083: astore_0
    //   4084: iconst_1
    //   4085: istore 6
    //   4087: aconst_null
    //   4088: astore 27
    //   4090: goto -1382 -> 2708
    //   4093: astore 32
    //   4095: aconst_null
    //   4096: astore_0
    //   4097: goto -739 -> 3358
    //   4100: astore 32
    //   4102: aconst_null
    //   4103: astore_0
    //   4104: goto -746 -> 3358
    //   4107: astore 32
    //   4109: aconst_null
    //   4110: astore 31
    //   4112: iload 7
    //   4114: istore 6
    //   4116: goto -821 -> 3295
    //   4119: astore 33
    //   4121: aconst_null
    //   4122: astore 31
    //   4124: iload 7
    //   4126: istore 6
    //   4128: goto -1281 -> 2847
    //   4131: astore 33
    //   4133: aconst_null
    //   4134: astore 31
    //   4136: goto -1289 -> 2847
    //   4139: astore 32
    //   4141: aconst_null
    //   4142: astore 31
    //   4144: goto -1356 -> 2788
    //   4147: astore_0
    //   4148: iconst_1
    //   4149: istore 6
    //   4151: goto -3226 -> 925
    //   4154: astore_0
    //   4155: iconst_1
    //   4156: istore 8
    //   4158: iload 6
    //   4160: istore 7
    //   4162: iload 8
    //   4164: istore 6
    //   4166: goto -3241 -> 925
    //   4169: astore_0
    //   4170: iconst_1
    //   4171: istore 6
    //   4173: goto -3331 -> 842
    //   4176: astore_0
    //   4177: iconst_1
    //   4178: istore 8
    //   4180: iload 6
    //   4182: istore 7
    //   4184: iload 8
    //   4186: istore 6
    //   4188: goto -3346 -> 842
    //   4191: aconst_null
    //   4192: astore_0
    //   4193: goto -3398 -> 795
    //   4196: aconst_null
    //   4197: astore_1
    //   4198: aload_0
    //   4199: astore 27
    //   4201: goto -3429 -> 772
    //   4204: iload 7
    //   4206: istore 6
    //   4208: goto -1552 -> 2656
    //   4211: iconst_1
    //   4212: istore 6
    //   4214: aload 36
    //   4216: astore_0
    //   4217: goto -3633 -> 584
    //   4220: goto -1979 -> 2241
    //   4223: goto -1944 -> 2279
    //   4226: iconst_0
    //   4227: istore 7
    //   4229: iconst_m1
    //   4230: istore 8
    //   4232: goto -3658 -> 574
    //   4235: aload_1
    //   4236: astore 27
    //   4238: aconst_null
    //   4239: astore_1
    //   4240: iload 24
    //   4242: istore 6
    //   4244: goto -3472 -> 772
    //   4247: aload_1
    //   4248: astore_0
    //   4249: goto -3665 -> 584
    //   4252: astore_0
    //   4253: iload 22
    //   4255: istore 6
    //   4257: goto -3332 -> 925
    //   4260: aload_1
    //   4261: astore_0
    //   4262: goto -3678 -> 584
    //   4265: astore 33
    //   4267: aload 32
    //   4269: astore 31
    //   4271: goto -1424 -> 2847
    //   4274: astore 32
    //   4276: aload 31
    //   4278: astore_0
    //   4279: goto -921 -> 3358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4282	0	paramUri	Uri
    //   0	4282	1	paramContext	Context
    //   0	4282	2	paramBoolean1	boolean
    //   0	4282	3	paramBoolean2	boolean
    //   1512	28	4	d	double
    //   76	4180	6	i	int
    //   20	4208	7	j	int
    //   146	4085	8	k	int
    //   138	3919	9	m	int
    //   122	3881	10	n	int
    //   130	3822	11	i1	int
    //   114	3881	12	i2	int
    //   97	3806	13	i3	int
    //   91	3107	14	i4	int
    //   85	1773	15	i5	int
    //   103	3113	16	i6	int
    //   82	1375	17	i7	int
    //   79	1370	18	i8	int
    //   100	1004	19	i9	int
    //   88	1385	20	i10	int
    //   70	769	21	i11	int
    //   73	4181	22	i12	int
    //   94	1002	23	i13	int
    //   106	4135	24	i14	int
    //   17	807	25	l	long
    //   9	3449	27	localObject1	Object
    //   3470	19	27	localIOException	java.io.IOException
    //   4054	183	27	localObject2	Object
    //   142	3800	28	localObject3	Object
    //   134	3859	29	localObject4	Object
    //   126	3918	30	localObject5	Object
    //   118	4159	31	localObject6	Object
    //   55	3322	32	localObject7	Object
    //   4093	1	32	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   4100	1	32	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4107	1	32	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4139	129	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4274	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   64	3163	33	localBitmap	Bitmap
    //   4119	1	33	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4131	1	33	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4265	1	33	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   58	2634	34	localObject8	Object
    //   67	2617	35	localObject9	Object
    //   61	4154	36	localObject10	Object
    //   1145	1528	37	localObject11	Object
    //   1124	329	38	localObject12	Object
    //   1121	324	39	localObject13	Object
    //   1130	339	40	localObject14	Object
    //   1127	334	41	localObject15	Object
    //   152	2792	42	localContentResolver	android.content.ContentResolver
    //   1035	1661	43	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   382	386	388	java/io/IOException
    //   225	233	837	java/lang/OutOfMemoryError
    //   249	255	837	java/lang/OutOfMemoryError
    //   271	297	837	java/lang/OutOfMemoryError
    //   317	323	837	java/lang/OutOfMemoryError
    //   339	345	837	java/lang/OutOfMemoryError
    //   361	369	837	java/lang/OutOfMemoryError
    //   430	439	837	java/lang/OutOfMemoryError
    //   455	470	837	java/lang/OutOfMemoryError
    //   486	490	837	java/lang/OutOfMemoryError
    //   506	510	837	java/lang/OutOfMemoryError
    //   1309	1317	1317	java/io/IOException
    //   1403	1411	1411	java/io/IOException
    //   1537	1555	2704	java/io/IOException
    //   1578	1586	2704	java/io/IOException
    //   1613	1623	2704	java/io/IOException
    //   1650	1656	2704	java/io/IOException
    //   1683	1746	2704	java/io/IOException
    //   1773	1778	2704	java/io/IOException
    //   1968	1976	2704	java/io/IOException
    //   2003	2010	2704	java/io/IOException
    //   2037	2043	2704	java/io/IOException
    //   2070	2097	2704	java/io/IOException
    //   2124	2129	2704	java/io/IOException
    //   2333	2342	2704	java/io/IOException
    //   2373	2389	2704	java/io/IOException
    //   2416	2423	2704	java/io/IOException
    //   2444	2453	2704	java/io/IOException
    //   2474	2480	2704	java/io/IOException
    //   2501	2528	2704	java/io/IOException
    //   2549	2553	2704	java/io/IOException
    //   2695	2701	2704	java/io/IOException
    //   2811	2816	2704	java/io/IOException
    //   2839	2844	2704	java/io/IOException
    //   2870	2875	2704	java/io/IOException
    //   2898	2903	2704	java/io/IOException
    //   2943	2951	2704	java/io/IOException
    //   2978	2985	2704	java/io/IOException
    //   3012	3018	2704	java/io/IOException
    //   3045	3072	2704	java/io/IOException
    //   3099	3104	2704	java/io/IOException
    //   3318	3323	2704	java/io/IOException
    //   3346	3351	2704	java/io/IOException
    //   3376	3381	2704	java/io/IOException
    //   3399	3403	2704	java/io/IOException
    //   1578	1586	2776	java/lang/OutOfMemoryError
    //   1613	1623	2776	java/lang/OutOfMemoryError
    //   1650	1656	2776	java/lang/OutOfMemoryError
    //   1683	1746	2776	java/lang/OutOfMemoryError
    //   1773	1778	2776	java/lang/OutOfMemoryError
    //   2943	2951	3287	java/lang/OutOfMemoryError
    //   2978	2985	3287	java/lang/OutOfMemoryError
    //   3012	3018	3287	java/lang/OutOfMemoryError
    //   3045	3072	3287	java/lang/OutOfMemoryError
    //   3099	3104	3287	java/lang/OutOfMemoryError
    //   148	154	3462	java/io/IOException
    //   194	201	3462	java/io/IOException
    //   629	637	3462	java/io/IOException
    //   672	681	3462	java/io/IOException
    //   716	723	3462	java/io/IOException
    //   758	769	3462	java/io/IOException
    //   1186	1193	3462	java/io/IOException
    //   1232	1239	3462	java/io/IOException
    //   1278	1284	3462	java/io/IOException
    //   1382	1390	3462	java/io/IOException
    //   1476	1480	3462	java/io/IOException
    //   3446	3456	3462	java/io/IOException
    //   788	793	3470	java/io/IOException
    //   2766	2771	3501	java/io/IOException
    //   148	154	3527	java/lang/RuntimeException
    //   194	201	3527	java/lang/RuntimeException
    //   629	637	3527	java/lang/RuntimeException
    //   672	681	3527	java/lang/RuntimeException
    //   716	723	3527	java/lang/RuntimeException
    //   758	769	3527	java/lang/RuntimeException
    //   1186	1193	3527	java/lang/RuntimeException
    //   1232	1239	3527	java/lang/RuntimeException
    //   1278	1284	3527	java/lang/RuntimeException
    //   1382	1390	3527	java/lang/RuntimeException
    //   1476	1480	3527	java/lang/RuntimeException
    //   3446	3456	3527	java/lang/RuntimeException
    //   3591	3596	3601	java/io/IOException
    //   148	154	3627	java/lang/UnsatisfiedLinkError
    //   194	201	3627	java/lang/UnsatisfiedLinkError
    //   629	637	3627	java/lang/UnsatisfiedLinkError
    //   672	681	3627	java/lang/UnsatisfiedLinkError
    //   716	723	3627	java/lang/UnsatisfiedLinkError
    //   758	769	3627	java/lang/UnsatisfiedLinkError
    //   1186	1193	3627	java/lang/UnsatisfiedLinkError
    //   1232	1239	3627	java/lang/UnsatisfiedLinkError
    //   1278	1284	3627	java/lang/UnsatisfiedLinkError
    //   1382	1390	3627	java/lang/UnsatisfiedLinkError
    //   1476	1480	3627	java/lang/UnsatisfiedLinkError
    //   3446	3456	3627	java/lang/UnsatisfiedLinkError
    //   3691	3696	3701	java/io/IOException
    //   148	154	3727	java/lang/Throwable
    //   194	201	3727	java/lang/Throwable
    //   629	637	3727	java/lang/Throwable
    //   672	681	3727	java/lang/Throwable
    //   716	723	3727	java/lang/Throwable
    //   758	769	3727	java/lang/Throwable
    //   1186	1193	3727	java/lang/Throwable
    //   1232	1239	3727	java/lang/Throwable
    //   1278	1284	3727	java/lang/Throwable
    //   1382	1390	3727	java/lang/Throwable
    //   1476	1480	3727	java/lang/Throwable
    //   3446	3456	3727	java/lang/Throwable
    //   3791	3796	3801	java/io/IOException
    //   148	154	3827	finally
    //   194	201	3827	finally
    //   629	637	3827	finally
    //   672	681	3827	finally
    //   716	723	3827	finally
    //   758	769	3827	finally
    //   1186	1193	3827	finally
    //   1232	1239	3827	finally
    //   1278	1284	3827	finally
    //   1382	1390	3827	finally
    //   1476	1480	3827	finally
    //   2716	2720	3827	finally
    //   2728	2734	3827	finally
    //   2742	2752	3827	finally
    //   3446	3456	3827	finally
    //   3844	3848	3850	java/io/IOException
    //   225	233	3874	finally
    //   249	255	3874	finally
    //   271	297	3874	finally
    //   317	323	3874	finally
    //   339	345	3874	finally
    //   361	369	3874	finally
    //   430	439	3874	finally
    //   455	470	3874	finally
    //   486	490	3874	finally
    //   506	510	3874	finally
    //   862	866	3874	finally
    //   886	892	3874	finally
    //   912	922	3874	finally
    //   945	949	3874	finally
    //   969	975	3874	finally
    //   995	1005	3874	finally
    //   1028	1037	3874	finally
    //   1057	1063	3874	finally
    //   1083	1091	3874	finally
    //   1111	1115	3874	finally
    //   513	525	3878	finally
    //   533	566	3878	finally
    //   1537	1555	3885	finally
    //   1578	1586	3885	finally
    //   1613	1623	3885	finally
    //   1650	1656	3885	finally
    //   1683	1746	3885	finally
    //   1773	1778	3885	finally
    //   1968	1976	3885	finally
    //   2003	2010	3885	finally
    //   2037	2043	3885	finally
    //   2070	2097	3885	finally
    //   2124	2129	3885	finally
    //   2333	2342	3885	finally
    //   2373	2389	3885	finally
    //   2416	2423	3885	finally
    //   2444	2453	3885	finally
    //   2474	2480	3885	finally
    //   2501	2528	3885	finally
    //   2549	2553	3885	finally
    //   2695	2701	3885	finally
    //   2811	2816	3885	finally
    //   2839	2844	3885	finally
    //   2870	2875	3885	finally
    //   2898	2903	3885	finally
    //   2943	2951	3885	finally
    //   2978	2985	3885	finally
    //   3012	3018	3885	finally
    //   3045	3072	3885	finally
    //   3099	3104	3885	finally
    //   3318	3323	3885	finally
    //   3346	3351	3885	finally
    //   3376	3381	3885	finally
    //   3399	3403	3885	finally
    //   3543	3547	3885	finally
    //   3554	3560	3885	finally
    //   3567	3577	3885	finally
    //   3643	3647	3885	finally
    //   3654	3660	3885	finally
    //   3667	3677	3885	finally
    //   3743	3747	3885	finally
    //   3754	3760	3885	finally
    //   3767	3777	3885	finally
    //   1791	1798	3889	finally
    //   1802	1809	3889	finally
    //   1813	1821	3889	finally
    //   1825	1840	3889	finally
    //   1844	1849	3889	finally
    //   1853	1864	3889	finally
    //   1872	1878	3889	finally
    //   1882	1909	3889	finally
    //   2138	2147	3899	finally
    //   2151	2167	3899	finally
    //   2171	2179	3899	finally
    //   2183	2195	3899	finally
    //   2205	2225	3899	finally
    //   2229	2241	3899	finally
    //   2241	2279	3899	finally
    //   2558	2611	3899	finally
    //   2619	2652	3899	finally
    //   3117	3125	3899	finally
    //   3129	3144	3899	finally
    //   3148	3157	3899	finally
    //   3161	3173	3899	finally
    //   3187	3206	3899	finally
    //   3210	3222	3899	finally
    //   3226	3231	3899	finally
    //   3239	3245	3899	finally
    //   3249	3276	3899	finally
    //   862	866	3909	java/lang/Throwable
    //   886	892	3909	java/lang/Throwable
    //   912	922	3909	java/lang/Throwable
    //   945	949	3909	java/lang/Throwable
    //   969	975	3909	java/lang/Throwable
    //   995	1005	3909	java/lang/Throwable
    //   1028	1037	3909	java/lang/Throwable
    //   1057	1063	3909	java/lang/Throwable
    //   1083	1091	3909	java/lang/Throwable
    //   1111	1115	3909	java/lang/Throwable
    //   1537	1555	3920	java/lang/Throwable
    //   1578	1586	3920	java/lang/Throwable
    //   1613	1623	3920	java/lang/Throwable
    //   1650	1656	3920	java/lang/Throwable
    //   1683	1746	3920	java/lang/Throwable
    //   1773	1778	3920	java/lang/Throwable
    //   1968	1976	3920	java/lang/Throwable
    //   2003	2010	3920	java/lang/Throwable
    //   2037	2043	3920	java/lang/Throwable
    //   2070	2097	3920	java/lang/Throwable
    //   2124	2129	3920	java/lang/Throwable
    //   2333	2342	3920	java/lang/Throwable
    //   2373	2389	3920	java/lang/Throwable
    //   2416	2423	3920	java/lang/Throwable
    //   2444	2453	3920	java/lang/Throwable
    //   2474	2480	3920	java/lang/Throwable
    //   2501	2528	3920	java/lang/Throwable
    //   2549	2553	3920	java/lang/Throwable
    //   2695	2701	3920	java/lang/Throwable
    //   2811	2816	3920	java/lang/Throwable
    //   2839	2844	3920	java/lang/Throwable
    //   2870	2875	3920	java/lang/Throwable
    //   2898	2903	3920	java/lang/Throwable
    //   2943	2951	3920	java/lang/Throwable
    //   2978	2985	3920	java/lang/Throwable
    //   3012	3018	3920	java/lang/Throwable
    //   3045	3072	3920	java/lang/Throwable
    //   3099	3104	3920	java/lang/Throwable
    //   3318	3323	3920	java/lang/Throwable
    //   3346	3351	3920	java/lang/Throwable
    //   3376	3381	3920	java/lang/Throwable
    //   3399	3403	3920	java/lang/Throwable
    //   1791	1798	3928	java/lang/Throwable
    //   1802	1809	3928	java/lang/Throwable
    //   1813	1821	3928	java/lang/Throwable
    //   1825	1840	3928	java/lang/Throwable
    //   1844	1849	3928	java/lang/Throwable
    //   1853	1864	3928	java/lang/Throwable
    //   1872	1878	3928	java/lang/Throwable
    //   1882	1909	3928	java/lang/Throwable
    //   2138	2147	3939	java/lang/Throwable
    //   2151	2167	3939	java/lang/Throwable
    //   2171	2179	3939	java/lang/Throwable
    //   2183	2195	3939	java/lang/Throwable
    //   2205	2225	3939	java/lang/Throwable
    //   2229	2241	3939	java/lang/Throwable
    //   2241	2279	3939	java/lang/Throwable
    //   2558	2611	3939	java/lang/Throwable
    //   2619	2652	3939	java/lang/Throwable
    //   3117	3125	3939	java/lang/Throwable
    //   3129	3144	3939	java/lang/Throwable
    //   3148	3157	3939	java/lang/Throwable
    //   3161	3173	3939	java/lang/Throwable
    //   3187	3206	3939	java/lang/Throwable
    //   3210	3222	3939	java/lang/Throwable
    //   3226	3231	3939	java/lang/Throwable
    //   3239	3245	3939	java/lang/Throwable
    //   3249	3276	3939	java/lang/Throwable
    //   225	233	3950	java/lang/UnsatisfiedLinkError
    //   249	255	3950	java/lang/UnsatisfiedLinkError
    //   271	297	3950	java/lang/UnsatisfiedLinkError
    //   317	323	3950	java/lang/UnsatisfiedLinkError
    //   339	345	3950	java/lang/UnsatisfiedLinkError
    //   361	369	3950	java/lang/UnsatisfiedLinkError
    //   430	439	3950	java/lang/UnsatisfiedLinkError
    //   455	470	3950	java/lang/UnsatisfiedLinkError
    //   486	490	3950	java/lang/UnsatisfiedLinkError
    //   506	510	3950	java/lang/UnsatisfiedLinkError
    //   862	866	3950	java/lang/UnsatisfiedLinkError
    //   886	892	3950	java/lang/UnsatisfiedLinkError
    //   912	922	3950	java/lang/UnsatisfiedLinkError
    //   945	949	3950	java/lang/UnsatisfiedLinkError
    //   969	975	3950	java/lang/UnsatisfiedLinkError
    //   995	1005	3950	java/lang/UnsatisfiedLinkError
    //   1028	1037	3950	java/lang/UnsatisfiedLinkError
    //   1057	1063	3950	java/lang/UnsatisfiedLinkError
    //   1083	1091	3950	java/lang/UnsatisfiedLinkError
    //   1111	1115	3950	java/lang/UnsatisfiedLinkError
    //   513	525	3961	java/lang/UnsatisfiedLinkError
    //   533	566	3961	java/lang/UnsatisfiedLinkError
    //   1537	1555	3971	java/lang/UnsatisfiedLinkError
    //   1578	1586	3971	java/lang/UnsatisfiedLinkError
    //   1613	1623	3971	java/lang/UnsatisfiedLinkError
    //   1650	1656	3971	java/lang/UnsatisfiedLinkError
    //   1683	1746	3971	java/lang/UnsatisfiedLinkError
    //   1773	1778	3971	java/lang/UnsatisfiedLinkError
    //   1968	1976	3971	java/lang/UnsatisfiedLinkError
    //   2003	2010	3971	java/lang/UnsatisfiedLinkError
    //   2037	2043	3971	java/lang/UnsatisfiedLinkError
    //   2070	2097	3971	java/lang/UnsatisfiedLinkError
    //   2124	2129	3971	java/lang/UnsatisfiedLinkError
    //   2333	2342	3971	java/lang/UnsatisfiedLinkError
    //   2373	2389	3971	java/lang/UnsatisfiedLinkError
    //   2416	2423	3971	java/lang/UnsatisfiedLinkError
    //   2444	2453	3971	java/lang/UnsatisfiedLinkError
    //   2474	2480	3971	java/lang/UnsatisfiedLinkError
    //   2501	2528	3971	java/lang/UnsatisfiedLinkError
    //   2549	2553	3971	java/lang/UnsatisfiedLinkError
    //   2695	2701	3971	java/lang/UnsatisfiedLinkError
    //   2811	2816	3971	java/lang/UnsatisfiedLinkError
    //   2839	2844	3971	java/lang/UnsatisfiedLinkError
    //   2870	2875	3971	java/lang/UnsatisfiedLinkError
    //   2898	2903	3971	java/lang/UnsatisfiedLinkError
    //   2943	2951	3971	java/lang/UnsatisfiedLinkError
    //   2978	2985	3971	java/lang/UnsatisfiedLinkError
    //   3012	3018	3971	java/lang/UnsatisfiedLinkError
    //   3045	3072	3971	java/lang/UnsatisfiedLinkError
    //   3099	3104	3971	java/lang/UnsatisfiedLinkError
    //   3318	3323	3971	java/lang/UnsatisfiedLinkError
    //   3346	3351	3971	java/lang/UnsatisfiedLinkError
    //   3376	3381	3971	java/lang/UnsatisfiedLinkError
    //   3399	3403	3971	java/lang/UnsatisfiedLinkError
    //   1791	1798	3979	java/lang/UnsatisfiedLinkError
    //   1802	1809	3979	java/lang/UnsatisfiedLinkError
    //   1813	1821	3979	java/lang/UnsatisfiedLinkError
    //   1825	1840	3979	java/lang/UnsatisfiedLinkError
    //   1844	1849	3979	java/lang/UnsatisfiedLinkError
    //   1853	1864	3979	java/lang/UnsatisfiedLinkError
    //   1872	1878	3979	java/lang/UnsatisfiedLinkError
    //   1882	1909	3979	java/lang/UnsatisfiedLinkError
    //   2138	2147	3990	java/lang/UnsatisfiedLinkError
    //   2151	2167	3990	java/lang/UnsatisfiedLinkError
    //   2171	2179	3990	java/lang/UnsatisfiedLinkError
    //   2183	2195	3990	java/lang/UnsatisfiedLinkError
    //   2205	2225	3990	java/lang/UnsatisfiedLinkError
    //   2229	2241	3990	java/lang/UnsatisfiedLinkError
    //   2241	2279	3990	java/lang/UnsatisfiedLinkError
    //   2558	2611	3990	java/lang/UnsatisfiedLinkError
    //   2619	2652	3990	java/lang/UnsatisfiedLinkError
    //   3117	3125	3990	java/lang/UnsatisfiedLinkError
    //   3129	3144	3990	java/lang/UnsatisfiedLinkError
    //   3148	3157	3990	java/lang/UnsatisfiedLinkError
    //   3161	3173	3990	java/lang/UnsatisfiedLinkError
    //   3187	3206	3990	java/lang/UnsatisfiedLinkError
    //   3210	3222	3990	java/lang/UnsatisfiedLinkError
    //   3226	3231	3990	java/lang/UnsatisfiedLinkError
    //   3239	3245	3990	java/lang/UnsatisfiedLinkError
    //   3249	3276	3990	java/lang/UnsatisfiedLinkError
    //   225	233	4001	java/lang/RuntimeException
    //   249	255	4001	java/lang/RuntimeException
    //   271	297	4001	java/lang/RuntimeException
    //   317	323	4001	java/lang/RuntimeException
    //   339	345	4001	java/lang/RuntimeException
    //   361	369	4001	java/lang/RuntimeException
    //   430	439	4001	java/lang/RuntimeException
    //   455	470	4001	java/lang/RuntimeException
    //   486	490	4001	java/lang/RuntimeException
    //   506	510	4001	java/lang/RuntimeException
    //   862	866	4001	java/lang/RuntimeException
    //   886	892	4001	java/lang/RuntimeException
    //   912	922	4001	java/lang/RuntimeException
    //   945	949	4001	java/lang/RuntimeException
    //   969	975	4001	java/lang/RuntimeException
    //   995	1005	4001	java/lang/RuntimeException
    //   1028	1037	4001	java/lang/RuntimeException
    //   1057	1063	4001	java/lang/RuntimeException
    //   1083	1091	4001	java/lang/RuntimeException
    //   1111	1115	4001	java/lang/RuntimeException
    //   513	525	4012	java/lang/RuntimeException
    //   533	566	4012	java/lang/RuntimeException
    //   1537	1555	4022	java/lang/RuntimeException
    //   1578	1586	4022	java/lang/RuntimeException
    //   1613	1623	4022	java/lang/RuntimeException
    //   1650	1656	4022	java/lang/RuntimeException
    //   1683	1746	4022	java/lang/RuntimeException
    //   1773	1778	4022	java/lang/RuntimeException
    //   1968	1976	4022	java/lang/RuntimeException
    //   2003	2010	4022	java/lang/RuntimeException
    //   2037	2043	4022	java/lang/RuntimeException
    //   2070	2097	4022	java/lang/RuntimeException
    //   2124	2129	4022	java/lang/RuntimeException
    //   2333	2342	4022	java/lang/RuntimeException
    //   2373	2389	4022	java/lang/RuntimeException
    //   2416	2423	4022	java/lang/RuntimeException
    //   2444	2453	4022	java/lang/RuntimeException
    //   2474	2480	4022	java/lang/RuntimeException
    //   2501	2528	4022	java/lang/RuntimeException
    //   2549	2553	4022	java/lang/RuntimeException
    //   2695	2701	4022	java/lang/RuntimeException
    //   2811	2816	4022	java/lang/RuntimeException
    //   2839	2844	4022	java/lang/RuntimeException
    //   2870	2875	4022	java/lang/RuntimeException
    //   2898	2903	4022	java/lang/RuntimeException
    //   2943	2951	4022	java/lang/RuntimeException
    //   2978	2985	4022	java/lang/RuntimeException
    //   3012	3018	4022	java/lang/RuntimeException
    //   3045	3072	4022	java/lang/RuntimeException
    //   3099	3104	4022	java/lang/RuntimeException
    //   3318	3323	4022	java/lang/RuntimeException
    //   3346	3351	4022	java/lang/RuntimeException
    //   3376	3381	4022	java/lang/RuntimeException
    //   3399	3403	4022	java/lang/RuntimeException
    //   1791	1798	4030	java/lang/RuntimeException
    //   1802	1809	4030	java/lang/RuntimeException
    //   1813	1821	4030	java/lang/RuntimeException
    //   1825	1840	4030	java/lang/RuntimeException
    //   1844	1849	4030	java/lang/RuntimeException
    //   1853	1864	4030	java/lang/RuntimeException
    //   1872	1878	4030	java/lang/RuntimeException
    //   1882	1909	4030	java/lang/RuntimeException
    //   2138	2147	4041	java/lang/RuntimeException
    //   2151	2167	4041	java/lang/RuntimeException
    //   2171	2179	4041	java/lang/RuntimeException
    //   2183	2195	4041	java/lang/RuntimeException
    //   2205	2225	4041	java/lang/RuntimeException
    //   2229	2241	4041	java/lang/RuntimeException
    //   2241	2279	4041	java/lang/RuntimeException
    //   2558	2611	4041	java/lang/RuntimeException
    //   2619	2652	4041	java/lang/RuntimeException
    //   3117	3125	4041	java/lang/RuntimeException
    //   3129	3144	4041	java/lang/RuntimeException
    //   3148	3157	4041	java/lang/RuntimeException
    //   3161	3173	4041	java/lang/RuntimeException
    //   3187	3206	4041	java/lang/RuntimeException
    //   3210	3222	4041	java/lang/RuntimeException
    //   3226	3231	4041	java/lang/RuntimeException
    //   3239	3245	4041	java/lang/RuntimeException
    //   3249	3276	4041	java/lang/RuntimeException
    //   225	233	4052	java/io/IOException
    //   249	255	4052	java/io/IOException
    //   271	297	4052	java/io/IOException
    //   317	323	4052	java/io/IOException
    //   339	345	4052	java/io/IOException
    //   361	369	4052	java/io/IOException
    //   430	439	4052	java/io/IOException
    //   455	470	4052	java/io/IOException
    //   486	490	4052	java/io/IOException
    //   506	510	4052	java/io/IOException
    //   862	866	4052	java/io/IOException
    //   886	892	4052	java/io/IOException
    //   912	922	4052	java/io/IOException
    //   945	949	4052	java/io/IOException
    //   969	975	4052	java/io/IOException
    //   995	1005	4052	java/io/IOException
    //   1028	1037	4052	java/io/IOException
    //   1057	1063	4052	java/io/IOException
    //   1083	1091	4052	java/io/IOException
    //   1111	1115	4052	java/io/IOException
    //   513	525	4063	java/io/IOException
    //   533	566	4063	java/io/IOException
    //   1791	1798	4073	java/io/IOException
    //   1802	1809	4073	java/io/IOException
    //   1813	1821	4073	java/io/IOException
    //   1825	1840	4073	java/io/IOException
    //   1844	1849	4073	java/io/IOException
    //   1853	1864	4073	java/io/IOException
    //   1872	1878	4073	java/io/IOException
    //   1882	1909	4073	java/io/IOException
    //   2138	2147	4083	java/io/IOException
    //   2151	2167	4083	java/io/IOException
    //   2171	2179	4083	java/io/IOException
    //   2183	2195	4083	java/io/IOException
    //   2205	2225	4083	java/io/IOException
    //   2229	2241	4083	java/io/IOException
    //   2241	2279	4083	java/io/IOException
    //   2558	2611	4083	java/io/IOException
    //   2619	2652	4083	java/io/IOException
    //   3117	3125	4083	java/io/IOException
    //   3129	3144	4083	java/io/IOException
    //   3148	3157	4083	java/io/IOException
    //   3161	3173	4083	java/io/IOException
    //   3187	3206	4083	java/io/IOException
    //   3210	3222	4083	java/io/IOException
    //   3226	3231	4083	java/io/IOException
    //   3239	3245	4083	java/io/IOException
    //   3249	3276	4083	java/io/IOException
    //   2558	2611	4093	java/lang/OutOfMemoryError
    //   2619	2652	4100	java/lang/OutOfMemoryError
    //   3117	3125	4107	java/lang/OutOfMemoryError
    //   3129	3144	4107	java/lang/OutOfMemoryError
    //   3148	3157	4107	java/lang/OutOfMemoryError
    //   3161	3173	4107	java/lang/OutOfMemoryError
    //   3187	3206	4107	java/lang/OutOfMemoryError
    //   3210	3222	4107	java/lang/OutOfMemoryError
    //   3226	3231	4107	java/lang/OutOfMemoryError
    //   3239	3245	4107	java/lang/OutOfMemoryError
    //   3249	3276	4107	java/lang/OutOfMemoryError
    //   2138	2147	4119	java/lang/OutOfMemoryError
    //   2151	2167	4119	java/lang/OutOfMemoryError
    //   2171	2179	4119	java/lang/OutOfMemoryError
    //   2183	2195	4119	java/lang/OutOfMemoryError
    //   2205	2225	4119	java/lang/OutOfMemoryError
    //   2229	2241	4119	java/lang/OutOfMemoryError
    //   2241	2279	4131	java/lang/OutOfMemoryError
    //   1791	1798	4139	java/lang/OutOfMemoryError
    //   1802	1809	4139	java/lang/OutOfMemoryError
    //   1813	1821	4139	java/lang/OutOfMemoryError
    //   1825	1840	4139	java/lang/OutOfMemoryError
    //   1844	1849	4139	java/lang/OutOfMemoryError
    //   1853	1864	4139	java/lang/OutOfMemoryError
    //   1872	1878	4139	java/lang/OutOfMemoryError
    //   1882	1909	4139	java/lang/OutOfMemoryError
    //   513	525	4147	java/lang/Throwable
    //   533	566	4154	java/lang/Throwable
    //   513	525	4169	java/lang/OutOfMemoryError
    //   533	566	4176	java/lang/OutOfMemoryError
    //   225	233	4252	java/lang/Throwable
    //   249	255	4252	java/lang/Throwable
    //   271	297	4252	java/lang/Throwable
    //   317	323	4252	java/lang/Throwable
    //   339	345	4252	java/lang/Throwable
    //   361	369	4252	java/lang/Throwable
    //   430	439	4252	java/lang/Throwable
    //   455	470	4252	java/lang/Throwable
    //   486	490	4252	java/lang/Throwable
    //   506	510	4252	java/lang/Throwable
    //   1968	1976	4265	java/lang/OutOfMemoryError
    //   2003	2010	4265	java/lang/OutOfMemoryError
    //   2037	2043	4265	java/lang/OutOfMemoryError
    //   2070	2097	4265	java/lang/OutOfMemoryError
    //   2124	2129	4265	java/lang/OutOfMemoryError
    //   2416	2423	4274	java/lang/OutOfMemoryError
    //   2444	2453	4274	java/lang/OutOfMemoryError
    //   2474	2480	4274	java/lang/OutOfMemoryError
    //   2501	2528	4274	java/lang/OutOfMemoryError
    //   2549	2553	4274	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", paramInt);
        if (BaseApplicationImpl.getApplication() != null)
        {
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
            if (localObject != null)
            {
              localObject = ((WtloginManager)localObject).getGUID();
              if ((localObject != null) && (localObject.length > 0))
              {
                localObject = aqhs.bytes2HexStr((byte[])localObject);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  localJSONObject.put("guid", ((String)localObject).toUpperCase());
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("md5", paramString1.toUpperCase());
        }
        if ((TextUtils.isEmpty(paramString2)) || (paramString2.length() >= 512)) {
          continue;
        }
        localJSONObject.put("url", paramString2);
        if (!TextUtils.isEmpty(paramString4)) {
          localJSONObject.put("fromuin", paramString4);
        }
        if (!TextUtils.isEmpty(paramString5)) {
          localJSONObject.put("touin", paramString5);
        }
        paramString1 = aqgz.getIMEI();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = ct.K();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("ip", paramString1);
        }
      }
      catch (Throwable paramString1)
      {
        QLog.i("ScannerUtils", 1, "buildQRScanReportParams error: " + paramString1.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, "buildQRScanReportParams json: " + localJSONObject.toString());
      }
      return localJSONObject.toString();
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("uuid", paramString3);
      }
    }
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      anpc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (rwt.isUrl(paramString))
      {
        anpc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        anpc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (rwt.fP(paramString))
        {
          anpc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, rwe paramrwe, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new rvz(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramrwe);
    paramAppActivity = new NewIntent(paramAppActivity, rtv.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramrwe = paramrwe.Q();
    if (paramrwe != null)
    {
      paramView = new String[9];
      paramView[0] = "md5";
      paramView[1] = "fromuin";
      paramView[2] = "touin";
      paramView[3] = "imei";
      paramView[4] = "ip";
      paramView[5] = "url";
      paramView[6] = "guid";
      paramView[7] = "uuid";
      paramView[8] = "type";
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        String str = paramView[i];
        if (paramrwe.has(str)) {
          paramAppActivity.putExtra(str, paramrwe.optString(str));
        }
        i += 1;
      }
    }
    paramAppActivity.setObserver(paramScannerParams);
    paramQQAppInterface.startServlet(paramAppActivity);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, rwe paramrwe)
  {
    paramString1 = paramString2.trim();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "resultString:" + paramString1);
    }
    if (paramAppActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerUtils", 2, "handleUrl,activity == null");
      }
    }
    label1090:
    label1094:
    for (;;)
    {
      return;
      if (paramScannerParams.aKe)
      {
        if ((!paramQQAppInterface.YI()) && (!paramQQAppInterface.abt()) && (!paramQQAppInterface.YJ())) {
          aqge.ce(2131230770, false);
        }
        paramAppActivity.setResult(-1, paramAppActivity.getIntent().putExtra("scanResult", paramString2));
        paramAppActivity.finish();
        return;
      }
      String str = paramString1.toLowerCase();
      int j = -1;
      int k = 0;
      int i = j;
      if (Pattern.compile("^mecard.*").matcher(str).matches()) {
        if (paramString1.length() <= "MECARD:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 0;
        }
      }
      j = i;
      if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(str).matches()) {
        if (paramString1.length() <= "BEGIN:VCARD\nEND:VCARD".length())
        {
          j = i;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          j = 1;
        }
      }
      i = j;
      if (Pattern.compile("^bizcard.*;;$").matcher(str).matches()) {
        if (paramString1.length() <= "BIZCARD:;;:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 2;
        }
      }
      if (str.startsWith("qqf2f://qf/"))
      {
        if ((!paramQQAppInterface.YI()) && (!paramQQAppInterface.abt()) && (!paramQQAppInterface.YJ())) {
          aqge.ce(2131230770, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramrwe);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramrwe);
        return;
      }
      if (str.startsWith("https://cmshow.qq.com/start-apollo-game.html"))
      {
        ApolloGameUtil.a(paramAppActivity, paramQQAppInterface, paramString1);
        paramAppActivity.finish();
        j = k;
        if (i != -1) {
          j = 1;
        }
        if (j == 0) {
          break label485;
        }
        if ((!paramQQAppInterface.YI()) && (!paramQQAppInterface.abt()) && (!paramQQAppInterface.YJ())) {
          aqge.ce(2131230770, false);
        }
        if (j == 0) {
          break label1090;
        }
        rtw.a(paramQQAppInterface, paramAppActivity, paramString1, i);
        i = 0;
      }
      for (;;)
      {
        if ((i != 0) || (!paramScannerParams.aKf)) {
          break label1094;
        }
        paramAppActivity.finish();
        return;
        if (!str.startsWith("https://cmshow.qq.com/developer-tool.html")) {
          break;
        }
        ApolloGameUtil.b(paramAppActivity, paramQQAppInterface, paramString1);
        paramAppActivity.finish();
        break;
        label485:
        if (!jqc.ak(paramAppActivity))
        {
          paramString1 = aqha.a(paramAppActivity, 230);
          paramString1.setMessage(2131719035);
          paramString2 = new rvy(paramrwe);
          paramString1.setPositiveButton(2131721079, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.YI()) && (!paramQQAppInterface.abt()) && (!paramQQAppInterface.YJ())) {
          aqge.ce(2131230770, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!rwt.fI(str)))
        {
          if (arsg.dcV)
          {
            paramView.setVisibility(0);
            arsg.a().a(paramQQAppInterface, paramString1, paramView);
            i = 0;
          }
          else
          {
            paramView.setVisibility(0);
            paramString2 = new Intent(paramAppActivity, QRLoginAuthActivity.class);
            paramString2.putExtra("QR_CODE_STRING", paramString1);
            if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
              paramAppActivity.startActivityForResult(paramString2, 2);
            }
            for (;;)
            {
              i = 0;
              break;
              paramAppActivity.startActivity(paramString2);
            }
          }
        }
        else if (((!TextUtils.isEmpty(str)) && (str.startsWith("http://iot.qq.com/add"))) || (("ScanSmartDevice".equals(paramAppActivity.getIntent().getStringExtra("from"))) && (!TextUtils.isEmpty(str)) && (!str.startsWith("http://qqapp.eprintsw.com"))))
        {
          tar.a().zh(1);
          tar.a().aIF = "";
          tar.a().bAQ = 0;
          tar.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramrwe, paramString1)) {
            paramAppActivity.finish();
          }
          i = 0;
        }
        else if (fH(paramString1))
        {
          b(paramString1, paramAppActivity);
          i = 0;
        }
        else if (paramString2.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate"))
        {
          a(paramString2, paramAppActivity);
          i = 0;
        }
        else if (rwt.fL(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (rwt.fM(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (rwt.fN(str))
        {
          QWalletHelper.doF2FRedpack(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppUrl(str))
        {
          com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScanCode(paramAppActivity, paramString1);
          i = 0;
        }
        else
        {
          if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(str))
          {
            if (paramScannerParams.aKi) {}
            for (i = 1012;; i = 1011)
            {
              com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramAppActivity, paramString1, i, null);
              paramAppActivity.finish();
              i = 0;
              break;
            }
          }
          if (rwt.fO(str))
          {
            if (rwt.fJ(str))
            {
              paramString2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
              paramString2.putExtra("innerSig", paramString1);
              paramString2.putExtra(aCJ, bvz);
              if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
                paramAppActivity.startActivityForResult(paramString2, 2);
              }
              for (;;)
              {
                i = 0;
                break;
                paramAppActivity.startActivity(paramString2);
              }
            }
            if (aqni.rB(paramString1))
            {
              aqni.c(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramrwe, paramView);
              i = 1;
            }
          }
          else
          {
            rtw.a(paramQQAppInterface, paramAppActivity, paramString1);
            i = 0;
          }
        }
      }
    }
  }
  
  private static void a(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("msgbackup_qr_sig", paramString);
    localIntent.putExtra("param_start", 4);
    PublicFragmentActivity.start(paramAppActivity, localIntent, MsgBackupTransportFragment.class);
  }
  
  public static boolean a(Uri paramUri, Context paramContext)
  {
    boolean bool = false;
    if (a(paramUri, paramContext, false, false) != null) {
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerUtils", 4, "hasQRCode res:" + bool);
    }
    return bool;
  }
  
  public static void aD(QQAppInterface paramQQAppInterface)
  {
    if (aKd) {}
    do
    {
      return;
      aKd = true;
    } while (ajny.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", asfh.iw));
    new ajny().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", asfh.iw, null);
  }
  
  private static int ab(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (((paramInt1 & 0x1) == 1) && ((paramInt2 & 0x1) == 0)) {}
    for (;;)
    {
      int j = i;
      if ((paramInt1 & 0x2) == 2)
      {
        j = i;
        if ((paramInt2 & 0x2) == 0) {
          j = i | 0x2;
        }
      }
      return j;
      i = 0;
    }
  }
  
  private static void b(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent(paramAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromQrcode", true);
    localIntent.putExtra("url", paramString);
    if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
      paramAppActivity.startActivityForResult(localIntent, 2);
    }
    for (;;)
    {
      paramAppActivity.finish();
      return;
      paramAppActivity.startActivity(localIntent);
    }
  }
  
  public static void cJ(Context paramContext)
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
          Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          localObject1 = ((Class)localObject1).getDeclaredField("mContext");
          ((Field)localObject1).setAccessible(true);
          if (((Field)localObject1).get(localObject2) == paramContext)
          {
            ((Field)localObject1).set(localObject2, null);
            return;
          }
        }
        catch (Throwable paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ScannerUtils", 2, paramContext, new Object[0]);
  }
  
  public static boolean fH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("app_name=qim");
  }
  
  public static boolean fa(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean fb(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  private static int ua()
  {
    int i = 0;
    try
    {
      int k = asfh.b(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = asfh.c((int[])localObject, localObject.length);
      localObject = asfh.GetVersion();
      if (QLog.isDevelopLevel()) {
        QLog.d("ScannerUtils", 4, "initQbar init_result1:" + k + ",init_result2:" + j + "version:" + (String)localObject);
      }
      if ((k < 0) || (j < 0)) {
        i = -1;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScannerUtils", 1, "initQbar failed:", localThrowable);
    }
    return -1;
  }
  
  private static int ub()
  {
    try
    {
      int i = asfh.Release();
      if (i < 0) {
        return -1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScannerUtils", 1, "releaseQbar failed:", localThrowable);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvx
 * JD-Core Version:    0.7.0.1
 */