import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class psb
  implements psj
{
  protected AtomicBoolean aJ = new AtomicBoolean(false);
  protected SharedPreferences mSharedPreferences;
  
  private void a(@Nullable String paramString1, @Nullable Object paramObject, @Nullable String paramString2)
  {
    paramString2 = new StringBuilder().append("key=").append(paramString1).append(" expected ").append(paramString2).append(" but value was ");
    if (paramObject == null) {}
    for (paramString1 = "null";; paramString1 = paramObject.getClass().getName())
    {
      ram.w("ConfigManager", paramString1);
      return;
    }
  }
  
  private void checkState()
  {
    if (!this.aJ.get()) {
      throw new IllegalStateException("have not attachContext");
    }
  }
  
  public void attachContext(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    if (this.aJ.compareAndSet(false, true))
    {
      ram.d("ConfigManager", "attachContext, " + paramContext);
      this.mSharedPreferences = paramContext.getSharedPreferences("qqstory_config", 4);
      return;
    }
    ram.w("ConfigManager", "attachContext duplicate");
  }
  
  public <V> V getValue(@NonNull String paramString, @NonNull V paramV)
  {
    checkState();
    Object localObject;
    if (paramV.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.mSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    for (;;)
    {
      ram.d("ConfigManager", "get value : K : %s, V : %s", paramString, localObject);
      if ((localObject == null) || (localObject.getClass() != paramV.getClass())) {
        break label183;
      }
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
    label183:
    a(paramString, localObject, paramV.getClass().getName());
    return paramV;
  }
  
  public <V> void m(String paramString, V paramV)
  {
    checkState();
    boolean bool;
    if (paramV.getClass() == Integer.class) {
      bool = this.mSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    while (!bool)
    {
      ram.e("ConfigManager", "set value error : K:%s, V:%s .", new Object[] { paramString, paramV });
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
    ram.d("ConfigManager", "set value success :  K:%s, V:%s .", paramString, paramV);
  }
  
  public void onDestroy()
  {
    ram.d("ConfigManager", "onDestroy");
  }
  
  public void onInit()
  {
    ram.d("ConfigManager", "onInit");
  }
  
  public void removeValue(String paramString)
  {
    checkState();
    if (!this.mSharedPreferences.edit().remove(paramString).commit())
    {
      ram.e("ConfigManager", "remove value error : K:%s.", new Object[] { paramString });
      return;
    }
    ram.d("ConfigManager", "remove value success :  K:%s.", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psb
 * JD-Core Version:    0.7.0.1
 */