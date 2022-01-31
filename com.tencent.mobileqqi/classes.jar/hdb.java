import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class hdb
  implements View.OnClickListener
{
  public hdb(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.b = true;
      MediaControllerX.b(this.a).setBackgroundResource(2130838544);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131558476));
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.onClick(paramView);
      }
      return;
      this.a.b = false;
      MediaControllerX.b(this.a).setBackgroundResource(2130838534);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131558477));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hdb
 * JD-Core Version:    0.7.0.1
 */