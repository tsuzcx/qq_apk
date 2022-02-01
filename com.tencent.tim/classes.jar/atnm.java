import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler.1.1;

public class atnm
  extends RemoteCommand
{
  public atnm(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramBundle.getBoolean("_async_call_", true)) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      new Handler(Looper.getMainLooper()).post(new DingdongPluginRemoteCmdHandler.1.1(this, paramBundle, paramOnInvokeFinishLinstener));
      paramBundle.putInt("_result_code_", 0);
      return paramBundle;
    }
    return this.this$0.a(paramBundle, paramOnInvokeFinishLinstener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnm
 * JD-Core Version:    0.7.0.1
 */