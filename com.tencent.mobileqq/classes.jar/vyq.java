import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class vyq
  implements INetEventHandler
{
  vyq(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      vyp.a(this.a);
      return;
    }
    vyp.a("");
    vyp.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyq
 * JD-Core Version:    0.7.0.1
 */