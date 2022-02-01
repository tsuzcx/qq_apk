import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class awpk
  extends RemoteCommand
{
  private static awpk.a b;
  private static final AtomicInteger mState = new AtomicInteger();
  
  public awpk()
  {
    super("weiyun.notify_state");
  }
  
  public void a(awpk.a parama)
  {
    b = parama;
  }
  
  public int getState()
  {
    return mState.get();
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", mState.get());
    if (i != mState.get())
    {
      mState.set(i);
      if (b != null) {
        b.mT(mState.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
  
  public static abstract interface a
  {
    public abstract void mT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpk
 * JD-Core Version:    0.7.0.1
 */