import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugt
  implements View.OnClickListener
{
  public ugt(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    if ((localView == null) || (localView.getTag() == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.this$0.app, "CliOper", "", "", "0X8007146", "0X8007146", 0, 0, "", "", "", "");
      if ((localView.getTag() instanceof SubAccountInfo)) {
        this.this$0.a((SubAccountInfo)localView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugt
 * JD-Core Version:    0.7.0.1
 */