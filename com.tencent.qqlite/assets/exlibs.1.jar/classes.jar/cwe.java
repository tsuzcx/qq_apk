import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.ProtoServlet;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

public class cwe
  extends Handler
{
  public cwe(StartAppCheckHandler paramStartAppCheckHandler, Looper paramLooper)
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
      if ((this.a.jdField_a_of_type_AndroidAppActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null))
      {
        localObject = new NewIntent(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ProtoServlet.class);
        ((NewIntent)localObject).putExtra("data", ((cwj)paramMessage.obj).a.toByteArray());
        ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
        ((NewIntent)localObject).setObserver(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_Cwj = null;
        return;
        localObject = this.a.a("SecCheckSigSvc.UploadReq");
        ((ToServiceMsg)localObject).putWupBuffer(((cwj)paramMessage.obj).a.toByteArray());
        this.a.b((ToServiceMsg)localObject);
      }
    }
    new Thread(this.a.jdField_a_of_type_JavaLangRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwe
 * JD-Core Version:    0.7.0.1
 */