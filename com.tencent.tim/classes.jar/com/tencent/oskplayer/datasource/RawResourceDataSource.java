package com.tencent.oskplayer.datasource;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class RawResourceDataSource
  implements UriDataSource
{
  public static final String RAW_RESOURCE_SCHEME = "android.resource";
  public static final String TAG = "RawResourceDataSource";
  private AssetFileDescriptor assetFileDescriptor;
  private long assetSize = -1L;
  private long bytesAvailable = -1L;
  private long bytesRemaining;
  private String extraLogTag = "";
  private InputStream inputStream;
  private final TransferListener listener;
  private String mimeType = null;
  private boolean opened;
  private final Resources resources;
  private Uri uri;
  
  public RawResourceDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RawResourceDataSource(Context paramContext, TransferListener paramTransferListener)
  {
    this.resources = paramContext.getResources();
    this.listener = paramTransferListener;
  }
  
  public static Uri buildRawResourceUri(Context paramContext, int paramInt)
  {
    return Uri.parse("android.resource:///" + paramContext.getPackageName() + "/" + paramInt);
  }
  
  public long available()
  {
    return this.bytesAvailable;
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 101	com/tencent/oskplayer/datasource/RawResourceDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 103	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 103	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   16: invokevirtual 107	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 103	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 112	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   47: ifeq +24 -> 71
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   55: aload_0
    //   56: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   66: invokeinterface 119 1 0
    //   71: return
    //   72: astore_1
    //   73: new 8	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 122	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   88: aload_0
    //   89: getfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   92: ifeq +24 -> 116
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   100: aload_0
    //   101: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   104: ifnull +12 -> 116
    //   107: aload_0
    //   108: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   111: invokeinterface 119 1 0
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: new 8	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 122	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 103	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   134: aload_0
    //   135: getfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   138: ifnull +10 -> 148
    //   141: aload_0
    //   142: getfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   145: invokevirtual 112	android/content/res/AssetFileDescriptor:close	()V
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   153: aload_0
    //   154: getfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   157: ifeq +24 -> 181
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   165: aload_0
    //   166: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   169: ifnull +12 -> 181
    //   172: aload_0
    //   173: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   176: invokeinterface 119 1 0
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: new 8	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 122	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   192: athrow
    //   193: astore_1
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 109	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   199: aload_0
    //   200: getfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   203: ifeq +24 -> 227
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 114	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   211: aload_0
    //   212: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   215: ifnull +12 -> 227
    //   218: aload_0
    //   219: getfield 65	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   222: invokeinterface 119 1 0
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	RawResourceDataSource
    //   72	6	1	localIOException1	IOException
    //   82	35	1	localObject1	Object
    //   118	6	1	localIOException2	IOException
    //   128	54	1	localObject2	Object
    //   183	6	1	localIOException3	IOException
    //   193	35	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	72	java/io/IOException
    //   24	38	82	finally
    //   73	82	82	finally
    //   5	19	118	java/io/IOException
    //   5	19	128	finally
    //   119	128	128	finally
    //   134	148	183	java/io/IOException
    //   134	148	193	finally
    //   184	193	193	finally
  }
  
  public FileType getFileType()
  {
    if (TextUtils.isEmpty(this.mimeType)) {
      return FileType.OCTET_STREAM;
    }
    return FileType.getFileType(this.mimeType);
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + "RawResourceDataSource";
  }
  
  public long getTotalLength()
  {
    return this.assetSize;
  }
  
  public String getUri()
  {
    if (this.uri != null) {
      return this.uri.toString();
    }
    return null;
  }
  
  public long open(DataSpec paramDataSpec)
    throws IOException
  {
    long l1 = -1L;
    try
    {
      this.uri = paramDataSpec.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme())) {
        throw new RawResourceDataSourceException("URI must use scheme android.resource");
      }
    }
    catch (IOException paramDataSpec)
    {
      throw new RawResourceDataSourceException(paramDataSpec);
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.assetFileDescriptor = this.resources.openRawResourceFd(i);
      this.assetSize = this.assetFileDescriptor.getLength();
      this.bytesAvailable = (this.assetSize - paramDataSpec.position);
      this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
      if (this.inputStream.skip(paramDataSpec.position) < paramDataSpec.position) {
        throw new EOFException();
      }
    }
    catch (NumberFormatException paramDataSpec)
    {
      throw new RawResourceDataSourceException("Resource identifier must be an integer.");
    }
    if (paramDataSpec.length != -1L)
    {
      this.bytesRemaining = paramDataSpec.length;
      this.opened = true;
      if (this.listener != null) {
        this.listener.onTransferStart();
      }
      return this.bytesRemaining;
    }
    long l2 = this.assetFileDescriptor.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bytesRemaining = l1;
      break;
      l1 = paramDataSpec.position;
      l1 = l2 - l1;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = j;
      if (this.bytesRemaining != 0L) {
        try
        {
          if (this.bytesRemaining == -1L) {}
          for (;;)
          {
            paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 != -1) {
              break label111;
            }
            i = j;
            if (this.bytesRemaining == -1L) {
              break;
            }
            throw new RawResourceDataSourceException(new EOFException());
            long l = Math.min(this.bytesRemaining, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.bytesRemaining == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new RawResourceDataSourceException(paramArrayOfByte);
        }
      }
    }
    label111:
    this.bytesRemaining -= paramInt1;
    label133:
    if (this.listener != null) {
      this.listener.onBytesTransferred(paramInt1);
    }
    return paramInt1;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
  
  public static class RawResourceDataSourceException
    extends IOException
  {
    public RawResourceDataSourceException(IOException paramIOException)
    {
      super();
    }
    
    public RawResourceDataSourceException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.RawResourceDataSource
 * JD-Core Version:    0.7.0.1
 */