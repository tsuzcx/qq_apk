import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.ApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

public class ykv
  implements ApolloPushManager.OnActionPushListener
{
  public ykv(ApolloPushManager paramApolloPushManager) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((ApolloPushManager.a(this.a) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((ApolloPushManager.a(this.a).jdField_a_of_type_Int == paramInt) && (paramInt == ApolloPushManager.a(this.a).jdField_a_of_type_Int) && (!TextUtils.isEmpty(ApolloPushManager.a(this.a).jdField_a_of_type_JavaLangString)) && (ApolloPushManager.a(this.a).jdField_a_of_type_JavaLangString.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.a.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykv
 * JD-Core Version:    0.7.0.1
 */