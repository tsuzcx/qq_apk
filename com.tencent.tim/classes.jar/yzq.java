import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;

public class yzq
{
  public static yzr a(int paramInt, Entity paramEntity, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new zap(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 5) {
      return new zae(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 1) {
      return new zay(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 2) {
      return new zch(paramQQAppInterface, paramContext, paramEntity, 2);
    }
    if (paramInt == 3) {
      return new zch(paramQQAppInterface, paramContext, paramEntity, 3);
    }
    if (paramInt == 4) {
      return new zap(paramQQAppInterface, paramContext, paramEntity);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzq
 * JD-Core Version:    0.7.0.1
 */