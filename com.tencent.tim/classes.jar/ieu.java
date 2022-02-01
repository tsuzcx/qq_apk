import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class ieu
  implements HttpRequestRetryHandler
{
  private static HashSet<Class<?>> A;
  private static HashSet<Class<?>> z = new HashSet();
  private final int maxRetries;
  
  static
  {
    A = new HashSet();
    z.add(NoHttpResponseException.class);
    z.add(UnknownHostException.class);
    z.add(SocketException.class);
    A.add(InterruptedIOException.class);
    A.add(SSLException.class);
  }
  
  public ieu(int paramInt)
  {
    this.maxRetries = paramInt;
  }
  
  protected boolean a(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext()) {
      if (((Class)paramHashSet.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("Translator", 2, "[retryRequest] exception:" + paramIOException + "executionCount:" + paramInt);
    }
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    boolean bool1;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.maxRetries) {
        break label136;
      }
      bool1 = false;
    }
    for (;;)
    {
      label83:
      if (bool1) {
        if (!((HttpUriRequest)paramHttpContext.getAttribute("http.request")).getMethod().equals("POST")) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          SystemClock.sleep(1500L);
          return bool1;
          i = 0;
          break;
          label136:
          if (a(A, paramIOException))
          {
            bool1 = false;
            break label83;
          }
          if (a(z, paramIOException))
          {
            bool1 = true;
            break label83;
          }
          if (i != 0) {
            break label197;
          }
          bool1 = true;
          break label83;
          bool1 = false;
          continue;
        }
        paramIOException.printStackTrace();
        return bool1;
      }
      label197:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ieu
 * JD-Core Version:    0.7.0.1
 */