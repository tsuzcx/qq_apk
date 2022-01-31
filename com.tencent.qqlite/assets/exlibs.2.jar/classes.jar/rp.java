import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

public class rp
  implements AsyncCallBack
{
  public rp(ViewPluginManager paramViewPluginManager, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + "," + " time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b + "/" + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.c;
    try
    {
      String str1 = HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b;
      String str2 = PluginUtils.getLibPath(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).getCanonicalPath();
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(paramString, str1, str2, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClassLoader());
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, paramString, null);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     rp
 * JD-Core Version:    0.7.0.1
 */