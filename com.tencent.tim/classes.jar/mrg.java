import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class mrg
  extends aook
{
  mrg(mrf parammrf) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((mrf.a(this.this$0) == null) || (mrf.a(this.this$0).mUniseq != localaoko.uniseq));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          mrf.a(this.this$0, System.currentTimeMillis());
        }
      } while (this.this$0.b == null);
      this.this$0.b.aDx();
      return;
    } while (this.this$0.b == null);
    this.this$0.b.L((float)localaoko.transferedSize * 100.0F / (float)localaoko.fileSize);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localaoko.fL);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        mrf.a(this.this$0, localaoko.fileMd5);
        if (paramMessage.bytes_download_url.has()) {
          mrf.b(this.this$0, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          mrf.c(this.this$0, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(mrf.c(this.this$0))) || (TextUtils.isEmpty(mrf.d(this.this$0)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(mrf.e(this.this$0));
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramMessage)
      {
        int i = 0;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finish with error!");
        mrf.a(this.this$0, 1004, null, null, null);
        mrf.a(this.this$0, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      mrf.a(this.this$0, 0, mrf.e(this.this$0), mrf.c(this.this$0), mrf.d(this.this$0));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localaoko.errorCode);
    }
    mrf.a(this.this$0, 1004, null, null, null);
    mrf.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrg
 * JD-Core Version:    0.7.0.1
 */