import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class yag
  implements View.OnTouchListener
{
  yag(xzp paramxzp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    paramView = this.this$0.a.a();
    if (i == 0)
    {
      this.this$0.KG.setText(acfp.m(2131706836));
      this.this$0.KG.setTextColor(this.this$0.bYa);
      this.this$0.mGameRoomAVController.aqG();
      if (paramView != null) {
        paramView.Tz(true);
      }
      anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      bool = true;
    }
    while ((i != 3) && (i != 1)) {
      return bool;
    }
    this.this$0.KG.setText(acfp.m(2131706775));
    this.this$0.KG.setTextColor(this.this$0.bXZ);
    this.this$0.mGameRoomAVController.aqH();
    if (paramView != null) {
      paramView.Tz(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yag
 * JD-Core Version:    0.7.0.1
 */