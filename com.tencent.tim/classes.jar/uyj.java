import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class uyj
  implements SelectedAndSearchBar.b
{
  public uyj(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardTroopListFragment.a(this.this$0, paramResultRecord.uin, paramResultRecord.lk());
    }
    this.this$0.b.notifyDataSetChanged();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardTroopListFragment.a(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardTroopListFragment.a(this.this$0) != null) {
        ForwardTroopListFragment.a(this.this$0).Id(paramEditable);
      }
      return;
      ForwardTroopListFragment.a(this.this$0).setVisibility(0);
    }
  }
  
  public void xf(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardTroopListFragment.a(this.this$0) == null))
    {
      ForwardTroopListFragment.a(this.this$0, ContactSearchFragment.a(8, 2097176, null, null, ForwardTroopListFragment.a(this.this$0)));
      FragmentTransaction localFragmentTransaction = this.this$0.getActivity().getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131377207, ForwardTroopListFragment.a(this.this$0));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyj
 * JD-Core Version:    0.7.0.1
 */