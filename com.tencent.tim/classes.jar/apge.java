import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mqq.os.MqqHandler;

public class apge
  implements aglg, apee.a, apfr
{
  private long YK;
  private long YL;
  protected long YM;
  private long YN;
  public agkz a;
  protected final apee a;
  protected apfs a;
  protected apge.a a;
  protected String bHE;
  private long bz;
  private boolean cQj;
  protected int cXB;
  private boolean cdS;
  private boolean cdT;
  protected int dTX;
  protected final String mFilePath;
  protected final long mFileSize;
  private InputStream mInputStream;
  protected String mIp;
  private boolean mIsStop;
  protected int mPort;
  protected final long mSessionId;
  
  protected apge(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.jdField_a_of_type_Apge$a = new apge.a();
    this.mSessionId = paramLong;
    this.mFilePath = paramString1;
    this.mFileSize = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Apee = new apee(paramQQAppInterface, paramList, paramString4, this.mSessionId, paramBoolean, this);
    this.bHE = this.jdField_a_of_type_Apee.Ba();
    paramString1 = apef.a(this.bHE);
    if (paramString1 != null)
    {
      this.mIp = paramString1.ip;
      this.mPort = paramString1.port;
      this.dTX = paramString1.proxyType;
    }
    this.jdField_a_of_type_Agkz = agkz.a(paramQQAppInterface, this.mSessionId, 1, 0, paramString2, paramString3, this.mFileSize, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Agkz != null) {
      this.jdField_a_of_type_Agkz.a(this);
    }
  }
  
  public static apfr a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strFilePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      apef.b.e("TroopFileUploader", apef.b.USR, "getFileUploader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strFilePath is empty";
      } else if (paramString2 == null) {
        str = "strCheckSum is null";
      } else if (paramString3 == null) {
        str = "strSHA is null";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString4 == null) {
        str = "urlParams is null";
      } else if (paramString4.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new apge(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramList, paramString4, paramBoolean, paramString5);
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
    apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] processRollback" + str);
    if (paramLong <= this.YM)
    {
      int i = this.cXB + 1;
      this.cXB = i;
      if (i > 6)
      {
        this.jdField_a_of_type_Apfs.c(true, paramLong, str, paramString);
        return;
      }
    }
    this.YM = paramLong;
    this.bz = paramLong;
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileUploader.2(this), 6000L);
    this.jdField_a_of_type_Apfs.c(false, paramLong, str, paramString);
  }
  
  private boolean cd(long paramLong)
  {
    byte[] arrayOfByte = f(paramLong);
    if (arrayOfByte == null)
    {
      apef.b.e("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] sendFile. getSendStreamSlice return null");
      ThreadManager.post(new TroopFileUploader.1(this), 5, null, true);
      return false;
    }
    this.mIsStop = false;
    return this.jdField_a_of_type_Agkz.a(this.bHE, paramLong, arrayOfByte);
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
    //   7: invokespecial 280	apge:alB	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 282	apge:YN	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +80 -> 105
    //   28: aload_0
    //   29: getfield 180	apge:mInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 282	apge:YN	J
    //   37: lsub
    //   38: invokevirtual 286	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 282	apge:YN	J
    //   47: aload_0
    //   48: getfield 50	apge:jdField_a_of_type_Apge$a	Lapge$a;
    //   51: aload_0
    //   52: getfield 116	apge:bz	J
    //   55: aload_0
    //   56: getfield 65	apge:mFileSize	J
    //   59: invokevirtual 290	apge$a:d	(JJ)I
    //   62: istore_3
    //   63: iload_3
    //   64: newarray byte
    //   66: astore 7
    //   68: aload_0
    //   69: getfield 180	apge:mInputStream	Ljava/io/InputStream;
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 294	java/io/InputStream:read	([BII)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 282	apge:YN	J
    //   84: lstore_1
    //   85: aload_0
    //   86: iload_3
    //   87: i2l
    //   88: lload_1
    //   89: ladd
    //   90: putfield 282	apge:YN	J
    //   93: aload 7
    //   95: areturn
    //   96: astore 7
    //   98: aload 7
    //   100: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   103: aconst_null
    //   104: areturn
    //   105: lload_1
    //   106: aload_0
    //   107: getfield 282	apge:YN	J
    //   110: lcmp
    //   111: ifge -69 -> 42
    //   114: aload_0
    //   115: invokespecial 280	apge:alB	()Z
    //   118: istore 6
    //   120: iload 6
    //   122: ifeq +72 -> 194
    //   125: aload_0
    //   126: getfield 180	apge:mInputStream	Ljava/io/InputStream;
    //   129: lload_1
    //   130: invokevirtual 286	java/io/InputStream:skip	(J)J
    //   133: pop2
    //   134: goto -92 -> 42
    //   137: astore 7
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 180	apge:mInputStream	Ljava/io/InputStream;
    //   144: aload 7
    //   146: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore 7
    //   153: aload 7
    //   155: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   158: ldc 129
    //   160: iconst_1
    //   161: new 136	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 297
    //   171: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 7
    //   176: invokevirtual 298	java/lang/Exception:toString	()Ljava/lang/String;
    //   179: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aconst_null
    //   189: astore 7
    //   191: goto -98 -> 93
    //   194: aconst_null
    //   195: areturn
    //   196: astore 7
    //   198: aconst_null
    //   199: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	apge
    //   0	200	1	paramLong	long
    //   62	25	3	i	int
    //   19	4	4	l	long
    //   118	3	6	bool	boolean
    //   66	28	7	arrayOfByte	byte[]
    //   96	3	7	localIOException1	IOException
    //   137	8	7	localIOException2	IOException
    //   151	24	7	localException1	Exception
    //   189	1	7	localObject	Object
    //   196	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	96	java/io/IOException
    //   125	134	137	java/io/IOException
    //   68	93	151	java/lang/Exception
    //   6	13	196	java/lang/Exception
    //   15	21	196	java/lang/Exception
    //   28	42	196	java/lang/Exception
    //   42	68	196	java/lang/Exception
    //   98	103	196	java/lang/Exception
    //   105	120	196	java/lang/Exception
    //   125	134	196	java/lang/Exception
    //   139	149	196	java/lang/Exception
    //   153	188	196	java/lang/Exception
  }
  
  private void reSend()
  {
    if (this.mIsStop) {
      return;
    }
    apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] reSend mstrUrl:" + this.bHE);
    this.jdField_a_of_type_Apge$a = new apge.a();
    if (this.jdField_a_of_type_Apfs != null) {
      this.jdField_a_of_type_Apfs.dgC();
    }
    this.bz = 0L;
    cd(0L);
  }
  
  public int EG()
  {
    return this.jdField_a_of_type_Apee.Ez();
  }
  
  public int EH()
  {
    return this.mPort;
  }
  
  public void IK(String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    b(true, this.bz, 9062, "UrlOver", null);
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
        b(true, this.bz, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        b(true, this.bz, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.mIsStop = true;
        this.jdField_a_of_type_Apfs.dgB();
        return;
      }
    }
    if ((paramString1 != null) && (paramString1.contains("SSLPeerUnverifiedException")))
    {
      this.jdField_a_of_type_Apfs.a(true, this.bz, paramInt, paramString1, paramString2);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      b(true, this.bz, paramInt, paramString1, paramString2);
      return;
    }
    this.cQj = false;
    apef.b.e("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    if (this.jdField_a_of_type_Apee.g(this.bHE, paramInt, false))
    {
      b(false, this.bz, paramInt, paramString1, paramString2);
      return;
    }
    b(true, this.bz, paramInt, paramString1, paramString2);
  }
  
  public void SO(String paramString)
  {
    if (this.mIsStop)
    {
      apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.bHE.equalsIgnoreCase(paramString))
    {
      i = 1;
      apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] onRetry urlChanged");
    }
    this.bHE = paramString;
    if (i != 0)
    {
      paramString = apef.a(this.bHE);
      if (paramString != null)
      {
        this.mIp = paramString.ip;
        this.mPort = paramString.port;
        this.dTX = paramString.proxyType;
      }
      this.jdField_a_of_type_Apfs.IC(this.bHE);
    }
    reSend();
  }
  
  public void a(apfs paramapfs)
  {
    this.jdField_a_of_type_Apfs = paramapfs;
  }
  
  public void a(aqog paramaqog)
  {
    paramaqog.setRequestProperty("User-Agent", "TroopFile");
  }
  
  public boolean alC()
  {
    return this.cdT;
  }
  
  public boolean alZ()
  {
    return this.jdField_a_of_type_Apee.alZ();
  }
  
  public boolean ame()
  {
    apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] upload url:" + this.bHE);
    this.mIsStop = false;
    this.cdS = true;
    this.cdT = false;
    boolean bool = cd(0L);
    if ((bool) && (this.YN > 0L))
    {
      this.YL = this.YN;
      return bool;
    }
    this.YL = 0L;
    return bool;
  }
  
  public void at(long paramLong, String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    this.jdField_a_of_type_Apge$a.dhy();
    if (this.cdS)
    {
      this.cdS = false;
      if (paramLong != this.YL) {
        break label57;
      }
    }
    label57:
    for (this.YK = 0L; paramLong <= this.bz; this.YK = paramLong)
    {
      as(paramLong, paramString);
      return;
    }
    if ((this.bz == 0L) && (paramLong == this.mFileSize))
    {
      this.mIsStop = true;
      this.YK = this.mFileSize;
      this.bz = this.mFileSize;
      this.cdT = true;
      this.jdField_a_of_type_Apfs.dgz();
      return;
    }
    this.bz = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileUploader", 2, "send http data size[" + String.valueOf(this.bz) + "] fileSize[" + this.mFileSize + "] success!");
    }
    if (paramLong < this.mFileSize)
    {
      this.jdField_a_of_type_Apfs.jm(paramLong);
      if (!this.cQj)
      {
        this.cQj = true;
        this.jdField_a_of_type_Apee.SN(this.bHE);
      }
      cd(this.bz);
      return;
    }
    this.mIsStop = true;
    this.jdField_a_of_type_Apfs.dgA();
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      this.mIsStop = true;
    }
    this.jdField_a_of_type_Apfs.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  public void bme()
  {
    try
    {
      this.mInputStream.close();
      this.mInputStream = null;
      this.jdField_a_of_type_Agkz.cancel();
      this.mIsStop = true;
      apef.b.i("TroopFileUploader", apef.b.USR, "[" + this.mSessionId + "] cancelTask");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void cs(int paramInt, String paramString)
  {
    if (this.mIsStop) {
      return;
    }
    b(true, this.bz, 9343, "parseDataErr", null);
  }
  
  public long fG()
  {
    return this.YK;
  }
  
  public int getProxyType()
  {
    return this.dTX;
  }
  
  public String getUrl()
  {
    return this.bHE;
  }
  
  public long hq()
  {
    return 6000L;
  }
  
  public void onSuccess()
  {
    if (this.mIsStop) {
      return;
    }
    this.mIsStop = true;
    if (this.cdS)
    {
      this.YK = this.mFileSize;
      this.cdT = true;
    }
    this.bz = this.mFileSize;
    this.jdField_a_of_type_Apfs.dgz();
  }
  
  public String vC()
  {
    return this.mIp;
  }
  
  class a
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apge
 * JD-Core Version:    0.7.0.1
 */