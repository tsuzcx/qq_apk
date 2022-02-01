import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class zkh
  extends jqk
{
  zkh(zju paramzju) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString() + " mOpenId = " + this.this$0.mOpenId);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      do
      {
        return;
        if (this.this$0.jdField_a_of_type_Arhz != null) {
          this.this$0.jdField_a_of_type_Arhz.hide();
        }
        if (this.this$0.bJ != null) {
          this.this$0.bJ.removeCallbacksAndMessages(null);
        }
        if ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "openIdObserver success");
        }
      } while ((TextUtils.isEmpty(this.this$0.mOpenId)) || (paramOpenID.openID.equals(this.this$0.mOpenId)));
      this.this$0.bFG();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MainAssistObserver", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkh
 * JD-Core Version:    0.7.0.1
 */