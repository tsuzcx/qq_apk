import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.ApolloJSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ypi
  implements EIPCResultCallback
{
  ypi(yph paramyph) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    ApolloJSContext localApolloJSContext;
    if (i == 1)
    {
      paramEIPCResult = paramEIPCResult.getString("nickName");
      if ((ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy) != null) && (ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy).get() != null))
      {
        localApolloJSContext = (ApolloJSContext)ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy).get();
        if (localApolloJSContext == null) {}
      }
    }
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("nickname", 1);
            localJSONObject.put("data", paramEIPCResult);
            localJSONObject.put("openId", this.a.jdField_a_of_type_JavaLangString);
            localApolloJSContext.a(0, "cs.get_userInfo.local", "" + localJSONObject.toString() + "");
            return;
          }
          catch (Throwable paramEIPCResult)
          {
            QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
            return;
          }
        } while (i != 2);
        paramEIPCResult = ApolloGameTool.a((Bitmap)paramEIPCResult.getParcelable("head"), 100);
      } while ((ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy) == null) || (ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy).get() == null));
      localApolloJSContext = (ApolloJSContext)ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy).get();
    } while (localApolloJSContext == null);
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("avatar", 1);
      localJSONObject.put("data", paramEIPCResult);
      localJSONObject.put("openId", this.a.jdField_a_of_type_JavaLangString);
      localApolloJSContext.a(0, "cs.get_userInfo.local", "" + localJSONObject.toString() + "");
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypi
 * JD-Core Version:    0.7.0.1
 */