import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.qidian.data.BmqqAccountType;

class xwx
  extends accn
{
  xwx(xwq paramxwq) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    xwq.a(this.a);
    this.a.cfz();
    if ((this.a.b != null) && (this.a.a.sM(this.a.sessionInfo.aTl)) && (!xwq.a(this.a)))
    {
      xwq.a(this.a, true);
      this.a.b.b(this.a.app, this.a.sessionInfo, this.a.mActivity.getChatFragment().b);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.sessionInfo != null) && (this.a.sessionInfo.aTl != null) && (paramBmqqAccountType.getUin().equals(this.a.sessionInfo.aTl)) && (paramBmqqAccountType.getAccountType() == 6)) {
      xwq.b(this.a);
    }
    if ((this.a.sessionInfo != null) && (this.a.sessionInfo.cZ == 1024) && ((TextUtils.isEmpty(this.a.sessionInfo.aTn)) || (this.a.sessionInfo.aTn.equals(this.a.sessionInfo.aTl))))
    {
      this.a.sessionInfo.aTn = jqs.getNickName(this.a.app, this.a.sessionInfo.aTl);
      this.a.mTitleText.setText(this.a.sessionInfo.aTn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwx
 * JD-Core Version:    0.7.0.1
 */