import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class cua
  extends Handler
{
  public cua(MessageHandler paramMessageHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = paramMessage.getData();
    } while ((paramMessage == null) || (!paramMessage.containsKey("update_unread_uin")) || (!paramMessage.containsKey("update_unread_time")));
    this.a.a.a().a(paramMessage.getString("update_unread_uin"), paramMessage.getInt("update_unread_type", 0), paramMessage.getLong("update_unread_time"));
    MessageHandler.a(this.a, 2002, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cua
 * JD-Core Version:    0.7.0.1
 */