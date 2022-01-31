import com.tencent.mobileqq.apollo.game.ApolloJSContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

public class yvz
  implements ValueCallback
{
  public yvz(ApolloJSContext paramApolloJSContext) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJSContext", 2, "[onReceiveValue] s " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvz
 * JD-Core Version:    0.7.0.1
 */