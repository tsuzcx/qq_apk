import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;

public class jrj
  extends Handler
{
  public jrj(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      this.this$0.lk((String)paramMessage.obj);
    }
    while (paramMessage.what != 291) {
      return;
    }
    this.this$0.updateMicStatus((String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrj
 * JD-Core Version:    0.7.0.1
 */