import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class aqko
  implements View.OnTouchListener
{
  aqko(aqkk paramaqkk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.this$0.zR.setImageResource(2130838215);
    this.this$0.zR.setTag(Integer.valueOf(2130838215));
    if (this.this$0.brS)
    {
      aqkk.a(this.this$0);
      if (!this.this$0.cUt) {
        break label110;
      }
      this.this$0.mWindowManager.removeView(this.this$0.b);
    }
    for (;;)
    {
      this.this$0.brS = false;
      paramView = this.this$0.getWindow().getAttributes();
      paramView.y = 0;
      this.this$0.getWindow().setAttributes(paramView);
      return false;
      label110:
      this.this$0.mWindowManager.removeView(this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqko
 * JD-Core Version:    0.7.0.1
 */