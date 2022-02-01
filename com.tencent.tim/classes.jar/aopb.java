import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class aopb
{
  public static long Wk = -1L;
  public static long Wl = -1L;
  
  private static void bd(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadFileSizeLimit", 2, "setLimit:" + paramString + " size:" + paramLong);
    }
  }
  
  public static long hm()
  {
    if (Wk < 0L)
    {
      Wk = j("SP_KEY_C2C_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitC2C:" + Wk);
      }
    }
    return Wk;
  }
  
  public static long hn()
  {
    if (Wl < 0L)
    {
      Wl = j("SP_KEY_GROUP_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitGroup:" + Wl);
      }
    }
    return Wl;
  }
  
  private static long j(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString, -1L);
    }
    if (l < 0L) {
      return paramLong;
    }
    return l;
  }
  
  public static void lH(long paramLong)
  {
    bd("SP_KEY_C2C_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      Wk = paramLong;
    }
  }
  
  public static void lI(long paramLong)
  {
    bd("SP_KEY_GROUP_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      Wl = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopb
 * JD-Core Version:    0.7.0.1
 */