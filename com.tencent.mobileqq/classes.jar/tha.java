import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class tha
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static tha jdField_a_of_type_Tha;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static tha a()
  {
    if (jdField_a_of_type_Tha == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Tha == null) {
        jdField_a_of_type_Tha = new tha();
      }
      return jdField_a_of_type_Tha;
    }
  }
  
  public int a(thb paramthb, tgs paramtgs)
  {
    if (paramthb == null) {}
    for (;;)
    {
      return 1000004;
      paramthb.a(paramtgs);
      paramthb.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), thd.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((the)paramtgs);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramtgs = BaseApplicationImpl.getApplication().getRuntime();
          if (paramtgs != null)
          {
            paramtgs.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramthb.uniKey() + ", pkgId=" + paramthb.a() + " submit to MSF, isLogin: " + paramtgs.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramthb)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramthb.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tha
 * JD-Core Version:    0.7.0.1
 */