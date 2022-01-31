import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class wua
  extends Handler
{
  wua(wtw paramwtw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      wye.a("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("sceneLvOne");
      paramMessage = paramMessage.getString("sceneName");
      this.a.a(i, paramMessage, true);
      return;
    }
    wye.a("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wua
 * JD-Core Version:    0.7.0.1
 */