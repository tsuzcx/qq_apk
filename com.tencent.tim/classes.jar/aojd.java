import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aojd
  implements ITransactionCallback
{
  aojd(aojc paramaojc) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.a.apj = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (this.a.apj - this.a.api) + "ms");
    }
    this.a.jdField_b_of_type_Aoko.fL = paramArrayOfByte;
    if (this.a.um != -1) {
      this.a.dM(paramInt, "uploadImgError");
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.a.apj = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (this.a.apj - this.a.api) + "ms ,fileSize:" + this.a.mFileSize);
    }
    if (this.a.jdField_b_of_type_Rfg.aAd.equals(this.a.jdField_b_of_type_Rfi.aAe))
    {
      this.a.jdField_b_of_type_Rfg.BV = this.a.apj;
      if (this.a.um != -1) {
        this.a.dUQ();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojd
 * JD-Core Version:    0.7.0.1
 */