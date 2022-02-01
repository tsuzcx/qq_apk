package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class DefaultHttpDataSource
  extends BaseDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
  private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
  private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
  private static final long MAX_BYTES_TO_DRAIN = 2048L;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "DefaultHttpDataSource";
  private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference();
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  @Nullable
  private HttpURLConnection connection;
  @Nullable
  private final Predicate<String> contentTypePredicate;
  @Nullable
  private DataSpec dataSpec;
  @Nullable
  private final HttpDataSource.RequestProperties defaultRequestProperties;
  @Nullable
  private InputStream inputStream;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HttpDataSource.RequestProperties requestProperties;
  private final String userAgent;
  
  public DefaultHttpDataSource(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate)
  {
    this(paramString, paramPredicate, 8000, 8000);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, false, null);
  }
  
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable HttpDataSource.RequestProperties paramRequestProperties)
  {
    super(true);
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.requestProperties = new HttpDataSource.RequestProperties();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.defaultRequestProperties = paramRequestProperties;
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener)
  {
    this(paramString, paramPredicate, paramTransferListener, 8000, 8000);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramTransferListener, paramInt1, paramInt2, false, null);
  }
  
  @Deprecated
  public DefaultHttpDataSource(String paramString, @Nullable Predicate<String> paramPredicate, @Nullable TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable HttpDataSource.RequestProperties paramRequestProperties)
  {
    this(paramString, paramPredicate, paramInt1, paramInt2, paramBoolean, paramRequestProperties);
    if (paramTransferListener != null) {
      addTransferListener(paramTransferListener);
    }
  }
  
  private void closeConnectionQuietly()
  {
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      this.connection = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
      }
    }
  }
  
  /* Error */
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 152
    //   3: lstore_3
    //   4: aload_0
    //   5: ldc 155
    //   7: invokevirtual 158	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: lload_3
    //   13: lstore_1
    //   14: aload 7
    //   16: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +9 -> 28
    //   22: aload 7
    //   24: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore_1
    //   28: aload_0
    //   29: ldc 172
    //   31: invokevirtual 158	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: lload_1
    //   36: lstore_3
    //   37: aload_0
    //   38: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +60 -> 101
    //   44: getstatic 64	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
    //   47: aload_0
    //   48: invokevirtual 176	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 8
    //   53: lload_1
    //   54: lstore_3
    //   55: aload 8
    //   57: invokevirtual 182	java/util/regex/Matcher:find	()Z
    //   60: ifeq +41 -> 101
    //   63: aload 8
    //   65: iconst_2
    //   66: invokevirtual 186	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   69: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore_3
    //   73: aload 8
    //   75: iconst_1
    //   76: invokevirtual 186	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   79: invokestatic 170	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore 5
    //   84: lload_3
    //   85: lload 5
    //   87: lsub
    //   88: lconst_1
    //   89: ladd
    //   90: lstore 5
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +46 -> 141
    //   98: lload 5
    //   100: lstore_3
    //   101: lload_3
    //   102: lreturn
    //   103: astore 8
    //   105: ldc 26
    //   107: new 188	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   114: ldc 191
    //   116: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 7
    //   121: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 197
    //   126: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: lload_3
    //   137: lstore_1
    //   138: goto -110 -> 28
    //   141: lload_1
    //   142: lstore_3
    //   143: lload_1
    //   144: lload 5
    //   146: lcmp
    //   147: ifeq -46 -> 101
    //   150: ldc 26
    //   152: new 188	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   159: ldc 206
    //   161: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc 208
    //   171: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 197
    //   180: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 211	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: lload_1
    //   191: lload 5
    //   193: invokestatic 217	java/lang/Math:max	(JJ)J
    //   196: lstore_3
    //   197: lload_3
    //   198: lreturn
    //   199: astore 7
    //   201: ldc 26
    //   203: new 188	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   210: ldc 219
    //   212: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 197
    //   221: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: lload_1
    //   232: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramHttpURLConnection	HttpURLConnection
    //   13	219	1	l1	long
    //   3	195	3	l2	long
    //   82	110	5	l3	long
    //   10	155	7	str	String
    //   199	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   51	23	8	localMatcher	java.util.regex.Matcher
    //   103	1	8	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	103	java/lang/NumberFormatException
    //   63	84	199	java/lang/NumberFormatException
    //   150	197	199	java/lang/NumberFormatException
  }
  
  private static URL handleRedirect(URL paramURL, String paramString)
    throws IOException
  {
    if (paramString == null) {
      throw new ProtocolException("Null location redirect");
    }
    paramURL = new URL(paramURL, paramString);
    paramString = paramURL.getProtocol();
    if ((!"https".equals(paramString)) && (!"http".equals(paramString))) {
      throw new ProtocolException("Unsupported protocol redirect: " + paramString);
    }
    return paramURL;
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
    throws IOException
  {
    Object localObject2 = new URL(paramDataSpec.uri.toString());
    int i = paramDataSpec.httpMethod;
    Object localObject1 = paramDataSpec.httpBody;
    long l1 = paramDataSpec.position;
    long l2 = paramDataSpec.length;
    boolean bool1 = paramDataSpec.isFlagSet(1);
    boolean bool2 = paramDataSpec.isFlagSet(2);
    if (!this.allowCrossProtocolRedirects)
    {
      localObject1 = makeConnection((URL)localObject2, i, (byte[])localObject1, l1, l2, bool1, bool2, true);
      return localObject1;
    }
    int j = 0;
    paramDataSpec = (DataSpec)localObject2;
    label88:
    int k = j + 1;
    if (j <= 20)
    {
      localObject2 = makeConnection(paramDataSpec, i, (byte[])localObject1, l1, l2, bool1, bool2, false);
      j = ((HttpURLConnection)localObject2).getResponseCode();
      String str = ((HttpURLConnection)localObject2).getHeaderField("Location");
      if (((i == 1) || (i == 3)) && ((j == 300) || (j == 301) || (j == 302) || (j == 303) || (j == 307) || (j == 308))) {
        ((HttpURLConnection)localObject2).disconnect();
      }
      for (paramDataSpec = handleRedirect(paramDataSpec, str);; paramDataSpec = handleRedirect(paramDataSpec, str))
      {
        j = k;
        break label88;
        localObject1 = localObject2;
        if (i != 2) {
          break;
        }
        if ((j != 300) && (j != 301) && (j != 302))
        {
          localObject1 = localObject2;
          if (j != 303) {
            break;
          }
        }
        ((HttpURLConnection)localObject2).disconnect();
        i = 1;
        localObject1 = null;
      }
    }
    throw new NoRouteToHostException("Too many redirects: " + k);
  }
  
  private HttpURLConnection makeConnection(URL paramURL, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(this.readTimeoutMillis);
    Object localObject;
    if (this.defaultRequestProperties != null)
    {
      paramURL = this.defaultRequestProperties.getSnapshot().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.requestProperties.getSnapshot().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject = "bytes=" + paramLong1 + "-";
      paramURL = (URL)localObject;
      if (paramLong2 != -1L) {
        paramURL = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    if (paramBoolean2) {
      localHttpURLConnection.setRequestProperty("Icy-MetaData", "1");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean3);
    if (paramArrayOfByte != null) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localHttpURLConnection.setDoOutput(paramBoolean1);
      localHttpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(paramInt));
      if (paramArrayOfByte == null) {
        break;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  private static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20)) {
      return;
    }
    do
    {
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (paramHttpURLConnection.read() == -1) {
            break;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if ((!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) && (!"com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject))) {
            break;
          }
          localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        return;
      }
    } while (paramLong > 2048L);
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    do
    {
      long l;
      do
      {
        return i;
        i = paramInt2;
        if (this.bytesToRead == -1L) {
          break;
        }
        l = this.bytesToRead - this.bytesRead;
        i = j;
      } while (l == 0L);
      i = (int)Math.min(paramInt2, l);
      paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 != -1) {
        break;
      }
      i = j;
    } while (this.bytesToRead == -1L);
    throw new EOFException();
    this.bytesRead += paramInt1;
    bytesTransferred(paramInt1);
    return paramInt1;
  }
  
  private void skipInternal()
    throws IOException
  {
    if (this.bytesSkipped == this.bytesToSkip) {
      return;
    }
    byte[] arrayOfByte2 = (byte[])skipBufferReference.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4096];
    }
    while (this.bytesSkipped != this.bytesToSkip)
    {
      int i = (int)Math.min(this.bytesToSkip - this.bytesSkipped, arrayOfByte1.length);
      i = this.inputStream.read(arrayOfByte1, 0, i);
      if (Thread.currentThread().isInterrupted()) {
        throw new InterruptedIOException();
      }
      if (i == -1) {
        throw new EOFException();
      }
      this.bytesSkipped += i;
      bytesTransferred(i);
    }
    skipBufferReference.set(arrayOfByte1);
  }
  
  protected final long bytesRead()
  {
    return this.bytesRead;
  }
  
  protected final long bytesRemaining()
  {
    if (this.bytesToRead == -1L) {
      return this.bytesToRead;
    }
    return this.bytesToRead - this.bytesRead;
  }
  
  protected final long bytesSkipped()
  {
    return this.bytesSkipped;
  }
  
  public void clearAllRequestProperties()
  {
    this.requestProperties.clear();
  }
  
  public void clearRequestProperty(String paramString)
  {
    Assertions.checkNotNull(paramString);
    this.requestProperties.remove(paramString);
  }
  
  /* Error */
  public void close()
    throws HttpDataSource.HttpDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 459	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   4: ifnull +21 -> 25
    //   7: aload_0
    //   8: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   11: aload_0
    //   12: invokevirtual 510	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesRemaining	()J
    //   15: invokestatic 512	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:maybeTerminateInputStream	(Ljava/net/HttpURLConnection;J)V
    //   18: aload_0
    //   19: getfield 459	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   22: invokevirtual 513	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 459	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   30: aload_0
    //   31: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   34: aload_0
    //   35: getfield 517	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 517	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   46: aload_0
    //   47: invokevirtual 520	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferEnded	()V
    //   50: return
    //   51: astore_1
    //   52: new 508	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   55: dup
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;
    //   61: iconst_3
    //   62: invokespecial 525	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 459	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   72: aload_0
    //   73: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   76: aload_0
    //   77: getfield 517	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   80: ifeq +12 -> 92
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 517	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   88: aload_0
    //   89: invokevirtual 520	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferEnded	()V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	DefaultHttpDataSource
    //   51	6	1	localIOException	IOException
    //   66	27	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	51	java/io/IOException
    //   0	18	66	finally
    //   18	25	66	finally
    //   52	66	66	finally
  }
  
  @Nullable
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    if (this.connection == null) {
      return null;
    }
    return this.connection.getHeaderFields();
  }
  
  @Nullable
  public Uri getUri()
  {
    if (this.connection == null) {
      return null;
    }
    return Uri.parse(this.connection.getURL().toString());
  }
  
  /* Error */
  public long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: new 550	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier
    //   6: dup
    //   7: invokespecial 551	com/tencent/thumbplayer/core/drm/httpclient/MyHostnameVerifier:<init>	()V
    //   10: astore 7
    //   12: new 553	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory
    //   15: dup
    //   16: invokespecial 554	com/tencent/thumbplayer/core/drm/httpclient/SSLTrustAllSocketFactory:<init>	()V
    //   19: invokestatic 560	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   22: aload 7
    //   24: invokestatic 564	javax/net/ssl/HttpsURLConnection:setDefaultHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 522	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 454	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesRead	J
    //   37: aload_0
    //   38: lconst_0
    //   39: putfield 470	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesSkipped	J
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 568	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferInitializing	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 570	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:makeConnection	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)Ljava/net/HttpURLConnection;
    //   53: putfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   56: aload_0
    //   57: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   60: invokevirtual 286	java/net/HttpURLConnection:getResponseCode	()I
    //   63: istore_2
    //   64: aload_0
    //   65: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   68: invokevirtual 573	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   71: astore 7
    //   73: iload_2
    //   74: sipush 200
    //   77: if_icmplt +10 -> 87
    //   80: iload_2
    //   81: sipush 299
    //   84: if_icmple +146 -> 230
    //   87: aload_0
    //   88: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   91: invokevirtual 532	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   94: astore 8
    //   96: aload_0
    //   97: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   100: new 575	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException
    //   103: dup
    //   104: iload_2
    //   105: aload 7
    //   107: aload 8
    //   109: aload_1
    //   110: invokespecial 578	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/lang/String;Ljava/util/Map;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   113: astore_1
    //   114: iload_2
    //   115: sipush 416
    //   118: if_icmpne +16 -> 134
    //   121: aload_1
    //   122: new 580	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException
    //   125: dup
    //   126: iconst_0
    //   127: invokespecial 582	com/tencent/thumbplayer/core/drm/httpclient/DataSourceException:<init>	(I)V
    //   130: invokevirtual 586	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidResponseCodeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   133: pop
    //   134: aload_1
    //   135: athrow
    //   136: astore 8
    //   138: aload 8
    //   140: invokevirtual 587	java/lang/Throwable:printStackTrace	()V
    //   143: goto -121 -> 22
    //   146: astore 7
    //   148: new 508	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   151: dup
    //   152: new 188	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 589
    //   162: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_1
    //   166: getfield 258	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   169: invokevirtual 261	android/net/Uri:toString	()Ljava/lang/String;
    //   172: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: aload 7
    //   180: aload_1
    //   181: iconst_1
    //   182: invokespecial 592	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   185: athrow
    //   186: astore 7
    //   188: aload_0
    //   189: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   192: new 508	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   195: dup
    //   196: new 188	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 589
    //   206: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: getfield 258	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:uri	Landroid/net/Uri;
    //   213: invokevirtual 261	android/net/Uri:toString	()Ljava/lang/String;
    //   216: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: aload 7
    //   224: aload_1
    //   225: iconst_1
    //   226: invokespecial 592	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   229: athrow
    //   230: aload_0
    //   231: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   234: invokevirtual 595	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   237: astore 7
    //   239: aload_0
    //   240: getfield 99	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/thumbplayer/core/drm/httpclient/Predicate;
    //   243: ifnull +32 -> 275
    //   246: aload_0
    //   247: getfield 99	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:contentTypePredicate	Lcom/tencent/thumbplayer/core/drm/httpclient/Predicate;
    //   250: aload 7
    //   252: invokeinterface 600 2 0
    //   257: ifne +18 -> 275
    //   260: aload_0
    //   261: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   264: new 602	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException
    //   267: dup
    //   268: aload 7
    //   270: aload_1
    //   271: invokespecial 605	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   274: athrow
    //   275: lload 5
    //   277: lstore_3
    //   278: iload_2
    //   279: sipush 200
    //   282: if_icmpne +20 -> 302
    //   285: lload 5
    //   287: lstore_3
    //   288: aload_1
    //   289: getfield 272	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   292: lconst_0
    //   293: lcmp
    //   294: ifeq +8 -> 302
    //   297: aload_1
    //   298: getfield 272	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:position	J
    //   301: lstore_3
    //   302: aload_0
    //   303: lload_3
    //   304: putfield 472	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   307: aload_1
    //   308: iconst_1
    //   309: invokevirtual 279	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:isFlagSet	(I)Z
    //   312: ifne +86 -> 398
    //   315: aload_1
    //   316: getfield 275	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   319: ldc2_w 152
    //   322: lcmp
    //   323: ifeq +37 -> 360
    //   326: aload_0
    //   327: aload_1
    //   328: getfield 275	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   331: putfield 452	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   334: aload_0
    //   335: aload_0
    //   336: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   339: invokevirtual 407	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   342: putfield 459	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   345: aload_0
    //   346: iconst_1
    //   347: putfield 517	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:opened	Z
    //   350: aload_0
    //   351: aload_1
    //   352: invokevirtual 608	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:transferStarted	(Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;)V
    //   355: aload_0
    //   356: getfield 452	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   359: lreturn
    //   360: aload_0
    //   361: getfield 134	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   364: invokestatic 610	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   367: lstore_3
    //   368: lload_3
    //   369: ldc2_w 152
    //   372: lcmp
    //   373: ifeq +18 -> 391
    //   376: lload_3
    //   377: aload_0
    //   378: getfield 472	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToSkip	J
    //   381: lsub
    //   382: lstore_3
    //   383: aload_0
    //   384: lload_3
    //   385: putfield 452	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   388: goto -54 -> 334
    //   391: ldc2_w 152
    //   394: lstore_3
    //   395: goto -12 -> 383
    //   398: aload_0
    //   399: aload_1
    //   400: getfield 275	com/tencent/thumbplayer/core/drm/httpclient/DataSpec:length	J
    //   403: putfield 452	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:bytesToRead	J
    //   406: goto -72 -> 334
    //   409: astore 7
    //   411: aload_0
    //   412: invokespecial 515	com/tencent/thumbplayer/core/drm/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   415: new 508	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException
    //   418: dup
    //   419: aload 7
    //   421: aload_1
    //   422: iconst_1
    //   423: invokespecial 525	com/tencent/thumbplayer/core/drm/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/thumbplayer/core/drm/httpclient/DataSpec;I)V
    //   426: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	DefaultHttpDataSource
    //   0	427	1	paramDataSpec	DataSpec
    //   63	220	2	i	int
    //   277	118	3	l1	long
    //   1	285	5	l2	long
    //   10	96	7	localObject	Object
    //   146	33	7	localIOException1	IOException
    //   186	37	7	localIOException2	IOException
    //   237	32	7	str	String
    //   409	11	7	localIOException3	IOException
    //   94	14	8	localMap	Map
    //   136	3	8	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   12	22	136	java/lang/Throwable
    //   47	56	146	java/io/IOException
    //   56	73	186	java/io/IOException
    //   334	345	409	java/io/IOException
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException
  {
    try
    {
      skipInternal();
      paramInt1 = readInternal(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec, 2);
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    this.requestProperties.set(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */