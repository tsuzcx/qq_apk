import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class iep
  implements HttpRequestInterceptor
{
  iep(ien paramien) {}
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (!paramHttpRequest.containsHeader("Accept-Encoding")) {
      paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }
    paramHttpContext = ien.a(this.a).keySet().iterator();
    while (paramHttpContext.hasNext())
    {
      String str = (String)paramHttpContext.next();
      paramHttpRequest.addHeader(str, (String)ien.a(this.a).get(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iep
 * JD-Core Version:    0.7.0.1
 */