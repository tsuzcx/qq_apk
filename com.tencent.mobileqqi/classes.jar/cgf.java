import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;

public final class cgf
  implements Runnable
{
  public cgf(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = MessageCache.a();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(this.a, String.valueOf(l * 1000L));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgf
 * JD-Core Version:    0.7.0.1
 */