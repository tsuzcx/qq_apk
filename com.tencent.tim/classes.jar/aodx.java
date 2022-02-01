import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class aodx
  implements View.OnFocusChangeListener
{
  public aodx(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aobw.h(this.this$0.app, "0X800993D");
      paramView.clearFocus();
      if (this.this$0.az == null) {}
    }
    else
    {
      return;
    }
    this.this$0.az = new aoeq(this.this$0, GroupTeamWorkListActivity.a(this.this$0), this.this$0.app, this.this$0.aoW);
    this.this$0.az.setTitle(acfp.m(2131707079));
    this.this$0.az.setCanceledOnTouchOutside(true);
    this.this$0.az.show();
    this.this$0.az.setOnDismissListener(new aody(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodx
 * JD-Core Version:    0.7.0.1
 */