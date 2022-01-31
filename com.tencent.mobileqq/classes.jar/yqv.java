import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;

public class yqv
  implements Runnable
{
  public yqv(CmGameAvHandler paramCmGameAvHandler, boolean paramBoolean) {}
  
  public void run()
  {
    CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      AVEngineWalper.a().c();
    }
    AVEngineWalper.a().a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqv
 * JD-Core Version:    0.7.0.1
 */