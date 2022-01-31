import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class xck
  implements mpp
{
  xck(xce paramxce) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bazo localbazo = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbazo != null) && ((localbazo instanceof bbej)) && (((bbej)localbazo).b() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbazo = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbazo instanceof bbev))
            {
              ((WebView)localObject).loadUrl(((bbev)localbazo).b());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xck
 * JD-Core Version:    0.7.0.1
 */