import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class zej
  implements INetEventHandler
{
  zej(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zei.a(this.a);
      return;
    }
    zei.a("");
    zei.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zej
 * JD-Core Version:    0.7.0.1
 */