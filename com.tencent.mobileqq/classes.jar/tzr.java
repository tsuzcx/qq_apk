import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.10.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class tzr
  implements BusinessObserver
{
  tzr(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountUtil.10.1(this, paramBoolean, paramBundle), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzr
 * JD-Core Version:    0.7.0.1
 */