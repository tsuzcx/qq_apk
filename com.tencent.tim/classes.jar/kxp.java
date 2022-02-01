import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class kxp
  implements INetEventHandler
{
  kxp(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      kxm.bB(this.val$appContext);
      return;
    }
    kxm.access$502("");
    kxm.eB("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxp
 * JD-Core Version:    0.7.0.1
 */