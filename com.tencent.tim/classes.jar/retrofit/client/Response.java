package retrofit.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit.mime.TypedInput;

public final class Response
{
  private final TypedInput body;
  private final List<Header> headers;
  private final String reason;
  private final int status;
  private final String url;
  
  public Response(String paramString1, int paramInt, String paramString2, List<Header> paramList, TypedInput paramTypedInput)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("url == null");
    }
    if (paramInt < 200) {
      throw new IllegalArgumentException("Invalid status code: " + paramInt);
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("reason == null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("headers == null");
    }
    this.url = paramString1;
    this.status = paramInt;
    this.reason = paramString2;
    this.headers = Collections.unmodifiableList(new ArrayList(paramList));
    this.body = paramTypedInput;
  }
  
  public TypedInput getBody()
  {
    return this.body;
  }
  
  public List<Header> getHeaders()
  {
    return this.headers;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.Response
 * JD-Core Version:    0.7.0.1
 */