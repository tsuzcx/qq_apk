import android.content.Context;

public class afdg
  extends ivl
{
  public static long e(Context paramContext, String paramString)
  {
    return getLong(paramContext, "TencentDocGrayTips_LastShowTime_" + paramString, 0L);
  }
  
  public static void k(Context paramContext, String paramString, long paramLong)
  {
    setLong(paramContext, "TencentDocGrayTips_LastShowTime_" + paramString, paramLong);
  }
  
  public static void s(Context paramContext, String paramString, int paramInt)
  {
    setInt(paramContext, "TencentDocGrayTips_ShowTimes_" + paramString, paramInt);
  }
  
  public static int x(Context paramContext, String paramString)
  {
    return getInt(paramContext, "TencentDocGrayTips_ShowTimes_" + paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdg
 * JD-Core Version:    0.7.0.1
 */