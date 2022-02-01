import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

public class aeaa
  implements View.OnTouchListener
{
  public aeaa(ClearEllipsisEditText paramClearEllipsisEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.this$0.getCompoundDrawables()[2] == null) {}
    for (;;)
    {
      return false;
      if (paramMotionEvent.getX() > this.this$0.getWidth() - this.this$0.getPaddingRight() - ClearEllipsisEditText.a(this.this$0).getIntrinsicWidth()) {}
      for (int i = 1; (paramMotionEvent.getAction() == 0) && (i != 0); i = 0)
      {
        this.this$0.setText("");
        this.this$0.setClearButtonVisible(false);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeaa
 * JD-Core Version:    0.7.0.1
 */