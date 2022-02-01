import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;

public class oij
{
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private RockDownloadListener jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  private Activity mActivity;
  
  public oij(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private RockDownloadListener a(RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener = new RockDownloadPresenter.1(this, paramRockDownloadListenerWrapper);
    }
    return this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  }
  
  public static String lu()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  public RockDownloadInfo a()
  {
    int i = ohy.a().rt();
    String str2 = ohy.a().lq();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = lu();
    }
    return new RockDownloadInfo("biz_src_jc_gzh_weishi", "weishi_gzh", "com.tencent.weishi", str1, i);
  }
  
  public void a(Activity paramActivity, RockDownloadInfo paramRockDownloadInfo, int paramInt, WSDownloadParams paramWSDownloadParams, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if ((paramActivity != null) && (paramInt == 3)) {
      oik.aX(paramActivity);
    }
    if (oir.isDownloading())
    {
      ooz.e("RockDownloader", "已有正在下载的任务，不响应");
      return;
    }
    paramActivity = paramWSDownloadParams;
    if (paramWSDownloadParams == null) {
      paramActivity = new WSDownloadParams();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramActivity;
    ong.a(paramActivity, 1);
    WSPublicAccReport.getInstance().reportDownload(paramActivity.mEventId, paramInt, 1, 1, 0);
    if (paramInt == 1)
    {
      adxc.a(paramRockDownloadInfo, a(paramRockDownloadListenerWrapper));
      ooz.e("RockDownloader", "执行预下载Rock下载 " + paramRockDownloadInfo.toString());
      return;
    }
    opn.writeEncryptedDeviceIdToClipboard(paramActivity.mScheme);
    adxc.a(paramRockDownloadInfo, a(paramRockDownloadListenerWrapper));
    ooz.e("RockDownloader", "执行可call起安装Rock下载 " + paramRockDownloadInfo.toString());
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo)
  {
    boolean bool = adxc.b(paramRockDownloadInfo);
    if (bool)
    {
      ooz.d("RockDownloader", "rockdownload deleteSuccess");
      return bool;
    }
    if (paramRockDownloadInfo.realVersionCode == 333)
    {
      ooz.d("RockDownloader", "rockdownload 模拟 deleteFail");
      return bool;
    }
    ooz.d("RockDownloader", "rockdownload deleteFail");
    return bool;
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    boolean bool = adxc.c(paramRockDownloadInfo);
    int i = oir.getEventType();
    if (bool)
    {
      ooz.e("RockDownloader", "rockdownload installSuccess,eventType = " + i);
      ong.dC(paramInt, 1);
      WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 2, 1, 1);
      return bool;
    }
    ooz.e("RockDownloader", "rockdownload installFail,eventType = " + i);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oij
 * JD-Core Version:    0.7.0.1
 */