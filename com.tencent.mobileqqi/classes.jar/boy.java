import android.view.View;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class boy
  implements ActionSheet.OnButtonClickListener
{
  public boy(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (EnterpriseDetailActivity.a(this.a)) {
      return;
    }
    EnterpriseDetailActivity.a(this.a, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      EnterpriseDetailActivity.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     boy
 * JD-Core Version:    0.7.0.1
 */