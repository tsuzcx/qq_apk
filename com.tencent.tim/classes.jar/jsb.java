import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;

public class jsb
  extends Handler
{
  public jsb(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.this$0.mClient.a(17, paramMessage, this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsb
 * JD-Core Version:    0.7.0.1
 */