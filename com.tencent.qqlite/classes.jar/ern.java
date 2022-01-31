import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class ern
  implements View.OnClickListener
{
  public ern(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.b = true;
      MediaControllerX.b(this.a).setBackgroundResource(2130838481);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131362356));
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.onClick(paramView);
      }
      return;
      this.a.b = false;
      MediaControllerX.b(this.a).setBackgroundResource(2130838471);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131362357));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ern
 * JD-Core Version:    0.7.0.1
 */