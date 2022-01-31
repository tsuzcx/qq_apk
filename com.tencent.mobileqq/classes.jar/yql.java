import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;

public class yql
  implements Runnable
{
  public yql(CmGameAvHandler paramCmGameAvHandler, float paramFloat) {}
  
  public void run()
  {
    AVManager.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().inputBeautyParam(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yql
 * JD-Core Version:    0.7.0.1
 */