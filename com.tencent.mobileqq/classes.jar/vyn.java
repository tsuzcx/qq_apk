import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class vyn
  implements INetEventHandler
{
  vyn(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      vym.a(this.a);
      return;
    }
    vym.a("");
    vym.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyn
 * JD-Core Version:    0.7.0.1
 */