import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.vip.ar.util.VipQGLoaderManager.1;
import java.util.HashMap;

public class awll
  implements awku
{
  private static awll jdField_a_of_type_Awll;
  private static final int eBz = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private aeoq jdField_a_of_type_Aeoq;
  private Downloader mDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> qV = new HashMap();
  
  public static awll a()
  {
    if (jdField_a_of_type_Awll == null) {}
    try
    {
      if (jdField_a_of_type_Awll == null) {
        jdField_a_of_type_Awll = new awll();
      }
      return jdField_a_of_type_Awll;
    }
    finally {}
  }
  
  public void a(aeoq.a parama, awkt paramawkt)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.resUrl))) {}
    String str1;
    do
    {
      return;
      str1 = parama.resUrl;
      if (this.qV.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (paramawkt == null);
    paramawkt.abS((String)this.qV.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, paramawkt, parama));
  }
  
  public boolean aNh()
  {
    return (this.jdField_a_of_type_Aeoq != null) && (this.jdField_a_of_type_Aeoq.cOk != 0) && (!awlg.aF(this.jdField_a_of_type_Aeoq.bAa)) && (Build.VERSION.SDK_INT > eBz);
  }
  
  public void abU(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public void b(aeoq.a parama, awkt paramawkt)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.resUrl)) || (this.mDownloader == null))
    {
      if (paramawkt != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (parama != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        paramawkt.abT(bool);
        return;
      }
    }
    Object localObject = parama.resUrl;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.mDownloader.download((String)localObject, str, false, new awlm(this, paramawkt, (String)localObject, str, parama));
  }
  
  public void c(aeoq paramaeoq)
  {
    if (paramaeoq != null)
    {
      this.jdField_a_of_type_Aeoq = paramaeoq;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramaeoq.cOk);
    }
  }
  
  public void d(aeoq paramaeoq)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramaeoq == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Aeoq = paramaeoq;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awll
 * JD-Core Version:    0.7.0.1
 */