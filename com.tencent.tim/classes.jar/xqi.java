import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class xqi
  implements xqh.a
{
  xqi(xqh paramxqh) {}
  
  public void fx(View paramView)
  {
    paramView = (xqh.b)wja.a(paramView);
    xqh.aVU = paramView.mMessage.senderuin;
    Object localObject = ((FragmentActivity)this.a.mContext).getChatFragment();
    TroopManager.a locala = ((TroopManager)this.a.app.getManager(52)).a();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      ((wwz)((TroopChatPie)localObject).a(41)).CW(1);
      locala.a(this.a.app, this.a.mContext, ((TroopChatPie)localObject).a, this.a.sessionInfo.aTl, 0, paramView.mMessage);
    }
    new anov(this.a.app).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome").a(new String[] { paramView.mMessage.frienduin, "", "" + apuh.o(this.a.app, paramView.mMessage.frienduin) }).report();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    xqh.bWm = 1;
  }
  
  public void fy(View paramView)
  {
    paramView = (xqh.b)wja.a(paramView);
    xqh.aVU = paramView.mMessage.senderuin;
    TroopManager.a locala = ((TroopManager)this.a.app.getManager(52)).a();
    Object localObject = ((FragmentActivity)this.a.mContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      locala.a(this.a.app, this.a.mContext, ((TroopChatPie)localObject).a, this.a.sessionInfo.aTl, 1, paramView.mMessage);
    }
    new anov(this.a.app).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.mMessage.frienduin }).report();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    xqh.bWm = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqi
 * JD-Core Version:    0.7.0.1
 */