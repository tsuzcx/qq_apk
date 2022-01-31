import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class vlu
  implements INetEventHandler
{
  vlu(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      vlt.a(this.a);
      return;
    }
    vlt.a("");
    vlt.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlu
 * JD-Core Version:    0.7.0.1
 */