import android.app.Activity;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class yxu
  implements Runnable
{
  public yxu(CmGameCommonShare paramCmGameCommonShare) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(CmGameCommonShare.a(this.a));
      localJSONObject.put("gameId", CmGameCommonShare.a(this.a));
      localJSONObject.put("isSelectFriend", 1);
      ApolloGameBasicEventUtil.a(CmGameCommonShare.a(this.a), localJSONObject.toString(), (Activity)CmGameCommonShare.a(this.a).get());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxu
 * JD-Core Version:    0.7.0.1
 */