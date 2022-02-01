import android.os.Message;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class mqr
  extends aook
{
  mqr(mqq parammqq) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 54)) {}
    while ((mqq.a(this.a) == null) || (localaoko.uniseq != mqq.a(this.a))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1001: 
      paramMessage = new JSONObject();
      try
      {
        paramMessage.put("uniseq", mqq.a(this.a));
        paramMessage.put("localPath", mqq.a(this.a));
        mqq.a(this.a).onStart(paramMessage.toString());
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "uploadListener.onStart, e=" + QLog.getStackTraceString(localException));
        }
      }
    case 1002: 
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.RIJUgcVideoUploader", 2, "mVideoTransProcessorHandler transfer=" + localException.transferedSize + ", total=" + localException.fileSize);
      }
      mqq.a(this.a).N((float)localException.transferedSize * 100.0F / (float)localException.fileSize);
      return;
    case 1003: 
      QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send finished!");
      paramMessage = new bigFileUpload.BigFileExtRsp();
      for (;;)
      {
        try
        {
          paramMessage.mergeFrom(localException.fL);
          int i = paramMessage.int32_retcode.get();
          QLog.d("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.errorCode:" + i);
          if (i != 0) {
            continue;
          }
          if (!paramMessage.bytes_download_url.has()) {
            continue;
          }
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          mqq.a(this.a).onSuccess(paramMessage);
        }
        catch (Exception paramMessage)
        {
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "upload success but parse exception, e=" + QLog.getStackTraceString(paramMessage));
          continue;
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
          mqq.a(this.a).onFailed(localException.errorCode, paramMessage.bytes_msg.get().toStringUtf8());
          continue;
        }
        mqq.a(this.a);
        return;
        mqq.a(this.a).onFailed(-1, "not has download url");
      }
    }
    QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send error:" + localException.errorCode);
    mqq.a(this.a).onFailed(localException.errorCode, "");
    mqq.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqr
 * JD-Core Version:    0.7.0.1
 */