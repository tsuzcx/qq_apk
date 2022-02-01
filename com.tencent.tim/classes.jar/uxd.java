import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class uxd
  implements SelectedAndSearchBar.b
{
  public uxd(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardFriendListActivity.a(this.this$0, paramResultRecord.uin, paramResultRecord.lk());
    }
    ForwardFriendListActivity.a(this.this$0).notifyDataSetChanged();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardFriendListActivity.a(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardFriendListActivity.a(this.this$0) != null) {
        ForwardFriendListActivity.a(this.this$0).Id(paramEditable);
      }
      return;
      ForwardFriendListActivity.a(this.this$0).setVisibility(0);
    }
  }
  
  public void xf(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardFriendListActivity.a(this.this$0) == null))
    {
      ForwardFriendListActivity.a(this.this$0, ContactSearchFragment.a(6, 1, null, null, ForwardFriendListActivity.a(this.this$0)));
      FragmentTransaction localFragmentTransaction = this.this$0.getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131377207, ForwardFriendListActivity.a(this.this$0));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxd
 * JD-Core Version:    0.7.0.1
 */