import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class iuf
  implements alkd.a
{
  public iuf(QQServiceForAV paramQQServiceForAV) {}
  
  public void in(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onGetQCallNickName");
    }
    new iuq(((QQAppInterface)this.a.getAppRuntime()).getApp().getApplicationContext()).a(new iug(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iuf
 * JD-Core Version:    0.7.0.1
 */