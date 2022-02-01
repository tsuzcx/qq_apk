import android.os.Message;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class rau
  extends aook
{
  public rau(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != CommonPicUploadFragment.a(this.this$0, CommonPicUploadFragment.a(this.this$0)))) {}
    do
    {
      do
      {
        return;
      } while (localaoko.fileMd5.equals(CommonPicUploadFragment.b(this.this$0)));
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send finished!" + CommonPicUploadFragment.a(this.this$0));
        }
        break;
      }
    } while (CommonPicUploadFragment.a(this.this$0));
    paramMessage = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramMessage.mergeFrom(localaoko.fL, 0, localaoko.fL.length);
      CommonPicUploadFragment.a(this.this$0, true);
      CommonPicUploadFragment.b(this.this$0, localaoko.fileMd5);
      CommonPicUploadFragment.c(this.this$0, paramMessage.bytes_file_resid.get().toStringUtf8());
      CommonPicUploadFragment.d(this.this$0, paramMessage.bytes_download_url.get().toStringUtf8());
      if (QLog.isColorLevel()) {
        QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler mUuid=" + CommonPicUploadFragment.c(this.this$0) + ", mPicMd5=" + CommonPicUploadFragment.b(this.this$0) + ", mPicUrl=" + CommonPicUploadFragment.d(this.this$0));
      }
      CommonPicUploadFragment.a(this.this$0).sendEmptyMessage(1005);
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
      QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send error:" + localaoko.errorCode);
    }
    CommonPicUploadFragment.a(this.this$0).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rau
 * JD-Core Version:    0.7.0.1
 */