import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.InviteMemberObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class iin
  implements Observer
{
  Handler mHandler = null;
  
  private void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("qav.GAudioUIObserver", 2, "OnUpdate，msgType = " + i);
    }
    if (paramObject.length < 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qav.GAudioUIObserver", 2, "quit for message length");
      }
      return;
    }
    switch (i)
    {
    default: 
      return;
    }
    c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (ArrayList)paramObject[3]);
  }
  
  protected void c(long paramLong1, long paramLong2, ArrayList<VideoController.b> paramArrayList) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new InviteMemberObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iin
 * JD-Core Version:    0.7.0.1
 */