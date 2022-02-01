package com.weiyun.sdk.job.af;

import com.weiyun.sdk.log.Log;
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
  
  public TransferAddress getAddress(int paramInt)
    throws AddressFetcher.FetchAddressException
  {
    setAddress(null);
    setException(null);
    int i = sendRequest();
    if (i != 0) {
      throw new FetchAddressException(i, "send request failed!");
    }
    if (Thread.interrupted()) {}
    FetchAddressException localFetchAddressException;
    do
    {
      return null;
      Log.i("AddressFetcher", "Thread " + Thread.currentThread().getName() + " will wait time " + paramInt * 1000);
      try
      {
        TransferAddress localTransferAddress1 = this.mAddress;
        localFetchAddressException = this.mException;
        if (localTransferAddress1 != null) {
          return localTransferAddress1;
        }
        if (localFetchAddressException != null) {
          throw localFetchAddressException;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new FetchAddressException(-10002, localInterruptedException);
      }
      finally {}
      long l = paramInt * 1000;
      wait(l);
      TransferAddress localTransferAddress2 = this.mAddress;
      localFetchAddressException = this.mException;
      if (localTransferAddress2 != null) {
        return localTransferAddress2;
      }
    } while (localFetchAddressException == null);
    throw localFetchAddressException;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.af.AddressFetcher
 * JD-Core Version:    0.7.0.1
 */