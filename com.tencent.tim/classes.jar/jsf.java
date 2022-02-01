import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;

public class jsf
  implements View.OnTouchListener
{
  Handler handler = new jsg(this);
  int lastY = 0;
  
  public jsf(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(), 5L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsf
 * JD-Core Version:    0.7.0.1
 */