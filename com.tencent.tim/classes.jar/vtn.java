import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class vtn
  extends aook
{
  vtn(vtm paramvtm) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (aoko)paramMessage.obj;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i);
        }
        i = this.this$0.mApp.a().b(paramMessage.mUin, paramMessage.fileUrl, paramMessage.uniseq);
      } while (this.this$0.bao);
      if (this.this$0.mPause)
      {
        if (paramMessage.status == 1005)
        {
          this.this$0.ban = true;
          return;
        }
        if (paramMessage.status == 1003)
        {
          this.this$0.bVo();
          return;
        }
        vtm.a(this.this$0, this.this$0.mType, this.this$0.mUin, paramMessage.uniseq);
        return;
      }
      if (paramMessage.status == 1003)
      {
        if (this.this$0.mDialog != null) {
          this.this$0.mDialog.setMessage(String.format(this.this$0.aPU, new Object[] { Integer.valueOf(this.this$0.mCurrentIndex + 1), Integer.valueOf(this.this$0.mTotalSize), Integer.valueOf(100) }));
        }
        this.this$0.bVo();
        return;
      }
      if (paramMessage.status == 1005)
      {
        this.this$0.bVo();
        return;
      }
    } while (this.this$0.mDialog == null);
    this.this$0.mDialog.setMessage(String.format(this.this$0.aPU, new Object[] { Integer.valueOf(this.this$0.mCurrentIndex + 1), Integer.valueOf(this.this$0.mTotalSize), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtn
 * JD-Core Version:    0.7.0.1
 */