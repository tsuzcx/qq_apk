import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class zda
  implements Runnable
{
  public zda(ApolloGameRscVerify paramApolloGameRscVerify) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (!ApolloGameRscVerify.a(this.a)) {
        return;
      }
      if (ApolloGameRscVerify.a(this.a) != null)
      {
        Iterator localIterator = ApolloGameRscVerify.a(this.a).keys();
        StringBuilder localStringBuilder = new StringBuilder(200);
        Object localObject;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = this.a;
          ((ApolloGameRscVerify)localObject).jdField_a_of_type_Int += 1;
          localObject = (String)localIterator.next();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append(ApolloConstant.a);
          localStringBuilder.append("/game/").append(ApolloGameRscVerify.a(this.a)).append("/").append((String)localObject);
        } while (this.a.a(localStringBuilder.toString(), (String)localObject));
        this.a.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameRscVerify", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zda
 * JD-Core Version:    0.7.0.1
 */