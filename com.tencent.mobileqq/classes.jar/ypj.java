import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ypj
  implements Runnable
{
  public ypj(ApolloBoxEnterView paramApolloBoxEnterView) {}
  
  public void run()
  {
    if (ApolloBoxEnterView.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)ApolloBoxEnterView.a(this.a).get();
      } while ((ApolloBoxEnterView.a(this.a) == null) || (localObject == null));
      Object localObject = (ApolloManager)((QQAppInterface)localObject).getManager(152);
      ApolloBoxEnterView.a(this.a).hadStolen = 1;
      ((ApolloManager)localObject).a(ApolloBoxEnterView.a(this.a));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloBoxEnterView", 2, "updateApolloPandora");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypj
 * JD-Core Version:    0.7.0.1
 */