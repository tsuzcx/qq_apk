package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract interface Interceptor
{
  public abstract Response intercept(Chain paramChain)
    throws IOException;
  
  public static abstract interface Chain
  {
    public abstract Call call();
    
    public abstract int connectTimeoutMillis();
    
    @Nullable
    public abstract Connection connection();
    
    public abstract Response proceed(Request paramRequest)
      throws IOException;
    
    public abstract int readTimeoutMillis();
    
    public abstract Request request();
    
    public abstract Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract int writeTimeoutMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Interceptor
 * JD-Core Version:    0.7.0.1
 */