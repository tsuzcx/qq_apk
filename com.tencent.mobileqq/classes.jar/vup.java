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

public class vup
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "addDisSource";
    jdField_a_of_type_Int = 1;
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
    if ((arni.a() >= 0) && (akux.a()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = akux.a().a(paramBitmap, l, localRect);
      if ((!bool) || (localRect.width() <= 0) || (localRect.height() <= 0)) {
        break label176;
      }
      paramBitmap = new Rect();
      arni.a(localRect, paramBitmap, paramInt1, paramInt2, 1.2F);
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
    //   1: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
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
    //   30: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   33: ifeq +34 -> 67
    //   36: ldc 71
    //   38: iconst_4
    //   39: ldc 111
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload 4
    //   49: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: iload 7
    //   57: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: aload 10
    //   70: iconst_0
    //   71: iload 4
    //   73: iconst_0
    //   74: iconst_0
    //   75: iload 4
    //   77: iload 7
    //   79: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   82: aload 10
    //   84: aload 11
    //   86: iload 4
    //   88: iload 7
    //   90: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   93: pop
    //   94: aload 10
    //   96: aload 11
    //   98: iload 4
    //   100: iload 7
    //   102: iload_1
    //   103: aload_2
    //   104: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   107: istore_3
    //   108: iconst_0
    //   109: iload_3
    //   110: ior
    //   111: istore_3
    //   112: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +222 -> 337
    //   118: ldc 71
    //   120: iconst_4
    //   121: ldc 134
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_1
    //   130: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_3
    //   137: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: aload_2
    //   144: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto +183 -> 337
    //   157: invokestatic 23	arni:a	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 28	akux:a	()Z
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
    //   187: invokestatic 142	vup:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 147	akvj:a	(ZZ)V
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
    //   274: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -36 -> 241
    //   280: ldc 71
    //   282: iconst_2
    //   283: aload_0
    //   284: invokevirtual 150	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   287: aload_0
    //   288: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: iload_3
    //   292: ireturn
    //   293: astore_0
    //   294: iconst_0
    //   295: istore_3
    //   296: iload_3
    //   297: istore 4
    //   299: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -61 -> 241
    //   305: ldc 71
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 154	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   312: aload_0
    //   313: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      j = 0;
      if ((paramInt & 0x1) == 1)
      {
        k = i1;
        m = i2;
        n = i3;
      }
      for (;;)
      {
        try
        {
          i = bcof.a(2, 0, "ANY", "UTF-8");
          k = i1;
          m = i2;
          n = i3;
          localObject = new int[2];
          localObject[0] = 2;
          localObject[1] = 0;
          k = i1;
          m = i2;
          n = i3;
          int i4 = bcof.a((int[])localObject, localObject.length);
          k = i1;
          m = i2;
          n = i3;
          localObject = bcof.a();
          k = i1;
          m = i2;
          n = i3;
          if (QLog.isDevelopLevel())
          {
            k = i1;
            m = i2;
            n = i3;
            QLog.d("ScannerUtils.detectQQCodeBmp", 4, "init qbar init_result1:" + i + ",init_result2:" + i4 + "version:" + (String)localObject);
          }
          k = i1;
          m = i2;
          n = i3;
          l2 = System.currentTimeMillis();
          if ((paramInt & 0x2) == 2)
          {
            k = i1;
            m = i2;
            n = i3;
            akux.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            k = i1;
            m = i2;
            n = i3;
            if (QLog.isColorLevel())
            {
              k = i1;
              m = i2;
              n = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(akux.a()), Long.valueOf(l2) }));
            }
          }
          k = i1;
          m = i2;
          n = i3;
          localObject = new StringBuilder();
          i = j;
          if (paramBitmap != null)
          {
            k = i1;
            m = i2;
          }
        }
        catch (RuntimeException paramBitmap)
        {
          Object localObject;
          long l2;
          StringBuilder localStringBuilder;
          paramBitmap.printStackTrace();
          j = k;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          j = k;
          continue;
          bool = false;
          continue;
          paramBoolean = false;
          continue;
        }
        catch (UnsatisfiedLinkError paramBitmap)
        {
          paramBitmap.printStackTrace();
          j = m;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          j = m;
          continue;
        }
        catch (Throwable paramBitmap)
        {
          int i;
          paramBitmap.printStackTrace();
          j = n;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("ScannerUtils.detectQQCodeBmp", 2, paramBitmap.toString());
          j = n;
          continue;
          if (i < 0) {
            continue;
          }
          if ((i & 0x1) != 1) {
            continue;
          }
          boolean bool = true;
          continue;
          if ((i & 0x2) != 2) {
            continue;
          }
          paramBoolean = true;
          continue;
        }
        try
        {
          i = a(paramBitmap, paramInt, (StringBuilder)localObject);
          i = 0x0 | i;
        }
        catch (Throwable localThrowable)
        {
          i = j;
          k = i1;
          m = i2;
          n = i3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          k = i1;
          m = i2;
          n = i3;
          QLog.i("ScannerUtils.detectQQCodeBmp", 2, localThrowable.getMessage(), localThrowable);
          i = j;
        }
      }
      k = i;
      m = i;
      n = i;
      if (a(paramInt, i) <= 0) {
        break label964;
      }
      k = i;
      m = i;
      n = i;
      j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (j <= 250) {
        break label964;
      }
      k = i;
      m = i;
      n = i;
      j = (int)Math.ceil(j / 250.0D);
      break label964;
      if ((!bool) || (paramSparseArray == null) || (!paramBoolean)) {
        break label983;
      }
      k = i;
      m = i;
      n = i;
      paramBitmap = new StringBuilder();
      k = i;
      m = i;
      n = i;
      localStringBuilder = new StringBuilder();
      k = i;
      m = i;
      n = i;
      bcof.a(paramBitmap, localStringBuilder);
      k = i;
      m = i;
      n = i;
      paramSparseArray.put(1, new Pair(localStringBuilder, paramBitmap));
      break label983;
      if ((paramBoolean) && (paramSparseArray != null))
      {
        k = i;
        m = i;
        n = i;
        paramSparseArray.put(2, ((StringBuilder)localObject).toString());
      }
      k = i;
      m = i;
      n = i;
      if (QLog.isColorLevel())
      {
        k = i;
        m = i;
        n = i;
        QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("result mode=%d result=%d qr=%b mini=%b miniStr=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), ((StringBuilder)localObject).toString() }));
      }
      if ((paramInt & 0x1) == 1)
      {
        k = i;
        m = i;
        n = i;
        bcof.a();
      }
      j = i;
      if ((paramInt & 0x2) == 2)
      {
        k = i;
        m = i;
        n = i;
        akux.a().a(l2, "ScannerUtils.detectQQCodeBmp");
        j = i;
      }
      paramInt = j;
    } while (!QLog.isDevelopLevel());
    QLog.d("ScannerUtils.detectQQCodeBmp", 4, "cost:" + (System.currentTimeMillis() - l1));
    return j;
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
    //   14: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   17: lstore 19
    //   19: iconst_0
    //   20: istore 6
    //   22: iconst_0
    //   23: istore 16
    //   25: iconst_0
    //   26: istore 12
    //   28: iconst_0
    //   29: istore 13
    //   31: iconst_0
    //   32: istore 14
    //   34: iconst_0
    //   35: istore 11
    //   37: iconst_0
    //   38: istore 15
    //   40: iconst_0
    //   41: istore 17
    //   43: iload 12
    //   45: istore 7
    //   47: iload 13
    //   49: istore 8
    //   51: iload 14
    //   53: istore 9
    //   55: iload 11
    //   57: istore 10
    //   59: aload_1
    //   60: invokevirtual 279	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   63: astore 26
    //   65: iload 12
    //   67: istore 7
    //   69: iload 13
    //   71: istore 8
    //   73: iload 14
    //   75: istore 9
    //   77: iload 11
    //   79: istore 10
    //   81: aload 26
    //   83: aload_0
    //   84: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   87: astore_1
    //   88: iload 17
    //   90: istore 7
    //   92: aload_1
    //   93: ifnull +1211 -> 1304
    //   96: iload 4
    //   98: iconst_1
    //   99: iand
    //   100: iconst_1
    //   101: if_icmpne +203 -> 304
    //   104: iload 12
    //   106: istore 7
    //   108: iload 13
    //   110: istore 8
    //   112: iload 14
    //   114: istore 9
    //   116: iload 11
    //   118: istore 10
    //   120: iconst_2
    //   121: iconst_0
    //   122: ldc 163
    //   124: ldc 165
    //   126: invokestatic 170	bcof:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   129: istore 17
    //   131: iload 12
    //   133: istore 7
    //   135: iload 13
    //   137: istore 8
    //   139: iload 14
    //   141: istore 9
    //   143: iload 11
    //   145: istore 10
    //   147: iconst_2
    //   148: newarray int
    //   150: astore 23
    //   152: aload 23
    //   154: iconst_0
    //   155: iconst_2
    //   156: iastore
    //   157: aload 23
    //   159: iconst_1
    //   160: iconst_0
    //   161: iastore
    //   162: iload 12
    //   164: istore 7
    //   166: iload 13
    //   168: istore 8
    //   170: iload 14
    //   172: istore 9
    //   174: iload 11
    //   176: istore 10
    //   178: aload 23
    //   180: aload 23
    //   182: arraylength
    //   183: invokestatic 173	bcof:a	([II)I
    //   186: istore 18
    //   188: iload 12
    //   190: istore 7
    //   192: iload 13
    //   194: istore 8
    //   196: iload 14
    //   198: istore 9
    //   200: iload 11
    //   202: istore 10
    //   204: invokestatic 175	bcof:a	()Ljava/lang/String;
    //   207: astore 23
    //   209: iload 12
    //   211: istore 7
    //   213: iload 13
    //   215: istore 8
    //   217: iload 14
    //   219: istore 9
    //   221: iload 11
    //   223: istore 10
    //   225: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   228: ifeq +76 -> 304
    //   231: iload 12
    //   233: istore 7
    //   235: iload 13
    //   237: istore 8
    //   239: iload 14
    //   241: istore 9
    //   243: iload 11
    //   245: istore 10
    //   247: ldc_w 287
    //   250: iconst_4
    //   251: new 136	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   258: ldc 180
    //   260: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 17
    //   265: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc 189
    //   270: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 18
    //   275: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: ldc 191
    //   280: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 23
    //   285: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 289
    //   291: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: iload_3
    //   295: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   298: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: iload 12
    //   306: istore 7
    //   308: iload 13
    //   310: istore 8
    //   312: iload 14
    //   314: istore 9
    //   316: iload 11
    //   318: istore 10
    //   320: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   323: lstore 21
    //   325: iload 4
    //   327: iconst_2
    //   328: iand
    //   329: iconst_2
    //   330: if_icmpne +104 -> 434
    //   333: iload 12
    //   335: istore 7
    //   337: iload 13
    //   339: istore 8
    //   341: iload 14
    //   343: istore 9
    //   345: iload 11
    //   347: istore 10
    //   349: invokestatic 42	akux:a	()Lakux;
    //   352: invokestatic 197	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   355: lload 21
    //   357: ldc_w 287
    //   360: invokevirtual 200	akux:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   363: iload 12
    //   365: istore 7
    //   367: iload 13
    //   369: istore 8
    //   371: iload 14
    //   373: istore 9
    //   375: iload 11
    //   377: istore 10
    //   379: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +52 -> 434
    //   385: iload 12
    //   387: istore 7
    //   389: iload 13
    //   391: istore 8
    //   393: iload 14
    //   395: istore 9
    //   397: iload 11
    //   399: istore 10
    //   401: ldc_w 287
    //   404: iconst_2
    //   405: ldc 202
    //   407: iconst_2
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: invokestatic 28	akux:a	()Z
    //   416: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: lload 21
    //   424: invokestatic 207	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   427: aastore
    //   428: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   431: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: iload 12
    //   436: istore 7
    //   438: iload 13
    //   440: istore 8
    //   442: iload 14
    //   444: istore 9
    //   446: iload 11
    //   448: istore 10
    //   450: new 136	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   457: astore 25
    //   459: iload_3
    //   460: ifeq +1059 -> 1519
    //   463: iload 6
    //   465: istore 10
    //   467: iload 12
    //   469: istore 7
    //   471: iload 13
    //   473: istore 8
    //   475: iload 14
    //   477: istore 9
    //   479: iload 15
    //   481: istore 11
    //   483: aload_0
    //   484: invokevirtual 297	android/net/Uri:getPath	()Ljava/lang/String;
    //   487: invokestatic 303	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   490: astore 23
    //   492: iload 6
    //   494: istore 10
    //   496: iload 12
    //   498: istore 7
    //   500: iload 13
    //   502: istore 8
    //   504: iload 14
    //   506: istore 9
    //   508: iload 15
    //   510: istore 11
    //   512: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   515: ifeq +51 -> 566
    //   518: iload 6
    //   520: istore 10
    //   522: iload 12
    //   524: istore 7
    //   526: iload 13
    //   528: istore 8
    //   530: iload 14
    //   532: istore 9
    //   534: iload 15
    //   536: istore 11
    //   538: ldc_w 287
    //   541: iconst_4
    //   542: new 136	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 305
    //   552: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 23
    //   557: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 23
    //   568: ifnull +3635 -> 4203
    //   571: iload 6
    //   573: istore 10
    //   575: iload 12
    //   577: istore 7
    //   579: iload 13
    //   581: istore 8
    //   583: iload 14
    //   585: istore 9
    //   587: iload 15
    //   589: istore 11
    //   591: aload 23
    //   593: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   596: istore 16
    //   598: iload 6
    //   600: istore 10
    //   602: iload 12
    //   604: istore 7
    //   606: iload 13
    //   608: istore 8
    //   610: iload 14
    //   612: istore 9
    //   614: iload 15
    //   616: istore 11
    //   618: aload 23
    //   620: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   623: istore 17
    //   625: iload 6
    //   627: istore 10
    //   629: iload 12
    //   631: istore 7
    //   633: iload 13
    //   635: istore 8
    //   637: iload 14
    //   639: istore 9
    //   641: iload 15
    //   643: istore 11
    //   645: iload 16
    //   647: iload 17
    //   649: imul
    //   650: newarray int
    //   652: astore 24
    //   654: iload 6
    //   656: istore 10
    //   658: iload 12
    //   660: istore 7
    //   662: iload 13
    //   664: istore 8
    //   666: iload 14
    //   668: istore 9
    //   670: iload 15
    //   672: istore 11
    //   674: aload 23
    //   676: aload 24
    //   678: iconst_0
    //   679: iload 16
    //   681: iconst_0
    //   682: iconst_0
    //   683: iload 16
    //   685: iload 17
    //   687: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   690: iload 6
    //   692: istore 10
    //   694: iload 12
    //   696: istore 7
    //   698: iload 13
    //   700: istore 8
    //   702: iload 14
    //   704: istore 9
    //   706: iload 15
    //   708: istore 11
    //   710: aload 24
    //   712: aconst_null
    //   713: iload 16
    //   715: iload 17
    //   717: iload 4
    //   719: aload 25
    //   721: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   724: istore 6
    //   726: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   729: ifeq +44 -> 773
    //   732: ldc_w 287
    //   735: iconst_4
    //   736: ldc_w 310
    //   739: iconst_3
    //   740: anewarray 4	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: iload 4
    //   747: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: dup
    //   752: iconst_1
    //   753: iload 6
    //   755: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   758: aastore
    //   759: dup
    //   760: iconst_2
    //   761: aload 25
    //   763: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   770: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: iload 16
    //   775: iload 17
    //   777: imul
    //   778: newarray byte
    //   780: astore 26
    //   782: aload 24
    //   784: aload 26
    //   786: iload 16
    //   788: iload 17
    //   790: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   793: pop
    //   794: iload 4
    //   796: iconst_2
    //   797: iand
    //   798: iconst_2
    //   799: if_icmpne +560 -> 1359
    //   802: iload 6
    //   804: iconst_2
    //   805: iand
    //   806: ifne +553 -> 1359
    //   809: iconst_1
    //   810: istore 7
    //   812: invokestatic 23	arni:a	()I
    //   815: iflt +9 -> 824
    //   818: invokestatic 28	akux:a	()Z
    //   821: ifeq +3 -> 824
    //   824: iload 7
    //   826: ifeq +3374 -> 4200
    //   829: aload 23
    //   831: iload 16
    //   833: iload 17
    //   835: aload 24
    //   837: aload 26
    //   839: aload 25
    //   841: invokestatic 142	vup:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   844: istore 7
    //   846: iload 6
    //   848: iload 7
    //   850: ior
    //   851: istore 6
    //   853: iload 6
    //   855: istore 10
    //   857: iload 6
    //   859: istore 7
    //   861: iload 6
    //   863: istore 8
    //   865: iload 6
    //   867: istore 9
    //   869: iload 6
    //   871: istore 11
    //   873: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   876: ifeq +50 -> 926
    //   879: iload 6
    //   881: istore 10
    //   883: iload 6
    //   885: istore 7
    //   887: iload 6
    //   889: istore 8
    //   891: iload 6
    //   893: istore 9
    //   895: iload 6
    //   897: istore 11
    //   899: ldc 71
    //   901: iconst_4
    //   902: new 136	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 312
    //   912: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: iload 6
    //   917: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: iload 6
    //   928: istore 7
    //   930: iload 6
    //   932: istore 8
    //   934: iload 6
    //   936: istore 9
    //   938: aload 23
    //   940: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   943: iload 6
    //   945: iflt +264 -> 1209
    //   948: iload 6
    //   950: iconst_1
    //   951: iand
    //   952: iconst_1
    //   953: if_icmpne +2916 -> 3869
    //   956: iconst_1
    //   957: istore_3
    //   958: iload_3
    //   959: ifeq +3250 -> 4209
    //   962: aload 5
    //   964: ifnull +3245 -> 4209
    //   967: iload_2
    //   968: ifeq +3241 -> 4209
    //   971: iload 6
    //   973: istore 7
    //   975: iload 6
    //   977: istore 8
    //   979: iload 6
    //   981: istore 9
    //   983: iload 6
    //   985: istore 10
    //   987: new 136	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   994: astore 23
    //   996: iload 6
    //   998: istore 7
    //   1000: iload 6
    //   1002: istore 8
    //   1004: iload 6
    //   1006: istore 9
    //   1008: iload 6
    //   1010: istore 10
    //   1012: new 136	java/lang/StringBuilder
    //   1015: dup
    //   1016: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1019: astore 24
    //   1021: iload 6
    //   1023: istore 7
    //   1025: iload 6
    //   1027: istore 8
    //   1029: iload 6
    //   1031: istore 9
    //   1033: iload 6
    //   1035: istore 10
    //   1037: aload 23
    //   1039: aload 24
    //   1041: invokestatic 225	bcof:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   1044: pop
    //   1045: iload 6
    //   1047: istore 7
    //   1049: iload 6
    //   1051: istore 8
    //   1053: iload 6
    //   1055: istore 9
    //   1057: iload 6
    //   1059: istore 10
    //   1061: aload 5
    //   1063: iconst_1
    //   1064: new 227	android/util/Pair
    //   1067: dup
    //   1068: aload 24
    //   1070: aload 23
    //   1072: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1075: invokevirtual 236	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1078: goto +3131 -> 4209
    //   1081: iload_2
    //   1082: ifeq +35 -> 1117
    //   1085: aload 5
    //   1087: ifnull +30 -> 1117
    //   1090: iload 6
    //   1092: istore 7
    //   1094: iload 6
    //   1096: istore 8
    //   1098: iload 6
    //   1100: istore 9
    //   1102: iload 6
    //   1104: istore 10
    //   1106: aload 5
    //   1108: iconst_2
    //   1109: aload 25
    //   1111: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1114: invokevirtual 236	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1117: iload 6
    //   1119: istore 7
    //   1121: iload 6
    //   1123: istore 8
    //   1125: iload 6
    //   1127: istore 9
    //   1129: iload 6
    //   1131: istore 10
    //   1133: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1136: ifeq +73 -> 1209
    //   1139: iload 6
    //   1141: istore 7
    //   1143: iload 6
    //   1145: istore 8
    //   1147: iload 6
    //   1149: istore 9
    //   1151: iload 6
    //   1153: istore 10
    //   1155: ldc_w 287
    //   1158: iconst_2
    //   1159: ldc 238
    //   1161: iconst_5
    //   1162: anewarray 4	java/lang/Object
    //   1165: dup
    //   1166: iconst_0
    //   1167: iload 4
    //   1169: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1172: aastore
    //   1173: dup
    //   1174: iconst_1
    //   1175: iload 6
    //   1177: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1180: aastore
    //   1181: dup
    //   1182: iconst_2
    //   1183: iload_3
    //   1184: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1187: aastore
    //   1188: dup
    //   1189: iconst_3
    //   1190: iload_2
    //   1191: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_4
    //   1197: aload 25
    //   1199: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: aastore
    //   1203: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1206: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1209: iload 4
    //   1211: iconst_1
    //   1212: iand
    //   1213: iconst_1
    //   1214: if_icmpne +23 -> 1237
    //   1217: iload 6
    //   1219: istore 7
    //   1221: iload 6
    //   1223: istore 8
    //   1225: iload 6
    //   1227: istore 9
    //   1229: iload 6
    //   1231: istore 10
    //   1233: invokestatic 239	bcof:a	()I
    //   1236: pop
    //   1237: aload_1
    //   1238: ifnull +23 -> 1261
    //   1241: iload 6
    //   1243: istore 7
    //   1245: iload 6
    //   1247: istore 8
    //   1249: iload 6
    //   1251: istore 9
    //   1253: iload 6
    //   1255: istore 10
    //   1257: aload_1
    //   1258: invokevirtual 320	java/io/InputStream:close	()V
    //   1261: iload 6
    //   1263: istore 7
    //   1265: iload 4
    //   1267: iconst_2
    //   1268: iand
    //   1269: iconst_2
    //   1270: if_icmpne +34 -> 1304
    //   1273: iload 6
    //   1275: istore 7
    //   1277: iload 6
    //   1279: istore 8
    //   1281: iload 6
    //   1283: istore 9
    //   1285: iload 6
    //   1287: istore 10
    //   1289: invokestatic 42	akux:a	()Lakux;
    //   1292: lload 21
    //   1294: ldc_w 287
    //   1297: invokevirtual 242	akux:a	(JLjava/lang/String;)V
    //   1300: iload 6
    //   1302: istore 7
    //   1304: iload 7
    //   1306: istore 4
    //   1308: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1311: ifeq -1300 -> 11
    //   1314: ldc_w 287
    //   1317: iconst_4
    //   1318: new 136	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1325: ldc_w 322
    //   1328: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   1334: lload 19
    //   1336: lsub
    //   1337: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1340: ldc_w 324
    //   1343: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: aload_0
    //   1347: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1350: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1353: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1356: iload 7
    //   1358: ireturn
    //   1359: iconst_0
    //   1360: istore 7
    //   1362: goto -550 -> 812
    //   1365: astore 23
    //   1367: iload 10
    //   1369: istore 6
    //   1371: iload 6
    //   1373: istore 7
    //   1375: iload 6
    //   1377: istore 8
    //   1379: iload 6
    //   1381: istore 9
    //   1383: iload 6
    //   1385: istore 10
    //   1387: aload 23
    //   1389: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1392: iload 6
    //   1394: istore 7
    //   1396: iload 6
    //   1398: istore 8
    //   1400: iload 6
    //   1402: istore 9
    //   1404: iload 6
    //   1406: istore 10
    //   1408: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1411: ifeq +2811 -> 4222
    //   1414: iload 6
    //   1416: istore 7
    //   1418: iload 6
    //   1420: istore 8
    //   1422: iload 6
    //   1424: istore 9
    //   1426: iload 6
    //   1428: istore 10
    //   1430: ldc_w 287
    //   1433: iconst_2
    //   1434: aload 23
    //   1436: invokevirtual 326	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1439: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1442: goto +2780 -> 4222
    //   1445: iload 6
    //   1447: istore 7
    //   1449: iload 6
    //   1451: istore 8
    //   1453: iload 6
    //   1455: istore 9
    //   1457: iload 6
    //   1459: istore 10
    //   1461: aload 23
    //   1463: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   1466: iload 6
    //   1468: istore 7
    //   1470: iload 6
    //   1472: istore 8
    //   1474: iload 6
    //   1476: istore 9
    //   1478: iload 6
    //   1480: istore 10
    //   1482: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1485: ifeq +2749 -> 4234
    //   1488: iload 6
    //   1490: istore 7
    //   1492: iload 6
    //   1494: istore 8
    //   1496: iload 6
    //   1498: istore 9
    //   1500: iload 6
    //   1502: istore 10
    //   1504: ldc_w 287
    //   1507: iconst_2
    //   1508: aload 23
    //   1510: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1513: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1516: goto +2718 -> 4234
    //   1519: iload 12
    //   1521: istore 7
    //   1523: iload 13
    //   1525: istore 8
    //   1527: iload 14
    //   1529: istore 9
    //   1531: iload 11
    //   1533: istore 10
    //   1535: new 328	android/graphics/BitmapFactory$Options
    //   1538: dup
    //   1539: invokespecial 329	android/graphics/BitmapFactory$Options:<init>	()V
    //   1542: astore 27
    //   1544: iload 12
    //   1546: istore 7
    //   1548: iload 13
    //   1550: istore 8
    //   1552: iload 14
    //   1554: istore 9
    //   1556: iload 11
    //   1558: istore 10
    //   1560: aload 27
    //   1562: iconst_1
    //   1563: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1566: iload 12
    //   1568: istore 7
    //   1570: iload 13
    //   1572: istore 8
    //   1574: iload 14
    //   1576: istore 9
    //   1578: iload 11
    //   1580: istore 10
    //   1582: aload_1
    //   1583: aconst_null
    //   1584: aload 27
    //   1586: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1589: pop
    //   1590: iload 12
    //   1592: istore 7
    //   1594: iload 13
    //   1596: istore 8
    //   1598: iload 14
    //   1600: istore 9
    //   1602: iload 11
    //   1604: istore 10
    //   1606: aload_1
    //   1607: invokevirtual 320	java/io/InputStream:close	()V
    //   1610: aconst_null
    //   1611: astore_1
    //   1612: iload 12
    //   1614: istore 7
    //   1616: iload 13
    //   1618: istore 8
    //   1620: iload 14
    //   1622: istore 9
    //   1624: iload 11
    //   1626: istore 10
    //   1628: aload 27
    //   1630: getfield 342	android/graphics/BitmapFactory$Options:outWidth	I
    //   1633: istore 15
    //   1635: iload 12
    //   1637: istore 7
    //   1639: iload 13
    //   1641: istore 8
    //   1643: iload 14
    //   1645: istore 9
    //   1647: iload 11
    //   1649: istore 10
    //   1651: aload 27
    //   1653: getfield 345	android/graphics/BitmapFactory$Options:outHeight	I
    //   1656: istore 17
    //   1658: iload 15
    //   1660: sipush 12800
    //   1663: if_icmpgt +2574 -> 4237
    //   1666: iload 17
    //   1668: sipush 12800
    //   1671: if_icmple +6 -> 1677
    //   1674: goto +2563 -> 4237
    //   1677: iload 12
    //   1679: istore 7
    //   1681: iload 13
    //   1683: istore 8
    //   1685: iload 14
    //   1687: istore 9
    //   1689: iload 11
    //   1691: istore 10
    //   1693: aload 27
    //   1695: aload 27
    //   1697: sipush 1280
    //   1700: sipush 1280
    //   1703: invokestatic 350	ageu:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1706: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1709: iload 12
    //   1711: istore 7
    //   1713: iload 13
    //   1715: istore 8
    //   1717: iload 14
    //   1719: istore 9
    //   1721: iload 11
    //   1723: istore 10
    //   1725: aload 27
    //   1727: iconst_0
    //   1728: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1731: iload 12
    //   1733: istore 7
    //   1735: iload 13
    //   1737: istore 8
    //   1739: iload 14
    //   1741: istore 9
    //   1743: iload 11
    //   1745: istore 10
    //   1747: aload 26
    //   1749: aload_0
    //   1750: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1753: astore 23
    //   1755: aload 23
    //   1757: astore_1
    //   1758: iload 12
    //   1760: istore 7
    //   1762: iload 13
    //   1764: istore 8
    //   1766: iload 14
    //   1768: istore 9
    //   1770: iload 11
    //   1772: istore 10
    //   1774: aload 23
    //   1776: aconst_null
    //   1777: aload 27
    //   1779: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1782: astore 24
    //   1784: aload 23
    //   1786: astore_1
    //   1787: iload 12
    //   1789: istore 7
    //   1791: iload 13
    //   1793: istore 8
    //   1795: iload 14
    //   1797: istore 9
    //   1799: iload 11
    //   1801: istore 10
    //   1803: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1806: ifeq +66 -> 1872
    //   1809: aload 23
    //   1811: astore_1
    //   1812: iload 12
    //   1814: istore 7
    //   1816: iload 13
    //   1818: istore 8
    //   1820: iload 14
    //   1822: istore 9
    //   1824: iload 11
    //   1826: istore 10
    //   1828: ldc_w 287
    //   1831: iconst_4
    //   1832: ldc_w 355
    //   1835: iconst_3
    //   1836: anewarray 4	java/lang/Object
    //   1839: dup
    //   1840: iconst_0
    //   1841: iload 15
    //   1843: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1846: aastore
    //   1847: dup
    //   1848: iconst_1
    //   1849: iload 17
    //   1851: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1854: aastore
    //   1855: dup
    //   1856: iconst_2
    //   1857: aload 27
    //   1859: getfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1862: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1865: aastore
    //   1866: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1869: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1872: aload 23
    //   1874: astore_1
    //   1875: iload 12
    //   1877: istore 7
    //   1879: iload 13
    //   1881: istore 8
    //   1883: iload 14
    //   1885: istore 9
    //   1887: iload 11
    //   1889: istore 10
    //   1891: aload 23
    //   1893: invokevirtual 320	java/io/InputStream:close	()V
    //   1896: aconst_null
    //   1897: astore_1
    //   1898: iload 16
    //   1900: istore 6
    //   1902: aload 24
    //   1904: ifnull +36 -> 1940
    //   1907: iload 12
    //   1909: istore 7
    //   1911: iload 13
    //   1913: istore 8
    //   1915: iload 14
    //   1917: istore 9
    //   1919: iload 11
    //   1921: istore 10
    //   1923: aload 24
    //   1925: iload 4
    //   1927: aload 25
    //   1929: invokestatic 209	vup:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1932: istore 6
    //   1934: iconst_0
    //   1935: iload 6
    //   1937: ior
    //   1938: istore 6
    //   1940: aconst_null
    //   1941: astore 23
    //   1943: aconst_null
    //   1944: astore_1
    //   1945: iload 6
    //   1947: istore 8
    //   1949: iload 6
    //   1951: istore 9
    //   1953: iload 6
    //   1955: istore 10
    //   1957: iload 6
    //   1959: istore 11
    //   1961: iload 4
    //   1963: iload 6
    //   1965: invokestatic 211	vup:a	(II)I
    //   1968: istore 13
    //   1970: iload 13
    //   1972: ifle +2219 -> 4191
    //   1975: iload 15
    //   1977: iload 17
    //   1979: iconst_2
    //   1980: imul
    //   1981: if_icmplt +1086 -> 3067
    //   1984: iload 17
    //   1986: sipush 1280
    //   1989: if_icmpge +1078 -> 3067
    //   1992: iconst_1
    //   1993: istore 7
    //   1995: iload 15
    //   1997: iconst_2
    //   1998: imul
    //   1999: iload 17
    //   2001: if_icmpgt +1072 -> 3073
    //   2004: iload 15
    //   2006: sipush 1280
    //   2009: if_icmpge +1064 -> 3073
    //   2012: iconst_1
    //   2013: istore 8
    //   2015: iload 8
    //   2017: ifeq +1114 -> 3131
    //   2020: iload 6
    //   2022: istore 8
    //   2024: iload 6
    //   2026: istore 9
    //   2028: iload 6
    //   2030: istore 10
    //   2032: iload 6
    //   2034: istore 11
    //   2036: aload 26
    //   2038: aload_0
    //   2039: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2042: astore 23
    //   2044: aload 23
    //   2046: astore_1
    //   2047: iload 6
    //   2049: istore 8
    //   2051: iload 6
    //   2053: istore 9
    //   2055: iload 6
    //   2057: istore 10
    //   2059: iload 6
    //   2061: istore 11
    //   2063: aload 23
    //   2065: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2068: astore 24
    //   2070: aload 23
    //   2072: astore_1
    //   2073: iload 6
    //   2075: istore 8
    //   2077: iload 6
    //   2079: istore 9
    //   2081: iload 6
    //   2083: istore 10
    //   2085: iload 6
    //   2087: istore 11
    //   2089: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2092: ifeq +50 -> 2142
    //   2095: aload 23
    //   2097: astore_1
    //   2098: iload 6
    //   2100: istore 8
    //   2102: iload 6
    //   2104: istore 9
    //   2106: iload 6
    //   2108: istore 10
    //   2110: iload 6
    //   2112: istore 11
    //   2114: ldc_w 287
    //   2117: iconst_4
    //   2118: new 136	java/lang/StringBuilder
    //   2121: dup
    //   2122: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2125: ldc_w 360
    //   2128: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: aload 24
    //   2133: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2142: aload 23
    //   2144: astore_1
    //   2145: iload 6
    //   2147: istore 8
    //   2149: iload 6
    //   2151: istore 9
    //   2153: iload 6
    //   2155: istore 10
    //   2157: iload 6
    //   2159: istore 11
    //   2161: aload 23
    //   2163: invokevirtual 320	java/io/InputStream:close	()V
    //   2166: aload 24
    //   2168: ifnull +2029 -> 4197
    //   2171: iload 6
    //   2173: istore 8
    //   2175: iload 6
    //   2177: istore 9
    //   2179: iload 6
    //   2181: istore 10
    //   2183: iload 6
    //   2185: istore 11
    //   2187: iload 6
    //   2189: istore 7
    //   2191: iload 15
    //   2193: iload 15
    //   2195: imul
    //   2196: newarray int
    //   2198: astore_1
    //   2199: iload 6
    //   2201: istore 8
    //   2203: iload 6
    //   2205: istore 9
    //   2207: iload 6
    //   2209: istore 10
    //   2211: iload 6
    //   2213: istore 11
    //   2215: iload 6
    //   2217: istore 7
    //   2219: aload 24
    //   2221: aload_1
    //   2222: iconst_0
    //   2223: iload 15
    //   2225: iconst_0
    //   2226: iconst_0
    //   2227: iload 15
    //   2229: iload 15
    //   2231: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2234: iload 6
    //   2236: istore 8
    //   2238: iload 6
    //   2240: istore 9
    //   2242: iload 6
    //   2244: istore 10
    //   2246: iload 6
    //   2248: istore 11
    //   2250: iload 6
    //   2252: istore 7
    //   2254: iload 15
    //   2256: iload 15
    //   2258: imul
    //   2259: newarray byte
    //   2261: astore 23
    //   2263: iload 6
    //   2265: istore 8
    //   2267: iload 6
    //   2269: istore 9
    //   2271: iload 6
    //   2273: istore 10
    //   2275: iload 6
    //   2277: istore 11
    //   2279: iload 6
    //   2281: istore 7
    //   2283: aload_1
    //   2284: aload 23
    //   2286: iload 15
    //   2288: iload 15
    //   2290: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2293: pop
    //   2294: iload 6
    //   2296: istore 8
    //   2298: iload 6
    //   2300: istore 9
    //   2302: iload 6
    //   2304: istore 10
    //   2306: iload 6
    //   2308: istore 11
    //   2310: iload 6
    //   2312: istore 7
    //   2314: iload 6
    //   2316: aload_1
    //   2317: aload 23
    //   2319: iload 15
    //   2321: iload 15
    //   2323: iload 13
    //   2325: aload 25
    //   2327: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2330: ior
    //   2331: istore 6
    //   2333: iload 6
    //   2335: iconst_1
    //   2336: if_icmpeq +1858 -> 4194
    //   2339: iload 6
    //   2341: istore 8
    //   2343: iload 6
    //   2345: istore 9
    //   2347: iload 6
    //   2349: istore 10
    //   2351: iload 6
    //   2353: istore 11
    //   2355: iload 6
    //   2357: istore 7
    //   2359: aload 24
    //   2361: aload_1
    //   2362: iconst_0
    //   2363: iload 15
    //   2365: iconst_0
    //   2366: iload 17
    //   2368: iload 15
    //   2370: isub
    //   2371: iload 15
    //   2373: iload 15
    //   2375: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2378: iload 6
    //   2380: istore 8
    //   2382: iload 6
    //   2384: istore 9
    //   2386: iload 6
    //   2388: istore 10
    //   2390: iload 6
    //   2392: istore 11
    //   2394: iload 6
    //   2396: istore 7
    //   2398: aload_1
    //   2399: aload 23
    //   2401: iload 15
    //   2403: iload 15
    //   2405: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2408: pop
    //   2409: iload 6
    //   2411: istore 8
    //   2413: iload 6
    //   2415: istore 9
    //   2417: iload 6
    //   2419: istore 10
    //   2421: iload 6
    //   2423: istore 11
    //   2425: iload 6
    //   2427: istore 7
    //   2429: aload_1
    //   2430: aload 23
    //   2432: iload 15
    //   2434: iload 15
    //   2436: iload 13
    //   2438: aload 25
    //   2440: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2443: istore 12
    //   2445: iload 12
    //   2447: iload 6
    //   2449: ior
    //   2450: istore 6
    //   2452: iload 6
    //   2454: istore 7
    //   2456: iload 6
    //   2458: istore 8
    //   2460: iload 6
    //   2462: istore 9
    //   2464: aload 24
    //   2466: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   2469: iload 6
    //   2471: istore 7
    //   2473: iload 6
    //   2475: istore 8
    //   2477: iload 6
    //   2479: istore 9
    //   2481: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2484: ifeq +56 -> 2540
    //   2487: iload 6
    //   2489: istore 7
    //   2491: iload 6
    //   2493: istore 8
    //   2495: iload 6
    //   2497: istore 9
    //   2499: ldc_w 287
    //   2502: iconst_4
    //   2503: ldc_w 362
    //   2506: iconst_3
    //   2507: anewarray 4	java/lang/Object
    //   2510: dup
    //   2511: iconst_0
    //   2512: iload 13
    //   2514: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2517: aastore
    //   2518: dup
    //   2519: iconst_1
    //   2520: iload 6
    //   2522: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2525: aastore
    //   2526: dup
    //   2527: iconst_2
    //   2528: aload 25
    //   2530: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2533: aastore
    //   2534: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2537: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2540: aconst_null
    //   2541: astore_1
    //   2542: iload 6
    //   2544: istore 7
    //   2546: iload 6
    //   2548: istore 8
    //   2550: iload 6
    //   2552: istore 9
    //   2554: iload 6
    //   2556: istore 10
    //   2558: iload 4
    //   2560: iload 6
    //   2562: invokestatic 211	vup:a	(II)I
    //   2565: istore 11
    //   2567: iload 11
    //   2569: ifle +1617 -> 4186
    //   2572: iload 6
    //   2574: istore 7
    //   2576: iload 6
    //   2578: istore 8
    //   2580: iload 6
    //   2582: istore 9
    //   2584: iload 6
    //   2586: istore 10
    //   2588: iload 15
    //   2590: iload 17
    //   2592: invokestatic 216	java/lang/Math:min	(II)I
    //   2595: istore 12
    //   2597: iload 12
    //   2599: sipush 250
    //   2602: if_icmple +1584 -> 4186
    //   2605: iload 6
    //   2607: istore 7
    //   2609: iload 6
    //   2611: istore 8
    //   2613: iload 6
    //   2615: istore 9
    //   2617: iload 6
    //   2619: istore 10
    //   2621: aload 27
    //   2623: iload 12
    //   2625: i2d
    //   2626: ldc2_w 217
    //   2629: ddiv
    //   2630: invokestatic 222	java/lang/Math:ceil	(D)D
    //   2633: d2i
    //   2634: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2637: iload 6
    //   2639: istore 7
    //   2641: iload 6
    //   2643: istore 8
    //   2645: iload 6
    //   2647: istore 9
    //   2649: iload 6
    //   2651: istore 10
    //   2653: aload 26
    //   2655: aload_0
    //   2656: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2659: astore 23
    //   2661: aload 23
    //   2663: astore_1
    //   2664: iload 6
    //   2666: istore 7
    //   2668: iload 6
    //   2670: istore 8
    //   2672: iload 6
    //   2674: istore 9
    //   2676: iload 6
    //   2678: istore 10
    //   2680: aload 23
    //   2682: aconst_null
    //   2683: aload 27
    //   2685: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2688: astore 24
    //   2690: aload 23
    //   2692: astore_1
    //   2693: iload 6
    //   2695: istore 7
    //   2697: iload 6
    //   2699: istore 8
    //   2701: iload 6
    //   2703: istore 9
    //   2705: iload 6
    //   2707: istore 10
    //   2709: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2712: ifeq +50 -> 2762
    //   2715: aload 23
    //   2717: astore_1
    //   2718: iload 6
    //   2720: istore 7
    //   2722: iload 6
    //   2724: istore 8
    //   2726: iload 6
    //   2728: istore 9
    //   2730: iload 6
    //   2732: istore 10
    //   2734: ldc_w 287
    //   2737: iconst_4
    //   2738: new 136	java/lang/StringBuilder
    //   2741: dup
    //   2742: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2745: ldc_w 364
    //   2748: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: aload 24
    //   2753: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2756: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2759: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2762: aload 23
    //   2764: astore_1
    //   2765: iload 6
    //   2767: istore 7
    //   2769: iload 6
    //   2771: istore 8
    //   2773: iload 6
    //   2775: istore 9
    //   2777: iload 6
    //   2779: istore 10
    //   2781: aload 23
    //   2783: invokevirtual 320	java/io/InputStream:close	()V
    //   2786: aconst_null
    //   2787: astore_1
    //   2788: aload 24
    //   2790: ifnull +1389 -> 4179
    //   2793: iload 6
    //   2795: istore 7
    //   2797: iload 6
    //   2799: istore 8
    //   2801: iload 6
    //   2803: istore 9
    //   2805: iload 6
    //   2807: istore 10
    //   2809: aload 24
    //   2811: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   2814: istore 12
    //   2816: iload 6
    //   2818: istore 7
    //   2820: iload 6
    //   2822: istore 8
    //   2824: iload 6
    //   2826: istore 9
    //   2828: iload 6
    //   2830: istore 10
    //   2832: aload 24
    //   2834: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   2837: istore 13
    //   2839: iload 6
    //   2841: istore 7
    //   2843: iload 6
    //   2845: istore 8
    //   2847: iload 6
    //   2849: istore 9
    //   2851: iload 6
    //   2853: istore 10
    //   2855: iload 12
    //   2857: iload 13
    //   2859: imul
    //   2860: newarray int
    //   2862: astore 23
    //   2864: iload 6
    //   2866: istore 7
    //   2868: iload 6
    //   2870: istore 8
    //   2872: iload 6
    //   2874: istore 9
    //   2876: iload 6
    //   2878: istore 10
    //   2880: aload 24
    //   2882: aload 23
    //   2884: iconst_0
    //   2885: iload 12
    //   2887: iconst_0
    //   2888: iconst_0
    //   2889: iload 12
    //   2891: iload 13
    //   2893: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2896: iload 6
    //   2898: istore 7
    //   2900: iload 6
    //   2902: istore 8
    //   2904: iload 6
    //   2906: istore 9
    //   2908: iload 6
    //   2910: istore 10
    //   2912: aload 24
    //   2914: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   2917: iload 6
    //   2919: istore 7
    //   2921: iload 6
    //   2923: istore 8
    //   2925: iload 6
    //   2927: istore 9
    //   2929: iload 6
    //   2931: istore 10
    //   2933: aload 23
    //   2935: aconst_null
    //   2936: iload 12
    //   2938: iload 13
    //   2940: iload 11
    //   2942: aload 25
    //   2944: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2947: istore 12
    //   2949: iload 12
    //   2951: iload 6
    //   2953: ior
    //   2954: istore 6
    //   2956: iload 6
    //   2958: istore 7
    //   2960: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2963: ifeq +48 -> 3011
    //   2966: ldc_w 287
    //   2969: iconst_4
    //   2970: ldc_w 366
    //   2973: iconst_3
    //   2974: anewarray 4	java/lang/Object
    //   2977: dup
    //   2978: iconst_0
    //   2979: iload 11
    //   2981: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2984: aastore
    //   2985: dup
    //   2986: iconst_1
    //   2987: iload 6
    //   2989: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2992: aastore
    //   2993: dup
    //   2994: iconst_2
    //   2995: aload 25
    //   2997: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3000: aastore
    //   3001: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3004: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3007: iload 6
    //   3009: istore 7
    //   3011: iload 7
    //   3013: istore 6
    //   3015: goto -2072 -> 943
    //   3018: astore 23
    //   3020: iload 12
    //   3022: istore 7
    //   3024: iload 13
    //   3026: istore 8
    //   3028: iload 14
    //   3030: istore 9
    //   3032: iload 11
    //   3034: istore 10
    //   3036: aload 23
    //   3038: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3041: iload 12
    //   3043: istore 7
    //   3045: iload 13
    //   3047: istore 8
    //   3049: iload 14
    //   3051: istore 9
    //   3053: iload 11
    //   3055: istore 10
    //   3057: aload_1
    //   3058: invokevirtual 320	java/io/InputStream:close	()V
    //   3061: iconst_0
    //   3062: istore 6
    //   3064: goto -1124 -> 1940
    //   3067: iconst_0
    //   3068: istore 7
    //   3070: goto -1075 -> 1995
    //   3073: iconst_0
    //   3074: istore 8
    //   3076: goto -1061 -> 2015
    //   3079: astore 24
    //   3081: aload_1
    //   3082: astore 23
    //   3084: aload 24
    //   3086: astore_1
    //   3087: iload 6
    //   3089: istore 8
    //   3091: iload 6
    //   3093: istore 9
    //   3095: iload 6
    //   3097: istore 10
    //   3099: iload 6
    //   3101: istore 11
    //   3103: aload_1
    //   3104: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3107: iload 6
    //   3109: istore 8
    //   3111: iload 6
    //   3113: istore 9
    //   3115: iload 6
    //   3117: istore 10
    //   3119: iload 6
    //   3121: istore 11
    //   3123: aload 23
    //   3125: invokevirtual 320	java/io/InputStream:close	()V
    //   3128: goto -588 -> 2540
    //   3131: iload 7
    //   3133: ifeq +1058 -> 4191
    //   3136: aload 23
    //   3138: astore_1
    //   3139: iload 6
    //   3141: istore 7
    //   3143: iload 6
    //   3145: istore 8
    //   3147: iload 6
    //   3149: istore 9
    //   3151: iload 6
    //   3153: istore 10
    //   3155: iload 6
    //   3157: istore 11
    //   3159: aload 26
    //   3161: aload_0
    //   3162: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3165: astore 23
    //   3167: aload 23
    //   3169: astore_1
    //   3170: iload 6
    //   3172: istore 7
    //   3174: iload 6
    //   3176: istore 8
    //   3178: iload 6
    //   3180: istore 9
    //   3182: iload 6
    //   3184: istore 10
    //   3186: iload 6
    //   3188: istore 11
    //   3190: aload 23
    //   3192: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3195: astore 24
    //   3197: aload 23
    //   3199: astore_1
    //   3200: iload 6
    //   3202: istore 7
    //   3204: iload 6
    //   3206: istore 8
    //   3208: iload 6
    //   3210: istore 9
    //   3212: iload 6
    //   3214: istore 10
    //   3216: iload 6
    //   3218: istore 11
    //   3220: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3223: ifeq +54 -> 3277
    //   3226: aload 23
    //   3228: astore_1
    //   3229: iload 6
    //   3231: istore 7
    //   3233: iload 6
    //   3235: istore 8
    //   3237: iload 6
    //   3239: istore 9
    //   3241: iload 6
    //   3243: istore 10
    //   3245: iload 6
    //   3247: istore 11
    //   3249: ldc_w 287
    //   3252: iconst_4
    //   3253: new 136	java/lang/StringBuilder
    //   3256: dup
    //   3257: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3260: ldc_w 368
    //   3263: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3266: aload 24
    //   3268: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3271: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3274: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3277: aload 23
    //   3279: astore_1
    //   3280: iload 6
    //   3282: istore 7
    //   3284: iload 6
    //   3286: istore 8
    //   3288: iload 6
    //   3290: istore 9
    //   3292: iload 6
    //   3294: istore 10
    //   3296: iload 6
    //   3298: istore 11
    //   3300: aload 23
    //   3302: invokevirtual 320	java/io/InputStream:close	()V
    //   3305: aconst_null
    //   3306: astore 23
    //   3308: iload 6
    //   3310: istore 12
    //   3312: aload 24
    //   3314: ifnull +444 -> 3758
    //   3317: aload 23
    //   3319: astore_1
    //   3320: iload 6
    //   3322: istore 7
    //   3324: iload 6
    //   3326: istore 8
    //   3328: iload 6
    //   3330: istore 9
    //   3332: iload 6
    //   3334: istore 10
    //   3336: iload 6
    //   3338: istore 11
    //   3340: iload 17
    //   3342: iload 17
    //   3344: imul
    //   3345: newarray int
    //   3347: astore 28
    //   3349: aload 23
    //   3351: astore_1
    //   3352: iload 6
    //   3354: istore 7
    //   3356: iload 6
    //   3358: istore 8
    //   3360: iload 6
    //   3362: istore 9
    //   3364: iload 6
    //   3366: istore 10
    //   3368: iload 6
    //   3370: istore 11
    //   3372: aload 24
    //   3374: aload 28
    //   3376: iconst_0
    //   3377: iload 17
    //   3379: iconst_0
    //   3380: iconst_0
    //   3381: iload 17
    //   3383: iload 17
    //   3385: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3388: aload 23
    //   3390: astore_1
    //   3391: iload 6
    //   3393: istore 7
    //   3395: iload 6
    //   3397: istore 8
    //   3399: iload 6
    //   3401: istore 9
    //   3403: iload 6
    //   3405: istore 10
    //   3407: iload 6
    //   3409: istore 11
    //   3411: iload 17
    //   3413: iload 17
    //   3415: imul
    //   3416: newarray byte
    //   3418: astore 29
    //   3420: aload 23
    //   3422: astore_1
    //   3423: iload 6
    //   3425: istore 7
    //   3427: iload 6
    //   3429: istore 8
    //   3431: iload 6
    //   3433: istore 9
    //   3435: iload 6
    //   3437: istore 10
    //   3439: iload 6
    //   3441: istore 11
    //   3443: aload 28
    //   3445: aload 29
    //   3447: iload 17
    //   3449: iload 17
    //   3451: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3454: pop
    //   3455: aload 23
    //   3457: astore_1
    //   3458: iload 6
    //   3460: istore 7
    //   3462: iload 6
    //   3464: istore 8
    //   3466: iload 6
    //   3468: istore 9
    //   3470: iload 6
    //   3472: istore 10
    //   3474: iload 6
    //   3476: istore 11
    //   3478: iload 6
    //   3480: aload 28
    //   3482: aload 29
    //   3484: iload 17
    //   3486: iload 17
    //   3488: iload 13
    //   3490: aload 25
    //   3492: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3495: ior
    //   3496: istore 12
    //   3498: iload 12
    //   3500: istore 6
    //   3502: iload 12
    //   3504: iconst_1
    //   3505: if_icmpeq +124 -> 3629
    //   3508: aload 23
    //   3510: astore_1
    //   3511: iload 12
    //   3513: istore 7
    //   3515: iload 12
    //   3517: istore 8
    //   3519: iload 12
    //   3521: istore 9
    //   3523: iload 12
    //   3525: istore 10
    //   3527: iload 12
    //   3529: istore 11
    //   3531: aload 24
    //   3533: aload 28
    //   3535: iconst_0
    //   3536: iload 17
    //   3538: iload 15
    //   3540: iload 17
    //   3542: isub
    //   3543: iconst_0
    //   3544: iload 17
    //   3546: iload 17
    //   3548: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3551: aload 23
    //   3553: astore_1
    //   3554: iload 12
    //   3556: istore 7
    //   3558: iload 12
    //   3560: istore 8
    //   3562: iload 12
    //   3564: istore 9
    //   3566: iload 12
    //   3568: istore 10
    //   3570: iload 12
    //   3572: istore 11
    //   3574: aload 28
    //   3576: aload 29
    //   3578: iload 17
    //   3580: iload 17
    //   3582: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3585: pop
    //   3586: aload 23
    //   3588: astore_1
    //   3589: iload 12
    //   3591: istore 7
    //   3593: iload 12
    //   3595: istore 8
    //   3597: iload 12
    //   3599: istore 9
    //   3601: iload 12
    //   3603: istore 10
    //   3605: iload 12
    //   3607: istore 11
    //   3609: iload 12
    //   3611: aload 28
    //   3613: aload 29
    //   3615: iload 17
    //   3617: iload 17
    //   3619: iload 13
    //   3621: aload 25
    //   3623: invokestatic 132	vup:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3626: ior
    //   3627: istore 6
    //   3629: aload 23
    //   3631: astore_1
    //   3632: iload 6
    //   3634: istore 7
    //   3636: iload 6
    //   3638: istore 8
    //   3640: iload 6
    //   3642: istore 9
    //   3644: iload 6
    //   3646: istore 10
    //   3648: iload 6
    //   3650: istore 11
    //   3652: aload 24
    //   3654: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   3657: iload 6
    //   3659: istore 12
    //   3661: aload 23
    //   3663: astore_1
    //   3664: iload 6
    //   3666: istore 7
    //   3668: iload 6
    //   3670: istore 8
    //   3672: iload 6
    //   3674: istore 9
    //   3676: iload 6
    //   3678: istore 10
    //   3680: iload 6
    //   3682: istore 11
    //   3684: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3687: ifeq +71 -> 3758
    //   3690: aload 23
    //   3692: astore_1
    //   3693: iload 6
    //   3695: istore 7
    //   3697: iload 6
    //   3699: istore 8
    //   3701: iload 6
    //   3703: istore 9
    //   3705: iload 6
    //   3707: istore 10
    //   3709: iload 6
    //   3711: istore 11
    //   3713: ldc_w 287
    //   3716: iconst_4
    //   3717: ldc_w 370
    //   3720: iconst_3
    //   3721: anewarray 4	java/lang/Object
    //   3724: dup
    //   3725: iconst_0
    //   3726: iload 13
    //   3728: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3731: aastore
    //   3732: dup
    //   3733: iconst_1
    //   3734: iload 6
    //   3736: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3739: aastore
    //   3740: dup
    //   3741: iconst_2
    //   3742: aload 25
    //   3744: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3747: aastore
    //   3748: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3751: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3754: iload 6
    //   3756: istore 12
    //   3758: iload 12
    //   3760: istore 6
    //   3762: goto -1222 -> 2540
    //   3765: astore 23
    //   3767: iload 7
    //   3769: istore 8
    //   3771: iload 7
    //   3773: istore 9
    //   3775: iload 7
    //   3777: istore 10
    //   3779: iload 7
    //   3781: istore 11
    //   3783: aload 23
    //   3785: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3788: iload 7
    //   3790: istore 8
    //   3792: iload 7
    //   3794: istore 9
    //   3796: iload 7
    //   3798: istore 10
    //   3800: iload 7
    //   3802: istore 11
    //   3804: aload_1
    //   3805: invokevirtual 320	java/io/InputStream:close	()V
    //   3808: iload 7
    //   3810: istore 6
    //   3812: goto -1272 -> 2540
    //   3815: astore 24
    //   3817: aload_1
    //   3818: astore 23
    //   3820: aload 24
    //   3822: astore_1
    //   3823: iload 6
    //   3825: istore 7
    //   3827: iload 6
    //   3829: istore 8
    //   3831: iload 6
    //   3833: istore 9
    //   3835: iload 6
    //   3837: istore 10
    //   3839: aload_1
    //   3840: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3843: iload 6
    //   3845: istore 7
    //   3847: iload 6
    //   3849: istore 8
    //   3851: iload 6
    //   3853: istore 9
    //   3855: iload 6
    //   3857: istore 10
    //   3859: aload 23
    //   3861: invokevirtual 320	java/io/InputStream:close	()V
    //   3864: aconst_null
    //   3865: astore_1
    //   3866: goto -2923 -> 943
    //   3869: iconst_0
    //   3870: istore_3
    //   3871: goto -2913 -> 958
    //   3874: iconst_0
    //   3875: istore_2
    //   3876: goto -2795 -> 1081
    //   3879: astore_1
    //   3880: iload 7
    //   3882: istore 4
    //   3884: aload_1
    //   3885: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   3888: iload 4
    //   3890: istore 7
    //   3892: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3895: ifeq -2591 -> 1304
    //   3898: ldc_w 287
    //   3901: iconst_2
    //   3902: aload_1
    //   3903: invokevirtual 372	java/io/IOException:toString	()Ljava/lang/String;
    //   3906: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3909: iload 4
    //   3911: istore 7
    //   3913: goto -2609 -> 1304
    //   3916: astore_1
    //   3917: aload_1
    //   3918: invokevirtual 250	java/lang/RuntimeException:printStackTrace	()V
    //   3921: iload 8
    //   3923: istore 7
    //   3925: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3928: ifeq -2624 -> 1304
    //   3931: ldc_w 287
    //   3934: iconst_2
    //   3935: aload_1
    //   3936: invokevirtual 251	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3939: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3942: iload 8
    //   3944: istore 7
    //   3946: goto -2642 -> 1304
    //   3949: astore_1
    //   3950: aload_1
    //   3951: invokevirtual 255	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3954: iload 9
    //   3956: istore 7
    //   3958: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3961: ifeq -2657 -> 1304
    //   3964: ldc_w 287
    //   3967: iconst_2
    //   3968: aload_1
    //   3969: invokevirtual 256	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3972: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3975: iload 9
    //   3977: istore 7
    //   3979: goto -2675 -> 1304
    //   3982: astore_1
    //   3983: aload_1
    //   3984: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   3987: iload 10
    //   3989: istore 7
    //   3991: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3994: ifeq -2690 -> 1304
    //   3997: ldc_w 287
    //   4000: iconst_2
    //   4001: aload_1
    //   4002: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4005: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4008: iload 10
    //   4010: istore 7
    //   4012: goto -2708 -> 1304
    //   4015: astore_1
    //   4016: iload 8
    //   4018: istore 10
    //   4020: goto -37 -> 3983
    //   4023: astore_1
    //   4024: iload 6
    //   4026: istore 10
    //   4028: goto -45 -> 3983
    //   4031: astore_1
    //   4032: iload 6
    //   4034: istore 10
    //   4036: goto -53 -> 3983
    //   4039: astore_1
    //   4040: iload 6
    //   4042: istore 9
    //   4044: goto -94 -> 3950
    //   4047: astore_1
    //   4048: iload 7
    //   4050: istore 9
    //   4052: goto -102 -> 3950
    //   4055: astore_1
    //   4056: goto -106 -> 3950
    //   4059: astore_1
    //   4060: iload 6
    //   4062: istore 9
    //   4064: goto -114 -> 3950
    //   4067: astore_1
    //   4068: iload 6
    //   4070: istore 8
    //   4072: goto -155 -> 3917
    //   4075: astore_1
    //   4076: goto -159 -> 3917
    //   4079: astore_1
    //   4080: iload 10
    //   4082: istore 8
    //   4084: goto -167 -> 3917
    //   4087: astore_1
    //   4088: iload 6
    //   4090: istore 8
    //   4092: goto -175 -> 3917
    //   4095: astore_1
    //   4096: iload 6
    //   4098: istore 4
    //   4100: goto -216 -> 3884
    //   4103: astore_1
    //   4104: iload 9
    //   4106: istore 4
    //   4108: goto -224 -> 3884
    //   4111: astore_1
    //   4112: iload 11
    //   4114: istore 4
    //   4116: goto -232 -> 3884
    //   4119: astore_1
    //   4120: iload 6
    //   4122: istore 4
    //   4124: goto -240 -> 3884
    //   4127: astore_1
    //   4128: aconst_null
    //   4129: astore 23
    //   4131: goto -308 -> 3823
    //   4134: astore_1
    //   4135: aconst_null
    //   4136: astore 23
    //   4138: goto -315 -> 3823
    //   4141: astore_1
    //   4142: aconst_null
    //   4143: astore 23
    //   4145: iload 7
    //   4147: istore 6
    //   4149: goto -1062 -> 3087
    //   4152: astore_1
    //   4153: aconst_null
    //   4154: astore 23
    //   4156: goto -1069 -> 3087
    //   4159: astore 23
    //   4161: goto -2716 -> 1445
    //   4164: astore 23
    //   4166: goto -2721 -> 1445
    //   4169: astore 23
    //   4171: goto -2800 -> 1371
    //   4174: astore 23
    //   4176: goto -2805 -> 1371
    //   4179: iload 6
    //   4181: istore 7
    //   4183: goto -1172 -> 3011
    //   4186: aconst_null
    //   4187: astore_1
    //   4188: goto -3245 -> 943
    //   4191: goto -1651 -> 2540
    //   4194: goto -1742 -> 2452
    //   4197: goto -1657 -> 2540
    //   4200: goto -3274 -> 926
    //   4203: iconst_0
    //   4204: istore 6
    //   4206: goto -3263 -> 943
    //   4209: iload 6
    //   4211: iconst_2
    //   4212: iand
    //   4213: iconst_2
    //   4214: if_icmpne -340 -> 3874
    //   4217: iconst_1
    //   4218: istore_2
    //   4219: goto -3138 -> 1081
    //   4222: goto -3279 -> 943
    //   4225: astore 23
    //   4227: iload 11
    //   4229: istore 6
    //   4231: goto -2786 -> 1445
    //   4234: goto -3291 -> 943
    //   4237: iconst_0
    //   4238: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4239	0	paramUri	Uri
    //   0	4239	1	paramContext	Context
    //   0	4239	2	paramBoolean1	boolean
    //   0	4239	3	paramBoolean2	boolean
    //   0	4239	4	paramInt	int
    //   0	4239	5	paramSparseArray	SparseArray<Object>
    //   20	4210	6	i	int
    //   45	4137	7	j	int
    //   49	4042	8	k	int
    //   53	4052	9	m	int
    //   57	4024	10	n	int
    //   35	4193	11	i1	int
    //   26	3733	12	i2	int
    //   29	3698	13	i3	int
    //   32	3018	14	i4	int
    //   38	3505	15	i5	int
    //   23	1876	16	i6	int
    //   41	3577	17	i7	int
    //   186	88	18	i8	int
    //   17	1318	19	l1	long
    //   323	970	21	l2	long
    //   150	921	23	localObject1	Object
    //   1365	144	23	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1753	1181	23	localObject2	Object
    //   3018	19	23	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3082	609	23	localObject3	Object
    //   3765	19	23	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3818	337	23	localContext	Context
    //   4159	1	23	localThrowable1	Throwable
    //   4164	1	23	localThrowable2	Throwable
    //   4169	1	23	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4174	1	23	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   4225	1	23	localThrowable3	Throwable
    //   652	2261	24	localObject4	Object
    //   3079	6	24	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   3195	458	24	localBitmap	Bitmap
    //   3815	6	24	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   457	3286	25	localStringBuilder	StringBuilder
    //   63	3097	26	localObject5	Object
    //   1542	1142	27	localOptions	android.graphics.BitmapFactory.Options
    //   3347	265	28	arrayOfInt	int[]
    //   3418	196	29	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   483	492	1365	java/lang/OutOfMemoryError
    //   512	518	1365	java/lang/OutOfMemoryError
    //   538	566	1365	java/lang/OutOfMemoryError
    //   591	598	1365	java/lang/OutOfMemoryError
    //   618	625	1365	java/lang/OutOfMemoryError
    //   645	654	1365	java/lang/OutOfMemoryError
    //   674	690	1365	java/lang/OutOfMemoryError
    //   710	726	1365	java/lang/OutOfMemoryError
    //   873	879	1365	java/lang/OutOfMemoryError
    //   899	926	1365	java/lang/OutOfMemoryError
    //   1747	1755	3018	java/lang/OutOfMemoryError
    //   1774	1784	3018	java/lang/OutOfMemoryError
    //   1803	1809	3018	java/lang/OutOfMemoryError
    //   1828	1872	3018	java/lang/OutOfMemoryError
    //   1891	1896	3018	java/lang/OutOfMemoryError
    //   1923	1934	3018	java/lang/OutOfMemoryError
    //   2036	2044	3079	java/lang/OutOfMemoryError
    //   2063	2070	3079	java/lang/OutOfMemoryError
    //   2089	2095	3079	java/lang/OutOfMemoryError
    //   2114	2142	3079	java/lang/OutOfMemoryError
    //   2161	2166	3079	java/lang/OutOfMemoryError
    //   3159	3167	3765	java/lang/OutOfMemoryError
    //   3190	3197	3765	java/lang/OutOfMemoryError
    //   3220	3226	3765	java/lang/OutOfMemoryError
    //   3249	3277	3765	java/lang/OutOfMemoryError
    //   3300	3305	3765	java/lang/OutOfMemoryError
    //   3340	3349	3765	java/lang/OutOfMemoryError
    //   3372	3388	3765	java/lang/OutOfMemoryError
    //   3411	3420	3765	java/lang/OutOfMemoryError
    //   3443	3455	3765	java/lang/OutOfMemoryError
    //   3478	3498	3765	java/lang/OutOfMemoryError
    //   3531	3551	3765	java/lang/OutOfMemoryError
    //   3574	3586	3765	java/lang/OutOfMemoryError
    //   3609	3629	3765	java/lang/OutOfMemoryError
    //   3652	3657	3765	java/lang/OutOfMemoryError
    //   3684	3690	3765	java/lang/OutOfMemoryError
    //   3713	3754	3765	java/lang/OutOfMemoryError
    //   2653	2661	3815	java/lang/OutOfMemoryError
    //   2680	2690	3815	java/lang/OutOfMemoryError
    //   2709	2715	3815	java/lang/OutOfMemoryError
    //   2734	2762	3815	java/lang/OutOfMemoryError
    //   2781	2786	3815	java/lang/OutOfMemoryError
    //   59	65	3879	java/io/IOException
    //   81	88	3879	java/io/IOException
    //   120	131	3879	java/io/IOException
    //   147	152	3879	java/io/IOException
    //   178	188	3879	java/io/IOException
    //   204	209	3879	java/io/IOException
    //   225	231	3879	java/io/IOException
    //   247	304	3879	java/io/IOException
    //   320	325	3879	java/io/IOException
    //   349	363	3879	java/io/IOException
    //   379	385	3879	java/io/IOException
    //   401	434	3879	java/io/IOException
    //   450	459	3879	java/io/IOException
    //   483	492	3879	java/io/IOException
    //   512	518	3879	java/io/IOException
    //   538	566	3879	java/io/IOException
    //   591	598	3879	java/io/IOException
    //   618	625	3879	java/io/IOException
    //   645	654	3879	java/io/IOException
    //   674	690	3879	java/io/IOException
    //   710	726	3879	java/io/IOException
    //   873	879	3879	java/io/IOException
    //   899	926	3879	java/io/IOException
    //   987	996	3879	java/io/IOException
    //   1012	1021	3879	java/io/IOException
    //   1037	1045	3879	java/io/IOException
    //   1061	1078	3879	java/io/IOException
    //   1106	1117	3879	java/io/IOException
    //   1133	1139	3879	java/io/IOException
    //   1155	1209	3879	java/io/IOException
    //   1233	1237	3879	java/io/IOException
    //   1257	1261	3879	java/io/IOException
    //   1289	1300	3879	java/io/IOException
    //   1387	1392	3879	java/io/IOException
    //   1408	1414	3879	java/io/IOException
    //   1430	1442	3879	java/io/IOException
    //   1461	1466	3879	java/io/IOException
    //   1482	1488	3879	java/io/IOException
    //   1504	1516	3879	java/io/IOException
    //   1535	1544	3879	java/io/IOException
    //   1560	1566	3879	java/io/IOException
    //   1582	1590	3879	java/io/IOException
    //   1606	1610	3879	java/io/IOException
    //   1628	1635	3879	java/io/IOException
    //   1651	1658	3879	java/io/IOException
    //   1693	1709	3879	java/io/IOException
    //   1725	1731	3879	java/io/IOException
    //   1747	1755	3879	java/io/IOException
    //   1774	1784	3879	java/io/IOException
    //   1803	1809	3879	java/io/IOException
    //   1828	1872	3879	java/io/IOException
    //   1891	1896	3879	java/io/IOException
    //   1923	1934	3879	java/io/IOException
    //   2558	2567	3879	java/io/IOException
    //   2588	2597	3879	java/io/IOException
    //   2621	2637	3879	java/io/IOException
    //   2653	2661	3879	java/io/IOException
    //   2680	2690	3879	java/io/IOException
    //   2709	2715	3879	java/io/IOException
    //   2734	2762	3879	java/io/IOException
    //   2781	2786	3879	java/io/IOException
    //   2809	2816	3879	java/io/IOException
    //   2832	2839	3879	java/io/IOException
    //   2855	2864	3879	java/io/IOException
    //   2880	2896	3879	java/io/IOException
    //   2912	2917	3879	java/io/IOException
    //   2933	2949	3879	java/io/IOException
    //   3036	3041	3879	java/io/IOException
    //   3057	3061	3879	java/io/IOException
    //   3839	3843	3879	java/io/IOException
    //   3859	3864	3879	java/io/IOException
    //   59	65	3916	java/lang/RuntimeException
    //   81	88	3916	java/lang/RuntimeException
    //   120	131	3916	java/lang/RuntimeException
    //   147	152	3916	java/lang/RuntimeException
    //   178	188	3916	java/lang/RuntimeException
    //   204	209	3916	java/lang/RuntimeException
    //   225	231	3916	java/lang/RuntimeException
    //   247	304	3916	java/lang/RuntimeException
    //   320	325	3916	java/lang/RuntimeException
    //   349	363	3916	java/lang/RuntimeException
    //   379	385	3916	java/lang/RuntimeException
    //   401	434	3916	java/lang/RuntimeException
    //   450	459	3916	java/lang/RuntimeException
    //   483	492	3916	java/lang/RuntimeException
    //   512	518	3916	java/lang/RuntimeException
    //   538	566	3916	java/lang/RuntimeException
    //   591	598	3916	java/lang/RuntimeException
    //   618	625	3916	java/lang/RuntimeException
    //   645	654	3916	java/lang/RuntimeException
    //   674	690	3916	java/lang/RuntimeException
    //   710	726	3916	java/lang/RuntimeException
    //   873	879	3916	java/lang/RuntimeException
    //   899	926	3916	java/lang/RuntimeException
    //   987	996	3916	java/lang/RuntimeException
    //   1012	1021	3916	java/lang/RuntimeException
    //   1037	1045	3916	java/lang/RuntimeException
    //   1061	1078	3916	java/lang/RuntimeException
    //   1106	1117	3916	java/lang/RuntimeException
    //   1133	1139	3916	java/lang/RuntimeException
    //   1155	1209	3916	java/lang/RuntimeException
    //   1233	1237	3916	java/lang/RuntimeException
    //   1257	1261	3916	java/lang/RuntimeException
    //   1289	1300	3916	java/lang/RuntimeException
    //   1387	1392	3916	java/lang/RuntimeException
    //   1408	1414	3916	java/lang/RuntimeException
    //   1430	1442	3916	java/lang/RuntimeException
    //   1461	1466	3916	java/lang/RuntimeException
    //   1482	1488	3916	java/lang/RuntimeException
    //   1504	1516	3916	java/lang/RuntimeException
    //   1535	1544	3916	java/lang/RuntimeException
    //   1560	1566	3916	java/lang/RuntimeException
    //   1582	1590	3916	java/lang/RuntimeException
    //   1606	1610	3916	java/lang/RuntimeException
    //   1628	1635	3916	java/lang/RuntimeException
    //   1651	1658	3916	java/lang/RuntimeException
    //   1693	1709	3916	java/lang/RuntimeException
    //   1725	1731	3916	java/lang/RuntimeException
    //   1747	1755	3916	java/lang/RuntimeException
    //   1774	1784	3916	java/lang/RuntimeException
    //   1803	1809	3916	java/lang/RuntimeException
    //   1828	1872	3916	java/lang/RuntimeException
    //   1891	1896	3916	java/lang/RuntimeException
    //   1923	1934	3916	java/lang/RuntimeException
    //   2558	2567	3916	java/lang/RuntimeException
    //   2588	2597	3916	java/lang/RuntimeException
    //   2621	2637	3916	java/lang/RuntimeException
    //   2653	2661	3916	java/lang/RuntimeException
    //   2680	2690	3916	java/lang/RuntimeException
    //   2709	2715	3916	java/lang/RuntimeException
    //   2734	2762	3916	java/lang/RuntimeException
    //   2781	2786	3916	java/lang/RuntimeException
    //   2809	2816	3916	java/lang/RuntimeException
    //   2832	2839	3916	java/lang/RuntimeException
    //   2855	2864	3916	java/lang/RuntimeException
    //   2880	2896	3916	java/lang/RuntimeException
    //   2912	2917	3916	java/lang/RuntimeException
    //   2933	2949	3916	java/lang/RuntimeException
    //   3036	3041	3916	java/lang/RuntimeException
    //   3057	3061	3916	java/lang/RuntimeException
    //   3839	3843	3916	java/lang/RuntimeException
    //   3859	3864	3916	java/lang/RuntimeException
    //   59	65	3949	java/lang/UnsatisfiedLinkError
    //   81	88	3949	java/lang/UnsatisfiedLinkError
    //   120	131	3949	java/lang/UnsatisfiedLinkError
    //   147	152	3949	java/lang/UnsatisfiedLinkError
    //   178	188	3949	java/lang/UnsatisfiedLinkError
    //   204	209	3949	java/lang/UnsatisfiedLinkError
    //   225	231	3949	java/lang/UnsatisfiedLinkError
    //   247	304	3949	java/lang/UnsatisfiedLinkError
    //   320	325	3949	java/lang/UnsatisfiedLinkError
    //   349	363	3949	java/lang/UnsatisfiedLinkError
    //   379	385	3949	java/lang/UnsatisfiedLinkError
    //   401	434	3949	java/lang/UnsatisfiedLinkError
    //   450	459	3949	java/lang/UnsatisfiedLinkError
    //   483	492	3949	java/lang/UnsatisfiedLinkError
    //   512	518	3949	java/lang/UnsatisfiedLinkError
    //   538	566	3949	java/lang/UnsatisfiedLinkError
    //   591	598	3949	java/lang/UnsatisfiedLinkError
    //   618	625	3949	java/lang/UnsatisfiedLinkError
    //   645	654	3949	java/lang/UnsatisfiedLinkError
    //   674	690	3949	java/lang/UnsatisfiedLinkError
    //   710	726	3949	java/lang/UnsatisfiedLinkError
    //   873	879	3949	java/lang/UnsatisfiedLinkError
    //   899	926	3949	java/lang/UnsatisfiedLinkError
    //   987	996	3949	java/lang/UnsatisfiedLinkError
    //   1012	1021	3949	java/lang/UnsatisfiedLinkError
    //   1037	1045	3949	java/lang/UnsatisfiedLinkError
    //   1061	1078	3949	java/lang/UnsatisfiedLinkError
    //   1106	1117	3949	java/lang/UnsatisfiedLinkError
    //   1133	1139	3949	java/lang/UnsatisfiedLinkError
    //   1155	1209	3949	java/lang/UnsatisfiedLinkError
    //   1233	1237	3949	java/lang/UnsatisfiedLinkError
    //   1257	1261	3949	java/lang/UnsatisfiedLinkError
    //   1289	1300	3949	java/lang/UnsatisfiedLinkError
    //   1387	1392	3949	java/lang/UnsatisfiedLinkError
    //   1408	1414	3949	java/lang/UnsatisfiedLinkError
    //   1430	1442	3949	java/lang/UnsatisfiedLinkError
    //   1461	1466	3949	java/lang/UnsatisfiedLinkError
    //   1482	1488	3949	java/lang/UnsatisfiedLinkError
    //   1504	1516	3949	java/lang/UnsatisfiedLinkError
    //   1535	1544	3949	java/lang/UnsatisfiedLinkError
    //   1560	1566	3949	java/lang/UnsatisfiedLinkError
    //   1582	1590	3949	java/lang/UnsatisfiedLinkError
    //   1606	1610	3949	java/lang/UnsatisfiedLinkError
    //   1628	1635	3949	java/lang/UnsatisfiedLinkError
    //   1651	1658	3949	java/lang/UnsatisfiedLinkError
    //   1693	1709	3949	java/lang/UnsatisfiedLinkError
    //   1725	1731	3949	java/lang/UnsatisfiedLinkError
    //   1747	1755	3949	java/lang/UnsatisfiedLinkError
    //   1774	1784	3949	java/lang/UnsatisfiedLinkError
    //   1803	1809	3949	java/lang/UnsatisfiedLinkError
    //   1828	1872	3949	java/lang/UnsatisfiedLinkError
    //   1891	1896	3949	java/lang/UnsatisfiedLinkError
    //   1923	1934	3949	java/lang/UnsatisfiedLinkError
    //   2558	2567	3949	java/lang/UnsatisfiedLinkError
    //   2588	2597	3949	java/lang/UnsatisfiedLinkError
    //   2621	2637	3949	java/lang/UnsatisfiedLinkError
    //   2653	2661	3949	java/lang/UnsatisfiedLinkError
    //   2680	2690	3949	java/lang/UnsatisfiedLinkError
    //   2709	2715	3949	java/lang/UnsatisfiedLinkError
    //   2734	2762	3949	java/lang/UnsatisfiedLinkError
    //   2781	2786	3949	java/lang/UnsatisfiedLinkError
    //   2809	2816	3949	java/lang/UnsatisfiedLinkError
    //   2832	2839	3949	java/lang/UnsatisfiedLinkError
    //   2855	2864	3949	java/lang/UnsatisfiedLinkError
    //   2880	2896	3949	java/lang/UnsatisfiedLinkError
    //   2912	2917	3949	java/lang/UnsatisfiedLinkError
    //   2933	2949	3949	java/lang/UnsatisfiedLinkError
    //   3036	3041	3949	java/lang/UnsatisfiedLinkError
    //   3057	3061	3949	java/lang/UnsatisfiedLinkError
    //   3839	3843	3949	java/lang/UnsatisfiedLinkError
    //   3859	3864	3949	java/lang/UnsatisfiedLinkError
    //   59	65	3982	java/lang/Throwable
    //   81	88	3982	java/lang/Throwable
    //   120	131	3982	java/lang/Throwable
    //   147	152	3982	java/lang/Throwable
    //   178	188	3982	java/lang/Throwable
    //   204	209	3982	java/lang/Throwable
    //   225	231	3982	java/lang/Throwable
    //   247	304	3982	java/lang/Throwable
    //   320	325	3982	java/lang/Throwable
    //   349	363	3982	java/lang/Throwable
    //   379	385	3982	java/lang/Throwable
    //   401	434	3982	java/lang/Throwable
    //   450	459	3982	java/lang/Throwable
    //   987	996	3982	java/lang/Throwable
    //   1012	1021	3982	java/lang/Throwable
    //   1037	1045	3982	java/lang/Throwable
    //   1061	1078	3982	java/lang/Throwable
    //   1106	1117	3982	java/lang/Throwable
    //   1133	1139	3982	java/lang/Throwable
    //   1155	1209	3982	java/lang/Throwable
    //   1233	1237	3982	java/lang/Throwable
    //   1257	1261	3982	java/lang/Throwable
    //   1289	1300	3982	java/lang/Throwable
    //   1387	1392	3982	java/lang/Throwable
    //   1408	1414	3982	java/lang/Throwable
    //   1430	1442	3982	java/lang/Throwable
    //   1461	1466	3982	java/lang/Throwable
    //   1482	1488	3982	java/lang/Throwable
    //   1504	1516	3982	java/lang/Throwable
    //   1535	1544	3982	java/lang/Throwable
    //   1560	1566	3982	java/lang/Throwable
    //   1582	1590	3982	java/lang/Throwable
    //   1606	1610	3982	java/lang/Throwable
    //   1628	1635	3982	java/lang/Throwable
    //   1651	1658	3982	java/lang/Throwable
    //   1693	1709	3982	java/lang/Throwable
    //   1725	1731	3982	java/lang/Throwable
    //   1747	1755	3982	java/lang/Throwable
    //   1774	1784	3982	java/lang/Throwable
    //   1803	1809	3982	java/lang/Throwable
    //   1828	1872	3982	java/lang/Throwable
    //   1891	1896	3982	java/lang/Throwable
    //   1923	1934	3982	java/lang/Throwable
    //   2558	2567	3982	java/lang/Throwable
    //   2588	2597	3982	java/lang/Throwable
    //   2621	2637	3982	java/lang/Throwable
    //   2653	2661	3982	java/lang/Throwable
    //   2680	2690	3982	java/lang/Throwable
    //   2709	2715	3982	java/lang/Throwable
    //   2734	2762	3982	java/lang/Throwable
    //   2781	2786	3982	java/lang/Throwable
    //   2809	2816	3982	java/lang/Throwable
    //   2832	2839	3982	java/lang/Throwable
    //   2855	2864	3982	java/lang/Throwable
    //   2880	2896	3982	java/lang/Throwable
    //   2912	2917	3982	java/lang/Throwable
    //   2933	2949	3982	java/lang/Throwable
    //   3036	3041	3982	java/lang/Throwable
    //   3057	3061	3982	java/lang/Throwable
    //   3839	3843	3982	java/lang/Throwable
    //   3859	3864	3982	java/lang/Throwable
    //   1961	1970	4015	java/lang/Throwable
    //   2036	2044	4015	java/lang/Throwable
    //   2063	2070	4015	java/lang/Throwable
    //   2089	2095	4015	java/lang/Throwable
    //   2114	2142	4015	java/lang/Throwable
    //   2161	2166	4015	java/lang/Throwable
    //   2191	2199	4015	java/lang/Throwable
    //   2219	2234	4015	java/lang/Throwable
    //   2254	2263	4015	java/lang/Throwable
    //   2283	2294	4015	java/lang/Throwable
    //   2314	2333	4015	java/lang/Throwable
    //   2359	2378	4015	java/lang/Throwable
    //   2398	2409	4015	java/lang/Throwable
    //   2429	2445	4015	java/lang/Throwable
    //   3103	3107	4015	java/lang/Throwable
    //   3123	3128	4015	java/lang/Throwable
    //   3159	3167	4015	java/lang/Throwable
    //   3190	3197	4015	java/lang/Throwable
    //   3220	3226	4015	java/lang/Throwable
    //   3249	3277	4015	java/lang/Throwable
    //   3300	3305	4015	java/lang/Throwable
    //   3340	3349	4015	java/lang/Throwable
    //   3372	3388	4015	java/lang/Throwable
    //   3411	3420	4015	java/lang/Throwable
    //   3443	3455	4015	java/lang/Throwable
    //   3478	3498	4015	java/lang/Throwable
    //   3531	3551	4015	java/lang/Throwable
    //   3574	3586	4015	java/lang/Throwable
    //   3609	3629	4015	java/lang/Throwable
    //   3652	3657	4015	java/lang/Throwable
    //   3684	3690	4015	java/lang/Throwable
    //   3713	3754	4015	java/lang/Throwable
    //   3783	3788	4015	java/lang/Throwable
    //   3804	3808	4015	java/lang/Throwable
    //   2464	2469	4023	java/lang/Throwable
    //   2481	2487	4023	java/lang/Throwable
    //   2499	2540	4023	java/lang/Throwable
    //   2960	3007	4031	java/lang/Throwable
    //   726	773	4039	java/lang/UnsatisfiedLinkError
    //   773	794	4039	java/lang/UnsatisfiedLinkError
    //   812	824	4039	java/lang/UnsatisfiedLinkError
    //   829	846	4039	java/lang/UnsatisfiedLinkError
    //   938	943	4047	java/lang/UnsatisfiedLinkError
    //   2464	2469	4047	java/lang/UnsatisfiedLinkError
    //   2481	2487	4047	java/lang/UnsatisfiedLinkError
    //   2499	2540	4047	java/lang/UnsatisfiedLinkError
    //   1961	1970	4055	java/lang/UnsatisfiedLinkError
    //   2036	2044	4055	java/lang/UnsatisfiedLinkError
    //   2063	2070	4055	java/lang/UnsatisfiedLinkError
    //   2089	2095	4055	java/lang/UnsatisfiedLinkError
    //   2114	2142	4055	java/lang/UnsatisfiedLinkError
    //   2161	2166	4055	java/lang/UnsatisfiedLinkError
    //   2191	2199	4055	java/lang/UnsatisfiedLinkError
    //   2219	2234	4055	java/lang/UnsatisfiedLinkError
    //   2254	2263	4055	java/lang/UnsatisfiedLinkError
    //   2283	2294	4055	java/lang/UnsatisfiedLinkError
    //   2314	2333	4055	java/lang/UnsatisfiedLinkError
    //   2359	2378	4055	java/lang/UnsatisfiedLinkError
    //   2398	2409	4055	java/lang/UnsatisfiedLinkError
    //   2429	2445	4055	java/lang/UnsatisfiedLinkError
    //   3103	3107	4055	java/lang/UnsatisfiedLinkError
    //   3123	3128	4055	java/lang/UnsatisfiedLinkError
    //   3159	3167	4055	java/lang/UnsatisfiedLinkError
    //   3190	3197	4055	java/lang/UnsatisfiedLinkError
    //   3220	3226	4055	java/lang/UnsatisfiedLinkError
    //   3249	3277	4055	java/lang/UnsatisfiedLinkError
    //   3300	3305	4055	java/lang/UnsatisfiedLinkError
    //   3340	3349	4055	java/lang/UnsatisfiedLinkError
    //   3372	3388	4055	java/lang/UnsatisfiedLinkError
    //   3411	3420	4055	java/lang/UnsatisfiedLinkError
    //   3443	3455	4055	java/lang/UnsatisfiedLinkError
    //   3478	3498	4055	java/lang/UnsatisfiedLinkError
    //   3531	3551	4055	java/lang/UnsatisfiedLinkError
    //   3574	3586	4055	java/lang/UnsatisfiedLinkError
    //   3609	3629	4055	java/lang/UnsatisfiedLinkError
    //   3652	3657	4055	java/lang/UnsatisfiedLinkError
    //   3684	3690	4055	java/lang/UnsatisfiedLinkError
    //   3713	3754	4055	java/lang/UnsatisfiedLinkError
    //   3783	3788	4055	java/lang/UnsatisfiedLinkError
    //   3804	3808	4055	java/lang/UnsatisfiedLinkError
    //   2960	3007	4059	java/lang/UnsatisfiedLinkError
    //   726	773	4067	java/lang/RuntimeException
    //   773	794	4067	java/lang/RuntimeException
    //   812	824	4067	java/lang/RuntimeException
    //   829	846	4067	java/lang/RuntimeException
    //   938	943	4075	java/lang/RuntimeException
    //   2464	2469	4075	java/lang/RuntimeException
    //   2481	2487	4075	java/lang/RuntimeException
    //   2499	2540	4075	java/lang/RuntimeException
    //   1961	1970	4079	java/lang/RuntimeException
    //   2036	2044	4079	java/lang/RuntimeException
    //   2063	2070	4079	java/lang/RuntimeException
    //   2089	2095	4079	java/lang/RuntimeException
    //   2114	2142	4079	java/lang/RuntimeException
    //   2161	2166	4079	java/lang/RuntimeException
    //   2191	2199	4079	java/lang/RuntimeException
    //   2219	2234	4079	java/lang/RuntimeException
    //   2254	2263	4079	java/lang/RuntimeException
    //   2283	2294	4079	java/lang/RuntimeException
    //   2314	2333	4079	java/lang/RuntimeException
    //   2359	2378	4079	java/lang/RuntimeException
    //   2398	2409	4079	java/lang/RuntimeException
    //   2429	2445	4079	java/lang/RuntimeException
    //   3103	3107	4079	java/lang/RuntimeException
    //   3123	3128	4079	java/lang/RuntimeException
    //   3159	3167	4079	java/lang/RuntimeException
    //   3190	3197	4079	java/lang/RuntimeException
    //   3220	3226	4079	java/lang/RuntimeException
    //   3249	3277	4079	java/lang/RuntimeException
    //   3300	3305	4079	java/lang/RuntimeException
    //   3340	3349	4079	java/lang/RuntimeException
    //   3372	3388	4079	java/lang/RuntimeException
    //   3411	3420	4079	java/lang/RuntimeException
    //   3443	3455	4079	java/lang/RuntimeException
    //   3478	3498	4079	java/lang/RuntimeException
    //   3531	3551	4079	java/lang/RuntimeException
    //   3574	3586	4079	java/lang/RuntimeException
    //   3609	3629	4079	java/lang/RuntimeException
    //   3652	3657	4079	java/lang/RuntimeException
    //   3684	3690	4079	java/lang/RuntimeException
    //   3713	3754	4079	java/lang/RuntimeException
    //   3783	3788	4079	java/lang/RuntimeException
    //   3804	3808	4079	java/lang/RuntimeException
    //   2960	3007	4087	java/lang/RuntimeException
    //   726	773	4095	java/io/IOException
    //   773	794	4095	java/io/IOException
    //   812	824	4095	java/io/IOException
    //   829	846	4095	java/io/IOException
    //   938	943	4103	java/io/IOException
    //   2464	2469	4103	java/io/IOException
    //   2481	2487	4103	java/io/IOException
    //   2499	2540	4103	java/io/IOException
    //   1961	1970	4111	java/io/IOException
    //   2036	2044	4111	java/io/IOException
    //   2063	2070	4111	java/io/IOException
    //   2089	2095	4111	java/io/IOException
    //   2114	2142	4111	java/io/IOException
    //   2161	2166	4111	java/io/IOException
    //   2191	2199	4111	java/io/IOException
    //   2219	2234	4111	java/io/IOException
    //   2254	2263	4111	java/io/IOException
    //   2283	2294	4111	java/io/IOException
    //   2314	2333	4111	java/io/IOException
    //   2359	2378	4111	java/io/IOException
    //   2398	2409	4111	java/io/IOException
    //   2429	2445	4111	java/io/IOException
    //   3103	3107	4111	java/io/IOException
    //   3123	3128	4111	java/io/IOException
    //   3159	3167	4111	java/io/IOException
    //   3190	3197	4111	java/io/IOException
    //   3220	3226	4111	java/io/IOException
    //   3249	3277	4111	java/io/IOException
    //   3300	3305	4111	java/io/IOException
    //   3340	3349	4111	java/io/IOException
    //   3372	3388	4111	java/io/IOException
    //   3411	3420	4111	java/io/IOException
    //   3443	3455	4111	java/io/IOException
    //   3478	3498	4111	java/io/IOException
    //   3531	3551	4111	java/io/IOException
    //   3574	3586	4111	java/io/IOException
    //   3609	3629	4111	java/io/IOException
    //   3652	3657	4111	java/io/IOException
    //   3684	3690	4111	java/io/IOException
    //   3713	3754	4111	java/io/IOException
    //   3783	3788	4111	java/io/IOException
    //   3804	3808	4111	java/io/IOException
    //   2960	3007	4119	java/io/IOException
    //   2809	2816	4127	java/lang/OutOfMemoryError
    //   2832	2839	4127	java/lang/OutOfMemoryError
    //   2855	2864	4127	java/lang/OutOfMemoryError
    //   2880	2896	4127	java/lang/OutOfMemoryError
    //   2912	2917	4127	java/lang/OutOfMemoryError
    //   2933	2949	4127	java/lang/OutOfMemoryError
    //   2960	3007	4134	java/lang/OutOfMemoryError
    //   2191	2199	4141	java/lang/OutOfMemoryError
    //   2219	2234	4141	java/lang/OutOfMemoryError
    //   2254	2263	4141	java/lang/OutOfMemoryError
    //   2283	2294	4141	java/lang/OutOfMemoryError
    //   2314	2333	4141	java/lang/OutOfMemoryError
    //   2359	2378	4141	java/lang/OutOfMemoryError
    //   2398	2409	4141	java/lang/OutOfMemoryError
    //   2429	2445	4141	java/lang/OutOfMemoryError
    //   2464	2469	4152	java/lang/OutOfMemoryError
    //   2481	2487	4152	java/lang/OutOfMemoryError
    //   2499	2540	4152	java/lang/OutOfMemoryError
    //   726	773	4159	java/lang/Throwable
    //   773	794	4159	java/lang/Throwable
    //   812	824	4159	java/lang/Throwable
    //   829	846	4159	java/lang/Throwable
    //   938	943	4164	java/lang/Throwable
    //   726	773	4169	java/lang/OutOfMemoryError
    //   773	794	4169	java/lang/OutOfMemoryError
    //   812	824	4169	java/lang/OutOfMemoryError
    //   829	846	4169	java/lang/OutOfMemoryError
    //   938	943	4174	java/lang/OutOfMemoryError
    //   483	492	4225	java/lang/Throwable
    //   512	518	4225	java/lang/Throwable
    //   538	566	4225	java/lang/Throwable
    //   591	598	4225	java/lang/Throwable
    //   618	625	4225	java/lang/Throwable
    //   645	654	4225	java/lang/Throwable
    //   674	690	4225	java/lang/Throwable
    //   710	726	4225	java/lang/Throwable
    //   873	879	4225	java/lang/Throwable
    //   899	926	4225	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bcof.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bcof.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = akux.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (akux.a(paramArrayOfInt))
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
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   15: lstore 10
    //   17: iconst_m1
    //   18: istore 4
    //   20: aload_1
    //   21: invokevirtual 279	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   24: astore 14
    //   26: aload 14
    //   28: aload_0
    //   29: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +1833 -> 1867
    //   37: iconst_2
    //   38: iconst_0
    //   39: ldc 163
    //   41: ldc 165
    //   43: invokestatic 170	bcof:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   46: istore 5
    //   48: iconst_2
    //   49: newarray int
    //   51: astore 12
    //   53: aload 12
    //   55: iconst_0
    //   56: iconst_2
    //   57: iastore
    //   58: aload 12
    //   60: iconst_1
    //   61: iconst_0
    //   62: iastore
    //   63: aload 12
    //   65: aload 12
    //   67: arraylength
    //   68: invokestatic 173	bcof:a	([II)I
    //   71: istore 6
    //   73: invokestatic 175	bcof:a	()Ljava/lang/String;
    //   76: astore 12
    //   78: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   81: ifeq +60 -> 141
    //   84: ldc 71
    //   86: iconst_4
    //   87: new 136	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 396
    //   97: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 5
    //   102: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 189
    //   107: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 6
    //   112: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc 191
    //   117: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 12
    //   122: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 289
    //   128: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: iload_3
    //   132: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: iload_3
    //   142: ifeq +299 -> 441
    //   145: aload_0
    //   146: invokevirtual 297	android/net/Uri:getPath	()Ljava/lang/String;
    //   149: invokestatic 303	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   152: astore_0
    //   153: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   156: ifeq +29 -> 185
    //   159: ldc 71
    //   161: iconst_4
    //   162: new 136	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 305
    //   172: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: ifnull +1675 -> 1861
    //   189: aload_0
    //   190: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   193: istore 5
    //   195: aload_0
    //   196: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   199: istore 6
    //   201: iload 5
    //   203: iload 6
    //   205: imul
    //   206: newarray int
    //   208: astore 12
    //   210: aload_0
    //   211: aload 12
    //   213: iconst_0
    //   214: iload 5
    //   216: iconst_0
    //   217: iconst_0
    //   218: iload 5
    //   220: iload 6
    //   222: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   225: aload_0
    //   226: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   229: aload 12
    //   231: aconst_null
    //   232: iload 5
    //   234: iload 6
    //   236: invokestatic 398	vup:a	([I[BII)I
    //   239: istore 5
    //   241: iload 5
    //   243: istore 4
    //   245: iload 4
    //   247: istore 5
    //   249: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   252: ifeq +34 -> 286
    //   255: ldc 71
    //   257: iconst_4
    //   258: new 136	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 400
    //   268: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: iload 4
    //   273: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: iload 4
    //   284: istore 5
    //   286: iload 5
    //   288: istore 4
    //   290: aload_1
    //   291: astore 12
    //   293: iload 4
    //   295: iconst_1
    //   296: if_icmpne +1551 -> 1847
    //   299: iload_2
    //   300: ifeq +1351 -> 1651
    //   303: new 136	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   310: astore_0
    //   311: new 136	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   318: astore_1
    //   319: aload_0
    //   320: aload_1
    //   321: invokestatic 225	bcof:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   324: pop
    //   325: new 227	android/util/Pair
    //   328: dup
    //   329: aload_1
    //   330: aload_0
    //   331: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   334: astore_0
    //   335: invokestatic 239	bcof:a	()I
    //   338: pop
    //   339: aload_0
    //   340: astore_1
    //   341: aload 12
    //   343: ifnull +10 -> 353
    //   346: aload 12
    //   348: invokevirtual 320	java/io/InputStream:close	()V
    //   351: aload_0
    //   352: astore_1
    //   353: aload_1
    //   354: astore_0
    //   355: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   358: ifeq -348 -> 10
    //   361: ldc 71
    //   363: iconst_4
    //   364: new 136	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 402
    //   374: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   380: lload 10
    //   382: lsub
    //   383: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_1
    //   393: areturn
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   399: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +1470 -> 1872
    //   405: ldc 71
    //   407: iconst_2
    //   408: aload_0
    //   409: invokevirtual 326	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   412: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto +1457 -> 1872
    //   418: aload_0
    //   419: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   422: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +1457 -> 1882
    //   428: ldc 71
    //   430: iconst_2
    //   431: aload_0
    //   432: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   435: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: goto +1444 -> 1882
    //   441: new 328	android/graphics/BitmapFactory$Options
    //   444: dup
    //   445: invokespecial 329	android/graphics/BitmapFactory$Options:<init>	()V
    //   448: astore 15
    //   450: aload 15
    //   452: iconst_1
    //   453: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   456: aload_1
    //   457: aconst_null
    //   458: aload 15
    //   460: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   463: pop
    //   464: aload_1
    //   465: invokevirtual 320	java/io/InputStream:close	()V
    //   468: aconst_null
    //   469: astore_1
    //   470: aload 15
    //   472: getfield 342	android/graphics/BitmapFactory$Options:outWidth	I
    //   475: istore 7
    //   477: aload 15
    //   479: getfield 345	android/graphics/BitmapFactory$Options:outHeight	I
    //   482: istore 8
    //   484: aload 15
    //   486: iconst_0
    //   487: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   490: iload 7
    //   492: sipush 12800
    //   495: if_icmpgt +1393 -> 1888
    //   498: iload 8
    //   500: sipush 12800
    //   503: if_icmple +6 -> 509
    //   506: goto +1382 -> 1888
    //   509: iload 7
    //   511: iload 8
    //   513: imul
    //   514: ldc_w 403
    //   517: if_icmple +745 -> 1262
    //   520: aload 15
    //   522: iload 7
    //   524: iload 8
    //   526: imul
    //   527: i2d
    //   528: invokestatic 406	java/lang/Math:sqrt	(D)D
    //   531: ldc2_w 407
    //   534: ddiv
    //   535: invokestatic 222	java/lang/Math:ceil	(D)D
    //   538: d2i
    //   539: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   542: aload 14
    //   544: aload_0
    //   545: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   548: astore 12
    //   550: aload 12
    //   552: astore_1
    //   553: aload 12
    //   555: aconst_null
    //   556: aload 15
    //   558: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   561: astore 13
    //   563: aload 12
    //   565: astore_1
    //   566: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   569: ifeq +69 -> 638
    //   572: aload 12
    //   574: astore_1
    //   575: ldc 71
    //   577: iconst_4
    //   578: new 136	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 410
    //   588: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 13
    //   593: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: ldc_w 412
    //   599: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 7
    //   604: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: ldc_w 414
    //   610: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: iload 8
    //   615: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: ldc_w 416
    //   621: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload 15
    //   626: getfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   629: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload 12
    //   640: astore_1
    //   641: aload 12
    //   643: invokevirtual 320	java/io/InputStream:close	()V
    //   646: iload 4
    //   648: istore 6
    //   650: aload 13
    //   652: ifnull +129 -> 781
    //   655: iload 4
    //   657: istore 5
    //   659: aload 13
    //   661: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   664: istore 6
    //   666: iload 4
    //   668: istore 5
    //   670: aload 13
    //   672: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   675: istore 9
    //   677: iload 4
    //   679: istore 5
    //   681: iload 6
    //   683: iload 9
    //   685: imul
    //   686: newarray int
    //   688: astore_1
    //   689: iload 4
    //   691: istore 5
    //   693: aload 13
    //   695: aload_1
    //   696: iconst_0
    //   697: iload 6
    //   699: iconst_0
    //   700: iconst_0
    //   701: iload 6
    //   703: iload 9
    //   705: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   708: iload 4
    //   710: istore 5
    //   712: aload 13
    //   714: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   717: iload 4
    //   719: istore 5
    //   721: aload_1
    //   722: aconst_null
    //   723: iload 6
    //   725: iload 9
    //   727: invokestatic 398	vup:a	([I[BII)I
    //   730: istore 4
    //   732: iload 4
    //   734: istore 6
    //   736: iload 4
    //   738: istore 5
    //   740: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   743: ifeq +38 -> 781
    //   746: iload 4
    //   748: istore 5
    //   750: ldc 71
    //   752: iconst_4
    //   753: new 136	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   760: ldc_w 418
    //   763: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: iload 4
    //   768: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: iload 4
    //   779: istore 6
    //   781: iload 6
    //   783: istore 4
    //   785: aconst_null
    //   786: astore 12
    //   788: aconst_null
    //   789: astore_1
    //   790: iload 4
    //   792: istore 5
    //   794: iload 4
    //   796: iconst_1
    //   797: if_icmpeq +234 -> 1031
    //   800: iload 7
    //   802: iconst_2
    //   803: imul
    //   804: iload 8
    //   806: if_icmpgt +534 -> 1340
    //   809: iload 7
    //   811: sipush 1280
    //   814: if_icmpge +526 -> 1340
    //   817: aload 14
    //   819: aload_0
    //   820: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   823: astore_1
    //   824: aload_1
    //   825: astore 12
    //   827: aload_1
    //   828: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   831: astore 13
    //   833: aload_1
    //   834: astore 12
    //   836: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   839: ifeq +33 -> 872
    //   842: aload_1
    //   843: astore 12
    //   845: ldc 71
    //   847: iconst_4
    //   848: new 136	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 420
    //   858: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload 13
    //   863: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload_1
    //   873: astore 12
    //   875: aload_1
    //   876: invokevirtual 320	java/io/InputStream:close	()V
    //   879: aload 13
    //   881: ifnull +977 -> 1858
    //   884: iload 4
    //   886: istore 5
    //   888: iload 7
    //   890: iload 7
    //   892: imul
    //   893: newarray int
    //   895: astore_1
    //   896: iload 4
    //   898: istore 5
    //   900: aload 13
    //   902: aload_1
    //   903: iconst_0
    //   904: iload 7
    //   906: iconst_0
    //   907: iconst_0
    //   908: iload 7
    //   910: iload 7
    //   912: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   915: iload 4
    //   917: istore 5
    //   919: iload 7
    //   921: iload 7
    //   923: imul
    //   924: newarray byte
    //   926: astore 12
    //   928: iload 4
    //   930: istore 5
    //   932: aload_1
    //   933: aload 12
    //   935: iload 7
    //   937: iload 7
    //   939: invokestatic 398	vup:a	([I[BII)I
    //   942: istore 4
    //   944: iload 4
    //   946: iconst_1
    //   947: if_icmpeq +908 -> 1855
    //   950: iload 4
    //   952: istore 5
    //   954: aload 13
    //   956: aload_1
    //   957: iconst_0
    //   958: iload 7
    //   960: iconst_0
    //   961: iload 8
    //   963: iload 7
    //   965: isub
    //   966: iload 7
    //   968: iload 7
    //   970: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   973: iload 4
    //   975: istore 5
    //   977: aload_1
    //   978: aload 12
    //   980: iload 7
    //   982: iload 7
    //   984: invokestatic 398	vup:a	([I[BII)I
    //   987: istore 4
    //   989: aload 13
    //   991: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   994: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   997: ifeq +30 -> 1027
    //   1000: ldc 71
    //   1002: iconst_4
    //   1003: new 136	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1010: ldc_w 422
    //   1013: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: iload 4
    //   1018: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: iload 4
    //   1029: istore 5
    //   1031: aconst_null
    //   1032: astore 13
    //   1034: aconst_null
    //   1035: astore_1
    //   1036: aload_1
    //   1037: astore 12
    //   1039: iload 5
    //   1041: istore 4
    //   1043: iload 5
    //   1045: iconst_1
    //   1046: if_icmpeq -753 -> 293
    //   1049: iload 7
    //   1051: iload 8
    //   1053: invokestatic 216	java/lang/Math:min	(II)I
    //   1056: istore 6
    //   1058: aload_1
    //   1059: astore 12
    //   1061: iload 5
    //   1063: istore 4
    //   1065: iload 6
    //   1067: sipush 250
    //   1070: if_icmple -777 -> 293
    //   1073: aload 15
    //   1075: iload 6
    //   1077: i2d
    //   1078: ldc2_w 217
    //   1081: ddiv
    //   1082: invokestatic 222	java/lang/Math:ceil	(D)D
    //   1085: d2i
    //   1086: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1089: aload 13
    //   1091: astore_1
    //   1092: aload 14
    //   1094: aload_0
    //   1095: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1098: astore_0
    //   1099: aload_0
    //   1100: astore_1
    //   1101: aload_0
    //   1102: aconst_null
    //   1103: aload 15
    //   1105: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1108: astore 12
    //   1110: aload_0
    //   1111: astore_1
    //   1112: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1115: ifeq +32 -> 1147
    //   1118: aload_0
    //   1119: astore_1
    //   1120: ldc 71
    //   1122: iconst_4
    //   1123: new 136	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1130: ldc_w 424
    //   1133: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload 12
    //   1138: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1141: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1147: aload_0
    //   1148: astore_1
    //   1149: aload_0
    //   1150: invokevirtual 320	java/io/InputStream:close	()V
    //   1153: aload 12
    //   1155: ifnull +697 -> 1852
    //   1158: aload 12
    //   1160: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   1163: istore 4
    //   1165: aload 12
    //   1167: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   1170: istore 6
    //   1172: iload 4
    //   1174: iload 6
    //   1176: imul
    //   1177: newarray int
    //   1179: astore_0
    //   1180: aload 12
    //   1182: aload_0
    //   1183: iconst_0
    //   1184: iload 4
    //   1186: iconst_0
    //   1187: iconst_0
    //   1188: iload 4
    //   1190: iload 6
    //   1192: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1195: aload 12
    //   1197: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   1200: aload_0
    //   1201: aconst_null
    //   1202: iload 4
    //   1204: iload 6
    //   1206: invokestatic 398	vup:a	([I[BII)I
    //   1209: istore 4
    //   1211: iload 4
    //   1213: istore 5
    //   1215: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1218: ifeq +34 -> 1252
    //   1221: ldc 71
    //   1223: iconst_4
    //   1224: new 136	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1231: ldc_w 426
    //   1234: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: iload 4
    //   1239: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1242: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1245: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1248: iload 4
    //   1250: istore 5
    //   1252: aconst_null
    //   1253: astore 12
    //   1255: iload 5
    //   1257: istore 4
    //   1259: goto -966 -> 293
    //   1262: aload 15
    //   1264: iconst_1
    //   1265: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1268: goto -726 -> 542
    //   1271: astore 12
    //   1273: aconst_null
    //   1274: astore_0
    //   1275: aload 12
    //   1277: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   1280: aload_0
    //   1281: astore_1
    //   1282: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1285: ifeq -932 -> 353
    //   1288: ldc 71
    //   1290: iconst_2
    //   1291: aload 12
    //   1293: invokevirtual 372	java/io/IOException:toString	()Ljava/lang/String;
    //   1296: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1299: aload_0
    //   1300: astore_1
    //   1301: goto -948 -> 353
    //   1304: astore 13
    //   1306: aload_1
    //   1307: astore 12
    //   1309: aload 13
    //   1311: astore_1
    //   1312: aload_1
    //   1313: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1316: aload 12
    //   1318: invokevirtual 320	java/io/InputStream:close	()V
    //   1321: goto -536 -> 785
    //   1324: aload_1
    //   1325: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1328: aload 12
    //   1330: invokevirtual 320	java/io/InputStream:close	()V
    //   1333: iload 4
    //   1335: istore 5
    //   1337: goto -306 -> 1031
    //   1340: iload 4
    //   1342: istore 5
    //   1344: iload 7
    //   1346: iload 8
    //   1348: iconst_2
    //   1349: imul
    //   1350: if_icmplt -319 -> 1031
    //   1353: iload 4
    //   1355: istore 5
    //   1357: iload 8
    //   1359: sipush 1280
    //   1362: if_icmpge -331 -> 1031
    //   1365: aload 14
    //   1367: aload_0
    //   1368: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1371: astore 12
    //   1373: aload 12
    //   1375: astore_1
    //   1376: aload 12
    //   1378: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1381: astore 13
    //   1383: aload 12
    //   1385: astore_1
    //   1386: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1389: ifeq +33 -> 1422
    //   1392: aload 12
    //   1394: astore_1
    //   1395: ldc 71
    //   1397: iconst_4
    //   1398: new 136	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1405: ldc_w 428
    //   1408: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: aload 13
    //   1413: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1422: aload 12
    //   1424: astore_1
    //   1425: aload 12
    //   1427: invokevirtual 320	java/io/InputStream:close	()V
    //   1430: iload 4
    //   1432: istore 6
    //   1434: aload 13
    //   1436: ifnull +170 -> 1606
    //   1439: iload 4
    //   1441: istore 5
    //   1443: iload 8
    //   1445: iload 8
    //   1447: imul
    //   1448: newarray int
    //   1450: astore_1
    //   1451: iload 4
    //   1453: istore 5
    //   1455: aload 13
    //   1457: aload_1
    //   1458: iconst_0
    //   1459: iload 8
    //   1461: iconst_0
    //   1462: iconst_0
    //   1463: iload 8
    //   1465: iload 8
    //   1467: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1470: iload 4
    //   1472: istore 5
    //   1474: iload 8
    //   1476: iload 8
    //   1478: imul
    //   1479: newarray byte
    //   1481: astore 12
    //   1483: iload 4
    //   1485: istore 5
    //   1487: aload_1
    //   1488: aload 12
    //   1490: iload 8
    //   1492: iload 8
    //   1494: invokestatic 398	vup:a	([I[BII)I
    //   1497: istore 6
    //   1499: iload 6
    //   1501: istore 4
    //   1503: iload 6
    //   1505: iconst_1
    //   1506: if_icmpeq +42 -> 1548
    //   1509: iload 6
    //   1511: istore 5
    //   1513: aload 13
    //   1515: aload_1
    //   1516: iconst_0
    //   1517: iload 8
    //   1519: iload 7
    //   1521: iload 8
    //   1523: isub
    //   1524: iconst_0
    //   1525: iload 8
    //   1527: iload 8
    //   1529: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1532: iload 6
    //   1534: istore 5
    //   1536: aload_1
    //   1537: aload 12
    //   1539: iload 8
    //   1541: iload 8
    //   1543: invokestatic 398	vup:a	([I[BII)I
    //   1546: istore 4
    //   1548: iload 4
    //   1550: istore 5
    //   1552: aload 13
    //   1554: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   1557: iload 4
    //   1559: istore 6
    //   1561: iload 4
    //   1563: istore 5
    //   1565: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1568: ifeq +38 -> 1606
    //   1571: iload 4
    //   1573: istore 5
    //   1575: ldc 71
    //   1577: iconst_4
    //   1578: new 136	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1585: ldc_w 430
    //   1588: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: iload 4
    //   1593: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1602: iload 4
    //   1604: istore 6
    //   1606: iload 6
    //   1608: istore 5
    //   1610: goto -579 -> 1031
    //   1613: astore 13
    //   1615: aload_1
    //   1616: astore 12
    //   1618: aload 13
    //   1620: astore_1
    //   1621: aload_1
    //   1622: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1625: aload 12
    //   1627: invokevirtual 320	java/io/InputStream:close	()V
    //   1630: iload 4
    //   1632: istore 5
    //   1634: goto -603 -> 1031
    //   1637: aload_0
    //   1638: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1641: aload_1
    //   1642: invokevirtual 320	java/io/InputStream:close	()V
    //   1645: aconst_null
    //   1646: astore 12
    //   1648: goto -1355 -> 293
    //   1651: new 227	android/util/Pair
    //   1654: dup
    //   1655: aconst_null
    //   1656: aconst_null
    //   1657: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1660: astore_0
    //   1661: goto -1326 -> 335
    //   1664: astore 12
    //   1666: aconst_null
    //   1667: astore_0
    //   1668: aload 12
    //   1670: invokevirtual 250	java/lang/RuntimeException:printStackTrace	()V
    //   1673: aload_0
    //   1674: astore_1
    //   1675: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq -1325 -> 353
    //   1681: ldc 71
    //   1683: iconst_2
    //   1684: aload 12
    //   1686: invokevirtual 251	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1689: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1692: aload_0
    //   1693: astore_1
    //   1694: goto -1341 -> 353
    //   1697: astore 12
    //   1699: aconst_null
    //   1700: astore_0
    //   1701: aload 12
    //   1703: invokevirtual 255	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1706: aload_0
    //   1707: astore_1
    //   1708: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1711: ifeq -1358 -> 353
    //   1714: ldc 71
    //   1716: iconst_2
    //   1717: aload 12
    //   1719: invokevirtual 256	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1722: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1725: aload_0
    //   1726: astore_1
    //   1727: goto -1374 -> 353
    //   1730: astore 12
    //   1732: aconst_null
    //   1733: astore_0
    //   1734: aload 12
    //   1736: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   1739: aload_0
    //   1740: astore_1
    //   1741: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1744: ifeq -1391 -> 353
    //   1747: ldc 71
    //   1749: iconst_2
    //   1750: aload 12
    //   1752: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1755: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1758: aload_0
    //   1759: astore_1
    //   1760: goto -1407 -> 353
    //   1763: astore 12
    //   1765: goto -31 -> 1734
    //   1768: astore 12
    //   1770: goto -69 -> 1701
    //   1773: astore 12
    //   1775: goto -107 -> 1668
    //   1778: astore 12
    //   1780: goto -505 -> 1275
    //   1783: astore_0
    //   1784: aconst_null
    //   1785: astore_1
    //   1786: iload 5
    //   1788: istore 4
    //   1790: goto -153 -> 1637
    //   1793: astore_0
    //   1794: aconst_null
    //   1795: astore_1
    //   1796: goto -159 -> 1637
    //   1799: astore_1
    //   1800: aconst_null
    //   1801: astore 12
    //   1803: iload 5
    //   1805: istore 4
    //   1807: goto -186 -> 1621
    //   1810: astore_1
    //   1811: aconst_null
    //   1812: astore 12
    //   1814: iload 5
    //   1816: istore 4
    //   1818: goto -494 -> 1324
    //   1821: astore_1
    //   1822: aconst_null
    //   1823: astore 12
    //   1825: goto -501 -> 1324
    //   1828: astore_1
    //   1829: aconst_null
    //   1830: astore 12
    //   1832: iload 5
    //   1834: istore 4
    //   1836: goto -524 -> 1312
    //   1839: astore_0
    //   1840: goto -1422 -> 418
    //   1843: astore_0
    //   1844: goto -1449 -> 395
    //   1847: aconst_null
    //   1848: astore_0
    //   1849: goto -1514 -> 335
    //   1852: goto -600 -> 1252
    //   1855: goto -866 -> 989
    //   1858: goto -831 -> 1027
    //   1861: iconst_m1
    //   1862: istore 5
    //   1864: goto -1578 -> 286
    //   1867: aconst_null
    //   1868: astore_1
    //   1869: goto -1516 -> 353
    //   1872: aload_1
    //   1873: astore 12
    //   1875: goto -1582 -> 293
    //   1878: astore_0
    //   1879: goto -1461 -> 418
    //   1882: aload_1
    //   1883: astore 12
    //   1885: goto -1592 -> 293
    //   1888: aconst_null
    //   1889: areturn
    //   1890: astore_1
    //   1891: goto -567 -> 1324
    //   1894: astore_0
    //   1895: iload 5
    //   1897: istore 4
    //   1899: goto -262 -> 1637
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1902	0	paramUri	Uri
    //   0	1902	1	paramContext	Context
    //   0	1902	2	paramBoolean1	boolean
    //   0	1902	3	paramBoolean2	boolean
    //   18	1880	4	i	int
    //   46	1850	5	j	int
    //   71	1536	6	k	int
    //   475	1049	7	m	int
    //   482	1060	8	n	int
    //   675	51	9	i1	int
    //   15	366	10	l	long
    //   51	1203	12	localObject1	Object
    //   1271	21	12	localIOException1	java.io.IOException
    //   1307	340	12	localObject2	Object
    //   1664	21	12	localRuntimeException1	RuntimeException
    //   1697	21	12	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   1730	21	12	localThrowable1	Throwable
    //   1763	1	12	localThrowable2	Throwable
    //   1768	1	12	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   1773	1	12	localRuntimeException2	RuntimeException
    //   1778	1	12	localIOException2	java.io.IOException
    //   1801	83	12	localContext	Context
    //   561	529	13	localBitmap1	Bitmap
    //   1304	6	13	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1381	172	13	localBitmap2	Bitmap
    //   1613	6	13	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   24	1342	14	localContentResolver	android.content.ContentResolver
    //   448	815	15	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   145	185	394	java/lang/OutOfMemoryError
    //   189	241	394	java/lang/OutOfMemoryError
    //   20	33	1271	java/io/IOException
    //   37	53	1271	java/io/IOException
    //   63	141	1271	java/io/IOException
    //   145	185	1271	java/io/IOException
    //   189	241	1271	java/io/IOException
    //   249	282	1271	java/io/IOException
    //   303	335	1271	java/io/IOException
    //   395	415	1271	java/io/IOException
    //   418	438	1271	java/io/IOException
    //   441	468	1271	java/io/IOException
    //   470	490	1271	java/io/IOException
    //   520	542	1271	java/io/IOException
    //   542	550	1271	java/io/IOException
    //   553	563	1271	java/io/IOException
    //   566	572	1271	java/io/IOException
    //   575	638	1271	java/io/IOException
    //   641	646	1271	java/io/IOException
    //   659	666	1271	java/io/IOException
    //   670	677	1271	java/io/IOException
    //   681	689	1271	java/io/IOException
    //   693	708	1271	java/io/IOException
    //   712	717	1271	java/io/IOException
    //   721	732	1271	java/io/IOException
    //   740	746	1271	java/io/IOException
    //   750	777	1271	java/io/IOException
    //   817	824	1271	java/io/IOException
    //   827	833	1271	java/io/IOException
    //   836	842	1271	java/io/IOException
    //   845	872	1271	java/io/IOException
    //   875	879	1271	java/io/IOException
    //   888	896	1271	java/io/IOException
    //   900	915	1271	java/io/IOException
    //   919	928	1271	java/io/IOException
    //   932	944	1271	java/io/IOException
    //   954	973	1271	java/io/IOException
    //   977	989	1271	java/io/IOException
    //   989	1027	1271	java/io/IOException
    //   1049	1058	1271	java/io/IOException
    //   1073	1089	1271	java/io/IOException
    //   1092	1099	1271	java/io/IOException
    //   1101	1110	1271	java/io/IOException
    //   1112	1118	1271	java/io/IOException
    //   1120	1147	1271	java/io/IOException
    //   1149	1153	1271	java/io/IOException
    //   1158	1211	1271	java/io/IOException
    //   1215	1248	1271	java/io/IOException
    //   1262	1268	1271	java/io/IOException
    //   1312	1321	1271	java/io/IOException
    //   1324	1333	1271	java/io/IOException
    //   1365	1373	1271	java/io/IOException
    //   1376	1383	1271	java/io/IOException
    //   1386	1392	1271	java/io/IOException
    //   1395	1422	1271	java/io/IOException
    //   1425	1430	1271	java/io/IOException
    //   1443	1451	1271	java/io/IOException
    //   1455	1470	1271	java/io/IOException
    //   1474	1483	1271	java/io/IOException
    //   1487	1499	1271	java/io/IOException
    //   1513	1532	1271	java/io/IOException
    //   1536	1548	1271	java/io/IOException
    //   1552	1557	1271	java/io/IOException
    //   1565	1571	1271	java/io/IOException
    //   1575	1602	1271	java/io/IOException
    //   1621	1630	1271	java/io/IOException
    //   1637	1645	1271	java/io/IOException
    //   1651	1661	1271	java/io/IOException
    //   542	550	1304	java/lang/OutOfMemoryError
    //   553	563	1304	java/lang/OutOfMemoryError
    //   566	572	1304	java/lang/OutOfMemoryError
    //   575	638	1304	java/lang/OutOfMemoryError
    //   641	646	1304	java/lang/OutOfMemoryError
    //   1365	1373	1613	java/lang/OutOfMemoryError
    //   1376	1383	1613	java/lang/OutOfMemoryError
    //   1386	1392	1613	java/lang/OutOfMemoryError
    //   1395	1422	1613	java/lang/OutOfMemoryError
    //   1425	1430	1613	java/lang/OutOfMemoryError
    //   20	33	1664	java/lang/RuntimeException
    //   37	53	1664	java/lang/RuntimeException
    //   63	141	1664	java/lang/RuntimeException
    //   145	185	1664	java/lang/RuntimeException
    //   189	241	1664	java/lang/RuntimeException
    //   249	282	1664	java/lang/RuntimeException
    //   303	335	1664	java/lang/RuntimeException
    //   395	415	1664	java/lang/RuntimeException
    //   418	438	1664	java/lang/RuntimeException
    //   441	468	1664	java/lang/RuntimeException
    //   470	490	1664	java/lang/RuntimeException
    //   520	542	1664	java/lang/RuntimeException
    //   542	550	1664	java/lang/RuntimeException
    //   553	563	1664	java/lang/RuntimeException
    //   566	572	1664	java/lang/RuntimeException
    //   575	638	1664	java/lang/RuntimeException
    //   641	646	1664	java/lang/RuntimeException
    //   659	666	1664	java/lang/RuntimeException
    //   670	677	1664	java/lang/RuntimeException
    //   681	689	1664	java/lang/RuntimeException
    //   693	708	1664	java/lang/RuntimeException
    //   712	717	1664	java/lang/RuntimeException
    //   721	732	1664	java/lang/RuntimeException
    //   740	746	1664	java/lang/RuntimeException
    //   750	777	1664	java/lang/RuntimeException
    //   817	824	1664	java/lang/RuntimeException
    //   827	833	1664	java/lang/RuntimeException
    //   836	842	1664	java/lang/RuntimeException
    //   845	872	1664	java/lang/RuntimeException
    //   875	879	1664	java/lang/RuntimeException
    //   888	896	1664	java/lang/RuntimeException
    //   900	915	1664	java/lang/RuntimeException
    //   919	928	1664	java/lang/RuntimeException
    //   932	944	1664	java/lang/RuntimeException
    //   954	973	1664	java/lang/RuntimeException
    //   977	989	1664	java/lang/RuntimeException
    //   989	1027	1664	java/lang/RuntimeException
    //   1049	1058	1664	java/lang/RuntimeException
    //   1073	1089	1664	java/lang/RuntimeException
    //   1092	1099	1664	java/lang/RuntimeException
    //   1101	1110	1664	java/lang/RuntimeException
    //   1112	1118	1664	java/lang/RuntimeException
    //   1120	1147	1664	java/lang/RuntimeException
    //   1149	1153	1664	java/lang/RuntimeException
    //   1158	1211	1664	java/lang/RuntimeException
    //   1215	1248	1664	java/lang/RuntimeException
    //   1262	1268	1664	java/lang/RuntimeException
    //   1312	1321	1664	java/lang/RuntimeException
    //   1324	1333	1664	java/lang/RuntimeException
    //   1365	1373	1664	java/lang/RuntimeException
    //   1376	1383	1664	java/lang/RuntimeException
    //   1386	1392	1664	java/lang/RuntimeException
    //   1395	1422	1664	java/lang/RuntimeException
    //   1425	1430	1664	java/lang/RuntimeException
    //   1443	1451	1664	java/lang/RuntimeException
    //   1455	1470	1664	java/lang/RuntimeException
    //   1474	1483	1664	java/lang/RuntimeException
    //   1487	1499	1664	java/lang/RuntimeException
    //   1513	1532	1664	java/lang/RuntimeException
    //   1536	1548	1664	java/lang/RuntimeException
    //   1552	1557	1664	java/lang/RuntimeException
    //   1565	1571	1664	java/lang/RuntimeException
    //   1575	1602	1664	java/lang/RuntimeException
    //   1621	1630	1664	java/lang/RuntimeException
    //   1637	1645	1664	java/lang/RuntimeException
    //   1651	1661	1664	java/lang/RuntimeException
    //   20	33	1697	java/lang/UnsatisfiedLinkError
    //   37	53	1697	java/lang/UnsatisfiedLinkError
    //   63	141	1697	java/lang/UnsatisfiedLinkError
    //   145	185	1697	java/lang/UnsatisfiedLinkError
    //   189	241	1697	java/lang/UnsatisfiedLinkError
    //   249	282	1697	java/lang/UnsatisfiedLinkError
    //   303	335	1697	java/lang/UnsatisfiedLinkError
    //   395	415	1697	java/lang/UnsatisfiedLinkError
    //   418	438	1697	java/lang/UnsatisfiedLinkError
    //   441	468	1697	java/lang/UnsatisfiedLinkError
    //   470	490	1697	java/lang/UnsatisfiedLinkError
    //   520	542	1697	java/lang/UnsatisfiedLinkError
    //   542	550	1697	java/lang/UnsatisfiedLinkError
    //   553	563	1697	java/lang/UnsatisfiedLinkError
    //   566	572	1697	java/lang/UnsatisfiedLinkError
    //   575	638	1697	java/lang/UnsatisfiedLinkError
    //   641	646	1697	java/lang/UnsatisfiedLinkError
    //   659	666	1697	java/lang/UnsatisfiedLinkError
    //   670	677	1697	java/lang/UnsatisfiedLinkError
    //   681	689	1697	java/lang/UnsatisfiedLinkError
    //   693	708	1697	java/lang/UnsatisfiedLinkError
    //   712	717	1697	java/lang/UnsatisfiedLinkError
    //   721	732	1697	java/lang/UnsatisfiedLinkError
    //   740	746	1697	java/lang/UnsatisfiedLinkError
    //   750	777	1697	java/lang/UnsatisfiedLinkError
    //   817	824	1697	java/lang/UnsatisfiedLinkError
    //   827	833	1697	java/lang/UnsatisfiedLinkError
    //   836	842	1697	java/lang/UnsatisfiedLinkError
    //   845	872	1697	java/lang/UnsatisfiedLinkError
    //   875	879	1697	java/lang/UnsatisfiedLinkError
    //   888	896	1697	java/lang/UnsatisfiedLinkError
    //   900	915	1697	java/lang/UnsatisfiedLinkError
    //   919	928	1697	java/lang/UnsatisfiedLinkError
    //   932	944	1697	java/lang/UnsatisfiedLinkError
    //   954	973	1697	java/lang/UnsatisfiedLinkError
    //   977	989	1697	java/lang/UnsatisfiedLinkError
    //   989	1027	1697	java/lang/UnsatisfiedLinkError
    //   1049	1058	1697	java/lang/UnsatisfiedLinkError
    //   1073	1089	1697	java/lang/UnsatisfiedLinkError
    //   1092	1099	1697	java/lang/UnsatisfiedLinkError
    //   1101	1110	1697	java/lang/UnsatisfiedLinkError
    //   1112	1118	1697	java/lang/UnsatisfiedLinkError
    //   1120	1147	1697	java/lang/UnsatisfiedLinkError
    //   1149	1153	1697	java/lang/UnsatisfiedLinkError
    //   1158	1211	1697	java/lang/UnsatisfiedLinkError
    //   1215	1248	1697	java/lang/UnsatisfiedLinkError
    //   1262	1268	1697	java/lang/UnsatisfiedLinkError
    //   1312	1321	1697	java/lang/UnsatisfiedLinkError
    //   1324	1333	1697	java/lang/UnsatisfiedLinkError
    //   1365	1373	1697	java/lang/UnsatisfiedLinkError
    //   1376	1383	1697	java/lang/UnsatisfiedLinkError
    //   1386	1392	1697	java/lang/UnsatisfiedLinkError
    //   1395	1422	1697	java/lang/UnsatisfiedLinkError
    //   1425	1430	1697	java/lang/UnsatisfiedLinkError
    //   1443	1451	1697	java/lang/UnsatisfiedLinkError
    //   1455	1470	1697	java/lang/UnsatisfiedLinkError
    //   1474	1483	1697	java/lang/UnsatisfiedLinkError
    //   1487	1499	1697	java/lang/UnsatisfiedLinkError
    //   1513	1532	1697	java/lang/UnsatisfiedLinkError
    //   1536	1548	1697	java/lang/UnsatisfiedLinkError
    //   1552	1557	1697	java/lang/UnsatisfiedLinkError
    //   1565	1571	1697	java/lang/UnsatisfiedLinkError
    //   1575	1602	1697	java/lang/UnsatisfiedLinkError
    //   1621	1630	1697	java/lang/UnsatisfiedLinkError
    //   1637	1645	1697	java/lang/UnsatisfiedLinkError
    //   1651	1661	1697	java/lang/UnsatisfiedLinkError
    //   20	33	1730	java/lang/Throwable
    //   37	53	1730	java/lang/Throwable
    //   63	141	1730	java/lang/Throwable
    //   303	335	1730	java/lang/Throwable
    //   395	415	1730	java/lang/Throwable
    //   418	438	1730	java/lang/Throwable
    //   441	468	1730	java/lang/Throwable
    //   470	490	1730	java/lang/Throwable
    //   520	542	1730	java/lang/Throwable
    //   542	550	1730	java/lang/Throwable
    //   553	563	1730	java/lang/Throwable
    //   566	572	1730	java/lang/Throwable
    //   575	638	1730	java/lang/Throwable
    //   641	646	1730	java/lang/Throwable
    //   659	666	1730	java/lang/Throwable
    //   670	677	1730	java/lang/Throwable
    //   681	689	1730	java/lang/Throwable
    //   693	708	1730	java/lang/Throwable
    //   712	717	1730	java/lang/Throwable
    //   721	732	1730	java/lang/Throwable
    //   740	746	1730	java/lang/Throwable
    //   750	777	1730	java/lang/Throwable
    //   817	824	1730	java/lang/Throwable
    //   827	833	1730	java/lang/Throwable
    //   836	842	1730	java/lang/Throwable
    //   845	872	1730	java/lang/Throwable
    //   875	879	1730	java/lang/Throwable
    //   888	896	1730	java/lang/Throwable
    //   900	915	1730	java/lang/Throwable
    //   919	928	1730	java/lang/Throwable
    //   932	944	1730	java/lang/Throwable
    //   954	973	1730	java/lang/Throwable
    //   977	989	1730	java/lang/Throwable
    //   989	1027	1730	java/lang/Throwable
    //   1049	1058	1730	java/lang/Throwable
    //   1073	1089	1730	java/lang/Throwable
    //   1092	1099	1730	java/lang/Throwable
    //   1101	1110	1730	java/lang/Throwable
    //   1112	1118	1730	java/lang/Throwable
    //   1120	1147	1730	java/lang/Throwable
    //   1149	1153	1730	java/lang/Throwable
    //   1158	1211	1730	java/lang/Throwable
    //   1215	1248	1730	java/lang/Throwable
    //   1262	1268	1730	java/lang/Throwable
    //   1312	1321	1730	java/lang/Throwable
    //   1324	1333	1730	java/lang/Throwable
    //   1365	1373	1730	java/lang/Throwable
    //   1376	1383	1730	java/lang/Throwable
    //   1386	1392	1730	java/lang/Throwable
    //   1395	1422	1730	java/lang/Throwable
    //   1425	1430	1730	java/lang/Throwable
    //   1443	1451	1730	java/lang/Throwable
    //   1455	1470	1730	java/lang/Throwable
    //   1474	1483	1730	java/lang/Throwable
    //   1487	1499	1730	java/lang/Throwable
    //   1513	1532	1730	java/lang/Throwable
    //   1536	1548	1730	java/lang/Throwable
    //   1552	1557	1730	java/lang/Throwable
    //   1565	1571	1730	java/lang/Throwable
    //   1575	1602	1730	java/lang/Throwable
    //   1621	1630	1730	java/lang/Throwable
    //   1637	1645	1730	java/lang/Throwable
    //   1651	1661	1730	java/lang/Throwable
    //   335	339	1763	java/lang/Throwable
    //   346	351	1763	java/lang/Throwable
    //   335	339	1768	java/lang/UnsatisfiedLinkError
    //   346	351	1768	java/lang/UnsatisfiedLinkError
    //   335	339	1773	java/lang/RuntimeException
    //   346	351	1773	java/lang/RuntimeException
    //   335	339	1778	java/io/IOException
    //   346	351	1778	java/io/IOException
    //   1158	1211	1783	java/lang/OutOfMemoryError
    //   1215	1248	1793	java/lang/OutOfMemoryError
    //   1443	1451	1799	java/lang/OutOfMemoryError
    //   1455	1470	1799	java/lang/OutOfMemoryError
    //   1474	1483	1799	java/lang/OutOfMemoryError
    //   1487	1499	1799	java/lang/OutOfMemoryError
    //   1513	1532	1799	java/lang/OutOfMemoryError
    //   1536	1548	1799	java/lang/OutOfMemoryError
    //   1552	1557	1799	java/lang/OutOfMemoryError
    //   1565	1571	1799	java/lang/OutOfMemoryError
    //   1575	1602	1799	java/lang/OutOfMemoryError
    //   888	896	1810	java/lang/OutOfMemoryError
    //   900	915	1810	java/lang/OutOfMemoryError
    //   919	928	1810	java/lang/OutOfMemoryError
    //   932	944	1810	java/lang/OutOfMemoryError
    //   954	973	1810	java/lang/OutOfMemoryError
    //   977	989	1810	java/lang/OutOfMemoryError
    //   989	1027	1821	java/lang/OutOfMemoryError
    //   659	666	1828	java/lang/OutOfMemoryError
    //   670	677	1828	java/lang/OutOfMemoryError
    //   681	689	1828	java/lang/OutOfMemoryError
    //   693	708	1828	java/lang/OutOfMemoryError
    //   712	717	1828	java/lang/OutOfMemoryError
    //   721	732	1828	java/lang/OutOfMemoryError
    //   740	746	1828	java/lang/OutOfMemoryError
    //   750	777	1828	java/lang/OutOfMemoryError
    //   249	282	1839	java/lang/Throwable
    //   249	282	1843	java/lang/OutOfMemoryError
    //   145	185	1878	java/lang/Throwable
    //   189	241	1878	java/lang/Throwable
    //   817	824	1890	java/lang/OutOfMemoryError
    //   827	833	1890	java/lang/OutOfMemoryError
    //   836	842	1890	java/lang/OutOfMemoryError
    //   845	872	1890	java/lang/OutOfMemoryError
    //   875	879	1890	java/lang/OutOfMemoryError
    //   1092	1099	1894	java/lang/OutOfMemoryError
    //   1101	1110	1894	java/lang/OutOfMemoryError
    //   1112	1118	1894	java/lang/OutOfMemoryError
    //   1120	1147	1894	java/lang/OutOfMemoryError
    //   1149	1153	1894	java/lang/OutOfMemoryError
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
                localObject = bach.a((byte[])localObject);
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
        paramString1 = babp.a();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = di.a();
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
      awrn.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (vvp.g(paramString))
      {
        awrn.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        awrn.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (vvp.i(paramString))
        {
          awrn.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, vux paramvux, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new vur(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramvux);
    paramAppActivity = new NewIntent(paramAppActivity, vsq.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramvux = paramvux.a();
    if (paramvux != null)
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
        if (paramvux.has(str)) {
          paramAppActivity.putExtra(str, paramvux.optString(str));
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
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, vux paramvux)
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
      if (paramScannerParams.a)
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          baan.b(2131230757, false);
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
          baan.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramvux);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramvux);
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
          baan.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        vsr.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
        if (!mpl.a(paramAppActivity))
        {
          paramString1 = babr.a(paramAppActivity, 230);
          paramString1.setMessage(2131653076);
          paramString2 = new vuq(paramvux);
          paramString1.setPositiveButton(2131629116, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          baan.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!vvp.a(str)))
        {
          if (bbys.a)
          {
            paramView.setVisibility(0);
            bbys.a().a(paramQQAppInterface, paramString1, paramView);
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
          yds.a().a(1);
          yds.a().jdField_a_of_type_JavaLangString = "";
          yds.a().jdField_a_of_type_Int = 0;
          yds.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramvux, paramString1)) {
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
        else if (vvp.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (vvp.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (vvp.f(str))
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
          if (vvp.h(str))
          {
            if (vvp.b(str))
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
            if (bajl.a(paramString1))
            {
              bajl.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramvux, paramView);
              i = 1;
            }
          }
          else
          {
            vsr.a(paramQQAppInterface, paramAppActivity, paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vup
 * JD-Core Version:    0.7.0.1
 */