import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.open.agent.FriendChooser;

public class arqq
  implements View.OnTouchListener
{
  float x = 0.0F;
  float y = 0.0F;
  
  public arqq(FriendChooser paramFriendChooser) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.x = paramMotionEvent.getRawX();
      this.y = paramMotionEvent.getRawY();
    }
    while ((i != 2) || ((paramMotionEvent.getRawX() - this.x <= 10.0F) && (paramMotionEvent.getRawY() - this.y <= 10.0F))) {
      return false;
    }
    this.a.d.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqq
 * JD-Core Version:    0.7.0.1
 */