import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ypt
  implements View.OnClickListener
{
  public ypt(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener");
    }
    anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "location_set_exp", 0, 0, "", "", "", "");
    this.a.getActivity().requestPermissions(new ypu(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypt
 * JD-Core Version:    0.7.0.1
 */