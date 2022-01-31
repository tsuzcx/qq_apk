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

public class xu
  implements View.OnClickListener
{
  public xu(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    ReportController.b(this.a.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    Object localObject = (FriendManager)this.a.app.getManager(8);
    boolean bool = ((FriendManager)localObject).b(AddRequestActivity.a(this.a));
    paramView = new Intent(this.a, ChatActivity.class);
    paramView.putExtra("uin", AddRequestActivity.a(this.a));
    paramView.putExtra("add_friend_source_id", AddRequestActivity.a(this.a));
    if (bool)
    {
      localObject = ((FriendManager)localObject).c(AddRequestActivity.a(this.a));
      if (localObject != null)
      {
        paramView.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        paramView.putExtra("uinname", ContactUtils.a((Friends)localObject));
      }
      if (!bool) {
        break label193;
      }
    }
    for (;;)
    {
      paramView.putExtra("uintype", i);
      this.a.startActivity(paramView);
      return;
      paramView.putExtra("uinname", this.a.q);
      break;
      label193:
      i = 1022;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xu
 * JD-Core Version:    0.7.0.1
 */