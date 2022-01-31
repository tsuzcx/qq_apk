import com.tencent.mobileqq.apollo.game.ApolloJSContext;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

public class ymm
  implements Runnable
{
  public ymm(ApolloJSContext paramApolloJSContext, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (ApolloJSContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext) != null) {
      ApolloJSContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloJSContext).evaluateJavascript(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSmttSdkValueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymm
 * JD-Core Version:    0.7.0.1
 */