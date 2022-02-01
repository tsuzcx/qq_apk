import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class zkz
  implements INetEventHandler
{
  zkz(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zky.a(this.a);
      return;
    }
    zky.a("");
    zky.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkz
 * JD-Core Version:    0.7.0.1
 */