import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class acak
  extends aqrd
{
  public acak(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt) {}
  
  protected void onAuthResponse(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if ((paramObject != null) && ((paramObject instanceof HashMap)))
    {
      paramObject = (HashMap)paramObject;
      localObject = (String)paramObject.get("optFrom");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("newActionFloatView".equals(localObject))) {}
    }
    else
    {
      return;
    }
    this.this$0.mBaseChatPie.app.removeObserver(this);
    if (paramBoolean)
    {
      ApolloPanel.a(this.this$0, this.a, 0, 21, this.cup, null);
      return;
    }
    Object localObject = new Bundle();
    paramObject = (String)paramObject.get("url");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, activityUrl=", paramObject });
    }
    ((Bundle)localObject).putString("activityUrl", paramObject);
    ApolloPanel.a(this.this$0, this.a, 1, 22, this.cup, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acak
 * JD-Core Version:    0.7.0.1
 */