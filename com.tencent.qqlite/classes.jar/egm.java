import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

public class egm
  extends MessageObserver
{
  public egm(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    if (QLog.isColorLevel()) {
      if ("Stream ptt:onUpdateUploadStreamFinished : isSuccess:" + paramBoolean + " Key:" + paramUploadStreamStruct != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = paramUploadStreamStruct.jdField_a_of_type_JavaLangString + " FilePath:" + this.a.a.e + " seq:" + paramUploadStreamStruct.jdField_a_of_type_Short + " Layer:" + paramUploadStreamStruct.jdField_a_of_type_Int + " RespCode:" + paramUploadStreamStruct.b + " isStreamPttSuccess:" + this.a.l)
    {
      QLog.e("streamptt.send", 2, str);
      this.a.c(2);
      if ((paramUploadStreamStruct != null) && (paramUploadStreamStruct.jdField_a_of_type_JavaLangString != null) && (paramUploadStreamStruct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.e))) {
        break;
      }
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.a(this.a, false, paramUploadStreamStruct);
      return;
    }
    BuddyTransfileProcessor.a(this.a, true, paramUploadStreamStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egm
 * JD-Core Version:    0.7.0.1
 */