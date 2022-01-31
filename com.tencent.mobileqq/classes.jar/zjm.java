import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.SVIPHandler;

public class zjm
  implements Runnable
{
  public zjm(SVIPHandler paramSVIPHandler, String paramString) {}
  
  public void run()
  {
    DiyPendantFetcher localDiyPendantFetcher = DiyPendantFetcher.a();
    localDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.b, this.jdField_a_of_type_JavaLangString, new zjn(this, localDiyPendantFetcher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjm
 * JD-Core Version:    0.7.0.1
 */