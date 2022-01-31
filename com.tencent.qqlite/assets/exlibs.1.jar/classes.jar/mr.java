import android.view.View;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mr
  implements ActionSheet.OnButtonClickListener
{
  public mr(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void a(View paramView, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mr
 * JD-Core Version:    0.7.0.1
 */