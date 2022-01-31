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

public class yzo
{
  public static String a;
  private static yzo jdField_a_of_type_Yzo;
  private Map<String, yzq> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private yzo()
  {
    a(BaseApplicationImpl.getContext());
  }
  
  private String a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getExternalFilesDir("video_story");
      if (paramContext != null) {
        jdField_a_of_type_JavaLangString = paramContext.getAbsolutePath();
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
      jdField_a_of_type_JavaLangString = paramContext + "/Tencent/MobileQQ/" + "video_story";
    }
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "intDownLoadRoot" + jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static yzo a()
  {
    try
    {
      if (jdField_a_of_type_Yzo == null) {
        jdField_a_of_type_Yzo = new yzo();
      }
      yzo localyzo = jdField_a_of_type_Yzo;
      return localyzo;
    }
    finally {}
  }
  
  public String a(String paramString)
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
  
  public void a(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:url is empty" });
    }
    String str1;
    String str2;
    yzq localyzq;
    beaj localbeaj;
    beae localbeae;
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          str1 = a(paramString);
          if (TextUtils.isEmpty(str1))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:prefixId is empty" });
            return;
          }
          QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:prefixId:" + str1);
          if (b(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource has download");
            return;
          }
          if (c(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource on download");
            return;
          }
          if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:mDownLoadRoot is empty" });
            return;
          }
          str2 = jdField_a_of_type_JavaLangString + "/" + str1 + ".zip";
        } while (TextUtils.isEmpty(paramString));
        localyzq = new yzq(this, null);
        this.jdField_a_of_type_JavaUtilMap.put(str1, localyzq);
        localbeaj = ((beag)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      } while (localbeaj == null);
      localbeae = new beae(paramString, new File(str2));
      localbeae.b = 1;
      localBundle = new Bundle();
    } while (localbeaj == null);
    localbeaj.a(localbeae, new yzp(this, paramDownloadListener, str2, localyzq, str1, paramString), localBundle);
  }
  
  public void a(yyz paramyyz)
  {
    if (paramyyz != null) {
      a(paramyyz.a(), null);
    }
  }
  
  public void a(yzb paramyzb)
  {
    if (paramyzb != null) {
      a(paramyzb.a(), null);
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return b(paramString);
    }
    return false;
  }
  
  public String b(String paramString)
  {
    return jdField_a_of_type_JavaLangString + "/" + a(paramString);
  }
  
  public boolean b(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString + "/" + paramString;
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
        localObject = new yzq(this, null);
        yzq.a((yzq)localObject, 0);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = (yzq)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (yzq.a(paramString) == -1) || (yzq.a(paramString) == 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzo
 * JD-Core Version:    0.7.0.1
 */