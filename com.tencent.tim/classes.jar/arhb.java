import android.view.View;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;

public class arhb
  implements ausj.a
{
  public arhb(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((ProfileCardExtendFriendView.c(this.this$0)) && (!ProfileCardExtendFriendView.d(this.this$0))) {
      if (paramInt == 0)
      {
        this.this$0.cC(false, true);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
      }
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "4");
      ProfileCardExtendFriendView.a(this.this$0).cancel();
      return;
      if ((!ProfileCardExtendFriendView.c(this.this$0)) && (ProfileCardExtendFriendView.d(this.this$0)))
      {
        if (paramInt == 0)
        {
          this.this$0.cC(true, false);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
        }
      }
      else if ((ProfileCardExtendFriendView.d(this.this$0)) && (ProfileCardExtendFriendView.c(this.this$0)))
      {
        if (paramInt == 0)
        {
          this.this$0.cC(false, true);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
        }
        else if (paramInt == 1)
        {
          this.this$0.cC(true, false);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
        }
      }
      else if ((!ProfileCardExtendFriendView.c(this.this$0)) && (!ProfileCardExtendFriendView.d(this.this$0)) && (paramInt == 0))
      {
        this.this$0.cC(false, false);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhb
 * JD-Core Version:    0.7.0.1
 */