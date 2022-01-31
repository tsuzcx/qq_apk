import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class etb
  implements View.OnClickListener
{
  public etb(VideoViewX paramVideoViewX) {}
  
  public void onClick(View paramView)
  {
    if (VideoViewX.a(this.a) == -1) {
      this.a.d = true;
    }
    if ((VideoViewX.a(this.a) != null) && (VideoViewX.a(this.a) != 0) && (VideoViewX.a(this.a) != 1) && (VideoViewX.a(this.a) != null)) {
      VideoViewX.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etb
 * JD-Core Version:    0.7.0.1
 */