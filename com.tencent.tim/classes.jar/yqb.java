import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yqb
  implements View.OnClickListener
{
  public yqb(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.a.getActivity(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.b.a.getActivity().startActivity(localIntent);
    this.b.a.getActivity().overridePendingTransition(0, 0);
    amxk.d("add_page", "search", "active_frame", 2, 0, new String[] { "" });
    anot.a(this.b.app, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqb
 * JD-Core Version:    0.7.0.1
 */