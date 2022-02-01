import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aosb
  extends Handler
{
  public aosb(AudioRecordFragment paramAudioRecordFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.getActivity() == null) || (this.a.isDetached())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "handleMessage,fragment is in a invalid state, return");
      }
    }
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOAudioPanel", 2, "RECORD_TO_START =============");
      return;
      paramMessage = paramMessage.obj.toString();
      File localFile = new File(paramMessage);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramMessage, (int)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.v(), l);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
        paramMessage = new Intent();
        paramMessage.putExtra("audio_info", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
        this.a.getActivity().setResult(-1, paramMessage);
        this.a.getActivity().finish();
        return;
      }
    } while ((this.a.mFrom == null) || (!this.a.mFrom.equals("publish")) || (this.a.mBid == null));
    aprv.report("pub_page", "preview_record", this.a.mBid, this.a.cmL, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosb
 * JD-Core Version:    0.7.0.1
 */