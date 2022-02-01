import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;

public class aoza
  implements View.OnTouchListener
{
  float x = 0.0F;
  float y = 0.0F;
  
  public aoza(NewTroopContactView paramNewTroopContactView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.x = paramMotionEvent.getRawX();
      this.y = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      return false;
      if ((i == 2) && ((paramMotionEvent.getRawX() - this.x > 10.0F) || (paramMotionEvent.getRawY() - this.y > 10.0F))) {
        this.b.T.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoza
 * JD-Core Version:    0.7.0.1
 */