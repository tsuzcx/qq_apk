import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import cooperation.qzone.share.QZoneShareActivity;

public class avzw
  implements View.OnTouchListener
{
  public avzw(QZoneShareActivity paramQZoneShareActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.this$0.jb();
    if ((!this.this$0.rY) && (this.this$0.bK != null))
    {
      this.this$0.bK.setHint("");
      this.this$0.rY = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzw
 * JD-Core Version:    0.7.0.1
 */