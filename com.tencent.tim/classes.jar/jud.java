import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class jud
  implements BusinessObserver
{
  jud(QQAppInterface paramQQAppInterface, boolean paramBoolean, acje paramacje) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList isSuccess:" + String.valueOf(paramBoolean));
    }
    paramBundle = paramBundle.getByteArray("data");
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramInt = juc.a(this.val$app, this.abM, paramBundle, false);; paramInt = 1)
    {
      if (this.a != null) {
        this.a.I(paramBoolean, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList onReceiveerrCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jud
 * JD-Core Version:    0.7.0.1
 */