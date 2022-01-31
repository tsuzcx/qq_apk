import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class dxe
  implements View.OnClickListener
{
  public dxe(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = TroopMemberListActivity.a(this.a, paramView);
    TroopMemberListActivity.b(this.a, paramView);
    if (this.a.c == null)
    {
      this.a.c = paramView;
      TroopMemberListActivity.a(this.a, Long.parseLong((String)paramView.getTag()));
      this.a.a(paramView, 2130968586, 2);
      if (localView != null) {
        ((ShaderAnimLayout)localView).a();
      }
      return;
    }
    if (this.a.c == paramView)
    {
      TroopMemberListActivity.a(this.a, 0L);
      this.a.a(this.a.c, 2130968585, 3);
      if (localView != null) {
        ((ShaderAnimLayout)localView).d();
      }
      this.a.c = null;
      return;
    }
    TroopMemberListActivity.a(this.a, Long.parseLong((String)paramView.getTag()));
    this.a.a(this.a.c, 2130968585, 3);
    this.a.a(paramView, 2130968586, 2);
    if (localView != null) {
      ((ShaderAnimLayout)localView).a();
    }
    localView = TroopMemberListActivity.a(this.a, this.a.c);
    if (localView != null) {
      ((ShaderAnimLayout)localView).d();
    }
    this.a.c = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxe
 * JD-Core Version:    0.7.0.1
 */