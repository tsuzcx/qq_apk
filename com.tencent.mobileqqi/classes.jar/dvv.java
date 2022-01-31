import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.ViewHolder;

public class dvv
  implements View.OnClickListener
{
  public dvv(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
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
        this.a.f("Clk_account");
        return;
      }
      if (paramView.a == 1)
      {
        this.a.b(this.a.c, this.a.e);
        this.a.f("Clk_name");
        return;
      }
    } while (paramView.a != 3);
    this.a.a(this.a.c, this.a.e);
    this.a.f("Clk_set");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvv
 * JD-Core Version:    0.7.0.1
 */