import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugu
  implements View.OnClickListener
{
  public ugu(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getParent() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView = (View)paramView.getParent().getParent();
      if ((localView != null) && (localView.getTag() != null))
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8007147", "0X8007147", 0, 0, "", "", "", "");
        if ((localView.getTag() instanceof SimpleAccount)) {
          this.this$0.b((SimpleAccount)localView.getTag());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugu
 * JD-Core Version:    0.7.0.1
 */