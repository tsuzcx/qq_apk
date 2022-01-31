import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import java.util.LinkedList;

public class axc
  implements View.OnClickListener
{
  public axc(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    if ((paramView != null) && (paramView.getIntExtra("param_mode", 0) == 1))
    {
      NearbyPeopleProfileActivity.a(this.a, 2131364471);
      return;
    }
    NearbyPeopleProfileActivity.c(this.a);
    if (NearbyPeopleProfileActivity.a(this.a) == 0) {
      NearbyPeopleProfileActivity.a(this.a, 2131364471);
    }
    for (;;)
    {
      NearbyPeopleProfileActivity.a(this.a).setOnClickListener(NearbyPeopleProfileActivity.a(this.a));
      return;
      if ((NearbyPeopleProfileActivity.a(this.a).size() > 0) || (NearbyPeopleProfileActivity.a(this.a)) || (NearbyPeopleProfileActivity.b(this.a))) {
        NearbyPeopleProfileActivity.a(this.a, 2131364472);
      } else {
        NearbyPeopleProfileActivity.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axc
 * JD-Core Version:    0.7.0.1
 */