import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel.a;
import com.tencent.mobileqq.widget.QQToast;

public class ajsu
  implements RecentUserInvitePanel.a
{
  public ajsu(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView, ajtw.b paramb)
  {
    if (paramb.cqf) {
      QQToast.a(this.this$0, 1, acfp.m(2131706807), 1).show();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.this$0, paramb.uin, paramb.uinType);
      paramb.cqf = true;
      this.this$0.a.K(paramView, paramb.cqf);
      if (paramb.uinType == 1)
      {
        anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramb.uinType != 0);
    anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
  
  public void hj(View paramView)
  {
    this.this$0.bhq();
    anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsu
 * JD-Core Version:    0.7.0.1
 */