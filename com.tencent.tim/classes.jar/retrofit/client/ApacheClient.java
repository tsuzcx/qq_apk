package retrofit.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedOutput;

public class ApacheClient
  implements Client
{
  private final HttpClient client;
  
  public ApacheClient()
  {
    this(createDefaultClient());
  }
  
  public ApacheClient(HttpClient paramHttpClient)
  {
    this.client = paramHttpClient;
  }
  
  private static HttpClient createDefaultClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
  
  static HttpUriRequest createRequest(Request paramRequest)
  {
    if (paramRequest.getBody() != null) {
      return new GenericEntityHttpRequest(paramRequest);
    }
    return new GenericHttpRequest(paramRequest);
  }
  
  static Response parseResponse(String paramString, HttpResponse paramHttpResponse)
    throws IOException
  {
    Object localObject1 = paramHttpResponse.getStatusLine();
    int j = ((StatusLine)localObject1).getStatusCode();
    String str2 = ((StatusLine)localObject1).getReasonPhrase();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHttpResponse.getAllHeaders();
    int k = localObject2.length;
    int i = 0;
    localObject1 = "application/octet-stream";
    while (i < k)
    {
      str1 = localObject2[i];
      String str3 = str1.getName();
      str1 = str1.getValue();
      if ("Content-Type".equalsIgnoreCase(str3)) {
        localObject1 = str1;
      }
      localArrayList.add(new Header(str3, str1));
      i += 1;
    }
    String str1 = null;
    localObject2 = paramHttpResponse.getEntity();
    paramHttpResponse = str1;
    if (localObject2 != null) {
      paramHttpResponse = new TypedByteArray((String)localObject1, EntityUtils.toByteArray((HttpEntity)localObject2));
    }
    return new Response(paramString, j, str2, localArrayList, paramHttpResponse);
  }
  
  protected HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    return paramHttpClient.execute(paramHttpUriRequest);
  }
  
  public Response execute(Request paramRequest)
    throws IOException
  {
    Object localObject = createRequest(paramRequest);
    localObject = execute(this.client, (HttpUriRequest)localObject);
    return parseResponse(paramRequest.getUrl(), (HttpResponse)localObject);
  }
  
  static class GenericEntityHttpRequest
    extends HttpEntityEnclosingRequestBase
  {
    private final String method;
    
    GenericEntityHttpRequest(Request paramRequest)
    {
      this.method = paramRequest.getMethod();
      setURI(URI.create(paramRequest.getUrl()));
      Iterator localIterator = paramRequest.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        addHeader(new BasicHeader(localHeader.getName(), localHeader.getValue()));
      }
      setEntity(new ApacheClient.TypedOutputEntity(paramRequest.getBody()));
    }
    
    public String getMethod()
    {
      return this.method;
    }
  }
  
  static class GenericHttpRequest
    extends HttpRequestBase
  {
    private final String method;
    
    public GenericHttpRequest(Request paramRequest)
    {
      this.method = paramRequest.getMethod();
      setURI(URI.create(paramRequest.getUrl()));
      paramRequest = paramRequest.getHeaders().iterator();
      while (paramRequest.hasNext())
      {
        Header localHeader = (Header)paramRequest.next();
        addHeader(new BasicHeader(localHeader.getName(), localHeader.getValue()));
      }
    }
    
    public String getMethod()
    {
      return this.method;
    }
  }
  
  static class TypedOutputEntity
    extends AbstractHttpEntity
  {
    final TypedOutput typedOutput;
    
    TypedOutputEntity(TypedOutput paramTypedOutput)
    {
      this.typedOutput = paramTypedOutput;
      setContentType(paramTypedOutput.mimeType());
    }
    
    public InputStream getContent()
      throws IOException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      this.typedOutput.writeTo(localByteArrayOutputStream);
      return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
    }
    
    public long getContentLength()
    {
      return this.typedOutput.length();
    }
    
    public boolean isRepeatable()
    {
      return true;
    }
    
    public boolean isStreaming()
    {
      return false;
    }
    
    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      this.typedOutput.writeTo(paramOutputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.ApacheClient
 * JD-Core Version:    0.7.0.1
 */