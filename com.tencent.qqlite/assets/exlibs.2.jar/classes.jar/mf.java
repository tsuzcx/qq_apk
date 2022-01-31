import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.EqqDetail;

public class mf
  implements View.OnClickListener
{
  public mf(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ChatHistory.class);
    paramView.putExtra("uin", this.a.b);
    int i = 0;
    if (this.a.a.followType != 1) {
      i = 1024;
    }
    paramView.putExtra("uintype", i);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     mf
 * JD-Core Version:    0.7.0.1
 */