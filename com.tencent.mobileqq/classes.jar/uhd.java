import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class uhd
  extends Handler
{
  WeakReference<uhc> jdField_a_of_type_JavaLangRefWeakReference;
  
  uhd(uhc paramuhc1, uhc paramuhc2)
  {
    uqf.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuhc2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    uqf.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (uhc.a(this.jdField_a_of_type_Uhc) != 4) {
        break label46;
      }
      uhc.a(this.jdField_a_of_type_Uhc);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uhc.b();
      return;
      label46:
      uhc.b(this.jdField_a_of_type_Uhc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */