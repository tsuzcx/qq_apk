import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public abstract class apwr
{
  public String TAG;
  apwo a;
  protected ITransactionCallback a;
  protected Transaction b;
  protected boolean cST;
  int callbackId;
  protected String picUrl;
  
  public apwr(apwo paramapwo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback = new apws(this);
    this.callbackId = paramInt;
    this.TAG = getClass().getSimpleName();
    this.jdField_a_of_type_Apwo = paramapwo;
  }
  
  public abstract void ecw();
  
  public abstract void ecx();
  
  public abstract void ecy();
  
  public abstract void ecz();
  
  protected QQAppInterface getAppInterface()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public void onFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onFailed ");
    }
    ecz();
    ecw();
  }
  
  protected boolean rc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "uploadPic path= " + paramString);
    }
    ITransactionCallback localITransactionCallback = this.jdField_a_of_type_ComTencentMobileqqHighwayApiITransactionCallback;
    QQAppInterface localQQAppInterface = getAppInterface();
    String str = localQQAppInterface.getCurrentUin();
    byte[] arrayOfByte;
    if (localQQAppInterface != null)
    {
      arrayOfByte = adgp.t(paramString);
      if (arrayOfByte != null) {
        break label83;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "uploadPic md5 null ");
      }
    }
    label83:
    int i;
    do
    {
      return false;
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramString = new Transaction(str, 75, paramString, 0, arrayOfByte, localITransactionCallback, localCommFileExtReq.toByteArray(), false);
      i = localQQAppInterface.getHwEngine().submitTransactionTask(paramString);
      if (i == 0)
      {
        this.b = paramString;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "uploadPic submitTransactionTask  retCode= " + i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwr
 * JD-Core Version:    0.7.0.1
 */