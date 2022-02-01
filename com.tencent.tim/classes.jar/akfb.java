import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

class akfb
  implements aryx
{
  akfb(akef paramakef) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    this.this$0.bwF = 4;
    this.this$0.dh.sendEmptyMessage(4);
    if (akef.a(this.this$0) != null) {
      anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, akef.a(this.this$0).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    this.this$0.bwF = 2;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.this$0.dh.sendEmptyMessage(5);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    this.this$0.bwF = 3;
    this.this$0.dh.sendEmptyMessage(3);
    if (this.this$0.jdField_a_of_type_Akhp != null) {
      this.this$0.jdField_a_of_type_Akhp.RP(5);
    }
    if (akef.a(this.this$0) != null) {
      anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, akef.a(this.this$0).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    this.this$0.bwF = 2;
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.this$0.bwF = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.this$0.dh.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.progress;
      localMessage.sendToTarget();
      if ((paramList.progress == 0) && (akef.a(this.this$0) != null)) {
        anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, akef.a(this.this$0).uin, "", "yes", "android");
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.this$0.bwF = 2;
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfb
 * JD-Core Version:    0.7.0.1
 */