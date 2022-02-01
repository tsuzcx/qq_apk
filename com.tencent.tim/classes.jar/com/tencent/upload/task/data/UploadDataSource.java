package com.tencent.upload.task.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.upload.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class UploadDataSource
  implements Parcelable
{
  public abstract String calcSha1();
  
  public abstract boolean exists();
  
  public abstract long getDataLength();
  
  public boolean isValid()
  {
    return getDataLength() > 0L;
  }
  
  public abstract long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws IOException;
  
  public static class ByteDataSource
    extends UploadDataSource
  {
    public static final Parcelable.Creator<ByteDataSource> CREATOR = new UploadDataSource.ByteDataSource.1();
    private byte[] mData;
    
    public ByteDataSource(Parcel paramParcel)
    {
      int j = (int)paramParcel.readLong();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.mData = new byte[i];
      paramParcel.readByteArray(this.mData);
    }
    
    public ByteDataSource(byte[] paramArrayOfByte)
    {
      this.mData = paramArrayOfByte;
    }
    
    public String calcSha1()
    {
      return FileUtils.getFileSha1(this.mData);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean exists()
    {
      return this.mData != null;
    }
    
    public long getDataLength()
    {
      if (this.mData != null) {
        return this.mData.length;
      }
      return 0L;
    }
    
    public long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    {
      System.arraycopy(this.mData, (int)paramLong, paramArrayOfByte, paramInt2, paramInt1);
      return paramInt1;
    }
    
    public String toString()
    {
      return "[Byte:,Size:" + getDataLength() + "]";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(getDataLength());
      paramParcel.writeByteArray(this.mData);
    }
  }
  
  public static class FileDataSource
    extends UploadDataSource
  {
    public static final Parcelable.Creator<FileDataSource> CREATOR = new UploadDataSource.FileDataSource.1();
    private File mFile;
    private String mFilePath;
    private FileInputStream sIns;
    private long sfileOffset;
    
    public FileDataSource(Parcel paramParcel)
    {
      this.mFilePath = paramParcel.readString();
      this.mFile = new File(this.mFilePath);
    }
    
    public FileDataSource(String paramString)
    {
      this.mFilePath = paramString;
      this.mFile = new File(paramString);
    }
    
    public String calcSha1()
    {
      return FileUtils.getFileSha1(this.mFile);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean exists()
    {
      return this.mFile.exists();
    }
    
    public long getDataLength()
    {
      if (this.mFile.exists()) {
        return this.mFile.length();
      }
      return 0L;
    }
    
    public String getFileName()
    {
      return this.mFile.getName();
    }
    
    /* Error */
    public long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   6: ifnull +86 -> 92
      //   9: aload_0
      //   10: getfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   13: lload_1
      //   14: lcmp
      //   15: ifne +77 -> 92
      //   18: aload_0
      //   19: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   22: astore 6
      //   24: aload_0
      //   25: aload_0
      //   26: getfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   29: iload_3
      //   30: i2l
      //   31: ladd
      //   32: putfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   35: aload 6
      //   37: aload 4
      //   39: iload 5
      //   41: iload_3
      //   42: invokevirtual 83	java/io/InputStream:read	([BII)I
      //   45: istore_3
      //   46: iload_3
      //   47: i2l
      //   48: lstore_1
      //   49: aload_0
      //   50: getfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   53: aload_0
      //   54: getfield 43	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
      //   57: invokevirtual 61	java/io/File:length	()J
      //   60: lcmp
      //   61: iflt +27 -> 88
      //   64: aload_0
      //   65: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   68: ifnull +20 -> 88
      //   71: aload_0
      //   72: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   75: invokevirtual 88	java/io/FileInputStream:close	()V
      //   78: aload_0
      //   79: aconst_null
      //   80: putfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   83: aload_0
      //   84: lconst_0
      //   85: putfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   88: aload_0
      //   89: monitorexit
      //   90: lload_1
      //   91: lreturn
      //   92: aload_0
      //   93: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   96: ifnull +10 -> 106
      //   99: aload_0
      //   100: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   103: invokevirtual 88	java/io/FileInputStream:close	()V
      //   106: new 85	java/io/FileInputStream
      //   109: dup
      //   110: aload_0
      //   111: getfield 43	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
      //   114: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   117: astore 6
      //   119: aload_0
      //   120: aload 6
      //   122: putfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   125: aload 6
      //   127: lload_1
      //   128: invokevirtual 95	java/io/InputStream:skip	(J)J
      //   131: pop2
      //   132: aload_0
      //   133: iload_3
      //   134: i2l
      //   135: lload_1
      //   136: ladd
      //   137: putfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   140: goto -105 -> 35
      //   143: astore 4
      //   145: aload_0
      //   146: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   149: ifnull +20 -> 169
      //   152: aload_0
      //   153: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   156: invokevirtual 88	java/io/FileInputStream:close	()V
      //   159: aload_0
      //   160: aconst_null
      //   161: putfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   164: aload_0
      //   165: lconst_0
      //   166: putfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   169: aload 4
      //   171: athrow
      //   172: astore 4
      //   174: aload_0
      //   175: getfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   178: aload_0
      //   179: getfield 43	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
      //   182: invokevirtual 61	java/io/File:length	()J
      //   185: lcmp
      //   186: iflt +27 -> 213
      //   189: aload_0
      //   190: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   193: ifnull +20 -> 213
      //   196: aload_0
      //   197: getfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   200: invokevirtual 88	java/io/FileInputStream:close	()V
      //   203: aload_0
      //   204: aconst_null
      //   205: putfield 75	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
      //   208: aload_0
      //   209: lconst_0
      //   210: putfield 77	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
      //   213: aload 4
      //   215: athrow
      //   216: astore 4
      //   218: aload_0
      //   219: monitorexit
      //   220: aload 4
      //   222: athrow
      //   223: astore 6
      //   225: aload 6
      //   227: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
      //   230: goto -124 -> 106
      //   233: astore 6
      //   235: goto -22 -> 213
      //   238: astore 6
      //   240: goto -71 -> 169
      //   243: astore 4
      //   245: goto -157 -> 88
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	248	0	this	FileDataSource
      //   0	248	1	paramLong	long
      //   0	248	3	paramInt1	int
      //   0	248	4	paramArrayOfByte	byte[]
      //   0	248	5	paramInt2	int
      //   22	104	6	localFileInputStream	FileInputStream
      //   223	3	6	localThrowable	java.lang.Throwable
      //   233	1	6	localException1	java.lang.Exception
      //   238	1	6	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   2	35	143	java/io/IOException
      //   35	46	143	java/io/IOException
      //   92	106	143	java/io/IOException
      //   106	140	143	java/io/IOException
      //   225	230	143	java/io/IOException
      //   2	35	172	finally
      //   35	46	172	finally
      //   92	106	172	finally
      //   106	140	172	finally
      //   145	169	172	finally
      //   169	172	172	finally
      //   225	230	172	finally
      //   49	88	216	finally
      //   88	90	216	finally
      //   174	213	216	finally
      //   213	216	216	finally
      //   218	220	216	finally
      //   92	106	223	java/lang/Throwable
      //   174	213	233	java/lang/Exception
      //   145	169	238	java/lang/Exception
      //   49	88	243	java/lang/Exception
    }
    
    public String toString()
    {
      return "[File:" + this.mFilePath + ",Size:" + getDataLength() + "]";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mFilePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.task.data.UploadDataSource
 * JD-Core Version:    0.7.0.1
 */