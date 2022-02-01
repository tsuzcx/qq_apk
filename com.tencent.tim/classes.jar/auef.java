import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.util.FilePicURLDrawlableHelper.1;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class auef
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
    str = audn.a().wb() + D(7, str);
    str = m(paramFileManagerEntity.getFilePath(), str, 2);
    if (str == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
      return;
    }
    paramFileManagerEntity.strLargeThumPath = str;
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
    localObject1 = audn.a().wb() + D(5, atad.toMD5((String)localObject2));
    if ((aqhq.fileExistsAndNotEmpty(str)) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) && (aqhq.renameFile(new File(str), new File((String)localObject1)) == true)) {
      paramFileManagerEntity.strMiddleThumPath = str;
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
          break label170;
        }
        localObject1 = paramFileManagerEntity.strLargeThumPath;
      }
    }
    label50:
    localObject2 = localObject1;
    if (!ahbj.fileExistsAndNotEmpty((String)localObject1))
    {
      localObject2 = localObject1;
      if (aueh.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
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
    int i;
    int j;
    if (aqhq.fileExistsAndNotEmpty((String)localObject2))
    {
      paramFileManagerEntity = new BitmapFactory.Options();
      paramFileManagerEntity.inJustDecodeBounds = true;
      d((String)localObject2, paramFileManagerEntity);
      i = paramFileManagerEntity.outWidth;
      j = paramFileManagerEntity.outHeight;
    }
    for (;;)
    {
      label170:
      try
      {
        paramFileManagerEntity = AsyncImageView.a((String)localObject2, i, j, new File((String)localObject2), false, false, true);
        if (paramFileManagerEntity == null) {
          break;
        }
        return paramFileManagerEntity;
      }
      catch (Exception paramFileManagerEntity) {}
      localObject1 = localObject2;
      if (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath)) {
        break label50;
      }
      localObject1 = paramFileManagerEntity.strThumbPath;
      break label50;
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
    //   2: new 335	java/io/BufferedInputStream
    //   5: dup
    //   6: new 337	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 338	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 341	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aconst_null
    //   22: aload_1
    //   23: invokestatic 347	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull +9 -> 39
    //   33: aload_2
    //   34: invokevirtual 352	java/io/InputStream:close	()V
    //   37: aload_1
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +15 -> 64
    //   52: aload_2
    //   53: astore_0
    //   54: ldc 115
    //   56: iconst_2
    //   57: ldc_w 354
    //   60: aload_1
    //   61: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload_3
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull -28 -> 39
    //   70: aload_2
    //   71: invokevirtual 352	java/io/InputStream:close	()V
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
    //   84: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +15 -> 102
    //   90: aload_2
    //   91: astore_0
    //   92: ldc 115
    //   94: iconst_2
    //   95: ldc_w 359
    //   98: aload_1
    //   99: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_3
    //   103: astore_0
    //   104: aload_2
    //   105: ifnull -66 -> 39
    //   108: aload_2
    //   109: invokevirtual 352	java/io/InputStream:close	()V
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
    //   125: invokevirtual 352	java/io/InputStream:close	()V
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
    File localFile = new File(audn.a().wb());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void e(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = i(paramFileManagerEntity);
    paramString = audn.a().wb() + D(5, paramString);
    paramString = m(paramFileManagerEntity.strMiddleThumPath, paramString, 1);
    if (paramString == null) {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
    }
    do
    {
      return;
      paramFileManagerEntity.strMiddleThumPath = paramString;
      paramFileManagerEntity = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramFileManagerEntity == null);
    paramFileManagerEntity.a().b(true, 3, null);
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
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
        paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.Uuid);
      } else if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) {
        paramFileManagerEntity = aqhs.bytes2HexStr(ahav.t(paramFileManagerEntity.getFilePath())).toUpperCase();
      } else {
        paramFileManagerEntity = atad.toMD5(paramFileManagerEntity.fileName);
      }
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
      str1 = audn.a().wb() + D(5, str1);
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
  
  public static String m(String paramString1, String paramString2, int paramInt)
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
  
  public static boolean u(FileManagerEntity paramFileManagerEntity)
  {
    return aY(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auef
 * JD-Core Version:    0.7.0.1
 */