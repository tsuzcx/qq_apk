import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class cnz
  implements Runnable
{
  public cnz(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    ShortVideoPlayActivity.a(this.a).removeView(ShortVideoPlayActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnz
 * JD-Core Version:    0.7.0.1
 */