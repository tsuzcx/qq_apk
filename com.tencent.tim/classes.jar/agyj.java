import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public final class agyj
{
  public static void B(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    String str = localBaseApplicationImpl.getResources().getString(paramInt2);
    if (paramBoolean) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      QQToast.a(localBaseApplicationImpl, paramInt1, str, paramInt2).show(localBaseApplicationImpl.getResources().getDimensionPixelSize(2131299627));
      return;
    }
  }
  
  public static long G(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      long l2 = NetConnInfoCenter.getServerTime();
      if (paramInt == 1) {}
      for (long l1 = 604800000L;; l1 = 2592000000L) {
        return l1 + 1000L * l2;
      }
    }
    return -1L;
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = paramString;
    if (paramFileManagerEntity != null) {
      if (!TextUtils.isEmpty(paramFileManagerEntity.fileName)) {
        break label44;
      }
    }
    label44:
    for (str = paramString;; str = paramFileManagerEntity.fileName)
    {
      paramFileManagerEntity = ahbj.getExtension(str);
      if ((!".doc".equalsIgnoreCase(paramFileManagerEntity)) && (!".docx".equalsIgnoreCase(paramFileManagerEntity))) {
        break;
      }
      return "1";
    }
    if ((".xls".equalsIgnoreCase(paramFileManagerEntity)) || (".xlsx".equalsIgnoreCase(paramFileManagerEntity))) {
      return "2";
    }
    if ((".ppt".equalsIgnoreCase(paramFileManagerEntity)) || (".pptx".equalsIgnoreCase(paramFileManagerEntity))) {
      return "3";
    }
    if (".pdf".equalsIgnoreCase(paramFileManagerEntity)) {
      return "4";
    }
    if (".txt".equalsIgnoreCase(paramFileManagerEntity)) {
      return "5";
    }
    if ((".zip".equalsIgnoreCase(paramFileManagerEntity)) || (".rar".equalsIgnoreCase(paramFileManagerEntity))) {
      return "6";
    }
    return "7";
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      return true;
      if (paramFileManagerEntity == null) {
        return false;
      }
      int i = ahav.b(paramFileManagerEntity);
      if (i == 2)
      {
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {}
        for (paramBoolean = true;; paramBoolean = false) {
          return paramBoolean;
        }
      }
      if (i == 1)
      {
        if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (TextUtils.isEmpty(paramFileManagerEntity.peerUin))) {
          return false;
        }
      }
      else if (i == 4)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          try
          {
            paramFileManagerEntity = apsv.a((QQAppInterface)localAppRuntime, paramFileManagerEntity);
            if (paramFileManagerEntity != null)
            {
              paramBoolean = TextUtils.isEmpty(paramFileManagerEntity.FilePath);
              if (!paramBoolean) {}
            }
            else
            {
              return false;
            }
          }
          catch (Throwable paramFileManagerEntity)
          {
            QLog.e("LinkUtils<FileAssistant>", 2, "isSupportedShareByWeiyun error", paramFileManagerEntity);
          }
        }
      }
    }
    return false;
  }
  
  public static String eh(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String ei(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  public static String ej(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2: 
      return "1";
    case 3: 
      return "2";
    case 9: 
      return "3";
    case 10: 
      return "4";
    }
    return "5";
  }
  
  public static Bitmap i(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localObject = rwt.a(paramString, -1);
      if (localObject == null)
      {
        QLog.w("LinkUtils<FileAssistant>", 2, "getQrCode4Weiyun: encode failed.");
        return null;
      }
      int m = ((lk)localObject).getWidth();
      int n = ((lk)localObject).getHeight();
      paramString = new int[m * n];
      i = 0;
      while (i < n)
      {
        j = 0;
        if (j < m)
        {
          if (((lk)localObject).get(j, i)) {}
          for (k = -16777216;; k = 16777215)
          {
            paramString[(i * m + j)] = k;
            j += 1;
            break;
          }
        }
        i += 1;
      }
      localObject = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, n);
      if (m == paramInt)
      {
        paramString = (String)localObject;
        if (n == paramInt) {}
      }
      else
      {
        paramString = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        new Canvas(paramString).drawBitmap((Bitmap)localObject, new Rect(0, 0, m, n), new Rect(0, 0, paramInt, paramInt), null);
        ((Bitmap)localObject).recycle();
      }
      localBitmap = aqcu.decodeResource(BaseApplicationImpl.sApplication.getResources(), 2130845211);
      localObject = paramString;
    } while (localBitmap == null);
    paramInt = localBitmap.getWidth();
    int i = localBitmap.getHeight();
    Object localObject = new Canvas(paramString);
    int j = ((Canvas)localObject).getWidth();
    int k = ((Canvas)localObject).getHeight();
    ((Canvas)localObject).drawBitmap(localBitmap, new Rect(0, 0, paramInt, i), new Rect((j - paramInt) / 2, (k - i) / 2, (paramInt + j) / 2, (i + k) / 2), null);
    localBitmap.recycle();
    return paramString;
  }
  
  public static void p(int paramInt, String paramString, boolean paramBoolean)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      QQToast.a(localBaseApplicationImpl, paramInt, paramString, i).show(localBaseApplicationImpl.getResources().getDimensionPixelSize(2131299627));
      return;
    }
  }
  
  public static void report(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null)
    {
      paramString2 = "";
      if (paramString3 != null) {
        break label39;
      }
      paramString3 = "";
    }
    label39:
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
      return;
      break;
    }
  }
  
  public static String t(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "1";
    }
    return "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyj
 * JD-Core Version:    0.7.0.1
 */