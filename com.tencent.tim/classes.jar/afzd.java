import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable.b;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView.a;
import com.tencent.qphone.base.util.QLog;

public class afzd
  implements QQAnimationDrawable.b
{
  public afzd(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void onStart() {}
  
  public void onStop()
  {
    SignalBombAnimationView.a(this.b).setVisibility(4);
    if (SignalBombAnimationView.a(this.b) != null) {
      SignalBombAnimationView.a(this.b).onAnimationEnd();
    }
    QLog.d("SignalBombAnimationViewExtendFriendLimitChat", 2, "onAnimationEnd");
    if (SignalBombAnimationView.a(this.b) != null) {
      SignalBombAnimationView.a(this.b).sendEmptyMessage(1);
    }
  }
  
  public void vz(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzd
 * JD-Core Version:    0.7.0.1
 */