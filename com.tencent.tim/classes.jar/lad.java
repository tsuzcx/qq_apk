import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class lad
{
  private static volatile lad jdField_a_of_type_Lad;
  private final lac jdField_a_of_type_Lac = new lac();
  private TMAssistantDownloadClient c = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  
  private lad()
  {
    this.c.registerDownloadTaskListener(this.jdField_a_of_type_Lac);
  }
  
  public static lad a()
  {
    if (jdField_a_of_type_Lad != null) {
      return jdField_a_of_type_Lad;
    }
    try
    {
      if (jdField_a_of_type_Lad == null) {
        jdField_a_of_type_Lad = new lad();
      }
      return jdField_a_of_type_Lad;
    }
    finally {}
  }
  
  private void a(lad.a parama)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, parama), 15000L);
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    asac.a().j(paramDownloadInfo);
    a(new lad.a(paramDownloadInfo, null));
  }
  
  public void c(lab paramlab)
  {
    this.jdField_a_of_type_Lac.a(paramlab);
  }
  
  public void d(lab paramlab)
  {
    this.jdField_a_of_type_Lac.b(paramlab);
  }
  
  public static class a
  {
    private static int aMP = 5000;
    private int aMO = 3;
    private final DownloadInfo b;
    private final Map<String, String> df = new HashMap();
    
    private a(DownloadInfo paramDownloadInfo)
    {
      this.b = paramDownloadInfo;
      this.df.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.appId);
      this.df.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.packageName);
      this.df.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.versionCode));
      this.df.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.via);
      this.df.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
      this.df.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
      this.df.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.iconUrl);
      this.df.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.pushTitle);
      this.df.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.ell));
      this.df.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.isAutoInstallBySDK));
      this.df.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.fileSize));
    }
    
    private Map<String, String> E()
    {
      return this.df;
    }
    
    private void aIm()
    {
      this.aMO -= 1;
    }
    
    private int oe()
    {
      return this.aMO;
    }
    
    public DownloadInfo a()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lad
 * JD-Core Version:    0.7.0.1
 */