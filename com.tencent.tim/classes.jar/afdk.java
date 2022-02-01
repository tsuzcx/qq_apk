import android.content.Context;

public class afdk
  extends ivl
{
  public static boolean Q(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, "TencentDoc_USER_" + paramString, false);
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean)
  {
    setBoolean(paramContext, "TencentDoc_USER_" + paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdk
 * JD-Core Version:    0.7.0.1
 */