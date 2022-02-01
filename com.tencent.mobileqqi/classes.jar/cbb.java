import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;

public class cbb
  implements View.OnClickListener
{
  public cbb(ChatForEnterpriseActivity paramChatForEnterpriseActivity) {}
  
  public void onClick(View paramView)
  {
    ChatForEnterpriseActivity.a(this.a).setVisibility(8);
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbb
 * JD-Core Version:    0.7.0.1
 */