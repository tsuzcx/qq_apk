import android.os.Handler.Callback;
import android.os.Message;

class aqsk
  implements Handler.Callback
{
  aqsk(aqsj paramaqsj) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      aqsl.VC(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsk
 * JD-Core Version:    0.7.0.1
 */