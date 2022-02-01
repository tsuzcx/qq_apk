import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class urf
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static urf jdField_a_of_type_Urf;
  
  public static urf a()
  {
    if (jdField_a_of_type_Urf == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Urf == null) {
        jdField_a_of_type_Urf = new urf();
      }
      return jdField_a_of_type_Urf;
    }
  }
  
  public int a(urg paramurg, uqx paramuqx)
  {
    if (paramurg == null) {}
    for (;;)
    {
      return 1000004;
      paramurg.a(paramuqx);
      paramurg.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), uri.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((urj)paramuqx);
        localWeishiIntent.putExtra("timeout", paramurg.f);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramuqx = BaseApplicationImpl.getApplication().getRuntime();
          if (paramuqx != null)
          {
            paramuqx.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramurg.uniKey() + ", pkgId=" + paramurg.a() + " submit to MSF, isLogin: " + paramuqx.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramurg)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramurg.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */