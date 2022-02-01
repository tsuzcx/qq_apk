import android.text.TextUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.manager.Manager;

public class afch
  implements Manager
{
  public static long Xf;
  public static long Xg;
  public static long timestamp;
  protected EntityManager mEntityManager;
  
  public static void c(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!ajrk.ary())
    {
      ajrb.c(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      ajrb.c(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      ajrb.c(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    Xf = paramLong1;
    Xg = paramLong2;
    timestamp = paramLong3;
  }
  
  public void onDestroy()
  {
    if (this.mEntityManager != null) {}
    try
    {
      this.mEntityManager.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afch
 * JD-Core Version:    0.7.0.1
 */