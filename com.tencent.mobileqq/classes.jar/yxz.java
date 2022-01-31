import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

public class yxz
  implements Runnable
{
  public yxz(CmGameLauncher paramCmGameLauncher, ApolloCmdChannel paramApolloCmdChannel) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.requestData(CmGameLauncher.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher).getLuaState(), "cs.make_room_min.local", "{}", true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxz
 * JD-Core Version:    0.7.0.1
 */