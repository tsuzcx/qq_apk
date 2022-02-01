import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class akyb
  implements akye
{
  akyb(akya paramakya, akxq paramakxq, akxy paramakxy) {}
  
  public void Nc(int paramInt) {}
  
  public void a(int paramInt, akxr paramakxr) {}
  
  public void aO(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, akxr paramakxr) {}
  
  public void c(int paramInt, akxr arg2)
  {
    akyf.a locala = (akyf.a)???.en;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_b_of_type_Akxq.b.localPath).append(",uuid:").append(this.jdField_b_of_type_Akxq.localUUID).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      akxe.a("PresendPicMgrService", "onSend ", ???);
      akxe.a("PresendPicMgrService", "onSend", " SendResult = " + locala);
    }
    for (;;)
    {
      synchronized (akya.a(this.jdField_b_of_type_Akya))
      {
        if (!this.c.cvc)
        {
          if (paramInt == 0)
          {
            this.jdField_b_of_type_Akxq.b.picExtraFlag = 1;
            akxe.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_b_of_type_Akxq);
            akya.a(this.jdField_b_of_type_Akya).add(this.jdField_b_of_type_Akxq);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_b_of_type_Akxq.b.picExtraFlag = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(akya.a(this.jdField_b_of_type_Akya));
          localObject2 = (MessageRecord)this.jdField_b_of_type_Akxq.b.picExtraObject;
          ((ambj)localQQAppInterface.getManager(326)).d((MessageRecord)localObject2, null);
          akxe.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_b_of_type_Akxq);
        }
        catch (AccountNotMatchException localAccountNotMatchException) {}
        if (QLog.isColorLevel()) {
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "onSend SendResult = " + localAccountNotMatchException + ", upload failed");
      }
    }
  }
  
  public void d(int paramInt, akxr paramakxr) {}
  
  public void o(int paramInt, ArrayList<akxr> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyb
 * JD-Core Version:    0.7.0.1
 */