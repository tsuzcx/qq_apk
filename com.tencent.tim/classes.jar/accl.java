import com.tencent.mobileqq.app.CardHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.util.ArrayList;

public class accl
  implements IUploadTaskCallback
{
  public accl(CardHandler paramCardHandler) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qzonephotowall", 2, "onUploadError " + paramString + " path:" + paramAbstractUploadTask.uploadFilePath);
    }
    this.this$0.notifyUI(71, false, new Object[] { paramAbstractUploadTask.uploadFilePath });
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2)
    {
      this.this$0.bnV = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "onUploadProgress is 100%");
      }
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt) {}
  
  public void onUploadSucceed(AbstractUploadTask arg1, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "onUploadSucceed ");
    }
    synchronized (CardHandler.a(this.this$0))
    {
      if (CardHandler.a(this.this$0).size() != 0)
      {
        CardHandler.a(this.this$0);
        return;
      }
      this.this$0.notifyUI(71, true, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accl
 * JD-Core Version:    0.7.0.1
 */