import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahls
  extends acnd
{
  ahls(ahlr paramahlr) {}
  
  public void a(boolean paramBoolean, apzf paramapzf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.this$0.hideProgressDialog();
    if (ahlr.a(this.this$0) != -1)
    {
      if ((!paramBoolean) || (paramapzf.errCode != 0)) {
        break label189;
      }
      if (paramapzf.isVerify)
      {
        ahlr.a(this.this$0, paramapzf.shareUrl);
        if (ahlr.a(this.this$0) == 0) {}
      }
      else
      {
        do
        {
          return;
          ahlr.b(this.this$0, paramapzf.shareUrl);
        } while (ahlr.a(this.this$0) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ahlr.a(this.this$0) + " mTroopNotNeedVefifyLink=" + ahlr.b(this.this$0));
      }
      if ((paramapzf.troopUin != null) && (paramapzf.troopUin.equals(ahlr.c(this.this$0)))) {
        ahlr.a(this.this$0);
      }
    }
    for (;;)
    {
      ahlr.a(this.this$0, -1);
      return;
      label189:
      if (((paramapzf.isVerify) && (ahlr.a(this.this$0) != 0)) || ((!paramapzf.isVerify) && (ahlr.a(this.this$0) != 1))) {
        break;
      }
      QQToast.a(this.this$0.mActivity, 1, this.this$0.mActivity.getString(2131694334), 0).show(((BaseActivity)this.this$0.mActivity).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahls
 * JD-Core Version:    0.7.0.1
 */