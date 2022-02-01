import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;

public class oba
{
  private static final String TAG = oba.class.getName();
  private static oba a;
  private Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
  
  public static oba a()
  {
    if (a == null) {
      a = new oba();
    }
    return a;
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {}
    try
    {
      return paramClass.newInstance();
    }
    catch (JsonSyntaxException paramString)
    {
      Log.e(TAG, "form json error.");
      return null;
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz new instance instantiation error.");
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz IllegalAccessException error.");
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz NumberFormatException error.");
      }
    }
    paramString = this.gson.fromJson(paramString, paramClass);
    return paramString;
  }
  
  public String toJson(Object paramObject)
  {
    return this.gson.toJson(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oba
 * JD-Core Version:    0.7.0.1
 */