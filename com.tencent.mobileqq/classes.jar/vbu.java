import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class vbu
  extends Handler
{
  WeakReference<vbt> jdField_a_of_type_JavaLangRefWeakReference;
  
  vbu(vbt paramvbt1, vbt paramvbt2)
  {
    vmp.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvbt2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    vmp.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (vbt.a(this.jdField_a_of_type_Vbt) != 4) {
        break label46;
      }
      vbt.a(this.jdField_a_of_type_Vbt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vbt.b();
      return;
      label46:
      vbt.b(this.jdField_a_of_type_Vbt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbu
 * JD-Core Version:    0.7.0.1
 */