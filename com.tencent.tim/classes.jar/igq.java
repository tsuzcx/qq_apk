import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class igq
{
  private accz a;
  private QQAppInterface mApp;
  
  public igq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void hA(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.avReceivePushMsg");
    localIntent.putExtra("real_name_result", paramBoolean);
    localIntent.setPackage(this.mApp.getApplication().getPackageName());
    this.mApp.getApp().sendBroadcast(localIntent);
  }
  
  private boolean sj()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus");
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus remove observer");
      }
      this.mApp.removeObserver(this.a);
    }
    return ((accy)this.mApp.getBusinessHandler(4)).ZO();
  }
  
  public void alo()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "startMonitorRealNameResult");
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "monitorRealNameResult remove observer");
      }
      this.mApp.removeObserver(this.a);
      this.a = null;
    }
    this.a = new igr(this);
    this.mApp.addObserver(this.a);
  }
  
  public boolean cf(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      bool = sj();
    }
    alo();
    return bool;
  }
  
  public void doDestroy()
  {
    if (this.a != null)
    {
      this.mApp.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igq
 * JD-Core Version:    0.7.0.1
 */