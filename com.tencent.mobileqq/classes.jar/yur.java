import com.tencent.mobileqq.apollo.ai.ApolloAILogicProcessor;
import com.tencent.qphone.base.util.QLog;

public class yur
  implements Runnable
{
  public yur(ApolloAILogicProcessor paramApolloAILogicProcessor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[run post]");
    }
    ApolloAILogicProcessor.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yur
 * JD-Core Version:    0.7.0.1
 */