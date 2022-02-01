import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class assd
  implements View.OnTouchListener
{
  public assd(Login paramLogin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.a.bH) {
      if ((paramMotionEvent.getAction() == 0) && (this.a.bH.getText().length() > 0)) {
        this.a.Kj.setVisibility(0);
      }
    }
    while ((paramView != this.a.bG) || (paramMotionEvent.getAction() != 0) || (this.a.bG.getText().length() <= 0)) {
      return false;
    }
    this.a.Ar.setVisibility(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assd
 * JD-Core Version:    0.7.0.1
 */