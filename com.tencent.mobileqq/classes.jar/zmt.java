import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.app.ThreadManager;

public class zmt
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apnc jdField_a_of_type_Apnc;
  private String jdField_a_of_type_JavaLangString = "QR_CODE";
  private zmu jdField_a_of_type_Zmu;
  private Handler b;
  
  public zmt(Context paramContext, zmu paramzmu)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Zmu = paramzmu;
    this.jdField_a_of_type_Apnc = apnc.a();
    this.jdField_a_of_type_Apnc.a(paramContext, hashCode(), "QrImageScan");
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      if (this.jdField_a_of_type_Apnc != null) {
        this.jdField_a_of_type_Apnc.a(hashCode(), "QrImageScan");
      }
      this.jdField_a_of_type_Zmu = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramString = Uri.parse("file://" + paramString);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
        this.b = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper(), this);
      }
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramInt, 0, paramString).sendToTarget();
      return;
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i = paramMessage.arg1;
      paramMessage = zmk.a((Uri)paramMessage.obj, this.jdField_a_of_type_AndroidContentContext, i);
      if ((paramMessage != null) && (paramMessage.b()))
      {
        if (this.b != null) {
          this.b.obtainMessage(2, i, 0, paramMessage).sendToTarget();
        }
      }
      else if (this.b != null)
      {
        this.b.obtainMessage(3, i, 0).sendToTarget();
        continue;
        i = paramMessage.arg1;
        if (this.jdField_a_of_type_Zmu != null)
        {
          this.jdField_a_of_type_Zmu.a((ScannerResult)paramMessage.obj, i);
          continue;
          i = paramMessage.arg1;
          if (this.jdField_a_of_type_Zmu != null) {
            this.jdField_a_of_type_Zmu.a(i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmt
 * JD-Core Version:    0.7.0.1
 */