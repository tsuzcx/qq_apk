import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;

public class gjq
  implements View.OnTouchListener
{
  public gjq(QZoneShareAlbumAssistantActivity paramQZoneShareAlbumAssistantActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QZoneShareAlbumAssistantActivity.a(this.a).getVisibility() == 0) {
      QZoneShareAlbumAssistantActivity.b(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjq
 * JD-Core Version:    0.7.0.1
 */