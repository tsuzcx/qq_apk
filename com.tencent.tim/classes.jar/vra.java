import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.RegisterActivity;

public class vra
  extends Handler
{
  public vra(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.this$0.gV();
    switch (paramMessage.what)
    {
    case -1: 
    case 0: 
    case 2: 
    default: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        paramMessage = this.this$0;
        paramMessage.aX = ((byte)(paramMessage.aX + 1));
        this.this$0.bUN();
        return;
        this.this$0.bUZ();
        return;
        this.this$0.bUY();
        return;
      } while (this.this$0.aPk == null);
      Toast.makeText(this.this$0.getApplicationContext(), this.this$0.aPk, 1).show();
      this.this$0.aPk = null;
      return;
    case 6: 
      paramMessage = paramMessage.getData().getString("url");
      this.this$0.wp(paramMessage);
      return;
    case 7: 
      this.this$0.dq(paramMessage.getData().getString("telNum"), paramMessage.getData().getString("msg"));
      return;
    }
    this.this$0.aX = 3;
    this.this$0.bUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vra
 * JD-Core Version:    0.7.0.1
 */