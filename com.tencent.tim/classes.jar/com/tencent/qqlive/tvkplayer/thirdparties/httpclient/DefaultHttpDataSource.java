package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
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
        TVKLogUtil.e("DefaultHttpDataSource", localException, "Unexpected error while disconnecting");
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
    //   44: getstatic 64	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
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
    //   95: ifge +45 -> 140
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
    //   132: invokestatic 204	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: lload_3
    //   136: lstore_1
    //   137: goto -109 -> 28
    //   140: lload_1
    //   141: lstore_3
    //   142: lload_1
    //   143: lload 5
    //   145: lcmp
    //   146: ifeq -45 -> 101
    //   149: ldc 26
    //   151: new 188	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   158: ldc 206
    //   160: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 7
    //   165: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 208
    //   170: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 197
    //   179: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 211	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: lload_1
    //   189: lload 5
    //   191: invokestatic 217	java/lang/Math:max	(JJ)J
    //   194: lstore_3
    //   195: lload_3
    //   196: lreturn
    //   197: astore 7
    //   199: ldc 26
    //   201: new 188	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   208: ldc 219
    //   210: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 197
    //   219: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 204	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: lload_1
    //   229: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramHttpURLConnection	HttpURLConnection
    //   13	216	1	l1	long
    //   3	193	3	l2	long
    //   82	108	5	l3	long
    //   10	154	7	str	String
    //   197	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   51	23	8	localMatcher	java.util.regex.Matcher
    //   103	1	8	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	103	java/lang/NumberFormatException
    //   63	84	197	java/lang/NumberFormatException
    //   149	195	197	java/lang/NumberFormatException
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
          localObject = paramHttpURLConnection.getClass().getSuperclass();
          if (localObject == null) {
            break;
          }
          localObject = ((Class)localObject).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
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
    //   1: getfield 455	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   4: ifnull +21 -> 25
    //   7: aload_0
    //   8: getfield 134	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   11: aload_0
    //   12: invokevirtual 506	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:bytesRemaining	()J
    //   15: invokestatic 508	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:maybeTerminateInputStream	(Ljava/net/HttpURLConnection;J)V
    //   18: aload_0
    //   19: getfield 455	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   22: invokevirtual 509	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 455	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   30: aload_0
    //   31: invokespecial 511	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   34: aload_0
    //   35: getfield 513	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:opened	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 513	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:opened	Z
    //   46: aload_0
    //   47: invokevirtual 516	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:transferEnded	()V
    //   50: return
    //   51: astore_1
    //   52: new 504	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException
    //   55: dup
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 518	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:dataSpec	Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;
    //   61: iconst_3
    //   62: invokespecial 521	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/tencent/qqlive/tvkplayer/thirdparties/httpclient/DataSpec;I)V
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 455	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   72: aload_0
    //   73: invokespecial 511	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   76: aload_0
    //   77: getfield 513	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:opened	Z
    //   80: ifeq +12 -> 92
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 513	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:opened	Z
    //   88: aload_0
    //   89: invokevirtual 516	com/tencent/qqlive/tvkplayer/thirdparties/httpclient/DefaultHttpDataSource:transferEnded	()V
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
  
  public long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException
  {
    long l2 = 0L;
    this.dataSpec = paramDataSpec;
    this.bytesRead = 0L;
    this.bytesSkipped = 0L;
    transferInitializing(paramDataSpec);
    int i;
    try
    {
      this.connection = makeConnection(paramDataSpec);
      String str1;
      Map localMap;
      str2 = this.connection.getContentType();
    }
    catch (IOException localIOException1)
    {
      try
      {
        i = this.connection.getResponseCode();
        str1 = this.connection.getResponseMessage();
        if ((i >= 200) && (i <= 299)) {
          break label238;
        }
        localMap = this.connection.getHeaderFields();
        closeConnectionQuietly();
        paramDataSpec = new HttpDataSource.InvalidResponseCodeException(i, str1, localMap, paramDataSpec);
        if (i == 416) {
          paramDataSpec.initCause(new DataSourceException(0));
        }
        throw paramDataSpec;
      }
      catch (IOException localIOException2)
      {
        closeConnectionQuietly();
        throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException2, paramDataSpec, 1);
      }
      catch (Exception localException)
      {
        closeConnectionQuietly();
        throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), paramDataSpec, 1);
      }
      localIOException1 = localIOException1;
      throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException1, paramDataSpec, 1);
    }
    label238:
    String str2;
    if ((this.contentTypePredicate != null) && (!this.contentTypePredicate.evaluate(str2)))
    {
      closeConnectionQuietly();
      throw new HttpDataSource.InvalidContentTypeException(str2, paramDataSpec);
    }
    long l1 = l2;
    if (i == 200)
    {
      l1 = l2;
      if (paramDataSpec.position != 0L) {
        l1 = paramDataSpec.position;
      }
    }
    this.bytesToSkip = l1;
    if (!paramDataSpec.isFlagSet(1)) {
      if (paramDataSpec.length != -1L) {
        this.bytesToRead = paramDataSpec.length;
      }
    }
    for (;;)
    {
      try
      {
        this.inputStream = this.connection.getInputStream();
        this.opened = true;
        transferStarted(paramDataSpec);
        return this.bytesToRead;
      }
      catch (IOException localIOException3)
      {
        closeConnectionQuietly();
        throw new HttpDataSource.HttpDataSourceException(localIOException3, paramDataSpec, 1);
      }
      l1 = getContentLength(this.connection);
      if (l1 != -1L)
      {
        l1 -= this.bytesToSkip;
        this.bytesToRead = l1;
      }
      else
      {
        l1 = -1L;
        continue;
        this.bytesToRead = paramDataSpec.length;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */