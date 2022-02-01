package retrofit.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class UrlConnectionClient
  implements Client
{
  private static final int CHUNK_SIZE = 4096;
  
  public Response execute(Request paramRequest)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = openConnection(paramRequest);
    prepareRequest(localHttpURLConnection, paramRequest);
    return readResponse(localHttpURLConnection);
  }
  
  protected HttpURLConnection openConnection(Request paramRequest)
    throws IOException
  {
    paramRequest = (HttpURLConnection)new URL(paramRequest.getUrl()).openConnection();
    paramRequest.setConnectTimeout(15000);
    paramRequest.setReadTimeout(20000);
    return paramRequest;
  }
  
  void prepareRequest(HttpURLConnection paramHttpURLConnection, Request paramRequest)
    throws IOException
  {
    paramHttpURLConnection.setRequestMethod(paramRequest.getMethod());
    paramHttpURLConnection.setDoInput(true);
    Iterator localIterator = paramRequest.getHeaders().iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      paramHttpURLConnection.addRequestProperty(localHeader.getName(), localHeader.getValue());
    }
    paramRequest = paramRequest.getBody();
    if (paramRequest != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramRequest.mimeType());
      long l = paramRequest.length();
      if (l == -1L) {
        break label131;
      }
      paramHttpURLConnection.setFixedLengthStreamingMode((int)l);
      paramHttpURLConnection.addRequestProperty("Content-Length", String.valueOf(l));
    }
    for (;;)
    {
      paramRequest.writeTo(paramHttpURLConnection.getOutputStream());
      return;
      label131:
      paramHttpURLConnection.setChunkedStreamingMode(4096);
    }
  }
  
  Response readResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int j = 0;
    int k = paramHttpURLConnection.getResponseCode();
    String str1 = paramHttpURLConnection.getResponseMessage();
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        str2 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(new Header(str2, (String)((Iterator)localObject2).next()));
        }
      }
      String str2 = paramHttpURLConnection.getContentType();
      int m = paramHttpURLConnection.getContentLength();
      Header localHeader;
      int i;
      if (k >= 400)
      {
        localObject1 = paramHttpURLConnection.getErrorStream();
        localObject2 = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localHeader = (Header)((Iterator)localObject2).next();
            if ((localHeader.getName() != null) && ("content-encoding".equals(localHeader.getName().toLowerCase())) && (localHeader.getValue() != null)) {
              if ("gzip".equals(localHeader.getValue().toLowerCase()))
              {
                i = 0;
                j = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        label248:
        if (j != 0) {
          localObject1 = new GZIPInputStream((InputStream)localObject1);
        }
        for (;;)
        {
          localObject1 = new TypedInputStream(str2, m, (InputStream)localObject1, null);
          return new Response(paramHttpURLConnection.getURL().toString(), k, str1, localArrayList, (TypedInput)localObject1);
          localObject1 = paramHttpURLConnection.getInputStream();
          break;
          if (!"deflate".equals(localHeader.getValue().toLowerCase())) {
            break label354;
          }
          i = 1;
          break label248;
          if (i != 0) {
            localObject1 = new InflaterInputStream((InputStream)localObject1);
          }
        }
        label354:
        i = 0;
      }
    }
  }
  
  static class TypedInputStream
    implements TypedInput
  {
    private final long length;
    private final String mimeType;
    private final InputStream stream;
    
    private TypedInputStream(String paramString, long paramLong, InputStream paramInputStream)
    {
      this.mimeType = paramString;
      this.length = paramLong;
      this.stream = paramInputStream;
    }
    
    public InputStream in()
      throws IOException
    {
      return this.stream;
    }
    
    public long length()
    {
      return this.length;
    }
    
    public String mimeType()
    {
      return this.mimeType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.UrlConnectionClient
 * JD-Core Version:    0.7.0.1
 */