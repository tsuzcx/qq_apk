import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class xnf
  implements INetEventHandler
{
  xnf(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      xne.a(this.a);
      return;
    }
    xne.a("");
    xne.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */