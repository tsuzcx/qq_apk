import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.2;
import com.tencent.av.redpacket.AVRedPacketManager.a;
import com.tencent.qphone.base.util.QLog;

public class irs
  implements irx.a
{
  public irs(AVRedPacketManager.2 param2, long paramLong) {}
  
  public void onLoadFinish()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startTime;
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, music load finish,cost =" + (l1 - l2));
    l1 = System.currentTimeMillis();
    if (this.a.this$0.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a != null)
    {
      this.a.this$0.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.a(1, this.a.this$0.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$b);
      l2 = System.currentTimeMillis();
      QLog.d("AVRedPacketManager", 1, "preloadCountDownRes, preloadRes finish,cost =" + (l2 - l1));
      return;
    }
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes,  mRedPacketGameShower is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irs
 * JD-Core Version:    0.7.0.1
 */