import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.AudioUploadTask;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import java.io.File;

public class aovz
  extends Handler
{
  public aovz(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      TroopBarReplyActivity.b(this.this$0, false);
      return;
    }
    paramMessage = paramMessage.obj.toString();
    File localFile = new File(paramMessage);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      TroopBarReplyActivity.b(this.this$0, true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
      TroopBarReplyActivity.a(this.this$0, new AudioInfo(paramMessage, (int)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.v(), l));
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = TroopBarReplyActivity.a(this.this$0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask = new TroopBarPublishUtils.AudioUploadTask(this.this$0, this.this$0.mHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      ThreadManager.post(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask, 5, null, true);
      this.this$0.a(2, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      TroopBarReplyActivity.a(this.this$0, 0);
      if (!this.this$0.cPd) {
        break;
      }
      aprv.d(this.this$0.cmV, this.this$0.mOpType, "sure_record", this.this$0.mBid, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovz
 * JD-Core Version:    0.7.0.1
 */