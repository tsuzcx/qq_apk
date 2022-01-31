import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.qphone.base.util.QLog;

public class yng
  implements Runnable
{
  public yng(CmGameAvHandler paramCmGameAvHandler, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + ApolloConstant.V + ", ApolloConstant.sGameAVSoMd5=" + ApolloConstant.W);
    AVEngineWalper.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.a);
    AVEngineWalper.a().a(0, ApolloConstant.V, ApolloConstant.W);
    AVEngineWalper.a().a(BaseApplicationImpl.getContext(), CmGameUtil.a().getCurrentAccountUin(), "" + this.jdField_a_of_type_Int, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yng
 * JD-Core Version:    0.7.0.1
 */