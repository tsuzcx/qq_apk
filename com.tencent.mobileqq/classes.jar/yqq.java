import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yqq
  implements Runnable
{
  public yqq(ApolloStoreActivity paramApolloStoreActivity) {}
  
  public void run()
  {
    if (!ApolloEngine.a())
    {
      QLog.e("ApolloStoreActivity", 1, "error engine not ready");
      return;
    }
    this.a.a.sendEmptyMessage(357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqq
 * JD-Core Version:    0.7.0.1
 */