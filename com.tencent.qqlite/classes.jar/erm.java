import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class erm
  implements View.OnClickListener
{
  public erm(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c())
    {
      this.a.b(0);
      MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131362352));
      return;
    }
    this.a.b(1);
    MediaControllerX.a(this.a, true);
    MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131362353));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erm
 * JD-Core Version:    0.7.0.1
 */