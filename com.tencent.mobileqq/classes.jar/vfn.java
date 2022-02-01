import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class vfn
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vfn jdField_a_of_type_Vfn;
  
  public static vfn a()
  {
    if (jdField_a_of_type_Vfn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vfn == null) {
        jdField_a_of_type_Vfn = new vfn();
      }
      return jdField_a_of_type_Vfn;
    }
  }
  
  public int a(vfo paramvfo, vff paramvff)
  {
    if (paramvfo == null) {}
    for (;;)
    {
      return 1000004;
      paramvfo.a(paramvff);
      paramvfo.a = System.currentTimeMillis();
      try
      {
        WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), vfq.class);
        localWeishiIntent.setWithouLogin(true);
        localWeishiIntent.a = ((vfr)paramvff);
        localWeishiIntent.putExtra("timeout", paramvfo.f);
        if ((localWeishiIntent.a != null) && (localWeishiIntent.a.a != null))
        {
          paramvff = BaseApplicationImpl.getApplication().getRuntime();
          if (paramvff != null)
          {
            paramvff.startServlet(localWeishiIntent);
            Log.i("weishi", "cmd=" + paramvfo.uniKey() + ", pkgId=" + paramvfo.a() + " submit to MSF, isLogin: " + paramvff.isLogin());
          }
          else
          {
            Log.e("weishi", "app is null");
          }
        }
      }
      catch (Exception paramvfo)
      {
        Log.e("weishi", "WeishiProtocolService occur exception. stack=" + paramvfo.getLocalizedMessage());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */