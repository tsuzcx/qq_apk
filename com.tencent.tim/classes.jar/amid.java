import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

class amid
  implements Observer
{
  amid(amib paramamib) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    do
    {
      return;
      paramObservable = this.this$0.a();
    } while ((paramObservable == null) || (paramObservable.er.get()) || (this.this$0.cCI != true) || (this.this$0.richStatus == null) || (this.this$0.cCJ) || (this.this$0.aDd));
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "update tplId=" + this.this$0.richStatus.tplId);
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.K);
    ThreadManager.getUIHandlerV2().post(this.this$0.K);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amid
 * JD-Core Version:    0.7.0.1
 */