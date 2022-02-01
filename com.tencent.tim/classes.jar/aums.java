import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aums
  implements View.OnFocusChangeListener
{
  public aums(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      if (this.this$0.az == null) {}
    }
    else
    {
      return;
    }
    this.this$0.az = new aumz(this.this$0, GroupTeamWorkListActivity.a(this.this$0), this.this$0.app, this.this$0.aoW);
    this.this$0.az.setTitle("提示：");
    this.this$0.az.setCanceledOnTouchOutside(true);
    this.this$0.az.show();
    this.this$0.az.setOnDismissListener(new aumt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aums
 * JD-Core Version:    0.7.0.1
 */