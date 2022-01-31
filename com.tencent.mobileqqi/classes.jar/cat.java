import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

public class cat
  implements View.OnClickListener
{
  public cat(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    ReportController.b(this.a.b, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    Object localObject = (FriendManager)this.a.b.getManager(8);
    boolean bool = ((FriendManager)localObject).b(AddRequestActivity.a(this.a));
    paramView = new Intent(this.a, ChatActivity.class);
    paramView.putExtra("uin", AddRequestActivity.a(this.a));
    if (bool)
    {
      localObject = ((FriendManager)localObject).c(AddRequestActivity.a(this.a));
      if (localObject != null)
      {
        paramView.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        paramView.putExtra("uinname", ContactUtils.a((Friends)localObject));
      }
      if (!bool) {
        break label179;
      }
    }
    for (;;)
    {
      paramView.putExtra("uintype", i);
      this.a.startActivity(paramView);
      return;
      paramView.putExtra("uinname", this.a.q);
      break;
      label179:
      i = 1022;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cat
 * JD-Core Version:    0.7.0.1
 */