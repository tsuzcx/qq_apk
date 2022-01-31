import android.media.SoundPool;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

class etw
  implements Runnable
{
  etw(etv parametv) {}
  
  public void run()
  {
    VoipDialInterfaceActivity.a(this.a.a).play(VoipDialInterfaceActivity.m(this.a.a), 1.0F, 1.0F, 0, 0, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etw
 * JD-Core Version:    0.7.0.1
 */