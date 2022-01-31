import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

class hzb
  implements AudioManager.OnAudioFocusChangeListener
{
  hzb(hyy paramhyy) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.u + " currMode:" + this.a.b.a.getMode() + " _activeMode:" + this.a.b.w);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzb
 * JD-Core Version:    0.7.0.1
 */