import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class aaxo
  implements View.OnTouchListener
{
  float x = 0.0F;
  float y = 0.0F;
  
  public aaxo(SelectMemberActivity paramSelectMemberActivity) {}
  
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
        this.this$0.a.bVm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxo
 * JD-Core Version:    0.7.0.1
 */