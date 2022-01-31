import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;

public class yms
  implements Runnable
{
  public yms(ApolloWebViewFragment paramApolloWebViewFragment, String paramString) {}
  
  public void run()
  {
    WebAccelerateHelper.getInstance().preGetKey(this.jdField_a_of_type_JavaLangString, ApolloWebViewFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebViewFragment), null);
    WebAccelerateHelper.getInstance().preCheckOffline(this.jdField_a_of_type_JavaLangString);
    WebAccelerateHelper.getInstance().preFetchResource(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yms
 * JD-Core Version:    0.7.0.1
 */