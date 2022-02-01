import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;
import com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.9.1;

public class aubf
  implements atye.a
{
  aubf(auau paramauau, atzy.b paramb, TroopInfo paramTroopInfo, TroopManager paramTroopManager) {}
  
  public void bD(int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      if (paramInt1 == 0) {
        break label144;
      }
      this.a.djB();
    }
    while (paramInt1 != 0)
    {
      if (this.a != null) {
        this.a.djB();
      }
      anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
      this.k.mTroopFileVideoIsWhite = paramInt1;
      this.k.mTroopFileVideoReqInterval = (System.currentTimeMillis() + paramInt2 * 1000);
      ThreadManager.post(new TroopFileModel.9.1(this), 5, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "OfflineVideoFileView initVarView() is_white = " + paramInt1 + ", req_interval = " + paramInt2);
      }
      return;
      label144:
      this.a.djC();
    }
    if (this.a != null) {
      this.a.djC();
    }
    if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
    for (String str = "0";; str = "-1")
    {
      anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubf
 * JD-Core Version:    0.7.0.1
 */