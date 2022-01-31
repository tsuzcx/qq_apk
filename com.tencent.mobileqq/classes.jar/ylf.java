import com.tencent.mobileqq.apollo.ai.ApolloAILogicProcessor;
import com.tencent.qphone.base.util.QLog;

public class ylf
  implements Runnable
{
  public ylf(ApolloAILogicProcessor paramApolloAILogicProcessor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAILogicProcessor", 2, "[run post]");
    }
    ApolloAILogicProcessor.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylf
 * JD-Core Version:    0.7.0.1
 */