package okhttp3;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

class OkUrlFactory$1
  extends URLStreamHandler
{
  OkUrlFactory$1(OkUrlFactory paramOkUrlFactory, String paramString) {}
  
  protected int getDefaultPort()
  {
    if (this.val$protocol.equals("http")) {
      return 80;
    }
    if (this.val$protocol.equals("https")) {
      return 443;
    }
    throw new AssertionError();
  }
  
  protected URLConnection openConnection(URL paramURL)
  {
    return this.this$0.open(paramURL);
  }
  
  protected URLConnection openConnection(URL paramURL, Proxy paramProxy)
  {
    return this.this$0.open(paramURL, paramProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.OkUrlFactory.1
 * JD-Core Version:    0.7.0.1
 */