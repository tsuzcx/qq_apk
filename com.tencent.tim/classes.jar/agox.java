import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class agox
  implements aolm.b
{
  final String TAG = "FileHttpUploder<FileAssistant>";
  long YH = 0L;
  long Zr = 0L;
  private aglb jdField_a_of_type_Aglb;
  agpc jdField_a_of_type_Agpc = null;
  agoz b = null;
  private String bHV;
  String bIJ = null;
  String bIm = null;
  auyc c = null;
  final int cYo = 3;
  int cYp = 0;
  final int cYq = 3;
  int cYr = 0;
  final int cYs = 5;
  int cYt = 0;
  boolean ceF = false;
  aoll d = null;
  aolm e = null;
  InputStream k = null;
  File mFile = null;
  private boolean mIsHttps;
  String strUrl = null;
  long uFileSize = 0L;
  
  public agox(QQAppInterface paramQQAppInterface, agoz paramagoz, String paramString1, int paramInt, String paramString2, long paramLong, agpc paramagpc, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.e = paramQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Agpc = paramagpc;
    this.mIsHttps = paramBoolean;
    this.bHV = paramString3;
    int i = paramInt;
    if (paramInt == 0)
    {
      if (this.mIsHttps) {
        i = 443;
      }
    }
    else
    {
      paramagpc = paramString1 + ":" + i;
      paramString1 = new ArrayList(1);
      paramString1.add(paramagpc);
      if ((!TextUtils.isEmpty(paramString4)) && (agke.a().l(paramQQAppInterface, 5)))
      {
        QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. is config enable IPv6. domain[" + paramString4 + "]");
        paramagpc = new agke.a(paramString4, i);
        paramagpc = agke.a().a(paramQQAppInterface, paramagpc, 5);
        if ((paramagpc == null) || (paramagpc.alz())) {
          break label465;
        }
        if (agke.alt())
        {
          QLog.d("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader.debugIsDisableIPv4OnDoubleStack");
          paramString1.clear();
        }
        agke.a(paramagpc.Bb, paramString1, false, false);
        QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. use IPv6. hostlist:" + paramString1.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aglb = new aglb(paramQQAppInterface, paramString1, "/ftn_handler");
      if (this.mIsHttps) {
        this.jdField_a_of_type_Aglb.Jj(true);
      }
      this.strUrl = this.jdField_a_of_type_Aglb.vg();
      this.bIm = paramString2;
      this.bIJ = String.valueOf(paramLong);
      this.b = paramagoz;
      this.c = new auyc();
      this.c.initParam();
      this.mFile = new File(paramString2);
      this.uFileSize = this.mFile.length();
      this.ceF = false;
      return;
      i = 80;
      break;
      label465:
      QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. use IPv4");
    }
  }
  
  public void dgu()
  {
    this.Zr = 0L;
    QLog.i("FileHttpUploder<FileAssistant>", 1, "=_= ^> [Upload Step] Id[" + this.bIJ + "]Send Start url:" + this.strUrl);
    jC(0L);
  }
  
  /* Error */
  byte[] f(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +8 -> 11
    //   6: aload_0
    //   7: lconst_0
    //   8: putfield 68	agox:Zr	J
    //   11: aload_0
    //   12: getfield 66	agox:k	Ljava/io/InputStream;
    //   15: ifnonnull +23 -> 38
    //   18: aload_0
    //   19: new 245	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 58	agox:bIm	Ljava/lang/String;
    //   27: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: putfield 66	agox:k	Ljava/io/InputStream;
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 90	agox:YH	J
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +113 -> 154
    //   44: aload_0
    //   45: getfield 90	agox:YH	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: new 245	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 58	agox:bIm	Ljava/lang/String;
    //   62: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: putfield 66	agox:k	Ljava/io/InputStream;
    //   68: aload_0
    //   69: lconst_0
    //   70: putfield 90	agox:YH	J
    //   73: aload_0
    //   74: lload_1
    //   75: putfield 90	agox:YH	J
    //   78: aload_0
    //   79: getfield 60	agox:c	Lauyc;
    //   82: aload_0
    //   83: getfield 64	agox:uFileSize	J
    //   86: aload_0
    //   87: getfield 68	agox:Zr	J
    //   90: lload_1
    //   91: invokestatic 251	agoy:a	(Lauyc;JJJ)I
    //   94: istore_3
    //   95: iload_3
    //   96: newarray byte
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 66	agox:k	Ljava/io/InputStream;
    //   104: aload 4
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 257	java/io/InputStream:read	([BII)I
    //   111: pop
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 90	agox:YH	J
    //   117: iload_3
    //   118: i2l
    //   119: ladd
    //   120: putfield 90	agox:YH	J
    //   123: aload 4
    //   125: areturn
    //   126: astore 4
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 66	agox:k	Ljava/io/InputStream;
    //   133: aload 4
    //   135: invokevirtual 260	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 66	agox:k	Ljava/io/InputStream;
    //   147: aload 4
    //   149: invokevirtual 260	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aconst_null
    //   153: areturn
    //   154: lload_1
    //   155: aload_0
    //   156: getfield 90	agox:YH	J
    //   159: lcmp
    //   160: ifle +29 -> 189
    //   163: aload_0
    //   164: getfield 66	agox:k	Ljava/io/InputStream;
    //   167: lload_1
    //   168: aload_0
    //   169: getfield 90	agox:YH	J
    //   172: lsub
    //   173: invokevirtual 264	java/io/InputStream:skip	(J)J
    //   176: pop2
    //   177: goto -104 -> 73
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: lload_1
    //   190: aload_0
    //   191: getfield 90	agox:YH	J
    //   194: lcmp
    //   195: ifge -122 -> 73
    //   198: aload_0
    //   199: new 245	java/io/FileInputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 58	agox:bIm	Ljava/lang/String;
    //   207: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   210: putfield 66	agox:k	Ljava/io/InputStream;
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 90	agox:YH	J
    //   218: aload_0
    //   219: getfield 66	agox:k	Ljava/io/InputStream;
    //   222: lload_1
    //   223: invokevirtual 264	java/io/InputStream:skip	(J)J
    //   226: pop2
    //   227: goto -154 -> 73
    //   230: astore 4
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 66	agox:k	Ljava/io/InputStream;
    //   237: aload 4
    //   239: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -126 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	agox
    //   0	252	1	paramLong	long
    //   94	24	3	i	int
    //   98	26	4	arrayOfByte	byte[]
    //   126	8	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   140	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   180	3	4	localIOException1	java.io.IOException
    //   230	8	4	localIOException2	java.io.IOException
    //   244	1	4	localException	Exception
    //   247	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	38	126	java/io/FileNotFoundException
    //   53	73	140	java/io/FileNotFoundException
    //   163	177	180	java/io/IOException
    //   198	227	230	java/io/IOException
    //   100	123	244	java/lang/Exception
  }
  
  public void jC(long paramLong)
  {
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = this.strUrl;
    localaoll.mHttpMethod = 1;
    localaoll.u.put("Accept-Encoding", "identity");
    localaoll.mMsgId = this.bIJ;
    Object localObject = "";
    if (this.strUrl != null) {
      localObject = this.strUrl.toLowerCase();
    }
    if ((this.mIsHttps) && (((String)localObject).startsWith("https")))
    {
      localaoll.mIsHttps = true;
      localaoll.cML = aglb.mp(this.strUrl);
      localaoll.clP = this.bHV;
    }
    try
    {
      localObject = f(paramLong);
      if (localObject == null) {
        return;
      }
      localObject = this.jdField_a_of_type_Agpc.a((byte[])localObject, paramLong, this.b);
      if (localObject != null)
      {
        localaoll.X = ((byte[])localObject);
        this.b.Zv = System.currentTimeMillis();
        this.d = localaoll;
        localaoll.b = ahav.a();
        this.e.a(localaoll);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("FileHttpUploder<FileAssistant>", 1, "=_= ^> logID[" + this.bIJ + "] Exception:" + localException.toString());
      this.b.Zs = 9360L;
      this.b.strErrMsg = ahav.ti();
      this.jdField_a_of_type_Agpc.a(this.b);
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (this.ceF) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileHttpUploder<FileAssistant>", 4, "logID[" + this.bIJ + "]onResp result:" + paramaomh.mResult + " errCode:" + paramaomh.mErrCode + " errDesc:" + paramaomh.clO);
      }
      this.d = null;
      this.b.Zw = System.currentTimeMillis();
      i = paramaomh.dPy;
      if ((paramaomh.mErrCode == 9364) && (this.cYp < 3))
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "]onNetChanged:mNetworkChangRetryCount[" + this.cYp + "] retry!");
        this.cYp += 1;
        this.c.initParam();
        if (this.jdField_a_of_type_Agpc != null)
        {
          this.b.Zs = 9364L;
          this.b.cYv = this.cYp;
          this.b.Zw = System.currentTimeMillis();
          this.jdField_a_of_type_Agpc.a(true, this.b);
        }
        jC(this.Zr);
        return;
      }
      if ((agoy.jL(paramaomh.mErrCode)) && (this.jdField_a_of_type_Aglb != null))
      {
        str = this.jdField_a_of_type_Aglb.vg();
        if (str != null)
        {
          this.strUrl = str;
          jC(this.Zr);
          return;
        }
      }
      if ((i == 200) && (paramaomh.mResult == 0)) {
        break;
      }
      this.b.Zs = paramaomh.mResult;
      this.b.strErrMsg = paramaomh.clO;
      this.b.bIN = ((String)paramaomh.nR.get("param_rspHeader"));
      this.b.bIL = ((String)paramaomh.nR.get("param_url"));
      if ((paramaomh.mResult == 9056) && (this.cYt < 5))
      {
        this.b.diC();
        this.cYt += 1;
        jC(this.Zr);
        return;
      }
      this.jdField_a_of_type_Agpc.a(this.b);
    } while (!QLog.isColorLevel());
    QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "]httpRetCode:" + i + "]onResp result:" + paramaomh.mResult + " errCode:" + paramaomh.mErrCode + " errDesc:" + paramaomh.clO);
    return;
    this.cYt = 0;
    this.c.exX();
    String str = (String)paramaomh.nR.get("User-ReturnCode");
    if (str != null) {}
    for (long l = Long.parseLong(str);; l = 0L)
    {
      if (l != 0L)
      {
        this.b.Zs = -9527L;
        this.b.strErrMsg = ("ResponCode[206]But UserCode[" + String.valueOf(l) + "]");
        this.b.bIN = ((String)paramaomh.nR.get("param_rspHeader"));
        this.jdField_a_of_type_Agpc.a(this.b);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "ResponCode[206]But UserCode[" + l + "]");
        return;
      }
      l = this.jdField_a_of_type_Agpc.a(paramaomh, this.b);
      if (l == -1L)
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "server resp data read len -1");
        if (QLog.isDevelopLevel()) {
          throw new IllegalArgumentException();
        }
      }
      if (l == 0L)
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "server resp data read len 0");
        return;
      }
      if (l == this.uFileSize)
      {
        this.b.Zs = 0L;
        this.b.Zw = (this.b.Zv + 1L);
        this.jdField_a_of_type_Agpc.b(this.b);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "miaochuan");
        return;
      }
      if (l < this.Zr)
      {
        paramaomh = "RangSizeError_rangError tSize[" + String.valueOf(l) + "]<=mSize[" + String.valueOf(this.Zr) + "],reTryafter[" + String.valueOf(this.cYr) + "]";
        QLog.w("FileHttpUploder<FileAssistant>", 1, "nSessionId[" + this.bIJ + "]" + paramaomh);
        this.cYr += 1;
        this.b.Zs = 9009L;
        this.b.strErrMsg = paramaomh;
        if (this.cYr < 3)
        {
          QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "server rang error retry,mmaxRangErrorRetryCount [" + this.cYr + "], maxRangErrorRetry[" + 3 + "]");
          this.b.diC();
          jC(l);
          return;
        }
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "]server rang error not retry,mmaxRangErrorRetryCount [" + this.cYr + "], maxRangErrorRetry[" + 3 + "]");
        this.jdField_a_of_type_Agpc.a(this.b);
        return;
      }
      this.cYr = 0;
      this.Zr = l;
      this.jdField_a_of_type_Agpc.as(this.Zr, this.uFileSize);
      jC(l);
      return;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FileHttpUploder<FileAssistant>", 1, "nID[" + this.bIJ + "]onUpdateProgeress[" + paramLong1 + "]/[" + paramLong2 + "]");
    }
  }
  
  public void stop()
  {
    this.ceF = true;
    this.e.b(this.d);
    try
    {
      this.k.close();
      this.k = null;
      label30:
      if (QLog.isColorLevel()) {
        QLog.d("FileHttpUploder<FileAssistant>", 2, "=_= ^> Id[" + this.bIJ + "]stop");
      }
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agox
 * JD-Core Version:    0.7.0.1
 */