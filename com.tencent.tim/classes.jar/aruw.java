import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

public class aruw
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (aruv)paramMessage.obj;
    } while ((paramMessage == null) || (paramMessage.webView == null) || (paramMessage.cCD == null));
    try
    {
      paramMessage.webView.loadUrl(paramMessage.cCD);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruw
 * JD-Core Version:    0.7.0.1
 */