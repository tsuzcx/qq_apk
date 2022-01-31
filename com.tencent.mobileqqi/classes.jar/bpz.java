import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bpz
  implements ActionSheet.OnButtonClickListener
{
  public bpz(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AccountDetailActivity.a(this.a)) {
      return;
    }
    AccountDetailActivity.a(this.a, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      AccountDetailActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpz
 * JD-Core Version:    0.7.0.1
 */