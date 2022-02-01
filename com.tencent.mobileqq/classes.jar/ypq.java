import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class ypq
  implements INetEventHandler
{
  ypq(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ypp.a(this.a);
      return;
    }
    ypp.a("");
    ypp.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypq
 * JD-Core Version:    0.7.0.1
 */