import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class ujq
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ujq jdField_a_of_type_Ujq;
  private String jdField_a_of_type_JavaLangString = "WeishiNewService";
  
  public static ujq a()
  {
    if (jdField_a_of_type_Ujq == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ujq == null) {
        jdField_a_of_type_Ujq = new ujq();
      }
      return jdField_a_of_type_Ujq;
    }
  }
  
  public int a(ujr paramujr, uji paramuji)
  {
    if (paramujr == null) {}
    for (;;)
    {
      return 1000004;
      paramujr.a(paramuji);
      paramujr.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), ujt.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((uju)paramuji);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramuji = BaseApplicationImpl.getApplication().getRuntime();
          if (paramuji != null)
          {
            paramuji.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramujr.uniKey() + ", pkgId=" + paramujr.a() + " submit to MSF, isLogin: " + paramuji.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramujr)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramujr.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */