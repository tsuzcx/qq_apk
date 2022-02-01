import android.media.AudioManager;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ewg
  implements Runnable
{
  public ewg(VoipDialInterfaceActivity paramVoipDialInterfaceActivity, boolean paramBoolean) {}
  
  public void run()
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterfaceActivity.getSystemService("audio");
    if (this.jdField_a_of_type_Boolean)
    {
      localAudioManager.setSpeakerphoneOn(true);
      return;
    }
    localAudioManager.setSpeakerphoneOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewg
 * JD-Core Version:    0.7.0.1
 */