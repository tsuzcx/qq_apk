import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.sso.CmGameObserver;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ysu
  extends CmGameObserver
{
  public ysu(ApolloGameActivity paramApolloGameActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameObserver", 2, "[onGetGameKey]");
    }
    if (paramBoolean)
    {
      if (paramObject != null) {}
      try
      {
        if (((paramObject instanceof Bundle)) && (Long.valueOf(((Bundle)paramObject).getLong("retCode")).longValue() == ApolloConstant.b))
        {
          ApolloGameStateMachine.a().a(5, "fail in get key in activity");
          this.a.a();
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e("cmgame_process.CmGameObserver", 1, paramObject, new Object[] { "[onGetGameKey]" });
        return;
      }
    }
    this.a.a();
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameObserver", 2, new Object[] { "[onGetGameOnlineCount] result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if ((paramBoolean) && (paramObject != null)) {
      try
      {
        if ((paramObject instanceof JSONObject))
        {
          long l = ((JSONObject)paramObject).optLong("num");
          if (l > 0L)
          {
            if (ApolloGameActivity.a(this.a) != null)
            {
              paramObject = String.valueOf(l) + "人在玩";
              if (l > 9999L) {
                paramObject = String.valueOf(l / 10000L) + "万人在玩";
              }
              ApolloGameActivity.a(this.a).setVisibility(0);
              ApolloGameActivity.a(this.a).setText(paramObject);
            }
          }
          else if (ApolloGameActivity.a(this.a) != null)
          {
            ApolloGameActivity.a(this.a).setVisibility(4);
            return;
          }
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("cmgame_process.CmGameObserver", 1, "[onGetGameOnlineCount] parse data failed, exception=", paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */