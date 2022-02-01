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

public class zxx
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
      int k = bked.a(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bked.a((int[])localObject, localObject.length);
      localObject = bked.a();
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
    if ((RecogUtil.getSupportDetectType() >= 0) && (apqo.b()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = apqo.a().a(paramBitmap, l, localRect);
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
    //   1: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
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
    //   39: ldc 158
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 4
    //   49: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: iload 7
    //   57: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: aload 10
    //   70: iconst_0
    //   71: iload 4
    //   73: iconst_0
    //   74: iconst_0
    //   75: iload 4
    //   77: iload 7
    //   79: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   82: aload 10
    //   84: aload 11
    //   86: iload 4
    //   88: iload 7
    //   90: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   93: pop
    //   94: aload 10
    //   96: aload 11
    //   98: iload 4
    //   100: iload 7
    //   102: iload_1
    //   103: aload_2
    //   104: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   107: istore_3
    //   108: iconst_0
    //   109: iload_3
    //   110: ior
    //   111: istore_3
    //   112: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +222 -> 337
    //   118: ldc 43
    //   120: iconst_4
    //   121: ldc 178
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_1
    //   130: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_3
    //   137: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: aload_2
    //   144: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto +183 -> 337
    //   157: invokestatic 81	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 86	apqo:b	()Z
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
    //   187: invokestatic 180	zxx:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 185	apra:a	(ZZ)V
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
    //   274: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -36 -> 241
    //   280: ldc 43
    //   282: iconst_2
    //   283: aload_0
    //   284: invokevirtual 188	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   287: aload_0
    //   288: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: iload_3
    //   292: ireturn
    //   293: astore_0
    //   294: iconst_0
    //   295: istore_3
    //   296: iload_3
    //   297: istore 4
    //   299: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -61 -> 241
    //   305: ldc 43
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 191	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   312: aload_0
    //   313: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
          if (!bked.a(paramBitmap.getWidth(), paramBitmap.getHeight())) {
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
            apqo.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(apqo.a()), Long.valueOf(l2) }));
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
      bked.a(paramBitmap, localStringBuilder2);
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
        apqo.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   14: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   17: lstore 32
    //   19: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   22: ifeq +30 -> 52
    //   25: ldc_w 292
    //   28: iconst_4
    //   29: new 45	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 294
    //   39: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 297	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
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
    //   77: astore 40
    //   79: aconst_null
    //   80: astore 41
    //   82: aconst_null
    //   83: astore 34
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
    //   115: ldc2_w 298
    //   118: lstore 30
    //   120: aload 39
    //   122: astore 38
    //   124: aload 40
    //   126: astore 37
    //   128: aload 41
    //   130: astore 36
    //   132: aload 34
    //   134: astore 35
    //   136: aload_1
    //   137: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 39
    //   144: astore 38
    //   146: aload 40
    //   148: astore 37
    //   150: aload 41
    //   152: astore 36
    //   154: aload 34
    //   156: astore 35
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5796 -> 5964
    //   171: aload 34
    //   173: astore 38
    //   175: aload 34
    //   177: astore 37
    //   179: aload 34
    //   181: astore 36
    //   183: aload 34
    //   185: astore 35
    //   187: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   190: lstore 28
    //   192: iload 4
    //   194: iconst_2
    //   195: iand
    //   196: iconst_2
    //   197: if_icmpne +126 -> 323
    //   200: iload 22
    //   202: istore 7
    //   204: invokestatic 98	apqo:a	()Lapqo;
    //   207: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   210: lload 28
    //   212: ldc_w 292
    //   215: invokevirtual 214	apqo:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   218: iconst_1
    //   219: istore 22
    //   221: iconst_1
    //   222: istore 24
    //   224: iconst_1
    //   225: istore 26
    //   227: iconst_1
    //   228: istore 23
    //   230: iconst_1
    //   231: istore 25
    //   233: iconst_1
    //   234: istore 27
    //   236: iload 27
    //   238: istore 6
    //   240: iload 22
    //   242: istore 7
    //   244: iload 24
    //   246: istore 8
    //   248: iload 26
    //   250: istore 9
    //   252: iload 23
    //   254: istore 10
    //   256: iload 25
    //   258: istore 11
    //   260: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +60 -> 323
    //   266: iload 22
    //   268: istore 7
    //   270: iload 24
    //   272: istore 8
    //   274: iload 26
    //   276: istore 9
    //   278: iload 23
    //   280: istore 10
    //   282: iload 25
    //   284: istore 11
    //   286: ldc_w 292
    //   289: iconst_2
    //   290: ldc 216
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: invokestatic 218	apqo:a	()Z
    //   301: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 28
    //   309: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 27
    //   321: istore 6
    //   323: new 45	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   330: astore 40
    //   332: iload_3
    //   333: ifeq +1049 -> 1382
    //   336: aload_0
    //   337: invokevirtual 316	android/net/Uri:getPath	()Ljava/lang/String;
    //   340: invokestatic 322	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   343: astore 36
    //   345: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   348: ifeq +31 -> 379
    //   351: ldc_w 292
    //   354: iconst_4
    //   355: new 45	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 324
    //   365: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 36
    //   370: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload 36
    //   381: ifnull +5566 -> 5947
    //   384: aload 36
    //   386: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   389: istore 21
    //   391: aload 36
    //   393: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   396: istore 20
    //   398: iload 21
    //   400: iload 20
    //   402: invokestatic 201	bked:a	(II)Z
    //   405: istore_3
    //   406: iload_3
    //   407: ifne +5533 -> 5940
    //   410: iload 4
    //   412: bipush 254
    //   414: iand
    //   415: istore 8
    //   417: iload 21
    //   419: iload 20
    //   421: imul
    //   422: newarray int
    //   424: astore 35
    //   426: aload 36
    //   428: aload 35
    //   430: iconst_0
    //   431: iload 21
    //   433: iconst_0
    //   434: iconst_0
    //   435: iload 21
    //   437: iload 20
    //   439: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   442: iload 8
    //   444: iconst_1
    //   445: iand
    //   446: iconst_1
    //   447: if_icmpne +5487 -> 5934
    //   450: invokestatic 203	zxx:a	()I
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
    //   475: istore 11
    //   477: iload 4
    //   479: istore 15
    //   481: iload 18
    //   483: istore 10
    //   485: aload 35
    //   487: aconst_null
    //   488: iload 21
    //   490: iload 20
    //   492: iload 8
    //   494: aload 40
    //   496: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   499: istore 7
    //   501: iload 4
    //   503: istore 12
    //   505: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   508: ifeq +48 -> 556
    //   511: iload 4
    //   513: istore 12
    //   515: ldc_w 292
    //   518: iconst_4
    //   519: ldc_w 329
    //   522: iconst_3
    //   523: anewarray 4	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: iload 8
    //   530: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: iconst_1
    //   536: iload 7
    //   538: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_2
    //   544: aload 40
    //   546: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: aastore
    //   550: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   553: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: iload 4
    //   558: istore 12
    //   560: iload 21
    //   562: iload 20
    //   564: imul
    //   565: newarray byte
    //   567: astore_1
    //   568: iload 4
    //   570: istore 12
    //   572: aload 35
    //   574: aload_1
    //   575: iload 21
    //   577: iload 20
    //   579: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
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
    //   605: invokestatic 81	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   608: iflt +13 -> 621
    //   611: iload 4
    //   613: istore 12
    //   615: invokestatic 218	apqo:a	()Z
    //   618: ifeq +3 -> 621
    //   621: iload 9
    //   623: ifeq +5308 -> 5931
    //   626: iload 4
    //   628: istore 12
    //   630: aload 36
    //   632: iload 21
    //   634: iload 20
    //   636: aload 35
    //   638: aload_1
    //   639: aload 40
    //   641: invokestatic 180	zxx:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   671: istore 11
    //   673: iload 4
    //   675: istore 15
    //   677: iload 7
    //   679: istore 10
    //   681: iload 7
    //   683: istore 16
    //   685: iload 7
    //   687: istore 17
    //   689: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
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
    //   713: istore 11
    //   715: iload 4
    //   717: istore 15
    //   719: iload 7
    //   721: istore 10
    //   723: iload 7
    //   725: istore 16
    //   727: iload 7
    //   729: istore 17
    //   731: ldc 43
    //   733: iconst_4
    //   734: new 45	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 331
    //   744: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: iload 7
    //   749: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: iload 4
    //   760: istore 12
    //   762: aload 36
    //   764: invokevirtual 334	android/graphics/Bitmap:recycle	()V
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
    //   796: if_icmpne +3198 -> 3994
    //   799: iconst_1
    //   800: istore_3
    //   801: iload_3
    //   802: ifeq +5179 -> 5981
    //   805: aload 5
    //   807: ifnull +5174 -> 5981
    //   810: iload_2
    //   811: ifeq +5170 -> 5981
    //   814: aload_1
    //   815: astore 34
    //   817: iload 7
    //   819: istore 8
    //   821: new 45	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   828: astore 36
    //   830: aload_1
    //   831: astore 34
    //   833: iload 7
    //   835: istore 8
    //   837: new 45	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   844: astore 35
    //   846: aload_1
    //   847: astore 34
    //   849: iload 7
    //   851: istore 8
    //   853: aload 36
    //   855: aload 35
    //   857: invokestatic 241	bked:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   860: pop
    //   861: aload_1
    //   862: astore 34
    //   864: iload 7
    //   866: istore 8
    //   868: aload 5
    //   870: iconst_1
    //   871: new 243	android/util/Pair
    //   874: dup
    //   875: aload 35
    //   877: aload 36
    //   879: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   882: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   885: goto +5096 -> 5981
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
    //   909: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   915: aload_1
    //   916: astore 34
    //   918: iload 7
    //   920: istore 8
    //   922: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: ifeq +64 -> 989
    //   928: aload_1
    //   929: astore 34
    //   931: iload 7
    //   933: istore 8
    //   935: ldc_w 292
    //   938: iconst_2
    //   939: ldc 254
    //   941: iconst_5
    //   942: anewarray 4	java/lang/Object
    //   945: dup
    //   946: iconst_0
    //   947: iload 9
    //   949: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   952: aastore
    //   953: dup
    //   954: iconst_1
    //   955: iload 4
    //   957: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   960: aastore
    //   961: dup
    //   962: iconst_2
    //   963: iload_3
    //   964: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   967: aastore
    //   968: dup
    //   969: iconst_3
    //   970: iload_2
    //   971: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   974: aastore
    //   975: dup
    //   976: iconst_4
    //   977: aload 40
    //   979: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: aastore
    //   983: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   986: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: iload 7
    //   991: ifeq +7 -> 998
    //   994: invokestatic 256	zxx:b	()I
    //   997: pop
    //   998: iload 6
    //   1000: ifeq +14 -> 1014
    //   1003: invokestatic 98	apqo:a	()Lapqo;
    //   1006: lload 28
    //   1008: ldc_w 292
    //   1011: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   1014: iload 4
    //   1016: istore 6
    //   1018: aload_1
    //   1019: ifnull +11 -> 1030
    //   1022: aload_1
    //   1023: invokevirtual 339	java/io/InputStream:close	()V
    //   1026: iload 4
    //   1028: istore 6
    //   1030: iload 6
    //   1032: istore 4
    //   1034: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1037: ifeq -1026 -> 11
    //   1040: ldc_w 292
    //   1043: iconst_4
    //   1044: new 45	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1051: ldc_w 341
    //   1054: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   1060: lload 32
    //   1062: lsub
    //   1063: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: ldc_w 343
    //   1069: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload_0
    //   1073: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: iload 6
    //   1084: ireturn
    //   1085: iconst_0
    //   1086: istore 9
    //   1088: goto -487 -> 601
    //   1091: astore_1
    //   1092: iconst_0
    //   1093: istore 7
    //   1095: iload 4
    //   1097: istore 8
    //   1099: iload 19
    //   1101: istore 4
    //   1103: iload 7
    //   1105: istore 12
    //   1107: iload 7
    //   1109: istore 17
    //   1111: iload 4
    //   1113: istore 16
    //   1115: iload 7
    //   1117: istore 13
    //   1119: iload 4
    //   1121: istore 9
    //   1123: iload 7
    //   1125: istore 14
    //   1127: iload 4
    //   1129: istore 11
    //   1131: iload 7
    //   1133: istore 15
    //   1135: iload 4
    //   1137: istore 10
    //   1139: aload_1
    //   1140: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1143: iload 7
    //   1145: istore 12
    //   1147: iload 7
    //   1149: istore 17
    //   1151: iload 4
    //   1153: istore 16
    //   1155: iload 7
    //   1157: istore 13
    //   1159: iload 4
    //   1161: istore 9
    //   1163: iload 7
    //   1165: istore 14
    //   1167: iload 4
    //   1169: istore 11
    //   1171: iload 7
    //   1173: istore 15
    //   1175: iload 4
    //   1177: istore 10
    //   1179: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1182: ifeq +4812 -> 5994
    //   1185: iload 7
    //   1187: istore 12
    //   1189: iload 7
    //   1191: istore 17
    //   1193: iload 4
    //   1195: istore 16
    //   1197: iload 7
    //   1199: istore 13
    //   1201: iload 4
    //   1203: istore 9
    //   1205: iload 7
    //   1207: istore 14
    //   1209: iload 4
    //   1211: istore 11
    //   1213: iload 7
    //   1215: istore 15
    //   1217: iload 4
    //   1219: istore 10
    //   1221: ldc_w 292
    //   1224: iconst_2
    //   1225: aload_1
    //   1226: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1229: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: goto +4762 -> 5994
    //   1235: iload 4
    //   1237: istore 12
    //   1239: iload 4
    //   1241: istore 17
    //   1243: iload 8
    //   1245: istore 16
    //   1247: iload 4
    //   1249: istore 13
    //   1251: iload 8
    //   1253: istore 9
    //   1255: iload 4
    //   1257: istore 14
    //   1259: iload 8
    //   1261: istore 11
    //   1263: iload 4
    //   1265: istore 15
    //   1267: iload 8
    //   1269: istore 10
    //   1271: aload_1
    //   1272: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   1275: iload 4
    //   1277: istore 12
    //   1279: iload 4
    //   1281: istore 17
    //   1283: iload 8
    //   1285: istore 16
    //   1287: iload 4
    //   1289: istore 13
    //   1291: iload 8
    //   1293: istore 9
    //   1295: iload 4
    //   1297: istore 14
    //   1299: iload 8
    //   1301: istore 11
    //   1303: iload 4
    //   1305: istore 15
    //   1307: iload 8
    //   1309: istore 10
    //   1311: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1314: ifeq +50 -> 1364
    //   1317: iload 4
    //   1319: istore 12
    //   1321: iload 4
    //   1323: istore 17
    //   1325: iload 8
    //   1327: istore 16
    //   1329: iload 4
    //   1331: istore 13
    //   1333: iload 8
    //   1335: istore 9
    //   1337: iload 4
    //   1339: istore 14
    //   1341: iload 8
    //   1343: istore 11
    //   1345: iload 4
    //   1347: istore 15
    //   1349: iload 8
    //   1351: istore 10
    //   1353: ldc_w 292
    //   1356: iconst_2
    //   1357: aload_1
    //   1358: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1361: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1364: aload 34
    //   1366: astore_1
    //   1367: iload 7
    //   1369: istore 9
    //   1371: iload 4
    //   1373: istore 7
    //   1375: iload 8
    //   1377: istore 4
    //   1379: goto -593 -> 786
    //   1382: new 347	android/graphics/BitmapFactory$Options
    //   1385: dup
    //   1386: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   1389: astore 41
    //   1391: aload 41
    //   1393: iconst_1
    //   1394: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1397: aload 34
    //   1399: aconst_null
    //   1400: aload 41
    //   1402: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1405: pop
    //   1406: aload 34
    //   1408: invokevirtual 339	java/io/InputStream:close	()V
    //   1411: aconst_null
    //   1412: astore_1
    //   1413: aconst_null
    //   1414: astore 35
    //   1416: aconst_null
    //   1417: astore 36
    //   1419: aload_1
    //   1420: astore 34
    //   1422: iload 21
    //   1424: istore 8
    //   1426: aload 41
    //   1428: getfield 360	android/graphics/BitmapFactory$Options:outWidth	I
    //   1431: istore 15
    //   1433: aload_1
    //   1434: astore 34
    //   1436: iload 21
    //   1438: istore 8
    //   1440: aload 41
    //   1442: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
    //   1445: istore 16
    //   1447: iload 15
    //   1449: sipush 12800
    //   1452: if_icmpgt +11 -> 1463
    //   1455: iload 16
    //   1457: sipush 12800
    //   1460: if_icmple +65 -> 1525
    //   1463: iconst_0
    //   1464: istore 7
    //   1466: iload 6
    //   1468: ifeq +14 -> 1482
    //   1471: invokestatic 98	apqo:a	()Lapqo;
    //   1474: lload 28
    //   1476: ldc_w 292
    //   1479: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   1482: iload 7
    //   1484: istore 4
    //   1486: iconst_0
    //   1487: ifeq -1476 -> 11
    //   1490: new 365	java/lang/NullPointerException
    //   1493: dup
    //   1494: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   1497: athrow
    //   1498: astore_0
    //   1499: aload_0
    //   1500: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   1503: iload 7
    //   1505: istore 4
    //   1507: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1510: ifeq -1499 -> 11
    //   1513: ldc 43
    //   1515: iconst_2
    //   1516: aload_0
    //   1517: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   1520: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1523: iconst_0
    //   1524: ireturn
    //   1525: aload_1
    //   1526: astore 34
    //   1528: iload 21
    //   1530: istore 8
    //   1532: iload 15
    //   1534: iload 16
    //   1536: invokestatic 201	bked:a	(II)Z
    //   1539: ifne +4385 -> 5924
    //   1542: iload 4
    //   1544: bipush 254
    //   1546: iand
    //   1547: istore 10
    //   1549: iload 10
    //   1551: iconst_1
    //   1552: iand
    //   1553: iconst_1
    //   1554: if_icmpne +4364 -> 5918
    //   1557: aload_1
    //   1558: astore 34
    //   1560: iload 21
    //   1562: istore 8
    //   1564: invokestatic 203	zxx:a	()I
    //   1567: pop
    //   1568: iconst_1
    //   1569: istore 7
    //   1571: aload 35
    //   1573: astore_1
    //   1574: aload 41
    //   1576: aload 41
    //   1578: sipush 1280
    //   1581: sipush 1280
    //   1584: invokestatic 373	aksj:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1587: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1590: aload 35
    //   1592: astore_1
    //   1593: aload 41
    //   1595: iconst_0
    //   1596: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1599: aload 36
    //   1601: astore 34
    //   1603: aload 35
    //   1605: astore_1
    //   1606: aload 42
    //   1608: aload_0
    //   1609: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1612: astore 35
    //   1614: aload 35
    //   1616: astore 34
    //   1618: aload 35
    //   1620: astore_1
    //   1621: aload 35
    //   1623: astore 39
    //   1625: aload 35
    //   1627: astore 36
    //   1629: aload 35
    //   1631: astore 38
    //   1633: aload 35
    //   1635: astore 37
    //   1637: aload 35
    //   1639: aconst_null
    //   1640: aload 41
    //   1642: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1645: astore 43
    //   1647: aload 35
    //   1649: astore 34
    //   1651: aload 35
    //   1653: astore_1
    //   1654: aload 35
    //   1656: astore 39
    //   1658: aload 35
    //   1660: astore 36
    //   1662: aload 35
    //   1664: astore 38
    //   1666: aload 35
    //   1668: astore 37
    //   1670: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1673: ifeq +70 -> 1743
    //   1676: aload 35
    //   1678: astore 34
    //   1680: aload 35
    //   1682: astore_1
    //   1683: aload 35
    //   1685: astore 39
    //   1687: aload 35
    //   1689: astore 36
    //   1691: aload 35
    //   1693: astore 38
    //   1695: aload 35
    //   1697: astore 37
    //   1699: ldc_w 292
    //   1702: iconst_4
    //   1703: ldc_w 378
    //   1706: iconst_3
    //   1707: anewarray 4	java/lang/Object
    //   1710: dup
    //   1711: iconst_0
    //   1712: iload 15
    //   1714: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1717: aastore
    //   1718: dup
    //   1719: iconst_1
    //   1720: iload 16
    //   1722: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1725: aastore
    //   1726: dup
    //   1727: iconst_2
    //   1728: aload 41
    //   1730: getfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1733: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1736: aastore
    //   1737: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1740: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1743: aload 35
    //   1745: astore 34
    //   1747: aload 35
    //   1749: astore_1
    //   1750: aload 35
    //   1752: astore 39
    //   1754: aload 35
    //   1756: astore 36
    //   1758: aload 35
    //   1760: astore 38
    //   1762: aload 35
    //   1764: astore 37
    //   1766: aload 35
    //   1768: invokevirtual 339	java/io/InputStream:close	()V
    //   1771: aconst_null
    //   1772: astore_1
    //   1773: aconst_null
    //   1774: astore 34
    //   1776: iload 20
    //   1778: istore 4
    //   1780: aload 43
    //   1782: ifnull +20 -> 1802
    //   1785: aload 43
    //   1787: iload 10
    //   1789: aload 40
    //   1791: invokestatic 225	zxx:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1794: istore 4
    //   1796: iconst_0
    //   1797: iload 4
    //   1799: ior
    //   1800: istore 4
    //   1802: aconst_null
    //   1803: astore 34
    //   1805: aconst_null
    //   1806: astore 36
    //   1808: aconst_null
    //   1809: astore 35
    //   1811: aload 36
    //   1813: astore_1
    //   1814: iload 4
    //   1816: istore 13
    //   1818: iload 4
    //   1820: istore 12
    //   1822: iload 4
    //   1824: istore 14
    //   1826: iload 4
    //   1828: istore 11
    //   1830: iload 10
    //   1832: iload 4
    //   1834: invokestatic 227	zxx:a	(II)I
    //   1837: istore 17
    //   1839: iload 17
    //   1841: ifle +4068 -> 5909
    //   1844: iload 15
    //   1846: iload 16
    //   1848: iconst_2
    //   1849: imul
    //   1850: if_icmplt +1094 -> 2944
    //   1853: iload 16
    //   1855: sipush 1280
    //   1858: if_icmpge +1086 -> 2944
    //   1861: iconst_1
    //   1862: istore 8
    //   1864: iload 15
    //   1866: iconst_2
    //   1867: imul
    //   1868: iload 16
    //   1870: if_icmpgt +1080 -> 2950
    //   1873: iload 15
    //   1875: sipush 1280
    //   1878: if_icmpge +1072 -> 2950
    //   1881: iconst_1
    //   1882: istore 9
    //   1884: iload 9
    //   1886: ifeq +1161 -> 3047
    //   1889: aload 36
    //   1891: astore_1
    //   1892: iload 4
    //   1894: istore 13
    //   1896: iload 4
    //   1898: istore 12
    //   1900: iload 4
    //   1902: istore 14
    //   1904: iload 4
    //   1906: istore 11
    //   1908: aload 42
    //   1910: aload_0
    //   1911: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1914: astore 34
    //   1916: aload 34
    //   1918: astore 35
    //   1920: aload 34
    //   1922: astore_1
    //   1923: aload 34
    //   1925: astore 38
    //   1927: iload 4
    //   1929: istore 13
    //   1931: aload 34
    //   1933: astore 39
    //   1935: iload 4
    //   1937: istore 12
    //   1939: aload 34
    //   1941: astore 36
    //   1943: iload 4
    //   1945: istore 11
    //   1947: aload 34
    //   1949: astore 37
    //   1951: iload 4
    //   1953: istore 9
    //   1955: aload 34
    //   1957: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1960: astore 43
    //   1962: aload 34
    //   1964: astore 35
    //   1966: aload 34
    //   1968: astore_1
    //   1969: aload 34
    //   1971: astore 38
    //   1973: iload 4
    //   1975: istore 13
    //   1977: aload 34
    //   1979: astore 39
    //   1981: iload 4
    //   1983: istore 12
    //   1985: aload 34
    //   1987: astore 36
    //   1989: iload 4
    //   1991: istore 11
    //   1993: aload 34
    //   1995: astore 37
    //   1997: iload 4
    //   1999: istore 9
    //   2001: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2004: ifeq +70 -> 2074
    //   2007: aload 34
    //   2009: astore 35
    //   2011: aload 34
    //   2013: astore_1
    //   2014: aload 34
    //   2016: astore 38
    //   2018: iload 4
    //   2020: istore 13
    //   2022: aload 34
    //   2024: astore 39
    //   2026: iload 4
    //   2028: istore 12
    //   2030: aload 34
    //   2032: astore 36
    //   2034: iload 4
    //   2036: istore 11
    //   2038: aload 34
    //   2040: astore 37
    //   2042: iload 4
    //   2044: istore 9
    //   2046: ldc_w 292
    //   2049: iconst_4
    //   2050: new 45	java/lang/StringBuilder
    //   2053: dup
    //   2054: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2057: ldc_w 383
    //   2060: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: aload 43
    //   2065: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2068: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2071: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2074: aload 34
    //   2076: astore 35
    //   2078: aload 34
    //   2080: astore_1
    //   2081: aload 34
    //   2083: astore 38
    //   2085: iload 4
    //   2087: istore 13
    //   2089: aload 34
    //   2091: astore 39
    //   2093: iload 4
    //   2095: istore 12
    //   2097: aload 34
    //   2099: astore 36
    //   2101: iload 4
    //   2103: istore 11
    //   2105: aload 34
    //   2107: astore 37
    //   2109: iload 4
    //   2111: istore 9
    //   2113: aload 34
    //   2115: invokevirtual 339	java/io/InputStream:close	()V
    //   2118: aconst_null
    //   2119: astore 36
    //   2121: aconst_null
    //   2122: astore 34
    //   2124: aconst_null
    //   2125: astore 35
    //   2127: aconst_null
    //   2128: astore 37
    //   2130: aload 43
    //   2132: ifnull +3783 -> 5915
    //   2135: iload 4
    //   2137: istore 12
    //   2139: iload 4
    //   2141: istore 13
    //   2143: iload 4
    //   2145: istore 11
    //   2147: iload 4
    //   2149: istore 8
    //   2151: iload 4
    //   2153: istore 9
    //   2155: iload 15
    //   2157: iload 15
    //   2159: imul
    //   2160: newarray int
    //   2162: astore 38
    //   2164: iload 4
    //   2166: istore 12
    //   2168: iload 4
    //   2170: istore 13
    //   2172: iload 4
    //   2174: istore 11
    //   2176: iload 4
    //   2178: istore 8
    //   2180: iload 4
    //   2182: istore 9
    //   2184: aload 43
    //   2186: aload 38
    //   2188: iconst_0
    //   2189: iload 15
    //   2191: iconst_0
    //   2192: iconst_0
    //   2193: iload 15
    //   2195: iload 15
    //   2197: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2200: iload 4
    //   2202: istore 12
    //   2204: iload 4
    //   2206: istore 13
    //   2208: iload 4
    //   2210: istore 11
    //   2212: iload 4
    //   2214: istore 8
    //   2216: iload 4
    //   2218: istore 9
    //   2220: iload 15
    //   2222: iload 15
    //   2224: imul
    //   2225: newarray byte
    //   2227: astore_1
    //   2228: iload 4
    //   2230: istore 12
    //   2232: iload 4
    //   2234: istore 13
    //   2236: iload 4
    //   2238: istore 11
    //   2240: iload 4
    //   2242: istore 8
    //   2244: iload 4
    //   2246: istore 9
    //   2248: aload 38
    //   2250: aload_1
    //   2251: iload 15
    //   2253: iload 15
    //   2255: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2258: pop
    //   2259: iload 4
    //   2261: istore 12
    //   2263: iload 4
    //   2265: istore 13
    //   2267: iload 4
    //   2269: istore 11
    //   2271: iload 4
    //   2273: istore 8
    //   2275: iload 4
    //   2277: istore 9
    //   2279: iload 4
    //   2281: aload 38
    //   2283: aload_1
    //   2284: iload 15
    //   2286: iload 15
    //   2288: iload 17
    //   2290: aload 40
    //   2292: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2295: ior
    //   2296: istore 4
    //   2298: iload 4
    //   2300: iconst_1
    //   2301: if_icmpeq +3611 -> 5912
    //   2304: iload 4
    //   2306: istore 12
    //   2308: iload 4
    //   2310: istore 13
    //   2312: iload 4
    //   2314: istore 11
    //   2316: iload 4
    //   2318: istore 8
    //   2320: iload 4
    //   2322: istore 9
    //   2324: aload 43
    //   2326: aload 38
    //   2328: iconst_0
    //   2329: iload 15
    //   2331: iconst_0
    //   2332: iload 16
    //   2334: iload 15
    //   2336: isub
    //   2337: iload 15
    //   2339: iload 15
    //   2341: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2344: iload 4
    //   2346: istore 12
    //   2348: iload 4
    //   2350: istore 13
    //   2352: iload 4
    //   2354: istore 11
    //   2356: iload 4
    //   2358: istore 8
    //   2360: iload 4
    //   2362: istore 9
    //   2364: aload 38
    //   2366: aload_1
    //   2367: iload 15
    //   2369: iload 15
    //   2371: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2374: pop
    //   2375: iload 4
    //   2377: istore 12
    //   2379: iload 4
    //   2381: istore 13
    //   2383: iload 4
    //   2385: istore 11
    //   2387: iload 4
    //   2389: istore 8
    //   2391: iload 4
    //   2393: istore 9
    //   2395: aload 38
    //   2397: aload_1
    //   2398: iload 15
    //   2400: iload 15
    //   2402: iload 17
    //   2404: aload 40
    //   2406: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2409: istore 14
    //   2411: iload 14
    //   2413: iload 4
    //   2415: ior
    //   2416: istore 4
    //   2418: aload 43
    //   2420: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2423: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2426: ifeq +44 -> 2470
    //   2429: ldc_w 292
    //   2432: iconst_4
    //   2433: ldc_w 385
    //   2436: iconst_3
    //   2437: anewarray 4	java/lang/Object
    //   2440: dup
    //   2441: iconst_0
    //   2442: iload 17
    //   2444: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2447: aastore
    //   2448: dup
    //   2449: iconst_1
    //   2450: iload 4
    //   2452: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2455: aastore
    //   2456: dup
    //   2457: iconst_2
    //   2458: aload 40
    //   2460: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2463: aastore
    //   2464: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2467: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2470: aconst_null
    //   2471: astore 35
    //   2473: aconst_null
    //   2474: astore 34
    //   2476: aconst_null
    //   2477: astore 36
    //   2479: aload 34
    //   2481: astore_1
    //   2482: iload 10
    //   2484: iload 4
    //   2486: invokestatic 227	zxx:a	(II)I
    //   2489: istore 13
    //   2491: iload 13
    //   2493: ifle +3406 -> 5899
    //   2496: aload 34
    //   2498: astore_1
    //   2499: iload 15
    //   2501: iload 16
    //   2503: invokestatic 232	java/lang/Math:min	(II)I
    //   2506: istore 8
    //   2508: iload 8
    //   2510: sipush 250
    //   2513: if_icmple +3386 -> 5899
    //   2516: aload 34
    //   2518: astore_1
    //   2519: aload 41
    //   2521: iload 8
    //   2523: i2d
    //   2524: ldc2_w 233
    //   2527: ddiv
    //   2528: invokestatic 238	java/lang/Math:ceil	(D)D
    //   2531: d2i
    //   2532: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2535: aload 34
    //   2537: astore_1
    //   2538: aload 42
    //   2540: aload_0
    //   2541: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2544: astore 34
    //   2546: aload 34
    //   2548: astore 35
    //   2550: aload 34
    //   2552: astore_1
    //   2553: aload 34
    //   2555: astore 37
    //   2557: iload 4
    //   2559: istore 9
    //   2561: aload 34
    //   2563: astore 36
    //   2565: iload 4
    //   2567: istore 11
    //   2569: aload 34
    //   2571: astore 39
    //   2573: iload 4
    //   2575: istore 12
    //   2577: aload 34
    //   2579: astore 38
    //   2581: iload 4
    //   2583: istore 8
    //   2585: aload 34
    //   2587: aconst_null
    //   2588: aload 41
    //   2590: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2593: astore 41
    //   2595: aload 34
    //   2597: astore 35
    //   2599: aload 34
    //   2601: astore_1
    //   2602: aload 34
    //   2604: astore 37
    //   2606: iload 4
    //   2608: istore 9
    //   2610: aload 34
    //   2612: astore 36
    //   2614: iload 4
    //   2616: istore 11
    //   2618: aload 34
    //   2620: astore 39
    //   2622: iload 4
    //   2624: istore 12
    //   2626: aload 34
    //   2628: astore 38
    //   2630: iload 4
    //   2632: istore 8
    //   2634: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2637: ifeq +70 -> 2707
    //   2640: aload 34
    //   2642: astore 35
    //   2644: aload 34
    //   2646: astore_1
    //   2647: aload 34
    //   2649: astore 37
    //   2651: iload 4
    //   2653: istore 9
    //   2655: aload 34
    //   2657: astore 36
    //   2659: iload 4
    //   2661: istore 11
    //   2663: aload 34
    //   2665: astore 39
    //   2667: iload 4
    //   2669: istore 12
    //   2671: aload 34
    //   2673: astore 38
    //   2675: iload 4
    //   2677: istore 8
    //   2679: ldc_w 292
    //   2682: iconst_4
    //   2683: new 45	java/lang/StringBuilder
    //   2686: dup
    //   2687: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2690: ldc_w 387
    //   2693: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2696: aload 41
    //   2698: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2701: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2704: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2707: aload 34
    //   2709: astore 35
    //   2711: aload 34
    //   2713: astore_1
    //   2714: aload 34
    //   2716: astore 37
    //   2718: iload 4
    //   2720: istore 9
    //   2722: aload 34
    //   2724: astore 36
    //   2726: iload 4
    //   2728: istore 11
    //   2730: aload 34
    //   2732: astore 39
    //   2734: iload 4
    //   2736: istore 12
    //   2738: aload 34
    //   2740: astore 38
    //   2742: iload 4
    //   2744: istore 8
    //   2746: aload 34
    //   2748: invokevirtual 339	java/io/InputStream:close	()V
    //   2751: aload 41
    //   2753: ifnull +3139 -> 5892
    //   2756: aload 41
    //   2758: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   2761: istore 8
    //   2763: aload 41
    //   2765: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   2768: istore 9
    //   2770: iload 8
    //   2772: iload 9
    //   2774: imul
    //   2775: newarray int
    //   2777: astore_1
    //   2778: aload 41
    //   2780: aload_1
    //   2781: iconst_0
    //   2782: iload 8
    //   2784: iconst_0
    //   2785: iconst_0
    //   2786: iload 8
    //   2788: iload 9
    //   2790: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2793: aload 41
    //   2795: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2798: aload_1
    //   2799: aconst_null
    //   2800: iload 8
    //   2802: iload 9
    //   2804: iload 13
    //   2806: aload 40
    //   2808: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2811: istore 8
    //   2813: iload 8
    //   2815: iload 4
    //   2817: ior
    //   2818: istore 4
    //   2820: iload 4
    //   2822: istore 8
    //   2824: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2827: ifeq +48 -> 2875
    //   2830: ldc_w 292
    //   2833: iconst_4
    //   2834: ldc_w 389
    //   2837: iconst_3
    //   2838: anewarray 4	java/lang/Object
    //   2841: dup
    //   2842: iconst_0
    //   2843: iload 13
    //   2845: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2848: aastore
    //   2849: dup
    //   2850: iconst_1
    //   2851: iload 4
    //   2853: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2856: aastore
    //   2857: dup
    //   2858: iconst_2
    //   2859: aload 40
    //   2861: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2864: aastore
    //   2865: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2868: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2871: iload 4
    //   2873: istore 8
    //   2875: aconst_null
    //   2876: astore_1
    //   2877: iload 10
    //   2879: istore 9
    //   2881: iload 8
    //   2883: istore 4
    //   2885: goto -2099 -> 786
    //   2888: astore 35
    //   2890: aload 34
    //   2892: astore_1
    //   2893: aload 34
    //   2895: astore 39
    //   2897: aload 34
    //   2899: astore 36
    //   2901: aload 34
    //   2903: astore 38
    //   2905: aload 34
    //   2907: astore 37
    //   2909: aload 35
    //   2911: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2914: aload 34
    //   2916: astore_1
    //   2917: aload 34
    //   2919: astore 39
    //   2921: aload 34
    //   2923: astore 36
    //   2925: aload 34
    //   2927: astore 38
    //   2929: aload 34
    //   2931: astore 37
    //   2933: aload 34
    //   2935: invokevirtual 339	java/io/InputStream:close	()V
    //   2938: iconst_0
    //   2939: istore 4
    //   2941: goto -1139 -> 1802
    //   2944: iconst_0
    //   2945: istore 8
    //   2947: goto -1083 -> 1864
    //   2950: iconst_0
    //   2951: istore 9
    //   2953: goto -1069 -> 1884
    //   2956: astore_1
    //   2957: aload 35
    //   2959: astore 34
    //   2961: aload_1
    //   2962: astore 35
    //   2964: aload 34
    //   2966: astore_1
    //   2967: aload 34
    //   2969: astore 38
    //   2971: iload 4
    //   2973: istore 13
    //   2975: aload 34
    //   2977: astore 39
    //   2979: iload 4
    //   2981: istore 12
    //   2983: aload 34
    //   2985: astore 36
    //   2987: iload 4
    //   2989: istore 11
    //   2991: aload 34
    //   2993: astore 37
    //   2995: iload 4
    //   2997: istore 9
    //   2999: aload 35
    //   3001: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3004: aload 34
    //   3006: astore_1
    //   3007: aload 34
    //   3009: astore 38
    //   3011: iload 4
    //   3013: istore 13
    //   3015: aload 34
    //   3017: astore 39
    //   3019: iload 4
    //   3021: istore 12
    //   3023: aload 34
    //   3025: astore 36
    //   3027: iload 4
    //   3029: istore 11
    //   3031: aload 34
    //   3033: astore 37
    //   3035: iload 4
    //   3037: istore 9
    //   3039: aload 34
    //   3041: invokevirtual 339	java/io/InputStream:close	()V
    //   3044: goto -574 -> 2470
    //   3047: iload 8
    //   3049: ifeq +2860 -> 5909
    //   3052: iload 4
    //   3054: istore 8
    //   3056: aload 36
    //   3058: astore_1
    //   3059: iload 4
    //   3061: istore 13
    //   3063: iload 4
    //   3065: istore 12
    //   3067: iload 4
    //   3069: istore 14
    //   3071: iload 4
    //   3073: istore 11
    //   3075: aload 42
    //   3077: aload_0
    //   3078: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3081: astore 35
    //   3083: aload 35
    //   3085: astore 34
    //   3087: iload 4
    //   3089: istore 8
    //   3091: aload 35
    //   3093: astore_1
    //   3094: aload 35
    //   3096: astore 38
    //   3098: iload 4
    //   3100: istore 13
    //   3102: aload 35
    //   3104: astore 39
    //   3106: iload 4
    //   3108: istore 12
    //   3110: aload 35
    //   3112: astore 36
    //   3114: iload 4
    //   3116: istore 11
    //   3118: aload 35
    //   3120: astore 37
    //   3122: iload 4
    //   3124: istore 9
    //   3126: aload 35
    //   3128: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3131: astore 43
    //   3133: aload 35
    //   3135: astore 34
    //   3137: iload 4
    //   3139: istore 8
    //   3141: aload 35
    //   3143: astore_1
    //   3144: aload 35
    //   3146: astore 38
    //   3148: iload 4
    //   3150: istore 13
    //   3152: aload 35
    //   3154: astore 39
    //   3156: iload 4
    //   3158: istore 12
    //   3160: aload 35
    //   3162: astore 36
    //   3164: iload 4
    //   3166: istore 11
    //   3168: aload 35
    //   3170: astore 37
    //   3172: iload 4
    //   3174: istore 9
    //   3176: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3179: ifeq +74 -> 3253
    //   3182: aload 35
    //   3184: astore 34
    //   3186: iload 4
    //   3188: istore 8
    //   3190: aload 35
    //   3192: astore_1
    //   3193: aload 35
    //   3195: astore 38
    //   3197: iload 4
    //   3199: istore 13
    //   3201: aload 35
    //   3203: astore 39
    //   3205: iload 4
    //   3207: istore 12
    //   3209: aload 35
    //   3211: astore 36
    //   3213: iload 4
    //   3215: istore 11
    //   3217: aload 35
    //   3219: astore 37
    //   3221: iload 4
    //   3223: istore 9
    //   3225: ldc_w 292
    //   3228: iconst_4
    //   3229: new 45	java/lang/StringBuilder
    //   3232: dup
    //   3233: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3236: ldc_w 391
    //   3239: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3242: aload 43
    //   3244: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3247: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3250: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3253: aload 35
    //   3255: astore 34
    //   3257: iload 4
    //   3259: istore 8
    //   3261: aload 35
    //   3263: astore_1
    //   3264: aload 35
    //   3266: astore 38
    //   3268: iload 4
    //   3270: istore 13
    //   3272: aload 35
    //   3274: astore 39
    //   3276: iload 4
    //   3278: istore 12
    //   3280: aload 35
    //   3282: astore 36
    //   3284: iload 4
    //   3286: istore 11
    //   3288: aload 35
    //   3290: astore 37
    //   3292: iload 4
    //   3294: istore 9
    //   3296: aload 35
    //   3298: invokevirtual 339	java/io/InputStream:close	()V
    //   3301: aconst_null
    //   3302: astore 35
    //   3304: aconst_null
    //   3305: astore 36
    //   3307: iload 4
    //   3309: istore 9
    //   3311: aload 43
    //   3313: ifnull +488 -> 3801
    //   3316: aload 36
    //   3318: astore 34
    //   3320: iload 4
    //   3322: istore 8
    //   3324: aload 35
    //   3326: astore_1
    //   3327: iload 4
    //   3329: istore 13
    //   3331: iload 4
    //   3333: istore 12
    //   3335: iload 4
    //   3337: istore 14
    //   3339: iload 4
    //   3341: istore 11
    //   3343: iload 16
    //   3345: iload 16
    //   3347: imul
    //   3348: newarray int
    //   3350: astore 38
    //   3352: aload 36
    //   3354: astore 34
    //   3356: iload 4
    //   3358: istore 8
    //   3360: aload 35
    //   3362: astore_1
    //   3363: iload 4
    //   3365: istore 13
    //   3367: iload 4
    //   3369: istore 12
    //   3371: iload 4
    //   3373: istore 14
    //   3375: iload 4
    //   3377: istore 11
    //   3379: aload 43
    //   3381: aload 38
    //   3383: iconst_0
    //   3384: iload 16
    //   3386: iconst_0
    //   3387: iconst_0
    //   3388: iload 16
    //   3390: iload 16
    //   3392: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3395: aload 36
    //   3397: astore 34
    //   3399: iload 4
    //   3401: istore 8
    //   3403: aload 35
    //   3405: astore_1
    //   3406: iload 4
    //   3408: istore 13
    //   3410: iload 4
    //   3412: istore 12
    //   3414: iload 4
    //   3416: istore 14
    //   3418: iload 4
    //   3420: istore 11
    //   3422: iload 16
    //   3424: iload 16
    //   3426: imul
    //   3427: newarray byte
    //   3429: astore 37
    //   3431: aload 36
    //   3433: astore 34
    //   3435: iload 4
    //   3437: istore 8
    //   3439: aload 35
    //   3441: astore_1
    //   3442: iload 4
    //   3444: istore 13
    //   3446: iload 4
    //   3448: istore 12
    //   3450: iload 4
    //   3452: istore 14
    //   3454: iload 4
    //   3456: istore 11
    //   3458: aload 38
    //   3460: aload 37
    //   3462: iload 16
    //   3464: iload 16
    //   3466: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3469: pop
    //   3470: aload 36
    //   3472: astore 34
    //   3474: iload 4
    //   3476: istore 8
    //   3478: aload 35
    //   3480: astore_1
    //   3481: iload 4
    //   3483: istore 13
    //   3485: iload 4
    //   3487: istore 12
    //   3489: iload 4
    //   3491: istore 14
    //   3493: iload 4
    //   3495: istore 11
    //   3497: iload 4
    //   3499: aload 38
    //   3501: aload 37
    //   3503: iload 16
    //   3505: iload 16
    //   3507: iload 17
    //   3509: aload 40
    //   3511: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3514: ior
    //   3515: istore 9
    //   3517: iload 9
    //   3519: istore 4
    //   3521: iload 9
    //   3523: iconst_1
    //   3524: if_icmpeq +136 -> 3660
    //   3527: aload 36
    //   3529: astore 34
    //   3531: iload 9
    //   3533: istore 8
    //   3535: aload 35
    //   3537: astore_1
    //   3538: iload 9
    //   3540: istore 13
    //   3542: iload 9
    //   3544: istore 12
    //   3546: iload 9
    //   3548: istore 14
    //   3550: iload 9
    //   3552: istore 11
    //   3554: aload 43
    //   3556: aload 38
    //   3558: iconst_0
    //   3559: iload 16
    //   3561: iload 15
    //   3563: iload 16
    //   3565: isub
    //   3566: iconst_0
    //   3567: iload 16
    //   3569: iload 16
    //   3571: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3574: aload 36
    //   3576: astore 34
    //   3578: iload 9
    //   3580: istore 8
    //   3582: aload 35
    //   3584: astore_1
    //   3585: iload 9
    //   3587: istore 13
    //   3589: iload 9
    //   3591: istore 12
    //   3593: iload 9
    //   3595: istore 14
    //   3597: iload 9
    //   3599: istore 11
    //   3601: aload 38
    //   3603: aload 37
    //   3605: iload 16
    //   3607: iload 16
    //   3609: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3612: pop
    //   3613: aload 36
    //   3615: astore 34
    //   3617: iload 9
    //   3619: istore 8
    //   3621: aload 35
    //   3623: astore_1
    //   3624: iload 9
    //   3626: istore 13
    //   3628: iload 9
    //   3630: istore 12
    //   3632: iload 9
    //   3634: istore 14
    //   3636: iload 9
    //   3638: istore 11
    //   3640: iload 9
    //   3642: aload 38
    //   3644: aload 37
    //   3646: iload 16
    //   3648: iload 16
    //   3650: iload 17
    //   3652: aload 40
    //   3654: invokestatic 176	zxx:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3657: ior
    //   3658: istore 4
    //   3660: aload 36
    //   3662: astore 34
    //   3664: iload 4
    //   3666: istore 8
    //   3668: aload 35
    //   3670: astore_1
    //   3671: iload 4
    //   3673: istore 13
    //   3675: iload 4
    //   3677: istore 12
    //   3679: iload 4
    //   3681: istore 14
    //   3683: iload 4
    //   3685: istore 11
    //   3687: aload 43
    //   3689: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   3692: iload 4
    //   3694: istore 9
    //   3696: aload 36
    //   3698: astore 34
    //   3700: iload 4
    //   3702: istore 8
    //   3704: aload 35
    //   3706: astore_1
    //   3707: iload 4
    //   3709: istore 13
    //   3711: iload 4
    //   3713: istore 12
    //   3715: iload 4
    //   3717: istore 14
    //   3719: iload 4
    //   3721: istore 11
    //   3723: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3726: ifeq +75 -> 3801
    //   3729: aload 36
    //   3731: astore 34
    //   3733: iload 4
    //   3735: istore 8
    //   3737: aload 35
    //   3739: astore_1
    //   3740: iload 4
    //   3742: istore 13
    //   3744: iload 4
    //   3746: istore 12
    //   3748: iload 4
    //   3750: istore 14
    //   3752: iload 4
    //   3754: istore 11
    //   3756: ldc_w 292
    //   3759: iconst_4
    //   3760: ldc_w 393
    //   3763: iconst_3
    //   3764: anewarray 4	java/lang/Object
    //   3767: dup
    //   3768: iconst_0
    //   3769: iload 17
    //   3771: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3774: aastore
    //   3775: dup
    //   3776: iconst_1
    //   3777: iload 4
    //   3779: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3782: aastore
    //   3783: dup
    //   3784: iconst_2
    //   3785: aload 40
    //   3787: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3790: aastore
    //   3791: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3794: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3797: iload 4
    //   3799: istore 9
    //   3801: iload 9
    //   3803: istore 4
    //   3805: goto -1335 -> 2470
    //   3808: astore 35
    //   3810: aload 34
    //   3812: astore_1
    //   3813: aload 34
    //   3815: astore 38
    //   3817: iload 8
    //   3819: istore 13
    //   3821: aload 34
    //   3823: astore 39
    //   3825: iload 8
    //   3827: istore 12
    //   3829: aload 34
    //   3831: astore 36
    //   3833: iload 8
    //   3835: istore 11
    //   3837: aload 34
    //   3839: astore 37
    //   3841: iload 8
    //   3843: istore 9
    //   3845: aload 35
    //   3847: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3850: aload 34
    //   3852: astore_1
    //   3853: aload 34
    //   3855: astore 38
    //   3857: iload 8
    //   3859: istore 13
    //   3861: aload 34
    //   3863: astore 39
    //   3865: iload 8
    //   3867: istore 12
    //   3869: aload 34
    //   3871: astore 36
    //   3873: iload 8
    //   3875: istore 11
    //   3877: aload 34
    //   3879: astore 37
    //   3881: iload 8
    //   3883: istore 9
    //   3885: aload 34
    //   3887: invokevirtual 339	java/io/InputStream:close	()V
    //   3890: iload 8
    //   3892: istore 4
    //   3894: goto -1424 -> 2470
    //   3897: astore_1
    //   3898: aload 35
    //   3900: astore 34
    //   3902: aload_1
    //   3903: astore 35
    //   3905: aload 34
    //   3907: astore_1
    //   3908: aload 34
    //   3910: astore 37
    //   3912: iload 4
    //   3914: istore 9
    //   3916: aload 34
    //   3918: astore 36
    //   3920: iload 4
    //   3922: istore 11
    //   3924: aload 34
    //   3926: astore 39
    //   3928: iload 4
    //   3930: istore 12
    //   3932: aload 34
    //   3934: astore 38
    //   3936: iload 4
    //   3938: istore 8
    //   3940: aload 35
    //   3942: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3945: aload 34
    //   3947: astore_1
    //   3948: aload 34
    //   3950: astore 37
    //   3952: iload 4
    //   3954: istore 9
    //   3956: aload 34
    //   3958: astore 36
    //   3960: iload 4
    //   3962: istore 11
    //   3964: aload 34
    //   3966: astore 39
    //   3968: iload 4
    //   3970: istore 12
    //   3972: aload 34
    //   3974: astore 38
    //   3976: iload 4
    //   3978: istore 8
    //   3980: aload 34
    //   3982: invokevirtual 339	java/io/InputStream:close	()V
    //   3985: aconst_null
    //   3986: astore_1
    //   3987: iload 10
    //   3989: istore 9
    //   3991: goto -3205 -> 786
    //   3994: iconst_0
    //   3995: istore_3
    //   3996: goto -3195 -> 801
    //   3999: iconst_0
    //   4000: istore_2
    //   4001: goto -3113 -> 888
    //   4004: astore_1
    //   4005: aload_1
    //   4006: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4009: iload 4
    //   4011: istore 6
    //   4013: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4016: ifeq -2986 -> 1030
    //   4019: ldc 43
    //   4021: iconst_2
    //   4022: aload_1
    //   4023: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4026: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4029: iload 4
    //   4031: istore 6
    //   4033: goto -3003 -> 1030
    //   4036: astore_1
    //   4037: iconst_0
    //   4038: istore 6
    //   4040: iconst_0
    //   4041: istore 4
    //   4043: aload 38
    //   4045: astore 34
    //   4047: iload 12
    //   4049: istore 7
    //   4051: lload 30
    //   4053: lstore 28
    //   4055: aload_1
    //   4056: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4059: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4062: ifeq +14 -> 4076
    //   4065: ldc_w 292
    //   4068: iconst_2
    //   4069: aload_1
    //   4070: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4073: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4076: iload 7
    //   4078: ifeq +7 -> 4085
    //   4081: invokestatic 256	zxx:b	()I
    //   4084: pop
    //   4085: iload 6
    //   4087: ifeq +14 -> 4101
    //   4090: invokestatic 98	apqo:a	()Lapqo;
    //   4093: lload 28
    //   4095: ldc_w 292
    //   4098: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   4101: iload 4
    //   4103: istore 6
    //   4105: aload 34
    //   4107: ifnull -3077 -> 1030
    //   4110: aload 34
    //   4112: invokevirtual 339	java/io/InputStream:close	()V
    //   4115: iload 4
    //   4117: istore 6
    //   4119: goto -3089 -> 1030
    //   4122: astore_1
    //   4123: aload_1
    //   4124: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4127: iload 4
    //   4129: istore 6
    //   4131: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4134: ifeq -3104 -> 1030
    //   4137: ldc 43
    //   4139: iconst_2
    //   4140: aload_1
    //   4141: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4144: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4147: iload 4
    //   4149: istore 6
    //   4151: goto -3121 -> 1030
    //   4154: astore_1
    //   4155: ldc2_w 298
    //   4158: lstore 30
    //   4160: iconst_0
    //   4161: istore 6
    //   4163: iconst_0
    //   4164: istore 7
    //   4166: iconst_0
    //   4167: istore 4
    //   4169: aload 37
    //   4171: astore 34
    //   4173: aload 34
    //   4175: astore 5
    //   4177: lload 30
    //   4179: lstore 28
    //   4181: iload 6
    //   4183: istore 9
    //   4185: iload 7
    //   4187: istore 8
    //   4189: aload_1
    //   4190: invokevirtual 267	java/lang/RuntimeException:printStackTrace	()V
    //   4193: aload 34
    //   4195: astore 5
    //   4197: lload 30
    //   4199: lstore 28
    //   4201: iload 6
    //   4203: istore 9
    //   4205: iload 7
    //   4207: istore 8
    //   4209: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4212: ifeq +30 -> 4242
    //   4215: aload 34
    //   4217: astore 5
    //   4219: lload 30
    //   4221: lstore 28
    //   4223: iload 6
    //   4225: istore 9
    //   4227: iload 7
    //   4229: istore 8
    //   4231: ldc_w 292
    //   4234: iconst_2
    //   4235: aload_1
    //   4236: invokevirtual 268	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   4239: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4242: iload 7
    //   4244: ifeq +7 -> 4251
    //   4247: invokestatic 256	zxx:b	()I
    //   4250: pop
    //   4251: iload 6
    //   4253: ifeq +14 -> 4267
    //   4256: invokestatic 98	apqo:a	()Lapqo;
    //   4259: lload 30
    //   4261: ldc_w 292
    //   4264: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   4267: iload 4
    //   4269: istore 6
    //   4271: aload 34
    //   4273: ifnull -3243 -> 1030
    //   4276: aload 34
    //   4278: invokevirtual 339	java/io/InputStream:close	()V
    //   4281: iload 4
    //   4283: istore 6
    //   4285: goto -3255 -> 1030
    //   4288: astore_1
    //   4289: aload_1
    //   4290: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4293: iload 4
    //   4295: istore 6
    //   4297: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4300: ifeq -3270 -> 1030
    //   4303: ldc 43
    //   4305: iconst_2
    //   4306: aload_1
    //   4307: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4310: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4313: iload 4
    //   4315: istore 6
    //   4317: goto -3287 -> 1030
    //   4320: astore_1
    //   4321: ldc2_w 298
    //   4324: lstore 30
    //   4326: iconst_0
    //   4327: istore 6
    //   4329: iconst_0
    //   4330: istore 7
    //   4332: iconst_0
    //   4333: istore 4
    //   4335: aload 36
    //   4337: astore 34
    //   4339: aload 34
    //   4341: astore 5
    //   4343: lload 30
    //   4345: lstore 28
    //   4347: iload 6
    //   4349: istore 9
    //   4351: iload 7
    //   4353: istore 8
    //   4355: aload_1
    //   4356: invokevirtual 272	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   4359: aload 34
    //   4361: astore 5
    //   4363: lload 30
    //   4365: lstore 28
    //   4367: iload 6
    //   4369: istore 9
    //   4371: iload 7
    //   4373: istore 8
    //   4375: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4378: ifeq +30 -> 4408
    //   4381: aload 34
    //   4383: astore 5
    //   4385: lload 30
    //   4387: lstore 28
    //   4389: iload 6
    //   4391: istore 9
    //   4393: iload 7
    //   4395: istore 8
    //   4397: ldc_w 292
    //   4400: iconst_2
    //   4401: aload_1
    //   4402: invokevirtual 273	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   4405: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4408: iload 7
    //   4410: ifeq +7 -> 4417
    //   4413: invokestatic 256	zxx:b	()I
    //   4416: pop
    //   4417: iload 6
    //   4419: ifeq +14 -> 4433
    //   4422: invokestatic 98	apqo:a	()Lapqo;
    //   4425: lload 30
    //   4427: ldc_w 292
    //   4430: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   4433: iload 4
    //   4435: istore 6
    //   4437: aload 34
    //   4439: ifnull -3409 -> 1030
    //   4442: aload 34
    //   4444: invokevirtual 339	java/io/InputStream:close	()V
    //   4447: iload 4
    //   4449: istore 6
    //   4451: goto -3421 -> 1030
    //   4454: astore_1
    //   4455: aload_1
    //   4456: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4459: iload 4
    //   4461: istore 6
    //   4463: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4466: ifeq -3436 -> 1030
    //   4469: ldc 43
    //   4471: iconst_2
    //   4472: aload_1
    //   4473: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4476: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4479: iload 4
    //   4481: istore 6
    //   4483: goto -3453 -> 1030
    //   4486: astore_1
    //   4487: ldc2_w 298
    //   4490: lstore 30
    //   4492: iconst_0
    //   4493: istore 6
    //   4495: iconst_0
    //   4496: istore 7
    //   4498: iconst_0
    //   4499: istore 4
    //   4501: aload 35
    //   4503: astore 34
    //   4505: aload 34
    //   4507: astore 5
    //   4509: lload 30
    //   4511: lstore 28
    //   4513: iload 6
    //   4515: istore 9
    //   4517: iload 7
    //   4519: istore 8
    //   4521: aload_1
    //   4522: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   4525: aload 34
    //   4527: astore 5
    //   4529: lload 30
    //   4531: lstore 28
    //   4533: iload 6
    //   4535: istore 9
    //   4537: iload 7
    //   4539: istore 8
    //   4541: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4544: ifeq +30 -> 4574
    //   4547: aload 34
    //   4549: astore 5
    //   4551: lload 30
    //   4553: lstore 28
    //   4555: iload 6
    //   4557: istore 9
    //   4559: iload 7
    //   4561: istore 8
    //   4563: ldc_w 292
    //   4566: iconst_2
    //   4567: aload_1
    //   4568: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4571: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4574: iload 7
    //   4576: ifeq +7 -> 4583
    //   4579: invokestatic 256	zxx:b	()I
    //   4582: pop
    //   4583: iload 6
    //   4585: ifeq +14 -> 4599
    //   4588: invokestatic 98	apqo:a	()Lapqo;
    //   4591: lload 30
    //   4593: ldc_w 292
    //   4596: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   4599: iload 4
    //   4601: istore 6
    //   4603: aload 34
    //   4605: ifnull -3575 -> 1030
    //   4608: aload 34
    //   4610: invokevirtual 339	java/io/InputStream:close	()V
    //   4613: iload 4
    //   4615: istore 6
    //   4617: goto -3587 -> 1030
    //   4620: astore_1
    //   4621: aload_1
    //   4622: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4625: iload 4
    //   4627: istore 6
    //   4629: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4632: ifeq -3602 -> 1030
    //   4635: ldc 43
    //   4637: iconst_2
    //   4638: aload_1
    //   4639: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4642: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4645: iload 4
    //   4647: istore 6
    //   4649: goto -3619 -> 1030
    //   4652: astore_0
    //   4653: ldc2_w 298
    //   4656: lstore 28
    //   4658: iconst_0
    //   4659: istore 6
    //   4661: iconst_0
    //   4662: istore 7
    //   4664: aconst_null
    //   4665: astore_1
    //   4666: iload 7
    //   4668: ifeq +7 -> 4675
    //   4671: invokestatic 256	zxx:b	()I
    //   4674: pop
    //   4675: iload 6
    //   4677: ifeq +14 -> 4691
    //   4680: invokestatic 98	apqo:a	()Lapqo;
    //   4683: lload 28
    //   4685: ldc_w 292
    //   4688: invokevirtual 259	apqo:a	(JLjava/lang/String;)V
    //   4691: aload_1
    //   4692: ifnull +7 -> 4699
    //   4695: aload_1
    //   4696: invokevirtual 339	java/io/InputStream:close	()V
    //   4699: aload_0
    //   4700: athrow
    //   4701: astore_1
    //   4702: aload_1
    //   4703: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4706: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4709: ifeq -10 -> 4699
    //   4712: ldc 43
    //   4714: iconst_2
    //   4715: aload_1
    //   4716: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4719: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4722: goto -23 -> 4699
    //   4725: astore_0
    //   4726: ldc2_w 298
    //   4729: lstore 28
    //   4731: iconst_0
    //   4732: istore 6
    //   4734: iconst_0
    //   4735: istore 7
    //   4737: aload 34
    //   4739: astore_1
    //   4740: goto -74 -> 4666
    //   4743: astore_0
    //   4744: iload 7
    //   4746: istore 6
    //   4748: iconst_0
    //   4749: istore 7
    //   4751: aload 34
    //   4753: astore_1
    //   4754: goto -88 -> 4666
    //   4757: astore_0
    //   4758: iconst_0
    //   4759: istore 7
    //   4761: aload 34
    //   4763: astore_1
    //   4764: goto -98 -> 4666
    //   4767: astore_0
    //   4768: iload 12
    //   4770: istore 7
    //   4772: aload 34
    //   4774: astore_1
    //   4775: goto -109 -> 4666
    //   4778: astore_0
    //   4779: iload 8
    //   4781: istore 7
    //   4783: aload 34
    //   4785: astore_1
    //   4786: goto -120 -> 4666
    //   4789: astore_0
    //   4790: goto -124 -> 4666
    //   4793: astore_0
    //   4794: aconst_null
    //   4795: astore_1
    //   4796: goto -130 -> 4666
    //   4799: astore_0
    //   4800: aconst_null
    //   4801: astore_1
    //   4802: goto -136 -> 4666
    //   4805: astore_0
    //   4806: aload 34
    //   4808: astore_1
    //   4809: goto -143 -> 4666
    //   4812: astore_0
    //   4813: aload 5
    //   4815: astore_1
    //   4816: iload 9
    //   4818: istore 6
    //   4820: iload 8
    //   4822: istore 7
    //   4824: goto -158 -> 4666
    //   4827: astore_1
    //   4828: iload 8
    //   4830: istore 6
    //   4832: iconst_0
    //   4833: istore 7
    //   4835: iconst_0
    //   4836: istore 4
    //   4838: lload 28
    //   4840: lstore 30
    //   4842: goto -337 -> 4505
    //   4845: astore_1
    //   4846: iconst_0
    //   4847: istore 7
    //   4849: iconst_0
    //   4850: istore 4
    //   4852: lload 28
    //   4854: lstore 30
    //   4856: goto -351 -> 4505
    //   4859: astore_1
    //   4860: iload 17
    //   4862: istore 7
    //   4864: iload 16
    //   4866: istore 4
    //   4868: lload 28
    //   4870: lstore 30
    //   4872: goto -367 -> 4505
    //   4875: astore_1
    //   4876: iconst_0
    //   4877: istore 7
    //   4879: aconst_null
    //   4880: astore 34
    //   4882: iconst_0
    //   4883: istore 4
    //   4885: lload 28
    //   4887: lstore 30
    //   4889: goto -384 -> 4505
    //   4892: astore_1
    //   4893: aconst_null
    //   4894: astore 34
    //   4896: iconst_0
    //   4897: istore 4
    //   4899: lload 28
    //   4901: lstore 30
    //   4903: goto -398 -> 4505
    //   4906: astore_1
    //   4907: aload 39
    //   4909: astore 34
    //   4911: iconst_0
    //   4912: istore 4
    //   4914: lload 28
    //   4916: lstore 30
    //   4918: goto -413 -> 4505
    //   4921: astore_1
    //   4922: aconst_null
    //   4923: astore 34
    //   4925: iload 13
    //   4927: istore 4
    //   4929: lload 28
    //   4931: lstore 30
    //   4933: goto -428 -> 4505
    //   4936: astore_1
    //   4937: aload 38
    //   4939: astore 34
    //   4941: iload 13
    //   4943: istore 4
    //   4945: lload 28
    //   4947: lstore 30
    //   4949: goto -444 -> 4505
    //   4952: astore_1
    //   4953: iload 12
    //   4955: istore 4
    //   4957: aload 35
    //   4959: astore 34
    //   4961: lload 28
    //   4963: lstore 30
    //   4965: goto -460 -> 4505
    //   4968: astore_1
    //   4969: aload 35
    //   4971: astore 34
    //   4973: lload 28
    //   4975: lstore 30
    //   4977: goto -472 -> 4505
    //   4980: astore_1
    //   4981: aconst_null
    //   4982: astore 34
    //   4984: lload 28
    //   4986: lstore 30
    //   4988: goto -483 -> 4505
    //   4991: astore_1
    //   4992: aload 37
    //   4994: astore 34
    //   4996: iload 9
    //   4998: istore 4
    //   5000: lload 28
    //   5002: lstore 30
    //   5004: goto -499 -> 4505
    //   5007: astore_1
    //   5008: aconst_null
    //   5009: astore 34
    //   5011: lload 28
    //   5013: lstore 30
    //   5015: goto -510 -> 4505
    //   5018: astore_1
    //   5019: aconst_null
    //   5020: astore 34
    //   5022: lload 28
    //   5024: lstore 30
    //   5026: goto -521 -> 4505
    //   5029: astore 5
    //   5031: aload_1
    //   5032: astore 34
    //   5034: aload 5
    //   5036: astore_1
    //   5037: lload 28
    //   5039: lstore 30
    //   5041: goto -536 -> 4505
    //   5044: astore_1
    //   5045: iload 9
    //   5047: istore 6
    //   5049: iconst_0
    //   5050: istore 7
    //   5052: iconst_0
    //   5053: istore 4
    //   5055: lload 28
    //   5057: lstore 30
    //   5059: goto -720 -> 4339
    //   5062: astore_1
    //   5063: iconst_0
    //   5064: istore 7
    //   5066: iconst_0
    //   5067: istore 4
    //   5069: lload 28
    //   5071: lstore 30
    //   5073: goto -734 -> 4339
    //   5076: astore_1
    //   5077: iload 13
    //   5079: istore 7
    //   5081: iload 9
    //   5083: istore 4
    //   5085: lload 28
    //   5087: lstore 30
    //   5089: goto -750 -> 4339
    //   5092: astore_1
    //   5093: iload 4
    //   5095: istore 8
    //   5097: iload 7
    //   5099: istore 4
    //   5101: lload 28
    //   5103: lstore 30
    //   5105: iload 8
    //   5107: istore 7
    //   5109: goto -770 -> 4339
    //   5112: astore_1
    //   5113: iload 4
    //   5115: istore 8
    //   5117: iload 7
    //   5119: istore 4
    //   5121: lload 28
    //   5123: lstore 30
    //   5125: iload 8
    //   5127: istore 7
    //   5129: goto -790 -> 4339
    //   5132: astore_1
    //   5133: iconst_0
    //   5134: istore 7
    //   5136: aconst_null
    //   5137: astore 34
    //   5139: iconst_0
    //   5140: istore 4
    //   5142: lload 28
    //   5144: lstore 30
    //   5146: goto -807 -> 4339
    //   5149: astore_1
    //   5150: aconst_null
    //   5151: astore 34
    //   5153: iconst_0
    //   5154: istore 4
    //   5156: lload 28
    //   5158: lstore 30
    //   5160: goto -821 -> 4339
    //   5163: astore_1
    //   5164: aload 36
    //   5166: astore 34
    //   5168: iconst_0
    //   5169: istore 4
    //   5171: lload 28
    //   5173: lstore 30
    //   5175: goto -836 -> 4339
    //   5178: astore_1
    //   5179: aconst_null
    //   5180: astore 34
    //   5182: iload 12
    //   5184: istore 4
    //   5186: lload 28
    //   5188: lstore 30
    //   5190: goto -851 -> 4339
    //   5193: astore_1
    //   5194: aload 39
    //   5196: astore 34
    //   5198: iload 12
    //   5200: istore 4
    //   5202: lload 28
    //   5204: lstore 30
    //   5206: goto -867 -> 4339
    //   5209: astore_1
    //   5210: iload 13
    //   5212: istore 4
    //   5214: lload 28
    //   5216: lstore 30
    //   5218: goto -879 -> 4339
    //   5221: astore_1
    //   5222: lload 28
    //   5224: lstore 30
    //   5226: goto -887 -> 4339
    //   5229: astore_1
    //   5230: aconst_null
    //   5231: astore 34
    //   5233: lload 28
    //   5235: lstore 30
    //   5237: goto -898 -> 4339
    //   5240: astore_1
    //   5241: aload 36
    //   5243: astore 34
    //   5245: iload 11
    //   5247: istore 4
    //   5249: lload 28
    //   5251: lstore 30
    //   5253: goto -914 -> 4339
    //   5256: astore_1
    //   5257: aconst_null
    //   5258: astore 34
    //   5260: lload 28
    //   5262: lstore 30
    //   5264: goto -925 -> 4339
    //   5267: astore_1
    //   5268: aconst_null
    //   5269: astore 34
    //   5271: lload 28
    //   5273: lstore 30
    //   5275: goto -936 -> 4339
    //   5278: astore 5
    //   5280: aload_1
    //   5281: astore 34
    //   5283: aload 5
    //   5285: astore_1
    //   5286: lload 28
    //   5288: lstore 30
    //   5290: goto -951 -> 4339
    //   5293: astore_1
    //   5294: iload 10
    //   5296: istore 6
    //   5298: iconst_0
    //   5299: istore 7
    //   5301: iconst_0
    //   5302: istore 4
    //   5304: lload 28
    //   5306: lstore 30
    //   5308: goto -1135 -> 4173
    //   5311: astore_1
    //   5312: iconst_0
    //   5313: istore 7
    //   5315: iconst_0
    //   5316: istore 4
    //   5318: lload 28
    //   5320: lstore 30
    //   5322: goto -1149 -> 4173
    //   5325: astore_1
    //   5326: iload 14
    //   5328: istore 7
    //   5330: iload 11
    //   5332: istore 4
    //   5334: lload 28
    //   5336: lstore 30
    //   5338: goto -1165 -> 4173
    //   5341: astore_1
    //   5342: iload 4
    //   5344: istore 8
    //   5346: iload 7
    //   5348: istore 4
    //   5350: lload 28
    //   5352: lstore 30
    //   5354: iload 8
    //   5356: istore 7
    //   5358: goto -1185 -> 4173
    //   5361: astore_1
    //   5362: iload 4
    //   5364: istore 8
    //   5366: iload 7
    //   5368: istore 4
    //   5370: lload 28
    //   5372: lstore 30
    //   5374: iload 8
    //   5376: istore 7
    //   5378: goto -1205 -> 4173
    //   5381: astore_1
    //   5382: iconst_0
    //   5383: istore 7
    //   5385: aconst_null
    //   5386: astore 34
    //   5388: iconst_0
    //   5389: istore 4
    //   5391: lload 28
    //   5393: lstore 30
    //   5395: goto -1222 -> 4173
    //   5398: astore_1
    //   5399: aconst_null
    //   5400: astore 34
    //   5402: iconst_0
    //   5403: istore 4
    //   5405: lload 28
    //   5407: lstore 30
    //   5409: goto -1236 -> 4173
    //   5412: astore_1
    //   5413: aload 38
    //   5415: astore 34
    //   5417: iconst_0
    //   5418: istore 4
    //   5420: lload 28
    //   5422: lstore 30
    //   5424: goto -1251 -> 4173
    //   5427: astore_1
    //   5428: aconst_null
    //   5429: astore 34
    //   5431: iload 14
    //   5433: istore 4
    //   5435: lload 28
    //   5437: lstore 30
    //   5439: goto -1266 -> 4173
    //   5442: astore_1
    //   5443: aload 36
    //   5445: astore 34
    //   5447: iload 11
    //   5449: istore 4
    //   5451: lload 28
    //   5453: lstore 30
    //   5455: goto -1282 -> 4173
    //   5458: astore_1
    //   5459: iload 11
    //   5461: istore 4
    //   5463: aload 36
    //   5465: astore 34
    //   5467: lload 28
    //   5469: lstore 30
    //   5471: goto -1298 -> 4173
    //   5474: astore_1
    //   5475: aload 36
    //   5477: astore 34
    //   5479: lload 28
    //   5481: lstore 30
    //   5483: goto -1310 -> 4173
    //   5486: astore_1
    //   5487: aconst_null
    //   5488: astore 34
    //   5490: lload 28
    //   5492: lstore 30
    //   5494: goto -1321 -> 4173
    //   5497: astore_1
    //   5498: aload 39
    //   5500: astore 34
    //   5502: iload 12
    //   5504: istore 4
    //   5506: lload 28
    //   5508: lstore 30
    //   5510: goto -1337 -> 4173
    //   5513: astore_1
    //   5514: aconst_null
    //   5515: astore 34
    //   5517: lload 28
    //   5519: lstore 30
    //   5521: goto -1348 -> 4173
    //   5524: astore_1
    //   5525: aconst_null
    //   5526: astore 34
    //   5528: lload 28
    //   5530: lstore 30
    //   5532: goto -1359 -> 4173
    //   5535: astore 5
    //   5537: aload_1
    //   5538: astore 34
    //   5540: aload 5
    //   5542: astore_1
    //   5543: lload 28
    //   5545: lstore 30
    //   5547: goto -1374 -> 4173
    //   5550: astore_1
    //   5551: iload 11
    //   5553: istore 6
    //   5555: iconst_0
    //   5556: istore 4
    //   5558: iload 12
    //   5560: istore 7
    //   5562: goto -1507 -> 4055
    //   5565: astore_1
    //   5566: iconst_0
    //   5567: istore 4
    //   5569: iload 12
    //   5571: istore 7
    //   5573: goto -1518 -> 4055
    //   5576: astore_1
    //   5577: iload 15
    //   5579: istore 7
    //   5581: iload 10
    //   5583: istore 4
    //   5585: goto -1530 -> 4055
    //   5588: astore_1
    //   5589: iload 4
    //   5591: istore 8
    //   5593: iload 7
    //   5595: istore 4
    //   5597: iload 8
    //   5599: istore 7
    //   5601: goto -1546 -> 4055
    //   5604: astore_1
    //   5605: iload 4
    //   5607: istore 8
    //   5609: iload 7
    //   5611: istore 4
    //   5613: iload 8
    //   5615: istore 7
    //   5617: goto -1562 -> 4055
    //   5620: astore_1
    //   5621: aconst_null
    //   5622: astore 34
    //   5624: iconst_0
    //   5625: istore 4
    //   5627: iload 12
    //   5629: istore 7
    //   5631: goto -1576 -> 4055
    //   5634: astore_1
    //   5635: aconst_null
    //   5636: astore 34
    //   5638: iconst_0
    //   5639: istore 4
    //   5641: goto -1586 -> 4055
    //   5644: astore_1
    //   5645: aload 37
    //   5647: astore 34
    //   5649: iconst_0
    //   5650: istore 4
    //   5652: goto -1597 -> 4055
    //   5655: astore_1
    //   5656: aconst_null
    //   5657: astore 34
    //   5659: iload 11
    //   5661: istore 4
    //   5663: goto -1608 -> 4055
    //   5666: astore_1
    //   5667: aload 37
    //   5669: astore 34
    //   5671: iload 9
    //   5673: istore 4
    //   5675: goto -1620 -> 4055
    //   5678: astore_1
    //   5679: iload 8
    //   5681: istore 4
    //   5683: aload 37
    //   5685: astore 34
    //   5687: goto -1632 -> 4055
    //   5690: astore_1
    //   5691: aload 37
    //   5693: astore 34
    //   5695: goto -1640 -> 4055
    //   5698: astore_1
    //   5699: aconst_null
    //   5700: astore 34
    //   5702: goto -1647 -> 4055
    //   5705: astore_1
    //   5706: aload 38
    //   5708: astore 34
    //   5710: iload 8
    //   5712: istore 4
    //   5714: goto -1659 -> 4055
    //   5717: astore_1
    //   5718: aconst_null
    //   5719: astore 34
    //   5721: goto -1666 -> 4055
    //   5724: astore_1
    //   5725: aconst_null
    //   5726: astore 34
    //   5728: goto -1673 -> 4055
    //   5731: astore 5
    //   5733: aload_1
    //   5734: astore 34
    //   5736: aload 5
    //   5738: astore_1
    //   5739: goto -1684 -> 4055
    //   5742: astore 35
    //   5744: aconst_null
    //   5745: astore 34
    //   5747: goto -1842 -> 3905
    //   5750: astore 35
    //   5752: aconst_null
    //   5753: astore 34
    //   5755: goto -1850 -> 3905
    //   5758: astore 35
    //   5760: aconst_null
    //   5761: astore 34
    //   5763: iload 9
    //   5765: istore 4
    //   5767: goto -2803 -> 2964
    //   5770: astore 35
    //   5772: aconst_null
    //   5773: astore 34
    //   5775: goto -2811 -> 2964
    //   5778: astore_1
    //   5779: iconst_0
    //   5780: istore 4
    //   5782: iload 8
    //   5784: istore 7
    //   5786: iload 13
    //   5788: istore 8
    //   5790: goto -4555 -> 1235
    //   5793: astore_1
    //   5794: iload 8
    //   5796: istore 7
    //   5798: iload 16
    //   5800: istore 8
    //   5802: goto -4567 -> 1235
    //   5805: astore_1
    //   5806: iload 7
    //   5808: istore 9
    //   5810: iload 8
    //   5812: istore 7
    //   5814: iload 9
    //   5816: istore 8
    //   5818: goto -4583 -> 1235
    //   5821: astore_1
    //   5822: iload 7
    //   5824: istore 9
    //   5826: iload 8
    //   5828: istore 7
    //   5830: iload 9
    //   5832: istore 8
    //   5834: goto -4599 -> 1235
    //   5837: astore_1
    //   5838: iconst_0
    //   5839: istore 7
    //   5841: iload 19
    //   5843: istore 4
    //   5845: goto -4742 -> 1103
    //   5848: astore_1
    //   5849: iload 4
    //   5851: istore 7
    //   5853: iload 17
    //   5855: istore 4
    //   5857: goto -4754 -> 1103
    //   5860: astore_1
    //   5861: iload 7
    //   5863: istore 9
    //   5865: iload 4
    //   5867: istore 7
    //   5869: iload 9
    //   5871: istore 4
    //   5873: goto -4770 -> 1103
    //   5876: astore_1
    //   5877: iload 7
    //   5879: istore 9
    //   5881: iload 4
    //   5883: istore 7
    //   5885: iload 9
    //   5887: istore 4
    //   5889: goto -4786 -> 1103
    //   5892: iload 4
    //   5894: istore 8
    //   5896: goto -3021 -> 2875
    //   5899: iload 10
    //   5901: istore 9
    //   5903: aload 36
    //   5905: astore_1
    //   5906: goto -5120 -> 786
    //   5909: goto -3439 -> 2470
    //   5912: goto -3494 -> 2418
    //   5915: goto -3445 -> 2470
    //   5918: iconst_0
    //   5919: istore 7
    //   5921: goto -4350 -> 1571
    //   5924: iload 4
    //   5926: istore 10
    //   5928: goto -4379 -> 1549
    //   5931: goto -5173 -> 758
    //   5934: iconst_0
    //   5935: istore 4
    //   5937: goto -5480 -> 457
    //   5940: iload 4
    //   5942: istore 8
    //   5944: goto -5527 -> 417
    //   5947: iconst_0
    //   5948: istore 9
    //   5950: iconst_0
    //   5951: istore 7
    //   5953: iload 4
    //   5955: istore 8
    //   5957: iload 9
    //   5959: istore 4
    //   5961: goto -5194 -> 767
    //   5964: ldc2_w 298
    //   5967: lstore 28
    //   5969: iconst_0
    //   5970: istore 6
    //   5972: iconst_0
    //   5973: istore 4
    //   5975: aload 34
    //   5977: astore_1
    //   5978: goto -4989 -> 989
    //   5981: iload 4
    //   5983: iconst_2
    //   5984: iand
    //   5985: iconst_2
    //   5986: if_icmpne -1987 -> 3999
    //   5989: iconst_1
    //   5990: istore_2
    //   5991: goto -5103 -> 888
    //   5994: aload 34
    //   5996: astore_1
    //   5997: iload 8
    //   5999: istore 9
    //   6001: goto -5215 -> 786
    //   6004: astore_1
    //   6005: iconst_0
    //   6006: istore 8
    //   6008: iload 4
    //   6010: istore 7
    //   6012: iload 8
    //   6014: istore 4
    //   6016: iload 13
    //   6018: istore 8
    //   6020: goto -4785 -> 1235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6023	0	paramUri	Uri
    //   0	6023	1	paramContext	Context
    //   0	6023	2	paramBoolean1	boolean
    //   0	6023	3	paramBoolean2	boolean
    //   0	6023	4	paramInt	int
    //   0	6023	5	paramSparseArray	SparseArray<Object>
    //   113	5858	6	i	int
    //   95	5916	7	j	int
    //   101	5918	8	k	int
    //   104	5896	9	m	int
    //   107	5820	10	n	int
    //   110	5550	11	i1	int
    //   89	5539	12	i2	int
    //   53	5964	13	i3	int
    //   59	5373	14	i4	int
    //   62	5516	15	i5	int
    //   68	5731	16	i6	int
    //   71	5783	17	i7	int
    //   65	417	18	i8	int
    //   74	5768	19	i9	int
    //   56	1721	20	i10	int
    //   92	1469	21	i11	int
    //   98	169	22	i12	int
    //   228	51	23	i13	int
    //   222	49	24	i14	int
    //   231	52	25	i15	int
    //   225	50	26	i16	int
    //   234	86	27	i17	int
    //   190	5778	28	l1	long
    //   118	5428	30	l2	long
    //   17	1044	32	l3	long
    //   83	5912	34	localObject1	Object
    //   134	2576	35	localObject2	Object
    //   2888	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2962	776	35	localObject3	Object
    //   3808	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3903	1067	35	localContext	Context
    //   5742	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5750	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5758	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5770	1	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   130	5774	36	localObject4	Object
    //   126	5566	37	localObject5	Object
    //   122	5585	38	localObject6	Object
    //   86	5413	39	localObject7	Object
    //   77	3709	40	localStringBuilder	StringBuilder
    //   80	2714	41	localObject8	Object
    //   140	2936	42	localContentResolver	android.content.ContentResolver
    //   1645	2043	43	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   336	379	1091	java/lang/OutOfMemoryError
    //   384	406	1091	java/lang/OutOfMemoryError
    //   1490	1498	1498	java/io/IOException
    //   1606	1614	2888	java/lang/OutOfMemoryError
    //   1637	1647	2888	java/lang/OutOfMemoryError
    //   1670	1676	2888	java/lang/OutOfMemoryError
    //   1699	1743	2888	java/lang/OutOfMemoryError
    //   1766	1771	2888	java/lang/OutOfMemoryError
    //   1785	1796	2888	java/lang/OutOfMemoryError
    //   1908	1916	2956	java/lang/OutOfMemoryError
    //   1955	1962	2956	java/lang/OutOfMemoryError
    //   2001	2007	2956	java/lang/OutOfMemoryError
    //   2046	2074	2956	java/lang/OutOfMemoryError
    //   2113	2118	2956	java/lang/OutOfMemoryError
    //   3075	3083	3808	java/lang/OutOfMemoryError
    //   3126	3133	3808	java/lang/OutOfMemoryError
    //   3176	3182	3808	java/lang/OutOfMemoryError
    //   3225	3253	3808	java/lang/OutOfMemoryError
    //   3296	3301	3808	java/lang/OutOfMemoryError
    //   3343	3352	3808	java/lang/OutOfMemoryError
    //   3379	3395	3808	java/lang/OutOfMemoryError
    //   3422	3431	3808	java/lang/OutOfMemoryError
    //   3458	3470	3808	java/lang/OutOfMemoryError
    //   3497	3517	3808	java/lang/OutOfMemoryError
    //   3554	3574	3808	java/lang/OutOfMemoryError
    //   3601	3613	3808	java/lang/OutOfMemoryError
    //   3640	3660	3808	java/lang/OutOfMemoryError
    //   3687	3692	3808	java/lang/OutOfMemoryError
    //   3723	3729	3808	java/lang/OutOfMemoryError
    //   3756	3797	3808	java/lang/OutOfMemoryError
    //   2538	2546	3897	java/lang/OutOfMemoryError
    //   2585	2595	3897	java/lang/OutOfMemoryError
    //   2634	2640	3897	java/lang/OutOfMemoryError
    //   2679	2707	3897	java/lang/OutOfMemoryError
    //   2746	2751	3897	java/lang/OutOfMemoryError
    //   1022	1026	4004	java/io/IOException
    //   136	142	4036	java/io/IOException
    //   158	166	4036	java/io/IOException
    //   187	192	4036	java/io/IOException
    //   4110	4115	4122	java/io/IOException
    //   136	142	4154	java/lang/RuntimeException
    //   158	166	4154	java/lang/RuntimeException
    //   187	192	4154	java/lang/RuntimeException
    //   4276	4281	4288	java/io/IOException
    //   136	142	4320	java/lang/UnsatisfiedLinkError
    //   158	166	4320	java/lang/UnsatisfiedLinkError
    //   187	192	4320	java/lang/UnsatisfiedLinkError
    //   4442	4447	4454	java/io/IOException
    //   136	142	4486	java/lang/Throwable
    //   158	166	4486	java/lang/Throwable
    //   187	192	4486	java/lang/Throwable
    //   4608	4613	4620	java/io/IOException
    //   136	142	4652	finally
    //   158	166	4652	finally
    //   4695	4699	4701	java/io/IOException
    //   187	192	4725	finally
    //   204	218	4743	finally
    //   260	266	4743	finally
    //   286	319	4743	finally
    //   323	332	4757	finally
    //   336	379	4757	finally
    //   384	406	4757	finally
    //   417	442	4757	finally
    //   450	454	4757	finally
    //   1382	1411	4757	finally
    //   485	501	4767	finally
    //   505	511	4767	finally
    //   515	556	4767	finally
    //   560	568	4767	finally
    //   572	583	4767	finally
    //   605	611	4767	finally
    //   615	621	4767	finally
    //   630	646	4767	finally
    //   689	695	4767	finally
    //   731	758	4767	finally
    //   762	767	4767	finally
    //   1139	1143	4767	finally
    //   1179	1185	4767	finally
    //   1221	1232	4767	finally
    //   1271	1275	4767	finally
    //   1311	1317	4767	finally
    //   1353	1364	4767	finally
    //   821	830	4778	finally
    //   837	846	4778	finally
    //   853	861	4778	finally
    //   868	885	4778	finally
    //   904	915	4778	finally
    //   922	928	4778	finally
    //   935	989	4778	finally
    //   1426	1433	4778	finally
    //   1440	1447	4778	finally
    //   1532	1542	4778	finally
    //   1564	1568	4778	finally
    //   1574	1590	4789	finally
    //   1593	1599	4789	finally
    //   1606	1614	4789	finally
    //   1637	1647	4789	finally
    //   1670	1676	4789	finally
    //   1699	1743	4789	finally
    //   1766	1771	4789	finally
    //   1785	1796	4789	finally
    //   1830	1839	4789	finally
    //   1908	1916	4789	finally
    //   1955	1962	4789	finally
    //   2001	2007	4789	finally
    //   2046	2074	4789	finally
    //   2113	2118	4789	finally
    //   2482	2491	4789	finally
    //   2499	2508	4789	finally
    //   2519	2535	4789	finally
    //   2538	2546	4789	finally
    //   2585	2595	4789	finally
    //   2634	2640	4789	finally
    //   2679	2707	4789	finally
    //   2746	2751	4789	finally
    //   2909	2914	4789	finally
    //   2933	2938	4789	finally
    //   2999	3004	4789	finally
    //   3039	3044	4789	finally
    //   3075	3083	4789	finally
    //   3126	3133	4789	finally
    //   3176	3182	4789	finally
    //   3225	3253	4789	finally
    //   3296	3301	4789	finally
    //   3343	3352	4789	finally
    //   3379	3395	4789	finally
    //   3422	3431	4789	finally
    //   3458	3470	4789	finally
    //   3497	3517	4789	finally
    //   3554	3574	4789	finally
    //   3601	3613	4789	finally
    //   3640	3660	4789	finally
    //   3687	3692	4789	finally
    //   3723	3729	4789	finally
    //   3756	3797	4789	finally
    //   3845	3850	4789	finally
    //   3885	3890	4789	finally
    //   3940	3945	4789	finally
    //   3980	3985	4789	finally
    //   2155	2164	4793	finally
    //   2184	2200	4793	finally
    //   2220	2228	4793	finally
    //   2248	2259	4793	finally
    //   2279	2298	4793	finally
    //   2324	2344	4793	finally
    //   2364	2375	4793	finally
    //   2395	2411	4793	finally
    //   2418	2470	4793	finally
    //   2756	2813	4799	finally
    //   2824	2871	4799	finally
    //   4055	4076	4805	finally
    //   4189	4193	4812	finally
    //   4209	4215	4812	finally
    //   4231	4242	4812	finally
    //   4355	4359	4812	finally
    //   4375	4381	4812	finally
    //   4397	4408	4812	finally
    //   4521	4525	4812	finally
    //   4541	4547	4812	finally
    //   4563	4574	4812	finally
    //   204	218	4827	java/lang/Throwable
    //   260	266	4827	java/lang/Throwable
    //   286	319	4827	java/lang/Throwable
    //   323	332	4845	java/lang/Throwable
    //   1382	1411	4845	java/lang/Throwable
    //   1139	1143	4859	java/lang/Throwable
    //   1179	1185	4859	java/lang/Throwable
    //   1221	1232	4859	java/lang/Throwable
    //   1271	1275	4859	java/lang/Throwable
    //   1311	1317	4859	java/lang/Throwable
    //   1353	1364	4859	java/lang/Throwable
    //   1426	1433	4875	java/lang/Throwable
    //   1440	1447	4875	java/lang/Throwable
    //   1532	1542	4875	java/lang/Throwable
    //   1564	1568	4875	java/lang/Throwable
    //   1574	1590	4892	java/lang/Throwable
    //   1593	1599	4892	java/lang/Throwable
    //   1606	1614	4892	java/lang/Throwable
    //   1785	1796	4892	java/lang/Throwable
    //   1637	1647	4906	java/lang/Throwable
    //   1670	1676	4906	java/lang/Throwable
    //   1699	1743	4906	java/lang/Throwable
    //   1766	1771	4906	java/lang/Throwable
    //   2909	2914	4906	java/lang/Throwable
    //   2933	2938	4906	java/lang/Throwable
    //   1830	1839	4921	java/lang/Throwable
    //   1908	1916	4921	java/lang/Throwable
    //   3075	3083	4921	java/lang/Throwable
    //   3343	3352	4921	java/lang/Throwable
    //   3379	3395	4921	java/lang/Throwable
    //   3422	3431	4921	java/lang/Throwable
    //   3458	3470	4921	java/lang/Throwable
    //   3497	3517	4921	java/lang/Throwable
    //   3554	3574	4921	java/lang/Throwable
    //   3601	3613	4921	java/lang/Throwable
    //   3640	3660	4921	java/lang/Throwable
    //   3687	3692	4921	java/lang/Throwable
    //   3723	3729	4921	java/lang/Throwable
    //   3756	3797	4921	java/lang/Throwable
    //   1955	1962	4936	java/lang/Throwable
    //   2001	2007	4936	java/lang/Throwable
    //   2046	2074	4936	java/lang/Throwable
    //   2113	2118	4936	java/lang/Throwable
    //   2999	3004	4936	java/lang/Throwable
    //   3039	3044	4936	java/lang/Throwable
    //   3126	3133	4936	java/lang/Throwable
    //   3176	3182	4936	java/lang/Throwable
    //   3225	3253	4936	java/lang/Throwable
    //   3296	3301	4936	java/lang/Throwable
    //   3845	3850	4936	java/lang/Throwable
    //   3885	3890	4936	java/lang/Throwable
    //   2155	2164	4952	java/lang/Throwable
    //   2184	2200	4952	java/lang/Throwable
    //   2220	2228	4952	java/lang/Throwable
    //   2248	2259	4952	java/lang/Throwable
    //   2279	2298	4952	java/lang/Throwable
    //   2324	2344	4952	java/lang/Throwable
    //   2364	2375	4952	java/lang/Throwable
    //   2395	2411	4952	java/lang/Throwable
    //   2418	2470	4968	java/lang/Throwable
    //   2482	2491	4980	java/lang/Throwable
    //   2499	2508	4980	java/lang/Throwable
    //   2519	2535	4980	java/lang/Throwable
    //   2538	2546	4980	java/lang/Throwable
    //   2585	2595	4991	java/lang/Throwable
    //   2634	2640	4991	java/lang/Throwable
    //   2679	2707	4991	java/lang/Throwable
    //   2746	2751	4991	java/lang/Throwable
    //   3940	3945	4991	java/lang/Throwable
    //   3980	3985	4991	java/lang/Throwable
    //   2756	2813	5007	java/lang/Throwable
    //   2824	2871	5018	java/lang/Throwable
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
    //   1382	1411	5062	java/lang/UnsatisfiedLinkError
    //   485	501	5076	java/lang/UnsatisfiedLinkError
    //   689	695	5076	java/lang/UnsatisfiedLinkError
    //   731	758	5076	java/lang/UnsatisfiedLinkError
    //   1139	1143	5076	java/lang/UnsatisfiedLinkError
    //   1179	1185	5076	java/lang/UnsatisfiedLinkError
    //   1221	1232	5076	java/lang/UnsatisfiedLinkError
    //   1271	1275	5076	java/lang/UnsatisfiedLinkError
    //   1311	1317	5076	java/lang/UnsatisfiedLinkError
    //   1353	1364	5076	java/lang/UnsatisfiedLinkError
    //   505	511	5092	java/lang/UnsatisfiedLinkError
    //   515	556	5092	java/lang/UnsatisfiedLinkError
    //   560	568	5092	java/lang/UnsatisfiedLinkError
    //   572	583	5092	java/lang/UnsatisfiedLinkError
    //   605	611	5092	java/lang/UnsatisfiedLinkError
    //   615	621	5092	java/lang/UnsatisfiedLinkError
    //   630	646	5092	java/lang/UnsatisfiedLinkError
    //   762	767	5112	java/lang/UnsatisfiedLinkError
    //   1426	1433	5132	java/lang/UnsatisfiedLinkError
    //   1440	1447	5132	java/lang/UnsatisfiedLinkError
    //   1532	1542	5132	java/lang/UnsatisfiedLinkError
    //   1564	1568	5132	java/lang/UnsatisfiedLinkError
    //   1574	1590	5149	java/lang/UnsatisfiedLinkError
    //   1593	1599	5149	java/lang/UnsatisfiedLinkError
    //   1606	1614	5149	java/lang/UnsatisfiedLinkError
    //   1785	1796	5149	java/lang/UnsatisfiedLinkError
    //   1637	1647	5163	java/lang/UnsatisfiedLinkError
    //   1670	1676	5163	java/lang/UnsatisfiedLinkError
    //   1699	1743	5163	java/lang/UnsatisfiedLinkError
    //   1766	1771	5163	java/lang/UnsatisfiedLinkError
    //   2909	2914	5163	java/lang/UnsatisfiedLinkError
    //   2933	2938	5163	java/lang/UnsatisfiedLinkError
    //   1830	1839	5178	java/lang/UnsatisfiedLinkError
    //   1908	1916	5178	java/lang/UnsatisfiedLinkError
    //   3075	3083	5178	java/lang/UnsatisfiedLinkError
    //   3343	3352	5178	java/lang/UnsatisfiedLinkError
    //   3379	3395	5178	java/lang/UnsatisfiedLinkError
    //   3422	3431	5178	java/lang/UnsatisfiedLinkError
    //   3458	3470	5178	java/lang/UnsatisfiedLinkError
    //   3497	3517	5178	java/lang/UnsatisfiedLinkError
    //   3554	3574	5178	java/lang/UnsatisfiedLinkError
    //   3601	3613	5178	java/lang/UnsatisfiedLinkError
    //   3640	3660	5178	java/lang/UnsatisfiedLinkError
    //   3687	3692	5178	java/lang/UnsatisfiedLinkError
    //   3723	3729	5178	java/lang/UnsatisfiedLinkError
    //   3756	3797	5178	java/lang/UnsatisfiedLinkError
    //   1955	1962	5193	java/lang/UnsatisfiedLinkError
    //   2001	2007	5193	java/lang/UnsatisfiedLinkError
    //   2046	2074	5193	java/lang/UnsatisfiedLinkError
    //   2113	2118	5193	java/lang/UnsatisfiedLinkError
    //   2999	3004	5193	java/lang/UnsatisfiedLinkError
    //   3039	3044	5193	java/lang/UnsatisfiedLinkError
    //   3126	3133	5193	java/lang/UnsatisfiedLinkError
    //   3176	3182	5193	java/lang/UnsatisfiedLinkError
    //   3225	3253	5193	java/lang/UnsatisfiedLinkError
    //   3296	3301	5193	java/lang/UnsatisfiedLinkError
    //   3845	3850	5193	java/lang/UnsatisfiedLinkError
    //   3885	3890	5193	java/lang/UnsatisfiedLinkError
    //   2155	2164	5209	java/lang/UnsatisfiedLinkError
    //   2184	2200	5209	java/lang/UnsatisfiedLinkError
    //   2220	2228	5209	java/lang/UnsatisfiedLinkError
    //   2248	2259	5209	java/lang/UnsatisfiedLinkError
    //   2279	2298	5209	java/lang/UnsatisfiedLinkError
    //   2324	2344	5209	java/lang/UnsatisfiedLinkError
    //   2364	2375	5209	java/lang/UnsatisfiedLinkError
    //   2395	2411	5209	java/lang/UnsatisfiedLinkError
    //   2418	2470	5221	java/lang/UnsatisfiedLinkError
    //   2482	2491	5229	java/lang/UnsatisfiedLinkError
    //   2499	2508	5229	java/lang/UnsatisfiedLinkError
    //   2519	2535	5229	java/lang/UnsatisfiedLinkError
    //   2538	2546	5229	java/lang/UnsatisfiedLinkError
    //   2585	2595	5240	java/lang/UnsatisfiedLinkError
    //   2634	2640	5240	java/lang/UnsatisfiedLinkError
    //   2679	2707	5240	java/lang/UnsatisfiedLinkError
    //   2746	2751	5240	java/lang/UnsatisfiedLinkError
    //   3940	3945	5240	java/lang/UnsatisfiedLinkError
    //   3980	3985	5240	java/lang/UnsatisfiedLinkError
    //   2756	2813	5256	java/lang/UnsatisfiedLinkError
    //   2824	2871	5267	java/lang/UnsatisfiedLinkError
    //   821	830	5278	java/lang/UnsatisfiedLinkError
    //   837	846	5278	java/lang/UnsatisfiedLinkError
    //   853	861	5278	java/lang/UnsatisfiedLinkError
    //   868	885	5278	java/lang/UnsatisfiedLinkError
    //   904	915	5278	java/lang/UnsatisfiedLinkError
    //   922	928	5278	java/lang/UnsatisfiedLinkError
    //   935	989	5278	java/lang/UnsatisfiedLinkError
    //   204	218	5293	java/lang/RuntimeException
    //   260	266	5293	java/lang/RuntimeException
    //   286	319	5293	java/lang/RuntimeException
    //   323	332	5311	java/lang/RuntimeException
    //   336	379	5311	java/lang/RuntimeException
    //   384	406	5311	java/lang/RuntimeException
    //   417	442	5311	java/lang/RuntimeException
    //   450	454	5311	java/lang/RuntimeException
    //   1382	1411	5311	java/lang/RuntimeException
    //   485	501	5325	java/lang/RuntimeException
    //   689	695	5325	java/lang/RuntimeException
    //   731	758	5325	java/lang/RuntimeException
    //   1139	1143	5325	java/lang/RuntimeException
    //   1179	1185	5325	java/lang/RuntimeException
    //   1221	1232	5325	java/lang/RuntimeException
    //   1271	1275	5325	java/lang/RuntimeException
    //   1311	1317	5325	java/lang/RuntimeException
    //   1353	1364	5325	java/lang/RuntimeException
    //   505	511	5341	java/lang/RuntimeException
    //   515	556	5341	java/lang/RuntimeException
    //   560	568	5341	java/lang/RuntimeException
    //   572	583	5341	java/lang/RuntimeException
    //   605	611	5341	java/lang/RuntimeException
    //   615	621	5341	java/lang/RuntimeException
    //   630	646	5341	java/lang/RuntimeException
    //   762	767	5361	java/lang/RuntimeException
    //   1426	1433	5381	java/lang/RuntimeException
    //   1440	1447	5381	java/lang/RuntimeException
    //   1532	1542	5381	java/lang/RuntimeException
    //   1564	1568	5381	java/lang/RuntimeException
    //   1574	1590	5398	java/lang/RuntimeException
    //   1593	1599	5398	java/lang/RuntimeException
    //   1606	1614	5398	java/lang/RuntimeException
    //   1785	1796	5398	java/lang/RuntimeException
    //   1637	1647	5412	java/lang/RuntimeException
    //   1670	1676	5412	java/lang/RuntimeException
    //   1699	1743	5412	java/lang/RuntimeException
    //   1766	1771	5412	java/lang/RuntimeException
    //   2909	2914	5412	java/lang/RuntimeException
    //   2933	2938	5412	java/lang/RuntimeException
    //   1830	1839	5427	java/lang/RuntimeException
    //   1908	1916	5427	java/lang/RuntimeException
    //   3075	3083	5427	java/lang/RuntimeException
    //   3343	3352	5427	java/lang/RuntimeException
    //   3379	3395	5427	java/lang/RuntimeException
    //   3422	3431	5427	java/lang/RuntimeException
    //   3458	3470	5427	java/lang/RuntimeException
    //   3497	3517	5427	java/lang/RuntimeException
    //   3554	3574	5427	java/lang/RuntimeException
    //   3601	3613	5427	java/lang/RuntimeException
    //   3640	3660	5427	java/lang/RuntimeException
    //   3687	3692	5427	java/lang/RuntimeException
    //   3723	3729	5427	java/lang/RuntimeException
    //   3756	3797	5427	java/lang/RuntimeException
    //   1955	1962	5442	java/lang/RuntimeException
    //   2001	2007	5442	java/lang/RuntimeException
    //   2046	2074	5442	java/lang/RuntimeException
    //   2113	2118	5442	java/lang/RuntimeException
    //   2999	3004	5442	java/lang/RuntimeException
    //   3039	3044	5442	java/lang/RuntimeException
    //   3126	3133	5442	java/lang/RuntimeException
    //   3176	3182	5442	java/lang/RuntimeException
    //   3225	3253	5442	java/lang/RuntimeException
    //   3296	3301	5442	java/lang/RuntimeException
    //   3845	3850	5442	java/lang/RuntimeException
    //   3885	3890	5442	java/lang/RuntimeException
    //   2155	2164	5458	java/lang/RuntimeException
    //   2184	2200	5458	java/lang/RuntimeException
    //   2220	2228	5458	java/lang/RuntimeException
    //   2248	2259	5458	java/lang/RuntimeException
    //   2279	2298	5458	java/lang/RuntimeException
    //   2324	2344	5458	java/lang/RuntimeException
    //   2364	2375	5458	java/lang/RuntimeException
    //   2395	2411	5458	java/lang/RuntimeException
    //   2418	2470	5474	java/lang/RuntimeException
    //   2482	2491	5486	java/lang/RuntimeException
    //   2499	2508	5486	java/lang/RuntimeException
    //   2519	2535	5486	java/lang/RuntimeException
    //   2538	2546	5486	java/lang/RuntimeException
    //   2585	2595	5497	java/lang/RuntimeException
    //   2634	2640	5497	java/lang/RuntimeException
    //   2679	2707	5497	java/lang/RuntimeException
    //   2746	2751	5497	java/lang/RuntimeException
    //   3940	3945	5497	java/lang/RuntimeException
    //   3980	3985	5497	java/lang/RuntimeException
    //   2756	2813	5513	java/lang/RuntimeException
    //   2824	2871	5524	java/lang/RuntimeException
    //   821	830	5535	java/lang/RuntimeException
    //   837	846	5535	java/lang/RuntimeException
    //   853	861	5535	java/lang/RuntimeException
    //   868	885	5535	java/lang/RuntimeException
    //   904	915	5535	java/lang/RuntimeException
    //   922	928	5535	java/lang/RuntimeException
    //   935	989	5535	java/lang/RuntimeException
    //   204	218	5550	java/io/IOException
    //   260	266	5550	java/io/IOException
    //   286	319	5550	java/io/IOException
    //   323	332	5565	java/io/IOException
    //   336	379	5565	java/io/IOException
    //   384	406	5565	java/io/IOException
    //   417	442	5565	java/io/IOException
    //   450	454	5565	java/io/IOException
    //   1382	1411	5565	java/io/IOException
    //   485	501	5576	java/io/IOException
    //   689	695	5576	java/io/IOException
    //   731	758	5576	java/io/IOException
    //   1139	1143	5576	java/io/IOException
    //   1179	1185	5576	java/io/IOException
    //   1221	1232	5576	java/io/IOException
    //   1271	1275	5576	java/io/IOException
    //   1311	1317	5576	java/io/IOException
    //   1353	1364	5576	java/io/IOException
    //   505	511	5588	java/io/IOException
    //   515	556	5588	java/io/IOException
    //   560	568	5588	java/io/IOException
    //   572	583	5588	java/io/IOException
    //   605	611	5588	java/io/IOException
    //   615	621	5588	java/io/IOException
    //   630	646	5588	java/io/IOException
    //   762	767	5604	java/io/IOException
    //   1426	1433	5620	java/io/IOException
    //   1440	1447	5620	java/io/IOException
    //   1532	1542	5620	java/io/IOException
    //   1564	1568	5620	java/io/IOException
    //   1574	1590	5634	java/io/IOException
    //   1593	1599	5634	java/io/IOException
    //   1606	1614	5634	java/io/IOException
    //   1785	1796	5634	java/io/IOException
    //   1637	1647	5644	java/io/IOException
    //   1670	1676	5644	java/io/IOException
    //   1699	1743	5644	java/io/IOException
    //   1766	1771	5644	java/io/IOException
    //   2909	2914	5644	java/io/IOException
    //   2933	2938	5644	java/io/IOException
    //   1830	1839	5655	java/io/IOException
    //   1908	1916	5655	java/io/IOException
    //   3075	3083	5655	java/io/IOException
    //   3343	3352	5655	java/io/IOException
    //   3379	3395	5655	java/io/IOException
    //   3422	3431	5655	java/io/IOException
    //   3458	3470	5655	java/io/IOException
    //   3497	3517	5655	java/io/IOException
    //   3554	3574	5655	java/io/IOException
    //   3601	3613	5655	java/io/IOException
    //   3640	3660	5655	java/io/IOException
    //   3687	3692	5655	java/io/IOException
    //   3723	3729	5655	java/io/IOException
    //   3756	3797	5655	java/io/IOException
    //   1955	1962	5666	java/io/IOException
    //   2001	2007	5666	java/io/IOException
    //   2046	2074	5666	java/io/IOException
    //   2113	2118	5666	java/io/IOException
    //   2999	3004	5666	java/io/IOException
    //   3039	3044	5666	java/io/IOException
    //   3126	3133	5666	java/io/IOException
    //   3176	3182	5666	java/io/IOException
    //   3225	3253	5666	java/io/IOException
    //   3296	3301	5666	java/io/IOException
    //   3845	3850	5666	java/io/IOException
    //   3885	3890	5666	java/io/IOException
    //   2155	2164	5678	java/io/IOException
    //   2184	2200	5678	java/io/IOException
    //   2220	2228	5678	java/io/IOException
    //   2248	2259	5678	java/io/IOException
    //   2279	2298	5678	java/io/IOException
    //   2324	2344	5678	java/io/IOException
    //   2364	2375	5678	java/io/IOException
    //   2395	2411	5678	java/io/IOException
    //   2418	2470	5690	java/io/IOException
    //   2482	2491	5698	java/io/IOException
    //   2499	2508	5698	java/io/IOException
    //   2519	2535	5698	java/io/IOException
    //   2538	2546	5698	java/io/IOException
    //   2585	2595	5705	java/io/IOException
    //   2634	2640	5705	java/io/IOException
    //   2679	2707	5705	java/io/IOException
    //   2746	2751	5705	java/io/IOException
    //   3940	3945	5705	java/io/IOException
    //   3980	3985	5705	java/io/IOException
    //   2756	2813	5717	java/io/IOException
    //   2824	2871	5724	java/io/IOException
    //   821	830	5731	java/io/IOException
    //   837	846	5731	java/io/IOException
    //   853	861	5731	java/io/IOException
    //   868	885	5731	java/io/IOException
    //   904	915	5731	java/io/IOException
    //   922	928	5731	java/io/IOException
    //   935	989	5731	java/io/IOException
    //   2756	2813	5742	java/lang/OutOfMemoryError
    //   2824	2871	5750	java/lang/OutOfMemoryError
    //   2155	2164	5758	java/lang/OutOfMemoryError
    //   2184	2200	5758	java/lang/OutOfMemoryError
    //   2220	2228	5758	java/lang/OutOfMemoryError
    //   2248	2259	5758	java/lang/OutOfMemoryError
    //   2279	2298	5758	java/lang/OutOfMemoryError
    //   2324	2344	5758	java/lang/OutOfMemoryError
    //   2364	2375	5758	java/lang/OutOfMemoryError
    //   2395	2411	5758	java/lang/OutOfMemoryError
    //   2418	2470	5770	java/lang/OutOfMemoryError
    //   417	442	5778	java/lang/Throwable
    //   450	454	5778	java/lang/Throwable
    //   485	501	5793	java/lang/Throwable
    //   689	695	5793	java/lang/Throwable
    //   731	758	5793	java/lang/Throwable
    //   505	511	5805	java/lang/Throwable
    //   515	556	5805	java/lang/Throwable
    //   560	568	5805	java/lang/Throwable
    //   572	583	5805	java/lang/Throwable
    //   605	611	5805	java/lang/Throwable
    //   615	621	5805	java/lang/Throwable
    //   630	646	5805	java/lang/Throwable
    //   762	767	5821	java/lang/Throwable
    //   417	442	5837	java/lang/OutOfMemoryError
    //   450	454	5837	java/lang/OutOfMemoryError
    //   485	501	5848	java/lang/OutOfMemoryError
    //   689	695	5848	java/lang/OutOfMemoryError
    //   731	758	5848	java/lang/OutOfMemoryError
    //   505	511	5860	java/lang/OutOfMemoryError
    //   515	556	5860	java/lang/OutOfMemoryError
    //   560	568	5860	java/lang/OutOfMemoryError
    //   572	583	5860	java/lang/OutOfMemoryError
    //   605	611	5860	java/lang/OutOfMemoryError
    //   615	621	5860	java/lang/OutOfMemoryError
    //   630	646	5860	java/lang/OutOfMemoryError
    //   762	767	5876	java/lang/OutOfMemoryError
    //   336	379	6004	java/lang/Throwable
    //   384	406	6004	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bked.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bked.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = apqo.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (apqo.a(paramArrayOfInt))
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
    //   14: invokestatic 92	java/lang/System:currentTimeMillis	()J
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
    //   38: ldc_w 417
    //   41: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_3
    //   45: invokevirtual 297	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: astore 32
    //   57: aconst_null
    //   58: astore 35
    //   60: aconst_null
    //   61: astore 33
    //   63: aconst_null
    //   64: astore 34
    //   66: aconst_null
    //   67: astore 36
    //   69: iconst_0
    //   70: istore 16
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 21
    //   78: iconst_0
    //   79: istore 15
    //   81: iconst_0
    //   82: istore 17
    //   84: iconst_0
    //   85: istore 18
    //   87: iconst_0
    //   88: istore 6
    //   90: iconst_0
    //   91: istore 20
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 13
    //   99: iconst_0
    //   100: istore 14
    //   102: iconst_0
    //   103: istore 19
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 36
    //   110: astore 27
    //   112: iload 21
    //   114: istore 10
    //   116: aload 32
    //   118: astore 30
    //   120: iload 15
    //   122: istore 12
    //   124: aload 35
    //   126: astore 31
    //   128: iload 17
    //   130: istore 11
    //   132: aload 33
    //   134: astore 29
    //   136: iload 18
    //   138: istore 9
    //   140: aload 34
    //   142: astore 28
    //   144: iload 6
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 36
    //   156: astore 27
    //   158: iload 21
    //   160: istore 10
    //   162: aload 32
    //   164: astore 30
    //   166: iload 15
    //   168: istore 12
    //   170: aload 35
    //   172: astore 31
    //   174: iload 17
    //   176: istore 11
    //   178: aload 33
    //   180: astore 29
    //   182: iload 18
    //   184: istore 9
    //   186: aload 34
    //   188: astore 28
    //   190: iload 6
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4029 -> 4231
    //   205: iload_3
    //   206: ifeq +802 -> 1008
    //   209: iload 20
    //   211: istore 9
    //   213: iload 13
    //   215: istore 10
    //   217: iload 14
    //   219: istore 8
    //   221: iload 19
    //   223: istore 11
    //   225: aload_0
    //   226: invokevirtual 316	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 322	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore 27
    //   234: iload 20
    //   236: istore 9
    //   238: iload 13
    //   240: istore 10
    //   242: iload 14
    //   244: istore 8
    //   246: iload 19
    //   248: istore 11
    //   250: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   253: ifeq +46 -> 299
    //   256: iload 20
    //   258: istore 9
    //   260: iload 13
    //   262: istore 10
    //   264: iload 14
    //   266: istore 8
    //   268: iload 19
    //   270: istore 11
    //   272: ldc 43
    //   274: iconst_4
    //   275: new 45	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 324
    //   285: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 27
    //   290: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 27
    //   301: ifnull +3921 -> 4222
    //   304: iload 20
    //   306: istore 9
    //   308: iload 13
    //   310: istore 10
    //   312: iload 14
    //   314: istore 8
    //   316: iload 19
    //   318: istore 11
    //   320: aload 27
    //   322: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   325: istore 12
    //   327: iload 20
    //   329: istore 9
    //   331: iload 13
    //   333: istore 10
    //   335: iload 14
    //   337: istore 8
    //   339: iload 19
    //   341: istore 11
    //   343: aload 27
    //   345: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   348: istore 6
    //   350: iload 20
    //   352: istore 9
    //   354: iload 13
    //   356: istore 10
    //   358: iload 14
    //   360: istore 8
    //   362: iload 19
    //   364: istore 11
    //   366: iload 12
    //   368: iload 6
    //   370: invokestatic 201	bked:a	(II)Z
    //   373: istore_3
    //   374: iload_3
    //   375: ifne +44 -> 419
    //   378: aconst_null
    //   379: astore_0
    //   380: aload_0
    //   381: astore 27
    //   383: aload_1
    //   384: ifnull -373 -> 11
    //   387: aload_1
    //   388: invokevirtual 339	java/io/InputStream:close	()V
    //   391: aconst_null
    //   392: areturn
    //   393: astore_1
    //   394: aload_1
    //   395: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   398: aload_0
    //   399: astore 27
    //   401: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq -393 -> 11
    //   407: ldc 43
    //   409: iconst_2
    //   410: aload_1
    //   411: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   414: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aconst_null
    //   418: areturn
    //   419: iload 20
    //   421: istore 9
    //   423: iload 13
    //   425: istore 10
    //   427: iload 14
    //   429: istore 8
    //   431: iload 19
    //   433: istore 11
    //   435: iload 12
    //   437: iload 6
    //   439: imul
    //   440: newarray int
    //   442: astore_0
    //   443: iload 20
    //   445: istore 9
    //   447: iload 13
    //   449: istore 10
    //   451: iload 14
    //   453: istore 8
    //   455: iload 19
    //   457: istore 11
    //   459: aload 27
    //   461: aload_0
    //   462: iconst_0
    //   463: iload 12
    //   465: iconst_0
    //   466: iconst_0
    //   467: iload 12
    //   469: iload 6
    //   471: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   474: iload 20
    //   476: istore 9
    //   478: iload 13
    //   480: istore 10
    //   482: iload 14
    //   484: istore 8
    //   486: iload 19
    //   488: istore 11
    //   490: aload 27
    //   492: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   495: iload 20
    //   497: istore 9
    //   499: iload 13
    //   501: istore 10
    //   503: iload 14
    //   505: istore 8
    //   507: iload 19
    //   509: istore 11
    //   511: invokestatic 203	zxx:a	()I
    //   514: pop
    //   515: iconst_1
    //   516: istore 9
    //   518: aload_0
    //   519: aconst_null
    //   520: iload 12
    //   522: iload 6
    //   524: invokestatic 419	zxx:a	([I[BII)I
    //   527: istore 6
    //   529: iload 9
    //   531: istore 8
    //   533: iload 6
    //   535: istore 7
    //   537: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   540: ifeq +38 -> 578
    //   543: ldc 43
    //   545: iconst_4
    //   546: new 45	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 421
    //   556: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload 6
    //   561: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: iload 6
    //   572: istore 7
    //   574: iload 9
    //   576: istore 8
    //   578: iload 8
    //   580: istore 6
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
    //   599: istore 10
    //   601: aload_0
    //   602: astore 30
    //   604: iload 6
    //   606: istore 12
    //   608: aload_0
    //   609: astore 31
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
    //   629: new 45	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   636: astore 32
    //   638: aload_0
    //   639: astore 27
    //   641: iload 6
    //   643: istore 10
    //   645: aload_0
    //   646: astore 30
    //   648: iload 6
    //   650: istore 12
    //   652: aload_0
    //   653: astore 31
    //   655: iload 6
    //   657: istore 11
    //   659: aload_0
    //   660: astore 29
    //   662: iload 6
    //   664: istore 9
    //   666: aload_0
    //   667: astore 28
    //   669: iload 6
    //   671: istore 8
    //   673: new 45	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   680: astore_1
    //   681: aload_0
    //   682: astore 27
    //   684: iload 6
    //   686: istore 10
    //   688: aload_0
    //   689: astore 30
    //   691: iload 6
    //   693: istore 12
    //   695: aload_0
    //   696: astore 31
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
    //   716: aload 32
    //   718: aload_1
    //   719: invokestatic 241	bked:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   722: pop
    //   723: aload_0
    //   724: astore 27
    //   726: iload 6
    //   728: istore 10
    //   730: aload_0
    //   731: astore 30
    //   733: iload 6
    //   735: istore 12
    //   737: aload_0
    //   738: astore 31
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
    //   758: new 243	android/util/Pair
    //   761: dup
    //   762: aload_1
    //   763: aload 32
    //   765: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   768: astore_1
    //   769: aload_0
    //   770: astore 27
    //   772: iload 6
    //   774: ifeq +7 -> 781
    //   777: invokestatic 256	zxx:b	()I
    //   780: pop
    //   781: aload_1
    //   782: astore_0
    //   783: aload 27
    //   785: ifnull +10 -> 795
    //   788: aload 27
    //   790: invokevirtual 339	java/io/InputStream:close	()V
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
    //   814: ldc_w 423
    //   817: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   823: lload 25
    //   825: lsub
    //   826: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload_0
    //   836: areturn
    //   837: astore_0
    //   838: iload 16
    //   840: istore 6
    //   842: iload 6
    //   844: istore 9
    //   846: iload 6
    //   848: istore 12
    //   850: iload 6
    //   852: istore 10
    //   854: iload 6
    //   856: istore 8
    //   858: iload 6
    //   860: istore 11
    //   862: aload_0
    //   863: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: iload 6
    //   868: istore 9
    //   870: iload 6
    //   872: istore 12
    //   874: iload 6
    //   876: istore 10
    //   878: iload 6
    //   880: istore 8
    //   882: iload 6
    //   884: istore 11
    //   886: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +3354 -> 4243
    //   892: iload 6
    //   894: istore 9
    //   896: iload 6
    //   898: istore 12
    //   900: iload 6
    //   902: istore 10
    //   904: iload 6
    //   906: istore 8
    //   908: iload 6
    //   910: istore 11
    //   912: ldc 43
    //   914: iconst_2
    //   915: aload_0
    //   916: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   919: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto +3321 -> 4243
    //   925: iload 6
    //   927: istore 9
    //   929: iload 6
    //   931: istore 12
    //   933: iload 6
    //   935: istore 10
    //   937: iload 6
    //   939: istore 8
    //   941: iload 6
    //   943: istore 11
    //   945: aload_0
    //   946: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   949: iload 6
    //   951: istore 9
    //   953: iload 6
    //   955: istore 12
    //   957: iload 6
    //   959: istore 10
    //   961: iload 6
    //   963: istore 8
    //   965: iload 6
    //   967: istore 11
    //   969: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +3284 -> 4256
    //   975: iload 6
    //   977: istore 9
    //   979: iload 6
    //   981: istore 12
    //   983: iload 6
    //   985: istore 10
    //   987: iload 6
    //   989: istore 8
    //   991: iload 6
    //   993: istore 11
    //   995: ldc 43
    //   997: iconst_2
    //   998: aload_0
    //   999: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1002: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto +3251 -> 4256
    //   1008: iload 20
    //   1010: istore 9
    //   1012: iload 23
    //   1014: istore 12
    //   1016: iload 13
    //   1018: istore 10
    //   1020: iload 14
    //   1022: istore 8
    //   1024: iload 19
    //   1026: istore 11
    //   1028: new 347	android/graphics/BitmapFactory$Options
    //   1031: dup
    //   1032: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   1035: astore 43
    //   1037: iload 20
    //   1039: istore 9
    //   1041: iload 23
    //   1043: istore 12
    //   1045: iload 13
    //   1047: istore 10
    //   1049: iload 14
    //   1051: istore 8
    //   1053: iload 19
    //   1055: istore 11
    //   1057: aload 43
    //   1059: iconst_1
    //   1060: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1063: iload 20
    //   1065: istore 9
    //   1067: iload 23
    //   1069: istore 12
    //   1071: iload 13
    //   1073: istore 10
    //   1075: iload 14
    //   1077: istore 8
    //   1079: iload 19
    //   1081: istore 11
    //   1083: aload_1
    //   1084: aconst_null
    //   1085: aload 43
    //   1087: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1090: pop
    //   1091: iload 20
    //   1093: istore 9
    //   1095: iload 23
    //   1097: istore 12
    //   1099: iload 13
    //   1101: istore 10
    //   1103: iload 14
    //   1105: istore 8
    //   1107: iload 19
    //   1109: istore 11
    //   1111: aload_1
    //   1112: invokevirtual 339	java/io/InputStream:close	()V
    //   1115: aconst_null
    //   1116: astore 32
    //   1118: aconst_null
    //   1119: astore 40
    //   1121: aconst_null
    //   1122: astore 39
    //   1124: aconst_null
    //   1125: astore 38
    //   1127: aconst_null
    //   1128: astore 41
    //   1130: aconst_null
    //   1131: astore_1
    //   1132: aconst_null
    //   1133: astore 34
    //   1135: aconst_null
    //   1136: astore 36
    //   1138: aconst_null
    //   1139: astore 35
    //   1141: aconst_null
    //   1142: astore 33
    //   1144: aconst_null
    //   1145: astore 37
    //   1147: aload 40
    //   1149: astore 27
    //   1151: iload 21
    //   1153: istore 10
    //   1155: aload 39
    //   1157: astore 30
    //   1159: iload 15
    //   1161: istore 12
    //   1163: aload 38
    //   1165: astore 31
    //   1167: iload 17
    //   1169: istore 11
    //   1171: aload 41
    //   1173: astore 29
    //   1175: iload 18
    //   1177: istore 9
    //   1179: aload_1
    //   1180: astore 28
    //   1182: iload 6
    //   1184: istore 8
    //   1186: aload 43
    //   1188: getfield 360	android/graphics/BitmapFactory$Options:outWidth	I
    //   1191: istore 16
    //   1193: aload 40
    //   1195: astore 27
    //   1197: iload 21
    //   1199: istore 10
    //   1201: aload 39
    //   1203: astore 30
    //   1205: iload 15
    //   1207: istore 12
    //   1209: aload 38
    //   1211: astore 31
    //   1213: iload 17
    //   1215: istore 11
    //   1217: aload 41
    //   1219: astore 29
    //   1221: iload 18
    //   1223: istore 9
    //   1225: aload_1
    //   1226: astore 28
    //   1228: iload 6
    //   1230: istore 8
    //   1232: aload 43
    //   1234: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
    //   1237: istore 14
    //   1239: aload 40
    //   1241: astore 27
    //   1243: iload 21
    //   1245: istore 10
    //   1247: aload 39
    //   1249: astore 30
    //   1251: iload 15
    //   1253: istore 12
    //   1255: aload 38
    //   1257: astore 31
    //   1259: iload 17
    //   1261: istore 11
    //   1263: aload 41
    //   1265: astore 29
    //   1267: iload 18
    //   1269: istore 9
    //   1271: aload_1
    //   1272: astore 28
    //   1274: iload 6
    //   1276: istore 8
    //   1278: aload 43
    //   1280: iconst_0
    //   1281: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1284: iload 16
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
    //   1309: new 365	java/lang/NullPointerException
    //   1312: dup
    //   1313: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   1316: athrow
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   1322: aload_0
    //   1323: astore 27
    //   1325: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1328: ifeq -1317 -> 11
    //   1331: ldc 43
    //   1333: iconst_2
    //   1334: aload_1
    //   1335: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   1338: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aconst_null
    //   1342: areturn
    //   1343: aload 40
    //   1345: astore 27
    //   1347: iload 21
    //   1349: istore 10
    //   1351: aload 39
    //   1353: astore 30
    //   1355: iload 15
    //   1357: istore 12
    //   1359: aload 38
    //   1361: astore 31
    //   1363: iload 17
    //   1365: istore 11
    //   1367: aload 41
    //   1369: astore 29
    //   1371: iload 18
    //   1373: istore 9
    //   1375: aload_1
    //   1376: astore 28
    //   1378: iload 6
    //   1380: istore 8
    //   1382: iload 16
    //   1384: iload 14
    //   1386: invokestatic 201	bked:a	(II)Z
    //   1389: istore_3
    //   1390: iload_3
    //   1391: ifne +46 -> 1437
    //   1394: aconst_null
    //   1395: astore_0
    //   1396: aload_0
    //   1397: astore 27
    //   1399: iconst_0
    //   1400: ifeq -1389 -> 11
    //   1403: new 365	java/lang/NullPointerException
    //   1406: dup
    //   1407: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   1410: athrow
    //   1411: astore_1
    //   1412: aload_1
    //   1413: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   1416: aload_0
    //   1417: astore 27
    //   1419: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1422: ifeq -1411 -> 11
    //   1425: ldc 43
    //   1427: iconst_2
    //   1428: aload_1
    //   1429: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   1432: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1435: aconst_null
    //   1436: areturn
    //   1437: aload 40
    //   1439: astore 27
    //   1441: iload 21
    //   1443: istore 10
    //   1445: aload 39
    //   1447: astore 30
    //   1449: iload 15
    //   1451: istore 12
    //   1453: aload 38
    //   1455: astore 31
    //   1457: iload 17
    //   1459: istore 11
    //   1461: aload 41
    //   1463: astore 29
    //   1465: iload 18
    //   1467: istore 9
    //   1469: aload_1
    //   1470: astore 28
    //   1472: iload 6
    //   1474: istore 8
    //   1476: invokestatic 203	zxx:a	()I
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
    //   1495: iload 16
    //   1497: iload 14
    //   1499: imul
    //   1500: ldc_w 424
    //   1503: if_icmple +1169 -> 2672
    //   1506: iload 16
    //   1508: iload 14
    //   1510: imul
    //   1511: i2d
    //   1512: dstore 4
    //   1514: aload 37
    //   1516: astore 27
    //   1518: aload 34
    //   1520: astore_1
    //   1521: iload 10
    //   1523: istore 8
    //   1525: aload 36
    //   1527: astore 28
    //   1529: aload 35
    //   1531: astore 29
    //   1533: aload 33
    //   1535: astore 30
    //   1537: aload 43
    //   1539: dload 4
    //   1541: invokestatic 427	java/lang/Math:sqrt	(D)D
    //   1544: ldc2_w 428
    //   1547: ddiv
    //   1548: invokestatic 238	java/lang/Math:ceil	(D)D
    //   1551: d2i
    //   1552: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1555: aload 37
    //   1557: astore 27
    //   1559: aload 34
    //   1561: astore_1
    //   1562: iload 10
    //   1564: istore 8
    //   1566: aload 36
    //   1568: astore 28
    //   1570: aload 35
    //   1572: astore 29
    //   1574: aload 33
    //   1576: astore 30
    //   1578: aload 42
    //   1580: aload_0
    //   1581: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
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
    //   1618: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
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
    //   1650: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
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
    //   1683: ldc 43
    //   1685: iconst_4
    //   1686: new 45	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 431
    //   1696: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload 33
    //   1701: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1704: ldc_w 433
    //   1707: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: iload 16
    //   1712: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: ldc_w 435
    //   1718: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: iload 14
    //   1723: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: ldc_w 437
    //   1729: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: aload 43
    //   1734: getfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1737: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1775: invokevirtual 339	java/io/InputStream:close	()V
    //   1778: iload 7
    //   1780: istore 8
    //   1782: aload 33
    //   1784: ifnull +129 -> 1913
    //   1787: iload 7
    //   1789: istore 6
    //   1791: aload 33
    //   1793: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   1796: istore 15
    //   1798: iload 7
    //   1800: istore 6
    //   1802: aload 33
    //   1804: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
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
    //   1837: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1840: iload 7
    //   1842: istore 6
    //   1844: aload 33
    //   1846: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   1849: iload 7
    //   1851: istore 6
    //   1853: aload_1
    //   1854: aconst_null
    //   1855: iload 15
    //   1857: iload 8
    //   1859: invokestatic 419	zxx:a	([I[BII)I
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
    //   1892: ldc_w 439
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
    //   1918: astore 32
    //   1920: aconst_null
    //   1921: astore_1
    //   1922: aconst_null
    //   1923: astore 28
    //   1925: aconst_null
    //   1926: astore 29
    //   1928: aconst_null
    //   1929: astore 30
    //   1931: aconst_null
    //   1932: astore 33
    //   1934: aconst_null
    //   1935: astore 27
    //   1937: iload 6
    //   1939: istore 7
    //   1941: iload 6
    //   1943: iconst_1
    //   1944: if_icmpeq +339 -> 2283
    //   1947: iload 16
    //   1949: iconst_2
    //   1950: imul
    //   1951: iload 14
    //   1953: if_icmpgt +957 -> 2910
    //   1956: iload 16
    //   1958: sipush 1280
    //   1961: if_icmpge +949 -> 2910
    //   1964: iload 10
    //   1966: istore 8
    //   1968: aload 42
    //   1970: aload_0
    //   1971: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
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
    //   2001: astore 33
    //   2003: aload 31
    //   2005: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2008: astore 32
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
    //   2035: astore 33
    //   2037: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
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
    //   2068: astore 33
    //   2070: ldc 43
    //   2072: iconst_4
    //   2073: new 45	java/lang/StringBuilder
    //   2076: dup
    //   2077: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2080: ldc_w 441
    //   2083: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload 32
    //   2088: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2122: astore 33
    //   2124: aload 31
    //   2126: invokevirtual 339	java/io/InputStream:close	()V
    //   2129: aload 32
    //   2131: ifnull +2088 -> 4219
    //   2134: iload 6
    //   2136: istore 7
    //   2138: iload 16
    //   2140: iload 16
    //   2142: imul
    //   2143: newarray int
    //   2145: astore 27
    //   2147: iload 6
    //   2149: istore 7
    //   2151: aload 32
    //   2153: aload 27
    //   2155: iconst_0
    //   2156: iload 16
    //   2158: iconst_0
    //   2159: iconst_0
    //   2160: iload 16
    //   2162: iload 16
    //   2164: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2167: iload 6
    //   2169: istore 7
    //   2171: iload 16
    //   2173: iload 16
    //   2175: imul
    //   2176: newarray byte
    //   2178: astore_1
    //   2179: iload 6
    //   2181: istore 7
    //   2183: aload 27
    //   2185: aload_1
    //   2186: iload 16
    //   2188: iload 16
    //   2190: invokestatic 419	zxx:a	([I[BII)I
    //   2193: istore 6
    //   2195: iload 6
    //   2197: iconst_1
    //   2198: if_icmpeq +2018 -> 4216
    //   2201: iload 6
    //   2203: istore 7
    //   2205: aload 32
    //   2207: aload 27
    //   2209: iconst_0
    //   2210: iload 16
    //   2212: iconst_0
    //   2213: iload 14
    //   2215: iload 16
    //   2217: isub
    //   2218: iload 16
    //   2220: iload 16
    //   2222: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2225: iload 6
    //   2227: istore 7
    //   2229: aload 27
    //   2231: aload_1
    //   2232: iload 16
    //   2234: iload 16
    //   2236: invokestatic 419	zxx:a	([I[BII)I
    //   2239: istore 6
    //   2241: aload 32
    //   2243: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2246: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2249: ifeq +30 -> 2279
    //   2252: ldc 43
    //   2254: iconst_4
    //   2255: new 45	java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2262: ldc_w 443
    //   2265: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: iload 6
    //   2270: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2273: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2276: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2279: iload 6
    //   2281: istore 7
    //   2283: aconst_null
    //   2284: astore 37
    //   2286: aconst_null
    //   2287: astore 35
    //   2289: aconst_null
    //   2290: astore 34
    //   2292: aconst_null
    //   2293: astore 32
    //   2295: aconst_null
    //   2296: astore 33
    //   2298: aconst_null
    //   2299: astore 36
    //   2301: aconst_null
    //   2302: astore 31
    //   2304: iload 7
    //   2306: iconst_1
    //   2307: if_icmpeq +1900 -> 4207
    //   2310: aload 37
    //   2312: astore 27
    //   2314: aload 35
    //   2316: astore_1
    //   2317: iload 10
    //   2319: istore 8
    //   2321: aload 34
    //   2323: astore 28
    //   2325: aload 32
    //   2327: astore 29
    //   2329: aload 33
    //   2331: astore 30
    //   2333: iload 16
    //   2335: iload 14
    //   2337: invokestatic 232	java/lang/Math:min	(II)I
    //   2340: istore 6
    //   2342: iload 6
    //   2344: sipush 250
    //   2347: if_icmple +1860 -> 4207
    //   2350: aload 37
    //   2352: astore 27
    //   2354: aload 35
    //   2356: astore_1
    //   2357: iload 10
    //   2359: istore 8
    //   2361: aload 34
    //   2363: astore 28
    //   2365: aload 32
    //   2367: astore 29
    //   2369: aload 33
    //   2371: astore 30
    //   2373: aload 43
    //   2375: iload 6
    //   2377: i2d
    //   2378: ldc2_w 233
    //   2381: ddiv
    //   2382: invokestatic 238	java/lang/Math:ceil	(D)D
    //   2385: d2i
    //   2386: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2389: aload 37
    //   2391: astore 27
    //   2393: aload 35
    //   2395: astore_1
    //   2396: iload 10
    //   2398: istore 8
    //   2400: aload 34
    //   2402: astore 28
    //   2404: aload 32
    //   2406: astore 29
    //   2408: aload 33
    //   2410: astore 30
    //   2412: aload 36
    //   2414: astore 31
    //   2416: aload 42
    //   2418: aload_0
    //   2419: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
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
    //   2448: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
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
    //   2474: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
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
    //   2501: ldc 43
    //   2503: iconst_4
    //   2504: new 45	java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2511: ldc_w 445
    //   2514: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: aload 32
    //   2519: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2522: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2550: invokevirtual 339	java/io/InputStream:close	()V
    //   2553: aload 32
    //   2555: ifnull +1645 -> 4200
    //   2558: aload 32
    //   2560: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   2563: istore 6
    //   2565: aload 32
    //   2567: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   2570: istore 8
    //   2572: iload 6
    //   2574: iload 8
    //   2576: imul
    //   2577: newarray int
    //   2579: astore_0
    //   2580: aload 32
    //   2582: aload_0
    //   2583: iconst_0
    //   2584: iload 6
    //   2586: iconst_0
    //   2587: iconst_0
    //   2588: iload 6
    //   2590: iload 8
    //   2592: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2595: aload 32
    //   2597: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2600: aload_0
    //   2601: aconst_null
    //   2602: iload 6
    //   2604: iload 8
    //   2606: invokestatic 419	zxx:a	([I[BII)I
    //   2609: istore 6
    //   2611: iload 6
    //   2613: istore 7
    //   2615: iload 7
    //   2617: istore 6
    //   2619: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2622: ifeq +34 -> 2656
    //   2625: ldc 43
    //   2627: iconst_4
    //   2628: new 45	java/lang/StringBuilder
    //   2631: dup
    //   2632: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2635: ldc_w 447
    //   2638: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: iload 7
    //   2643: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2646: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2649: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2676: aload 34
    //   2678: astore_1
    //   2679: iload 10
    //   2681: istore 8
    //   2683: aload 36
    //   2685: astore 28
    //   2687: aload 35
    //   2689: astore 29
    //   2691: aload 33
    //   2693: astore 30
    //   2695: aload 43
    //   2697: iconst_1
    //   2698: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2701: goto -1146 -> 1555
    //   2704: astore_0
    //   2705: iconst_1
    //   2706: istore 6
    //   2708: aload 27
    //   2710: astore 28
    //   2712: iload 6
    //   2714: istore 8
    //   2716: aload_0
    //   2717: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   2720: aload 27
    //   2722: astore 28
    //   2724: iload 6
    //   2726: istore 8
    //   2728: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2731: ifeq +21 -> 2752
    //   2734: aload 27
    //   2736: astore 28
    //   2738: iload 6
    //   2740: istore 8
    //   2742: ldc 43
    //   2744: iconst_2
    //   2745: aload_0
    //   2746: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   2749: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2752: iload 6
    //   2754: ifeq +7 -> 2761
    //   2757: invokestatic 256	zxx:b	()I
    //   2760: pop
    //   2761: aload 27
    //   2763: ifnull +1424 -> 4187
    //   2766: aload 27
    //   2768: invokevirtual 339	java/io/InputStream:close	()V
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
    //   2813: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   2841: invokevirtual 339	java/io/InputStream:close	()V
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
    //   2870: aload 32
    //   2872: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   2900: invokevirtual 339	java/io/InputStream:close	()V
    //   2903: iload 6
    //   2905: istore 7
    //   2907: goto -624 -> 2283
    //   2910: iload 6
    //   2912: istore 7
    //   2914: iload 16
    //   2916: iload 14
    //   2918: iconst_2
    //   2919: imul
    //   2920: if_icmplt -637 -> 2283
    //   2923: iload 6
    //   2925: istore 7
    //   2927: iload 14
    //   2929: sipush 1280
    //   2932: if_icmpge -649 -> 2283
    //   2935: iload 10
    //   2937: istore 8
    //   2939: aload 42
    //   2941: aload_0
    //   2942: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2945: astore 31
    //   2947: aload 31
    //   2949: astore 27
    //   2951: aload 31
    //   2953: astore 32
    //   2955: aload 31
    //   2957: astore_1
    //   2958: iload 10
    //   2960: istore 8
    //   2962: aload 31
    //   2964: astore 28
    //   2966: aload 31
    //   2968: astore 29
    //   2970: aload 31
    //   2972: astore 30
    //   2974: aload 31
    //   2976: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2979: astore 33
    //   2981: aload 31
    //   2983: astore 27
    //   2985: aload 31
    //   2987: astore 32
    //   2989: aload 31
    //   2991: astore_1
    //   2992: iload 10
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
    //   3025: iload 10
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
    //   3051: ldc_w 449
    //   3054: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3057: aload 33
    //   3059: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3062: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3065: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3068: aload 31
    //   3070: astore 27
    //   3072: aload 31
    //   3074: astore 32
    //   3076: aload 31
    //   3078: astore_1
    //   3079: iload 10
    //   3081: istore 8
    //   3083: aload 31
    //   3085: astore 28
    //   3087: aload 31
    //   3089: astore 29
    //   3091: aload 31
    //   3093: astore 30
    //   3095: aload 31
    //   3097: invokevirtual 339	java/io/InputStream:close	()V
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
    //   3137: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
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
    //   3164: invokestatic 419	zxx:a	([I[BII)I
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
    //   3189: iload 16
    //   3191: iload 14
    //   3193: isub
    //   3194: iconst_0
    //   3195: iload 14
    //   3197: iload 14
    //   3199: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3202: iload 8
    //   3204: istore 7
    //   3206: aload_1
    //   3207: aload 27
    //   3209: iload 14
    //   3211: iload 14
    //   3213: invokestatic 419	zxx:a	([I[BII)I
    //   3216: istore 6
    //   3218: iload 6
    //   3220: istore 7
    //   3222: aload 33
    //   3224: invokevirtual 334	android/graphics/Bitmap:recycle	()V
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
    //   3255: ldc_w 451
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
    //   3298: iload 10
    //   3300: istore 8
    //   3302: aload 31
    //   3304: astore 28
    //   3306: aload 31
    //   3308: astore 29
    //   3310: aload 31
    //   3312: astore 30
    //   3314: aload 32
    //   3316: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   3344: invokevirtual 339	java/io/InputStream:close	()V
    //   3347: iload 6
    //   3349: istore 7
    //   3351: goto -1068 -> 2283
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
    //   3374: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   3396: invokevirtual 339	java/io/InputStream:close	()V
    //   3399: aconst_null
    //   3400: astore_0
    //   3401: iconst_1
    //   3402: istore 6
    //   3404: goto -2820 -> 584
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 6
    //   3412: istore 10
    //   3414: aload_0
    //   3415: astore 30
    //   3417: iload 6
    //   3419: istore 12
    //   3421: aload_0
    //   3422: astore 31
    //   3424: iload 6
    //   3426: istore 11
    //   3428: aload_0
    //   3429: astore 29
    //   3431: iload 6
    //   3433: istore 9
    //   3435: aload_0
    //   3436: astore 28
    //   3438: iload 6
    //   3440: istore 8
    //   3442: new 243	android/util/Pair
    //   3445: dup
    //   3446: aconst_null
    //   3447: aconst_null
    //   3448: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3451: astore_1
    //   3452: aload_0
    //   3453: astore 27
    //   3455: goto -2683 -> 772
    //   3458: astore_0
    //   3459: iload 10
    //   3461: istore 6
    //   3463: goto -755 -> 2708
    //   3466: astore 27
    //   3468: aload 27
    //   3470: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3473: aload_1
    //   3474: astore_0
    //   3475: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3478: ifeq -2683 -> 795
    //   3481: ldc 43
    //   3483: iconst_2
    //   3484: aload 27
    //   3486: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3489: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3492: aload_1
    //   3493: astore_0
    //   3494: goto -2699 -> 795
    //   3497: astore_0
    //   3498: aload_0
    //   3499: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3502: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3505: ifeq +13 -> 3518
    //   3508: ldc 43
    //   3510: iconst_2
    //   3511: aload_0
    //   3512: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3515: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3518: aconst_null
    //   3519: astore_0
    //   3520: goto -2725 -> 795
    //   3523: astore_0
    //   3524: iload 12
    //   3526: istore 6
    //   3528: aload 30
    //   3530: astore_1
    //   3531: iload 6
    //   3533: istore 8
    //   3535: aload_0
    //   3536: invokevirtual 267	java/lang/RuntimeException:printStackTrace	()V
    //   3539: aload 30
    //   3541: astore_1
    //   3542: iload 6
    //   3544: istore 8
    //   3546: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3549: ifeq +20 -> 3569
    //   3552: aload 30
    //   3554: astore_1
    //   3555: iload 6
    //   3557: istore 8
    //   3559: ldc 43
    //   3561: iconst_2
    //   3562: aload_0
    //   3563: invokevirtual 268	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3566: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3569: iload 6
    //   3571: ifeq +7 -> 3578
    //   3574: invokestatic 256	zxx:b	()I
    //   3577: pop
    //   3578: aload 30
    //   3580: ifnull +607 -> 4187
    //   3583: aload 30
    //   3585: invokevirtual 339	java/io/InputStream:close	()V
    //   3588: aconst_null
    //   3589: astore_0
    //   3590: goto -2795 -> 795
    //   3593: astore_0
    //   3594: aload_0
    //   3595: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3598: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3601: ifeq +13 -> 3614
    //   3604: ldc 43
    //   3606: iconst_2
    //   3607: aload_0
    //   3608: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3611: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3614: aconst_null
    //   3615: astore_0
    //   3616: goto -2821 -> 795
    //   3619: astore_0
    //   3620: iload 11
    //   3622: istore 6
    //   3624: aload 31
    //   3626: astore 29
    //   3628: aload 29
    //   3630: astore_1
    //   3631: iload 6
    //   3633: istore 8
    //   3635: aload_0
    //   3636: invokevirtual 272	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3639: aload 29
    //   3641: astore_1
    //   3642: iload 6
    //   3644: istore 8
    //   3646: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3649: ifeq +20 -> 3669
    //   3652: aload 29
    //   3654: astore_1
    //   3655: iload 6
    //   3657: istore 8
    //   3659: ldc 43
    //   3661: iconst_2
    //   3662: aload_0
    //   3663: invokevirtual 273	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3666: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3669: iload 6
    //   3671: ifeq +7 -> 3678
    //   3674: invokestatic 256	zxx:b	()I
    //   3677: pop
    //   3678: aload 29
    //   3680: ifnull +507 -> 4187
    //   3683: aload 29
    //   3685: invokevirtual 339	java/io/InputStream:close	()V
    //   3688: aconst_null
    //   3689: astore_0
    //   3690: goto -2895 -> 795
    //   3693: astore_0
    //   3694: aload_0
    //   3695: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3698: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3701: ifeq +13 -> 3714
    //   3704: ldc 43
    //   3706: iconst_2
    //   3707: aload_0
    //   3708: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3711: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3714: aconst_null
    //   3715: astore_0
    //   3716: goto -2921 -> 795
    //   3719: astore_0
    //   3720: iload 9
    //   3722: istore 6
    //   3724: aload 29
    //   3726: astore 28
    //   3728: aload 28
    //   3730: astore_1
    //   3731: iload 6
    //   3733: istore 8
    //   3735: aload_0
    //   3736: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   3739: aload 28
    //   3741: astore_1
    //   3742: iload 6
    //   3744: istore 8
    //   3746: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3749: ifeq +20 -> 3769
    //   3752: aload 28
    //   3754: astore_1
    //   3755: iload 6
    //   3757: istore 8
    //   3759: ldc 43
    //   3761: iconst_2
    //   3762: aload_0
    //   3763: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3766: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3769: iload 6
    //   3771: ifeq +7 -> 3778
    //   3774: invokestatic 256	zxx:b	()I
    //   3777: pop
    //   3778: aload 28
    //   3780: ifnull +407 -> 4187
    //   3783: aload 28
    //   3785: invokevirtual 339	java/io/InputStream:close	()V
    //   3788: aconst_null
    //   3789: astore_0
    //   3790: goto -2995 -> 795
    //   3793: astore_0
    //   3794: aload_0
    //   3795: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3798: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3801: ifeq +13 -> 3814
    //   3804: ldc 43
    //   3806: iconst_2
    //   3807: aload_0
    //   3808: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3811: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3814: aconst_null
    //   3815: astore_0
    //   3816: goto -3021 -> 795
    //   3819: astore_0
    //   3820: aload 28
    //   3822: astore_1
    //   3823: iload 8
    //   3825: ifeq +7 -> 3832
    //   3828: invokestatic 256	zxx:b	()I
    //   3831: pop
    //   3832: aload_1
    //   3833: ifnull +7 -> 3840
    //   3836: aload_1
    //   3837: invokevirtual 339	java/io/InputStream:close	()V
    //   3840: aload_0
    //   3841: athrow
    //   3842: astore_1
    //   3843: aload_1
    //   3844: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3847: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3850: ifeq -10 -> 3840
    //   3853: ldc 43
    //   3855: iconst_2
    //   3856: aload_1
    //   3857: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3860: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3863: goto -23 -> 3840
    //   3866: astore_0
    //   3867: iload 9
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
    //   3917: iload 11
    //   3919: istore 6
    //   3921: goto -193 -> 3728
    //   3924: astore_0
    //   3925: aconst_null
    //   3926: astore 28
    //   3928: iload 11
    //   3930: istore 6
    //   3932: goto -204 -> 3728
    //   3935: astore_0
    //   3936: aconst_null
    //   3937: astore 28
    //   3939: iload 11
    //   3941: istore 6
    //   3943: goto -215 -> 3728
    //   3946: astore_0
    //   3947: iload 10
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
    //   3968: iload 12
    //   3970: istore 6
    //   3972: goto -344 -> 3628
    //   3975: astore_0
    //   3976: aconst_null
    //   3977: astore 29
    //   3979: iload 12
    //   3981: istore 6
    //   3983: goto -355 -> 3628
    //   3986: astore_0
    //   3987: aconst_null
    //   3988: astore 29
    //   3990: iload 12
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
    //   4019: iload 9
    //   4021: istore 6
    //   4023: goto -495 -> 3528
    //   4026: astore_0
    //   4027: aconst_null
    //   4028: astore 30
    //   4030: iload 9
    //   4032: istore 6
    //   4034: goto -506 -> 3528
    //   4037: astore_0
    //   4038: aconst_null
    //   4039: astore 30
    //   4041: iload 9
    //   4043: istore 6
    //   4045: goto -517 -> 3528
    //   4048: astore_0
    //   4049: aload_1
    //   4050: astore 27
    //   4052: iload 11
    //   4054: istore 6
    //   4056: goto -1348 -> 2708
    //   4059: astore_0
    //   4060: iconst_1
    //   4061: istore 6
    //   4063: aload_1
    //   4064: astore 27
    //   4066: goto -1358 -> 2708
    //   4069: astore_0
    //   4070: aconst_null
    //   4071: astore 27
    //   4073: iconst_1
    //   4074: istore 6
    //   4076: goto -1368 -> 2708
    //   4079: astore_0
    //   4080: iconst_1
    //   4081: istore 6
    //   4083: aconst_null
    //   4084: astore 27
    //   4086: goto -1378 -> 2708
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
    //   4115: astore 32
    //   4117: aconst_null
    //   4118: astore 31
    //   4120: iload 7
    //   4122: istore 6
    //   4124: goto -1277 -> 2847
    //   4127: astore 32
    //   4129: aconst_null
    //   4130: astore 31
    //   4132: goto -1285 -> 2847
    //   4135: astore 32
    //   4137: aconst_null
    //   4138: astore 31
    //   4140: goto -1352 -> 2788
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
    //   4204: goto -1548 -> 2656
    //   4207: iconst_1
    //   4208: istore 6
    //   4210: aload 31
    //   4212: astore_0
    //   4213: goto -3629 -> 584
    //   4216: goto -1975 -> 2241
    //   4219: goto -1940 -> 2279
    //   4222: iconst_0
    //   4223: istore 8
    //   4225: iconst_m1
    //   4226: istore 7
    //   4228: goto -3650 -> 578
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
    //   4261: astore 32
    //   4263: aload 33
    //   4265: astore 31
    //   4267: goto -1420 -> 2847
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
    //   88	4164	6	i	int
    //   20	4207	7	j	int
    //   146	4078	8	k	int
    //   138	3904	9	m	int
    //   114	3834	10	n	int
    //   130	3923	11	i1	int
    //   122	3869	12	i2	int
    //   97	3802	13	i3	int
    //   100	3112	14	i4	int
    //   79	1777	15	i5	int
    //   70	3124	16	i6	int
    //   82	1376	17	i7	int
    //   85	1381	18	i8	int
    //   103	1005	19	i9	int
    //   91	1001	20	i10	int
    //   76	1366	21	i11	int
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
    //   4115	1	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4127	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   4135	1	32	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4261	1	32	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4270	1	32	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   61	4203	33	localObject8	Object
    //   64	2613	34	localObject9	Object
    //   58	2630	35	localObject10	Object
    //   67	2617	36	localObject11	Object
    //   1145	1528	37	localObject12	Object
    //   1125	329	38	localObject13	Object
    //   1122	324	39	localObject14	Object
    //   1119	319	40	localObject15	Object
    //   1128	334	41	localObject16	Object
    //   152	2788	42	localContentResolver	android.content.ContentResolver
    //   1035	1661	43	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   387	391	393	java/io/IOException
    //   225	234	837	java/lang/OutOfMemoryError
    //   250	256	837	java/lang/OutOfMemoryError
    //   272	299	837	java/lang/OutOfMemoryError
    //   320	327	837	java/lang/OutOfMemoryError
    //   343	350	837	java/lang/OutOfMemoryError
    //   366	374	837	java/lang/OutOfMemoryError
    //   435	443	837	java/lang/OutOfMemoryError
    //   459	474	837	java/lang/OutOfMemoryError
    //   490	495	837	java/lang/OutOfMemoryError
    //   511	515	837	java/lang/OutOfMemoryError
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
    //   2939	2947	2704	java/io/IOException
    //   2974	2981	2704	java/io/IOException
    //   3008	3014	2704	java/io/IOException
    //   3041	3068	2704	java/io/IOException
    //   3095	3100	2704	java/io/IOException
    //   3314	3319	2704	java/io/IOException
    //   3342	3347	2704	java/io/IOException
    //   3372	3377	2704	java/io/IOException
    //   3395	3399	2704	java/io/IOException
    //   1578	1586	2776	java/lang/OutOfMemoryError
    //   1613	1623	2776	java/lang/OutOfMemoryError
    //   1650	1656	2776	java/lang/OutOfMemoryError
    //   1683	1746	2776	java/lang/OutOfMemoryError
    //   1773	1778	2776	java/lang/OutOfMemoryError
    //   2939	2947	3283	java/lang/OutOfMemoryError
    //   2974	2981	3283	java/lang/OutOfMemoryError
    //   3008	3014	3283	java/lang/OutOfMemoryError
    //   3041	3068	3283	java/lang/OutOfMemoryError
    //   3095	3100	3283	java/lang/OutOfMemoryError
    //   148	154	3458	java/io/IOException
    //   194	201	3458	java/io/IOException
    //   629	638	3458	java/io/IOException
    //   673	681	3458	java/io/IOException
    //   716	723	3458	java/io/IOException
    //   758	769	3458	java/io/IOException
    //   1186	1193	3458	java/io/IOException
    //   1232	1239	3458	java/io/IOException
    //   1278	1284	3458	java/io/IOException
    //   1382	1390	3458	java/io/IOException
    //   1476	1480	3458	java/io/IOException
    //   3442	3452	3458	java/io/IOException
    //   788	793	3466	java/io/IOException
    //   2766	2771	3497	java/io/IOException
    //   148	154	3523	java/lang/RuntimeException
    //   194	201	3523	java/lang/RuntimeException
    //   629	638	3523	java/lang/RuntimeException
    //   673	681	3523	java/lang/RuntimeException
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
    //   629	638	3619	java/lang/UnsatisfiedLinkError
    //   673	681	3619	java/lang/UnsatisfiedLinkError
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
    //   629	638	3719	java/lang/Throwable
    //   673	681	3719	java/lang/Throwable
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
    //   629	638	3819	finally
    //   673	681	3819	finally
    //   716	723	3819	finally
    //   758	769	3819	finally
    //   1186	1193	3819	finally
    //   1232	1239	3819	finally
    //   1278	1284	3819	finally
    //   1382	1390	3819	finally
    //   1476	1480	3819	finally
    //   2716	2720	3819	finally
    //   2728	2734	3819	finally
    //   2742	2752	3819	finally
    //   3442	3452	3819	finally
    //   3836	3840	3842	java/io/IOException
    //   225	234	3866	finally
    //   250	256	3866	finally
    //   272	299	3866	finally
    //   320	327	3866	finally
    //   343	350	3866	finally
    //   366	374	3866	finally
    //   435	443	3866	finally
    //   459	474	3866	finally
    //   490	495	3866	finally
    //   511	515	3866	finally
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
    //   518	529	3874	finally
    //   537	570	3874	finally
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
    //   2416	2423	3881	finally
    //   2444	2453	3881	finally
    //   2474	2480	3881	finally
    //   2501	2528	3881	finally
    //   2549	2553	3881	finally
    //   2695	2701	3881	finally
    //   2811	2816	3881	finally
    //   2839	2844	3881	finally
    //   2870	2875	3881	finally
    //   2898	2903	3881	finally
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
    //   2558	2611	3895	finally
    //   2619	2652	3895	finally
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
    //   2416	2423	3916	java/lang/Throwable
    //   2444	2453	3916	java/lang/Throwable
    //   2474	2480	3916	java/lang/Throwable
    //   2501	2528	3916	java/lang/Throwable
    //   2549	2553	3916	java/lang/Throwable
    //   2695	2701	3916	java/lang/Throwable
    //   2811	2816	3916	java/lang/Throwable
    //   2839	2844	3916	java/lang/Throwable
    //   2870	2875	3916	java/lang/Throwable
    //   2898	2903	3916	java/lang/Throwable
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
    //   2558	2611	3935	java/lang/Throwable
    //   2619	2652	3935	java/lang/Throwable
    //   3113	3121	3935	java/lang/Throwable
    //   3125	3140	3935	java/lang/Throwable
    //   3144	3153	3935	java/lang/Throwable
    //   3157	3169	3935	java/lang/Throwable
    //   3183	3202	3935	java/lang/Throwable
    //   3206	3218	3935	java/lang/Throwable
    //   3222	3227	3935	java/lang/Throwable
    //   3235	3241	3935	java/lang/Throwable
    //   3245	3272	3935	java/lang/Throwable
    //   225	234	3946	java/lang/UnsatisfiedLinkError
    //   250	256	3946	java/lang/UnsatisfiedLinkError
    //   272	299	3946	java/lang/UnsatisfiedLinkError
    //   320	327	3946	java/lang/UnsatisfiedLinkError
    //   343	350	3946	java/lang/UnsatisfiedLinkError
    //   366	374	3946	java/lang/UnsatisfiedLinkError
    //   435	443	3946	java/lang/UnsatisfiedLinkError
    //   459	474	3946	java/lang/UnsatisfiedLinkError
    //   490	495	3946	java/lang/UnsatisfiedLinkError
    //   511	515	3946	java/lang/UnsatisfiedLinkError
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
    //   518	529	3957	java/lang/UnsatisfiedLinkError
    //   537	570	3957	java/lang/UnsatisfiedLinkError
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
    //   2416	2423	3967	java/lang/UnsatisfiedLinkError
    //   2444	2453	3967	java/lang/UnsatisfiedLinkError
    //   2474	2480	3967	java/lang/UnsatisfiedLinkError
    //   2501	2528	3967	java/lang/UnsatisfiedLinkError
    //   2549	2553	3967	java/lang/UnsatisfiedLinkError
    //   2695	2701	3967	java/lang/UnsatisfiedLinkError
    //   2811	2816	3967	java/lang/UnsatisfiedLinkError
    //   2839	2844	3967	java/lang/UnsatisfiedLinkError
    //   2870	2875	3967	java/lang/UnsatisfiedLinkError
    //   2898	2903	3967	java/lang/UnsatisfiedLinkError
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
    //   2558	2611	3986	java/lang/UnsatisfiedLinkError
    //   2619	2652	3986	java/lang/UnsatisfiedLinkError
    //   3113	3121	3986	java/lang/UnsatisfiedLinkError
    //   3125	3140	3986	java/lang/UnsatisfiedLinkError
    //   3144	3153	3986	java/lang/UnsatisfiedLinkError
    //   3157	3169	3986	java/lang/UnsatisfiedLinkError
    //   3183	3202	3986	java/lang/UnsatisfiedLinkError
    //   3206	3218	3986	java/lang/UnsatisfiedLinkError
    //   3222	3227	3986	java/lang/UnsatisfiedLinkError
    //   3235	3241	3986	java/lang/UnsatisfiedLinkError
    //   3245	3272	3986	java/lang/UnsatisfiedLinkError
    //   225	234	3997	java/lang/RuntimeException
    //   250	256	3997	java/lang/RuntimeException
    //   272	299	3997	java/lang/RuntimeException
    //   320	327	3997	java/lang/RuntimeException
    //   343	350	3997	java/lang/RuntimeException
    //   366	374	3997	java/lang/RuntimeException
    //   435	443	3997	java/lang/RuntimeException
    //   459	474	3997	java/lang/RuntimeException
    //   490	495	3997	java/lang/RuntimeException
    //   511	515	3997	java/lang/RuntimeException
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
    //   518	529	4008	java/lang/RuntimeException
    //   537	570	4008	java/lang/RuntimeException
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
    //   2416	2423	4018	java/lang/RuntimeException
    //   2444	2453	4018	java/lang/RuntimeException
    //   2474	2480	4018	java/lang/RuntimeException
    //   2501	2528	4018	java/lang/RuntimeException
    //   2549	2553	4018	java/lang/RuntimeException
    //   2695	2701	4018	java/lang/RuntimeException
    //   2811	2816	4018	java/lang/RuntimeException
    //   2839	2844	4018	java/lang/RuntimeException
    //   2870	2875	4018	java/lang/RuntimeException
    //   2898	2903	4018	java/lang/RuntimeException
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
    //   2558	2611	4037	java/lang/RuntimeException
    //   2619	2652	4037	java/lang/RuntimeException
    //   3113	3121	4037	java/lang/RuntimeException
    //   3125	3140	4037	java/lang/RuntimeException
    //   3144	3153	4037	java/lang/RuntimeException
    //   3157	3169	4037	java/lang/RuntimeException
    //   3183	3202	4037	java/lang/RuntimeException
    //   3206	3218	4037	java/lang/RuntimeException
    //   3222	3227	4037	java/lang/RuntimeException
    //   3235	3241	4037	java/lang/RuntimeException
    //   3245	3272	4037	java/lang/RuntimeException
    //   225	234	4048	java/io/IOException
    //   250	256	4048	java/io/IOException
    //   272	299	4048	java/io/IOException
    //   320	327	4048	java/io/IOException
    //   343	350	4048	java/io/IOException
    //   366	374	4048	java/io/IOException
    //   435	443	4048	java/io/IOException
    //   459	474	4048	java/io/IOException
    //   490	495	4048	java/io/IOException
    //   511	515	4048	java/io/IOException
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
    //   518	529	4059	java/io/IOException
    //   537	570	4059	java/io/IOException
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
    //   2558	2611	4079	java/io/IOException
    //   2619	2652	4079	java/io/IOException
    //   3113	3121	4079	java/io/IOException
    //   3125	3140	4079	java/io/IOException
    //   3144	3153	4079	java/io/IOException
    //   3157	3169	4079	java/io/IOException
    //   3183	3202	4079	java/io/IOException
    //   3206	3218	4079	java/io/IOException
    //   3222	3227	4079	java/io/IOException
    //   3235	3241	4079	java/io/IOException
    //   3245	3272	4079	java/io/IOException
    //   2558	2611	4089	java/lang/OutOfMemoryError
    //   2619	2652	4096	java/lang/OutOfMemoryError
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
    //   518	529	4143	java/lang/Throwable
    //   537	570	4150	java/lang/Throwable
    //   518	529	4165	java/lang/OutOfMemoryError
    //   537	570	4172	java/lang/OutOfMemoryError
    //   225	234	4248	java/lang/Throwable
    //   250	256	4248	java/lang/Throwable
    //   272	299	4248	java/lang/Throwable
    //   320	327	4248	java/lang/Throwable
    //   343	350	4248	java/lang/Throwable
    //   366	374	4248	java/lang/Throwable
    //   435	443	4248	java/lang/Throwable
    //   459	474	4248	java/lang/Throwable
    //   490	495	4248	java/lang/Throwable
    //   511	515	4248	java/lang/Throwable
    //   1968	1976	4261	java/lang/OutOfMemoryError
    //   2003	2010	4261	java/lang/OutOfMemoryError
    //   2037	2043	4261	java/lang/OutOfMemoryError
    //   2070	2097	4261	java/lang/OutOfMemoryError
    //   2124	2129	4261	java/lang/OutOfMemoryError
    //   2416	2423	4270	java/lang/OutOfMemoryError
    //   2444	2453	4270	java/lang/OutOfMemoryError
    //   2474	2480	4270	java/lang/OutOfMemoryError
    //   2501	2528	4270	java/lang/OutOfMemoryError
    //   2549	2553	4270	java/lang/OutOfMemoryError
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
                localObject = bhml.a((byte[])localObject);
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
        paramString1 = bhlo.a();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = dp.a();
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
      bdmc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (zyx.g(paramString))
      {
        bdmc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        bdmc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (zyx.i(paramString))
        {
          bdmc.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, zyf paramzyf, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new zxz(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramzyf);
    paramAppActivity = new NewIntent(paramAppActivity, zvq.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramzyf = paramzyf.a();
    if (paramzyf != null)
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
        if (paramzyf.has(str)) {
          paramAppActivity.putExtra(str, paramzyf.optString(str));
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
    } while (axsw.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bked.a));
    new axsw().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bked.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, zyf paramzyf)
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
        if ((!paramQQAppInterface.q()) && (!paramQQAppInterface.n()) && (!paramQQAppInterface.r())) {
          bhkm.b(2131230757, false);
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
        if ((!paramQQAppInterface.q()) && (!paramQQAppInterface.n()) && (!paramQQAppInterface.r())) {
          bhkm.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramzyf);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramzyf);
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
        if ((!paramQQAppInterface.q()) && (!paramQQAppInterface.n()) && (!paramQQAppInterface.r())) {
          bhkm.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        zvr.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
        if (!nnr.a(paramAppActivity))
        {
          paramString1 = bhlq.a(paramAppActivity, 230);
          paramString1.setMessage(2131717578);
          paramString2 = new zxy(paramzyf);
          paramString1.setPositiveButton(2131694098, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.q()) && (!paramQQAppInterface.n()) && (!paramQQAppInterface.r())) {
          bhkm.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).isWtLoginUrl(str)) && (!zyx.a(str)))
        {
          if (bjos.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            bjos.a().a(paramQQAppInterface, paramString1, paramView);
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
          achd.a().a(1);
          achd.a().jdField_a_of_type_JavaLangString = "";
          achd.a().jdField_a_of_type_Int = 0;
          achd.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramzyf, paramString1)) {
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
        else if (zyx.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (zyx.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (zyx.f(str))
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
          if (zyx.h(str))
          {
            if (zyx.b(str))
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
            if (bhtl.a(paramString1))
            {
              bhtl.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramzyf, paramView);
              i = 1;
            }
          }
          else
          {
            zvr.a(paramQQAppInterface, paramAppActivity, paramString1);
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
      int i = bked.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxx
 * JD-Core Version:    0.7.0.1
 */