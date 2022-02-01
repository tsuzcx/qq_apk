import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.FileUploader.1;
import com.tencent.tim.filemanager.core.FileUploader.2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class attu
  implements atty
{
  private long YM;
  private long YN;
  private attu.b jdField_a_of_type_Attu$b;
  private attu.c jdField_a_of_type_Attu$c = new attu.a();
  private final attx jdField_a_of_type_Attx;
  private attz jdField_a_of_type_Attz;
  private String bHE;
  private long bz;
  private int cXA;
  private int cXB;
  private int cXx;
  private int cXy;
  private int cXz;
  private final String mFilePath;
  private final long mFileSize;
  private InputStream mInputStream;
  private boolean mIsStop;
  private final long mSessionId;
  
  private attu(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mSessionId = paramLong;
    this.mFilePath = paramString1;
    this.mFileSize = new File(paramString1).length();
    this.jdField_a_of_type_Attx = new attx(paramQQAppInterface, paramString2);
    this.bHE = this.jdField_a_of_type_Attx.vg();
    this.jdField_a_of_type_Attz = atua.a(paramQQAppInterface, this.mSessionId, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Attz != null) {
      this.jdField_a_of_type_Attz.a(this);
    }
  }
  
  private attu(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mSessionId = paramLong;
    this.mFilePath = paramString1;
    this.mFileSize = new File(paramString1).length();
    this.jdField_a_of_type_Attx = new attx(paramQQAppInterface, paramString4);
    this.bHE = this.jdField_a_of_type_Attx.vg();
    this.jdField_a_of_type_Attz = attv.a(paramQQAppInterface, this.mSessionId, paramInt1, paramInt2, paramString2, paramString3, this.mFileSize);
    if (this.jdField_a_of_type_Attz != null) {
      this.jdField_a_of_type_Attz.a(this);
    }
  }
  
  private attu(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4)
  {
    this.mSessionId = paramLong;
    this.mFilePath = paramString1;
    this.mFileSize = new File(paramString1).length();
    this.jdField_a_of_type_Attx = new attx(paramQQAppInterface, paramList, paramString4);
    this.bHE = this.jdField_a_of_type_Attx.vg();
    this.jdField_a_of_type_Attz = attv.a(paramQQAppInterface, this.mSessionId, paramInt1, paramInt2, paramString2, paramString3, this.mFileSize);
    if (this.jdField_a_of_type_Attz != null) {
      this.jdField_a_of_type_Attz.a(this);
    }
  }
  
  private attu(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2)
  {
    this.mSessionId = paramLong;
    this.mFilePath = paramString1;
    this.mFileSize = new File(paramString1).length();
    this.jdField_a_of_type_Attx = new attx(paramQQAppInterface, paramList, paramString2);
    this.bHE = this.jdField_a_of_type_Attx.vg();
    this.jdField_a_of_type_Attz = atua.a(paramQQAppInterface, this.mSessionId, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Attz != null) {
      this.jdField_a_of_type_Attz.a(this);
    }
  }
  
  private void NX(int paramInt)
  {
    String str = null;
    if (this.jdField_a_of_type_Attx != null) {
      str = this.jdField_a_of_type_Attx.vg();
    }
    if ((str == null) || (str.length() == 0))
    {
      QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + this.mSessionId + "] need chang Ip ,but can not get next ip errCode[" + paramInt + "]");
      return;
    }
    this.bHE = str;
    this.cXz += 1;
    this.cXx = 0;
  }
  
  private void NY(int paramInt)
  {
    this.jdField_a_of_type_Attu$c = new attu.a();
    new Handler().postDelayed(new FileUploader.2(this), paramInt);
  }
  
  public static attu a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramString1.length() != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        return null;
        if (paramString2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      return null;
      if (paramString2.length() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
    return null;
    return new attu(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public static attu a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
      }
      return null;
    }
    return new attu(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static attu a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new attu(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramList, paramString4);
  }
  
  public static attu a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new attu(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramList, paramString2);
  }
  
  private boolean alB()
  {
    if (this.mInputStream != null) {}
    try
    {
      this.mInputStream.close();
      this.mInputStream = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          this.mInputStream = new FileInputStream(this.mFilePath);
          return true;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          this.mInputStream = null;
          localFileNotFoundException.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  private void as(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.bz + "], lastRoolbackSize[" + this.YM + "], retry[" + this.cXB + "]";
    if (paramLong <= this.YM)
    {
      int i = this.cXB + 1;
      this.cXB = i;
      if (i > 6)
      {
        this.jdField_a_of_type_Attu$b.c(true, paramLong, str, paramString);
        return;
      }
    }
    this.YM = paramLong;
    this.bz = paramLong;
    new Handler().postDelayed(new FileUploader.1(this), 6000L);
    this.jdField_a_of_type_Attu$b.c(false, paramLong, str, paramString);
  }
  
  /* Error */
  private byte[] f(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: invokespecial 254	attu:alB	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 256	attu:YN	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +82 -> 107
    //   28: aload_0
    //   29: getfield 212	attu:mInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 256	attu:YN	J
    //   37: lsub
    //   38: invokevirtual 260	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 256	attu:YN	J
    //   47: aload_0
    //   48: getfield 48	attu:jdField_a_of_type_Attu$c	Lattu$c;
    //   51: aload_0
    //   52: getfield 158	attu:bz	J
    //   55: aload_0
    //   56: getfield 63	attu:mFileSize	J
    //   59: invokeinterface 264 5 0
    //   64: istore_3
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 7
    //   70: aload_0
    //   71: getfield 212	attu:mInputStream	Ljava/io/InputStream;
    //   74: aload 7
    //   76: iconst_0
    //   77: iload_3
    //   78: invokevirtual 268	java/io/InputStream:read	([BII)I
    //   81: pop
    //   82: aload_0
    //   83: getfield 256	attu:YN	J
    //   86: lstore_1
    //   87: aload_0
    //   88: iload_3
    //   89: i2l
    //   90: lload_1
    //   91: ladd
    //   92: putfield 256	attu:YN	J
    //   95: aload 7
    //   97: areturn
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: lload_1
    //   108: aload_0
    //   109: getfield 256	attu:YN	J
    //   112: lcmp
    //   113: ifge -71 -> 42
    //   116: aload_0
    //   117: invokespecial 254	attu:alB	()Z
    //   120: istore 6
    //   122: iload 6
    //   124: ifeq +72 -> 196
    //   127: aload_0
    //   128: getfield 212	attu:mInputStream	Ljava/io/InputStream;
    //   131: lload_1
    //   132: invokevirtual 260	java/io/InputStream:skip	(J)J
    //   135: pop2
    //   136: goto -94 -> 42
    //   139: astore 7
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 212	attu:mInputStream	Ljava/io/InputStream;
    //   146: aload 7
    //   148: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore 7
    //   155: aload 7
    //   157: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   160: ldc 112
    //   162: iconst_1
    //   163: new 114	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 271
    //   173: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 7
    //   178: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
    //   181: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aconst_null
    //   191: astore 7
    //   193: goto -98 -> 95
    //   196: aconst_null
    //   197: areturn
    //   198: astore 7
    //   200: aconst_null
    //   201: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	attu
    //   0	202	1	paramLong	long
    //   64	25	3	i	int
    //   19	4	4	l	long
    //   120	3	6	bool	boolean
    //   68	28	7	arrayOfByte	byte[]
    //   98	3	7	localIOException1	IOException
    //   139	8	7	localIOException2	IOException
    //   153	24	7	localException1	Exception
    //   191	1	7	localObject	Object
    //   198	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	98	java/io/IOException
    //   127	136	139	java/io/IOException
    //   70	95	153	java/lang/Exception
    //   6	13	198	java/lang/Exception
    //   15	21	198	java/lang/Exception
    //   28	42	198	java/lang/Exception
    //   42	70	198	java/lang/Exception
    //   100	105	198	java/lang/Exception
    //   107	122	198	java/lang/Exception
    //   127	136	198	java/lang/Exception
    //   141	151	198	java/lang/Exception
    //   155	190	198	java/lang/Exception
  }
  
  public void IK(String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.jdField_a_of_type_Attu$b.a(true, this.bz, 9062, "UrlOver", null);
  }
  
  public void M(int paramInt, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        this.jdField_a_of_type_Attu$b.a(true, this.bz, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        this.jdField_a_of_type_Attu$b.a(true, this.bz, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_Attu$b.dgB();
        return;
      }
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Attu$b.a(true, this.bz, paramInt, paramString1, paramString2);
      return;
    }
    if (atwx.jL(paramInt)) {
      NX(paramInt);
    }
    if (this.cXx < 8)
    {
      this.cXA += 1;
      if ((this.cXy < 3) && (9056 == paramInt))
      {
        this.cXy += 1;
        if (paramInt != 9056) {
          break label248;
        }
      }
    }
    label248:
    for (int i = 0;; i = 6000)
    {
      this.jdField_a_of_type_Attu$b.a(false, this.bz, paramInt, paramString1, paramString2);
      NY(i);
      return;
      this.cXy = 0;
      this.cXx += 1;
      break;
      this.jdField_a_of_type_Attu$b.a(true, this.bz, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(attu.b paramb)
  {
    this.jdField_a_of_type_Attu$b = paramb;
  }
  
  public void at(long paramLong, String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.jdField_a_of_type_Attu$c.dhy();
    if (paramLong <= this.bz)
    {
      as(paramLong, paramString);
      return;
    }
    if ((this.bz == 0L) && (paramLong == this.mFileSize))
    {
      this.jdField_a_of_type_Attu$b.dgz();
      return;
    }
    this.bz = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FtnHttpUploader<FileAssistant>", 2, "send http data size[" + String.valueOf(this.bz) + "] fileSize[" + this.mFileSize + "] success!");
    }
    if (paramLong < this.mFileSize)
    {
      this.jdField_a_of_type_Attu$b.jm(paramLong);
      this.cXy = 0;
      this.cXx = 0;
      cd(this.bz);
      return;
    }
    this.jdField_a_of_type_Attu$b.dgA();
  }
  
  public void bme()
  {
    try
    {
      this.mInputStream.close();
      this.mInputStream = null;
      label12:
      this.jdField_a_of_type_Attz.cancel();
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public boolean cd(long paramLong)
  {
    byte[] arrayOfByte = f(paramLong);
    if (arrayOfByte == null)
    {
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "getSendStreamSlice return null");
      return false;
    }
    return this.jdField_a_of_type_Attz.a(this.bHE, paramLong, arrayOfByte);
  }
  
  public void cs(int paramInt, String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.jdField_a_of_type_Attu$b.a(true, this.bz, 9343, "parseDataErr", null);
  }
  
  public int getRetryCount()
  {
    return this.cXx;
  }
  
  public String getUrl()
  {
    return this.bHE;
  }
  
  public void onSuccess()
  {
    if (this.mIsStop) {
      return;
    }
    this.jdField_a_of_type_Attu$b.dgz();
  }
  
  class a
    implements attu.c
  {
    private auyc c = new auyc();
    
    public a()
    {
      this.c.initParam();
    }
    
    public int d(long paramLong1, long paramLong2)
    {
      int j = this.c.a(BaseApplication.getContext(), paramLong2, paramLong1, 1048576);
      int k = auye.getNetWorkType(BaseApplication.getContext());
      int i;
      if (k != 1)
      {
        i = j;
        if (k != 2) {}
      }
      else
      {
        i = j;
        if (j > 16384) {
          i = 16384;
        }
      }
      return i;
    }
    
    public void dhy()
    {
      this.c.exX();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2);
    
    public abstract void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2);
    
    public abstract void dgA();
    
    public abstract void dgB();
    
    public abstract void dgz();
    
    public abstract void jm(long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract int d(long paramLong1, long paramLong2);
    
    public abstract void dhy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attu
 * JD-Core Version:    0.7.0.1
 */