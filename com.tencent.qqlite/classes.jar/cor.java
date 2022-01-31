import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.MenuPopupDialog;

public class cor
  implements View.OnClickListener
{
  public cor(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)BuddyListAdapter.a(this.a));
    ReportController.b(BuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    if (BuddyListAdapter.a(this.a) != null)
    {
      BuddyListAdapter.a(this.a).dismiss();
      BuddyListAdapter.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cor
 * JD-Core Version:    0.7.0.1
 */