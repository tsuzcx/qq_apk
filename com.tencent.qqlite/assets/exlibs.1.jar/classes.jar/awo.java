import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;

public class awo
  implements View.OnClickListener
{
  public awo(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyActivity.a(this.a) != null) && (NearbyActivity.a(this.a).isShowing())) {
      NearbyActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awo
 * JD-Core Version:    0.7.0.1
 */