import android.graphics.drawable.Drawable;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class awea
  implements InvocationHandler
{
  public awea(LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramMethod.getName().equals("onFailed")) {
      if (this.a != null) {
        this.a.onFailed();
      }
    }
    for (;;)
    {
      return null;
      if ((paramMethod.getName().equals("onLoaded")) && (this.a != null)) {
        this.a.onLoaded((Drawable)paramArrayOfObject[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awea
 * JD-Core Version:    0.7.0.1
 */