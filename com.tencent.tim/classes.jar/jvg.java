import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class jvg
  implements Handler.Callback
{
  jvg(juk paramjuk) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (QLog.isColorLevel()) {
          QLog.i("AccountDetailGroupListContainer", 2, "refresh recent list, from_handle");
        }
        bool1 = bool2;
      } while (!this.b.abP);
      bool1 = bool2;
    } while (this.b.iP == null);
    this.b.sp = this.b.app.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    int i;
    if (this.b.sp != null)
    {
      i = this.b.sp.getInt("setting_result_" + this.b.a.uin + "_" + this.b.app.getCurrentAccountUin(), -10000);
      this.b.state = this.b.sp.getInt("setting_status_" + this.b.a.uin + "_" + this.b.app.getCurrentAccountUin(), -1);
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = bool2;
      if (this.b.state <= -1) {
        break;
      }
      juk.b(this.b, this.b.state);
      this.b.iP.setOnClickListener(new jvh(this));
      return true;
      i = -10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvg
 * JD-Core Version:    0.7.0.1
 */