import android.annotation.TargetApi;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class gja
  implements SharedPreferences.Editor
{
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private boolean jdField_a_of_type_Boolean = false;
  
  public gja(MessageCache paramMessageCache, SharedPreferences.Editor paramEditor)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = paramEditor;
  }
  
  @TargetApi(9)
  public void apply()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (Build.VERSION.SDK_INT >= 9) {}
    }
    else
    {
      try
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w(MessageCache.c(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
        }
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(MessageCache.c(), 2, "commit Exception ! ", localException);
        }
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
  }
  
  public SharedPreferences.Editor clear()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.clear();
    return this;
  }
  
  public boolean commit()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return bool;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.w(MessageCache.c(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
      }
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(MessageCache.c(), 2, "commit Exception ! ", localException);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    return false;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(paramString, paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putFloat(paramString, paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(paramString, paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramString, paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(paramString1, paramString2);
    return this;
  }
  
  @Deprecated
  public SharedPreferences.Editor putStringSet(String paramString, Set paramSet)
  {
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gja
 * JD-Core Version:    0.7.0.1
 */