import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;

public class ubq
  implements View.OnFocusChangeListener
{
  public ubq(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SubscriptFeedsActivity.a(this.a);
      long l = System.currentTimeMillis();
      if (l - SubscriptFeedsActivity.a(this.a) > 1500L)
      {
        SubscriptFeedsActivity.a(this.a, l);
        UniteSearchActivity.a(this.a, null, 12);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "Search Subscript Account...");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubq
 * JD-Core Version:    0.7.0.1
 */