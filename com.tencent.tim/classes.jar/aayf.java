import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class aayf
  implements SelectedAndSearchBar.b
{
  public aayf(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(ResultRecord paramResultRecord)
  {
    String str = paramResultRecord.uin;
    if (this.this$0.iX(str))
    {
      this.this$0.Bd(str);
      this.this$0.a(paramResultRecord, false);
      this.this$0.cAc();
      int i = this.this$0.a.uy();
      if ((i == 6) || (i == 7) || (i == 5) || (i == 4) || (i == 1) || (i == 0) || (i == 8) || (i == 9)) {
        ((SelectMemberInnerFrame)this.this$0.a.getCurrentView()).notifyDataSetChanged();
      }
      SelectMemberActivity.a(this.this$0, false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.this$0.Ai.setVisibility(8);
    }
    for (;;)
    {
      if (this.this$0.c != null) {
        this.this$0.c.Id(paramEditable);
      }
      return;
      this.this$0.Ai.setVisibility(0);
    }
  }
  
  public void xf(boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.this$0.cmw == 6) || (this.this$0.cmw == 7) || (this.this$0.cmw != this.this$0.a.uy())))
    {
      ContactSearchFragment localContactSearchFragment = ((SelectMemberInnerFrame)this.this$0.a.getCurrentView()).a();
      if (localContactSearchFragment != null)
      {
        localContactSearchFragment.Pt(this.this$0.bBc);
        localContactSearchFragment.N(this.this$0.dx(), this.this$0.so);
        FragmentTransaction localFragmentTransaction = this.this$0.getSupportFragmentManager().beginTransaction();
        if (this.this$0.c != null) {
          localFragmentTransaction.remove(this.this$0.c);
        }
        localFragmentTransaction.add(2131377207, localContactSearchFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.this$0.c = localContactSearchFragment;
      }
      if (this.this$0.bGG == 0) {
        anot.a(this.this$0.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayf
 * JD-Core Version:    0.7.0.1
 */