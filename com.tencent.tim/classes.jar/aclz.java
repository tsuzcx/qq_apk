import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

class aclz
  extends Handler
{
  aclz(acly paramacly, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 1: 
      Object localObject;
      if ((this.this$0.F != null) && (this.this$0.mBrowserApp != null))
      {
        localObject = new NewIntent(this.this$0.F.getApplicationContext(), jnl.class);
        ((NewIntent)localObject).putExtra("data", ((acly.c)paramMessage.obj).a.toByteArray());
        ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
        ((NewIntent)localObject).setObserver(this.this$0);
        this.this$0.mBrowserApp.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        this.this$0.mIsRunning = false;
        this.this$0.a = null;
        return;
        localObject = this.this$0.createToServiceMsg("SecCheckSigSvc.UploadReq");
        ((ToServiceMsg)localObject).putWupBuffer(((acly.c)paramMessage.obj).a.toByteArray());
        this.this$0.sendPbReq((ToServiceMsg)localObject);
      }
    }
    new Thread(this.this$0.fN).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclz
 * JD-Core Version:    0.7.0.1
 */