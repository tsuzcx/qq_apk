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

public class xwb
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
      int k = bfru.a(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bfru.a((int[])localObject, localObject.length);
      localObject = bfru.a();
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
    if ((auan.a() >= 0) && (amzy.b()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = amzy.a().a(paramBitmap, l, localRect);
      if ((!bool) || (localRect.width() <= 0) || (localRect.height() <= 0)) {
        break label176;
      }
      paramBitmap = new Rect();
      auan.a(localRect, paramBitmap, paramInt1, paramInt2, 1.2F);
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
    //   104: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   157: invokestatic 80	auan:a	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 85	amzy:b	()Z
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
    //   187: invokestatic 178	xwb:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 183	anak:a	(ZZ)V
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
          if (!bfru.a(paramBitmap.getWidth(), paramBitmap.getHeight())) {
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
            amzy.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(amzy.a()), Long.valueOf(l2) }));
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
      bfru.a(paramBitmap, localStringBuilder2);
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
        amzy.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   59: istore 15
    //   61: iconst_0
    //   62: istore 14
    //   64: iconst_0
    //   65: istore 18
    //   67: iconst_0
    //   68: istore 16
    //   70: iconst_0
    //   71: istore 17
    //   73: iconst_0
    //   74: istore 19
    //   76: aconst_null
    //   77: astore 40
    //   79: aconst_null
    //   80: astore 39
    //   82: aconst_null
    //   83: astore 41
    //   85: aconst_null
    //   86: astore 34
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
    //   118: lstore 28
    //   120: aload 34
    //   122: astore 35
    //   124: aload 40
    //   126: astore 38
    //   128: aload 39
    //   130: astore 36
    //   132: aload 41
    //   134: astore 37
    //   136: aload_1
    //   137: invokevirtual 302	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 34
    //   144: astore 35
    //   146: aload 40
    //   148: astore 38
    //   150: aload 39
    //   152: astore 36
    //   154: aload 41
    //   156: astore 37
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5794 -> 5962
    //   171: aload 34
    //   173: astore 35
    //   175: aload 34
    //   177: astore 38
    //   179: aload 34
    //   181: astore 36
    //   183: aload 34
    //   185: astore 37
    //   187: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   190: lstore 30
    //   192: lload 30
    //   194: lstore 28
    //   196: iload 4
    //   198: iconst_2
    //   199: iand
    //   200: iconst_2
    //   201: if_icmpne +126 -> 327
    //   204: iload 22
    //   206: istore 7
    //   208: invokestatic 97	amzy:a	()Lamzy;
    //   211: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   214: lload 28
    //   216: ldc_w 289
    //   219: invokevirtual 211	amzy:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   222: iconst_1
    //   223: istore 25
    //   225: iconst_1
    //   226: istore 22
    //   228: iconst_1
    //   229: istore 23
    //   231: iconst_1
    //   232: istore 26
    //   234: iconst_1
    //   235: istore 27
    //   237: iconst_1
    //   238: istore 24
    //   240: iload 24
    //   242: istore 6
    //   244: iload 25
    //   246: istore 7
    //   248: iload 22
    //   250: istore 8
    //   252: iload 23
    //   254: istore 9
    //   256: iload 26
    //   258: istore 10
    //   260: iload 27
    //   262: istore 11
    //   264: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +60 -> 327
    //   270: iload 25
    //   272: istore 7
    //   274: iload 22
    //   276: istore 8
    //   278: iload 23
    //   280: istore 9
    //   282: iload 26
    //   284: istore 10
    //   286: iload 27
    //   288: istore 11
    //   290: ldc_w 289
    //   293: iconst_2
    //   294: ldc 213
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: invokestatic 215	amzy:a	()Z
    //   305: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: lload 28
    //   313: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   316: aastore
    //   317: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   320: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iload 24
    //   325: istore 6
    //   327: new 45	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   334: astore 40
    //   336: iload_3
    //   337: ifeq +1047 -> 1384
    //   340: aload_0
    //   341: invokevirtual 313	android/net/Uri:getPath	()Ljava/lang/String;
    //   344: invokestatic 319	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   347: astore 35
    //   349: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   352: ifeq +31 -> 383
    //   355: ldc_w 289
    //   358: iconst_4
    //   359: new 45	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 321
    //   369: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 35
    //   374: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload 35
    //   385: ifnull +5560 -> 5945
    //   388: aload 35
    //   390: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   393: istore 21
    //   395: aload 35
    //   397: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   400: istore 20
    //   402: iload 21
    //   404: iload 20
    //   406: invokestatic 199	bfru:a	(II)Z
    //   409: istore_3
    //   410: iload_3
    //   411: ifne +5527 -> 5938
    //   414: iload 4
    //   416: bipush 254
    //   418: iand
    //   419: istore 8
    //   421: iload 21
    //   423: iload 20
    //   425: imul
    //   426: newarray int
    //   428: astore_1
    //   429: aload 35
    //   431: aload_1
    //   432: iconst_0
    //   433: iload 21
    //   435: iconst_0
    //   436: iconst_0
    //   437: iload 21
    //   439: iload 20
    //   441: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   444: iload 8
    //   446: iconst_1
    //   447: iand
    //   448: iconst_1
    //   449: if_icmpne +5483 -> 5932
    //   452: invokestatic 200	xwb:a	()I
    //   455: pop
    //   456: iconst_1
    //   457: istore 4
    //   459: iload 4
    //   461: istore 12
    //   463: iload 4
    //   465: istore 13
    //   467: iload 15
    //   469: istore 9
    //   471: iload 4
    //   473: istore 15
    //   475: iload 14
    //   477: istore 10
    //   479: iload 4
    //   481: istore 14
    //   483: iload 18
    //   485: istore 11
    //   487: aload_1
    //   488: aconst_null
    //   489: iload 21
    //   491: iload 20
    //   493: iload 8
    //   495: aload 40
    //   497: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   500: istore 7
    //   502: iload 4
    //   504: istore 12
    //   506: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   509: ifeq +48 -> 557
    //   512: iload 4
    //   514: istore 12
    //   516: ldc_w 289
    //   519: iconst_4
    //   520: ldc_w 326
    //   523: iconst_3
    //   524: anewarray 4	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: iload 8
    //   531: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: aastore
    //   535: dup
    //   536: iconst_1
    //   537: iload 7
    //   539: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aastore
    //   543: dup
    //   544: iconst_2
    //   545: aload 40
    //   547: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: aastore
    //   551: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   554: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: iload 4
    //   559: istore 12
    //   561: iload 21
    //   563: iload 20
    //   565: imul
    //   566: newarray byte
    //   568: astore 36
    //   570: iload 4
    //   572: istore 12
    //   574: aload_1
    //   575: aload 36
    //   577: iload 21
    //   579: iload 20
    //   581: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   584: pop
    //   585: iload 8
    //   587: iconst_2
    //   588: iand
    //   589: iconst_2
    //   590: if_icmpne +497 -> 1087
    //   593: iload 7
    //   595: iconst_2
    //   596: iand
    //   597: ifne +490 -> 1087
    //   600: iconst_1
    //   601: istore 9
    //   603: iload 4
    //   605: istore 12
    //   607: invokestatic 80	auan:a	()I
    //   610: iflt +13 -> 623
    //   613: iload 4
    //   615: istore 12
    //   617: invokestatic 215	amzy:a	()Z
    //   620: ifeq +3 -> 623
    //   623: iload 9
    //   625: ifeq +5304 -> 5929
    //   628: iload 4
    //   630: istore 12
    //   632: aload 35
    //   634: iload 21
    //   636: iload 20
    //   638: aload_1
    //   639: aload 36
    //   641: aload 40
    //   643: invokestatic 178	xwb:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   646: istore 9
    //   648: iload 7
    //   650: iload 9
    //   652: ior
    //   653: istore 7
    //   655: iload 4
    //   657: istore 12
    //   659: iload 4
    //   661: istore 13
    //   663: iload 7
    //   665: istore 9
    //   667: iload 4
    //   669: istore 15
    //   671: iload 7
    //   673: istore 10
    //   675: iload 4
    //   677: istore 14
    //   679: iload 7
    //   681: istore 11
    //   683: iload 7
    //   685: istore 16
    //   687: iload 7
    //   689: istore 17
    //   691: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   694: ifeq +66 -> 760
    //   697: iload 4
    //   699: istore 12
    //   701: iload 4
    //   703: istore 13
    //   705: iload 7
    //   707: istore 9
    //   709: iload 4
    //   711: istore 15
    //   713: iload 7
    //   715: istore 10
    //   717: iload 4
    //   719: istore 14
    //   721: iload 7
    //   723: istore 11
    //   725: iload 7
    //   727: istore 16
    //   729: iload 7
    //   731: istore 17
    //   733: ldc 43
    //   735: iconst_4
    //   736: new 45	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 328
    //   746: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: iload 7
    //   751: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iload 4
    //   762: istore 12
    //   764: aload 35
    //   766: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   769: iload 4
    //   771: istore 9
    //   773: iload 7
    //   775: istore 4
    //   777: aload 34
    //   779: astore_1
    //   780: iload 9
    //   782: istore 7
    //   784: iload 8
    //   786: istore 9
    //   788: iload 4
    //   790: iflt +201 -> 991
    //   793: iload 4
    //   795: iconst_1
    //   796: iand
    //   797: iconst_1
    //   798: if_icmpne +3198 -> 3996
    //   801: iconst_1
    //   802: istore_3
    //   803: iload_3
    //   804: ifeq +5175 -> 5979
    //   807: aload 5
    //   809: ifnull +5170 -> 5979
    //   812: iload_2
    //   813: ifeq +5166 -> 5979
    //   816: aload_1
    //   817: astore 34
    //   819: iload 7
    //   821: istore 8
    //   823: new 45	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   830: astore 36
    //   832: aload_1
    //   833: astore 34
    //   835: iload 7
    //   837: istore 8
    //   839: new 45	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   846: astore 35
    //   848: aload_1
    //   849: astore 34
    //   851: iload 7
    //   853: istore 8
    //   855: aload 36
    //   857: aload 35
    //   859: invokestatic 238	bfru:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   862: pop
    //   863: aload_1
    //   864: astore 34
    //   866: iload 7
    //   868: istore 8
    //   870: aload 5
    //   872: iconst_1
    //   873: new 240	android/util/Pair
    //   876: dup
    //   877: aload 35
    //   879: aload 36
    //   881: invokespecial 243	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   884: invokevirtual 249	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   887: goto +5092 -> 5979
    //   890: iload_2
    //   891: ifeq +26 -> 917
    //   894: aload 5
    //   896: ifnull +21 -> 917
    //   899: aload_1
    //   900: astore 34
    //   902: iload 7
    //   904: istore 8
    //   906: aload 5
    //   908: iconst_2
    //   909: aload 40
    //   911: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokevirtual 249	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   917: aload_1
    //   918: astore 34
    //   920: iload 7
    //   922: istore 8
    //   924: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +64 -> 991
    //   930: aload_1
    //   931: astore 34
    //   933: iload 7
    //   935: istore 8
    //   937: ldc_w 289
    //   940: iconst_2
    //   941: ldc 251
    //   943: iconst_5
    //   944: anewarray 4	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: iload 9
    //   951: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   954: aastore
    //   955: dup
    //   956: iconst_1
    //   957: iload 4
    //   959: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   962: aastore
    //   963: dup
    //   964: iconst_2
    //   965: iload_3
    //   966: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   969: aastore
    //   970: dup
    //   971: iconst_3
    //   972: iload_2
    //   973: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   976: aastore
    //   977: dup
    //   978: iconst_4
    //   979: aload 40
    //   981: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: aastore
    //   985: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   988: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: iload 7
    //   993: ifeq +7 -> 1000
    //   996: invokestatic 253	xwb:b	()I
    //   999: pop
    //   1000: iload 6
    //   1002: ifeq +14 -> 1016
    //   1005: invokestatic 97	amzy:a	()Lamzy;
    //   1008: lload 28
    //   1010: ldc_w 289
    //   1013: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   1016: iload 4
    //   1018: istore 6
    //   1020: aload_1
    //   1021: ifnull +11 -> 1032
    //   1024: aload_1
    //   1025: invokevirtual 336	java/io/InputStream:close	()V
    //   1028: iload 4
    //   1030: istore 6
    //   1032: iload 6
    //   1034: istore 4
    //   1036: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1039: ifeq -1028 -> 11
    //   1042: ldc_w 289
    //   1045: iconst_4
    //   1046: new 45	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 338
    //   1056: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   1062: lload 32
    //   1064: lsub
    //   1065: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: ldc_w 340
    //   1071: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1078: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: iload 6
    //   1086: ireturn
    //   1087: iconst_0
    //   1088: istore 9
    //   1090: goto -487 -> 603
    //   1093: astore_1
    //   1094: iconst_0
    //   1095: istore 7
    //   1097: iload 4
    //   1099: istore 8
    //   1101: iload 19
    //   1103: istore 4
    //   1105: iload 7
    //   1107: istore 12
    //   1109: iload 7
    //   1111: istore 17
    //   1113: iload 4
    //   1115: istore 16
    //   1117: iload 7
    //   1119: istore 13
    //   1121: iload 4
    //   1123: istore 9
    //   1125: iload 7
    //   1127: istore 15
    //   1129: iload 4
    //   1131: istore 10
    //   1133: iload 7
    //   1135: istore 14
    //   1137: iload 4
    //   1139: istore 11
    //   1141: aload_1
    //   1142: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1145: iload 7
    //   1147: istore 12
    //   1149: iload 7
    //   1151: istore 17
    //   1153: iload 4
    //   1155: istore 16
    //   1157: iload 7
    //   1159: istore 13
    //   1161: iload 4
    //   1163: istore 9
    //   1165: iload 7
    //   1167: istore 15
    //   1169: iload 4
    //   1171: istore 10
    //   1173: iload 7
    //   1175: istore 14
    //   1177: iload 4
    //   1179: istore 11
    //   1181: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1184: ifeq +4808 -> 5992
    //   1187: iload 7
    //   1189: istore 12
    //   1191: iload 7
    //   1193: istore 17
    //   1195: iload 4
    //   1197: istore 16
    //   1199: iload 7
    //   1201: istore 13
    //   1203: iload 4
    //   1205: istore 9
    //   1207: iload 7
    //   1209: istore 15
    //   1211: iload 4
    //   1213: istore 10
    //   1215: iload 7
    //   1217: istore 14
    //   1219: iload 4
    //   1221: istore 11
    //   1223: ldc_w 289
    //   1226: iconst_2
    //   1227: aload_1
    //   1228: invokevirtual 342	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1231: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1234: goto +4758 -> 5992
    //   1237: iload 4
    //   1239: istore 12
    //   1241: iload 4
    //   1243: istore 17
    //   1245: iload 8
    //   1247: istore 16
    //   1249: iload 4
    //   1251: istore 13
    //   1253: iload 8
    //   1255: istore 9
    //   1257: iload 4
    //   1259: istore 15
    //   1261: iload 8
    //   1263: istore 10
    //   1265: iload 4
    //   1267: istore 14
    //   1269: iload 8
    //   1271: istore 11
    //   1273: aload_1
    //   1274: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   1277: iload 4
    //   1279: istore 12
    //   1281: iload 4
    //   1283: istore 17
    //   1285: iload 8
    //   1287: istore 16
    //   1289: iload 4
    //   1291: istore 13
    //   1293: iload 8
    //   1295: istore 9
    //   1297: iload 4
    //   1299: istore 15
    //   1301: iload 8
    //   1303: istore 10
    //   1305: iload 4
    //   1307: istore 14
    //   1309: iload 8
    //   1311: istore 11
    //   1313: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1316: ifeq +50 -> 1366
    //   1319: iload 4
    //   1321: istore 12
    //   1323: iload 4
    //   1325: istore 17
    //   1327: iload 8
    //   1329: istore 16
    //   1331: iload 4
    //   1333: istore 13
    //   1335: iload 8
    //   1337: istore 9
    //   1339: iload 4
    //   1341: istore 15
    //   1343: iload 8
    //   1345: istore 10
    //   1347: iload 4
    //   1349: istore 14
    //   1351: iload 8
    //   1353: istore 11
    //   1355: ldc_w 289
    //   1358: iconst_2
    //   1359: aload_1
    //   1360: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1363: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1366: aload 34
    //   1368: astore_1
    //   1369: iload 7
    //   1371: istore 9
    //   1373: iload 4
    //   1375: istore 7
    //   1377: iload 8
    //   1379: istore 4
    //   1381: goto -593 -> 788
    //   1384: new 344	android/graphics/BitmapFactory$Options
    //   1387: dup
    //   1388: invokespecial 345	android/graphics/BitmapFactory$Options:<init>	()V
    //   1391: astore 41
    //   1393: aload 41
    //   1395: iconst_1
    //   1396: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1399: aload 34
    //   1401: aconst_null
    //   1402: aload 41
    //   1404: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1407: pop
    //   1408: aload 34
    //   1410: invokevirtual 336	java/io/InputStream:close	()V
    //   1413: aconst_null
    //   1414: astore_1
    //   1415: aconst_null
    //   1416: astore 35
    //   1418: aconst_null
    //   1419: astore 36
    //   1421: aload_1
    //   1422: astore 34
    //   1424: iload 21
    //   1426: istore 8
    //   1428: aload 41
    //   1430: getfield 357	android/graphics/BitmapFactory$Options:outWidth	I
    //   1433: istore 16
    //   1435: aload_1
    //   1436: astore 34
    //   1438: iload 21
    //   1440: istore 8
    //   1442: aload 41
    //   1444: getfield 360	android/graphics/BitmapFactory$Options:outHeight	I
    //   1447: istore 15
    //   1449: iload 16
    //   1451: sipush 12800
    //   1454: if_icmpgt +11 -> 1465
    //   1457: iload 15
    //   1459: sipush 12800
    //   1462: if_icmple +65 -> 1527
    //   1465: iconst_0
    //   1466: istore 7
    //   1468: iload 6
    //   1470: ifeq +14 -> 1484
    //   1473: invokestatic 97	amzy:a	()Lamzy;
    //   1476: lload 28
    //   1478: ldc_w 289
    //   1481: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   1484: iload 7
    //   1486: istore 4
    //   1488: iconst_0
    //   1489: ifeq -1478 -> 11
    //   1492: new 362	java/lang/NullPointerException
    //   1495: dup
    //   1496: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1499: athrow
    //   1500: astore_0
    //   1501: aload_0
    //   1502: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1505: iload 7
    //   1507: istore 4
    //   1509: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1512: ifeq -1501 -> 11
    //   1515: ldc 43
    //   1517: iconst_2
    //   1518: aload_0
    //   1519: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1522: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1525: iconst_0
    //   1526: ireturn
    //   1527: aload_1
    //   1528: astore 34
    //   1530: iload 21
    //   1532: istore 8
    //   1534: iload 16
    //   1536: iload 15
    //   1538: invokestatic 199	bfru:a	(II)Z
    //   1541: ifne +4381 -> 5922
    //   1544: iload 4
    //   1546: bipush 254
    //   1548: iand
    //   1549: istore 10
    //   1551: iload 10
    //   1553: iconst_1
    //   1554: iand
    //   1555: iconst_1
    //   1556: if_icmpne +4360 -> 5916
    //   1559: aload_1
    //   1560: astore 34
    //   1562: iload 21
    //   1564: istore 8
    //   1566: invokestatic 200	xwb:a	()I
    //   1569: pop
    //   1570: iconst_1
    //   1571: istore 7
    //   1573: aload 35
    //   1575: astore_1
    //   1576: aload 41
    //   1578: aload 41
    //   1580: sipush 1280
    //   1583: sipush 1280
    //   1586: invokestatic 370	ailp:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1589: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1592: aload 35
    //   1594: astore_1
    //   1595: aload 41
    //   1597: iconst_0
    //   1598: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1601: aload 36
    //   1603: astore 34
    //   1605: aload 35
    //   1607: astore_1
    //   1608: aload 42
    //   1610: aload_0
    //   1611: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1614: astore 35
    //   1616: aload 35
    //   1618: astore 34
    //   1620: aload 35
    //   1622: astore_1
    //   1623: aload 35
    //   1625: astore 36
    //   1627: aload 35
    //   1629: astore 37
    //   1631: aload 35
    //   1633: astore 38
    //   1635: aload 35
    //   1637: astore 39
    //   1639: aload 35
    //   1641: aconst_null
    //   1642: aload 41
    //   1644: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1647: astore 43
    //   1649: aload 35
    //   1651: astore 34
    //   1653: aload 35
    //   1655: astore_1
    //   1656: aload 35
    //   1658: astore 36
    //   1660: aload 35
    //   1662: astore 37
    //   1664: aload 35
    //   1666: astore 38
    //   1668: aload 35
    //   1670: astore 39
    //   1672: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1675: ifeq +70 -> 1745
    //   1678: aload 35
    //   1680: astore 34
    //   1682: aload 35
    //   1684: astore_1
    //   1685: aload 35
    //   1687: astore 36
    //   1689: aload 35
    //   1691: astore 37
    //   1693: aload 35
    //   1695: astore 38
    //   1697: aload 35
    //   1699: astore 39
    //   1701: ldc_w 289
    //   1704: iconst_4
    //   1705: ldc_w 375
    //   1708: iconst_3
    //   1709: anewarray 4	java/lang/Object
    //   1712: dup
    //   1713: iconst_0
    //   1714: iload 16
    //   1716: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1719: aastore
    //   1720: dup
    //   1721: iconst_1
    //   1722: iload 15
    //   1724: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1727: aastore
    //   1728: dup
    //   1729: iconst_2
    //   1730: aload 41
    //   1732: getfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1735: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1738: aastore
    //   1739: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1742: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1745: aload 35
    //   1747: astore 34
    //   1749: aload 35
    //   1751: astore_1
    //   1752: aload 35
    //   1754: astore 36
    //   1756: aload 35
    //   1758: astore 37
    //   1760: aload 35
    //   1762: astore 38
    //   1764: aload 35
    //   1766: astore 39
    //   1768: aload 35
    //   1770: invokevirtual 336	java/io/InputStream:close	()V
    //   1773: aconst_null
    //   1774: astore_1
    //   1775: aconst_null
    //   1776: astore 34
    //   1778: iload 20
    //   1780: istore 4
    //   1782: aload 43
    //   1784: ifnull +20 -> 1804
    //   1787: aload 43
    //   1789: iload 10
    //   1791: aload 40
    //   1793: invokestatic 222	xwb:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1796: istore 4
    //   1798: iconst_0
    //   1799: iload 4
    //   1801: ior
    //   1802: istore 4
    //   1804: aconst_null
    //   1805: astore 34
    //   1807: aconst_null
    //   1808: astore 36
    //   1810: aconst_null
    //   1811: astore 35
    //   1813: aload 36
    //   1815: astore_1
    //   1816: iload 4
    //   1818: istore 13
    //   1820: iload 4
    //   1822: istore 14
    //   1824: iload 4
    //   1826: istore 12
    //   1828: iload 4
    //   1830: istore 11
    //   1832: iload 10
    //   1834: iload 4
    //   1836: invokestatic 224	xwb:a	(II)I
    //   1839: istore 17
    //   1841: iload 17
    //   1843: ifle +4064 -> 5907
    //   1846: iload 16
    //   1848: iload 15
    //   1850: iconst_2
    //   1851: imul
    //   1852: if_icmplt +1094 -> 2946
    //   1855: iload 15
    //   1857: sipush 1280
    //   1860: if_icmpge +1086 -> 2946
    //   1863: iconst_1
    //   1864: istore 8
    //   1866: iload 16
    //   1868: iconst_2
    //   1869: imul
    //   1870: iload 15
    //   1872: if_icmpgt +1080 -> 2952
    //   1875: iload 16
    //   1877: sipush 1280
    //   1880: if_icmpge +1072 -> 2952
    //   1883: iconst_1
    //   1884: istore 9
    //   1886: iload 9
    //   1888: ifeq +1161 -> 3049
    //   1891: aload 36
    //   1893: astore_1
    //   1894: iload 4
    //   1896: istore 13
    //   1898: iload 4
    //   1900: istore 14
    //   1902: iload 4
    //   1904: istore 12
    //   1906: iload 4
    //   1908: istore 11
    //   1910: aload 42
    //   1912: aload_0
    //   1913: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1916: astore 34
    //   1918: aload 34
    //   1920: astore 35
    //   1922: aload 34
    //   1924: astore_1
    //   1925: aload 34
    //   1927: astore 38
    //   1929: iload 4
    //   1931: istore 13
    //   1933: aload 34
    //   1935: astore 37
    //   1937: iload 4
    //   1939: istore 11
    //   1941: aload 34
    //   1943: astore 39
    //   1945: iload 4
    //   1947: istore 12
    //   1949: aload 34
    //   1951: astore 36
    //   1953: iload 4
    //   1955: istore 9
    //   1957: aload 34
    //   1959: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1962: astore 43
    //   1964: aload 34
    //   1966: astore 35
    //   1968: aload 34
    //   1970: astore_1
    //   1971: aload 34
    //   1973: astore 38
    //   1975: iload 4
    //   1977: istore 13
    //   1979: aload 34
    //   1981: astore 37
    //   1983: iload 4
    //   1985: istore 11
    //   1987: aload 34
    //   1989: astore 39
    //   1991: iload 4
    //   1993: istore 12
    //   1995: aload 34
    //   1997: astore 36
    //   1999: iload 4
    //   2001: istore 9
    //   2003: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2006: ifeq +70 -> 2076
    //   2009: aload 34
    //   2011: astore 35
    //   2013: aload 34
    //   2015: astore_1
    //   2016: aload 34
    //   2018: astore 38
    //   2020: iload 4
    //   2022: istore 13
    //   2024: aload 34
    //   2026: astore 37
    //   2028: iload 4
    //   2030: istore 11
    //   2032: aload 34
    //   2034: astore 39
    //   2036: iload 4
    //   2038: istore 12
    //   2040: aload 34
    //   2042: astore 36
    //   2044: iload 4
    //   2046: istore 9
    //   2048: ldc_w 289
    //   2051: iconst_4
    //   2052: new 45	java/lang/StringBuilder
    //   2055: dup
    //   2056: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2059: ldc_w 380
    //   2062: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: aload 43
    //   2067: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2070: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2073: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2076: aload 34
    //   2078: astore 35
    //   2080: aload 34
    //   2082: astore_1
    //   2083: aload 34
    //   2085: astore 38
    //   2087: iload 4
    //   2089: istore 13
    //   2091: aload 34
    //   2093: astore 37
    //   2095: iload 4
    //   2097: istore 11
    //   2099: aload 34
    //   2101: astore 39
    //   2103: iload 4
    //   2105: istore 12
    //   2107: aload 34
    //   2109: astore 36
    //   2111: iload 4
    //   2113: istore 9
    //   2115: aload 34
    //   2117: invokevirtual 336	java/io/InputStream:close	()V
    //   2120: aconst_null
    //   2121: astore 34
    //   2123: aconst_null
    //   2124: astore 37
    //   2126: aconst_null
    //   2127: astore 35
    //   2129: aconst_null
    //   2130: astore 36
    //   2132: aload 43
    //   2134: ifnull +3779 -> 5913
    //   2137: iload 4
    //   2139: istore 13
    //   2141: iload 4
    //   2143: istore 12
    //   2145: iload 4
    //   2147: istore 11
    //   2149: iload 4
    //   2151: istore 8
    //   2153: iload 4
    //   2155: istore 9
    //   2157: iload 16
    //   2159: iload 16
    //   2161: imul
    //   2162: newarray int
    //   2164: astore 38
    //   2166: iload 4
    //   2168: istore 13
    //   2170: iload 4
    //   2172: istore 12
    //   2174: iload 4
    //   2176: istore 11
    //   2178: iload 4
    //   2180: istore 8
    //   2182: iload 4
    //   2184: istore 9
    //   2186: aload 43
    //   2188: aload 38
    //   2190: iconst_0
    //   2191: iload 16
    //   2193: iconst_0
    //   2194: iconst_0
    //   2195: iload 16
    //   2197: iload 16
    //   2199: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2202: iload 4
    //   2204: istore 13
    //   2206: iload 4
    //   2208: istore 12
    //   2210: iload 4
    //   2212: istore 11
    //   2214: iload 4
    //   2216: istore 8
    //   2218: iload 4
    //   2220: istore 9
    //   2222: iload 16
    //   2224: iload 16
    //   2226: imul
    //   2227: newarray byte
    //   2229: astore_1
    //   2230: iload 4
    //   2232: istore 13
    //   2234: iload 4
    //   2236: istore 12
    //   2238: iload 4
    //   2240: istore 11
    //   2242: iload 4
    //   2244: istore 8
    //   2246: iload 4
    //   2248: istore 9
    //   2250: aload 38
    //   2252: aload_1
    //   2253: iload 16
    //   2255: iload 16
    //   2257: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2260: pop
    //   2261: iload 4
    //   2263: istore 13
    //   2265: iload 4
    //   2267: istore 12
    //   2269: iload 4
    //   2271: istore 11
    //   2273: iload 4
    //   2275: istore 8
    //   2277: iload 4
    //   2279: istore 9
    //   2281: iload 4
    //   2283: aload 38
    //   2285: aload_1
    //   2286: iload 16
    //   2288: iload 16
    //   2290: iload 17
    //   2292: aload 40
    //   2294: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2297: ior
    //   2298: istore 4
    //   2300: iload 4
    //   2302: iconst_1
    //   2303: if_icmpeq +3607 -> 5910
    //   2306: iload 4
    //   2308: istore 13
    //   2310: iload 4
    //   2312: istore 12
    //   2314: iload 4
    //   2316: istore 11
    //   2318: iload 4
    //   2320: istore 8
    //   2322: iload 4
    //   2324: istore 9
    //   2326: aload 43
    //   2328: aload 38
    //   2330: iconst_0
    //   2331: iload 16
    //   2333: iconst_0
    //   2334: iload 15
    //   2336: iload 16
    //   2338: isub
    //   2339: iload 16
    //   2341: iload 16
    //   2343: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2346: iload 4
    //   2348: istore 13
    //   2350: iload 4
    //   2352: istore 12
    //   2354: iload 4
    //   2356: istore 11
    //   2358: iload 4
    //   2360: istore 8
    //   2362: iload 4
    //   2364: istore 9
    //   2366: aload 38
    //   2368: aload_1
    //   2369: iload 16
    //   2371: iload 16
    //   2373: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2376: pop
    //   2377: iload 4
    //   2379: istore 13
    //   2381: iload 4
    //   2383: istore 12
    //   2385: iload 4
    //   2387: istore 11
    //   2389: iload 4
    //   2391: istore 8
    //   2393: iload 4
    //   2395: istore 9
    //   2397: aload 38
    //   2399: aload_1
    //   2400: iload 16
    //   2402: iload 16
    //   2404: iload 17
    //   2406: aload 40
    //   2408: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2411: istore 14
    //   2413: iload 14
    //   2415: iload 4
    //   2417: ior
    //   2418: istore 4
    //   2420: aload 43
    //   2422: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2425: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2428: ifeq +44 -> 2472
    //   2431: ldc_w 289
    //   2434: iconst_4
    //   2435: ldc_w 382
    //   2438: iconst_3
    //   2439: anewarray 4	java/lang/Object
    //   2442: dup
    //   2443: iconst_0
    //   2444: iload 17
    //   2446: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2449: aastore
    //   2450: dup
    //   2451: iconst_1
    //   2452: iload 4
    //   2454: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2457: aastore
    //   2458: dup
    //   2459: iconst_2
    //   2460: aload 40
    //   2462: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2465: aastore
    //   2466: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2469: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2472: aconst_null
    //   2473: astore 35
    //   2475: aconst_null
    //   2476: astore 34
    //   2478: aconst_null
    //   2479: astore 36
    //   2481: aload 34
    //   2483: astore_1
    //   2484: iload 10
    //   2486: iload 4
    //   2488: invokestatic 224	xwb:a	(II)I
    //   2491: istore 13
    //   2493: iload 13
    //   2495: ifle +3402 -> 5897
    //   2498: aload 34
    //   2500: astore_1
    //   2501: iload 16
    //   2503: iload 15
    //   2505: invokestatic 229	java/lang/Math:min	(II)I
    //   2508: istore 8
    //   2510: iload 8
    //   2512: sipush 250
    //   2515: if_icmple +3382 -> 5897
    //   2518: aload 34
    //   2520: astore_1
    //   2521: aload 41
    //   2523: iload 8
    //   2525: i2d
    //   2526: ldc2_w 230
    //   2529: ddiv
    //   2530: invokestatic 235	java/lang/Math:ceil	(D)D
    //   2533: d2i
    //   2534: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2537: aload 34
    //   2539: astore_1
    //   2540: aload 42
    //   2542: aload_0
    //   2543: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2546: astore 34
    //   2548: aload 34
    //   2550: astore 35
    //   2552: aload 34
    //   2554: astore_1
    //   2555: aload 34
    //   2557: astore 38
    //   2559: iload 4
    //   2561: istore 11
    //   2563: aload 34
    //   2565: astore 37
    //   2567: iload 4
    //   2569: istore 9
    //   2571: aload 34
    //   2573: astore 36
    //   2575: iload 4
    //   2577: istore 12
    //   2579: aload 34
    //   2581: astore 39
    //   2583: iload 4
    //   2585: istore 8
    //   2587: aload 34
    //   2589: aconst_null
    //   2590: aload 41
    //   2592: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2595: astore 41
    //   2597: aload 34
    //   2599: astore 35
    //   2601: aload 34
    //   2603: astore_1
    //   2604: aload 34
    //   2606: astore 38
    //   2608: iload 4
    //   2610: istore 11
    //   2612: aload 34
    //   2614: astore 37
    //   2616: iload 4
    //   2618: istore 9
    //   2620: aload 34
    //   2622: astore 36
    //   2624: iload 4
    //   2626: istore 12
    //   2628: aload 34
    //   2630: astore 39
    //   2632: iload 4
    //   2634: istore 8
    //   2636: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2639: ifeq +70 -> 2709
    //   2642: aload 34
    //   2644: astore 35
    //   2646: aload 34
    //   2648: astore_1
    //   2649: aload 34
    //   2651: astore 38
    //   2653: iload 4
    //   2655: istore 11
    //   2657: aload 34
    //   2659: astore 37
    //   2661: iload 4
    //   2663: istore 9
    //   2665: aload 34
    //   2667: astore 36
    //   2669: iload 4
    //   2671: istore 12
    //   2673: aload 34
    //   2675: astore 39
    //   2677: iload 4
    //   2679: istore 8
    //   2681: ldc_w 289
    //   2684: iconst_4
    //   2685: new 45	java/lang/StringBuilder
    //   2688: dup
    //   2689: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2692: ldc_w 384
    //   2695: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2698: aload 41
    //   2700: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2703: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2706: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2709: aload 34
    //   2711: astore 35
    //   2713: aload 34
    //   2715: astore_1
    //   2716: aload 34
    //   2718: astore 38
    //   2720: iload 4
    //   2722: istore 11
    //   2724: aload 34
    //   2726: astore 37
    //   2728: iload 4
    //   2730: istore 9
    //   2732: aload 34
    //   2734: astore 36
    //   2736: iload 4
    //   2738: istore 12
    //   2740: aload 34
    //   2742: astore 39
    //   2744: iload 4
    //   2746: istore 8
    //   2748: aload 34
    //   2750: invokevirtual 336	java/io/InputStream:close	()V
    //   2753: aload 41
    //   2755: ifnull +3135 -> 5890
    //   2758: aload 41
    //   2760: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   2763: istore 9
    //   2765: aload 41
    //   2767: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   2770: istore 8
    //   2772: iload 9
    //   2774: iload 8
    //   2776: imul
    //   2777: newarray int
    //   2779: astore_1
    //   2780: aload 41
    //   2782: aload_1
    //   2783: iconst_0
    //   2784: iload 9
    //   2786: iconst_0
    //   2787: iconst_0
    //   2788: iload 9
    //   2790: iload 8
    //   2792: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2795: aload 41
    //   2797: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2800: aload_1
    //   2801: aconst_null
    //   2802: iload 9
    //   2804: iload 8
    //   2806: iload 13
    //   2808: aload 40
    //   2810: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2813: istore 8
    //   2815: iload 8
    //   2817: iload 4
    //   2819: ior
    //   2820: istore 4
    //   2822: iload 4
    //   2824: istore 8
    //   2826: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2829: ifeq +48 -> 2877
    //   2832: ldc_w 289
    //   2835: iconst_4
    //   2836: ldc_w 386
    //   2839: iconst_3
    //   2840: anewarray 4	java/lang/Object
    //   2843: dup
    //   2844: iconst_0
    //   2845: iload 13
    //   2847: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2850: aastore
    //   2851: dup
    //   2852: iconst_1
    //   2853: iload 4
    //   2855: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2858: aastore
    //   2859: dup
    //   2860: iconst_2
    //   2861: aload 40
    //   2863: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2866: aastore
    //   2867: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2870: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2873: iload 4
    //   2875: istore 8
    //   2877: aconst_null
    //   2878: astore_1
    //   2879: iload 10
    //   2881: istore 9
    //   2883: iload 8
    //   2885: istore 4
    //   2887: goto -2099 -> 788
    //   2890: astore 35
    //   2892: aload 34
    //   2894: astore_1
    //   2895: aload 34
    //   2897: astore 36
    //   2899: aload 34
    //   2901: astore 37
    //   2903: aload 34
    //   2905: astore 38
    //   2907: aload 34
    //   2909: astore 39
    //   2911: aload 35
    //   2913: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2916: aload 34
    //   2918: astore_1
    //   2919: aload 34
    //   2921: astore 36
    //   2923: aload 34
    //   2925: astore 37
    //   2927: aload 34
    //   2929: astore 38
    //   2931: aload 34
    //   2933: astore 39
    //   2935: aload 34
    //   2937: invokevirtual 336	java/io/InputStream:close	()V
    //   2940: iconst_0
    //   2941: istore 4
    //   2943: goto -1139 -> 1804
    //   2946: iconst_0
    //   2947: istore 8
    //   2949: goto -1083 -> 1866
    //   2952: iconst_0
    //   2953: istore 9
    //   2955: goto -1069 -> 1886
    //   2958: astore_1
    //   2959: aload 35
    //   2961: astore 34
    //   2963: aload_1
    //   2964: astore 35
    //   2966: aload 34
    //   2968: astore_1
    //   2969: aload 34
    //   2971: astore 38
    //   2973: iload 4
    //   2975: istore 13
    //   2977: aload 34
    //   2979: astore 37
    //   2981: iload 4
    //   2983: istore 11
    //   2985: aload 34
    //   2987: astore 39
    //   2989: iload 4
    //   2991: istore 12
    //   2993: aload 34
    //   2995: astore 36
    //   2997: iload 4
    //   2999: istore 9
    //   3001: aload 35
    //   3003: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3006: aload 34
    //   3008: astore_1
    //   3009: aload 34
    //   3011: astore 38
    //   3013: iload 4
    //   3015: istore 13
    //   3017: aload 34
    //   3019: astore 37
    //   3021: iload 4
    //   3023: istore 11
    //   3025: aload 34
    //   3027: astore 39
    //   3029: iload 4
    //   3031: istore 12
    //   3033: aload 34
    //   3035: astore 36
    //   3037: iload 4
    //   3039: istore 9
    //   3041: aload 34
    //   3043: invokevirtual 336	java/io/InputStream:close	()V
    //   3046: goto -574 -> 2472
    //   3049: iload 8
    //   3051: ifeq +2856 -> 5907
    //   3054: iload 4
    //   3056: istore 8
    //   3058: aload 36
    //   3060: astore_1
    //   3061: iload 4
    //   3063: istore 13
    //   3065: iload 4
    //   3067: istore 14
    //   3069: iload 4
    //   3071: istore 12
    //   3073: iload 4
    //   3075: istore 11
    //   3077: aload 42
    //   3079: aload_0
    //   3080: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3083: astore 35
    //   3085: aload 35
    //   3087: astore 34
    //   3089: iload 4
    //   3091: istore 8
    //   3093: aload 35
    //   3095: astore_1
    //   3096: aload 35
    //   3098: astore 38
    //   3100: iload 4
    //   3102: istore 13
    //   3104: aload 35
    //   3106: astore 37
    //   3108: iload 4
    //   3110: istore 11
    //   3112: aload 35
    //   3114: astore 39
    //   3116: iload 4
    //   3118: istore 12
    //   3120: aload 35
    //   3122: astore 36
    //   3124: iload 4
    //   3126: istore 9
    //   3128: aload 35
    //   3130: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3133: astore 43
    //   3135: aload 35
    //   3137: astore 34
    //   3139: iload 4
    //   3141: istore 8
    //   3143: aload 35
    //   3145: astore_1
    //   3146: aload 35
    //   3148: astore 38
    //   3150: iload 4
    //   3152: istore 13
    //   3154: aload 35
    //   3156: astore 37
    //   3158: iload 4
    //   3160: istore 11
    //   3162: aload 35
    //   3164: astore 39
    //   3166: iload 4
    //   3168: istore 12
    //   3170: aload 35
    //   3172: astore 36
    //   3174: iload 4
    //   3176: istore 9
    //   3178: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3181: ifeq +74 -> 3255
    //   3184: aload 35
    //   3186: astore 34
    //   3188: iload 4
    //   3190: istore 8
    //   3192: aload 35
    //   3194: astore_1
    //   3195: aload 35
    //   3197: astore 38
    //   3199: iload 4
    //   3201: istore 13
    //   3203: aload 35
    //   3205: astore 37
    //   3207: iload 4
    //   3209: istore 11
    //   3211: aload 35
    //   3213: astore 39
    //   3215: iload 4
    //   3217: istore 12
    //   3219: aload 35
    //   3221: astore 36
    //   3223: iload 4
    //   3225: istore 9
    //   3227: ldc_w 289
    //   3230: iconst_4
    //   3231: new 45	java/lang/StringBuilder
    //   3234: dup
    //   3235: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3238: ldc_w 388
    //   3241: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: aload 43
    //   3246: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3249: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3252: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3255: aload 35
    //   3257: astore 34
    //   3259: iload 4
    //   3261: istore 8
    //   3263: aload 35
    //   3265: astore_1
    //   3266: aload 35
    //   3268: astore 38
    //   3270: iload 4
    //   3272: istore 13
    //   3274: aload 35
    //   3276: astore 37
    //   3278: iload 4
    //   3280: istore 11
    //   3282: aload 35
    //   3284: astore 39
    //   3286: iload 4
    //   3288: istore 12
    //   3290: aload 35
    //   3292: astore 36
    //   3294: iload 4
    //   3296: istore 9
    //   3298: aload 35
    //   3300: invokevirtual 336	java/io/InputStream:close	()V
    //   3303: aconst_null
    //   3304: astore 35
    //   3306: aconst_null
    //   3307: astore 36
    //   3309: iload 4
    //   3311: istore 9
    //   3313: aload 43
    //   3315: ifnull +488 -> 3803
    //   3318: aload 36
    //   3320: astore 34
    //   3322: iload 4
    //   3324: istore 8
    //   3326: aload 35
    //   3328: astore_1
    //   3329: iload 4
    //   3331: istore 13
    //   3333: iload 4
    //   3335: istore 14
    //   3337: iload 4
    //   3339: istore 12
    //   3341: iload 4
    //   3343: istore 11
    //   3345: iload 15
    //   3347: iload 15
    //   3349: imul
    //   3350: newarray int
    //   3352: astore 38
    //   3354: aload 36
    //   3356: astore 34
    //   3358: iload 4
    //   3360: istore 8
    //   3362: aload 35
    //   3364: astore_1
    //   3365: iload 4
    //   3367: istore 13
    //   3369: iload 4
    //   3371: istore 14
    //   3373: iload 4
    //   3375: istore 12
    //   3377: iload 4
    //   3379: istore 11
    //   3381: aload 43
    //   3383: aload 38
    //   3385: iconst_0
    //   3386: iload 15
    //   3388: iconst_0
    //   3389: iconst_0
    //   3390: iload 15
    //   3392: iload 15
    //   3394: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3397: aload 36
    //   3399: astore 34
    //   3401: iload 4
    //   3403: istore 8
    //   3405: aload 35
    //   3407: astore_1
    //   3408: iload 4
    //   3410: istore 13
    //   3412: iload 4
    //   3414: istore 14
    //   3416: iload 4
    //   3418: istore 12
    //   3420: iload 4
    //   3422: istore 11
    //   3424: iload 15
    //   3426: iload 15
    //   3428: imul
    //   3429: newarray byte
    //   3431: astore 37
    //   3433: aload 36
    //   3435: astore 34
    //   3437: iload 4
    //   3439: istore 8
    //   3441: aload 35
    //   3443: astore_1
    //   3444: iload 4
    //   3446: istore 13
    //   3448: iload 4
    //   3450: istore 14
    //   3452: iload 4
    //   3454: istore 12
    //   3456: iload 4
    //   3458: istore 11
    //   3460: aload 38
    //   3462: aload 37
    //   3464: iload 15
    //   3466: iload 15
    //   3468: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3471: pop
    //   3472: aload 36
    //   3474: astore 34
    //   3476: iload 4
    //   3478: istore 8
    //   3480: aload 35
    //   3482: astore_1
    //   3483: iload 4
    //   3485: istore 13
    //   3487: iload 4
    //   3489: istore 14
    //   3491: iload 4
    //   3493: istore 12
    //   3495: iload 4
    //   3497: istore 11
    //   3499: iload 4
    //   3501: aload 38
    //   3503: aload 37
    //   3505: iload 15
    //   3507: iload 15
    //   3509: iload 17
    //   3511: aload 40
    //   3513: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3516: ior
    //   3517: istore 9
    //   3519: iload 9
    //   3521: istore 4
    //   3523: iload 9
    //   3525: iconst_1
    //   3526: if_icmpeq +136 -> 3662
    //   3529: aload 36
    //   3531: astore 34
    //   3533: iload 9
    //   3535: istore 8
    //   3537: aload 35
    //   3539: astore_1
    //   3540: iload 9
    //   3542: istore 13
    //   3544: iload 9
    //   3546: istore 14
    //   3548: iload 9
    //   3550: istore 12
    //   3552: iload 9
    //   3554: istore 11
    //   3556: aload 43
    //   3558: aload 38
    //   3560: iconst_0
    //   3561: iload 15
    //   3563: iload 16
    //   3565: iload 15
    //   3567: isub
    //   3568: iconst_0
    //   3569: iload 15
    //   3571: iload 15
    //   3573: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3576: aload 36
    //   3578: astore 34
    //   3580: iload 9
    //   3582: istore 8
    //   3584: aload 35
    //   3586: astore_1
    //   3587: iload 9
    //   3589: istore 13
    //   3591: iload 9
    //   3593: istore 14
    //   3595: iload 9
    //   3597: istore 12
    //   3599: iload 9
    //   3601: istore 11
    //   3603: aload 38
    //   3605: aload 37
    //   3607: iload 15
    //   3609: iload 15
    //   3611: invokestatic 171	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3614: pop
    //   3615: aload 36
    //   3617: astore 34
    //   3619: iload 9
    //   3621: istore 8
    //   3623: aload 35
    //   3625: astore_1
    //   3626: iload 9
    //   3628: istore 13
    //   3630: iload 9
    //   3632: istore 14
    //   3634: iload 9
    //   3636: istore 12
    //   3638: iload 9
    //   3640: istore 11
    //   3642: iload 9
    //   3644: aload 38
    //   3646: aload 37
    //   3648: iload 15
    //   3650: iload 15
    //   3652: iload 17
    //   3654: aload 40
    //   3656: invokestatic 174	xwb:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3659: ior
    //   3660: istore 4
    //   3662: aload 36
    //   3664: astore 34
    //   3666: iload 4
    //   3668: istore 8
    //   3670: aload 35
    //   3672: astore_1
    //   3673: iload 4
    //   3675: istore 13
    //   3677: iload 4
    //   3679: istore 14
    //   3681: iload 4
    //   3683: istore 12
    //   3685: iload 4
    //   3687: istore 11
    //   3689: aload 43
    //   3691: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   3694: iload 4
    //   3696: istore 9
    //   3698: aload 36
    //   3700: astore 34
    //   3702: iload 4
    //   3704: istore 8
    //   3706: aload 35
    //   3708: astore_1
    //   3709: iload 4
    //   3711: istore 13
    //   3713: iload 4
    //   3715: istore 14
    //   3717: iload 4
    //   3719: istore 12
    //   3721: iload 4
    //   3723: istore 11
    //   3725: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3728: ifeq +75 -> 3803
    //   3731: aload 36
    //   3733: astore 34
    //   3735: iload 4
    //   3737: istore 8
    //   3739: aload 35
    //   3741: astore_1
    //   3742: iload 4
    //   3744: istore 13
    //   3746: iload 4
    //   3748: istore 14
    //   3750: iload 4
    //   3752: istore 12
    //   3754: iload 4
    //   3756: istore 11
    //   3758: ldc_w 289
    //   3761: iconst_4
    //   3762: ldc_w 390
    //   3765: iconst_3
    //   3766: anewarray 4	java/lang/Object
    //   3769: dup
    //   3770: iconst_0
    //   3771: iload 17
    //   3773: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3776: aastore
    //   3777: dup
    //   3778: iconst_1
    //   3779: iload 4
    //   3781: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3784: aastore
    //   3785: dup
    //   3786: iconst_2
    //   3787: aload 40
    //   3789: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3792: aastore
    //   3793: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3796: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3799: iload 4
    //   3801: istore 9
    //   3803: iload 9
    //   3805: istore 4
    //   3807: goto -1335 -> 2472
    //   3810: astore 35
    //   3812: aload 34
    //   3814: astore_1
    //   3815: aload 34
    //   3817: astore 38
    //   3819: iload 8
    //   3821: istore 13
    //   3823: aload 34
    //   3825: astore 37
    //   3827: iload 8
    //   3829: istore 11
    //   3831: aload 34
    //   3833: astore 39
    //   3835: iload 8
    //   3837: istore 12
    //   3839: aload 34
    //   3841: astore 36
    //   3843: iload 8
    //   3845: istore 9
    //   3847: aload 35
    //   3849: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3852: aload 34
    //   3854: astore_1
    //   3855: aload 34
    //   3857: astore 38
    //   3859: iload 8
    //   3861: istore 13
    //   3863: aload 34
    //   3865: astore 37
    //   3867: iload 8
    //   3869: istore 11
    //   3871: aload 34
    //   3873: astore 39
    //   3875: iload 8
    //   3877: istore 12
    //   3879: aload 34
    //   3881: astore 36
    //   3883: iload 8
    //   3885: istore 9
    //   3887: aload 34
    //   3889: invokevirtual 336	java/io/InputStream:close	()V
    //   3892: iload 8
    //   3894: istore 4
    //   3896: goto -1424 -> 2472
    //   3899: astore_1
    //   3900: aload 35
    //   3902: astore 34
    //   3904: aload_1
    //   3905: astore 35
    //   3907: aload 34
    //   3909: astore_1
    //   3910: aload 34
    //   3912: astore 38
    //   3914: iload 4
    //   3916: istore 11
    //   3918: aload 34
    //   3920: astore 37
    //   3922: iload 4
    //   3924: istore 9
    //   3926: aload 34
    //   3928: astore 36
    //   3930: iload 4
    //   3932: istore 12
    //   3934: aload 34
    //   3936: astore 39
    //   3938: iload 4
    //   3940: istore 8
    //   3942: aload 35
    //   3944: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3947: aload 34
    //   3949: astore_1
    //   3950: aload 34
    //   3952: astore 38
    //   3954: iload 4
    //   3956: istore 11
    //   3958: aload 34
    //   3960: astore 37
    //   3962: iload 4
    //   3964: istore 9
    //   3966: aload 34
    //   3968: astore 36
    //   3970: iload 4
    //   3972: istore 12
    //   3974: aload 34
    //   3976: astore 39
    //   3978: iload 4
    //   3980: istore 8
    //   3982: aload 34
    //   3984: invokevirtual 336	java/io/InputStream:close	()V
    //   3987: aconst_null
    //   3988: astore_1
    //   3989: iload 10
    //   3991: istore 9
    //   3993: goto -3205 -> 788
    //   3996: iconst_0
    //   3997: istore_3
    //   3998: goto -3195 -> 803
    //   4001: iconst_0
    //   4002: istore_2
    //   4003: goto -3113 -> 890
    //   4006: astore_1
    //   4007: aload_1
    //   4008: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4011: iload 4
    //   4013: istore 6
    //   4015: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4018: ifeq -2986 -> 1032
    //   4021: ldc 43
    //   4023: iconst_2
    //   4024: aload_1
    //   4025: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4028: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4031: iload 4
    //   4033: istore 6
    //   4035: goto -3003 -> 1032
    //   4038: astore_1
    //   4039: iconst_0
    //   4040: istore 6
    //   4042: iconst_0
    //   4043: istore 4
    //   4045: aload 35
    //   4047: astore 34
    //   4049: iload 12
    //   4051: istore 7
    //   4053: aload_1
    //   4054: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4057: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4060: ifeq +14 -> 4074
    //   4063: ldc_w 289
    //   4066: iconst_2
    //   4067: aload_1
    //   4068: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4071: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4074: iload 7
    //   4076: ifeq +7 -> 4083
    //   4079: invokestatic 253	xwb:b	()I
    //   4082: pop
    //   4083: iload 6
    //   4085: ifeq +14 -> 4099
    //   4088: invokestatic 97	amzy:a	()Lamzy;
    //   4091: lload 28
    //   4093: ldc_w 289
    //   4096: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   4099: iload 4
    //   4101: istore 6
    //   4103: aload 34
    //   4105: ifnull -3073 -> 1032
    //   4108: aload 34
    //   4110: invokevirtual 336	java/io/InputStream:close	()V
    //   4113: iload 4
    //   4115: istore 6
    //   4117: goto -3085 -> 1032
    //   4120: astore_1
    //   4121: aload_1
    //   4122: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4125: iload 4
    //   4127: istore 6
    //   4129: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4132: ifeq -3100 -> 1032
    //   4135: ldc 43
    //   4137: iconst_2
    //   4138: aload_1
    //   4139: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4142: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4145: iload 4
    //   4147: istore 6
    //   4149: goto -3117 -> 1032
    //   4152: astore_1
    //   4153: ldc2_w 295
    //   4156: lstore 30
    //   4158: iconst_0
    //   4159: istore 6
    //   4161: iconst_0
    //   4162: istore 7
    //   4164: iconst_0
    //   4165: istore 4
    //   4167: aload 38
    //   4169: astore 34
    //   4171: aload 34
    //   4173: astore 5
    //   4175: lload 30
    //   4177: lstore 28
    //   4179: iload 6
    //   4181: istore 9
    //   4183: iload 7
    //   4185: istore 8
    //   4187: aload_1
    //   4188: invokevirtual 264	java/lang/RuntimeException:printStackTrace	()V
    //   4191: aload 34
    //   4193: astore 5
    //   4195: lload 30
    //   4197: lstore 28
    //   4199: iload 6
    //   4201: istore 9
    //   4203: iload 7
    //   4205: istore 8
    //   4207: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4210: ifeq +30 -> 4240
    //   4213: aload 34
    //   4215: astore 5
    //   4217: lload 30
    //   4219: lstore 28
    //   4221: iload 6
    //   4223: istore 9
    //   4225: iload 7
    //   4227: istore 8
    //   4229: ldc_w 289
    //   4232: iconst_2
    //   4233: aload_1
    //   4234: invokevirtual 265	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   4237: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4240: iload 7
    //   4242: ifeq +7 -> 4249
    //   4245: invokestatic 253	xwb:b	()I
    //   4248: pop
    //   4249: iload 6
    //   4251: ifeq +14 -> 4265
    //   4254: invokestatic 97	amzy:a	()Lamzy;
    //   4257: lload 30
    //   4259: ldc_w 289
    //   4262: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   4265: iload 4
    //   4267: istore 6
    //   4269: aload 34
    //   4271: ifnull -3239 -> 1032
    //   4274: aload 34
    //   4276: invokevirtual 336	java/io/InputStream:close	()V
    //   4279: iload 4
    //   4281: istore 6
    //   4283: goto -3251 -> 1032
    //   4286: astore_1
    //   4287: aload_1
    //   4288: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4291: iload 4
    //   4293: istore 6
    //   4295: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4298: ifeq -3266 -> 1032
    //   4301: ldc 43
    //   4303: iconst_2
    //   4304: aload_1
    //   4305: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4308: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4311: iload 4
    //   4313: istore 6
    //   4315: goto -3283 -> 1032
    //   4318: astore_1
    //   4319: ldc2_w 295
    //   4322: lstore 30
    //   4324: iconst_0
    //   4325: istore 6
    //   4327: iconst_0
    //   4328: istore 7
    //   4330: iconst_0
    //   4331: istore 4
    //   4333: aload 36
    //   4335: astore 34
    //   4337: aload 34
    //   4339: astore 5
    //   4341: lload 30
    //   4343: lstore 28
    //   4345: iload 6
    //   4347: istore 9
    //   4349: iload 7
    //   4351: istore 8
    //   4353: aload_1
    //   4354: invokevirtual 269	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   4357: aload 34
    //   4359: astore 5
    //   4361: lload 30
    //   4363: lstore 28
    //   4365: iload 6
    //   4367: istore 9
    //   4369: iload 7
    //   4371: istore 8
    //   4373: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4376: ifeq +30 -> 4406
    //   4379: aload 34
    //   4381: astore 5
    //   4383: lload 30
    //   4385: lstore 28
    //   4387: iload 6
    //   4389: istore 9
    //   4391: iload 7
    //   4393: istore 8
    //   4395: ldc_w 289
    //   4398: iconst_2
    //   4399: aload_1
    //   4400: invokevirtual 270	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   4403: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4406: iload 7
    //   4408: ifeq +7 -> 4415
    //   4411: invokestatic 253	xwb:b	()I
    //   4414: pop
    //   4415: iload 6
    //   4417: ifeq +14 -> 4431
    //   4420: invokestatic 97	amzy:a	()Lamzy;
    //   4423: lload 30
    //   4425: ldc_w 289
    //   4428: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   4431: iload 4
    //   4433: istore 6
    //   4435: aload 34
    //   4437: ifnull -3405 -> 1032
    //   4440: aload 34
    //   4442: invokevirtual 336	java/io/InputStream:close	()V
    //   4445: iload 4
    //   4447: istore 6
    //   4449: goto -3417 -> 1032
    //   4452: astore_1
    //   4453: aload_1
    //   4454: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4457: iload 4
    //   4459: istore 6
    //   4461: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4464: ifeq -3432 -> 1032
    //   4467: ldc 43
    //   4469: iconst_2
    //   4470: aload_1
    //   4471: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4474: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4477: iload 4
    //   4479: istore 6
    //   4481: goto -3449 -> 1032
    //   4484: astore_1
    //   4485: ldc2_w 295
    //   4488: lstore 30
    //   4490: iconst_0
    //   4491: istore 6
    //   4493: iconst_0
    //   4494: istore 7
    //   4496: iconst_0
    //   4497: istore 4
    //   4499: aload 37
    //   4501: astore 34
    //   4503: aload 34
    //   4505: astore 5
    //   4507: lload 30
    //   4509: lstore 28
    //   4511: iload 6
    //   4513: istore 9
    //   4515: iload 7
    //   4517: istore 8
    //   4519: aload_1
    //   4520: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   4523: aload 34
    //   4525: astore 5
    //   4527: lload 30
    //   4529: lstore 28
    //   4531: iload 6
    //   4533: istore 9
    //   4535: iload 7
    //   4537: istore 8
    //   4539: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4542: ifeq +30 -> 4572
    //   4545: aload 34
    //   4547: astore 5
    //   4549: lload 30
    //   4551: lstore 28
    //   4553: iload 6
    //   4555: istore 9
    //   4557: iload 7
    //   4559: istore 8
    //   4561: ldc_w 289
    //   4564: iconst_2
    //   4565: aload_1
    //   4566: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4569: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4572: iload 7
    //   4574: ifeq +7 -> 4581
    //   4577: invokestatic 253	xwb:b	()I
    //   4580: pop
    //   4581: iload 6
    //   4583: ifeq +14 -> 4597
    //   4586: invokestatic 97	amzy:a	()Lamzy;
    //   4589: lload 30
    //   4591: ldc_w 289
    //   4594: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   4597: iload 4
    //   4599: istore 6
    //   4601: aload 34
    //   4603: ifnull -3571 -> 1032
    //   4606: aload 34
    //   4608: invokevirtual 336	java/io/InputStream:close	()V
    //   4611: iload 4
    //   4613: istore 6
    //   4615: goto -3583 -> 1032
    //   4618: astore_1
    //   4619: aload_1
    //   4620: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4623: iload 4
    //   4625: istore 6
    //   4627: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4630: ifeq -3598 -> 1032
    //   4633: ldc 43
    //   4635: iconst_2
    //   4636: aload_1
    //   4637: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4640: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4643: iload 4
    //   4645: istore 6
    //   4647: goto -3615 -> 1032
    //   4650: astore_0
    //   4651: ldc2_w 295
    //   4654: lstore 28
    //   4656: iconst_0
    //   4657: istore 6
    //   4659: iconst_0
    //   4660: istore 7
    //   4662: aconst_null
    //   4663: astore_1
    //   4664: iload 7
    //   4666: ifeq +7 -> 4673
    //   4669: invokestatic 253	xwb:b	()I
    //   4672: pop
    //   4673: iload 6
    //   4675: ifeq +14 -> 4689
    //   4678: invokestatic 97	amzy:a	()Lamzy;
    //   4681: lload 28
    //   4683: ldc_w 289
    //   4686: invokevirtual 256	amzy:a	(JLjava/lang/String;)V
    //   4689: aload_1
    //   4690: ifnull +7 -> 4697
    //   4693: aload_1
    //   4694: invokevirtual 336	java/io/InputStream:close	()V
    //   4697: aload_0
    //   4698: athrow
    //   4699: astore_1
    //   4700: aload_1
    //   4701: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   4704: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4707: ifeq -10 -> 4697
    //   4710: ldc 43
    //   4712: iconst_2
    //   4713: aload_1
    //   4714: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   4717: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4720: goto -23 -> 4697
    //   4723: astore_0
    //   4724: ldc2_w 295
    //   4727: lstore 28
    //   4729: iconst_0
    //   4730: istore 6
    //   4732: iconst_0
    //   4733: istore 7
    //   4735: aload 34
    //   4737: astore_1
    //   4738: goto -74 -> 4664
    //   4741: astore_0
    //   4742: iload 7
    //   4744: istore 6
    //   4746: iconst_0
    //   4747: istore 7
    //   4749: aload 34
    //   4751: astore_1
    //   4752: goto -88 -> 4664
    //   4755: astore_0
    //   4756: iconst_0
    //   4757: istore 7
    //   4759: aload 34
    //   4761: astore_1
    //   4762: goto -98 -> 4664
    //   4765: astore_0
    //   4766: iload 12
    //   4768: istore 7
    //   4770: aload 34
    //   4772: astore_1
    //   4773: goto -109 -> 4664
    //   4776: astore_0
    //   4777: iload 8
    //   4779: istore 7
    //   4781: aload 34
    //   4783: astore_1
    //   4784: goto -120 -> 4664
    //   4787: astore_0
    //   4788: goto -124 -> 4664
    //   4791: astore_0
    //   4792: aconst_null
    //   4793: astore_1
    //   4794: goto -130 -> 4664
    //   4797: astore_0
    //   4798: aconst_null
    //   4799: astore_1
    //   4800: goto -136 -> 4664
    //   4803: astore_0
    //   4804: aload 34
    //   4806: astore_1
    //   4807: goto -143 -> 4664
    //   4810: astore_0
    //   4811: aload 5
    //   4813: astore_1
    //   4814: iload 9
    //   4816: istore 6
    //   4818: iload 8
    //   4820: istore 7
    //   4822: goto -158 -> 4664
    //   4825: astore_1
    //   4826: iload 8
    //   4828: istore 6
    //   4830: iconst_0
    //   4831: istore 7
    //   4833: iconst_0
    //   4834: istore 4
    //   4836: lload 28
    //   4838: lstore 30
    //   4840: goto -337 -> 4503
    //   4843: astore_1
    //   4844: iconst_0
    //   4845: istore 7
    //   4847: iconst_0
    //   4848: istore 4
    //   4850: lload 28
    //   4852: lstore 30
    //   4854: goto -351 -> 4503
    //   4857: astore_1
    //   4858: iload 17
    //   4860: istore 7
    //   4862: iload 16
    //   4864: istore 4
    //   4866: lload 28
    //   4868: lstore 30
    //   4870: goto -367 -> 4503
    //   4873: astore_1
    //   4874: iconst_0
    //   4875: istore 7
    //   4877: aconst_null
    //   4878: astore 34
    //   4880: iconst_0
    //   4881: istore 4
    //   4883: lload 28
    //   4885: lstore 30
    //   4887: goto -384 -> 4503
    //   4890: astore_1
    //   4891: aconst_null
    //   4892: astore 34
    //   4894: iconst_0
    //   4895: istore 4
    //   4897: lload 28
    //   4899: lstore 30
    //   4901: goto -398 -> 4503
    //   4904: astore_1
    //   4905: aload 36
    //   4907: astore 34
    //   4909: iconst_0
    //   4910: istore 4
    //   4912: lload 28
    //   4914: lstore 30
    //   4916: goto -413 -> 4503
    //   4919: astore_1
    //   4920: aconst_null
    //   4921: astore 34
    //   4923: iload 13
    //   4925: istore 4
    //   4927: lload 28
    //   4929: lstore 30
    //   4931: goto -428 -> 4503
    //   4934: astore_1
    //   4935: aload 38
    //   4937: astore 34
    //   4939: iload 13
    //   4941: istore 4
    //   4943: lload 28
    //   4945: lstore 30
    //   4947: goto -444 -> 4503
    //   4950: astore_1
    //   4951: iload 13
    //   4953: istore 4
    //   4955: aload 35
    //   4957: astore 34
    //   4959: lload 28
    //   4961: lstore 30
    //   4963: goto -460 -> 4503
    //   4966: astore_1
    //   4967: aload 35
    //   4969: astore 34
    //   4971: lload 28
    //   4973: lstore 30
    //   4975: goto -472 -> 4503
    //   4978: astore_1
    //   4979: aconst_null
    //   4980: astore 34
    //   4982: lload 28
    //   4984: lstore 30
    //   4986: goto -483 -> 4503
    //   4989: astore_1
    //   4990: aload 38
    //   4992: astore 34
    //   4994: iload 11
    //   4996: istore 4
    //   4998: lload 28
    //   5000: lstore 30
    //   5002: goto -499 -> 4503
    //   5005: astore_1
    //   5006: aconst_null
    //   5007: astore 34
    //   5009: lload 28
    //   5011: lstore 30
    //   5013: goto -510 -> 4503
    //   5016: astore_1
    //   5017: aconst_null
    //   5018: astore 34
    //   5020: lload 28
    //   5022: lstore 30
    //   5024: goto -521 -> 4503
    //   5027: astore 5
    //   5029: aload_1
    //   5030: astore 34
    //   5032: aload 5
    //   5034: astore_1
    //   5035: lload 28
    //   5037: lstore 30
    //   5039: goto -536 -> 4503
    //   5042: astore_1
    //   5043: iload 9
    //   5045: istore 6
    //   5047: iconst_0
    //   5048: istore 7
    //   5050: iconst_0
    //   5051: istore 4
    //   5053: lload 28
    //   5055: lstore 30
    //   5057: goto -720 -> 4337
    //   5060: astore_1
    //   5061: iconst_0
    //   5062: istore 7
    //   5064: iconst_0
    //   5065: istore 4
    //   5067: lload 28
    //   5069: lstore 30
    //   5071: goto -734 -> 4337
    //   5074: astore_1
    //   5075: iload 13
    //   5077: istore 7
    //   5079: iload 9
    //   5081: istore 4
    //   5083: lload 28
    //   5085: lstore 30
    //   5087: goto -750 -> 4337
    //   5090: astore_1
    //   5091: iload 4
    //   5093: istore 8
    //   5095: iload 7
    //   5097: istore 4
    //   5099: lload 28
    //   5101: lstore 30
    //   5103: iload 8
    //   5105: istore 7
    //   5107: goto -770 -> 4337
    //   5110: astore_1
    //   5111: iload 4
    //   5113: istore 8
    //   5115: iload 7
    //   5117: istore 4
    //   5119: lload 28
    //   5121: lstore 30
    //   5123: iload 8
    //   5125: istore 7
    //   5127: goto -790 -> 4337
    //   5130: astore_1
    //   5131: iconst_0
    //   5132: istore 7
    //   5134: aconst_null
    //   5135: astore 34
    //   5137: iconst_0
    //   5138: istore 4
    //   5140: lload 28
    //   5142: lstore 30
    //   5144: goto -807 -> 4337
    //   5147: astore_1
    //   5148: aconst_null
    //   5149: astore 34
    //   5151: iconst_0
    //   5152: istore 4
    //   5154: lload 28
    //   5156: lstore 30
    //   5158: goto -821 -> 4337
    //   5161: astore_1
    //   5162: aload 37
    //   5164: astore 34
    //   5166: iconst_0
    //   5167: istore 4
    //   5169: lload 28
    //   5171: lstore 30
    //   5173: goto -836 -> 4337
    //   5176: astore_1
    //   5177: aconst_null
    //   5178: astore 34
    //   5180: iload 14
    //   5182: istore 4
    //   5184: lload 28
    //   5186: lstore 30
    //   5188: goto -851 -> 4337
    //   5191: astore_1
    //   5192: aload 37
    //   5194: astore 34
    //   5196: iload 11
    //   5198: istore 4
    //   5200: lload 28
    //   5202: lstore 30
    //   5204: goto -867 -> 4337
    //   5207: astore_1
    //   5208: iload 12
    //   5210: istore 4
    //   5212: aload 37
    //   5214: astore 34
    //   5216: lload 28
    //   5218: lstore 30
    //   5220: goto -883 -> 4337
    //   5223: astore_1
    //   5224: aload 37
    //   5226: astore 34
    //   5228: lload 28
    //   5230: lstore 30
    //   5232: goto -895 -> 4337
    //   5235: astore_1
    //   5236: aconst_null
    //   5237: astore 34
    //   5239: lload 28
    //   5241: lstore 30
    //   5243: goto -906 -> 4337
    //   5246: astore_1
    //   5247: aload 37
    //   5249: astore 34
    //   5251: iload 9
    //   5253: istore 4
    //   5255: lload 28
    //   5257: lstore 30
    //   5259: goto -922 -> 4337
    //   5262: astore_1
    //   5263: aconst_null
    //   5264: astore 34
    //   5266: lload 28
    //   5268: lstore 30
    //   5270: goto -933 -> 4337
    //   5273: astore_1
    //   5274: aconst_null
    //   5275: astore 34
    //   5277: lload 28
    //   5279: lstore 30
    //   5281: goto -944 -> 4337
    //   5284: astore 5
    //   5286: aload_1
    //   5287: astore 34
    //   5289: aload 5
    //   5291: astore_1
    //   5292: lload 28
    //   5294: lstore 30
    //   5296: goto -959 -> 4337
    //   5299: astore_1
    //   5300: iload 10
    //   5302: istore 6
    //   5304: iconst_0
    //   5305: istore 7
    //   5307: iconst_0
    //   5308: istore 4
    //   5310: lload 28
    //   5312: lstore 30
    //   5314: goto -1143 -> 4171
    //   5317: astore_1
    //   5318: iconst_0
    //   5319: istore 7
    //   5321: iconst_0
    //   5322: istore 4
    //   5324: lload 28
    //   5326: lstore 30
    //   5328: goto -1157 -> 4171
    //   5331: astore_1
    //   5332: iload 15
    //   5334: istore 7
    //   5336: iload 10
    //   5338: istore 4
    //   5340: lload 28
    //   5342: lstore 30
    //   5344: goto -1173 -> 4171
    //   5347: astore_1
    //   5348: iload 4
    //   5350: istore 8
    //   5352: iload 7
    //   5354: istore 4
    //   5356: lload 28
    //   5358: lstore 30
    //   5360: iload 8
    //   5362: istore 7
    //   5364: goto -1193 -> 4171
    //   5367: astore_1
    //   5368: iload 4
    //   5370: istore 8
    //   5372: iload 7
    //   5374: istore 4
    //   5376: lload 28
    //   5378: lstore 30
    //   5380: iload 8
    //   5382: istore 7
    //   5384: goto -1213 -> 4171
    //   5387: astore_1
    //   5388: iconst_0
    //   5389: istore 7
    //   5391: aconst_null
    //   5392: astore 34
    //   5394: iconst_0
    //   5395: istore 4
    //   5397: lload 28
    //   5399: lstore 30
    //   5401: goto -1230 -> 4171
    //   5404: astore_1
    //   5405: aconst_null
    //   5406: astore 34
    //   5408: iconst_0
    //   5409: istore 4
    //   5411: lload 28
    //   5413: lstore 30
    //   5415: goto -1244 -> 4171
    //   5418: astore_1
    //   5419: aload 38
    //   5421: astore 34
    //   5423: iconst_0
    //   5424: istore 4
    //   5426: lload 28
    //   5428: lstore 30
    //   5430: goto -1259 -> 4171
    //   5433: astore_1
    //   5434: aconst_null
    //   5435: astore 34
    //   5437: iload 12
    //   5439: istore 4
    //   5441: lload 28
    //   5443: lstore 30
    //   5445: goto -1274 -> 4171
    //   5448: astore_1
    //   5449: aload 39
    //   5451: astore 34
    //   5453: iload 12
    //   5455: istore 4
    //   5457: lload 28
    //   5459: lstore 30
    //   5461: goto -1290 -> 4171
    //   5464: astore_1
    //   5465: iload 11
    //   5467: istore 4
    //   5469: lload 28
    //   5471: lstore 30
    //   5473: goto -1302 -> 4171
    //   5476: astore_1
    //   5477: lload 28
    //   5479: lstore 30
    //   5481: goto -1310 -> 4171
    //   5484: astore_1
    //   5485: aconst_null
    //   5486: astore 34
    //   5488: lload 28
    //   5490: lstore 30
    //   5492: goto -1321 -> 4171
    //   5495: astore_1
    //   5496: aload 36
    //   5498: astore 34
    //   5500: iload 12
    //   5502: istore 4
    //   5504: lload 28
    //   5506: lstore 30
    //   5508: goto -1337 -> 4171
    //   5511: astore_1
    //   5512: aconst_null
    //   5513: astore 34
    //   5515: lload 28
    //   5517: lstore 30
    //   5519: goto -1348 -> 4171
    //   5522: astore_1
    //   5523: aconst_null
    //   5524: astore 34
    //   5526: lload 28
    //   5528: lstore 30
    //   5530: goto -1359 -> 4171
    //   5533: astore 5
    //   5535: aload_1
    //   5536: astore 34
    //   5538: aload 5
    //   5540: astore_1
    //   5541: lload 28
    //   5543: lstore 30
    //   5545: goto -1374 -> 4171
    //   5548: astore_1
    //   5549: iload 11
    //   5551: istore 6
    //   5553: iconst_0
    //   5554: istore 4
    //   5556: iload 12
    //   5558: istore 7
    //   5560: goto -1507 -> 4053
    //   5563: astore_1
    //   5564: iconst_0
    //   5565: istore 4
    //   5567: iload 12
    //   5569: istore 7
    //   5571: goto -1518 -> 4053
    //   5574: astore_1
    //   5575: iload 14
    //   5577: istore 7
    //   5579: iload 11
    //   5581: istore 4
    //   5583: goto -1530 -> 4053
    //   5586: astore_1
    //   5587: iload 4
    //   5589: istore 8
    //   5591: iload 7
    //   5593: istore 4
    //   5595: iload 8
    //   5597: istore 7
    //   5599: goto -1546 -> 4053
    //   5602: astore_1
    //   5603: iload 4
    //   5605: istore 8
    //   5607: iload 7
    //   5609: istore 4
    //   5611: iload 8
    //   5613: istore 7
    //   5615: goto -1562 -> 4053
    //   5618: astore_1
    //   5619: aconst_null
    //   5620: astore 34
    //   5622: iconst_0
    //   5623: istore 4
    //   5625: iload 12
    //   5627: istore 7
    //   5629: goto -1576 -> 4053
    //   5632: astore_1
    //   5633: aconst_null
    //   5634: astore 34
    //   5636: iconst_0
    //   5637: istore 4
    //   5639: goto -1586 -> 4053
    //   5642: astore_1
    //   5643: aload 39
    //   5645: astore 34
    //   5647: iconst_0
    //   5648: istore 4
    //   5650: goto -1597 -> 4053
    //   5653: astore_1
    //   5654: aconst_null
    //   5655: astore 34
    //   5657: iload 11
    //   5659: istore 4
    //   5661: goto -1608 -> 4053
    //   5664: astore_1
    //   5665: aload 36
    //   5667: astore 34
    //   5669: iload 9
    //   5671: istore 4
    //   5673: goto -1620 -> 4053
    //   5676: astore_1
    //   5677: iload 8
    //   5679: istore 4
    //   5681: aload 36
    //   5683: astore 34
    //   5685: goto -1632 -> 4053
    //   5688: astore_1
    //   5689: aload 36
    //   5691: astore 34
    //   5693: goto -1640 -> 4053
    //   5696: astore_1
    //   5697: aconst_null
    //   5698: astore 34
    //   5700: goto -1647 -> 4053
    //   5703: astore_1
    //   5704: aload 39
    //   5706: astore 34
    //   5708: iload 8
    //   5710: istore 4
    //   5712: goto -1659 -> 4053
    //   5715: astore_1
    //   5716: aconst_null
    //   5717: astore 34
    //   5719: goto -1666 -> 4053
    //   5722: astore_1
    //   5723: aconst_null
    //   5724: astore 34
    //   5726: goto -1673 -> 4053
    //   5729: astore 5
    //   5731: aload_1
    //   5732: astore 34
    //   5734: aload 5
    //   5736: astore_1
    //   5737: goto -1684 -> 4053
    //   5740: astore 35
    //   5742: aconst_null
    //   5743: astore 34
    //   5745: goto -1838 -> 3907
    //   5748: astore 35
    //   5750: aconst_null
    //   5751: astore 34
    //   5753: goto -1846 -> 3907
    //   5756: astore 35
    //   5758: aconst_null
    //   5759: astore 34
    //   5761: iload 9
    //   5763: istore 4
    //   5765: goto -2799 -> 2966
    //   5768: astore 35
    //   5770: aconst_null
    //   5771: astore 34
    //   5773: goto -2807 -> 2966
    //   5776: astore_1
    //   5777: iconst_0
    //   5778: istore 4
    //   5780: iload 8
    //   5782: istore 7
    //   5784: iload 13
    //   5786: istore 8
    //   5788: goto -4551 -> 1237
    //   5791: astore_1
    //   5792: iload 8
    //   5794: istore 7
    //   5796: iload 16
    //   5798: istore 8
    //   5800: goto -4563 -> 1237
    //   5803: astore_1
    //   5804: iload 7
    //   5806: istore 9
    //   5808: iload 8
    //   5810: istore 7
    //   5812: iload 9
    //   5814: istore 8
    //   5816: goto -4579 -> 1237
    //   5819: astore_1
    //   5820: iload 7
    //   5822: istore 9
    //   5824: iload 8
    //   5826: istore 7
    //   5828: iload 9
    //   5830: istore 8
    //   5832: goto -4595 -> 1237
    //   5835: astore_1
    //   5836: iconst_0
    //   5837: istore 7
    //   5839: iload 19
    //   5841: istore 4
    //   5843: goto -4738 -> 1105
    //   5846: astore_1
    //   5847: iload 4
    //   5849: istore 7
    //   5851: iload 17
    //   5853: istore 4
    //   5855: goto -4750 -> 1105
    //   5858: astore_1
    //   5859: iload 7
    //   5861: istore 9
    //   5863: iload 4
    //   5865: istore 7
    //   5867: iload 9
    //   5869: istore 4
    //   5871: goto -4766 -> 1105
    //   5874: astore_1
    //   5875: iload 7
    //   5877: istore 9
    //   5879: iload 4
    //   5881: istore 7
    //   5883: iload 9
    //   5885: istore 4
    //   5887: goto -4782 -> 1105
    //   5890: iload 4
    //   5892: istore 8
    //   5894: goto -3017 -> 2877
    //   5897: iload 10
    //   5899: istore 9
    //   5901: aload 36
    //   5903: astore_1
    //   5904: goto -5116 -> 788
    //   5907: goto -3435 -> 2472
    //   5910: goto -3490 -> 2420
    //   5913: goto -3441 -> 2472
    //   5916: iconst_0
    //   5917: istore 7
    //   5919: goto -4346 -> 1573
    //   5922: iload 4
    //   5924: istore 10
    //   5926: goto -4375 -> 1551
    //   5929: goto -5169 -> 760
    //   5932: iconst_0
    //   5933: istore 4
    //   5935: goto -5476 -> 459
    //   5938: iload 4
    //   5940: istore 8
    //   5942: goto -5521 -> 421
    //   5945: iconst_0
    //   5946: istore 9
    //   5948: iconst_0
    //   5949: istore 7
    //   5951: iload 4
    //   5953: istore 8
    //   5955: iload 9
    //   5957: istore 4
    //   5959: goto -5190 -> 769
    //   5962: ldc2_w 295
    //   5965: lstore 28
    //   5967: iconst_0
    //   5968: istore 6
    //   5970: iconst_0
    //   5971: istore 4
    //   5973: aload 34
    //   5975: astore_1
    //   5976: goto -4985 -> 991
    //   5979: iload 4
    //   5981: iconst_2
    //   5982: iand
    //   5983: iconst_2
    //   5984: if_icmpne -1983 -> 4001
    //   5987: iconst_1
    //   5988: istore_2
    //   5989: goto -5099 -> 890
    //   5992: aload 34
    //   5994: astore_1
    //   5995: iload 8
    //   5997: istore 9
    //   5999: goto -5211 -> 788
    //   6002: astore_1
    //   6003: iconst_0
    //   6004: istore 8
    //   6006: iload 4
    //   6008: istore 7
    //   6010: iload 8
    //   6012: istore 4
    //   6014: iload 13
    //   6016: istore 8
    //   6018: goto -4781 -> 1237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6021	0	paramUri	Uri
    //   0	6021	1	paramContext	Context
    //   0	6021	2	paramBoolean1	boolean
    //   0	6021	3	paramBoolean2	boolean
    //   0	6021	4	paramInt	int
    //   0	6021	5	paramSparseArray	SparseArray<Object>
    //   113	5856	6	i	int
    //   95	5914	7	j	int
    //   101	5916	8	k	int
    //   104	5894	9	m	int
    //   107	5818	10	n	int
    //   110	5548	11	i1	int
    //   89	5537	12	i2	int
    //   53	5962	13	i3	int
    //   62	5514	14	i4	int
    //   59	5274	15	i5	int
    //   68	5729	16	i6	int
    //   71	5781	17	i7	int
    //   65	419	18	i8	int
    //   74	5766	19	i9	int
    //   56	1723	20	i10	int
    //   92	1471	21	i11	int
    //   98	177	22	i12	int
    //   229	50	23	i13	int
    //   238	86	24	i14	int
    //   223	48	25	i15	int
    //   232	51	26	i16	int
    //   235	52	27	i17	int
    //   118	5848	28	l1	long
    //   190	5354	30	l2	long
    //   17	1046	32	l3	long
    //   86	5907	34	localObject1	Object
    //   122	2590	35	localObject2	Object
    //   2890	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2964	776	35	localObject3	Object
    //   3810	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3905	1063	35	localContext	Context
    //   5740	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5748	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5756	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5768	1	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   130	5772	36	localObject4	Object
    //   134	5114	37	localObject5	Object
    //   126	5294	38	localObject6	Object
    //   80	5625	39	localObject7	Object
    //   77	3711	40	localStringBuilder	StringBuilder
    //   83	2713	41	localObject8	Object
    //   140	2938	42	localContentResolver	android.content.ContentResolver
    //   1647	2043	43	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   340	383	1093	java/lang/OutOfMemoryError
    //   388	410	1093	java/lang/OutOfMemoryError
    //   1492	1500	1500	java/io/IOException
    //   1608	1616	2890	java/lang/OutOfMemoryError
    //   1639	1649	2890	java/lang/OutOfMemoryError
    //   1672	1678	2890	java/lang/OutOfMemoryError
    //   1701	1745	2890	java/lang/OutOfMemoryError
    //   1768	1773	2890	java/lang/OutOfMemoryError
    //   1787	1798	2890	java/lang/OutOfMemoryError
    //   1910	1918	2958	java/lang/OutOfMemoryError
    //   1957	1964	2958	java/lang/OutOfMemoryError
    //   2003	2009	2958	java/lang/OutOfMemoryError
    //   2048	2076	2958	java/lang/OutOfMemoryError
    //   2115	2120	2958	java/lang/OutOfMemoryError
    //   3077	3085	3810	java/lang/OutOfMemoryError
    //   3128	3135	3810	java/lang/OutOfMemoryError
    //   3178	3184	3810	java/lang/OutOfMemoryError
    //   3227	3255	3810	java/lang/OutOfMemoryError
    //   3298	3303	3810	java/lang/OutOfMemoryError
    //   3345	3354	3810	java/lang/OutOfMemoryError
    //   3381	3397	3810	java/lang/OutOfMemoryError
    //   3424	3433	3810	java/lang/OutOfMemoryError
    //   3460	3472	3810	java/lang/OutOfMemoryError
    //   3499	3519	3810	java/lang/OutOfMemoryError
    //   3556	3576	3810	java/lang/OutOfMemoryError
    //   3603	3615	3810	java/lang/OutOfMemoryError
    //   3642	3662	3810	java/lang/OutOfMemoryError
    //   3689	3694	3810	java/lang/OutOfMemoryError
    //   3725	3731	3810	java/lang/OutOfMemoryError
    //   3758	3799	3810	java/lang/OutOfMemoryError
    //   2540	2548	3899	java/lang/OutOfMemoryError
    //   2587	2597	3899	java/lang/OutOfMemoryError
    //   2636	2642	3899	java/lang/OutOfMemoryError
    //   2681	2709	3899	java/lang/OutOfMemoryError
    //   2748	2753	3899	java/lang/OutOfMemoryError
    //   1024	1028	4006	java/io/IOException
    //   136	142	4038	java/io/IOException
    //   158	166	4038	java/io/IOException
    //   187	192	4038	java/io/IOException
    //   4108	4113	4120	java/io/IOException
    //   136	142	4152	java/lang/RuntimeException
    //   158	166	4152	java/lang/RuntimeException
    //   187	192	4152	java/lang/RuntimeException
    //   4274	4279	4286	java/io/IOException
    //   136	142	4318	java/lang/UnsatisfiedLinkError
    //   158	166	4318	java/lang/UnsatisfiedLinkError
    //   187	192	4318	java/lang/UnsatisfiedLinkError
    //   4440	4445	4452	java/io/IOException
    //   136	142	4484	java/lang/Throwable
    //   158	166	4484	java/lang/Throwable
    //   187	192	4484	java/lang/Throwable
    //   4606	4611	4618	java/io/IOException
    //   136	142	4650	finally
    //   158	166	4650	finally
    //   4693	4697	4699	java/io/IOException
    //   187	192	4723	finally
    //   208	222	4741	finally
    //   264	270	4741	finally
    //   290	323	4741	finally
    //   327	336	4755	finally
    //   340	383	4755	finally
    //   388	410	4755	finally
    //   421	444	4755	finally
    //   452	456	4755	finally
    //   1384	1413	4755	finally
    //   487	502	4765	finally
    //   506	512	4765	finally
    //   516	557	4765	finally
    //   561	570	4765	finally
    //   574	585	4765	finally
    //   607	613	4765	finally
    //   617	623	4765	finally
    //   632	648	4765	finally
    //   691	697	4765	finally
    //   733	760	4765	finally
    //   764	769	4765	finally
    //   1141	1145	4765	finally
    //   1181	1187	4765	finally
    //   1223	1234	4765	finally
    //   1273	1277	4765	finally
    //   1313	1319	4765	finally
    //   1355	1366	4765	finally
    //   823	832	4776	finally
    //   839	848	4776	finally
    //   855	863	4776	finally
    //   870	887	4776	finally
    //   906	917	4776	finally
    //   924	930	4776	finally
    //   937	991	4776	finally
    //   1428	1435	4776	finally
    //   1442	1449	4776	finally
    //   1534	1544	4776	finally
    //   1566	1570	4776	finally
    //   1576	1592	4787	finally
    //   1595	1601	4787	finally
    //   1608	1616	4787	finally
    //   1639	1649	4787	finally
    //   1672	1678	4787	finally
    //   1701	1745	4787	finally
    //   1768	1773	4787	finally
    //   1787	1798	4787	finally
    //   1832	1841	4787	finally
    //   1910	1918	4787	finally
    //   1957	1964	4787	finally
    //   2003	2009	4787	finally
    //   2048	2076	4787	finally
    //   2115	2120	4787	finally
    //   2484	2493	4787	finally
    //   2501	2510	4787	finally
    //   2521	2537	4787	finally
    //   2540	2548	4787	finally
    //   2587	2597	4787	finally
    //   2636	2642	4787	finally
    //   2681	2709	4787	finally
    //   2748	2753	4787	finally
    //   2911	2916	4787	finally
    //   2935	2940	4787	finally
    //   3001	3006	4787	finally
    //   3041	3046	4787	finally
    //   3077	3085	4787	finally
    //   3128	3135	4787	finally
    //   3178	3184	4787	finally
    //   3227	3255	4787	finally
    //   3298	3303	4787	finally
    //   3345	3354	4787	finally
    //   3381	3397	4787	finally
    //   3424	3433	4787	finally
    //   3460	3472	4787	finally
    //   3499	3519	4787	finally
    //   3556	3576	4787	finally
    //   3603	3615	4787	finally
    //   3642	3662	4787	finally
    //   3689	3694	4787	finally
    //   3725	3731	4787	finally
    //   3758	3799	4787	finally
    //   3847	3852	4787	finally
    //   3887	3892	4787	finally
    //   3942	3947	4787	finally
    //   3982	3987	4787	finally
    //   2157	2166	4791	finally
    //   2186	2202	4791	finally
    //   2222	2230	4791	finally
    //   2250	2261	4791	finally
    //   2281	2300	4791	finally
    //   2326	2346	4791	finally
    //   2366	2377	4791	finally
    //   2397	2413	4791	finally
    //   2420	2472	4791	finally
    //   2758	2815	4797	finally
    //   2826	2873	4797	finally
    //   4053	4074	4803	finally
    //   4187	4191	4810	finally
    //   4207	4213	4810	finally
    //   4229	4240	4810	finally
    //   4353	4357	4810	finally
    //   4373	4379	4810	finally
    //   4395	4406	4810	finally
    //   4519	4523	4810	finally
    //   4539	4545	4810	finally
    //   4561	4572	4810	finally
    //   208	222	4825	java/lang/Throwable
    //   264	270	4825	java/lang/Throwable
    //   290	323	4825	java/lang/Throwable
    //   327	336	4843	java/lang/Throwable
    //   1384	1413	4843	java/lang/Throwable
    //   1141	1145	4857	java/lang/Throwable
    //   1181	1187	4857	java/lang/Throwable
    //   1223	1234	4857	java/lang/Throwable
    //   1273	1277	4857	java/lang/Throwable
    //   1313	1319	4857	java/lang/Throwable
    //   1355	1366	4857	java/lang/Throwable
    //   1428	1435	4873	java/lang/Throwable
    //   1442	1449	4873	java/lang/Throwable
    //   1534	1544	4873	java/lang/Throwable
    //   1566	1570	4873	java/lang/Throwable
    //   1576	1592	4890	java/lang/Throwable
    //   1595	1601	4890	java/lang/Throwable
    //   1608	1616	4890	java/lang/Throwable
    //   1787	1798	4890	java/lang/Throwable
    //   1639	1649	4904	java/lang/Throwable
    //   1672	1678	4904	java/lang/Throwable
    //   1701	1745	4904	java/lang/Throwable
    //   1768	1773	4904	java/lang/Throwable
    //   2911	2916	4904	java/lang/Throwable
    //   2935	2940	4904	java/lang/Throwable
    //   1832	1841	4919	java/lang/Throwable
    //   1910	1918	4919	java/lang/Throwable
    //   3077	3085	4919	java/lang/Throwable
    //   3345	3354	4919	java/lang/Throwable
    //   3381	3397	4919	java/lang/Throwable
    //   3424	3433	4919	java/lang/Throwable
    //   3460	3472	4919	java/lang/Throwable
    //   3499	3519	4919	java/lang/Throwable
    //   3556	3576	4919	java/lang/Throwable
    //   3603	3615	4919	java/lang/Throwable
    //   3642	3662	4919	java/lang/Throwable
    //   3689	3694	4919	java/lang/Throwable
    //   3725	3731	4919	java/lang/Throwable
    //   3758	3799	4919	java/lang/Throwable
    //   1957	1964	4934	java/lang/Throwable
    //   2003	2009	4934	java/lang/Throwable
    //   2048	2076	4934	java/lang/Throwable
    //   2115	2120	4934	java/lang/Throwable
    //   3001	3006	4934	java/lang/Throwable
    //   3041	3046	4934	java/lang/Throwable
    //   3128	3135	4934	java/lang/Throwable
    //   3178	3184	4934	java/lang/Throwable
    //   3227	3255	4934	java/lang/Throwable
    //   3298	3303	4934	java/lang/Throwable
    //   3847	3852	4934	java/lang/Throwable
    //   3887	3892	4934	java/lang/Throwable
    //   2157	2166	4950	java/lang/Throwable
    //   2186	2202	4950	java/lang/Throwable
    //   2222	2230	4950	java/lang/Throwable
    //   2250	2261	4950	java/lang/Throwable
    //   2281	2300	4950	java/lang/Throwable
    //   2326	2346	4950	java/lang/Throwable
    //   2366	2377	4950	java/lang/Throwable
    //   2397	2413	4950	java/lang/Throwable
    //   2420	2472	4966	java/lang/Throwable
    //   2484	2493	4978	java/lang/Throwable
    //   2501	2510	4978	java/lang/Throwable
    //   2521	2537	4978	java/lang/Throwable
    //   2540	2548	4978	java/lang/Throwable
    //   2587	2597	4989	java/lang/Throwable
    //   2636	2642	4989	java/lang/Throwable
    //   2681	2709	4989	java/lang/Throwable
    //   2748	2753	4989	java/lang/Throwable
    //   3942	3947	4989	java/lang/Throwable
    //   3982	3987	4989	java/lang/Throwable
    //   2758	2815	5005	java/lang/Throwable
    //   2826	2873	5016	java/lang/Throwable
    //   823	832	5027	java/lang/Throwable
    //   839	848	5027	java/lang/Throwable
    //   855	863	5027	java/lang/Throwable
    //   870	887	5027	java/lang/Throwable
    //   906	917	5027	java/lang/Throwable
    //   924	930	5027	java/lang/Throwable
    //   937	991	5027	java/lang/Throwable
    //   208	222	5042	java/lang/UnsatisfiedLinkError
    //   264	270	5042	java/lang/UnsatisfiedLinkError
    //   290	323	5042	java/lang/UnsatisfiedLinkError
    //   327	336	5060	java/lang/UnsatisfiedLinkError
    //   340	383	5060	java/lang/UnsatisfiedLinkError
    //   388	410	5060	java/lang/UnsatisfiedLinkError
    //   421	444	5060	java/lang/UnsatisfiedLinkError
    //   452	456	5060	java/lang/UnsatisfiedLinkError
    //   1384	1413	5060	java/lang/UnsatisfiedLinkError
    //   487	502	5074	java/lang/UnsatisfiedLinkError
    //   691	697	5074	java/lang/UnsatisfiedLinkError
    //   733	760	5074	java/lang/UnsatisfiedLinkError
    //   1141	1145	5074	java/lang/UnsatisfiedLinkError
    //   1181	1187	5074	java/lang/UnsatisfiedLinkError
    //   1223	1234	5074	java/lang/UnsatisfiedLinkError
    //   1273	1277	5074	java/lang/UnsatisfiedLinkError
    //   1313	1319	5074	java/lang/UnsatisfiedLinkError
    //   1355	1366	5074	java/lang/UnsatisfiedLinkError
    //   506	512	5090	java/lang/UnsatisfiedLinkError
    //   516	557	5090	java/lang/UnsatisfiedLinkError
    //   561	570	5090	java/lang/UnsatisfiedLinkError
    //   574	585	5090	java/lang/UnsatisfiedLinkError
    //   607	613	5090	java/lang/UnsatisfiedLinkError
    //   617	623	5090	java/lang/UnsatisfiedLinkError
    //   632	648	5090	java/lang/UnsatisfiedLinkError
    //   764	769	5110	java/lang/UnsatisfiedLinkError
    //   1428	1435	5130	java/lang/UnsatisfiedLinkError
    //   1442	1449	5130	java/lang/UnsatisfiedLinkError
    //   1534	1544	5130	java/lang/UnsatisfiedLinkError
    //   1566	1570	5130	java/lang/UnsatisfiedLinkError
    //   1576	1592	5147	java/lang/UnsatisfiedLinkError
    //   1595	1601	5147	java/lang/UnsatisfiedLinkError
    //   1608	1616	5147	java/lang/UnsatisfiedLinkError
    //   1787	1798	5147	java/lang/UnsatisfiedLinkError
    //   1639	1649	5161	java/lang/UnsatisfiedLinkError
    //   1672	1678	5161	java/lang/UnsatisfiedLinkError
    //   1701	1745	5161	java/lang/UnsatisfiedLinkError
    //   1768	1773	5161	java/lang/UnsatisfiedLinkError
    //   2911	2916	5161	java/lang/UnsatisfiedLinkError
    //   2935	2940	5161	java/lang/UnsatisfiedLinkError
    //   1832	1841	5176	java/lang/UnsatisfiedLinkError
    //   1910	1918	5176	java/lang/UnsatisfiedLinkError
    //   3077	3085	5176	java/lang/UnsatisfiedLinkError
    //   3345	3354	5176	java/lang/UnsatisfiedLinkError
    //   3381	3397	5176	java/lang/UnsatisfiedLinkError
    //   3424	3433	5176	java/lang/UnsatisfiedLinkError
    //   3460	3472	5176	java/lang/UnsatisfiedLinkError
    //   3499	3519	5176	java/lang/UnsatisfiedLinkError
    //   3556	3576	5176	java/lang/UnsatisfiedLinkError
    //   3603	3615	5176	java/lang/UnsatisfiedLinkError
    //   3642	3662	5176	java/lang/UnsatisfiedLinkError
    //   3689	3694	5176	java/lang/UnsatisfiedLinkError
    //   3725	3731	5176	java/lang/UnsatisfiedLinkError
    //   3758	3799	5176	java/lang/UnsatisfiedLinkError
    //   1957	1964	5191	java/lang/UnsatisfiedLinkError
    //   2003	2009	5191	java/lang/UnsatisfiedLinkError
    //   2048	2076	5191	java/lang/UnsatisfiedLinkError
    //   2115	2120	5191	java/lang/UnsatisfiedLinkError
    //   3001	3006	5191	java/lang/UnsatisfiedLinkError
    //   3041	3046	5191	java/lang/UnsatisfiedLinkError
    //   3128	3135	5191	java/lang/UnsatisfiedLinkError
    //   3178	3184	5191	java/lang/UnsatisfiedLinkError
    //   3227	3255	5191	java/lang/UnsatisfiedLinkError
    //   3298	3303	5191	java/lang/UnsatisfiedLinkError
    //   3847	3852	5191	java/lang/UnsatisfiedLinkError
    //   3887	3892	5191	java/lang/UnsatisfiedLinkError
    //   2157	2166	5207	java/lang/UnsatisfiedLinkError
    //   2186	2202	5207	java/lang/UnsatisfiedLinkError
    //   2222	2230	5207	java/lang/UnsatisfiedLinkError
    //   2250	2261	5207	java/lang/UnsatisfiedLinkError
    //   2281	2300	5207	java/lang/UnsatisfiedLinkError
    //   2326	2346	5207	java/lang/UnsatisfiedLinkError
    //   2366	2377	5207	java/lang/UnsatisfiedLinkError
    //   2397	2413	5207	java/lang/UnsatisfiedLinkError
    //   2420	2472	5223	java/lang/UnsatisfiedLinkError
    //   2484	2493	5235	java/lang/UnsatisfiedLinkError
    //   2501	2510	5235	java/lang/UnsatisfiedLinkError
    //   2521	2537	5235	java/lang/UnsatisfiedLinkError
    //   2540	2548	5235	java/lang/UnsatisfiedLinkError
    //   2587	2597	5246	java/lang/UnsatisfiedLinkError
    //   2636	2642	5246	java/lang/UnsatisfiedLinkError
    //   2681	2709	5246	java/lang/UnsatisfiedLinkError
    //   2748	2753	5246	java/lang/UnsatisfiedLinkError
    //   3942	3947	5246	java/lang/UnsatisfiedLinkError
    //   3982	3987	5246	java/lang/UnsatisfiedLinkError
    //   2758	2815	5262	java/lang/UnsatisfiedLinkError
    //   2826	2873	5273	java/lang/UnsatisfiedLinkError
    //   823	832	5284	java/lang/UnsatisfiedLinkError
    //   839	848	5284	java/lang/UnsatisfiedLinkError
    //   855	863	5284	java/lang/UnsatisfiedLinkError
    //   870	887	5284	java/lang/UnsatisfiedLinkError
    //   906	917	5284	java/lang/UnsatisfiedLinkError
    //   924	930	5284	java/lang/UnsatisfiedLinkError
    //   937	991	5284	java/lang/UnsatisfiedLinkError
    //   208	222	5299	java/lang/RuntimeException
    //   264	270	5299	java/lang/RuntimeException
    //   290	323	5299	java/lang/RuntimeException
    //   327	336	5317	java/lang/RuntimeException
    //   340	383	5317	java/lang/RuntimeException
    //   388	410	5317	java/lang/RuntimeException
    //   421	444	5317	java/lang/RuntimeException
    //   452	456	5317	java/lang/RuntimeException
    //   1384	1413	5317	java/lang/RuntimeException
    //   487	502	5331	java/lang/RuntimeException
    //   691	697	5331	java/lang/RuntimeException
    //   733	760	5331	java/lang/RuntimeException
    //   1141	1145	5331	java/lang/RuntimeException
    //   1181	1187	5331	java/lang/RuntimeException
    //   1223	1234	5331	java/lang/RuntimeException
    //   1273	1277	5331	java/lang/RuntimeException
    //   1313	1319	5331	java/lang/RuntimeException
    //   1355	1366	5331	java/lang/RuntimeException
    //   506	512	5347	java/lang/RuntimeException
    //   516	557	5347	java/lang/RuntimeException
    //   561	570	5347	java/lang/RuntimeException
    //   574	585	5347	java/lang/RuntimeException
    //   607	613	5347	java/lang/RuntimeException
    //   617	623	5347	java/lang/RuntimeException
    //   632	648	5347	java/lang/RuntimeException
    //   764	769	5367	java/lang/RuntimeException
    //   1428	1435	5387	java/lang/RuntimeException
    //   1442	1449	5387	java/lang/RuntimeException
    //   1534	1544	5387	java/lang/RuntimeException
    //   1566	1570	5387	java/lang/RuntimeException
    //   1576	1592	5404	java/lang/RuntimeException
    //   1595	1601	5404	java/lang/RuntimeException
    //   1608	1616	5404	java/lang/RuntimeException
    //   1787	1798	5404	java/lang/RuntimeException
    //   1639	1649	5418	java/lang/RuntimeException
    //   1672	1678	5418	java/lang/RuntimeException
    //   1701	1745	5418	java/lang/RuntimeException
    //   1768	1773	5418	java/lang/RuntimeException
    //   2911	2916	5418	java/lang/RuntimeException
    //   2935	2940	5418	java/lang/RuntimeException
    //   1832	1841	5433	java/lang/RuntimeException
    //   1910	1918	5433	java/lang/RuntimeException
    //   3077	3085	5433	java/lang/RuntimeException
    //   3345	3354	5433	java/lang/RuntimeException
    //   3381	3397	5433	java/lang/RuntimeException
    //   3424	3433	5433	java/lang/RuntimeException
    //   3460	3472	5433	java/lang/RuntimeException
    //   3499	3519	5433	java/lang/RuntimeException
    //   3556	3576	5433	java/lang/RuntimeException
    //   3603	3615	5433	java/lang/RuntimeException
    //   3642	3662	5433	java/lang/RuntimeException
    //   3689	3694	5433	java/lang/RuntimeException
    //   3725	3731	5433	java/lang/RuntimeException
    //   3758	3799	5433	java/lang/RuntimeException
    //   1957	1964	5448	java/lang/RuntimeException
    //   2003	2009	5448	java/lang/RuntimeException
    //   2048	2076	5448	java/lang/RuntimeException
    //   2115	2120	5448	java/lang/RuntimeException
    //   3001	3006	5448	java/lang/RuntimeException
    //   3041	3046	5448	java/lang/RuntimeException
    //   3128	3135	5448	java/lang/RuntimeException
    //   3178	3184	5448	java/lang/RuntimeException
    //   3227	3255	5448	java/lang/RuntimeException
    //   3298	3303	5448	java/lang/RuntimeException
    //   3847	3852	5448	java/lang/RuntimeException
    //   3887	3892	5448	java/lang/RuntimeException
    //   2157	2166	5464	java/lang/RuntimeException
    //   2186	2202	5464	java/lang/RuntimeException
    //   2222	2230	5464	java/lang/RuntimeException
    //   2250	2261	5464	java/lang/RuntimeException
    //   2281	2300	5464	java/lang/RuntimeException
    //   2326	2346	5464	java/lang/RuntimeException
    //   2366	2377	5464	java/lang/RuntimeException
    //   2397	2413	5464	java/lang/RuntimeException
    //   2420	2472	5476	java/lang/RuntimeException
    //   2484	2493	5484	java/lang/RuntimeException
    //   2501	2510	5484	java/lang/RuntimeException
    //   2521	2537	5484	java/lang/RuntimeException
    //   2540	2548	5484	java/lang/RuntimeException
    //   2587	2597	5495	java/lang/RuntimeException
    //   2636	2642	5495	java/lang/RuntimeException
    //   2681	2709	5495	java/lang/RuntimeException
    //   2748	2753	5495	java/lang/RuntimeException
    //   3942	3947	5495	java/lang/RuntimeException
    //   3982	3987	5495	java/lang/RuntimeException
    //   2758	2815	5511	java/lang/RuntimeException
    //   2826	2873	5522	java/lang/RuntimeException
    //   823	832	5533	java/lang/RuntimeException
    //   839	848	5533	java/lang/RuntimeException
    //   855	863	5533	java/lang/RuntimeException
    //   870	887	5533	java/lang/RuntimeException
    //   906	917	5533	java/lang/RuntimeException
    //   924	930	5533	java/lang/RuntimeException
    //   937	991	5533	java/lang/RuntimeException
    //   208	222	5548	java/io/IOException
    //   264	270	5548	java/io/IOException
    //   290	323	5548	java/io/IOException
    //   327	336	5563	java/io/IOException
    //   340	383	5563	java/io/IOException
    //   388	410	5563	java/io/IOException
    //   421	444	5563	java/io/IOException
    //   452	456	5563	java/io/IOException
    //   1384	1413	5563	java/io/IOException
    //   487	502	5574	java/io/IOException
    //   691	697	5574	java/io/IOException
    //   733	760	5574	java/io/IOException
    //   1141	1145	5574	java/io/IOException
    //   1181	1187	5574	java/io/IOException
    //   1223	1234	5574	java/io/IOException
    //   1273	1277	5574	java/io/IOException
    //   1313	1319	5574	java/io/IOException
    //   1355	1366	5574	java/io/IOException
    //   506	512	5586	java/io/IOException
    //   516	557	5586	java/io/IOException
    //   561	570	5586	java/io/IOException
    //   574	585	5586	java/io/IOException
    //   607	613	5586	java/io/IOException
    //   617	623	5586	java/io/IOException
    //   632	648	5586	java/io/IOException
    //   764	769	5602	java/io/IOException
    //   1428	1435	5618	java/io/IOException
    //   1442	1449	5618	java/io/IOException
    //   1534	1544	5618	java/io/IOException
    //   1566	1570	5618	java/io/IOException
    //   1576	1592	5632	java/io/IOException
    //   1595	1601	5632	java/io/IOException
    //   1608	1616	5632	java/io/IOException
    //   1787	1798	5632	java/io/IOException
    //   1639	1649	5642	java/io/IOException
    //   1672	1678	5642	java/io/IOException
    //   1701	1745	5642	java/io/IOException
    //   1768	1773	5642	java/io/IOException
    //   2911	2916	5642	java/io/IOException
    //   2935	2940	5642	java/io/IOException
    //   1832	1841	5653	java/io/IOException
    //   1910	1918	5653	java/io/IOException
    //   3077	3085	5653	java/io/IOException
    //   3345	3354	5653	java/io/IOException
    //   3381	3397	5653	java/io/IOException
    //   3424	3433	5653	java/io/IOException
    //   3460	3472	5653	java/io/IOException
    //   3499	3519	5653	java/io/IOException
    //   3556	3576	5653	java/io/IOException
    //   3603	3615	5653	java/io/IOException
    //   3642	3662	5653	java/io/IOException
    //   3689	3694	5653	java/io/IOException
    //   3725	3731	5653	java/io/IOException
    //   3758	3799	5653	java/io/IOException
    //   1957	1964	5664	java/io/IOException
    //   2003	2009	5664	java/io/IOException
    //   2048	2076	5664	java/io/IOException
    //   2115	2120	5664	java/io/IOException
    //   3001	3006	5664	java/io/IOException
    //   3041	3046	5664	java/io/IOException
    //   3128	3135	5664	java/io/IOException
    //   3178	3184	5664	java/io/IOException
    //   3227	3255	5664	java/io/IOException
    //   3298	3303	5664	java/io/IOException
    //   3847	3852	5664	java/io/IOException
    //   3887	3892	5664	java/io/IOException
    //   2157	2166	5676	java/io/IOException
    //   2186	2202	5676	java/io/IOException
    //   2222	2230	5676	java/io/IOException
    //   2250	2261	5676	java/io/IOException
    //   2281	2300	5676	java/io/IOException
    //   2326	2346	5676	java/io/IOException
    //   2366	2377	5676	java/io/IOException
    //   2397	2413	5676	java/io/IOException
    //   2420	2472	5688	java/io/IOException
    //   2484	2493	5696	java/io/IOException
    //   2501	2510	5696	java/io/IOException
    //   2521	2537	5696	java/io/IOException
    //   2540	2548	5696	java/io/IOException
    //   2587	2597	5703	java/io/IOException
    //   2636	2642	5703	java/io/IOException
    //   2681	2709	5703	java/io/IOException
    //   2748	2753	5703	java/io/IOException
    //   3942	3947	5703	java/io/IOException
    //   3982	3987	5703	java/io/IOException
    //   2758	2815	5715	java/io/IOException
    //   2826	2873	5722	java/io/IOException
    //   823	832	5729	java/io/IOException
    //   839	848	5729	java/io/IOException
    //   855	863	5729	java/io/IOException
    //   870	887	5729	java/io/IOException
    //   906	917	5729	java/io/IOException
    //   924	930	5729	java/io/IOException
    //   937	991	5729	java/io/IOException
    //   2758	2815	5740	java/lang/OutOfMemoryError
    //   2826	2873	5748	java/lang/OutOfMemoryError
    //   2157	2166	5756	java/lang/OutOfMemoryError
    //   2186	2202	5756	java/lang/OutOfMemoryError
    //   2222	2230	5756	java/lang/OutOfMemoryError
    //   2250	2261	5756	java/lang/OutOfMemoryError
    //   2281	2300	5756	java/lang/OutOfMemoryError
    //   2326	2346	5756	java/lang/OutOfMemoryError
    //   2366	2377	5756	java/lang/OutOfMemoryError
    //   2397	2413	5756	java/lang/OutOfMemoryError
    //   2420	2472	5768	java/lang/OutOfMemoryError
    //   421	444	5776	java/lang/Throwable
    //   452	456	5776	java/lang/Throwable
    //   487	502	5791	java/lang/Throwable
    //   691	697	5791	java/lang/Throwable
    //   733	760	5791	java/lang/Throwable
    //   506	512	5803	java/lang/Throwable
    //   516	557	5803	java/lang/Throwable
    //   561	570	5803	java/lang/Throwable
    //   574	585	5803	java/lang/Throwable
    //   607	613	5803	java/lang/Throwable
    //   617	623	5803	java/lang/Throwable
    //   632	648	5803	java/lang/Throwable
    //   764	769	5819	java/lang/Throwable
    //   421	444	5835	java/lang/OutOfMemoryError
    //   452	456	5835	java/lang/OutOfMemoryError
    //   487	502	5846	java/lang/OutOfMemoryError
    //   691	697	5846	java/lang/OutOfMemoryError
    //   733	760	5846	java/lang/OutOfMemoryError
    //   506	512	5858	java/lang/OutOfMemoryError
    //   516	557	5858	java/lang/OutOfMemoryError
    //   561	570	5858	java/lang/OutOfMemoryError
    //   574	585	5858	java/lang/OutOfMemoryError
    //   607	613	5858	java/lang/OutOfMemoryError
    //   617	623	5858	java/lang/OutOfMemoryError
    //   632	648	5858	java/lang/OutOfMemoryError
    //   764	769	5874	java/lang/OutOfMemoryError
    //   340	383	6002	java/lang/Throwable
    //   388	410	6002	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bfru.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bfru.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = amzy.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (amzy.a(paramArrayOfInt))
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
    //   55: astore 33
    //   57: aconst_null
    //   58: astore 36
    //   60: aconst_null
    //   61: astore 32
    //   63: aconst_null
    //   64: astore 34
    //   66: aconst_null
    //   67: astore 35
    //   69: iconst_0
    //   70: istore 21
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 15
    //   78: iconst_0
    //   79: istore 20
    //   81: iconst_0
    //   82: istore 19
    //   84: iconst_0
    //   85: istore 13
    //   87: iconst_0
    //   88: istore 6
    //   90: iconst_0
    //   91: istore 16
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 17
    //   99: iconst_0
    //   100: istore 18
    //   102: iconst_0
    //   103: istore 14
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 35
    //   110: astore 27
    //   112: iload 15
    //   114: istore 12
    //   116: aload 33
    //   118: astore 31
    //   120: iload 20
    //   122: istore 10
    //   124: aload 36
    //   126: astore 29
    //   128: iload 19
    //   130: istore 11
    //   132: aload 32
    //   134: astore 30
    //   136: iload 13
    //   138: istore 9
    //   140: aload 34
    //   142: astore 28
    //   144: iload 6
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 302	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 35
    //   156: astore 27
    //   158: iload 15
    //   160: istore 12
    //   162: aload 33
    //   164: astore 31
    //   166: iload 20
    //   168: istore 10
    //   170: aload 36
    //   172: astore 29
    //   174: iload 19
    //   176: istore 11
    //   178: aload 32
    //   180: astore 30
    //   182: iload 13
    //   184: istore 9
    //   186: aload 34
    //   188: astore 28
    //   190: iload 6
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4025 -> 4227
    //   205: iload_3
    //   206: ifeq +798 -> 1004
    //   209: iload 16
    //   211: istore 8
    //   213: iload 17
    //   215: istore 10
    //   217: iload 18
    //   219: istore 11
    //   221: iload 14
    //   223: istore 9
    //   225: aload_0
    //   226: invokevirtual 313	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 319	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore_0
    //   233: iload 16
    //   235: istore 8
    //   237: iload 17
    //   239: istore 10
    //   241: iload 18
    //   243: istore 11
    //   245: iload 14
    //   247: istore 9
    //   249: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   252: ifeq +45 -> 297
    //   255: iload 16
    //   257: istore 8
    //   259: iload 17
    //   261: istore 10
    //   263: iload 18
    //   265: istore 11
    //   267: iload 14
    //   269: istore 9
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
    //   298: ifnull +3920 -> 4218
    //   301: iload 16
    //   303: istore 8
    //   305: iload 17
    //   307: istore 10
    //   309: iload 18
    //   311: istore 11
    //   313: iload 14
    //   315: istore 9
    //   317: aload_0
    //   318: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   321: istore 6
    //   323: iload 16
    //   325: istore 8
    //   327: iload 17
    //   329: istore 10
    //   331: iload 18
    //   333: istore 11
    //   335: iload 14
    //   337: istore 9
    //   339: aload_0
    //   340: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   343: istore 12
    //   345: iload 16
    //   347: istore 8
    //   349: iload 17
    //   351: istore 10
    //   353: iload 18
    //   355: istore 11
    //   357: iload 14
    //   359: istore 9
    //   361: iload 6
    //   363: iload 12
    //   365: invokestatic 199	bfru:a	(II)Z
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
    //   414: iload 16
    //   416: istore 8
    //   418: iload 17
    //   420: istore 10
    //   422: iload 18
    //   424: istore 11
    //   426: iload 14
    //   428: istore 9
    //   430: iload 6
    //   432: iload 12
    //   434: imul
    //   435: newarray int
    //   437: astore 27
    //   439: iload 16
    //   441: istore 8
    //   443: iload 17
    //   445: istore 10
    //   447: iload 18
    //   449: istore 11
    //   451: iload 14
    //   453: istore 9
    //   455: aload_0
    //   456: aload 27
    //   458: iconst_0
    //   459: iload 6
    //   461: iconst_0
    //   462: iconst_0
    //   463: iload 6
    //   465: iload 12
    //   467: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   470: iload 16
    //   472: istore 8
    //   474: iload 17
    //   476: istore 10
    //   478: iload 18
    //   480: istore 11
    //   482: iload 14
    //   484: istore 9
    //   486: aload_0
    //   487: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   490: iload 16
    //   492: istore 8
    //   494: iload 17
    //   496: istore 10
    //   498: iload 18
    //   500: istore 11
    //   502: iload 14
    //   504: istore 9
    //   506: invokestatic 200	xwb:a	()I
    //   509: pop
    //   510: iconst_1
    //   511: istore 9
    //   513: aload 27
    //   515: aconst_null
    //   516: iload 6
    //   518: iload 12
    //   520: invokestatic 416	xwb:a	([I[BII)I
    //   523: istore 6
    //   525: iload 9
    //   527: istore 8
    //   529: iload 6
    //   531: istore 7
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
    //   568: istore 7
    //   570: iload 9
    //   572: istore 8
    //   574: iload 8
    //   576: istore 6
    //   578: aload_1
    //   579: astore_0
    //   580: iload 7
    //   582: iconst_1
    //   583: if_icmpne +3605 -> 4188
    //   586: iload_2
    //   587: ifeq +2820 -> 3407
    //   590: aload_0
    //   591: astore 27
    //   593: iload 6
    //   595: istore 12
    //   597: aload_0
    //   598: astore 31
    //   600: iload 6
    //   602: istore 10
    //   604: aload_0
    //   605: astore 29
    //   607: iload 6
    //   609: istore 11
    //   611: aload_0
    //   612: astore 30
    //   614: iload 6
    //   616: istore 9
    //   618: aload_0
    //   619: astore 28
    //   621: iload 6
    //   623: istore 8
    //   625: new 45	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   632: astore_1
    //   633: aload_0
    //   634: astore 27
    //   636: iload 6
    //   638: istore 12
    //   640: aload_0
    //   641: astore 31
    //   643: iload 6
    //   645: istore 10
    //   647: aload_0
    //   648: astore 29
    //   650: iload 6
    //   652: istore 11
    //   654: aload_0
    //   655: astore 30
    //   657: iload 6
    //   659: istore 9
    //   661: aload_0
    //   662: astore 28
    //   664: iload 6
    //   666: istore 8
    //   668: new 45	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   675: astore 32
    //   677: aload_0
    //   678: astore 27
    //   680: iload 6
    //   682: istore 12
    //   684: aload_0
    //   685: astore 31
    //   687: iload 6
    //   689: istore 10
    //   691: aload_0
    //   692: astore 29
    //   694: iload 6
    //   696: istore 11
    //   698: aload_0
    //   699: astore 30
    //   701: iload 6
    //   703: istore 9
    //   705: aload_0
    //   706: astore 28
    //   708: iload 6
    //   710: istore 8
    //   712: aload_1
    //   713: aload 32
    //   715: invokestatic 238	bfru:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   718: pop
    //   719: aload_0
    //   720: astore 27
    //   722: iload 6
    //   724: istore 12
    //   726: aload_0
    //   727: astore 31
    //   729: iload 6
    //   731: istore 10
    //   733: aload_0
    //   734: astore 29
    //   736: iload 6
    //   738: istore 11
    //   740: aload_0
    //   741: astore 30
    //   743: iload 6
    //   745: istore 9
    //   747: aload_0
    //   748: astore 28
    //   750: iload 6
    //   752: istore 8
    //   754: new 240	android/util/Pair
    //   757: dup
    //   758: aload 32
    //   760: aload_1
    //   761: invokespecial 243	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   764: astore_1
    //   765: aload_0
    //   766: astore 27
    //   768: iload 6
    //   770: ifeq +7 -> 777
    //   773: invokestatic 253	xwb:b	()I
    //   776: pop
    //   777: aload_1
    //   778: astore_0
    //   779: aload 27
    //   781: ifnull +10 -> 791
    //   784: aload 27
    //   786: invokevirtual 336	java/io/InputStream:close	()V
    //   789: aload_1
    //   790: astore_0
    //   791: aload_0
    //   792: astore 27
    //   794: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   797: ifeq -786 -> 11
    //   800: ldc 43
    //   802: iconst_4
    //   803: new 45	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   810: ldc_w 420
    //   813: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   819: lload 25
    //   821: lsub
    //   822: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   825: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload_0
    //   832: areturn
    //   833: astore_0
    //   834: iload 21
    //   836: istore 6
    //   838: iload 6
    //   840: istore 8
    //   842: iload 6
    //   844: istore 12
    //   846: iload 6
    //   848: istore 10
    //   850: iload 6
    //   852: istore 11
    //   854: iload 6
    //   856: istore 9
    //   858: aload_0
    //   859: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   862: iload 6
    //   864: istore 8
    //   866: iload 6
    //   868: istore 12
    //   870: iload 6
    //   872: istore 10
    //   874: iload 6
    //   876: istore 11
    //   878: iload 6
    //   880: istore 9
    //   882: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +3354 -> 4239
    //   888: iload 6
    //   890: istore 8
    //   892: iload 6
    //   894: istore 12
    //   896: iload 6
    //   898: istore 10
    //   900: iload 6
    //   902: istore 11
    //   904: iload 6
    //   906: istore 9
    //   908: ldc 43
    //   910: iconst_2
    //   911: aload_0
    //   912: invokevirtual 342	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   915: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   918: goto +3321 -> 4239
    //   921: iload 6
    //   923: istore 8
    //   925: iload 6
    //   927: istore 12
    //   929: iload 6
    //   931: istore 10
    //   933: iload 6
    //   935: istore 11
    //   937: iload 6
    //   939: istore 9
    //   941: aload_0
    //   942: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   945: iload 6
    //   947: istore 8
    //   949: iload 6
    //   951: istore 12
    //   953: iload 6
    //   955: istore 10
    //   957: iload 6
    //   959: istore 11
    //   961: iload 6
    //   963: istore 9
    //   965: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: ifeq +3284 -> 4252
    //   971: iload 6
    //   973: istore 8
    //   975: iload 6
    //   977: istore 12
    //   979: iload 6
    //   981: istore 10
    //   983: iload 6
    //   985: istore 11
    //   987: iload 6
    //   989: istore 9
    //   991: ldc 43
    //   993: iconst_2
    //   994: aload_0
    //   995: invokevirtual 272	java/lang/Throwable:toString	()Ljava/lang/String;
    //   998: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: goto +3251 -> 4252
    //   1004: iload 16
    //   1006: istore 8
    //   1008: iload 23
    //   1010: istore 12
    //   1012: iload 17
    //   1014: istore 10
    //   1016: iload 18
    //   1018: istore 11
    //   1020: iload 14
    //   1022: istore 9
    //   1024: new 344	android/graphics/BitmapFactory$Options
    //   1027: dup
    //   1028: invokespecial 345	android/graphics/BitmapFactory$Options:<init>	()V
    //   1031: astore 43
    //   1033: iload 16
    //   1035: istore 8
    //   1037: iload 23
    //   1039: istore 12
    //   1041: iload 17
    //   1043: istore 10
    //   1045: iload 18
    //   1047: istore 11
    //   1049: iload 14
    //   1051: istore 9
    //   1053: aload 43
    //   1055: iconst_1
    //   1056: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1059: iload 16
    //   1061: istore 8
    //   1063: iload 23
    //   1065: istore 12
    //   1067: iload 17
    //   1069: istore 10
    //   1071: iload 18
    //   1073: istore 11
    //   1075: iload 14
    //   1077: istore 9
    //   1079: aload_1
    //   1080: aconst_null
    //   1081: aload 43
    //   1083: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1086: pop
    //   1087: iload 16
    //   1089: istore 8
    //   1091: iload 23
    //   1093: istore 12
    //   1095: iload 17
    //   1097: istore 10
    //   1099: iload 18
    //   1101: istore 11
    //   1103: iload 14
    //   1105: istore 9
    //   1107: aload_1
    //   1108: invokevirtual 336	java/io/InputStream:close	()V
    //   1111: aconst_null
    //   1112: astore 32
    //   1114: aconst_null
    //   1115: astore 38
    //   1117: aconst_null
    //   1118: astore 40
    //   1120: aconst_null
    //   1121: astore 41
    //   1123: aconst_null
    //   1124: astore_1
    //   1125: aconst_null
    //   1126: astore 39
    //   1128: aconst_null
    //   1129: astore 36
    //   1131: aconst_null
    //   1132: astore 33
    //   1134: aconst_null
    //   1135: astore 34
    //   1137: aconst_null
    //   1138: astore 35
    //   1140: aconst_null
    //   1141: astore 37
    //   1143: aload 38
    //   1145: astore 27
    //   1147: iload 15
    //   1149: istore 12
    //   1151: aload 40
    //   1153: astore 31
    //   1155: iload 20
    //   1157: istore 10
    //   1159: aload 41
    //   1161: astore 29
    //   1163: iload 19
    //   1165: istore 11
    //   1167: aload_1
    //   1168: astore 30
    //   1170: iload 13
    //   1172: istore 9
    //   1174: aload 39
    //   1176: astore 28
    //   1178: iload 6
    //   1180: istore 8
    //   1182: aload 43
    //   1184: getfield 357	android/graphics/BitmapFactory$Options:outWidth	I
    //   1187: istore 14
    //   1189: aload 38
    //   1191: astore 27
    //   1193: iload 15
    //   1195: istore 12
    //   1197: aload 40
    //   1199: astore 31
    //   1201: iload 20
    //   1203: istore 10
    //   1205: aload 41
    //   1207: astore 29
    //   1209: iload 19
    //   1211: istore 11
    //   1213: aload_1
    //   1214: astore 30
    //   1216: iload 13
    //   1218: istore 9
    //   1220: aload 39
    //   1222: astore 28
    //   1224: iload 6
    //   1226: istore 8
    //   1228: aload 43
    //   1230: getfield 360	android/graphics/BitmapFactory$Options:outHeight	I
    //   1233: istore 16
    //   1235: aload 38
    //   1237: astore 27
    //   1239: iload 15
    //   1241: istore 12
    //   1243: aload 40
    //   1245: astore 31
    //   1247: iload 20
    //   1249: istore 10
    //   1251: aload 41
    //   1253: astore 29
    //   1255: iload 19
    //   1257: istore 11
    //   1259: aload_1
    //   1260: astore 30
    //   1262: iload 13
    //   1264: istore 9
    //   1266: aload 39
    //   1268: astore 28
    //   1270: iload 6
    //   1272: istore 8
    //   1274: aload 43
    //   1276: iconst_0
    //   1277: putfield 348	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1280: iload 14
    //   1282: sipush 12800
    //   1285: if_icmpgt +11 -> 1296
    //   1288: iload 16
    //   1290: sipush 12800
    //   1293: if_icmple +46 -> 1339
    //   1296: aconst_null
    //   1297: astore_0
    //   1298: aload_0
    //   1299: astore 27
    //   1301: iconst_0
    //   1302: ifeq -1291 -> 11
    //   1305: new 362	java/lang/NullPointerException
    //   1308: dup
    //   1309: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1312: athrow
    //   1313: astore_1
    //   1314: aload_1
    //   1315: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1318: aload_0
    //   1319: astore 27
    //   1321: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1324: ifeq -1313 -> 11
    //   1327: ldc 43
    //   1329: iconst_2
    //   1330: aload_1
    //   1331: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1334: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1337: aconst_null
    //   1338: areturn
    //   1339: aload 38
    //   1341: astore 27
    //   1343: iload 15
    //   1345: istore 12
    //   1347: aload 40
    //   1349: astore 31
    //   1351: iload 20
    //   1353: istore 10
    //   1355: aload 41
    //   1357: astore 29
    //   1359: iload 19
    //   1361: istore 11
    //   1363: aload_1
    //   1364: astore 30
    //   1366: iload 13
    //   1368: istore 9
    //   1370: aload 39
    //   1372: astore 28
    //   1374: iload 6
    //   1376: istore 8
    //   1378: iload 14
    //   1380: iload 16
    //   1382: invokestatic 199	bfru:a	(II)Z
    //   1385: istore_3
    //   1386: iload_3
    //   1387: ifne +46 -> 1433
    //   1390: aconst_null
    //   1391: astore_0
    //   1392: aload_0
    //   1393: astore 27
    //   1395: iconst_0
    //   1396: ifeq -1385 -> 11
    //   1399: new 362	java/lang/NullPointerException
    //   1402: dup
    //   1403: invokespecial 363	java/lang/NullPointerException:<init>	()V
    //   1406: athrow
    //   1407: astore_1
    //   1408: aload_1
    //   1409: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1412: aload_0
    //   1413: astore 27
    //   1415: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -1407 -> 11
    //   1421: ldc 43
    //   1423: iconst_2
    //   1424: aload_1
    //   1425: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   1428: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1431: aconst_null
    //   1432: areturn
    //   1433: aload 38
    //   1435: astore 27
    //   1437: iload 15
    //   1439: istore 12
    //   1441: aload 40
    //   1443: astore 31
    //   1445: iload 20
    //   1447: istore 10
    //   1449: aload 41
    //   1451: astore 29
    //   1453: iload 19
    //   1455: istore 11
    //   1457: aload_1
    //   1458: astore 30
    //   1460: iload 13
    //   1462: istore 9
    //   1464: aload 39
    //   1466: astore 28
    //   1468: iload 6
    //   1470: istore 8
    //   1472: invokestatic 200	xwb:a	()I
    //   1475: pop
    //   1476: iconst_1
    //   1477: istore 11
    //   1479: iconst_1
    //   1480: istore 12
    //   1482: iconst_1
    //   1483: istore 13
    //   1485: iconst_1
    //   1486: istore 10
    //   1488: iconst_1
    //   1489: istore 9
    //   1491: iload 14
    //   1493: iload 16
    //   1495: imul
    //   1496: ldc_w 421
    //   1499: if_icmple +1167 -> 2666
    //   1502: iload 14
    //   1504: iload 16
    //   1506: imul
    //   1507: i2d
    //   1508: dstore 4
    //   1510: aload 37
    //   1512: astore 27
    //   1514: aload 36
    //   1516: astore_1
    //   1517: iload 10
    //   1519: istore 8
    //   1521: aload 33
    //   1523: astore 28
    //   1525: aload 34
    //   1527: astore 29
    //   1529: aload 35
    //   1531: astore 30
    //   1533: aload 43
    //   1535: dload 4
    //   1537: invokestatic 424	java/lang/Math:sqrt	(D)D
    //   1540: ldc2_w 425
    //   1543: ddiv
    //   1544: invokestatic 235	java/lang/Math:ceil	(D)D
    //   1547: d2i
    //   1548: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1551: aload 37
    //   1553: astore 27
    //   1555: aload 36
    //   1557: astore_1
    //   1558: iload 10
    //   1560: istore 8
    //   1562: aload 33
    //   1564: astore 28
    //   1566: aload 34
    //   1568: astore 29
    //   1570: aload 35
    //   1572: astore 30
    //   1574: aload 42
    //   1576: aload_0
    //   1577: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1580: astore 31
    //   1582: aload 31
    //   1584: astore 27
    //   1586: aload 31
    //   1588: astore 32
    //   1590: aload 31
    //   1592: astore_1
    //   1593: iload 10
    //   1595: istore 8
    //   1597: aload 31
    //   1599: astore 28
    //   1601: aload 31
    //   1603: astore 29
    //   1605: aload 31
    //   1607: astore 30
    //   1609: aload 31
    //   1611: aconst_null
    //   1612: aload 43
    //   1614: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1617: astore 33
    //   1619: aload 31
    //   1621: astore 27
    //   1623: aload 31
    //   1625: astore 32
    //   1627: aload 31
    //   1629: astore_1
    //   1630: iload 10
    //   1632: istore 8
    //   1634: aload 31
    //   1636: astore 28
    //   1638: aload 31
    //   1640: astore 29
    //   1642: aload 31
    //   1644: astore 30
    //   1646: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1649: ifeq +93 -> 1742
    //   1652: aload 31
    //   1654: astore 27
    //   1656: aload 31
    //   1658: astore 32
    //   1660: aload 31
    //   1662: astore_1
    //   1663: iload 10
    //   1665: istore 8
    //   1667: aload 31
    //   1669: astore 28
    //   1671: aload 31
    //   1673: astore 29
    //   1675: aload 31
    //   1677: astore 30
    //   1679: ldc 43
    //   1681: iconst_4
    //   1682: new 45	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1689: ldc_w 428
    //   1692: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: aload 33
    //   1697: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1700: ldc_w 430
    //   1703: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: iload 14
    //   1708: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1711: ldc_w 432
    //   1714: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: iload 16
    //   1719: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1722: ldc_w 434
    //   1725: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: aload 43
    //   1730: getfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1733: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1736: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1742: aload 31
    //   1744: astore 27
    //   1746: aload 31
    //   1748: astore 32
    //   1750: aload 31
    //   1752: astore_1
    //   1753: iload 10
    //   1755: istore 8
    //   1757: aload 31
    //   1759: astore 28
    //   1761: aload 31
    //   1763: astore 29
    //   1765: aload 31
    //   1767: astore 30
    //   1769: aload 31
    //   1771: invokevirtual 336	java/io/InputStream:close	()V
    //   1774: iload 7
    //   1776: istore 8
    //   1778: aload 33
    //   1780: ifnull +129 -> 1909
    //   1783: iload 7
    //   1785: istore 6
    //   1787: aload 33
    //   1789: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   1792: istore 15
    //   1794: iload 7
    //   1796: istore 6
    //   1798: aload 33
    //   1800: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   1803: istore 8
    //   1805: iload 7
    //   1807: istore 6
    //   1809: iload 15
    //   1811: iload 8
    //   1813: imul
    //   1814: newarray int
    //   1816: astore_1
    //   1817: iload 7
    //   1819: istore 6
    //   1821: aload 33
    //   1823: aload_1
    //   1824: iconst_0
    //   1825: iload 15
    //   1827: iconst_0
    //   1828: iconst_0
    //   1829: iload 15
    //   1831: iload 8
    //   1833: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1836: iload 7
    //   1838: istore 6
    //   1840: aload 33
    //   1842: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   1845: iload 7
    //   1847: istore 6
    //   1849: aload_1
    //   1850: aconst_null
    //   1851: iload 15
    //   1853: iload 8
    //   1855: invokestatic 416	xwb:a	([I[BII)I
    //   1858: istore 7
    //   1860: iload 7
    //   1862: istore 8
    //   1864: iload 7
    //   1866: istore 6
    //   1868: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1871: ifeq +38 -> 1909
    //   1874: iload 7
    //   1876: istore 6
    //   1878: ldc 43
    //   1880: iconst_4
    //   1881: new 45	java/lang/StringBuilder
    //   1884: dup
    //   1885: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1888: ldc_w 436
    //   1891: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: iload 7
    //   1896: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1899: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1902: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1905: iload 7
    //   1907: istore 8
    //   1909: iload 8
    //   1911: istore 6
    //   1913: aconst_null
    //   1914: astore 31
    //   1916: aconst_null
    //   1917: astore_1
    //   1918: aconst_null
    //   1919: astore 28
    //   1921: aconst_null
    //   1922: astore 29
    //   1924: aconst_null
    //   1925: astore 30
    //   1927: aconst_null
    //   1928: astore 32
    //   1930: aconst_null
    //   1931: astore 27
    //   1933: iload 6
    //   1935: istore 7
    //   1937: iload 6
    //   1939: iconst_1
    //   1940: if_icmpeq +337 -> 2277
    //   1943: iload 14
    //   1945: iconst_2
    //   1946: imul
    //   1947: iload 16
    //   1949: if_icmpgt +955 -> 2904
    //   1952: iload 14
    //   1954: sipush 1280
    //   1957: if_icmpge +947 -> 2904
    //   1960: iload 10
    //   1962: istore 8
    //   1964: aload 42
    //   1966: aload_0
    //   1967: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1970: astore 31
    //   1972: aload 31
    //   1974: astore 27
    //   1976: aload 31
    //   1978: astore_1
    //   1979: iload 10
    //   1981: istore 8
    //   1983: aload 31
    //   1985: astore 28
    //   1987: aload 31
    //   1989: astore 29
    //   1991: aload 31
    //   1993: astore 30
    //   1995: aload 31
    //   1997: astore 32
    //   1999: aload 31
    //   2001: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2004: astore 33
    //   2006: aload 31
    //   2008: astore 27
    //   2010: aload 31
    //   2012: astore_1
    //   2013: iload 10
    //   2015: istore 8
    //   2017: aload 31
    //   2019: astore 28
    //   2021: aload 31
    //   2023: astore 29
    //   2025: aload 31
    //   2027: astore 30
    //   2029: aload 31
    //   2031: astore 32
    //   2033: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2036: ifeq +57 -> 2093
    //   2039: aload 31
    //   2041: astore 27
    //   2043: aload 31
    //   2045: astore_1
    //   2046: iload 10
    //   2048: istore 8
    //   2050: aload 31
    //   2052: astore 28
    //   2054: aload 31
    //   2056: astore 29
    //   2058: aload 31
    //   2060: astore 30
    //   2062: aload 31
    //   2064: astore 32
    //   2066: ldc 43
    //   2068: iconst_4
    //   2069: new 45	java/lang/StringBuilder
    //   2072: dup
    //   2073: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2076: ldc_w 438
    //   2079: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload 33
    //   2084: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2087: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2090: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2093: aload 31
    //   2095: astore 27
    //   2097: aload 31
    //   2099: astore_1
    //   2100: iload 10
    //   2102: istore 8
    //   2104: aload 31
    //   2106: astore 28
    //   2108: aload 31
    //   2110: astore 29
    //   2112: aload 31
    //   2114: astore 30
    //   2116: aload 31
    //   2118: astore 32
    //   2120: aload 31
    //   2122: invokevirtual 336	java/io/InputStream:close	()V
    //   2125: aload 33
    //   2127: ifnull +2088 -> 4215
    //   2130: iload 6
    //   2132: istore 7
    //   2134: iload 14
    //   2136: iload 14
    //   2138: imul
    //   2139: newarray int
    //   2141: astore_1
    //   2142: iload 6
    //   2144: istore 7
    //   2146: aload 33
    //   2148: aload_1
    //   2149: iconst_0
    //   2150: iload 14
    //   2152: iconst_0
    //   2153: iconst_0
    //   2154: iload 14
    //   2156: iload 14
    //   2158: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2161: iload 6
    //   2163: istore 7
    //   2165: iload 14
    //   2167: iload 14
    //   2169: imul
    //   2170: newarray byte
    //   2172: astore 27
    //   2174: iload 6
    //   2176: istore 7
    //   2178: aload_1
    //   2179: aload 27
    //   2181: iload 14
    //   2183: iload 14
    //   2185: invokestatic 416	xwb:a	([I[BII)I
    //   2188: istore 6
    //   2190: iload 6
    //   2192: iconst_1
    //   2193: if_icmpeq +2019 -> 4212
    //   2196: iload 6
    //   2198: istore 7
    //   2200: aload 33
    //   2202: aload_1
    //   2203: iconst_0
    //   2204: iload 14
    //   2206: iconst_0
    //   2207: iload 16
    //   2209: iload 14
    //   2211: isub
    //   2212: iload 14
    //   2214: iload 14
    //   2216: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2219: iload 6
    //   2221: istore 7
    //   2223: aload_1
    //   2224: aload 27
    //   2226: iload 14
    //   2228: iload 14
    //   2230: invokestatic 416	xwb:a	([I[BII)I
    //   2233: istore 6
    //   2235: aload 33
    //   2237: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2240: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2243: ifeq +30 -> 2273
    //   2246: ldc 43
    //   2248: iconst_4
    //   2249: new 45	java/lang/StringBuilder
    //   2252: dup
    //   2253: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2256: ldc_w 440
    //   2259: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: iload 6
    //   2264: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2267: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2270: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2273: iload 6
    //   2275: istore 7
    //   2277: aconst_null
    //   2278: astore 34
    //   2280: aconst_null
    //   2281: astore 37
    //   2283: aconst_null
    //   2284: astore 31
    //   2286: aconst_null
    //   2287: astore 35
    //   2289: aconst_null
    //   2290: astore 32
    //   2292: aconst_null
    //   2293: astore 36
    //   2295: aconst_null
    //   2296: astore 33
    //   2298: iload 7
    //   2300: iconst_1
    //   2301: if_icmpeq +1902 -> 4203
    //   2304: aload 34
    //   2306: astore 27
    //   2308: aload 37
    //   2310: astore_1
    //   2311: iload 10
    //   2313: istore 8
    //   2315: aload 31
    //   2317: astore 28
    //   2319: aload 35
    //   2321: astore 29
    //   2323: aload 32
    //   2325: astore 30
    //   2327: iload 14
    //   2329: iload 16
    //   2331: invokestatic 229	java/lang/Math:min	(II)I
    //   2334: istore 6
    //   2336: iload 6
    //   2338: sipush 250
    //   2341: if_icmple +1862 -> 4203
    //   2344: aload 34
    //   2346: astore 27
    //   2348: aload 37
    //   2350: astore_1
    //   2351: iload 10
    //   2353: istore 8
    //   2355: aload 31
    //   2357: astore 28
    //   2359: aload 35
    //   2361: astore 29
    //   2363: aload 32
    //   2365: astore 30
    //   2367: aload 43
    //   2369: iload 6
    //   2371: i2d
    //   2372: ldc2_w 230
    //   2375: ddiv
    //   2376: invokestatic 235	java/lang/Math:ceil	(D)D
    //   2379: d2i
    //   2380: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2383: aload 34
    //   2385: astore 27
    //   2387: aload 37
    //   2389: astore_1
    //   2390: iload 10
    //   2392: istore 8
    //   2394: aload 31
    //   2396: astore 28
    //   2398: aload 35
    //   2400: astore 29
    //   2402: aload 32
    //   2404: astore 30
    //   2406: aload 36
    //   2408: astore 31
    //   2410: aload 42
    //   2412: aload_0
    //   2413: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2416: astore_0
    //   2417: aload_0
    //   2418: astore 27
    //   2420: aload_0
    //   2421: astore_1
    //   2422: iload 10
    //   2424: istore 8
    //   2426: aload_0
    //   2427: astore 28
    //   2429: aload_0
    //   2430: astore 29
    //   2432: aload_0
    //   2433: astore 30
    //   2435: aload_0
    //   2436: astore 31
    //   2438: aload_0
    //   2439: aconst_null
    //   2440: aload 43
    //   2442: invokestatic 354	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2445: astore 32
    //   2447: aload_0
    //   2448: astore 27
    //   2450: aload_0
    //   2451: astore_1
    //   2452: iload 10
    //   2454: istore 8
    //   2456: aload_0
    //   2457: astore 28
    //   2459: aload_0
    //   2460: astore 29
    //   2462: aload_0
    //   2463: astore 30
    //   2465: aload_0
    //   2466: astore 31
    //   2468: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2471: ifeq +51 -> 2522
    //   2474: aload_0
    //   2475: astore 27
    //   2477: aload_0
    //   2478: astore_1
    //   2479: iload 10
    //   2481: istore 8
    //   2483: aload_0
    //   2484: astore 28
    //   2486: aload_0
    //   2487: astore 29
    //   2489: aload_0
    //   2490: astore 30
    //   2492: aload_0
    //   2493: astore 31
    //   2495: ldc 43
    //   2497: iconst_4
    //   2498: new 45	java/lang/StringBuilder
    //   2501: dup
    //   2502: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2505: ldc_w 442
    //   2508: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2511: aload 32
    //   2513: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2516: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2519: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2522: aload_0
    //   2523: astore 27
    //   2525: aload_0
    //   2526: astore_1
    //   2527: iload 10
    //   2529: istore 8
    //   2531: aload_0
    //   2532: astore 28
    //   2534: aload_0
    //   2535: astore 29
    //   2537: aload_0
    //   2538: astore 30
    //   2540: aload_0
    //   2541: astore 31
    //   2543: aload_0
    //   2544: invokevirtual 336	java/io/InputStream:close	()V
    //   2547: aload 32
    //   2549: ifnull +1647 -> 4196
    //   2552: aload 32
    //   2554: invokevirtual 151	android/graphics/Bitmap:getWidth	()I
    //   2557: istore 6
    //   2559: aload 32
    //   2561: invokevirtual 154	android/graphics/Bitmap:getHeight	()I
    //   2564: istore 8
    //   2566: iload 6
    //   2568: iload 8
    //   2570: imul
    //   2571: newarray int
    //   2573: astore_0
    //   2574: aload 32
    //   2576: aload_0
    //   2577: iconst_0
    //   2578: iload 6
    //   2580: iconst_0
    //   2581: iconst_0
    //   2582: iload 6
    //   2584: iload 8
    //   2586: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2589: aload 32
    //   2591: invokevirtual 331	android/graphics/Bitmap:recycle	()V
    //   2594: aload_0
    //   2595: aconst_null
    //   2596: iload 6
    //   2598: iload 8
    //   2600: invokestatic 416	xwb:a	([I[BII)I
    //   2603: istore 6
    //   2605: iload 6
    //   2607: istore 7
    //   2609: iload 7
    //   2611: istore 6
    //   2613: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2616: ifeq +34 -> 2650
    //   2619: ldc 43
    //   2621: iconst_4
    //   2622: new 45	java/lang/StringBuilder
    //   2625: dup
    //   2626: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2629: ldc_w 444
    //   2632: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2635: iload 7
    //   2637: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2640: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2643: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2646: iload 7
    //   2648: istore 6
    //   2650: iconst_1
    //   2651: istore 8
    //   2653: aconst_null
    //   2654: astore_0
    //   2655: iload 6
    //   2657: istore 7
    //   2659: iload 8
    //   2661: istore 6
    //   2663: goto -2083 -> 580
    //   2666: aload 37
    //   2668: astore 27
    //   2670: aload 36
    //   2672: astore_1
    //   2673: iload 10
    //   2675: istore 8
    //   2677: aload 33
    //   2679: astore 28
    //   2681: aload 34
    //   2683: astore 29
    //   2685: aload 35
    //   2687: astore 30
    //   2689: aload 43
    //   2691: iconst_1
    //   2692: putfield 373	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2695: goto -1144 -> 1551
    //   2698: astore_0
    //   2699: iconst_1
    //   2700: istore 6
    //   2702: aload 27
    //   2704: astore 28
    //   2706: iload 6
    //   2708: istore 8
    //   2710: aload_0
    //   2711: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   2714: aload 27
    //   2716: astore 28
    //   2718: iload 6
    //   2720: istore 8
    //   2722: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2725: ifeq +21 -> 2746
    //   2728: aload 27
    //   2730: astore 28
    //   2732: iload 6
    //   2734: istore 8
    //   2736: ldc 43
    //   2738: iconst_2
    //   2739: aload_0
    //   2740: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   2743: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2746: iload 6
    //   2748: ifeq +7 -> 2755
    //   2751: invokestatic 253	xwb:b	()I
    //   2754: pop
    //   2755: aload 27
    //   2757: ifnull +1426 -> 4183
    //   2760: aload 27
    //   2762: invokevirtual 336	java/io/InputStream:close	()V
    //   2765: aconst_null
    //   2766: astore_0
    //   2767: goto -1976 -> 791
    //   2770: astore_1
    //   2771: iload 7
    //   2773: istore 6
    //   2775: aload 32
    //   2777: astore 31
    //   2779: aload_1
    //   2780: astore 32
    //   2782: aload 31
    //   2784: astore 27
    //   2786: aload 31
    //   2788: astore_1
    //   2789: iload 10
    //   2791: istore 8
    //   2793: aload 31
    //   2795: astore 28
    //   2797: aload 31
    //   2799: astore 29
    //   2801: aload 31
    //   2803: astore 30
    //   2805: aload 32
    //   2807: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2810: aload 31
    //   2812: astore 27
    //   2814: aload 31
    //   2816: astore_1
    //   2817: iload 10
    //   2819: istore 8
    //   2821: aload 31
    //   2823: astore 28
    //   2825: aload 31
    //   2827: astore 29
    //   2829: aload 31
    //   2831: astore 30
    //   2833: aload 31
    //   2835: invokevirtual 336	java/io/InputStream:close	()V
    //   2838: goto -925 -> 1913
    //   2841: aload 31
    //   2843: astore 27
    //   2845: aload 31
    //   2847: astore_1
    //   2848: iload 10
    //   2850: istore 8
    //   2852: aload 31
    //   2854: astore 28
    //   2856: aload 31
    //   2858: astore 29
    //   2860: aload 31
    //   2862: astore 30
    //   2864: aload 33
    //   2866: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2869: aload 31
    //   2871: astore 27
    //   2873: aload 31
    //   2875: astore_1
    //   2876: iload 10
    //   2878: istore 8
    //   2880: aload 31
    //   2882: astore 28
    //   2884: aload 31
    //   2886: astore 29
    //   2888: aload 31
    //   2890: astore 30
    //   2892: aload 31
    //   2894: invokevirtual 336	java/io/InputStream:close	()V
    //   2897: iload 6
    //   2899: istore 7
    //   2901: goto -624 -> 2277
    //   2904: iload 6
    //   2906: istore 7
    //   2908: iload 14
    //   2910: iload 16
    //   2912: iconst_2
    //   2913: imul
    //   2914: if_icmplt -637 -> 2277
    //   2917: iload 6
    //   2919: istore 7
    //   2921: iload 16
    //   2923: sipush 1280
    //   2926: if_icmpge -649 -> 2277
    //   2929: aload 31
    //   2931: astore 32
    //   2933: iload 10
    //   2935: istore 8
    //   2937: aload 42
    //   2939: aload_0
    //   2940: invokevirtual 308	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2943: astore 31
    //   2945: aload 31
    //   2947: astore 27
    //   2949: aload 31
    //   2951: astore 32
    //   2953: aload 31
    //   2955: astore_1
    //   2956: iload 10
    //   2958: istore 8
    //   2960: aload 31
    //   2962: astore 28
    //   2964: aload 31
    //   2966: astore 29
    //   2968: aload 31
    //   2970: astore 30
    //   2972: aload 31
    //   2974: invokestatic 378	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2977: astore 33
    //   2979: aload 31
    //   2981: astore 27
    //   2983: aload 31
    //   2985: astore 32
    //   2987: aload 31
    //   2989: astore_1
    //   2990: iload 10
    //   2992: istore 8
    //   2994: aload 31
    //   2996: astore 28
    //   2998: aload 31
    //   3000: astore 29
    //   3002: aload 31
    //   3004: astore 30
    //   3006: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3009: ifeq +57 -> 3066
    //   3012: aload 31
    //   3014: astore 27
    //   3016: aload 31
    //   3018: astore 32
    //   3020: aload 31
    //   3022: astore_1
    //   3023: iload 10
    //   3025: istore 8
    //   3027: aload 31
    //   3029: astore 28
    //   3031: aload 31
    //   3033: astore 29
    //   3035: aload 31
    //   3037: astore 30
    //   3039: ldc 43
    //   3041: iconst_4
    //   3042: new 45	java/lang/StringBuilder
    //   3045: dup
    //   3046: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3049: ldc_w 446
    //   3052: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3055: aload 33
    //   3057: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3060: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3063: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3066: aload 31
    //   3068: astore 27
    //   3070: aload 31
    //   3072: astore 32
    //   3074: aload 31
    //   3076: astore_1
    //   3077: iload 10
    //   3079: istore 8
    //   3081: aload 31
    //   3083: astore 28
    //   3085: aload 31
    //   3087: astore 29
    //   3089: aload 31
    //   3091: astore 30
    //   3093: aload 31
    //   3095: invokevirtual 336	java/io/InputStream:close	()V
    //   3098: iload 6
    //   3100: istore 8
    //   3102: aload 33
    //   3104: ifnull +172 -> 3276
    //   3107: iload 6
    //   3109: istore 7
    //   3111: iload 16
    //   3113: iload 16
    //   3115: imul
    //   3116: newarray int
    //   3118: astore 27
    //   3120: iload 6
    //   3122: istore 7
    //   3124: aload 33
    //   3126: aload 27
    //   3128: iconst_0
    //   3129: iload 16
    //   3131: iconst_0
    //   3132: iconst_0
    //   3133: iload 16
    //   3135: iload 16
    //   3137: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3140: iload 6
    //   3142: istore 7
    //   3144: iload 16
    //   3146: iload 16
    //   3148: imul
    //   3149: newarray byte
    //   3151: astore_1
    //   3152: iload 6
    //   3154: istore 7
    //   3156: aload 27
    //   3158: aload_1
    //   3159: iload 16
    //   3161: iload 16
    //   3163: invokestatic 416	xwb:a	([I[BII)I
    //   3166: istore 8
    //   3168: iload 8
    //   3170: istore 6
    //   3172: iload 8
    //   3174: iconst_1
    //   3175: if_icmpeq +43 -> 3218
    //   3178: iload 8
    //   3180: istore 7
    //   3182: aload 33
    //   3184: aload 27
    //   3186: iconst_0
    //   3187: iload 16
    //   3189: iload 14
    //   3191: iload 16
    //   3193: isub
    //   3194: iconst_0
    //   3195: iload 16
    //   3197: iload 16
    //   3199: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3202: iload 8
    //   3204: istore 7
    //   3206: aload 27
    //   3208: aload_1
    //   3209: iload 16
    //   3211: iload 16
    //   3213: invokestatic 416	xwb:a	([I[BII)I
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
    //   3280: goto -1003 -> 2277
    //   3283: astore_1
    //   3284: aload 32
    //   3286: astore 31
    //   3288: aload_1
    //   3289: astore 32
    //   3291: aload 31
    //   3293: astore 27
    //   3295: aload 31
    //   3297: astore_1
    //   3298: iload 10
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
    //   3326: iload 10
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
    //   3351: goto -1074 -> 2277
    //   3354: aload_0
    //   3355: astore 27
    //   3357: aload_0
    //   3358: astore_1
    //   3359: iload 10
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
    //   3382: iload 10
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
    //   3404: goto -2824 -> 580
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 6
    //   3412: istore 12
    //   3414: aload_0
    //   3415: astore 31
    //   3417: iload 6
    //   3419: istore 10
    //   3421: aload_0
    //   3422: astore 29
    //   3424: iload 6
    //   3426: istore 11
    //   3428: aload_0
    //   3429: astore 30
    //   3431: iload 6
    //   3433: istore 9
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
    //   3455: goto -2687 -> 768
    //   3458: astore_0
    //   3459: iload 12
    //   3461: istore 6
    //   3463: goto -761 -> 2702
    //   3466: astore 27
    //   3468: aload 27
    //   3470: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3473: aload_1
    //   3474: astore_0
    //   3475: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3478: ifeq -2687 -> 791
    //   3481: ldc 43
    //   3483: iconst_2
    //   3484: aload 27
    //   3486: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3489: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3492: aload_1
    //   3493: astore_0
    //   3494: goto -2703 -> 791
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
    //   3520: goto -2729 -> 791
    //   3523: astore_0
    //   3524: iload 10
    //   3526: istore 6
    //   3528: aload 31
    //   3530: astore 30
    //   3532: aload 30
    //   3534: astore_1
    //   3535: iload 6
    //   3537: istore 8
    //   3539: aload_0
    //   3540: invokevirtual 264	java/lang/RuntimeException:printStackTrace	()V
    //   3543: aload 30
    //   3545: astore_1
    //   3546: iload 6
    //   3548: istore 8
    //   3550: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3553: ifeq +20 -> 3573
    //   3556: aload 30
    //   3558: astore_1
    //   3559: iload 6
    //   3561: istore 8
    //   3563: ldc 43
    //   3565: iconst_2
    //   3566: aload_0
    //   3567: invokevirtual 265	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3570: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3573: iload 6
    //   3575: ifeq +7 -> 3582
    //   3578: invokestatic 253	xwb:b	()I
    //   3581: pop
    //   3582: aload 30
    //   3584: ifnull +599 -> 4183
    //   3587: aload 30
    //   3589: invokevirtual 336	java/io/InputStream:close	()V
    //   3592: aconst_null
    //   3593: astore_0
    //   3594: goto -2803 -> 791
    //   3597: astore_0
    //   3598: aload_0
    //   3599: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   3602: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3605: ifeq +13 -> 3618
    //   3608: ldc 43
    //   3610: iconst_2
    //   3611: aload_0
    //   3612: invokevirtual 365	java/io/IOException:toString	()Ljava/lang/String;
    //   3615: invokestatic 268	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3618: aconst_null
    //   3619: astore_0
    //   3620: goto -2829 -> 791
    //   3623: astore_0
    //   3624: iload 11
    //   3626: istore 6
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
    //   3674: invokestatic 253	xwb:b	()I
    //   3677: pop
    //   3678: aload 29
    //   3680: ifnull +503 -> 4183
    //   3683: aload 29
    //   3685: invokevirtual 336	java/io/InputStream:close	()V
    //   3688: aconst_null
    //   3689: astore_0
    //   3690: goto -2899 -> 791
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
    //   3716: goto -2925 -> 791
    //   3719: astore_0
    //   3720: iload 9
    //   3722: istore 6
    //   3724: aload 30
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
    //   3774: invokestatic 253	xwb:b	()I
    //   3777: pop
    //   3778: aload 28
    //   3780: ifnull +403 -> 4183
    //   3783: aload 28
    //   3785: invokevirtual 336	java/io/InputStream:close	()V
    //   3788: aconst_null
    //   3789: astore_0
    //   3790: goto -2999 -> 791
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
    //   3816: goto -3025 -> 791
    //   3819: astore_0
    //   3820: aload 28
    //   3822: astore_1
    //   3823: iload 8
    //   3825: ifeq +7 -> 3832
    //   3828: invokestatic 253	xwb:b	()I
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
    //   3867: goto -44 -> 3823
    //   3870: astore_0
    //   3871: iconst_1
    //   3872: istore 8
    //   3874: goto -51 -> 3823
    //   3877: astore_0
    //   3878: goto -55 -> 3823
    //   3881: astore_0
    //   3882: aconst_null
    //   3883: astore_1
    //   3884: iload 13
    //   3886: istore 8
    //   3888: goto -65 -> 3823
    //   3891: astore_0
    //   3892: aconst_null
    //   3893: astore_1
    //   3894: iload 13
    //   3896: istore 8
    //   3898: goto -75 -> 3823
    //   3901: astore_0
    //   3902: iload 12
    //   3904: istore 6
    //   3906: aload_1
    //   3907: astore 28
    //   3909: goto -181 -> 3728
    //   3912: astore_0
    //   3913: iload 12
    //   3915: istore 6
    //   3917: goto -189 -> 3728
    //   3920: astore_0
    //   3921: aconst_null
    //   3922: astore 28
    //   3924: iload 12
    //   3926: istore 6
    //   3928: goto -200 -> 3728
    //   3931: astore_0
    //   3932: aconst_null
    //   3933: astore 28
    //   3935: iload 12
    //   3937: istore 6
    //   3939: goto -211 -> 3728
    //   3942: astore_0
    //   3943: iload 10
    //   3945: istore 6
    //   3947: aload_1
    //   3948: astore 29
    //   3950: goto -322 -> 3628
    //   3953: astore_0
    //   3954: iconst_1
    //   3955: istore 6
    //   3957: aload_1
    //   3958: astore 29
    //   3960: goto -332 -> 3628
    //   3963: astore_0
    //   3964: iload 11
    //   3966: istore 6
    //   3968: goto -340 -> 3628
    //   3971: astore_0
    //   3972: aconst_null
    //   3973: astore 29
    //   3975: iload 11
    //   3977: istore 6
    //   3979: goto -351 -> 3628
    //   3982: astore_0
    //   3983: aconst_null
    //   3984: astore 29
    //   3986: iload 11
    //   3988: istore 6
    //   3990: goto -362 -> 3628
    //   3993: astore_0
    //   3994: iload 11
    //   3996: istore 6
    //   3998: aload_1
    //   3999: astore 30
    //   4001: goto -469 -> 3532
    //   4004: astore_0
    //   4005: iconst_1
    //   4006: istore 6
    //   4008: aload_1
    //   4009: astore 30
    //   4011: goto -479 -> 3532
    //   4014: astore_0
    //   4015: iload 9
    //   4017: istore 6
    //   4019: goto -487 -> 3532
    //   4022: astore_0
    //   4023: aconst_null
    //   4024: astore 30
    //   4026: iload 9
    //   4028: istore 6
    //   4030: goto -498 -> 3532
    //   4033: astore_0
    //   4034: aconst_null
    //   4035: astore 30
    //   4037: iload 9
    //   4039: istore 6
    //   4041: goto -509 -> 3532
    //   4044: astore_0
    //   4045: aload_1
    //   4046: astore 27
    //   4048: iload 9
    //   4050: istore 6
    //   4052: goto -1350 -> 2702
    //   4055: astore_0
    //   4056: iconst_1
    //   4057: istore 6
    //   4059: aload_1
    //   4060: astore 27
    //   4062: goto -1360 -> 2702
    //   4065: astore_0
    //   4066: aconst_null
    //   4067: astore 27
    //   4069: iconst_1
    //   4070: istore 6
    //   4072: goto -1370 -> 2702
    //   4075: astore_0
    //   4076: iconst_1
    //   4077: istore 6
    //   4079: aconst_null
    //   4080: astore 27
    //   4082: goto -1380 -> 2702
    //   4085: astore 32
    //   4087: aconst_null
    //   4088: astore_0
    //   4089: goto -735 -> 3354
    //   4092: astore 32
    //   4094: aconst_null
    //   4095: astore_0
    //   4096: goto -742 -> 3354
    //   4099: astore 32
    //   4101: aconst_null
    //   4102: astore 31
    //   4104: iload 7
    //   4106: istore 6
    //   4108: goto -817 -> 3291
    //   4111: astore 33
    //   4113: aconst_null
    //   4114: astore 31
    //   4116: iload 7
    //   4118: istore 6
    //   4120: goto -1279 -> 2841
    //   4123: astore 33
    //   4125: aconst_null
    //   4126: astore 31
    //   4128: goto -1287 -> 2841
    //   4131: astore 32
    //   4133: aconst_null
    //   4134: astore 31
    //   4136: goto -1354 -> 2782
    //   4139: astore_0
    //   4140: iconst_1
    //   4141: istore 6
    //   4143: goto -3222 -> 921
    //   4146: astore_0
    //   4147: iconst_1
    //   4148: istore 8
    //   4150: iload 6
    //   4152: istore 7
    //   4154: iload 8
    //   4156: istore 6
    //   4158: goto -3237 -> 921
    //   4161: astore_0
    //   4162: iconst_1
    //   4163: istore 6
    //   4165: goto -3327 -> 838
    //   4168: astore_0
    //   4169: iconst_1
    //   4170: istore 8
    //   4172: iload 6
    //   4174: istore 7
    //   4176: iload 8
    //   4178: istore 6
    //   4180: goto -3342 -> 838
    //   4183: aconst_null
    //   4184: astore_0
    //   4185: goto -3394 -> 791
    //   4188: aconst_null
    //   4189: astore_1
    //   4190: aload_0
    //   4191: astore 27
    //   4193: goto -3425 -> 768
    //   4196: iload 7
    //   4198: istore 6
    //   4200: goto -1550 -> 2650
    //   4203: iconst_1
    //   4204: istore 6
    //   4206: aload 33
    //   4208: astore_0
    //   4209: goto -3629 -> 580
    //   4212: goto -1977 -> 2235
    //   4215: goto -1942 -> 2273
    //   4218: iconst_0
    //   4219: istore 8
    //   4221: iconst_m1
    //   4222: istore 7
    //   4224: goto -3650 -> 574
    //   4227: aload_1
    //   4228: astore 27
    //   4230: aconst_null
    //   4231: astore_1
    //   4232: iload 24
    //   4234: istore 6
    //   4236: goto -3468 -> 768
    //   4239: aload_1
    //   4240: astore_0
    //   4241: goto -3661 -> 580
    //   4244: astore_0
    //   4245: iload 22
    //   4247: istore 6
    //   4249: goto -3328 -> 921
    //   4252: aload_1
    //   4253: astore_0
    //   4254: goto -3674 -> 580
    //   4257: astore 33
    //   4259: aload 32
    //   4261: astore 31
    //   4263: goto -1422 -> 2841
    //   4266: astore 32
    //   4268: aload 31
    //   4270: astore_0
    //   4271: goto -917 -> 3354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4274	0	paramUri	Uri
    //   0	4274	1	paramContext	Context
    //   0	4274	2	paramBoolean1	boolean
    //   0	4274	3	paramBoolean2	boolean
    //   1508	28	4	d	double
    //   88	4160	6	i	int
    //   20	4203	7	j	int
    //   146	4074	8	k	int
    //   138	3911	9	m	int
    //   122	3822	10	n	int
    //   130	3865	11	i1	int
    //   114	3822	12	i2	int
    //   85	3810	13	i3	int
    //   103	3091	14	i4	int
    //   76	1776	15	i5	int
    //   91	3121	16	i6	int
    //   97	999	17	i7	int
    //   100	1000	18	i8	int
    //   82	1372	19	i9	int
    //   79	1367	20	i10	int
    //   70	765	21	i11	int
    //   73	4173	22	i12	int
    //   94	998	23	i13	int
    //   106	4127	24	i14	int
    //   17	803	25	l	long
    //   9	3445	27	localObject1	Object
    //   3466	19	27	localIOException	java.io.IOException
    //   4046	183	27	localObject2	Object
    //   142	3792	28	localObject3	Object
    //   126	3859	29	localObject4	Object
    //   134	3902	30	localObject5	Object
    //   118	4151	31	localObject6	Object
    //   61	3312	32	localObject7	Object
    //   4085	1	32	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   4092	1	32	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4099	1	32	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4131	129	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4266	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   55	3168	33	localBitmap	Bitmap
    //   4111	1	33	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4123	84	33	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4257	1	33	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   64	2618	34	localObject8	Object
    //   67	2619	35	localObject9	Object
    //   58	2613	36	localObject10	Object
    //   1141	1526	37	localObject11	Object
    //   1115	319	38	localObject12	Object
    //   1126	339	39	localObject13	Object
    //   1118	324	40	localObject14	Object
    //   1121	329	41	localObject15	Object
    //   152	2786	42	localContentResolver	android.content.ContentResolver
    //   1031	1659	43	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   382	386	388	java/io/IOException
    //   225	233	833	java/lang/OutOfMemoryError
    //   249	255	833	java/lang/OutOfMemoryError
    //   271	297	833	java/lang/OutOfMemoryError
    //   317	323	833	java/lang/OutOfMemoryError
    //   339	345	833	java/lang/OutOfMemoryError
    //   361	369	833	java/lang/OutOfMemoryError
    //   430	439	833	java/lang/OutOfMemoryError
    //   455	470	833	java/lang/OutOfMemoryError
    //   486	490	833	java/lang/OutOfMemoryError
    //   506	510	833	java/lang/OutOfMemoryError
    //   1305	1313	1313	java/io/IOException
    //   1399	1407	1407	java/io/IOException
    //   1533	1551	2698	java/io/IOException
    //   1574	1582	2698	java/io/IOException
    //   1609	1619	2698	java/io/IOException
    //   1646	1652	2698	java/io/IOException
    //   1679	1742	2698	java/io/IOException
    //   1769	1774	2698	java/io/IOException
    //   1964	1972	2698	java/io/IOException
    //   1999	2006	2698	java/io/IOException
    //   2033	2039	2698	java/io/IOException
    //   2066	2093	2698	java/io/IOException
    //   2120	2125	2698	java/io/IOException
    //   2327	2336	2698	java/io/IOException
    //   2367	2383	2698	java/io/IOException
    //   2410	2417	2698	java/io/IOException
    //   2438	2447	2698	java/io/IOException
    //   2468	2474	2698	java/io/IOException
    //   2495	2522	2698	java/io/IOException
    //   2543	2547	2698	java/io/IOException
    //   2689	2695	2698	java/io/IOException
    //   2805	2810	2698	java/io/IOException
    //   2833	2838	2698	java/io/IOException
    //   2864	2869	2698	java/io/IOException
    //   2892	2897	2698	java/io/IOException
    //   2937	2945	2698	java/io/IOException
    //   2972	2979	2698	java/io/IOException
    //   3006	3012	2698	java/io/IOException
    //   3039	3066	2698	java/io/IOException
    //   3093	3098	2698	java/io/IOException
    //   3314	3319	2698	java/io/IOException
    //   3342	3347	2698	java/io/IOException
    //   3372	3377	2698	java/io/IOException
    //   3395	3399	2698	java/io/IOException
    //   1574	1582	2770	java/lang/OutOfMemoryError
    //   1609	1619	2770	java/lang/OutOfMemoryError
    //   1646	1652	2770	java/lang/OutOfMemoryError
    //   1679	1742	2770	java/lang/OutOfMemoryError
    //   1769	1774	2770	java/lang/OutOfMemoryError
    //   2937	2945	3283	java/lang/OutOfMemoryError
    //   2972	2979	3283	java/lang/OutOfMemoryError
    //   3006	3012	3283	java/lang/OutOfMemoryError
    //   3039	3066	3283	java/lang/OutOfMemoryError
    //   3093	3098	3283	java/lang/OutOfMemoryError
    //   148	154	3458	java/io/IOException
    //   194	201	3458	java/io/IOException
    //   625	633	3458	java/io/IOException
    //   668	677	3458	java/io/IOException
    //   712	719	3458	java/io/IOException
    //   754	765	3458	java/io/IOException
    //   1182	1189	3458	java/io/IOException
    //   1228	1235	3458	java/io/IOException
    //   1274	1280	3458	java/io/IOException
    //   1378	1386	3458	java/io/IOException
    //   1472	1476	3458	java/io/IOException
    //   3442	3452	3458	java/io/IOException
    //   784	789	3466	java/io/IOException
    //   2760	2765	3497	java/io/IOException
    //   148	154	3523	java/lang/RuntimeException
    //   194	201	3523	java/lang/RuntimeException
    //   625	633	3523	java/lang/RuntimeException
    //   668	677	3523	java/lang/RuntimeException
    //   712	719	3523	java/lang/RuntimeException
    //   754	765	3523	java/lang/RuntimeException
    //   1182	1189	3523	java/lang/RuntimeException
    //   1228	1235	3523	java/lang/RuntimeException
    //   1274	1280	3523	java/lang/RuntimeException
    //   1378	1386	3523	java/lang/RuntimeException
    //   1472	1476	3523	java/lang/RuntimeException
    //   3442	3452	3523	java/lang/RuntimeException
    //   3587	3592	3597	java/io/IOException
    //   148	154	3623	java/lang/UnsatisfiedLinkError
    //   194	201	3623	java/lang/UnsatisfiedLinkError
    //   625	633	3623	java/lang/UnsatisfiedLinkError
    //   668	677	3623	java/lang/UnsatisfiedLinkError
    //   712	719	3623	java/lang/UnsatisfiedLinkError
    //   754	765	3623	java/lang/UnsatisfiedLinkError
    //   1182	1189	3623	java/lang/UnsatisfiedLinkError
    //   1228	1235	3623	java/lang/UnsatisfiedLinkError
    //   1274	1280	3623	java/lang/UnsatisfiedLinkError
    //   1378	1386	3623	java/lang/UnsatisfiedLinkError
    //   1472	1476	3623	java/lang/UnsatisfiedLinkError
    //   3442	3452	3623	java/lang/UnsatisfiedLinkError
    //   3683	3688	3693	java/io/IOException
    //   148	154	3719	java/lang/Throwable
    //   194	201	3719	java/lang/Throwable
    //   625	633	3719	java/lang/Throwable
    //   668	677	3719	java/lang/Throwable
    //   712	719	3719	java/lang/Throwable
    //   754	765	3719	java/lang/Throwable
    //   1182	1189	3719	java/lang/Throwable
    //   1228	1235	3719	java/lang/Throwable
    //   1274	1280	3719	java/lang/Throwable
    //   1378	1386	3719	java/lang/Throwable
    //   1472	1476	3719	java/lang/Throwable
    //   3442	3452	3719	java/lang/Throwable
    //   3783	3788	3793	java/io/IOException
    //   148	154	3819	finally
    //   194	201	3819	finally
    //   625	633	3819	finally
    //   668	677	3819	finally
    //   712	719	3819	finally
    //   754	765	3819	finally
    //   1182	1189	3819	finally
    //   1228	1235	3819	finally
    //   1274	1280	3819	finally
    //   1378	1386	3819	finally
    //   1472	1476	3819	finally
    //   2710	2714	3819	finally
    //   2722	2728	3819	finally
    //   2736	2746	3819	finally
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
    //   858	862	3866	finally
    //   882	888	3866	finally
    //   908	918	3866	finally
    //   941	945	3866	finally
    //   965	971	3866	finally
    //   991	1001	3866	finally
    //   1024	1033	3866	finally
    //   1053	1059	3866	finally
    //   1079	1087	3866	finally
    //   1107	1111	3866	finally
    //   513	525	3870	finally
    //   533	566	3870	finally
    //   1533	1551	3877	finally
    //   1574	1582	3877	finally
    //   1609	1619	3877	finally
    //   1646	1652	3877	finally
    //   1679	1742	3877	finally
    //   1769	1774	3877	finally
    //   1964	1972	3877	finally
    //   1999	2006	3877	finally
    //   2033	2039	3877	finally
    //   2066	2093	3877	finally
    //   2120	2125	3877	finally
    //   2327	2336	3877	finally
    //   2367	2383	3877	finally
    //   2410	2417	3877	finally
    //   2438	2447	3877	finally
    //   2468	2474	3877	finally
    //   2495	2522	3877	finally
    //   2543	2547	3877	finally
    //   2689	2695	3877	finally
    //   2805	2810	3877	finally
    //   2833	2838	3877	finally
    //   2864	2869	3877	finally
    //   2892	2897	3877	finally
    //   2937	2945	3877	finally
    //   2972	2979	3877	finally
    //   3006	3012	3877	finally
    //   3039	3066	3877	finally
    //   3093	3098	3877	finally
    //   3314	3319	3877	finally
    //   3342	3347	3877	finally
    //   3372	3377	3877	finally
    //   3395	3399	3877	finally
    //   3539	3543	3877	finally
    //   3550	3556	3877	finally
    //   3563	3573	3877	finally
    //   3635	3639	3877	finally
    //   3646	3652	3877	finally
    //   3659	3669	3877	finally
    //   3735	3739	3877	finally
    //   3746	3752	3877	finally
    //   3759	3769	3877	finally
    //   1787	1794	3881	finally
    //   1798	1805	3881	finally
    //   1809	1817	3881	finally
    //   1821	1836	3881	finally
    //   1840	1845	3881	finally
    //   1849	1860	3881	finally
    //   1868	1874	3881	finally
    //   1878	1905	3881	finally
    //   2134	2142	3891	finally
    //   2146	2161	3891	finally
    //   2165	2174	3891	finally
    //   2178	2190	3891	finally
    //   2200	2219	3891	finally
    //   2223	2235	3891	finally
    //   2235	2273	3891	finally
    //   2552	2605	3891	finally
    //   2613	2646	3891	finally
    //   3111	3120	3891	finally
    //   3124	3140	3891	finally
    //   3144	3152	3891	finally
    //   3156	3168	3891	finally
    //   3182	3202	3891	finally
    //   3206	3218	3891	finally
    //   3222	3227	3891	finally
    //   3235	3241	3891	finally
    //   3245	3272	3891	finally
    //   858	862	3901	java/lang/Throwable
    //   882	888	3901	java/lang/Throwable
    //   908	918	3901	java/lang/Throwable
    //   941	945	3901	java/lang/Throwable
    //   965	971	3901	java/lang/Throwable
    //   991	1001	3901	java/lang/Throwable
    //   1024	1033	3901	java/lang/Throwable
    //   1053	1059	3901	java/lang/Throwable
    //   1079	1087	3901	java/lang/Throwable
    //   1107	1111	3901	java/lang/Throwable
    //   1533	1551	3912	java/lang/Throwable
    //   1574	1582	3912	java/lang/Throwable
    //   1609	1619	3912	java/lang/Throwable
    //   1646	1652	3912	java/lang/Throwable
    //   1679	1742	3912	java/lang/Throwable
    //   1769	1774	3912	java/lang/Throwable
    //   1964	1972	3912	java/lang/Throwable
    //   1999	2006	3912	java/lang/Throwable
    //   2033	2039	3912	java/lang/Throwable
    //   2066	2093	3912	java/lang/Throwable
    //   2120	2125	3912	java/lang/Throwable
    //   2327	2336	3912	java/lang/Throwable
    //   2367	2383	3912	java/lang/Throwable
    //   2410	2417	3912	java/lang/Throwable
    //   2438	2447	3912	java/lang/Throwable
    //   2468	2474	3912	java/lang/Throwable
    //   2495	2522	3912	java/lang/Throwable
    //   2543	2547	3912	java/lang/Throwable
    //   2689	2695	3912	java/lang/Throwable
    //   2805	2810	3912	java/lang/Throwable
    //   2833	2838	3912	java/lang/Throwable
    //   2864	2869	3912	java/lang/Throwable
    //   2892	2897	3912	java/lang/Throwable
    //   2937	2945	3912	java/lang/Throwable
    //   2972	2979	3912	java/lang/Throwable
    //   3006	3012	3912	java/lang/Throwable
    //   3039	3066	3912	java/lang/Throwable
    //   3093	3098	3912	java/lang/Throwable
    //   3314	3319	3912	java/lang/Throwable
    //   3342	3347	3912	java/lang/Throwable
    //   3372	3377	3912	java/lang/Throwable
    //   3395	3399	3912	java/lang/Throwable
    //   1787	1794	3920	java/lang/Throwable
    //   1798	1805	3920	java/lang/Throwable
    //   1809	1817	3920	java/lang/Throwable
    //   1821	1836	3920	java/lang/Throwable
    //   1840	1845	3920	java/lang/Throwable
    //   1849	1860	3920	java/lang/Throwable
    //   1868	1874	3920	java/lang/Throwable
    //   1878	1905	3920	java/lang/Throwable
    //   2134	2142	3931	java/lang/Throwable
    //   2146	2161	3931	java/lang/Throwable
    //   2165	2174	3931	java/lang/Throwable
    //   2178	2190	3931	java/lang/Throwable
    //   2200	2219	3931	java/lang/Throwable
    //   2223	2235	3931	java/lang/Throwable
    //   2235	2273	3931	java/lang/Throwable
    //   2552	2605	3931	java/lang/Throwable
    //   2613	2646	3931	java/lang/Throwable
    //   3111	3120	3931	java/lang/Throwable
    //   3124	3140	3931	java/lang/Throwable
    //   3144	3152	3931	java/lang/Throwable
    //   3156	3168	3931	java/lang/Throwable
    //   3182	3202	3931	java/lang/Throwable
    //   3206	3218	3931	java/lang/Throwable
    //   3222	3227	3931	java/lang/Throwable
    //   3235	3241	3931	java/lang/Throwable
    //   3245	3272	3931	java/lang/Throwable
    //   225	233	3942	java/lang/UnsatisfiedLinkError
    //   249	255	3942	java/lang/UnsatisfiedLinkError
    //   271	297	3942	java/lang/UnsatisfiedLinkError
    //   317	323	3942	java/lang/UnsatisfiedLinkError
    //   339	345	3942	java/lang/UnsatisfiedLinkError
    //   361	369	3942	java/lang/UnsatisfiedLinkError
    //   430	439	3942	java/lang/UnsatisfiedLinkError
    //   455	470	3942	java/lang/UnsatisfiedLinkError
    //   486	490	3942	java/lang/UnsatisfiedLinkError
    //   506	510	3942	java/lang/UnsatisfiedLinkError
    //   858	862	3942	java/lang/UnsatisfiedLinkError
    //   882	888	3942	java/lang/UnsatisfiedLinkError
    //   908	918	3942	java/lang/UnsatisfiedLinkError
    //   941	945	3942	java/lang/UnsatisfiedLinkError
    //   965	971	3942	java/lang/UnsatisfiedLinkError
    //   991	1001	3942	java/lang/UnsatisfiedLinkError
    //   1024	1033	3942	java/lang/UnsatisfiedLinkError
    //   1053	1059	3942	java/lang/UnsatisfiedLinkError
    //   1079	1087	3942	java/lang/UnsatisfiedLinkError
    //   1107	1111	3942	java/lang/UnsatisfiedLinkError
    //   513	525	3953	java/lang/UnsatisfiedLinkError
    //   533	566	3953	java/lang/UnsatisfiedLinkError
    //   1533	1551	3963	java/lang/UnsatisfiedLinkError
    //   1574	1582	3963	java/lang/UnsatisfiedLinkError
    //   1609	1619	3963	java/lang/UnsatisfiedLinkError
    //   1646	1652	3963	java/lang/UnsatisfiedLinkError
    //   1679	1742	3963	java/lang/UnsatisfiedLinkError
    //   1769	1774	3963	java/lang/UnsatisfiedLinkError
    //   1964	1972	3963	java/lang/UnsatisfiedLinkError
    //   1999	2006	3963	java/lang/UnsatisfiedLinkError
    //   2033	2039	3963	java/lang/UnsatisfiedLinkError
    //   2066	2093	3963	java/lang/UnsatisfiedLinkError
    //   2120	2125	3963	java/lang/UnsatisfiedLinkError
    //   2327	2336	3963	java/lang/UnsatisfiedLinkError
    //   2367	2383	3963	java/lang/UnsatisfiedLinkError
    //   2410	2417	3963	java/lang/UnsatisfiedLinkError
    //   2438	2447	3963	java/lang/UnsatisfiedLinkError
    //   2468	2474	3963	java/lang/UnsatisfiedLinkError
    //   2495	2522	3963	java/lang/UnsatisfiedLinkError
    //   2543	2547	3963	java/lang/UnsatisfiedLinkError
    //   2689	2695	3963	java/lang/UnsatisfiedLinkError
    //   2805	2810	3963	java/lang/UnsatisfiedLinkError
    //   2833	2838	3963	java/lang/UnsatisfiedLinkError
    //   2864	2869	3963	java/lang/UnsatisfiedLinkError
    //   2892	2897	3963	java/lang/UnsatisfiedLinkError
    //   2937	2945	3963	java/lang/UnsatisfiedLinkError
    //   2972	2979	3963	java/lang/UnsatisfiedLinkError
    //   3006	3012	3963	java/lang/UnsatisfiedLinkError
    //   3039	3066	3963	java/lang/UnsatisfiedLinkError
    //   3093	3098	3963	java/lang/UnsatisfiedLinkError
    //   3314	3319	3963	java/lang/UnsatisfiedLinkError
    //   3342	3347	3963	java/lang/UnsatisfiedLinkError
    //   3372	3377	3963	java/lang/UnsatisfiedLinkError
    //   3395	3399	3963	java/lang/UnsatisfiedLinkError
    //   1787	1794	3971	java/lang/UnsatisfiedLinkError
    //   1798	1805	3971	java/lang/UnsatisfiedLinkError
    //   1809	1817	3971	java/lang/UnsatisfiedLinkError
    //   1821	1836	3971	java/lang/UnsatisfiedLinkError
    //   1840	1845	3971	java/lang/UnsatisfiedLinkError
    //   1849	1860	3971	java/lang/UnsatisfiedLinkError
    //   1868	1874	3971	java/lang/UnsatisfiedLinkError
    //   1878	1905	3971	java/lang/UnsatisfiedLinkError
    //   2134	2142	3982	java/lang/UnsatisfiedLinkError
    //   2146	2161	3982	java/lang/UnsatisfiedLinkError
    //   2165	2174	3982	java/lang/UnsatisfiedLinkError
    //   2178	2190	3982	java/lang/UnsatisfiedLinkError
    //   2200	2219	3982	java/lang/UnsatisfiedLinkError
    //   2223	2235	3982	java/lang/UnsatisfiedLinkError
    //   2235	2273	3982	java/lang/UnsatisfiedLinkError
    //   2552	2605	3982	java/lang/UnsatisfiedLinkError
    //   2613	2646	3982	java/lang/UnsatisfiedLinkError
    //   3111	3120	3982	java/lang/UnsatisfiedLinkError
    //   3124	3140	3982	java/lang/UnsatisfiedLinkError
    //   3144	3152	3982	java/lang/UnsatisfiedLinkError
    //   3156	3168	3982	java/lang/UnsatisfiedLinkError
    //   3182	3202	3982	java/lang/UnsatisfiedLinkError
    //   3206	3218	3982	java/lang/UnsatisfiedLinkError
    //   3222	3227	3982	java/lang/UnsatisfiedLinkError
    //   3235	3241	3982	java/lang/UnsatisfiedLinkError
    //   3245	3272	3982	java/lang/UnsatisfiedLinkError
    //   225	233	3993	java/lang/RuntimeException
    //   249	255	3993	java/lang/RuntimeException
    //   271	297	3993	java/lang/RuntimeException
    //   317	323	3993	java/lang/RuntimeException
    //   339	345	3993	java/lang/RuntimeException
    //   361	369	3993	java/lang/RuntimeException
    //   430	439	3993	java/lang/RuntimeException
    //   455	470	3993	java/lang/RuntimeException
    //   486	490	3993	java/lang/RuntimeException
    //   506	510	3993	java/lang/RuntimeException
    //   858	862	3993	java/lang/RuntimeException
    //   882	888	3993	java/lang/RuntimeException
    //   908	918	3993	java/lang/RuntimeException
    //   941	945	3993	java/lang/RuntimeException
    //   965	971	3993	java/lang/RuntimeException
    //   991	1001	3993	java/lang/RuntimeException
    //   1024	1033	3993	java/lang/RuntimeException
    //   1053	1059	3993	java/lang/RuntimeException
    //   1079	1087	3993	java/lang/RuntimeException
    //   1107	1111	3993	java/lang/RuntimeException
    //   513	525	4004	java/lang/RuntimeException
    //   533	566	4004	java/lang/RuntimeException
    //   1533	1551	4014	java/lang/RuntimeException
    //   1574	1582	4014	java/lang/RuntimeException
    //   1609	1619	4014	java/lang/RuntimeException
    //   1646	1652	4014	java/lang/RuntimeException
    //   1679	1742	4014	java/lang/RuntimeException
    //   1769	1774	4014	java/lang/RuntimeException
    //   1964	1972	4014	java/lang/RuntimeException
    //   1999	2006	4014	java/lang/RuntimeException
    //   2033	2039	4014	java/lang/RuntimeException
    //   2066	2093	4014	java/lang/RuntimeException
    //   2120	2125	4014	java/lang/RuntimeException
    //   2327	2336	4014	java/lang/RuntimeException
    //   2367	2383	4014	java/lang/RuntimeException
    //   2410	2417	4014	java/lang/RuntimeException
    //   2438	2447	4014	java/lang/RuntimeException
    //   2468	2474	4014	java/lang/RuntimeException
    //   2495	2522	4014	java/lang/RuntimeException
    //   2543	2547	4014	java/lang/RuntimeException
    //   2689	2695	4014	java/lang/RuntimeException
    //   2805	2810	4014	java/lang/RuntimeException
    //   2833	2838	4014	java/lang/RuntimeException
    //   2864	2869	4014	java/lang/RuntimeException
    //   2892	2897	4014	java/lang/RuntimeException
    //   2937	2945	4014	java/lang/RuntimeException
    //   2972	2979	4014	java/lang/RuntimeException
    //   3006	3012	4014	java/lang/RuntimeException
    //   3039	3066	4014	java/lang/RuntimeException
    //   3093	3098	4014	java/lang/RuntimeException
    //   3314	3319	4014	java/lang/RuntimeException
    //   3342	3347	4014	java/lang/RuntimeException
    //   3372	3377	4014	java/lang/RuntimeException
    //   3395	3399	4014	java/lang/RuntimeException
    //   1787	1794	4022	java/lang/RuntimeException
    //   1798	1805	4022	java/lang/RuntimeException
    //   1809	1817	4022	java/lang/RuntimeException
    //   1821	1836	4022	java/lang/RuntimeException
    //   1840	1845	4022	java/lang/RuntimeException
    //   1849	1860	4022	java/lang/RuntimeException
    //   1868	1874	4022	java/lang/RuntimeException
    //   1878	1905	4022	java/lang/RuntimeException
    //   2134	2142	4033	java/lang/RuntimeException
    //   2146	2161	4033	java/lang/RuntimeException
    //   2165	2174	4033	java/lang/RuntimeException
    //   2178	2190	4033	java/lang/RuntimeException
    //   2200	2219	4033	java/lang/RuntimeException
    //   2223	2235	4033	java/lang/RuntimeException
    //   2235	2273	4033	java/lang/RuntimeException
    //   2552	2605	4033	java/lang/RuntimeException
    //   2613	2646	4033	java/lang/RuntimeException
    //   3111	3120	4033	java/lang/RuntimeException
    //   3124	3140	4033	java/lang/RuntimeException
    //   3144	3152	4033	java/lang/RuntimeException
    //   3156	3168	4033	java/lang/RuntimeException
    //   3182	3202	4033	java/lang/RuntimeException
    //   3206	3218	4033	java/lang/RuntimeException
    //   3222	3227	4033	java/lang/RuntimeException
    //   3235	3241	4033	java/lang/RuntimeException
    //   3245	3272	4033	java/lang/RuntimeException
    //   225	233	4044	java/io/IOException
    //   249	255	4044	java/io/IOException
    //   271	297	4044	java/io/IOException
    //   317	323	4044	java/io/IOException
    //   339	345	4044	java/io/IOException
    //   361	369	4044	java/io/IOException
    //   430	439	4044	java/io/IOException
    //   455	470	4044	java/io/IOException
    //   486	490	4044	java/io/IOException
    //   506	510	4044	java/io/IOException
    //   858	862	4044	java/io/IOException
    //   882	888	4044	java/io/IOException
    //   908	918	4044	java/io/IOException
    //   941	945	4044	java/io/IOException
    //   965	971	4044	java/io/IOException
    //   991	1001	4044	java/io/IOException
    //   1024	1033	4044	java/io/IOException
    //   1053	1059	4044	java/io/IOException
    //   1079	1087	4044	java/io/IOException
    //   1107	1111	4044	java/io/IOException
    //   513	525	4055	java/io/IOException
    //   533	566	4055	java/io/IOException
    //   1787	1794	4065	java/io/IOException
    //   1798	1805	4065	java/io/IOException
    //   1809	1817	4065	java/io/IOException
    //   1821	1836	4065	java/io/IOException
    //   1840	1845	4065	java/io/IOException
    //   1849	1860	4065	java/io/IOException
    //   1868	1874	4065	java/io/IOException
    //   1878	1905	4065	java/io/IOException
    //   2134	2142	4075	java/io/IOException
    //   2146	2161	4075	java/io/IOException
    //   2165	2174	4075	java/io/IOException
    //   2178	2190	4075	java/io/IOException
    //   2200	2219	4075	java/io/IOException
    //   2223	2235	4075	java/io/IOException
    //   2235	2273	4075	java/io/IOException
    //   2552	2605	4075	java/io/IOException
    //   2613	2646	4075	java/io/IOException
    //   3111	3120	4075	java/io/IOException
    //   3124	3140	4075	java/io/IOException
    //   3144	3152	4075	java/io/IOException
    //   3156	3168	4075	java/io/IOException
    //   3182	3202	4075	java/io/IOException
    //   3206	3218	4075	java/io/IOException
    //   3222	3227	4075	java/io/IOException
    //   3235	3241	4075	java/io/IOException
    //   3245	3272	4075	java/io/IOException
    //   2552	2605	4085	java/lang/OutOfMemoryError
    //   2613	2646	4092	java/lang/OutOfMemoryError
    //   3111	3120	4099	java/lang/OutOfMemoryError
    //   3124	3140	4099	java/lang/OutOfMemoryError
    //   3144	3152	4099	java/lang/OutOfMemoryError
    //   3156	3168	4099	java/lang/OutOfMemoryError
    //   3182	3202	4099	java/lang/OutOfMemoryError
    //   3206	3218	4099	java/lang/OutOfMemoryError
    //   3222	3227	4099	java/lang/OutOfMemoryError
    //   3235	3241	4099	java/lang/OutOfMemoryError
    //   3245	3272	4099	java/lang/OutOfMemoryError
    //   2134	2142	4111	java/lang/OutOfMemoryError
    //   2146	2161	4111	java/lang/OutOfMemoryError
    //   2165	2174	4111	java/lang/OutOfMemoryError
    //   2178	2190	4111	java/lang/OutOfMemoryError
    //   2200	2219	4111	java/lang/OutOfMemoryError
    //   2223	2235	4111	java/lang/OutOfMemoryError
    //   2235	2273	4123	java/lang/OutOfMemoryError
    //   1787	1794	4131	java/lang/OutOfMemoryError
    //   1798	1805	4131	java/lang/OutOfMemoryError
    //   1809	1817	4131	java/lang/OutOfMemoryError
    //   1821	1836	4131	java/lang/OutOfMemoryError
    //   1840	1845	4131	java/lang/OutOfMemoryError
    //   1849	1860	4131	java/lang/OutOfMemoryError
    //   1868	1874	4131	java/lang/OutOfMemoryError
    //   1878	1905	4131	java/lang/OutOfMemoryError
    //   513	525	4139	java/lang/Throwable
    //   533	566	4146	java/lang/Throwable
    //   513	525	4161	java/lang/OutOfMemoryError
    //   533	566	4168	java/lang/OutOfMemoryError
    //   225	233	4244	java/lang/Throwable
    //   249	255	4244	java/lang/Throwable
    //   271	297	4244	java/lang/Throwable
    //   317	323	4244	java/lang/Throwable
    //   339	345	4244	java/lang/Throwable
    //   361	369	4244	java/lang/Throwable
    //   430	439	4244	java/lang/Throwable
    //   455	470	4244	java/lang/Throwable
    //   486	490	4244	java/lang/Throwable
    //   506	510	4244	java/lang/Throwable
    //   1964	1972	4257	java/lang/OutOfMemoryError
    //   1999	2006	4257	java/lang/OutOfMemoryError
    //   2033	2039	4257	java/lang/OutOfMemoryError
    //   2066	2093	4257	java/lang/OutOfMemoryError
    //   2120	2125	4257	java/lang/OutOfMemoryError
    //   2410	2417	4266	java/lang/OutOfMemoryError
    //   2438	2447	4266	java/lang/OutOfMemoryError
    //   2468	2474	4266	java/lang/OutOfMemoryError
    //   2495	2522	4266	java/lang/OutOfMemoryError
    //   2543	2547	4266	java/lang/OutOfMemoryError
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
                localObject = bdcv.a((byte[])localObject);
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
        paramString1 = bdcb.a();
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
      azmz.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (xxb.g(paramString))
      {
        azmz.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        azmz.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (xxb.i(paramString))
        {
          azmz.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, xwj paramxwj, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new xwd(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramxwj);
    paramAppActivity = new NewIntent(paramAppActivity, xub.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramxwj = paramxwj.a();
    if (paramxwj != null)
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
        if (paramxwj.has(str)) {
          paramAppActivity.putExtra(str, paramxwj.optString(str));
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
    } while (auoo.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bfru.a));
    new auoo().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bfru.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, xwj paramxwj)
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
          bdaz.b(2131230757, false);
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
          bdaz.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramxwj);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramxwj);
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
          bdaz.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        xuc.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
          paramString1 = bdcd.a(paramAppActivity, 230);
          paramString1.setMessage(2131719391);
          paramString2 = new xwc(paramxwj);
          paramString1.setPositiveButton(2131694951, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bdaz.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!xxb.a(str)))
        {
          if (bfcf.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            bfcf.a().a(paramQQAppInterface, paramString1, paramView);
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
          aabm.a().a(1);
          aabm.a().jdField_a_of_type_JavaLangString = "";
          aabm.a().jdField_a_of_type_Int = 0;
          aabm.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramxwj, paramString1)) {
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
        else if (xxb.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (xxb.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (xxb.f(str))
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
          if (xxb.h(str))
          {
            if (xxb.b(str))
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
            if (bdka.a(paramString1))
            {
              bdka.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramxwj, paramView);
              i = 1;
            }
          }
          else
          {
            xuc.a(paramQQAppInterface, paramAppActivity, paramString1);
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
      int i = bfru.a();
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
 * Qualified Name:     xwb
 * JD-Core Version:    0.7.0.1
 */