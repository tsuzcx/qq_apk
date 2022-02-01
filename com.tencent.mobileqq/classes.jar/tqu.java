import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class tqu
  implements tkl
{
  public tqu(ADVideoAppDownloadManager paramADVideoAppDownloadManager, tqt paramtqt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + this.jdField_a_of_type_Tqt.d);
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a = true;
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a();
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).c(this.jdField_a_of_type_Tqt);
    }
    label70:
    do
    {
      do
      {
        do
        {
          do
          {
            break label70;
            break label70;
            do
            {
              return;
            } while ((ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager) == null) || (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a == null) || (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a.a == null) || (!tpz.d(ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a.a.a)));
            int j = ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager, ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager), this.jdField_a_of_type_Tqt);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (this.jdField_a_of_type_Tqt.b > 0) {
                i = this.jdField_a_of_type_Tqt.b;
              }
            }
            if ((i < 0) || ((this.jdField_a_of_type_Tqt.a != 3) && (this.jdField_a_of_type_Tqt.a != 4))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + this.jdField_a_of_type_Tqt.d + " " + i);
            }
            if (this.jdField_a_of_type_Tqt.a == 3)
            {
              ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).b(this.jdField_a_of_type_Tqt, i);
              return;
            }
          } while (this.jdField_a_of_type_Tqt.a != 4);
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a(this.jdField_a_of_type_Tqt);
          return;
          if ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a) && ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager)) || (!acwa.a()))) {
            break;
          }
          if (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager).a)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "autodownload not by userClick");
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(this.jdField_a_of_type_Tqt, 0);
            return;
          }
        } while ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager)) || (!acwa.a()));
        if (!ADVideoAppDownloadManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ADVideoAppDownloadManager", 2, "autodownload for getAppData <1s");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(this.jdField_a_of_type_Tqt, 0);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "dont autodownload for getAppData >1s");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqu
 * JD-Core Version:    0.7.0.1
 */