package wf7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.wifisdk.services.common.api.e;
import java.util.Map;

public class hh
  implements e
{
  private SharedPreferences tf;
  private SharedPreferences.Editor tg;
  private boolean th = false;
  
  public hh(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wfsdk_");
    localStringBuilder.append(paramString);
    this.tf = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private SharedPreferences.Editor getEditor()
  {
    if (this.tg == null) {
      this.tg = this.tf.edit();
    }
    return this.tg;
  }
  
  public boolean L(String paramString)
  {
    return getEditor().remove(paramString).commit();
  }
  
  public boolean a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = getEditor();
    localEditor.putLong(paramString, paramLong);
    if (!this.th) {
      return localEditor.commit();
    }
    return true;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getEditor();
    localEditor.putString(paramString1, paramString2);
    if (!this.th) {
      return localEditor.commit();
    }
    return true;
  }
  
  public void beginTransaction()
  {
    this.th = true;
  }
  
  public boolean e(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getEditor();
    localEditor.putBoolean(paramString, paramBoolean);
    if (!this.th) {
      return localEditor.commit();
    }
    return true;
  }
  
  public boolean eQ()
  {
    this.th = false;
    SharedPreferences.Editor localEditor = this.tg;
    if (localEditor != null) {
      return localEditor.commit();
    }
    return true;
  }
  
  public Map<String, ?> getAll()
  {
    return this.tf.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.tf.getBoolean(paramString, paramBoolean);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.tf.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.tf.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return this.tf.getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.tf.getString(paramString1, paramString2);
  }
  
  public boolean m(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = getEditor();
    localEditor.putInt(paramString, paramInt);
    if (!this.th) {
      return localEditor.commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hh
 * JD-Core Version:    0.7.0.1
 */