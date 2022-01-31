import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class xro
  implements INetEventHandler
{
  xro(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      xrn.a(this.a);
      return;
    }
    xrn.a("");
    xrn.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xro
 * JD-Core Version:    0.7.0.1
 */