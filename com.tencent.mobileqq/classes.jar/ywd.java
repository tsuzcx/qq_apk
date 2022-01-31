import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ywd
  implements Runnable
{
  public ywd(ApolloGameInvitation paramApolloGameInvitation) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.n).append(ApolloGameInvitation.a(this.a).jdField_e_of_type_Int).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject1).toString()).exists()) {
        localObject1 = BitmapFactory.decodeFile(((StringBuilder)localObject1).toString());
      } else {
        localObject1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130838155);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    while (localException != null)
    {
      Bitmap localBitmap = TroopShareUtility.a(localThrowable);
      ApolloGameInvitation.a(this.a, String.valueOf(System.currentTimeMillis()));
      String str1 = "一起来玩" + ApolloGameInvitation.a(this.a).jdField_e_of_type_JavaLangString;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("gameId", ApolloGameInvitation.a(this.a).jdField_e_of_type_Int);
        ((JSONObject)localObject2).put("roomId", ApolloGameInvitation.a(this.a).b);
        ((JSONObject)localObject2).put("gameMode", ApolloGameInvitation.a(this.a).g);
        ((JSONObject)localObject2).put("extendInfo", ApolloGameInvitation.a(this.a).f);
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "UTF-8");
        String str2 = URLEncoder.encode(str1, "UTF-8");
        StringBuilder localStringBuilder = new StringBuilder("http://cmshow.qq.com/apollo/html/redirect/mqqapi_cmshow.html");
        localStringBuilder.append("?").append("cmd=game_invite&title=").append(str2).append("&data=").append((String)localObject2);
        WXShareHelper.a().a(new ywe(this));
        WXShareHelper.a().a(ApolloGameInvitation.a(this.a), str1, localBitmap, ApolloGameInvitation.b(this.a), localStringBuilder.toString(), 1);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ApolloGameInvitation", 1, "[inviteWeChatFriend], errInfo->" + localException.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywd
 * JD-Core Version:    0.7.0.1
 */