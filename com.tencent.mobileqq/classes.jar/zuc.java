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

public class zuc
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
      int k = bjde.a(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bjde.a((int[])localObject, localObject.length);
      localObject = bjde.a();
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
    if ((RecogUtil.getSupportDetectType() >= 0) && (apcy.b()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = apcy.a().a(paramBitmap, l, localRect);
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
    //   104: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   163: invokestatic 86	apcy:b	()Z
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
    //   187: invokestatic 180	zuc:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 185	apdk:a	(ZZ)V
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
          if (!bjde.a(paramBitmap.getWidth(), paramBitmap.getHeight())) {
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
            apcy.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            j = i1;
            k = i2;
            m = i3;
            if (QLog.isColorLevel())
            {
              j = i1;
              k = i2;
              m = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(apcy.a()), Long.valueOf(l2) }));
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
      bjde.a(paramBitmap, localStringBuilder2);
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
        apcy.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   53: istore 15
    //   55: iconst_0
    //   56: istore 20
    //   58: iconst_0
    //   59: istore 19
    //   61: iconst_0
    //   62: istore 14
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
    //   80: astore 34
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
    //   115: ldc2_w 298
    //   118: lstore 30
    //   120: aload 40
    //   122: astore 38
    //   124: aload 39
    //   126: astore 37
    //   128: aload 34
    //   130: astore 35
    //   132: aload 41
    //   134: astore 36
    //   136: aload_1
    //   137: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   140: astore 42
    //   142: aload 40
    //   144: astore 38
    //   146: aload 39
    //   148: astore 37
    //   150: aload 34
    //   152: astore 35
    //   154: aload 41
    //   156: astore 36
    //   158: aload 42
    //   160: aload_0
    //   161: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore 34
    //   166: aload 34
    //   168: ifnull +5800 -> 5968
    //   171: aload 34
    //   173: astore 38
    //   175: aload 34
    //   177: astore 37
    //   179: aload 34
    //   181: astore 35
    //   183: aload 34
    //   185: astore 36
    //   187: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   190: lstore 28
    //   192: iload 4
    //   194: iconst_2
    //   195: iand
    //   196: iconst_2
    //   197: if_icmpne +126 -> 323
    //   200: iload 22
    //   202: istore 7
    //   204: invokestatic 98	apcy:a	()Lapcy;
    //   207: invokestatic 209	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   210: lload 28
    //   212: ldc_w 292
    //   215: invokevirtual 214	apcy:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   218: iconst_1
    //   219: istore 23
    //   221: iconst_1
    //   222: istore 25
    //   224: iconst_1
    //   225: istore 26
    //   227: iconst_1
    //   228: istore 22
    //   230: iconst_1
    //   231: istore 27
    //   233: iconst_1
    //   234: istore 24
    //   236: iload 24
    //   238: istore 6
    //   240: iload 23
    //   242: istore 7
    //   244: iload 25
    //   246: istore 8
    //   248: iload 26
    //   250: istore 9
    //   252: iload 22
    //   254: istore 10
    //   256: iload 27
    //   258: istore 11
    //   260: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +60 -> 323
    //   266: iload 23
    //   268: istore 7
    //   270: iload 25
    //   272: istore 8
    //   274: iload 26
    //   276: istore 9
    //   278: iload 22
    //   280: istore 10
    //   282: iload 27
    //   284: istore 11
    //   286: ldc_w 292
    //   289: iconst_2
    //   290: ldc 216
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: invokestatic 218	apcy:a	()Z
    //   301: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 28
    //   309: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: aastore
    //   313: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 24
    //   321: istore 6
    //   323: new 45	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   330: astore 40
    //   332: iload_3
    //   333: ifeq +1051 -> 1384
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
    //   381: ifnull +5570 -> 5951
    //   384: aload 36
    //   386: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   389: istore 20
    //   391: aload 36
    //   393: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   396: istore 21
    //   398: iload 20
    //   400: iload 21
    //   402: invokestatic 201	bjde:a	(II)Z
    //   405: istore_3
    //   406: iload_3
    //   407: ifne +5537 -> 5944
    //   410: iload 4
    //   412: bipush 254
    //   414: iand
    //   415: istore 8
    //   417: iload 20
    //   419: iload 21
    //   421: imul
    //   422: newarray int
    //   424: astore_1
    //   425: aload 36
    //   427: aload_1
    //   428: iconst_0
    //   429: iload 20
    //   431: iconst_0
    //   432: iconst_0
    //   433: iload 20
    //   435: iload 21
    //   437: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   440: iload 8
    //   442: iconst_1
    //   443: iand
    //   444: iconst_1
    //   445: if_icmpne +5493 -> 5938
    //   448: invokestatic 203	zuc:a	()I
    //   451: pop
    //   452: iconst_1
    //   453: istore 4
    //   455: iload 4
    //   457: istore 12
    //   459: iload 4
    //   461: istore 13
    //   463: iload 19
    //   465: istore 9
    //   467: iload 4
    //   469: istore 15
    //   471: iload 14
    //   473: istore 10
    //   475: iload 4
    //   477: istore 14
    //   479: iload 18
    //   481: istore 11
    //   483: aload_1
    //   484: aconst_null
    //   485: iload 20
    //   487: iload 21
    //   489: iload 8
    //   491: aload 40
    //   493: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
    //   496: istore 7
    //   498: iload 4
    //   500: istore 12
    //   502: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   505: ifeq +48 -> 553
    //   508: iload 4
    //   510: istore 12
    //   512: ldc_w 292
    //   515: iconst_4
    //   516: ldc_w 329
    //   519: iconst_3
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: iload 8
    //   527: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: iload 7
    //   535: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: dup
    //   540: iconst_2
    //   541: aload 40
    //   543: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: aastore
    //   547: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   550: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: iload 4
    //   555: istore 12
    //   557: iload 20
    //   559: iload 21
    //   561: imul
    //   562: newarray byte
    //   564: astore 35
    //   566: iload 4
    //   568: istore 12
    //   570: aload_1
    //   571: aload 35
    //   573: iload 20
    //   575: iload 21
    //   577: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   580: pop
    //   581: iload 8
    //   583: iconst_2
    //   584: iand
    //   585: iconst_2
    //   586: if_icmpne +497 -> 1083
    //   589: iload 7
    //   591: iconst_2
    //   592: iand
    //   593: ifne +490 -> 1083
    //   596: iconst_1
    //   597: istore 9
    //   599: iload 4
    //   601: istore 12
    //   603: invokestatic 81	com/tencent/mobileqq/minicode/RecogUtil:getSupportDetectType	()I
    //   606: iflt +13 -> 619
    //   609: iload 4
    //   611: istore 12
    //   613: invokestatic 218	apcy:a	()Z
    //   616: ifeq +3 -> 619
    //   619: iload 9
    //   621: ifeq +5314 -> 5935
    //   624: iload 4
    //   626: istore 12
    //   628: aload 36
    //   630: iload 20
    //   632: iload 21
    //   634: aload_1
    //   635: aload 35
    //   637: aload 40
    //   639: invokestatic 180	zuc:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   642: istore 9
    //   644: iload 7
    //   646: iload 9
    //   648: ior
    //   649: istore 7
    //   651: iload 4
    //   653: istore 12
    //   655: iload 4
    //   657: istore 13
    //   659: iload 7
    //   661: istore 9
    //   663: iload 4
    //   665: istore 15
    //   667: iload 7
    //   669: istore 10
    //   671: iload 4
    //   673: istore 14
    //   675: iload 7
    //   677: istore 11
    //   679: iload 7
    //   681: istore 16
    //   683: iload 7
    //   685: istore 17
    //   687: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   690: ifeq +66 -> 756
    //   693: iload 4
    //   695: istore 12
    //   697: iload 4
    //   699: istore 13
    //   701: iload 7
    //   703: istore 9
    //   705: iload 4
    //   707: istore 15
    //   709: iload 7
    //   711: istore 10
    //   713: iload 4
    //   715: istore 14
    //   717: iload 7
    //   719: istore 11
    //   721: iload 7
    //   723: istore 16
    //   725: iload 7
    //   727: istore 17
    //   729: ldc 43
    //   731: iconst_4
    //   732: new 45	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 331
    //   742: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: iload 7
    //   747: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: iload 4
    //   758: istore 12
    //   760: aload 36
    //   762: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   765: iload 4
    //   767: istore 9
    //   769: iload 7
    //   771: istore 4
    //   773: aload 34
    //   775: astore_1
    //   776: iload 9
    //   778: istore 7
    //   780: iload 8
    //   782: istore 9
    //   784: iload 4
    //   786: iflt +201 -> 987
    //   789: iload 4
    //   791: iconst_1
    //   792: iand
    //   793: iconst_1
    //   794: if_icmpne +3200 -> 3994
    //   797: iconst_1
    //   798: istore_3
    //   799: iload_3
    //   800: ifeq +5185 -> 5985
    //   803: aload 5
    //   805: ifnull +5180 -> 5985
    //   808: iload_2
    //   809: ifeq +5176 -> 5985
    //   812: aload_1
    //   813: astore 34
    //   815: iload 7
    //   817: istore 8
    //   819: new 45	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   826: astore 35
    //   828: aload_1
    //   829: astore 34
    //   831: iload 7
    //   833: istore 8
    //   835: new 45	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   842: astore 36
    //   844: aload_1
    //   845: astore 34
    //   847: iload 7
    //   849: istore 8
    //   851: aload 35
    //   853: aload 36
    //   855: invokestatic 241	bjde:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   858: pop
    //   859: aload_1
    //   860: astore 34
    //   862: iload 7
    //   864: istore 8
    //   866: aload 5
    //   868: iconst_1
    //   869: new 243	android/util/Pair
    //   872: dup
    //   873: aload 36
    //   875: aload 35
    //   877: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   880: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   883: goto +5102 -> 5985
    //   886: iload_2
    //   887: ifeq +26 -> 913
    //   890: aload 5
    //   892: ifnull +21 -> 913
    //   895: aload_1
    //   896: astore 34
    //   898: iload 7
    //   900: istore 8
    //   902: aload 5
    //   904: iconst_2
    //   905: aload 40
    //   907: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokevirtual 252	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   913: aload_1
    //   914: astore 34
    //   916: iload 7
    //   918: istore 8
    //   920: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   923: ifeq +64 -> 987
    //   926: aload_1
    //   927: astore 34
    //   929: iload 7
    //   931: istore 8
    //   933: ldc_w 292
    //   936: iconst_2
    //   937: ldc 254
    //   939: iconst_5
    //   940: anewarray 4	java/lang/Object
    //   943: dup
    //   944: iconst_0
    //   945: iload 9
    //   947: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   950: aastore
    //   951: dup
    //   952: iconst_1
    //   953: iload 4
    //   955: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   958: aastore
    //   959: dup
    //   960: iconst_2
    //   961: iload_3
    //   962: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   965: aastore
    //   966: dup
    //   967: iconst_3
    //   968: iload_2
    //   969: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   972: aastore
    //   973: dup
    //   974: iconst_4
    //   975: aload 40
    //   977: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: aastore
    //   981: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   984: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: iload 7
    //   989: ifeq +7 -> 996
    //   992: invokestatic 256	zuc:b	()I
    //   995: pop
    //   996: iload 6
    //   998: ifeq +14 -> 1012
    //   1001: invokestatic 98	apcy:a	()Lapcy;
    //   1004: lload 28
    //   1006: ldc_w 292
    //   1009: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
    //   1012: iload 4
    //   1014: istore 6
    //   1016: aload_1
    //   1017: ifnull +11 -> 1028
    //   1020: aload_1
    //   1021: invokevirtual 339	java/io/InputStream:close	()V
    //   1024: iload 4
    //   1026: istore 6
    //   1028: iload 6
    //   1030: istore 4
    //   1032: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1035: ifeq -1024 -> 11
    //   1038: ldc_w 292
    //   1041: iconst_4
    //   1042: new 45	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 341
    //   1052: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   1058: lload 32
    //   1060: lsub
    //   1061: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1064: ldc_w 343
    //   1067: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_0
    //   1071: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1080: iload 6
    //   1082: ireturn
    //   1083: iconst_0
    //   1084: istore 9
    //   1086: goto -487 -> 599
    //   1089: astore_1
    //   1090: iconst_0
    //   1091: istore 9
    //   1093: iload 13
    //   1095: istore 8
    //   1097: iload 4
    //   1099: istore 7
    //   1101: iload 9
    //   1103: istore 4
    //   1105: iload 4
    //   1107: istore 12
    //   1109: iload 4
    //   1111: istore 17
    //   1113: iload 8
    //   1115: istore 16
    //   1117: iload 4
    //   1119: istore 13
    //   1121: iload 8
    //   1123: istore 9
    //   1125: iload 4
    //   1127: istore 15
    //   1129: iload 8
    //   1131: istore 10
    //   1133: iload 4
    //   1135: istore 14
    //   1137: iload 8
    //   1139: istore 11
    //   1141: aload_1
    //   1142: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1145: iload 4
    //   1147: istore 12
    //   1149: iload 4
    //   1151: istore 17
    //   1153: iload 8
    //   1155: istore 16
    //   1157: iload 4
    //   1159: istore 13
    //   1161: iload 8
    //   1163: istore 9
    //   1165: iload 4
    //   1167: istore 15
    //   1169: iload 8
    //   1171: istore 10
    //   1173: iload 4
    //   1175: istore 14
    //   1177: iload 8
    //   1179: istore 11
    //   1181: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1184: ifeq +4814 -> 5998
    //   1187: iload 4
    //   1189: istore 12
    //   1191: iload 4
    //   1193: istore 17
    //   1195: iload 8
    //   1197: istore 16
    //   1199: iload 4
    //   1201: istore 13
    //   1203: iload 8
    //   1205: istore 9
    //   1207: iload 4
    //   1209: istore 15
    //   1211: iload 8
    //   1213: istore 10
    //   1215: iload 4
    //   1217: istore 14
    //   1219: iload 8
    //   1221: istore 11
    //   1223: ldc_w 292
    //   1226: iconst_2
    //   1227: aload_1
    //   1228: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1231: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1234: goto +4764 -> 5998
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
    //   1299: istore 15
    //   1301: iload 8
    //   1303: istore 10
    //   1305: iload 4
    //   1307: istore 14
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
    //   1341: istore 15
    //   1343: iload 8
    //   1345: istore 10
    //   1347: iload 4
    //   1349: istore 14
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
    //   1381: goto -597 -> 784
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
    //   1433: istore 16
    //   1435: aload_1
    //   1436: astore 34
    //   1438: iload 21
    //   1440: istore 8
    //   1442: aload 41
    //   1444: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
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
    //   1473: invokestatic 98	apcy:a	()Lapcy;
    //   1476: lload 28
    //   1478: ldc_w 292
    //   1481: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
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
    //   1534: iload 16
    //   1536: iload 15
    //   1538: invokestatic 201	bjde:a	(II)Z
    //   1541: ifne +4387 -> 5928
    //   1544: iload 4
    //   1546: bipush 254
    //   1548: iand
    //   1549: istore 10
    //   1551: iload 10
    //   1553: iconst_1
    //   1554: iand
    //   1555: iconst_1
    //   1556: if_icmpne +4366 -> 5922
    //   1559: aload_1
    //   1560: astore 34
    //   1562: iload 21
    //   1564: istore 8
    //   1566: invokestatic 203	zuc:a	()I
    //   1569: pop
    //   1570: iconst_1
    //   1571: istore 7
    //   1573: aload 35
    //   1575: astore_1
    //   1576: aload 41
    //   1578: aload 41
    //   1580: sipush 1280
    //   1583: sipush 1280
    //   1586: invokestatic 373	akgy:a	(Landroid/graphics/BitmapFactory$Options;II)I
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
    //   1629: astore 39
    //   1631: aload 35
    //   1633: astore 38
    //   1635: aload 35
    //   1637: astore 36
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
    //   1662: astore 39
    //   1664: aload 35
    //   1666: astore 38
    //   1668: aload 35
    //   1670: astore 36
    //   1672: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1675: ifeq +70 -> 1745
    //   1678: aload 35
    //   1680: astore 34
    //   1682: aload 35
    //   1684: astore_1
    //   1685: aload 35
    //   1687: astore 37
    //   1689: aload 35
    //   1691: astore 39
    //   1693: aload 35
    //   1695: astore 38
    //   1697: aload 35
    //   1699: astore 36
    //   1701: ldc_w 292
    //   1704: iconst_4
    //   1705: ldc_w 378
    //   1708: iconst_3
    //   1709: anewarray 4	java/lang/Object
    //   1712: dup
    //   1713: iconst_0
    //   1714: iload 16
    //   1716: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1719: aastore
    //   1720: dup
    //   1721: iconst_1
    //   1722: iload 15
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
    //   1758: astore 39
    //   1760: aload 35
    //   1762: astore 38
    //   1764: aload 35
    //   1766: astore 36
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
    //   1793: invokestatic 225	zuc:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
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
    //   1836: invokestatic 227	zuc:a	(II)I
    //   1839: istore 17
    //   1841: iload 17
    //   1843: ifle +4070 -> 5913
    //   1846: iload 16
    //   1848: iload 15
    //   1850: iconst_2
    //   1851: imul
    //   1852: if_icmplt +1092 -> 2944
    //   1855: iload 15
    //   1857: sipush 1280
    //   1860: if_icmpge +1084 -> 2944
    //   1863: iconst_1
    //   1864: istore 8
    //   1866: iload 16
    //   1868: iconst_2
    //   1869: imul
    //   1870: iload 15
    //   1872: if_icmpgt +1078 -> 2950
    //   1875: iload 16
    //   1877: sipush 1280
    //   1880: if_icmpge +1070 -> 2950
    //   1883: iconst_1
    //   1884: istore 9
    //   1886: iload 9
    //   1888: ifeq +1159 -> 3047
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
    //   1913: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1916: astore 34
    //   1918: aload 34
    //   1920: astore 35
    //   1922: aload 34
    //   1924: astore_1
    //   1925: aload 34
    //   1927: astore 37
    //   1929: iload 4
    //   1931: istore 12
    //   1933: aload 34
    //   1935: astore 38
    //   1937: iload 4
    //   1939: istore 11
    //   1941: aload 34
    //   1943: astore 36
    //   1945: iload 4
    //   1947: istore 13
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
    //   1977: istore 12
    //   1979: aload 34
    //   1981: astore 38
    //   1983: iload 4
    //   1985: istore 11
    //   1987: aload 34
    //   1989: astore 36
    //   1991: iload 4
    //   1993: istore 13
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
    //   2022: istore 12
    //   2024: aload 34
    //   2026: astore 38
    //   2028: iload 4
    //   2030: istore 11
    //   2032: aload 34
    //   2034: astore 36
    //   2036: iload 4
    //   2038: istore 13
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
    //   2089: istore 12
    //   2091: aload 34
    //   2093: astore 38
    //   2095: iload 4
    //   2097: istore 11
    //   2099: aload 34
    //   2101: astore 36
    //   2103: iload 4
    //   2105: istore 13
    //   2107: aload 34
    //   2109: astore 39
    //   2111: iload 4
    //   2113: istore 9
    //   2115: aload 34
    //   2117: invokevirtual 339	java/io/InputStream:close	()V
    //   2120: aconst_null
    //   2121: astore 35
    //   2123: aconst_null
    //   2124: astore 36
    //   2126: aconst_null
    //   2127: astore 37
    //   2129: aconst_null
    //   2130: astore 34
    //   2132: aload 43
    //   2134: ifnull +3785 -> 5919
    //   2137: iload 4
    //   2139: istore 9
    //   2141: iload 4
    //   2143: istore 12
    //   2145: iload 4
    //   2147: istore 11
    //   2149: iload 4
    //   2151: istore 8
    //   2153: iload 4
    //   2155: istore 13
    //   2157: iload 16
    //   2159: iload 16
    //   2161: imul
    //   2162: newarray int
    //   2164: astore_1
    //   2165: iload 4
    //   2167: istore 9
    //   2169: iload 4
    //   2171: istore 12
    //   2173: iload 4
    //   2175: istore 11
    //   2177: iload 4
    //   2179: istore 8
    //   2181: iload 4
    //   2183: istore 13
    //   2185: aload 43
    //   2187: aload_1
    //   2188: iconst_0
    //   2189: iload 16
    //   2191: iconst_0
    //   2192: iconst_0
    //   2193: iload 16
    //   2195: iload 16
    //   2197: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2200: iload 4
    //   2202: istore 9
    //   2204: iload 4
    //   2206: istore 12
    //   2208: iload 4
    //   2210: istore 11
    //   2212: iload 4
    //   2214: istore 8
    //   2216: iload 4
    //   2218: istore 13
    //   2220: iload 16
    //   2222: iload 16
    //   2224: imul
    //   2225: newarray byte
    //   2227: astore 38
    //   2229: iload 4
    //   2231: istore 9
    //   2233: iload 4
    //   2235: istore 12
    //   2237: iload 4
    //   2239: istore 11
    //   2241: iload 4
    //   2243: istore 8
    //   2245: iload 4
    //   2247: istore 13
    //   2249: aload_1
    //   2250: aload 38
    //   2252: iload 16
    //   2254: iload 16
    //   2256: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2259: pop
    //   2260: iload 4
    //   2262: istore 9
    //   2264: iload 4
    //   2266: istore 12
    //   2268: iload 4
    //   2270: istore 11
    //   2272: iload 4
    //   2274: istore 8
    //   2276: iload 4
    //   2278: istore 13
    //   2280: iload 4
    //   2282: aload_1
    //   2283: aload 38
    //   2285: iload 16
    //   2287: iload 16
    //   2289: iload 17
    //   2291: aload 40
    //   2293: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2296: ior
    //   2297: istore 4
    //   2299: iload 4
    //   2301: iconst_1
    //   2302: if_icmpeq +3614 -> 5916
    //   2305: iload 4
    //   2307: istore 9
    //   2309: iload 4
    //   2311: istore 12
    //   2313: iload 4
    //   2315: istore 11
    //   2317: iload 4
    //   2319: istore 8
    //   2321: iload 4
    //   2323: istore 13
    //   2325: aload 43
    //   2327: aload_1
    //   2328: iconst_0
    //   2329: iload 16
    //   2331: iconst_0
    //   2332: iload 15
    //   2334: iload 16
    //   2336: isub
    //   2337: iload 16
    //   2339: iload 16
    //   2341: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2344: iload 4
    //   2346: istore 9
    //   2348: iload 4
    //   2350: istore 12
    //   2352: iload 4
    //   2354: istore 11
    //   2356: iload 4
    //   2358: istore 8
    //   2360: iload 4
    //   2362: istore 13
    //   2364: aload_1
    //   2365: aload 38
    //   2367: iload 16
    //   2369: iload 16
    //   2371: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2374: pop
    //   2375: iload 4
    //   2377: istore 9
    //   2379: iload 4
    //   2381: istore 12
    //   2383: iload 4
    //   2385: istore 11
    //   2387: iload 4
    //   2389: istore 8
    //   2391: iload 4
    //   2393: istore 13
    //   2395: aload_1
    //   2396: aload 38
    //   2398: iload 16
    //   2400: iload 16
    //   2402: iload 17
    //   2404: aload 40
    //   2406: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   2486: invokestatic 227	zuc:a	(II)I
    //   2489: istore 13
    //   2491: iload 13
    //   2493: ifle +3410 -> 5903
    //   2496: aload 34
    //   2498: astore_1
    //   2499: iload 16
    //   2501: iload 15
    //   2503: invokestatic 232	java/lang/Math:min	(II)I
    //   2506: istore 8
    //   2508: iload 8
    //   2510: sipush 250
    //   2513: if_icmple +3390 -> 5903
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
    //   2559: istore 11
    //   2561: aload 34
    //   2563: astore 36
    //   2565: iload 4
    //   2567: istore 9
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
    //   2608: istore 11
    //   2610: aload 34
    //   2612: astore 36
    //   2614: iload 4
    //   2616: istore 9
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
    //   2653: istore 11
    //   2655: aload 34
    //   2657: astore 36
    //   2659: iload 4
    //   2661: istore 9
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
    //   2720: istore 11
    //   2722: aload 34
    //   2724: astore 36
    //   2726: iload 4
    //   2728: istore 9
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
    //   2753: ifnull +3143 -> 5896
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
    //   2808: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   2885: goto -2101 -> 784
    //   2888: astore 35
    //   2890: aload 34
    //   2892: astore_1
    //   2893: aload 34
    //   2895: astore 37
    //   2897: aload 34
    //   2899: astore 39
    //   2901: aload 34
    //   2903: astore 38
    //   2905: aload 34
    //   2907: astore 36
    //   2909: aload 35
    //   2911: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2914: aload 34
    //   2916: astore_1
    //   2917: aload 34
    //   2919: astore 37
    //   2921: aload 34
    //   2923: astore 39
    //   2925: aload 34
    //   2927: astore 38
    //   2929: aload 34
    //   2931: astore 36
    //   2933: aload 34
    //   2935: invokevirtual 339	java/io/InputStream:close	()V
    //   2938: iconst_0
    //   2939: istore 4
    //   2941: goto -1137 -> 1804
    //   2944: iconst_0
    //   2945: istore 8
    //   2947: goto -1081 -> 1866
    //   2950: iconst_0
    //   2951: istore 9
    //   2953: goto -1067 -> 1886
    //   2956: astore_1
    //   2957: aload 35
    //   2959: astore 34
    //   2961: aload_1
    //   2962: astore 35
    //   2964: aload 34
    //   2966: astore_1
    //   2967: aload 34
    //   2969: astore 37
    //   2971: iload 4
    //   2973: istore 12
    //   2975: aload 34
    //   2977: astore 38
    //   2979: iload 4
    //   2981: istore 11
    //   2983: aload 34
    //   2985: astore 36
    //   2987: iload 4
    //   2989: istore 13
    //   2991: aload 34
    //   2993: astore 39
    //   2995: iload 4
    //   2997: istore 9
    //   2999: aload 35
    //   3001: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3004: aload 34
    //   3006: astore_1
    //   3007: aload 34
    //   3009: astore 37
    //   3011: iload 4
    //   3013: istore 12
    //   3015: aload 34
    //   3017: astore 38
    //   3019: iload 4
    //   3021: istore 11
    //   3023: aload 34
    //   3025: astore 36
    //   3027: iload 4
    //   3029: istore 13
    //   3031: aload 34
    //   3033: astore 39
    //   3035: iload 4
    //   3037: istore 9
    //   3039: aload 34
    //   3041: invokevirtual 339	java/io/InputStream:close	()V
    //   3044: goto -574 -> 2470
    //   3047: iload 8
    //   3049: ifeq +2864 -> 5913
    //   3052: iload 4
    //   3054: istore 8
    //   3056: aload 36
    //   3058: astore_1
    //   3059: iload 4
    //   3061: istore 13
    //   3063: iload 4
    //   3065: istore 14
    //   3067: iload 4
    //   3069: istore 12
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
    //   3096: astore 37
    //   3098: iload 4
    //   3100: istore 12
    //   3102: aload 35
    //   3104: astore 38
    //   3106: iload 4
    //   3108: istore 11
    //   3110: aload 35
    //   3112: astore 36
    //   3114: iload 4
    //   3116: istore 13
    //   3118: aload 35
    //   3120: astore 39
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
    //   3146: astore 37
    //   3148: iload 4
    //   3150: istore 12
    //   3152: aload 35
    //   3154: astore 38
    //   3156: iload 4
    //   3158: istore 11
    //   3160: aload 35
    //   3162: astore 36
    //   3164: iload 4
    //   3166: istore 13
    //   3168: aload 35
    //   3170: astore 39
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
    //   3195: astore 37
    //   3197: iload 4
    //   3199: istore 12
    //   3201: aload 35
    //   3203: astore 38
    //   3205: iload 4
    //   3207: istore 11
    //   3209: aload 35
    //   3211: astore 36
    //   3213: iload 4
    //   3215: istore 13
    //   3217: aload 35
    //   3219: astore 39
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
    //   3266: astore 37
    //   3268: iload 4
    //   3270: istore 12
    //   3272: aload 35
    //   3274: astore 38
    //   3276: iload 4
    //   3278: istore 11
    //   3280: aload 35
    //   3282: astore 36
    //   3284: iload 4
    //   3286: istore 13
    //   3288: aload 35
    //   3290: astore 39
    //   3292: iload 4
    //   3294: istore 9
    //   3296: aload 35
    //   3298: invokevirtual 339	java/io/InputStream:close	()V
    //   3301: aconst_null
    //   3302: astore 36
    //   3304: aconst_null
    //   3305: astore 35
    //   3307: iload 4
    //   3309: istore 9
    //   3311: aload 43
    //   3313: ifnull +488 -> 3801
    //   3316: aload 35
    //   3318: astore 34
    //   3320: iload 4
    //   3322: istore 8
    //   3324: aload 36
    //   3326: astore_1
    //   3327: iload 4
    //   3329: istore 13
    //   3331: iload 4
    //   3333: istore 14
    //   3335: iload 4
    //   3337: istore 12
    //   3339: iload 4
    //   3341: istore 11
    //   3343: iload 15
    //   3345: iload 15
    //   3347: imul
    //   3348: newarray int
    //   3350: astore 38
    //   3352: aload 35
    //   3354: astore 34
    //   3356: iload 4
    //   3358: istore 8
    //   3360: aload 36
    //   3362: astore_1
    //   3363: iload 4
    //   3365: istore 13
    //   3367: iload 4
    //   3369: istore 14
    //   3371: iload 4
    //   3373: istore 12
    //   3375: iload 4
    //   3377: istore 11
    //   3379: aload 43
    //   3381: aload 38
    //   3383: iconst_0
    //   3384: iload 15
    //   3386: iconst_0
    //   3387: iconst_0
    //   3388: iload 15
    //   3390: iload 15
    //   3392: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3395: aload 35
    //   3397: astore 34
    //   3399: iload 4
    //   3401: istore 8
    //   3403: aload 36
    //   3405: astore_1
    //   3406: iload 4
    //   3408: istore 13
    //   3410: iload 4
    //   3412: istore 14
    //   3414: iload 4
    //   3416: istore 12
    //   3418: iload 4
    //   3420: istore 11
    //   3422: iload 15
    //   3424: iload 15
    //   3426: imul
    //   3427: newarray byte
    //   3429: astore 37
    //   3431: aload 35
    //   3433: astore 34
    //   3435: iload 4
    //   3437: istore 8
    //   3439: aload 36
    //   3441: astore_1
    //   3442: iload 4
    //   3444: istore 13
    //   3446: iload 4
    //   3448: istore 14
    //   3450: iload 4
    //   3452: istore 12
    //   3454: iload 4
    //   3456: istore 11
    //   3458: aload 38
    //   3460: aload 37
    //   3462: iload 15
    //   3464: iload 15
    //   3466: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3469: pop
    //   3470: aload 35
    //   3472: astore 34
    //   3474: iload 4
    //   3476: istore 8
    //   3478: aload 36
    //   3480: astore_1
    //   3481: iload 4
    //   3483: istore 13
    //   3485: iload 4
    //   3487: istore 14
    //   3489: iload 4
    //   3491: istore 12
    //   3493: iload 4
    //   3495: istore 11
    //   3497: iload 4
    //   3499: aload 38
    //   3501: aload 37
    //   3503: iload 15
    //   3505: iload 15
    //   3507: iload 17
    //   3509: aload 40
    //   3511: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3514: ior
    //   3515: istore 9
    //   3517: iload 9
    //   3519: istore 4
    //   3521: iload 9
    //   3523: iconst_1
    //   3524: if_icmpeq +136 -> 3660
    //   3527: aload 35
    //   3529: astore 34
    //   3531: iload 9
    //   3533: istore 8
    //   3535: aload 36
    //   3537: astore_1
    //   3538: iload 9
    //   3540: istore 13
    //   3542: iload 9
    //   3544: istore 14
    //   3546: iload 9
    //   3548: istore 12
    //   3550: iload 9
    //   3552: istore 11
    //   3554: aload 43
    //   3556: aload 38
    //   3558: iconst_0
    //   3559: iload 15
    //   3561: iload 16
    //   3563: iload 15
    //   3565: isub
    //   3566: iconst_0
    //   3567: iload 15
    //   3569: iload 15
    //   3571: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3574: aload 35
    //   3576: astore 34
    //   3578: iload 9
    //   3580: istore 8
    //   3582: aload 36
    //   3584: astore_1
    //   3585: iload 9
    //   3587: istore 13
    //   3589: iload 9
    //   3591: istore 14
    //   3593: iload 9
    //   3595: istore 12
    //   3597: iload 9
    //   3599: istore 11
    //   3601: aload 38
    //   3603: aload 37
    //   3605: iload 15
    //   3607: iload 15
    //   3609: invokestatic 173	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3612: pop
    //   3613: aload 35
    //   3615: astore 34
    //   3617: iload 9
    //   3619: istore 8
    //   3621: aload 36
    //   3623: astore_1
    //   3624: iload 9
    //   3626: istore 13
    //   3628: iload 9
    //   3630: istore 14
    //   3632: iload 9
    //   3634: istore 12
    //   3636: iload 9
    //   3638: istore 11
    //   3640: iload 9
    //   3642: aload 38
    //   3644: aload 37
    //   3646: iload 15
    //   3648: iload 15
    //   3650: iload 17
    //   3652: aload 40
    //   3654: invokestatic 176	zuc:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3657: ior
    //   3658: istore 4
    //   3660: aload 35
    //   3662: astore 34
    //   3664: iload 4
    //   3666: istore 8
    //   3668: aload 36
    //   3670: astore_1
    //   3671: iload 4
    //   3673: istore 13
    //   3675: iload 4
    //   3677: istore 14
    //   3679: iload 4
    //   3681: istore 12
    //   3683: iload 4
    //   3685: istore 11
    //   3687: aload 43
    //   3689: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   3692: iload 4
    //   3694: istore 9
    //   3696: aload 35
    //   3698: astore 34
    //   3700: iload 4
    //   3702: istore 8
    //   3704: aload 36
    //   3706: astore_1
    //   3707: iload 4
    //   3709: istore 13
    //   3711: iload 4
    //   3713: istore 14
    //   3715: iload 4
    //   3717: istore 12
    //   3719: iload 4
    //   3721: istore 11
    //   3723: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3726: ifeq +75 -> 3801
    //   3729: aload 35
    //   3731: astore 34
    //   3733: iload 4
    //   3735: istore 8
    //   3737: aload 36
    //   3739: astore_1
    //   3740: iload 4
    //   3742: istore 13
    //   3744: iload 4
    //   3746: istore 14
    //   3748: iload 4
    //   3750: istore 12
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
    //   3815: astore 37
    //   3817: iload 8
    //   3819: istore 12
    //   3821: aload 34
    //   3823: astore 38
    //   3825: iload 8
    //   3827: istore 11
    //   3829: aload 34
    //   3831: astore 36
    //   3833: iload 8
    //   3835: istore 13
    //   3837: aload 34
    //   3839: astore 39
    //   3841: iload 8
    //   3843: istore 9
    //   3845: aload 35
    //   3847: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3850: aload 34
    //   3852: astore_1
    //   3853: aload 34
    //   3855: astore 37
    //   3857: iload 8
    //   3859: istore 12
    //   3861: aload 34
    //   3863: astore 38
    //   3865: iload 8
    //   3867: istore 11
    //   3869: aload 34
    //   3871: astore 36
    //   3873: iload 8
    //   3875: istore 13
    //   3877: aload 34
    //   3879: astore 39
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
    //   3914: istore 11
    //   3916: aload 34
    //   3918: astore 36
    //   3920: iload 4
    //   3922: istore 9
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
    //   3954: istore 11
    //   3956: aload 34
    //   3958: astore 36
    //   3960: iload 4
    //   3962: istore 9
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
    //   3991: goto -3207 -> 784
    //   3994: iconst_0
    //   3995: istore_3
    //   3996: goto -3197 -> 799
    //   3999: iconst_0
    //   4000: istore_2
    //   4001: goto -3115 -> 886
    //   4004: astore_1
    //   4005: aload_1
    //   4006: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4009: iload 4
    //   4011: istore 6
    //   4013: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4016: ifeq -2988 -> 1028
    //   4019: ldc 43
    //   4021: iconst_2
    //   4022: aload_1
    //   4023: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4026: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4029: iload 4
    //   4031: istore 6
    //   4033: goto -3005 -> 1028
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
    //   4081: invokestatic 256	zuc:b	()I
    //   4084: pop
    //   4085: iload 6
    //   4087: ifeq +14 -> 4101
    //   4090: invokestatic 98	apcy:a	()Lapcy;
    //   4093: lload 28
    //   4095: ldc_w 292
    //   4098: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
    //   4101: iload 4
    //   4103: istore 6
    //   4105: aload 34
    //   4107: ifnull -3079 -> 1028
    //   4110: aload 34
    //   4112: invokevirtual 339	java/io/InputStream:close	()V
    //   4115: iload 4
    //   4117: istore 6
    //   4119: goto -3091 -> 1028
    //   4122: astore_1
    //   4123: aload_1
    //   4124: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4127: iload 4
    //   4129: istore 6
    //   4131: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4134: ifeq -3106 -> 1028
    //   4137: ldc 43
    //   4139: iconst_2
    //   4140: aload_1
    //   4141: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4144: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4147: iload 4
    //   4149: istore 6
    //   4151: goto -3123 -> 1028
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
    //   4247: invokestatic 256	zuc:b	()I
    //   4250: pop
    //   4251: iload 6
    //   4253: ifeq +14 -> 4267
    //   4256: invokestatic 98	apcy:a	()Lapcy;
    //   4259: lload 30
    //   4261: ldc_w 292
    //   4264: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
    //   4267: iload 4
    //   4269: istore 6
    //   4271: aload 34
    //   4273: ifnull -3245 -> 1028
    //   4276: aload 34
    //   4278: invokevirtual 339	java/io/InputStream:close	()V
    //   4281: iload 4
    //   4283: istore 6
    //   4285: goto -3257 -> 1028
    //   4288: astore_1
    //   4289: aload_1
    //   4290: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4293: iload 4
    //   4295: istore 6
    //   4297: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4300: ifeq -3272 -> 1028
    //   4303: ldc 43
    //   4305: iconst_2
    //   4306: aload_1
    //   4307: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4310: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4313: iload 4
    //   4315: istore 6
    //   4317: goto -3289 -> 1028
    //   4320: astore_1
    //   4321: ldc2_w 298
    //   4324: lstore 30
    //   4326: iconst_0
    //   4327: istore 6
    //   4329: iconst_0
    //   4330: istore 7
    //   4332: iconst_0
    //   4333: istore 4
    //   4335: aload 35
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
    //   4413: invokestatic 256	zuc:b	()I
    //   4416: pop
    //   4417: iload 6
    //   4419: ifeq +14 -> 4433
    //   4422: invokestatic 98	apcy:a	()Lapcy;
    //   4425: lload 30
    //   4427: ldc_w 292
    //   4430: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
    //   4433: iload 4
    //   4435: istore 6
    //   4437: aload 34
    //   4439: ifnull -3411 -> 1028
    //   4442: aload 34
    //   4444: invokevirtual 339	java/io/InputStream:close	()V
    //   4447: iload 4
    //   4449: istore 6
    //   4451: goto -3423 -> 1028
    //   4454: astore_1
    //   4455: aload_1
    //   4456: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4459: iload 4
    //   4461: istore 6
    //   4463: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4466: ifeq -3438 -> 1028
    //   4469: ldc 43
    //   4471: iconst_2
    //   4472: aload_1
    //   4473: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4476: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4479: iload 4
    //   4481: istore 6
    //   4483: goto -3455 -> 1028
    //   4486: astore_1
    //   4487: ldc2_w 298
    //   4490: lstore 30
    //   4492: iconst_0
    //   4493: istore 6
    //   4495: iconst_0
    //   4496: istore 7
    //   4498: iconst_0
    //   4499: istore 4
    //   4501: aload 36
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
    //   4579: invokestatic 256	zuc:b	()I
    //   4582: pop
    //   4583: iload 6
    //   4585: ifeq +14 -> 4599
    //   4588: invokestatic 98	apcy:a	()Lapcy;
    //   4591: lload 30
    //   4593: ldc_w 292
    //   4596: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
    //   4599: iload 4
    //   4601: istore 6
    //   4603: aload 34
    //   4605: ifnull -3577 -> 1028
    //   4608: aload 34
    //   4610: invokevirtual 339	java/io/InputStream:close	()V
    //   4613: iload 4
    //   4615: istore 6
    //   4617: goto -3589 -> 1028
    //   4620: astore_1
    //   4621: aload_1
    //   4622: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   4625: iload 4
    //   4627: istore 6
    //   4629: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4632: ifeq -3604 -> 1028
    //   4635: ldc 43
    //   4637: iconst_2
    //   4638: aload_1
    //   4639: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   4642: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4645: iload 4
    //   4647: istore 6
    //   4649: goto -3621 -> 1028
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
    //   4671: invokestatic 256	zuc:b	()I
    //   4674: pop
    //   4675: iload 6
    //   4677: ifeq +14 -> 4691
    //   4680: invokestatic 98	apcy:a	()Lapcy;
    //   4683: lload 28
    //   4685: ldc_w 292
    //   4688: invokevirtual 259	apcy:a	(JLjava/lang/String;)V
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
    //   4907: aload 37
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
    //   4937: aload 37
    //   4939: astore 34
    //   4941: iload 12
    //   4943: istore 4
    //   4945: lload 28
    //   4947: lstore 30
    //   4949: goto -444 -> 4505
    //   4952: astore_1
    //   4953: iload 9
    //   4955: istore 4
    //   4957: aload 37
    //   4959: astore 34
    //   4961: lload 28
    //   4963: lstore 30
    //   4965: goto -460 -> 4505
    //   4968: astore_1
    //   4969: aload 37
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
    //   4996: iload 11
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
    //   5164: aload 39
    //   5166: astore 34
    //   5168: iconst_0
    //   5169: istore 4
    //   5171: lload 28
    //   5173: lstore 30
    //   5175: goto -836 -> 4339
    //   5178: astore_1
    //   5179: aconst_null
    //   5180: astore 34
    //   5182: iload 14
    //   5184: istore 4
    //   5186: lload 28
    //   5188: lstore 30
    //   5190: goto -851 -> 4339
    //   5193: astore_1
    //   5194: aload 38
    //   5196: astore 34
    //   5198: iload 11
    //   5200: istore 4
    //   5202: lload 28
    //   5204: lstore 30
    //   5206: goto -867 -> 4339
    //   5209: astore_1
    //   5210: iload 12
    //   5212: istore 4
    //   5214: aload 36
    //   5216: astore 34
    //   5218: lload 28
    //   5220: lstore 30
    //   5222: goto -883 -> 4339
    //   5225: astore_1
    //   5226: aload 36
    //   5228: astore 34
    //   5230: lload 28
    //   5232: lstore 30
    //   5234: goto -895 -> 4339
    //   5237: astore_1
    //   5238: aconst_null
    //   5239: astore 34
    //   5241: lload 28
    //   5243: lstore 30
    //   5245: goto -906 -> 4339
    //   5248: astore_1
    //   5249: aload 36
    //   5251: astore 34
    //   5253: iload 9
    //   5255: istore 4
    //   5257: lload 28
    //   5259: lstore 30
    //   5261: goto -922 -> 4339
    //   5264: astore_1
    //   5265: aconst_null
    //   5266: astore 34
    //   5268: lload 28
    //   5270: lstore 30
    //   5272: goto -933 -> 4339
    //   5275: astore_1
    //   5276: aconst_null
    //   5277: astore 34
    //   5279: lload 28
    //   5281: lstore 30
    //   5283: goto -944 -> 4339
    //   5286: astore 5
    //   5288: aload_1
    //   5289: astore 34
    //   5291: aload 5
    //   5293: astore_1
    //   5294: lload 28
    //   5296: lstore 30
    //   5298: goto -959 -> 4339
    //   5301: astore_1
    //   5302: iload 10
    //   5304: istore 6
    //   5306: iconst_0
    //   5307: istore 7
    //   5309: iconst_0
    //   5310: istore 4
    //   5312: lload 28
    //   5314: lstore 30
    //   5316: goto -1143 -> 4173
    //   5319: astore_1
    //   5320: iconst_0
    //   5321: istore 7
    //   5323: iconst_0
    //   5324: istore 4
    //   5326: lload 28
    //   5328: lstore 30
    //   5330: goto -1157 -> 4173
    //   5333: astore_1
    //   5334: iload 15
    //   5336: istore 7
    //   5338: iload 10
    //   5340: istore 4
    //   5342: lload 28
    //   5344: lstore 30
    //   5346: goto -1173 -> 4173
    //   5349: astore_1
    //   5350: iload 4
    //   5352: istore 8
    //   5354: iload 7
    //   5356: istore 4
    //   5358: lload 28
    //   5360: lstore 30
    //   5362: iload 8
    //   5364: istore 7
    //   5366: goto -1193 -> 4173
    //   5369: astore_1
    //   5370: iload 4
    //   5372: istore 8
    //   5374: iload 7
    //   5376: istore 4
    //   5378: lload 28
    //   5380: lstore 30
    //   5382: iload 8
    //   5384: istore 7
    //   5386: goto -1213 -> 4173
    //   5389: astore_1
    //   5390: iconst_0
    //   5391: istore 7
    //   5393: aconst_null
    //   5394: astore 34
    //   5396: iconst_0
    //   5397: istore 4
    //   5399: lload 28
    //   5401: lstore 30
    //   5403: goto -1230 -> 4173
    //   5406: astore_1
    //   5407: aconst_null
    //   5408: astore 34
    //   5410: iconst_0
    //   5411: istore 4
    //   5413: lload 28
    //   5415: lstore 30
    //   5417: goto -1244 -> 4173
    //   5420: astore_1
    //   5421: aload 38
    //   5423: astore 34
    //   5425: iconst_0
    //   5426: istore 4
    //   5428: lload 28
    //   5430: lstore 30
    //   5432: goto -1259 -> 4173
    //   5435: astore_1
    //   5436: aconst_null
    //   5437: astore 34
    //   5439: iload 12
    //   5441: istore 4
    //   5443: lload 28
    //   5445: lstore 30
    //   5447: goto -1274 -> 4173
    //   5450: astore_1
    //   5451: aload 36
    //   5453: astore 34
    //   5455: iload 13
    //   5457: istore 4
    //   5459: lload 28
    //   5461: lstore 30
    //   5463: goto -1290 -> 4173
    //   5466: astore_1
    //   5467: iload 11
    //   5469: istore 4
    //   5471: aload 35
    //   5473: astore 34
    //   5475: lload 28
    //   5477: lstore 30
    //   5479: goto -1306 -> 4173
    //   5482: astore_1
    //   5483: aload 35
    //   5485: astore 34
    //   5487: lload 28
    //   5489: lstore 30
    //   5491: goto -1318 -> 4173
    //   5494: astore_1
    //   5495: aconst_null
    //   5496: astore 34
    //   5498: lload 28
    //   5500: lstore 30
    //   5502: goto -1329 -> 4173
    //   5505: astore_1
    //   5506: aload 39
    //   5508: astore 34
    //   5510: iload 12
    //   5512: istore 4
    //   5514: lload 28
    //   5516: lstore 30
    //   5518: goto -1345 -> 4173
    //   5521: astore_1
    //   5522: aconst_null
    //   5523: astore 34
    //   5525: lload 28
    //   5527: lstore 30
    //   5529: goto -1356 -> 4173
    //   5532: astore_1
    //   5533: aconst_null
    //   5534: astore 34
    //   5536: lload 28
    //   5538: lstore 30
    //   5540: goto -1367 -> 4173
    //   5543: astore 5
    //   5545: aload_1
    //   5546: astore 34
    //   5548: aload 5
    //   5550: astore_1
    //   5551: lload 28
    //   5553: lstore 30
    //   5555: goto -1382 -> 4173
    //   5558: astore_1
    //   5559: iload 11
    //   5561: istore 6
    //   5563: iconst_0
    //   5564: istore 4
    //   5566: iload 12
    //   5568: istore 7
    //   5570: goto -1515 -> 4055
    //   5573: astore_1
    //   5574: iconst_0
    //   5575: istore 4
    //   5577: iload 12
    //   5579: istore 7
    //   5581: goto -1526 -> 4055
    //   5584: astore_1
    //   5585: iload 14
    //   5587: istore 7
    //   5589: iload 11
    //   5591: istore 4
    //   5593: goto -1538 -> 4055
    //   5596: astore_1
    //   5597: iload 4
    //   5599: istore 8
    //   5601: iload 7
    //   5603: istore 4
    //   5605: iload 8
    //   5607: istore 7
    //   5609: goto -1554 -> 4055
    //   5612: astore_1
    //   5613: iload 4
    //   5615: istore 8
    //   5617: iload 7
    //   5619: istore 4
    //   5621: iload 8
    //   5623: istore 7
    //   5625: goto -1570 -> 4055
    //   5628: astore_1
    //   5629: aconst_null
    //   5630: astore 34
    //   5632: iconst_0
    //   5633: istore 4
    //   5635: iload 12
    //   5637: istore 7
    //   5639: goto -1584 -> 4055
    //   5642: astore_1
    //   5643: aconst_null
    //   5644: astore 34
    //   5646: iconst_0
    //   5647: istore 4
    //   5649: goto -1594 -> 4055
    //   5652: astore_1
    //   5653: aload 36
    //   5655: astore 34
    //   5657: iconst_0
    //   5658: istore 4
    //   5660: goto -1605 -> 4055
    //   5663: astore_1
    //   5664: aconst_null
    //   5665: astore 34
    //   5667: iload 11
    //   5669: istore 4
    //   5671: goto -1616 -> 4055
    //   5674: astore_1
    //   5675: aload 39
    //   5677: astore 34
    //   5679: iload 9
    //   5681: istore 4
    //   5683: goto -1628 -> 4055
    //   5686: astore_1
    //   5687: iload 8
    //   5689: istore 4
    //   5691: goto -1636 -> 4055
    //   5694: astore_1
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
    //   5763: iload 13
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
    //   5786: iload 15
    //   5788: istore 8
    //   5790: goto -4553 -> 1237
    //   5793: astore_1
    //   5794: iload 8
    //   5796: istore 7
    //   5798: iload 16
    //   5800: istore 8
    //   5802: goto -4565 -> 1237
    //   5805: astore_1
    //   5806: iload 7
    //   5808: istore 9
    //   5810: iload 8
    //   5812: istore 7
    //   5814: iload 9
    //   5816: istore 8
    //   5818: goto -4581 -> 1237
    //   5821: astore_1
    //   5822: iload 7
    //   5824: istore 9
    //   5826: iload 8
    //   5828: istore 7
    //   5830: iload 9
    //   5832: istore 8
    //   5834: goto -4597 -> 1237
    //   5837: astore_1
    //   5838: iconst_0
    //   5839: istore 4
    //   5841: iload 8
    //   5843: istore 7
    //   5845: iload 13
    //   5847: istore 8
    //   5849: goto -4744 -> 1105
    //   5852: astore_1
    //   5853: iload 8
    //   5855: istore 7
    //   5857: iload 17
    //   5859: istore 8
    //   5861: goto -4756 -> 1105
    //   5864: astore_1
    //   5865: iload 7
    //   5867: istore 9
    //   5869: iload 8
    //   5871: istore 7
    //   5873: iload 9
    //   5875: istore 8
    //   5877: goto -4772 -> 1105
    //   5880: astore_1
    //   5881: iload 7
    //   5883: istore 9
    //   5885: iload 8
    //   5887: istore 7
    //   5889: iload 9
    //   5891: istore 8
    //   5893: goto -4788 -> 1105
    //   5896: iload 4
    //   5898: istore 8
    //   5900: goto -3025 -> 2875
    //   5903: iload 10
    //   5905: istore 9
    //   5907: aload 36
    //   5909: astore_1
    //   5910: goto -5126 -> 784
    //   5913: goto -3443 -> 2470
    //   5916: goto -3498 -> 2418
    //   5919: goto -3449 -> 2470
    //   5922: iconst_0
    //   5923: istore 7
    //   5925: goto -4352 -> 1573
    //   5928: iload 4
    //   5930: istore 10
    //   5932: goto -4381 -> 1551
    //   5935: goto -5179 -> 756
    //   5938: iconst_0
    //   5939: istore 4
    //   5941: goto -5486 -> 455
    //   5944: iload 4
    //   5946: istore 8
    //   5948: goto -5531 -> 417
    //   5951: iconst_0
    //   5952: istore 9
    //   5954: iconst_0
    //   5955: istore 7
    //   5957: iload 4
    //   5959: istore 8
    //   5961: iload 9
    //   5963: istore 4
    //   5965: goto -5200 -> 765
    //   5968: ldc2_w 298
    //   5971: lstore 28
    //   5973: iconst_0
    //   5974: istore 6
    //   5976: iconst_0
    //   5977: istore 4
    //   5979: aload 34
    //   5981: astore_1
    //   5982: goto -4995 -> 987
    //   5985: iload 4
    //   5987: iconst_2
    //   5988: iand
    //   5989: iconst_2
    //   5990: if_icmpne -1991 -> 3999
    //   5993: iconst_1
    //   5994: istore_2
    //   5995: goto -5109 -> 886
    //   5998: aload 34
    //   6000: astore_1
    //   6001: iload 7
    //   6003: istore 9
    //   6005: iload 4
    //   6007: istore 7
    //   6009: iload 8
    //   6011: istore 4
    //   6013: goto -5229 -> 784
    //   6016: astore_1
    //   6017: iconst_0
    //   6018: istore 8
    //   6020: iload 4
    //   6022: istore 7
    //   6024: iload 8
    //   6026: istore 4
    //   6028: iload 15
    //   6030: istore 8
    //   6032: goto -4795 -> 1237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6035	0	paramUri	Uri
    //   0	6035	1	paramContext	Context
    //   0	6035	2	paramBoolean1	boolean
    //   0	6035	3	paramBoolean2	boolean
    //   0	6035	4	paramInt	int
    //   0	6035	5	paramSparseArray	SparseArray<Object>
    //   113	5862	6	i	int
    //   95	5928	7	j	int
    //   101	5930	8	k	int
    //   104	5900	9	m	int
    //   107	5824	10	n	int
    //   110	5558	11	i1	int
    //   89	5547	12	i2	int
    //   74	5772	13	i3	int
    //   62	5524	14	i4	int
    //   53	5976	15	i5	int
    //   68	5731	16	i6	int
    //   71	5787	17	i7	int
    //   65	415	18	i8	int
    //   59	405	19	i9	int
    //   56	1723	20	i10	int
    //   92	1471	21	i11	int
    //   98	181	22	i12	int
    //   219	48	23	i13	int
    //   234	86	24	i14	int
    //   222	49	25	i15	int
    //   225	50	26	i16	int
    //   231	52	27	i17	int
    //   190	5782	28	l1	long
    //   118	5436	30	l2	long
    //   17	1042	32	l3	long
    //   80	5919	34	localObject1	Object
    //   130	2580	35	localObject2	Object
    //   2888	70	35	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2962	768	35	localObject3	Object
    //   3808	91	35	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3903	1581	35	localContext	Context
    //   5742	1	35	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   5750	1	35	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   5758	1	35	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   5770	1	35	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   134	5774	36	localObject4	Object
    //   126	4867	37	localObject5	Object
    //   122	5585	38	localObject6	Object
    //   77	5599	39	localObject7	Object
    //   86	3700	40	localStringBuilder	StringBuilder
    //   83	2711	41	localObject8	Object
    //   140	2936	42	localContentResolver	android.content.ContentResolver
    //   1647	2041	43	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   336	379	1089	java/lang/OutOfMemoryError
    //   384	406	1089	java/lang/OutOfMemoryError
    //   1492	1500	1500	java/io/IOException
    //   1608	1616	2888	java/lang/OutOfMemoryError
    //   1639	1649	2888	java/lang/OutOfMemoryError
    //   1672	1678	2888	java/lang/OutOfMemoryError
    //   1701	1745	2888	java/lang/OutOfMemoryError
    //   1768	1773	2888	java/lang/OutOfMemoryError
    //   1787	1798	2888	java/lang/OutOfMemoryError
    //   1910	1918	2956	java/lang/OutOfMemoryError
    //   1957	1964	2956	java/lang/OutOfMemoryError
    //   2003	2009	2956	java/lang/OutOfMemoryError
    //   2048	2076	2956	java/lang/OutOfMemoryError
    //   2115	2120	2956	java/lang/OutOfMemoryError
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
    //   1020	1024	4004	java/io/IOException
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
    //   417	440	4757	finally
    //   448	452	4757	finally
    //   1384	1413	4757	finally
    //   483	498	4767	finally
    //   502	508	4767	finally
    //   512	553	4767	finally
    //   557	566	4767	finally
    //   570	581	4767	finally
    //   603	609	4767	finally
    //   613	619	4767	finally
    //   628	644	4767	finally
    //   687	693	4767	finally
    //   729	756	4767	finally
    //   760	765	4767	finally
    //   1141	1145	4767	finally
    //   1181	1187	4767	finally
    //   1223	1234	4767	finally
    //   1273	1277	4767	finally
    //   1313	1319	4767	finally
    //   1355	1366	4767	finally
    //   819	828	4778	finally
    //   835	844	4778	finally
    //   851	859	4778	finally
    //   866	883	4778	finally
    //   902	913	4778	finally
    //   920	926	4778	finally
    //   933	987	4778	finally
    //   1428	1435	4778	finally
    //   1442	1449	4778	finally
    //   1534	1544	4778	finally
    //   1566	1570	4778	finally
    //   1576	1592	4789	finally
    //   1595	1601	4789	finally
    //   1608	1616	4789	finally
    //   1639	1649	4789	finally
    //   1672	1678	4789	finally
    //   1701	1745	4789	finally
    //   1768	1773	4789	finally
    //   1787	1798	4789	finally
    //   1832	1841	4789	finally
    //   1910	1918	4789	finally
    //   1957	1964	4789	finally
    //   2003	2009	4789	finally
    //   2048	2076	4789	finally
    //   2115	2120	4789	finally
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
    //   2157	2165	4793	finally
    //   2185	2200	4793	finally
    //   2220	2229	4793	finally
    //   2249	2260	4793	finally
    //   2280	2299	4793	finally
    //   2325	2344	4793	finally
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
    //   1384	1413	4845	java/lang/Throwable
    //   1141	1145	4859	java/lang/Throwable
    //   1181	1187	4859	java/lang/Throwable
    //   1223	1234	4859	java/lang/Throwable
    //   1273	1277	4859	java/lang/Throwable
    //   1313	1319	4859	java/lang/Throwable
    //   1355	1366	4859	java/lang/Throwable
    //   1428	1435	4875	java/lang/Throwable
    //   1442	1449	4875	java/lang/Throwable
    //   1534	1544	4875	java/lang/Throwable
    //   1566	1570	4875	java/lang/Throwable
    //   1576	1592	4892	java/lang/Throwable
    //   1595	1601	4892	java/lang/Throwable
    //   1608	1616	4892	java/lang/Throwable
    //   1787	1798	4892	java/lang/Throwable
    //   1639	1649	4906	java/lang/Throwable
    //   1672	1678	4906	java/lang/Throwable
    //   1701	1745	4906	java/lang/Throwable
    //   1768	1773	4906	java/lang/Throwable
    //   2909	2914	4906	java/lang/Throwable
    //   2933	2938	4906	java/lang/Throwable
    //   1832	1841	4921	java/lang/Throwable
    //   1910	1918	4921	java/lang/Throwable
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
    //   1957	1964	4936	java/lang/Throwable
    //   2003	2009	4936	java/lang/Throwable
    //   2048	2076	4936	java/lang/Throwable
    //   2115	2120	4936	java/lang/Throwable
    //   2999	3004	4936	java/lang/Throwable
    //   3039	3044	4936	java/lang/Throwable
    //   3126	3133	4936	java/lang/Throwable
    //   3176	3182	4936	java/lang/Throwable
    //   3225	3253	4936	java/lang/Throwable
    //   3296	3301	4936	java/lang/Throwable
    //   3845	3850	4936	java/lang/Throwable
    //   3885	3890	4936	java/lang/Throwable
    //   2157	2165	4952	java/lang/Throwable
    //   2185	2200	4952	java/lang/Throwable
    //   2220	2229	4952	java/lang/Throwable
    //   2249	2260	4952	java/lang/Throwable
    //   2280	2299	4952	java/lang/Throwable
    //   2325	2344	4952	java/lang/Throwable
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
    //   819	828	5029	java/lang/Throwable
    //   835	844	5029	java/lang/Throwable
    //   851	859	5029	java/lang/Throwable
    //   866	883	5029	java/lang/Throwable
    //   902	913	5029	java/lang/Throwable
    //   920	926	5029	java/lang/Throwable
    //   933	987	5029	java/lang/Throwable
    //   204	218	5044	java/lang/UnsatisfiedLinkError
    //   260	266	5044	java/lang/UnsatisfiedLinkError
    //   286	319	5044	java/lang/UnsatisfiedLinkError
    //   323	332	5062	java/lang/UnsatisfiedLinkError
    //   336	379	5062	java/lang/UnsatisfiedLinkError
    //   384	406	5062	java/lang/UnsatisfiedLinkError
    //   417	440	5062	java/lang/UnsatisfiedLinkError
    //   448	452	5062	java/lang/UnsatisfiedLinkError
    //   1384	1413	5062	java/lang/UnsatisfiedLinkError
    //   483	498	5076	java/lang/UnsatisfiedLinkError
    //   687	693	5076	java/lang/UnsatisfiedLinkError
    //   729	756	5076	java/lang/UnsatisfiedLinkError
    //   1141	1145	5076	java/lang/UnsatisfiedLinkError
    //   1181	1187	5076	java/lang/UnsatisfiedLinkError
    //   1223	1234	5076	java/lang/UnsatisfiedLinkError
    //   1273	1277	5076	java/lang/UnsatisfiedLinkError
    //   1313	1319	5076	java/lang/UnsatisfiedLinkError
    //   1355	1366	5076	java/lang/UnsatisfiedLinkError
    //   502	508	5092	java/lang/UnsatisfiedLinkError
    //   512	553	5092	java/lang/UnsatisfiedLinkError
    //   557	566	5092	java/lang/UnsatisfiedLinkError
    //   570	581	5092	java/lang/UnsatisfiedLinkError
    //   603	609	5092	java/lang/UnsatisfiedLinkError
    //   613	619	5092	java/lang/UnsatisfiedLinkError
    //   628	644	5092	java/lang/UnsatisfiedLinkError
    //   760	765	5112	java/lang/UnsatisfiedLinkError
    //   1428	1435	5132	java/lang/UnsatisfiedLinkError
    //   1442	1449	5132	java/lang/UnsatisfiedLinkError
    //   1534	1544	5132	java/lang/UnsatisfiedLinkError
    //   1566	1570	5132	java/lang/UnsatisfiedLinkError
    //   1576	1592	5149	java/lang/UnsatisfiedLinkError
    //   1595	1601	5149	java/lang/UnsatisfiedLinkError
    //   1608	1616	5149	java/lang/UnsatisfiedLinkError
    //   1787	1798	5149	java/lang/UnsatisfiedLinkError
    //   1639	1649	5163	java/lang/UnsatisfiedLinkError
    //   1672	1678	5163	java/lang/UnsatisfiedLinkError
    //   1701	1745	5163	java/lang/UnsatisfiedLinkError
    //   1768	1773	5163	java/lang/UnsatisfiedLinkError
    //   2909	2914	5163	java/lang/UnsatisfiedLinkError
    //   2933	2938	5163	java/lang/UnsatisfiedLinkError
    //   1832	1841	5178	java/lang/UnsatisfiedLinkError
    //   1910	1918	5178	java/lang/UnsatisfiedLinkError
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
    //   1957	1964	5193	java/lang/UnsatisfiedLinkError
    //   2003	2009	5193	java/lang/UnsatisfiedLinkError
    //   2048	2076	5193	java/lang/UnsatisfiedLinkError
    //   2115	2120	5193	java/lang/UnsatisfiedLinkError
    //   2999	3004	5193	java/lang/UnsatisfiedLinkError
    //   3039	3044	5193	java/lang/UnsatisfiedLinkError
    //   3126	3133	5193	java/lang/UnsatisfiedLinkError
    //   3176	3182	5193	java/lang/UnsatisfiedLinkError
    //   3225	3253	5193	java/lang/UnsatisfiedLinkError
    //   3296	3301	5193	java/lang/UnsatisfiedLinkError
    //   3845	3850	5193	java/lang/UnsatisfiedLinkError
    //   3885	3890	5193	java/lang/UnsatisfiedLinkError
    //   2157	2165	5209	java/lang/UnsatisfiedLinkError
    //   2185	2200	5209	java/lang/UnsatisfiedLinkError
    //   2220	2229	5209	java/lang/UnsatisfiedLinkError
    //   2249	2260	5209	java/lang/UnsatisfiedLinkError
    //   2280	2299	5209	java/lang/UnsatisfiedLinkError
    //   2325	2344	5209	java/lang/UnsatisfiedLinkError
    //   2364	2375	5209	java/lang/UnsatisfiedLinkError
    //   2395	2411	5209	java/lang/UnsatisfiedLinkError
    //   2418	2470	5225	java/lang/UnsatisfiedLinkError
    //   2482	2491	5237	java/lang/UnsatisfiedLinkError
    //   2499	2508	5237	java/lang/UnsatisfiedLinkError
    //   2519	2535	5237	java/lang/UnsatisfiedLinkError
    //   2538	2546	5237	java/lang/UnsatisfiedLinkError
    //   2585	2595	5248	java/lang/UnsatisfiedLinkError
    //   2634	2640	5248	java/lang/UnsatisfiedLinkError
    //   2679	2707	5248	java/lang/UnsatisfiedLinkError
    //   2746	2751	5248	java/lang/UnsatisfiedLinkError
    //   3940	3945	5248	java/lang/UnsatisfiedLinkError
    //   3980	3985	5248	java/lang/UnsatisfiedLinkError
    //   2756	2813	5264	java/lang/UnsatisfiedLinkError
    //   2824	2871	5275	java/lang/UnsatisfiedLinkError
    //   819	828	5286	java/lang/UnsatisfiedLinkError
    //   835	844	5286	java/lang/UnsatisfiedLinkError
    //   851	859	5286	java/lang/UnsatisfiedLinkError
    //   866	883	5286	java/lang/UnsatisfiedLinkError
    //   902	913	5286	java/lang/UnsatisfiedLinkError
    //   920	926	5286	java/lang/UnsatisfiedLinkError
    //   933	987	5286	java/lang/UnsatisfiedLinkError
    //   204	218	5301	java/lang/RuntimeException
    //   260	266	5301	java/lang/RuntimeException
    //   286	319	5301	java/lang/RuntimeException
    //   323	332	5319	java/lang/RuntimeException
    //   336	379	5319	java/lang/RuntimeException
    //   384	406	5319	java/lang/RuntimeException
    //   417	440	5319	java/lang/RuntimeException
    //   448	452	5319	java/lang/RuntimeException
    //   1384	1413	5319	java/lang/RuntimeException
    //   483	498	5333	java/lang/RuntimeException
    //   687	693	5333	java/lang/RuntimeException
    //   729	756	5333	java/lang/RuntimeException
    //   1141	1145	5333	java/lang/RuntimeException
    //   1181	1187	5333	java/lang/RuntimeException
    //   1223	1234	5333	java/lang/RuntimeException
    //   1273	1277	5333	java/lang/RuntimeException
    //   1313	1319	5333	java/lang/RuntimeException
    //   1355	1366	5333	java/lang/RuntimeException
    //   502	508	5349	java/lang/RuntimeException
    //   512	553	5349	java/lang/RuntimeException
    //   557	566	5349	java/lang/RuntimeException
    //   570	581	5349	java/lang/RuntimeException
    //   603	609	5349	java/lang/RuntimeException
    //   613	619	5349	java/lang/RuntimeException
    //   628	644	5349	java/lang/RuntimeException
    //   760	765	5369	java/lang/RuntimeException
    //   1428	1435	5389	java/lang/RuntimeException
    //   1442	1449	5389	java/lang/RuntimeException
    //   1534	1544	5389	java/lang/RuntimeException
    //   1566	1570	5389	java/lang/RuntimeException
    //   1576	1592	5406	java/lang/RuntimeException
    //   1595	1601	5406	java/lang/RuntimeException
    //   1608	1616	5406	java/lang/RuntimeException
    //   1787	1798	5406	java/lang/RuntimeException
    //   1639	1649	5420	java/lang/RuntimeException
    //   1672	1678	5420	java/lang/RuntimeException
    //   1701	1745	5420	java/lang/RuntimeException
    //   1768	1773	5420	java/lang/RuntimeException
    //   2909	2914	5420	java/lang/RuntimeException
    //   2933	2938	5420	java/lang/RuntimeException
    //   1832	1841	5435	java/lang/RuntimeException
    //   1910	1918	5435	java/lang/RuntimeException
    //   3075	3083	5435	java/lang/RuntimeException
    //   3343	3352	5435	java/lang/RuntimeException
    //   3379	3395	5435	java/lang/RuntimeException
    //   3422	3431	5435	java/lang/RuntimeException
    //   3458	3470	5435	java/lang/RuntimeException
    //   3497	3517	5435	java/lang/RuntimeException
    //   3554	3574	5435	java/lang/RuntimeException
    //   3601	3613	5435	java/lang/RuntimeException
    //   3640	3660	5435	java/lang/RuntimeException
    //   3687	3692	5435	java/lang/RuntimeException
    //   3723	3729	5435	java/lang/RuntimeException
    //   3756	3797	5435	java/lang/RuntimeException
    //   1957	1964	5450	java/lang/RuntimeException
    //   2003	2009	5450	java/lang/RuntimeException
    //   2048	2076	5450	java/lang/RuntimeException
    //   2115	2120	5450	java/lang/RuntimeException
    //   2999	3004	5450	java/lang/RuntimeException
    //   3039	3044	5450	java/lang/RuntimeException
    //   3126	3133	5450	java/lang/RuntimeException
    //   3176	3182	5450	java/lang/RuntimeException
    //   3225	3253	5450	java/lang/RuntimeException
    //   3296	3301	5450	java/lang/RuntimeException
    //   3845	3850	5450	java/lang/RuntimeException
    //   3885	3890	5450	java/lang/RuntimeException
    //   2157	2165	5466	java/lang/RuntimeException
    //   2185	2200	5466	java/lang/RuntimeException
    //   2220	2229	5466	java/lang/RuntimeException
    //   2249	2260	5466	java/lang/RuntimeException
    //   2280	2299	5466	java/lang/RuntimeException
    //   2325	2344	5466	java/lang/RuntimeException
    //   2364	2375	5466	java/lang/RuntimeException
    //   2395	2411	5466	java/lang/RuntimeException
    //   2418	2470	5482	java/lang/RuntimeException
    //   2482	2491	5494	java/lang/RuntimeException
    //   2499	2508	5494	java/lang/RuntimeException
    //   2519	2535	5494	java/lang/RuntimeException
    //   2538	2546	5494	java/lang/RuntimeException
    //   2585	2595	5505	java/lang/RuntimeException
    //   2634	2640	5505	java/lang/RuntimeException
    //   2679	2707	5505	java/lang/RuntimeException
    //   2746	2751	5505	java/lang/RuntimeException
    //   3940	3945	5505	java/lang/RuntimeException
    //   3980	3985	5505	java/lang/RuntimeException
    //   2756	2813	5521	java/lang/RuntimeException
    //   2824	2871	5532	java/lang/RuntimeException
    //   819	828	5543	java/lang/RuntimeException
    //   835	844	5543	java/lang/RuntimeException
    //   851	859	5543	java/lang/RuntimeException
    //   866	883	5543	java/lang/RuntimeException
    //   902	913	5543	java/lang/RuntimeException
    //   920	926	5543	java/lang/RuntimeException
    //   933	987	5543	java/lang/RuntimeException
    //   204	218	5558	java/io/IOException
    //   260	266	5558	java/io/IOException
    //   286	319	5558	java/io/IOException
    //   323	332	5573	java/io/IOException
    //   336	379	5573	java/io/IOException
    //   384	406	5573	java/io/IOException
    //   417	440	5573	java/io/IOException
    //   448	452	5573	java/io/IOException
    //   1384	1413	5573	java/io/IOException
    //   483	498	5584	java/io/IOException
    //   687	693	5584	java/io/IOException
    //   729	756	5584	java/io/IOException
    //   1141	1145	5584	java/io/IOException
    //   1181	1187	5584	java/io/IOException
    //   1223	1234	5584	java/io/IOException
    //   1273	1277	5584	java/io/IOException
    //   1313	1319	5584	java/io/IOException
    //   1355	1366	5584	java/io/IOException
    //   502	508	5596	java/io/IOException
    //   512	553	5596	java/io/IOException
    //   557	566	5596	java/io/IOException
    //   570	581	5596	java/io/IOException
    //   603	609	5596	java/io/IOException
    //   613	619	5596	java/io/IOException
    //   628	644	5596	java/io/IOException
    //   760	765	5612	java/io/IOException
    //   1428	1435	5628	java/io/IOException
    //   1442	1449	5628	java/io/IOException
    //   1534	1544	5628	java/io/IOException
    //   1566	1570	5628	java/io/IOException
    //   1576	1592	5642	java/io/IOException
    //   1595	1601	5642	java/io/IOException
    //   1608	1616	5642	java/io/IOException
    //   1787	1798	5642	java/io/IOException
    //   1639	1649	5652	java/io/IOException
    //   1672	1678	5652	java/io/IOException
    //   1701	1745	5652	java/io/IOException
    //   1768	1773	5652	java/io/IOException
    //   2909	2914	5652	java/io/IOException
    //   2933	2938	5652	java/io/IOException
    //   1832	1841	5663	java/io/IOException
    //   1910	1918	5663	java/io/IOException
    //   3075	3083	5663	java/io/IOException
    //   3343	3352	5663	java/io/IOException
    //   3379	3395	5663	java/io/IOException
    //   3422	3431	5663	java/io/IOException
    //   3458	3470	5663	java/io/IOException
    //   3497	3517	5663	java/io/IOException
    //   3554	3574	5663	java/io/IOException
    //   3601	3613	5663	java/io/IOException
    //   3640	3660	5663	java/io/IOException
    //   3687	3692	5663	java/io/IOException
    //   3723	3729	5663	java/io/IOException
    //   3756	3797	5663	java/io/IOException
    //   1957	1964	5674	java/io/IOException
    //   2003	2009	5674	java/io/IOException
    //   2048	2076	5674	java/io/IOException
    //   2115	2120	5674	java/io/IOException
    //   2999	3004	5674	java/io/IOException
    //   3039	3044	5674	java/io/IOException
    //   3126	3133	5674	java/io/IOException
    //   3176	3182	5674	java/io/IOException
    //   3225	3253	5674	java/io/IOException
    //   3296	3301	5674	java/io/IOException
    //   3845	3850	5674	java/io/IOException
    //   3885	3890	5674	java/io/IOException
    //   2157	2165	5686	java/io/IOException
    //   2185	2200	5686	java/io/IOException
    //   2220	2229	5686	java/io/IOException
    //   2249	2260	5686	java/io/IOException
    //   2280	2299	5686	java/io/IOException
    //   2325	2344	5686	java/io/IOException
    //   2364	2375	5686	java/io/IOException
    //   2395	2411	5686	java/io/IOException
    //   2418	2470	5694	java/io/IOException
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
    //   819	828	5731	java/io/IOException
    //   835	844	5731	java/io/IOException
    //   851	859	5731	java/io/IOException
    //   866	883	5731	java/io/IOException
    //   902	913	5731	java/io/IOException
    //   920	926	5731	java/io/IOException
    //   933	987	5731	java/io/IOException
    //   2756	2813	5742	java/lang/OutOfMemoryError
    //   2824	2871	5750	java/lang/OutOfMemoryError
    //   2157	2165	5758	java/lang/OutOfMemoryError
    //   2185	2200	5758	java/lang/OutOfMemoryError
    //   2220	2229	5758	java/lang/OutOfMemoryError
    //   2249	2260	5758	java/lang/OutOfMemoryError
    //   2280	2299	5758	java/lang/OutOfMemoryError
    //   2325	2344	5758	java/lang/OutOfMemoryError
    //   2364	2375	5758	java/lang/OutOfMemoryError
    //   2395	2411	5758	java/lang/OutOfMemoryError
    //   2418	2470	5770	java/lang/OutOfMemoryError
    //   417	440	5778	java/lang/Throwable
    //   448	452	5778	java/lang/Throwable
    //   483	498	5793	java/lang/Throwable
    //   687	693	5793	java/lang/Throwable
    //   729	756	5793	java/lang/Throwable
    //   502	508	5805	java/lang/Throwable
    //   512	553	5805	java/lang/Throwable
    //   557	566	5805	java/lang/Throwable
    //   570	581	5805	java/lang/Throwable
    //   603	609	5805	java/lang/Throwable
    //   613	619	5805	java/lang/Throwable
    //   628	644	5805	java/lang/Throwable
    //   760	765	5821	java/lang/Throwable
    //   417	440	5837	java/lang/OutOfMemoryError
    //   448	452	5837	java/lang/OutOfMemoryError
    //   483	498	5852	java/lang/OutOfMemoryError
    //   687	693	5852	java/lang/OutOfMemoryError
    //   729	756	5852	java/lang/OutOfMemoryError
    //   502	508	5864	java/lang/OutOfMemoryError
    //   512	553	5864	java/lang/OutOfMemoryError
    //   557	566	5864	java/lang/OutOfMemoryError
    //   570	581	5864	java/lang/OutOfMemoryError
    //   603	609	5864	java/lang/OutOfMemoryError
    //   613	619	5864	java/lang/OutOfMemoryError
    //   628	644	5864	java/lang/OutOfMemoryError
    //   760	765	5880	java/lang/OutOfMemoryError
    //   336	379	6016	java/lang/Throwable
    //   384	406	6016	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bjde.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bjde.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = apcy.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (apcy.a(paramArrayOfInt))
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
    //   55: astore 33
    //   57: aconst_null
    //   58: astore 35
    //   60: aconst_null
    //   61: astore 32
    //   63: aconst_null
    //   64: astore 34
    //   66: aconst_null
    //   67: astore 36
    //   69: iconst_0
    //   70: istore 13
    //   72: iconst_0
    //   73: istore 22
    //   75: iconst_0
    //   76: istore 15
    //   78: iconst_0
    //   79: istore 19
    //   81: iconst_0
    //   82: istore 17
    //   84: iconst_0
    //   85: istore 14
    //   87: iconst_0
    //   88: istore 20
    //   90: iconst_0
    //   91: istore 18
    //   93: iconst_0
    //   94: istore 23
    //   96: iconst_0
    //   97: istore 16
    //   99: iconst_0
    //   100: istore 6
    //   102: iconst_0
    //   103: istore 21
    //   105: iconst_0
    //   106: istore 24
    //   108: aload 36
    //   110: astore 27
    //   112: iload 15
    //   114: istore 9
    //   116: aload 33
    //   118: astore 31
    //   120: iload 19
    //   122: istore 10
    //   124: aload 35
    //   126: astore 30
    //   128: iload 17
    //   130: istore 11
    //   132: aload 32
    //   134: astore 29
    //   136: iload 14
    //   138: istore 12
    //   140: aload 34
    //   142: astore 28
    //   144: iload 20
    //   146: istore 8
    //   148: aload_1
    //   149: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   152: astore 42
    //   154: aload 36
    //   156: astore 27
    //   158: iload 15
    //   160: istore 9
    //   162: aload 33
    //   164: astore 31
    //   166: iload 19
    //   168: istore 10
    //   170: aload 35
    //   172: astore 30
    //   174: iload 17
    //   176: istore 11
    //   178: aload 32
    //   180: astore 29
    //   182: iload 14
    //   184: istore 12
    //   186: aload 34
    //   188: astore 28
    //   190: iload 20
    //   192: istore 8
    //   194: aload 42
    //   196: aload_0
    //   197: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +4033 -> 4235
    //   205: iload_3
    //   206: ifeq +802 -> 1008
    //   209: iload 18
    //   211: istore 9
    //   213: iload 16
    //   215: istore 11
    //   217: iload 6
    //   219: istore 10
    //   221: iload 21
    //   223: istore 8
    //   225: aload_0
    //   226: invokevirtual 316	android/net/Uri:getPath	()Ljava/lang/String;
    //   229: invokestatic 322	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore_0
    //   233: iload 18
    //   235: istore 9
    //   237: iload 16
    //   239: istore 11
    //   241: iload 6
    //   243: istore 10
    //   245: iload 21
    //   247: istore 8
    //   249: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   252: ifeq +45 -> 297
    //   255: iload 18
    //   257: istore 9
    //   259: iload 16
    //   261: istore 11
    //   263: iload 6
    //   265: istore 10
    //   267: iload 21
    //   269: istore 8
    //   271: ldc 43
    //   273: iconst_4
    //   274: new 45	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 324
    //   284: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: ifnull +3928 -> 4226
    //   301: iload 18
    //   303: istore 9
    //   305: iload 16
    //   307: istore 11
    //   309: iload 6
    //   311: istore 10
    //   313: iload 21
    //   315: istore 8
    //   317: aload_0
    //   318: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   321: istore 14
    //   323: iload 18
    //   325: istore 9
    //   327: iload 16
    //   329: istore 11
    //   331: iload 6
    //   333: istore 10
    //   335: iload 21
    //   337: istore 8
    //   339: aload_0
    //   340: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   343: istore 12
    //   345: iload 18
    //   347: istore 9
    //   349: iload 16
    //   351: istore 11
    //   353: iload 6
    //   355: istore 10
    //   357: iload 21
    //   359: istore 8
    //   361: iload 14
    //   363: iload 12
    //   365: invokestatic 201	bjde:a	(II)Z
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
    //   383: invokevirtual 339	java/io/InputStream:close	()V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   393: aload_0
    //   394: astore 27
    //   396: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -388 -> 11
    //   402: ldc 43
    //   404: iconst_2
    //   405: aload_1
    //   406: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   409: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aconst_null
    //   413: areturn
    //   414: iload 18
    //   416: istore 9
    //   418: iload 16
    //   420: istore 11
    //   422: iload 6
    //   424: istore 10
    //   426: iload 21
    //   428: istore 8
    //   430: iload 14
    //   432: iload 12
    //   434: imul
    //   435: newarray int
    //   437: astore 27
    //   439: iload 18
    //   441: istore 9
    //   443: iload 16
    //   445: istore 11
    //   447: iload 6
    //   449: istore 10
    //   451: iload 21
    //   453: istore 8
    //   455: aload_0
    //   456: aload 27
    //   458: iconst_0
    //   459: iload 14
    //   461: iconst_0
    //   462: iconst_0
    //   463: iload 14
    //   465: iload 12
    //   467: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   470: iload 18
    //   472: istore 9
    //   474: iload 16
    //   476: istore 11
    //   478: iload 6
    //   480: istore 10
    //   482: iload 21
    //   484: istore 8
    //   486: aload_0
    //   487: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   490: iload 18
    //   492: istore 9
    //   494: iload 16
    //   496: istore 11
    //   498: iload 6
    //   500: istore 10
    //   502: iload 21
    //   504: istore 8
    //   506: invokestatic 203	zuc:a	()I
    //   509: pop
    //   510: iconst_1
    //   511: istore 9
    //   513: aload 27
    //   515: aconst_null
    //   516: iload 14
    //   518: iload 12
    //   520: invokestatic 419	zuc:a	([I[BII)I
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
    //   549: ldc_w 421
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
    //   587: if_icmpne +3609 -> 4196
    //   590: iload_2
    //   591: ifeq +2816 -> 3407
    //   594: aload_0
    //   595: astore 27
    //   597: iload 6
    //   599: istore 9
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
    //   620: istore 12
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
    //   642: istore 9
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
    //   663: istore 12
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
    //   686: istore 9
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
    //   707: istore 12
    //   709: aload_0
    //   710: astore 28
    //   712: iload 6
    //   714: istore 8
    //   716: aload_1
    //   717: aload 32
    //   719: invokestatic 241	bjde:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   722: pop
    //   723: aload_0
    //   724: astore 27
    //   726: iload 6
    //   728: istore 9
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
    //   749: istore 12
    //   751: aload_0
    //   752: astore 28
    //   754: iload 6
    //   756: istore 8
    //   758: new 243	android/util/Pair
    //   761: dup
    //   762: aload 32
    //   764: aload_1
    //   765: invokespecial 246	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   768: astore_1
    //   769: aload_0
    //   770: astore 27
    //   772: iload 6
    //   774: ifeq +7 -> 781
    //   777: invokestatic 256	zuc:b	()I
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
    //   838: iload 13
    //   840: istore 6
    //   842: iload 6
    //   844: istore 9
    //   846: iload 6
    //   848: istore 12
    //   850: iload 6
    //   852: istore 11
    //   854: iload 6
    //   856: istore 10
    //   858: iload 6
    //   860: istore 8
    //   862: aload_0
    //   863: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: iload 6
    //   868: istore 9
    //   870: iload 6
    //   872: istore 12
    //   874: iload 6
    //   876: istore 11
    //   878: iload 6
    //   880: istore 10
    //   882: iload 6
    //   884: istore 8
    //   886: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +3358 -> 4247
    //   892: iload 6
    //   894: istore 9
    //   896: iload 6
    //   898: istore 12
    //   900: iload 6
    //   902: istore 11
    //   904: iload 6
    //   906: istore 10
    //   908: iload 6
    //   910: istore 8
    //   912: ldc 43
    //   914: iconst_2
    //   915: aload_0
    //   916: invokevirtual 345	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   919: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto +3325 -> 4247
    //   925: iload 6
    //   927: istore 9
    //   929: iload 6
    //   931: istore 12
    //   933: iload 6
    //   935: istore 11
    //   937: iload 6
    //   939: istore 10
    //   941: iload 6
    //   943: istore 8
    //   945: aload_0
    //   946: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   949: iload 6
    //   951: istore 9
    //   953: iload 6
    //   955: istore 12
    //   957: iload 6
    //   959: istore 11
    //   961: iload 6
    //   963: istore 10
    //   965: iload 6
    //   967: istore 8
    //   969: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +3288 -> 4260
    //   975: iload 6
    //   977: istore 9
    //   979: iload 6
    //   981: istore 12
    //   983: iload 6
    //   985: istore 11
    //   987: iload 6
    //   989: istore 10
    //   991: iload 6
    //   993: istore 8
    //   995: ldc 43
    //   997: iconst_2
    //   998: aload_0
    //   999: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1002: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto +3255 -> 4260
    //   1008: iload 18
    //   1010: istore 9
    //   1012: iload 23
    //   1014: istore 12
    //   1016: iload 16
    //   1018: istore 11
    //   1020: iload 6
    //   1022: istore 10
    //   1024: iload 21
    //   1026: istore 8
    //   1028: new 347	android/graphics/BitmapFactory$Options
    //   1031: dup
    //   1032: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   1035: astore 43
    //   1037: iload 18
    //   1039: istore 9
    //   1041: iload 23
    //   1043: istore 12
    //   1045: iload 16
    //   1047: istore 11
    //   1049: iload 6
    //   1051: istore 10
    //   1053: iload 21
    //   1055: istore 8
    //   1057: aload 43
    //   1059: iconst_1
    //   1060: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1063: iload 18
    //   1065: istore 9
    //   1067: iload 23
    //   1069: istore 12
    //   1071: iload 16
    //   1073: istore 11
    //   1075: iload 6
    //   1077: istore 10
    //   1079: iload 21
    //   1081: istore 8
    //   1083: aload_1
    //   1084: aconst_null
    //   1085: aload 43
    //   1087: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1090: pop
    //   1091: iload 18
    //   1093: istore 9
    //   1095: iload 23
    //   1097: istore 12
    //   1099: iload 16
    //   1101: istore 11
    //   1103: iload 6
    //   1105: istore 10
    //   1107: iload 21
    //   1109: istore 8
    //   1111: aload_1
    //   1112: invokevirtual 339	java/io/InputStream:close	()V
    //   1115: aconst_null
    //   1116: astore 32
    //   1118: aconst_null
    //   1119: astore 41
    //   1121: aconst_null
    //   1122: astore 40
    //   1124: aconst_null
    //   1125: astore 39
    //   1127: aconst_null
    //   1128: astore_1
    //   1129: aconst_null
    //   1130: astore 38
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
    //   1147: aload 41
    //   1149: astore 27
    //   1151: iload 15
    //   1153: istore 9
    //   1155: aload 40
    //   1157: astore 31
    //   1159: iload 19
    //   1161: istore 10
    //   1163: aload 39
    //   1165: astore 30
    //   1167: iload 17
    //   1169: istore 11
    //   1171: aload_1
    //   1172: astore 29
    //   1174: iload 14
    //   1176: istore 12
    //   1178: aload 38
    //   1180: astore 28
    //   1182: iload 20
    //   1184: istore 8
    //   1186: aload 43
    //   1188: getfield 360	android/graphics/BitmapFactory$Options:outWidth	I
    //   1191: istore 16
    //   1193: aload 41
    //   1195: astore 27
    //   1197: iload 15
    //   1199: istore 9
    //   1201: aload 40
    //   1203: astore 31
    //   1205: iload 19
    //   1207: istore 10
    //   1209: aload 39
    //   1211: astore 30
    //   1213: iload 17
    //   1215: istore 11
    //   1217: aload_1
    //   1218: astore 29
    //   1220: iload 14
    //   1222: istore 12
    //   1224: aload 38
    //   1226: astore 28
    //   1228: iload 20
    //   1230: istore 8
    //   1232: aload 43
    //   1234: getfield 363	android/graphics/BitmapFactory$Options:outHeight	I
    //   1237: istore 18
    //   1239: aload 41
    //   1241: astore 27
    //   1243: iload 15
    //   1245: istore 9
    //   1247: aload 40
    //   1249: astore 31
    //   1251: iload 19
    //   1253: istore 10
    //   1255: aload 39
    //   1257: astore 30
    //   1259: iload 17
    //   1261: istore 11
    //   1263: aload_1
    //   1264: astore 29
    //   1266: iload 14
    //   1268: istore 12
    //   1270: aload 38
    //   1272: astore 28
    //   1274: iload 20
    //   1276: istore 8
    //   1278: aload 43
    //   1280: iconst_0
    //   1281: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1284: iload 16
    //   1286: sipush 12800
    //   1289: if_icmpgt +11 -> 1300
    //   1292: iload 18
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
    //   1343: aload 41
    //   1345: astore 27
    //   1347: iload 15
    //   1349: istore 9
    //   1351: aload 40
    //   1353: astore 31
    //   1355: iload 19
    //   1357: istore 10
    //   1359: aload 39
    //   1361: astore 30
    //   1363: iload 17
    //   1365: istore 11
    //   1367: aload_1
    //   1368: astore 29
    //   1370: iload 14
    //   1372: istore 12
    //   1374: aload 38
    //   1376: astore 28
    //   1378: iload 20
    //   1380: istore 8
    //   1382: iload 16
    //   1384: iload 18
    //   1386: invokestatic 201	bjde:a	(II)Z
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
    //   1437: aload 41
    //   1439: astore 27
    //   1441: iload 15
    //   1443: istore 9
    //   1445: aload 40
    //   1447: astore 31
    //   1449: iload 19
    //   1451: istore 10
    //   1453: aload 39
    //   1455: astore 30
    //   1457: iload 17
    //   1459: istore 11
    //   1461: aload_1
    //   1462: astore 29
    //   1464: iload 14
    //   1466: istore 12
    //   1468: aload 38
    //   1470: astore 28
    //   1472: iload 20
    //   1474: istore 8
    //   1476: invokestatic 203	zuc:a	()I
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
    //   1495: iload 16
    //   1497: iload 18
    //   1499: imul
    //   1500: ldc_w 424
    //   1503: if_icmple +1167 -> 2670
    //   1506: iload 16
    //   1508: iload 18
    //   1510: imul
    //   1511: i2d
    //   1512: dstore 4
    //   1514: aload 37
    //   1516: astore 27
    //   1518: aload 34
    //   1520: astore_1
    //   1521: iload 12
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
    //   1562: iload 12
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
    //   1618: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
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
    //   1721: iload 18
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
    //   1757: iload 12
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
    //   1859: invokestatic 419	zuc:a	([I[BII)I
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
    //   1944: if_icmpeq +337 -> 2281
    //   1947: iload 16
    //   1949: iconst_2
    //   1950: imul
    //   1951: iload 18
    //   1953: if_icmpgt +955 -> 2908
    //   1956: iload 16
    //   1958: sipush 1280
    //   1961: if_icmpge +947 -> 2908
    //   1964: iload 12
    //   1966: istore 8
    //   1968: aload 42
    //   1970: aload_0
    //   1971: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
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
    //   2001: astore 33
    //   2003: aload 31
    //   2005: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2008: astore 32
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
    //   2035: astore 33
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
    //   2104: iload 12
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
    //   2131: ifnull +2092 -> 4223
    //   2134: iload 6
    //   2136: istore 7
    //   2138: iload 16
    //   2140: iload 16
    //   2142: imul
    //   2143: newarray int
    //   2145: astore_1
    //   2146: iload 6
    //   2148: istore 7
    //   2150: aload 32
    //   2152: aload_1
    //   2153: iconst_0
    //   2154: iload 16
    //   2156: iconst_0
    //   2157: iconst_0
    //   2158: iload 16
    //   2160: iload 16
    //   2162: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2165: iload 6
    //   2167: istore 7
    //   2169: iload 16
    //   2171: iload 16
    //   2173: imul
    //   2174: newarray byte
    //   2176: astore 27
    //   2178: iload 6
    //   2180: istore 7
    //   2182: aload_1
    //   2183: aload 27
    //   2185: iload 16
    //   2187: iload 16
    //   2189: invokestatic 419	zuc:a	([I[BII)I
    //   2192: istore 6
    //   2194: iload 6
    //   2196: iconst_1
    //   2197: if_icmpeq +2023 -> 4220
    //   2200: iload 6
    //   2202: istore 7
    //   2204: aload 32
    //   2206: aload_1
    //   2207: iconst_0
    //   2208: iload 16
    //   2210: iconst_0
    //   2211: iload 18
    //   2213: iload 16
    //   2215: isub
    //   2216: iload 16
    //   2218: iload 16
    //   2220: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2223: iload 6
    //   2225: istore 7
    //   2227: aload_1
    //   2228: aload 27
    //   2230: iload 16
    //   2232: iload 16
    //   2234: invokestatic 419	zuc:a	([I[BII)I
    //   2237: istore 6
    //   2239: aload 32
    //   2241: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2244: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2247: ifeq +30 -> 2277
    //   2250: ldc 43
    //   2252: iconst_4
    //   2253: new 45	java/lang/StringBuilder
    //   2256: dup
    //   2257: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2260: ldc_w 443
    //   2263: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: iload 6
    //   2268: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2271: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2274: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2277: iload 6
    //   2279: istore 7
    //   2281: aconst_null
    //   2282: astore 32
    //   2284: aconst_null
    //   2285: astore 33
    //   2287: aconst_null
    //   2288: astore 36
    //   2290: aconst_null
    //   2291: astore 37
    //   2293: aconst_null
    //   2294: astore 31
    //   2296: aconst_null
    //   2297: astore 35
    //   2299: aconst_null
    //   2300: astore 34
    //   2302: iload 7
    //   2304: iconst_1
    //   2305: if_icmpeq +1906 -> 4211
    //   2308: aload 32
    //   2310: astore 27
    //   2312: aload 33
    //   2314: astore_1
    //   2315: iload 12
    //   2317: istore 8
    //   2319: aload 36
    //   2321: astore 28
    //   2323: aload 37
    //   2325: astore 29
    //   2327: aload 31
    //   2329: astore 30
    //   2331: iload 16
    //   2333: iload 18
    //   2335: invokestatic 232	java/lang/Math:min	(II)I
    //   2338: istore 6
    //   2340: iload 6
    //   2342: sipush 250
    //   2345: if_icmple +1866 -> 4211
    //   2348: aload 32
    //   2350: astore 27
    //   2352: aload 33
    //   2354: astore_1
    //   2355: iload 12
    //   2357: istore 8
    //   2359: aload 36
    //   2361: astore 28
    //   2363: aload 37
    //   2365: astore 29
    //   2367: aload 31
    //   2369: astore 30
    //   2371: aload 43
    //   2373: iload 6
    //   2375: i2d
    //   2376: ldc2_w 233
    //   2379: ddiv
    //   2380: invokestatic 238	java/lang/Math:ceil	(D)D
    //   2383: d2i
    //   2384: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2387: aload 32
    //   2389: astore 27
    //   2391: aload 33
    //   2393: astore_1
    //   2394: iload 12
    //   2396: istore 8
    //   2398: aload 36
    //   2400: astore 28
    //   2402: aload 37
    //   2404: astore 29
    //   2406: aload 31
    //   2408: astore 30
    //   2410: aload 35
    //   2412: astore 31
    //   2414: aload 42
    //   2416: aload_0
    //   2417: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2420: astore_0
    //   2421: aload_0
    //   2422: astore 27
    //   2424: aload_0
    //   2425: astore_1
    //   2426: iload 12
    //   2428: istore 8
    //   2430: aload_0
    //   2431: astore 28
    //   2433: aload_0
    //   2434: astore 29
    //   2436: aload_0
    //   2437: astore 30
    //   2439: aload_0
    //   2440: astore 31
    //   2442: aload_0
    //   2443: aconst_null
    //   2444: aload 43
    //   2446: invokestatic 357	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2449: astore 32
    //   2451: aload_0
    //   2452: astore 27
    //   2454: aload_0
    //   2455: astore_1
    //   2456: iload 12
    //   2458: istore 8
    //   2460: aload_0
    //   2461: astore 28
    //   2463: aload_0
    //   2464: astore 29
    //   2466: aload_0
    //   2467: astore 30
    //   2469: aload_0
    //   2470: astore 31
    //   2472: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2475: ifeq +51 -> 2526
    //   2478: aload_0
    //   2479: astore 27
    //   2481: aload_0
    //   2482: astore_1
    //   2483: iload 12
    //   2485: istore 8
    //   2487: aload_0
    //   2488: astore 28
    //   2490: aload_0
    //   2491: astore 29
    //   2493: aload_0
    //   2494: astore 30
    //   2496: aload_0
    //   2497: astore 31
    //   2499: ldc 43
    //   2501: iconst_4
    //   2502: new 45	java/lang/StringBuilder
    //   2505: dup
    //   2506: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2509: ldc_w 445
    //   2512: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: aload 32
    //   2517: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2520: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2523: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2526: aload_0
    //   2527: astore 27
    //   2529: aload_0
    //   2530: astore_1
    //   2531: iload 12
    //   2533: istore 8
    //   2535: aload_0
    //   2536: astore 28
    //   2538: aload_0
    //   2539: astore 29
    //   2541: aload_0
    //   2542: astore 30
    //   2544: aload_0
    //   2545: astore 31
    //   2547: aload_0
    //   2548: invokevirtual 339	java/io/InputStream:close	()V
    //   2551: aload 32
    //   2553: ifnull +1651 -> 4204
    //   2556: aload 32
    //   2558: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   2561: istore 8
    //   2563: aload 32
    //   2565: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   2568: istore 6
    //   2570: iload 8
    //   2572: iload 6
    //   2574: imul
    //   2575: newarray int
    //   2577: astore_0
    //   2578: aload 32
    //   2580: aload_0
    //   2581: iconst_0
    //   2582: iload 8
    //   2584: iconst_0
    //   2585: iconst_0
    //   2586: iload 8
    //   2588: iload 6
    //   2590: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2593: aload 32
    //   2595: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   2598: aload_0
    //   2599: aconst_null
    //   2600: iload 8
    //   2602: iload 6
    //   2604: invokestatic 419	zuc:a	([I[BII)I
    //   2607: istore 6
    //   2609: iload 6
    //   2611: istore 7
    //   2613: iload 7
    //   2615: istore 6
    //   2617: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2620: ifeq +34 -> 2654
    //   2623: ldc 43
    //   2625: iconst_4
    //   2626: new 45	java/lang/StringBuilder
    //   2629: dup
    //   2630: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2633: ldc_w 447
    //   2636: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2639: iload 7
    //   2641: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2644: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2647: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2650: iload 7
    //   2652: istore 6
    //   2654: iconst_1
    //   2655: istore 8
    //   2657: aconst_null
    //   2658: astore_0
    //   2659: iload 6
    //   2661: istore 7
    //   2663: iload 8
    //   2665: istore 6
    //   2667: goto -2083 -> 584
    //   2670: aload 37
    //   2672: astore 27
    //   2674: aload 34
    //   2676: astore_1
    //   2677: iload 12
    //   2679: istore 8
    //   2681: aload 36
    //   2683: astore 28
    //   2685: aload 35
    //   2687: astore 29
    //   2689: aload 33
    //   2691: astore 30
    //   2693: aload 43
    //   2695: iconst_1
    //   2696: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2699: goto -1144 -> 1555
    //   2702: astore_0
    //   2703: iconst_1
    //   2704: istore 6
    //   2706: aload 27
    //   2708: astore 28
    //   2710: iload 6
    //   2712: istore 8
    //   2714: aload_0
    //   2715: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   2718: aload 27
    //   2720: astore 28
    //   2722: iload 6
    //   2724: istore 8
    //   2726: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2729: ifeq +21 -> 2750
    //   2732: aload 27
    //   2734: astore 28
    //   2736: iload 6
    //   2738: istore 8
    //   2740: ldc 43
    //   2742: iconst_2
    //   2743: aload_0
    //   2744: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   2747: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2750: iload 6
    //   2752: ifeq +7 -> 2759
    //   2755: invokestatic 256	zuc:b	()I
    //   2758: pop
    //   2759: aload 27
    //   2761: ifnull +1430 -> 4191
    //   2764: aload 27
    //   2766: invokevirtual 339	java/io/InputStream:close	()V
    //   2769: aconst_null
    //   2770: astore_0
    //   2771: goto -1976 -> 795
    //   2774: astore_1
    //   2775: iload 7
    //   2777: istore 6
    //   2779: aload 32
    //   2781: astore 31
    //   2783: aload_1
    //   2784: astore 32
    //   2786: aload 31
    //   2788: astore 27
    //   2790: aload 31
    //   2792: astore_1
    //   2793: iload 12
    //   2795: istore 8
    //   2797: aload 31
    //   2799: astore 28
    //   2801: aload 31
    //   2803: astore 29
    //   2805: aload 31
    //   2807: astore 30
    //   2809: aload 32
    //   2811: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2814: aload 31
    //   2816: astore 27
    //   2818: aload 31
    //   2820: astore_1
    //   2821: iload 12
    //   2823: istore 8
    //   2825: aload 31
    //   2827: astore 28
    //   2829: aload 31
    //   2831: astore 29
    //   2833: aload 31
    //   2835: astore 30
    //   2837: aload 31
    //   2839: invokevirtual 339	java/io/InputStream:close	()V
    //   2842: goto -925 -> 1917
    //   2845: aload 31
    //   2847: astore 27
    //   2849: aload 31
    //   2851: astore_1
    //   2852: iload 12
    //   2854: istore 8
    //   2856: aload 31
    //   2858: astore 28
    //   2860: aload 31
    //   2862: astore 29
    //   2864: aload 31
    //   2866: astore 30
    //   2868: aload 32
    //   2870: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2873: aload 31
    //   2875: astore 27
    //   2877: aload 31
    //   2879: astore_1
    //   2880: iload 12
    //   2882: istore 8
    //   2884: aload 31
    //   2886: astore 28
    //   2888: aload 31
    //   2890: astore 29
    //   2892: aload 31
    //   2894: astore 30
    //   2896: aload 31
    //   2898: invokevirtual 339	java/io/InputStream:close	()V
    //   2901: iload 6
    //   2903: istore 7
    //   2905: goto -624 -> 2281
    //   2908: iload 6
    //   2910: istore 7
    //   2912: iload 16
    //   2914: iload 18
    //   2916: iconst_2
    //   2917: imul
    //   2918: if_icmplt -637 -> 2281
    //   2921: iload 6
    //   2923: istore 7
    //   2925: iload 18
    //   2927: sipush 1280
    //   2930: if_icmpge -649 -> 2281
    //   2933: iload 12
    //   2935: istore 8
    //   2937: aload 42
    //   2939: aload_0
    //   2940: invokevirtual 311	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2943: astore 31
    //   2945: aload 31
    //   2947: astore 27
    //   2949: aload 31
    //   2951: astore 32
    //   2953: aload 31
    //   2955: astore_1
    //   2956: iload 12
    //   2958: istore 8
    //   2960: aload 31
    //   2962: astore 28
    //   2964: aload 31
    //   2966: astore 29
    //   2968: aload 31
    //   2970: astore 30
    //   2972: aload 31
    //   2974: invokestatic 381	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2977: astore 33
    //   2979: aload 31
    //   2981: astore 27
    //   2983: aload 31
    //   2985: astore 32
    //   2987: aload 31
    //   2989: astore_1
    //   2990: iload 12
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
    //   3023: iload 12
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
    //   3049: ldc_w 449
    //   3052: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3055: aload 33
    //   3057: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3060: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3063: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3066: aload 31
    //   3068: astore 27
    //   3070: aload 31
    //   3072: astore 32
    //   3074: aload 31
    //   3076: astore_1
    //   3077: iload 12
    //   3079: istore 8
    //   3081: aload 31
    //   3083: astore 28
    //   3085: aload 31
    //   3087: astore 29
    //   3089: aload 31
    //   3091: astore 30
    //   3093: aload 31
    //   3095: invokevirtual 339	java/io/InputStream:close	()V
    //   3098: iload 6
    //   3100: istore 8
    //   3102: aload 33
    //   3104: ifnull +172 -> 3276
    //   3107: iload 6
    //   3109: istore 7
    //   3111: iload 18
    //   3113: iload 18
    //   3115: imul
    //   3116: newarray int
    //   3118: astore 27
    //   3120: iload 6
    //   3122: istore 7
    //   3124: aload 33
    //   3126: aload 27
    //   3128: iconst_0
    //   3129: iload 18
    //   3131: iconst_0
    //   3132: iconst_0
    //   3133: iload 18
    //   3135: iload 18
    //   3137: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3140: iload 6
    //   3142: istore 7
    //   3144: iload 18
    //   3146: iload 18
    //   3148: imul
    //   3149: newarray byte
    //   3151: astore_1
    //   3152: iload 6
    //   3154: istore 7
    //   3156: aload 27
    //   3158: aload_1
    //   3159: iload 18
    //   3161: iload 18
    //   3163: invokestatic 419	zuc:a	([I[BII)I
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
    //   3187: iload 18
    //   3189: iload 16
    //   3191: iload 18
    //   3193: isub
    //   3194: iconst_0
    //   3195: iload 18
    //   3197: iload 18
    //   3199: invokevirtual 167	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3202: iload 8
    //   3204: istore 7
    //   3206: aload 27
    //   3208: aload_1
    //   3209: iload 18
    //   3211: iload 18
    //   3213: invokestatic 419	zuc:a	([I[BII)I
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
    //   3280: goto -999 -> 2281
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
    //   3316: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   3344: invokevirtual 339	java/io/InputStream:close	()V
    //   3347: iload 6
    //   3349: istore 7
    //   3351: goto -1070 -> 2281
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
    //   3374: invokevirtual 344	java/lang/OutOfMemoryError:printStackTrace	()V
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
    //   3396: invokevirtual 339	java/io/InputStream:close	()V
    //   3399: aconst_null
    //   3400: astore_0
    //   3401: iconst_1
    //   3402: istore 6
    //   3404: goto -2820 -> 584
    //   3407: aload_0
    //   3408: astore 27
    //   3410: iload 6
    //   3412: istore 9
    //   3414: aload_0
    //   3415: astore 31
    //   3417: iload 6
    //   3419: istore 10
    //   3421: aload_0
    //   3422: astore 30
    //   3424: iload 6
    //   3426: istore 11
    //   3428: aload_0
    //   3429: astore 29
    //   3431: iload 6
    //   3433: istore 12
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
    //   3459: iload 9
    //   3461: istore 6
    //   3463: goto -757 -> 2706
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
    //   3524: iload 10
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
    //   3578: invokestatic 256	zuc:b	()I
    //   3581: pop
    //   3582: aload 30
    //   3584: ifnull +607 -> 4191
    //   3587: aload 30
    //   3589: invokevirtual 339	java/io/InputStream:close	()V
    //   3592: aconst_null
    //   3593: astore_0
    //   3594: goto -2799 -> 795
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
    //   3620: goto -2825 -> 795
    //   3623: astore_0
    //   3624: iload 11
    //   3626: istore 6
    //   3628: aload 30
    //   3630: astore 29
    //   3632: aload 29
    //   3634: astore_1
    //   3635: iload 6
    //   3637: istore 8
    //   3639: aload_0
    //   3640: invokevirtual 272	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3643: aload 29
    //   3645: astore_1
    //   3646: iload 6
    //   3648: istore 8
    //   3650: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3653: ifeq +20 -> 3673
    //   3656: aload 29
    //   3658: astore_1
    //   3659: iload 6
    //   3661: istore 8
    //   3663: ldc 43
    //   3665: iconst_2
    //   3666: aload_0
    //   3667: invokevirtual 273	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3670: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3673: iload 6
    //   3675: ifeq +7 -> 3682
    //   3678: invokestatic 256	zuc:b	()I
    //   3681: pop
    //   3682: aload 29
    //   3684: ifnull +507 -> 4191
    //   3687: aload 29
    //   3689: invokevirtual 339	java/io/InputStream:close	()V
    //   3692: aconst_null
    //   3693: astore_0
    //   3694: goto -2899 -> 795
    //   3697: astore_0
    //   3698: aload_0
    //   3699: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3702: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3705: ifeq +13 -> 3718
    //   3708: ldc 43
    //   3710: iconst_2
    //   3711: aload_0
    //   3712: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3715: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3718: aconst_null
    //   3719: astore_0
    //   3720: goto -2925 -> 795
    //   3723: astore_0
    //   3724: iload 12
    //   3726: istore 6
    //   3728: aload 29
    //   3730: astore 28
    //   3732: aload 28
    //   3734: astore_1
    //   3735: iload 6
    //   3737: istore 8
    //   3739: aload_0
    //   3740: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   3743: aload 28
    //   3745: astore_1
    //   3746: iload 6
    //   3748: istore 8
    //   3750: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3753: ifeq +20 -> 3773
    //   3756: aload 28
    //   3758: astore_1
    //   3759: iload 6
    //   3761: istore 8
    //   3763: ldc 43
    //   3765: iconst_2
    //   3766: aload_0
    //   3767: invokevirtual 275	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3770: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3773: iload 6
    //   3775: ifeq +7 -> 3782
    //   3778: invokestatic 256	zuc:b	()I
    //   3781: pop
    //   3782: aload 28
    //   3784: ifnull +407 -> 4191
    //   3787: aload 28
    //   3789: invokevirtual 339	java/io/InputStream:close	()V
    //   3792: aconst_null
    //   3793: astore_0
    //   3794: goto -2999 -> 795
    //   3797: astore_0
    //   3798: aload_0
    //   3799: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3802: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3805: ifeq +13 -> 3818
    //   3808: ldc 43
    //   3810: iconst_2
    //   3811: aload_0
    //   3812: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3815: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3818: aconst_null
    //   3819: astore_0
    //   3820: goto -3025 -> 795
    //   3823: astore_0
    //   3824: aload 28
    //   3826: astore_1
    //   3827: iload 8
    //   3829: ifeq +7 -> 3836
    //   3832: invokestatic 256	zuc:b	()I
    //   3835: pop
    //   3836: aload_1
    //   3837: ifnull +7 -> 3844
    //   3840: aload_1
    //   3841: invokevirtual 339	java/io/InputStream:close	()V
    //   3844: aload_0
    //   3845: athrow
    //   3846: astore_1
    //   3847: aload_1
    //   3848: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   3851: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3854: ifeq -10 -> 3844
    //   3857: ldc 43
    //   3859: iconst_2
    //   3860: aload_1
    //   3861: invokevirtual 368	java/io/IOException:toString	()Ljava/lang/String;
    //   3864: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3867: goto -23 -> 3844
    //   3870: astore_0
    //   3871: iload 9
    //   3873: istore 8
    //   3875: goto -48 -> 3827
    //   3878: astore_0
    //   3879: iconst_1
    //   3880: istore 8
    //   3882: goto -55 -> 3827
    //   3885: astore_0
    //   3886: goto -59 -> 3827
    //   3889: astore_0
    //   3890: aconst_null
    //   3891: astore_1
    //   3892: iload 13
    //   3894: istore 8
    //   3896: goto -69 -> 3827
    //   3899: astore_0
    //   3900: aconst_null
    //   3901: astore_1
    //   3902: iload 13
    //   3904: istore 8
    //   3906: goto -79 -> 3827
    //   3909: astore_0
    //   3910: iload 12
    //   3912: istore 6
    //   3914: aload_1
    //   3915: astore 28
    //   3917: goto -185 -> 3732
    //   3920: astore_0
    //   3921: iload 10
    //   3923: istore 6
    //   3925: goto -193 -> 3732
    //   3928: astore_0
    //   3929: aconst_null
    //   3930: astore 28
    //   3932: iload 10
    //   3934: istore 6
    //   3936: goto -204 -> 3732
    //   3939: astore_0
    //   3940: aconst_null
    //   3941: astore 28
    //   3943: iload 10
    //   3945: istore 6
    //   3947: goto -215 -> 3732
    //   3950: astore_0
    //   3951: iload 11
    //   3953: istore 6
    //   3955: aload_1
    //   3956: astore 29
    //   3958: goto -326 -> 3632
    //   3961: astore_0
    //   3962: iconst_1
    //   3963: istore 6
    //   3965: aload_1
    //   3966: astore 29
    //   3968: goto -336 -> 3632
    //   3971: astore_0
    //   3972: iload 9
    //   3974: istore 6
    //   3976: goto -344 -> 3632
    //   3979: astore_0
    //   3980: aconst_null
    //   3981: astore 29
    //   3983: iload 9
    //   3985: istore 6
    //   3987: goto -355 -> 3632
    //   3990: astore_0
    //   3991: aconst_null
    //   3992: astore 29
    //   3994: iload 9
    //   3996: istore 6
    //   3998: goto -366 -> 3632
    //   4001: astore_0
    //   4002: iload 10
    //   4004: istore 6
    //   4006: aload_1
    //   4007: astore 30
    //   4009: goto -477 -> 3532
    //   4012: astore_0
    //   4013: iconst_1
    //   4014: istore 6
    //   4016: aload_1
    //   4017: astore 30
    //   4019: goto -487 -> 3532
    //   4022: astore_0
    //   4023: iload 11
    //   4025: istore 6
    //   4027: goto -495 -> 3532
    //   4030: astore_0
    //   4031: aconst_null
    //   4032: astore 30
    //   4034: iload 11
    //   4036: istore 6
    //   4038: goto -506 -> 3532
    //   4041: astore_0
    //   4042: aconst_null
    //   4043: astore 30
    //   4045: iload 11
    //   4047: istore 6
    //   4049: goto -517 -> 3532
    //   4052: astore_0
    //   4053: aload_1
    //   4054: astore 27
    //   4056: iload 8
    //   4058: istore 6
    //   4060: goto -1354 -> 2706
    //   4063: astore_0
    //   4064: iconst_1
    //   4065: istore 6
    //   4067: aload_1
    //   4068: astore 27
    //   4070: goto -1364 -> 2706
    //   4073: astore_0
    //   4074: aconst_null
    //   4075: astore 27
    //   4077: iconst_1
    //   4078: istore 6
    //   4080: goto -1374 -> 2706
    //   4083: astore_0
    //   4084: iconst_1
    //   4085: istore 6
    //   4087: aconst_null
    //   4088: astore 27
    //   4090: goto -1384 -> 2706
    //   4093: astore 32
    //   4095: aconst_null
    //   4096: astore_0
    //   4097: goto -743 -> 3354
    //   4100: astore 32
    //   4102: aconst_null
    //   4103: astore_0
    //   4104: goto -750 -> 3354
    //   4107: astore 32
    //   4109: aconst_null
    //   4110: astore 31
    //   4112: iload 7
    //   4114: istore 6
    //   4116: goto -825 -> 3291
    //   4119: astore 32
    //   4121: aconst_null
    //   4122: astore 31
    //   4124: iload 7
    //   4126: istore 6
    //   4128: goto -1283 -> 2845
    //   4131: astore 32
    //   4133: aconst_null
    //   4134: astore 31
    //   4136: goto -1291 -> 2845
    //   4139: astore 32
    //   4141: aconst_null
    //   4142: astore 31
    //   4144: goto -1358 -> 2786
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
    //   4208: goto -1554 -> 2654
    //   4211: iconst_1
    //   4212: istore 6
    //   4214: aload 34
    //   4216: astore_0
    //   4217: goto -3633 -> 584
    //   4220: goto -1981 -> 2239
    //   4223: goto -1946 -> 2277
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
    //   4265: astore 32
    //   4267: aload 33
    //   4269: astore 31
    //   4271: goto -1426 -> 2845
    //   4274: astore 32
    //   4276: aload 31
    //   4278: astore_0
    //   4279: goto -925 -> 3354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4282	0	paramUri	Uri
    //   0	4282	1	paramContext	Context
    //   0	4282	2	paramBoolean1	boolean
    //   0	4282	3	paramBoolean2	boolean
    //   1512	28	4	d	double
    //   100	4156	6	i	int
    //   20	4208	7	j	int
    //   146	4085	8	k	int
    //   114	3881	9	m	int
    //   122	3881	10	n	int
    //   130	3916	11	i1	int
    //   138	3773	12	i2	int
    //   70	3833	13	i3	int
    //   85	1773	14	i4	int
    //   76	1366	15	i5	int
    //   97	3097	16	i6	int
    //   82	1376	17	i7	int
    //   91	3121	18	i8	int
    //   79	1371	19	i9	int
    //   88	1385	20	i10	int
    //   103	1005	21	i11	int
    //   73	4181	22	i12	int
    //   94	1002	23	i13	int
    //   106	4135	24	i14	int
    //   17	807	25	l	long
    //   9	3445	27	localObject1	Object
    //   3466	19	27	localIOException	java.io.IOException
    //   4054	183	27	localObject2	Object
    //   142	3800	28	localObject3	Object
    //   134	3859	29	localObject4	Object
    //   126	3918	30	localObject5	Object
    //   118	4159	31	localObject6	Object
    //   61	3312	32	localObject7	Object
    //   4093	1	32	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   4100	1	32	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4107	1	32	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4119	1	32	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4131	1	32	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   4139	1	32	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   4265	1	32	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   4274	1	32	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   55	4213	33	localObject8	Object
    //   64	4151	34	localObject9	Object
    //   58	2628	35	localObject10	Object
    //   67	2615	36	localObject11	Object
    //   1145	1526	37	localObject12	Object
    //   1130	339	38	localObject13	Object
    //   1125	329	39	localObject14	Object
    //   1122	324	40	localObject15	Object
    //   1119	319	41	localObject16	Object
    //   152	2786	42	localContentResolver	android.content.ContentResolver
    //   1035	1659	43	localOptions	android.graphics.BitmapFactory.Options
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
    //   1537	1555	2702	java/io/IOException
    //   1578	1586	2702	java/io/IOException
    //   1613	1623	2702	java/io/IOException
    //   1650	1656	2702	java/io/IOException
    //   1683	1746	2702	java/io/IOException
    //   1773	1778	2702	java/io/IOException
    //   1968	1976	2702	java/io/IOException
    //   2003	2010	2702	java/io/IOException
    //   2037	2043	2702	java/io/IOException
    //   2070	2097	2702	java/io/IOException
    //   2124	2129	2702	java/io/IOException
    //   2331	2340	2702	java/io/IOException
    //   2371	2387	2702	java/io/IOException
    //   2414	2421	2702	java/io/IOException
    //   2442	2451	2702	java/io/IOException
    //   2472	2478	2702	java/io/IOException
    //   2499	2526	2702	java/io/IOException
    //   2547	2551	2702	java/io/IOException
    //   2693	2699	2702	java/io/IOException
    //   2809	2814	2702	java/io/IOException
    //   2837	2842	2702	java/io/IOException
    //   2868	2873	2702	java/io/IOException
    //   2896	2901	2702	java/io/IOException
    //   2937	2945	2702	java/io/IOException
    //   2972	2979	2702	java/io/IOException
    //   3006	3012	2702	java/io/IOException
    //   3039	3066	2702	java/io/IOException
    //   3093	3098	2702	java/io/IOException
    //   3314	3319	2702	java/io/IOException
    //   3342	3347	2702	java/io/IOException
    //   3372	3377	2702	java/io/IOException
    //   3395	3399	2702	java/io/IOException
    //   1578	1586	2774	java/lang/OutOfMemoryError
    //   1613	1623	2774	java/lang/OutOfMemoryError
    //   1650	1656	2774	java/lang/OutOfMemoryError
    //   1683	1746	2774	java/lang/OutOfMemoryError
    //   1773	1778	2774	java/lang/OutOfMemoryError
    //   2937	2945	3283	java/lang/OutOfMemoryError
    //   2972	2979	3283	java/lang/OutOfMemoryError
    //   3006	3012	3283	java/lang/OutOfMemoryError
    //   3039	3066	3283	java/lang/OutOfMemoryError
    //   3093	3098	3283	java/lang/OutOfMemoryError
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
    //   2764	2769	3497	java/io/IOException
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
    //   3587	3592	3597	java/io/IOException
    //   148	154	3623	java/lang/UnsatisfiedLinkError
    //   194	201	3623	java/lang/UnsatisfiedLinkError
    //   629	637	3623	java/lang/UnsatisfiedLinkError
    //   672	681	3623	java/lang/UnsatisfiedLinkError
    //   716	723	3623	java/lang/UnsatisfiedLinkError
    //   758	769	3623	java/lang/UnsatisfiedLinkError
    //   1186	1193	3623	java/lang/UnsatisfiedLinkError
    //   1232	1239	3623	java/lang/UnsatisfiedLinkError
    //   1278	1284	3623	java/lang/UnsatisfiedLinkError
    //   1382	1390	3623	java/lang/UnsatisfiedLinkError
    //   1476	1480	3623	java/lang/UnsatisfiedLinkError
    //   3442	3452	3623	java/lang/UnsatisfiedLinkError
    //   3687	3692	3697	java/io/IOException
    //   148	154	3723	java/lang/Throwable
    //   194	201	3723	java/lang/Throwable
    //   629	637	3723	java/lang/Throwable
    //   672	681	3723	java/lang/Throwable
    //   716	723	3723	java/lang/Throwable
    //   758	769	3723	java/lang/Throwable
    //   1186	1193	3723	java/lang/Throwable
    //   1232	1239	3723	java/lang/Throwable
    //   1278	1284	3723	java/lang/Throwable
    //   1382	1390	3723	java/lang/Throwable
    //   1476	1480	3723	java/lang/Throwable
    //   3442	3452	3723	java/lang/Throwable
    //   3787	3792	3797	java/io/IOException
    //   148	154	3823	finally
    //   194	201	3823	finally
    //   629	637	3823	finally
    //   672	681	3823	finally
    //   716	723	3823	finally
    //   758	769	3823	finally
    //   1186	1193	3823	finally
    //   1232	1239	3823	finally
    //   1278	1284	3823	finally
    //   1382	1390	3823	finally
    //   1476	1480	3823	finally
    //   2714	2718	3823	finally
    //   2726	2732	3823	finally
    //   2740	2750	3823	finally
    //   3442	3452	3823	finally
    //   3840	3844	3846	java/io/IOException
    //   225	233	3870	finally
    //   249	255	3870	finally
    //   271	297	3870	finally
    //   317	323	3870	finally
    //   339	345	3870	finally
    //   361	369	3870	finally
    //   430	439	3870	finally
    //   455	470	3870	finally
    //   486	490	3870	finally
    //   506	510	3870	finally
    //   862	866	3870	finally
    //   886	892	3870	finally
    //   912	922	3870	finally
    //   945	949	3870	finally
    //   969	975	3870	finally
    //   995	1005	3870	finally
    //   1028	1037	3870	finally
    //   1057	1063	3870	finally
    //   1083	1091	3870	finally
    //   1111	1115	3870	finally
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
    //   2331	2340	3885	finally
    //   2371	2387	3885	finally
    //   2414	2421	3885	finally
    //   2442	2451	3885	finally
    //   2472	2478	3885	finally
    //   2499	2526	3885	finally
    //   2547	2551	3885	finally
    //   2693	2699	3885	finally
    //   2809	2814	3885	finally
    //   2837	2842	3885	finally
    //   2868	2873	3885	finally
    //   2896	2901	3885	finally
    //   2937	2945	3885	finally
    //   2972	2979	3885	finally
    //   3006	3012	3885	finally
    //   3039	3066	3885	finally
    //   3093	3098	3885	finally
    //   3314	3319	3885	finally
    //   3342	3347	3885	finally
    //   3372	3377	3885	finally
    //   3395	3399	3885	finally
    //   3539	3543	3885	finally
    //   3550	3556	3885	finally
    //   3563	3573	3885	finally
    //   3639	3643	3885	finally
    //   3650	3656	3885	finally
    //   3663	3673	3885	finally
    //   3739	3743	3885	finally
    //   3750	3756	3885	finally
    //   3763	3773	3885	finally
    //   1791	1798	3889	finally
    //   1802	1809	3889	finally
    //   1813	1821	3889	finally
    //   1825	1840	3889	finally
    //   1844	1849	3889	finally
    //   1853	1864	3889	finally
    //   1872	1878	3889	finally
    //   1882	1909	3889	finally
    //   2138	2146	3899	finally
    //   2150	2165	3899	finally
    //   2169	2178	3899	finally
    //   2182	2194	3899	finally
    //   2204	2223	3899	finally
    //   2227	2239	3899	finally
    //   2239	2277	3899	finally
    //   2556	2609	3899	finally
    //   2617	2650	3899	finally
    //   3111	3120	3899	finally
    //   3124	3140	3899	finally
    //   3144	3152	3899	finally
    //   3156	3168	3899	finally
    //   3182	3202	3899	finally
    //   3206	3218	3899	finally
    //   3222	3227	3899	finally
    //   3235	3241	3899	finally
    //   3245	3272	3899	finally
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
    //   2331	2340	3920	java/lang/Throwable
    //   2371	2387	3920	java/lang/Throwable
    //   2414	2421	3920	java/lang/Throwable
    //   2442	2451	3920	java/lang/Throwable
    //   2472	2478	3920	java/lang/Throwable
    //   2499	2526	3920	java/lang/Throwable
    //   2547	2551	3920	java/lang/Throwable
    //   2693	2699	3920	java/lang/Throwable
    //   2809	2814	3920	java/lang/Throwable
    //   2837	2842	3920	java/lang/Throwable
    //   2868	2873	3920	java/lang/Throwable
    //   2896	2901	3920	java/lang/Throwable
    //   2937	2945	3920	java/lang/Throwable
    //   2972	2979	3920	java/lang/Throwable
    //   3006	3012	3920	java/lang/Throwable
    //   3039	3066	3920	java/lang/Throwable
    //   3093	3098	3920	java/lang/Throwable
    //   3314	3319	3920	java/lang/Throwable
    //   3342	3347	3920	java/lang/Throwable
    //   3372	3377	3920	java/lang/Throwable
    //   3395	3399	3920	java/lang/Throwable
    //   1791	1798	3928	java/lang/Throwable
    //   1802	1809	3928	java/lang/Throwable
    //   1813	1821	3928	java/lang/Throwable
    //   1825	1840	3928	java/lang/Throwable
    //   1844	1849	3928	java/lang/Throwable
    //   1853	1864	3928	java/lang/Throwable
    //   1872	1878	3928	java/lang/Throwable
    //   1882	1909	3928	java/lang/Throwable
    //   2138	2146	3939	java/lang/Throwable
    //   2150	2165	3939	java/lang/Throwable
    //   2169	2178	3939	java/lang/Throwable
    //   2182	2194	3939	java/lang/Throwable
    //   2204	2223	3939	java/lang/Throwable
    //   2227	2239	3939	java/lang/Throwable
    //   2239	2277	3939	java/lang/Throwable
    //   2556	2609	3939	java/lang/Throwable
    //   2617	2650	3939	java/lang/Throwable
    //   3111	3120	3939	java/lang/Throwable
    //   3124	3140	3939	java/lang/Throwable
    //   3144	3152	3939	java/lang/Throwable
    //   3156	3168	3939	java/lang/Throwable
    //   3182	3202	3939	java/lang/Throwable
    //   3206	3218	3939	java/lang/Throwable
    //   3222	3227	3939	java/lang/Throwable
    //   3235	3241	3939	java/lang/Throwable
    //   3245	3272	3939	java/lang/Throwable
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
    //   2331	2340	3971	java/lang/UnsatisfiedLinkError
    //   2371	2387	3971	java/lang/UnsatisfiedLinkError
    //   2414	2421	3971	java/lang/UnsatisfiedLinkError
    //   2442	2451	3971	java/lang/UnsatisfiedLinkError
    //   2472	2478	3971	java/lang/UnsatisfiedLinkError
    //   2499	2526	3971	java/lang/UnsatisfiedLinkError
    //   2547	2551	3971	java/lang/UnsatisfiedLinkError
    //   2693	2699	3971	java/lang/UnsatisfiedLinkError
    //   2809	2814	3971	java/lang/UnsatisfiedLinkError
    //   2837	2842	3971	java/lang/UnsatisfiedLinkError
    //   2868	2873	3971	java/lang/UnsatisfiedLinkError
    //   2896	2901	3971	java/lang/UnsatisfiedLinkError
    //   2937	2945	3971	java/lang/UnsatisfiedLinkError
    //   2972	2979	3971	java/lang/UnsatisfiedLinkError
    //   3006	3012	3971	java/lang/UnsatisfiedLinkError
    //   3039	3066	3971	java/lang/UnsatisfiedLinkError
    //   3093	3098	3971	java/lang/UnsatisfiedLinkError
    //   3314	3319	3971	java/lang/UnsatisfiedLinkError
    //   3342	3347	3971	java/lang/UnsatisfiedLinkError
    //   3372	3377	3971	java/lang/UnsatisfiedLinkError
    //   3395	3399	3971	java/lang/UnsatisfiedLinkError
    //   1791	1798	3979	java/lang/UnsatisfiedLinkError
    //   1802	1809	3979	java/lang/UnsatisfiedLinkError
    //   1813	1821	3979	java/lang/UnsatisfiedLinkError
    //   1825	1840	3979	java/lang/UnsatisfiedLinkError
    //   1844	1849	3979	java/lang/UnsatisfiedLinkError
    //   1853	1864	3979	java/lang/UnsatisfiedLinkError
    //   1872	1878	3979	java/lang/UnsatisfiedLinkError
    //   1882	1909	3979	java/lang/UnsatisfiedLinkError
    //   2138	2146	3990	java/lang/UnsatisfiedLinkError
    //   2150	2165	3990	java/lang/UnsatisfiedLinkError
    //   2169	2178	3990	java/lang/UnsatisfiedLinkError
    //   2182	2194	3990	java/lang/UnsatisfiedLinkError
    //   2204	2223	3990	java/lang/UnsatisfiedLinkError
    //   2227	2239	3990	java/lang/UnsatisfiedLinkError
    //   2239	2277	3990	java/lang/UnsatisfiedLinkError
    //   2556	2609	3990	java/lang/UnsatisfiedLinkError
    //   2617	2650	3990	java/lang/UnsatisfiedLinkError
    //   3111	3120	3990	java/lang/UnsatisfiedLinkError
    //   3124	3140	3990	java/lang/UnsatisfiedLinkError
    //   3144	3152	3990	java/lang/UnsatisfiedLinkError
    //   3156	3168	3990	java/lang/UnsatisfiedLinkError
    //   3182	3202	3990	java/lang/UnsatisfiedLinkError
    //   3206	3218	3990	java/lang/UnsatisfiedLinkError
    //   3222	3227	3990	java/lang/UnsatisfiedLinkError
    //   3235	3241	3990	java/lang/UnsatisfiedLinkError
    //   3245	3272	3990	java/lang/UnsatisfiedLinkError
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
    //   2331	2340	4022	java/lang/RuntimeException
    //   2371	2387	4022	java/lang/RuntimeException
    //   2414	2421	4022	java/lang/RuntimeException
    //   2442	2451	4022	java/lang/RuntimeException
    //   2472	2478	4022	java/lang/RuntimeException
    //   2499	2526	4022	java/lang/RuntimeException
    //   2547	2551	4022	java/lang/RuntimeException
    //   2693	2699	4022	java/lang/RuntimeException
    //   2809	2814	4022	java/lang/RuntimeException
    //   2837	2842	4022	java/lang/RuntimeException
    //   2868	2873	4022	java/lang/RuntimeException
    //   2896	2901	4022	java/lang/RuntimeException
    //   2937	2945	4022	java/lang/RuntimeException
    //   2972	2979	4022	java/lang/RuntimeException
    //   3006	3012	4022	java/lang/RuntimeException
    //   3039	3066	4022	java/lang/RuntimeException
    //   3093	3098	4022	java/lang/RuntimeException
    //   3314	3319	4022	java/lang/RuntimeException
    //   3342	3347	4022	java/lang/RuntimeException
    //   3372	3377	4022	java/lang/RuntimeException
    //   3395	3399	4022	java/lang/RuntimeException
    //   1791	1798	4030	java/lang/RuntimeException
    //   1802	1809	4030	java/lang/RuntimeException
    //   1813	1821	4030	java/lang/RuntimeException
    //   1825	1840	4030	java/lang/RuntimeException
    //   1844	1849	4030	java/lang/RuntimeException
    //   1853	1864	4030	java/lang/RuntimeException
    //   1872	1878	4030	java/lang/RuntimeException
    //   1882	1909	4030	java/lang/RuntimeException
    //   2138	2146	4041	java/lang/RuntimeException
    //   2150	2165	4041	java/lang/RuntimeException
    //   2169	2178	4041	java/lang/RuntimeException
    //   2182	2194	4041	java/lang/RuntimeException
    //   2204	2223	4041	java/lang/RuntimeException
    //   2227	2239	4041	java/lang/RuntimeException
    //   2239	2277	4041	java/lang/RuntimeException
    //   2556	2609	4041	java/lang/RuntimeException
    //   2617	2650	4041	java/lang/RuntimeException
    //   3111	3120	4041	java/lang/RuntimeException
    //   3124	3140	4041	java/lang/RuntimeException
    //   3144	3152	4041	java/lang/RuntimeException
    //   3156	3168	4041	java/lang/RuntimeException
    //   3182	3202	4041	java/lang/RuntimeException
    //   3206	3218	4041	java/lang/RuntimeException
    //   3222	3227	4041	java/lang/RuntimeException
    //   3235	3241	4041	java/lang/RuntimeException
    //   3245	3272	4041	java/lang/RuntimeException
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
    //   2138	2146	4083	java/io/IOException
    //   2150	2165	4083	java/io/IOException
    //   2169	2178	4083	java/io/IOException
    //   2182	2194	4083	java/io/IOException
    //   2204	2223	4083	java/io/IOException
    //   2227	2239	4083	java/io/IOException
    //   2239	2277	4083	java/io/IOException
    //   2556	2609	4083	java/io/IOException
    //   2617	2650	4083	java/io/IOException
    //   3111	3120	4083	java/io/IOException
    //   3124	3140	4083	java/io/IOException
    //   3144	3152	4083	java/io/IOException
    //   3156	3168	4083	java/io/IOException
    //   3182	3202	4083	java/io/IOException
    //   3206	3218	4083	java/io/IOException
    //   3222	3227	4083	java/io/IOException
    //   3235	3241	4083	java/io/IOException
    //   3245	3272	4083	java/io/IOException
    //   2556	2609	4093	java/lang/OutOfMemoryError
    //   2617	2650	4100	java/lang/OutOfMemoryError
    //   3111	3120	4107	java/lang/OutOfMemoryError
    //   3124	3140	4107	java/lang/OutOfMemoryError
    //   3144	3152	4107	java/lang/OutOfMemoryError
    //   3156	3168	4107	java/lang/OutOfMemoryError
    //   3182	3202	4107	java/lang/OutOfMemoryError
    //   3206	3218	4107	java/lang/OutOfMemoryError
    //   3222	3227	4107	java/lang/OutOfMemoryError
    //   3235	3241	4107	java/lang/OutOfMemoryError
    //   3245	3272	4107	java/lang/OutOfMemoryError
    //   2138	2146	4119	java/lang/OutOfMemoryError
    //   2150	2165	4119	java/lang/OutOfMemoryError
    //   2169	2178	4119	java/lang/OutOfMemoryError
    //   2182	2194	4119	java/lang/OutOfMemoryError
    //   2204	2223	4119	java/lang/OutOfMemoryError
    //   2227	2239	4119	java/lang/OutOfMemoryError
    //   2239	2277	4131	java/lang/OutOfMemoryError
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
    //   2414	2421	4274	java/lang/OutOfMemoryError
    //   2442	2451	4274	java/lang/OutOfMemoryError
    //   2472	2478	4274	java/lang/OutOfMemoryError
    //   2499	2526	4274	java/lang/OutOfMemoryError
    //   2547	2551	4274	java/lang/OutOfMemoryError
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
                localObject = bgmj.a((byte[])localObject);
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
        paramString1 = bgln.a();
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
      bctj.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (zvc.g(paramString))
      {
        bctj.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        bctj.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (zvc.i(paramString))
        {
          bctj.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, zuk paramzuk, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new zue(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramzuk);
    paramAppActivity = new NewIntent(paramAppActivity, zrv.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramzuk = paramzuk.a();
    if (paramzuk != null)
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
        if (paramzuk.has(str)) {
          paramAppActivity.putExtra(str, paramzuk.optString(str));
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
    } while (axad.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bjde.a));
    new axad().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bjde.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, zuk paramzuk)
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
          bgkl.b(2131230757, false);
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
          bgkl.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramzuk);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramzuk);
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
          bgkl.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        zrw.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
        if (!nlw.a(paramAppActivity))
        {
          paramString1 = bglp.a(paramAppActivity, 230);
          paramString1.setMessage(2131717447);
          paramString2 = new zud(paramzuk);
          paramString1.setPositiveButton(2131694081, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.q()) && (!paramQQAppInterface.n()) && (!paramQQAppInterface.r())) {
          bgkl.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!zvc.a(str)))
        {
          if (bint.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            bint.a().a(paramQQAppInterface, paramString1, paramView);
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
          accz.a().a(1);
          accz.a().jdField_a_of_type_JavaLangString = "";
          accz.a().jdField_a_of_type_Int = 0;
          accz.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramzuk, paramString1)) {
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
        else if (zvc.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (zvc.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (zvc.f(str))
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
          if (zvc.h(str))
          {
            if (zvc.b(str))
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
            if (bgti.a(paramString1))
            {
              bgti.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramzuk, paramView);
              i = 1;
            }
          }
          else
          {
            zrw.a(paramQQAppInterface, paramAppActivity, paramString1);
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
      int i = bjde.a();
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
 * Qualified Name:     zuc
 * JD-Core Version:    0.7.0.1
 */