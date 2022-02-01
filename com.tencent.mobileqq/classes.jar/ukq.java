import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;

public class ukq
{
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ukr(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new uks(Looper.getMainLooper(), this);
  
  public static ukq a()
  {
    return ukt.a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio"));
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    uqf.e("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestOrAbandonAudioFocus] isFocus:" + paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukq
 * JD-Core Version:    0.7.0.1
 */