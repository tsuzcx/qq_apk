import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class aomv
  extends aoiz
{
  protected static File aV;
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramOutputStream = paramDownloadParams.url.getHost();
    String str = paramDownloadParams.url.getFile();
    paramURLDrawableHandler = new File(bI(paramOutputStream, str));
    if (paramURLDrawableHandler.exists())
    {
      paramOutputStream = paramURLDrawableHandler;
      if (QLog.isColorLevel())
      {
        QLog.d("AbsDownloader", 2, new Object[] { "found file:", str });
        paramOutputStream = paramURLDrawableHandler;
      }
    }
    int i;
    do
    {
      do
      {
        return paramOutputStream;
        paramDownloadParams = paramDownloadParams.getHeader("emoId");
        if (paramDownloadParams == null) {
          break label224;
        }
        paramDownloadParams = paramDownloadParams.getValue();
        QLog.d("AbsDownloader", 1, String.format("file[%s] not found, loading[%s], host[%s]", new Object[] { str, paramDownloadParams, paramOutputStream }));
        i = Integer.parseInt(paramDownloadParams);
        if (!"host_qqsys_gif".equals(paramOutputStream)) {
          break label226;
        }
        if (!lP(i)) {
          break;
        }
        paramDownloadParams = new File(bI("host_qqsys_static", str.replace(".gif", ".png")));
        if (!paramDownloadParams.exists()) {
          break label217;
        }
        paramOutputStream = paramDownloadParams;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, new Object[] { "static file exist:", Integer.valueOf(i) });
      return paramDownloadParams;
      paramDownloadParams = g(i);
      paramOutputStream = paramDownloadParams;
    } while (paramDownloadParams != null);
    label217:
    jL(1, i);
    for (;;)
    {
      label224:
      return null;
      label226:
      if ("host_qqsys_static".equals(paramOutputStream)) {
        jL(1, i);
      } else if ("host_emoji".equals(paramOutputStream)) {
        jL(2, i);
      }
    }
  }
  
  protected Object a(File paramFile)
  {
    return NativeGifFactory.getNativeGifObject(paramFile, false);
  }
  
  protected String bI(String paramString1, String paramString2)
  {
    int i = 2;
    if ("host_qqsys_gif".equals(paramString1)) {
      i = 1;
    }
    for (;;)
    {
      return afkv.B(i, paramString2);
      if ("host_emoji".equals(paramString1)) {
        i = 3;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (paramFile == null) {
      return null;
    }
    if (GifDrawable.isGifFile(paramFile)) {
      return a(paramFile);
    }
    return t(paramFile.getAbsolutePath());
  }
  
  protected File g(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str;
    if (paramInt < aoff.ol.length)
    {
      if (aV == null) {
        aV = BaseApplicationImpl.getApplication().getDir("systemface", 0);
      }
      str = BaseApplicationImpl.getContext().getResources().getResourceEntryName(aoff.ol[paramInt]);
      localObject2 = new File(aV + File.separator + str);
      if (((File)localObject2).exists()) {
        break label162;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel()) {
        if (localObject1 == null) {
          break label157;
        }
      }
      label157:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("AbsDownloader", 2, new Object[] { "getGifFileFromOldDir:", Integer.valueOf(paramInt), " ,name:", str, " ,exist:", Boolean.valueOf(bool) });
        localObject2 = localObject1;
        return localObject2;
      }
      label162:
      localObject1 = localObject2;
    }
  }
  
  protected void jL(int paramInt1, int paramInt2)
  {
    afkv.a().a(paramInt1).MA(paramInt2);
  }
  
  protected boolean lP(int paramInt)
  {
    return afky.jo(paramInt);
  }
  
  protected Object t(String paramString)
  {
    return BitmapFactory.decodeFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomv
 * JD-Core Version:    0.7.0.1
 */