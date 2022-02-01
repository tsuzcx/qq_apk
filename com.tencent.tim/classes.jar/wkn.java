import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class wkn
  extends Handler
{
  public wkn(ChatItemAnimLayout paramChatItemAnimLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_START");
      }
      this.a.i.mMsgAnimTime = System.currentTimeMillis();
      this.a.py = 0.0F;
      this.a.pz = 0.0F;
      sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(1), 10L);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_UPDADE");
      }
      this.a.i.mMsgAnimTime = System.currentTimeMillis();
      float f2 = (float)(this.a.i.mMsgAnimTime - this.a.HN) / 300.0F;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      this.a.py = (1.0F - (1.0F - f1) * (1.0F - f1) * (1.0F - f1));
      this.a.pz = f1;
      if (this.a.py < 1.0F) {
        sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(1), 10L);
      }
      for (;;)
      {
        this.a.invalidate();
        return;
        this.a.py = 1.0F;
        sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(2), 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_END");
      }
      this.a.py = 1.0F;
      this.a.invalidate();
    } while (this.a.a == null);
    this.a.a.o(this.a.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkn
 * JD-Core Version:    0.7.0.1
 */