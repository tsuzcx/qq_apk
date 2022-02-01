import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

public class rww
  extends QIPCModule
{
  rww(rwv paramrwv, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    ThreadManager.getUIHandler().post(new SimpleEventBus.1.1(this, paramString, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rww
 * JD-Core Version:    0.7.0.1
 */