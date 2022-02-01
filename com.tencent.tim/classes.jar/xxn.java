import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class xxn
  implements Handler.Callback
{
  xxn(xxh paramxxh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "[handleMessage] handle message mStoped = " + xxh.a(this.this$0));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (abhh)this.this$0.app.getManager(153);
      paramMessage = (String)paramMessage.obj;
      if (!xxh.a(this.this$0)) {
        ((abhh)localObject).a().Ce(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      xxh.a(this.this$0).removeMessages(1);
      xxh.a(this.this$0).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxn
 * JD-Core Version:    0.7.0.1
 */