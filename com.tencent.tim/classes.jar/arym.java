import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class arym
{
  public static int getInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return getPreferences4Uin(paramLong).getInt(paramString, paramInt);
  }
  
  public static SharedPreferences getPreferences()
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("OPENSDK_setting", i);
    }
  }
  
  public static SharedPreferences getPreferences4Uin(long paramLong)
  {
    if (paramLong == 0L) {
      return getPreferences();
    }
    String str = arwv.encodeHexStr(String.valueOf(paramLong)) + "_" + "preference";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  public static void putInt4Uin(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = getPreferences4Uin(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arym
 * JD-Core Version:    0.7.0.1
 */