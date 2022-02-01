import android.os.Handler;
import com.tencent.mobileqq.bubble.QQAnimationDrawable.b;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;

public class afze
  implements QQAnimationDrawable.b
{
  public afze(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void vz(int paramInt)
  {
    if (paramInt == SignalBombAnimationView.a(this.b)) {
      SignalBombAnimationView.a(this.b).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afze
 * JD-Core Version:    0.7.0.1
 */