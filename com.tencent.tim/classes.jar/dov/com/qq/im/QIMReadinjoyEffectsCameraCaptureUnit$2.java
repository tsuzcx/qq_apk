package dov.com.qq.im;

import aqmj;
import awsv;
import aycb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QIMReadinjoyEffectsCameraCaptureUnit$2
  implements Runnable
{
  public QIMReadinjoyEffectsCameraCaptureUnit$2(awsv paramawsv) {}
  
  public void run()
  {
    if (!aqmj.aI(this.this$0.a.getActivity(), this.this$0.a.getAppInterface().getCurrentAccountUin()))
    {
      ThreadManager.getUIHandler().post(new QIMReadinjoyEffectsCameraCaptureUnit.2.1(this));
      aqmj.cP(this.this$0.a.getActivity(), this.this$0.a.getAppInterface().getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */