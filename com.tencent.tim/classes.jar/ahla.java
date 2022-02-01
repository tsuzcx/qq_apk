import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class ahla
  extends jqk
{
  ahla(ahkr paramahkr) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.this$0.mActivity.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      return;
      this.this$0.hideProgressDialog();
      if (this.this$0.bJ != null) {
        this.this$0.bJ.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.this$0.aMl))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->onGetOpenId--openid doesn't equal current openid");
          }
          this.this$0.bFG();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver fail");
      }
    } while (!ahkr.a(this.this$0));
    this.this$0.bf.putString("uin", String.valueOf("-1010"));
    this.this$0.bf.putInt("uintype", -1);
    this.this$0.bf.putInt("key_forward_ability_type", ahgg.a.V.intValue());
    this.this$0.dnB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahla
 * JD-Core Version:    0.7.0.1
 */