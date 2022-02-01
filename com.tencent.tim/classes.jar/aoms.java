import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import tencent.im.cs.smartptt.Smartptt.PttTransRsp;
import tencent.im.cs.smartptt.Smartptt.RspBody;

class aoms
  implements ITransactionCallback
{
  aoms(aomr paramaomr, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.val$startTime) + "ms retCode=" + paramInt);
    }
    if ((aomr.a(this.a) != null) && (aomr.a(this.a).filePath != null)) {
      new File(aomr.a(this.a).filePath).delete();
    }
    this.a.VR(2005);
    this.a.jdField_b_of_type_Aoko.fL = paramArrayOfByte;
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Aojn$a);
    this.a.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    boolean bool2 = true;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onSuccess SendTotalCost:" + (l - this.val$startTime) + "ms");
    }
    if ((aomr.a(this.a) != null) && (aomr.a(this.a).filePath != null)) {
      new File(aomr.a(this.a).filePath).delete();
    }
    paramHashMap = new Smartptt.RspBody();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "onSuccess  text =" + paramHashMap.msg_ptttrans_rsp.str_text.get() + " id=" + paramHashMap.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.a.h.dQN + " uint32_is_final=" + paramHashMap.msg_ptttrans_rsp.uint32_is_final.get());
      }
      this.a.jdField_b_of_type_Aoko.fileType = 327696;
      this.a.jdField_b_of_type_Aoko.clC = (aomr.a(this.a) + paramHashMap.msg_ptttrans_rsp.str_text.get());
      this.a.jdField_b_of_type_Aoko.commandId = 68;
      this.a.jdField_b_of_type_Aoko.dPs = this.a.h.dQN;
      paramArrayOfByte = this.a;
      boolean bool1 = bool2;
      if (paramHashMap.msg_ptttrans_rsp.uint32_is_final.get() != 1) {
        if (!aomr.a(this.a).cNv) {
          break label355;
        }
      }
      label355:
      for (bool1 = bool2;; bool1 = false)
      {
        aomr.a(paramArrayOfByte, bool1, true);
        this.a.jdField_b_of_type_Aojn$a.dVg();
        this.a.jdField_b_of_type_Aojn$a.result = 1;
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.a.jdField_b_of_type_Aojn$a.dVf();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onUpdateProgress transferedSize:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoms
 * JD-Core Version:    0.7.0.1
 */