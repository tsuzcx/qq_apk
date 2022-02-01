import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class abtn
  extends aoiz
{
  public static int crA = 1;
  public static int crB = 2;
  public static int crC = 3;
  
  public static URLDrawable a(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return a(false, paramString1, paramURLDrawableOptions, paramString2);
  }
  
  public static URLDrawable a(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean)
  {
    return a(false, paramString1, paramURLDrawableOptions, paramString2, paramBoolean);
  }
  
  public static URLDrawable a(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return a(paramBoolean, paramString1, paramURLDrawableOptions, paramString2, false);
  }
  
  public static URLDrawable a(boolean paramBoolean1, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (!paramBoolean1) {}
    for (String str = abxi.biw + "boxcard/" + paramString1;; str = paramString1)
    {
      File localFile = new File(str);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
      if (paramURLDrawableOptions == null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = null;
      }
      if (localURLDrawableOptions.mLoadingDrawable == null) {
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
      }
      if (localURLDrawableOptions.mFailedDrawable == null) {
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
      }
      if (localURLDrawableOptions.mExtraInfo == null) {
        localURLDrawableOptions.mExtraInfo = new abtn.a();
      }
      paramBoolean1 = paramBoolean2;
      if ((localURLDrawableOptions.mExtraInfo instanceof abtn.a))
      {
        paramURLDrawableOptions = (abtn.a)localURLDrawableOptions.mExtraInfo;
        if (!TextUtils.isEmpty(str)) {
          paramURLDrawableOptions.dQ = str;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramURLDrawableOptions.mDownloadUrl = paramString2;
        }
        if (paramURLDrawableOptions.crD != crA)
        {
          paramBoolean1 = paramBoolean2;
          if (!paramURLDrawableOptions.bFm) {}
        }
        else
        {
          paramBoolean1 = true;
        }
      }
      if ((!paramBoolean1) && (localFile.exists()))
      {
        paramURLDrawableOptions = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramString1 = paramURLDrawableOptions;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloImageDownloader", 2, "getDrawable file exsit path->" + str + ",url:" + paramString2);
          paramString1 = paramURLDrawableOptions;
        }
      }
      for (;;)
      {
        return paramString1;
        try
        {
          paramString1 = URLDrawable.getDrawable(new URL("apollo_image", "", paramString1), localURLDrawableOptions);
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloImageDownloader", 2, paramString1.getMessage());
          }
          paramString1 = null;
        }
      }
    }
  }
  
  public static final String iG(String paramString)
  {
    return "https://cmshow.gtimg.cn/client/img/" + paramString;
  }
  
  public static boolean jz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      String str = abxi.biw + paramString.substring(paramString.lastIndexOf("/") + 1);
      if (new File(str).exists()) {
        return true;
      }
      paramString = a(true, str, null, paramString, true);
    } while (paramString == null);
    paramString.startDownload();
    return false;
  }
  
  public static final String w(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/task_detail.gif";
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/task_detail.png";
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof abtn.a)))
    {
      paramOutputStream = (abtn.a)paramDownloadParams.mExtraInfo;
      paramDownloadParams = paramOutputStream.dQ;
      paramOutputStream = paramOutputStream.mDownloadUrl;
      paramDownloadParams = new File(paramDownloadParams);
      if (paramDownloadParams.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, "downloadImage file exsit url->" + paramOutputStream);
        }
      }
      int i;
      do
      {
        return paramDownloadParams;
        paramDownloadParams.getParentFile().mkdirs();
        if ((BaseApplicationImpl.sApplication != null) && (!aqiw.isNetworkAvailable(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
          paramURLDrawableHandler.onFileDownloadFailed(0);
        }
        aquz localaquz = new aquz(paramOutputStream, paramDownloadParams);
        localaquz.retryCount = 1;
        localaquz.cWy = false;
        localaquz.cWz = true;
        localaquz.cWA = true;
        i = aqva.a(localaquz, null);
        if (i != 0) {
          break;
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->0");
      return paramDownloadParams;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->" + i);
      }
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    Bitmap localBitmap = null;
    abtn.a locala;
    if ((paramFile != null) && (paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof abtn.a)))
    {
      locala = (abtn.a)paramDownloadParams.mExtraInfo;
      if (locala.crD != crA) {
        break label102;
      }
    }
    for (;;)
    {
      try
      {
        localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
        localBitmap = aqhu.getCircleFaceBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        paramFile = localBitmap;
        return paramFile;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, localThrowable.getMessage());
        }
      }
      label102:
      do
      {
        return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      } while (locala.crD != crB);
      if (paramFile.exists())
      {
        paramURLDrawableHandler = new BitmapFactory.Options();
        paramURLDrawableHandler.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramFile.getPath(), paramURLDrawableHandler);
        paramURLDrawableHandler.inSampleSize = aqhu.calculateInSampleSize(paramURLDrawableHandler, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
        paramURLDrawableHandler.inJustDecodeBounds = false;
        paramURLDrawableHandler.inPreferredConfig = Bitmap.Config.RGB_565;
        try
        {
          paramFile = BitmapFactory.decodeFile(paramFile.getPath(), paramURLDrawableHandler);
          if (paramFile != null) {
            if (locala.isSend)
            {
              i = 2130851000;
              paramDownloadParams = aqhu.a(paramFile, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, true);
              paramFile = paramDownloadParams;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloImageDownloader", 2, "ApolloItemBuilder decodeFile bgBitmap:" + paramDownloadParams);
              return paramDownloadParams;
            }
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          for (;;)
          {
            QLog.e("ApolloImageDownloader", 1, "decode server pic oom!!");
            System.gc();
            paramFile = localThrowable;
            continue;
            int i = 2130850823;
          }
          paramDownloadParams = paramFile;
        }
      }
    }
    for (;;)
    {
      paramFile = paramDownloadParams;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloImageDownloader", 2, "ApolloItemBuilder decodeFile bgBitmap:" + paramDownloadParams);
      return paramDownloadParams;
      paramDownloadParams = null;
    }
  }
  
  public static class a
  {
    public boolean bFm;
    public int crD;
    public String dQ;
    public boolean isSend;
    public String mDownloadUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtn
 * JD-Core Version:    0.7.0.1
 */