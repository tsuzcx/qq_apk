import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class rpd
  implements INetEventHandler
{
  rpd(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      rpc.access$000(this.val$appContext);
      return;
    }
    rpc.access$102("");
    rpc.access$202("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpd
 * JD-Core Version:    0.7.0.1
 */