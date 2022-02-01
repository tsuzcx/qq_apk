import android.os.Handler.Callback;
import android.os.Message;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, k=3, mv={1, 1, 16})
final class uaw
  implements Handler.Callback
{
  public static final uaw a = new uaw();
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = Integer.valueOf(paramMessage.what);
      if (paramMessage != null) {
        break label23;
      }
    }
    for (;;)
    {
      return true;
      paramMessage = null;
      break;
      label23:
      if (paramMessage.intValue() != 1000) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uaw
 * JD-Core Version:    0.7.0.1
 */