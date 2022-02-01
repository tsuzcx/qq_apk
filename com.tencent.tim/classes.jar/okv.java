import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class okv
{
  private static okv a;
  private static Object lock = new Object();
  private String wd = "WeishiNewService";
  
  public static okv a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new okv();
      }
      return a;
    }
  }
  
  public int a(okw paramokw, okn paramokn)
  {
    if (paramokw == null) {}
    for (;;)
    {
      return 1000004;
      paramokw.a(paramokn);
      paramokw.startTime = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), oky.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((okz)paramokn);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramokn = BaseApplicationImpl.getApplication().getRuntime();
          if (paramokn != null)
          {
            paramokn.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramokw.uniKey() + ", pkgId=" + paramokw.getRequestPkgId() + " submit to MSF, isLogin: " + paramokn.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramokw)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramokw.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okv
 * JD-Core Version:    0.7.0.1
 */