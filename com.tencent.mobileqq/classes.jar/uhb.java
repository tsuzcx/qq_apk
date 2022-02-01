import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class uhb
  extends Handler
{
  WeakReference<uha> jdField_a_of_type_JavaLangRefWeakReference;
  
  uhb(uha paramuha1, uha paramuha2)
  {
    upe.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuha2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    upe.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (uha.a(this.jdField_a_of_type_Uha) != 4) {
        break label46;
      }
      uha.a(this.jdField_a_of_type_Uha);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uha.b();
      return;
      label46:
      uha.b(this.jdField_a_of_type_Uha);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */