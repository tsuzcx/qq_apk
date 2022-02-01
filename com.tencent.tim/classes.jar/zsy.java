import android.os.Message;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class zsy
  extends aook
{
  public zsy(SendWebPicActivity paramSendWebPicActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 51)) {}
    do
    {
      do
      {
        return;
      } while (localaoko.fileMd5.equals(SendWebPicActivity.a(this.this$0)));
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler send finished!" + SendWebPicActivity.a(this.this$0));
        }
        break;
      }
    } while (SendWebPicActivity.a(this.this$0));
    paramMessage = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramMessage.mergeFrom(localaoko.fL, 0, localaoko.fL.length);
      SendWebPicActivity.a(this.this$0, true);
      SendWebPicActivity.a(this.this$0, localaoko.fileMd5);
      SendWebPicActivity.b(this.this$0, paramMessage.bytes_file_resid.get().toStringUtf8());
      SendWebPicActivity.c(this.this$0, paramMessage.bytes_download_url.get().toStringUtf8());
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler mUuid=" + SendWebPicActivity.b(this.this$0) + ", mImageMd5=" + SendWebPicActivity.a(this.this$0) + ", mImageUrl=" + SendWebPicActivity.c(this.this$0));
      }
      SendWebPicActivity.a(this.this$0).sendEmptyMessage(1001);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler send error:" + localaoko.errorCode);
    }
    SendWebPicActivity.a(this.this$0).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsy
 * JD-Core Version:    0.7.0.1
 */