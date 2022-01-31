import android.media.SoundPool;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

class evd
  implements Runnable
{
  evd(evc paramevc) {}
  
  public void run()
  {
    VoipDialInterfaceActivity.a(this.a.a).play(VoipDialInterfaceActivity.d(this.a.a), 1.0F, 1.0F, 0, 0, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evd
 * JD-Core Version:    0.7.0.1
 */