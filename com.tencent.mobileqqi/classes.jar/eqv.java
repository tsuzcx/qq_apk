import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.statistics.ReportController;

public class eqv
  implements ConversationSearchAdapter.SearchResultCallBack
{
  public eqv(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    if (1 == paramInt)
    {
      if (SelectMemberActivity.a(this.a).getCount() != 0) {
        break label71;
      }
      SelectMemberActivity.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      if (ContactsSearchableCircleBuddy.a) {
        ReportController.b(this.a.b, "CliOper", "", "", "Network_circle", "Search_circle_exp", 82, 0, "", "", "", "");
      }
      ContactsSearchableCircleBuddy.a = false;
      return;
      label71:
      SelectMemberActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqv
 * JD-Core Version:    0.7.0.1
 */