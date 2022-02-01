import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class aojr
  extends aojn
{
  int QV = 0;
  long apw;
  long apx = 20480L;
  public long apy;
  auyc b;
  byte[] bL;
  long bz = 0L;
  protected boolean cMb = true;
  boolean cMc = false;
  boolean cMd = false;
  boolean cMe = false;
  String clf;
  String clg;
  int dOO = 0;
  int dPd = 0;
  public int dPe = -1;
  public int dPf = -1;
  protected int dPg = 0;
  protected byte[] de;
  protected byte[] fH;
  String mFileName;
  long mFileSize;
  int mHeight;
  RandomAccessFile mRaf;
  String mResid;
  public Transaction mTrans;
  String mUkey;
  String mUuid;
  int mWidth;
  ArrayList<aonh> xp = new ArrayList();
  
  public aojr(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Auyc = new auyc();
    setKey(paramaool.mPeerUin + paramaool.mUniseq);
    this.cMb = paramaool.cMb;
  }
  
  public int EN()
  {
    return super.EN();
  }
  
  public void I(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    String str6 = (String)paramHashMap.get("param_conf_connNum");
    String str7 = (String)paramHashMap.get("param_fin_lost");
    this.mM.put("serverip", paramHashMap.get("ip"));
    this.mM.put("param_bdhPort", paramHashMap.get("port"));
    this.mM.put("X-piccachetime", str1);
    this.mM.put("param_BdhTrans", str2);
    this.mM.put("param_segspercnt", str3);
    this.mM.put("param_conf_segSize", str4);
    this.mM.put("param_conf_segNum", str5);
    this.mM.put("param_conf_connNum", str6);
    this.mM.put("param_fin_lost", str7);
    this.mM.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.mM.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.mM.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.mM.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.mM.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.mM.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.mM.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.mM.put("param_BDH_Cache_Diff", paramHashMap.get("param_BDH_Cache_Diff"));
    this.mM.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.mM.put("param_hasV6List", paramHashMap.get("param_hasV6List"));
    this.mM.put("param_ipv6First", paramHashMap.get("param_ipv6First"));
    this.aps = this.mTrans.mTransReport.timeCost_Ht;
    this.apu = this.mTrans.mTransReport.timeCost_Cache;
  }
  
  protected long U(long paramLong)
  {
    long l = this.mFileSize;
    return Math.min(this.apx, l - paramLong);
  }
  
  protected aoll a(byte[] paramArrayOfByte)
  {
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = z(paramArrayOfByte);
    localaoll.mHttpMethod = 1;
    localaoll.X = paramArrayOfByte;
    localaoll.P = this.xp;
    localaoll.mMsgId = String.valueOf(this.h.mUniseq);
    localaoll.dPG = this.h.mUinType;
    localaoll.mFileType = this.h.mFileType;
    localaoll.cMU = true;
    localaoll.u.put("Range", "bytes=" + this.bz + "-");
    localaoll.u.put("Accept-Encoding", "identity");
    return localaoll;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (paramLong1 != 0L) {
      this.app.countFlow(true, 1, paramInt, this.h.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.app.countFlow(true, 1, paramInt, this.h.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.app.countFlow(true, 0, paramInt, this.h.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.app.countFlow(true, 0, paramInt, this.h.mUinType, paramLong4);
    }
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Aomy.mMD5 = paramString4;
    this.jdField_a_of_type_Aomy.bRd = paramString5;
    this.jdField_a_of_type_Aomy.aft = paramString6;
    this.jdField_a_of_type_Aomy.cma = String.valueOf(paramInt);
    this.jdField_a_of_type_Aomy.mServerIp = paramString2;
    this.jdField_a_of_type_Aomy.clZ = paramString3;
    this.jdField_a_of_type_Aomy.mFileSize = this.mFileSize;
    cZ(paramString1, paramBoolean);
  }
  
  protected boolean azS()
  {
    return (this.de != null) && (this.de.length > 0) && (this.fH != null) && (this.fH.length > 0);
  }
  
  /* Error */
  boolean azT()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 249	aojr:h	Laool;
    //   4: getfield 339	aool:dQ	Ljava/lang/String;
    //   7: astore 4
    //   9: new 341	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 343	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 346	aojr:jdField_b_of_type_Aoko	Laoko;
    //   27: getfield 351	aoko:fileSize	J
    //   30: invokestatic 357	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 359	aojr:bL	[B
    //   36: aload_3
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 359	aojr:bL	[B
    //   43: invokestatic 364	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   46: putfield 366	aojr:mFileName	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 366	aojr:mFileName	Ljava/lang/String;
    //   56: putfield 368	aojr:clf	Ljava/lang/String;
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 346	aojr:jdField_b_of_type_Aoko	Laoko;
    //   65: aload_0
    //   66: getfield 366	aojr:mFileName	Ljava/lang/String;
    //   69: putfield 371	aoko:fileMd5	Ljava/lang/String;
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: new 88	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 366	aojr:mFileName	Ljava/lang/String;
    //   86: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 373
    //   92: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 375	aojr:clg	Ljava/lang/String;
    //   99: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 366	aojr:mFileName	Ljava/lang/String;
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 378	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: istore_1
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_2
    //   123: new 380	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 381	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 384	java/io/File:exists	()Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq -107 -> 36
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokestatic 390	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload 4
    //   165: invokestatic 394	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   168: putfield 359	aojr:bL	[B
    //   171: goto -135 -> 36
    //   174: ldc_w 396
    //   177: astore 4
    //   179: goto -19 -> 160
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 399	java/io/IOException:printStackTrace	()V
    //   187: goto -71 -> 116
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 359	aojr:bL	[B
    //   201: aload_3
    //   202: astore_2
    //   203: aload_0
    //   204: aload 4
    //   206: invokevirtual 402	aojr:a	(Ljava/io/IOException;)V
    //   209: iconst_0
    //   210: istore_1
    //   211: aload_3
    //   212: ifnull -94 -> 118
    //   215: aload_3
    //   216: invokevirtual 378	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 399	java/io/IOException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 378	java/io/FileInputStream:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 399	java/io/IOException:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: astore_3
    //   250: goto -19 -> 231
    //   253: astore 4
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -223 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	aojr
    //   117	94	1	bool	boolean
    //   20	54	2	localFileInputStream1	java.io.FileInputStream
    //   120	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   122	40	2	localFileInputStream2	java.io.FileInputStream
    //   182	2	2	localIOException1	IOException
    //   195	8	2	localFileInputStream3	java.io.FileInputStream
    //   221	2	2	localIOException2	IOException
    //   230	6	2	localObject1	Object
    //   241	2	2	localIOException3	IOException
    //   258	1	2	localIOException4	IOException
    //   18	198	3	localFileInputStream4	java.io.FileInputStream
    //   228	12	3	localObject2	Object
    //   249	1	3	localObject3	Object
    //   7	171	4	localObject4	Object
    //   190	15	4	localIOException5	IOException
    //   253	1	4	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	120	java/lang/UnsatisfiedLinkError
    //   112	116	182	java/io/IOException
    //   9	19	190	java/io/IOException
    //   215	219	221	java/io/IOException
    //   9	19	228	finally
    //   235	239	241	java/io/IOException
    //   21	36	249	finally
    //   38	49	249	finally
    //   51	59	249	finally
    //   61	72	249	finally
    //   74	108	249	finally
    //   123	134	249	finally
    //   136	142	249	finally
    //   148	155	249	finally
    //   162	171	249	finally
    //   196	201	249	finally
    //   203	209	249	finally
    //   21	36	253	java/io/IOException
    //   38	49	253	java/io/IOException
    //   51	59	253	java/io/IOException
    //   61	72	253	java/io/IOException
    //   74	108	253	java/io/IOException
    //   123	134	253	java/io/IOException
    //   136	142	253	java/io/IOException
    //   148	155	258	java/io/IOException
    //   162	171	258	java/io/IOException
  }
  
  byte[] b(int paramInt1, int paramInt2)
  {
    try
    {
      this.mRaf.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        int j = this.mRaf.read(arrayOfByte, i, paramInt1);
        if (j == -1)
        {
          dN(9303, "fileSize not enough");
          this.jdField_b_of_type_Aojn$a.dVg();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public int cancel()
  {
    return super.cancel();
  }
  
  protected void dVh()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session().length;
        this.de = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session(), 0, this.de, 0, i);
      }
      if (SessionInfo.getInstance(this.h.mSelfUin).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.h.mSelfUin).getSessionKey().length;
        this.fH = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getSessionKey(), 0, this.fH, 0, i);
      }
      return;
    }
    finally {}
  }
  
  protected void dVi()
  {
    int i = 1;
    if ((this.dPg == 2) && (!this.mM.containsKey("param_BdhTrans"))) {
      if ((this.apt > 0L) && (this.apu > 0L))
      {
        if ((this.cMa) && (i != 0))
        {
          this.W = new StringBuilder();
          this.W.append("s").append(this.dPa).append("_").append("tr").append(this.apt).append("_").append("ht").append(this.aps).append("_").append("pic").append(this.apu).append(";");
          this.mM.put("X-piccachetime", String.valueOf(this.apu));
          this.mM.put("param_CostEach", this.W.toString());
          this.mM.put("param_sliceNum", String.valueOf(this.dPa));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.dPa).append(";").append("tc_s:").append(this.apt).append(";").append("tc_h:").append(this.aps).append(";").append("tc_p:").append(this.apu).append(";");
        this.mM.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.dPg != 1) || (this.mTrans == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        i = 0;
      }
    }
    this.mM.put("X-piccachetime", String.valueOf(this.mTrans.mTransReport.timeCost_Cache));
  }
  
  public void dVj()
  {
    this.mStartTime = System.nanoTime();
  }
  
  protected void diB()
  {
    this.jdField_b_of_type_Aojn$a.dVf();
    long l1 = this.bz;
    long l2 = U(l1);
    Object localObject = b((int)l1, (int)l2);
    if (localObject == null) {
      onError();
    }
    do
    {
      return;
      hM("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.mFileSize) {
        ((aoll)localObject).u.put("Connection", "close");
      }
    } while (!azR());
    this.jdField_a_of_type_Aomg = ((aomg)localObject);
    dVe();
    this.c.a((aomg)localObject);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mRaf != null) {}
    try
    {
      this.mRaf.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.mRaf = null;
    }
  }
  
  public void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        hM("pause", "");
      }
      VR(1004);
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
      if (this.jdField_a_of_type_Aomg != null)
      {
        this.c.b(this.jdField_a_of_type_Aomg);
        this.jdField_a_of_type_Aomg = null;
      }
    }
  }
  
  protected String z(byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojr
 * JD-Core Version:    0.7.0.1
 */