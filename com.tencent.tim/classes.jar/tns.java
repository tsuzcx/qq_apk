import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class tns
{
  private static int bCA = 3600;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ("doOnReconnect".equals(paramString2))
    {
      if (bCA > 0)
      {
        long l1 = PatchSharedPreUtil.getLastTimePullPatchReconnect(BaseApplicationImpl.sApplication);
        long l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) > bCA * 1000L)
        {
          aevk.d(paramQQAppInterface, paramString1, paramInt, paramString2);
          PatchSharedPreUtil.updateLastTimePullPatchReconnect(BaseApplicationImpl.sApplication, l2);
        }
      }
      return;
    }
    aevk.d(paramQQAppInterface, paramString1, paramInt, paramString2);
  }
  
  public static void zz(int paramInt)
  {
    if ((paramInt >= 0) && (bCA != paramInt)) {
      bCA = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tns
 * JD-Core Version:    0.7.0.1
 */