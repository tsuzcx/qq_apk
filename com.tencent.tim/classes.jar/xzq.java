import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class xzq
  implements View.OnTouchListener
{
  xzq(xzp paramxzp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.this$0.a.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.aGo()))
      {
        this.this$0.KF.setText(acfp.m(2131706790));
        this.this$0.KF.setPressed(true);
        this.this$0.mGameRoomAVController.aqG();
        paramView.Tz(true);
      }
    }
    do
    {
      return true;
      this.this$0.zM(false);
      return true;
      if ((i != 3) && (i != 1)) {
        break;
      }
      this.this$0.KF.setText(acfp.m(2131706786));
      this.this$0.KF.setPressed(false);
      this.this$0.mGameRoomAVController.aqH();
    } while (paramView == null);
    paramView.Tz(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzq
 * JD-Core Version:    0.7.0.1
 */