import android.os.Handler;
import com.tencent.mobileqq.tts.SilkStreamPlayer.a;

class apzq
  implements SilkStreamPlayer.a
{
  apzq(apzp paramapzp) {}
  
  public void ecM()
  {
    apzp.a(this.b).sendEmptyMessage(1);
  }
  
  public void ecN()
  {
    apzp.a(this.b).sendEmptyMessage(0);
  }
  
  public void onStop()
  {
    if (apzp.a(this.b) != null) {
      apzp.a(this.b).onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzq
 * JD-Core Version:    0.7.0.1
 */