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

public class spp
  implements Manager
{
  private static spp a;
  public static String aFu = "0";
  public static String aFv = "1";
  public static final String aFw = acfp.m(2131716887);
  private ConcurrentHashMap<String, Object> cx = new ConcurrentHashMap();
  protected SharedPreferences mSharedPreferences;
  
  private spp()
  {
    init();
  }
  
  public static spp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new spp();
      }
      return a;
    }
    finally {}
  }
  
  private <V> V e(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject;
    if (paramV.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.mSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "get value from sp success : K:" + paramString + ", V : " + localObject);
      if ((localObject == null) || (localObject.getClass() != paramV.getClass())) {
        return paramV;
      }
      this.cx.put(paramString, localObject);
      return localObject;
      if (paramV.getClass() == Long.class)
      {
        localObject = Long.valueOf(this.mSharedPreferences.getLong(paramString, ((Long)paramV).longValue()));
      }
      else if (paramV.getClass() == String.class)
      {
        localObject = this.mSharedPreferences.getString(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        localObject = Boolean.valueOf(this.mSharedPreferences.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
      }
    }
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
    return paramV;
  }
  
  private void init()
  {
    this.mSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
    ThreadManager.executeOnSubThread(new VSConfigManager.1(this));
  }
  
  private String mw()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  private <V> void s(String paramString, V paramV)
  {
    boolean bool;
    if (paramV.getClass() == Integer.class) {
      bool = this.mSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    while (!bool)
    {
      QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into sp error : K:" + paramString + ", V : " + paramV);
      return;
      if (paramV.getClass() == Long.class) {
        bool = this.mSharedPreferences.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
      } else if (paramV.getClass() == String.class) {
        bool = this.mSharedPreferences.edit().putString(paramString, (String)paramV).commit();
      } else if (paramV.getClass() == Boolean.class) {
        bool = this.mSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
      } else {
        throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
      }
    }
    QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into sp success : K:" + paramString + ", V : " + paramV);
  }
  
  public boolean Ng()
  {
    boolean bool = ((Boolean)a().getValue("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyStyleConfig:" + bool);
    return bool;
  }
  
  public boolean Nh()
  {
    boolean bool = ((Boolean)a().getValue("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyWidgetConfig:" + bool);
    return bool;
  }
  
  public void bzP()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
    a().m("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false));
  }
  
  public boolean fZ(String paramString)
  {
    boolean bool2 = ((Boolean)a().getValue(paramString, Boolean.valueOf(true))).booleanValue();
    if (LocalMultiProcConfig.getLong4Uin("need_show_story_tips", 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1 & bool2;
      QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "needShowGuideTips:" + bool2);
      return bool2;
    }
  }
  
  public <V> V getValue(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject = paramString + "_" + mw();
    if ((this.cx == null) || (!this.cx.containsKey(localObject)))
    {
      localObject = e((String)localObject, paramV);
      return localObject;
    }
    if (paramV.getClass() == Integer.class) {
      paramString = (Integer)this.cx.get(localObject);
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
        paramString = (Long)this.cx.get(localObject);
      }
      else if (paramV.getClass() == String.class)
      {
        paramString = (String)this.cx.get(localObject);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break label214;
        }
        paramString = (Boolean)this.cx.get(localObject);
      }
    }
    label214:
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
  }
  
  public <V> void m(String paramString, V paramV)
  {
    paramString = paramString + "_" + mw();
    if (paramV.getClass() == Integer.class) {
      this.cx.put(paramString, (Integer)paramV);
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into map success :  K:" + paramString + ", V : " + paramV);
      s(paramString, paramV);
      return;
      if (paramV.getClass() == Long.class)
      {
        this.cx.put(paramString, (Long)paramV);
      }
      else if (paramV.getClass() == String.class)
      {
        this.cx.put(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        this.cx.put(paramString, (Boolean)paramV);
      }
    }
    QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into map error : K:" + paramString + ", V : " + paramV);
    throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
  }
  
  public void onDestroy()
  {
    QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spp
 * JD-Core Version:    0.7.0.1
 */