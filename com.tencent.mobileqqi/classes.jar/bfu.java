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

public class bfu
  implements HttpRequestRetryHandler
{
  private static final int jdField_a_of_type_Int = 1500;
  private static HashSet jdField_a_of_type_JavaUtilHashSet;
  private static HashSet jdField_b_of_type_JavaUtilHashSet;
  private final int jdField_b_of_type_Int;
  
  static
  {
    a = new HashSet();
    jdField_b_of_type_JavaUtilHashSet = new HashSet();
    a.add(NoHttpResponseException.class);
    a.add(UnknownHostException.class);
    a.add(SocketException.class);
    jdField_b_of_type_JavaUtilHashSet.add(InterruptedIOException.class);
    jdField_b_of_type_JavaUtilHashSet.add(SSLException.class);
  }
  
  public bfu(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected boolean a(HashSet paramHashSet, Throwable paramThrowable)
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
      if (paramInt <= this.jdField_b_of_type_Int) {
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
          if (a(jdField_b_of_type_JavaUtilHashSet, paramIOException))
          {
            bool1 = false;
            break label83;
          }
          if (a(a, paramIOException))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bfu
 * JD-Core Version:    0.7.0.1
 */