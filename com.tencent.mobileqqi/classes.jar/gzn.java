import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class gzn
  implements View.OnFocusChangeListener
{
  public gzn(VideoViewX paramVideoViewX) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzn
 * JD-Core Version:    0.7.0.1
 */