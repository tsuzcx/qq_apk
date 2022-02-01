import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class awxl
  extends Handler
{
  awxl(awxg paramawxg, Looper paramLooper)
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
      sqn.a("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("sceneLvOne");
      paramMessage = paramMessage.getString("sceneName");
      this.this$0.z(i, paramMessage, true);
      return;
    }
    sqn.a("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
    this.this$0.eHq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxl
 * JD-Core Version:    0.7.0.1
 */