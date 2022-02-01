import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.confess.ConfessPlugin;

public class aegw
  implements View.OnTouchListener
{
  public aegw(ConfessPlugin paramConfessPlugin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if ((paramView instanceof TextView))
      {
        int i = ((TextView)paramView).getCurrentTextColor();
        ((TextView)paramView).setTextColor(Color.argb(128, Color.red(i), Color.green(i), Color.blue(i)));
        continue;
        if ((paramView instanceof TextView))
        {
          i = ((TextView)paramView).getCurrentTextColor();
          ((TextView)paramView).setTextColor(Color.argb(255, Color.red(i), Color.green(i), Color.blue(i)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegw
 * JD-Core Version:    0.7.0.1
 */