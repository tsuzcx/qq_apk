import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONObject;

final class abxv
  implements abxt.b
{
  abxv(int paramInt) {}
  
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
      paramQQAppInterface = abxt.a(paramInt2, paramArrayOfInt);
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
    if (this.ctz == 1000) {
      paramQQAppInterface.put("uin", paramString1);
    }
    paramQQAppInterface.put("openId", paramString2);
    paramString1 = new Bundle();
    paramString1.putString("resData", paramQQAppInterface.toString());
    paramQQAppInterface = EIPCResult.createResult(0, paramString1);
    abmm.a().callbackResult(paramInt1, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxv
 * JD-Core Version:    0.7.0.1
 */