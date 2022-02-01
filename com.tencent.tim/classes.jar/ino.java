import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.GaInviteLockActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ino
  extends iio
{
  public ino(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  protected void c(long paramLong1, long paramLong2, ArrayList<inx> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onReceiveMemberList mMemberChangeEventReceiver size:" + paramArrayList.size());
    }
    ThreadManager.getUIHandler().post(new GaInviteLockActivity.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ino
 * JD-Core Version:    0.7.0.1
 */