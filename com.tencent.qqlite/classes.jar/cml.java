import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;

public class cml
  implements ConversationSearchAdapter.SearchResultCallBack
{
  public cml(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    if (1 == paramInt)
    {
      if (SelectMemberActivity.a(this.a).getCount() == 0) {
        SelectMemberActivity.a(this.a).setVisibility(0);
      }
    }
    else {
      return;
    }
    SelectMemberActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cml
 * JD-Core Version:    0.7.0.1
 */