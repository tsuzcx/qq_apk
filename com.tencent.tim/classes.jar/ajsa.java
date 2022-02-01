import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajsa
  implements View.OnClickListener
{
  ajsa(ajrz paramajrz, int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (this.val$state == 1)
    {
      localIntent = new Intent(this.b.mContext, SplashActivity.class);
      localIntent.putExtra("uin", this.Hg + "");
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", this.Hg + "");
      localIntent.putExtra("uinname", this.val$nickname);
      localIntent.putExtra("isGameRoom", true);
      localIntent = wja.a(localIntent, new int[] { 1, 2 });
      this.b.mContext.startActivity(localIntent);
      if ((this.b.mContext instanceof ChatActivity)) {
        ((ChatActivity)this.b.mContext).finish();
      }
      anot.a(null, "dc00899", "Grp_wolf", "", "in_game", "active_ball", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent = wja.a(new Intent(this.b.mContext, GameRoomInviteActivity.class), new int[] { 2 });
      localIntent.putExtra("inviteId", this.bSo);
      localIntent.putExtra("roomNum", this.val$num);
      this.b.mContext.startActivity(localIntent);
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsa
 * JD-Core Version:    0.7.0.1
 */