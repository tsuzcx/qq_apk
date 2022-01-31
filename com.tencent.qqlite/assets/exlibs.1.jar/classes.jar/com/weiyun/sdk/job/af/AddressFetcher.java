package com.weiyun.sdk.job.af;

import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.IllegalFormatException;

public abstract class AddressFetcher
{
  private static final String TAG = "AddressFetcher";
  private TransferAddress mAddress = null;
  private FetchAddressException mException = null;
  
  private void setAddress(TransferAddress paramTransferAddress)
  {
    try
    {
      this.mAddress = paramTransferAddress;
      return;
    }
    finally
    {
      paramTransferAddress = finally;
      throw paramTransferAddress;
    }
  }
  
  private void setException(FetchAddressException paramFetchAddressException)
  {
    try
    {
      this.mException = paramFetchAddressException;
      return;
    }
    finally
    {
      paramFetchAddressException = finally;
      throw paramFetchAddressException;
    }
  }
  
  protected void failedGetAddress(FetchAddressException paramFetchAddressException)
  {
    setException(paramFetchAddressException);
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public TransferAddress getAddress(int paramInt)
    throws AddressFetcher.FetchAddressException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: invokespecial 64	com/weiyun/sdk/job/af/AddressFetcher:setAddress	(Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;)V
    //   5: aload_0
    //   6: aconst_null
    //   7: invokespecial 55	com/weiyun/sdk/job/af/AddressFetcher:setException	(Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;)V
    //   10: aload_0
    //   11: invokevirtual 68	com/weiyun/sdk/job/af/AddressFetcher:sendRequest	()I
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq +14 -> 30
    //   19: new 9	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException
    //   22: dup
    //   23: iload_2
    //   24: ldc 70
    //   26: invokespecial 73	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException:<init>	(ILjava/lang/String;)V
    //   29: athrow
    //   30: invokestatic 79	java/lang/Thread:interrupted	()Z
    //   33: ifeq +9 -> 42
    //   36: aconst_null
    //   37: astore 5
    //   39: aload 5
    //   41: areturn
    //   42: ldc 35
    //   44: new 81	java/lang/StringBuilder
    //   47: dup
    //   48: ldc 83
    //   50: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: invokevirtual 94	java/lang/Thread:getName	()Ljava/lang/String;
    //   59: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 100
    //   64: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: sipush 1000
    //   71: imul
    //   72: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 112	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: getfield 45	com/weiyun/sdk/job/af/AddressFetcher:mAddress	Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;
    //   87: astore 5
    //   89: aload_0
    //   90: getfield 47	com/weiyun/sdk/job/af/AddressFetcher:mException	Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;
    //   93: astore 6
    //   95: aload 5
    //   97: ifnull +15 -> 112
    //   100: aload_0
    //   101: monitorexit
    //   102: aload 5
    //   104: areturn
    //   105: astore 5
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 5
    //   111: athrow
    //   112: aload 6
    //   114: ifnull +21 -> 135
    //   117: aload 6
    //   119: athrow
    //   120: astore 5
    //   122: new 9	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException
    //   125: dup
    //   126: sipush -10002
    //   129: aload 5
    //   131: invokespecial 115	com/weiyun/sdk/job/af/AddressFetcher$FetchAddressException:<init>	(ILjava/lang/Throwable;)V
    //   134: athrow
    //   135: iload_1
    //   136: sipush 1000
    //   139: imul
    //   140: i2l
    //   141: lstore_3
    //   142: aload_0
    //   143: lload_3
    //   144: invokevirtual 119	java/lang/Object:wait	(J)V
    //   147: aload_0
    //   148: getfield 45	com/weiyun/sdk/job/af/AddressFetcher:mAddress	Lcom/weiyun/sdk/job/af/AddressFetcher$TransferAddress;
    //   151: astore 6
    //   153: aload_0
    //   154: getfield 47	com/weiyun/sdk/job/af/AddressFetcher:mException	Lcom/weiyun/sdk/job/af/AddressFetcher$FetchAddressException;
    //   157: astore 7
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 6
    //   163: astore 5
    //   165: aload 6
    //   167: ifnonnull -128 -> 39
    //   170: aload 7
    //   172: ifnull +6 -> 178
    //   175: aload 7
    //   177: athrow
    //   178: aconst_null
    //   179: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	AddressFetcher
    //   0	180	1	paramInt	int
    //   14	10	2	i	int
    //   141	3	3	l	long
    //   37	66	5	localTransferAddress	TransferAddress
    //   105	5	5	localObject1	Object
    //   120	10	5	localInterruptedException	java.lang.InterruptedException
    //   163	1	5	localObject2	Object
    //   93	73	6	localObject3	Object
    //   157	19	7	localFetchAddressException	FetchAddressException
    // Exception table:
    //   from	to	target	type
    //   83	95	105	finally
    //   100	102	105	finally
    //   107	109	105	finally
    //   117	120	105	finally
    //   122	135	105	finally
    //   142	159	105	finally
    //   159	161	105	finally
    //   83	95	120	java/lang/InterruptedException
    //   117	120	120	java/lang/InterruptedException
    //   142	159	120	java/lang/InterruptedException
  }
  
