import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufi
  implements View.OnClickListener
{
  public ufi(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    anot.a(this.this$0.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    Object localObject1 = this.this$0;
    int i;
    if (AddRequestActivity.a(this.this$0) == 3999)
    {
      i = 3041;
      AddRequestActivity.a((AddRequestActivity)localObject1, i);
      Object localObject2 = (acff)this.this$0.app.getManager(51);
      boolean bool = ((acff)localObject2).isFriend(this.this$0.aKN);
      localObject1 = wja.a(new Intent(this.this$0, SplashActivity.class), null);
      ((Intent)localObject1).putExtra("uin", this.this$0.aKN);
      ((Intent)localObject1).putExtra("add_friend_source_id", AddRequestActivity.a(this.this$0));
      if (!bool) {
        break label236;
      }
      localObject2 = ((acff)localObject2).e(this.this$0.aKN);
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("cSpecialFlag", ((Friends)localObject2).cSpecialFlag);
        ((Intent)localObject1).putExtra("uinname", aqgv.c((Friends)localObject2));
      }
      label192:
      if (!bool) {
        break label269;
      }
      i = j;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("uintype", i);
      this.this$0.startActivity((Intent)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = AddRequestActivity.a(this.this$0);
      break;
      label236:
      ((Intent)localObject1).putExtra("uinname", this.this$0.strNickName);
      ((Intent)localObject1).putExtra("param_wzry_data", AddRequestActivity.a(this.this$0));
      break label192;
      label269:
      if ((AddRequestActivity.a(this.this$0) == 2007) || (AddRequestActivity.a(this.this$0) == 3007) || (AddRequestActivity.a(this.this$0) == 4007)) {
        i = 1001;
      } else if ((AddRequestActivity.a(this.this$0) == 2019) || (AddRequestActivity.a(this.this$0) == 3019)) {
        i = 1010;
      } else {
        i = 1022;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufi
 * JD-Core Version:    0.7.0.1
 */