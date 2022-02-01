import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class ier
{
  private Handler handler;
  
  public ier()
  {
    if (Looper.myLooper() != null) {
      this.handler = new ies(this);
    }
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString) {}
  
  public void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    sendMessage(obtainMessage(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  public void a(HttpResponse paramHttpResponse)
  {
    Object localObject3 = null;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    try
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      localObject1 = localObject3;
      if (localHttpEntity != null) {
        localObject1 = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
      }
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        f(localIOException, (String)null);
        localObject2 = localObject3;
      }
      b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), localObject2);
    }
    if (localStatusLine.getStatusCode() >= 300)
    {
      f(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), (String)localObject1);
      return;
    }
  }
  
  public void ahB()
  {
    sendMessage(obtainMessage(2, null));
  }
  
  public void ahC()
  {
    sendMessage(obtainMessage(3, null));
  }
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    sendMessage(obtainMessage(0, new Object[] { new Integer(paramInt), paramArrayOfHeader, paramString }));
  }
  
  protected void c(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    a(paramInt, paramArrayOfHeader, paramString);
  }
  
  public void c(Throwable paramThrowable, String paramString) {}
  
  public void f(Throwable paramThrowable, String paramString)
  {
    sendMessage(obtainMessage(1, new Object[] { paramThrowable, paramString }));
  }
  
  protected void g(Throwable paramThrowable, String paramString)
  {
    c(paramThrowable, paramString);
  }
  
  protected void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (Object[])paramMessage.obj;
      c(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (String)paramMessage[2]);
      return;
    case 1: 
      paramMessage = (Object[])paramMessage.obj;
      g((Throwable)paramMessage[0], (String)paramMessage[1]);
      return;
    case 2: 
      onStart();
      return;
    }
    onFinish();
  }
  
  protected Message obtainMessage(int paramInt, Object paramObject)
  {
    if (this.handler != null) {
      return this.handler.obtainMessage(paramInt, paramObject);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public void onFinish() {}
  
  public void onStart() {}
  
  protected void sendMessage(Message paramMessage)
  {
    if (this.handler != null)
    {
      this.handler.sendMessage(paramMessage);
      return;
    }
    handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ier
 * JD-Core Version:    0.7.0.1
 */