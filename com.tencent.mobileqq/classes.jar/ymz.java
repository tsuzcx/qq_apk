import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.qphone.base.util.QLog;

public class ymz
  implements Runnable
{
  public ymz(CmGameAvHandler paramCmGameAvHandler, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    AVEngineWalper.a().b(CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler));
    AVEngineWalper.a().b(this.jdField_a_of_type_JavaLangString);
    AVEngineWalper.a().a(this.jdField_a_of_type_Long);
    AVEngineWalper.a().a(0);
    AVEngineWalper.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymz
 * JD-Core Version:    0.7.0.1
 */