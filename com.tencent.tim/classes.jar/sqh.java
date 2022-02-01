import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class sqh
{
  private static sqh a;
  public static String aFJ;
  private Map<String, sqh.a> gx = new ConcurrentHashMap();
  
  private sqh()
  {
    ap(BaseApplicationImpl.getContext());
  }
  
  public static sqh a()
  {
    try
    {
      if (a == null) {
        a = new sqh();
      }
      sqh localsqh = a;
      return localsqh;
    }
    finally {}
  }
  
  private String ap(Context paramContext)
  {
    if (TextUtils.isEmpty(aFJ))
    {
      paramContext = paramContext.getExternalFilesDir("video_story");
      if (paramContext != null) {
        aFJ = paramContext.getAbsolutePath();
      }
    }
    if (TextUtils.isEmpty(aFJ))
    {
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
      aFJ = paramContext + "/Tencent/MobileQQ/" + "video_story";
    }
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "intDownLoadRoot" + aFJ);
    return null;
  }
  
  public void b(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:url is empty" });
    }
    String str1;
    String str2;
    sqh.a locala;
    aqvc localaqvc;
    aquz localaquz;
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          str1 = gJ(paramString);
          if (TextUtils.isEmpty(str1))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:prefixId is empty" });
            return;
          }
          QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:prefixId:" + str1);
          if (gb(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource has download");
            return;
          }
          if (gc(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource on download");
            return;
          }
          if (TextUtils.isEmpty(aFJ))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:mDownLoadRoot is empty" });
            return;
          }
          str2 = aFJ + "/" + str1 + ".zip";
        } while (TextUtils.isEmpty(paramString));
        locala = new sqh.a(null);
        this.gx.put(str1, locala);
        localaqvc = ((aqva)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      } while (localaqvc == null);
      localaquz = new aquz(paramString, new File(str2));
      localaquz.retryCount = 1;
      localBundle = new Bundle();
    } while (localaqvc == null);
    localaqvc.a(localaquz, new sqi(this, paramDownloadListener, str2, locala, str1, paramString), localBundle);
  }
  
  public void b(sps paramsps)
  {
    if (paramsps != null) {
      b(paramsps.getDownloadUrl(), null);
    }
  }
  
  public void b(spu paramspu)
  {
    if (paramspu != null) {
      b(paramspu.getDownloadUrl(), null);
    }
  }
  
  public String gJ(String paramString)
  {
    try
    {
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
      paramString = paramString.substring(0, paramString.indexOf(".zip"));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String gK(String paramString)
  {
    return aFJ + "/" + gJ(paramString);
  }
  
  public boolean ga(String paramString)
  {
    paramString = gJ(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return gb(paramString);
    }
    return false;
  }
  
  public boolean gb(String paramString)
  {
    Object localObject = aFJ + "/" + paramString;
    if (new File((String)localObject + ".zip").exists())
    {
      QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "upZip failed:" + paramString);
      return false;
    }
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool2 = new File((String)localObject).exists();
      bool1 = bool2;
      if (bool2)
      {
        localObject = new sqh.a(null);
        sqh.a.a((sqh.a)localObject, 0);
        this.gx.put(paramString, localObject);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean gc(String paramString)
  {
    paramString = (sqh.a)this.gx.get(paramString);
    if (paramString != null) {
      return (sqh.a.a(paramString) == -1) || (sqh.a.a(paramString) == 1);
    }
    return false;
  }
  
  class a
  {
    private int aDC = -1;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqh
 * JD-Core Version:    0.7.0.1
 */