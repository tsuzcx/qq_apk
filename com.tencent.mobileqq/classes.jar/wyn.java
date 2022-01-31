import Wallet.PfaFriendRsp;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.TopayManager;

public final class wyn
  extends Handler
{
  public wyn(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessage.obj != null)
    {
      localObject1 = localObject2;
      if ((paramMessage.obj instanceof PfaFriendRsp)) {
        localObject1 = (PfaFriendRsp)paramMessage.obj;
      }
    }
    boolean bool1;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if (paramMessage.arg2 != 1) {
        break label93;
      }
    }
    for (;;)
    {
      TopayManager.a(bool1, (PfaFriendRsp)localObject1, bool2);
      return;
      bool1 = false;
      break;
      label93:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */