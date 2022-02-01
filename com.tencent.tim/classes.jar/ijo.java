import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public abstract class ijo
{
  protected static final String[] aL = { "MANAGER_ZIMU", "MANAGER_FILTER", "MANAGER_PENDANT", "MANAGER_FACE", "MANAGER_NODE_REPORTER", "MANAGER_SUPPORT", "MANAGER_REDPACKET", "MANAGER_REDPACKET_Entry", "MANAGER_EFFECT_OPERATE", "MANAGER_ZIMU_LIVE", "MANAGER_Voice_Recog", "MANAGER_Tips", "MANAGER_mutex", "MANAGER_MAKEUP", "MANAGER_VIRTUAL_BG" };
  public final String TAG;
  public VideoAppInterface mApp;
  
  protected ijo(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.TAG = (getClass().getSimpleName() + "_" + AudioHelper.hG());
  }
  
  public static void a(String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (paramInt < aL.length))
    {
      String str = "Business_" + aL[paramInt];
      paramContext = aqmj.k(paramContext).edit();
      paramContext.putBoolean(str, paramBoolean);
      paramContext.commit();
      igd.aL(paramString, "setPreload zzzzz  bid=" + paramInt);
      return;
    }
    igd.aL(paramString, "setPreload ERROR : bid=" + paramInt);
  }
  
  static boolean a(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (paramInt < aL.length))
    {
      String str = "Business_" + aL[paramInt];
      boolean bool = aqmj.k(paramVideoAppInterface.getApplication()).getBoolean(str, false);
      igd.aJ(paramString, "isPreloaded:" + str + "|" + bool);
      return bool;
    }
    igd.aL(paramString, "isPreloaded ERROR : bid=" + paramInt);
    return false;
  }
  
  protected void U(String paramString, boolean paramBoolean) {}
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  protected abstract boolean cs(String paramString);
  
  protected abstract void onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijo
 * JD-Core Version:    0.7.0.1
 */