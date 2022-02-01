import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

public class zwq
  extends QIPCModule
{
  zwq(zwp paramzwp, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    ThreadManager.getUIHandler().post(new SimpleEventBus.1.1(this, paramString, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */