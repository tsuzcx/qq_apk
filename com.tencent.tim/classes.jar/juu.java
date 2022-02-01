import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class juu
  extends adai.a
{
  juu(jut paramjut) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "New 0xc76 onGetRecvMsgState isSuccess = " + paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 7;
  }
  
  public void onSuccess(Object paramObject)
  {
    juk.b(this.a.b, this.a.b.state);
    if (this.a.b.sp != null) {
      this.a.b.sp.edit().putInt("setting_status_" + this.a.b.a.uin + "_" + this.a.b.app.getCurrentAccountUin(), this.a.b.state).apply();
    }
  }
  
  public void p(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juu
 * JD-Core Version:    0.7.0.1
 */