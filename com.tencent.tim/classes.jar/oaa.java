import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class oaa
  implements View.OnTouchListener
{
  oaa(nzx.a parama, nzx paramnzx, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.tZ.setTextColor(this.a.a.mActivity.getResources().getColor(2131166348));
      if (!this.avT)
      {
        this.a.nm.setBackgroundResource(2130844035);
        return false;
      }
      this.a.nm.setBackgroundResource(2130844036);
      return false;
    }
    this.a.tZ.setTextColor(this.a.a.mActivity.getResources().getColor(2131166347));
    this.a.nm.setBackgroundResource(2130844044);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oaa
 * JD-Core Version:    0.7.0.1
 */