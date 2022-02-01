import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class amgj
  implements View.OnTouchListener
{
  public amgj(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131380936).getHeight() + wja.dp2px(30.0F, paramView.getResources())) {
        SignatureHistoryFragment.a(this.this$0, true);
      }
    }
    else {
      return false;
    }
    SignatureHistoryFragment.a(this.this$0, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgj
 * JD-Core Version:    0.7.0.1
 */