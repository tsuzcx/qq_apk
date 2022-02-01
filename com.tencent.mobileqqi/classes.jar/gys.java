import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class gys
  implements View.OnClickListener
{
  public gys(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c())
    {
      this.a.b(0);
      MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131558472));
      return;
    }
    this.a.b(1);
    MediaControllerX.a(this.a, true);
    MediaControllerX.a(this.a).setContentDescription(this.a.getResources().getString(2131558473));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gys
 * JD-Core Version:    0.7.0.1
 */