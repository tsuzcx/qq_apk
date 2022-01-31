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
    if (this.oq == null) {
      return;
    }
    this.oq.edit().clear().commit();
  }
  
  public Map getAll()
  {
    if (this.oq == null) {
      return null;
    }
    return this.oq.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (this.oq == null) {
      return paramBoolean;
    }
    return this.oq.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    if (this.oq == null) {
      return paramFloat;
    }
    return this.oq.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    if (this.oq == null) {
      return paramInt;
    }
    return this.oq.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    if (this.oq == null) {
      return paramLong;
    }
    return this.oq.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (this.oq == null) {
      return paramString2;
    }
    return this.oq.getString(paramString1, paramString2);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    if (this.oq == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.oq.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public void putInt(String paramString, int paramInt)
  {
    if (this.oq == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.oq.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public void putLong(String paramString, long paramLong)
  {
    if (this.oq == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.oq.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    if (this.oq == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.oq.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void remove(String paramString)
  {
    if (this.oq == null) {
      return;
    }
    this.oq.edit().remove(paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ej
 * JD-Core Version:    0.7.0.1
 */