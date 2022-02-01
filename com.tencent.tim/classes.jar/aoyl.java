import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class aoyl
  implements View.OnTouchListener
{
  aoyl(aoyk.a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.a.icon.setAlpha(0.15F);
      this.a.fO.setAlpha(0.5F);
      this.a.title.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((i == 3) || (i == 1))
      {
        this.a.icon.setAlpha(1.0F);
        this.a.fO.setAlpha(1.0F);
        this.a.title.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyl
 * JD-Core Version:    0.7.0.1
 */