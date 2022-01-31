import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class xlh
  implements nan
{
  xlh(xlb paramxlb) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bccw localbccw = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbccw != null) && ((localbccw instanceof bchx)) && (((bchx)localbccw).b() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbccw = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbccw instanceof bcij))
            {
              ((WebView)localObject).loadUrl(((bcij)localbccw).b());
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
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */