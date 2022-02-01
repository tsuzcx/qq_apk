import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

public class actn
  extends acuk
{
  public actn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean kK(String paramString)
  {
    int k = 0;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = paramString.split("\\?");
    } while ((paramString == null) || (paramString.length < 2));
    long l1 = 0L;
    paramString = paramString[1];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i = ((JSONObject)localObject).optInt("gameId");
        j = k;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = ((JSONObject)localObject).optLong("roomId");
          l1 = l2;
          j = k;
          paramString = ((JSONObject)localObject).optString("gameName");
          l1 = l2;
          j = k;
          k = ((JSONObject)localObject).optInt("gameMode");
          l1 = l2;
          j = k;
          localObject = ((JSONObject)localObject).optString("extendInfo");
          l1 = l2;
          j = k;
          ApolloGameUtil.a(this.app, i, l2, k, (String)localObject, 204, paramString);
          j = k;
          l1 = l2;
          QLog.i("CMShowGameInviteAction", 1, "[gotoCmShowGame], gameId:" + i + ",roomId:" + l1 + ",gameMode:" + j);
          return true;
        }
        catch (Exception paramString)
        {
          break label212;
        }
        paramString = paramString;
        i = 0;
      }
      label212:
      QLog.w("CMShowGameInviteAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  public boolean ace()
  {
    try
    {
      QLog.i("CMShowGameInviteAction", 1, "[cmshow.game_invite], source:" + this.source);
      boolean bool = kK(this.source);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("CMShowGameInviteAction", 1, "doAction error: " + localException.getMessage());
      Ge("CMShowGameInviteAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actn
 * JD-Core Version:    0.7.0.1
 */