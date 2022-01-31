import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.viewplugin.ViewPluginManager.1;
import com.tencent.biz.viewplugin.ViewPluginManager.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class xjm
{
  SharedPreferences a;
  public BaseActivity a;
  public ClassLoader a;
  public String a;
  public HashMap<String, Class> a;
  public xjh a;
  public String b;
  String c = null;
  public String d;
  
  public xjm(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.c = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir() + paramString3);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPreferences(0);
  }
  
  public static boolean a(View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      Method localMethod = paramView.getClass().getMethod("setData", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[] { paramString });
      return true;
    }
    catch (Exception paramView)
    {
      ThreadManager.post(new ViewPluginManager.1(paramView), 2, null, true);
    }
    return false;
  }
  
  public View a(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {}
    for (;;)
    {
      try
      {
        Class localClass = this.jdField_a_of_type_JavaLangClassLoader.loadClass(paramString);
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.b + " not find view:" + paramString);
          }
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject = null;
        continue;
        if (this.jdField_a_of_type_Xjh == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.b + " plugin context is null");
          }
          return null;
        }
        try
        {
          paramString = (View)localObject.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_Xjh });
          return paramString;
        }
        catch (Exception paramString)
        {
          return null;
        }
      }
      Object localObject = null;
    }
  }
  
  public String a(String paramString)
  {
    return "sp_key_plugin_view_version_" + paramString;
  }
  
  public void a()
  {
    ThreadManager.post(new ViewPluginManager.3(this), 8, null, true);
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      Method localMethod = paramString.getClass().getMethod("destory", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramString, new Object[0]);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(mzc parammzc, boolean paramBoolean)
  {
    String str = "http://" + this.b + "?_bid=" + this.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginManager", 2, "loadPlugin:" + this.b + "mBid:" + this.jdField_a_of_type_JavaLangString);
    }
    mze.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      mze.a = bool;
      a();
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
      long l = System.currentTimeMillis();
      if ((!mze.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, new xjn(this, l, localContext, paramBoolean, parammzc))) && (QLog.isColorLevel())) {
        QLog.i("ViewPluginManager", 2, "plugin:" + this.b + " transToLocalUrl: return false");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */