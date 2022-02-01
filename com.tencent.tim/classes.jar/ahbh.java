import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.1;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ahbh
{
  private static List<String> BN = new ArrayList();
  public static final int bUr;
  public static final int bUs;
  public static int cZb;
  public static int cZc;
  public static int cZd;
  public static int cZe;
  public static int cZf;
  public static int maxSize = 232;
  
  static
  {
    cZb = 750;
    cZc = 130;
    cZd = 421;
    if (BaseChatItemLayout.bNT > 0)
    {
      maxSize = BaseChatItemLayout.bNT;
      cZc = (int)(BaseChatItemLayout.bNT * 0.5625F);
    }
    cZe = maxSize;
    cZf = cZc;
    float f = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
    if (f != 0.0F)
    {
      cZe = (int)(maxSize / f);
      cZf = (int)(cZc / f);
    }
    bUr = cZc;
    bUs = maxSize;
  }
  
  public static String D(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  private static void JK(String paramString)
  {
    synchronized (BN)
    {
      BN.remove(paramString);
      return;
    }
  }
  
  public static void L(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig entity is null, so return null");
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    e(paramFileManagerEntity, paramFileManagerEntity.getFilePath());
  }
  
  public static void M(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge entity is null, so return null");
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    e(paramFileManagerEntity, paramFileManagerEntity.strLargeThumPath);
  }
  
  public static void N(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge entity is null, so return null");
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {}
    e(paramFileManagerEntity, paramFileManagerEntity.strMiddleThumPath);
  }
  
  public static void O(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig entity is null, so return");
      return;
    }
    if (paramFileManagerEntity.nFileType != 0)
    {
      QLog.i("FilePicURLDrawlableHelper<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] createQXlargeThumbWithOrig is not image file!");
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig Thumb file " + paramFileManagerEntity.strLargeThumPath + " already exist");
      return;
    }
    String str = i(paramFileManagerEntity);
    str = ahaf.a().wb() + D(7, str);
    str = m(paramFileManagerEntity.getFilePath(), str, 2);
    if (str == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
      return;
    }
    paramFileManagerEntity.strLargeThumPath = str;
  }
  
  public static ahbh.a a(int paramInt1, int paramInt2, ahbh.b paramb, boolean paramBoolean)
  {
    int i1 = maxSize;
    int i2 = cZc;
    int j;
    int i;
    int k;
    int m;
    int i3;
    int n;
    switch (paramb.cZh)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      j = paramInt2;
      i = paramInt1;
      k = paramInt2;
      m = paramInt1;
      if (i > j)
      {
        i3 = i;
        n = j;
        switch (paramb.cZg)
        {
        default: 
          paramb = new ahbh.a();
          paramb.width = paramInt1;
          paramb.height = paramInt2;
          return paramb;
        }
      }
      break;
    case 1: 
    case 3: 
    case 6: 
      label79:
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        k = (int)(i * 1.777778F);
        if (paramInt1 <= paramInt2) {
          break label199;
        }
        j = i;
        i = k;
        if (k > paramInt1) {
          i = paramInt1;
        }
        if (j <= paramInt2) {
          break label474;
        }
      }
      label140:
      label158:
      break;
    }
    for (;;)
    {
      j = paramInt2;
      k = paramInt2;
      m = i;
      paramInt1 = i;
      break;
      i = paramInt1;
      break label140;
      label199:
      j = k;
      k = i;
      break label158;
      i3 = j;
      n = i;
      break label79;
      float f = i2 / (n * 1.0F);
      n = (int)(i3 * f);
      if (m > paramInt1) {}
      for (;;)
      {
        if (k > paramInt2) {}
        for (;;)
        {
          k = Math.round(paramInt1 * f);
          m = Math.round(paramInt2 * f);
          if (i > j)
          {
            paramInt2 = i2;
            i = i1;
            label287:
            paramInt1 = i;
            if (i > k) {
              paramInt1 = k;
            }
            if (paramInt2 <= m) {
              break label459;
            }
            paramInt2 = m;
          }
          label405:
          label441:
          label459:
          for (;;)
          {
            break;
            paramInt2 = i1;
            i = i2;
            break label287;
            f = i1 / (i3 * 1.0F);
            n = (int)(n * f);
            if ((i <= j) || (m > paramInt1)) {}
            for (;;)
            {
              if (k > paramInt2) {}
              for (;;)
              {
                paramInt1 = Math.round(paramInt1 * f);
                paramInt2 = Math.round(paramInt2 * f);
                break;
                break;
                k = (int)(n * 1.777778F);
                if (i > j)
                {
                  i = n;
                  j = k;
                  if (k > paramInt1) {
                    j = paramInt1;
                  }
                  if (i <= paramInt2) {
                    break label441;
                  }
                }
                for (;;)
                {
                  paramInt1 = j;
                  break;
                  i = k;
                  k = n;
                  break label405;
                  paramInt2 = i;
                }
                paramInt2 = k;
              }
              paramInt1 = m;
            }
          }
          paramInt2 = k;
        }
        paramInt1 = m;
      }
      label474:
      paramInt2 = j;
    }
  }
  
  public static ahbh.a a(int paramInt1, int paramInt2, String paramString)
  {
    int i = bUr;
    int j = bUs;
    ahbh.a locala = new ahbh.a();
    float f1;
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      d(paramString, localOptions);
      locala.width = localOptions.outWidth;
      locala.height = localOptions.outHeight;
      paramString = locala;
      paramInt2 = paramString.width;
      paramInt1 = paramString.height;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((paramInt2 >= cZf) && (paramInt1 >= cZf)) {
        break label234;
      }
      if (paramInt2 < paramInt1)
      {
        f1 = cZc / paramInt2;
        i = cZc;
        j = (int)(f1 * paramInt1 + 0.5F);
        paramInt1 = j;
        paramInt2 = i;
        if (j > maxSize)
        {
          paramInt1 = maxSize;
          paramInt2 = i;
        }
        label157:
        paramString.width = paramInt2;
        paramString.height = paramInt1;
        return paramString;
      }
    }
    else
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label379;
      }
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramString = a(paramInt2, i, false);
      break;
      paramInt2 = (int)(cZc / paramInt1 * paramInt2 + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > maxSize) {
        paramInt1 = maxSize;
      }
      i = cZc;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break label157;
      label234:
      if ((paramInt2 < cZe) && (paramInt1 < cZe))
      {
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        break label157;
      }
      if (paramInt2 > paramInt1)
      {
        f1 = maxSize / paramInt2;
        label282:
        if (paramInt2 <= paramInt1) {
          break label367;
        }
      }
      label367:
      for (float f2 = cZc / paramInt1;; f2 = cZc / paramInt2)
      {
        f1 = Math.max(f1, f2);
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        paramInt2 = Math.min(paramInt2, maxSize);
        paramInt1 = Math.min(paramInt1, maxSize);
        paramInt2 = Math.max(paramInt2, cZc);
        paramInt1 = Math.max(paramInt1, cZc);
        break;
        f1 = maxSize / paramInt1;
        break label282;
      }
      label379:
      paramInt1 = j;
      paramInt2 = i;
      i = paramInt1;
    }
  }
  
  public static ahbh.a a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    for (int j = paramInt1;; j = paramInt2)
    {
      ahbh.b localb = a(i, j);
      i = l(paramInt1, paramInt2, maxSize);
      return a(paramInt1 * i, i * paramInt2, localb, false);
      i = paramInt1;
    }
  }
  
  public static ahbh.a a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    ahbh.a locala = new ahbh.a();
    int j;
    int i;
    float f1;
    int k;
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      d(paramFileManagerEntity.strMiddleThumPath, localOptions);
      locala.width = localOptions.outWidth;
      locala.height = localOptions.outHeight;
      paramFileManagerEntity = locala;
      j = paramFileManagerEntity.width;
      i = paramFileManagerEntity.height;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((j >= cZf) && (i >= cZf)) {
        break label272;
      }
      if (j >= i) {
        break label226;
      }
      f1 = cZc / j;
      k = cZc;
      int m = (int)(f1 * i + 0.5F);
      i = m;
      j = k;
      if (m > maxSize)
      {
        i = maxSize;
        j = k;
      }
    }
    for (;;)
    {
      paramFileManagerEntity.width = j;
      paramFileManagerEntity.height = i;
      return paramFileManagerEntity;
      if ((paramFileManagerEntity.imgWidth > 0) && (paramFileManagerEntity.imgHeight > 0)) {
        j = paramFileManagerEntity.imgWidth;
      }
      for (i = paramFileManagerEntity.imgHeight;; i = bUs)
      {
        paramFileManagerEntity = a(j, i, false);
        break;
        j = bUr;
      }
      label226:
      j = (int)(cZc / i * j + 0.5F);
      i = j;
      if (j > maxSize) {
        i = maxSize;
      }
      k = cZc;
      j = i;
      i = k;
      continue;
      label272:
      if ((j >= cZe) || (i >= cZe)) {
        break label310;
      }
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
    }
    label310:
    if (j > i)
    {
      f1 = maxSize / j;
      label325:
      if (j <= i) {
        break label379;
      }
    }
    label379:
    for (float f2 = cZc / i;; f2 = cZc / j)
    {
      f1 = Math.max(f1, f2);
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      break;
      f1 = maxSize / i;
      break label325;
    }
  }
  
  private static ahbh.b a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = maxSize;
    int m = cZc;
    if (paramInt1 > k) {
      if (aX(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      ahbh.b localb = new ahbh.b();
      localb.cZg = paramInt2;
      localb.cZh = paramInt1;
      return localb;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (aX(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (aX(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (aX(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static URL a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    String str;
    do
    {
      return null;
      int j = 0;
      int i = j;
      if (paramFileManagerEntity.getCloudType() == 3)
      {
        i = j;
        if (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
          i = 1;
        }
      }
      if (i == 0) {
        break;
      }
      str = lf(paramFileManagerEntity.getFilePath());
    } while (str == null);
    Object localObject2 = paramFileManagerEntity.strFileMd5;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramFileManagerEntity.Uuid;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = aqhs.bytes2HexStr(ahav.t(paramFileManagerEntity.getFilePath())).toUpperCase();
    }
    localObject1 = ahaf.a().wb() + D(5, atad.toMD5((String)localObject2));
    if ((aqhq.fileExistsAndNotEmpty(str)) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) && (aqhq.renameFile(new File(str), new File((String)localObject1)) == true)) {
      paramFileManagerEntity.strMiddleThumPath = ((String)localObject1);
    }
    return b(paramFileManagerEntity);
  }
  
  public static boolean aX(int paramInt1, int paramInt2)
  {
    return paramInt2 > (int)(paramInt1 * 1.777778F);
  }
  
  public static boolean aY(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return true;
      if (paramInt1 > paramInt2) {}
      while (!aX(paramInt2, paramInt1))
      {
        return false;
        int i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  public static long al(String paramString)
  {
    synchronized (BN)
    {
      if (BN.contains(paramString)) {
        return -1L;
      }
      BN.add(paramString);
      return 1L;
    }
  }
  
  public static URL b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    Object localObject2 = paramFileManagerEntity.strMiddleThumPath;
    Object localObject1 = localObject2;
    if (paramFileManagerEntity.status == 16)
    {
      localObject1 = localObject2;
      if (!ahbj.fileExistsAndNotEmpty((String)localObject2))
      {
        if (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
          break label129;
        }
        localObject1 = paramFileManagerEntity.strLargeThumPath;
      }
    }
    label46:
    localObject2 = localObject1;
    if (!ahbj.fileExistsAndNotEmpty((String)localObject1))
    {
      localObject2 = localObject1;
      if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
      {
        localObject1 = paramFileManagerEntity.strLargeThumPath;
        localObject2 = localObject1;
        if (u(paramFileManagerEntity))
        {
          ThreadManager.post(new FilePicURLDrawlableHelper.1(paramFileManagerEntity), 8, null, false);
          localObject2 = localObject1;
        }
      }
    }
    if (aqhq.fileExistsAndNotEmpty((String)localObject2)) {}
    for (;;)
    {
      label129:
      try
      {
        paramFileManagerEntity = AsyncImageView.a((String)localObject2, -1, -1, new File((String)localObject2), false, false, true);
        if (paramFileManagerEntity == null) {
          break;
        }
        return paramFileManagerEntity;
      }
      catch (Exception paramFileManagerEntity) {}
      localObject1 = localObject2;
      if (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath)) {
        break label46;
      }
      localObject1 = paramFileManagerEntity.strThumbPath;
      break label46;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 1, "createFilePicDrawlableURL generateAIOThumbURL error!");
      return null;
      paramFileManagerEntity = null;
    }
  }
  
  /* Error */
  public static android.graphics.Bitmap d(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 395	java/io/BufferedInputStream
    //   5: dup
    //   6: new 397	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 401	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aconst_null
    //   22: aload_1
    //   23: invokestatic 407	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull +9 -> 39
    //   33: aload_2
    //   34: invokevirtual 412	java/io/InputStream:close	()V
    //   37: aload_1
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +15 -> 64
    //   52: aload_2
    //   53: astore_0
    //   54: ldc 121
    //   56: iconst_2
    //   57: ldc_w 414
    //   60: aload_1
    //   61: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload_3
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull -28 -> 39
    //   70: aload_2
    //   71: invokevirtual 412	java/io/InputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: astore_0
    //   84: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +15 -> 102
    //   90: aload_2
    //   91: astore_0
    //   92: ldc 121
    //   94: iconst_2
    //   95: ldc_w 419
    //   98: aload_1
    //   99: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_3
    //   103: astore_0
    //   104: aload_2
    //   105: ifnull -66 -> 39
    //   108: aload_2
    //   109: invokevirtual 412	java/io/InputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 412	java/io/InputStream:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: aload_1
    //   132: areturn
    //   133: astore_0
    //   134: goto -6 -> 128
    //   137: astore_1
    //   138: goto -18 -> 120
    //   141: astore_1
    //   142: goto -60 -> 82
    //   145: astore_1
    //   146: goto -102 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   0	149	1	paramOptions	BitmapFactory.Options
    //   17	92	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	102	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	41	java/lang/OutOfMemoryError
    //   70	74	76	java/io/IOException
    //   2	18	79	java/lang/Exception
    //   108	112	114	java/io/IOException
    //   2	18	117	finally
    //   33	37	130	java/io/IOException
    //   124	128	133	java/io/IOException
    //   20	27	137	finally
    //   46	52	137	finally
    //   54	64	137	finally
    //   84	90	137	finally
    //   92	102	137	finally
    //   20	27	141	java/lang/Exception
    //   20	27	145	java/lang/OutOfMemoryError
  }
  
  private static void dhg()
  {
    File localFile = new File(ahaf.a().wb());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static void e(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = i(paramFileManagerEntity);
    paramString = m(paramString, ahaf.a().wb() + D(5, str), 1);
    if (paramString == null) {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
    }
    do
    {
      return;
      paramFileManagerEntity.strMiddleThumPath = paramString;
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramString == null);
    paramString.a().u(paramFileManagerEntity);
    paramString.a().b(true, 3, null);
  }
  
  public static String i(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "getThumbPath entity is null, so return null");
      localObject = null;
      return localObject;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.strFileMd5);
    }
    for (;;)
    {
      localObject = paramFileManagerEntity;
      if (paramFileManagerEntity == null) {
        break;
      }
      return paramFileManagerEntity.replace("/", "");
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
      {
        paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.Uuid);
      }
      else if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        localObject = ahav.t(paramFileManagerEntity.getFilePath());
        if ((localObject != null) && (localObject.length > 0)) {
          paramFileManagerEntity = aqhs.bytes2HexStr((byte[])localObject).toUpperCase();
        } else {
          paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.fileName);
        }
      }
      else
      {
        paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.fileName);
      }
    }
  }
  
  private static int l(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      i >>= 1;
      paramInt2 >>= 1;
      if ((i < paramInt3) || (paramInt2 < paramInt3))
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= 1) {
          break;
        }
        return 1;
      }
      paramInt1 *= 2;
    }
  }
  
  public static String lf(String paramString)
  {
    if (!ahbj.fileExistsAndNotEmpty(paramString)) {}
    label141:
    for (;;)
    {
      return null;
      String str1 = aqhs.bytes2HexStr(ahav.t(paramString));
      dhg();
      str1 = ahaf.a().wb() + D(5, str1);
      String str2 = str1 + "_original_.tmp";
      if (aqhq.fileExistsAndNotEmpty(paramString)) {}
      for (;;)
      {
        for (;;)
        {
          if (paramString == null) {
            break label141;
          }
          try
          {
            if (!aqhq.fileExistsAndNotEmpty(str2)) {
              akyr.a(paramString, str2, true, "", 1);
            }
            if ((!aqhq.fileExistsAndNotEmpty(str2)) || (aqhq.renameFile(new File(str2), new File(str1)) != true)) {
              break;
            }
            return str1;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
        paramString = null;
      }
    }
  }
  
  private static String m(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if (al(paramString2) == -1L)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile temp Thumb file " + paramString2 + " is creating");
      return null;
    }
    if (!aqhq.fileExistsAndNotEmpty(paramString1))
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile file " + paramString1 + " is not exist");
      paramString1 = localObject;
    }
    for (;;)
    {
      JK(paramString2);
      return paramString1;
      dhg();
      String str = paramString2 + ".tmp";
      try
      {
        akyr.a(paramString1, str, true, "", paramInt);
        if (aqhq.fileExistsAndNotEmpty(str)) {
          break label220;
        }
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      continue;
      label220:
      if (!aqhq.renameFile(new File(str), new File(paramString2)))
      {
        aqhq.delete(str, true);
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile rename tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      else
      {
        paramString1 = paramString2;
      }
    }
  }
  
  public static boolean t(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.status == 16) && (!ahav.s(paramFileManagerEntity))) {}
    while ((paramFileManagerEntity.cloudType == 1) && (ahav.o(paramFileManagerEntity))) {
      return true;
    }
    return false;
  }
  
  public static boolean u(FileManagerEntity paramFileManagerEntity)
  {
    return aY(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight);
  }
  
  public static class a
  {
    public int height;
    public int width;
  }
  
  public static class b
  {
    int cZg;
    int cZh;
    
    public String toString()
    {
      return "Type [type1=" + this.cZg + ", type2=" + this.cZh + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbh
 * JD-Core Version:    0.7.0.1
 */