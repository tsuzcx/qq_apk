import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class era
  implements View.OnFocusChangeListener
{
  public era(VideoViewX paramVideoViewX) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     era
 * JD-Core Version:    0.7.0.1
 */