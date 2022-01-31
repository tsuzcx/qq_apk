import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;

public class axh
  implements View.OnClickListener
{
  public axh(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.a(this.a).dismiss();
      NearbyPeopleProfileActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axh
 * JD-Core Version:    0.7.0.1
 */