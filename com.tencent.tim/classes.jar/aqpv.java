import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class aqpv
  implements AudioManager.OnAudioFocusChangeListener
{
  aqpv(aqpt paramaqpt) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "transient focus loss.");
      }
      synchronized (this.this$0.a)
      {
        if (this.this$0.a.aNy == 4) {
          this.this$0.eeP();
        }
        return;
      }
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "gained focus");
      }
      if (this.this$0.cVB)
      {
        this.this$0.eeR();
        this.this$0.cVB = false;
      }
    }
    else if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "Audio focus Loss");
      }
      this.this$0.eeQ();
      synchronized (this.this$0.a)
      {
        this.this$0.a.aNy = 6;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpv
 * JD-Core Version:    0.7.0.1
 */