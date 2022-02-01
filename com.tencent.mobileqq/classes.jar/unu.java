import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class unu
  extends Handler
{
  WeakReference<unt> jdField_a_of_type_JavaLangRefWeakReference;
  
  unu(unt paramunt1, unt paramunt2)
  {
    uya.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramunt2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    uya.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (unt.a(this.jdField_a_of_type_Unt) != 4) {
        break label46;
      }
      unt.a(this.jdField_a_of_type_Unt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Unt.b();
      return;
      label46:
      unt.b(this.jdField_a_of_type_Unt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unu
 * JD-Core Version:    0.7.0.1
 */