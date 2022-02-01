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
import com.tencent.biz.common.util.HttpUtil;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public class yxi
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
      int k = bijo.a(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bijo.a((int[])localObject, localObject.length);
      localObject = bijo.a();
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
    if ((RecogUtil.getSupportDetectType() >= 0) && (aokb.b()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = aokb.a().a(paramBitmap, l, localRect);
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
    //   104: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   163: invokestatic 86	aokb:b	()Z
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
    //   187: invokestatic 180	yxi:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 185	aokn:a	(ZZ)V
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
          if (!bijo.a(paramBitmap.getWidth(), paramBitmap.getHeight())) {
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
            aokb.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(aokb.a()), Long.valueOf(l2) }));
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
      bijo.a(paramBitmap, localStringBuilder2);
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
        aokb.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   77: astore 39
    //   79: aconst_null
    //   80: astore 40
    //   82: aconst_null
    //   83: astore 34
    //   85: aconst_null
    //   86: astore 41
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
    //   118: lstore 28
    //   120: aload 41
    //   122: astore 38
    //   124: aload 39
    //   126: astore 35
    //   128: aload 40
    //   130: astore 37
    //   132: aload 34
    //   134: astore 36
    //   136: aload_1
    //   137: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 41
    //   144: astore 38
    //   146: aload 39
    //   148: astore 35
    //   150: aload 40
    //   152: astore 37
    //   154: aload 34
    //   156: astore 36
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5794 -> 5962
    //   171: aload 34
    //   173: astore 38
    //   175: aload 34
    //   177: astore 35
    //   179: aload 34
    //   181: astore 37
    //   183: aload 34
    //   185: astore 36
    //   187: invokestatic 92	java/lang/System:currentTimeMillis	()J
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
    //   208: invokestatic 98	aokb:a	()Laokb;
    //   211: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   214: lload 28
    //   216: ldc_w 292
    //   219: invokevirtual 214	aokb:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   222: iconst_1
    //   223: istore 26
    //   225: iconst_1
    //   226: istore 23
    //   228: iconst_1
    //   229: istore 25
    //   231: iconst_1
    //   232: istore 22
    //   234: iconst_1
    //   235: istore 27
    //   237: iconst_1
    //   238: istore 24
    //   240: iload 24
    //   242: istore 6
    //   244: iload 26
    //   246: istore 7
    //   248: iload 23
    //   250: istore 8
    //   252: iload 25
    //   254: istore 9
    //   256: iload 22
    //   258: istore 10
    //   260: iload 27
    //   262: istore 11
    //   264: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +60 -> 327
    //   270: iload 26
    //   272: istore 7
    //   274: iload 23
    //   276: istore 8
    //   278: iload 25
    //   280: istore 9
    //   282: iload 22
    //   284: istore 10
    //   286: iload 27
    //   288: istore 11
    //   290: ldc_w 292
    //   293: iconst_2
    //   294: ldc 216
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: invokestatic 218	aokb:a	()Z
    //   305: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: lload 28
    //   313: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   316: aastore
    //   317: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   320: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iload 24
    //   325: istore 6
    //   327: new 45	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   334: astore 40
    //   336: iload_3
    //   337: ifeq +1047 -> 1384
    //   340: aload_0
    //   341: invokevirtual 316	android/net/Uri:getPath	()Ljava/lang/String;
    //   344: invokestatic 322	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   347: astore 35
    //   349: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   352: ifeq +31 -> 383
    //   355: ldc_w 292
    //   358: iconst_4
    //   359: new 45	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 324
    //   369: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 35
    //   374: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload 35
    //   385: ifnull +5560 -> 5945
    //   388: aload 35
    //   390: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   393: istore 21
    //   395: aload 35
    //   397: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   400: istore 20
    //   402: iload 21
    //   404: iload 20
    //   406: invokestatic 201	bijo:a	(II)Z
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
    //   441: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   444: iload 8
    //   446: iconst_1
    //   447: iand
    //   448: iconst_1
    //   449: if_icmpne +5483 -> 5932
    //   452: invokestatic 203	yxi:a	()I
    //   455: pop
    //   456: iconst_1
    //   457: istore 4
    //   459: iload 4
    //   461: istore 12
    //   463: iload 4
    //   465: istore 13
    //   467: iload 14
    //   469: istore 9
    //   471: iload 4
    //   473: istore 14
    //   475: iload 15
    //   477: istore 10
    //   479: iload 4
    //   481: istore 15
    //   483: iload 18
    //   485: istore 11
    //   487: aload_1
    //   488: aconst_null
    //   489: iload 21
    //   491: iload 20
    //   493: iload 8
    //   495: aload 40
    //   497: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   500: istore 7
    //   502: iload 4
    //   504: istore 12
    //   506: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   509: ifeq +48 -> 557
    //   512: iload 4
    //   514: istore 12
    //   516: ldc_w 292
    //   519: iconst_4
    //   520: ldc_w 329
    //   523: iconst_3
    //   524: anewarray 4	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: iload 8
    //   531: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: aastore
    //   535: dup
    //   536: iconst_1
    //   537: iload 7
    //   539: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aastore
    //   543: dup
    //   544: iconst_2
    //   545: aload 40
    //   547: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: aastore
    //   551: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
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
    //   581: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
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
    //   607: invokestatic 81	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   610: iflt +13 -> 623
    //   613: iload 4
    //   615: istore 12
    //   617: invokestatic 218	aokb:a	()Z
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
    //   643: invokestatic 180	yxi:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   669: istore 14
    //   671: iload 7
    //   673: istore 10
    //   675: iload 4
    //   677: istore 15
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
    //   711: istore 14
    //   713: iload 7
    //   715: istore 10
    //   717: iload 4
    //   719: istore 15
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
    //   743: ldc_w 331
    //   746: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: iload 7
    //   751: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iload 4
    //   762: istore 12
    //   764: aload 35
    //   766: invokevirtual 334	android/graphics/Bitmap:recycle	()V
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
    //   830: astore 35
    //   832: aload_1
    //   833: astore 34
    //   835: iload 7
    //   837: istore 8
    //   839: new 45	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   846: astore 36
    //   848: aload_1
    //   849: astore 34
    //   851: iload 7
    //   853: istore 8
    //   855: aload 35
    //   857: aload 36
    //   859: invokestatic 241	bijo:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   862: pop
    //   863: aload_1
    //   864: astore 34
    //   866: iload 7
    //   868: istore 8
    //   870: aload 5
    //   872: iconst_1
    //   873: new 243	android/util/Pair
    //   876: dup
    //   877: aload 36
    //   879: aload 35
    //   881: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   884: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
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
    //   914: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   917: aload_1
    //   918: astore 34
    //   920: iload 7
    //   922: istore 8
    //   924: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +64 -> 991
    //   930: aload_1
    //   931: astore 34
    //   933: iload 7
    //   935: istore 8
    //   937: ldc_w 292
    //   940: iconst_2
    //   941: ldc 254
    //   943: iconst_5
    //   944: anewarray 4	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: iload 9
    //   951: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   954: aastore
    //   955: dup
    //   956: iconst_1
    //   957: iload 4
    //   959: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   962: aastore
    //   963: dup
    //   964: iconst_2
    //   965: iload_3
    //   966: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   969: aastore
    //   970: dup
    //   971: iconst_3
    //   972: iload_2
    //   973: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   976: aastore
    //   977: dup
    //   978: iconst_4
    //   979: aload 40
    //   981: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: aastore
    //   985: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   988: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: iload 7
    //   993: ifeq +7 -> 1000
    //   996: invokestatic 256	yxi:b	()I
    //   999: pop
    //   1000: iload 6
    //   1002: ifeq +14 -> 1016
    //   1005: invokestatic 98	aokb:a	()Laokb;
    //   1008: lload 28
    //   1010: ldc_w 292
    //   1013: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   1016: iload 4
    //   1018: istore 6
    //   1020: aload_1
    //   1021: ifnull +11 -> 1032
    //   1024: aload_1
    //   1025: invokevirtual 339	java/io/InputStream:close	()V
    //   1028: iload 4
    //   1030: istore 6
    //   1032: iload 6
    //   1034: istore 4
    //   1036: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1039: ifeq -1028 -> 11
    //   1042: ldc_w 292
    //   1045: iconst_4
    //   1046: new 45	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 341
    //   1056: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   1062: lload 32
    //   1064: lsub
    //   1065: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: ldc_w 343
    //   1071: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   1101: iload 13
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
    //   1127: istore 14
    //   1129: iload 4
    //   1131: istore 10
    //   1133: iload 7
    //   1135: istore 15
    //   1137: iload 4
    //   1139: istore 11
    //   1141: aload_1
    //   1142: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   1167: istore 14
    //   1169: iload 4
    //   1171: istore 10
    //   1173: iload 7
    //   1175: istore 15
    //   1177: iload 4
    //   1179: istore 11
    //   1181: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   1209: istore 14
    //   1211: iload 4
    //   1213: istore 10
    //   1215: iload 7
    //   1217: istore 15
    //   1219: iload 4
    //   1221: istore 11
    //   1223: ldc_w 292
    //   1226: iconst_2
    //   1227: aload_1
    //   1228: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1231: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1259: istore 14
    //   1261: iload 8
    //   1263: istore 10
    //   1265: iload 4
    //   1267: istore 15
    //   1269: iload 8
    //   1271: istore 11
    //   1273: aload_1
    //   1274: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
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
    //   1299: istore 14
    //   1301: iload 8
    //   1303: istore 10
    //   1305: iload 4
    //   1307: istore 15
    //   1309: iload 8
    //   1311: istore 11
    //   1313: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   1341: istore 14
    //   1343: iload 8
    //   1345: istore 10
    //   1347: iload 4
    //   1349: istore 15
    //   1351: iload 8
    //   1353: istore 11
    //   1355: ldc_w 292
    //   1358: iconst_2
    //   1359: aload_1
    //   1360: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1363: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1366: aload 34
    //   1368: astore_1
    //   1369: iload 7
    //   1371: istore 9
    //   1373: iload 4
    //   1375: istore 7
    //   1377: iload 8
    //   1379: istore 4
    //   1381: goto -593 -> 788
    //   1384: new 347	android/graphics/BitmapFactory$Options
    //   1387: dup
    //   1388: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   1391: astore 41
    //   1393: aload 41
    //   1395: iconst_1
    //   1396: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1399: aload 34
    //   1401: aconst_null
    //   1402: aload 41
    //   1404: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1407: pop
    //   1408: aload 34
    //   1410: invokevirtual 339	java/io/InputStream:close	()V
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
    //   1430: getfield 360	android/graphics/BitmapFactory$Options:outWidth	I
    //   1433: istore 15
    //   1435: aload_1
    //   1436: astore 34
    //   1438: iload 21
    //   1440: istore 8
    //   1442: aload 41
    //   1444: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
    //   1447: istore 16
    //   1449: iload 15
    //   1451: sipush 12800
    //   1454: if_icmpgt +11 -> 1465
    //   1457: iload 16
    //   1459: sipush 12800
    //   1462: if_icmple +65 -> 1527
    //   1465: iconst_0
    //   1466: istore 7
    //   1468: iload 6
    //   1470: ifeq +14 -> 1484
    //   1473: invokestatic 98	aokb:a	()Laokb;
    //   1476: lload 28
    //   1478: ldc_w 292
    //   1481: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   1484: iload 7
    //   1486: istore 4
    //   1488: iconst_0
    //   1489: ifeq -1478 -> 11
    //   1492: new 365	java/lang/NullPointerException
    //   1495: dup
    //   1496: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   1499: athrow
    //   1500: astore_0
    //   1501: aload_0
    //   1502: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   1505: iload 7
    //   1507: istore 4
    //   1509: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1512: ifeq -1501 -> 11
    //   1515: ldc 43
    //   1517: iconst_2
    //   1518: aload_0
    //   1519: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   1522: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1525: iconst_0
    //   1526: ireturn
    //   1527: aload_1
    //   1528: astore 34
    //   1530: iload 21
    //   1532: istore 8
    //   1534: iload 15
    //   1536: iload 16
    //   1538: invokestatic 201	bijo:a	(II)Z
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
    //   1566: invokestatic 203	yxi:a	()I
    //   1569: pop
    //   1570: iconst_1
    //   1571: istore 7
    //   1573: aload 35
    //   1575: astore_1
    //   1576: aload 41
    //   1578: aload 41
    //   1580: sipush 1280
    //   1583: sipush 1280
    //   1586: invokestatic 373	ajpz:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1589: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1592: aload 35
    //   1594: astore_1
    //   1595: aload 41
    //   1597: iconst_0
    //   1598: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1601: aload 36
    //   1603: astore 34
    //   1605: aload 35
    //   1607: astore_1
    //   1608: aload 42
    //   1610: aload_0
    //   1611: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1614: astore 35
    //   1616: aload 35
    //   1618: astore 34
    //   1620: aload 35
    //   1622: astore_1
    //   1623: aload 35
    //   1625: astore 37
    //   1627: aload 35
    //   1629: astore 38
    //   1631: aload 35
    //   1633: astore 36
    //   1635: aload 35
    //   1637: astore 39
    //   1639: aload 35
    //   1641: aconst_null
    //   1642: aload 41
    //   1644: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1647: astore 43
    //   1649: aload 35
    //   1651: astore 34
    //   1653: aload 35
    //   1655: astore_1
    //   1656: aload 35
    //   1658: astore 37
    //   1660: aload 35
    //   1662: astore 38
    //   1664: aload 35
    //   1666: astore 36
    //   1668: aload 35
    //   1670: astore 39
    //   1672: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1675: ifeq +70 -> 1745
    //   1678: aload 35
    //   1680: astore 34
    //   1682: aload 35
    //   1684: astore_1
    //   1685: aload 35
    //   1687: astore 37
    //   1689: aload 35
    //   1691: astore 38
    //   1693: aload 35
    //   1695: astore 36
    //   1697: aload 35
    //   1699: astore 39
    //   1701: ldc_w 292
    //   1704: iconst_4
    //   1705: ldc_w 378
    //   1708: iconst_3
    //   1709: anewarray 4	java/lang/Object
    //   1712: dup
    //   1713: iconst_0
    //   1714: iload 15
    //   1716: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1719: aastore
    //   1720: dup
    //   1721: iconst_1
    //   1722: iload 16
    //   1724: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1727: aastore
    //   1728: dup
    //   1729: iconst_2
    //   1730: aload 41
    //   1732: getfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1735: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1738: aastore
    //   1739: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1742: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1745: aload 35
    //   1747: astore 34
    //   1749: aload 35
    //   1751: astore_1
    //   1752: aload 35
    //   1754: astore 37
    //   1756: aload 35
    //   1758: astore 38
    //   1760: aload 35
    //   1762: astore 36
    //   1764: aload 35
    //   1766: astore 39
    //   1768: aload 35
    //   1770: invokevirtual 339	java/io/InputStream:close	()V
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
    //   1793: invokestatic 225	yxi:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
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
    //   1818: istore 12
    //   1820: iload 4
    //   1822: istore 13
    //   1824: iload 4
    //   1826: istore 14
    //   1828: iload 4
    //   1830: istore 11
    //   1832: iload 10
    //   1834: iload 4
    //   1836: invokestatic 227	yxi:a	(II)I
    //   1839: istore 17
    //   1841: iload 17
    //   1843: ifle +4064 -> 5907
    //   1846: iload 15
    //   1848: iload 16
    //   1850: iconst_2
    //   1851: imul
    //   1852: if_icmplt +1094 -> 2946
    //   1855: iload 16
    //   1857: sipush 1280
    //   1860: if_icmpge +1086 -> 2946
    //   1863: iconst_1
    //   1864: istore 8
    //   1866: iload 15
    //   1868: iconst_2
    //   1869: imul
    //   1870: iload 16
    //   1872: if_icmpgt +1080 -> 2952
    //   1875: iload 15
    //   1877: sipush 1280
    //   1880: if_icmpge +1072 -> 2952
    //   1883: iconst_1
    //   1884: istore 9
    //   1886: iload 9
    //   1888: ifeq +1161 -> 3049
    //   1891: aload 36
    //   1893: astore_1
    //   1894: iload 4
    //   1896: istore 12
    //   1898: iload 4
    //   1900: istore 13
    //   1902: iload 4
    //   1904: istore 14
    //   1906: iload 4
    //   1908: istore 11
    //   1910: aload 42
    //   1912: aload_0
    //   1913: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1916: astore 34
    //   1918: aload 34
    //   1920: astore 35
    //   1922: aload 34
    //   1924: astore_1
    //   1925: aload 34
    //   1927: astore 37
    //   1929: iload 4
    //   1931: istore 11
    //   1933: aload 34
    //   1935: astore 36
    //   1937: iload 4
    //   1939: istore 13
    //   1941: aload 34
    //   1943: astore 38
    //   1945: iload 4
    //   1947: istore 12
    //   1949: aload 34
    //   1951: astore 39
    //   1953: iload 4
    //   1955: istore 9
    //   1957: aload 34
    //   1959: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1962: astore 43
    //   1964: aload 34
    //   1966: astore 35
    //   1968: aload 34
    //   1970: astore_1
    //   1971: aload 34
    //   1973: astore 37
    //   1975: iload 4
    //   1977: istore 11
    //   1979: aload 34
    //   1981: astore 36
    //   1983: iload 4
    //   1985: istore 13
    //   1987: aload 34
    //   1989: astore 38
    //   1991: iload 4
    //   1993: istore 12
    //   1995: aload 34
    //   1997: astore 39
    //   1999: iload 4
    //   2001: istore 9
    //   2003: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2006: ifeq +70 -> 2076
    //   2009: aload 34
    //   2011: astore 35
    //   2013: aload 34
    //   2015: astore_1
    //   2016: aload 34
    //   2018: astore 37
    //   2020: iload 4
    //   2022: istore 11
    //   2024: aload 34
    //   2026: astore 36
    //   2028: iload 4
    //   2030: istore 13
    //   2032: aload 34
    //   2034: astore 38
    //   2036: iload 4
    //   2038: istore 12
    //   2040: aload 34
    //   2042: astore 39
    //   2044: iload 4
    //   2046: istore 9
    //   2048: ldc_w 292
    //   2051: iconst_4
    //   2052: new 45	java/lang/StringBuilder
    //   2055: dup
    //   2056: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2059: ldc_w 383
    //   2062: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: aload 43
    //   2067: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2070: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2073: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2076: aload 34
    //   2078: astore 35
    //   2080: aload 34
    //   2082: astore_1
    //   2083: aload 34
    //   2085: astore 37
    //   2087: iload 4
    //   2089: istore 11
    //   2091: aload 34
    //   2093: astore 36
    //   2095: iload 4
    //   2097: istore 13
    //   2099: aload 34
    //   2101: astore 38
    //   2103: iload 4
    //   2105: istore 12
    //   2107: aload 34
    //   2109: astore 39
    //   2111: iload 4
    //   2113: istore 9
    //   2115: aload 34
    //   2117: invokevirtual 339	java/io/InputStream:close	()V
    //   2120: aconst_null
    //   2121: astore 37
    //   2123: aconst_null
    //   2124: astore 34
    //   2126: aconst_null
    //   2127: astore 36
    //   2129: aconst_null
    //   2130: astore 35
    //   2132: aload 43
    //   2134: ifnull +3779 -> 5913
    //   2137: iload 4
    //   2139: istore 9
    //   2141: iload 4
    //   2143: istore 12
    //   2145: iload 4
    //   2147: istore 13
    //   2149: iload 4
    //   2151: istore 8
    //   2153: iload 4
    //   2155: istore 11
    //   2157: iload 15
    //   2159: iload 15
    //   2161: imul
    //   2162: newarray int
    //   2164: astore 38
    //   2166: iload 4
    //   2168: istore 9
    //   2170: iload 4
    //   2172: istore 12
    //   2174: iload 4
    //   2176: istore 13
    //   2178: iload 4
    //   2180: istore 8
    //   2182: iload 4
    //   2184: istore 11
    //   2186: aload 43
    //   2188: aload 38
    //   2190: iconst_0
    //   2191: iload 15
    //   2193: iconst_0
    //   2194: iconst_0
    //   2195: iload 15
    //   2197: iload 15
    //   2199: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2202: iload 4
    //   2204: istore 9
    //   2206: iload 4
    //   2208: istore 12
    //   2210: iload 4
    //   2212: istore 13
    //   2214: iload 4
    //   2216: istore 8
    //   2218: iload 4
    //   2220: istore 11
    //   2222: iload 15
    //   2224: iload 15
    //   2226: imul
    //   2227: newarray byte
    //   2229: astore_1
    //   2230: iload 4
    //   2232: istore 9
    //   2234: iload 4
    //   2236: istore 12
    //   2238: iload 4
    //   2240: istore 13
    //   2242: iload 4
    //   2244: istore 8
    //   2246: iload 4
    //   2248: istore 11
    //   2250: aload 38
    //   2252: aload_1
    //   2253: iload 15
    //   2255: iload 15
    //   2257: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2260: pop
    //   2261: iload 4
    //   2263: istore 9
    //   2265: iload 4
    //   2267: istore 12
    //   2269: iload 4
    //   2271: istore 13
    //   2273: iload 4
    //   2275: istore 8
    //   2277: iload 4
    //   2279: istore 11
    //   2281: iload 4
    //   2283: aload 38
    //   2285: aload_1
    //   2286: iload 15
    //   2288: iload 15
    //   2290: iload 17
    //   2292: aload 40
    //   2294: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2297: ior
    //   2298: istore 4
    //   2300: iload 4
    //   2302: iconst_1
    //   2303: if_icmpeq +3607 -> 5910
    //   2306: iload 4
    //   2308: istore 9
    //   2310: iload 4
    //   2312: istore 12
    //   2314: iload 4
    //   2316: istore 13
    //   2318: iload 4
    //   2320: istore 8
    //   2322: iload 4
    //   2324: istore 11
    //   2326: aload 43
    //   2328: aload 38
    //   2330: iconst_0
    //   2331: iload 15
    //   2333: iconst_0
    //   2334: iload 16
    //   2336: iload 15
    //   2338: isub
    //   2339: iload 15
    //   2341: iload 15
    //   2343: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2346: iload 4
    //   2348: istore 9
    //   2350: iload 4
    //   2352: istore 12
    //   2354: iload 4
    //   2356: istore 13
    //   2358: iload 4
    //   2360: istore 8
    //   2362: iload 4
    //   2364: istore 11
    //   2366: aload 38
    //   2368: aload_1
    //   2369: iload 15
    //   2371: iload 15
    //   2373: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2376: pop
    //   2377: iload 4
    //   2379: istore 9
    //   2381: iload 4
    //   2383: istore 12
    //   2385: iload 4
    //   2387: istore 13
    //   2389: iload 4
    //   2391: istore 8
    //   2393: iload 4
    //   2395: istore 11
    //   2397: aload 38
    //   2399: aload_1
    //   2400: iload 15
    //   2402: iload 15
    //   2404: iload 17
    //   2406: aload 40
    //   2408: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2411: istore 14
    //   2413: iload 14
    //   2415: iload 4
    //   2417: ior
    //   2418: istore 4
    //   2420: aload 43
    //   2422: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2425: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2428: ifeq +44 -> 2472
    //   2431: ldc_w 292
    //   2434: iconst_4
    //   2435: ldc_w 385
    //   2438: iconst_3
    //   2439: anewarray 4	java/lang/Object
    //   2442: dup
    //   2443: iconst_0
    //   2444: iload 17
    //   2446: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2449: aastore
    //   2450: dup
    //   2451: iconst_1
    //   2452: iload 4
    //   2454: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2457: aastore
    //   2458: dup
    //   2459: iconst_2
    //   2460: aload 40
    //   2462: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2465: aastore
    //   2466: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
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
    //   2488: invokestatic 227	yxi:a	(II)I
    //   2491: istore 13
    //   2493: iload 13
    //   2495: ifle +3402 -> 5897
    //   2498: aload 34
    //   2500: astore_1
    //   2501: iload 15
    //   2503: iload 16
    //   2505: invokestatic 232	java/lang/Math:min	(II)I
    //   2508: istore 8
    //   2510: iload 8
    //   2512: sipush 250
    //   2515: if_icmple +3382 -> 5897
    //   2518: aload 34
    //   2520: astore_1
    //   2521: aload 41
    //   2523: iload 8
    //   2525: i2d
    //   2526: ldc2_w 233
    //   2529: ddiv
    //   2530: invokestatic 238	java/lang/Math:ceil	(D)D
    //   2533: d2i
    //   2534: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2537: aload 34
    //   2539: astore_1
    //   2540: aload 42
    //   2542: aload_0
    //   2543: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2546: astore 34
    //   2548: aload 34
    //   2550: astore 35
    //   2552: aload 34
    //   2554: astore_1
    //   2555: aload 34
    //   2557: astore 39
    //   2559: iload 4
    //   2561: istore 11
    //   2563: aload 34
    //   2565: astore 38
    //   2567: iload 4
    //   2569: istore 9
    //   2571: aload 34
    //   2573: astore 36
    //   2575: iload 4
    //   2577: istore 12
    //   2579: aload 34
    //   2581: astore 37
    //   2583: iload 4
    //   2585: istore 8
    //   2587: aload 34
    //   2589: aconst_null
    //   2590: aload 41
    //   2592: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2595: astore 41
    //   2597: aload 34
    //   2599: astore 35
    //   2601: aload 34
    //   2603: astore_1
    //   2604: aload 34
    //   2606: astore 39
    //   2608: iload 4
    //   2610: istore 11
    //   2612: aload 34
    //   2614: astore 38
    //   2616: iload 4
    //   2618: istore 9
    //   2620: aload 34
    //   2622: astore 36
    //   2624: iload 4
    //   2626: istore 12
    //   2628: aload 34
    //   2630: astore 37
    //   2632: iload 4
    //   2634: istore 8
    //   2636: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2639: ifeq +70 -> 2709
    //   2642: aload 34
    //   2644: astore 35
    //   2646: aload 34
    //   2648: astore_1
    //   2649: aload 34
    //   2651: astore 39
    //   2653: iload 4
    //   2655: istore 11
    //   2657: aload 34
    //   2659: astore 38
    //   2661: iload 4
    //   2663: istore 9
    //   2665: aload 34
    //   2667: astore 36
    //   2669: iload 4
    //   2671: istore 12
    //   2673: aload 34
    //   2675: astore 37
    //   2677: iload 4
    //   2679: istore 8
    //   2681: ldc_w 292
    //   2684: iconst_4
    //   2685: new 45	java/lang/StringBuilder
    //   2688: dup
    //   2689: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2692: ldc_w 387
    //   2695: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2698: aload 41
    //   2700: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2703: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2706: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2709: aload 34
    //   2711: astore 35
    //   2713: aload 34
    //   2715: astore_1
    //   2716: aload 34
    //   2718: astore 39
    //   2720: iload 4
    //   2722: istore 11
    //   2724: aload 34
    //   2726: astore 38
    //   2728: iload 4
    //   2730: istore 9
    //   2732: aload 34
    //   2734: astore 36
    //   2736: iload 4
    //   2738: istore 12
    //   2740: aload 34
    //   2742: astore 37
    //   2744: iload 4
    //   2746: istore 8
    //   2748: aload 34
    //   2750: invokevirtual 339	java/io/InputStream:close	()V
    //   2753: aload 41
    //   2755: ifnull +3135 -> 5890
    //   2758: aload 41
    //   2760: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   2763: istore 9
    //   2765: aload 41
    //   2767: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
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
    //   2792: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2795: aload 41
    //   2797: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2800: aload_1
    //   2801: aconst_null
    //   2802: iload 9
    //   2804: iload 8
    //   2806: iload 13
    //   2808: aload 40
    //   2810: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2813: istore 8
    //   2815: iload 8
    //   2817: iload 4
    //   2819: ior
    //   2820: istore 4
    //   2822: iload 4
    //   2824: istore 8
    //   2826: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2829: ifeq +48 -> 2877
    //   2832: ldc_w 292
    //   2835: iconst_4
    //   2836: ldc_w 389
    //   2839: iconst_3
    //   2840: anewarray 4	java/lang/Object
    //   2843: dup
    //   2844: iconst_0
    //   2845: iload 13
    //   2847: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2850: aastore
    //   2851: dup
    //   2852: iconst_1
    //   2853: iload 4
    //   2855: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2858: aastore
    //   2859: dup
    //   2860: iconst_2
    //   2861: aload 40
    //   2863: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2866: aastore
    //   2867: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
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
    //   2897: astore 37
    //   2899: aload 34
    //   2901: astore 38
    //   2903: aload 34
    //   2905: astore 36
    //   2907: aload 34
    //   2909: astore 39
    //   2911: aload 35
    //   2913: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2916: aload 34
    //   2918: astore_1
    //   2919: aload 34
    //   2921: astore 37
    //   2923: aload 34
    //   2925: astore 38
    //   2927: aload 34
    //   2929: astore 36
    //   2931: aload 34
    //   2933: astore 39
    //   2935: aload 34
    //   2937: invokevirtual 339	java/io/InputStream:close	()V
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
    //   2971: astore 37
    //   2973: iload 4
    //   2975: istore 11
    //   2977: aload 34
    //   2979: astore 36
    //   2981: iload 4
    //   2983: istore 13
    //   2985: aload 34
    //   2987: astore 38
    //   2989: iload 4
    //   2991: istore 12
    //   2993: aload 34
    //   2995: astore 39
    //   2997: iload 4
    //   2999: istore 9
    //   3001: aload 35
    //   3003: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3006: aload 34
    //   3008: astore_1
    //   3009: aload 34
    //   3011: astore 37
    //   3013: iload 4
    //   3015: istore 11
    //   3017: aload 34
    //   3019: astore 36
    //   3021: iload 4
    //   3023: istore 13
    //   3025: aload 34
    //   3027: astore 38
    //   3029: iload 4
    //   3031: istore 12
    //   3033: aload 34
    //   3035: astore 39
    //   3037: iload 4
    //   3039: istore 9
    //   3041: aload 34
    //   3043: invokevirtual 339	java/io/InputStream:close	()V
    //   3046: goto -574 -> 2472
    //   3049: iload 8
    //   3051: ifeq +2856 -> 5907
    //   3054: iload 4
    //   3056: istore 8
    //   3058: aload 36
    //   3060: astore_1
    //   3061: iload 4
    //   3063: istore 12
    //   3065: iload 4
    //   3067: istore 13
    //   3069: iload 4
    //   3071: istore 14
    //   3073: iload 4
    //   3075: istore 11
    //   3077: aload 42
    //   3079: aload_0
    //   3080: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3083: astore 35
    //   3085: aload 35
    //   3087: astore 34
    //   3089: iload 4
    //   3091: istore 8
    //   3093: aload 35
    //   3095: astore_1
    //   3096: aload 35
    //   3098: astore 37
    //   3100: iload 4
    //   3102: istore 11
    //   3104: aload 35
    //   3106: astore 36
    //   3108: iload 4
    //   3110: istore 13
    //   3112: aload 35
    //   3114: astore 38
    //   3116: iload 4
    //   3118: istore 12
    //   3120: aload 35
    //   3122: astore 39
    //   3124: iload 4
    //   3126: istore 9
    //   3128: aload 35
    //   3130: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3133: astore 43
    //   3135: aload 35
    //   3137: astore 34
    //   3139: iload 4
    //   3141: istore 8
    //   3143: aload 35
    //   3145: astore_1
    //   3146: aload 35
    //   3148: astore 37
    //   3150: iload 4
    //   3152: istore 11
    //   3154: aload 35
    //   3156: astore 36
    //   3158: iload 4
    //   3160: istore 13
    //   3162: aload 35
    //   3164: astore 38
    //   3166: iload 4
    //   3168: istore 12
    //   3170: aload 35
    //   3172: astore 39
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
    //   3197: astore 37
    //   3199: iload 4
    //   3201: istore 11
    //   3203: aload 35
    //   3205: astore 36
    //   3207: iload 4
    //   3209: istore 13
    //   3211: aload 35
    //   3213: astore 38
    //   3215: iload 4
    //   3217: istore 12
    //   3219: aload 35
    //   3221: astore 39
    //   3223: iload 4
    //   3225: istore 9
    //   3227: ldc_w 292
    //   3230: iconst_4
    //   3231: new 45	java/lang/StringBuilder
    //   3234: dup
    //   3235: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3238: ldc_w 391
    //   3241: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: aload 43
    //   3246: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3249: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3252: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3255: aload 35
    //   3257: astore 34
    //   3259: iload 4
    //   3261: istore 8
    //   3263: aload 35
    //   3265: astore_1
    //   3266: aload 35
    //   3268: astore 37
    //   3270: iload 4
    //   3272: istore 11
    //   3274: aload 35
    //   3276: astore 36
    //   3278: iload 4
    //   3280: istore 13
    //   3282: aload 35
    //   3284: astore 38
    //   3286: iload 4
    //   3288: istore 12
    //   3290: aload 35
    //   3292: astore 39
    //   3294: iload 4
    //   3296: istore 9
    //   3298: aload 35
    //   3300: invokevirtual 339	java/io/InputStream:close	()V
    //   3303: aconst_null
    //   3304: astore 36
    //   3306: aconst_null
    //   3307: astore 35
    //   3309: iload 4
    //   3311: istore 9
    //   3313: aload 43
    //   3315: ifnull +488 -> 3803
    //   3318: aload 35
    //   3320: astore 34
    //   3322: iload 4
    //   3324: istore 8
    //   3326: aload 36
    //   3328: astore_1
    //   3329: iload 4
    //   3331: istore 12
    //   3333: iload 4
    //   3335: istore 13
    //   3337: iload 4
    //   3339: istore 14
    //   3341: iload 4
    //   3343: istore 11
    //   3345: iload 16
    //   3347: iload 16
    //   3349: imul
    //   3350: newarray int
    //   3352: astore 37
    //   3354: aload 35
    //   3356: astore 34
    //   3358: iload 4
    //   3360: istore 8
    //   3362: aload 36
    //   3364: astore_1
    //   3365: iload 4
    //   3367: istore 12
    //   3369: iload 4
    //   3371: istore 13
    //   3373: iload 4
    //   3375: istore 14
    //   3377: iload 4
    //   3379: istore 11
    //   3381: aload 43
    //   3383: aload 37
    //   3385: iconst_0
    //   3386: iload 16
    //   3388: iconst_0
    //   3389: iconst_0
    //   3390: iload 16
    //   3392: iload 16
    //   3394: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3397: aload 35
    //   3399: astore 34
    //   3401: iload 4
    //   3403: istore 8
    //   3405: aload 36
    //   3407: astore_1
    //   3408: iload 4
    //   3410: istore 12
    //   3412: iload 4
    //   3414: istore 13
    //   3416: iload 4
    //   3418: istore 14
    //   3420: iload 4
    //   3422: istore 11
    //   3424: iload 16
    //   3426: iload 16
    //   3428: imul
    //   3429: newarray byte
    //   3431: astore 38
    //   3433: aload 35
    //   3435: astore 34
    //   3437: iload 4
    //   3439: istore 8
    //   3441: aload 36
    //   3443: astore_1
    //   3444: iload 4
    //   3446: istore 12
    //   3448: iload 4
    //   3450: istore 13
    //   3452: iload 4
    //   3454: istore 14
    //   3456: iload 4
    //   3458: istore 11
    //   3460: aload 37
    //   3462: aload 38
    //   3464: iload 16
    //   3466: iload 16
    //   3468: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3471: pop
    //   3472: aload 35
    //   3474: astore 34
    //   3476: iload 4
    //   3478: istore 8
    //   3480: aload 36
    //   3482: astore_1
    //   3483: iload 4
    //   3485: istore 12
    //   3487: iload 4
    //   3489: istore 13
    //   3491: iload 4
    //   3493: istore 14
    //   3495: iload 4
    //   3497: istore 11
    //   3499: iload 4
    //   3501: aload 37
    //   3503: aload 38
    //   3505: iload 16
    //   3507: iload 16
    //   3509: iload 17
    //   3511: aload 40
    //   3513: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3516: ior
    //   3517: istore 9
    //   3519: iload 9
    //   3521: istore 4
    //   3523: iload 9
    //   3525: iconst_1
    //   3526: if_icmpeq +136 -> 3662
    //   3529: aload 35
    //   3531: astore 34
    //   3533: iload 9
    //   3535: istore 8
    //   3537: aload 36
    //   3539: astore_1
    //   3540: iload 9
    //   3542: istore 12
    //   3544: iload 9
    //   3546: istore 13
    //   3548: iload 9
    //   3550: istore 14
    //   3552: iload 9
    //   3554: istore 11
    //   3556: aload 43
    //   3558: aload 37
    //   3560: iconst_0
    //   3561: iload 16
    //   3563: iload 15
    //   3565: iload 16
    //   3567: isub
    //   3568: iconst_0
    //   3569: iload 16
    //   3571: iload 16
    //   3573: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3576: aload 35
    //   3578: astore 34
    //   3580: iload 9
    //   3582: istore 8
    //   3584: aload 36
    //   3586: astore_1
    //   3587: iload 9
    //   3589: istore 12
    //   3591: iload 9
    //   3593: istore 13
    //   3595: iload 9
    //   3597: istore 14
    //   3599: iload 9
    //   3601: istore 11
    //   3603: aload 37
    //   3605: aload 38
    //   3607: iload 16
    //   3609: iload 16
    //   3611: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3614: pop
    //   3615: aload 35
    //   3617: astore 34
    //   3619: iload 9
    //   3621: istore 8
    //   3623: aload 36
    //   3625: astore_1
    //   3626: iload 9
    //   3628: istore 12
    //   3630: iload 9
    //   3632: istore 13
    //   3634: iload 9
    //   3636: istore 14
    //   3638: iload 9
    //   3640: istore 11
    //   3642: iload 9
    //   3644: aload 37
    //   3646: aload 38
    //   3648: iload 16
    //   3650: iload 16
    //   3652: iload 17
    //   3654: aload 40
    //   3656: invokestatic 176	yxi:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3659: ior
    //   3660: istore 4
    //   3662: aload 35
    //   3664: astore 34
    //   3666: iload 4
    //   3668: istore 8
    //   3670: aload 36
    //   3672: astore_1
    //   3673: iload 4
    //   3675: istore 12
    //   3677: iload 4
    //   3679: istore 13
    //   3681: iload 4
    //   3683: istore 14
    //   3685: iload 4
    //   3687: istore 11
    //   3689: aload 43
    //   3691: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   3694: iload 4
    //   3696: istore 9
    //   3698: aload 35
    //   3700: astore 34
    //   3702: iload 4
    //   3704: istore 8
    //   3706: aload 36
    //   3708: astore_1
    //   3709: iload 4
    //   3711: istore 12
    //   3713: iload 4
    //   3715: istore 13
    //   3717: iload 4
    //   3719: istore 14
    //   3721: iload 4
    //   3723: istore 11
    //   3725: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3728: ifeq +75 -> 3803
    //   3731: aload 35
    //   3733: astore 34
    //   3735: iload 4
    //   3737: istore 8
    //   3739: aload 36
    //   3741: astore_1
    //   3742: iload 4
    //   3744: istore 12
    //   3746: iload 4
    //   3748: istore 13
    //   3750: iload 4
    //   3752: istore 14
    //   3754: iload 4
    //   3756: istore 11
    //   3758: ldc_w 292
    //   3761: iconst_4
    //   3762: ldc_w 393
    //   3765: iconst_3
    //   3766: anewarray 4	java/lang/Object
    //   3769: dup
    //   3770: iconst_0
    //   3771: iload 17
    //   3773: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3776: aastore
    //   3777: dup
    //   3778: iconst_1
    //   3779: iload 4
    //   3781: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3784: aastore
    //   3785: dup
    //   3786: iconst_2
    //   3787: aload 40
    //   3789: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3792: aastore
    //   3793: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
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
    //   3817: astore 37
    //   3819: iload 8
    //   3821: istore 11
    //   3823: aload 34
    //   3825: astore 36
    //   3827: iload 8
    //   3829: istore 13
    //   3831: aload 34
    //   3833: astore 38
    //   3835: iload 8
    //   3837: istore 12
    //   3839: aload 34
    //   3841: astore 39
    //   3843: iload 8
    //   3845: istore 9
    //   3847: aload 35
    //   3849: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3852: aload 34
    //   3854: astore_1
    //   3855: aload 34
    //   3857: astore 37
    //   3859: iload 8
    //   3861: istore 11
    //   3863: aload 34
    //   3865: astore 36
    //   3867: iload 8
    //   3869: istore 13
    //   3871: aload 34
    //   3873: astore 38
    //   3875: iload 8
    //   3877: istore 12
    //   3879: aload 34
    //   3881: astore 39
    //   3883: iload 8
    //   3885: istore 9
    //   3887: aload 34
    //   3889: invokevirtual 339	java/io/InputStream:close	()V
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
    //   3912: astore 39
    //   3914: iload 4
    //   3916: istore 11
    //   3918: aload 34
    //   3920: astore 38
    //   3922: iload 4
    //   3924: istore 9
    //   3926: aload 34
    //   3928: astore 36
    //   3930: iload 4
    //   3932: istore 12
    //   3934: aload 34
    //   3936: astore 37
    //   3938: iload 4
    //   3940: istore 8
    //   3942: aload 35
    //   3944: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3947: aload 34
    //   3949: astore_1
    //   3950: aload 34
    //   3952: astore 39
    //   3954: iload 4
    //   3956: istore 11
    //   3958: aload 34
    //   3960: astore 38
    //   3962: iload 4
    //   3964: istore 9
    //   3966: aload 34
    //   3968: astore 36
    //   3970: iload 4
    //   3972: istore 12
    //   3974: aload 34
    //   3976: astore 37
    //   3978: iload 4
    //   3980: istore 8
    //   3982: aload 34
    //   3984: invokevirtual 339	java/io/InputStream:close	()V
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
    //   4008: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4011: iload 4
    //   4013: istore 6
    //   4015: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4018: ifeq -2986 -> 1032
    //   4021: ldc 43
    //   4023: iconst_2
    //   4024: aload_1
    //   4025: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4028: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4031: iload 4
    //   4033: istore 6
    //   4035: goto -3003 -> 1032
    //   4038: astore_1
    //   4039: iconst_0
    //   4040: istore 6
    //   4042: iconst_0
    //   4043: istore 4
    //   4045: aload 38
    //   4047: astore 34
    //   4049: iload 12
    //   4051: istore 7
    //   4053: aload_1
    //   4054: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4057: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4060: ifeq +14 -> 4074
    //   4063: ldc_w 292
    //   4066: iconst_2
    //   4067: aload_1
    //   4068: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4071: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4074: iload 7
    //   4076: ifeq +7 -> 4083
    //   4079: invokestatic 256	yxi:b	()I
    //   4082: pop
    //   4083: iload 6
    //   4085: ifeq +14 -> 4099
    //   4088: invokestatic 98	aokb:a	()Laokb;
    //   4091: lload 28
    //   4093: ldc_w 292
    //   4096: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   4099: iload 4
    //   4101: istore 6
    //   4103: aload 34
    //   4105: ifnull -3073 -> 1032
    //   4108: aload 34
    //   4110: invokevirtual 339	java/io/InputStream:close	()V
    //   4113: iload 4
    //   4115: istore 6
    //   4117: goto -3085 -> 1032
    //   4120: astore_1
    //   4121: aload_1
    //   4122: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4125: iload 4
    //   4127: istore 6
    //   4129: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4132: ifeq -3100 -> 1032
    //   4135: ldc 43
    //   4137: iconst_2
    //   4138: aload_1
    //   4139: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4142: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4145: iload 4
    //   4147: istore 6
    //   4149: goto -3117 -> 1032
    //   4152: astore_1
    //   4153: ldc2_w 298
    //   4156: lstore 30
    //   4158: iconst_0
    //   4159: istore 6
    //   4161: iconst_0
    //   4162: istore 7
    //   4164: iconst_0
    //   4165: istore 4
    //   4167: aload 35
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
    //   4188: invokevirtual 267	java/lang/RuntimeException:printStackTrace	()V
    //   4191: aload 34
    //   4193: astore 5
    //   4195: lload 30
    //   4197: lstore 28
    //   4199: iload 6
    //   4201: istore 9
    //   4203: iload 7
    //   4205: istore 8
    //   4207: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4210: ifeq +30 -> 4240
    //   4213: aload 34
    //   4215: astore 5
    //   4217: lload 30
    //   4219: lstore 28
    //   4221: iload 6
    //   4223: istore 9
    //   4225: iload 7
    //   4227: istore 8
    //   4229: ldc_w 292
    //   4232: iconst_2
    //   4233: aload_1
    //   4234: invokevirtual 268	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   4237: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4240: iload 7
    //   4242: ifeq +7 -> 4249
    //   4245: invokestatic 256	yxi:b	()I
    //   4248: pop
    //   4249: iload 6
    //   4251: ifeq +14 -> 4265
    //   4254: invokestatic 98	aokb:a	()Laokb;
    //   4257: lload 30
    //   4259: ldc_w 292
    //   4262: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   4265: iload 4
    //   4267: istore 6
    //   4269: aload 34
    //   4271: ifnull -3239 -> 1032
    //   4274: aload 34
    //   4276: invokevirtual 339	java/io/InputStream:close	()V
    //   4279: iload 4
    //   4281: istore 6
    //   4283: goto -3251 -> 1032
    //   4286: astore_1
    //   4287: aload_1
    //   4288: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4291: iload 4
    //   4293: istore 6
    //   4295: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4298: ifeq -3266 -> 1032
    //   4301: ldc 43
    //   4303: iconst_2
    //   4304: aload_1
    //   4305: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4308: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4311: iload 4
    //   4313: istore 6
    //   4315: goto -3283 -> 1032
    //   4318: astore_1
    //   4319: ldc2_w 298
    //   4322: lstore 30
    //   4324: iconst_0
    //   4325: istore 6
    //   4327: iconst_0
    //   4328: istore 7
    //   4330: iconst_0
    //   4331: istore 4
    //   4333: aload 37
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
    //   4354: invokevirtual 272	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   4357: aload 34
    //   4359: astore 5
    //   4361: lload 30
    //   4363: lstore 28
    //   4365: iload 6
    //   4367: istore 9
    //   4369: iload 7
    //   4371: istore 8
    //   4373: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4376: ifeq +30 -> 4406
    //   4379: aload 34
    //   4381: astore 5
    //   4383: lload 30
    //   4385: lstore 28
    //   4387: iload 6
    //   4389: istore 9
    //   4391: iload 7
    //   4393: istore 8
    //   4395: ldc_w 292
    //   4398: iconst_2
    //   4399: aload_1
    //   4400: invokevirtual 273	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   4403: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4406: iload 7
    //   4408: ifeq +7 -> 4415
    //   4411: invokestatic 256	yxi:b	()I
    //   4414: pop
    //   4415: iload 6
    //   4417: ifeq +14 -> 4431
    //   4420: invokestatic 98	aokb:a	()Laokb;
    //   4423: lload 30
    //   4425: ldc_w 292
    //   4428: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   4431: iload 4
    //   4433: istore 6
    //   4435: aload 34
    //   4437: ifnull -3405 -> 1032
    //   4440: aload 34
    //   4442: invokevirtual 339	java/io/InputStream:close	()V
    //   4445: iload 4
    //   4447: istore 6
    //   4449: goto -3417 -> 1032
    //   4452: astore_1
    //   4453: aload_1
    //   4454: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4457: iload 4
    //   4459: istore 6
    //   4461: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4464: ifeq -3432 -> 1032
    //   4467: ldc 43
    //   4469: iconst_2
    //   4470: aload_1
    //   4471: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4474: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4477: iload 4
    //   4479: istore 6
    //   4481: goto -3449 -> 1032
    //   4484: astore_1
    //   4485: ldc2_w 298
    //   4488: lstore 30
    //   4490: iconst_0
    //   4491: istore 6
    //   4493: iconst_0
    //   4494: istore 7
    //   4496: iconst_0
    //   4497: istore 4
    //   4499: aload 36
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
    //   4520: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   4523: aload 34
    //   4525: astore 5
    //   4527: lload 30
    //   4529: lstore 28
    //   4531: iload 6
    //   4533: istore 9
    //   4535: iload 7
    //   4537: istore 8
    //   4539: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4542: ifeq +30 -> 4572
    //   4545: aload 34
    //   4547: astore 5
    //   4549: lload 30
    //   4551: lstore 28
    //   4553: iload 6
    //   4555: istore 9
    //   4557: iload 7
    //   4559: istore 8
    //   4561: ldc_w 292
    //   4564: iconst_2
    //   4565: aload_1
    //   4566: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4569: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4572: iload 7
    //   4574: ifeq +7 -> 4581
    //   4577: invokestatic 256	yxi:b	()I
    //   4580: pop
    //   4581: iload 6
    //   4583: ifeq +14 -> 4597
    //   4586: invokestatic 98	aokb:a	()Laokb;
    //   4589: lload 30
    //   4591: ldc_w 292
    //   4594: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   4597: iload 4
    //   4599: istore 6
    //   4601: aload 34
    //   4603: ifnull -3571 -> 1032
    //   4606: aload 34
    //   4608: invokevirtual 339	java/io/InputStream:close	()V
    //   4611: iload 4
    //   4613: istore 6
    //   4615: goto -3583 -> 1032
    //   4618: astore_1
    //   4619: aload_1
    //   4620: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4623: iload 4
    //   4625: istore 6
    //   4627: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4630: ifeq -3598 -> 1032
    //   4633: ldc 43
    //   4635: iconst_2
    //   4636: aload_1
    //   4637: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4640: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4643: iload 4
    //   4645: istore 6
    //   4647: goto -3615 -> 1032
    //   4650: astore_0
    //   4651: ldc2_w 298
    //   4654: lstore 28
    //   4656: iconst_0
    //   4657: istore 6
    //   4659: iconst_0
    //   4660: istore 7
    //   4662: aconst_null
    //   4663: astore_1
    //   4664: iload 7
    //   4666: ifeq +7 -> 4673
    //   4669: invokestatic 256	yxi:b	()I
    //   4672: pop
    //   4673: iload 6
    //   4675: ifeq +14 -> 4689
    //   4678: invokestatic 98	aokb:a	()Laokb;
    //   4681: lload 28
    //   4683: ldc_w 292
    //   4686: invokevirtual 259	aokb:a	(JLjava/lang/String;)V
    //   4689: aload_1
    //   4690: ifnull +7 -> 4697
    //   4693: aload_1
    //   4694: invokevirtual 339	java/io/InputStream:close	()V
    //   4697: aload_0
    //   4698: athrow
    //   4699: astore_1
    //   4700: aload_1
    //   4701: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4704: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4707: ifeq -10 -> 4697
    //   4710: ldc 43
    //   4712: iconst_2
    //   4713: aload_1
    //   4714: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4717: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4720: goto -23 -> 4697
    //   4723: astore_0
    //   4724: ldc2_w 298
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
    //   4905: aload 37
    //   4907: astore 34
    //   4909: iconst_0
    //   4910: istore 4
    //   4912: lload 28
    //   4914: lstore 30
    //   4916: goto -413 -> 4503
    //   4919: astore_1
    //   4920: aconst_null
    //   4921: astore 34
    //   4923: iload 12
    //   4925: istore 4
    //   4927: lload 28
    //   4929: lstore 30
    //   4931: goto -428 -> 4503
    //   4934: astore_1
    //   4935: aload 37
    //   4937: astore 34
    //   4939: iload 11
    //   4941: istore 4
    //   4943: lload 28
    //   4945: lstore 30
    //   4947: goto -444 -> 4503
    //   4950: astore_1
    //   4951: iload 9
    //   4953: istore 4
    //   4955: aload 36
    //   4957: astore 34
    //   4959: lload 28
    //   4961: lstore 30
    //   4963: goto -460 -> 4503
    //   4966: astore_1
    //   4967: aload 36
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
    //   4990: aload 39
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
    //   5162: aload 38
    //   5164: astore 34
    //   5166: iconst_0
    //   5167: istore 4
    //   5169: lload 28
    //   5171: lstore 30
    //   5173: goto -836 -> 4337
    //   5176: astore_1
    //   5177: aconst_null
    //   5178: astore 34
    //   5180: iload 13
    //   5182: istore 4
    //   5184: lload 28
    //   5186: lstore 30
    //   5188: goto -851 -> 4337
    //   5191: astore_1
    //   5192: aload 36
    //   5194: astore 34
    //   5196: iload 13
    //   5198: istore 4
    //   5200: lload 28
    //   5202: lstore 30
    //   5204: goto -867 -> 4337
    //   5207: astore_1
    //   5208: iload 12
    //   5210: istore 4
    //   5212: lload 28
    //   5214: lstore 30
    //   5216: goto -879 -> 4337
    //   5219: astore_1
    //   5220: lload 28
    //   5222: lstore 30
    //   5224: goto -887 -> 4337
    //   5227: astore_1
    //   5228: aconst_null
    //   5229: astore 34
    //   5231: lload 28
    //   5233: lstore 30
    //   5235: goto -898 -> 4337
    //   5238: astore_1
    //   5239: aload 38
    //   5241: astore 34
    //   5243: iload 9
    //   5245: istore 4
    //   5247: lload 28
    //   5249: lstore 30
    //   5251: goto -914 -> 4337
    //   5254: astore_1
    //   5255: aconst_null
    //   5256: astore 34
    //   5258: lload 28
    //   5260: lstore 30
    //   5262: goto -925 -> 4337
    //   5265: astore_1
    //   5266: aconst_null
    //   5267: astore 34
    //   5269: lload 28
    //   5271: lstore 30
    //   5273: goto -936 -> 4337
    //   5276: astore 5
    //   5278: aload_1
    //   5279: astore 34
    //   5281: aload 5
    //   5283: astore_1
    //   5284: lload 28
    //   5286: lstore 30
    //   5288: goto -951 -> 4337
    //   5291: astore_1
    //   5292: iload 10
    //   5294: istore 6
    //   5296: iconst_0
    //   5297: istore 7
    //   5299: iconst_0
    //   5300: istore 4
    //   5302: lload 28
    //   5304: lstore 30
    //   5306: goto -1135 -> 4171
    //   5309: astore_1
    //   5310: iconst_0
    //   5311: istore 7
    //   5313: iconst_0
    //   5314: istore 4
    //   5316: lload 28
    //   5318: lstore 30
    //   5320: goto -1149 -> 4171
    //   5323: astore_1
    //   5324: iload 14
    //   5326: istore 7
    //   5328: iload 10
    //   5330: istore 4
    //   5332: lload 28
    //   5334: lstore 30
    //   5336: goto -1165 -> 4171
    //   5339: astore_1
    //   5340: iload 4
    //   5342: istore 8
    //   5344: iload 7
    //   5346: istore 4
    //   5348: lload 28
    //   5350: lstore 30
    //   5352: iload 8
    //   5354: istore 7
    //   5356: goto -1185 -> 4171
    //   5359: astore_1
    //   5360: iload 4
    //   5362: istore 8
    //   5364: iload 7
    //   5366: istore 4
    //   5368: lload 28
    //   5370: lstore 30
    //   5372: iload 8
    //   5374: istore 7
    //   5376: goto -1205 -> 4171
    //   5379: astore_1
    //   5380: iconst_0
    //   5381: istore 7
    //   5383: aconst_null
    //   5384: astore 34
    //   5386: iconst_0
    //   5387: istore 4
    //   5389: lload 28
    //   5391: lstore 30
    //   5393: goto -1222 -> 4171
    //   5396: astore_1
    //   5397: aconst_null
    //   5398: astore 34
    //   5400: iconst_0
    //   5401: istore 4
    //   5403: lload 28
    //   5405: lstore 30
    //   5407: goto -1236 -> 4171
    //   5410: astore_1
    //   5411: aload 36
    //   5413: astore 34
    //   5415: iconst_0
    //   5416: istore 4
    //   5418: lload 28
    //   5420: lstore 30
    //   5422: goto -1251 -> 4171
    //   5425: astore_1
    //   5426: aconst_null
    //   5427: astore 34
    //   5429: iload 14
    //   5431: istore 4
    //   5433: lload 28
    //   5435: lstore 30
    //   5437: goto -1266 -> 4171
    //   5440: astore_1
    //   5441: aload 38
    //   5443: astore 34
    //   5445: iload 12
    //   5447: istore 4
    //   5449: lload 28
    //   5451: lstore 30
    //   5453: goto -1282 -> 4171
    //   5456: astore_1
    //   5457: iload 13
    //   5459: istore 4
    //   5461: aload 37
    //   5463: astore 34
    //   5465: lload 28
    //   5467: lstore 30
    //   5469: goto -1298 -> 4171
    //   5472: astore_1
    //   5473: aload 37
    //   5475: astore 34
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
    //   5575: iload 15
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
    //   5665: aload 39
    //   5667: astore 34
    //   5669: iload 9
    //   5671: istore 4
    //   5673: goto -1620 -> 4053
    //   5676: astore_1
    //   5677: iload 8
    //   5679: istore 4
    //   5681: aload 35
    //   5683: astore 34
    //   5685: goto -1632 -> 4053
    //   5688: astore_1
    //   5689: aload 35
    //   5691: astore 34
    //   5693: goto -1640 -> 4053
    //   5696: astore_1
    //   5697: aconst_null
    //   5698: astore 34
    //   5700: goto -1647 -> 4053
    //   5703: astore_1
    //   5704: aload 37
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
    //   5761: iload 11
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
    //   5784: iload 19
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
    //   5839: iload 13
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
    //   5962: ldc2_w 298
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
    //   6014: iload 19
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
    //   110	5652	11	i1	int
    //   89	5537	12	i2	int
    //   74	5766	13	i3	int
    //   59	5371	14	i4	int
    //   62	5514	15	i5	int
    //   68	5729	16	i6	int
    //   71	5781	17	i7	int
    //   65	419	18	i8	int
    //   53	5962	19	i9	int
    //   56	1723	20	i10	int
    //   92	1471	21	i11	int
    //   98	185	22	i12	int
    //   226	49	23	i13	int
    //   238	86	24	i14	int
    //   229	50	25	i15	int
    //   223	48	26	i16	int
    //   235	52	27	i17	int
    //   118	5848	28	l1	long
    //   190	5354	30	l2	long
    //   17	1046	32	l3	long
    //   83	5910	34	localObject1	Object
    //   126	2586	35	localObject2	Object
    //   2890	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2964	768	35	localObject3	Object
    //   3810	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3905	1785	35	localContext	Context
    //   5740	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5748	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5756	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5768	1	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   134	5768	36	localObject4	Object
    //   130	5575	37	localObject5	Object
    //   122	5320	38	localObject6	Object
    //   77	5589	39	localObject7	Object
    //   80	3708	40	localStringBuilder	StringBuilder
    //   86	2710	41	localObject8	Object
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
    //   2420	2472	5219	java/lang/UnsatisfiedLinkError
    //   2484	2493	5227	java/lang/UnsatisfiedLinkError
    //   2501	2510	5227	java/lang/UnsatisfiedLinkError
    //   2521	2537	5227	java/lang/UnsatisfiedLinkError
    //   2540	2548	5227	java/lang/UnsatisfiedLinkError
    //   2587	2597	5238	java/lang/UnsatisfiedLinkError
    //   2636	2642	5238	java/lang/UnsatisfiedLinkError
    //   2681	2709	5238	java/lang/UnsatisfiedLinkError
    //   2748	2753	5238	java/lang/UnsatisfiedLinkError
    //   3942	3947	5238	java/lang/UnsatisfiedLinkError
    //   3982	3987	5238	java/lang/UnsatisfiedLinkError
    //   2758	2815	5254	java/lang/UnsatisfiedLinkError
    //   2826	2873	5265	java/lang/UnsatisfiedLinkError
    //   823	832	5276	java/lang/UnsatisfiedLinkError
    //   839	848	5276	java/lang/UnsatisfiedLinkError
    //   855	863	5276	java/lang/UnsatisfiedLinkError
    //   870	887	5276	java/lang/UnsatisfiedLinkError
    //   906	917	5276	java/lang/UnsatisfiedLinkError
    //   924	930	5276	java/lang/UnsatisfiedLinkError
    //   937	991	5276	java/lang/UnsatisfiedLinkError
    //   208	222	5291	java/lang/RuntimeException
    //   264	270	5291	java/lang/RuntimeException
    //   290	323	5291	java/lang/RuntimeException
    //   327	336	5309	java/lang/RuntimeException
    //   340	383	5309	java/lang/RuntimeException
    //   388	410	5309	java/lang/RuntimeException
    //   421	444	5309	java/lang/RuntimeException
    //   452	456	5309	java/lang/RuntimeException
    //   1384	1413	5309	java/lang/RuntimeException
    //   487	502	5323	java/lang/RuntimeException
    //   691	697	5323	java/lang/RuntimeException
    //   733	760	5323	java/lang/RuntimeException
    //   1141	1145	5323	java/lang/RuntimeException
    //   1181	1187	5323	java/lang/RuntimeException
    //   1223	1234	5323	java/lang/RuntimeException
    //   1273	1277	5323	java/lang/RuntimeException
    //   1313	1319	5323	java/lang/RuntimeException
    //   1355	1366	5323	java/lang/RuntimeException
    //   506	512	5339	java/lang/RuntimeException
    //   516	557	5339	java/lang/RuntimeException
    //   561	570	5339	java/lang/RuntimeException
    //   574	585	5339	java/lang/RuntimeException
    //   607	613	5339	java/lang/RuntimeException
    //   617	623	5339	java/lang/RuntimeException
    //   632	648	5339	java/lang/RuntimeException
    //   764	769	5359	java/lang/RuntimeException
    //   1428	1435	5379	java/lang/RuntimeException
    //   1442	1449	5379	java/lang/RuntimeException
    //   1534	1544	5379	java/lang/RuntimeException
    //   1566	1570	5379	java/lang/RuntimeException
    //   1576	1592	5396	java/lang/RuntimeException
    //   1595	1601	5396	java/lang/RuntimeException
    //   1608	1616	5396	java/lang/RuntimeException
    //   1787	1798	5396	java/lang/RuntimeException
    //   1639	1649	5410	java/lang/RuntimeException
    //   1672	1678	5410	java/lang/RuntimeException
    //   1701	1745	5410	java/lang/RuntimeException
    //   1768	1773	5410	java/lang/RuntimeException
    //   2911	2916	5410	java/lang/RuntimeException
    //   2935	2940	5410	java/lang/RuntimeException
    //   1832	1841	5425	java/lang/RuntimeException
    //   1910	1918	5425	java/lang/RuntimeException
    //   3077	3085	5425	java/lang/RuntimeException
    //   3345	3354	5425	java/lang/RuntimeException
    //   3381	3397	5425	java/lang/RuntimeException
    //   3424	3433	5425	java/lang/RuntimeException
    //   3460	3472	5425	java/lang/RuntimeException
    //   3499	3519	5425	java/lang/RuntimeException
    //   3556	3576	5425	java/lang/RuntimeException
    //   3603	3615	5425	java/lang/RuntimeException
    //   3642	3662	5425	java/lang/RuntimeException
    //   3689	3694	5425	java/lang/RuntimeException
    //   3725	3731	5425	java/lang/RuntimeException
    //   3758	3799	5425	java/lang/RuntimeException
    //   1957	1964	5440	java/lang/RuntimeException
    //   2003	2009	5440	java/lang/RuntimeException
    //   2048	2076	5440	java/lang/RuntimeException
    //   2115	2120	5440	java/lang/RuntimeException
    //   3001	3006	5440	java/lang/RuntimeException
    //   3041	3046	5440	java/lang/RuntimeException
    //   3128	3135	5440	java/lang/RuntimeException
    //   3178	3184	5440	java/lang/RuntimeException
    //   3227	3255	5440	java/lang/RuntimeException
    //   3298	3303	5440	java/lang/RuntimeException
    //   3847	3852	5440	java/lang/RuntimeException
    //   3887	3892	5440	java/lang/RuntimeException
    //   2157	2166	5456	java/lang/RuntimeException
    //   2186	2202	5456	java/lang/RuntimeException
    //   2222	2230	5456	java/lang/RuntimeException
    //   2250	2261	5456	java/lang/RuntimeException
    //   2281	2300	5456	java/lang/RuntimeException
    //   2326	2346	5456	java/lang/RuntimeException
    //   2366	2377	5456	java/lang/RuntimeException
    //   2397	2413	5456	java/lang/RuntimeException
    //   2420	2472	5472	java/lang/RuntimeException
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
    return bijo.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bijo.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = aokb.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (aokb.a(paramArrayOfInt))
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
    //   55: astore 36
    //   57: aconst_null
    //   58: astore 35
    //   60: aconst_null
    //   61: astore 32
    //   63: aconst_null
    //   64: astore 34
    //   66: aconst_null
    //   67: astore 33
    //   69: iconst_0
    //   70: istore 6
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 17
    //   78: iconst_0
    //   79: istore 18
    //   81: iconst_0
    //   82: istore 16
    //   84: iconst_0
    //   85: istore 15
    //   87: iconst_0
    //   88: istore 14
    //   90: iconst_0
    //   91: istore 21
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 19
    //   99: iconst_0
    //   100: istore 13
    //   102: iconst_0
    //   103: istore 20
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 33
    //   110: astore 27
    //   112: iload 17
    //   114: istore 10
    //   116: aload 36
    //   118: astore 31
    //   120: iload 18
    //   122: istore 12
    //   124: aload 35
    //   126: astore 29
    //   128: iload 16
    //   130: istore 11
    //   132: aload 32
    //   134: astore 30
    //   136: iload 15
    //   138: istore 9
    //   140: aload 34
    //   142: astore 28
    //   144: iload 14
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 33
    //   156: astore 27
    //   158: iload 17
    //   160: istore 10
    //   162: aload 36
    //   164: astore 31
    //   166: iload 18
    //   168: istore 12
    //   170: aload 35
    //   172: astore 29
    //   174: iload 16
    //   176: istore 11
    //   178: aload 32
    //   180: astore 30
    //   182: iload 15
    //   184: istore 9
    //   186: aload 34
    //   188: astore 28
    //   190: iload 14
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4029 -> 4231
    //   205: iload_3
    //   206: ifeq +802 -> 1008
    //   209: iload 21
    //   211: istore 10
    //   213: iload 19
    //   215: istore 8
    //   217: iload 13
    //   219: istore 11
    //   221: iload 20
    //   223: istore 9
    //   225: aload_0
    //   226: invokevirtual 316	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 322	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore 27
    //   234: iload 21
    //   236: istore 10
    //   238: iload 19
    //   240: istore 8
    //   242: iload 13
    //   244: istore 11
    //   246: iload 20
    //   248: istore 9
    //   250: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   253: ifeq +46 -> 299
    //   256: iload 21
    //   258: istore 10
    //   260: iload 19
    //   262: istore 8
    //   264: iload 13
    //   266: istore 11
    //   268: iload 20
    //   270: istore 9
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
    //   304: iload 21
    //   306: istore 10
    //   308: iload 19
    //   310: istore 8
    //   312: iload 13
    //   314: istore 11
    //   316: iload 20
    //   318: istore 9
    //   320: aload 27
    //   322: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   325: istore 14
    //   327: iload 21
    //   329: istore 10
    //   331: iload 19
    //   333: istore 8
    //   335: iload 13
    //   337: istore 11
    //   339: iload 20
    //   341: istore 9
    //   343: aload 27
    //   345: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   348: istore 12
    //   350: iload 21
    //   352: istore 10
    //   354: iload 19
    //   356: istore 8
    //   358: iload 13
    //   360: istore 11
    //   362: iload 20
    //   364: istore 9
    //   366: iload 14
    //   368: iload 12
    //   370: invokestatic 201	bijo:a	(II)Z
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
    //   419: iload 21
    //   421: istore 10
    //   423: iload 19
    //   425: istore 8
    //   427: iload 13
    //   429: istore 11
    //   431: iload 20
    //   433: istore 9
    //   435: iload 14
    //   437: iload 12
    //   439: imul
    //   440: newarray int
    //   442: astore_0
    //   443: iload 21
    //   445: istore 10
    //   447: iload 19
    //   449: istore 8
    //   451: iload 13
    //   453: istore 11
    //   455: iload 20
    //   457: istore 9
    //   459: aload 27
    //   461: aload_0
    //   462: iconst_0
    //   463: iload 14
    //   465: iconst_0
    //   466: iconst_0
    //   467: iload 14
    //   469: iload 12
    //   471: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   474: iload 21
    //   476: istore 10
    //   478: iload 19
    //   480: istore 8
    //   482: iload 13
    //   484: istore 11
    //   486: iload 20
    //   488: istore 9
    //   490: aload 27
    //   492: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   495: iload 21
    //   497: istore 10
    //   499: iload 19
    //   501: istore 8
    //   503: iload 13
    //   505: istore 11
    //   507: iload 20
    //   509: istore 9
    //   511: invokestatic 203	yxi:a	()I
    //   514: pop
    //   515: iconst_1
    //   516: istore 9
    //   518: aload_0
    //   519: aconst_null
    //   520: iload 14
    //   522: iload 12
    //   524: invokestatic 419	yxi:a	([I[BII)I
    //   527: istore 6
    //   529: iload 9
    //   531: istore 7
    //   533: iload 6
    //   535: istore 8
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
    //   572: istore 8
    //   574: iload 9
    //   576: istore 7
    //   578: iload 7
    //   580: istore 6
    //   582: iload 8
    //   584: istore 7
    //   586: aload_1
    //   587: astore_0
    //   588: iload 7
    //   590: iconst_1
    //   591: if_icmpne +3601 -> 4192
    //   594: iload_2
    //   595: ifeq +2812 -> 3407
    //   598: aload_0
    //   599: astore 27
    //   601: iload 6
    //   603: istore 10
    //   605: aload_0
    //   606: astore 31
    //   608: iload 6
    //   610: istore 12
    //   612: aload_0
    //   613: astore 29
    //   615: iload 6
    //   617: istore 11
    //   619: aload_0
    //   620: astore 30
    //   622: iload 6
    //   624: istore 9
    //   626: aload_0
    //   627: astore 28
    //   629: iload 6
    //   631: istore 8
    //   633: new 45	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   640: astore 32
    //   642: aload_0
    //   643: astore 27
    //   645: iload 6
    //   647: istore 10
    //   649: aload_0
    //   650: astore 31
    //   652: iload 6
    //   654: istore 12
    //   656: aload_0
    //   657: astore 29
    //   659: iload 6
    //   661: istore 11
    //   663: aload_0
    //   664: astore 30
    //   666: iload 6
    //   668: istore 9
    //   670: aload_0
    //   671: astore 28
    //   673: iload 6
    //   675: istore 8
    //   677: new 45	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   684: astore_1
    //   685: aload_0
    //   686: astore 27
    //   688: iload 6
    //   690: istore 10
    //   692: aload_0
    //   693: astore 31
    //   695: iload 6
    //   697: istore 12
    //   699: aload_0
    //   700: astore 29
    //   702: iload 6
    //   704: istore 11
    //   706: aload_0
    //   707: astore 30
    //   709: iload 6
    //   711: istore 9
    //   713: aload_0
    //   714: astore 28
    //   716: iload 6
    //   718: istore 8
    //   720: aload 32
    //   722: aload_1
    //   723: invokestatic 241	bijo:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   726: pop
    //   727: aload_0
    //   728: astore 27
    //   730: iload 6
    //   732: istore 10
    //   734: aload_0
    //   735: astore 31
    //   737: iload 6
    //   739: istore 12
    //   741: aload_0
    //   742: astore 29
    //   744: iload 6
    //   746: istore 11
    //   748: aload_0
    //   749: astore 30
    //   751: iload 6
    //   753: istore 9
    //   755: aload_0
    //   756: astore 28
    //   758: iload 6
    //   760: istore 8
    //   762: new 243	android/util/Pair
    //   765: dup
    //   766: aload_1
    //   767: aload 32
    //   769: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   772: astore_1
    //   773: aload_0
    //   774: astore 27
    //   776: iload 6
    //   778: ifeq +7 -> 785
    //   781: invokestatic 256	yxi:b	()I
    //   784: pop
    //   785: aload_1
    //   786: astore_0
    //   787: aload 27
    //   789: ifnull +10 -> 799
    //   792: aload 27
    //   794: invokevirtual 339	java/io/InputStream:close	()V
    //   797: aload_1
    //   798: astore_0
    //   799: aload_0
    //   800: astore 27
    //   802: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   805: ifeq -794 -> 11
    //   808: ldc 43
    //   810: iconst_4
    //   811: new 45	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 423
    //   821: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   827: lload 25
    //   829: lsub
    //   830: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   833: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: aload_0
    //   840: areturn
    //   841: astore_0
    //   842: iload 6
    //   844: istore 10
    //   846: iload 6
    //   848: istore 12
    //   850: iload 6
    //   852: istore 8
    //   854: iload 6
    //   856: istore 11
    //   858: iload 6
    //   860: istore 9
    //   862: aload_0
    //   863: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: iload 6
    //   868: istore 10
    //   870: iload 6
    //   872: istore 12
    //   874: iload 6
    //   876: istore 8
    //   878: iload 6
    //   880: istore 11
    //   882: iload 6
    //   884: istore 9
    //   886: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +3354 -> 4243
    //   892: iload 6
    //   894: istore 10
    //   896: iload 6
    //   898: istore 12
    //   900: iload 6
    //   902: istore 8
    //   904: iload 6
    //   906: istore 11
    //   908: iload 6
    //   910: istore 9
    //   912: ldc 43
    //   914: iconst_2
    //   915: aload_0
    //   916: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   919: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto +3321 -> 4243
    //   925: iload 6
    //   927: istore 10
    //   929: iload 6
    //   931: istore 12
    //   933: iload 6
    //   935: istore 8
    //   937: iload 6
    //   939: istore 11
    //   941: iload 6
    //   943: istore 9
    //   945: aload_0
    //   946: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   949: iload 6
    //   951: istore 10
    //   953: iload 6
    //   955: istore 12
    //   957: iload 6
    //   959: istore 8
    //   961: iload 6
    //   963: istore 11
    //   965: iload 6
    //   967: istore 9
    //   969: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +3284 -> 4256
    //   975: iload 6
    //   977: istore 10
    //   979: iload 6
    //   981: istore 12
    //   983: iload 6
    //   985: istore 8
    //   987: iload 6
    //   989: istore 11
    //   991: iload 6
    //   993: istore 9
    //   995: ldc 43
    //   997: iconst_2
    //   998: aload_0
    //   999: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1002: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto +3251 -> 4256
    //   1008: iload 21
    //   1010: istore 10
    //   1012: iload 23
    //   1014: istore 12
    //   1016: iload 19
    //   1018: istore 8
    //   1020: iload 13
    //   1022: istore 11
    //   1024: iload 20
    //   1026: istore 9
    //   1028: new 347	android/graphics/BitmapFactory$Options
    //   1031: dup
    //   1032: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   1035: astore 43
    //   1037: iload 21
    //   1039: istore 10
    //   1041: iload 23
    //   1043: istore 12
    //   1045: iload 19
    //   1047: istore 8
    //   1049: iload 13
    //   1051: istore 11
    //   1053: iload 20
    //   1055: istore 9
    //   1057: aload 43
    //   1059: iconst_1
    //   1060: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1063: iload 21
    //   1065: istore 10
    //   1067: iload 23
    //   1069: istore 12
    //   1071: iload 19
    //   1073: istore 8
    //   1075: iload 13
    //   1077: istore 11
    //   1079: iload 20
    //   1081: istore 9
    //   1083: aload_1
    //   1084: aconst_null
    //   1085: aload 43
    //   1087: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1090: pop
    //   1091: iload 21
    //   1093: istore 10
    //   1095: iload 23
    //   1097: istore 12
    //   1099: iload 19
    //   1101: istore 8
    //   1103: iload 13
    //   1105: istore 11
    //   1107: iload 20
    //   1109: istore 9
    //   1111: aload_1
    //   1112: invokevirtual 339	java/io/InputStream:close	()V
    //   1115: aconst_null
    //   1116: astore 32
    //   1118: aconst_null
    //   1119: astore 39
    //   1121: aconst_null
    //   1122: astore 40
    //   1124: aconst_null
    //   1125: astore 38
    //   1127: aconst_null
    //   1128: astore_1
    //   1129: aconst_null
    //   1130: astore 41
    //   1132: aconst_null
    //   1133: astore 36
    //   1135: aconst_null
    //   1136: astore 33
    //   1138: aconst_null
    //   1139: astore 34
    //   1141: aconst_null
    //   1142: astore 35
    //   1144: aconst_null
    //   1145: astore 37
    //   1147: aload 39
    //   1149: astore 27
    //   1151: iload 17
    //   1153: istore 10
    //   1155: aload 40
    //   1157: astore 31
    //   1159: iload 18
    //   1161: istore 12
    //   1163: aload 38
    //   1165: astore 29
    //   1167: iload 16
    //   1169: istore 11
    //   1171: aload_1
    //   1172: astore 30
    //   1174: iload 15
    //   1176: istore 9
    //   1178: aload 41
    //   1180: astore 28
    //   1182: iload 14
    //   1184: istore 8
    //   1186: aload 43
    //   1188: getfield 360	android/graphics/BitmapFactory$Options:outWidth	I
    //   1191: istore 20
    //   1193: aload 39
    //   1195: astore 27
    //   1197: iload 17
    //   1199: istore 10
    //   1201: aload 40
    //   1203: astore 31
    //   1205: iload 18
    //   1207: istore 12
    //   1209: aload 38
    //   1211: astore 29
    //   1213: iload 16
    //   1215: istore 11
    //   1217: aload_1
    //   1218: astore 30
    //   1220: iload 15
    //   1222: istore 9
    //   1224: aload 41
    //   1226: astore 28
    //   1228: iload 14
    //   1230: istore 8
    //   1232: aload 43
    //   1234: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
    //   1237: istore 19
    //   1239: aload 39
    //   1241: astore 27
    //   1243: iload 17
    //   1245: istore 10
    //   1247: aload 40
    //   1249: astore 31
    //   1251: iload 18
    //   1253: istore 12
    //   1255: aload 38
    //   1257: astore 29
    //   1259: iload 16
    //   1261: istore 11
    //   1263: aload_1
    //   1264: astore 30
    //   1266: iload 15
    //   1268: istore 9
    //   1270: aload 41
    //   1272: astore 28
    //   1274: iload 14
    //   1276: istore 8
    //   1278: aload 43
    //   1280: iconst_0
    //   1281: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1284: iload 20
    //   1286: sipush 12800
    //   1289: if_icmpgt +11 -> 1300
    //   1292: iload 19
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
    //   1343: aload 39
    //   1345: astore 27
    //   1347: iload 17
    //   1349: istore 10
    //   1351: aload 40
    //   1353: astore 31
    //   1355: iload 18
    //   1357: istore 12
    //   1359: aload 38
    //   1361: astore 29
    //   1363: iload 16
    //   1365: istore 11
    //   1367: aload_1
    //   1368: astore 30
    //   1370: iload 15
    //   1372: istore 9
    //   1374: aload 41
    //   1376: astore 28
    //   1378: iload 14
    //   1380: istore 8
    //   1382: iload 20
    //   1384: iload 19
    //   1386: invokestatic 201	bijo:a	(II)Z
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
    //   1437: aload 39
    //   1439: astore 27
    //   1441: iload 17
    //   1443: istore 10
    //   1445: aload 40
    //   1447: astore 31
    //   1449: iload 18
    //   1451: istore 12
    //   1453: aload 38
    //   1455: astore 29
    //   1457: iload 16
    //   1459: istore 11
    //   1461: aload_1
    //   1462: astore 30
    //   1464: iload 15
    //   1466: istore 9
    //   1468: aload 41
    //   1470: astore 28
    //   1472: iload 14
    //   1474: istore 8
    //   1476: invokestatic 203	yxi:a	()I
    //   1479: pop
    //   1480: iconst_1
    //   1481: istore 11
    //   1483: iconst_1
    //   1484: istore 12
    //   1486: iconst_1
    //   1487: istore 13
    //   1489: iconst_1
    //   1490: istore 10
    //   1492: iconst_1
    //   1493: istore 9
    //   1495: iload 20
    //   1497: iload 19
    //   1499: imul
    //   1500: ldc_w 424
    //   1503: if_icmple +1169 -> 2672
    //   1506: iload 20
    //   1508: iload 19
    //   1510: imul
    //   1511: i2d
    //   1512: dstore 4
    //   1514: aload 37
    //   1516: astore 27
    //   1518: aload 36
    //   1520: astore_1
    //   1521: iload 10
    //   1523: istore 8
    //   1525: aload 33
    //   1527: astore 28
    //   1529: aload 34
    //   1531: astore 29
    //   1533: aload 35
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
    //   1559: aload 36
    //   1561: astore_1
    //   1562: iload 10
    //   1564: istore 8
    //   1566: aload 33
    //   1568: astore 28
    //   1570: aload 34
    //   1572: astore 29
    //   1574: aload 35
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
    //   1710: iload 20
    //   1712: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: ldc_w 435
    //   1718: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: iload 19
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
    //   1796: istore 8
    //   1798: iload 7
    //   1800: istore 6
    //   1802: aload 33
    //   1804: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   1807: istore 14
    //   1809: iload 7
    //   1811: istore 6
    //   1813: iload 8
    //   1815: iload 14
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
    //   1835: iload 14
    //   1837: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1840: iload 7
    //   1842: istore 6
    //   1844: aload 33
    //   1846: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   1849: iload 7
    //   1851: istore 6
    //   1853: aload_1
    //   1854: aconst_null
    //   1855: iload 8
    //   1857: iload 14
    //   1859: invokestatic 419	yxi:a	([I[BII)I
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
    //   1947: iload 20
    //   1949: iconst_2
    //   1950: imul
    //   1951: iload 19
    //   1953: if_icmpgt +957 -> 2910
    //   1956: iload 20
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
    //   2138: iload 20
    //   2140: iload 20
    //   2142: imul
    //   2143: newarray int
    //   2145: astore 27
    //   2147: iload 6
    //   2149: istore 7
    //   2151: aload 32
    //   2153: aload 27
    //   2155: iconst_0
    //   2156: iload 20
    //   2158: iconst_0
    //   2159: iconst_0
    //   2160: iload 20
    //   2162: iload 20
    //   2164: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2167: iload 6
    //   2169: istore 7
    //   2171: iload 20
    //   2173: iload 20
    //   2175: imul
    //   2176: newarray byte
    //   2178: astore_1
    //   2179: iload 6
    //   2181: istore 7
    //   2183: aload 27
    //   2185: aload_1
    //   2186: iload 20
    //   2188: iload 20
    //   2190: invokestatic 419	yxi:a	([I[BII)I
    //   2193: istore 6
    //   2195: iload 6
    //   2197: iconst_1
    //   2198: if_icmpeq +2018 -> 4216
    //   2201: iload 6
    //   2203: istore 7
    //   2205: aload 32
    //   2207: aload 27
    //   2209: iconst_0
    //   2210: iload 20
    //   2212: iconst_0
    //   2213: iload 19
    //   2215: iload 20
    //   2217: isub
    //   2218: iload 20
    //   2220: iload 20
    //   2222: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2225: iload 6
    //   2227: istore 7
    //   2229: aload 27
    //   2231: aload_1
    //   2232: iload 20
    //   2234: iload 20
    //   2236: invokestatic 419	yxi:a	([I[BII)I
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
    //   2284: astore 36
    //   2286: aconst_null
    //   2287: astore 34
    //   2289: aconst_null
    //   2290: astore 31
    //   2292: aconst_null
    //   2293: astore 33
    //   2295: aconst_null
    //   2296: astore 35
    //   2298: aconst_null
    //   2299: astore 37
    //   2301: aconst_null
    //   2302: astore 32
    //   2304: iload 7
    //   2306: iconst_1
    //   2307: if_icmpeq +1900 -> 4207
    //   2310: aload 36
    //   2312: astore 27
    //   2314: aload 34
    //   2316: astore_1
    //   2317: iload 10
    //   2319: istore 8
    //   2321: aload 31
    //   2323: astore 28
    //   2325: aload 33
    //   2327: astore 29
    //   2329: aload 35
    //   2331: astore 30
    //   2333: iload 20
    //   2335: iload 19
    //   2337: invokestatic 232	java/lang/Math:min	(II)I
    //   2340: istore 6
    //   2342: iload 6
    //   2344: sipush 250
    //   2347: if_icmple +1860 -> 4207
    //   2350: aload 36
    //   2352: astore 27
    //   2354: aload 34
    //   2356: astore_1
    //   2357: iload 10
    //   2359: istore 8
    //   2361: aload 31
    //   2363: astore 28
    //   2365: aload 33
    //   2367: astore 29
    //   2369: aload 35
    //   2371: astore 30
    //   2373: aload 43
    //   2375: iload 6
    //   2377: i2d
    //   2378: ldc2_w 233
    //   2381: ddiv
    //   2382: invokestatic 238	java/lang/Math:ceil	(D)D
    //   2385: d2i
    //   2386: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2389: aload 36
    //   2391: astore 27
    //   2393: aload 34
    //   2395: astore_1
    //   2396: iload 10
    //   2398: istore 8
    //   2400: aload 31
    //   2402: astore 28
    //   2404: aload 33
    //   2406: astore 29
    //   2408: aload 35
    //   2410: astore 30
    //   2412: aload 37
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
    //   2606: invokestatic 419	yxi:a	([I[BII)I
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
    //   2669: goto -2081 -> 588
    //   2672: aload 37
    //   2674: astore 27
    //   2676: aload 36
    //   2678: astore_1
    //   2679: iload 10
    //   2681: istore 8
    //   2683: aload 33
    //   2685: astore 28
    //   2687: aload 34
    //   2689: astore 29
    //   2691: aload 35
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
    //   2757: invokestatic 256	yxi:b	()I
    //   2760: pop
    //   2761: aload 27
    //   2763: ifnull +1424 -> 4187
    //   2766: aload 27
    //   2768: invokevirtual 339	java/io/InputStream:close	()V
    //   2771: aconst_null
    //   2772: astore_0
    //   2773: goto -1974 -> 799
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
    //   2914: iload 20
    //   2916: iload 19
    //   2918: iconst_2
    //   2919: imul
    //   2920: if_icmplt -637 -> 2283
    //   2923: iload 6
    //   2925: istore 7
    //   2927: iload 19
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
    //   3113: iload 19
    //   3115: iload 19
    //   3117: imul
    //   3118: newarray int
    //   3120: astore_1
    //   3121: iload 6
    //   3123: istore 7
    //   3125: aload 33
    //   3127: aload_1
    //   3128: iconst_0
    //   3129: iload 19
    //   3131: iconst_0
    //   3132: iconst_0
    //   3133: iload 19
    //   3135: iload 19
    //   3137: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3140: iload 6
    //   3142: istore 7
    //   3144: iload 19
    //   3146: iload 19
    //   3148: imul
    //   3149: newarray byte
    //   3151: astore 27
    //   3153: iload 6
    //   3155: istore 7
    //   3157: aload_1
    //   3158: aload 27
    //   3160: iload 19
    //   3162: iload 19
    //   3164: invokestatic 419	yxi:a	([I[BII)I
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
    //   3187: iload 19
    //   3189: iload 20
    //   3191: iload 19
    //   3193: isub
    //   3194: iconst_0
    //   3195: iload 19
    //   3197: iload 19
    //   3199: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3202: iload 8
    //   3204: istore 7
    //   3206: aload_1
    //   3207: aload 27
    //   3209: iload 19
    //   3211: iload 19
    //   3213: invokestatic 419	yxi:a	([I[BII)I
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
    //   3404: goto -2816 -> 588
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 6
    //   3412: istore 10
    //   3414: aload_0
    //   3415: astore 31
    //   3417: iload 6
    //   3419: istore 12
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
    //   3442: new 243	android/util/Pair
    //   3445: dup
    //   3446: aconst_null
    //   3447: aconst_null
    //   3448: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   3451: astore_1
    //   3452: aload_0
    //   3453: astore 27
    //   3455: goto -2679 -> 776
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
    //   3478: ifeq -2679 -> 799
    //   3481: ldc 43
    //   3483: iconst_2
    //   3484: aload 27
    //   3486: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3489: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3492: aload_1
    //   3493: astore_0
    //   3494: goto -2695 -> 799
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
    //   3520: goto -2721 -> 799
    //   3523: astore_0
    //   3524: iload 12
    //   3526: istore 6
    //   3528: aload 31
    //   3530: astore 30
    //   3532: aload 30
    //   3534: astore_1
    //   3535: iload 6
    //   3537: istore 8
    //   3539: aload_0
    //   3540: invokevirtual 267	java/lang/RuntimeException:printStackTrace	()V
    //   3543: aload 30
    //   3545: astore_1
    //   3546: iload 6
    //   3548: istore 8
    //   3550: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3553: ifeq +20 -> 3573
    //   3556: aload 30
    //   3558: astore_1
    //   3559: iload 6
    //   3561: istore 8
    //   3563: ldc 43
    //   3565: iconst_2
    //   3566: aload_0
    //   3567: invokevirtual 268	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3570: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3573: iload 6
    //   3575: ifeq +7 -> 3582
    //   3578: invokestatic 256	yxi:b	()I
    //   3581: pop
    //   3582: aload 30
    //   3584: ifnull +603 -> 4187
    //   3587: aload 30
    //   3589: invokevirtual 339	java/io/InputStream:close	()V
    //   3592: aconst_null
    //   3593: astore_0
    //   3594: goto -2795 -> 799
    //   3597: astore_0
    //   3598: aload_0
    //   3599: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3602: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3605: ifeq +13 -> 3618
    //   3608: ldc 43
    //   3610: iconst_2
    //   3611: aload_0
    //   3612: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3615: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3618: aconst_null
    //   3619: astore_0
    //   3620: goto -2821 -> 799
    //   3623: astore_0
    //   3624: iload 11
    //   3626: istore 6
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
    //   3674: invokestatic 256	yxi:b	()I
    //   3677: pop
    //   3678: aload 29
    //   3680: ifnull +507 -> 4187
    //   3683: aload 29
    //   3685: invokevirtual 339	java/io/InputStream:close	()V
    //   3688: aconst_null
    //   3689: astore_0
    //   3690: goto -2891 -> 799
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
    //   3716: goto -2917 -> 799
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
    //   3774: invokestatic 256	yxi:b	()I
    //   3777: pop
    //   3778: aload 28
    //   3780: ifnull +407 -> 4187
    //   3783: aload 28
    //   3785: invokevirtual 339	java/io/InputStream:close	()V
    //   3788: aconst_null
    //   3789: astore_0
    //   3790: goto -2991 -> 799
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
    //   3816: goto -3017 -> 799
    //   3819: astore_0
    //   3820: aload 28
    //   3822: astore_1
    //   3823: iload 8
    //   3825: ifeq +7 -> 3832
    //   3828: invokestatic 256	yxi:b	()I
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
    //   3917: iload 12
    //   3919: istore 6
    //   3921: goto -193 -> 3728
    //   3924: astore_0
    //   3925: aconst_null
    //   3926: astore 28
    //   3928: iload 12
    //   3930: istore 6
    //   3932: goto -204 -> 3728
    //   3935: astore_0
    //   3936: aconst_null
    //   3937: astore 28
    //   3939: iload 12
    //   3941: istore 6
    //   3943: goto -215 -> 3728
    //   3946: astore_0
    //   3947: iload 8
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
    //   3968: iload 11
    //   3970: istore 6
    //   3972: goto -344 -> 3628
    //   3975: astore_0
    //   3976: aconst_null
    //   3977: astore 29
    //   3979: iload 11
    //   3981: istore 6
    //   3983: goto -355 -> 3628
    //   3986: astore_0
    //   3987: aconst_null
    //   3988: astore 29
    //   3990: iload 11
    //   3992: istore 6
    //   3994: goto -366 -> 3628
    //   3997: astore_0
    //   3998: iload 11
    //   4000: istore 6
    //   4002: aload_1
    //   4003: astore 30
    //   4005: goto -473 -> 3532
    //   4008: astore_0
    //   4009: iconst_1
    //   4010: istore 6
    //   4012: aload_1
    //   4013: astore 30
    //   4015: goto -483 -> 3532
    //   4018: astore_0
    //   4019: iload 9
    //   4021: istore 6
    //   4023: goto -491 -> 3532
    //   4026: astore_0
    //   4027: aconst_null
    //   4028: astore 30
    //   4030: iload 9
    //   4032: istore 6
    //   4034: goto -502 -> 3532
    //   4037: astore_0
    //   4038: aconst_null
    //   4039: astore 30
    //   4041: iload 9
    //   4043: istore 6
    //   4045: goto -513 -> 3532
    //   4048: astore_0
    //   4049: aload_1
    //   4050: astore 27
    //   4052: iload 9
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
    //   4189: goto -3390 -> 799
    //   4192: aconst_null
    //   4193: astore_1
    //   4194: aload_0
    //   4195: astore 27
    //   4197: goto -3421 -> 776
    //   4200: iload 7
    //   4202: istore 6
    //   4204: goto -1548 -> 2656
    //   4207: iconst_1
    //   4208: istore 6
    //   4210: aload 32
    //   4212: astore_0
    //   4213: goto -3625 -> 588
    //   4216: goto -1975 -> 2241
    //   4219: goto -1940 -> 2279
    //   4222: iconst_0
    //   4223: istore 7
    //   4225: iconst_m1
    //   4226: istore 8
    //   4228: goto -3650 -> 578
    //   4231: aload_1
    //   4232: astore 27
    //   4234: aconst_null
    //   4235: astore_1
    //   4236: iload 24
    //   4238: istore 6
    //   4240: goto -3464 -> 776
    //   4243: aload_1
    //   4244: astore_0
    //   4245: goto -3657 -> 588
    //   4248: astore_0
    //   4249: iload 22
    //   4251: istore 6
    //   4253: goto -3328 -> 925
    //   4256: aload_1
    //   4257: astore_0
    //   4258: goto -3670 -> 588
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
    //   70	4182	6	i	int
    //   20	4204	7	j	int
    //   146	4081	8	k	int
    //   138	3915	9	m	int
    //   114	3754	10	n	int
    //   130	3869	11	i1	int
    //   122	3818	12	i2	int
    //   100	3799	13	i3	int
    //   88	1770	14	i4	int
    //   85	1380	15	i5	int
    //   82	1376	16	i6	int
    //   76	1366	17	i7	int
    //   79	1371	18	i8	int
    //   97	3115	19	i9	int
    //   103	3091	20	i10	int
    //   91	1001	21	i11	int
    //   73	4177	22	i12	int
    //   94	1002	23	i13	int
    //   106	4131	24	i14	int
    //   17	811	25	l	long
    //   9	3445	27	localObject1	Object
    //   3466	19	27	localIOException	java.io.IOException
    //   4050	183	27	localObject2	Object
    //   142	3796	28	localObject3	Object
    //   126	3863	29	localObject4	Object
    //   134	3906	30	localObject5	Object
    //   118	4155	31	localObject6	Object
    //   61	3312	32	localObject7	Object
    //   4089	1	32	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   4096	1	32	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4103	1	32	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4115	1	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4127	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   4135	76	32	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4261	1	32	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4270	1	32	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   67	4197	33	localObject8	Object
    //   64	2624	34	localObject9	Object
    //   58	2634	35	localObject10	Object
    //   55	2622	36	localObject11	Object
    //   1145	1528	37	localObject12	Object
    //   1125	329	38	localObject13	Object
    //   1119	319	39	localObject14	Object
    //   1122	324	40	localObject15	Object
    //   1130	339	41	localObject16	Object
    //   152	2788	42	localContentResolver	android.content.ContentResolver
    //   1035	1661	43	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   387	391	393	java/io/IOException
    //   225	234	841	java/lang/OutOfMemoryError
    //   250	256	841	java/lang/OutOfMemoryError
    //   272	299	841	java/lang/OutOfMemoryError
    //   320	327	841	java/lang/OutOfMemoryError
    //   343	350	841	java/lang/OutOfMemoryError
    //   366	374	841	java/lang/OutOfMemoryError
    //   435	443	841	java/lang/OutOfMemoryError
    //   459	474	841	java/lang/OutOfMemoryError
    //   490	495	841	java/lang/OutOfMemoryError
    //   511	515	841	java/lang/OutOfMemoryError
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
    //   633	642	3458	java/io/IOException
    //   677	685	3458	java/io/IOException
    //   720	727	3458	java/io/IOException
    //   762	773	3458	java/io/IOException
    //   1186	1193	3458	java/io/IOException
    //   1232	1239	3458	java/io/IOException
    //   1278	1284	3458	java/io/IOException
    //   1382	1390	3458	java/io/IOException
    //   1476	1480	3458	java/io/IOException
    //   3442	3452	3458	java/io/IOException
    //   792	797	3466	java/io/IOException
    //   2766	2771	3497	java/io/IOException
    //   148	154	3523	java/lang/RuntimeException
    //   194	201	3523	java/lang/RuntimeException
    //   633	642	3523	java/lang/RuntimeException
    //   677	685	3523	java/lang/RuntimeException
    //   720	727	3523	java/lang/RuntimeException
    //   762	773	3523	java/lang/RuntimeException
    //   1186	1193	3523	java/lang/RuntimeException
    //   1232	1239	3523	java/lang/RuntimeException
    //   1278	1284	3523	java/lang/RuntimeException
    //   1382	1390	3523	java/lang/RuntimeException
    //   1476	1480	3523	java/lang/RuntimeException
    //   3442	3452	3523	java/lang/RuntimeException
    //   3587	3592	3597	java/io/IOException
    //   148	154	3623	java/lang/UnsatisfiedLinkError
    //   194	201	3623	java/lang/UnsatisfiedLinkError
    //   633	642	3623	java/lang/UnsatisfiedLinkError
    //   677	685	3623	java/lang/UnsatisfiedLinkError
    //   720	727	3623	java/lang/UnsatisfiedLinkError
    //   762	773	3623	java/lang/UnsatisfiedLinkError
    //   1186	1193	3623	java/lang/UnsatisfiedLinkError
    //   1232	1239	3623	java/lang/UnsatisfiedLinkError
    //   1278	1284	3623	java/lang/UnsatisfiedLinkError
    //   1382	1390	3623	java/lang/UnsatisfiedLinkError
    //   1476	1480	3623	java/lang/UnsatisfiedLinkError
    //   3442	3452	3623	java/lang/UnsatisfiedLinkError
    //   3683	3688	3693	java/io/IOException
    //   148	154	3719	java/lang/Throwable
    //   194	201	3719	java/lang/Throwable
    //   633	642	3719	java/lang/Throwable
    //   677	685	3719	java/lang/Throwable
    //   720	727	3719	java/lang/Throwable
    //   762	773	3719	java/lang/Throwable
    //   1186	1193	3719	java/lang/Throwable
    //   1232	1239	3719	java/lang/Throwable
    //   1278	1284	3719	java/lang/Throwable
    //   1382	1390	3719	java/lang/Throwable
    //   1476	1480	3719	java/lang/Throwable
    //   3442	3452	3719	java/lang/Throwable
    //   3783	3788	3793	java/io/IOException
    //   148	154	3819	finally
    //   194	201	3819	finally
    //   633	642	3819	finally
    //   677	685	3819	finally
    //   720	727	3819	finally
    //   762	773	3819	finally
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
    //   3539	3543	3881	finally
    //   3550	3556	3881	finally
    //   3563	3573	3881	finally
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
                localObject = HexUtil.bytes2HexStr((byte[])localObject);
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
        paramString1 = DeviceInfoUtil.getIMEI();
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
      StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", (String)localObject, 1);
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
      if (yyi.g(paramString))
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (yyi.i(paramString))
        {
          StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, yxq paramyxq, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new yxk(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramyxq);
    paramAppActivity = new NewIntent(paramAppActivity, yvb.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramyxq = paramyxq.a();
    if (paramyxq != null)
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
        if (paramyxq.has(str)) {
          paramAppActivity.putExtra(str, paramyxq.optString(str));
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
    } while (awgd.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bijo.a));
    new awgd().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bijo.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, yxq paramyxq)
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
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bftt.b(2131230757, false);
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
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bftt.b(2131230757, false);
        }
        paramQQAppInterface.getQQProxyForQlink().a(paramAppActivity, paramString1, paramyxq);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.getQQProxyForQlink().a(paramAppActivity, paramyxq);
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
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bftt.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        yvc.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
        if (!HttpUtil.isConnect(paramAppActivity))
        {
          paramString1 = bfur.a(paramAppActivity, 230);
          paramString1.setMessage(2131717814);
          paramString2 = new yxj(paramyxq);
          paramString1.setPositiveButton(2131694201, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bftt.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).isWtLoginUrl(str)) && (!yyi.a(str)))
        {
          if (bhuh.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            bhuh.a().a(paramQQAppInterface, paramString1, paramView);
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
          abdm.a().a(1);
          abdm.a().jdField_a_of_type_JavaLangString = "";
          abdm.a().jdField_a_of_type_Int = 0;
          abdm.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramyxq, paramString1)) {
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
        else if (yyi.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (yyi.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (yyi.f(str))
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
          if (yyi.h(str))
          {
            if (yyi.b(str))
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
            if (bgab.a(paramString1))
            {
              bgab.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramyxq, paramView);
              i = 1;
            }
          }
          else
          {
            yvc.a(paramQQAppInterface, paramAppActivity, paramString1);
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
      int i = bijo.a();
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
 * Qualified Name:     yxi
 * JD-Core Version:    0.7.0.1
 */