import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class aryc
{
  public static String Dz()
  {
    if (aroi.a().getContext() == null) {
      return "";
    }
    return getPreferences().getString("uin", "");
  }
  
  public static int Nj()
  {
    int j = arxs.a(aroi.a().getContext(), null).getInt("Common_BusinessReportMaxcount");
    int i = j;
    if (j == 0) {
      i = 20;
    }
    return i;
  }
  
  public static int Nk()
  {
    int j = arxs.a(aroi.a().getContext(), null).getInt("Common_HttpRetryCount");
    int i = j;
    if (j == 0) {
      i = 2;
    }
    return i;
  }
  
  public static void Xq(String paramString)
  {
    if (aroi.a().getContext() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putString("uin", paramString);
    localEditor.commit();
  }
  
  public static void bd(long paramLong)
  {
    if (aroi.a().getContext() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putLong("lastTime", paramLong);
    localEditor.commit();
  }
  
  public static int fD(String paramString)
  {
    int j = arxs.a(aroi.a().getContext(), paramString).getInt("Common_BusinessReportFrequency");
    int i = j;
    if (j == 0) {
      i = 100;
    }
    return i;
  }
  
  public static long getLastReportTime()
  {
    return aroi.a().getContext().getSharedPreferences("reportConfig", 0).getLong("lastTime", 0L);
  }
  
  protected static SharedPreferences getPreferences()
  {
    return aroi.a().getContext().getSharedPreferences("reportConfig", 0);
  }
  
  public static long ic()
  {
    long l2 = arxs.a(aroi.a().getContext(), null).getLong("Common_BusinessReportTimeinterval");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 3600L;
    }
    return l1;
  }
  
  public static int kQ(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = arxs.a(aroi.a().getContext(), null).getInt("Common_ViaSuccessRatioFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        paramInt = 20;
      }
    }
    do
    {
      return paramInt;
      i = arxs.a(aroi.a().getContext(), null).getInt("Common_ViaSuccessRatioFrequencyFail");
      paramInt = i;
    } while (i != 0);
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryc
 * JD-Core Version:    0.7.0.1
 */