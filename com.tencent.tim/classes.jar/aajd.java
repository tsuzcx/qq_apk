import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class aajd
{
  private static aajd a;
  private File Z = new File(BaseApplicationImpl.getApplication().getCacheDir(), "qboss_ad");
  private Map<String, aajc> iD = new HashMap();
  private Downloader mDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private volatile boolean mIsDownloading;
  
  public static aajd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aajd();
      }
      return a;
    }
    finally {}
  }
  
  private void a(aajc paramaajc, String paramString, boolean paramBoolean)
  {
    if ((paramaajc == null) || (TextUtils.isEmpty(paramString)) || (paramaajc.bR == null)) {
      return;
    }
    int i = 0;
    label22:
    aajc.a locala;
    if (i < paramaajc.bR.size())
    {
      locala = (aajc.a)paramaajc.bR.valueAt(i);
      if ((locala != null) && (!TextUtils.isEmpty(locala.resUrl))) {
        break label73;
      }
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label73:
      if (locala.resUrl.equalsIgnoreCase(paramString)) {
        locala.Co(paramBoolean);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, aajc paramaajc)
  {
    if ((paramaajc == null) || (paramaajc.bR == null) || (paramaajc.bR.size() == 0))
    {
      bG(paramQQAppInterface);
      return;
    }
    paramQQAppInterface = new aajd.a(paramQQAppInterface, paramaajc, paramaajc.bR.size());
    int i = 0;
    label47:
    aajc.a locala;
    if (i < paramaajc.bR.size())
    {
      locala = (aajc.a)paramaajc.bR.valueAt(i);
      if ((locala != null) && (!TextUtils.isEmpty(locala.resUrl))) {
        break label94;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label94:
      if (this.mDownloader != null) {
        this.mDownloader.download(locala.resUrl, locala.filePath, false, paramQQAppInterface);
      }
    }
  }
  
  private void bF(QQAppInterface paramQQAppInterface)
  {
    this.mIsDownloading = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerShow");
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.sendEmptyMessage(1062);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "handle is null.");
  }
  
  private void bG(QQAppInterface paramQQAppInterface)
  {
    this.mIsDownloading = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerHide");
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.sendEmptyMessage(1063);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "handle is null.");
  }
  
  public void At(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "removeQBossADBannerConfig uin is empty. return.");
      return;
    }
    synchronized (this.iD)
    {
      this.iD.remove(paramString);
      return;
    }
  }
  
  public aajc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "getQBossADBannerConfig uin is empty. return.");
      return null;
    }
    synchronized (this.iD)
    {
      paramString = (aajc)this.iD.get(paramString);
      return paramString;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, aajc paramaajc)
  {
    if (paramQQAppInterface == null)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify app is null. return.");
      return;
    }
    String str = paramQQAppInterface.getCurrentUin();
    if (TextUtils.isEmpty(str))
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify uin is empty. return.");
      return;
    }
    if (this.mIsDownloading)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify mIsDownloading = " + this.mIsDownloading + " multi banner show");
      return;
    }
    Map localMap = this.iD;
    if (paramaajc == null) {}
    for (;;)
    {
      try
      {
        this.iD.remove(str);
        if (paramaajc != null) {
          break;
        }
        QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify QBossADBannerConfigInfo = null notifyBannerHide");
        bG(paramQQAppInterface);
        return;
      }
      finally {}
      this.iD.put(str, paramaajc);
    }
    if (paramaajc.Wx())
    {
      QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist exist , notifyBannerShow ");
      bF(paramQQAppInterface);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist is not exist , start downloadFile ");
    this.mIsDownloading = true;
    b(paramQQAppInterface, paramaajc);
  }
  
  public void al(long paramLong, int paramInt)
  {
    long l2 = NetConnInfoCenter.getServerTime();
    long l1 = paramLong;
    if (paramLong > l2 + 86400L)
    {
      paramLong = l2 + 86400L;
      l1 = paramLong;
      if (QLog.isDevelopLevel())
      {
        QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime nextRequestTime upper limit 24 " + paramLong);
        l1 = paramLong;
      }
    }
    SharedPreferences.Editor localEditor = aljs.x().edit();
    localEditor.putLong("qbossNextRequestTime_" + paramInt, l1);
    localEditor.commit();
    if (QLog.isDevelopLevel()) {
      QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime appid = " + paramInt + " nextRequestTime =  " + l1);
    }
  }
  
  public void gG(long paramLong)
  {
    al(paramLong, 2741);
    al(paramLong, 2742);
  }
  
  public boolean hz(int paramInt)
  {
    long l = aljs.x().getLong("qbossNextRequestTime_" + paramInt, 0L);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public String ii(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return this.Z.getAbsolutePath() + File.separator + Utils.Crc64String(paramString) + paramString.substring(paramString.lastIndexOf("."));
  }
  
  class a
    implements Downloader.DownloadListener
  {
    private aajc a;
    private volatile int chj;
    private volatile int chk;
    private int chl;
    private WeakReference<QQAppInterface> n;
    
    public a(QQAppInterface paramQQAppInterface, aajc paramaajc, int paramInt)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.a = paramaajc;
      this.chl = paramInt;
      this.chj = 0;
      this.chk = 0;
    }
    
    public void onDownloadCanceled(String paramString) {}
    
    public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerConfigManager", 2, "diy data download fail url = " + paramString);
      }
      this.chk += 1;
      aajd.a(aajd.this, this.a, paramString, false);
      if (this.a != null) {
        avyz.a().s(2741, this.a.taskId, 101, "qboss download resources fail mErrCode = " + paramDownloadResult.getStatus().httpStatus + " resUrl = " + paramString);
      }
      paramString = (QQAppInterface)this.n.get();
      if (this.chk + this.chj == this.chl) {
        aajd.a(aajd.this, paramString);
      }
    }
    
    public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
    
    public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerConfigManager", 2, "banner resources download success url = " + paramString);
      }
      this.chj += 1;
      aajd.a(aajd.this, this.a, paramString, true);
      paramString = (QQAppInterface)this.n.get();
      if (this.chj == this.chl) {
        aajd.b(aajd.this, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajd
 * JD-Core Version:    0.7.0.1
 */