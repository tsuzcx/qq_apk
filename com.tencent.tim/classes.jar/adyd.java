import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class adyd
{
  public static adxp c = new adxp(0);
  public static adxp d = new adxp(100000, 2130847896, 2130847897);
  public static adxp e = new adxp(100001, 2130847896, 2130847896);
  
  public static adxp a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramQQAppInterface, paramResources, paramBaseAdapter, true);
  }
  
  public static adxp a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleUtils", 2, "getBubbleInfo, bubbleId=" + paramInt + ", shouldDownload=" + paramBoolean);
    }
    long l = SystemClock.elapsedRealtime();
    if (paramInt == 100000) {
      paramQQAppInterface = e;
    }
    do
    {
      return paramQQAppInterface;
      if (paramInt == 100001) {
        return d;
      }
      if (paramInt < 1) {
        return c;
      }
      paramResources = ((BubbleManager)paramQQAppInterface.getManager(44)).a(paramInt, paramBoolean);
      if (paramResources == null) {
        break;
      }
      paramQQAppInterface = paramResources;
    } while (!QLog.isColorLevel());
    QLog.d("bubble_performance", 2, "getBubbleInfo time " + (SystemClock.elapsedRealtime() - l));
    return paramResources;
    if (QLog.isColorLevel()) {
      QLog.d("bubble_performance", 2, "getBubbleInfo time default" + (SystemClock.elapsedRealtime() - l));
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyd
 * JD-Core Version:    0.7.0.1
 */