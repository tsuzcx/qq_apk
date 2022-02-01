import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class eot
  implements View.OnClickListener
{
  public eot(RecentAdapter paramRecentAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject;
    RecentBaseData localRecentBaseData;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          if ((RecentAdapter.a(this.a) != null) && (RecentAdapter.a(this.a).isShowing())) {
            RecentAdapter.a(this.a).dismiss();
          }
          i = paramView.getId();
        } while ((i < 0) || (i >= this.a.getCount()));
        localObject = this.a.getItem(i);
      } while ((localObject == null) || (!(localObject instanceof RecentBaseData)));
      localRecentBaseData = (RecentBaseData)localObject;
      localObject = null;
      if ((paramView instanceof TextView)) {
        localObject = (String)((TextView)paramView).getText();
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.a.a(localRecentBaseData, (String)localObject, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eot
 * JD-Core Version:    0.7.0.1
 */