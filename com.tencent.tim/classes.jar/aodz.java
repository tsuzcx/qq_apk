import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class aodz
  extends ClickableSpan
{
  public aodz(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("uin", this.this$0.app.getCurrentAccountUin());
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    this.this$0.startActivity(paramView.putExtra("url", "https://tim.qq.com/htdocs/2.0_lead/document.html"));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.this$0.getResources().getColor(2131165652));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodz
 * JD-Core Version:    0.7.0.1
 */