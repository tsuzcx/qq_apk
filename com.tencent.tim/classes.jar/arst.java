import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class arst
  extends Handler
{
  public arst(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.mParams);
      paramMessage.putString("agentversion", aroi.a().getAgentVersion());
      paramMessage.putString("facetype", "mqqface");
      String str = asbg.a().qP("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      arsc.a().a(str, paramMessage, new arsu(this));
      return;
    }
    if ((this.a.b != null) && (!this.a.b.isCancelled())) {
      this.a.b.cancel(true);
    }
    this.a.dismissProgressDialog();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", arxo.cCU);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arst
 * JD-Core Version:    0.7.0.1
 */