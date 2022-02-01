package btmsdkobf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Map;

public class ej
{
  private SharedPreferences oq;
  
  public ej(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
      this.oq = paramContext.getSharedPreferences(paramString, 0);
    }
  }
  
  public void clear()
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public Map<String, ?> getAll()
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return paramBoolean;
    }
    return localSharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return paramFloat;
    }
    return localSharedPreferences.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return paramInt;
    }
    return localSharedPreferences.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return paramLong;
    }
    return localSharedPreferences.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return paramString2;
    }
    return localSharedPreferences.getString(paramString1, paramString2);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.oq;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void putInt(String paramString, int paramInt)
  {
    Object localObject = this.oq;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void putLong(String paramString, long paramLong)
  {
    Object localObject = this.oq;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    Object localObject = this.oq;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void remove(String paramString)
  {
    SharedPreferences localSharedPreferences = this.oq;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().remove(paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ej
 * JD-Core Version:    0.7.0.1
 */