import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class zaa
  implements ndj
{
  zaa(yzu paramyzu) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bebx localbebx = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbebx != null) && ((localbebx instanceof begy)) && (((begy)localbebx).b() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbebx = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbebx instanceof behk))
            {
              ((WebView)localObject).loadUrl(((behk)localbebx).b());
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
 * Qualified Name:     zaa
 * JD-Core Version:    0.7.0.1
 */