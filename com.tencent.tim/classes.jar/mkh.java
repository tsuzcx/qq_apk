import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;

public class mkh
  implements View.OnTouchListener
{
  public mkh(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = ReadInJoyUgcSearchTopicFragment.a(this.this$0).getCompoundDrawables()[2];
    if ((paramMotionEvent.getAction() == 0) && (paramView != null))
    {
      float f = ReadInJoyUgcSearchTopicFragment.a(this.this$0).getRight() - paramView.getBounds().width();
      if (paramMotionEvent.getRawX() >= f)
      {
        ReadInJoyUgcSearchTopicFragment.b(this.this$0);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkh
 * JD-Core Version:    0.7.0.1
 */