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

public class whm
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
    if ((asjl.a() >= 0) && (aljj.a()))
    {
      i = 1;
      if (i == 0) {
        break label210;
      }
      long l = System.currentTimeMillis();
      Rect localRect = new Rect();
      bool = aljj.a().a(paramBitmap, l, localRect);
      if ((!bool) || (localRect.width() <= 0) || (localRect.height() <= 0)) {
        break label176;
      }
      paramBitmap = new Rect();
      asjl.a(localRect, paramBitmap, paramInt1, paramInt2, 1.2F);
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
    //   104: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
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
    //   157: invokestatic 23	asjl:a	()I
    //   160: iflt +90 -> 250
    //   163: invokestatic 28	aljj:a	()Z
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
    //   187: invokestatic 142	whm:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
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
    //   235: invokestatic 147	aljv:a	(ZZ)V
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
          i = bdsg.a(0, "ANY", "UTF-8");
          k = i1;
          m = i2;
          n = i3;
          localObject = new int[2];
          localObject[0] = 2;
          localObject[1] = 1;
          k = i1;
          m = i2;
          n = i3;
          int i4 = bdsg.a((int[])localObject, localObject.length);
          k = i1;
          m = i2;
          n = i3;
          localObject = bdsg.a();
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
            aljj.a().a(BaseApplicationImpl.getContext(), l2, "ScannerUtils.detectQQCodeBmp");
            k = i1;
            m = i2;
            n = i3;
            if (QLog.isColorLevel())
            {
              k = i1;
              m = i2;
              n = i3;
              QLog.i("ScannerUtils.detectQQCodeBmp", 2, String.format("init minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(aljj.a()), Long.valueOf(l2) }));
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
        break label963;
      }
      k = i;
      m = i;
      n = i;
      j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (j <= 250) {
        break label963;
      }
      k = i;
      m = i;
      n = i;
      j = (int)Math.ceil(j / 250.0D);
      break label963;
      if ((!bool) || (paramSparseArray == null) || (!paramBoolean)) {
        break label982;
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
      bdsg.a(paramBitmap, localStringBuilder);
      k = i;
      m = i;
      n = i;
      paramSparseArray.put(1, new Pair(localStringBuilder, paramBitmap));
      break label982;
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
        bdsg.a();
      }
      j = i;
      if ((paramInt & 0x2) == 2)
      {
        k = i;
        m = i;
        n = i;
        aljj.a().a(l2, "ScannerUtils.detectQQCodeBmp");
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
    //   93: ifnull +1210 -> 1303
    //   96: iload 4
    //   98: iconst_1
    //   99: iand
    //   100: iconst_1
    //   101: if_icmpne +202 -> 303
    //   104: iload 12
    //   106: istore 7
    //   108: iload 13
    //   110: istore 8
    //   112: iload 14
    //   114: istore 9
    //   116: iload 11
    //   118: istore 10
    //   120: iconst_0
    //   121: ldc 163
    //   123: ldc 165
    //   125: invokestatic 170	bdsg:a	(ILjava/lang/String;Ljava/lang/String;)I
    //   128: istore 17
    //   130: iload 12
    //   132: istore 7
    //   134: iload 13
    //   136: istore 8
    //   138: iload 14
    //   140: istore 9
    //   142: iload 11
    //   144: istore 10
    //   146: iconst_2
    //   147: newarray int
    //   149: astore 23
    //   151: aload 23
    //   153: iconst_0
    //   154: iconst_2
    //   155: iastore
    //   156: aload 23
    //   158: iconst_1
    //   159: iconst_1
    //   160: iastore
    //   161: iload 12
    //   163: istore 7
    //   165: iload 13
    //   167: istore 8
    //   169: iload 14
    //   171: istore 9
    //   173: iload 11
    //   175: istore 10
    //   177: aload 23
    //   179: aload 23
    //   181: arraylength
    //   182: invokestatic 173	bdsg:a	([II)I
    //   185: istore 18
    //   187: iload 12
    //   189: istore 7
    //   191: iload 13
    //   193: istore 8
    //   195: iload 14
    //   197: istore 9
    //   199: iload 11
    //   201: istore 10
    //   203: invokestatic 175	bdsg:a	()Ljava/lang/String;
    //   206: astore 23
    //   208: iload 12
    //   210: istore 7
    //   212: iload 13
    //   214: istore 8
    //   216: iload 14
    //   218: istore 9
    //   220: iload 11
    //   222: istore 10
    //   224: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   227: ifeq +76 -> 303
    //   230: iload 12
    //   232: istore 7
    //   234: iload 13
    //   236: istore 8
    //   238: iload 14
    //   240: istore 9
    //   242: iload 11
    //   244: istore 10
    //   246: ldc_w 287
    //   249: iconst_4
    //   250: new 136	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   257: ldc 180
    //   259: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 17
    //   264: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: ldc 189
    //   269: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload 18
    //   274: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 191
    //   279: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 23
    //   284: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 289
    //   290: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload_3
    //   294: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   297: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload 12
    //   305: istore 7
    //   307: iload 13
    //   309: istore 8
    //   311: iload 14
    //   313: istore 9
    //   315: iload 11
    //   317: istore 10
    //   319: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   322: lstore 21
    //   324: iload 4
    //   326: iconst_2
    //   327: iand
    //   328: iconst_2
    //   329: if_icmpne +104 -> 433
    //   332: iload 12
    //   334: istore 7
    //   336: iload 13
    //   338: istore 8
    //   340: iload 14
    //   342: istore 9
    //   344: iload 11
    //   346: istore 10
    //   348: invokestatic 42	aljj:a	()Laljj;
    //   351: invokestatic 197	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   354: lload 21
    //   356: ldc_w 287
    //   359: invokevirtual 200	aljj:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   362: iload 12
    //   364: istore 7
    //   366: iload 13
    //   368: istore 8
    //   370: iload 14
    //   372: istore 9
    //   374: iload 11
    //   376: istore 10
    //   378: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +52 -> 433
    //   384: iload 12
    //   386: istore 7
    //   388: iload 13
    //   390: istore 8
    //   392: iload 14
    //   394: istore 9
    //   396: iload 11
    //   398: istore 10
    //   400: ldc_w 287
    //   403: iconst_2
    //   404: ldc 202
    //   406: iconst_2
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: invokestatic 28	aljj:a	()Z
    //   415: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: aastore
    //   419: dup
    //   420: iconst_1
    //   421: lload 21
    //   423: invokestatic 207	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   426: aastore
    //   427: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   430: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: iload 12
    //   435: istore 7
    //   437: iload 13
    //   439: istore 8
    //   441: iload 14
    //   443: istore 9
    //   445: iload 11
    //   447: istore 10
    //   449: new 136	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   456: astore 25
    //   458: iload_3
    //   459: ifeq +1059 -> 1518
    //   462: iload 6
    //   464: istore 10
    //   466: iload 12
    //   468: istore 7
    //   470: iload 13
    //   472: istore 8
    //   474: iload 14
    //   476: istore 9
    //   478: iload 15
    //   480: istore 11
    //   482: aload_0
    //   483: invokevirtual 297	android/net/Uri:getPath	()Ljava/lang/String;
    //   486: invokestatic 303	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   489: astore 23
    //   491: iload 6
    //   493: istore 10
    //   495: iload 12
    //   497: istore 7
    //   499: iload 13
    //   501: istore 8
    //   503: iload 14
    //   505: istore 9
    //   507: iload 15
    //   509: istore 11
    //   511: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   514: ifeq +51 -> 565
    //   517: iload 6
    //   519: istore 10
    //   521: iload 12
    //   523: istore 7
    //   525: iload 13
    //   527: istore 8
    //   529: iload 14
    //   531: istore 9
    //   533: iload 15
    //   535: istore 11
    //   537: ldc_w 287
    //   540: iconst_4
    //   541: new 136	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 305
    //   551: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 23
    //   556: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload 23
    //   567: ifnull +3635 -> 4202
    //   570: iload 6
    //   572: istore 10
    //   574: iload 12
    //   576: istore 7
    //   578: iload 13
    //   580: istore 8
    //   582: iload 14
    //   584: istore 9
    //   586: iload 15
    //   588: istore 11
    //   590: aload 23
    //   592: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   595: istore 16
    //   597: iload 6
    //   599: istore 10
    //   601: iload 12
    //   603: istore 7
    //   605: iload 13
    //   607: istore 8
    //   609: iload 14
    //   611: istore 9
    //   613: iload 15
    //   615: istore 11
    //   617: aload 23
    //   619: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   622: istore 17
    //   624: iload 6
    //   626: istore 10
    //   628: iload 12
    //   630: istore 7
    //   632: iload 13
    //   634: istore 8
    //   636: iload 14
    //   638: istore 9
    //   640: iload 15
    //   642: istore 11
    //   644: iload 16
    //   646: iload 17
    //   648: imul
    //   649: newarray int
    //   651: astore 24
    //   653: iload 6
    //   655: istore 10
    //   657: iload 12
    //   659: istore 7
    //   661: iload 13
    //   663: istore 8
    //   665: iload 14
    //   667: istore 9
    //   669: iload 15
    //   671: istore 11
    //   673: aload 23
    //   675: aload 24
    //   677: iconst_0
    //   678: iload 16
    //   680: iconst_0
    //   681: iconst_0
    //   682: iload 16
    //   684: iload 17
    //   686: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   689: iload 6
    //   691: istore 10
    //   693: iload 12
    //   695: istore 7
    //   697: iload 13
    //   699: istore 8
    //   701: iload 14
    //   703: istore 9
    //   705: iload 15
    //   707: istore 11
    //   709: aload 24
    //   711: aconst_null
    //   712: iload 16
    //   714: iload 17
    //   716: iload 4
    //   718: aload 25
    //   720: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   723: istore 6
    //   725: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   728: ifeq +44 -> 772
    //   731: ldc_w 287
    //   734: iconst_4
    //   735: ldc_w 310
    //   738: iconst_3
    //   739: anewarray 4	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: iload 4
    //   746: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   749: aastore
    //   750: dup
    //   751: iconst_1
    //   752: iload 6
    //   754: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   757: aastore
    //   758: dup
    //   759: iconst_2
    //   760: aload 25
    //   762: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: aastore
    //   766: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   769: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: iload 16
    //   774: iload 17
    //   776: imul
    //   777: newarray byte
    //   779: astore 26
    //   781: aload 24
    //   783: aload 26
    //   785: iload 16
    //   787: iload 17
    //   789: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   792: pop
    //   793: iload 4
    //   795: iconst_2
    //   796: iand
    //   797: iconst_2
    //   798: if_icmpne +560 -> 1358
    //   801: iload 6
    //   803: iconst_2
    //   804: iand
    //   805: ifne +553 -> 1358
    //   808: iconst_1
    //   809: istore 7
    //   811: invokestatic 23	asjl:a	()I
    //   814: iflt +9 -> 823
    //   817: invokestatic 28	aljj:a	()Z
    //   820: ifeq +3 -> 823
    //   823: iload 7
    //   825: ifeq +3374 -> 4199
    //   828: aload 23
    //   830: iload 16
    //   832: iload 17
    //   834: aload 24
    //   836: aload 26
    //   838: aload 25
    //   840: invokestatic 142	whm:a	(Landroid/graphics/Bitmap;II[I[BLjava/lang/StringBuilder;)I
    //   843: istore 7
    //   845: iload 6
    //   847: iload 7
    //   849: ior
    //   850: istore 6
    //   852: iload 6
    //   854: istore 10
    //   856: iload 6
    //   858: istore 7
    //   860: iload 6
    //   862: istore 8
    //   864: iload 6
    //   866: istore 9
    //   868: iload 6
    //   870: istore 11
    //   872: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   875: ifeq +50 -> 925
    //   878: iload 6
    //   880: istore 10
    //   882: iload 6
    //   884: istore 7
    //   886: iload 6
    //   888: istore 8
    //   890: iload 6
    //   892: istore 9
    //   894: iload 6
    //   896: istore 11
    //   898: ldc 71
    //   900: iconst_4
    //   901: new 136	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   908: ldc_w 312
    //   911: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: iload 6
    //   916: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   919: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   925: iload 6
    //   927: istore 7
    //   929: iload 6
    //   931: istore 8
    //   933: iload 6
    //   935: istore 9
    //   937: aload 23
    //   939: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   942: iload 6
    //   944: iflt +264 -> 1208
    //   947: iload 6
    //   949: iconst_1
    //   950: iand
    //   951: iconst_1
    //   952: if_icmpne +2916 -> 3868
    //   955: iconst_1
    //   956: istore_3
    //   957: iload_3
    //   958: ifeq +3250 -> 4208
    //   961: aload 5
    //   963: ifnull +3245 -> 4208
    //   966: iload_2
    //   967: ifeq +3241 -> 4208
    //   970: iload 6
    //   972: istore 7
    //   974: iload 6
    //   976: istore 8
    //   978: iload 6
    //   980: istore 9
    //   982: iload 6
    //   984: istore 10
    //   986: new 136	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   993: astore 23
    //   995: iload 6
    //   997: istore 7
    //   999: iload 6
    //   1001: istore 8
    //   1003: iload 6
    //   1005: istore 9
    //   1007: iload 6
    //   1009: istore 10
    //   1011: new 136	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1018: astore 24
    //   1020: iload 6
    //   1022: istore 7
    //   1024: iload 6
    //   1026: istore 8
    //   1028: iload 6
    //   1030: istore 9
    //   1032: iload 6
    //   1034: istore 10
    //   1036: aload 23
    //   1038: aload 24
    //   1040: invokestatic 225	bdsg:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   1043: pop
    //   1044: iload 6
    //   1046: istore 7
    //   1048: iload 6
    //   1050: istore 8
    //   1052: iload 6
    //   1054: istore 9
    //   1056: iload 6
    //   1058: istore 10
    //   1060: aload 5
    //   1062: iconst_1
    //   1063: new 227	android/util/Pair
    //   1066: dup
    //   1067: aload 24
    //   1069: aload 23
    //   1071: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1074: invokevirtual 236	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1077: goto +3131 -> 4208
    //   1080: iload_2
    //   1081: ifeq +35 -> 1116
    //   1084: aload 5
    //   1086: ifnull +30 -> 1116
    //   1089: iload 6
    //   1091: istore 7
    //   1093: iload 6
    //   1095: istore 8
    //   1097: iload 6
    //   1099: istore 9
    //   1101: iload 6
    //   1103: istore 10
    //   1105: aload 5
    //   1107: iconst_2
    //   1108: aload 25
    //   1110: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokevirtual 236	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1116: iload 6
    //   1118: istore 7
    //   1120: iload 6
    //   1122: istore 8
    //   1124: iload 6
    //   1126: istore 9
    //   1128: iload 6
    //   1130: istore 10
    //   1132: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1135: ifeq +73 -> 1208
    //   1138: iload 6
    //   1140: istore 7
    //   1142: iload 6
    //   1144: istore 8
    //   1146: iload 6
    //   1148: istore 9
    //   1150: iload 6
    //   1152: istore 10
    //   1154: ldc_w 287
    //   1157: iconst_2
    //   1158: ldc 238
    //   1160: iconst_5
    //   1161: anewarray 4	java/lang/Object
    //   1164: dup
    //   1165: iconst_0
    //   1166: iload 4
    //   1168: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1171: aastore
    //   1172: dup
    //   1173: iconst_1
    //   1174: iload 6
    //   1176: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_2
    //   1182: iload_3
    //   1183: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_3
    //   1189: iload_2
    //   1190: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1193: aastore
    //   1194: dup
    //   1195: iconst_4
    //   1196: aload 25
    //   1198: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: aastore
    //   1202: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1205: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1208: iload 4
    //   1210: iconst_1
    //   1211: iand
    //   1212: iconst_1
    //   1213: if_icmpne +23 -> 1236
    //   1216: iload 6
    //   1218: istore 7
    //   1220: iload 6
    //   1222: istore 8
    //   1224: iload 6
    //   1226: istore 9
    //   1228: iload 6
    //   1230: istore 10
    //   1232: invokestatic 239	bdsg:a	()I
    //   1235: pop
    //   1236: aload_1
    //   1237: ifnull +23 -> 1260
    //   1240: iload 6
    //   1242: istore 7
    //   1244: iload 6
    //   1246: istore 8
    //   1248: iload 6
    //   1250: istore 9
    //   1252: iload 6
    //   1254: istore 10
    //   1256: aload_1
    //   1257: invokevirtual 320	java/io/InputStream:close	()V
    //   1260: iload 6
    //   1262: istore 7
    //   1264: iload 4
    //   1266: iconst_2
    //   1267: iand
    //   1268: iconst_2
    //   1269: if_icmpne +34 -> 1303
    //   1272: iload 6
    //   1274: istore 7
    //   1276: iload 6
    //   1278: istore 8
    //   1280: iload 6
    //   1282: istore 9
    //   1284: iload 6
    //   1286: istore 10
    //   1288: invokestatic 42	aljj:a	()Laljj;
    //   1291: lload 21
    //   1293: ldc_w 287
    //   1296: invokevirtual 242	aljj:a	(JLjava/lang/String;)V
    //   1299: iload 6
    //   1301: istore 7
    //   1303: iload 7
    //   1305: istore 4
    //   1307: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1310: ifeq -1299 -> 11
    //   1313: ldc_w 287
    //   1316: iconst_4
    //   1317: new 136	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 322
    //   1327: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   1333: lload 19
    //   1335: lsub
    //   1336: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1339: ldc_w 324
    //   1342: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: aload_0
    //   1346: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1349: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1352: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1355: iload 7
    //   1357: ireturn
    //   1358: iconst_0
    //   1359: istore 7
    //   1361: goto -550 -> 811
    //   1364: astore 23
    //   1366: iload 10
    //   1368: istore 6
    //   1370: iload 6
    //   1372: istore 7
    //   1374: iload 6
    //   1376: istore 8
    //   1378: iload 6
    //   1380: istore 9
    //   1382: iload 6
    //   1384: istore 10
    //   1386: aload 23
    //   1388: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1391: iload 6
    //   1393: istore 7
    //   1395: iload 6
    //   1397: istore 8
    //   1399: iload 6
    //   1401: istore 9
    //   1403: iload 6
    //   1405: istore 10
    //   1407: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1410: ifeq +2811 -> 4221
    //   1413: iload 6
    //   1415: istore 7
    //   1417: iload 6
    //   1419: istore 8
    //   1421: iload 6
    //   1423: istore 9
    //   1425: iload 6
    //   1427: istore 10
    //   1429: ldc_w 287
    //   1432: iconst_2
    //   1433: aload 23
    //   1435: invokevirtual 326	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1438: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1441: goto +2780 -> 4221
    //   1444: iload 6
    //   1446: istore 7
    //   1448: iload 6
    //   1450: istore 8
    //   1452: iload 6
    //   1454: istore 9
    //   1456: iload 6
    //   1458: istore 10
    //   1460: aload 23
    //   1462: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   1465: iload 6
    //   1467: istore 7
    //   1469: iload 6
    //   1471: istore 8
    //   1473: iload 6
    //   1475: istore 9
    //   1477: iload 6
    //   1479: istore 10
    //   1481: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1484: ifeq +2749 -> 4233
    //   1487: iload 6
    //   1489: istore 7
    //   1491: iload 6
    //   1493: istore 8
    //   1495: iload 6
    //   1497: istore 9
    //   1499: iload 6
    //   1501: istore 10
    //   1503: ldc_w 287
    //   1506: iconst_2
    //   1507: aload 23
    //   1509: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1512: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1515: goto +2718 -> 4233
    //   1518: iload 12
    //   1520: istore 7
    //   1522: iload 13
    //   1524: istore 8
    //   1526: iload 14
    //   1528: istore 9
    //   1530: iload 11
    //   1532: istore 10
    //   1534: new 328	android/graphics/BitmapFactory$Options
    //   1537: dup
    //   1538: invokespecial 329	android/graphics/BitmapFactory$Options:<init>	()V
    //   1541: astore 27
    //   1543: iload 12
    //   1545: istore 7
    //   1547: iload 13
    //   1549: istore 8
    //   1551: iload 14
    //   1553: istore 9
    //   1555: iload 11
    //   1557: istore 10
    //   1559: aload 27
    //   1561: iconst_1
    //   1562: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1565: iload 12
    //   1567: istore 7
    //   1569: iload 13
    //   1571: istore 8
    //   1573: iload 14
    //   1575: istore 9
    //   1577: iload 11
    //   1579: istore 10
    //   1581: aload_1
    //   1582: aconst_null
    //   1583: aload 27
    //   1585: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1588: pop
    //   1589: iload 12
    //   1591: istore 7
    //   1593: iload 13
    //   1595: istore 8
    //   1597: iload 14
    //   1599: istore 9
    //   1601: iload 11
    //   1603: istore 10
    //   1605: aload_1
    //   1606: invokevirtual 320	java/io/InputStream:close	()V
    //   1609: aconst_null
    //   1610: astore_1
    //   1611: iload 12
    //   1613: istore 7
    //   1615: iload 13
    //   1617: istore 8
    //   1619: iload 14
    //   1621: istore 9
    //   1623: iload 11
    //   1625: istore 10
    //   1627: aload 27
    //   1629: getfield 342	android/graphics/BitmapFactory$Options:outWidth	I
    //   1632: istore 15
    //   1634: iload 12
    //   1636: istore 7
    //   1638: iload 13
    //   1640: istore 8
    //   1642: iload 14
    //   1644: istore 9
    //   1646: iload 11
    //   1648: istore 10
    //   1650: aload 27
    //   1652: getfield 345	android/graphics/BitmapFactory$Options:outHeight	I
    //   1655: istore 17
    //   1657: iload 15
    //   1659: sipush 12800
    //   1662: if_icmpgt +2574 -> 4236
    //   1665: iload 17
    //   1667: sipush 12800
    //   1670: if_icmple +6 -> 1676
    //   1673: goto +2563 -> 4236
    //   1676: iload 12
    //   1678: istore 7
    //   1680: iload 13
    //   1682: istore 8
    //   1684: iload 14
    //   1686: istore 9
    //   1688: iload 11
    //   1690: istore 10
    //   1692: aload 27
    //   1694: aload 27
    //   1696: sipush 1280
    //   1699: sipush 1280
    //   1702: invokestatic 350	agqs:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1705: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1708: iload 12
    //   1710: istore 7
    //   1712: iload 13
    //   1714: istore 8
    //   1716: iload 14
    //   1718: istore 9
    //   1720: iload 11
    //   1722: istore 10
    //   1724: aload 27
    //   1726: iconst_0
    //   1727: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1730: iload 12
    //   1732: istore 7
    //   1734: iload 13
    //   1736: istore 8
    //   1738: iload 14
    //   1740: istore 9
    //   1742: iload 11
    //   1744: istore 10
    //   1746: aload 26
    //   1748: aload_0
    //   1749: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1752: astore 23
    //   1754: aload 23
    //   1756: astore_1
    //   1757: iload 12
    //   1759: istore 7
    //   1761: iload 13
    //   1763: istore 8
    //   1765: iload 14
    //   1767: istore 9
    //   1769: iload 11
    //   1771: istore 10
    //   1773: aload 23
    //   1775: aconst_null
    //   1776: aload 27
    //   1778: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1781: astore 24
    //   1783: aload 23
    //   1785: astore_1
    //   1786: iload 12
    //   1788: istore 7
    //   1790: iload 13
    //   1792: istore 8
    //   1794: iload 14
    //   1796: istore 9
    //   1798: iload 11
    //   1800: istore 10
    //   1802: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1805: ifeq +66 -> 1871
    //   1808: aload 23
    //   1810: astore_1
    //   1811: iload 12
    //   1813: istore 7
    //   1815: iload 13
    //   1817: istore 8
    //   1819: iload 14
    //   1821: istore 9
    //   1823: iload 11
    //   1825: istore 10
    //   1827: ldc_w 287
    //   1830: iconst_4
    //   1831: ldc_w 355
    //   1834: iconst_3
    //   1835: anewarray 4	java/lang/Object
    //   1838: dup
    //   1839: iconst_0
    //   1840: iload 15
    //   1842: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1845: aastore
    //   1846: dup
    //   1847: iconst_1
    //   1848: iload 17
    //   1850: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1853: aastore
    //   1854: dup
    //   1855: iconst_2
    //   1856: aload 27
    //   1858: getfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1861: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1864: aastore
    //   1865: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1868: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1871: aload 23
    //   1873: astore_1
    //   1874: iload 12
    //   1876: istore 7
    //   1878: iload 13
    //   1880: istore 8
    //   1882: iload 14
    //   1884: istore 9
    //   1886: iload 11
    //   1888: istore 10
    //   1890: aload 23
    //   1892: invokevirtual 320	java/io/InputStream:close	()V
    //   1895: aconst_null
    //   1896: astore_1
    //   1897: iload 16
    //   1899: istore 6
    //   1901: aload 24
    //   1903: ifnull +36 -> 1939
    //   1906: iload 12
    //   1908: istore 7
    //   1910: iload 13
    //   1912: istore 8
    //   1914: iload 14
    //   1916: istore 9
    //   1918: iload 11
    //   1920: istore 10
    //   1922: aload 24
    //   1924: iload 4
    //   1926: aload 25
    //   1928: invokestatic 209	whm:a	(Landroid/graphics/Bitmap;ILjava/lang/StringBuilder;)I
    //   1931: istore 6
    //   1933: iconst_0
    //   1934: iload 6
    //   1936: ior
    //   1937: istore 6
    //   1939: aconst_null
    //   1940: astore 23
    //   1942: aconst_null
    //   1943: astore_1
    //   1944: iload 6
    //   1946: istore 8
    //   1948: iload 6
    //   1950: istore 9
    //   1952: iload 6
    //   1954: istore 10
    //   1956: iload 6
    //   1958: istore 11
    //   1960: iload 4
    //   1962: iload 6
    //   1964: invokestatic 211	whm:a	(II)I
    //   1967: istore 13
    //   1969: iload 13
    //   1971: ifle +2219 -> 4190
    //   1974: iload 15
    //   1976: iload 17
    //   1978: iconst_2
    //   1979: imul
    //   1980: if_icmplt +1086 -> 3066
    //   1983: iload 17
    //   1985: sipush 1280
    //   1988: if_icmpge +1078 -> 3066
    //   1991: iconst_1
    //   1992: istore 7
    //   1994: iload 15
    //   1996: iconst_2
    //   1997: imul
    //   1998: iload 17
    //   2000: if_icmpgt +1072 -> 3072
    //   2003: iload 15
    //   2005: sipush 1280
    //   2008: if_icmpge +1064 -> 3072
    //   2011: iconst_1
    //   2012: istore 8
    //   2014: iload 8
    //   2016: ifeq +1114 -> 3130
    //   2019: iload 6
    //   2021: istore 8
    //   2023: iload 6
    //   2025: istore 9
    //   2027: iload 6
    //   2029: istore 10
    //   2031: iload 6
    //   2033: istore 11
    //   2035: aload 26
    //   2037: aload_0
    //   2038: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2041: astore 23
    //   2043: aload 23
    //   2045: astore_1
    //   2046: iload 6
    //   2048: istore 8
    //   2050: iload 6
    //   2052: istore 9
    //   2054: iload 6
    //   2056: istore 10
    //   2058: iload 6
    //   2060: istore 11
    //   2062: aload 23
    //   2064: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2067: astore 24
    //   2069: aload 23
    //   2071: astore_1
    //   2072: iload 6
    //   2074: istore 8
    //   2076: iload 6
    //   2078: istore 9
    //   2080: iload 6
    //   2082: istore 10
    //   2084: iload 6
    //   2086: istore 11
    //   2088: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2091: ifeq +50 -> 2141
    //   2094: aload 23
    //   2096: astore_1
    //   2097: iload 6
    //   2099: istore 8
    //   2101: iload 6
    //   2103: istore 9
    //   2105: iload 6
    //   2107: istore 10
    //   2109: iload 6
    //   2111: istore 11
    //   2113: ldc_w 287
    //   2116: iconst_4
    //   2117: new 136	java/lang/StringBuilder
    //   2120: dup
    //   2121: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2124: ldc_w 360
    //   2127: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: aload 24
    //   2132: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2135: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2138: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2141: aload 23
    //   2143: astore_1
    //   2144: iload 6
    //   2146: istore 8
    //   2148: iload 6
    //   2150: istore 9
    //   2152: iload 6
    //   2154: istore 10
    //   2156: iload 6
    //   2158: istore 11
    //   2160: aload 23
    //   2162: invokevirtual 320	java/io/InputStream:close	()V
    //   2165: aload 24
    //   2167: ifnull +2029 -> 4196
    //   2170: iload 6
    //   2172: istore 8
    //   2174: iload 6
    //   2176: istore 9
    //   2178: iload 6
    //   2180: istore 10
    //   2182: iload 6
    //   2184: istore 11
    //   2186: iload 6
    //   2188: istore 7
    //   2190: iload 15
    //   2192: iload 15
    //   2194: imul
    //   2195: newarray int
    //   2197: astore_1
    //   2198: iload 6
    //   2200: istore 8
    //   2202: iload 6
    //   2204: istore 9
    //   2206: iload 6
    //   2208: istore 10
    //   2210: iload 6
    //   2212: istore 11
    //   2214: iload 6
    //   2216: istore 7
    //   2218: aload 24
    //   2220: aload_1
    //   2221: iconst_0
    //   2222: iload 15
    //   2224: iconst_0
    //   2225: iconst_0
    //   2226: iload 15
    //   2228: iload 15
    //   2230: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2233: iload 6
    //   2235: istore 8
    //   2237: iload 6
    //   2239: istore 9
    //   2241: iload 6
    //   2243: istore 10
    //   2245: iload 6
    //   2247: istore 11
    //   2249: iload 6
    //   2251: istore 7
    //   2253: iload 15
    //   2255: iload 15
    //   2257: imul
    //   2258: newarray byte
    //   2260: astore 23
    //   2262: iload 6
    //   2264: istore 8
    //   2266: iload 6
    //   2268: istore 9
    //   2270: iload 6
    //   2272: istore 10
    //   2274: iload 6
    //   2276: istore 11
    //   2278: iload 6
    //   2280: istore 7
    //   2282: aload_1
    //   2283: aload 23
    //   2285: iload 15
    //   2287: iload 15
    //   2289: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2292: pop
    //   2293: iload 6
    //   2295: istore 8
    //   2297: iload 6
    //   2299: istore 9
    //   2301: iload 6
    //   2303: istore 10
    //   2305: iload 6
    //   2307: istore 11
    //   2309: iload 6
    //   2311: istore 7
    //   2313: iload 6
    //   2315: aload_1
    //   2316: aload 23
    //   2318: iload 15
    //   2320: iload 15
    //   2322: iload 13
    //   2324: aload 25
    //   2326: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2329: ior
    //   2330: istore 6
    //   2332: iload 6
    //   2334: iconst_1
    //   2335: if_icmpeq +1858 -> 4193
    //   2338: iload 6
    //   2340: istore 8
    //   2342: iload 6
    //   2344: istore 9
    //   2346: iload 6
    //   2348: istore 10
    //   2350: iload 6
    //   2352: istore 11
    //   2354: iload 6
    //   2356: istore 7
    //   2358: aload 24
    //   2360: aload_1
    //   2361: iconst_0
    //   2362: iload 15
    //   2364: iconst_0
    //   2365: iload 17
    //   2367: iload 15
    //   2369: isub
    //   2370: iload 15
    //   2372: iload 15
    //   2374: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2377: iload 6
    //   2379: istore 8
    //   2381: iload 6
    //   2383: istore 9
    //   2385: iload 6
    //   2387: istore 10
    //   2389: iload 6
    //   2391: istore 11
    //   2393: iload 6
    //   2395: istore 7
    //   2397: aload_1
    //   2398: aload 23
    //   2400: iload 15
    //   2402: iload 15
    //   2404: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   2407: pop
    //   2408: iload 6
    //   2410: istore 8
    //   2412: iload 6
    //   2414: istore 9
    //   2416: iload 6
    //   2418: istore 10
    //   2420: iload 6
    //   2422: istore 11
    //   2424: iload 6
    //   2426: istore 7
    //   2428: aload_1
    //   2429: aload 23
    //   2431: iload 15
    //   2433: iload 15
    //   2435: iload 13
    //   2437: aload 25
    //   2439: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2442: istore 12
    //   2444: iload 12
    //   2446: iload 6
    //   2448: ior
    //   2449: istore 6
    //   2451: iload 6
    //   2453: istore 7
    //   2455: iload 6
    //   2457: istore 8
    //   2459: iload 6
    //   2461: istore 9
    //   2463: aload 24
    //   2465: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   2468: iload 6
    //   2470: istore 7
    //   2472: iload 6
    //   2474: istore 8
    //   2476: iload 6
    //   2478: istore 9
    //   2480: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2483: ifeq +56 -> 2539
    //   2486: iload 6
    //   2488: istore 7
    //   2490: iload 6
    //   2492: istore 8
    //   2494: iload 6
    //   2496: istore 9
    //   2498: ldc_w 287
    //   2501: iconst_4
    //   2502: ldc_w 362
    //   2505: iconst_3
    //   2506: anewarray 4	java/lang/Object
    //   2509: dup
    //   2510: iconst_0
    //   2511: iload 13
    //   2513: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2516: aastore
    //   2517: dup
    //   2518: iconst_1
    //   2519: iload 6
    //   2521: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2524: aastore
    //   2525: dup
    //   2526: iconst_2
    //   2527: aload 25
    //   2529: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2532: aastore
    //   2533: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2536: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2539: aconst_null
    //   2540: astore_1
    //   2541: iload 6
    //   2543: istore 7
    //   2545: iload 6
    //   2547: istore 8
    //   2549: iload 6
    //   2551: istore 9
    //   2553: iload 6
    //   2555: istore 10
    //   2557: iload 4
    //   2559: iload 6
    //   2561: invokestatic 211	whm:a	(II)I
    //   2564: istore 11
    //   2566: iload 11
    //   2568: ifle +1617 -> 4185
    //   2571: iload 6
    //   2573: istore 7
    //   2575: iload 6
    //   2577: istore 8
    //   2579: iload 6
    //   2581: istore 9
    //   2583: iload 6
    //   2585: istore 10
    //   2587: iload 15
    //   2589: iload 17
    //   2591: invokestatic 216	java/lang/Math:min	(II)I
    //   2594: istore 12
    //   2596: iload 12
    //   2598: sipush 250
    //   2601: if_icmple +1584 -> 4185
    //   2604: iload 6
    //   2606: istore 7
    //   2608: iload 6
    //   2610: istore 8
    //   2612: iload 6
    //   2614: istore 9
    //   2616: iload 6
    //   2618: istore 10
    //   2620: aload 27
    //   2622: iload 12
    //   2624: i2d
    //   2625: ldc2_w 217
    //   2628: ddiv
    //   2629: invokestatic 222	java/lang/Math:ceil	(D)D
    //   2632: d2i
    //   2633: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2636: iload 6
    //   2638: istore 7
    //   2640: iload 6
    //   2642: istore 8
    //   2644: iload 6
    //   2646: istore 9
    //   2648: iload 6
    //   2650: istore 10
    //   2652: aload 26
    //   2654: aload_0
    //   2655: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2658: astore 23
    //   2660: aload 23
    //   2662: astore_1
    //   2663: iload 6
    //   2665: istore 7
    //   2667: iload 6
    //   2669: istore 8
    //   2671: iload 6
    //   2673: istore 9
    //   2675: iload 6
    //   2677: istore 10
    //   2679: aload 23
    //   2681: aconst_null
    //   2682: aload 27
    //   2684: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2687: astore 24
    //   2689: aload 23
    //   2691: astore_1
    //   2692: iload 6
    //   2694: istore 7
    //   2696: iload 6
    //   2698: istore 8
    //   2700: iload 6
    //   2702: istore 9
    //   2704: iload 6
    //   2706: istore 10
    //   2708: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2711: ifeq +50 -> 2761
    //   2714: aload 23
    //   2716: astore_1
    //   2717: iload 6
    //   2719: istore 7
    //   2721: iload 6
    //   2723: istore 8
    //   2725: iload 6
    //   2727: istore 9
    //   2729: iload 6
    //   2731: istore 10
    //   2733: ldc_w 287
    //   2736: iconst_4
    //   2737: new 136	java/lang/StringBuilder
    //   2740: dup
    //   2741: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   2744: ldc_w 364
    //   2747: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: aload 24
    //   2752: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2755: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2758: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2761: aload 23
    //   2763: astore_1
    //   2764: iload 6
    //   2766: istore 7
    //   2768: iload 6
    //   2770: istore 8
    //   2772: iload 6
    //   2774: istore 9
    //   2776: iload 6
    //   2778: istore 10
    //   2780: aload 23
    //   2782: invokevirtual 320	java/io/InputStream:close	()V
    //   2785: aconst_null
    //   2786: astore_1
    //   2787: aload 24
    //   2789: ifnull +1389 -> 4178
    //   2792: iload 6
    //   2794: istore 7
    //   2796: iload 6
    //   2798: istore 8
    //   2800: iload 6
    //   2802: istore 9
    //   2804: iload 6
    //   2806: istore 10
    //   2808: aload 24
    //   2810: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   2813: istore 12
    //   2815: iload 6
    //   2817: istore 7
    //   2819: iload 6
    //   2821: istore 8
    //   2823: iload 6
    //   2825: istore 9
    //   2827: iload 6
    //   2829: istore 10
    //   2831: aload 24
    //   2833: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   2836: istore 13
    //   2838: iload 6
    //   2840: istore 7
    //   2842: iload 6
    //   2844: istore 8
    //   2846: iload 6
    //   2848: istore 9
    //   2850: iload 6
    //   2852: istore 10
    //   2854: iload 12
    //   2856: iload 13
    //   2858: imul
    //   2859: newarray int
    //   2861: astore 23
    //   2863: iload 6
    //   2865: istore 7
    //   2867: iload 6
    //   2869: istore 8
    //   2871: iload 6
    //   2873: istore 9
    //   2875: iload 6
    //   2877: istore 10
    //   2879: aload 24
    //   2881: aload 23
    //   2883: iconst_0
    //   2884: iload 12
    //   2886: iconst_0
    //   2887: iconst_0
    //   2888: iload 12
    //   2890: iload 13
    //   2892: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2895: iload 6
    //   2897: istore 7
    //   2899: iload 6
    //   2901: istore 8
    //   2903: iload 6
    //   2905: istore 9
    //   2907: iload 6
    //   2909: istore 10
    //   2911: aload 24
    //   2913: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   2916: iload 6
    //   2918: istore 7
    //   2920: iload 6
    //   2922: istore 8
    //   2924: iload 6
    //   2926: istore 9
    //   2928: iload 6
    //   2930: istore 10
    //   2932: aload 23
    //   2934: aconst_null
    //   2935: iload 12
    //   2937: iload 13
    //   2939: iload 11
    //   2941: aload 25
    //   2943: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   2946: istore 12
    //   2948: iload 12
    //   2950: iload 6
    //   2952: ior
    //   2953: istore 6
    //   2955: iload 6
    //   2957: istore 7
    //   2959: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2962: ifeq +48 -> 3010
    //   2965: ldc_w 287
    //   2968: iconst_4
    //   2969: ldc_w 366
    //   2972: iconst_3
    //   2973: anewarray 4	java/lang/Object
    //   2976: dup
    //   2977: iconst_0
    //   2978: iload 11
    //   2980: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2983: aastore
    //   2984: dup
    //   2985: iconst_1
    //   2986: iload 6
    //   2988: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2991: aastore
    //   2992: dup
    //   2993: iconst_2
    //   2994: aload 25
    //   2996: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2999: aastore
    //   3000: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3003: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3006: iload 6
    //   3008: istore 7
    //   3010: iload 7
    //   3012: istore 6
    //   3014: goto -2072 -> 942
    //   3017: astore 23
    //   3019: iload 12
    //   3021: istore 7
    //   3023: iload 13
    //   3025: istore 8
    //   3027: iload 14
    //   3029: istore 9
    //   3031: iload 11
    //   3033: istore 10
    //   3035: aload 23
    //   3037: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3040: iload 12
    //   3042: istore 7
    //   3044: iload 13
    //   3046: istore 8
    //   3048: iload 14
    //   3050: istore 9
    //   3052: iload 11
    //   3054: istore 10
    //   3056: aload_1
    //   3057: invokevirtual 320	java/io/InputStream:close	()V
    //   3060: iconst_0
    //   3061: istore 6
    //   3063: goto -1124 -> 1939
    //   3066: iconst_0
    //   3067: istore 7
    //   3069: goto -1075 -> 1994
    //   3072: iconst_0
    //   3073: istore 8
    //   3075: goto -1061 -> 2014
    //   3078: astore 24
    //   3080: aload_1
    //   3081: astore 23
    //   3083: aload 24
    //   3085: astore_1
    //   3086: iload 6
    //   3088: istore 8
    //   3090: iload 6
    //   3092: istore 9
    //   3094: iload 6
    //   3096: istore 10
    //   3098: iload 6
    //   3100: istore 11
    //   3102: aload_1
    //   3103: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3106: iload 6
    //   3108: istore 8
    //   3110: iload 6
    //   3112: istore 9
    //   3114: iload 6
    //   3116: istore 10
    //   3118: iload 6
    //   3120: istore 11
    //   3122: aload 23
    //   3124: invokevirtual 320	java/io/InputStream:close	()V
    //   3127: goto -588 -> 2539
    //   3130: iload 7
    //   3132: ifeq +1058 -> 4190
    //   3135: aload 23
    //   3137: astore_1
    //   3138: iload 6
    //   3140: istore 7
    //   3142: iload 6
    //   3144: istore 8
    //   3146: iload 6
    //   3148: istore 9
    //   3150: iload 6
    //   3152: istore 10
    //   3154: iload 6
    //   3156: istore 11
    //   3158: aload 26
    //   3160: aload_0
    //   3161: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3164: astore 23
    //   3166: aload 23
    //   3168: astore_1
    //   3169: iload 6
    //   3171: istore 7
    //   3173: iload 6
    //   3175: istore 8
    //   3177: iload 6
    //   3179: istore 9
    //   3181: iload 6
    //   3183: istore 10
    //   3185: iload 6
    //   3187: istore 11
    //   3189: aload 23
    //   3191: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3194: astore 24
    //   3196: aload 23
    //   3198: astore_1
    //   3199: iload 6
    //   3201: istore 7
    //   3203: iload 6
    //   3205: istore 8
    //   3207: iload 6
    //   3209: istore 9
    //   3211: iload 6
    //   3213: istore 10
    //   3215: iload 6
    //   3217: istore 11
    //   3219: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3222: ifeq +54 -> 3276
    //   3225: aload 23
    //   3227: astore_1
    //   3228: iload 6
    //   3230: istore 7
    //   3232: iload 6
    //   3234: istore 8
    //   3236: iload 6
    //   3238: istore 9
    //   3240: iload 6
    //   3242: istore 10
    //   3244: iload 6
    //   3246: istore 11
    //   3248: ldc_w 287
    //   3251: iconst_4
    //   3252: new 136	java/lang/StringBuilder
    //   3255: dup
    //   3256: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   3259: ldc_w 368
    //   3262: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: aload 24
    //   3267: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3270: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3273: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3276: aload 23
    //   3278: astore_1
    //   3279: iload 6
    //   3281: istore 7
    //   3283: iload 6
    //   3285: istore 8
    //   3287: iload 6
    //   3289: istore 9
    //   3291: iload 6
    //   3293: istore 10
    //   3295: iload 6
    //   3297: istore 11
    //   3299: aload 23
    //   3301: invokevirtual 320	java/io/InputStream:close	()V
    //   3304: aconst_null
    //   3305: astore 23
    //   3307: iload 6
    //   3309: istore 12
    //   3311: aload 24
    //   3313: ifnull +444 -> 3757
    //   3316: aload 23
    //   3318: astore_1
    //   3319: iload 6
    //   3321: istore 7
    //   3323: iload 6
    //   3325: istore 8
    //   3327: iload 6
    //   3329: istore 9
    //   3331: iload 6
    //   3333: istore 10
    //   3335: iload 6
    //   3337: istore 11
    //   3339: iload 17
    //   3341: iload 17
    //   3343: imul
    //   3344: newarray int
    //   3346: astore 28
    //   3348: aload 23
    //   3350: astore_1
    //   3351: iload 6
    //   3353: istore 7
    //   3355: iload 6
    //   3357: istore 8
    //   3359: iload 6
    //   3361: istore 9
    //   3363: iload 6
    //   3365: istore 10
    //   3367: iload 6
    //   3369: istore 11
    //   3371: aload 24
    //   3373: aload 28
    //   3375: iconst_0
    //   3376: iload 17
    //   3378: iconst_0
    //   3379: iconst_0
    //   3380: iload 17
    //   3382: iload 17
    //   3384: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3387: aload 23
    //   3389: astore_1
    //   3390: iload 6
    //   3392: istore 7
    //   3394: iload 6
    //   3396: istore 8
    //   3398: iload 6
    //   3400: istore 9
    //   3402: iload 6
    //   3404: istore 10
    //   3406: iload 6
    //   3408: istore 11
    //   3410: iload 17
    //   3412: iload 17
    //   3414: imul
    //   3415: newarray byte
    //   3417: astore 29
    //   3419: aload 23
    //   3421: astore_1
    //   3422: iload 6
    //   3424: istore 7
    //   3426: iload 6
    //   3428: istore 8
    //   3430: iload 6
    //   3432: istore 9
    //   3434: iload 6
    //   3436: istore 10
    //   3438: iload 6
    //   3440: istore 11
    //   3442: aload 28
    //   3444: aload 29
    //   3446: iload 17
    //   3448: iload 17
    //   3450: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3453: pop
    //   3454: aload 23
    //   3456: astore_1
    //   3457: iload 6
    //   3459: istore 7
    //   3461: iload 6
    //   3463: istore 8
    //   3465: iload 6
    //   3467: istore 9
    //   3469: iload 6
    //   3471: istore 10
    //   3473: iload 6
    //   3475: istore 11
    //   3477: iload 6
    //   3479: aload 28
    //   3481: aload 29
    //   3483: iload 17
    //   3485: iload 17
    //   3487: iload 13
    //   3489: aload 25
    //   3491: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3494: ior
    //   3495: istore 12
    //   3497: iload 12
    //   3499: istore 6
    //   3501: iload 12
    //   3503: iconst_1
    //   3504: if_icmpeq +124 -> 3628
    //   3507: aload 23
    //   3509: astore_1
    //   3510: iload 12
    //   3512: istore 7
    //   3514: iload 12
    //   3516: istore 8
    //   3518: iload 12
    //   3520: istore 9
    //   3522: iload 12
    //   3524: istore 10
    //   3526: iload 12
    //   3528: istore 11
    //   3530: aload 24
    //   3532: aload 28
    //   3534: iconst_0
    //   3535: iload 17
    //   3537: iload 15
    //   3539: iload 17
    //   3541: isub
    //   3542: iconst_0
    //   3543: iload 17
    //   3545: iload 17
    //   3547: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   3550: aload 23
    //   3552: astore_1
    //   3553: iload 12
    //   3555: istore 7
    //   3557: iload 12
    //   3559: istore 8
    //   3561: iload 12
    //   3563: istore 9
    //   3565: iload 12
    //   3567: istore 10
    //   3569: iload 12
    //   3571: istore 11
    //   3573: aload 28
    //   3575: aload 29
    //   3577: iload 17
    //   3579: iload 17
    //   3581: invokestatic 129	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   3584: pop
    //   3585: aload 23
    //   3587: astore_1
    //   3588: iload 12
    //   3590: istore 7
    //   3592: iload 12
    //   3594: istore 8
    //   3596: iload 12
    //   3598: istore 9
    //   3600: iload 12
    //   3602: istore 10
    //   3604: iload 12
    //   3606: istore 11
    //   3608: iload 12
    //   3610: aload 28
    //   3612: aload 29
    //   3614: iload 17
    //   3616: iload 17
    //   3618: iload 13
    //   3620: aload 25
    //   3622: invokestatic 132	whm:a	([I[BIIILjava/lang/StringBuilder;)I
    //   3625: ior
    //   3626: istore 6
    //   3628: aload 23
    //   3630: astore_1
    //   3631: iload 6
    //   3633: istore 7
    //   3635: iload 6
    //   3637: istore 8
    //   3639: iload 6
    //   3641: istore 9
    //   3643: iload 6
    //   3645: istore 10
    //   3647: iload 6
    //   3649: istore 11
    //   3651: aload 24
    //   3653: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   3656: iload 6
    //   3658: istore 12
    //   3660: aload 23
    //   3662: astore_1
    //   3663: iload 6
    //   3665: istore 7
    //   3667: iload 6
    //   3669: istore 8
    //   3671: iload 6
    //   3673: istore 9
    //   3675: iload 6
    //   3677: istore 10
    //   3679: iload 6
    //   3681: istore 11
    //   3683: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3686: ifeq +71 -> 3757
    //   3689: aload 23
    //   3691: astore_1
    //   3692: iload 6
    //   3694: istore 7
    //   3696: iload 6
    //   3698: istore 8
    //   3700: iload 6
    //   3702: istore 9
    //   3704: iload 6
    //   3706: istore 10
    //   3708: iload 6
    //   3710: istore 11
    //   3712: ldc_w 287
    //   3715: iconst_4
    //   3716: ldc_w 370
    //   3719: iconst_3
    //   3720: anewarray 4	java/lang/Object
    //   3723: dup
    //   3724: iconst_0
    //   3725: iload 13
    //   3727: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3730: aastore
    //   3731: dup
    //   3732: iconst_1
    //   3733: iload 6
    //   3735: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3738: aastore
    //   3739: dup
    //   3740: iconst_2
    //   3741: aload 25
    //   3743: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3746: aastore
    //   3747: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3750: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3753: iload 6
    //   3755: istore 12
    //   3757: iload 12
    //   3759: istore 6
    //   3761: goto -1222 -> 2539
    //   3764: astore 23
    //   3766: iload 7
    //   3768: istore 8
    //   3770: iload 7
    //   3772: istore 9
    //   3774: iload 7
    //   3776: istore 10
    //   3778: iload 7
    //   3780: istore 11
    //   3782: aload 23
    //   3784: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3787: iload 7
    //   3789: istore 8
    //   3791: iload 7
    //   3793: istore 9
    //   3795: iload 7
    //   3797: istore 10
    //   3799: iload 7
    //   3801: istore 11
    //   3803: aload_1
    //   3804: invokevirtual 320	java/io/InputStream:close	()V
    //   3807: iload 7
    //   3809: istore 6
    //   3811: goto -1272 -> 2539
    //   3814: astore 24
    //   3816: aload_1
    //   3817: astore 23
    //   3819: aload 24
    //   3821: astore_1
    //   3822: iload 6
    //   3824: istore 7
    //   3826: iload 6
    //   3828: istore 8
    //   3830: iload 6
    //   3832: istore 9
    //   3834: iload 6
    //   3836: istore 10
    //   3838: aload_1
    //   3839: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3842: iload 6
    //   3844: istore 7
    //   3846: iload 6
    //   3848: istore 8
    //   3850: iload 6
    //   3852: istore 9
    //   3854: iload 6
    //   3856: istore 10
    //   3858: aload 23
    //   3860: invokevirtual 320	java/io/InputStream:close	()V
    //   3863: aconst_null
    //   3864: astore_1
    //   3865: goto -2923 -> 942
    //   3868: iconst_0
    //   3869: istore_3
    //   3870: goto -2913 -> 957
    //   3873: iconst_0
    //   3874: istore_2
    //   3875: goto -2795 -> 1080
    //   3878: astore_1
    //   3879: iload 7
    //   3881: istore 4
    //   3883: aload_1
    //   3884: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   3887: iload 4
    //   3889: istore 7
    //   3891: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3894: ifeq -2591 -> 1303
    //   3897: ldc_w 287
    //   3900: iconst_2
    //   3901: aload_1
    //   3902: invokevirtual 372	java/io/IOException:toString	()Ljava/lang/String;
    //   3905: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3908: iload 4
    //   3910: istore 7
    //   3912: goto -2609 -> 1303
    //   3915: astore_1
    //   3916: aload_1
    //   3917: invokevirtual 250	java/lang/RuntimeException:printStackTrace	()V
    //   3920: iload 8
    //   3922: istore 7
    //   3924: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3927: ifeq -2624 -> 1303
    //   3930: ldc_w 287
    //   3933: iconst_2
    //   3934: aload_1
    //   3935: invokevirtual 251	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   3938: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3941: iload 8
    //   3943: istore 7
    //   3945: goto -2642 -> 1303
    //   3948: astore_1
    //   3949: aload_1
    //   3950: invokevirtual 255	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   3953: iload 9
    //   3955: istore 7
    //   3957: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3960: ifeq -2657 -> 1303
    //   3963: ldc_w 287
    //   3966: iconst_2
    //   3967: aload_1
    //   3968: invokevirtual 256	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   3971: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3974: iload 9
    //   3976: istore 7
    //   3978: goto -2675 -> 1303
    //   3981: astore_1
    //   3982: aload_1
    //   3983: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   3986: iload 10
    //   3988: istore 7
    //   3990: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3993: ifeq -2690 -> 1303
    //   3996: ldc_w 287
    //   3999: iconst_2
    //   4000: aload_1
    //   4001: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   4004: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4007: iload 10
    //   4009: istore 7
    //   4011: goto -2708 -> 1303
    //   4014: astore_1
    //   4015: iload 8
    //   4017: istore 10
    //   4019: goto -37 -> 3982
    //   4022: astore_1
    //   4023: iload 6
    //   4025: istore 10
    //   4027: goto -45 -> 3982
    //   4030: astore_1
    //   4031: iload 6
    //   4033: istore 10
    //   4035: goto -53 -> 3982
    //   4038: astore_1
    //   4039: iload 6
    //   4041: istore 9
    //   4043: goto -94 -> 3949
    //   4046: astore_1
    //   4047: iload 7
    //   4049: istore 9
    //   4051: goto -102 -> 3949
    //   4054: astore_1
    //   4055: goto -106 -> 3949
    //   4058: astore_1
    //   4059: iload 6
    //   4061: istore 9
    //   4063: goto -114 -> 3949
    //   4066: astore_1
    //   4067: iload 6
    //   4069: istore 8
    //   4071: goto -155 -> 3916
    //   4074: astore_1
    //   4075: goto -159 -> 3916
    //   4078: astore_1
    //   4079: iload 10
    //   4081: istore 8
    //   4083: goto -167 -> 3916
    //   4086: astore_1
    //   4087: iload 6
    //   4089: istore 8
    //   4091: goto -175 -> 3916
    //   4094: astore_1
    //   4095: iload 6
    //   4097: istore 4
    //   4099: goto -216 -> 3883
    //   4102: astore_1
    //   4103: iload 9
    //   4105: istore 4
    //   4107: goto -224 -> 3883
    //   4110: astore_1
    //   4111: iload 11
    //   4113: istore 4
    //   4115: goto -232 -> 3883
    //   4118: astore_1
    //   4119: iload 6
    //   4121: istore 4
    //   4123: goto -240 -> 3883
    //   4126: astore_1
    //   4127: aconst_null
    //   4128: astore 23
    //   4130: goto -308 -> 3822
    //   4133: astore_1
    //   4134: aconst_null
    //   4135: astore 23
    //   4137: goto -315 -> 3822
    //   4140: astore_1
    //   4141: aconst_null
    //   4142: astore 23
    //   4144: iload 7
    //   4146: istore 6
    //   4148: goto -1062 -> 3086
    //   4151: astore_1
    //   4152: aconst_null
    //   4153: astore 23
    //   4155: goto -1069 -> 3086
    //   4158: astore 23
    //   4160: goto -2716 -> 1444
    //   4163: astore 23
    //   4165: goto -2721 -> 1444
    //   4168: astore 23
    //   4170: goto -2800 -> 1370
    //   4173: astore 23
    //   4175: goto -2805 -> 1370
    //   4178: iload 6
    //   4180: istore 7
    //   4182: goto -1172 -> 3010
    //   4185: aconst_null
    //   4186: astore_1
    //   4187: goto -3245 -> 942
    //   4190: goto -1651 -> 2539
    //   4193: goto -1742 -> 2451
    //   4196: goto -1657 -> 2539
    //   4199: goto -3274 -> 925
    //   4202: iconst_0
    //   4203: istore 6
    //   4205: goto -3263 -> 942
    //   4208: iload 6
    //   4210: iconst_2
    //   4211: iand
    //   4212: iconst_2
    //   4213: if_icmpne -340 -> 3873
    //   4216: iconst_1
    //   4217: istore_2
    //   4218: goto -3138 -> 1080
    //   4221: goto -3279 -> 942
    //   4224: astore 23
    //   4226: iload 11
    //   4228: istore 6
    //   4230: goto -2786 -> 1444
    //   4233: goto -3291 -> 942
    //   4236: iconst_0
    //   4237: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4238	0	paramUri	Uri
    //   0	4238	1	paramContext	Context
    //   0	4238	2	paramBoolean1	boolean
    //   0	4238	3	paramBoolean2	boolean
    //   0	4238	4	paramInt	int
    //   0	4238	5	paramSparseArray	SparseArray<Object>
    //   20	4209	6	i	int
    //   45	4136	7	j	int
    //   49	4041	8	k	int
    //   53	4051	9	m	int
    //   57	4023	10	n	int
    //   35	4192	11	i1	int
    //   26	3732	12	i2	int
    //   29	3697	13	i3	int
    //   32	3017	14	i4	int
    //   38	3504	15	i5	int
    //   23	1875	16	i6	int
    //   41	3576	17	i7	int
    //   185	88	18	i8	int
    //   17	1317	19	l1	long
    //   322	970	21	l2	long
    //   149	921	23	localObject1	Object
    //   1364	144	23	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1752	1181	23	localObject2	Object
    //   3017	19	23	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3081	609	23	localObject3	Object
    //   3764	19	23	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3817	337	23	localContext	Context
    //   4158	1	23	localThrowable1	Throwable
    //   4163	1	23	localThrowable2	Throwable
    //   4168	1	23	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   4173	1	23	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   4224	1	23	localThrowable3	Throwable
    //   651	2261	24	localObject4	Object
    //   3078	6	24	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   3194	458	24	localBitmap	Bitmap
    //   3814	6	24	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   456	3286	25	localStringBuilder	StringBuilder
    //   63	3096	26	localObject5	Object
    //   1541	1142	27	localOptions	android.graphics.BitmapFactory.Options
    //   3346	265	28	arrayOfInt	int[]
    //   3417	196	29	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   482	491	1364	java/lang/OutOfMemoryError
    //   511	517	1364	java/lang/OutOfMemoryError
    //   537	565	1364	java/lang/OutOfMemoryError
    //   590	597	1364	java/lang/OutOfMemoryError
    //   617	624	1364	java/lang/OutOfMemoryError
    //   644	653	1364	java/lang/OutOfMemoryError
    //   673	689	1364	java/lang/OutOfMemoryError
    //   709	725	1364	java/lang/OutOfMemoryError
    //   872	878	1364	java/lang/OutOfMemoryError
    //   898	925	1364	java/lang/OutOfMemoryError
    //   1746	1754	3017	java/lang/OutOfMemoryError
    //   1773	1783	3017	java/lang/OutOfMemoryError
    //   1802	1808	3017	java/lang/OutOfMemoryError
    //   1827	1871	3017	java/lang/OutOfMemoryError
    //   1890	1895	3017	java/lang/OutOfMemoryError
    //   1922	1933	3017	java/lang/OutOfMemoryError
    //   2035	2043	3078	java/lang/OutOfMemoryError
    //   2062	2069	3078	java/lang/OutOfMemoryError
    //   2088	2094	3078	java/lang/OutOfMemoryError
    //   2113	2141	3078	java/lang/OutOfMemoryError
    //   2160	2165	3078	java/lang/OutOfMemoryError
    //   3158	3166	3764	java/lang/OutOfMemoryError
    //   3189	3196	3764	java/lang/OutOfMemoryError
    //   3219	3225	3764	java/lang/OutOfMemoryError
    //   3248	3276	3764	java/lang/OutOfMemoryError
    //   3299	3304	3764	java/lang/OutOfMemoryError
    //   3339	3348	3764	java/lang/OutOfMemoryError
    //   3371	3387	3764	java/lang/OutOfMemoryError
    //   3410	3419	3764	java/lang/OutOfMemoryError
    //   3442	3454	3764	java/lang/OutOfMemoryError
    //   3477	3497	3764	java/lang/OutOfMemoryError
    //   3530	3550	3764	java/lang/OutOfMemoryError
    //   3573	3585	3764	java/lang/OutOfMemoryError
    //   3608	3628	3764	java/lang/OutOfMemoryError
    //   3651	3656	3764	java/lang/OutOfMemoryError
    //   3683	3689	3764	java/lang/OutOfMemoryError
    //   3712	3753	3764	java/lang/OutOfMemoryError
    //   2652	2660	3814	java/lang/OutOfMemoryError
    //   2679	2689	3814	java/lang/OutOfMemoryError
    //   2708	2714	3814	java/lang/OutOfMemoryError
    //   2733	2761	3814	java/lang/OutOfMemoryError
    //   2780	2785	3814	java/lang/OutOfMemoryError
    //   59	65	3878	java/io/IOException
    //   81	88	3878	java/io/IOException
    //   120	130	3878	java/io/IOException
    //   146	151	3878	java/io/IOException
    //   177	187	3878	java/io/IOException
    //   203	208	3878	java/io/IOException
    //   224	230	3878	java/io/IOException
    //   246	303	3878	java/io/IOException
    //   319	324	3878	java/io/IOException
    //   348	362	3878	java/io/IOException
    //   378	384	3878	java/io/IOException
    //   400	433	3878	java/io/IOException
    //   449	458	3878	java/io/IOException
    //   482	491	3878	java/io/IOException
    //   511	517	3878	java/io/IOException
    //   537	565	3878	java/io/IOException
    //   590	597	3878	java/io/IOException
    //   617	624	3878	java/io/IOException
    //   644	653	3878	java/io/IOException
    //   673	689	3878	java/io/IOException
    //   709	725	3878	java/io/IOException
    //   872	878	3878	java/io/IOException
    //   898	925	3878	java/io/IOException
    //   986	995	3878	java/io/IOException
    //   1011	1020	3878	java/io/IOException
    //   1036	1044	3878	java/io/IOException
    //   1060	1077	3878	java/io/IOException
    //   1105	1116	3878	java/io/IOException
    //   1132	1138	3878	java/io/IOException
    //   1154	1208	3878	java/io/IOException
    //   1232	1236	3878	java/io/IOException
    //   1256	1260	3878	java/io/IOException
    //   1288	1299	3878	java/io/IOException
    //   1386	1391	3878	java/io/IOException
    //   1407	1413	3878	java/io/IOException
    //   1429	1441	3878	java/io/IOException
    //   1460	1465	3878	java/io/IOException
    //   1481	1487	3878	java/io/IOException
    //   1503	1515	3878	java/io/IOException
    //   1534	1543	3878	java/io/IOException
    //   1559	1565	3878	java/io/IOException
    //   1581	1589	3878	java/io/IOException
    //   1605	1609	3878	java/io/IOException
    //   1627	1634	3878	java/io/IOException
    //   1650	1657	3878	java/io/IOException
    //   1692	1708	3878	java/io/IOException
    //   1724	1730	3878	java/io/IOException
    //   1746	1754	3878	java/io/IOException
    //   1773	1783	3878	java/io/IOException
    //   1802	1808	3878	java/io/IOException
    //   1827	1871	3878	java/io/IOException
    //   1890	1895	3878	java/io/IOException
    //   1922	1933	3878	java/io/IOException
    //   2557	2566	3878	java/io/IOException
    //   2587	2596	3878	java/io/IOException
    //   2620	2636	3878	java/io/IOException
    //   2652	2660	3878	java/io/IOException
    //   2679	2689	3878	java/io/IOException
    //   2708	2714	3878	java/io/IOException
    //   2733	2761	3878	java/io/IOException
    //   2780	2785	3878	java/io/IOException
    //   2808	2815	3878	java/io/IOException
    //   2831	2838	3878	java/io/IOException
    //   2854	2863	3878	java/io/IOException
    //   2879	2895	3878	java/io/IOException
    //   2911	2916	3878	java/io/IOException
    //   2932	2948	3878	java/io/IOException
    //   3035	3040	3878	java/io/IOException
    //   3056	3060	3878	java/io/IOException
    //   3838	3842	3878	java/io/IOException
    //   3858	3863	3878	java/io/IOException
    //   59	65	3915	java/lang/RuntimeException
    //   81	88	3915	java/lang/RuntimeException
    //   120	130	3915	java/lang/RuntimeException
    //   146	151	3915	java/lang/RuntimeException
    //   177	187	3915	java/lang/RuntimeException
    //   203	208	3915	java/lang/RuntimeException
    //   224	230	3915	java/lang/RuntimeException
    //   246	303	3915	java/lang/RuntimeException
    //   319	324	3915	java/lang/RuntimeException
    //   348	362	3915	java/lang/RuntimeException
    //   378	384	3915	java/lang/RuntimeException
    //   400	433	3915	java/lang/RuntimeException
    //   449	458	3915	java/lang/RuntimeException
    //   482	491	3915	java/lang/RuntimeException
    //   511	517	3915	java/lang/RuntimeException
    //   537	565	3915	java/lang/RuntimeException
    //   590	597	3915	java/lang/RuntimeException
    //   617	624	3915	java/lang/RuntimeException
    //   644	653	3915	java/lang/RuntimeException
    //   673	689	3915	java/lang/RuntimeException
    //   709	725	3915	java/lang/RuntimeException
    //   872	878	3915	java/lang/RuntimeException
    //   898	925	3915	java/lang/RuntimeException
    //   986	995	3915	java/lang/RuntimeException
    //   1011	1020	3915	java/lang/RuntimeException
    //   1036	1044	3915	java/lang/RuntimeException
    //   1060	1077	3915	java/lang/RuntimeException
    //   1105	1116	3915	java/lang/RuntimeException
    //   1132	1138	3915	java/lang/RuntimeException
    //   1154	1208	3915	java/lang/RuntimeException
    //   1232	1236	3915	java/lang/RuntimeException
    //   1256	1260	3915	java/lang/RuntimeException
    //   1288	1299	3915	java/lang/RuntimeException
    //   1386	1391	3915	java/lang/RuntimeException
    //   1407	1413	3915	java/lang/RuntimeException
    //   1429	1441	3915	java/lang/RuntimeException
    //   1460	1465	3915	java/lang/RuntimeException
    //   1481	1487	3915	java/lang/RuntimeException
    //   1503	1515	3915	java/lang/RuntimeException
    //   1534	1543	3915	java/lang/RuntimeException
    //   1559	1565	3915	java/lang/RuntimeException
    //   1581	1589	3915	java/lang/RuntimeException
    //   1605	1609	3915	java/lang/RuntimeException
    //   1627	1634	3915	java/lang/RuntimeException
    //   1650	1657	3915	java/lang/RuntimeException
    //   1692	1708	3915	java/lang/RuntimeException
    //   1724	1730	3915	java/lang/RuntimeException
    //   1746	1754	3915	java/lang/RuntimeException
    //   1773	1783	3915	java/lang/RuntimeException
    //   1802	1808	3915	java/lang/RuntimeException
    //   1827	1871	3915	java/lang/RuntimeException
    //   1890	1895	3915	java/lang/RuntimeException
    //   1922	1933	3915	java/lang/RuntimeException
    //   2557	2566	3915	java/lang/RuntimeException
    //   2587	2596	3915	java/lang/RuntimeException
    //   2620	2636	3915	java/lang/RuntimeException
    //   2652	2660	3915	java/lang/RuntimeException
    //   2679	2689	3915	java/lang/RuntimeException
    //   2708	2714	3915	java/lang/RuntimeException
    //   2733	2761	3915	java/lang/RuntimeException
    //   2780	2785	3915	java/lang/RuntimeException
    //   2808	2815	3915	java/lang/RuntimeException
    //   2831	2838	3915	java/lang/RuntimeException
    //   2854	2863	3915	java/lang/RuntimeException
    //   2879	2895	3915	java/lang/RuntimeException
    //   2911	2916	3915	java/lang/RuntimeException
    //   2932	2948	3915	java/lang/RuntimeException
    //   3035	3040	3915	java/lang/RuntimeException
    //   3056	3060	3915	java/lang/RuntimeException
    //   3838	3842	3915	java/lang/RuntimeException
    //   3858	3863	3915	java/lang/RuntimeException
    //   59	65	3948	java/lang/UnsatisfiedLinkError
    //   81	88	3948	java/lang/UnsatisfiedLinkError
    //   120	130	3948	java/lang/UnsatisfiedLinkError
    //   146	151	3948	java/lang/UnsatisfiedLinkError
    //   177	187	3948	java/lang/UnsatisfiedLinkError
    //   203	208	3948	java/lang/UnsatisfiedLinkError
    //   224	230	3948	java/lang/UnsatisfiedLinkError
    //   246	303	3948	java/lang/UnsatisfiedLinkError
    //   319	324	3948	java/lang/UnsatisfiedLinkError
    //   348	362	3948	java/lang/UnsatisfiedLinkError
    //   378	384	3948	java/lang/UnsatisfiedLinkError
    //   400	433	3948	java/lang/UnsatisfiedLinkError
    //   449	458	3948	java/lang/UnsatisfiedLinkError
    //   482	491	3948	java/lang/UnsatisfiedLinkError
    //   511	517	3948	java/lang/UnsatisfiedLinkError
    //   537	565	3948	java/lang/UnsatisfiedLinkError
    //   590	597	3948	java/lang/UnsatisfiedLinkError
    //   617	624	3948	java/lang/UnsatisfiedLinkError
    //   644	653	3948	java/lang/UnsatisfiedLinkError
    //   673	689	3948	java/lang/UnsatisfiedLinkError
    //   709	725	3948	java/lang/UnsatisfiedLinkError
    //   872	878	3948	java/lang/UnsatisfiedLinkError
    //   898	925	3948	java/lang/UnsatisfiedLinkError
    //   986	995	3948	java/lang/UnsatisfiedLinkError
    //   1011	1020	3948	java/lang/UnsatisfiedLinkError
    //   1036	1044	3948	java/lang/UnsatisfiedLinkError
    //   1060	1077	3948	java/lang/UnsatisfiedLinkError
    //   1105	1116	3948	java/lang/UnsatisfiedLinkError
    //   1132	1138	3948	java/lang/UnsatisfiedLinkError
    //   1154	1208	3948	java/lang/UnsatisfiedLinkError
    //   1232	1236	3948	java/lang/UnsatisfiedLinkError
    //   1256	1260	3948	java/lang/UnsatisfiedLinkError
    //   1288	1299	3948	java/lang/UnsatisfiedLinkError
    //   1386	1391	3948	java/lang/UnsatisfiedLinkError
    //   1407	1413	3948	java/lang/UnsatisfiedLinkError
    //   1429	1441	3948	java/lang/UnsatisfiedLinkError
    //   1460	1465	3948	java/lang/UnsatisfiedLinkError
    //   1481	1487	3948	java/lang/UnsatisfiedLinkError
    //   1503	1515	3948	java/lang/UnsatisfiedLinkError
    //   1534	1543	3948	java/lang/UnsatisfiedLinkError
    //   1559	1565	3948	java/lang/UnsatisfiedLinkError
    //   1581	1589	3948	java/lang/UnsatisfiedLinkError
    //   1605	1609	3948	java/lang/UnsatisfiedLinkError
    //   1627	1634	3948	java/lang/UnsatisfiedLinkError
    //   1650	1657	3948	java/lang/UnsatisfiedLinkError
    //   1692	1708	3948	java/lang/UnsatisfiedLinkError
    //   1724	1730	3948	java/lang/UnsatisfiedLinkError
    //   1746	1754	3948	java/lang/UnsatisfiedLinkError
    //   1773	1783	3948	java/lang/UnsatisfiedLinkError
    //   1802	1808	3948	java/lang/UnsatisfiedLinkError
    //   1827	1871	3948	java/lang/UnsatisfiedLinkError
    //   1890	1895	3948	java/lang/UnsatisfiedLinkError
    //   1922	1933	3948	java/lang/UnsatisfiedLinkError
    //   2557	2566	3948	java/lang/UnsatisfiedLinkError
    //   2587	2596	3948	java/lang/UnsatisfiedLinkError
    //   2620	2636	3948	java/lang/UnsatisfiedLinkError
    //   2652	2660	3948	java/lang/UnsatisfiedLinkError
    //   2679	2689	3948	java/lang/UnsatisfiedLinkError
    //   2708	2714	3948	java/lang/UnsatisfiedLinkError
    //   2733	2761	3948	java/lang/UnsatisfiedLinkError
    //   2780	2785	3948	java/lang/UnsatisfiedLinkError
    //   2808	2815	3948	java/lang/UnsatisfiedLinkError
    //   2831	2838	3948	java/lang/UnsatisfiedLinkError
    //   2854	2863	3948	java/lang/UnsatisfiedLinkError
    //   2879	2895	3948	java/lang/UnsatisfiedLinkError
    //   2911	2916	3948	java/lang/UnsatisfiedLinkError
    //   2932	2948	3948	java/lang/UnsatisfiedLinkError
    //   3035	3040	3948	java/lang/UnsatisfiedLinkError
    //   3056	3060	3948	java/lang/UnsatisfiedLinkError
    //   3838	3842	3948	java/lang/UnsatisfiedLinkError
    //   3858	3863	3948	java/lang/UnsatisfiedLinkError
    //   59	65	3981	java/lang/Throwable
    //   81	88	3981	java/lang/Throwable
    //   120	130	3981	java/lang/Throwable
    //   146	151	3981	java/lang/Throwable
    //   177	187	3981	java/lang/Throwable
    //   203	208	3981	java/lang/Throwable
    //   224	230	3981	java/lang/Throwable
    //   246	303	3981	java/lang/Throwable
    //   319	324	3981	java/lang/Throwable
    //   348	362	3981	java/lang/Throwable
    //   378	384	3981	java/lang/Throwable
    //   400	433	3981	java/lang/Throwable
    //   449	458	3981	java/lang/Throwable
    //   986	995	3981	java/lang/Throwable
    //   1011	1020	3981	java/lang/Throwable
    //   1036	1044	3981	java/lang/Throwable
    //   1060	1077	3981	java/lang/Throwable
    //   1105	1116	3981	java/lang/Throwable
    //   1132	1138	3981	java/lang/Throwable
    //   1154	1208	3981	java/lang/Throwable
    //   1232	1236	3981	java/lang/Throwable
    //   1256	1260	3981	java/lang/Throwable
    //   1288	1299	3981	java/lang/Throwable
    //   1386	1391	3981	java/lang/Throwable
    //   1407	1413	3981	java/lang/Throwable
    //   1429	1441	3981	java/lang/Throwable
    //   1460	1465	3981	java/lang/Throwable
    //   1481	1487	3981	java/lang/Throwable
    //   1503	1515	3981	java/lang/Throwable
    //   1534	1543	3981	java/lang/Throwable
    //   1559	1565	3981	java/lang/Throwable
    //   1581	1589	3981	java/lang/Throwable
    //   1605	1609	3981	java/lang/Throwable
    //   1627	1634	3981	java/lang/Throwable
    //   1650	1657	3981	java/lang/Throwable
    //   1692	1708	3981	java/lang/Throwable
    //   1724	1730	3981	java/lang/Throwable
    //   1746	1754	3981	java/lang/Throwable
    //   1773	1783	3981	java/lang/Throwable
    //   1802	1808	3981	java/lang/Throwable
    //   1827	1871	3981	java/lang/Throwable
    //   1890	1895	3981	java/lang/Throwable
    //   1922	1933	3981	java/lang/Throwable
    //   2557	2566	3981	java/lang/Throwable
    //   2587	2596	3981	java/lang/Throwable
    //   2620	2636	3981	java/lang/Throwable
    //   2652	2660	3981	java/lang/Throwable
    //   2679	2689	3981	java/lang/Throwable
    //   2708	2714	3981	java/lang/Throwable
    //   2733	2761	3981	java/lang/Throwable
    //   2780	2785	3981	java/lang/Throwable
    //   2808	2815	3981	java/lang/Throwable
    //   2831	2838	3981	java/lang/Throwable
    //   2854	2863	3981	java/lang/Throwable
    //   2879	2895	3981	java/lang/Throwable
    //   2911	2916	3981	java/lang/Throwable
    //   2932	2948	3981	java/lang/Throwable
    //   3035	3040	3981	java/lang/Throwable
    //   3056	3060	3981	java/lang/Throwable
    //   3838	3842	3981	java/lang/Throwable
    //   3858	3863	3981	java/lang/Throwable
    //   1960	1969	4014	java/lang/Throwable
    //   2035	2043	4014	java/lang/Throwable
    //   2062	2069	4014	java/lang/Throwable
    //   2088	2094	4014	java/lang/Throwable
    //   2113	2141	4014	java/lang/Throwable
    //   2160	2165	4014	java/lang/Throwable
    //   2190	2198	4014	java/lang/Throwable
    //   2218	2233	4014	java/lang/Throwable
    //   2253	2262	4014	java/lang/Throwable
    //   2282	2293	4014	java/lang/Throwable
    //   2313	2332	4014	java/lang/Throwable
    //   2358	2377	4014	java/lang/Throwable
    //   2397	2408	4014	java/lang/Throwable
    //   2428	2444	4014	java/lang/Throwable
    //   3102	3106	4014	java/lang/Throwable
    //   3122	3127	4014	java/lang/Throwable
    //   3158	3166	4014	java/lang/Throwable
    //   3189	3196	4014	java/lang/Throwable
    //   3219	3225	4014	java/lang/Throwable
    //   3248	3276	4014	java/lang/Throwable
    //   3299	3304	4014	java/lang/Throwable
    //   3339	3348	4014	java/lang/Throwable
    //   3371	3387	4014	java/lang/Throwable
    //   3410	3419	4014	java/lang/Throwable
    //   3442	3454	4014	java/lang/Throwable
    //   3477	3497	4014	java/lang/Throwable
    //   3530	3550	4014	java/lang/Throwable
    //   3573	3585	4014	java/lang/Throwable
    //   3608	3628	4014	java/lang/Throwable
    //   3651	3656	4014	java/lang/Throwable
    //   3683	3689	4014	java/lang/Throwable
    //   3712	3753	4014	java/lang/Throwable
    //   3782	3787	4014	java/lang/Throwable
    //   3803	3807	4014	java/lang/Throwable
    //   2463	2468	4022	java/lang/Throwable
    //   2480	2486	4022	java/lang/Throwable
    //   2498	2539	4022	java/lang/Throwable
    //   2959	3006	4030	java/lang/Throwable
    //   725	772	4038	java/lang/UnsatisfiedLinkError
    //   772	793	4038	java/lang/UnsatisfiedLinkError
    //   811	823	4038	java/lang/UnsatisfiedLinkError
    //   828	845	4038	java/lang/UnsatisfiedLinkError
    //   937	942	4046	java/lang/UnsatisfiedLinkError
    //   2463	2468	4046	java/lang/UnsatisfiedLinkError
    //   2480	2486	4046	java/lang/UnsatisfiedLinkError
    //   2498	2539	4046	java/lang/UnsatisfiedLinkError
    //   1960	1969	4054	java/lang/UnsatisfiedLinkError
    //   2035	2043	4054	java/lang/UnsatisfiedLinkError
    //   2062	2069	4054	java/lang/UnsatisfiedLinkError
    //   2088	2094	4054	java/lang/UnsatisfiedLinkError
    //   2113	2141	4054	java/lang/UnsatisfiedLinkError
    //   2160	2165	4054	java/lang/UnsatisfiedLinkError
    //   2190	2198	4054	java/lang/UnsatisfiedLinkError
    //   2218	2233	4054	java/lang/UnsatisfiedLinkError
    //   2253	2262	4054	java/lang/UnsatisfiedLinkError
    //   2282	2293	4054	java/lang/UnsatisfiedLinkError
    //   2313	2332	4054	java/lang/UnsatisfiedLinkError
    //   2358	2377	4054	java/lang/UnsatisfiedLinkError
    //   2397	2408	4054	java/lang/UnsatisfiedLinkError
    //   2428	2444	4054	java/lang/UnsatisfiedLinkError
    //   3102	3106	4054	java/lang/UnsatisfiedLinkError
    //   3122	3127	4054	java/lang/UnsatisfiedLinkError
    //   3158	3166	4054	java/lang/UnsatisfiedLinkError
    //   3189	3196	4054	java/lang/UnsatisfiedLinkError
    //   3219	3225	4054	java/lang/UnsatisfiedLinkError
    //   3248	3276	4054	java/lang/UnsatisfiedLinkError
    //   3299	3304	4054	java/lang/UnsatisfiedLinkError
    //   3339	3348	4054	java/lang/UnsatisfiedLinkError
    //   3371	3387	4054	java/lang/UnsatisfiedLinkError
    //   3410	3419	4054	java/lang/UnsatisfiedLinkError
    //   3442	3454	4054	java/lang/UnsatisfiedLinkError
    //   3477	3497	4054	java/lang/UnsatisfiedLinkError
    //   3530	3550	4054	java/lang/UnsatisfiedLinkError
    //   3573	3585	4054	java/lang/UnsatisfiedLinkError
    //   3608	3628	4054	java/lang/UnsatisfiedLinkError
    //   3651	3656	4054	java/lang/UnsatisfiedLinkError
    //   3683	3689	4054	java/lang/UnsatisfiedLinkError
    //   3712	3753	4054	java/lang/UnsatisfiedLinkError
    //   3782	3787	4054	java/lang/UnsatisfiedLinkError
    //   3803	3807	4054	java/lang/UnsatisfiedLinkError
    //   2959	3006	4058	java/lang/UnsatisfiedLinkError
    //   725	772	4066	java/lang/RuntimeException
    //   772	793	4066	java/lang/RuntimeException
    //   811	823	4066	java/lang/RuntimeException
    //   828	845	4066	java/lang/RuntimeException
    //   937	942	4074	java/lang/RuntimeException
    //   2463	2468	4074	java/lang/RuntimeException
    //   2480	2486	4074	java/lang/RuntimeException
    //   2498	2539	4074	java/lang/RuntimeException
    //   1960	1969	4078	java/lang/RuntimeException
    //   2035	2043	4078	java/lang/RuntimeException
    //   2062	2069	4078	java/lang/RuntimeException
    //   2088	2094	4078	java/lang/RuntimeException
    //   2113	2141	4078	java/lang/RuntimeException
    //   2160	2165	4078	java/lang/RuntimeException
    //   2190	2198	4078	java/lang/RuntimeException
    //   2218	2233	4078	java/lang/RuntimeException
    //   2253	2262	4078	java/lang/RuntimeException
    //   2282	2293	4078	java/lang/RuntimeException
    //   2313	2332	4078	java/lang/RuntimeException
    //   2358	2377	4078	java/lang/RuntimeException
    //   2397	2408	4078	java/lang/RuntimeException
    //   2428	2444	4078	java/lang/RuntimeException
    //   3102	3106	4078	java/lang/RuntimeException
    //   3122	3127	4078	java/lang/RuntimeException
    //   3158	3166	4078	java/lang/RuntimeException
    //   3189	3196	4078	java/lang/RuntimeException
    //   3219	3225	4078	java/lang/RuntimeException
    //   3248	3276	4078	java/lang/RuntimeException
    //   3299	3304	4078	java/lang/RuntimeException
    //   3339	3348	4078	java/lang/RuntimeException
    //   3371	3387	4078	java/lang/RuntimeException
    //   3410	3419	4078	java/lang/RuntimeException
    //   3442	3454	4078	java/lang/RuntimeException
    //   3477	3497	4078	java/lang/RuntimeException
    //   3530	3550	4078	java/lang/RuntimeException
    //   3573	3585	4078	java/lang/RuntimeException
    //   3608	3628	4078	java/lang/RuntimeException
    //   3651	3656	4078	java/lang/RuntimeException
    //   3683	3689	4078	java/lang/RuntimeException
    //   3712	3753	4078	java/lang/RuntimeException
    //   3782	3787	4078	java/lang/RuntimeException
    //   3803	3807	4078	java/lang/RuntimeException
    //   2959	3006	4086	java/lang/RuntimeException
    //   725	772	4094	java/io/IOException
    //   772	793	4094	java/io/IOException
    //   811	823	4094	java/io/IOException
    //   828	845	4094	java/io/IOException
    //   937	942	4102	java/io/IOException
    //   2463	2468	4102	java/io/IOException
    //   2480	2486	4102	java/io/IOException
    //   2498	2539	4102	java/io/IOException
    //   1960	1969	4110	java/io/IOException
    //   2035	2043	4110	java/io/IOException
    //   2062	2069	4110	java/io/IOException
    //   2088	2094	4110	java/io/IOException
    //   2113	2141	4110	java/io/IOException
    //   2160	2165	4110	java/io/IOException
    //   2190	2198	4110	java/io/IOException
    //   2218	2233	4110	java/io/IOException
    //   2253	2262	4110	java/io/IOException
    //   2282	2293	4110	java/io/IOException
    //   2313	2332	4110	java/io/IOException
    //   2358	2377	4110	java/io/IOException
    //   2397	2408	4110	java/io/IOException
    //   2428	2444	4110	java/io/IOException
    //   3102	3106	4110	java/io/IOException
    //   3122	3127	4110	java/io/IOException
    //   3158	3166	4110	java/io/IOException
    //   3189	3196	4110	java/io/IOException
    //   3219	3225	4110	java/io/IOException
    //   3248	3276	4110	java/io/IOException
    //   3299	3304	4110	java/io/IOException
    //   3339	3348	4110	java/io/IOException
    //   3371	3387	4110	java/io/IOException
    //   3410	3419	4110	java/io/IOException
    //   3442	3454	4110	java/io/IOException
    //   3477	3497	4110	java/io/IOException
    //   3530	3550	4110	java/io/IOException
    //   3573	3585	4110	java/io/IOException
    //   3608	3628	4110	java/io/IOException
    //   3651	3656	4110	java/io/IOException
    //   3683	3689	4110	java/io/IOException
    //   3712	3753	4110	java/io/IOException
    //   3782	3787	4110	java/io/IOException
    //   3803	3807	4110	java/io/IOException
    //   2959	3006	4118	java/io/IOException
    //   2808	2815	4126	java/lang/OutOfMemoryError
    //   2831	2838	4126	java/lang/OutOfMemoryError
    //   2854	2863	4126	java/lang/OutOfMemoryError
    //   2879	2895	4126	java/lang/OutOfMemoryError
    //   2911	2916	4126	java/lang/OutOfMemoryError
    //   2932	2948	4126	java/lang/OutOfMemoryError
    //   2959	3006	4133	java/lang/OutOfMemoryError
    //   2190	2198	4140	java/lang/OutOfMemoryError
    //   2218	2233	4140	java/lang/OutOfMemoryError
    //   2253	2262	4140	java/lang/OutOfMemoryError
    //   2282	2293	4140	java/lang/OutOfMemoryError
    //   2313	2332	4140	java/lang/OutOfMemoryError
    //   2358	2377	4140	java/lang/OutOfMemoryError
    //   2397	2408	4140	java/lang/OutOfMemoryError
    //   2428	2444	4140	java/lang/OutOfMemoryError
    //   2463	2468	4151	java/lang/OutOfMemoryError
    //   2480	2486	4151	java/lang/OutOfMemoryError
    //   2498	2539	4151	java/lang/OutOfMemoryError
    //   725	772	4158	java/lang/Throwable
    //   772	793	4158	java/lang/Throwable
    //   811	823	4158	java/lang/Throwable
    //   828	845	4158	java/lang/Throwable
    //   937	942	4163	java/lang/Throwable
    //   725	772	4168	java/lang/OutOfMemoryError
    //   772	793	4168	java/lang/OutOfMemoryError
    //   811	823	4168	java/lang/OutOfMemoryError
    //   828	845	4168	java/lang/OutOfMemoryError
    //   937	942	4173	java/lang/OutOfMemoryError
    //   482	491	4224	java/lang/Throwable
    //   511	517	4224	java/lang/Throwable
    //   537	565	4224	java/lang/Throwable
    //   590	597	4224	java/lang/Throwable
    //   617	624	4224	java/lang/Throwable
    //   644	653	4224	java/lang/Throwable
    //   673	689	4224	java/lang/Throwable
    //   709	725	4224	java/lang/Throwable
    //   872	878	4224	java/lang/Throwable
    //   898	925	4224	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[paramInt1 * paramInt2];
    }
    ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    return bdsg.a(arrayOfByte, paramInt1, paramInt2, 0);
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
        if (bdsg.a(paramArrayOfInt, paramInt1, paramInt2, 0) == 1) {
          i = 1;
        }
      }
      if ((paramInt3 & 0x2) == 2)
      {
        paramArrayOfInt = aljj.a().a(paramArrayOfInt, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramInt7, 1);
        if (aljj.a(paramArrayOfInt))
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
    //   34: ifnull +1832 -> 1866
    //   37: iconst_0
    //   38: ldc 163
    //   40: ldc 165
    //   42: invokestatic 170	bdsg:a	(ILjava/lang/String;Ljava/lang/String;)I
    //   45: istore 5
    //   47: iconst_2
    //   48: newarray int
    //   50: astore 12
    //   52: aload 12
    //   54: iconst_0
    //   55: iconst_2
    //   56: iastore
    //   57: aload 12
    //   59: iconst_1
    //   60: iconst_1
    //   61: iastore
    //   62: aload 12
    //   64: aload 12
    //   66: arraylength
    //   67: invokestatic 173	bdsg:a	([II)I
    //   70: istore 6
    //   72: invokestatic 175	bdsg:a	()Ljava/lang/String;
    //   75: astore 12
    //   77: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   80: ifeq +60 -> 140
    //   83: ldc 71
    //   85: iconst_4
    //   86: new 136	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 396
    //   96: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 5
    //   101: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc 189
    //   106: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload 6
    //   111: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc 191
    //   116: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 12
    //   121: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 289
    //   127: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_3
    //   131: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iload_3
    //   141: ifeq +299 -> 440
    //   144: aload_0
    //   145: invokevirtual 297	android/net/Uri:getPath	()Ljava/lang/String;
    //   148: invokestatic 303	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   151: astore_0
    //   152: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   155: ifeq +29 -> 184
    //   158: ldc 71
    //   160: iconst_4
    //   161: new 136	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 305
    //   171: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: ifnull +1675 -> 1860
    //   188: aload_0
    //   189: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   192: istore 5
    //   194: aload_0
    //   195: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   198: istore 6
    //   200: iload 5
    //   202: iload 6
    //   204: imul
    //   205: newarray int
    //   207: astore 12
    //   209: aload_0
    //   210: aload 12
    //   212: iconst_0
    //   213: iload 5
    //   215: iconst_0
    //   216: iconst_0
    //   217: iload 5
    //   219: iload 6
    //   221: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   224: aload_0
    //   225: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   228: aload 12
    //   230: aconst_null
    //   231: iload 5
    //   233: iload 6
    //   235: invokestatic 398	whm:a	([I[BII)I
    //   238: istore 5
    //   240: iload 5
    //   242: istore 4
    //   244: iload 4
    //   246: istore 5
    //   248: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   251: ifeq +34 -> 285
    //   254: ldc 71
    //   256: iconst_4
    //   257: new 136	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   264: ldc_w 400
    //   267: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload 4
    //   272: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: iload 4
    //   283: istore 5
    //   285: iload 5
    //   287: istore 4
    //   289: aload_1
    //   290: astore 12
    //   292: iload 4
    //   294: iconst_1
    //   295: if_icmpne +1551 -> 1846
    //   298: iload_2
    //   299: ifeq +1351 -> 1650
    //   302: new 136	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   309: astore_0
    //   310: new 136	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   317: astore_1
    //   318: aload_0
    //   319: aload_1
    //   320: invokestatic 225	bdsg:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   323: pop
    //   324: new 227	android/util/Pair
    //   327: dup
    //   328: aload_1
    //   329: aload_0
    //   330: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   333: astore_0
    //   334: invokestatic 239	bdsg:a	()I
    //   337: pop
    //   338: aload_0
    //   339: astore_1
    //   340: aload 12
    //   342: ifnull +10 -> 352
    //   345: aload 12
    //   347: invokevirtual 320	java/io/InputStream:close	()V
    //   350: aload_0
    //   351: astore_1
    //   352: aload_1
    //   353: astore_0
    //   354: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq -347 -> 10
    //   360: ldc 71
    //   362: iconst_4
    //   363: new 136	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 402
    //   373: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   379: lload 10
    //   381: lsub
    //   382: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_1
    //   392: areturn
    //   393: astore_0
    //   394: aload_0
    //   395: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   398: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +1470 -> 1871
    //   404: ldc 71
    //   406: iconst_2
    //   407: aload_0
    //   408: invokevirtual 326	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   411: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: goto +1457 -> 1871
    //   417: aload_0
    //   418: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   421: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +1457 -> 1881
    //   427: ldc 71
    //   429: iconst_2
    //   430: aload_0
    //   431: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   434: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: goto +1444 -> 1881
    //   440: new 328	android/graphics/BitmapFactory$Options
    //   443: dup
    //   444: invokespecial 329	android/graphics/BitmapFactory$Options:<init>	()V
    //   447: astore 15
    //   449: aload 15
    //   451: iconst_1
    //   452: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   455: aload_1
    //   456: aconst_null
    //   457: aload 15
    //   459: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   462: pop
    //   463: aload_1
    //   464: invokevirtual 320	java/io/InputStream:close	()V
    //   467: aconst_null
    //   468: astore_1
    //   469: aload 15
    //   471: getfield 342	android/graphics/BitmapFactory$Options:outWidth	I
    //   474: istore 7
    //   476: aload 15
    //   478: getfield 345	android/graphics/BitmapFactory$Options:outHeight	I
    //   481: istore 8
    //   483: aload 15
    //   485: iconst_0
    //   486: putfield 333	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   489: iload 7
    //   491: sipush 12800
    //   494: if_icmpgt +1393 -> 1887
    //   497: iload 8
    //   499: sipush 12800
    //   502: if_icmple +6 -> 508
    //   505: goto +1382 -> 1887
    //   508: iload 7
    //   510: iload 8
    //   512: imul
    //   513: ldc_w 403
    //   516: if_icmple +745 -> 1261
    //   519: aload 15
    //   521: iload 7
    //   523: iload 8
    //   525: imul
    //   526: i2d
    //   527: invokestatic 406	java/lang/Math:sqrt	(D)D
    //   530: ldc2_w 407
    //   533: ddiv
    //   534: invokestatic 222	java/lang/Math:ceil	(D)D
    //   537: d2i
    //   538: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   541: aload 14
    //   543: aload_0
    //   544: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   547: astore 12
    //   549: aload 12
    //   551: astore_1
    //   552: aload 12
    //   554: aconst_null
    //   555: aload 15
    //   557: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   560: astore 13
    //   562: aload 12
    //   564: astore_1
    //   565: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +69 -> 637
    //   571: aload 12
    //   573: astore_1
    //   574: ldc 71
    //   576: iconst_4
    //   577: new 136	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 410
    //   587: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload 13
    //   592: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   595: ldc_w 412
    //   598: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 7
    //   603: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc_w 414
    //   609: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: iload 8
    //   614: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: ldc_w 416
    //   620: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 15
    //   625: getfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   628: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload 12
    //   639: astore_1
    //   640: aload 12
    //   642: invokevirtual 320	java/io/InputStream:close	()V
    //   645: iload 4
    //   647: istore 6
    //   649: aload 13
    //   651: ifnull +129 -> 780
    //   654: iload 4
    //   656: istore 5
    //   658: aload 13
    //   660: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   663: istore 6
    //   665: iload 4
    //   667: istore 5
    //   669: aload 13
    //   671: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   674: istore 9
    //   676: iload 4
    //   678: istore 5
    //   680: iload 6
    //   682: iload 9
    //   684: imul
    //   685: newarray int
    //   687: astore_1
    //   688: iload 4
    //   690: istore 5
    //   692: aload 13
    //   694: aload_1
    //   695: iconst_0
    //   696: iload 6
    //   698: iconst_0
    //   699: iconst_0
    //   700: iload 6
    //   702: iload 9
    //   704: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   707: iload 4
    //   709: istore 5
    //   711: aload 13
    //   713: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   716: iload 4
    //   718: istore 5
    //   720: aload_1
    //   721: aconst_null
    //   722: iload 6
    //   724: iload 9
    //   726: invokestatic 398	whm:a	([I[BII)I
    //   729: istore 4
    //   731: iload 4
    //   733: istore 6
    //   735: iload 4
    //   737: istore 5
    //   739: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   742: ifeq +38 -> 780
    //   745: iload 4
    //   747: istore 5
    //   749: ldc 71
    //   751: iconst_4
    //   752: new 136	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   759: ldc_w 418
    //   762: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: iload 4
    //   767: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: iload 4
    //   778: istore 6
    //   780: iload 6
    //   782: istore 4
    //   784: aconst_null
    //   785: astore 12
    //   787: aconst_null
    //   788: astore_1
    //   789: iload 4
    //   791: istore 5
    //   793: iload 4
    //   795: iconst_1
    //   796: if_icmpeq +234 -> 1030
    //   799: iload 7
    //   801: iconst_2
    //   802: imul
    //   803: iload 8
    //   805: if_icmpgt +534 -> 1339
    //   808: iload 7
    //   810: sipush 1280
    //   813: if_icmpge +526 -> 1339
    //   816: aload 14
    //   818: aload_0
    //   819: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   822: astore_1
    //   823: aload_1
    //   824: astore 12
    //   826: aload_1
    //   827: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   830: astore 13
    //   832: aload_1
    //   833: astore 12
    //   835: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   838: ifeq +33 -> 871
    //   841: aload_1
    //   842: astore 12
    //   844: ldc 71
    //   846: iconst_4
    //   847: new 136	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 420
    //   857: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 13
    //   862: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aload_1
    //   872: astore 12
    //   874: aload_1
    //   875: invokevirtual 320	java/io/InputStream:close	()V
    //   878: aload 13
    //   880: ifnull +977 -> 1857
    //   883: iload 4
    //   885: istore 5
    //   887: iload 7
    //   889: iload 7
    //   891: imul
    //   892: newarray int
    //   894: astore_1
    //   895: iload 4
    //   897: istore 5
    //   899: aload 13
    //   901: aload_1
    //   902: iconst_0
    //   903: iload 7
    //   905: iconst_0
    //   906: iconst_0
    //   907: iload 7
    //   909: iload 7
    //   911: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   914: iload 4
    //   916: istore 5
    //   918: iload 7
    //   920: iload 7
    //   922: imul
    //   923: newarray byte
    //   925: astore 12
    //   927: iload 4
    //   929: istore 5
    //   931: aload_1
    //   932: aload 12
    //   934: iload 7
    //   936: iload 7
    //   938: invokestatic 398	whm:a	([I[BII)I
    //   941: istore 4
    //   943: iload 4
    //   945: iconst_1
    //   946: if_icmpeq +908 -> 1854
    //   949: iload 4
    //   951: istore 5
    //   953: aload 13
    //   955: aload_1
    //   956: iconst_0
    //   957: iload 7
    //   959: iconst_0
    //   960: iload 8
    //   962: iload 7
    //   964: isub
    //   965: iload 7
    //   967: iload 7
    //   969: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   972: iload 4
    //   974: istore 5
    //   976: aload_1
    //   977: aload 12
    //   979: iload 7
    //   981: iload 7
    //   983: invokestatic 398	whm:a	([I[BII)I
    //   986: istore 4
    //   988: aload 13
    //   990: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   993: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   996: ifeq +30 -> 1026
    //   999: ldc 71
    //   1001: iconst_4
    //   1002: new 136	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 422
    //   1012: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: iload 4
    //   1017: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1020: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1023: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1026: iload 4
    //   1028: istore 5
    //   1030: aconst_null
    //   1031: astore 13
    //   1033: aconst_null
    //   1034: astore_1
    //   1035: aload_1
    //   1036: astore 12
    //   1038: iload 5
    //   1040: istore 4
    //   1042: iload 5
    //   1044: iconst_1
    //   1045: if_icmpeq -753 -> 292
    //   1048: iload 7
    //   1050: iload 8
    //   1052: invokestatic 216	java/lang/Math:min	(II)I
    //   1055: istore 6
    //   1057: aload_1
    //   1058: astore 12
    //   1060: iload 5
    //   1062: istore 4
    //   1064: iload 6
    //   1066: sipush 250
    //   1069: if_icmple -777 -> 292
    //   1072: aload 15
    //   1074: iload 6
    //   1076: i2d
    //   1077: ldc2_w 217
    //   1080: ddiv
    //   1081: invokestatic 222	java/lang/Math:ceil	(D)D
    //   1084: d2i
    //   1085: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1088: aload 13
    //   1090: astore_1
    //   1091: aload 14
    //   1093: aload_0
    //   1094: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1097: astore_0
    //   1098: aload_0
    //   1099: astore_1
    //   1100: aload_0
    //   1101: aconst_null
    //   1102: aload 15
    //   1104: invokestatic 339	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1107: astore 12
    //   1109: aload_0
    //   1110: astore_1
    //   1111: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1114: ifeq +32 -> 1146
    //   1117: aload_0
    //   1118: astore_1
    //   1119: ldc 71
    //   1121: iconst_4
    //   1122: new 136	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1129: ldc_w 424
    //   1132: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload 12
    //   1137: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_0
    //   1147: astore_1
    //   1148: aload_0
    //   1149: invokevirtual 320	java/io/InputStream:close	()V
    //   1152: aload 12
    //   1154: ifnull +697 -> 1851
    //   1157: aload 12
    //   1159: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   1162: istore 4
    //   1164: aload 12
    //   1166: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   1169: istore 6
    //   1171: iload 4
    //   1173: iload 6
    //   1175: imul
    //   1176: newarray int
    //   1178: astore_0
    //   1179: aload 12
    //   1181: aload_0
    //   1182: iconst_0
    //   1183: iload 4
    //   1185: iconst_0
    //   1186: iconst_0
    //   1187: iload 4
    //   1189: iload 6
    //   1191: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1194: aload 12
    //   1196: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   1199: aload_0
    //   1200: aconst_null
    //   1201: iload 4
    //   1203: iload 6
    //   1205: invokestatic 398	whm:a	([I[BII)I
    //   1208: istore 4
    //   1210: iload 4
    //   1212: istore 5
    //   1214: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1217: ifeq +34 -> 1251
    //   1220: ldc 71
    //   1222: iconst_4
    //   1223: new 136	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1230: ldc_w 426
    //   1233: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: iload 4
    //   1238: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1241: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1244: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1247: iload 4
    //   1249: istore 5
    //   1251: aconst_null
    //   1252: astore 12
    //   1254: iload 5
    //   1256: istore 4
    //   1258: goto -966 -> 292
    //   1261: aload 15
    //   1263: iconst_1
    //   1264: putfield 353	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1267: goto -726 -> 541
    //   1270: astore 12
    //   1272: aconst_null
    //   1273: astore_0
    //   1274: aload 12
    //   1276: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   1279: aload_0
    //   1280: astore_1
    //   1281: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1284: ifeq -932 -> 352
    //   1287: ldc 71
    //   1289: iconst_2
    //   1290: aload 12
    //   1292: invokevirtual 372	java/io/IOException:toString	()Ljava/lang/String;
    //   1295: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1298: aload_0
    //   1299: astore_1
    //   1300: goto -948 -> 352
    //   1303: astore 13
    //   1305: aload_1
    //   1306: astore 12
    //   1308: aload 13
    //   1310: astore_1
    //   1311: aload_1
    //   1312: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1315: aload 12
    //   1317: invokevirtual 320	java/io/InputStream:close	()V
    //   1320: goto -536 -> 784
    //   1323: aload_1
    //   1324: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1327: aload 12
    //   1329: invokevirtual 320	java/io/InputStream:close	()V
    //   1332: iload 4
    //   1334: istore 5
    //   1336: goto -306 -> 1030
    //   1339: iload 4
    //   1341: istore 5
    //   1343: iload 7
    //   1345: iload 8
    //   1347: iconst_2
    //   1348: imul
    //   1349: if_icmplt -319 -> 1030
    //   1352: iload 4
    //   1354: istore 5
    //   1356: iload 8
    //   1358: sipush 1280
    //   1361: if_icmpge -331 -> 1030
    //   1364: aload 14
    //   1366: aload_0
    //   1367: invokevirtual 285	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1370: astore 12
    //   1372: aload 12
    //   1374: astore_1
    //   1375: aload 12
    //   1377: invokestatic 358	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1380: astore 13
    //   1382: aload 12
    //   1384: astore_1
    //   1385: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1388: ifeq +33 -> 1421
    //   1391: aload 12
    //   1393: astore_1
    //   1394: ldc 71
    //   1396: iconst_4
    //   1397: new 136	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1404: ldc_w 428
    //   1407: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: aload 13
    //   1412: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1421: aload 12
    //   1423: astore_1
    //   1424: aload 12
    //   1426: invokevirtual 320	java/io/InputStream:close	()V
    //   1429: iload 4
    //   1431: istore 6
    //   1433: aload 13
    //   1435: ifnull +170 -> 1605
    //   1438: iload 4
    //   1440: istore 5
    //   1442: iload 8
    //   1444: iload 8
    //   1446: imul
    //   1447: newarray int
    //   1449: astore_1
    //   1450: iload 4
    //   1452: istore 5
    //   1454: aload 13
    //   1456: aload_1
    //   1457: iconst_0
    //   1458: iload 8
    //   1460: iconst_0
    //   1461: iconst_0
    //   1462: iload 8
    //   1464: iload 8
    //   1466: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1469: iload 4
    //   1471: istore 5
    //   1473: iload 8
    //   1475: iload 8
    //   1477: imul
    //   1478: newarray byte
    //   1480: astore 12
    //   1482: iload 4
    //   1484: istore 5
    //   1486: aload_1
    //   1487: aload 12
    //   1489: iload 8
    //   1491: iload 8
    //   1493: invokestatic 398	whm:a	([I[BII)I
    //   1496: istore 6
    //   1498: iload 6
    //   1500: istore 4
    //   1502: iload 6
    //   1504: iconst_1
    //   1505: if_icmpeq +42 -> 1547
    //   1508: iload 6
    //   1510: istore 5
    //   1512: aload 13
    //   1514: aload_1
    //   1515: iconst_0
    //   1516: iload 8
    //   1518: iload 7
    //   1520: iload 8
    //   1522: isub
    //   1523: iconst_0
    //   1524: iload 8
    //   1526: iload 8
    //   1528: invokevirtual 123	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1531: iload 6
    //   1533: istore 5
    //   1535: aload_1
    //   1536: aload 12
    //   1538: iload 8
    //   1540: iload 8
    //   1542: invokestatic 398	whm:a	([I[BII)I
    //   1545: istore 4
    //   1547: iload 4
    //   1549: istore 5
    //   1551: aload 13
    //   1553: invokevirtual 315	android/graphics/Bitmap:recycle	()V
    //   1556: iload 4
    //   1558: istore 6
    //   1560: iload 4
    //   1562: istore 5
    //   1564: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1567: ifeq +38 -> 1605
    //   1570: iload 4
    //   1572: istore 5
    //   1574: ldc 71
    //   1576: iconst_4
    //   1577: new 136	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1584: ldc_w 430
    //   1587: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: iload 4
    //   1592: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1601: iload 4
    //   1603: istore 6
    //   1605: iload 6
    //   1607: istore 5
    //   1609: goto -579 -> 1030
    //   1612: astore 13
    //   1614: aload_1
    //   1615: astore 12
    //   1617: aload 13
    //   1619: astore_1
    //   1620: aload_1
    //   1621: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1624: aload 12
    //   1626: invokevirtual 320	java/io/InputStream:close	()V
    //   1629: iload 4
    //   1631: istore 5
    //   1633: goto -603 -> 1030
    //   1636: aload_0
    //   1637: invokevirtual 325	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1640: aload_1
    //   1641: invokevirtual 320	java/io/InputStream:close	()V
    //   1644: aconst_null
    //   1645: astore 12
    //   1647: goto -1355 -> 292
    //   1650: new 227	android/util/Pair
    //   1653: dup
    //   1654: aconst_null
    //   1655: aconst_null
    //   1656: invokespecial 230	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1659: astore_0
    //   1660: goto -1326 -> 334
    //   1663: astore 12
    //   1665: aconst_null
    //   1666: astore_0
    //   1667: aload 12
    //   1669: invokevirtual 250	java/lang/RuntimeException:printStackTrace	()V
    //   1672: aload_0
    //   1673: astore_1
    //   1674: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1677: ifeq -1325 -> 352
    //   1680: ldc 71
    //   1682: iconst_2
    //   1683: aload 12
    //   1685: invokevirtual 251	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1688: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: aload_0
    //   1692: astore_1
    //   1693: goto -1341 -> 352
    //   1696: astore 12
    //   1698: aconst_null
    //   1699: astore_0
    //   1700: aload 12
    //   1702: invokevirtual 255	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1705: aload_0
    //   1706: astore_1
    //   1707: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1710: ifeq -1358 -> 352
    //   1713: ldc 71
    //   1715: iconst_2
    //   1716: aload 12
    //   1718: invokevirtual 256	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1721: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1724: aload_0
    //   1725: astore_1
    //   1726: goto -1374 -> 352
    //   1729: astore 12
    //   1731: aconst_null
    //   1732: astore_0
    //   1733: aload 12
    //   1735: invokevirtual 257	java/lang/Throwable:printStackTrace	()V
    //   1738: aload_0
    //   1739: astore_1
    //   1740: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1743: ifeq -1391 -> 352
    //   1746: ldc 71
    //   1748: iconst_2
    //   1749: aload 12
    //   1751: invokevirtual 258	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1754: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1757: aload_0
    //   1758: astore_1
    //   1759: goto -1407 -> 352
    //   1762: astore 12
    //   1764: goto -31 -> 1733
    //   1767: astore 12
    //   1769: goto -69 -> 1700
    //   1772: astore 12
    //   1774: goto -107 -> 1667
    //   1777: astore 12
    //   1779: goto -505 -> 1274
    //   1782: astore_0
    //   1783: aconst_null
    //   1784: astore_1
    //   1785: iload 5
    //   1787: istore 4
    //   1789: goto -153 -> 1636
    //   1792: astore_0
    //   1793: aconst_null
    //   1794: astore_1
    //   1795: goto -159 -> 1636
    //   1798: astore_1
    //   1799: aconst_null
    //   1800: astore 12
    //   1802: iload 5
    //   1804: istore 4
    //   1806: goto -186 -> 1620
    //   1809: astore_1
    //   1810: aconst_null
    //   1811: astore 12
    //   1813: iload 5
    //   1815: istore 4
    //   1817: goto -494 -> 1323
    //   1820: astore_1
    //   1821: aconst_null
    //   1822: astore 12
    //   1824: goto -501 -> 1323
    //   1827: astore_1
    //   1828: aconst_null
    //   1829: astore 12
    //   1831: iload 5
    //   1833: istore 4
    //   1835: goto -524 -> 1311
    //   1838: astore_0
    //   1839: goto -1422 -> 417
    //   1842: astore_0
    //   1843: goto -1449 -> 394
    //   1846: aconst_null
    //   1847: astore_0
    //   1848: goto -1514 -> 334
    //   1851: goto -600 -> 1251
    //   1854: goto -866 -> 988
    //   1857: goto -831 -> 1026
    //   1860: iconst_m1
    //   1861: istore 5
    //   1863: goto -1578 -> 285
    //   1866: aconst_null
    //   1867: astore_1
    //   1868: goto -1516 -> 352
    //   1871: aload_1
    //   1872: astore 12
    //   1874: goto -1582 -> 292
    //   1877: astore_0
    //   1878: goto -1461 -> 417
    //   1881: aload_1
    //   1882: astore 12
    //   1884: goto -1592 -> 292
    //   1887: aconst_null
    //   1888: areturn
    //   1889: astore_1
    //   1890: goto -567 -> 1323
    //   1893: astore_0
    //   1894: iload 5
    //   1896: istore 4
    //   1898: goto -262 -> 1636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1901	0	paramUri	Uri
    //   0	1901	1	paramContext	Context
    //   0	1901	2	paramBoolean1	boolean
    //   0	1901	3	paramBoolean2	boolean
    //   18	1879	4	i	int
    //   45	1850	5	j	int
    //   70	1536	6	k	int
    //   474	1049	7	m	int
    //   481	1060	8	n	int
    //   674	51	9	i1	int
    //   15	365	10	l	long
    //   50	1203	12	localObject1	Object
    //   1270	21	12	localIOException1	java.io.IOException
    //   1306	340	12	localObject2	Object
    //   1663	21	12	localRuntimeException1	RuntimeException
    //   1696	21	12	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   1729	21	12	localThrowable1	Throwable
    //   1762	1	12	localThrowable2	Throwable
    //   1767	1	12	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   1772	1	12	localRuntimeException2	RuntimeException
    //   1777	1	12	localIOException2	java.io.IOException
    //   1800	83	12	localContext	Context
    //   560	529	13	localBitmap1	Bitmap
    //   1303	6	13	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1380	172	13	localBitmap2	Bitmap
    //   1612	6	13	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   24	1341	14	localContentResolver	android.content.ContentResolver
    //   447	815	15	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   144	184	393	java/lang/OutOfMemoryError
    //   188	240	393	java/lang/OutOfMemoryError
    //   20	33	1270	java/io/IOException
    //   37	52	1270	java/io/IOException
    //   62	140	1270	java/io/IOException
    //   144	184	1270	java/io/IOException
    //   188	240	1270	java/io/IOException
    //   248	281	1270	java/io/IOException
    //   302	334	1270	java/io/IOException
    //   394	414	1270	java/io/IOException
    //   417	437	1270	java/io/IOException
    //   440	467	1270	java/io/IOException
    //   469	489	1270	java/io/IOException
    //   519	541	1270	java/io/IOException
    //   541	549	1270	java/io/IOException
    //   552	562	1270	java/io/IOException
    //   565	571	1270	java/io/IOException
    //   574	637	1270	java/io/IOException
    //   640	645	1270	java/io/IOException
    //   658	665	1270	java/io/IOException
    //   669	676	1270	java/io/IOException
    //   680	688	1270	java/io/IOException
    //   692	707	1270	java/io/IOException
    //   711	716	1270	java/io/IOException
    //   720	731	1270	java/io/IOException
    //   739	745	1270	java/io/IOException
    //   749	776	1270	java/io/IOException
    //   816	823	1270	java/io/IOException
    //   826	832	1270	java/io/IOException
    //   835	841	1270	java/io/IOException
    //   844	871	1270	java/io/IOException
    //   874	878	1270	java/io/IOException
    //   887	895	1270	java/io/IOException
    //   899	914	1270	java/io/IOException
    //   918	927	1270	java/io/IOException
    //   931	943	1270	java/io/IOException
    //   953	972	1270	java/io/IOException
    //   976	988	1270	java/io/IOException
    //   988	1026	1270	java/io/IOException
    //   1048	1057	1270	java/io/IOException
    //   1072	1088	1270	java/io/IOException
    //   1091	1098	1270	java/io/IOException
    //   1100	1109	1270	java/io/IOException
    //   1111	1117	1270	java/io/IOException
    //   1119	1146	1270	java/io/IOException
    //   1148	1152	1270	java/io/IOException
    //   1157	1210	1270	java/io/IOException
    //   1214	1247	1270	java/io/IOException
    //   1261	1267	1270	java/io/IOException
    //   1311	1320	1270	java/io/IOException
    //   1323	1332	1270	java/io/IOException
    //   1364	1372	1270	java/io/IOException
    //   1375	1382	1270	java/io/IOException
    //   1385	1391	1270	java/io/IOException
    //   1394	1421	1270	java/io/IOException
    //   1424	1429	1270	java/io/IOException
    //   1442	1450	1270	java/io/IOException
    //   1454	1469	1270	java/io/IOException
    //   1473	1482	1270	java/io/IOException
    //   1486	1498	1270	java/io/IOException
    //   1512	1531	1270	java/io/IOException
    //   1535	1547	1270	java/io/IOException
    //   1551	1556	1270	java/io/IOException
    //   1564	1570	1270	java/io/IOException
    //   1574	1601	1270	java/io/IOException
    //   1620	1629	1270	java/io/IOException
    //   1636	1644	1270	java/io/IOException
    //   1650	1660	1270	java/io/IOException
    //   541	549	1303	java/lang/OutOfMemoryError
    //   552	562	1303	java/lang/OutOfMemoryError
    //   565	571	1303	java/lang/OutOfMemoryError
    //   574	637	1303	java/lang/OutOfMemoryError
    //   640	645	1303	java/lang/OutOfMemoryError
    //   1364	1372	1612	java/lang/OutOfMemoryError
    //   1375	1382	1612	java/lang/OutOfMemoryError
    //   1385	1391	1612	java/lang/OutOfMemoryError
    //   1394	1421	1612	java/lang/OutOfMemoryError
    //   1424	1429	1612	java/lang/OutOfMemoryError
    //   20	33	1663	java/lang/RuntimeException
    //   37	52	1663	java/lang/RuntimeException
    //   62	140	1663	java/lang/RuntimeException
    //   144	184	1663	java/lang/RuntimeException
    //   188	240	1663	java/lang/RuntimeException
    //   248	281	1663	java/lang/RuntimeException
    //   302	334	1663	java/lang/RuntimeException
    //   394	414	1663	java/lang/RuntimeException
    //   417	437	1663	java/lang/RuntimeException
    //   440	467	1663	java/lang/RuntimeException
    //   469	489	1663	java/lang/RuntimeException
    //   519	541	1663	java/lang/RuntimeException
    //   541	549	1663	java/lang/RuntimeException
    //   552	562	1663	java/lang/RuntimeException
    //   565	571	1663	java/lang/RuntimeException
    //   574	637	1663	java/lang/RuntimeException
    //   640	645	1663	java/lang/RuntimeException
    //   658	665	1663	java/lang/RuntimeException
    //   669	676	1663	java/lang/RuntimeException
    //   680	688	1663	java/lang/RuntimeException
    //   692	707	1663	java/lang/RuntimeException
    //   711	716	1663	java/lang/RuntimeException
    //   720	731	1663	java/lang/RuntimeException
    //   739	745	1663	java/lang/RuntimeException
    //   749	776	1663	java/lang/RuntimeException
    //   816	823	1663	java/lang/RuntimeException
    //   826	832	1663	java/lang/RuntimeException
    //   835	841	1663	java/lang/RuntimeException
    //   844	871	1663	java/lang/RuntimeException
    //   874	878	1663	java/lang/RuntimeException
    //   887	895	1663	java/lang/RuntimeException
    //   899	914	1663	java/lang/RuntimeException
    //   918	927	1663	java/lang/RuntimeException
    //   931	943	1663	java/lang/RuntimeException
    //   953	972	1663	java/lang/RuntimeException
    //   976	988	1663	java/lang/RuntimeException
    //   988	1026	1663	java/lang/RuntimeException
    //   1048	1057	1663	java/lang/RuntimeException
    //   1072	1088	1663	java/lang/RuntimeException
    //   1091	1098	1663	java/lang/RuntimeException
    //   1100	1109	1663	java/lang/RuntimeException
    //   1111	1117	1663	java/lang/RuntimeException
    //   1119	1146	1663	java/lang/RuntimeException
    //   1148	1152	1663	java/lang/RuntimeException
    //   1157	1210	1663	java/lang/RuntimeException
    //   1214	1247	1663	java/lang/RuntimeException
    //   1261	1267	1663	java/lang/RuntimeException
    //   1311	1320	1663	java/lang/RuntimeException
    //   1323	1332	1663	java/lang/RuntimeException
    //   1364	1372	1663	java/lang/RuntimeException
    //   1375	1382	1663	java/lang/RuntimeException
    //   1385	1391	1663	java/lang/RuntimeException
    //   1394	1421	1663	java/lang/RuntimeException
    //   1424	1429	1663	java/lang/RuntimeException
    //   1442	1450	1663	java/lang/RuntimeException
    //   1454	1469	1663	java/lang/RuntimeException
    //   1473	1482	1663	java/lang/RuntimeException
    //   1486	1498	1663	java/lang/RuntimeException
    //   1512	1531	1663	java/lang/RuntimeException
    //   1535	1547	1663	java/lang/RuntimeException
    //   1551	1556	1663	java/lang/RuntimeException
    //   1564	1570	1663	java/lang/RuntimeException
    //   1574	1601	1663	java/lang/RuntimeException
    //   1620	1629	1663	java/lang/RuntimeException
    //   1636	1644	1663	java/lang/RuntimeException
    //   1650	1660	1663	java/lang/RuntimeException
    //   20	33	1696	java/lang/UnsatisfiedLinkError
    //   37	52	1696	java/lang/UnsatisfiedLinkError
    //   62	140	1696	java/lang/UnsatisfiedLinkError
    //   144	184	1696	java/lang/UnsatisfiedLinkError
    //   188	240	1696	java/lang/UnsatisfiedLinkError
    //   248	281	1696	java/lang/UnsatisfiedLinkError
    //   302	334	1696	java/lang/UnsatisfiedLinkError
    //   394	414	1696	java/lang/UnsatisfiedLinkError
    //   417	437	1696	java/lang/UnsatisfiedLinkError
    //   440	467	1696	java/lang/UnsatisfiedLinkError
    //   469	489	1696	java/lang/UnsatisfiedLinkError
    //   519	541	1696	java/lang/UnsatisfiedLinkError
    //   541	549	1696	java/lang/UnsatisfiedLinkError
    //   552	562	1696	java/lang/UnsatisfiedLinkError
    //   565	571	1696	java/lang/UnsatisfiedLinkError
    //   574	637	1696	java/lang/UnsatisfiedLinkError
    //   640	645	1696	java/lang/UnsatisfiedLinkError
    //   658	665	1696	java/lang/UnsatisfiedLinkError
    //   669	676	1696	java/lang/UnsatisfiedLinkError
    //   680	688	1696	java/lang/UnsatisfiedLinkError
    //   692	707	1696	java/lang/UnsatisfiedLinkError
    //   711	716	1696	java/lang/UnsatisfiedLinkError
    //   720	731	1696	java/lang/UnsatisfiedLinkError
    //   739	745	1696	java/lang/UnsatisfiedLinkError
    //   749	776	1696	java/lang/UnsatisfiedLinkError
    //   816	823	1696	java/lang/UnsatisfiedLinkError
    //   826	832	1696	java/lang/UnsatisfiedLinkError
    //   835	841	1696	java/lang/UnsatisfiedLinkError
    //   844	871	1696	java/lang/UnsatisfiedLinkError
    //   874	878	1696	java/lang/UnsatisfiedLinkError
    //   887	895	1696	java/lang/UnsatisfiedLinkError
    //   899	914	1696	java/lang/UnsatisfiedLinkError
    //   918	927	1696	java/lang/UnsatisfiedLinkError
    //   931	943	1696	java/lang/UnsatisfiedLinkError
    //   953	972	1696	java/lang/UnsatisfiedLinkError
    //   976	988	1696	java/lang/UnsatisfiedLinkError
    //   988	1026	1696	java/lang/UnsatisfiedLinkError
    //   1048	1057	1696	java/lang/UnsatisfiedLinkError
    //   1072	1088	1696	java/lang/UnsatisfiedLinkError
    //   1091	1098	1696	java/lang/UnsatisfiedLinkError
    //   1100	1109	1696	java/lang/UnsatisfiedLinkError
    //   1111	1117	1696	java/lang/UnsatisfiedLinkError
    //   1119	1146	1696	java/lang/UnsatisfiedLinkError
    //   1148	1152	1696	java/lang/UnsatisfiedLinkError
    //   1157	1210	1696	java/lang/UnsatisfiedLinkError
    //   1214	1247	1696	java/lang/UnsatisfiedLinkError
    //   1261	1267	1696	java/lang/UnsatisfiedLinkError
    //   1311	1320	1696	java/lang/UnsatisfiedLinkError
    //   1323	1332	1696	java/lang/UnsatisfiedLinkError
    //   1364	1372	1696	java/lang/UnsatisfiedLinkError
    //   1375	1382	1696	java/lang/UnsatisfiedLinkError
    //   1385	1391	1696	java/lang/UnsatisfiedLinkError
    //   1394	1421	1696	java/lang/UnsatisfiedLinkError
    //   1424	1429	1696	java/lang/UnsatisfiedLinkError
    //   1442	1450	1696	java/lang/UnsatisfiedLinkError
    //   1454	1469	1696	java/lang/UnsatisfiedLinkError
    //   1473	1482	1696	java/lang/UnsatisfiedLinkError
    //   1486	1498	1696	java/lang/UnsatisfiedLinkError
    //   1512	1531	1696	java/lang/UnsatisfiedLinkError
    //   1535	1547	1696	java/lang/UnsatisfiedLinkError
    //   1551	1556	1696	java/lang/UnsatisfiedLinkError
    //   1564	1570	1696	java/lang/UnsatisfiedLinkError
    //   1574	1601	1696	java/lang/UnsatisfiedLinkError
    //   1620	1629	1696	java/lang/UnsatisfiedLinkError
    //   1636	1644	1696	java/lang/UnsatisfiedLinkError
    //   1650	1660	1696	java/lang/UnsatisfiedLinkError
    //   20	33	1729	java/lang/Throwable
    //   37	52	1729	java/lang/Throwable
    //   62	140	1729	java/lang/Throwable
    //   302	334	1729	java/lang/Throwable
    //   394	414	1729	java/lang/Throwable
    //   417	437	1729	java/lang/Throwable
    //   440	467	1729	java/lang/Throwable
    //   469	489	1729	java/lang/Throwable
    //   519	541	1729	java/lang/Throwable
    //   541	549	1729	java/lang/Throwable
    //   552	562	1729	java/lang/Throwable
    //   565	571	1729	java/lang/Throwable
    //   574	637	1729	java/lang/Throwable
    //   640	645	1729	java/lang/Throwable
    //   658	665	1729	java/lang/Throwable
    //   669	676	1729	java/lang/Throwable
    //   680	688	1729	java/lang/Throwable
    //   692	707	1729	java/lang/Throwable
    //   711	716	1729	java/lang/Throwable
    //   720	731	1729	java/lang/Throwable
    //   739	745	1729	java/lang/Throwable
    //   749	776	1729	java/lang/Throwable
    //   816	823	1729	java/lang/Throwable
    //   826	832	1729	java/lang/Throwable
    //   835	841	1729	java/lang/Throwable
    //   844	871	1729	java/lang/Throwable
    //   874	878	1729	java/lang/Throwable
    //   887	895	1729	java/lang/Throwable
    //   899	914	1729	java/lang/Throwable
    //   918	927	1729	java/lang/Throwable
    //   931	943	1729	java/lang/Throwable
    //   953	972	1729	java/lang/Throwable
    //   976	988	1729	java/lang/Throwable
    //   988	1026	1729	java/lang/Throwable
    //   1048	1057	1729	java/lang/Throwable
    //   1072	1088	1729	java/lang/Throwable
    //   1091	1098	1729	java/lang/Throwable
    //   1100	1109	1729	java/lang/Throwable
    //   1111	1117	1729	java/lang/Throwable
    //   1119	1146	1729	java/lang/Throwable
    //   1148	1152	1729	java/lang/Throwable
    //   1157	1210	1729	java/lang/Throwable
    //   1214	1247	1729	java/lang/Throwable
    //   1261	1267	1729	java/lang/Throwable
    //   1311	1320	1729	java/lang/Throwable
    //   1323	1332	1729	java/lang/Throwable
    //   1364	1372	1729	java/lang/Throwable
    //   1375	1382	1729	java/lang/Throwable
    //   1385	1391	1729	java/lang/Throwable
    //   1394	1421	1729	java/lang/Throwable
    //   1424	1429	1729	java/lang/Throwable
    //   1442	1450	1729	java/lang/Throwable
    //   1454	1469	1729	java/lang/Throwable
    //   1473	1482	1729	java/lang/Throwable
    //   1486	1498	1729	java/lang/Throwable
    //   1512	1531	1729	java/lang/Throwable
    //   1535	1547	1729	java/lang/Throwable
    //   1551	1556	1729	java/lang/Throwable
    //   1564	1570	1729	java/lang/Throwable
    //   1574	1601	1729	java/lang/Throwable
    //   1620	1629	1729	java/lang/Throwable
    //   1636	1644	1729	java/lang/Throwable
    //   1650	1660	1729	java/lang/Throwable
    //   334	338	1762	java/lang/Throwable
    //   345	350	1762	java/lang/Throwable
    //   334	338	1767	java/lang/UnsatisfiedLinkError
    //   345	350	1767	java/lang/UnsatisfiedLinkError
    //   334	338	1772	java/lang/RuntimeException
    //   345	350	1772	java/lang/RuntimeException
    //   334	338	1777	java/io/IOException
    //   345	350	1777	java/io/IOException
    //   1157	1210	1782	java/lang/OutOfMemoryError
    //   1214	1247	1792	java/lang/OutOfMemoryError
    //   1442	1450	1798	java/lang/OutOfMemoryError
    //   1454	1469	1798	java/lang/OutOfMemoryError
    //   1473	1482	1798	java/lang/OutOfMemoryError
    //   1486	1498	1798	java/lang/OutOfMemoryError
    //   1512	1531	1798	java/lang/OutOfMemoryError
    //   1535	1547	1798	java/lang/OutOfMemoryError
    //   1551	1556	1798	java/lang/OutOfMemoryError
    //   1564	1570	1798	java/lang/OutOfMemoryError
    //   1574	1601	1798	java/lang/OutOfMemoryError
    //   887	895	1809	java/lang/OutOfMemoryError
    //   899	914	1809	java/lang/OutOfMemoryError
    //   918	927	1809	java/lang/OutOfMemoryError
    //   931	943	1809	java/lang/OutOfMemoryError
    //   953	972	1809	java/lang/OutOfMemoryError
    //   976	988	1809	java/lang/OutOfMemoryError
    //   988	1026	1820	java/lang/OutOfMemoryError
    //   658	665	1827	java/lang/OutOfMemoryError
    //   669	676	1827	java/lang/OutOfMemoryError
    //   680	688	1827	java/lang/OutOfMemoryError
    //   692	707	1827	java/lang/OutOfMemoryError
    //   711	716	1827	java/lang/OutOfMemoryError
    //   720	731	1827	java/lang/OutOfMemoryError
    //   739	745	1827	java/lang/OutOfMemoryError
    //   749	776	1827	java/lang/OutOfMemoryError
    //   248	281	1838	java/lang/Throwable
    //   248	281	1842	java/lang/OutOfMemoryError
    //   144	184	1877	java/lang/Throwable
    //   188	240	1877	java/lang/Throwable
    //   816	823	1889	java/lang/OutOfMemoryError
    //   826	832	1889	java/lang/OutOfMemoryError
    //   835	841	1889	java/lang/OutOfMemoryError
    //   844	871	1889	java/lang/OutOfMemoryError
    //   874	878	1889	java/lang/OutOfMemoryError
    //   1091	1098	1893	java/lang/OutOfMemoryError
    //   1100	1109	1893	java/lang/OutOfMemoryError
    //   1111	1117	1893	java/lang/OutOfMemoryError
    //   1119	1146	1893	java/lang/OutOfMemoryError
    //   1148	1152	1893	java/lang/OutOfMemoryError
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
                localObject = bbdm.a((byte[])localObject);
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
        paramString1 = bbct.a();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = fb.a();
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
      axrl.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
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
      if (wim.g(paramString))
      {
        axrl.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        axrl.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (wim.i(paramString))
        {
          axrl.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
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
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, whu paramwhu, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new who(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramwhu);
    paramAppActivity = new NewIntent(paramAppActivity, wfm.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramwhu = paramwhu.a();
    if (paramwhu != null)
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
        if (paramwhu.has(str)) {
          paramAppActivity.putExtra(str, paramwhu.optString(str));
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
  
  public static void a(QQAppInterface paramQQAppInterface) {}
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, whu paramwhu)
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
          bbbr.b(2131230757, false);
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
          bbbr.b(2131230757, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramwhu);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramwhu);
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
          bbbr.b(2131230757, false);
        }
        if (j == 0) {
          break label1090;
        }
        wfn.a(paramQQAppInterface, paramAppActivity, paramString1, i);
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
        if (!nam.a(paramAppActivity))
        {
          paramString1 = bbcv.a(paramAppActivity, 230);
          paramString1.setMessage(2131718904);
          paramString2 = new whn(paramwhu);
          paramString1.setPositiveButton(2131694793, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          bbbr.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(str)) && (!wim.a(str)))
        {
          if (bdcs.a)
          {
            paramView.setVisibility(0);
            bdcs.a().a(paramQQAppInterface, paramString1, paramView);
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
          ymw.a().a(1);
          ymw.a().jdField_a_of_type_JavaLangString = "";
          ymw.a().jdField_a_of_type_Int = 0;
          ymw.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramwhu, paramString1)) {
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
        else if (wim.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (wim.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (wim.f(str))
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
          if (wim.h(str))
          {
            if (wim.b(str))
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
            if (bbks.a(paramString1))
            {
              bbks.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramwhu, paramView);
              i = 1;
            }
          }
          else
          {
            wfn.a(paramQQAppInterface, paramAppActivity, paramString1);
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
 * Qualified Name:     whm
 * JD-Core Version:    0.7.0.1
 */