import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajtc
  implements View.OnClickListener
{
  public ajtc(GameRoomInviteActivity.b paramb, int paramInt, ardq paramardq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((GameRoomInviteActivity.a)this.b.this$0.mUsers.get(this.val$position)).uin);
      this.c.a(this.b.this$0.OG, l, null);
      this.b.this$0.report("invite_page", "kick_out");
      label62:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtc
 * JD-Core Version:    0.7.0.1
 */