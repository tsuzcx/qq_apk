import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.ViewHolder;

public class bnx
  implements View.OnClickListener
{
  public bnx(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopMemberCardActivity.ViewHolder))) {}
    do
    {
      return;
      paramView = (TroopMemberCardActivity.ViewHolder)paramView;
      if (paramView.a == 0)
      {
        this.a.c(this.a.e);
        this.a.e("Clk_account");
        return;
      }
      if (paramView.a == 1)
      {
        this.a.b(this.a.c, this.a.e);
        this.a.e("Clk_name");
        return;
      }
      if (paramView.a == 3)
      {
        this.a.a(this.a.c, this.a.e);
        this.a.e("Clk_set");
        return;
      }
    } while (paramView.a != 2);
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnx
 * JD-Core Version:    0.7.0.1
 */