  protected abstract int sendRequest();
  
  protected void successGetAddress(TransferAddress paramTransferAddress)
  {
    if (paramTransferAddress == null) {
      throw new NullPointerException("address is null");
    }
    setAddress(paramTransferAddress);
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public static class DownloadAddress
    extends AddressFetcher.TransferAddress
  {
    private static final String FORMAT = "/ftn_handler/%s/%s?cn=%s&cv=%s";
    private final String mCookieName;
    private final String mCookieValue;
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2)
    {
      this(paramString1, paramInt, paramString2, null, null);
    }
    
    public DownloadAddress(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5)
    {
      super(paramInt1, getUrlFile(paramString2, paramString3, paramInt2));
      this.mCookieName = paramString4;
      this.mCookieValue = paramString5;
    }
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      super(paramInt, paramString2);
      this.mCookieName = paramString3;
      this.mCookieValue = paramString4;
    }
    
    public DownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this(paramString1, paramInt, paramString2, paramString3, 30001, paramString4, paramString5);
    }
    
    private static String getUrlFile(String paramString1, String paramString2, int paramInt)
    {
      int i = NetworkUtils.getNetWorkType(null);
      return String.format("/ftn_handler/%s/%s?cn=%s&cv=%s", new Object[] { paramString2, Utils.encodeUrlString(paramString1), Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    
    public String getCookieName()
    {
      return this.mCookieName;
    }
    
    public String getCookieValue()
    {
      return this.mCookieValue;
    }
  }
  
  public static class FetchAddressException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    private final int mErrorCode;
    
    public FetchAddressException(int paramInt)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, String paramString)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.mErrorCode = paramInt;
    }
    
    public FetchAddressException(int paramInt, Throwable paramThrowable)
    {
      super();
      this.mErrorCode = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.mErrorCode;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("fetch address meet error code ");
      localStringBuilder.append(this.mErrorCode);
      localStringBuilder.append("\n");
      localStringBuilder.append(super.toString());
      return localStringBuilder.toString();
    }
  }
  
  public static class ImageDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    private static final String PIC_TYPE = "cut";
    private static final String THUMBNAIL_FORMAT = "/ftn_handler/%s/%s?pictype=%s&size=%s&cn=%d&cv=%d";
    private final String mThumbnailFile;
    
    public ImageDownloadAddress(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
    {
      super(paramInt1, paramString2, paramString3, paramInt2, paramString4, paramString5);
      this.mThumbnailFile = getThumbnailFile(paramString3, paramInt2, paramString2, paramString6);
    }
    
    public ImageDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this(paramString1, paramInt, paramString2, paramString3, 30001, paramString4, paramString5, paramString6);
    }
    
    public static String getThumbnailFile(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      int i = NetworkUtils.getNetWorkType(null);
      return String.format("/ftn_handler/%s/%s?pictype=%s&size=%s&cn=%d&cv=%d", new Object[] { paramString1, Utils.encodeUrlString(paramString2), "cut", paramString3, Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    
    public String getThumbnailFile()
    {
      return this.mThumbnailFile;
    }
  }
  
  public static class OfflineFileDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    private static final int CLIENT_VERSION = 2173;
    private static final String FORMAT = "/ver=%d&rkey=%s";
    
    public OfflineFileDownloadAddress(String paramString1, int paramInt, String paramString2)
    {
      super(paramInt, paramString2);
    }
    
    public OfflineFileDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      super(paramInt, getUrlFile(paramString3));
    }
    
    public static String getUrlFile(String paramString)
    {
      return String.format("/ver=%d&rkey=%s", new Object[] { Integer.valueOf(2173), paramString });
    }
    
    private static String getValidHost(String paramString1, String paramString2)
    {
      if ((paramString1 != null) && (!paramString1.equals(""))) {
        return paramString1;
      }
      return paramString2;
    }
  }
  
  public static class OfflineFileThumbnailDownloadAddress
    extends AddressFetcher.OfflineFileDownloadAddress
  {
    private static final String FORMAT = "/ver=%d&rkey=%s&size=%s";
    
    public OfflineFileThumbnailDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      super(paramInt, getUrlFile(paramString2, paramString4));
    }
    
    private static String getUrlFile(String paramString1, String paramString2)
    {
      return String.format("/ver=%d&rkey=%s&size=%s", new Object[] { Integer.valueOf(2173), paramString1, paramString2 });
    }
  }
  
  public static class ShareFileDownloadAddress
    extends AddressFetcher.DownloadAddress
  {
    public ShareFileDownloadAddress(URL paramURL)
      throws MalformedURLException
    {
      super(paramURL.getPort(), paramURL.getFile());
    }
    
    public ShareFileDownloadAddress(URL paramURL, String paramString1, String paramString2)
      throws MalformedURLException
    {
      super(paramURL.getPort(), paramURL.getFile(), paramString1, paramString2);
    }
  }
  
  public static class SimpleHttpAddress
    extends AddressFetcher.TransferAddress
  {
    public static final String HTTP = "http";
    
    public SimpleHttpAddress(String paramString)
      throws MalformedURLException
    {
      this(Utils.getURL(paramString));
    }
    
    public SimpleHttpAddress(URL paramURL)
    {
      super(paramURL.getPort(), paramURL.getFile());
    }
  }
  
  public static abstract class TransferAddress
  {
    private final String mFile;
    private final String mHost;
    private final int mPort;
    
    public TransferAddress(String paramString1, int paramInt, String paramString2)
    {
      this.mHost = paramString1;
      this.mPort = paramInt;
      this.mFile = paramString2;
    }
    
    public String getFile()
    {
      return this.mFile;
    }
    
    public String getHost()
    {
      return this.mHost;
    }
    
    public int getPort()
    {
      return this.mPort;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://").append(this.mHost).append(":").append(this.mPort).append(this.mFile);
      return localStringBuilder.toString();
    }
    
    public String toUrl()
    {
      return toString();
    }
  }
  
  public static class UploadAddress
    extends AddressFetcher.TransferAddress
  {
    private static final String FORMAT = "/ftn_handler/?cn=%d&cv=%d";
    private final String mUkey;
    
    public UploadAddress(String paramString1, int paramInt, String paramString2)
      throws IllegalFormatException
    {
      this(paramString1, paramInt, paramString2, 30001);
    }
    
    public UploadAddress(String paramString1, int paramInt1, String paramString2, int paramInt2)
      throws IllegalFormatException
    {
      super(paramInt1, getUrlFile(paramInt2));
      this.mUkey = paramString2;
    }
    
    private static String getUrlFile(int paramInt)
    {
      return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetWorkType(null)), Integer.valueOf(paramInt) });
    }
    
    public String getUKey()
    {
      return this.mUkey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.AddressFetcher
 * JD-Core Version:    0.7.0.1
 */