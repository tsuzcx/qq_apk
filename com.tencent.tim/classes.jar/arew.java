import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.ConfigClearableEditText.b;
import com.tencent.mobileqq.widget.ConfigClearableEditText.c;

public class arew
  implements View.OnTouchListener
{
  public arew(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.c;
    int i;
    if (paramMotionEvent.getX() > ConfigClearableEditText.a(this.c))
    {
      i = 1;
      if (ConfigClearableEditText.a(this.c) != null)
      {
        if ((i == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
          break label102;
        }
        ConfigClearableEditText.a(this.c).Cy(true);
      }
      label66:
      if ((paramView.getCompoundDrawables()[2] != null) || ((ConfigClearableEditText.a(this.c)) && (ConfigClearableEditText.a(this.c) != null))) {
        break label118;
      }
    }
    label102:
    label118:
    do
    {
      do
      {
        return false;
        i = 0;
        break;
        ConfigClearableEditText.a(this.c).Cy(false);
        break label66;
      } while ((paramMotionEvent.getAction() != 1) || (i == 0));
      this.c.setText("");
      this.c.setClearButtonVisible(false);
    } while (this.c.a == null);
    this.c.a.bFw();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arew
 * JD-Core Version:    0.7.0.1
 */