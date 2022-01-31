import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyPeopleListFrame;
import com.tencent.mobileqq.utils.NetworkUtil;

public class aww
  implements View.OnClickListener
{
  public aww(NearbyPeopleListFrame paramNearbyPeopleListFrame) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(NearbyPeopleListFrame.a(this.a)))
    {
      NearbyPeopleListFrame.a(this.a, 1, NearbyPeopleListFrame.b(this.a).getString(2131363527));
      return;
    }
    this.a.a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aww
 * JD-Core Version:    0.7.0.1
 */