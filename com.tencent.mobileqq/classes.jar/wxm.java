import android.os.Message;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class wxm
  extends bayj
{
  public wxm(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass = (bass)paramMessage.obj;
    if ((localbass == null) || (localbass.b != 24) || (localbass.c != CommonPicUploadFragment.a(this.a, CommonPicUploadFragment.a(this.a)))) {}
    do
    {
      do
      {
        return;
      } while (localbass.f.equals(CommonPicUploadFragment.b(this.a)));
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
      paramMessage.mergeFrom(localbass.a, 0, localbass.a.length);
      CommonPicUploadFragment.a(this.a, true);
      CommonPicUploadFragment.b(this.a, localbass.f);
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
      QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send error:" + localbass.g);
    }
    CommonPicUploadFragment.a(this.a).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxm
 * JD-Core Version:    0.7.0.1
 */