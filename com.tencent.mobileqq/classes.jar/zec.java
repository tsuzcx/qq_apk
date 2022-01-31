import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class zec
  extends VasExtensionObserver
{
  public zec(ApolloGameHotChatController paramApolloGameHotChatController) {}
  
  protected void m(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameHotChatController", 2, new Object[] { "[onGetGameOnlineCount] result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if ((ApolloGameHotChatController.a(this.a)) || (ApolloGameHotChatController.b(this.a) == null) || (ApolloGameHotChatController.c(this.a) == null) || (ApolloGameHotChatController.c(this.a).get() == null)) {}
    do
    {
      boolean bool2;
      long l;
      do
      {
        QQAppInterface localQQAppInterface;
        do
        {
          for (;;)
          {
            return;
            localQQAppInterface = (QQAppInterface)ApolloGameHotChatController.b(this.a).get();
            if ((localQQAppInterface != null) && (paramBoolean) && (paramObject != null)) {
              try
              {
                if ((paramObject instanceof JSONObject))
                {
                  paramObject = (JSONObject)paramObject;
                  if (paramObject.optInt("barShowFlag") == 1) {
                    bool1 = true;
                  }
                  bool2 = paramObject.optBoolean("tipsBarAnimation");
                  l = paramObject.optLong("num");
                  int i = paramObject.optInt("autoJoinFlag");
                  localQQAppInterface.getPreferences().edit().putInt("noActive_apollo_autojionflag", i).commit();
                  if ((!bool1) || (l <= 0L))
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("ApolloGameHotChatController", 2, new Object[] { "[onGetGameOnlineCount] showBar=", Boolean.valueOf(bool1), ",count:", Long.valueOf(l) });
                  }
                }
              }
              catch (Exception paramObject)
              {
                QLog.e("ApolloGameHotChatController", 1, "[onGetGameOnlineCount] parse data failed, exception=", paramObject);
                return;
              }
            }
          }
        } while (!bool1);
        paramObject = ((ApolloDaoManager)localQQAppInterface.getManager(154)).a(ApolloGameHotChatController.a(this.a));
        if (paramObject == null) {
          break;
        }
        paramObject = paramObject.name;
      } while (TextUtils.isEmpty(paramObject));
      if (ApolloGameHotChatController.a(this.a) == null) {
        ApolloGameHotChatController.a(this.a, new zef((Context)ApolloGameHotChatController.c(this.a).get(), this.a));
      }
      ApolloGameHotChatController.a(this.a).a(l, paramObject);
      ApolloGameHotChatController.a(this.a, bool2);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameHotChatController", 2, new Object[] { "[onGetGameOnlineCount] show tips bar, result=", Boolean.valueOf(paramBoolean) });
    return;
    QLog.e("ApolloGameHotChatController", 1, new Object[] { "[onGetGameOnlineCount] no game info for gameId: ", Integer.valueOf(ApolloGameHotChatController.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zec
 * JD-Core Version:    0.7.0.1
 */