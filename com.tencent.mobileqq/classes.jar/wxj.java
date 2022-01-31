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

public class wxj
{
  public static String a;
  private static wxj jdField_a_of_type_Wxj;
  private Map<String, wxl> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private wxj()
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
  
  public static wxj a()
  {
    try
    {
      if (jdField_a_of_type_Wxj == null) {
        jdField_a_of_type_Wxj = new wxj();
      }
      wxj localwxj = jdField_a_of_type_Wxj;
      return localwxj;
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
    wxl localwxl;
    batr localbatr;
    batm localbatm;
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
        localwxl = new wxl(this, null);
        this.jdField_a_of_type_JavaUtilMap.put(str1, localwxl);
        localbatr = ((bato)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      } while (localbatr == null);
      localbatm = new batm(paramString, new File(str2));
      localbatm.b = 1;
      localBundle = new Bundle();
    } while (localbatr == null);
    localbatr.a(localbatm, new wxk(this, paramDownloadListener, str2, localwxl, str1, paramString), localBundle);
  }
  
  public void a(www paramwww)
  {
    if (paramwww != null) {
      a(paramwww.a(), null);
    }
  }
  
  public void a(wwy paramwwy)
  {
    if (paramwwy != null) {
      a(paramwwy.a(), null);
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
        localObject = new wxl(this, null);
        wxl.a((wxl)localObject, 0);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = (wxl)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (wxl.a(paramString) == -1) || (wxl.a(paramString) == 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxj
 * JD-Core Version:    0.7.0.1
 */