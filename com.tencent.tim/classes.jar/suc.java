import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.sdk.WebView;

class suc
  implements jqh
{
  suc(stw paramstw) {}
  
  public void doRefresh()
  {
    Object localObject = this.this$0.mRuntime.getActivity();
    if (localObject == null) {}
    for (;;)
    {
      return;
      aqzv localaqzv = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
      if ((localaqzv != null) && ((localaqzv instanceof ardm.c)) && (((ardm.c)localaqzv).getTopActivity() != localObject))
      {
        localObject = this.this$0.mRuntime.getWebView();
        if (localObject != null) {
          try
          {
            localaqzv = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
            if ((localaqzv instanceof ardm.o))
            {
              ((WebView)localObject).loadUrl(((ardm.o)localaqzv).getCurrentUrl());
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
    paramString = this.this$0.mCheckupHandler.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.this$0.mCheckupHandler.sendMessage(paramString);
  }
  
  public void progress(int paramInt)
  {
    Message localMessage = this.this$0.mCheckupHandler.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.this$0.mCheckupHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */