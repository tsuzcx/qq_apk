package cooperation.qqreader;

import avmq;
import com.tencent.common.app.BaseApplicationImpl;
import jpa;

public class VipProxyRreLoadReaderProcess$1
  implements Runnable
{
  VipProxyRreLoadReaderProcess$1(VipProxyRreLoadReaderProcess paramVipProxyRreLoadReaderProcess) {}
  
  public void run()
  {
    jpa.b("354", BaseApplicationImpl.getApplication().getRuntime(), true, new avmq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess.1
 * JD-Core Version:    0.7.0.1
 */