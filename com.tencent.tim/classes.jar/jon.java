import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class jon
{
  public jon a;
  public SharedPreferences mPref;
  
  public jon(SharedPreferences paramSharedPreferences, jon paramjon)
  {
    this.mPref = paramSharedPreferences;
    this.a = paramjon;
  }
  
  public static boolean cR(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean y(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public abstract JSONArray a(String paramString);
  
  public int c(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      if (paramBoolean2) {
        j = 2;
      }
      return j | i;
    }
  }
  
  public abstract String getExt();
  
  public abstract int h(String paramString1, String paramString2);
  
  public abstract String hH();
  
  public abstract String hI();
  
  public abstract JSONObject i()
    throws JSONException;
  
  public abstract boolean isEnabled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jon
 * JD-Core Version:    0.7.0.1
 */