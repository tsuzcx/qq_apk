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

public class yak
{
  public static int a;
  public static String a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "addDisSource";
    jdField_a_of_type_Int = 1;
  }
  
  private static int a()
  {
    int i = 0;
    try
    {
      int k = bfwd.a(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bfwd.a((int[])localObject, localObject.length);
      localObject = bfwd.a();
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
  
  private static int a(int paramInt1, int paramInt2)
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
  
  private static int a(Bitmap paramBitmap, int paramInt1, int paramInt2, int[] paramArrayOfInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    int j = 0;
    int i;
    boolean bool;
    if ((auew.a() >= 0) && (aneh.b()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = aneh.a().a(paramBitmap, l, localRect);
      if ((!bool) || (localRect.width() <= 0) || (localRect.height() <= 0)) {
        break label176;
      }
      paramBitmap = new Rect();
      auew.a(localRect, paramBitmap, paramInt1, paramInt2, 1.2F);
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
    //   1: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
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
    //   30: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   33: ifeq +34 -> 67
    //   36: ldc 43
    //   38: iconst_4
    //   39: ldc 156
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 4
    //   49: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: iload 7
    //   57: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: aload 10
    //   70: iconst_0
    //   71: iload 4
    //   73: iconst_0
    //   74: iconst_0
    //   75: iload 4
    //   77: iload 7
    //   79: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   82: aload 10
    //   84: aload 11
    //   86: iload 4
    //   88: iload 7
    //   90: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   93: pop
    //   94: aload 10
    //   96: aload 11
    //   98: iload 4
    //   100: iload 7
    //   102: iload_1
    //   103: aload_2
    //   104: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   107: istore_3
    //   108: iconst_0
    //   109: iload_3
    //   110: ior
    //   111: istore_3
    //   112: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +222 -> 337
    //   118: ldc 43
    //   120: iconst_4
    //   121: ldc 176
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_1
    //   130: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_3
    //   137: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: aload_2
    //   144: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto +183 -> 337
    //   157: invokestatic 80	auew:a	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 85	aneh:b	()Z
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
    //   187: invokestatic 178	yak:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 183	anet:a	(ZZ)V
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
    //   274: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -36 -> 241
    //   280: ldc 43
    //   282: iconst_2
    //   283: aload_0
    //   284: invokevirtual 186	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   287: aload_0
    //   288: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: iload_3
    //   292: ireturn
    //   293: astore_0
    //   294: iconst_0
    //   295: istore_3
    //   296: iload_3
    //   297: istore 4
    //   299: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -61 -> 241
    //   305: ldc 43
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   312: aload_0
    //   313: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
          if (!bfwd.a(paramBitmap.getWidth(), paramBitmap.getHeight())) {
            n = paramInt & 0xFFFFFFFE;
          }
          if ((n & 0x1) == 1)
          {
            j = i1;
            k = i2;
            m = i3;
            a();
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
            aneh.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(aneh.a()), Long.valueOf(l2) }));
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
      if (a(n, paramInt) <= 0) {
        break label812;
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (i <= 250) {
        break label812;
      }
      j = paramInt;
      k = paramInt;
      m = paramInt;
      i = (int)Math.ceil(i / 250.0D);
      break label812;
      if ((!bool) || (paramSparseArray == null) || (!paramBoolean)) {
        break label829;
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
      bfwd.a(paramBitmap, localStringBuilder2);
      j = paramInt;
      k = paramInt;
      m = paramInt;
      paramSparseArray.put(1, new Pair(localStringBuilder2, paramBitmap));
      break label829;
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
        b();
      }
      i = paramInt;
      if ((n & 0x2) == 2)
      {
        j = paramInt;
        k = paramInt;
        m = paramInt;
        aneh.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   14: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   17: lstore 32
    //   19: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   22: ifeq +30 -> 52
    //   25: ldc_w 289
    //   28: iconst_4
    //   29: new 45	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 291
    //   39: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 294	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 13
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
    //   74: istore 19
    //   76: aconst_null
    //   77: astore 34
    //   79: aconst_null
    //   80: astore 39
    //   82: aconst_null
    //   83: astore 41
    //   85: aconst_null
    //   86: astore 40
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
    //   115: ldc2_w 295
    //   118: lstore 30
    //   120: aload 40
    //   122: astore 38
    //   124: aload 34
    //   126: astore 36
    //   128: aload 39
    //   130: astore 35
    //   132: aload 41
    //   134: astore 37
    //   136: aload_1
    //   137: invokevirtual 302	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 40
    //   144: astore 38
    //   146: aload 34
    //   148: astore 36
    //   150: aload 39
    //   152: astore 35
    //   154: aload 41
    //   156: astore 37
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5797 -> 5965
    //   171: aload 34
    //   173: astore 38
    //   175: aload 34
    //   177: astore 36
    //   179: aload 34
    //   181: astore 35
    //   183: aload 34
    //   185: astore 37
    //   187: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   190: lstore 28
    //   192: iload 4
    //   194: iconst_2
    //   195: iand
    //   196: iconst_2
    //   197: if_icmpne +126 -> 323
    //   200: iload 22
    //   202: istore 7
    //   204: invokestatic 97	aneh:a	()Laneh;
    //   207: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   210: lload 28
    //   212: ldc_w 289
    //   215: invokevirtual 211	aneh:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   218: iconst_1
    //   219: istore 24
    //   221: iconst_1
    //   222: istore 27
    //   224: iconst_1
    //   225: istore 23
    //   227: iconst_1
    //   228: istore 22
    //   230: iconst_1
    //   231: istore 25
    //   233: iconst_1
    //   234: istore 26
    //   236: iload 26
    //   238: istore 6
    //   240: iload 24
    //   242: istore 7
    //   244: iload 27
    //   246: istore 8
    //   248: iload 23
    //   250: istore 9
    //   252: iload 22
    //   254: istore 10
    //   256: iload 25
    //   258: istore 11
    //   260: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +60 -> 323
    //   266: iload 24
    //   268: istore 7
    //   270: iload 27
    //   272: istore 8
    //   274: iload 23
    //   276: istore 9
    //   278: iload 22
    //   280: istore 10
    //   282: iload 25
    //   284: istore 11
    //   286: ldc_w 289
    //   289: iconst_2
    //   290: ldc 213
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: invokestatic 215	aneh:a	()Z
    //   301: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 28
    //   309: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 26
    //   321: istore 6
    //   323: new 45	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   330: astore 40
    //   332: iload_3
    //   333: ifeq +1048 -> 1381
    //   336: aload_0
    //   337: invokevirtual 313	android/net/Uri:getPath	()Ljava/lang/String;
    //   340: invokestatic 319	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   343: astore_1
    //   344: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   347: ifeq +30 -> 377
    //   350: ldc_w 289
    //   353: iconst_4
    //   354: new 45	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 321
    //   364: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload_1
    //   378: ifnull +5570 -> 5948
    //   381: aload_1
    //   382: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   385: istore 20
    //   387: aload_1
    //   388: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   391: istore 21
    //   393: iload 20
    //   395: iload 21
    //   397: invokestatic 199	bfwd:a	(II)Z
    //   400: istore_3
    //   401: iload_3
    //   402: ifne +5539 -> 5941
    //   405: iload 4
    //   407: bipush 254
    //   409: iand
    //   410: istore 8
    //   412: iload 20
    //   414: iload 21
    //   416: imul
    //   417: newarray int
    //   419: astore 35
    //   421: aload_1
    //   422: aload 35
    //   424: iconst_0
    //   425: iload 20
    //   427: iconst_0
    //   428: iconst_0
    //   429: iload 20
    //   431: iload 21
    //   433: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   436: iload 8
    //   438: iconst_1
    //   439: iand
    //   440: iconst_1
    //   441: if_icmpne +5494 -> 5935
    //   444: invokestatic 200	yak:a	()I
    //   447: pop
    //   448: iconst_1
    //   449: istore 4
    //   451: iload 4
    //   453: istore 12
    //   455: iload 4
    //   457: istore 13
    //   459: iload 14
    //   461: istore 9
    //   463: iload 4
    //   465: istore 14
    //   467: iload 15
    //   469: istore 11
    //   471: iload 4
    //   473: istore 15
    //   475: iload 18
    //   477: istore 10
    //   479: aload 35
    //   481: aconst_null
    //   482: iload 20
    //   484: iload 21
    //   486: iload 8
    //   488: aload 40
    //   490: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   493: istore 7
    //   495: iload 4
    //   497: istore 12
    //   499: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   502: ifeq +48 -> 550
    //   505: iload 4
    //   507: istore 12
    //   509: ldc_w 289
    //   512: iconst_4
    //   513: ldc_w 326
    //   516: iconst_3
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: iload 8
    //   524: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: iload 7
    //   532: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: aastore
    //   536: dup
    //   537: iconst_2
    //   538: aload 40
    //   540: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: aastore
    //   544: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   547: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: iload 4
    //   552: istore 12
    //   554: iload 20
    //   556: iload 21
    //   558: imul
    //   559: newarray byte
    //   561: astore 36
    //   563: iload 4
    //   565: istore 12
    //   567: aload 35
    //   569: aload 36
    //   571: iload 20
    //   573: iload 21
    //   575: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   578: pop
    //   579: iload 8
    //   581: iconst_2
    //   582: iand
    //   583: iconst_2
    //   584: if_icmpne +496 -> 1080
    //   587: iload 7
    //   589: iconst_2
    //   590: iand
    //   591: ifne +489 -> 1080
    //   594: iconst_1
    //   595: istore 9
    //   597: iload 4
    //   599: istore 12
    //   601: invokestatic 80	auew:a	()I
    //   604: iflt +13 -> 617
    //   607: iload 4
    //   609: istore 12
    //   611: invokestatic 215	aneh:a	()Z
    //   614: ifeq +3 -> 617
    //   617: iload 9
    //   619: ifeq +5313 -> 5932
    //   622: iload 4
    //   624: istore 12
    //   626: aload_1
    //   627: iload 20
    //   629: iload 21
    //   631: aload 35
    //   633: aload 36
    //   635: aload 40
    //   637: invokestatic 178	yak:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   640: istore 9
    //   642: iload 7
    //   644: iload 9
    //   646: ior
    //   647: istore 7
    //   649: iload 4
    //   651: istore 12
    //   653: iload 4
    //   655: istore 13
    //   657: iload 7
    //   659: istore 9
    //   661: iload 4
    //   663: istore 14
    //   665: iload 7
    //   667: istore 11
    //   669: iload 4
    //   671: istore 15
    //   673: iload 7
    //   675: istore 10
    //   677: iload 7
    //   679: istore 16
    //   681: iload 7
    //   683: istore 17
    //   685: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   688: ifeq +66 -> 754
    //   691: iload 4
    //   693: istore 12
    //   695: iload 4
    //   697: istore 13
    //   699: iload 7
    //   701: istore 9
    //   703: iload 4
    //   705: istore 14
    //   707: iload 7
    //   709: istore 11
    //   711: iload 4
    //   713: istore 15
    //   715: iload 7
    //   717: istore 10
    //   719: iload 7
    //   721: istore 16
    //   723: iload 7
    //   725: istore 17
    //   727: ldc 43
    //   729: iconst_4
    //   730: new 45	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 328
    //   740: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: iload 7
    //   745: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: iload 4
    //   756: istore 12
    //   758: aload_1
    //   759: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   762: iload 4
    //   764: istore 9
    //   766: iload 7
    //   768: istore 4
    //   770: aload 34
    //   772: astore_1
    //   773: iload 9
    //   775: istore 7
    //   777: iload 8
    //   779: istore 9
    //   781: iload 4
    //   783: iflt +201 -> 984
    //   786: iload 4
    //   788: iconst_1
    //   789: iand
    //   790: iconst_1
    //   791: if_icmpne +3200 -> 3991
    //   794: iconst_1
    //   795: istore_3
    //   796: iload_3
    //   797: ifeq +5185 -> 5982
    //   800: aload 5
    //   802: ifnull +5180 -> 5982
    //   805: iload_2
    //   806: ifeq +5176 -> 5982
    //   809: aload_1
    //   810: astore 34
    //   812: iload 7
    //   814: istore 8
    //   816: new 45	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   823: astore 36
    //   825: aload_1
    //   826: astore 34
    //   828: iload 7
    //   830: istore 8
    //   832: new 45	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   839: astore 35
    //   841: aload_1
    //   842: astore 34
    //   844: iload 7
    //   846: istore 8
    //   848: aload 36
    //   850: aload 35
    //   852: invokestatic 238	bfwd:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   855: pop
    //   856: aload_1
    //   857: astore 34
    //   859: iload 7
    //   861: istore 8
    //   863: aload 5
    //   865: iconst_1
    //   866: new 240	android/util/Pair
    //   869: dup
    //   870: aload 35
    //   872: aload 36
    //   874: invokespecial 243	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   877: invokevirtual 249	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   880: goto +5102 -> 5982
    //   883: iload_2
    //   884: ifeq +26 -> 910
    //   887: aload 5
    //   889: ifnull +21 -> 910
    //   892: aload_1
    //   893: astore 34
    //   895: iload 7
    //   897: istore 8
    //   899: aload 5
    //   901: iconst_2
    //   902: aload 40
    //   904: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokevirtual 249	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   910: aload_1
    //   911: astore 34
    //   913: iload 7
    //   915: istore 8
    //   917: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +64 -> 984
    //   923: aload_1
    //   924: astore 34
    //   926: iload 7
    //   928: istore 8
    //   930: ldc_w 289
    //   933: iconst_2
    //   934: ldc 251
    //   936: iconst_5
    //   937: anewarray 4	java/lang/Object
    //   940: dup
    //   941: iconst_0
    //   942: iload 9
    //   944: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   947: aastore
    //   948: dup
    //   949: iconst_1
    //   950: iload 4
    //   952: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   955: aastore
    //   956: dup
    //   957: iconst_2
    //   958: iload_3
    //   959: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   962: aastore
    //   963: dup
    //   964: iconst_3
    //   965: iload_2
    //   966: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   969: aastore
    //   970: dup
    //   971: iconst_4
    //   972: aload 40
    //   974: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: aastore
    //   978: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   981: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   984: iload 7
    //   986: ifeq +7 -> 993
    //   989: invokestatic 253	yak:b	()I
    //   992: pop
    //   993: iload 6
    //   995: ifeq +14 -> 1009
    //   998: invokestatic 97	aneh:a	()Laneh;
    //   1001: lload 28
    //   1003: ldc_w 289
    //   1006: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   1009: iload 4
    //   1011: istore 6
    //   1013: aload_1
    //   1014: ifnull +11 -> 1025
    //   1017: aload_1
    //   1018: invokevirtual 336	java/io/InputStream:close	()V
    //   1021: iload 4
    //   1023: istore 6
    //   1025: iload 6
    //   1027: istore 4
    //   1029: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1032: ifeq -1021 -> 11
    //   1035: ldc_w 289
    //   1038: iconst_4
    //   1039: new 45	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 338
    //   1049: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   1055: lload 32
    //   1057: lsub
    //   1058: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1061: ldc_w 340
    //   1064: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: aload_0
    //   1068: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1077: iload 6
    //   1079: ireturn
    //   1080: iconst_0
    //   1081: istore 9
    //   1083: goto -486 -> 597
    //   1086: astore_1
    //   1087: iconst_0
    //   1088: istore 9
    //   1090: iload 19
    //   1092: istore 8
    //   1094: iload 4
    //   1096: istore 7
    //   1098: iload 9
    //   1100: istore 4
    //   1102: iload 4
    //   1104: istore 12
    //   1106: iload 4
    //   1108: istore 17
    //   1110: iload 8
    //   1112: istore 16
    //   1114: iload 4
    //   1116: istore 13
    //   1118: iload 8
    //   1120: istore 9
    //   1122: iload 4
    //   1124: istore 14
    //   1126: iload 8
    //   1128: istore 11
    //   1130: iload 4
    //   1132: istore 15
    //   1134: iload 8
    //   1136: istore 10
    //   1138: aload_1
    //   1139: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1142: iload 4
    //   1144: istore 12
    //   1146: iload 4
    //   1148: istore 17
    //   1150: iload 8
    //   1152: istore 16
    //   1154: iload 4
    //   1156: istore 13
    //   1158: iload 8
    //   1160: istore 9
    //   1162: iload 4
    //   1164: istore 14
    //   1166: iload 8
    //   1168: istore 11
    //   1170: iload 4
    //   1172: istore 15
    //   1174: iload 8
    //   1176: istore 10
    //   1178: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1181: ifeq +4814 -> 5995
    //   1184: iload 4
    //   1186: istore 12
    //   1188: iload 4
    //   1190: istore 17
    //   1192: iload 8
    //   1194: istore 16
    //   1196: iload 4
    //   1198: istore 13
    //   1200: iload 8
    //   1202: istore 9
    //   1204: iload 4
    //   1206: istore 14
    //   1208: iload 8
    //   1210: istore 11
    //   1212: iload 4
    //   1214: istore 15
    //   1216: iload 8
    //   1218: istore 10
    //   1220: ldc_w 289
    //   1223: iconst_2
    //   1224: aload_1
    //   1225: invokevirtual 342	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1228: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1231: goto +4764 -> 5995
    //   1234: iload 4
    //   1236: istore 12
    //   1238: iload 4
    //   1240: istore 17
    //   1242: iload 8
    //   1244: istore 16
    //   1246: iload 4
    //   1248: istore 13
    //   1250: iload 8
    //   1252: istore 9
    //   1254: iload 4
    //   1256: istore 14
    //   1258: iload 8
    //   1260: istore 11
    //   1262: iload 4
    //   1264: istore 15
    //   1266: iload 8
    //   1268: istore 10
    //   1270: aload_1
    //   1271: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   1274: iload 4
    //   1276: istore 12
    //   1278: iload 4
    //   1280: istore 17
    //   1282: iload 8
    //   1284: istore 16
    //   1286: iload 4
    //   1288: istore 13
    //   1290: iload 8
    //   1292: istore 9
    //   1294: iload 4
    //   1296: istore 14
    //   1298: iload 8
    //   1300: istore 11
    //   1302: iload 4
    //   1304: istore 15
    //   1306: iload 8
    //   1308: istore 10
    //   1310: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1313: ifeq +50 -> 1363
    //   1316: iload 4
    //   1318: istore 12
    //   1320: iload 4
    //   1322: istore 17
    //   1324: iload 8
    //   1326: istore 16
    //   1328: iload 4
    //   1330: istore 13
    //   1332: iload 8
    //   1334: istore 9
    //   1336: iload 4
    //   1338: istore 14
    //   1340: iload 8
    //   1342: istore 11
    //   1344: iload 4
    //   1346: istore 15
    //   1348: iload 8
    //   1350: istore 10
    //   1352: ldc_w 289
    //   1355: iconst_2
    //   1356: aload_1
    //   1357: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1360: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: aload 34
    //   1365: astore_1
    //   1366: iload 7
    //   1368: istore 9
    //   1370: iload 4
    //   1372: istore 7
    //   1374: iload 8
    //   1376: istore 4
    //   1378: goto -597 -> 781
    //   1381: new 344	android/graphics/BitmapFactory$Options
    //   1384: dup
    //   1385: invokespecial 345	android/graphics/BitmapFactory$Options:<init>	()V
    //   1388: astore 41
    //   1390: aload 41
    //   1392: iconst_1
    //   1393: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1396: aload 34
    //   1398: aconst_null
    //   1399: aload 41
    //   1401: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1404: pop
    //   1405: aload 34
    //   1407: invokevirtual 336	java/io/InputStream:close	()V
    //   1410: aconst_null
    //   1411: astore_1
    //   1412: aconst_null
    //   1413: astore 35
    //   1415: aconst_null
    //   1416: astore 36
    //   1418: aload_1
    //   1419: astore 34
    //   1421: iload 21
    //   1423: istore 8
    //   1425: aload 41
    //   1427: getfield 357	android/graphics/BitmapFactory$Options:outWidth	I
    //   1430: istore 16
    //   1432: aload_1
    //   1433: astore 34
    //   1435: iload 21
    //   1437: istore 8
    //   1439: aload 41
    //   1441: getfield 360	android/graphics/BitmapFactory$Options:outHeight	I
    //   1444: istore 15
    //   1446: iload 16
    //   1448: sipush 12800
    //   1451: if_icmpgt +11 -> 1462
    //   1454: iload 15
    //   1456: sipush 12800
    //   1459: if_icmple +65 -> 1524
    //   1462: iconst_0
    //   1463: istore 7
    //   1465: iload 6
    //   1467: ifeq +14 -> 1481
    //   1470: invokestatic 97	aneh:a	()Laneh;
    //   1473: lload 28
    //   1475: ldc_w 289
    //   1478: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   1481: iload 7
    //   1483: istore 4
    //   1485: iconst_0
    //   1486: ifeq -1475 -> 11
    //   1489: new 362	java/lang/NullPointerException
    //   1492: dup
    //   1493: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1496: athrow
    //   1497: astore_0
    //   1498: aload_0
    //   1499: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1502: iload 7
    //   1504: istore 4
    //   1506: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1509: ifeq -1498 -> 11
    //   1512: ldc 43
    //   1514: iconst_2
    //   1515: aload_0
    //   1516: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1519: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1522: iconst_0
    //   1523: ireturn
    //   1524: aload_1
    //   1525: astore 34
    //   1527: iload 21
    //   1529: istore 8
    //   1531: iload 16
    //   1533: iload 15
    //   1535: invokestatic 199	bfwd:a	(II)Z
    //   1538: ifne +4387 -> 5925
    //   1541: iload 4
    //   1543: bipush 254
    //   1545: iand
    //   1546: istore 10
    //   1548: iload 10
    //   1550: iconst_1
    //   1551: iand
    //   1552: iconst_1
    //   1553: if_icmpne +4366 -> 5919
    //   1556: aload_1
    //   1557: astore 34
    //   1559: iload 21
    //   1561: istore 8
    //   1563: invokestatic 200	yak:a	()I
    //   1566: pop
    //   1567: iconst_1
    //   1568: istore 7
    //   1570: aload 35
    //   1572: astore_1
    //   1573: aload 41
    //   1575: aload 41
    //   1577: sipush 1280
    //   1580: sipush 1280
    //   1583: invokestatic 370	aiqe:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1586: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1589: aload 35
    //   1591: astore_1
    //   1592: aload 41
    //   1594: iconst_0
    //   1595: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1598: aload 36
    //   1600: astore 34
    //   1602: aload 35
    //   1604: astore_1
    //   1605: aload 42
    //   1607: aload_0
    //   1608: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1611: astore 35
    //   1613: aload 35
    //   1615: astore 34
    //   1617: aload 35
    //   1619: astore_1
    //   1620: aload 35
    //   1622: astore 37
    //   1624: aload 35
    //   1626: astore 38
    //   1628: aload 35
    //   1630: astore 39
    //   1632: aload 35
    //   1634: astore 36
    //   1636: aload 35
    //   1638: aconst_null
    //   1639: aload 41
    //   1641: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1644: astore 43
    //   1646: aload 35
    //   1648: astore 34
    //   1650: aload 35
    //   1652: astore_1
    //   1653: aload 35
    //   1655: astore 37
    //   1657: aload 35
    //   1659: astore 38
    //   1661: aload 35
    //   1663: astore 39
    //   1665: aload 35
    //   1667: astore 36
    //   1669: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1672: ifeq +70 -> 1742
    //   1675: aload 35
    //   1677: astore 34
    //   1679: aload 35
    //   1681: astore_1
    //   1682: aload 35
    //   1684: astore 37
    //   1686: aload 35
    //   1688: astore 38
    //   1690: aload 35
    //   1692: astore 39
    //   1694: aload 35
    //   1696: astore 36
    //   1698: ldc_w 289
    //   1701: iconst_4
    //   1702: ldc_w 375
    //   1705: iconst_3
    //   1706: anewarray 4	java/lang/Object
    //   1709: dup
    //   1710: iconst_0
    //   1711: iload 16
    //   1713: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1716: aastore
    //   1717: dup
    //   1718: iconst_1
    //   1719: iload 15
    //   1721: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1724: aastore
    //   1725: dup
    //   1726: iconst_2
    //   1727: aload 41
    //   1729: getfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1732: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1735: aastore
    //   1736: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1739: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1742: aload 35
    //   1744: astore 34
    //   1746: aload 35
    //   1748: astore_1
    //   1749: aload 35
    //   1751: astore 37
    //   1753: aload 35
    //   1755: astore 38
    //   1757: aload 35
    //   1759: astore 39
    //   1761: aload 35
    //   1763: astore 36
    //   1765: aload 35
    //   1767: invokevirtual 336	java/io/InputStream:close	()V
    //   1770: aconst_null
    //   1771: astore_1
    //   1772: aconst_null
    //   1773: astore 34
    //   1775: iload 20
    //   1777: istore 4
    //   1779: aload 43
    //   1781: ifnull +20 -> 1801
    //   1784: aload 43
    //   1786: iload 10
    //   1788: aload 40
    //   1790: invokestatic 222	yak:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1793: istore 4
    //   1795: iconst_0
    //   1796: iload 4
    //   1798: ior
    //   1799: istore 4
    //   1801: aconst_null
    //   1802: astore 34
    //   1804: aconst_null
    //   1805: astore 36
    //   1807: aconst_null
    //   1808: astore 35
    //   1810: aload 36
    //   1812: astore_1
    //   1813: iload 4
    //   1815: istore 14
    //   1817: iload 4
    //   1819: istore 13
    //   1821: iload 4
    //   1823: istore 12
    //   1825: iload 4
    //   1827: istore 11
    //   1829: iload 10
    //   1831: iload 4
    //   1833: invokestatic 224	yak:a	(II)I
    //   1836: istore 17
    //   1838: iload 17
    //   1840: ifle +4070 -> 5910
    //   1843: iload 16
    //   1845: iload 15
    //   1847: iconst_2
    //   1848: imul
    //   1849: if_icmplt +1092 -> 2941
    //   1852: iload 15
    //   1854: sipush 1280
    //   1857: if_icmpge +1084 -> 2941
    //   1860: iconst_1
    //   1861: istore 8
    //   1863: iload 16
    //   1865: iconst_2
    //   1866: imul
    //   1867: iload 15
    //   1869: if_icmpgt +1078 -> 2947
    //   1872: iload 16
    //   1874: sipush 1280
    //   1877: if_icmpge +1070 -> 2947
    //   1880: iconst_1
    //   1881: istore 9
    //   1883: iload 9
    //   1885: ifeq +1159 -> 3044
    //   1888: aload 36
    //   1890: astore_1
    //   1891: iload 4
    //   1893: istore 14
    //   1895: iload 4
    //   1897: istore 13
    //   1899: iload 4
    //   1901: istore 12
    //   1903: iload 4
    //   1905: istore 11
    //   1907: aload 42
    //   1909: aload_0
    //   1910: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1913: astore 34
    //   1915: aload 34
    //   1917: astore 35
    //   1919: aload 34
    //   1921: astore_1
    //   1922: aload 34
    //   1924: astore 39
    //   1926: iload 4
    //   1928: istore 13
    //   1930: aload 34
    //   1932: astore 37
    //   1934: iload 4
    //   1936: istore 11
    //   1938: aload 34
    //   1940: astore 38
    //   1942: iload 4
    //   1944: istore 12
    //   1946: aload 34
    //   1948: astore 36
    //   1950: iload 4
    //   1952: istore 9
    //   1954: aload 34
    //   1956: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1959: astore 43
    //   1961: aload 34
    //   1963: astore 35
    //   1965: aload 34
    //   1967: astore_1
    //   1968: aload 34
    //   1970: astore 39
    //   1972: iload 4
    //   1974: istore 13
    //   1976: aload 34
    //   1978: astore 37
    //   1980: iload 4
    //   1982: istore 11
    //   1984: aload 34
    //   1986: astore 38
    //   1988: iload 4
    //   1990: istore 12
    //   1992: aload 34
    //   1994: astore 36
    //   1996: iload 4
    //   1998: istore 9
    //   2000: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2003: ifeq +70 -> 2073
    //   2006: aload 34
    //   2008: astore 35
    //   2010: aload 34
    //   2012: astore_1
    //   2013: aload 34
    //   2015: astore 39
    //   2017: iload 4
    //   2019: istore 13
    //   2021: aload 34
    //   2023: astore 37
    //   2025: iload 4
    //   2027: istore 11
    //   2029: aload 34
    //   2031: astore 38
    //   2033: iload 4
    //   2035: istore 12
    //   2037: aload 34
    //   2039: astore 36
    //   2041: iload 4
    //   2043: istore 9
    //   2045: ldc_w 289
    //   2048: iconst_4
    //   2049: new 45	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2056: ldc_w 380
    //   2059: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: aload 43
    //   2064: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2067: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2070: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2073: aload 34
    //   2075: astore 35
    //   2077: aload 34
    //   2079: astore_1
    //   2080: aload 34
    //   2082: astore 39
    //   2084: iload 4
    //   2086: istore 13
    //   2088: aload 34
    //   2090: astore 37
    //   2092: iload 4
    //   2094: istore 11
    //   2096: aload 34
    //   2098: astore 38
    //   2100: iload 4
    //   2102: istore 12
    //   2104: aload 34
    //   2106: astore 36
    //   2108: iload 4
    //   2110: istore 9
    //   2112: aload 34
    //   2114: invokevirtual 336	java/io/InputStream:close	()V
    //   2117: aconst_null
    //   2118: astore 37
    //   2120: aconst_null
    //   2121: astore 34
    //   2123: aconst_null
    //   2124: astore 35
    //   2126: aconst_null
    //   2127: astore 36
    //   2129: aload 43
    //   2131: ifnull +3785 -> 5916
    //   2134: iload 4
    //   2136: istore 12
    //   2138: iload 4
    //   2140: istore 11
    //   2142: iload 4
    //   2144: istore 9
    //   2146: iload 4
    //   2148: istore 8
    //   2150: iload 4
    //   2152: istore 13
    //   2154: iload 16
    //   2156: iload 16
    //   2158: imul
    //   2159: newarray int
    //   2161: astore_1
    //   2162: iload 4
    //   2164: istore 12
    //   2166: iload 4
    //   2168: istore 11
    //   2170: iload 4
    //   2172: istore 9
    //   2174: iload 4
    //   2176: istore 8
    //   2178: iload 4
    //   2180: istore 13
    //   2182: aload 43
    //   2184: aload_1
    //   2185: iconst_0
    //   2186: iload 16
    //   2188: iconst_0
    //   2189: iconst_0
    //   2190: iload 16
    //   2192: iload 16
    //   2194: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2197: iload 4
    //   2199: istore 12
    //   2201: iload 4
    //   2203: istore 11
    //   2205: iload 4
    //   2207: istore 9
    //   2209: iload 4
    //   2211: istore 8
    //   2213: iload 4
    //   2215: istore 13
    //   2217: iload 16
    //   2219: iload 16
    //   2221: imul
    //   2222: newarray byte
    //   2224: astore 38
    //   2226: iload 4
    //   2228: istore 12
    //   2230: iload 4
    //   2232: istore 11
    //   2234: iload 4
    //   2236: istore 9
    //   2238: iload 4
    //   2240: istore 8
    //   2242: iload 4
    //   2244: istore 13
    //   2246: aload_1
    //   2247: aload 38
    //   2249: iload 16
    //   2251: iload 16
    //   2253: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2256: pop
    //   2257: iload 4
    //   2259: istore 12
    //   2261: iload 4
    //   2263: istore 11
    //   2265: iload 4
    //   2267: istore 9
    //   2269: iload 4
    //   2271: istore 8
    //   2273: iload 4
    //   2275: istore 13
    //   2277: iload 4
    //   2279: aload_1
    //   2280: aload 38
    //   2282: iload 16
    //   2284: iload 16
    //   2286: iload 17
    //   2288: aload 40
    //   2290: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2293: ior
    //   2294: istore 4
    //   2296: iload 4
    //   2298: iconst_1
    //   2299: if_icmpeq +3614 -> 5913
    //   2302: iload 4
    //   2304: istore 12
    //   2306: iload 4
    //   2308: istore 11
    //   2310: iload 4
    //   2312: istore 9
    //   2314: iload 4
    //   2316: istore 8
    //   2318: iload 4
    //   2320: istore 13
    //   2322: aload 43
    //   2324: aload_1
    //   2325: iconst_0
    //   2326: iload 16
    //   2328: iconst_0
    //   2329: iload 15
    //   2331: iload 16
    //   2333: isub
    //   2334: iload 16
    //   2336: iload 16
    //   2338: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2341: iload 4
    //   2343: istore 12
    //   2345: iload 4
    //   2347: istore 11
    //   2349: iload 4
    //   2351: istore 9
    //   2353: iload 4
    //   2355: istore 8
    //   2357: iload 4
    //   2359: istore 13
    //   2361: aload_1
    //   2362: aload 38
    //   2364: iload 16
    //   2366: iload 16
    //   2368: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2371: pop
    //   2372: iload 4
    //   2374: istore 12
    //   2376: iload 4
    //   2378: istore 11
    //   2380: iload 4
    //   2382: istore 9
    //   2384: iload 4
    //   2386: istore 8
    //   2388: iload 4
    //   2390: istore 13
    //   2392: aload_1
    //   2393: aload 38
    //   2395: iload 16
    //   2397: iload 16
    //   2399: iload 17
    //   2401: aload 40
    //   2403: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2406: istore 14
    //   2408: iload 14
    //   2410: iload 4
    //   2412: ior
    //   2413: istore 4
    //   2415: aload 43
    //   2417: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2420: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2423: ifeq +44 -> 2467
    //   2426: ldc_w 289
    //   2429: iconst_4
    //   2430: ldc_w 382
    //   2433: iconst_3
    //   2434: anewarray 4	java/lang/Object
    //   2437: dup
    //   2438: iconst_0
    //   2439: iload 17
    //   2441: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2444: aastore
    //   2445: dup
    //   2446: iconst_1
    //   2447: iload 4
    //   2449: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2452: aastore
    //   2453: dup
    //   2454: iconst_2
    //   2455: aload 40
    //   2457: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2460: aastore
    //   2461: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2464: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2467: aconst_null
    //   2468: astore 35
    //   2470: aconst_null
    //   2471: astore 34
    //   2473: aconst_null
    //   2474: astore 36
    //   2476: aload 34
    //   2478: astore_1
    //   2479: iload 10
    //   2481: iload 4
    //   2483: invokestatic 224	yak:a	(II)I
    //   2486: istore 13
    //   2488: iload 13
    //   2490: ifle +3410 -> 5900
    //   2493: aload 34
    //   2495: astore_1
    //   2496: iload 16
    //   2498: iload 15
    //   2500: invokestatic 229	java/lang/Math:min	(II)I
    //   2503: istore 8
    //   2505: iload 8
    //   2507: sipush 250
    //   2510: if_icmple +3390 -> 5900
    //   2513: aload 34
    //   2515: astore_1
    //   2516: aload 41
    //   2518: iload 8
    //   2520: i2d
    //   2521: ldc2_w 230
    //   2524: ddiv
    //   2525: invokestatic 235	java/lang/Math:ceil	(D)D
    //   2528: d2i
    //   2529: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2532: aload 34
    //   2534: astore_1
    //   2535: aload 42
    //   2537: aload_0
    //   2538: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2541: astore 34
    //   2543: aload 34
    //   2545: astore 35
    //   2547: aload 34
    //   2549: astore_1
    //   2550: aload 34
    //   2552: astore 39
    //   2554: iload 4
    //   2556: istore 9
    //   2558: aload 34
    //   2560: astore 38
    //   2562: iload 4
    //   2564: istore 11
    //   2566: aload 34
    //   2568: astore 36
    //   2570: iload 4
    //   2572: istore 12
    //   2574: aload 34
    //   2576: astore 37
    //   2578: iload 4
    //   2580: istore 8
    //   2582: aload 34
    //   2584: aconst_null
    //   2585: aload 41
    //   2587: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2590: astore 41
    //   2592: aload 34
    //   2594: astore 35
    //   2596: aload 34
    //   2598: astore_1
    //   2599: aload 34
    //   2601: astore 39
    //   2603: iload 4
    //   2605: istore 9
    //   2607: aload 34
    //   2609: astore 38
    //   2611: iload 4
    //   2613: istore 11
    //   2615: aload 34
    //   2617: astore 36
    //   2619: iload 4
    //   2621: istore 12
    //   2623: aload 34
    //   2625: astore 37
    //   2627: iload 4
    //   2629: istore 8
    //   2631: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2634: ifeq +70 -> 2704
    //   2637: aload 34
    //   2639: astore 35
    //   2641: aload 34
    //   2643: astore_1
    //   2644: aload 34
    //   2646: astore 39
    //   2648: iload 4
    //   2650: istore 9
    //   2652: aload 34
    //   2654: astore 38
    //   2656: iload 4
    //   2658: istore 11
    //   2660: aload 34
    //   2662: astore 36
    //   2664: iload 4
    //   2666: istore 12
    //   2668: aload 34
    //   2670: astore 37
    //   2672: iload 4
    //   2674: istore 8
    //   2676: ldc_w 289
    //   2679: iconst_4
    //   2680: new 45	java/lang/StringBuilder
    //   2683: dup
    //   2684: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2687: ldc_w 384
    //   2690: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: aload 41
    //   2695: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2698: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2701: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2704: aload 34
    //   2706: astore 35
    //   2708: aload 34
    //   2710: astore_1
    //   2711: aload 34
    //   2713: astore 39
    //   2715: iload 4
    //   2717: istore 9
    //   2719: aload 34
    //   2721: astore 38
    //   2723: iload 4
    //   2725: istore 11
    //   2727: aload 34
    //   2729: astore 36
    //   2731: iload 4
    //   2733: istore 12
    //   2735: aload 34
    //   2737: astore 37
    //   2739: iload 4
    //   2741: istore 8
    //   2743: aload 34
    //   2745: invokevirtual 336	java/io/InputStream:close	()V
    //   2748: aload 41
    //   2750: ifnull +3143 -> 5893
    //   2753: aload 41
    //   2755: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   2758: istore 8
    //   2760: aload 41
    //   2762: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   2765: istore 9
    //   2767: iload 8
    //   2769: iload 9
    //   2771: imul
    //   2772: newarray int
    //   2774: astore_1
    //   2775: aload 41
    //   2777: aload_1
    //   2778: iconst_0
    //   2779: iload 8
    //   2781: iconst_0
    //   2782: iconst_0
    //   2783: iload 8
    //   2785: iload 9
    //   2787: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2790: aload 41
    //   2792: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2795: aload_1
    //   2796: aconst_null
    //   2797: iload 8
    //   2799: iload 9
    //   2801: iload 13
    //   2803: aload 40
    //   2805: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2808: istore 8
    //   2810: iload 8
    //   2812: iload 4
    //   2814: ior
    //   2815: istore 4
    //   2817: iload 4
    //   2819: istore 8
    //   2821: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2824: ifeq +48 -> 2872
    //   2827: ldc_w 289
    //   2830: iconst_4
    //   2831: ldc_w 386
    //   2834: iconst_3
    //   2835: anewarray 4	java/lang/Object
    //   2838: dup
    //   2839: iconst_0
    //   2840: iload 13
    //   2842: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2845: aastore
    //   2846: dup
    //   2847: iconst_1
    //   2848: iload 4
    //   2850: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2853: aastore
    //   2854: dup
    //   2855: iconst_2
    //   2856: aload 40
    //   2858: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2861: aastore
    //   2862: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2865: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2868: iload 4
    //   2870: istore 8
    //   2872: aconst_null
    //   2873: astore_1
    //   2874: iload 10
    //   2876: istore 9
    //   2878: iload 8
    //   2880: istore 4
    //   2882: goto -2101 -> 781
    //   2885: astore 35
    //   2887: aload 34
    //   2889: astore_1
    //   2890: aload 34
    //   2892: astore 37
    //   2894: aload 34
    //   2896: astore 38
    //   2898: aload 34
    //   2900: astore 39
    //   2902: aload 34
    //   2904: astore 36
    //   2906: aload 35
    //   2908: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2911: aload 34
    //   2913: astore_1
    //   2914: aload 34
    //   2916: astore 37
    //   2918: aload 34
    //   2920: astore 38
    //   2922: aload 34
    //   2924: astore 39
    //   2926: aload 34
    //   2928: astore 36
    //   2930: aload 34
    //   2932: invokevirtual 336	java/io/InputStream:close	()V
    //   2935: iconst_0
    //   2936: istore 4
    //   2938: goto -1137 -> 1801
    //   2941: iconst_0
    //   2942: istore 8
    //   2944: goto -1081 -> 1863
    //   2947: iconst_0
    //   2948: istore 9
    //   2950: goto -1067 -> 1883
    //   2953: astore_1
    //   2954: aload 35
    //   2956: astore 34
    //   2958: aload_1
    //   2959: astore 35
    //   2961: aload 34
    //   2963: astore_1
    //   2964: aload 34
    //   2966: astore 39
    //   2968: iload 4
    //   2970: istore 13
    //   2972: aload 34
    //   2974: astore 37
    //   2976: iload 4
    //   2978: istore 11
    //   2980: aload 34
    //   2982: astore 38
    //   2984: iload 4
    //   2986: istore 12
    //   2988: aload 34
    //   2990: astore 36
    //   2992: iload 4
    //   2994: istore 9
    //   2996: aload 35
    //   2998: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3001: aload 34
    //   3003: astore_1
    //   3004: aload 34
    //   3006: astore 39
    //   3008: iload 4
    //   3010: istore 13
    //   3012: aload 34
    //   3014: astore 37
    //   3016: iload 4
    //   3018: istore 11
    //   3020: aload 34
    //   3022: astore 38
    //   3024: iload 4
    //   3026: istore 12
    //   3028: aload 34
    //   3030: astore 36
    //   3032: iload 4
    //   3034: istore 9
    //   3036: aload 34
    //   3038: invokevirtual 336	java/io/InputStream:close	()V
    //   3041: goto -574 -> 2467
    //   3044: iload 8
    //   3046: ifeq +2864 -> 5910
    //   3049: iload 4
    //   3051: istore 8
    //   3053: aload 36
    //   3055: astore_1
    //   3056: iload 4
    //   3058: istore 14
    //   3060: iload 4
    //   3062: istore 13
    //   3064: iload 4
    //   3066: istore 12
    //   3068: iload 4
    //   3070: istore 11
    //   3072: aload 42
    //   3074: aload_0
    //   3075: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3078: astore 35
    //   3080: aload 35
    //   3082: astore 34
    //   3084: iload 4
    //   3086: istore 8
    //   3088: aload 35
    //   3090: astore_1
    //   3091: aload 35
    //   3093: astore 39
    //   3095: iload 4
    //   3097: istore 13
    //   3099: aload 35
    //   3101: astore 37
    //   3103: iload 4
    //   3105: istore 11
    //   3107: aload 35
    //   3109: astore 38
    //   3111: iload 4
    //   3113: istore 12
    //   3115: aload 35
    //   3117: astore 36
    //   3119: iload 4
    //   3121: istore 9
    //   3123: aload 35
    //   3125: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3128: astore 43
    //   3130: aload 35
    //   3132: astore 34
    //   3134: iload 4
    //   3136: istore 8
    //   3138: aload 35
    //   3140: astore_1
    //   3141: aload 35
    //   3143: astore 39
    //   3145: iload 4
    //   3147: istore 13
    //   3149: aload 35
    //   3151: astore 37
    //   3153: iload 4
    //   3155: istore 11
    //   3157: aload 35
    //   3159: astore 38
    //   3161: iload 4
    //   3163: istore 12
    //   3165: aload 35
    //   3167: astore 36
    //   3169: iload 4
    //   3171: istore 9
    //   3173: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3176: ifeq +74 -> 3250
    //   3179: aload 35
    //   3181: astore 34
    //   3183: iload 4
    //   3185: istore 8
    //   3187: aload 35
    //   3189: astore_1
    //   3190: aload 35
    //   3192: astore 39
    //   3194: iload 4
    //   3196: istore 13
    //   3198: aload 35
    //   3200: astore 37
    //   3202: iload 4
    //   3204: istore 11
    //   3206: aload 35
    //   3208: astore 38
    //   3210: iload 4
    //   3212: istore 12
    //   3214: aload 35
    //   3216: astore 36
    //   3218: iload 4
    //   3220: istore 9
    //   3222: ldc_w 289
    //   3225: iconst_4
    //   3226: new 45	java/lang/StringBuilder
    //   3229: dup
    //   3230: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3233: ldc_w 388
    //   3236: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: aload 43
    //   3241: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3244: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3247: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3250: aload 35
    //   3252: astore 34
    //   3254: iload 4
    //   3256: istore 8
    //   3258: aload 35
    //   3260: astore_1
    //   3261: aload 35
    //   3263: astore 39
    //   3265: iload 4
    //   3267: istore 13
    //   3269: aload 35
    //   3271: astore 37
    //   3273: iload 4
    //   3275: istore 11
    //   3277: aload 35
    //   3279: astore 38
    //   3281: iload 4
    //   3283: istore 12
    //   3285: aload 35
    //   3287: astore 36
    //   3289: iload 4
    //   3291: istore 9
    //   3293: aload 35
    //   3295: invokevirtual 336	java/io/InputStream:close	()V
    //   3298: aconst_null
    //   3299: astore 36
    //   3301: aconst_null
    //   3302: astore 35
    //   3304: iload 4
    //   3306: istore 9
    //   3308: aload 43
    //   3310: ifnull +488 -> 3798
    //   3313: aload 35
    //   3315: astore 34
    //   3317: iload 4
    //   3319: istore 8
    //   3321: aload 36
    //   3323: astore_1
    //   3324: iload 4
    //   3326: istore 14
    //   3328: iload 4
    //   3330: istore 13
    //   3332: iload 4
    //   3334: istore 12
    //   3336: iload 4
    //   3338: istore 11
    //   3340: iload 15
    //   3342: iload 15
    //   3344: imul
    //   3345: newarray int
    //   3347: astore 38
    //   3349: aload 35
    //   3351: astore 34
    //   3353: iload 4
    //   3355: istore 8
    //   3357: aload 36
    //   3359: astore_1
    //   3360: iload 4
    //   3362: istore 14
    //   3364: iload 4
    //   3366: istore 13
    //   3368: iload 4
    //   3370: istore 12
    //   3372: iload 4
    //   3374: istore 11
    //   3376: aload 43
    //   3378: aload 38
    //   3380: iconst_0
    //   3381: iload 15
    //   3383: iconst_0
    //   3384: iconst_0
    //   3385: iload 15
    //   3387: iload 15
    //   3389: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3392: aload 35
    //   3394: astore 34
    //   3396: iload 4
    //   3398: istore 8
    //   3400: aload 36
    //   3402: astore_1
    //   3403: iload 4
    //   3405: istore 14
    //   3407: iload 4
    //   3409: istore 13
    //   3411: iload 4
    //   3413: istore 12
    //   3415: iload 4
    //   3417: istore 11
    //   3419: iload 15
    //   3421: iload 15
    //   3423: imul
    //   3424: newarray byte
    //   3426: astore 37
    //   3428: aload 35
    //   3430: astore 34
    //   3432: iload 4
    //   3434: istore 8
    //   3436: aload 36
    //   3438: astore_1
    //   3439: iload 4
    //   3441: istore 14
    //   3443: iload 4
    //   3445: istore 13
    //   3447: iload 4
    //   3449: istore 12
    //   3451: iload 4
    //   3453: istore 11
    //   3455: aload 38
    //   3457: aload 37
    //   3459: iload 15
    //   3461: iload 15
    //   3463: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3466: pop
    //   3467: aload 35
    //   3469: astore 34
    //   3471: iload 4
    //   3473: istore 8
    //   3475: aload 36
    //   3477: astore_1
    //   3478: iload 4
    //   3480: istore 14
    //   3482: iload 4
    //   3484: istore 13
    //   3486: iload 4
    //   3488: istore 12
    //   3490: iload 4
    //   3492: istore 11
    //   3494: iload 4
    //   3496: aload 38
    //   3498: aload 37
    //   3500: iload 15
    //   3502: iload 15
    //   3504: iload 17
    //   3506: aload 40
    //   3508: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3511: ior
    //   3512: istore 9
    //   3514: iload 9
    //   3516: istore 4
    //   3518: iload 9
    //   3520: iconst_1
    //   3521: if_icmpeq +136 -> 3657
    //   3524: aload 35
    //   3526: astore 34
    //   3528: iload 9
    //   3530: istore 8
    //   3532: aload 36
    //   3534: astore_1
    //   3535: iload 9
    //   3537: istore 14
    //   3539: iload 9
    //   3541: istore 13
    //   3543: iload 9
    //   3545: istore 12
    //   3547: iload 9
    //   3549: istore 11
    //   3551: aload 43
    //   3553: aload 38
    //   3555: iconst_0
    //   3556: iload 15
    //   3558: iload 16
    //   3560: iload 15
    //   3562: isub
    //   3563: iconst_0
    //   3564: iload 15
    //   3566: iload 15
    //   3568: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3571: aload 35
    //   3573: astore 34
    //   3575: iload 9
    //   3577: istore 8
    //   3579: aload 36
    //   3581: astore_1
    //   3582: iload 9
    //   3584: istore 14
    //   3586: iload 9
    //   3588: istore 13
    //   3590: iload 9
    //   3592: istore 12
    //   3594: iload 9
    //   3596: istore 11
    //   3598: aload 38
    //   3600: aload 37
    //   3602: iload 15
    //   3604: iload 15
    //   3606: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3609: pop
    //   3610: aload 35
    //   3612: astore 34
    //   3614: iload 9
    //   3616: istore 8
    //   3618: aload 36
    //   3620: astore_1
    //   3621: iload 9
    //   3623: istore 14
    //   3625: iload 9
    //   3627: istore 13
    //   3629: iload 9
    //   3631: istore 12
    //   3633: iload 9
    //   3635: istore 11
    //   3637: iload 9
    //   3639: aload 38
    //   3641: aload 37
    //   3643: iload 15
    //   3645: iload 15
    //   3647: iload 17
    //   3649: aload 40
    //   3651: invokestatic 174	yak:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3654: ior
    //   3655: istore 4
    //   3657: aload 35
    //   3659: astore 34
    //   3661: iload 4
    //   3663: istore 8
    //   3665: aload 36
    //   3667: astore_1
    //   3668: iload 4
    //   3670: istore 14
    //   3672: iload 4
    //   3674: istore 13
    //   3676: iload 4
    //   3678: istore 12
    //   3680: iload 4
    //   3682: istore 11
    //   3684: aload 43
    //   3686: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   3689: iload 4
    //   3691: istore 9
    //   3693: aload 35
    //   3695: astore 34
    //   3697: iload 4
    //   3699: istore 8
    //   3701: aload 36
    //   3703: astore_1
    //   3704: iload 4
    //   3706: istore 14
    //   3708: iload 4
    //   3710: istore 13
    //   3712: iload 4
    //   3714: istore 12
    //   3716: iload 4
    //   3718: istore 11
    //   3720: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3723: ifeq +75 -> 3798
    //   3726: aload 35
    //   3728: astore 34
    //   3730: iload 4
    //   3732: istore 8
    //   3734: aload 36
    //   3736: astore_1
    //   3737: iload 4
    //   3739: istore 14
    //   3741: iload 4
    //   3743: istore 13
    //   3745: iload 4
    //   3747: istore 12
    //   3749: iload 4
    //   3751: istore 11
    //   3753: ldc_w 289
    //   3756: iconst_4
    //   3757: ldc_w 390
    //   3760: iconst_3
    //   3761: anewarray 4	java/lang/Object
    //   3764: dup
    //   3765: iconst_0
    //   3766: iload 17
    //   3768: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3771: aastore
    //   3772: dup
    //   3773: iconst_1
    //   3774: iload 4
    //   3776: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3779: aastore
    //   3780: dup
    //   3781: iconst_2
    //   3782: aload 40
    //   3784: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3787: aastore
    //   3788: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3791: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3794: iload 4
    //   3796: istore 9
    //   3798: iload 9
    //   3800: istore 4
    //   3802: goto -1335 -> 2467
    //   3805: astore 35
    //   3807: aload 34
    //   3809: astore_1
    //   3810: aload 34
    //   3812: astore 39
    //   3814: iload 8
    //   3816: istore 13
    //   3818: aload 34
    //   3820: astore 37
    //   3822: iload 8
    //   3824: istore 11
    //   3826: aload 34
    //   3828: astore 38
    //   3830: iload 8
    //   3832: istore 12
    //   3834: aload 34
    //   3836: astore 36
    //   3838: iload 8
    //   3840: istore 9
    //   3842: aload 35
    //   3844: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3847: aload 34
    //   3849: astore_1
    //   3850: aload 34
    //   3852: astore 39
    //   3854: iload 8
    //   3856: istore 13
    //   3858: aload 34
    //   3860: astore 37
    //   3862: iload 8
    //   3864: istore 11
    //   3866: aload 34
    //   3868: astore 38
    //   3870: iload 8
    //   3872: istore 12
    //   3874: aload 34
    //   3876: astore 36
    //   3878: iload 8
    //   3880: istore 9
    //   3882: aload 34
    //   3884: invokevirtual 336	java/io/InputStream:close	()V
    //   3887: iload 8
    //   3889: istore 4
    //   3891: goto -1424 -> 2467
    //   3894: astore_1
    //   3895: aload 35
    //   3897: astore 34
    //   3899: aload_1
    //   3900: astore 35
    //   3902: aload 34
    //   3904: astore_1
    //   3905: aload 34
    //   3907: astore 39
    //   3909: iload 4
    //   3911: istore 9
    //   3913: aload 34
    //   3915: astore 38
    //   3917: iload 4
    //   3919: istore 11
    //   3921: aload 34
    //   3923: astore 36
    //   3925: iload 4
    //   3927: istore 12
    //   3929: aload 34
    //   3931: astore 37
    //   3933: iload 4
    //   3935: istore 8
    //   3937: aload 35
    //   3939: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3942: aload 34
    //   3944: astore_1
    //   3945: aload 34
    //   3947: astore 39
    //   3949: iload 4
    //   3951: istore 9
    //   3953: aload 34
    //   3955: astore 38
    //   3957: iload 4
    //   3959: istore 11
    //   3961: aload 34
    //   3963: astore 36
    //   3965: iload 4
    //   3967: istore 12
    //   3969: aload 34
    //   3971: astore 37
    //   3973: iload 4
    //   3975: istore 8
    //   3977: aload 34
    //   3979: invokevirtual 336	java/io/InputStream:close	()V
    //   3982: aconst_null
    //   3983: astore_1
    //   3984: iload 10
    //   3986: istore 9
    //   3988: goto -3207 -> 781
    //   3991: iconst_0
    //   3992: istore_3
    //   3993: goto -3197 -> 796
    //   3996: iconst_0
    //   3997: istore_2
    //   3998: goto -3115 -> 883
    //   4001: astore_1
    //   4002: aload_1
    //   4003: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4006: iload 4
    //   4008: istore 6
    //   4010: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4013: ifeq -2988 -> 1025
    //   4016: ldc 43
    //   4018: iconst_2
    //   4019: aload_1
    //   4020: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4023: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4026: iload 4
    //   4028: istore 6
    //   4030: goto -3005 -> 1025
    //   4033: astore_1
    //   4034: iconst_0
    //   4035: istore 6
    //   4037: iconst_0
    //   4038: istore 4
    //   4040: aload 38
    //   4042: astore 34
    //   4044: iload 12
    //   4046: istore 7
    //   4048: lload 30
    //   4050: lstore 28
    //   4052: aload_1
    //   4053: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4056: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4059: ifeq +14 -> 4073
    //   4062: ldc_w 289
    //   4065: iconst_2
    //   4066: aload_1
    //   4067: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4070: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4073: iload 7
    //   4075: ifeq +7 -> 4082
    //   4078: invokestatic 253	yak:b	()I
    //   4081: pop
    //   4082: iload 6
    //   4084: ifeq +14 -> 4098
    //   4087: invokestatic 97	aneh:a	()Laneh;
    //   4090: lload 28
    //   4092: ldc_w 289
    //   4095: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   4098: iload 4
    //   4100: istore 6
    //   4102: aload 34
    //   4104: ifnull -3079 -> 1025
    //   4107: aload 34
    //   4109: invokevirtual 336	java/io/InputStream:close	()V
    //   4112: iload 4
    //   4114: istore 6
    //   4116: goto -3091 -> 1025
    //   4119: astore_1
    //   4120: aload_1
    //   4121: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4124: iload 4
    //   4126: istore 6
    //   4128: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4131: ifeq -3106 -> 1025
    //   4134: ldc 43
    //   4136: iconst_2
    //   4137: aload_1
    //   4138: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4141: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4144: iload 4
    //   4146: istore 6
    //   4148: goto -3123 -> 1025
    //   4151: astore_1
    //   4152: ldc2_w 295
    //   4155: lstore 30
    //   4157: iconst_0
    //   4158: istore 6
    //   4160: iconst_0
    //   4161: istore 7
    //   4163: iconst_0
    //   4164: istore 4
    //   4166: aload 36
    //   4168: astore 34
    //   4170: aload 34
    //   4172: astore 5
    //   4174: lload 30
    //   4176: lstore 28
    //   4178: iload 6
    //   4180: istore 9
    //   4182: iload 7
    //   4184: istore 8
    //   4186: aload_1
    //   4187: invokevirtual 264	java/lang/RuntimeException:printStackTrace	()V
    //   4190: aload 34
    //   4192: astore 5
    //   4194: lload 30
    //   4196: lstore 28
    //   4198: iload 6
    //   4200: istore 9
    //   4202: iload 7
    //   4204: istore 8
    //   4206: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4209: ifeq +30 -> 4239
    //   4212: aload 34
    //   4214: astore 5
    //   4216: lload 30
    //   4218: lstore 28
    //   4220: iload 6
    //   4222: istore 9
    //   4224: iload 7
    //   4226: istore 8
    //   4228: ldc_w 289
    //   4231: iconst_2
    //   4232: aload_1
    //   4233: invokevirtual 265	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   4236: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4239: iload 7
    //   4241: ifeq +7 -> 4248
    //   4244: invokestatic 253	yak:b	()I
    //   4247: pop
    //   4248: iload 6
    //   4250: ifeq +14 -> 4264
    //   4253: invokestatic 97	aneh:a	()Laneh;
    //   4256: lload 30
    //   4258: ldc_w 289
    //   4261: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   4264: iload 4
    //   4266: istore 6
    //   4268: aload 34
    //   4270: ifnull -3245 -> 1025
    //   4273: aload 34
    //   4275: invokevirtual 336	java/io/InputStream:close	()V
    //   4278: iload 4
    //   4280: istore 6
    //   4282: goto -3257 -> 1025
    //   4285: astore_1
    //   4286: aload_1
    //   4287: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4290: iload 4
    //   4292: istore 6
    //   4294: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4297: ifeq -3272 -> 1025
    //   4300: ldc 43
    //   4302: iconst_2
    //   4303: aload_1
    //   4304: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4307: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4310: iload 4
    //   4312: istore 6
    //   4314: goto -3289 -> 1025
    //   4317: astore_1
    //   4318: ldc2_w 295
    //   4321: lstore 30
    //   4323: iconst_0
    //   4324: istore 6
    //   4326: iconst_0
    //   4327: istore 7
    //   4329: iconst_0
    //   4330: istore 4
    //   4332: aload 35
    //   4334: astore 34
    //   4336: aload 34
    //   4338: astore 5
    //   4340: lload 30
    //   4342: lstore 28
    //   4344: iload 6
    //   4346: istore 9
    //   4348: iload 7
    //   4350: istore 8
    //   4352: aload_1
    //   4353: invokevirtual 269	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   4356: aload 34
    //   4358: astore 5
    //   4360: lload 30
    //   4362: lstore 28
    //   4364: iload 6
    //   4366: istore 9
    //   4368: iload 7
    //   4370: istore 8
    //   4372: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4375: ifeq +30 -> 4405
    //   4378: aload 34
    //   4380: astore 5
    //   4382: lload 30
    //   4384: lstore 28
    //   4386: iload 6
    //   4388: istore 9
    //   4390: iload 7
    //   4392: istore 8
    //   4394: ldc_w 289
    //   4397: iconst_2
    //   4398: aload_1
    //   4399: invokevirtual 270	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   4402: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4405: iload 7
    //   4407: ifeq +7 -> 4414
    //   4410: invokestatic 253	yak:b	()I
    //   4413: pop
    //   4414: iload 6
    //   4416: ifeq +14 -> 4430
    //   4419: invokestatic 97	aneh:a	()Laneh;
    //   4422: lload 30
    //   4424: ldc_w 289
    //   4427: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   4430: iload 4
    //   4432: istore 6
    //   4434: aload 34
    //   4436: ifnull -3411 -> 1025
    //   4439: aload 34
    //   4441: invokevirtual 336	java/io/InputStream:close	()V
    //   4444: iload 4
    //   4446: istore 6
    //   4448: goto -3423 -> 1025
    //   4451: astore_1
    //   4452: aload_1
    //   4453: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4456: iload 4
    //   4458: istore 6
    //   4460: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4463: ifeq -3438 -> 1025
    //   4466: ldc 43
    //   4468: iconst_2
    //   4469: aload_1
    //   4470: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4473: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4476: iload 4
    //   4478: istore 6
    //   4480: goto -3455 -> 1025
    //   4483: astore_1
    //   4484: ldc2_w 295
    //   4487: lstore 30
    //   4489: iconst_0
    //   4490: istore 6
    //   4492: iconst_0
    //   4493: istore 7
    //   4495: iconst_0
    //   4496: istore 4
    //   4498: aload 37
    //   4500: astore 34
    //   4502: aload 34
    //   4504: astore 5
    //   4506: lload 30
    //   4508: lstore 28
    //   4510: iload 6
    //   4512: istore 9
    //   4514: iload 7
    //   4516: istore 8
    //   4518: aload_1
    //   4519: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   4522: aload 34
    //   4524: astore 5
    //   4526: lload 30
    //   4528: lstore 28
    //   4530: iload 6
    //   4532: istore 9
    //   4534: iload 7
    //   4536: istore 8
    //   4538: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4541: ifeq +30 -> 4571
    //   4544: aload 34
    //   4546: astore 5
    //   4548: lload 30
    //   4550: lstore 28
    //   4552: iload 6
    //   4554: istore 9
    //   4556: iload 7
    //   4558: istore 8
    //   4560: ldc_w 289
    //   4563: iconst_2
    //   4564: aload_1
    //   4565: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4568: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4571: iload 7
    //   4573: ifeq +7 -> 4580
    //   4576: invokestatic 253	yak:b	()I
    //   4579: pop
    //   4580: iload 6
    //   4582: ifeq +14 -> 4596
    //   4585: invokestatic 97	aneh:a	()Laneh;
    //   4588: lload 30
    //   4590: ldc_w 289
    //   4593: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   4596: iload 4
    //   4598: istore 6
    //   4600: aload 34
    //   4602: ifnull -3577 -> 1025
    //   4605: aload 34
    //   4607: invokevirtual 336	java/io/InputStream:close	()V
    //   4610: iload 4
    //   4612: istore 6
    //   4614: goto -3589 -> 1025
    //   4617: astore_1
    //   4618: aload_1
    //   4619: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4622: iload 4
    //   4624: istore 6
    //   4626: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4629: ifeq -3604 -> 1025
    //   4632: ldc 43
    //   4634: iconst_2
    //   4635: aload_1
    //   4636: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4639: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4642: iload 4
    //   4644: istore 6
    //   4646: goto -3621 -> 1025
    //   4649: astore_0
    //   4650: ldc2_w 295
    //   4653: lstore 28
    //   4655: iconst_0
    //   4656: istore 6
    //   4658: iconst_0
    //   4659: istore 7
    //   4661: aconst_null
    //   4662: astore_1
    //   4663: iload 7
    //   4665: ifeq +7 -> 4672
    //   4668: invokestatic 253	yak:b	()I
    //   4671: pop
    //   4672: iload 6
    //   4674: ifeq +14 -> 4688
    //   4677: invokestatic 97	aneh:a	()Laneh;
    //   4680: lload 28
    //   4682: ldc_w 289
    //   4685: invokevirtual 256	aneh:a	(JLjava/lang/String;)V
    //   4688: aload_1
    //   4689: ifnull +7 -> 4696
    //   4692: aload_1
    //   4693: invokevirtual 336	java/io/InputStream:close	()V
    //   4696: aload_0
    //   4697: athrow
    //   4698: astore_1
    //   4699: aload_1
    //   4700: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4703: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4706: ifeq -10 -> 4696
    //   4709: ldc 43
    //   4711: iconst_2
    //   4712: aload_1
    //   4713: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4716: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4719: goto -23 -> 4696
    //   4722: astore_0
    //   4723: ldc2_w 295
    //   4726: lstore 28
    //   4728: iconst_0
    //   4729: istore 6
    //   4731: iconst_0
    //   4732: istore 7
    //   4734: aload 34
    //   4736: astore_1
    //   4737: goto -74 -> 4663
    //   4740: astore_0
    //   4741: iload 7
    //   4743: istore 6
    //   4745: iconst_0
    //   4746: istore 7
    //   4748: aload 34
    //   4750: astore_1
    //   4751: goto -88 -> 4663
    //   4754: astore_0
    //   4755: iconst_0
    //   4756: istore 7
    //   4758: aload 34
    //   4760: astore_1
    //   4761: goto -98 -> 4663
    //   4764: astore_0
    //   4765: iload 12
    //   4767: istore 7
    //   4769: aload 34
    //   4771: astore_1
    //   4772: goto -109 -> 4663
    //   4775: astore_0
    //   4776: iload 8
    //   4778: istore 7
    //   4780: aload 34
    //   4782: astore_1
    //   4783: goto -120 -> 4663
    //   4786: astore_0
    //   4787: goto -124 -> 4663
    //   4790: astore_0
    //   4791: aconst_null
    //   4792: astore_1
    //   4793: goto -130 -> 4663
    //   4796: astore_0
    //   4797: aconst_null
    //   4798: astore_1
    //   4799: goto -136 -> 4663
    //   4802: astore_0
    //   4803: aload 34
    //   4805: astore_1
    //   4806: goto -143 -> 4663
    //   4809: astore_0
    //   4810: aload 5
    //   4812: astore_1
    //   4813: iload 9
    //   4815: istore 6
    //   4817: iload 8
    //   4819: istore 7
    //   4821: goto -158 -> 4663
    //   4824: astore_1
    //   4825: iload 8
    //   4827: istore 6
    //   4829: iconst_0
    //   4830: istore 7
    //   4832: iconst_0
    //   4833: istore 4
    //   4835: lload 28
    //   4837: lstore 30
    //   4839: goto -337 -> 4502
    //   4842: astore_1
    //   4843: iconst_0
    //   4844: istore 7
    //   4846: iconst_0
    //   4847: istore 4
    //   4849: lload 28
    //   4851: lstore 30
    //   4853: goto -351 -> 4502
    //   4856: astore_1
    //   4857: iload 17
    //   4859: istore 7
    //   4861: iload 16
    //   4863: istore 4
    //   4865: lload 28
    //   4867: lstore 30
    //   4869: goto -367 -> 4502
    //   4872: astore_1
    //   4873: iconst_0
    //   4874: istore 7
    //   4876: aconst_null
    //   4877: astore 34
    //   4879: iconst_0
    //   4880: istore 4
    //   4882: lload 28
    //   4884: lstore 30
    //   4886: goto -384 -> 4502
    //   4889: astore_1
    //   4890: aconst_null
    //   4891: astore 34
    //   4893: iconst_0
    //   4894: istore 4
    //   4896: lload 28
    //   4898: lstore 30
    //   4900: goto -398 -> 4502
    //   4903: astore_1
    //   4904: aload 37
    //   4906: astore 34
    //   4908: iconst_0
    //   4909: istore 4
    //   4911: lload 28
    //   4913: lstore 30
    //   4915: goto -413 -> 4502
    //   4918: astore_1
    //   4919: aconst_null
    //   4920: astore 34
    //   4922: iload 14
    //   4924: istore 4
    //   4926: lload 28
    //   4928: lstore 30
    //   4930: goto -428 -> 4502
    //   4933: astore_1
    //   4934: aload 39
    //   4936: astore 34
    //   4938: iload 13
    //   4940: istore 4
    //   4942: lload 28
    //   4944: lstore 30
    //   4946: goto -444 -> 4502
    //   4949: astore_1
    //   4950: iload 12
    //   4952: istore 4
    //   4954: aload 35
    //   4956: astore 34
    //   4958: lload 28
    //   4960: lstore 30
    //   4962: goto -460 -> 4502
    //   4965: astore_1
    //   4966: aload 35
    //   4968: astore 34
    //   4970: lload 28
    //   4972: lstore 30
    //   4974: goto -472 -> 4502
    //   4977: astore_1
    //   4978: aconst_null
    //   4979: astore 34
    //   4981: lload 28
    //   4983: lstore 30
    //   4985: goto -483 -> 4502
    //   4988: astore_1
    //   4989: aload 39
    //   4991: astore 34
    //   4993: iload 9
    //   4995: istore 4
    //   4997: lload 28
    //   4999: lstore 30
    //   5001: goto -499 -> 4502
    //   5004: astore_1
    //   5005: aconst_null
    //   5006: astore 34
    //   5008: lload 28
    //   5010: lstore 30
    //   5012: goto -510 -> 4502
    //   5015: astore_1
    //   5016: aconst_null
    //   5017: astore 34
    //   5019: lload 28
    //   5021: lstore 30
    //   5023: goto -521 -> 4502
    //   5026: astore 5
    //   5028: aload_1
    //   5029: astore 34
    //   5031: aload 5
    //   5033: astore_1
    //   5034: lload 28
    //   5036: lstore 30
    //   5038: goto -536 -> 4502
    //   5041: astore_1
    //   5042: iload 9
    //   5044: istore 6
    //   5046: iconst_0
    //   5047: istore 7
    //   5049: iconst_0
    //   5050: istore 4
    //   5052: lload 28
    //   5054: lstore 30
    //   5056: goto -720 -> 4336
    //   5059: astore_1
    //   5060: iconst_0
    //   5061: istore 7
    //   5063: iconst_0
    //   5064: istore 4
    //   5066: lload 28
    //   5068: lstore 30
    //   5070: goto -734 -> 4336
    //   5073: astore_1
    //   5074: iload 13
    //   5076: istore 7
    //   5078: iload 9
    //   5080: istore 4
    //   5082: lload 28
    //   5084: lstore 30
    //   5086: goto -750 -> 4336
    //   5089: astore_1
    //   5090: iload 4
    //   5092: istore 8
    //   5094: iload 7
    //   5096: istore 4
    //   5098: lload 28
    //   5100: lstore 30
    //   5102: iload 8
    //   5104: istore 7
    //   5106: goto -770 -> 4336
    //   5109: astore_1
    //   5110: iload 4
    //   5112: istore 8
    //   5114: iload 7
    //   5116: istore 4
    //   5118: lload 28
    //   5120: lstore 30
    //   5122: iload 8
    //   5124: istore 7
    //   5126: goto -790 -> 4336
    //   5129: astore_1
    //   5130: iconst_0
    //   5131: istore 7
    //   5133: aconst_null
    //   5134: astore 34
    //   5136: iconst_0
    //   5137: istore 4
    //   5139: lload 28
    //   5141: lstore 30
    //   5143: goto -807 -> 4336
    //   5146: astore_1
    //   5147: aconst_null
    //   5148: astore 34
    //   5150: iconst_0
    //   5151: istore 4
    //   5153: lload 28
    //   5155: lstore 30
    //   5157: goto -821 -> 4336
    //   5160: astore_1
    //   5161: aload 38
    //   5163: astore 34
    //   5165: iconst_0
    //   5166: istore 4
    //   5168: lload 28
    //   5170: lstore 30
    //   5172: goto -836 -> 4336
    //   5175: astore_1
    //   5176: aconst_null
    //   5177: astore 34
    //   5179: iload 13
    //   5181: istore 4
    //   5183: lload 28
    //   5185: lstore 30
    //   5187: goto -851 -> 4336
    //   5190: astore_1
    //   5191: aload 37
    //   5193: astore 34
    //   5195: iload 11
    //   5197: istore 4
    //   5199: lload 28
    //   5201: lstore 30
    //   5203: goto -867 -> 4336
    //   5206: astore_1
    //   5207: iload 11
    //   5209: istore 4
    //   5211: lload 28
    //   5213: lstore 30
    //   5215: goto -879 -> 4336
    //   5218: astore_1
    //   5219: lload 28
    //   5221: lstore 30
    //   5223: goto -887 -> 4336
    //   5226: astore_1
    //   5227: aconst_null
    //   5228: astore 34
    //   5230: lload 28
    //   5232: lstore 30
    //   5234: goto -898 -> 4336
    //   5237: astore_1
    //   5238: aload 38
    //   5240: astore 34
    //   5242: iload 11
    //   5244: istore 4
    //   5246: lload 28
    //   5248: lstore 30
    //   5250: goto -914 -> 4336
    //   5253: astore_1
    //   5254: aconst_null
    //   5255: astore 34
    //   5257: lload 28
    //   5259: lstore 30
    //   5261: goto -925 -> 4336
    //   5264: astore_1
    //   5265: aconst_null
    //   5266: astore 34
    //   5268: lload 28
    //   5270: lstore 30
    //   5272: goto -936 -> 4336
    //   5275: astore 5
    //   5277: aload_1
    //   5278: astore 34
    //   5280: aload 5
    //   5282: astore_1
    //   5283: lload 28
    //   5285: lstore 30
    //   5287: goto -951 -> 4336
    //   5290: astore_1
    //   5291: iload 10
    //   5293: istore 6
    //   5295: iconst_0
    //   5296: istore 7
    //   5298: iconst_0
    //   5299: istore 4
    //   5301: lload 28
    //   5303: lstore 30
    //   5305: goto -1135 -> 4170
    //   5308: astore_1
    //   5309: iconst_0
    //   5310: istore 7
    //   5312: iconst_0
    //   5313: istore 4
    //   5315: lload 28
    //   5317: lstore 30
    //   5319: goto -1149 -> 4170
    //   5322: astore_1
    //   5323: iload 14
    //   5325: istore 7
    //   5327: iload 11
    //   5329: istore 4
    //   5331: lload 28
    //   5333: lstore 30
    //   5335: goto -1165 -> 4170
    //   5338: astore_1
    //   5339: iload 4
    //   5341: istore 8
    //   5343: iload 7
    //   5345: istore 4
    //   5347: lload 28
    //   5349: lstore 30
    //   5351: iload 8
    //   5353: istore 7
    //   5355: goto -1185 -> 4170
    //   5358: astore_1
    //   5359: iload 4
    //   5361: istore 8
    //   5363: iload 7
    //   5365: istore 4
    //   5367: lload 28
    //   5369: lstore 30
    //   5371: iload 8
    //   5373: istore 7
    //   5375: goto -1205 -> 4170
    //   5378: astore_1
    //   5379: iconst_0
    //   5380: istore 7
    //   5382: aconst_null
    //   5383: astore 34
    //   5385: iconst_0
    //   5386: istore 4
    //   5388: lload 28
    //   5390: lstore 30
    //   5392: goto -1222 -> 4170
    //   5395: astore_1
    //   5396: aconst_null
    //   5397: astore 34
    //   5399: iconst_0
    //   5400: istore 4
    //   5402: lload 28
    //   5404: lstore 30
    //   5406: goto -1236 -> 4170
    //   5409: astore_1
    //   5410: aload 39
    //   5412: astore 34
    //   5414: iconst_0
    //   5415: istore 4
    //   5417: lload 28
    //   5419: lstore 30
    //   5421: goto -1251 -> 4170
    //   5424: astore_1
    //   5425: aconst_null
    //   5426: astore 34
    //   5428: iload 12
    //   5430: istore 4
    //   5432: lload 28
    //   5434: lstore 30
    //   5436: goto -1266 -> 4170
    //   5439: astore_1
    //   5440: aload 38
    //   5442: astore 34
    //   5444: iload 12
    //   5446: istore 4
    //   5448: lload 28
    //   5450: lstore 30
    //   5452: goto -1282 -> 4170
    //   5455: astore_1
    //   5456: iload 9
    //   5458: istore 4
    //   5460: aload 37
    //   5462: astore 34
    //   5464: lload 28
    //   5466: lstore 30
    //   5468: goto -1298 -> 4170
    //   5471: astore_1
    //   5472: aload 37
    //   5474: astore 34
    //   5476: lload 28
    //   5478: lstore 30
    //   5480: goto -1310 -> 4170
    //   5483: astore_1
    //   5484: aconst_null
    //   5485: astore 34
    //   5487: lload 28
    //   5489: lstore 30
    //   5491: goto -1321 -> 4170
    //   5494: astore_1
    //   5495: aload 36
    //   5497: astore 34
    //   5499: iload 12
    //   5501: istore 4
    //   5503: lload 28
    //   5505: lstore 30
    //   5507: goto -1337 -> 4170
    //   5510: astore_1
    //   5511: aconst_null
    //   5512: astore 34
    //   5514: lload 28
    //   5516: lstore 30
    //   5518: goto -1348 -> 4170
    //   5521: astore_1
    //   5522: aconst_null
    //   5523: astore 34
    //   5525: lload 28
    //   5527: lstore 30
    //   5529: goto -1359 -> 4170
    //   5532: astore 5
    //   5534: aload_1
    //   5535: astore 34
    //   5537: aload 5
    //   5539: astore_1
    //   5540: lload 28
    //   5542: lstore 30
    //   5544: goto -1374 -> 4170
    //   5547: astore_1
    //   5548: iload 11
    //   5550: istore 6
    //   5552: iconst_0
    //   5553: istore 4
    //   5555: iload 12
    //   5557: istore 7
    //   5559: goto -1507 -> 4052
    //   5562: astore_1
    //   5563: iconst_0
    //   5564: istore 4
    //   5566: iload 12
    //   5568: istore 7
    //   5570: goto -1518 -> 4052
    //   5573: astore_1
    //   5574: iload 15
    //   5576: istore 7
    //   5578: iload 10
    //   5580: istore 4
    //   5582: goto -1530 -> 4052
    //   5585: astore_1
    //   5586: iload 4
    //   5588: istore 8
    //   5590: iload 7
    //   5592: istore 4
    //   5594: iload 8
    //   5596: istore 7
    //   5598: goto -1546 -> 4052
    //   5601: astore_1
    //   5602: iload 4
    //   5604: istore 8
    //   5606: iload 7
    //   5608: istore 4
    //   5610: iload 8
    //   5612: istore 7
    //   5614: goto -1562 -> 4052
    //   5617: astore_1
    //   5618: aconst_null
    //   5619: astore 34
    //   5621: iconst_0
    //   5622: istore 4
    //   5624: iload 12
    //   5626: istore 7
    //   5628: goto -1576 -> 4052
    //   5631: astore_1
    //   5632: aconst_null
    //   5633: astore 34
    //   5635: iconst_0
    //   5636: istore 4
    //   5638: goto -1586 -> 4052
    //   5641: astore_1
    //   5642: aload 36
    //   5644: astore 34
    //   5646: iconst_0
    //   5647: istore 4
    //   5649: goto -1597 -> 4052
    //   5652: astore_1
    //   5653: aconst_null
    //   5654: astore 34
    //   5656: iload 11
    //   5658: istore 4
    //   5660: goto -1608 -> 4052
    //   5663: astore_1
    //   5664: aload 36
    //   5666: astore 34
    //   5668: iload 9
    //   5670: istore 4
    //   5672: goto -1620 -> 4052
    //   5675: astore_1
    //   5676: iload 8
    //   5678: istore 4
    //   5680: aload 36
    //   5682: astore 34
    //   5684: goto -1632 -> 4052
    //   5687: astore_1
    //   5688: aload 36
    //   5690: astore 34
    //   5692: goto -1640 -> 4052
    //   5695: astore_1
    //   5696: aconst_null
    //   5697: astore 34
    //   5699: goto -1647 -> 4052
    //   5702: astore_1
    //   5703: aload 37
    //   5705: astore 34
    //   5707: iload 8
    //   5709: istore 4
    //   5711: goto -1659 -> 4052
    //   5714: astore_1
    //   5715: aconst_null
    //   5716: astore 34
    //   5718: goto -1666 -> 4052
    //   5721: astore_1
    //   5722: aconst_null
    //   5723: astore 34
    //   5725: goto -1673 -> 4052
    //   5728: astore 5
    //   5730: aload_1
    //   5731: astore 34
    //   5733: aload 5
    //   5735: astore_1
    //   5736: goto -1684 -> 4052
    //   5739: astore 35
    //   5741: aconst_null
    //   5742: astore 34
    //   5744: goto -1842 -> 3902
    //   5747: astore 35
    //   5749: aconst_null
    //   5750: astore 34
    //   5752: goto -1850 -> 3902
    //   5755: astore 35
    //   5757: aconst_null
    //   5758: astore 34
    //   5760: iload 13
    //   5762: istore 4
    //   5764: goto -2803 -> 2961
    //   5767: astore 35
    //   5769: aconst_null
    //   5770: astore 34
    //   5772: goto -2811 -> 2961
    //   5775: astore_1
    //   5776: iconst_0
    //   5777: istore 4
    //   5779: iload 8
    //   5781: istore 7
    //   5783: iload 13
    //   5785: istore 8
    //   5787: goto -4553 -> 1234
    //   5790: astore_1
    //   5791: iload 8
    //   5793: istore 7
    //   5795: iload 16
    //   5797: istore 8
    //   5799: goto -4565 -> 1234
    //   5802: astore_1
    //   5803: iload 7
    //   5805: istore 9
    //   5807: iload 8
    //   5809: istore 7
    //   5811: iload 9
    //   5813: istore 8
    //   5815: goto -4581 -> 1234
    //   5818: astore_1
    //   5819: iload 7
    //   5821: istore 9
    //   5823: iload 8
    //   5825: istore 7
    //   5827: iload 9
    //   5829: istore 8
    //   5831: goto -4597 -> 1234
    //   5834: astore_1
    //   5835: iconst_0
    //   5836: istore 4
    //   5838: iload 8
    //   5840: istore 7
    //   5842: iload 19
    //   5844: istore 8
    //   5846: goto -4744 -> 1102
    //   5849: astore_1
    //   5850: iload 8
    //   5852: istore 7
    //   5854: iload 17
    //   5856: istore 8
    //   5858: goto -4756 -> 1102
    //   5861: astore_1
    //   5862: iload 7
    //   5864: istore 9
    //   5866: iload 8
    //   5868: istore 7
    //   5870: iload 9
    //   5872: istore 8
    //   5874: goto -4772 -> 1102
    //   5877: astore_1
    //   5878: iload 7
    //   5880: istore 9
    //   5882: iload 8
    //   5884: istore 7
    //   5886: iload 9
    //   5888: istore 8
    //   5890: goto -4788 -> 1102
    //   5893: iload 4
    //   5895: istore 8
    //   5897: goto -3025 -> 2872
    //   5900: iload 10
    //   5902: istore 9
    //   5904: aload 36
    //   5906: astore_1
    //   5907: goto -5126 -> 781
    //   5910: goto -3443 -> 2467
    //   5913: goto -3498 -> 2415
    //   5916: goto -3449 -> 2467
    //   5919: iconst_0
    //   5920: istore 7
    //   5922: goto -4352 -> 1570
    //   5925: iload 4
    //   5927: istore 10
    //   5929: goto -4381 -> 1548
    //   5932: goto -5178 -> 754
    //   5935: iconst_0
    //   5936: istore 4
    //   5938: goto -5487 -> 451
    //   5941: iload 4
    //   5943: istore 8
    //   5945: goto -5533 -> 412
    //   5948: iconst_0
    //   5949: istore 9
    //   5951: iconst_0
    //   5952: istore 7
    //   5954: iload 4
    //   5956: istore 8
    //   5958: iload 9
    //   5960: istore 4
    //   5962: goto -5200 -> 762
    //   5965: ldc2_w 295
    //   5968: lstore 28
    //   5970: iconst_0
    //   5971: istore 6
    //   5973: iconst_0
    //   5974: istore 4
    //   5976: aload 34
    //   5978: astore_1
    //   5979: goto -4995 -> 984
    //   5982: iload 4
    //   5984: iconst_2
    //   5985: iand
    //   5986: iconst_2
    //   5987: if_icmpne -1991 -> 3996
    //   5990: iconst_1
    //   5991: istore_2
    //   5992: goto -5109 -> 883
    //   5995: aload 34
    //   5997: astore_1
    //   5998: iload 7
    //   6000: istore 9
    //   6002: iload 4
    //   6004: istore 7
    //   6006: iload 8
    //   6008: istore 4
    //   6010: goto -5229 -> 781
    //   6013: astore_1
    //   6014: iconst_0
    //   6015: istore 8
    //   6017: iload 4
    //   6019: istore 7
    //   6021: iload 8
    //   6023: istore 4
    //   6025: iload 13
    //   6027: istore 8
    //   6029: goto -4795 -> 1234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6032	0	paramUri	Uri
    //   0	6032	1	paramContext	Context
    //   0	6032	2	paramBoolean1	boolean
    //   0	6032	3	paramBoolean2	boolean
    //   0	6032	4	paramInt	int
    //   0	6032	5	paramSparseArray	SparseArray<Object>
    //   113	5859	6	i	int
    //   95	5925	7	j	int
    //   101	5927	8	k	int
    //   104	5897	9	m	int
    //   107	5821	10	n	int
    //   110	5547	11	i1	int
    //   89	5536	12	i2	int
    //   53	5973	13	i3	int
    //   59	5265	14	i4	int
    //   62	5513	15	i5	int
    //   68	5728	16	i6	int
    //   71	5784	17	i7	int
    //   65	411	18	i8	int
    //   74	5769	19	i9	int
    //   56	1720	20	i10	int
    //   92	1468	21	i11	int
    //   98	181	22	i12	int
    //   225	50	23	i13	int
    //   219	48	24	i14	int
    //   231	52	25	i15	int
    //   234	86	26	i16	int
    //   222	49	27	i17	int
    //   190	5779	28	l1	long
    //   118	5425	30	l2	long
    //   17	1039	32	l3	long
    //   77	5919	34	localObject1	Object
    //   130	2577	35	localObject2	Object
    //   2885	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2959	768	35	localObject3	Object
    //   3805	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3900	1067	35	localContext	Context
    //   5739	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5747	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5755	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5767	1	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   126	5779	36	localObject4	Object
    //   134	5570	37	localObject5	Object
    //   122	5319	38	localObject6	Object
    //   80	5331	39	localObject7	Object
    //   86	3697	40	localStringBuilder	StringBuilder
    //   83	2708	41	localObject8	Object
    //   140	2933	42	localContentResolver	android.content.ContentResolver
    //   1644	2041	43	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   336	377	1086	java/lang/OutOfMemoryError
    //   381	401	1086	java/lang/OutOfMemoryError
    //   1489	1497	1497	java/io/IOException
    //   1605	1613	2885	java/lang/OutOfMemoryError
    //   1636	1646	2885	java/lang/OutOfMemoryError
    //   1669	1675	2885	java/lang/OutOfMemoryError
    //   1698	1742	2885	java/lang/OutOfMemoryError
    //   1765	1770	2885	java/lang/OutOfMemoryError
    //   1784	1795	2885	java/lang/OutOfMemoryError
    //   1907	1915	2953	java/lang/OutOfMemoryError
    //   1954	1961	2953	java/lang/OutOfMemoryError
    //   2000	2006	2953	java/lang/OutOfMemoryError
    //   2045	2073	2953	java/lang/OutOfMemoryError
    //   2112	2117	2953	java/lang/OutOfMemoryError
    //   3072	3080	3805	java/lang/OutOfMemoryError
    //   3123	3130	3805	java/lang/OutOfMemoryError
    //   3173	3179	3805	java/lang/OutOfMemoryError
    //   3222	3250	3805	java/lang/OutOfMemoryError
    //   3293	3298	3805	java/lang/OutOfMemoryError
    //   3340	3349	3805	java/lang/OutOfMemoryError
    //   3376	3392	3805	java/lang/OutOfMemoryError
    //   3419	3428	3805	java/lang/OutOfMemoryError
    //   3455	3467	3805	java/lang/OutOfMemoryError
    //   3494	3514	3805	java/lang/OutOfMemoryError
    //   3551	3571	3805	java/lang/OutOfMemoryError
    //   3598	3610	3805	java/lang/OutOfMemoryError
    //   3637	3657	3805	java/lang/OutOfMemoryError
    //   3684	3689	3805	java/lang/OutOfMemoryError
    //   3720	3726	3805	java/lang/OutOfMemoryError
    //   3753	3794	3805	java/lang/OutOfMemoryError
    //   2535	2543	3894	java/lang/OutOfMemoryError
    //   2582	2592	3894	java/lang/OutOfMemoryError
    //   2631	2637	3894	java/lang/OutOfMemoryError
    //   2676	2704	3894	java/lang/OutOfMemoryError
    //   2743	2748	3894	java/lang/OutOfMemoryError
    //   1017	1021	4001	java/io/IOException
    //   136	142	4033	java/io/IOException
    //   158	166	4033	java/io/IOException
    //   187	192	4033	java/io/IOException
    //   4107	4112	4119	java/io/IOException
    //   136	142	4151	java/lang/RuntimeException
    //   158	166	4151	java/lang/RuntimeException
    //   187	192	4151	java/lang/RuntimeException
    //   4273	4278	4285	java/io/IOException
    //   136	142	4317	java/lang/UnsatisfiedLinkError
    //   158	166	4317	java/lang/UnsatisfiedLinkError
    //   187	192	4317	java/lang/UnsatisfiedLinkError
    //   4439	4444	4451	java/io/IOException
    //   136	142	4483	java/lang/Throwable
    //   158	166	4483	java/lang/Throwable
    //   187	192	4483	java/lang/Throwable
    //   4605	4610	4617	java/io/IOException
    //   136	142	4649	finally
    //   158	166	4649	finally
    //   4692	4696	4698	java/io/IOException
    //   187	192	4722	finally
    //   204	218	4740	finally
    //   260	266	4740	finally
    //   286	319	4740	finally
    //   323	332	4754	finally
    //   336	377	4754	finally
    //   381	401	4754	finally
    //   412	436	4754	finally
    //   444	448	4754	finally
    //   1381	1410	4754	finally
    //   479	495	4764	finally
    //   499	505	4764	finally
    //   509	550	4764	finally
    //   554	563	4764	finally
    //   567	579	4764	finally
    //   601	607	4764	finally
    //   611	617	4764	finally
    //   626	642	4764	finally
    //   685	691	4764	finally
    //   727	754	4764	finally
    //   758	762	4764	finally
    //   1138	1142	4764	finally
    //   1178	1184	4764	finally
    //   1220	1231	4764	finally
    //   1270	1274	4764	finally
    //   1310	1316	4764	finally
    //   1352	1363	4764	finally
    //   816	825	4775	finally
    //   832	841	4775	finally
    //   848	856	4775	finally
    //   863	880	4775	finally
    //   899	910	4775	finally
    //   917	923	4775	finally
    //   930	984	4775	finally
    //   1425	1432	4775	finally
    //   1439	1446	4775	finally
    //   1531	1541	4775	finally
    //   1563	1567	4775	finally
    //   1573	1589	4786	finally
    //   1592	1598	4786	finally
    //   1605	1613	4786	finally
    //   1636	1646	4786	finally
    //   1669	1675	4786	finally
    //   1698	1742	4786	finally
    //   1765	1770	4786	finally
    //   1784	1795	4786	finally
    //   1829	1838	4786	finally
    //   1907	1915	4786	finally
    //   1954	1961	4786	finally
    //   2000	2006	4786	finally
    //   2045	2073	4786	finally
    //   2112	2117	4786	finally
    //   2479	2488	4786	finally
    //   2496	2505	4786	finally
    //   2516	2532	4786	finally
    //   2535	2543	4786	finally
    //   2582	2592	4786	finally
    //   2631	2637	4786	finally
    //   2676	2704	4786	finally
    //   2743	2748	4786	finally
    //   2906	2911	4786	finally
    //   2930	2935	4786	finally
    //   2996	3001	4786	finally
    //   3036	3041	4786	finally
    //   3072	3080	4786	finally
    //   3123	3130	4786	finally
    //   3173	3179	4786	finally
    //   3222	3250	4786	finally
    //   3293	3298	4786	finally
    //   3340	3349	4786	finally
    //   3376	3392	4786	finally
    //   3419	3428	4786	finally
    //   3455	3467	4786	finally
    //   3494	3514	4786	finally
    //   3551	3571	4786	finally
    //   3598	3610	4786	finally
    //   3637	3657	4786	finally
    //   3684	3689	4786	finally
    //   3720	3726	4786	finally
    //   3753	3794	4786	finally
    //   3842	3847	4786	finally
    //   3882	3887	4786	finally
    //   3937	3942	4786	finally
    //   3977	3982	4786	finally
    //   2154	2162	4790	finally
    //   2182	2197	4790	finally
    //   2217	2226	4790	finally
    //   2246	2257	4790	finally
    //   2277	2296	4790	finally
    //   2322	2341	4790	finally
    //   2361	2372	4790	finally
    //   2392	2408	4790	finally
    //   2415	2467	4790	finally
    //   2753	2810	4796	finally
    //   2821	2868	4796	finally
    //   4052	4073	4802	finally
    //   4186	4190	4809	finally
    //   4206	4212	4809	finally
    //   4228	4239	4809	finally
    //   4352	4356	4809	finally
    //   4372	4378	4809	finally
    //   4394	4405	4809	finally
    //   4518	4522	4809	finally
    //   4538	4544	4809	finally
    //   4560	4571	4809	finally
    //   204	218	4824	java/lang/Throwable
    //   260	266	4824	java/lang/Throwable
    //   286	319	4824	java/lang/Throwable
    //   323	332	4842	java/lang/Throwable
    //   1381	1410	4842	java/lang/Throwable
    //   1138	1142	4856	java/lang/Throwable
    //   1178	1184	4856	java/lang/Throwable
    //   1220	1231	4856	java/lang/Throwable
    //   1270	1274	4856	java/lang/Throwable
    //   1310	1316	4856	java/lang/Throwable
    //   1352	1363	4856	java/lang/Throwable
    //   1425	1432	4872	java/lang/Throwable
    //   1439	1446	4872	java/lang/Throwable
    //   1531	1541	4872	java/lang/Throwable
    //   1563	1567	4872	java/lang/Throwable
    //   1573	1589	4889	java/lang/Throwable
    //   1592	1598	4889	java/lang/Throwable
    //   1605	1613	4889	java/lang/Throwable
    //   1784	1795	4889	java/lang/Throwable
    //   1636	1646	4903	java/lang/Throwable
    //   1669	1675	4903	java/lang/Throwable
    //   1698	1742	4903	java/lang/Throwable
    //   1765	1770	4903	java/lang/Throwable
    //   2906	2911	4903	java/lang/Throwable
    //   2930	2935	4903	java/lang/Throwable
    //   1829	1838	4918	java/lang/Throwable
    //   1907	1915	4918	java/lang/Throwable
    //   3072	3080	4918	java/lang/Throwable
    //   3340	3349	4918	java/lang/Throwable
    //   3376	3392	4918	java/lang/Throwable
    //   3419	3428	4918	java/lang/Throwable
    //   3455	3467	4918	java/lang/Throwable
    //   3494	3514	4918	java/lang/Throwable
    //   3551	3571	4918	java/lang/Throwable
    //   3598	3610	4918	java/lang/Throwable
    //   3637	3657	4918	java/lang/Throwable
    //   3684	3689	4918	java/lang/Throwable
    //   3720	3726	4918	java/lang/Throwable
    //   3753	3794	4918	java/lang/Throwable
    //   1954	1961	4933	java/lang/Throwable
    //   2000	2006	4933	java/lang/Throwable
    //   2045	2073	4933	java/lang/Throwable
    //   2112	2117	4933	java/lang/Throwable
    //   2996	3001	4933	java/lang/Throwable
    //   3036	3041	4933	java/lang/Throwable
    //   3123	3130	4933	java/lang/Throwable
    //   3173	3179	4933	java/lang/Throwable
    //   3222	3250	4933	java/lang/Throwable
    //   3293	3298	4933	java/lang/Throwable
    //   3842	3847	4933	java/lang/Throwable
    //   3882	3887	4933	java/lang/Throwable
    //   2154	2162	4949	java/lang/Throwable
    //   2182	2197	4949	java/lang/Throwable
    //   2217	2226	4949	java/lang/Throwable
    //   2246	2257	4949	java/lang/Throwable
    //   2277	2296	4949	java/lang/Throwable
    //   2322	2341	4949	java/lang/Throwable
    //   2361	2372	4949	java/lang/Throwable
    //   2392	2408	4949	java/lang/Throwable
    //   2415	2467	4965	java/lang/Throwable
    //   2479	2488	4977	java/lang/Throwable
    //   2496	2505	4977	java/lang/Throwable
    //   2516	2532	4977	java/lang/Throwable
    //   2535	2543	4977	java/lang/Throwable
    //   2582	2592	4988	java/lang/Throwable
    //   2631	2637	4988	java/lang/Throwable
    //   2676	2704	4988	java/lang/Throwable
    //   2743	2748	4988	java/lang/Throwable
    //   3937	3942	4988	java/lang/Throwable
    //   3977	3982	4988	java/lang/Throwable
    //   2753	2810	5004	java/lang/Throwable
    //   2821	2868	5015	java/lang/Throwable
    //   816	825	5026	java/lang/Throwable
    //   832	841	5026	java/lang/Throwable
    //   848	856	5026	java/lang/Throwable
    //   863	880	5026	java/lang/Throwable
    //   899	910	5026	java/lang/Throwable
    //   917	923	5026	java/lang/Throwable
    //   930	984	5026	java/lang/Throwable
    //   204	218	5041	java/lang/UnsatisfiedLinkError
    //   260	266	5041	java/lang/UnsatisfiedLinkError
    //   286	319	5041	java/lang/UnsatisfiedLinkError
    //   323	332	5059	java/lang/UnsatisfiedLinkError
    //   336	377	5059	java/lang/UnsatisfiedLinkError
    //   381	401	5059	java/lang/UnsatisfiedLinkError
    //   412	436	5059	java/lang/UnsatisfiedLinkError
    //   444	448	5059	java/lang/UnsatisfiedLinkError
    //   1381	1410	5059	java/lang/UnsatisfiedLinkError
    //   479	495	5073	java/lang/UnsatisfiedLinkError
    //   685	691	5073	java/lang/UnsatisfiedLinkError
    //   727	754	5073	java/lang/UnsatisfiedLinkError
    //   1138	1142	5073	java/lang/UnsatisfiedLinkError
    //   1178	1184	5073	java/lang/UnsatisfiedLinkError
    //   1220	1231	5073	java/lang/UnsatisfiedLinkError
    //   1270	1274	5073	java/lang/UnsatisfiedLinkError
    //   1310	1316	5073	java/lang/UnsatisfiedLinkError
    //   1352	1363	5073	java/lang/UnsatisfiedLinkError
    //   499	505	5089	java/lang/UnsatisfiedLinkError
    //   509	550	5089	java/lang/UnsatisfiedLinkError
    //   554	563	5089	java/lang/UnsatisfiedLinkError
    //   567	579	5089	java/lang/UnsatisfiedLinkError
    //   601	607	5089	java/lang/UnsatisfiedLinkError
    //   611	617	5089	java/lang/UnsatisfiedLinkError
    //   626	642	5089	java/lang/UnsatisfiedLinkError
    //   758	762	5109	java/lang/UnsatisfiedLinkError
    //   1425	1432	5129	java/lang/UnsatisfiedLinkError
    //   1439	1446	5129	java/lang/UnsatisfiedLinkError
    //   1531	1541	5129	java/lang/UnsatisfiedLinkError
    //   1563	1567	5129	java/lang/UnsatisfiedLinkError
    //   1573	1589	5146	java/lang/UnsatisfiedLinkError
    //   1592	1598	5146	java/lang/UnsatisfiedLinkError
    //   1605	1613	5146	java/lang/UnsatisfiedLinkError
    //   1784	1795	5146	java/lang/UnsatisfiedLinkError
    //   1636	1646	5160	java/lang/UnsatisfiedLinkError
    //   1669	1675	5160	java/lang/UnsatisfiedLinkError
    //   1698	1742	5160	java/lang/UnsatisfiedLinkError
    //   1765	1770	5160	java/lang/UnsatisfiedLinkError
    //   2906	2911	5160	java/lang/UnsatisfiedLinkError
    //   2930	2935	5160	java/lang/UnsatisfiedLinkError
    //   1829	1838	5175	java/lang/UnsatisfiedLinkError
    //   1907	1915	5175	java/lang/UnsatisfiedLinkError
    //   3072	3080	5175	java/lang/UnsatisfiedLinkError
    //   3340	3349	5175	java/lang/UnsatisfiedLinkError
    //   3376	3392	5175	java/lang/UnsatisfiedLinkError
    //   3419	3428	5175	java/lang/UnsatisfiedLinkError
    //   3455	3467	5175	java/lang/UnsatisfiedLinkError
    //   3494	3514	5175	java/lang/UnsatisfiedLinkError
    //   3551	3571	5175	java/lang/UnsatisfiedLinkError
    //   3598	3610	5175	java/lang/UnsatisfiedLinkError
    //   3637	3657	5175	java/lang/UnsatisfiedLinkError
    //   3684	3689	5175	java/lang/UnsatisfiedLinkError
    //   3720	3726	5175	java/lang/UnsatisfiedLinkError
    //   3753	3794	5175	java/lang/UnsatisfiedLinkError
    //   1954	1961	5190	java/lang/UnsatisfiedLinkError
    //   2000	2006	5190	java/lang/UnsatisfiedLinkError
    //   2045	2073	5190	java/lang/UnsatisfiedLinkError
    //   2112	2117	5190	java/lang/UnsatisfiedLinkError
    //   2996	3001	5190	java/lang/UnsatisfiedLinkError
    //   3036	3041	5190	java/lang/UnsatisfiedLinkError
    //   3123	3130	5190	java/lang/UnsatisfiedLinkError
    //   3173	3179	5190	java/lang/UnsatisfiedLinkError
    //   3222	3250	5190	java/lang/UnsatisfiedLinkError
    //   3293	3298	5190	java/lang/UnsatisfiedLinkError
    //   3842	3847	5190	java/lang/UnsatisfiedLinkError
    //   3882	3887	5190	java/lang/UnsatisfiedLinkError
    //   2154	2162	5206	java/lang/UnsatisfiedLinkError
    //   2182	2197	5206	java/lang/UnsatisfiedLinkError
    //   2217	2226	5206	java/lang/UnsatisfiedLinkError
    //   2246	2257	5206	java/lang/UnsatisfiedLinkError
    //   2277	2296	5206	java/lang/UnsatisfiedLinkError
    //   2322	2341	5206	java/lang/UnsatisfiedLinkError
    //   2361	2372	5206	java/lang/UnsatisfiedLinkError
    //   2392	2408	5206	java/lang/UnsatisfiedLinkError
    //   2415	2467	5218	java/lang/UnsatisfiedLinkError
    //   2479	2488	5226	java/lang/UnsatisfiedLinkError
    //   2496	2505	5226	java/lang/UnsatisfiedLinkError
    //   2516	2532	5226	java/lang/UnsatisfiedLinkError
    //   2535	2543	5226	java/lang/UnsatisfiedLinkError
    //   2582	2592	5237	java/lang/UnsatisfiedLinkError
    //   2631	2637	5237	java/lang/UnsatisfiedLinkError
    //   2676	2704	5237	java/lang/UnsatisfiedLinkError
    //   2743	2748	5237	java/lang/UnsatisfiedLinkError
    //   3937	3942	5237	java/lang/UnsatisfiedLinkError
    //   3977	3982	5237	java/lang/UnsatisfiedLinkError
    //   2753	2810	5253	java/lang/UnsatisfiedLinkError
    //   2821	2868	5264	java/lang/UnsatisfiedLinkError
    //   816	825	5275	java/lang/UnsatisfiedLinkError
    //   832	841	5275	java/lang/UnsatisfiedLinkError
    //   848	856	5275	java/lang/UnsatisfiedLinkError
    //   863	880	5275	java/lang/UnsatisfiedLinkError
    //   899	910	5275	java/lang/UnsatisfiedLinkError
    //   917	923	5275	java/lang/UnsatisfiedLinkError
    //   930	984	5275	java/lang/UnsatisfiedLinkError
    //   204	218	5290	java/lang/RuntimeException
    //   260	266	5290	java/lang/RuntimeException
    //   286	319	5290	java/lang/RuntimeException
    //   323	332	5308	java/lang/RuntimeException
    //   336	377	5308	java/lang/RuntimeException
    //   381	401	5308	java/lang/RuntimeException
    //   412	436	5308	java/lang/RuntimeException
    //   444	448	5308	java/lang/RuntimeException
    //   1381	1410	5308	java/lang/RuntimeException
    //   479	495	5322	java/lang/RuntimeException
    //   685	691	5322	java/lang/RuntimeException
    //   727	754	5322	java/lang/RuntimeException
    //   1138	1142	5322	java/lang/RuntimeException
    //   1178	1184	5322	java/lang/RuntimeException
    //   1220	1231	5322	java/lang/RuntimeException
    //   1270	1274	5322	java/lang/RuntimeException
    //   1310	1316	5322	java/lang/RuntimeException
    //   1352	1363	5322	java/lang/RuntimeException
    //   499	505	5338	java/lang/RuntimeException
    //   509	550	5338	java/lang/RuntimeException
    //   554	563	5338	java/lang/RuntimeException
    //   567	579	5338	java/lang/RuntimeException
    //   601	607	5338	java/lang/RuntimeException
    //   611	617	5338	java/lang/RuntimeException
    //   626	642	5338	java/lang/RuntimeException
    //   758	762	5358	java/lang/RuntimeException
    //   1425	1432	5378	java/lang/RuntimeException
    //   1439	1446	5378	java/lang/RuntimeException
    //   1531	1541	5378	java/lang/RuntimeException
    //   1563	1567	5378	java/lang/RuntimeException
    //   1573	1589	5395	java/lang/RuntimeException
    //   1592	1598	5395	java/lang/RuntimeException
    //   1605	1613	5395	java/lang/RuntimeException
    //   1784	1795	5395	java/lang/RuntimeException
    //   1636	1646	5409	java/lang/RuntimeException
    //   1669	1675	5409	java/lang/RuntimeException
    //   1698	1742	5409	java/lang/RuntimeException
    //   1765	1770	5409	java/lang/RuntimeException
    //   2906	2911	5409	java/lang/RuntimeException
    //   2930	2935	5409	java/lang/RuntimeException
    //   1829	1838	5424	java/lang/RuntimeException
    //   1907	1915	5424	java/lang/RuntimeException
    //   3072	3080	5424	java/lang/RuntimeException
    //   3340	3349	5424	java/lang/RuntimeException
    //   3376	3392	5424	java/lang/RuntimeException
    //   3419	3428	5424	java/lang/RuntimeException
    //   3455	3467	5424	java/lang/RuntimeException
    //   3494	3514	5424	java/lang/RuntimeException
    //   3551	3571	5424	java/lang/RuntimeException
    //   3598	3610	5424	java/lang/RuntimeException
    //   3637	3657	5424	java/lang/RuntimeException
    //   3684	3689	5424	java/lang/RuntimeException
    //   3720	3726	5424	java/lang/RuntimeException
    //   3753	3794	5424	java/lang/RuntimeException
    //   1954	1961	5439	java/lang/RuntimeException
    //   2000	2006	5439	java/lang/RuntimeException
    //   2045	2073	5439	java/lang/RuntimeException
    //   2112	2117	5439	java/lang/RuntimeException
    //   2996	3001	5439	java/lang/RuntimeException
    //   3036	3041	5439	java/lang/RuntimeException
    //   3123	3130	5439	java/lang/RuntimeException
    //   3173	3179	5439	java/lang/RuntimeException
    //   3222	3250	5439	java/lang/RuntimeException
    //   3293	3298	5439	java/lang/RuntimeException
    //   3842	3847	5439	java/lang/RuntimeException
    //   3882	3887	5439	java/lang/RuntimeException
    //   2154	2162	5455	java/lang/RuntimeException
    //   2182	2197	5455	java/lang/RuntimeException
    //   2217	2226	5455	java/lang/RuntimeException
    //   2246	2257	5455	java/lang/RuntimeException
    //   2277	2296	5455	java/lang/RuntimeException
    //   2322	2341	5455	java/lang/RuntimeException
    //   2361	2372	5455	java/lang/RuntimeException
    //   2392	2408	5455	java/lang/RuntimeException
    //   2415	2467	5471	java/lang/RuntimeException
    //   2479	2488	5483	java/lang/RuntimeException
    //   2496	2505	5483	java/lang/RuntimeException
    //   2516	2532	5483	java/lang/RuntimeException
    //   2535	2543	5483	java/lang/RuntimeException
    //   2582	2592	5494	java/lang/RuntimeException
    //   2631	2637	5494	java/lang/RuntimeException
    //   2676	2704	5494	java/lang/RuntimeException
    //   2743	2748	5494	java/lang/RuntimeException
    //   3937	3942	5494	java/lang/RuntimeException
    //   3977	3982	5494	java/lang/RuntimeException
    //   2753	2810	5510	java/lang/RuntimeException
    //   2821	2868	5521	java/lang/RuntimeException
    //   816	825	5532	java/lang/RuntimeException
    //   832	841	5532	java/lang/RuntimeException
    //   848	856	5532	java/lang/RuntimeException
    //   863	880	5532	java/lang/RuntimeException
    //   899	910	5532	java/lang/RuntimeException
    //   917	923	5532	java/lang/RuntimeException
    //   930	984	5532	java/lang/RuntimeException
    //   204	218	5547	java/io/IOException
    //   260	266	5547	java/io/IOException
    //   286	319	5547	java/io/IOException
    //   323	332	5562	java/io/IOException
    //   336	377	5562	java/io/IOException
    //   381	401	5562	java/io/IOException
    //   412	436	5562	java/io/IOException
    //   444	448	5562	java/io/IOException
    //   1381	1410	5562	java/io/IOException
    //   479	495	5573	java/io/IOException
    //   685	691	5573	java/io/IOException
    //   727	754	5573	java/io/IOException
    //   1138	1142	5573	java/io/IOException
    //   1178	1184	5573	java/io/IOException
    //   1220	1231	5573	java/io/IOException
    //   1270	1274	5573	java/io/IOException
    //   1310	1316	5573	java/io/IOException
    //   1352	1363	5573	java/io/IOException
    //   499	505	5585	java/io/IOException
    //   509	550	5585	java/io/IOException
    //   554	563	5585	java/io/IOException
    //   567	579	5585	java/io/IOException
    //   601	607	5585	java/io/IOException
    //   611	617	5585	java/io/IOException
    //   626	642	5585	java/io/IOException
    //   758	762	5601	java/io/IOException
    //   1425	1432	5617	java/io/IOException
    //   1439	1446	5617	java/io/IOException
    //   1531	1541	5617	java/io/IOException
    //   1563	1567	5617	java/io/IOException
    //   1573	1589	5631	java/io/IOException
    //   1592	1598	5631	java/io/IOException
    //   1605	1613	5631	java/io/IOException
    //   1784	1795	5631	java/io/IOException
    //   1636	1646	5641	java/io/IOException
    //   1669	1675	5641	java/io/IOException
    //   1698	1742	5641	java/io/IOException
    //   1765	1770	5641	java/io/IOException
    //   2906	2911	5641	java/io/IOException
    //   2930	2935	5641	java/io/IOException
    //   1829	1838	5652	java/io/IOException
    //   1907	1915	5652	java/io/IOException
    //   3072	3080	5652	java/io/IOException
    //   3340	3349	5652	java/io/IOException
    //   3376	3392	5652	java/io/IOException
    //   3419	3428	5652	java/io/IOException
    //   3455	3467	5652	java/io/IOException
    //   3494	3514	5652	java/io/IOException
    //   3551	3571	5652	java/io/IOException
    //   3598	3610	5652	java/io/IOException
    //   3637	3657	5652	java/io/IOException
    //   3684	3689	5652	java/io/IOException
    //   3720	3726	5652	java/io/IOException
    //   3753	3794	5652	java/io/IOException
    //   1954	1961	5663	java/io/IOException
    //   2000	2006	5663	java/io/IOException
    //   2045	2073	5663	java/io/IOException
    //   2112	2117	5663	java/io/IOException
    //   2996	3001	5663	java/io/IOException
    //   3036	3041	5663	java/io/IOException
    //   3123	3130	5663	java/io/IOException
    //   3173	3179	5663	java/io/IOException
    //   3222	3250	5663	java/io/IOException
    //   3293	3298	5663	java/io/IOException
    //   3842	3847	5663	java/io/IOException
    //   3882	3887	5663	java/io/IOException
    //   2154	2162	5675	java/io/IOException
    //   2182	2197	5675	java/io/IOException
    //   2217	2226	5675	java/io/IOException
    //   2246	2257	5675	java/io/IOException
    //   2277	2296	5675	java/io/IOException
    //   2322	2341	5675	java/io/IOException
    //   2361	2372	5675	java/io/IOException
    //   2392	2408	5675	java/io/IOException
    //   2415	2467	5687	java/io/IOException
    //   2479	2488	5695	java/io/IOException
    //   2496	2505	5695	java/io/IOException
    //   2516	2532	5695	java/io/IOException
    //   2535	2543	5695	java/io/IOException
    //   2582	2592	5702	java/io/IOException
    //   2631	2637	5702	java/io/IOException
    //   2676	2704	5702	java/io/IOException
    //   2743	2748	5702	java/io/IOException
    //   3937	3942	5702	java/io/IOException
    //   3977	3982	5702	java/io/IOException
    //   2753	2810	5714	java/io/IOException
    //   2821	2868	5721	java/io/IOException
    //   816	825	5728	java/io/IOException
    //   832	841	5728	java/io/IOException
    //   848	856	5728	java/io/IOException
    //   863	880	5728	java/io/IOException
    //   899	910	5728	java/io/IOException
    //   917	923	5728	java/io/IOException
    //   930	984	5728	java/io/IOException
    //   2753	2810	5739	java/lang/OutOfMemoryError
    //   2821	2868	5747	java/lang/OutOfMemoryError
    //   2154	2162	5755	java/lang/OutOfMemoryError
    //   2182	2197	5755	java/lang/OutOfMemoryError
    //   2217	2226	5755	java/lang/OutOfMemoryError
    //   2246	2257	5755	java/lang/OutOfMemoryError
    //   2277	2296	5755	java/lang/OutOfMemoryError
    //   2322	2341	5755	java/lang/OutOfMemoryError
    //   2361	2372	5755	java/lang/OutOfMemoryError
    //   2392	2408	5755	java/lang/OutOfMemoryError
    //   2415	2467	5767	java/lang/OutOfMemoryError
    //   412	436	5775	java/lang/Throwable
    //   444	448	5775	java/lang/Throwable
    //   479	495	5790	java/lang/Throwable
    //   685	691	5790	java/lang/Throwable
    //   727	754	5790	java/lang/Throwable
    //   499	505	5802	java/lang/Throwable
    //   509	550	5802	java/lang/Throwable
    //   554	563	5802	java/lang/Throwable
    //   567	579	5802	java/lang/Throwable
    //   601	607	5802	java/lang/Throwable
    //   611	617	5802	java/lang/Throwable
    //   626	642	5802	java/lang/Throwable
    //   758	762	5818	java/lang/Throwable
    //   412	436	5834	java/lang/OutOfMemoryError
    //   444	448	5834	java/lang/OutOfMemoryError
    //   479	495	5849	java/lang/OutOfMemoryError
    //   685	691	5849	java/lang/OutOfMemoryError
    //   727	754	5849	java/lang/OutOfMemoryError
    //   499	505	5861	java/lang/OutOfMemoryError
    //   509	550	5861	java/lang/OutOfMemoryError
    //   554	563	5861	java/lang/OutOfMemoryError
    //   567	579	5861	java/lang/OutOfMemoryError
    //   601	607	5861	java/lang/OutOfMemoryError
    //   611	617	5861	java/lang/OutOfMemoryError
    //   626	642	5861	java/lang/OutOfMemoryError
    //   758	762	5877	java/lang/OutOfMemoryError
    //   336	377	6013	java/lang/Throwable
    //   381	401	6013	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bfwd.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bfwd.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = aneh.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (aneh.a(paramArrayOfInt))
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
    //   14: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   17: lstore 25
    //   19: iconst_m1
    //   20: istore 7
    //   22: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   25: ifeq +29 -> 54
    //   28: ldc 43
    //   30: iconst_4
    //   31: new 45	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 414
    //   41: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_3
    //   45: invokevirtual 294	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: astore 32
    //   57: aconst_null
    //   58: astore 36
    //   60: aconst_null
    //   61: astore 34
    //   63: aconst_null
    //   64: astore 35
    //   66: aconst_null
    //   67: astore 33
    //   69: iconst_0
    //   70: istore 21
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 6
    //   78: iconst_0
    //   79: istore 15
    //   81: iconst_0
    //   82: istore 19
    //   84: iconst_0
    //   85: istore 20
    //   87: iconst_0
    //   88: istore 16
    //   90: iconst_0
    //   91: istore 17
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 18
    //   99: iconst_0
    //   100: istore 13
    //   102: iconst_0
    //   103: istore 14
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 33
    //   110: astore 27
    //   112: iload 6
    //   114: istore 12
    //   116: aload 32
    //   118: astore 30
    //   120: iload 15
    //   122: istore 11
    //   124: aload 36
    //   126: astore 31
    //   128: iload 19
    //   130: istore 9
    //   132: aload 34
    //   134: astore 29
    //   136: iload 20
    //   138: istore 10
    //   140: aload 35
    //   142: astore 28
    //   144: iload 16
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 302	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 33
    //   156: astore 27
    //   158: iload 6
    //   160: istore 12
    //   162: aload 32
    //   164: astore 30
    //   166: iload 15
    //   168: istore 11
    //   170: aload 36
    //   172: astore 31
    //   174: iload 19
    //   176: istore 9
    //   178: aload 34
    //   180: astore 29
    //   182: iload 20
    //   184: istore 10
    //   186: aload 35
    //   188: astore 28
    //   190: iload 16
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4029 -> 4231
    //   205: iload_3
    //   206: ifeq +802 -> 1008
    //   209: iload 17
    //   211: istore 10
    //   213: iload 18
    //   215: istore 9
    //   217: iload 13
    //   219: istore 8
    //   221: iload 14
    //   223: istore 11
    //   225: aload_0
    //   226: invokevirtual 313	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 319	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore_0
    //   233: iload 17
    //   235: istore 10
    //   237: iload 18
    //   239: istore 9
    //   241: iload 13
    //   243: istore 8
    //   245: iload 14
    //   247: istore 11
    //   249: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   252: ifeq +45 -> 297
    //   255: iload 17
    //   257: istore 10
    //   259: iload 18
    //   261: istore 9
    //   263: iload 13
    //   265: istore 8
    //   267: iload 14
    //   269: istore 11
    //   271: ldc 43
    //   273: iconst_4
    //   274: new 45	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 321
    //   284: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: ifnull +3924 -> 4222
    //   301: iload 17
    //   303: istore 10
    //   305: iload 18
    //   307: istore 9
    //   309: iload 13
    //   311: istore 8
    //   313: iload 14
    //   315: istore 11
    //   317: aload_0
    //   318: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   321: istore 6
    //   323: iload 17
    //   325: istore 10
    //   327: iload 18
    //   329: istore 9
    //   331: iload 13
    //   333: istore 8
    //   335: iload 14
    //   337: istore 11
    //   339: aload_0
    //   340: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   343: istore 12
    //   345: iload 17
    //   347: istore 10
    //   349: iload 18
    //   351: istore 9
    //   353: iload 13
    //   355: istore 8
    //   357: iload 14
    //   359: istore 11
    //   361: iload 6
    //   363: iload 12
    //   365: invokestatic 199	bfwd:a	(II)Z
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
    //   383: invokevirtual 336	java/io/InputStream:close	()V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   393: aload_0
    //   394: astore 27
    //   396: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -388 -> 11
    //   402: ldc 43
    //   404: iconst_2
    //   405: aload_1
    //   406: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   409: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aconst_null
    //   413: areturn
    //   414: iload 17
    //   416: istore 10
    //   418: iload 18
    //   420: istore 9
    //   422: iload 13
    //   424: istore 8
    //   426: iload 14
    //   428: istore 11
    //   430: iload 6
    //   432: iload 12
    //   434: imul
    //   435: newarray int
    //   437: astore 27
    //   439: iload 17
    //   441: istore 10
    //   443: iload 18
    //   445: istore 9
    //   447: iload 13
    //   449: istore 8
    //   451: iload 14
    //   453: istore 11
    //   455: aload_0
    //   456: aload 27
    //   458: iconst_0
    //   459: iload 6
    //   461: iconst_0
    //   462: iconst_0
    //   463: iload 6
    //   465: iload 12
    //   467: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   470: iload 17
    //   472: istore 10
    //   474: iload 18
    //   476: istore 9
    //   478: iload 13
    //   480: istore 8
    //   482: iload 14
    //   484: istore 11
    //   486: aload_0
    //   487: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   490: iload 17
    //   492: istore 10
    //   494: iload 18
    //   496: istore 9
    //   498: iload 13
    //   500: istore 8
    //   502: iload 14
    //   504: istore 11
    //   506: invokestatic 200	yak:a	()I
    //   509: pop
    //   510: iconst_1
    //   511: istore 9
    //   513: aload 27
    //   515: aconst_null
    //   516: iload 6
    //   518: iload 12
    //   520: invokestatic 416	yak:a	([I[BII)I
    //   523: istore 6
    //   525: iload 9
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   536: ifeq +38 -> 574
    //   539: ldc 43
    //   541: iconst_4
    //   542: new 45	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 418
    //   552: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 6
    //   557: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   587: if_icmpne +3605 -> 4192
    //   590: iload_2
    //   591: ifeq +2816 -> 3407
    //   594: aload_0
    //   595: astore 27
    //   597: iload 6
    //   599: istore 12
    //   601: aload_0
    //   602: astore 30
    //   604: iload 6
    //   606: istore 11
    //   608: aload_0
    //   609: astore 31
    //   611: iload 6
    //   613: istore 9
    //   615: aload_0
    //   616: astore 29
    //   618: iload 6
    //   620: istore 10
    //   622: aload_0
    //   623: astore 28
    //   625: iload 6
    //   627: istore 8
    //   629: new 45	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   636: astore_1
    //   637: aload_0
    //   638: astore 27
    //   640: iload 6
    //   642: istore 12
    //   644: aload_0
    //   645: astore 30
    //   647: iload 6
    //   649: istore 11
    //   651: aload_0
    //   652: astore 31
    //   654: iload 6
    //   656: istore 9
    //   658: aload_0
    //   659: astore 29
    //   661: iload 6
    //   663: istore 10
    //   665: aload_0
    //   666: astore 28
    //   668: iload 6
    //   670: istore 8
    //   672: new 45	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   679: astore 32
    //   681: aload_0
    //   682: astore 27
    //   684: iload 6
    //   686: istore 12
    //   688: aload_0
    //   689: astore 30
    //   691: iload 6
    //   693: istore 11
    //   695: aload_0
    //   696: astore 31
    //   698: iload 6
    //   700: istore 9
    //   702: aload_0
    //   703: astore 29
    //   705: iload 6
    //   707: istore 10
    //   709: aload_0
    //   710: astore 28
    //   712: iload 6
    //   714: istore 8
    //   716: aload_1
    //   717: aload 32
    //   719: invokestatic 238	bfwd:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   722: pop
    //   723: aload_0
    //   724: astore 27
    //   726: iload 6
    //   728: istore 12
    //   730: aload_0
    //   731: astore 30
    //   733: iload 6
    //   735: istore 11
    //   737: aload_0
    //   738: astore 31
    //   740: iload 6
    //   742: istore 9
    //   744: aload_0
    //   745: astore 29
    //   747: iload 6
    //   749: istore 10
    //   751: aload_0
    //   752: astore 28
    //   754: iload 6
    //   756: istore 8
    //   758: new 240	android/util/Pair
    //   761: dup
    //   762: aload 32
    //   764: aload_1
    //   765: invokespecial 243	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   768: astore_1
    //   769: aload_0
    //   770: astore 27
    //   772: iload 6
    //   774: ifeq +7 -> 781
    //   777: invokestatic 253	yak:b	()I
    //   780: pop
    //   781: aload_1
    //   782: astore_0
    //   783: aload 27
    //   785: ifnull +10 -> 795
    //   788: aload 27
    //   790: invokevirtual 336	java/io/InputStream:close	()V
    //   793: aload_1
    //   794: astore_0
    //   795: aload_0
    //   796: astore 27
    //   798: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   801: ifeq -790 -> 11
    //   804: ldc 43
    //   806: iconst_4
    //   807: new 45	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 420
    //   817: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   823: lload 25
    //   825: lsub
    //   826: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload_0
    //   836: areturn
    //   837: astore_0
    //   838: iload 21
    //   840: istore 6
    //   842: iload 6
    //   844: istore 10
    //   846: iload 6
    //   848: istore 12
    //   850: iload 6
    //   852: istore 9
    //   854: iload 6
    //   856: istore 8
    //   858: iload 6
    //   860: istore 11
    //   862: aload_0
    //   863: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: iload 6
    //   868: istore 10
    //   870: iload 6
    //   872: istore 12
    //   874: iload 6
    //   876: istore 9
    //   878: iload 6
    //   880: istore 8
    //   882: iload 6
    //   884: istore 11
    //   886: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +3354 -> 4243
    //   892: iload 6
    //   894: istore 10
    //   896: iload 6
    //   898: istore 12
    //   900: iload 6
    //   902: istore 9
    //   904: iload 6
    //   906: istore 8
    //   908: iload 6
    //   910: istore 11
    //   912: ldc 43
    //   914: iconst_2
    //   915: aload_0
    //   916: invokevirtual 342	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   919: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto +3321 -> 4243
    //   925: iload 6
    //   927: istore 10
    //   929: iload 6
    //   931: istore 12
    //   933: iload 6
    //   935: istore 9
    //   937: iload 6
    //   939: istore 8
    //   941: iload 6
    //   943: istore 11
    //   945: aload_0
    //   946: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   949: iload 6
    //   951: istore 10
    //   953: iload 6
    //   955: istore 12
    //   957: iload 6
    //   959: istore 9
    //   961: iload 6
    //   963: istore 8
    //   965: iload 6
    //   967: istore 11
    //   969: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +3284 -> 4256
    //   975: iload 6
    //   977: istore 10
    //   979: iload 6
    //   981: istore 12
    //   983: iload 6
    //   985: istore 9
    //   987: iload 6
    //   989: istore 8
    //   991: iload 6
    //   993: istore 11
    //   995: ldc 43
    //   997: iconst_2
    //   998: aload_0
    //   999: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1002: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto +3251 -> 4256
    //   1008: iload 17
    //   1010: istore 10
    //   1012: iload 23
    //   1014: istore 12
    //   1016: iload 18
    //   1018: istore 9
    //   1020: iload 13
    //   1022: istore 8
    //   1024: iload 14
    //   1026: istore 11
    //   1028: new 344	android/graphics/BitmapFactory$Options
    //   1031: dup
    //   1032: invokespecial 345	android/graphics/BitmapFactory$Options:<init>	()V
    //   1035: astore 43
    //   1037: iload 17
    //   1039: istore 10
    //   1041: iload 23
    //   1043: istore 12
    //   1045: iload 18
    //   1047: istore 9
    //   1049: iload 13
    //   1051: istore 8
    //   1053: iload 14
    //   1055: istore 11
    //   1057: aload 43
    //   1059: iconst_1
    //   1060: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1063: iload 17
    //   1065: istore 10
    //   1067: iload 23
    //   1069: istore 12
    //   1071: iload 18
    //   1073: istore 9
    //   1075: iload 13
    //   1077: istore 8
    //   1079: iload 14
    //   1081: istore 11
    //   1083: aload_1
    //   1084: aconst_null
    //   1085: aload 43
    //   1087: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1090: pop
    //   1091: iload 17
    //   1093: istore 10
    //   1095: iload 23
    //   1097: istore 12
    //   1099: iload 18
    //   1101: istore 9
    //   1103: iload 13
    //   1105: istore 8
    //   1107: iload 14
    //   1109: istore 11
    //   1111: aload_1
    //   1112: invokevirtual 336	java/io/InputStream:close	()V
    //   1115: aconst_null
    //   1116: astore 32
    //   1118: aconst_null
    //   1119: astore 41
    //   1121: aconst_null
    //   1122: astore 38
    //   1124: aconst_null
    //   1125: astore 39
    //   1127: aconst_null
    //   1128: astore_1
    //   1129: aconst_null
    //   1130: astore 40
    //   1132: aconst_null
    //   1133: astore 34
    //   1135: aconst_null
    //   1136: astore 35
    //   1138: aconst_null
    //   1139: astore 33
    //   1141: aconst_null
    //   1142: astore 36
    //   1144: aconst_null
    //   1145: astore 37
    //   1147: aload 41
    //   1149: astore 27
    //   1151: iload 6
    //   1153: istore 12
    //   1155: aload 38
    //   1157: astore 30
    //   1159: iload 15
    //   1161: istore 11
    //   1163: aload 39
    //   1165: astore 31
    //   1167: iload 19
    //   1169: istore 9
    //   1171: aload_1
    //   1172: astore 29
    //   1174: iload 20
    //   1176: istore 10
    //   1178: aload 40
    //   1180: astore 28
    //   1182: iload 16
    //   1184: istore 8
    //   1186: aload 43
    //   1188: getfield 357	android/graphics/BitmapFactory$Options:outWidth	I
    //   1191: istore 17
    //   1193: aload 41
    //   1195: astore 27
    //   1197: iload 6
    //   1199: istore 12
    //   1201: aload 38
    //   1203: astore 30
    //   1205: iload 15
    //   1207: istore 11
    //   1209: aload 39
    //   1211: astore 31
    //   1213: iload 19
    //   1215: istore 9
    //   1217: aload_1
    //   1218: astore 29
    //   1220: iload 20
    //   1222: istore 10
    //   1224: aload 40
    //   1226: astore 28
    //   1228: iload 16
    //   1230: istore 8
    //   1232: aload 43
    //   1234: getfield 360	android/graphics/BitmapFactory$Options:outHeight	I
    //   1237: istore 14
    //   1239: aload 41
    //   1241: astore 27
    //   1243: iload 6
    //   1245: istore 12
    //   1247: aload 38
    //   1249: astore 30
    //   1251: iload 15
    //   1253: istore 11
    //   1255: aload 39
    //   1257: astore 31
    //   1259: iload 19
    //   1261: istore 9
    //   1263: aload_1
    //   1264: astore 29
    //   1266: iload 20
    //   1268: istore 10
    //   1270: aload 40
    //   1272: astore 28
    //   1274: iload 16
    //   1276: istore 8
    //   1278: aload 43
    //   1280: iconst_0
    //   1281: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1284: iload 17
    //   1286: sipush 12800
    //   1289: if_icmpgt +11 -> 1300
    //   1292: iload 14
    //   1294: sipush 12800
    //   1297: if_icmple +46 -> 1343
    //   1300: aconst_null
    //   1301: astore_0
    //   1302: aload_0
    //   1303: astore 27
    //   1305: iconst_0
    //   1306: ifeq -1295 -> 11
    //   1309: new 362	java/lang/NullPointerException
    //   1312: dup
    //   1313: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1316: athrow
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1322: aload_0
    //   1323: astore 27
    //   1325: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1328: ifeq -1317 -> 11
    //   1331: ldc 43
    //   1333: iconst_2
    //   1334: aload_1
    //   1335: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1338: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aconst_null
    //   1342: areturn
    //   1343: aload 41
    //   1345: astore 27
    //   1347: iload 6
    //   1349: istore 12
    //   1351: aload 38
    //   1353: astore 30
    //   1355: iload 15
    //   1357: istore 11
    //   1359: aload 39
    //   1361: astore 31
    //   1363: iload 19
    //   1365: istore 9
    //   1367: aload_1
    //   1368: astore 29
    //   1370: iload 20
    //   1372: istore 10
    //   1374: aload 40
    //   1376: astore 28
    //   1378: iload 16
    //   1380: istore 8
    //   1382: iload 17
    //   1384: iload 14
    //   1386: invokestatic 199	bfwd:a	(II)Z
    //   1389: istore_3
    //   1390: iload_3
    //   1391: ifne +46 -> 1437
    //   1394: aconst_null
    //   1395: astore_0
    //   1396: aload_0
    //   1397: astore 27
    //   1399: iconst_0
    //   1400: ifeq -1389 -> 11
    //   1403: new 362	java/lang/NullPointerException
    //   1406: dup
    //   1407: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1410: athrow
    //   1411: astore_1
    //   1412: aload_1
    //   1413: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1416: aload_0
    //   1417: astore 27
    //   1419: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1422: ifeq -1411 -> 11
    //   1425: ldc 43
    //   1427: iconst_2
    //   1428: aload_1
    //   1429: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1432: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1435: aconst_null
    //   1436: areturn
    //   1437: aload 41
    //   1439: astore 27
    //   1441: iload 6
    //   1443: istore 12
    //   1445: aload 38
    //   1447: astore 30
    //   1449: iload 15
    //   1451: istore 11
    //   1453: aload 39
    //   1455: astore 31
    //   1457: iload 19
    //   1459: istore 9
    //   1461: aload_1
    //   1462: astore 29
    //   1464: iload 20
    //   1466: istore 10
    //   1468: aload 40
    //   1470: astore 28
    //   1472: iload 16
    //   1474: istore 8
    //   1476: invokestatic 200	yak:a	()I
    //   1479: pop
    //   1480: iconst_1
    //   1481: istore 9
    //   1483: iconst_1
    //   1484: istore 10
    //   1486: iconst_1
    //   1487: istore 13
    //   1489: iconst_1
    //   1490: istore 12
    //   1492: iconst_1
    //   1493: istore 11
    //   1495: iload 17
    //   1497: iload 14
    //   1499: imul
    //   1500: ldc_w 421
    //   1503: if_icmple +1165 -> 2668
    //   1506: iload 17
    //   1508: iload 14
    //   1510: imul
    //   1511: i2d
    //   1512: dstore 4
    //   1514: aload 37
    //   1516: astore 27
    //   1518: aload 34
    //   1520: astore_1
    //   1521: iload 12
    //   1523: istore 8
    //   1525: aload 35
    //   1527: astore 28
    //   1529: aload 33
    //   1531: astore 29
    //   1533: aload 36
    //   1535: astore 30
    //   1537: aload 43
    //   1539: dload 4
    //   1541: invokestatic 424	java/lang/Math:sqrt	(D)D
    //   1544: ldc2_w 425
    //   1547: ddiv
    //   1548: invokestatic 235	java/lang/Math:ceil	(D)D
    //   1551: d2i
    //   1552: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1555: aload 37
    //   1557: astore 27
    //   1559: aload 34
    //   1561: astore_1
    //   1562: iload 12
    //   1564: istore 8
    //   1566: aload 35
    //   1568: astore 28
    //   1570: aload 33
    //   1572: astore 29
    //   1574: aload 36
    //   1576: astore 30
    //   1578: aload 42
    //   1580: aload_0
    //   1581: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1584: astore 31
    //   1586: aload 31
    //   1588: astore 27
    //   1590: aload 31
    //   1592: astore 32
    //   1594: aload 31
    //   1596: astore_1
    //   1597: iload 12
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
    //   1618: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1621: astore 33
    //   1623: aload 31
    //   1625: astore 27
    //   1627: aload 31
    //   1629: astore 32
    //   1631: aload 31
    //   1633: astore_1
    //   1634: iload 12
    //   1636: istore 8
    //   1638: aload 31
    //   1640: astore 28
    //   1642: aload 31
    //   1644: astore 29
    //   1646: aload 31
    //   1648: astore 30
    //   1650: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1653: ifeq +93 -> 1746
    //   1656: aload 31
    //   1658: astore 27
    //   1660: aload 31
    //   1662: astore 32
    //   1664: aload 31
    //   1666: astore_1
    //   1667: iload 12
    //   1669: istore 8
    //   1671: aload 31
    //   1673: astore 28
    //   1675: aload 31
    //   1677: astore 29
    //   1679: aload 31
    //   1681: astore 30
    //   1683: ldc 43
    //   1685: iconst_4
    //   1686: new 45	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 428
    //   1696: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload 33
    //   1701: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1704: ldc_w 430
    //   1707: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: iload 17
    //   1712: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: ldc_w 432
    //   1718: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: iload 14
    //   1723: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: ldc_w 434
    //   1729: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: aload 43
    //   1734: getfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1737: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1746: aload 31
    //   1748: astore 27
    //   1750: aload 31
    //   1752: astore 32
    //   1754: aload 31
    //   1756: astore_1
    //   1757: iload 12
    //   1759: istore 8
    //   1761: aload 31
    //   1763: astore 28
    //   1765: aload 31
    //   1767: astore 29
    //   1769: aload 31
    //   1771: astore 30
    //   1773: aload 31
    //   1775: invokevirtual 336	java/io/InputStream:close	()V
    //   1778: iload 7
    //   1780: istore 8
    //   1782: aload 33
    //   1784: ifnull +129 -> 1913
    //   1787: iload 7
    //   1789: istore 6
    //   1791: aload 33
    //   1793: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   1796: istore 15
    //   1798: iload 7
    //   1800: istore 6
    //   1802: aload 33
    //   1804: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   1807: istore 8
    //   1809: iload 7
    //   1811: istore 6
    //   1813: iload 15
    //   1815: iload 8
    //   1817: imul
    //   1818: newarray int
    //   1820: astore_1
    //   1821: iload 7
    //   1823: istore 6
    //   1825: aload 33
    //   1827: aload_1
    //   1828: iconst_0
    //   1829: iload 15
    //   1831: iconst_0
    //   1832: iconst_0
    //   1833: iload 15
    //   1835: iload 8
    //   1837: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1840: iload 7
    //   1842: istore 6
    //   1844: aload 33
    //   1846: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   1849: iload 7
    //   1851: istore 6
    //   1853: aload_1
    //   1854: aconst_null
    //   1855: iload 15
    //   1857: iload 8
    //   1859: invokestatic 416	yak:a	([I[BII)I
    //   1862: istore 7
    //   1864: iload 7
    //   1866: istore 8
    //   1868: iload 7
    //   1870: istore 6
    //   1872: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1875: ifeq +38 -> 1913
    //   1878: iload 7
    //   1880: istore 6
    //   1882: ldc 43
    //   1884: iconst_4
    //   1885: new 45	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1892: ldc_w 436
    //   1895: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: iload 7
    //   1900: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1903: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1906: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1947: iload 17
    //   1949: iconst_2
    //   1950: imul
    //   1951: iload 14
    //   1953: if_icmpgt +953 -> 2906
    //   1956: iload 17
    //   1958: sipush 1280
    //   1961: if_icmpge +945 -> 2906
    //   1964: iload 12
    //   1966: istore 8
    //   1968: aload 42
    //   1970: aload_0
    //   1971: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1974: astore 31
    //   1976: aload 31
    //   1978: astore 27
    //   1980: aload 31
    //   1982: astore_1
    //   1983: iload 12
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
    //   2005: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2008: astore 33
    //   2010: aload 31
    //   2012: astore 27
    //   2014: aload 31
    //   2016: astore_1
    //   2017: iload 12
    //   2019: istore 8
    //   2021: aload 31
    //   2023: astore 28
    //   2025: aload 31
    //   2027: astore 29
    //   2029: aload 31
    //   2031: astore 30
    //   2033: aload 31
    //   2035: astore 32
    //   2037: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2040: ifeq +57 -> 2097
    //   2043: aload 31
    //   2045: astore 27
    //   2047: aload 31
    //   2049: astore_1
    //   2050: iload 12
    //   2052: istore 8
    //   2054: aload 31
    //   2056: astore 28
    //   2058: aload 31
    //   2060: astore 29
    //   2062: aload 31
    //   2064: astore 30
    //   2066: aload 31
    //   2068: astore 32
    //   2070: ldc 43
    //   2072: iconst_4
    //   2073: new 45	java/lang/StringBuilder
    //   2076: dup
    //   2077: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2080: ldc_w 438
    //   2083: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload 33
    //   2088: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2097: aload 31
    //   2099: astore 27
    //   2101: aload 31
    //   2103: astore_1
    //   2104: iload 12
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
    //   2126: invokevirtual 336	java/io/InputStream:close	()V
    //   2129: aload 33
    //   2131: ifnull +2088 -> 4219
    //   2134: iload 6
    //   2136: istore 7
    //   2138: iload 17
    //   2140: iload 17
    //   2142: imul
    //   2143: newarray int
    //   2145: astore 27
    //   2147: iload 6
    //   2149: istore 7
    //   2151: aload 33
    //   2153: aload 27
    //   2155: iconst_0
    //   2156: iload 17
    //   2158: iconst_0
    //   2159: iconst_0
    //   2160: iload 17
    //   2162: iload 17
    //   2164: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2167: iload 6
    //   2169: istore 7
    //   2171: iload 17
    //   2173: iload 17
    //   2175: imul
    //   2176: newarray byte
    //   2178: astore_1
    //   2179: iload 6
    //   2181: istore 7
    //   2183: aload 27
    //   2185: aload_1
    //   2186: iload 17
    //   2188: iload 17
    //   2190: invokestatic 416	yak:a	([I[BII)I
    //   2193: istore 6
    //   2195: iload 6
    //   2197: iconst_1
    //   2198: if_icmpeq +2018 -> 4216
    //   2201: iload 6
    //   2203: istore 7
    //   2205: aload 33
    //   2207: aload 27
    //   2209: iconst_0
    //   2210: iload 17
    //   2212: iconst_0
    //   2213: iload 14
    //   2215: iload 17
    //   2217: isub
    //   2218: iload 17
    //   2220: iload 17
    //   2222: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2225: iload 6
    //   2227: istore 7
    //   2229: aload 27
    //   2231: aload_1
    //   2232: iload 17
    //   2234: iload 17
    //   2236: invokestatic 416	yak:a	([I[BII)I
    //   2239: istore 6
    //   2241: aload 33
    //   2243: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2246: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2249: ifeq +30 -> 2279
    //   2252: ldc 43
    //   2254: iconst_4
    //   2255: new 45	java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2262: ldc_w 440
    //   2265: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: iload 6
    //   2270: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2273: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2276: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2279: iload 6
    //   2281: istore 7
    //   2283: aconst_null
    //   2284: astore 36
    //   2286: aconst_null
    //   2287: astore 37
    //   2289: aconst_null
    //   2290: astore 34
    //   2292: aconst_null
    //   2293: astore 35
    //   2295: aconst_null
    //   2296: astore 32
    //   2298: aconst_null
    //   2299: astore 31
    //   2301: aconst_null
    //   2302: astore 33
    //   2304: iload 7
    //   2306: iconst_1
    //   2307: if_icmpeq +1900 -> 4207
    //   2310: aload 36
    //   2312: astore 27
    //   2314: aload 37
    //   2316: astore_1
    //   2317: iload 12
    //   2319: istore 8
    //   2321: aload 34
    //   2323: astore 28
    //   2325: aload 35
    //   2327: astore 29
    //   2329: aload 32
    //   2331: astore 30
    //   2333: iload 17
    //   2335: iload 14
    //   2337: invokestatic 229	java/lang/Math:min	(II)I
    //   2340: istore 6
    //   2342: iload 6
    //   2344: sipush 250
    //   2347: if_icmple +1860 -> 4207
    //   2350: aload 36
    //   2352: astore 27
    //   2354: aload 37
    //   2356: astore_1
    //   2357: iload 12
    //   2359: istore 8
    //   2361: aload 34
    //   2363: astore 28
    //   2365: aload 35
    //   2367: astore 29
    //   2369: aload 32
    //   2371: astore 30
    //   2373: aload 43
    //   2375: iload 6
    //   2377: i2d
    //   2378: ldc2_w 230
    //   2381: ddiv
    //   2382: invokestatic 235	java/lang/Math:ceil	(D)D
    //   2385: d2i
    //   2386: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2389: aload 36
    //   2391: astore 27
    //   2393: aload 37
    //   2395: astore_1
    //   2396: iload 12
    //   2398: istore 8
    //   2400: aload 34
    //   2402: astore 28
    //   2404: aload 35
    //   2406: astore 29
    //   2408: aload 32
    //   2410: astore 30
    //   2412: aload 42
    //   2414: aload_0
    //   2415: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2418: astore_0
    //   2419: aload_0
    //   2420: astore 27
    //   2422: aload_0
    //   2423: astore_1
    //   2424: iload 12
    //   2426: istore 8
    //   2428: aload_0
    //   2429: astore 28
    //   2431: aload_0
    //   2432: astore 29
    //   2434: aload_0
    //   2435: astore 30
    //   2437: aload_0
    //   2438: astore 31
    //   2440: aload_0
    //   2441: aconst_null
    //   2442: aload 43
    //   2444: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2447: astore 32
    //   2449: aload_0
    //   2450: astore 27
    //   2452: aload_0
    //   2453: astore_1
    //   2454: iload 12
    //   2456: istore 8
    //   2458: aload_0
    //   2459: astore 28
    //   2461: aload_0
    //   2462: astore 29
    //   2464: aload_0
    //   2465: astore 30
    //   2467: aload_0
    //   2468: astore 31
    //   2470: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2473: ifeq +51 -> 2524
    //   2476: aload_0
    //   2477: astore 27
    //   2479: aload_0
    //   2480: astore_1
    //   2481: iload 12
    //   2483: istore 8
    //   2485: aload_0
    //   2486: astore 28
    //   2488: aload_0
    //   2489: astore 29
    //   2491: aload_0
    //   2492: astore 30
    //   2494: aload_0
    //   2495: astore 31
    //   2497: ldc 43
    //   2499: iconst_4
    //   2500: new 45	java/lang/StringBuilder
    //   2503: dup
    //   2504: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2507: ldc_w 442
    //   2510: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2513: aload 32
    //   2515: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2518: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2521: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2524: aload_0
    //   2525: astore 27
    //   2527: aload_0
    //   2528: astore_1
    //   2529: iload 12
    //   2531: istore 8
    //   2533: aload_0
    //   2534: astore 28
    //   2536: aload_0
    //   2537: astore 29
    //   2539: aload_0
    //   2540: astore 30
    //   2542: aload_0
    //   2543: astore 31
    //   2545: aload_0
    //   2546: invokevirtual 336	java/io/InputStream:close	()V
    //   2549: aload 32
    //   2551: ifnull +1649 -> 4200
    //   2554: aload 32
    //   2556: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   2559: istore 8
    //   2561: aload 32
    //   2563: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   2566: istore 6
    //   2568: iload 8
    //   2570: iload 6
    //   2572: imul
    //   2573: newarray int
    //   2575: astore_0
    //   2576: aload 32
    //   2578: aload_0
    //   2579: iconst_0
    //   2580: iload 8
    //   2582: iconst_0
    //   2583: iconst_0
    //   2584: iload 8
    //   2586: iload 6
    //   2588: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2591: aload 32
    //   2593: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2596: aload_0
    //   2597: aconst_null
    //   2598: iload 8
    //   2600: iload 6
    //   2602: invokestatic 416	yak:a	([I[BII)I
    //   2605: istore 6
    //   2607: iload 6
    //   2609: istore 7
    //   2611: iload 7
    //   2613: istore 6
    //   2615: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2618: ifeq +34 -> 2652
    //   2621: ldc 43
    //   2623: iconst_4
    //   2624: new 45	java/lang/StringBuilder
    //   2627: dup
    //   2628: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2631: ldc_w 444
    //   2634: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2637: iload 7
    //   2639: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2642: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2645: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2648: iload 7
    //   2650: istore 6
    //   2652: iconst_1
    //   2653: istore 8
    //   2655: aconst_null
    //   2656: astore_0
    //   2657: iload 6
    //   2659: istore 7
    //   2661: iload 8
    //   2663: istore 6
    //   2665: goto -2081 -> 584
    //   2668: aload 37
    //   2670: astore 27
    //   2672: aload 34
    //   2674: astore_1
    //   2675: iload 12
    //   2677: istore 8
    //   2679: aload 35
    //   2681: astore 28
    //   2683: aload 33
    //   2685: astore 29
    //   2687: aload 36
    //   2689: astore 30
    //   2691: aload 43
    //   2693: iconst_1
    //   2694: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2697: goto -1142 -> 1555
    //   2700: astore_0
    //   2701: iconst_1
    //   2702: istore 6
    //   2704: aload 27
    //   2706: astore 28
    //   2708: iload 6
    //   2710: istore 8
    //   2712: aload_0
    //   2713: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   2716: aload 27
    //   2718: astore 28
    //   2720: iload 6
    //   2722: istore 8
    //   2724: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2727: ifeq +21 -> 2748
    //   2730: aload 27
    //   2732: astore 28
    //   2734: iload 6
    //   2736: istore 8
    //   2738: ldc 43
    //   2740: iconst_2
    //   2741: aload_0
    //   2742: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   2745: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2748: iload 6
    //   2750: ifeq +7 -> 2757
    //   2753: invokestatic 253	yak:b	()I
    //   2756: pop
    //   2757: aload 27
    //   2759: ifnull +1428 -> 4187
    //   2762: aload 27
    //   2764: invokevirtual 336	java/io/InputStream:close	()V
    //   2767: aconst_null
    //   2768: astore_0
    //   2769: goto -1974 -> 795
    //   2772: astore_1
    //   2773: iload 7
    //   2775: istore 6
    //   2777: aload 32
    //   2779: astore 31
    //   2781: aload_1
    //   2782: astore 32
    //   2784: aload 31
    //   2786: astore 27
    //   2788: aload 31
    //   2790: astore_1
    //   2791: iload 12
    //   2793: istore 8
    //   2795: aload 31
    //   2797: astore 28
    //   2799: aload 31
    //   2801: astore 29
    //   2803: aload 31
    //   2805: astore 30
    //   2807: aload 32
    //   2809: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2812: aload 31
    //   2814: astore 27
    //   2816: aload 31
    //   2818: astore_1
    //   2819: iload 12
    //   2821: istore 8
    //   2823: aload 31
    //   2825: astore 28
    //   2827: aload 31
    //   2829: astore 29
    //   2831: aload 31
    //   2833: astore 30
    //   2835: aload 31
    //   2837: invokevirtual 336	java/io/InputStream:close	()V
    //   2840: goto -923 -> 1917
    //   2843: aload 31
    //   2845: astore 27
    //   2847: aload 31
    //   2849: astore_1
    //   2850: iload 12
    //   2852: istore 8
    //   2854: aload 31
    //   2856: astore 28
    //   2858: aload 31
    //   2860: astore 29
    //   2862: aload 31
    //   2864: astore 30
    //   2866: aload 33
    //   2868: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2871: aload 31
    //   2873: astore 27
    //   2875: aload 31
    //   2877: astore_1
    //   2878: iload 12
    //   2880: istore 8
    //   2882: aload 31
    //   2884: astore 28
    //   2886: aload 31
    //   2888: astore 29
    //   2890: aload 31
    //   2892: astore 30
    //   2894: aload 31
    //   2896: invokevirtual 336	java/io/InputStream:close	()V
    //   2899: iload 6
    //   2901: istore 7
    //   2903: goto -620 -> 2283
    //   2906: iload 6
    //   2908: istore 7
    //   2910: iload 17
    //   2912: iload 14
    //   2914: iconst_2
    //   2915: imul
    //   2916: if_icmplt -633 -> 2283
    //   2919: iload 6
    //   2921: istore 7
    //   2923: iload 14
    //   2925: sipush 1280
    //   2928: if_icmpge -645 -> 2283
    //   2931: aload 31
    //   2933: astore 32
    //   2935: iload 12
    //   2937: istore 8
    //   2939: aload 42
    //   2941: aload_0
    //   2942: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2945: astore 31
    //   2947: aload 31
    //   2949: astore 27
    //   2951: aload 31
    //   2953: astore 32
    //   2955: aload 31
    //   2957: astore_1
    //   2958: iload 12
    //   2960: istore 8
    //   2962: aload 31
    //   2964: astore 28
    //   2966: aload 31
    //   2968: astore 29
    //   2970: aload 31
    //   2972: astore 30
    //   2974: aload 31
    //   2976: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2979: astore 33
    //   2981: aload 31
    //   2983: astore 27
    //   2985: aload 31
    //   2987: astore 32
    //   2989: aload 31
    //   2991: astore_1
    //   2992: iload 12
    //   2994: istore 8
    //   2996: aload 31
    //   2998: astore 28
    //   3000: aload 31
    //   3002: astore 29
    //   3004: aload 31
    //   3006: astore 30
    //   3008: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3011: ifeq +57 -> 3068
    //   3014: aload 31
    //   3016: astore 27
    //   3018: aload 31
    //   3020: astore 32
    //   3022: aload 31
    //   3024: astore_1
    //   3025: iload 12
    //   3027: istore 8
    //   3029: aload 31
    //   3031: astore 28
    //   3033: aload 31
    //   3035: astore 29
    //   3037: aload 31
    //   3039: astore 30
    //   3041: ldc 43
    //   3043: iconst_4
    //   3044: new 45	java/lang/StringBuilder
    //   3047: dup
    //   3048: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3051: ldc_w 446
    //   3054: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3057: aload 33
    //   3059: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3062: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3065: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3068: aload 31
    //   3070: astore 27
    //   3072: aload 31
    //   3074: astore 32
    //   3076: aload 31
    //   3078: astore_1
    //   3079: iload 12
    //   3081: istore 8
    //   3083: aload 31
    //   3085: astore 28
    //   3087: aload 31
    //   3089: astore 29
    //   3091: aload 31
    //   3093: astore 30
    //   3095: aload 31
    //   3097: invokevirtual 336	java/io/InputStream:close	()V
    //   3100: iload 6
    //   3102: istore 8
    //   3104: aload 33
    //   3106: ifnull +170 -> 3276
    //   3109: iload 6
    //   3111: istore 7
    //   3113: iload 14
    //   3115: iload 14
    //   3117: imul
    //   3118: newarray int
    //   3120: astore_1
    //   3121: iload 6
    //   3123: istore 7
    //   3125: aload 33
    //   3127: aload_1
    //   3128: iconst_0
    //   3129: iload 14
    //   3131: iconst_0
    //   3132: iconst_0
    //   3133: iload 14
    //   3135: iload 14
    //   3137: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3140: iload 6
    //   3142: istore 7
    //   3144: iload 14
    //   3146: iload 14
    //   3148: imul
    //   3149: newarray byte
    //   3151: astore 27
    //   3153: iload 6
    //   3155: istore 7
    //   3157: aload_1
    //   3158: aload 27
    //   3160: iload 14
    //   3162: iload 14
    //   3164: invokestatic 416	yak:a	([I[BII)I
    //   3167: istore 8
    //   3169: iload 8
    //   3171: istore 6
    //   3173: iload 8
    //   3175: iconst_1
    //   3176: if_icmpeq +42 -> 3218
    //   3179: iload 8
    //   3181: istore 7
    //   3183: aload 33
    //   3185: aload_1
    //   3186: iconst_0
    //   3187: iload 14
    //   3189: iload 17
    //   3191: iload 14
    //   3193: isub
    //   3194: iconst_0
    //   3195: iload 14
    //   3197: iload 14
    //   3199: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3202: iload 8
    //   3204: istore 7
    //   3206: aload_1
    //   3207: aload 27
    //   3209: iload 14
    //   3211: iload 14
    //   3213: invokestatic 416	yak:a	([I[BII)I
    //   3216: istore 6
    //   3218: iload 6
    //   3220: istore 7
    //   3222: aload 33
    //   3224: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   3227: iload 6
    //   3229: istore 8
    //   3231: iload 6
    //   3233: istore 7
    //   3235: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3238: ifeq +38 -> 3276
    //   3241: iload 6
    //   3243: istore 7
    //   3245: ldc 43
    //   3247: iconst_4
    //   3248: new 45	java/lang/StringBuilder
    //   3251: dup
    //   3252: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3255: ldc_w 448
    //   3258: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: iload 6
    //   3263: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3266: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3269: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3272: iload 6
    //   3274: istore 8
    //   3276: iload 8
    //   3278: istore 7
    //   3280: goto -997 -> 2283
    //   3283: astore_1
    //   3284: aload 32
    //   3286: astore 31
    //   3288: aload_1
    //   3289: astore 32
    //   3291: aload 31
    //   3293: astore 27
    //   3295: aload 31
    //   3297: astore_1
    //   3298: iload 12
    //   3300: istore 8
    //   3302: aload 31
    //   3304: astore 28
    //   3306: aload 31
    //   3308: astore 29
    //   3310: aload 31
    //   3312: astore 30
    //   3314: aload 32
    //   3316: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3319: aload 31
    //   3321: astore 27
    //   3323: aload 31
    //   3325: astore_1
    //   3326: iload 12
    //   3328: istore 8
    //   3330: aload 31
    //   3332: astore 28
    //   3334: aload 31
    //   3336: astore 29
    //   3338: aload 31
    //   3340: astore 30
    //   3342: aload 31
    //   3344: invokevirtual 336	java/io/InputStream:close	()V
    //   3347: iload 6
    //   3349: istore 7
    //   3351: goto -1068 -> 2283
    //   3354: aload_0
    //   3355: astore 27
    //   3357: aload_0
    //   3358: astore_1
    //   3359: iload 12
    //   3361: istore 8
    //   3363: aload_0
    //   3364: astore 28
    //   3366: aload_0
    //   3367: astore 29
    //   3369: aload_0
    //   3370: astore 30
    //   3372: aload 32
    //   3374: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3377: aload_0
    //   3378: astore 27
    //   3380: aload_0
    //   3381: astore_1
    //   3382: iload 12
    //   3384: istore 8
    //   3386: aload_0
    //   3387: astore 28
    //   3389: aload_0
    //   3390: astore 29
    //   3392: aload_0
    //   3393: astore 30
    //   3395: aload_0
    //   3396: invokevirtual 336	java/io/InputStream:close	()V
    //   3399: aconst_null
    //   3400: astore_0
    //   3401: iconst_1
    //   3402: istore 6
    //   3404: goto -2820 -> 584
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 6
    //   3412: istore 12
    //   3414: aload_0
    //   3415: astore 30
    //   3417: iload 6
    //   3419: istore 11
    //   3421: aload_0
    //   3422: astore 31
    //   3424: iload 6
    //   3426: istore 9
    //   3428: aload_0
    //   3429: astore 29
    //   3431: iload 6
    //   3433: istore 10
    //   3435: aload_0
    //   3436: astore 28
    //   3438: iload 6
    //   3440: istore 8
    //   3442: new 240	android/util/Pair
    //   3445: dup
    //   3446: aconst_null
    //   3447: aconst_null
    //   3448: invokespecial 243	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3451: astore_1
    //   3452: aload_0
    //   3453: astore 27
    //   3455: goto -2683 -> 772
    //   3458: astore_0
    //   3459: iload 12
    //   3461: istore 6
    //   3463: goto -759 -> 2704
    //   3466: astore 27
    //   3468: aload 27
    //   3470: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3473: aload_1
    //   3474: astore_0
    //   3475: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3478: ifeq -2683 -> 795
    //   3481: ldc 43
    //   3483: iconst_2
    //   3484: aload 27
    //   3486: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3489: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3492: aload_1
    //   3493: astore_0
    //   3494: goto -2699 -> 795
    //   3497: astore_0
    //   3498: aload_0
    //   3499: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3502: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3505: ifeq +13 -> 3518
    //   3508: ldc 43
    //   3510: iconst_2
    //   3511: aload_0
    //   3512: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3515: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3518: aconst_null
    //   3519: astore_0
    //   3520: goto -2725 -> 795
    //   3523: astore_0
    //   3524: iload 11
    //   3526: istore 6
    //   3528: aload 30
    //   3530: astore_1
    //   3531: iload 6
    //   3533: istore 8
    //   3535: aload_0
    //   3536: invokevirtual 264	java/lang/RuntimeException:printStackTrace	()V
    //   3539: aload 30
    //   3541: astore_1
    //   3542: iload 6
    //   3544: istore 8
    //   3546: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3549: ifeq +20 -> 3569
    //   3552: aload 30
    //   3554: astore_1
    //   3555: iload 6
    //   3557: istore 8
    //   3559: ldc 43
    //   3561: iconst_2
    //   3562: aload_0
    //   3563: invokevirtual 265	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3566: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3569: iload 6
    //   3571: ifeq +7 -> 3578
    //   3574: invokestatic 253	yak:b	()I
    //   3577: pop
    //   3578: aload 30
    //   3580: ifnull +607 -> 4187
    //   3583: aload 30
    //   3585: invokevirtual 336	java/io/InputStream:close	()V
    //   3588: aconst_null
    //   3589: astore_0
    //   3590: goto -2795 -> 795
    //   3593: astore_0
    //   3594: aload_0
    //   3595: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3598: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3601: ifeq +13 -> 3614
    //   3604: ldc 43
    //   3606: iconst_2
    //   3607: aload_0
    //   3608: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3611: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3614: aconst_null
    //   3615: astore_0
    //   3616: goto -2821 -> 795
    //   3619: astore_0
    //   3620: iload 9
    //   3622: istore 6
    //   3624: aload 31
    //   3626: astore 29
    //   3628: aload 29
    //   3630: astore_1
    //   3631: iload 6
    //   3633: istore 8
    //   3635: aload_0
    //   3636: invokevirtual 269	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3639: aload 29
    //   3641: astore_1
    //   3642: iload 6
    //   3644: istore 8
    //   3646: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3649: ifeq +20 -> 3669
    //   3652: aload 29
    //   3654: astore_1
    //   3655: iload 6
    //   3657: istore 8
    //   3659: ldc 43
    //   3661: iconst_2
    //   3662: aload_0
    //   3663: invokevirtual 270	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3666: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3669: iload 6
    //   3671: ifeq +7 -> 3678
    //   3674: invokestatic 253	yak:b	()I
    //   3677: pop
    //   3678: aload 29
    //   3680: ifnull +507 -> 4187
    //   3683: aload 29
    //   3685: invokevirtual 336	java/io/InputStream:close	()V
    //   3688: aconst_null
    //   3689: astore_0
    //   3690: goto -2895 -> 795
    //   3693: astore_0
    //   3694: aload_0
    //   3695: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3698: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3701: ifeq +13 -> 3714
    //   3704: ldc 43
    //   3706: iconst_2
    //   3707: aload_0
    //   3708: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3711: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3714: aconst_null
    //   3715: astore_0
    //   3716: goto -2921 -> 795
    //   3719: astore_0
    //   3720: iload 10
    //   3722: istore 6
    //   3724: aload 29
    //   3726: astore 28
    //   3728: aload 28
    //   3730: astore_1
    //   3731: iload 6
    //   3733: istore 8
    //   3735: aload_0
    //   3736: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   3739: aload 28
    //   3741: astore_1
    //   3742: iload 6
    //   3744: istore 8
    //   3746: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3749: ifeq +20 -> 3769
    //   3752: aload 28
    //   3754: astore_1
    //   3755: iload 6
    //   3757: istore 8
    //   3759: ldc 43
    //   3761: iconst_2
    //   3762: aload_0
    //   3763: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3766: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3769: iload 6
    //   3771: ifeq +7 -> 3778
    //   3774: invokestatic 253	yak:b	()I
    //   3777: pop
    //   3778: aload 28
    //   3780: ifnull +407 -> 4187
    //   3783: aload 28
    //   3785: invokevirtual 336	java/io/InputStream:close	()V
    //   3788: aconst_null
    //   3789: astore_0
    //   3790: goto -2995 -> 795
    //   3793: astore_0
    //   3794: aload_0
    //   3795: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3798: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3801: ifeq +13 -> 3814
    //   3804: ldc 43
    //   3806: iconst_2
    //   3807: aload_0
    //   3808: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3811: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3814: aconst_null
    //   3815: astore_0
    //   3816: goto -3021 -> 795
    //   3819: astore_0
    //   3820: aload 28
    //   3822: astore_1
    //   3823: iload 8
    //   3825: ifeq +7 -> 3832
    //   3828: invokestatic 253	yak:b	()I
    //   3831: pop
    //   3832: aload_1
    //   3833: ifnull +7 -> 3840
    //   3836: aload_1
    //   3837: invokevirtual 336	java/io/InputStream:close	()V
    //   3840: aload_0
    //   3841: athrow
    //   3842: astore_1
    //   3843: aload_1
    //   3844: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3847: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3850: ifeq -10 -> 3840
    //   3853: ldc 43
    //   3855: iconst_2
    //   3856: aload_1
    //   3857: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3860: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3863: goto -23 -> 3840
    //   3866: astore_0
    //   3867: iload 10
    //   3869: istore 8
    //   3871: goto -48 -> 3823
    //   3874: astore_0
    //   3875: iconst_1
    //   3876: istore 8
    //   3878: goto -55 -> 3823
    //   3881: astore_0
    //   3882: goto -59 -> 3823
    //   3885: astore_0
    //   3886: aconst_null
    //   3887: astore_1
    //   3888: iload 13
    //   3890: istore 8
    //   3892: goto -69 -> 3823
    //   3895: astore_0
    //   3896: aconst_null
    //   3897: astore_1
    //   3898: iload 13
    //   3900: istore 8
    //   3902: goto -79 -> 3823
    //   3905: astore_0
    //   3906: iload 12
    //   3908: istore 6
    //   3910: aload_1
    //   3911: astore 28
    //   3913: goto -185 -> 3728
    //   3916: astore_0
    //   3917: iload 10
    //   3919: istore 6
    //   3921: goto -193 -> 3728
    //   3924: astore_0
    //   3925: aconst_null
    //   3926: astore 28
    //   3928: iload 10
    //   3930: istore 6
    //   3932: goto -204 -> 3728
    //   3935: astore_0
    //   3936: aconst_null
    //   3937: astore 28
    //   3939: iload 10
    //   3941: istore 6
    //   3943: goto -215 -> 3728
    //   3946: astore_0
    //   3947: iload 9
    //   3949: istore 6
    //   3951: aload_1
    //   3952: astore 29
    //   3954: goto -326 -> 3628
    //   3957: astore_0
    //   3958: iconst_1
    //   3959: istore 6
    //   3961: aload_1
    //   3962: astore 29
    //   3964: goto -336 -> 3628
    //   3967: astore_0
    //   3968: iload 9
    //   3970: istore 6
    //   3972: goto -344 -> 3628
    //   3975: astore_0
    //   3976: aconst_null
    //   3977: astore 29
    //   3979: iload 9
    //   3981: istore 6
    //   3983: goto -355 -> 3628
    //   3986: astore_0
    //   3987: aconst_null
    //   3988: astore 29
    //   3990: iload 9
    //   3992: istore 6
    //   3994: goto -366 -> 3628
    //   3997: astore_0
    //   3998: iload 8
    //   4000: istore 6
    //   4002: aload_1
    //   4003: astore 30
    //   4005: goto -477 -> 3528
    //   4008: astore_0
    //   4009: iconst_1
    //   4010: istore 6
    //   4012: aload_1
    //   4013: astore 30
    //   4015: goto -487 -> 3528
    //   4018: astore_0
    //   4019: iload 11
    //   4021: istore 6
    //   4023: goto -495 -> 3528
    //   4026: astore_0
    //   4027: aconst_null
    //   4028: astore 30
    //   4030: iload 11
    //   4032: istore 6
    //   4034: goto -506 -> 3528
    //   4037: astore_0
    //   4038: aconst_null
    //   4039: astore 30
    //   4041: iload 11
    //   4043: istore 6
    //   4045: goto -517 -> 3528
    //   4048: astore_0
    //   4049: aload_1
    //   4050: astore 27
    //   4052: iload 11
    //   4054: istore 6
    //   4056: goto -1352 -> 2704
    //   4059: astore_0
    //   4060: iconst_1
    //   4061: istore 6
    //   4063: aload_1
    //   4064: astore 27
    //   4066: goto -1362 -> 2704
    //   4069: astore_0
    //   4070: aconst_null
    //   4071: astore 27
    //   4073: iconst_1
    //   4074: istore 6
    //   4076: goto -1372 -> 2704
    //   4079: astore_0
    //   4080: iconst_1
    //   4081: istore 6
    //   4083: aconst_null
    //   4084: astore 27
    //   4086: goto -1382 -> 2704
    //   4089: astore 32
    //   4091: aconst_null
    //   4092: astore_0
    //   4093: goto -739 -> 3354
    //   4096: astore 32
    //   4098: aconst_null
    //   4099: astore_0
    //   4100: goto -746 -> 3354
    //   4103: astore 32
    //   4105: aconst_null
    //   4106: astore 31
    //   4108: iload 7
    //   4110: istore 6
    //   4112: goto -821 -> 3291
    //   4115: astore 33
    //   4117: aconst_null
    //   4118: astore 31
    //   4120: iload 7
    //   4122: istore 6
    //   4124: goto -1281 -> 2843
    //   4127: astore 33
    //   4129: aconst_null
    //   4130: astore 31
    //   4132: goto -1289 -> 2843
    //   4135: astore 32
    //   4137: aconst_null
    //   4138: astore 31
    //   4140: goto -1356 -> 2784
    //   4143: astore_0
    //   4144: iconst_1
    //   4145: istore 6
    //   4147: goto -3222 -> 925
    //   4150: astore_0
    //   4151: iconst_1
    //   4152: istore 8
    //   4154: iload 6
    //   4156: istore 7
    //   4158: iload 8
    //   4160: istore 6
    //   4162: goto -3237 -> 925
    //   4165: astore_0
    //   4166: iconst_1
    //   4167: istore 6
    //   4169: goto -3327 -> 842
    //   4172: astore_0
    //   4173: iconst_1
    //   4174: istore 8
    //   4176: iload 6
    //   4178: istore 7
    //   4180: iload 8
    //   4182: istore 6
    //   4184: goto -3342 -> 842
    //   4187: aconst_null
    //   4188: astore_0
    //   4189: goto -3394 -> 795
    //   4192: aconst_null
    //   4193: astore_1
    //   4194: aload_0
    //   4195: astore 27
    //   4197: goto -3425 -> 772
    //   4200: iload 7
    //   4202: istore 6
    //   4204: goto -1552 -> 2652
    //   4207: iconst_1
    //   4208: istore 6
    //   4210: aload 33
    //   4212: astore_0
    //   4213: goto -3629 -> 584
    //   4216: goto -1975 -> 2241
    //   4219: goto -1940 -> 2279
    //   4222: iconst_0
    //   4223: istore 7
    //   4225: iconst_m1
    //   4226: istore 8
    //   4228: goto -3654 -> 574
    //   4231: aload_1
    //   4232: astore 27
    //   4234: aconst_null
    //   4235: astore_1
    //   4236: iload 24
    //   4238: istore 6
    //   4240: goto -3468 -> 772
    //   4243: aload_1
    //   4244: astore_0
    //   4245: goto -3661 -> 584
    //   4248: astore_0
    //   4249: iload 22
    //   4251: istore 6
    //   4253: goto -3328 -> 925
    //   4256: aload_1
    //   4257: astore_0
    //   4258: goto -3674 -> 584
    //   4261: astore 33
    //   4263: aload 32
    //   4265: astore 31
    //   4267: goto -1424 -> 2843
    //   4270: astore 32
    //   4272: aload 31
    //   4274: astore_0
    //   4275: goto -921 -> 3354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4278	0	paramUri	Uri
    //   0	4278	1	paramContext	Context
    //   0	4278	2	paramBoolean1	boolean
    //   0	4278	3	paramBoolean2	boolean
    //   1512	28	4	d	double
    //   76	4176	6	i	int
    //   20	4204	7	j	int
    //   146	4081	8	k	int
    //   130	3861	9	m	int
    //   138	3802	10	n	int
    //   122	3931	11	i1	int
    //   114	3793	12	i2	int
    //   100	3799	13	i3	int
    //   103	3109	14	i4	int
    //   79	1777	15	i5	int
    //   88	1385	16	i6	int
    //   91	3103	17	i7	int
    //   97	1003	18	i8	int
    //   82	1376	19	i9	int
    //   85	1380	20	i10	int
    //   70	769	21	i11	int
    //   73	4177	22	i12	int
    //   94	1002	23	i13	int
    //   106	4131	24	i14	int
    //   17	807	25	l	long
    //   9	3445	27	localObject1	Object
    //   3466	19	27	localIOException	java.io.IOException
    //   4050	183	27	localObject2	Object
    //   142	3796	28	localObject3	Object
    //   134	3855	29	localObject4	Object
    //   118	3922	30	localObject5	Object
    //   126	4147	31	localObject6	Object
    //   55	3318	32	localObject7	Object
    //   4089	1	32	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   4096	1	32	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4103	1	32	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4135	129	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4270	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   67	3156	33	localBitmap	Bitmap
    //   4115	1	33	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4127	84	33	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4261	1	33	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   61	2612	34	localObject8	Object
    //   64	2616	35	localObject9	Object
    //   58	2630	36	localObject10	Object
    //   1145	1524	37	localObject11	Object
    //   1122	324	38	localObject12	Object
    //   1125	329	39	localObject13	Object
    //   1130	339	40	localObject14	Object
    //   1119	319	41	localObject15	Object
    //   152	2788	42	localContentResolver	android.content.ContentResolver
    //   1035	1657	43	localOptions	android.graphics.BitmapFactory.Options
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
    //   1537	1555	2700	java/io/IOException
    //   1578	1586	2700	java/io/IOException
    //   1613	1623	2700	java/io/IOException
    //   1650	1656	2700	java/io/IOException
    //   1683	1746	2700	java/io/IOException
    //   1773	1778	2700	java/io/IOException
    //   1968	1976	2700	java/io/IOException
    //   2003	2010	2700	java/io/IOException
    //   2037	2043	2700	java/io/IOException
    //   2070	2097	2700	java/io/IOException
    //   2124	2129	2700	java/io/IOException
    //   2333	2342	2700	java/io/IOException
    //   2373	2389	2700	java/io/IOException
    //   2412	2419	2700	java/io/IOException
    //   2440	2449	2700	java/io/IOException
    //   2470	2476	2700	java/io/IOException
    //   2497	2524	2700	java/io/IOException
    //   2545	2549	2700	java/io/IOException
    //   2691	2697	2700	java/io/IOException
    //   2807	2812	2700	java/io/IOException
    //   2835	2840	2700	java/io/IOException
    //   2866	2871	2700	java/io/IOException
    //   2894	2899	2700	java/io/IOException
    //   2939	2947	2700	java/io/IOException
    //   2974	2981	2700	java/io/IOException
    //   3008	3014	2700	java/io/IOException
    //   3041	3068	2700	java/io/IOException
    //   3095	3100	2700	java/io/IOException
    //   3314	3319	2700	java/io/IOException
    //   3342	3347	2700	java/io/IOException
    //   3372	3377	2700	java/io/IOException
    //   3395	3399	2700	java/io/IOException
    //   1578	1586	2772	java/lang/OutOfMemoryError
    //   1613	1623	2772	java/lang/OutOfMemoryError
    //   1650	1656	2772	java/lang/OutOfMemoryError
    //   1683	1746	2772	java/lang/OutOfMemoryError
    //   1773	1778	2772	java/lang/OutOfMemoryError
    //   2939	2947	3283	java/lang/OutOfMemoryError
    //   2974	2981	3283	java/lang/OutOfMemoryError
    //   3008	3014	3283	java/lang/OutOfMemoryError
    //   3041	3068	3283	java/lang/OutOfMemoryError
    //   3095	3100	3283	java/lang/OutOfMemoryError
    //   148	154	3458	java/io/IOException
    //   194	201	3458	java/io/IOException
    //   629	637	3458	java/io/IOException
    //   672	681	3458	java/io/IOException
    //   716	723	3458	java/io/IOException
    //   758	769	3458	java/io/IOException
    //   1186	1193	3458	java/io/IOException
    //   1232	1239	3458	java/io/IOException
    //   1278	1284	3458	java/io/IOException
    //   1382	1390	3458	java/io/IOException
    //   1476	1480	3458	java/io/IOException
    //   3442	3452	3458	java/io/IOException
    //   788	793	3466	java/io/IOException
    //   2762	2767	3497	java/io/IOException
    //   148	154	3523	java/lang/RuntimeException
    //   194	201	3523	java/lang/RuntimeException
    //   629	637	3523	java/lang/RuntimeException
    //   672	681	3523	java/lang/RuntimeException
    //   716	723	3523	java/lang/RuntimeException
    //   758	769	3523	java/lang/RuntimeException
    //   1186	1193	3523	java/lang/RuntimeException
    //   1232	1239	3523	java/lang/RuntimeException
    //   1278	1284	3523	java/lang/RuntimeException
    //   1382	1390	3523	java/lang/RuntimeException
    //   1476	1480	3523	java/lang/RuntimeException
    //   3442	3452	3523	java/lang/RuntimeException
    //   3583	3588	3593	java/io/IOException
    //   148	154	3619	java/lang/UnsatisfiedLinkError
    //   194	201	3619	java/lang/UnsatisfiedLinkError
    //   629	637	3619	java/lang/UnsatisfiedLinkError
    //   672	681	3619	java/lang/UnsatisfiedLinkError
    //   716	723	3619	java/lang/UnsatisfiedLinkError
    //   758	769	3619	java/lang/UnsatisfiedLinkError
    //   1186	1193	3619	java/lang/UnsatisfiedLinkError
    //   1232	1239	3619	java/lang/UnsatisfiedLinkError
    //   1278	1284	3619	java/lang/UnsatisfiedLinkError
    //   1382	1390	3619	java/lang/UnsatisfiedLinkError
    //   1476	1480	3619	java/lang/UnsatisfiedLinkError
    //   3442	3452	3619	java/lang/UnsatisfiedLinkError
    //   3683	3688	3693	java/io/IOException
    //   148	154	3719	java/lang/Throwable
    //   194	201	3719	java/lang/Throwable
    //   629	637	3719	java/lang/Throwable
    //   672	681	3719	java/lang/Throwable
    //   716	723	3719	java/lang/Throwable
    //   758	769	3719	java/lang/Throwable
    //   1186	1193	3719	java/lang/Throwable
    //   1232	1239	3719	java/lang/Throwable
    //   1278	1284	3719	java/lang/Throwable
    //   1382	1390	3719	java/lang/Throwable
    //   1476	1480	3719	java/lang/Throwable
    //   3442	3452	3719	java/lang/Throwable
    //   3783	3788	3793	java/io/IOException
    //   148	154	3819	finally
    //   194	201	3819	finally
    //   629	637	3819	finally
    //   672	681	3819	finally
    //   716	723	3819	finally
    //   758	769	3819	finally
    //   1186	1193	3819	finally
    //   1232	1239	3819	finally
    //   1278	1284	3819	finally
    //   1382	1390	3819	finally
    //   1476	1480	3819	finally
    //   2712	2716	3819	finally
    //   2724	2730	3819	finally
    //   2738	2748	3819	finally
    //   3442	3452	3819	finally
    //   3836	3840	3842	java/io/IOException
    //   225	233	3866	finally
    //   249	255	3866	finally
    //   271	297	3866	finally
    //   317	323	3866	finally
    //   339	345	3866	finally
    //   361	369	3866	finally
    //   430	439	3866	finally
    //   455	470	3866	finally
    //   486	490	3866	finally
    //   506	510	3866	finally
    //   862	866	3866	finally
    //   886	892	3866	finally
    //   912	922	3866	finally
    //   945	949	3866	finally
    //   969	975	3866	finally
    //   995	1005	3866	finally
    //   1028	1037	3866	finally
    //   1057	1063	3866	finally
    //   1083	1091	3866	finally
    //   1111	1115	3866	finally
    //   513	525	3874	finally
    //   533	566	3874	finally
    //   1537	1555	3881	finally
    //   1578	1586	3881	finally
    //   1613	1623	3881	finally
    //   1650	1656	3881	finally
    //   1683	1746	3881	finally
    //   1773	1778	3881	finally
    //   1968	1976	3881	finally
    //   2003	2010	3881	finally
    //   2037	2043	3881	finally
    //   2070	2097	3881	finally
    //   2124	2129	3881	finally
    //   2333	2342	3881	finally
    //   2373	2389	3881	finally
    //   2412	2419	3881	finally
    //   2440	2449	3881	finally
    //   2470	2476	3881	finally
    //   2497	2524	3881	finally
    //   2545	2549	3881	finally
    //   2691	2697	3881	finally
    //   2807	2812	3881	finally
    //   2835	2840	3881	finally
    //   2866	2871	3881	finally
    //   2894	2899	3881	finally
    //   2939	2947	3881	finally
    //   2974	2981	3881	finally
    //   3008	3014	3881	finally
    //   3041	3068	3881	finally
    //   3095	3100	3881	finally
    //   3314	3319	3881	finally
    //   3342	3347	3881	finally
    //   3372	3377	3881	finally
    //   3395	3399	3881	finally
    //   3535	3539	3881	finally
    //   3546	3552	3881	finally
    //   3559	3569	3881	finally
    //   3635	3639	3881	finally
    //   3646	3652	3881	finally
    //   3659	3669	3881	finally
    //   3735	3739	3881	finally
    //   3746	3752	3881	finally
    //   3759	3769	3881	finally
    //   1791	1798	3885	finally
    //   1802	1809	3885	finally
    //   1813	1821	3885	finally
    //   1825	1840	3885	finally
    //   1844	1849	3885	finally
    //   1853	1864	3885	finally
    //   1872	1878	3885	finally
    //   1882	1909	3885	finally
    //   2138	2147	3895	finally
    //   2151	2167	3895	finally
    //   2171	2179	3895	finally
    //   2183	2195	3895	finally
    //   2205	2225	3895	finally
    //   2229	2241	3895	finally
    //   2241	2279	3895	finally
    //   2554	2607	3895	finally
    //   2615	2648	3895	finally
    //   3113	3121	3895	finally
    //   3125	3140	3895	finally
    //   3144	3153	3895	finally
    //   3157	3169	3895	finally
    //   3183	3202	3895	finally
    //   3206	3218	3895	finally
    //   3222	3227	3895	finally
    //   3235	3241	3895	finally
    //   3245	3272	3895	finally
    //   862	866	3905	java/lang/Throwable
    //   886	892	3905	java/lang/Throwable
    //   912	922	3905	java/lang/Throwable
    //   945	949	3905	java/lang/Throwable
    //   969	975	3905	java/lang/Throwable
    //   995	1005	3905	java/lang/Throwable
    //   1028	1037	3905	java/lang/Throwable
    //   1057	1063	3905	java/lang/Throwable
    //   1083	1091	3905	java/lang/Throwable
    //   1111	1115	3905	java/lang/Throwable
    //   1537	1555	3916	java/lang/Throwable
    //   1578	1586	3916	java/lang/Throwable
    //   1613	1623	3916	java/lang/Throwable
    //   1650	1656	3916	java/lang/Throwable
    //   1683	1746	3916	java/lang/Throwable
    //   1773	1778	3916	java/lang/Throwable
    //   1968	1976	3916	java/lang/Throwable
    //   2003	2010	3916	java/lang/Throwable
    //   2037	2043	3916	java/lang/Throwable
    //   2070	2097	3916	java/lang/Throwable
    //   2124	2129	3916	java/lang/Throwable
    //   2333	2342	3916	java/lang/Throwable
    //   2373	2389	3916	java/lang/Throwable
    //   2412	2419	3916	java/lang/Throwable
    //   2440	2449	3916	java/lang/Throwable
    //   2470	2476	3916	java/lang/Throwable
    //   2497	2524	3916	java/lang/Throwable
    //   2545	2549	3916	java/lang/Throwable
    //   2691	2697	3916	java/lang/Throwable
    //   2807	2812	3916	java/lang/Throwable
    //   2835	2840	3916	java/lang/Throwable
    //   2866	2871	3916	java/lang/Throwable
    //   2894	2899	3916	java/lang/Throwable
    //   2939	2947	3916	java/lang/Throwable
    //   2974	2981	3916	java/lang/Throwable
    //   3008	3014	3916	java/lang/Throwable
    //   3041	3068	3916	java/lang/Throwable
    //   3095	3100	3916	java/lang/Throwable
    //   3314	3319	3916	java/lang/Throwable
    //   3342	3347	3916	java/lang/Throwable
    //   3372	3377	3916	java/lang/Throwable
    //   3395	3399	3916	java/lang/Throwable
    //   1791	1798	3924	java/lang/Throwable
    //   1802	1809	3924	java/lang/Throwable
    //   1813	1821	3924	java/lang/Throwable
    //   1825	1840	3924	java/lang/Throwable
    //   1844	1849	3924	java/lang/Throwable
    //   1853	1864	3924	java/lang/Throwable
    //   1872	1878	3924	java/lang/Throwable
    //   1882	1909	3924	java/lang/Throwable
    //   2138	2147	3935	java/lang/Throwable
    //   2151	2167	3935	java/lang/Throwable
    //   2171	2179	3935	java/lang/Throwable
    //   2183	2195	3935	java/lang/Throwable
    //   2205	2225	3935	java/lang/Throwable
    //   2229	2241	3935	java/lang/Throwable
    //   2241	2279	3935	java/lang/Throwable
    //   2554	2607	3935	java/lang/Throwable
    //   2615	2648	3935	java/lang/Throwable
    //   3113	3121	3935	java/lang/Throwable
    //   3125	3140	3935	java/lang/Throwable
    //   3144	3153	3935	java/lang/Throwable
    //   3157	3169	3935	java/lang/Throwable
    //   3183	3202	3935	java/lang/Throwable
    //   3206	3218	3935	java/lang/Throwable
    //   3222	3227	3935	java/lang/Throwable
    //   3235	3241	3935	java/lang/Throwable
    //   3245	3272	3935	java/lang/Throwable
    //   225	233	3946	java/lang/UnsatisfiedLinkError
    //   249	255	3946	java/lang/UnsatisfiedLinkError
    //   271	297	3946	java/lang/UnsatisfiedLinkError
    //   317	323	3946	java/lang/UnsatisfiedLinkError
    //   339	345	3946	java/lang/UnsatisfiedLinkError
    //   361	369	3946	java/lang/UnsatisfiedLinkError
    //   430	439	3946	java/lang/UnsatisfiedLinkError
    //   455	470	3946	java/lang/UnsatisfiedLinkError
    //   486	490	3946	java/lang/UnsatisfiedLinkError
    //   506	510	3946	java/lang/UnsatisfiedLinkError
    //   862	866	3946	java/lang/UnsatisfiedLinkError
    //   886	892	3946	java/lang/UnsatisfiedLinkError
    //   912	922	3946	java/lang/UnsatisfiedLinkError
    //   945	949	3946	java/lang/UnsatisfiedLinkError
    //   969	975	3946	java/lang/UnsatisfiedLinkError
    //   995	1005	3946	java/lang/UnsatisfiedLinkError
    //   1028	1037	3946	java/lang/UnsatisfiedLinkError
    //   1057	1063	3946	java/lang/UnsatisfiedLinkError
    //   1083	1091	3946	java/lang/UnsatisfiedLinkError
    //   1111	1115	3946	java/lang/UnsatisfiedLinkError
    //   513	525	3957	java/lang/UnsatisfiedLinkError
    //   533	566	3957	java/lang/UnsatisfiedLinkError
    //   1537	1555	3967	java/lang/UnsatisfiedLinkError
    //   1578	1586	3967	java/lang/UnsatisfiedLinkError
    //   1613	1623	3967	java/lang/UnsatisfiedLinkError
    //   1650	1656	3967	java/lang/UnsatisfiedLinkError
    //   1683	1746	3967	java/lang/UnsatisfiedLinkError
    //   1773	1778	3967	java/lang/UnsatisfiedLinkError
    //   1968	1976	3967	java/lang/UnsatisfiedLinkError
    //   2003	2010	3967	java/lang/UnsatisfiedLinkError
    //   2037	2043	3967	java/lang/UnsatisfiedLinkError
    //   2070	2097	3967	java/lang/UnsatisfiedLinkError
    //   2124	2129	3967	java/lang/UnsatisfiedLinkError
    //   2333	2342	3967	java/lang/UnsatisfiedLinkError
    //   2373	2389	3967	java/lang/UnsatisfiedLinkError
    //   2412	2419	3967	java/lang/UnsatisfiedLinkError
    //   2440	2449	3967	java/lang/UnsatisfiedLinkError
    //   2470	2476	3967	java/lang/UnsatisfiedLinkError
    //   2497	2524	3967	java/lang/UnsatisfiedLinkError
    //   2545	2549	3967	java/lang/UnsatisfiedLinkError
    //   2691	2697	3967	java/lang/UnsatisfiedLinkError
    //   2807	2812	3967	java/lang/UnsatisfiedLinkError
    //   2835	2840	3967	java/lang/UnsatisfiedLinkError
    //   2866	2871	3967	java/lang/UnsatisfiedLinkError
    //   2894	2899	3967	java/lang/UnsatisfiedLinkError
    //   2939	2947	3967	java/lang/UnsatisfiedLinkError
    //   2974	2981	3967	java/lang/UnsatisfiedLinkError
    //   3008	3014	3967	java/lang/UnsatisfiedLinkError
    //   3041	3068	3967	java/lang/UnsatisfiedLinkError
    //   3095	3100	3967	java/lang/UnsatisfiedLinkError
    //   3314	3319	3967	java/lang/UnsatisfiedLinkError
    //   3342	3347	3967	java/lang/UnsatisfiedLinkError
    //   3372	3377	3967	java/lang/UnsatisfiedLinkError
    //   3395	3399	3967	java/lang/UnsatisfiedLinkError
    //   1791	1798	3975	java/lang/UnsatisfiedLinkError
    //   1802	1809	3975	java/lang/UnsatisfiedLinkError
    //   1813	1821	3975	java/lang/UnsatisfiedLinkError
    //   1825	1840	3975	java/lang/UnsatisfiedLinkError
    //   1844	1849	3975	java/lang/UnsatisfiedLinkError
    //   1853	1864	3975	java/lang/UnsatisfiedLinkError
    //   1872	1878	3975	java/lang/UnsatisfiedLinkError
    //   1882	1909	3975	java/lang/UnsatisfiedLinkError
    //   2138	2147	3986	java/lang/UnsatisfiedLinkError
    //   2151	2167	3986	java/lang/UnsatisfiedLinkError
    //   2171	2179	3986	java/lang/UnsatisfiedLinkError
    //   2183	2195	3986	java/lang/UnsatisfiedLinkError
    //   2205	2225	3986	java/lang/UnsatisfiedLinkError
    //   2229	2241	3986	java/lang/UnsatisfiedLinkError
    //   2241	2279	3986	java/lang/UnsatisfiedLinkError
    //   2554	2607	3986	java/lang/UnsatisfiedLinkError
    //   2615	2648	3986	java/lang/UnsatisfiedLinkError
    //   3113	3121	3986	java/lang/UnsatisfiedLinkError
    //   3125	3140	3986	java/lang/UnsatisfiedLinkError
    //   3144	3153	3986	java/lang/UnsatisfiedLinkError
    //   3157	3169	3986	java/lang/UnsatisfiedLinkError
    //   3183	3202	3986	java/lang/UnsatisfiedLinkError
    //   3206	3218	3986	java/lang/UnsatisfiedLinkError
    //   3222	3227	3986	java/lang/UnsatisfiedLinkError
    //   3235	3241	3986	java/lang/UnsatisfiedLinkError
    //   3245	3272	3986	java/lang/UnsatisfiedLinkError
    //   225	233	3997	java/lang/RuntimeException
    //   249	255	3997	java/lang/RuntimeException
    //   271	297	3997	java/lang/RuntimeException
    //   317	323	3997	java/lang/RuntimeException
    //   339	345	3997	java/lang/RuntimeException
    //   361	369	3997	java/lang/RuntimeException
    //   430	439	3997	java/lang/RuntimeException
    //   455	470	3997	java/lang/RuntimeException
    //   486	490	3997	java/lang/RuntimeException
    //   506	510	3997	java/lang/RuntimeException
    //   862	866	3997	java/lang/RuntimeException
    //   886	892	3997	java/lang/RuntimeException
    //   912	922	3997	java/lang/RuntimeException
    //   945	949	3997	java/lang/RuntimeException
    //   969	975	3997	java/lang/RuntimeException
    //   995	1005	3997	java/lang/RuntimeException
    //   1028	1037	3997	java/lang/RuntimeException
    //   1057	1063	3997	java/lang/RuntimeException
    //   1083	1091	3997	java/lang/RuntimeException
    //   1111	1115	3997	java/lang/RuntimeException
    //   513	525	4008	java/lang/RuntimeException
    //   533	566	4008	java/lang/RuntimeException
    //   1537	1555	4018	java/lang/RuntimeException
    //   1578	1586	4018	java/lang/RuntimeException
    //   1613	1623	4018	java/lang/RuntimeException
    //   1650	1656	4018	java/lang/RuntimeException
    //   1683	1746	4018	java/lang/RuntimeException
    //   1773	1778	4018	java/lang/RuntimeException
    //   1968	1976	4018	java/lang/RuntimeException
    //   2003	2010	4018	java/lang/RuntimeException
    //   2037	2043	4018	java/lang/RuntimeException
    //   2070	2097	4018	java/lang/RuntimeException
    //   2124	2129	4018	java/lang/RuntimeException
    //   2333	2342	4018	java/lang/RuntimeException
    //   2373	2389	4018	java/lang/RuntimeException
    //   2412	2419	4018	java/lang/RuntimeException
    //   2440	2449	4018	java/lang/RuntimeException
    //   2470	2476	4018	java/lang/RuntimeException
    //   2497	2524	4018	java/lang/RuntimeException
    //   2545	2549	4018	java/lang/RuntimeException
    //   2691	2697	4018	java/lang/RuntimeException
    //   2807	2812	4018	java/lang/RuntimeException
    //   2835	2840	4018	java/lang/RuntimeException
    //   2866	2871	4018	java/lang/RuntimeException
    //   2894	2899	4018	java/lang/RuntimeException
    //   2939	2947	4018	java/lang/RuntimeException
    //   2974	2981	4018	java/lang/RuntimeException
    //   3008	3014	4018	java/lang/RuntimeException
    //   3041	3068	4018	java/lang/RuntimeException
    //   3095	3100	4018	java/lang/RuntimeException
    //   3314	3319	4018	java/lang/RuntimeException
    //   3342	3347	4018	java/lang/RuntimeException
    //   3372	3377	4018	java/lang/RuntimeException
    //   3395	3399	4018	java/lang/RuntimeException
    //   1791	1798	4026	java/lang/RuntimeException
    //   1802	1809	4026	java/lang/RuntimeException
    //   1813	1821	4026	java/lang/RuntimeException
    //   1825	1840	4026	java/lang/RuntimeException
    //   1844	1849	4026	java/lang/RuntimeException
    //   1853	1864	4026	java/lang/RuntimeException
    //   1872	1878	4026	java/lang/RuntimeException
    //   1882	1909	4026	java/lang/RuntimeException
    //   2138	2147	4037	java/lang/RuntimeException
    //   2151	2167	4037	java/lang/RuntimeException
    //   2171	2179	4037	java/lang/RuntimeException
    //   2183	2195	4037	java/lang/RuntimeException
    //   2205	2225	4037	java/lang/RuntimeException
    //   2229	2241	4037	java/lang/RuntimeException
    //   2241	2279	4037	java/lang/RuntimeException
    //   2554	2607	4037	java/lang/RuntimeException
    //   2615	2648	4037	java/lang/RuntimeException
    //   3113	3121	4037	java/lang/RuntimeException
    //   3125	3140	4037	java/lang/RuntimeException
    //   3144	3153	4037	java/lang/RuntimeException
    //   3157	3169	4037	java/lang/RuntimeException
    //   3183	3202	4037	java/lang/RuntimeException
    //   3206	3218	4037	java/lang/RuntimeException
    //   3222	3227	4037	java/lang/RuntimeException
    //   3235	3241	4037	java/lang/RuntimeException
    //   3245	3272	4037	java/lang/RuntimeException
    //   225	233	4048	java/io/IOException
    //   249	255	4048	java/io/IOException
    //   271	297	4048	java/io/IOException
    //   317	323	4048	java/io/IOException
    //   339	345	4048	java/io/IOException
    //   361	369	4048	java/io/IOException
    //   430	439	4048	java/io/IOException
    //   455	470	4048	java/io/IOException
    //   486	490	4048	java/io/IOException
    //   506	510	4048	java/io/IOException
    //   862	866	4048	java/io/IOException
    //   886	892	4048	java/io/IOException
    //   912	922	4048	java/io/IOException
    //   945	949	4048	java/io/IOException
    //   969	975	4048	java/io/IOException
    //   995	1005	4048	java/io/IOException
    //   1028	1037	4048	java/io/IOException
    //   1057	1063	4048	java/io/IOException
    //   1083	1091	4048	java/io/IOException
    //   1111	1115	4048	java/io/IOException
    //   513	525	4059	java/io/IOException
    //   533	566	4059	java/io/IOException
    //   1791	1798	4069	java/io/IOException
    //   1802	1809	4069	java/io/IOException
    //   1813	1821	4069	java/io/IOException
    //   1825	1840	4069	java/io/IOException
    //   1844	1849	4069	java/io/IOException
    //   1853	1864	4069	java/io/IOException
    //   1872	1878	4069	java/io/IOException
    //   1882	1909	4069	java/io/IOException
    //   2138	2147	4079	java/io/IOException
    //   2151	2167	4079	java/io/IOException
    //   2171	2179	4079	java/io/IOException
    //   2183	2195	4079	java/io/IOException
    //   2205	2225	4079	java/io/IOException
    //   2229	2241	4079	java/io/IOException
    //   2241	2279	4079	java/io/IOException
    //   2554	2607	4079	java/io/IOException
    //   2615	2648	4079	java/io/IOException
    //   3113	3121	4079	java/io/IOException
    //   3125	3140	4079	java/io/IOException
    //   3144	3153	4079	java/io/IOException
    //   3157	3169	4079	java/io/IOException
    //   3183	3202	4079	java/io/IOException
    //   3206	3218	4079	java/io/IOException
    //   3222	3227	4079	java/io/IOException
    //   3235	3241	4079	java/io/IOException
    //   3245	3272	4079	java/io/IOException
    //   2554	2607	4089	java/lang/OutOfMemoryError
    //   2615	2648	4096	java/lang/OutOfMemoryError
    //   3113	3121	4103	java/lang/OutOfMemoryError
    //   3125	3140	4103	java/lang/OutOfMemoryError
    //   3144	3153	4103	java/lang/OutOfMemoryError
    //   3157	3169	4103	java/lang/OutOfMemoryError
    //   3183	3202	4103	java/lang/OutOfMemoryError
    //   3206	3218	4103	java/lang/OutOfMemoryError
    //   3222	3227	4103	java/lang/OutOfMemoryError
    //   3235	3241	4103	java/lang/OutOfMemoryError
    //   3245	3272	4103	java/lang/OutOfMemoryError
    //   2138	2147	4115	java/lang/OutOfMemoryError
    //   2151	2167	4115	java/lang/OutOfMemoryError
    //   2171	2179	4115	java/lang/OutOfMemoryError
    //   2183	2195	4115	java/lang/OutOfMemoryError
    //   2205	2225	4115	java/lang/OutOfMemoryError
    //   2229	2241	4115	java/lang/OutOfMemoryError
    //   2241	2279	4127	java/lang/OutOfMemoryError
    //   1791	1798	4135	java/lang/OutOfMemoryError
    //   1802	1809	4135	java/lang/OutOfMemoryError
    //   1813	1821	4135	java/lang/OutOfMemoryError
    //   1825	1840	4135	java/lang/OutOfMemoryError
    //   1844	1849	4135	java/lang/OutOfMemoryError
    //   1853	1864	4135	java/lang/OutOfMemoryError
    //   1872	1878	4135	java/lang/OutOfMemoryError
    //   1882	1909	4135	java/lang/OutOfMemoryError
    //   513	525	4143	java/lang/Throwable
    //   533	566	4150	java/lang/Throwable
    //   513	525	4165	java/lang/OutOfMemoryError
    //   533	566	4172	java/lang/OutOfMemoryError
    //   225	233	4248	java/lang/Throwable
    //   249	255	4248	java/lang/Throwable
    //   271	297	4248	java/lang/Throwable
    //   317	323	4248	java/lang/Throwable
    //   339	345	4248	java/lang/Throwable
    //   361	369	4248	java/lang/Throwable
    //   430	439	4248	java/lang/Throwable
    //   455	470	4248	java/lang/Throwable
    //   486	490	4248	java/lang/Throwable
    //   506	510	4248	java/lang/Throwable
    //   1968	1976	4261	java/lang/OutOfMemoryError
    //   2003	2010	4261	java/lang/OutOfMemoryError
    //   2037	2043	4261	java/lang/OutOfMemoryError
    //   2070	2097	4261	java/lang/OutOfMemoryError
    //   2124	2129	4261	java/lang/OutOfMemoryError
    //   2412	2419	4270	java/lang/OutOfMemoryError
    //   2440	2449	4270	java/lang/OutOfMemoryError
    //   2470	2476	4270	java/lang/OutOfMemoryError
    //   2497	2524	4270	java/lang/OutOfMemoryError
    //   2545	2549	4270	java/lang/OutOfMemoryError
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
                localObject = bdhe.a((byte[])localObject);
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
        paramString1 = bdgk.a();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = dk.a();
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
      azri.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (ybk.g(paramString))
      {
        azri.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        azri.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (ybk.i(paramString))
        {
          azri.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public static void a(Context paramContext)
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, yas paramyas, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new yam(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramyas);
    paramAppActivity = new NewIntent(paramAppActivity, xyk.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramyas = paramyas.a();
    if (paramyas != null)
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
        if (paramyas.has(str)) {
          paramAppActivity.putExtra(str, paramyas.optString(str));
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
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Boolean) {}
    do
    {
      return;
      jdField_a_of_type_Boolean = true;
    } while (ausx.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bfwd.a));
    new ausx().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bfwd.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, yas paramyas)
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
      if (paramScannerParams.jdField_a_of_type_Boolean)
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bdfi.b(2131230757, false);
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
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bdfi.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramyas);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramyas);
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
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bdfi.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        xyl.a(paramQQAppInterface, paramAppActivity, paramString1, i);
        i = 0;
      }
      for (;;)
      {
        if ((i != 0) || (!paramScannerParams.b)) {
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
        if (!ndd.a(paramAppActivity))
        {
          paramString1 = bdgm.a(paramAppActivity, 230);
          paramString1.setMessage(2131719403);
          paramString2 = new yal(paramyas);
          paramString1.setPositiveButton(2131694953, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bdfi.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!ybk.a(str)))
        {
          if (bfgo.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            bfgo.a().a(paramQQAppInterface, paramString1, paramView);
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
          aagb.a().a(1);
          aagb.a().jdField_a_of_type_JavaLangString = "";
          aagb.a().jdField_a_of_type_Int = 0;
          aagb.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramyas, paramString1)) {
            paramAppActivity.finish();
          }
          i = 0;
        }
        else if (a(paramString1))
        {
          b(paramString1, paramAppActivity);
          i = 0;
        }
        else if (paramString2.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate"))
        {
          a(paramString2, paramAppActivity);
          i = 0;
        }
        else if (ybk.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (ybk.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (ybk.f(str))
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
            if (paramScannerParams.e) {}
            for (i = 1012;; i = 1011)
            {
              com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramAppActivity, paramString1, i, null);
              paramAppActivity.finish();
              i = 0;
              break;
            }
          }
          if (ybk.h(str))
          {
            if (ybk.b(str))
            {
              paramString2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
              paramString2.putExtra("innerSig", paramString1);
              paramString2.putExtra(jdField_a_of_type_JavaLangString, jdField_a_of_type_Int);
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
            if (bdoj.a(paramString1))
            {
              bdoj.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramyas, paramView);
              i = 1;
            }
          }
          else
          {
            xyl.a(paramQQAppInterface, paramAppActivity, paramString1);
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
    PublicFragmentActivity.a(paramAppActivity, localIntent, MsgBackupTransportFragment.class);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
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
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("app_name=qim");
  }
  
  private static int b()
  {
    try
    {
      int i = bfwd.a();
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
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yak
 * JD-Core Version:    0.7.0.1
 */