import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class acnf
  extends Handler
{
  acnf(acne paramacne, Looper paramLooper, QQAppInterface paramQQAppInterface)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message Progress. clientKey= " + paramMessage.arg1 + " progress=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.this$0.aJ(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1000: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message Finished. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.this$0.aJ(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message failed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.this$0.aJ(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1005: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message task removed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.this$0.aJ(paramMessage.what, i, paramMessage.arg2);
      this.this$0.cl.remove(i);
      return;
    case 1004: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message no task. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      this.this$0.aJ(paramMessage.what, paramMessage.arg1, paramMessage.arg2);
      this.this$0.cl.clear();
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    int i = ((Integer)paramMessage[0]).intValue();
    acne.c localc = (acne.c)paramMessage[1];
    int j = ((Integer)paramMessage[2]).intValue();
    int k = ((Integer)paramMessage[3]).intValue();
    this.this$0.J(localc.uniseq, j, k);
    this.this$0.a(this.val$app, i, localc.peerUin, localc.uniseq, j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnf
 * JD-Core Version:    0.7.0.1
 */