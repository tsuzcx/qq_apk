import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;

public class axk
  implements View.OnClickListener
{
  public axk(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.b(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.b(this.a).dismiss();
      NearbyPeopleProfileActivity.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axk
 * JD-Core Version:    0.7.0.1
 */