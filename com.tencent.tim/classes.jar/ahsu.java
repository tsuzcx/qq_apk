import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;

public class ahsu
  implements View.OnTouchListener
{
  public ahsu(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */