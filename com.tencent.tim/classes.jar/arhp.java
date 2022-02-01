import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhp
  implements View.OnClickListener
{
  public arhp(ProfileNameView paramProfileNameView, alcn paramalcn) {}
  
  public void onClick(View paramView)
  {
    String str = aptl.a().bQ(this.b.troopUin, this.b.e.uin);
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.getContext().startActivity(localIntent);
    anot.a(null, "dc00898", "", "", "0X800A708", "0X800A708", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhp
 * JD-Core Version:    0.7.0.1
 */