import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aonj
  implements ITransactionCallback
{
  aonj(aoni paramaoni, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.val$startTime) + "ms");
    }
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Aojn$a);
    this.a.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.val$startTime));
    }
    this.a.jdField_b_of_type_Aojn$a.dVg();
    this.a.jdField_b_of_type_Aojn$a.result = 1;
    this.a.bz = this.a.mFileSize;
    this.a.jdField_b_of_type_Aoko.fL = paramArrayOfByte;
    this.a.onSuccess();
    this.a.jdField_b_of_type_Aoko.dVw();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.a.jdField_b_of_type_Aojn$a.dVf();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aoni localaoni = this.a;
    aoko localaoko = this.a.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaoni.bz = l;
    if ((paramInt < this.a.mFileSize) && (!this.a.mIsCancel) && (!this.a.mIsPause)) {
      this.a.dUZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonj
 * JD-Core Version:    0.7.0.1
 */