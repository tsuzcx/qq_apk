import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import cooperation.qzone.share.QZoneShareActivity;

public class awah
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public awah(QZoneShareActivity paramQZoneShareActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i = this.nN.getHeight();
    if (QZoneShareActivity.a(this.this$0) - i > 150) {
      this.this$0.dj.setVisibility(0);
    }
    for (;;)
    {
      QZoneShareActivity.a(this.this$0, i);
      return;
      if ((i - QZoneShareActivity.a(this.this$0) > 150) && (!this.this$0.sa)) {
        this.this$0.dj.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awah
 * JD-Core Version:    0.7.0.1
 */