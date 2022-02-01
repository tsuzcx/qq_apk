import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class afhk
  implements Handler.Callback
{
  afhk(afhj paramafhj) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.this$0.bYe = true;
      QLog.i("EmoticonFromGroup_DBManager", 1, "set db tag, mCanWriteDataToDB = true.");
    } while (this.this$0.CX() < 300);
    afhj.a(this.this$0).clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhk
 * JD-Core Version:    0.7.0.1
 */