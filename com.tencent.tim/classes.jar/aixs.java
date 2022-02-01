import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class aixs
  implements aiyc.a
{
  aixs(aixr paramaixr) {}
  
  public void dvm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "fun startMagicPlay begins, sumPlayTimes:" + this.this$0.dgg + ",actionGlobalData.openSound:" + this.this$0.jdField_a_of_type_Aixt.cmC);
    }
    Object localObject;
    if (this.this$0.dgg == 0)
    {
      this.this$0.dvk();
      if ((this.this$0.jdField_a_of_type_Aiye.bQd != null) && (this.this$0.jdField_a_of_type_Aiye.bQd.length() > 0) && (this.this$0.jdField_a_of_type_Aixt.cmC))
      {
        if (this.this$0.jdField_a_of_type_Aiye.dgP > 0)
        {
          localObject = this.this$0.jdField_a_of_type_Aiye;
          ((aiye)localObject).dgP -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.this$0.jdField_a_of_type_Aiyl.ag(this.this$0.jdField_a_of_type_Aiye.bQd, this.this$0.jdField_a_of_type_Aiye.dgP);
      }
      if (this.this$0.jdField_a_of_type_Aiye.cmI)
      {
        this.this$0.vibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (this.this$0.jdField_a_of_type_Aiye.dgQ != -1) {
          break label311;
        }
        this.this$0.vibrator.vibrate(new long[] { 0L, 1000L }, 0);
      }
    }
    for (;;)
    {
      localObject = this.this$0;
      ((aixr)localObject).dgg += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Action", 2, "fun startMagicPlay ends, sumPlayTimes:" + this.this$0.dgg);
      }
      return;
      label311:
      this.this$0.vibrator.vibrate(this.this$0.jdField_a_of_type_Aiye.dgQ * 1000);
    }
  }
  
  public void dvn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "func endMagicPlay begins, isStop:" + this.this$0.isStop + ",timeout:" + this.this$0.timeout + ",playTimes:" + this.this$0.playTimes + ",sumPlayTimes:" + this.this$0.dgg + ",isTimeout:" + this.this$0.isTimeout);
    }
    if (this.this$0.isStop) {
      this.this$0.countDownLatch.countDown();
    }
    do
    {
      return;
      if (this.this$0.timeout == -1)
      {
        if (this.this$0.playTimes == -1)
        {
          this.this$0.jdField_a_of_type_Aiyl.a(this.this$0.jdField_a_of_type_Aiye);
          return;
        }
        if (this.this$0.playTimes > this.this$0.dgg)
        {
          this.this$0.jdField_a_of_type_Aiyl.a(this.this$0.jdField_a_of_type_Aiye);
          return;
        }
        if (this.this$0.playTimes == this.this$0.dgg)
        {
          this.this$0.countDownLatch.countDown();
          return;
        }
      }
    } while (this.this$0.isTimeout);
    this.this$0.jdField_a_of_type_Aiyl.a(this.this$0.jdField_a_of_type_Aiye);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixs
 * JD-Core Version:    0.7.0.1
 */