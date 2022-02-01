import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ypx
  implements View.OnClickListener
{
  ypx(ypw paramypw) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "seach_clk", 0, 0, this.a.a.aZv, this.a.a.aZu, "", "");
    Intent localIntent = new Intent(this.a.a.getActivity(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.a.a.getActivity().startActivity(localIntent);
    this.a.a.getActivity().overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypx
 * JD-Core Version:    0.7.0.1
 */