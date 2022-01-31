import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.TroopTransferActivity;

public class ubl
  implements View.OnTouchListener
{
  public ubl(TroopTransferActivity paramTroopTransferActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (InputMethodManager)this.a.getSystemService("input_method");
    if (paramMotionEvent != null) {
      paramMotionEvent.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubl
 * JD-Core Version:    0.7.0.1
 */