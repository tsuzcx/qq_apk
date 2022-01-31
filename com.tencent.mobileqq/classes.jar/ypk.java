import android.os.Process;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class ypk
  implements Runnable
{
  public ypk(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    ApolloGameStateMachine.HardwareInfo localHardwareInfo2 = ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo;
    ApolloGameStateMachine.HardwareInfo localHardwareInfo1 = localHardwareInfo2;
    if (localHardwareInfo2 == null) {
      localHardwareInfo1 = new ApolloGameStateMachine.HardwareInfo();
    }
    localHardwareInfo1.b = DeviceInfoUtil.a(Process.myPid());
    localHardwareInfo1.c = DeviceInfoUtil.g();
    ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo = localHardwareInfo1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypk
 * JD-Core Version:    0.7.0.1
 */