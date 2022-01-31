import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.videostory.config.VSConfigManager.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class xfo
  implements Manager
{
  public static String a;
  private static xfo jdField_a_of_type_Xfo;
  public static String b = "1";
  public static final String c = ajya.a(2131716877);
  protected SharedPreferences a;
  private ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "0";
  }
  
  private xfo()
  {
    b();
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static xfo a()
  {
    if (jdField_a_of_type_Xfo == null) {}
    try
    {
      if (jdField_a_of_type_Xfo == null) {
        jdField_a_of_type_Xfo = new xfo();
      }
      return jdField_a_of_type_Xfo;
    }
    finally {}
  }
  
  private <V> V b(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject;
    if (paramV.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "get value from sp success : K:" + paramString + ", V : " + localObject);
      if ((localObject == null) || (localObject.getClass() != paramV.getClass())) {
        return paramV;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
      return localObject;
      if (paramV.getClass() == Long.class)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, ((Long)paramV).longValue()));
      }
      else if (paramV.getClass() == String.class)
      {
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        localObject = Boolean.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
      }
    }
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
    return paramV;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
    ThreadManager.executeOnSubThread(new VSConfigManager.1(this));
  }
  
  private <V> void b(String paramString, V paramV)
  {
    boolean bool;
    if (paramV.getClass() == Integer.class) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    while (!bool)
    {
      QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into sp error : K:" + paramString + ", V : " + paramV);
      return;
      if (paramV.getClass() == Long.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
      } else if (paramV.getClass() == String.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString, (String)paramV).commit();
      } else if (paramV.getClass() == Boolean.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
      } else {
        throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
      }
    }
    QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into sp success : K:" + paramString + ", V : " + paramV);
  }
  
  public <V> V a(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject = paramString + "_" + a();
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject)))
    {
      localObject = b((String)localObject, paramV);
      return localObject;
    }
    if (paramV.getClass() == Integer.class) {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "get value : K : " + (String)localObject + ", V : " + paramString);
      if (paramString != null)
      {
        localObject = paramString;
        if (paramString.getClass() == paramV.getClass()) {
          break;
        }
      }
      return paramV;
      if (paramV.getClass() == Long.class)
      {
        paramString = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      }
      else if (paramV.getClass() == String.class)
      {
        paramString = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break label212;
        }
        paramString = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      }
    }
    label212:
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
  }
  
  public void a()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
    a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false));
  }
  
  public <V> void a(String paramString, V paramV)
  {
    paramString = paramString + "_" + a();
    if (paramV.getClass() == Integer.class) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Integer)paramV);
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into map success :  K:" + paramString + ", V : " + paramV);
      b(paramString, paramV);
      return;
      if (paramV.getClass() == Long.class)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Long)paramV);
      }
      else if (paramV.getClass() == String.class)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Boolean)paramV);
      }
    }
    QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into map error : K:" + paramString + ", V : " + paramV);
    throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
  }
  
  public boolean a()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyStyleConfig:" + bool);
    return bool;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = ((Boolean)a().a(paramString, Boolean.valueOf(true))).booleanValue();
    if (LocalMultiProcConfig.getLong4Uin("need_show_story_tips", 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1 & bool2;
      QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "needShowGuideTips:" + bool2);
      return bool2;
    }
  }
  
  public boolean b()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyWidgetConfig:" + bool);
    return bool;
  }
  
  public void onDestroy()
  {
    QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfo
 * JD-Core Version:    0.7.0.1
 */