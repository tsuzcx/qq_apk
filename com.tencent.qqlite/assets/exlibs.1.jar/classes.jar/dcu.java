import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity;

public class dcu
  implements View.OnClickListener
{
  public dcu(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void onClick(View paramView)
  {
    if (MsgBoxListActivity.a(this.a) == 1001) {
      NearbyActivity.a(this.a, 0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dcu
 * JD-Core Version:    0.7.0.1
 */