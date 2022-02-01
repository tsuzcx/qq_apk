import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import mqq.app.Constants.LogoutReason;

public class utq
{
  public arhz C;
  public aqju G;
  private Conversation a;
  private acgf b;
  
  public utq(Conversation paramConversation)
  {
    this.a = paramConversation;
  }
  
  public void b(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    BaseActivity localBaseActivity = this.a.a();
    HotChatManager localHotChatManager = localQQAppInterface.a(false);
    HotChatInfo localHotChatInfo;
    if ((localHotChatManager != null) && (localHotChatManager.kj(paramRecentUser.uin)))
    {
      localHotChatManager.DW(paramRecentUser.uin);
      localHotChatInfo = localHotChatManager.a(paramRecentUser.uin);
      if (localHotChatInfo != null)
      {
        if (localHotChatInfo.state == 0) {
          break label114;
        }
        if (!localHotChatInfo.isWifiHotChat) {
          break label109;
        }
        i = 1;
        anot.a(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
      }
    }
    label109:
    label114:
    while ((localHotChatInfo.adminLevel != 0) || ((localHotChatInfo.ownerUin != null) && (localHotChatInfo.ownerUin.equals(localQQAppInterface.getCurrentAccountUin())))) {
      for (;;)
      {
        return;
        i = 2;
      }
    }
    if (localHotChatInfo.isWifiHotChat) {}
    for (int i = 1;; i = 2)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
      if (this.b == null) {
        this.b = new utr(this, localBaseActivity);
      }
      this.G = acfx.a(localHotChatManager.a(paramRecentUser.uin), new uts(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
      return;
    }
  }
  
  public void onDestory()
  {
    if (this.G != null)
    {
      this.G.dismiss();
      this.G = null;
    }
    if (this.C != null)
    {
      this.C.dismiss();
      this.C = null;
    }
    if (this.b != null) {
      this.a.app.removeObserver(this.b);
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    onDestory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */