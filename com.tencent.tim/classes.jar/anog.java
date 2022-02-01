import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class anog
{
  public static void G(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).edit();
    paramContext.putBoolean("SUPPORT_MTA", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean l(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).getBoolean("SUPPORT_MTA", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anog
 * JD-Core Version:    0.7.0.1
 */