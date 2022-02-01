import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Field;

public class aewu
  implements aewt
{
  private Handler sHandler;
  
  public boolean ais()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public Resources d()
  {
    return BaseApplicationImpl.getApplication().getResources();
  }
  
  public Object getField(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public Handler getHandler()
  {
    if (this.sHandler == null) {
      this.sHandler = new Handler(Looper.getMainLooper());
    }
    return this.sHandler;
  }
  
  public boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public boolean isDebug()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewu
 * JD-Core Version:    0.7.0.1
 */