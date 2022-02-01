import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper.1;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import mqq.app.AppRuntime;

public class shp
{
  private static volatile shp a;
  private Map<String, Timer> gq = new HashMap();
  
  public static shp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new shp();
      }
      return a;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString, shp.a parama)
  {
    paramContext = sho.e(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(gC(paramString), 0);
      if (parama != null) {
        parama.yl(i + 1);
      }
    }
  }
  
  private String gC(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return paramString + "_" + str;
  }
  
  public void a(Context paramContext, String paramString, int paramInt, shp.a parama)
  {
    if (paramInt > 0)
    {
      tg(paramString);
      Timer localTimer = new Timer();
      localTimer.schedule(new TimeAndCountHelper.1(this, paramContext, paramString, parama), paramInt);
      this.gq.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, parama);
  }
  
  @SuppressLint({"NewApi"})
  public void j(Context paramContext, String paramString, int paramInt)
  {
    paramContext = sho.e(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = gC(paramString);
    localEditor.putInt(paramString, paramContext.getInt(paramString, 0) + paramInt);
    localEditor.apply();
  }
  
  public int r(Context paramContext, String paramString)
  {
    return sho.e(paramContext).getInt(gC(paramString), 0);
  }
  
  public void tg(String paramString)
  {
    Timer localTimer = (Timer)this.gq.get(paramString);
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
      this.gq.remove(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void yl(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shp
 * JD-Core Version:    0.7.0.1
 */