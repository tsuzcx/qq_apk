import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class uuy
  implements uvi
{
  protected SharedPreferences a;
  protected AtomicBoolean a;
  
  public uuy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(@Nullable String paramString1, @Nullable Object paramObject, @Nullable String paramString2)
  {
    paramString2 = new StringBuilder().append("key=").append(paramString1).append(" expected ").append(paramString2).append(" but value was ");
    if (paramObject == null) {}
    for (paramString1 = "null";; paramString1 = paramObject.getClass().getName())
    {
      wxe.d("ConfigManager", paramString1);
      return;
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IllegalStateException("have not attachContext");
    }
  }
  
  public <V> V a(@NonNull String paramString, @NonNull V paramV)
  {
    c();
    Object localObject;
    if (paramV.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    for (;;)
    {
      wxe.b("ConfigManager", "get value : K : %s, V : %s", paramString, localObject);
      if ((localObject == null) || (localObject.getClass() != paramV.getClass())) {
        break label183;
      }
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
    label183:
    a(paramString, localObject, paramV.getClass().getName());
    return paramV;
  }
  
  public void a()
  {
    wxe.b("ConfigManager", "onInit");
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      wxe.b("ConfigManager", "attachContext, " + paramContext);
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("qqstory_config", 4);
      return;
    }
    wxe.d("ConfigManager", "attachContext duplicate");
  }
  
  public void a(String paramString)
  {
    c();
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove(paramString).commit())
    {
      wxe.e("ConfigManager", "remove value error : K:%s.", new Object[] { paramString });
      return;
    }
    wxe.b("ConfigManager", "remove value success :  K:%s.", paramString);
  }
  
  public <V> void a(String paramString, V paramV)
  {
    c();
    boolean bool;
    if (paramV.getClass() == Integer.class) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    while (!bool)
    {
      wxe.e("ConfigManager", "set value error : K:%s, V:%s .", new Object[] { paramString, paramV });
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
    wxe.b("ConfigManager", "set value success :  K:%s, V:%s .", paramString, paramV);
  }
  
  public void b()
  {
    wxe.b("ConfigManager", "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuy
 * JD-Core Version:    0.7.0.1
 */