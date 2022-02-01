import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.15.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class uvv
  extends aqrd
{
  public uvv(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      this.this$0.xc(true);
      paramString = (acms)this.this$0.app.getBusinessHandler(20);
      try
      {
        paramString.ac(Long.parseLong(this.this$0.mTroopUin), Long.parseLong(this.this$0.uin));
        return;
      }
      catch (Exception paramString)
      {
        this.this$0.xa(false);
        return;
      }
    }
    this.this$0.xa(false);
    String str;
    if (paramInt == 1282)
    {
      VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
      paramString = acfp.m(2131705410);
      str = acfp.m(2131705404);
      try
      {
        aqha.a(this.this$0, 230, paramString, str, acfp.m(2131705397), acfp.m(2131705401), new uvw(this), new uvx(this)).show();
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("EditInfoActivity", 1, "onSetColorNick", paramString);
        return;
      }
    }
    if (1283 == paramInt)
    {
      QQToast.a(this.this$0, 1, acfp.m(2131705400), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.this$0;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.this$0.getString(2131694905);
      }
      QQToast.a(localEditInfoActivity, 1, str, 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0, 1, 2131695970, 0).show(this.this$0.getTitleBarHeight());
    this.this$0.mHandler.postDelayed(new EditInfoActivity.15.3(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvv
 * JD-Core Version:    0.7.0.1
 */