import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class zep
  implements ndj
{
  zep(zej paramzej) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      begg localbegg = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbegg != null) && ((localbegg instanceof belh)) && (((belh)localbegg).b() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbegg = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbegg instanceof belt))
            {
              ((WebView)localObject).loadUrl(((belt)localbegg).b());
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.a.a.sendMessage(paramString);
  }
  
  public void progress(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zep
 * JD-Core Version:    0.7.0.1
 */