import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class afue
  implements ausj.a
{
  public afue(ExtendFriendBaseFragment paramExtendFriendBaseFragment, afua paramafua, boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      stj.a(this.this$0.mActivity, this.a.mUin, stj.encrypt(this.a.mUin, stj.cm(2)), null, null, this.this$0.mApp.getCurrentAccountUin(), 20005, null, null);
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
      if (this.this$0.b != null) {
        this.this$0.b.Ih(this.a.mUin);
      }
      if (this.this$0.ae != null)
      {
        this.this$0.ae.dismiss();
        this.this$0.ae = null;
      }
      return;
    }
    if ((this.caR) && (!this.caS)) {
      if (paramInt == 1)
      {
        this.this$0.a(false, true, this.h);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
    }
    for (;;)
    {
      this.this$0.ae.cancel();
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
      return;
      if ((!this.caR) && (this.caS))
      {
        if (paramInt == 1)
        {
          this.this$0.a(true, false, this.h);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((this.caS) && (this.caR))
      {
        if (paramInt == 1)
        {
          this.this$0.a(false, true, this.h);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
        }
        else if (paramInt == 2)
        {
          this.this$0.a(true, false, this.h);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((!this.caR) && (!this.caS) && (paramInt == 1))
      {
        this.this$0.a(false, false, this.h);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afue
 * JD-Core Version:    0.7.0.1
 */