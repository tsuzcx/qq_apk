import android.os.Bundle;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil.NotifyGameDressReady;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONObject;

public final class ysu
  implements ApolloGameBasicEventUtil.NotifyGameDressReady
{
  public ysu(int paramInt) {}
  
  public void a(int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[notifyRoleDress], uin:" + paramString1 + ",roleId:" + paramInt2 + ",from:" + paramInt3 + ",cmd:" + paramString3);
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    try
    {
      paramQQAppInterface = ApolloGameBasicEventUtil.a(paramInt2, paramArrayOfInt);
      if (paramQQAppInterface == null)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "errInfo-> jsonObject is NULL");
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[notifyRoleDress], errInfo->" + paramQQAppInterface.getMessage());
      return;
    }
    if (this.a == 1000) {
      paramQQAppInterface.put("uin", paramString1);
    }
    paramQQAppInterface.put("openId", paramString2);
    paramString1 = new Bundle();
    paramString1.putString("resData", paramQQAppInterface.toString());
    paramQQAppInterface = EIPCResult.createResult(0, paramString1);
    CmGameServerQIPCModule.a().callbackResult(paramInt1, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */