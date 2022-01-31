import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayer;
import com.tencent.qphone.base.util.QLog;

public class ugt
  extends BroadcastReceiver
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long b = 0L;
  
  public ugt(AudioPlayer paramAudioPlayer, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = SystemClock.uptimeMillis();
    int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + i + " " + this.jdField_a_of_type_JavaLangString + ", time=" + l);
    }
    if (1 == i) {
      if (this.b == 0L)
      {
        this.b = l;
        AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer));
        AudioPlayer.b = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) {
          AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
    }
    do
    {
      do
      {
        return;
        if (2 == i)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
      } while (i != 0);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = l;
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
      }
      if (((this.b != 0L) && (l - this.b <= 2000L)) || (l - this.jdField_a_of_type_Long <= 1000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer", 2, "sco disconnected quickly.");
        }
        AudioPlayer.b(true);
        if ((AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer)) && (!AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer).isBluetoothA2dpOn())) {
          AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, false);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
        {
          AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          return;
        }
        AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, 0);
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a());
    AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugt
 * JD-Core Version:    0.7.0.1
 */