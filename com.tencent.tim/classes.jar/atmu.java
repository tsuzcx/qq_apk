import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.troopFile.TroopFileCopyInfoEntity;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody;

class atmu
  extends auqa.a
{
  atmu(atmt paramatmt, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity) {}
  
  public void a(boolean paramBoolean, oidb_0x6d9.CopyToRspBody paramCopyToRspBody, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.e("CopyToCloudProcessor.TroopAutoSaveToCloud", 1, "onCopyToResult : " + paramBoolean);
      return;
    }
    int i = paramCopyToRspBody.int32_ret_code.get();
    if (QLog.isColorLevel()) {
      QLog.i("CopyToCloudProcessor.TroopAutoSaveToCloud", 1, this.a.troopUin + ":" + this.a.strFileName + " SaveToCloud reCode : " + i);
    }
    if ((i == 0) || (i == -103) || (i == -132) || (i == -134) || (i == -301) || (i == -302) || (i == -304) || (i == 1051) || (i == -7003) || (i == 6186) || (i == 1095) || (i == 1091) || (i == 1020) || (i == -6101))
    {
      if (paramCopyToRspBody.str_save_file_path.has()) {
        this.a.cloudId = paramCopyToRspBody.str_save_file_path.get();
      }
      atmt.a(this.this$0).a(true, this.a);
      return;
    }
    atmt.a(this.this$0).a(false, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmu
 * JD-Core Version:    0.7.0.1
 */