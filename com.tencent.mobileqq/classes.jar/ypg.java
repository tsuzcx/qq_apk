import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.game.ApolloJSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

public class ypg
  implements EIPCResultCallback
{
  public ypg(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "get_open_key_back");
      }
      paramEIPCResult = paramEIPCResult.data.getString("respData");
      if ((ApolloGameInterfaceProxy.a(this.a) != null) && (ApolloGameInterfaceProxy.a(this.a).get() != null))
      {
        ApolloJSContext localApolloJSContext = (ApolloJSContext)ApolloGameInterfaceProxy.a(this.a).get();
        if (localApolloJSContext != null) {
          localApolloJSContext.a(0, "cs.on_get_open_key.local", paramEIPCResult);
        }
      }
      else
      {
        QLog.e("ApolloGameInterfaceProxy", 1, "[send] can not get js context");
        return;
      }
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypg
 * JD-Core Version:    0.7.0.1
 */