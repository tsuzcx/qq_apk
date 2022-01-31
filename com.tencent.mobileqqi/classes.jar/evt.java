import android.media.SoundPool;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

class evt
  implements Runnable
{
  evt(evs paramevs) {}
  
  public void run()
  {
    VoipDialInterfaceActivity.a(this.a.a).play(VoipDialInterfaceActivity.i(this.a.a), 1.0F, 1.0F, 0, 0, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evt
 * JD-Core Version:    0.7.0.1
 */