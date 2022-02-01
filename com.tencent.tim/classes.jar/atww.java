import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.HashMap;

public class atww
  implements aolm.b
{
  long YH;
  long Zr;
  private attx jdField_a_of_type_Attx;
  atwz jdField_a_of_type_Atwz;
  atwy b;
  String bIJ;
  String bIm;
  auyc c;
  int cYp;
  int cYr;
  int cYt;
  boolean ceF;
  aoll d;
  aolm e;
  InputStream k;
  String strUrl;
  long uFileSize;
  
  public void dgu()
  {
    this.Zr = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("FileHttpUploder<FileAssistant>", 2, "Id[" + this.bIJ + "]Run");
    }
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
    //   8: putfield 37	atww:Zr	J
    //   11: aload_0
    //   12: getfield 82	atww:k	Ljava/io/InputStream;
    //   15: ifnonnull +23 -> 38
    //   18: aload_0
    //   19: new 84	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 86	atww:bIm	Ljava/lang/String;
    //   27: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: putfield 82	atww:k	Ljava/io/InputStream;
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 91	atww:YH	J
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +113 -> 154
    //   44: aload_0
    //   45: getfield 91	atww:YH	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: new 84	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 86	atww:bIm	Ljava/lang/String;
    //   62: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: putfield 82	atww:k	Ljava/io/InputStream;
    //   68: aload_0
    //   69: lconst_0
    //   70: putfield 91	atww:YH	J
    //   73: aload_0
    //   74: lload_1
    //   75: putfield 91	atww:YH	J
    //   78: aload_0
    //   79: getfield 93	atww:c	Lauyc;
    //   82: aload_0
    //   83: getfield 95	atww:uFileSize	J
    //   86: aload_0
    //   87: getfield 37	atww:Zr	J
    //   90: lload_1
    //   91: invokestatic 100	agoy:a	(Lauyc;JJJ)I
    //   94: istore_3
    //   95: iload_3
    //   96: newarray byte
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 82	atww:k	Ljava/io/InputStream;
    //   104: aload 4
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 106	java/io/InputStream:read	([BII)I
    //   111: pop
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 91	atww:YH	J
    //   117: iload_3
    //   118: i2l
    //   119: ladd
    //   120: putfield 91	atww:YH	J
    //   123: aload 4
    //   125: areturn
    //   126: astore 4
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 82	atww:k	Ljava/io/InputStream;
    //   133: aload 4
    //   135: invokevirtual 109	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 82	atww:k	Ljava/io/InputStream;
    //   147: aload 4
    //   149: invokevirtual 109	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aconst_null
    //   153: areturn
    //   154: lload_1
    //   155: aload_0
    //   156: getfield 91	atww:YH	J
    //   159: lcmp
    //   160: ifle +29 -> 189
    //   163: aload_0
    //   164: getfield 82	atww:k	Ljava/io/InputStream;
    //   167: lload_1
    //   168: aload_0
    //   169: getfield 91	atww:YH	J
    //   172: lsub
    //   173: invokevirtual 113	java/io/InputStream:skip	(J)J
    //   176: pop2
    //   177: goto -104 -> 73
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: lload_1
    //   190: aload_0
    //   191: getfield 91	atww:YH	J
    //   194: lcmp
    //   195: ifge -122 -> 73
    //   198: aload_0
    //   199: new 84	java/io/FileInputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 86	atww:bIm	Ljava/lang/String;
    //   207: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   210: putfield 82	atww:k	Ljava/io/InputStream;
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 91	atww:YH	J
    //   218: aload_0
    //   219: getfield 82	atww:k	Ljava/io/InputStream;
    //   222: lload_1
    //   223: invokevirtual 113	java/io/InputStream:skip	(J)J
    //   226: pop2
    //   227: goto -154 -> 73
    //   230: astore 4
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 82	atww:k	Ljava/io/InputStream;
    //   237: aload 4
    //   239: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -126 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	atww
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
    try
    {
      byte[] arrayOfByte = f(paramLong);
      if (arrayOfByte == null) {
        return;
      }
      arrayOfByte = this.jdField_a_of_type_Atwz.a(arrayOfByte, paramLong, this.b);
      if (arrayOfByte != null)
      {
        localaoll.X = arrayOfByte;
        this.b.Zv = System.currentTimeMillis();
        this.d = localaoll;
        this.e.a(localaoll);
        if (QLog.isColorLevel())
        {
          QLog.i("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "]Send Http Request!");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.i("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "] Exception:" + localException.toString());
      this.b.Zs = 9360L;
      this.b.strErrMsg = audx.ti();
      this.jdField_a_of_type_Atwz.b(this.b);
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
        if (this.jdField_a_of_type_Atwz != null)
        {
          this.b.Zs = 9364L;
          this.b.cYv = this.cYp;
          this.b.Zw = System.currentTimeMillis();
          this.jdField_a_of_type_Atwz.a(true, this.b);
        }
        jC(this.Zr);
        return;
      }
      if ((atwx.jL(paramaomh.mErrCode)) && (this.jdField_a_of_type_Attx != null))
      {
        str = this.jdField_a_of_type_Attx.vg();
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
      this.jdField_a_of_type_Atwz.b(this.b);
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
        this.jdField_a_of_type_Atwz.b(this.b);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.bIJ + "ResponCode[206]But UserCode[" + l + "]");
        return;
      }
      l = this.jdField_a_of_type_Atwz.a(paramaomh, this.b);
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
        this.jdField_a_of_type_Atwz.a(this.b);
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
        this.jdField_a_of_type_Atwz.b(this.b);
        return;
      }
      this.cYr = 0;
      this.Zr = l;
      this.jdField_a_of_type_Atwz.as(this.Zr, this.uFileSize);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atww
 * JD-Core Version:    0.7.0.1
 */