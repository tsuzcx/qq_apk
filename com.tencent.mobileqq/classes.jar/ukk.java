import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class ukk
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ukk jdField_a_of_type_Ukk;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static ukk a()
  {
    if (jdField_a_of_type_Ukk == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ukk == null) {
        jdField_a_of_type_Ukk = new ukk();
      }
      return jdField_a_of_type_Ukk;
    }
  }
  
  public int a(ukl paramukl, ukc paramukc)
  {
    if (paramukl == null) {}
    for (;;)
    {
      return 1000004;
      paramukl.a(paramukc);
      paramukl.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), ukn.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((uko)paramukc);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramukc = BaseApplicationImpl.getApplication().getRuntime();
          if (paramukc != null)
          {
            paramukc.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramukl.uniKey() + ", pkgId=" + paramukl.a() + " submit to MSF, isLogin: " + paramukc.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramukl)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramukl.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukk
 * JD-Core Version:    0.7.0.1
 */