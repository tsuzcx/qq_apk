package oicq.wlogin_sdk.quicklogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class d
  implements DialogInterface.OnClickListener
{
  d(c paramc, SslErrorHandler paramSslErrorHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QuickLoginWebViewLoader.sslErrorProcessed = true;
    this.a.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.d
 * JD-Core Version:    0.7.0.1
 */