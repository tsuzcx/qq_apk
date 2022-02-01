import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

public class atne
{
  private static volatile atne a;
  private SharedPreferences mSharedPref = BaseApplication.getContext().getSharedPreferences("OfficeCenterAppName", 4);
  
  public static atne a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new atne();
      }
      return a;
    }
    finally {}
  }
  
  public boolean S(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.mSharedPref.edit().putBoolean(paramString, paramBoolean).commit();
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean av(String paramString, int paramInt)
  {
    try
    {
      boolean bool = this.mSharedPref.edit().putInt(paramString, paramInt).commit();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean cl(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.mSharedPref.edit().putString(paramString1, paramString2).commit();
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.mSharedPref.getBoolean(paramString, paramBoolean);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.mSharedPref.getInt(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atne
 * JD-Core Version:    0.7.0.1
 */