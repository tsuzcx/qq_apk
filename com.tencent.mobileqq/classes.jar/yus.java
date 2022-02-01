import android.os.Message;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class yus
  extends beyf
{
  public yus(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.b != 24) || (localbete.c != CommonPicUploadFragment.a(this.a, CommonPicUploadFragment.a(this.a)))) {}
    do
    {
      do
      {
        return;
      } while (localbete.f.equals(CommonPicUploadFragment.b(this.a)));
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send finished!" + CommonPicUploadFragment.a(this.a));
        }
        break;
      }
    } while (CommonPicUploadFragment.a(this.a));
    paramMessage = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramMessage.mergeFrom(localbete.a, 0, localbete.a.length);
      CommonPicUploadFragment.a(this.a, true);
      CommonPicUploadFragment.b(this.a, localbete.f);
      CommonPicUploadFragment.c(this.a, paramMessage.bytes_file_resid.get().toStringUtf8());
      CommonPicUploadFragment.d(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
      if (QLog.isColorLevel()) {
        QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler mUuid=" + CommonPicUploadFragment.c(this.a) + ", mPicMd5=" + CommonPicUploadFragment.b(this.a) + ", mPicUrl=" + CommonPicUploadFragment.d(this.a));
      }
      CommonPicUploadFragment.a(this.a).sendEmptyMessage(1005);
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
      QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send error:" + localbete.g);
    }
    CommonPicUploadFragment.a(this.a).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */