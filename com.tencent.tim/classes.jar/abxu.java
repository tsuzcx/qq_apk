import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class abxu
  implements abxt.a
{
  public void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[notifyRoleDress], uin:" + paramString1 + ",roleId:" + paramInt1 + ",from:" + paramInt2 + ",cmd:" + paramString3);
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    try
    {
      paramArrayOfInt = abxt.a(paramInt1, paramArrayOfInt);
      if (paramArrayOfInt == null)
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
    if (!TextUtils.isEmpty(paramString2)) {
      paramArrayOfInt.put("openId", paramString2);
    }
    for (;;)
    {
      ApolloCmdChannel.getChannel(paramQQAppInterface).callbackFromRequest(paramLong, 0, paramString3, paramArrayOfInt.toString());
      return;
      paramArrayOfInt.put("uin", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxu
 * JD-Core Version:    0.7.0.1
 */