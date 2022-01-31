import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class eqb
  implements View.OnClickListener
{
  public eqb(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    int i = MediaControllerX.a(this.a).b();
    MediaControllerX.a(this.a).a(i - 5000);
    MediaControllerX.a(this.a);
    this.a.a(5000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqb
 * JD-Core Version:    0.7.0.1
 */