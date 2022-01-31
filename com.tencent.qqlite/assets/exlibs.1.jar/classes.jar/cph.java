import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class cph
  implements Runnable
{
  public cph(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    ShortVideoPlayActivity.a(this.a).removeView(ShortVideoPlayActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cph
 * JD-Core Version:    0.7.0.1
 */