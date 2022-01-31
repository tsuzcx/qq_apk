package com.tencent.biz.viewplugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import mqq.app.AppRuntime;
import rp;
import rq;

public class ViewPluginManager
{
  public static final String a = "ViewPluginManager";
  public ViewPluginContext a;
  public BaseActivity a;
  public ClassLoader a;
  public HashMap a;
  public String b;
  public String c;
  
  public ViewPluginManager(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
      paramView.printStackTrace();
    }
    return false;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        Class localClass = this.jdField_a_of_type_JavaLangClassLoader.loadClass("com.tencent.biz.lebsearch.widget.SearchViewBuilder");
        if (localClass != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViewPluginManager", 2, "plugin:" + this.c + " not find view:" + paramInt);
        }
        return null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      localObject = null;
    }
    if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "plugin:" + this.c + " plugin context is null");
      }
      return null;
    }
    try
    {
      localObject = ((Class)localObject).getMethod("getView", new Class[] { Context.class, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      localObject = (View)((Method)localObject).invoke(null, new Object[] { this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext, Integer.valueOf(paramInt) });
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public View a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      paramString2 = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    }
    for (;;)
    {
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ViewPluginManager", 2, "plugin:" + this.c + " not find view:" + paramString1);
        }
        return null;
        if (this.jdField_a_of_type_JavaLangClassLoader == null) {}
      }
      else
      {
        try
        {
          paramString2 = this.jdField_a_of_type_JavaLangClassLoader.loadClass(paramString2);
          try
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
          }
          catch (ClassNotFoundException localClassNotFoundException1) {}
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          for (;;)
          {
            paramString2 = null;
          }
        }
        localClassNotFoundException1.printStackTrace();
        continue;
        if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.c + " plugin context is null");
          }
          return null;
        }
        try
        {
          paramString2 = (View)paramString2.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext });
          return paramString2;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.c + " view:" + paramString1 + " newInstance failed!");
          }
          return null;
        }
      }
      paramString2 = null;
    }
  }
  
  public void a()
  {
    String str = "http://test.qq.com/index?_bid=" + this.b;
    b();
    long l = System.currentTimeMillis();
    if ((!HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, new rp(this, l))) && (QLog.isColorLevel())) {
      QLog.i("ViewPluginManager", 2, "plugin:" + this.c + " transToLocalUrl: return false");
    }
  }
  
  public void b()
  {
    String str = "http://test.qq.com/index?_bid=" + this.b;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), new rq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager
 * JD-Core Version:    0.7.0.1
 */