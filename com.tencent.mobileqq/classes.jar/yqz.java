import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;

public class yqz
  implements Runnable
{
  public yqz(CmGameAvHandler paramCmGameAvHandler, int paramInt, long paramLong) {}
  
  public void run()
  {
    AVManager.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().switchCamera(this.jdField_a_of_type_Int, new yra(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqz
 * JD-Core Version:    0.7.0.1
 */