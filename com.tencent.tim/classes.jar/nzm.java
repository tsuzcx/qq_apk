import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;

public class nzm
  implements View.OnFocusChangeListener
{
  public nzm(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SubscriptFeedsActivity.a(this.this$0);
      long l = System.currentTimeMillis();
      if (l - SubscriptFeedsActivity.a(this.this$0) > 1500L)
      {
        SubscriptFeedsActivity.a(this.this$0, l);
        UniteSearchActivity.p(this.this$0, null, 12);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "Search Subscript Account...");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzm
 * JD-Core Version:    0.7.0.1
 */