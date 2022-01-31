import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class zyr
  implements View.OnClickListener
{
  public zyr(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    awqx.b(this.a.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    paramView = this.a;
    int i;
    if (AddRequestActivity.a(this.a) == 3999)
    {
      i = 3041;
      AddRequestActivity.a(paramView, i);
      Object localObject = (ajjj)this.a.app.getManager(51);
      boolean bool = ((ajjj)localObject).b(this.a.a);
      paramView = aciy.a(new Intent(this.a, SplashActivity.class), null);
      paramView.putExtra("uin", this.a.a);
      paramView.putExtra("add_friend_source_id", AddRequestActivity.a(this.a));
      if (!bool) {
        break label220;
      }
      localObject = ((ajjj)localObject).e(this.a.a);
      if (localObject != null)
      {
        paramView.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        paramView.putExtra("uinname", babh.a((Friends)localObject));
      }
      label185:
      if (!bool) {
        break label251;
      }
      i = j;
    }
    for (;;)
    {
      paramView.putExtra("uintype", i);
      this.a.startActivity(paramView);
      return;
      i = AddRequestActivity.a(this.a);
      break;
      label220:
      paramView.putExtra("uinname", this.a.b);
      paramView.putExtra("param_wzry_data", AddRequestActivity.a(this.a));
      break label185;
      label251:
      if ((AddRequestActivity.a(this.a) == 2007) || (AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 4007)) {
        i = 1001;
      } else if ((AddRequestActivity.a(this.a) == 2019) || (AddRequestActivity.a(this.a) == 3019)) {
        i = 1010;
      } else {
        i = 1022;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zyr
 * JD-Core Version:    0.7.0.1
 */