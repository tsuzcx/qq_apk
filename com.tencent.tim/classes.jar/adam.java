import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adam
{
  private static void a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountStateReporter", 2, new Object[] { "doPublicAccountFollowState { isFollow=", Boolean.valueOf(paramBoolean), " appType=", Integer.valueOf(paramInt1), " appid=", Long.valueOf(paramLong1), " puin=", Long.valueOf(paramLong2), " source=", Integer.valueOf(paramInt2), " }" });
    }
    paramQQAppInterface = (adag)paramQQAppInterface.getBusinessHandler(148);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramBoolean, paramInt1, paramLong1, paramLong2, paramInt2);
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    try
    {
      a(paramQQAppInterface, paramBoolean, -1, -1L, Long.parseLong(paramString), paramInt);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.d("PublicAccountStateReporter", 1, new Object[] { "NumberFormatException, puin=", paramString });
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    paramInt = gM(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountStateReporter", 2, "onPublicAccountReceiveState state : " + paramInt + ", name: " + paramString2 + ", pUin: " + paramString1);
    }
    paramQQAppInterface = (adag)paramQQAppInterface.getBusinessHandler(148);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.K(paramString1, paramString2, paramInt);
    }
  }
  
  private static int gM(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adam
 * JD-Core Version:    0.7.0.1
 */