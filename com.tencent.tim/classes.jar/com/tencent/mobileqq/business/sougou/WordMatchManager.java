package com.tencent.mobileqq.business.sougou;

import acbn;
import adyl;
import adyo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import aprb;
import aprb.a;
import aqul;
import aszr;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class WordMatchManager
  implements Manager
{
  protected static final String aEA = aqul.getSDKPrivatePath(acbn.SDCARD_ROOT + "/Tencent/QQ_business");
  protected aprb.a a;
  protected a a;
  protected b a;
  protected f a;
  protected a b = new a();
  protected boolean bSf;
  protected boolean bSg;
  protected boolean bSh;
  boolean bSi = false;
  protected QQAppInterface mApp;
  boolean soLoaded = false;
  protected ArrayList<e> vc = new ArrayList();
  
  public WordMatchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f = new HotWordMatcher();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b = new b();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$a = new a();
    this.jdField_a_of_type_Aprb$a = new adyo(this);
    this.mApp = paramQQAppInterface;
    paramQQAppInterface.getApp();
    try
    {
      if (!this.soLoaded) {
        SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
      }
    }
    catch (UnsatisfiedLinkError paramQQAppInterface)
    {
      for (;;)
      {
        try
        {
          this.soLoaded = SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getContext(), "Matcher", 0, false);
          return;
        }
        catch (UnsatisfiedLinkError paramQQAppInterface)
        {
          this.soLoaded = false;
          paramQQAppInterface.printStackTrace();
        }
        paramQQAppInterface = paramQQAppInterface;
        QLog.e(".business.sougou.DicFileDownloader", 2, "load stl failed!", paramQQAppInterface);
      }
    }
  }
  
  private String calcMD5(String paramString)
  {
    System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break label56;
        }
        try
        {
          String str2 = aszr.getFileMD5String(paramString);
          paramString = str2;
          if (str2 != null) {
            continue;
          }
          return "";
        }
        catch (IOException paramString)
        {
          return "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return paramString;
    label56:
    return "";
  }
  
  protected long D(int paramInt)
  {
    return this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getLong("DICT_LAST_MODIFIED_" + paramInt, 0L);
  }
  
  public void GU(boolean paramBoolean)
  {
    ThreadManager.post(new WordMatchManager.3(this, paramBoolean), 5, null, true);
    if (QLog.isDevelopLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 4, "handleUpdateCompleted:" + paramBoolean);
    }
  }
  
  protected void LH(int paramInt)
  {
    this.mApp.runOnUiThread(new WordMatchManager.5(this, paramInt));
  }
  
  /* Error */
  protected void LI(int paramInt)
  {
    // Byte code:
    //   0: new 175	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 256	com/tencent/mobileqq/business/sougou/WordMatchManager:dM	(I)Ljava/lang/String;
    //   9: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 9
    //   14: iconst_4
    //   15: newarray byte
    //   17: astore 10
    //   19: new 258	java/io/FileInputStream
    //   22: dup
    //   23: aload 9
    //   25: invokespecial 261	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 8
    //   30: aload 8
    //   32: astore 7
    //   34: aload 8
    //   36: aload 10
    //   38: invokevirtual 267	java/io/InputStream:read	([B)I
    //   41: pop
    //   42: aload 8
    //   44: astore 7
    //   46: aload 8
    //   48: aload 10
    //   50: invokevirtual 267	java/io/InputStream:read	([B)I
    //   53: pop
    //   54: aload 8
    //   56: astore 7
    //   58: aload 10
    //   60: invokestatic 272	adyl:u	([B)I
    //   63: istore_1
    //   64: iload_1
    //   65: iconst_4
    //   66: iadd
    //   67: i2l
    //   68: lstore_3
    //   69: aload 8
    //   71: astore 7
    //   73: aload 9
    //   75: invokevirtual 275	java/io/File:length	()J
    //   78: lstore 5
    //   80: lload_3
    //   81: lload 5
    //   83: lcmp
    //   84: ifle +22 -> 106
    //   87: aload 8
    //   89: ifnull +8 -> 97
    //   92: aload 8
    //   94: invokevirtual 278	java/io/InputStream:close	()V
    //   97: return
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: aload 8
    //   108: astore 7
    //   110: iload_1
    //   111: newarray byte
    //   113: astore 9
    //   115: aload 8
    //   117: astore 7
    //   119: aload 8
    //   121: aload 9
    //   123: invokevirtual 267	java/io/InputStream:read	([B)I
    //   126: pop
    //   127: aload 8
    //   129: astore 7
    //   131: new 281	java/lang/String
    //   134: dup
    //   135: aload 9
    //   137: invokespecial 284	java/lang/String:<init>	([B)V
    //   140: astore 9
    //   142: aload 9
    //   144: astore 7
    //   146: aload 8
    //   148: ifnull +12 -> 160
    //   151: aload 8
    //   153: invokevirtual 278	java/io/InputStream:close	()V
    //   156: aload 9
    //   158: astore 7
    //   160: new 286	org/json/JSONObject
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 287	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   169: ldc_w 289
    //   172: invokevirtual 293	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   175: astore 7
    //   177: iconst_0
    //   178: istore_1
    //   179: iload_1
    //   180: aload 7
    //   182: invokevirtual 298	org/json/JSONArray:length	()I
    //   185: if_icmpge -88 -> 97
    //   188: aload 7
    //   190: iload_1
    //   191: invokevirtual 302	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   194: astore 8
    //   196: aload 8
    //   198: ldc_w 304
    //   201: invokevirtual 307	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: ldc_w 309
    //   207: invokevirtual 313	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   210: ifeq +29 -> 239
    //   213: aload 8
    //   215: ldc_w 315
    //   218: invokevirtual 319	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   221: istore_2
    //   222: aload_0
    //   223: getfield 100	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$b;
    //   226: getfield 323	com/tencent/mobileqq/business/sougou/WordMatchManager$b:ch	Ljava/util/Set;
    //   229: iload_2
    //   230: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 335 2 0
    //   238: pop
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: goto -64 -> 179
    //   246: astore 7
    //   248: aload 7
    //   250: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   253: aload 9
    //   255: astore 7
    //   257: goto -97 -> 160
    //   260: astore 9
    //   262: aconst_null
    //   263: astore 8
    //   265: aload 8
    //   267: astore 7
    //   269: aload 9
    //   271: invokevirtual 336	java/io/FileNotFoundException:printStackTrace	()V
    //   274: aload 8
    //   276: ifnull +125 -> 401
    //   279: aload 8
    //   281: invokevirtual 278	java/io/InputStream:close	()V
    //   284: ldc 190
    //   286: astore 7
    //   288: goto -128 -> 160
    //   291: astore 7
    //   293: aload 7
    //   295: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   298: ldc 190
    //   300: astore 7
    //   302: goto -142 -> 160
    //   305: astore 9
    //   307: aconst_null
    //   308: astore 8
    //   310: aload 8
    //   312: astore 7
    //   314: aload 9
    //   316: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   319: aload 8
    //   321: ifnull +80 -> 401
    //   324: aload 8
    //   326: invokevirtual 278	java/io/InputStream:close	()V
    //   329: ldc 190
    //   331: astore 7
    //   333: goto -173 -> 160
    //   336: astore 7
    //   338: aload 7
    //   340: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   343: ldc 190
    //   345: astore 7
    //   347: goto -187 -> 160
    //   350: astore 8
    //   352: aconst_null
    //   353: astore 7
    //   355: aload 7
    //   357: ifnull +8 -> 365
    //   360: aload 7
    //   362: invokevirtual 278	java/io/InputStream:close	()V
    //   365: aload 8
    //   367: athrow
    //   368: astore 7
    //   370: aload 7
    //   372: invokevirtual 279	java/io/IOException:printStackTrace	()V
    //   375: goto -10 -> 365
    //   378: astore 7
    //   380: aload 7
    //   382: invokevirtual 337	org/json/JSONException:printStackTrace	()V
    //   385: return
    //   386: astore 8
    //   388: goto -33 -> 355
    //   391: astore 9
    //   393: goto -83 -> 310
    //   396: astore 9
    //   398: goto -133 -> 265
    //   401: ldc 190
    //   403: astore 7
    //   405: goto -245 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	WordMatchManager
    //   0	408	1	paramInt	int
    //   221	9	2	i	int
    //   68	13	3	l1	long
    //   78	4	5	l2	long
    //   32	40	7	localObject1	Object
    //   98	3	7	localIOException1	IOException
    //   108	81	7	localObject2	Object
    //   246	3	7	localIOException2	IOException
    //   255	32	7	localObject3	Object
    //   291	3	7	localIOException3	IOException
    //   300	32	7	localObject4	Object
    //   336	3	7	localIOException4	IOException
    //   345	16	7	str1	String
    //   368	3	7	localIOException5	IOException
    //   378	3	7	localJSONException	org.json.JSONException
    //   403	1	7	str2	String
    //   28	297	8	localObject5	Object
    //   350	16	8	localObject6	Object
    //   386	1	8	localObject7	Object
    //   12	242	9	localObject8	Object
    //   260	10	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   305	10	9	localIOException6	IOException
    //   391	1	9	localIOException7	IOException
    //   396	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   17	42	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   92	97	98	java/io/IOException
    //   151	156	246	java/io/IOException
    //   14	30	260	java/io/FileNotFoundException
    //   279	284	291	java/io/IOException
    //   14	30	305	java/io/IOException
    //   324	329	336	java/io/IOException
    //   14	30	350	finally
    //   360	365	368	java/io/IOException
    //   160	177	378	org/json/JSONException
    //   179	239	378	org/json/JSONException
    //   34	42	386	finally
    //   46	54	386	finally
    //   58	64	386	finally
    //   73	80	386	finally
    //   110	115	386	finally
    //   119	127	386	finally
    //   131	142	386	finally
    //   269	274	386	finally
    //   314	319	386	finally
    //   34	42	391	java/io/IOException
    //   46	54	391	java/io/IOException
    //   58	64	391	java/io/IOException
    //   73	80	391	java/io/IOException
    //   110	115	391	java/io/IOException
    //   119	127	391	java/io/IOException
    //   131	142	391	java/io/IOException
    //   34	42	396	java/io/FileNotFoundException
    //   46	54	396	java/io/FileNotFoundException
    //   58	64	396	java/io/FileNotFoundException
    //   73	80	396	java/io/FileNotFoundException
    //   110	115	396	java/io/FileNotFoundException
    //   119	127	396	java/io/FileNotFoundException
    //   131	142	396	java/io/FileNotFoundException
  }
  
  public f a(e parame)
  {
    if (!this.soLoaded) {
      return null;
    }
    if (this.bSg) {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f;
    }
    this.mApp.runOnUiThread(new WordMatchManager.1(this, parame));
    return null;
  }
  
  public void a(a parama)
  {
    if (parama.flag != 1)
    {
      LH(parama.type);
      return;
    }
    if (parama.type == 2) {
      this.b = parama;
    }
    for (;;)
    {
      ThreadManager.post(new TaskHttpDownload(parama.type), 8, null, true);
      return;
      if (parama.type == 1) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$a = parama;
      }
    }
  }
  
  public void a(e parame)
  {
    this.mApp.runOnUiThread(new WordMatchManager.2(this, parame));
  }
  
  protected void ae(int paramInt, long paramLong)
  {
    this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).edit().putLong("DICT_LAST_MODIFIED_" + paramInt, paramLong).commit();
  }
  
  protected void b(a parama)
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    localSharedPreferences.edit().putString("REQUEST_DICT_MD5_" + parama.type, parama.md5).commit();
    localSharedPreferences.edit().putString("DICT_ID_" + parama.type, parama.id).commit();
    localSharedPreferences.edit().putString("DICT_MD5_" + parama.type, parama.bwo).commit();
  }
  
  protected void cVk()
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    long l1 = localSharedPreferences.getLong("DICT_LAST_REQUEST_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.bSf) && (l2 - l1 < 86400L))
    {
      GU(true);
      return;
    }
    this.bSf = true;
    localSharedPreferences.edit().putLong("DICT_LAST_REQUEST_TIME", l2).commit();
    u(this.mApp, 2);
  }
  
  protected String dM(int paramInt)
  {
    String str = aEA;
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return str + File.separator + "small";
    case 2: 
      return str + File.separator + "big";
    case 3: 
      return str + File.separator + "dict.xdb";
    }
    return str + File.separator + "rules.ini";
  }
  
  protected String dN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "https://pub.idqqimg.com/pc/qqclient/sfile/small.gz";
    case 2: 
      return "https://pub.idqqimg.com/pc/qqclient/sfile/big.gz";
    case 3: 
      return "https://pub.idqqimg.com/pc/qqclient/sfile/wsdict.gz";
    }
    return "https://pub.idqqimg.com/pc/qqclient/sfile/srule.gz";
  }
  
  protected String dO(int paramInt)
  {
    return this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_ID_" + paramInt, "0");
  }
  
  protected String dP(int paramInt)
  {
    return this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("REQUEST_DICT_MD5_" + paramInt, "0");
  }
  
  protected String dQ(int paramInt)
  {
    return this.mApp.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_MD5_" + paramInt, "0");
  }
  
  protected boolean iW(int paramInt)
  {
    String str = dM(paramInt);
    if (!new File(str).exists()) {
      return false;
    }
    return dQ(paramInt).equalsIgnoreCase(adyl.kc(str));
  }
  
  protected void initEnvironment()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b.bSj = iW(2);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b.bSk = iW(1);
    b localb = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b;
    if ((iW(3)) && (iW(4))) {}
    for (boolean bool = true;; bool = false)
    {
      localb.bSl = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b.bSj) {
        LI(2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$b.bSk) {
        LI(1);
      }
      return;
    }
  }
  
  public void onDestroy() {}
  
  protected void u(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi begin| type:" + paramInt + ",time:" + System.currentTimeMillis());
    }
    Object localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    localObject2 = ((TicketManager)localObject2).getSkey(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putString("type", "" + paramInt);
    paramQQAppInterface.putString("id", dO(paramInt));
    paramQQAppInterface.putString("md5", "" + dP(paramInt));
    paramQQAppInterface.putString("version", "3.4.4");
    paramQQAppInterface.putString("platform", "android");
    paramQQAppInterface.putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + (String)localObject2);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", paramQQAppInterface);
    ((HashMap)localObject1).put("CONTEXT", BaseApplication.getContext());
    new aprb("https://cgi.qqweb.qq.com/cgi-bin/frequency/whether_request_cdn", "POST", this.jdField_a_of_type_Aprb$a, paramInt, null, true).execute(new HashMap[] { localObject1 });
  }
  
  public static class HotWordItem
  {
    public String hotWord = "";
    public int offset;
  }
  
  class HotWordMatcher
    implements WordMatchManager.f
  {
    protected Queue<WordMatchManager.d> G = new LinkedList();
    protected WordMatchManager.d a = new WordMatchManager.d();
    protected boolean bSm;
    protected int cLv = 0;
    
    HotWordMatcher()
    {
      onMatchResult(null);
    }
    
    public void LJ(int paramInt)
    {
      Object localObject = null;
      if (paramInt <= 0) {}
      label92:
      label93:
      for (;;)
      {
        return;
        if ((this.a != null) && (paramInt == this.a.taskId))
        {
          this.a = null;
          return;
        }
        Iterator localIterator = this.G.iterator();
        if (localIterator.hasNext())
        {
          WordMatchManager.d locald = (WordMatchManager.d)localIterator.next();
          if (locald.taskId != paramInt) {
            break label92;
          }
          localObject = locald;
        }
        for (;;)
        {
          break;
          if (localObject == null) {
            break label93;
          }
          this.G.remove(localObject);
          return;
        }
      }
    }
    
    protected native boolean Match(byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5);
    
    public int a(int paramInt1, String paramString, int paramInt2, WordMatchManager.c paramc)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        return -4;
      }
      if (isRequestExist(paramInt1, paramc)) {
        return -2;
      }
      if (this.bSm)
      {
        locald = new WordMatchManager.d();
        i = this.cLv + 1;
        this.cLv = i;
        locald.taskId = i;
        locald.cLx = paramInt2;
        locald.requestCode = paramInt1;
        locald.strContent = paramString;
        locald.gD = new WeakReference(paramc);
        this.G.add(locald);
        return locald.taskId;
      }
      if (this.a == null) {
        this.a = new WordMatchManager.d();
      }
      WordMatchManager.d locald = this.a;
      int i = this.cLv + 1;
      this.cLv = i;
      locald.taskId = i;
      this.a.cLx = paramInt2;
      this.a.requestCode = paramInt1;
      this.a.strContent = paramString;
      this.a.gD = new WeakReference(paramc);
      return executeMatchTask(this.a);
    }
    
    protected void dispatchNextTask()
    {
      this.bSm = false;
      if (!this.G.isEmpty())
      {
        this.a = ((WordMatchManager.d)this.G.remove());
        executeMatchTask(this.a);
        return;
      }
      this.a = null;
    }
    
    protected int executeMatchTask(WordMatchManager.d paramd)
    {
      Object localObject5 = null;
      if (!WordMatchManager.this.bSg) {}
      while ((!WordMatchManager.this.a.bSj) && (!WordMatchManager.this.a.bSk)) {
        return -3;
      }
      this.bSm = true;
      int j = paramd.cLx;
      try
      {
        arrayOfByte4 = paramd.strContent.getBytes("GB2312");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        for (;;)
        {
          byte[] arrayOfByte1;
          Object localObject6;
          label119:
          Object localObject7;
          int i;
          Object localObject1 = null;
          arrayOfByte2 = null;
          arrayOfByte3 = null;
          byte[] arrayOfByte4 = null;
        }
      }
      try
      {
        arrayOfByte3 = WordMatchManager.this.dM(2).getBytes();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        Object localObject2 = null;
        arrayOfByte2 = null;
        arrayOfByte3 = null;
        break label119;
      }
      try
      {
        arrayOfByte2 = WordMatchManager.this.dM(1).getBytes();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException3)
      {
        Object localObject3 = null;
        arrayOfByte2 = null;
        break label119;
      }
      try
      {
        arrayOfByte1 = WordMatchManager.this.dM(3).getBytes();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException4)
      {
        Object localObject4 = null;
        break label119;
      }
      try
      {
        localObject6 = WordMatchManager.this.dM(4).getBytes();
        localObject5 = localObject6;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException5)
      {
        break label119;
      }
      localObject7 = WordMatchManager.this.a.ch;
      localObject6 = new int[((Set)localObject7).size()];
      localObject7 = ((Set)localObject7).iterator();
      i = 0;
      while (((Iterator)localObject7).hasNext())
      {
        localObject6[i] = ((Integer)((Iterator)localObject7).next()).intValue();
        i += 1;
      }
      ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, arrayOfByte4, j, (int[])localObject6, arrayOfByte3, arrayOfByte2, arrayOfByte1, localObject5));
      return paramd.taskId;
    }
    
    protected boolean isRequestExist(int paramInt, WordMatchManager.c paramc)
    {
      if ((this.a != null) && (this.a.requestCode == paramInt) && (this.a.gD == paramc)) {
        return true;
      }
      Iterator localIterator = this.G.iterator();
      while (localIterator.hasNext())
      {
        WordMatchManager.d locald = (WordMatchManager.d)localIterator.next();
        if ((locald.requestCode == paramInt) && (locald.gD == paramc)) {
          return true;
        }
      }
      return false;
    }
    
    protected void onMatchResult(WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
    {
      if (WordMatchManager.this.mApp == null) {
        return;
      }
      WordMatchManager.this.mApp.runOnUiThread(new WordMatchManager.HotWordMatcher.1(this, paramArrayOfHotWordItem));
    }
  }
  
  public class TaskHttpDownload
    implements Runnable
  {
    int cLy = 0;
    
    TaskHttpDownload(int paramInt)
    {
      this.cLy = paramInt;
    }
    
    /* Error */
    private java.net.HttpURLConnection a(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   4: iload_1
      //   5: invokevirtual 33	com/tencent/mobileqq/business/sougou/WordMatchManager:dN	(I)Ljava/lang/String;
      //   8: astore 4
      //   10: new 35	java/net/URL
      //   13: dup
      //   14: aload 4
      //   16: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
      //   19: astore_2
      //   20: aload_2
      //   21: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   24: checkcast 44	java/net/HttpURLConnection
      //   27: astore_3
      //   28: aload_3
      //   29: ifnonnull +42 -> 71
      //   32: aconst_null
      //   33: astore_2
      //   34: aload_2
      //   35: areturn
      //   36: astore_2
      //   37: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   40: ifeq +29 -> 69
      //   43: ldc 52
      //   45: iconst_2
      //   46: new 54	java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   53: ldc 57
      //   55: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: aload 4
      //   60: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   63: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   66: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   69: aconst_null
      //   70: areturn
      //   71: aload_3
      //   72: sipush 30000
      //   75: invokevirtual 73	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   78: aload_3
      //   79: aload_0
      //   80: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   83: iload_1
      //   84: invokevirtual 77	com/tencent/mobileqq/business/sougou/WordMatchManager:D	(I)J
      //   87: invokevirtual 81	java/net/HttpURLConnection:setIfModifiedSince	(J)V
      //   90: aload_3
      //   91: sipush 30000
      //   94: invokevirtual 84	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   97: aload_3
      //   98: ldc 86
      //   100: invokevirtual 89	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   103: aload_3
      //   104: astore_2
      //   105: aload_3
      //   106: invokevirtual 93	java/net/HttpURLConnection:getResponseCode	()I
      //   109: sipush 200
      //   112: if_icmpeq -78 -> 34
      //   115: aload_3
      //   116: invokevirtual 93	java/net/HttpURLConnection:getResponseCode	()I
      //   119: istore_1
      //   120: aload_3
      //   121: astore_2
      //   122: iload_1
      //   123: sipush 206
      //   126: if_icmpeq -92 -> 34
      //   129: aconst_null
      //   130: areturn
      //   131: astore_2
      //   132: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   135: ifeq +29 -> 164
      //   138: ldc 52
      //   140: iconst_2
      //   141: new 54	java/lang/StringBuilder
      //   144: dup
      //   145: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   148: ldc 95
      //   150: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: aload 4
      //   155: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   158: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   161: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   164: aconst_null
      //   165: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	166	0	this	TaskHttpDownload
      //   0	166	1	paramInt	int
      //   19	16	2	localURL	java.net.URL
      //   36	1	2	localMalformedURLException	java.net.MalformedURLException
      //   104	18	2	localObject	Object
      //   131	1	2	localIOException	IOException
      //   27	94	3	localHttpURLConnection	java.net.HttpURLConnection
      //   8	146	4	str	String
      // Exception table:
      //   from	to	target	type
      //   10	20	36	java/net/MalformedURLException
      //   20	28	131	java/io/IOException
      //   71	103	131	java/io/IOException
      //   105	120	131	java/io/IOException
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   6: ifeq +42 -> 48
      //   9: ldc 52
      //   11: iconst_4
      //   12: new 54	java/lang/StringBuilder
      //   15: dup
      //   16: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   19: ldc 103
      //   21: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: aload_0
      //   25: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   28: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   31: ldc 108
      //   33: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   39: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   42: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   48: invokestatic 122	arug:cC	()Z
      //   51: ifne +240 -> 291
      //   54: iconst_0
      //   55: istore_2
      //   56: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   59: ifeq +51 -> 110
      //   62: ldc 52
      //   64: iconst_4
      //   65: new 54	java/lang/StringBuilder
      //   68: dup
      //   69: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   72: ldc 124
      //   74: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: aload_0
      //   78: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   81: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   84: ldc 126
      //   86: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: iload_2
      //   90: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   93: ldc 108
      //   95: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   101: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   104: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   107: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   110: iload_2
      //   111: ifeq +644 -> 755
      //   114: aload_0
      //   115: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   118: iconst_1
      //   119: if_icmpne +573 -> 692
      //   122: aload_0
      //   123: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   126: getfield 132	com/tencent/mobileqq/business/sougou/WordMatchManager:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$a;
      //   129: astore_3
      //   130: aload_0
      //   131: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   134: iconst_1
      //   135: putfield 136	com/tencent/mobileqq/business/sougou/WordMatchManager:bSi	Z
      //   138: aload_0
      //   139: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   142: getfield 132	com/tencent/mobileqq/business/sougou/WordMatchManager:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$a;
      //   145: getfield 142	com/tencent/mobileqq/business/sougou/WordMatchManager$a:md5	Ljava/lang/String;
      //   148: astore 4
      //   150: aload 4
      //   152: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   155: ifne +576 -> 731
      //   158: aload_0
      //   159: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   162: iconst_2
      //   163: if_icmpeq +11 -> 174
      //   166: aload_0
      //   167: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   170: iconst_1
      //   171: if_icmpne +560 -> 731
      //   174: aload 4
      //   176: invokevirtual 153	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   179: astore 4
      //   181: aload_0
      //   182: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   185: new 54	java/lang/StringBuilder
      //   188: dup
      //   189: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   192: aload_0
      //   193: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   196: aload_0
      //   197: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   200: invokevirtual 156	com/tencent/mobileqq/business/sougou/WordMatchManager:dM	(I)Ljava/lang/String;
      //   203: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: ldc 158
      //   208: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   211: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   214: invokestatic 161	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager;Ljava/lang/String;)Ljava/lang/String;
      //   217: astore 5
      //   219: aload 5
      //   221: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   224: ifne +16 -> 240
      //   227: aload 5
      //   229: invokevirtual 153	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   232: aload 4
      //   234: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   237: ifne +494 -> 731
      //   240: aload_0
      //   241: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   244: iconst_0
      //   245: invokevirtual 169	com/tencent/mobileqq/business/sougou/WordMatchManager:GU	(Z)V
      //   248: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   251: ifeq +39 -> 290
      //   254: ldc 52
      //   256: iconst_2
      //   257: new 54	java/lang/StringBuilder
      //   260: dup
      //   261: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   264: ldc 171
      //   266: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: aload 5
      //   271: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   274: ldc 173
      //   276: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   279: aload 4
      //   281: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   284: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   287: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   290: return
      //   291: new 175	java/io/File
      //   294: dup
      //   295: getstatic 178	com/tencent/mobileqq/business/sougou/WordMatchManager:aEA	Ljava/lang/String;
      //   298: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
      //   301: astore_3
      //   302: aload_3
      //   303: invokevirtual 182	java/io/File:exists	()Z
      //   306: ifne +8 -> 314
      //   309: aload_3
      //   310: invokevirtual 185	java/io/File:mkdir	()Z
      //   313: pop
      //   314: new 54	java/lang/StringBuilder
      //   317: dup
      //   318: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   321: aload_0
      //   322: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   325: aload_0
      //   326: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   329: invokevirtual 156	com/tencent/mobileqq/business/sougou/WordMatchManager:dM	(I)Ljava/lang/String;
      //   332: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   335: ldc 158
      //   337: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   340: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   343: astore_3
      //   344: new 175	java/io/File
      //   347: dup
      //   348: aload_3
      //   349: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
      //   352: astore 6
      //   354: aload 6
      //   356: invokevirtual 182	java/io/File:exists	()Z
      //   359: ifeq +53 -> 412
      //   362: aload 6
      //   364: invokevirtual 188	java/io/File:delete	()Z
      //   367: ifne +39 -> 406
      //   370: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   373: ifeq +416 -> 789
      //   376: ldc 52
      //   378: iconst_4
      //   379: new 54	java/lang/StringBuilder
      //   382: dup
      //   383: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   386: ldc 190
      //   388: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: aload_3
      //   392: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   395: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   398: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   401: iconst_0
      //   402: istore_2
      //   403: goto -347 -> 56
      //   406: aload 6
      //   408: invokevirtual 193	java/io/File:createNewFile	()Z
      //   411: pop
      //   412: invokestatic 199	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   415: invokestatic 205	apsv:aH	(Landroid/content/Context;)I
      //   418: iconst_2
      //   419: if_icmpeq +46 -> 465
      //   422: iconst_0
      //   423: istore_2
      //   424: goto -368 -> 56
      //   427: astore 5
      //   429: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   432: ifeq +28 -> 460
      //   435: ldc 52
      //   437: iconst_4
      //   438: new 54	java/lang/StringBuilder
      //   441: dup
      //   442: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   445: ldc 207
      //   447: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   450: aload_3
      //   451: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   454: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   457: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   460: iconst_0
      //   461: istore_2
      //   462: goto -406 -> 56
      //   465: aload_0
      //   466: aload_0
      //   467: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   470: invokespecial 209	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	(I)Ljava/net/HttpURLConnection;
      //   473: astore 5
      //   475: aload 5
      //   477: ifnonnull +8 -> 485
      //   480: iconst_0
      //   481: istore_2
      //   482: goto -426 -> 56
      //   485: aload 5
      //   487: invokevirtual 93	java/net/HttpURLConnection:getResponseCode	()I
      //   490: sipush 200
      //   493: if_icmpeq +8 -> 501
      //   496: iconst_0
      //   497: istore_2
      //   498: goto -442 -> 56
      //   501: aload 5
      //   503: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   506: astore 7
      //   508: new 215	java/io/FileOutputStream
      //   511: dup
      //   512: aload 6
      //   514: iconst_1
      //   515: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   518: astore 6
      //   520: sipush 4096
      //   523: newarray byte
      //   525: astore 8
      //   527: aload 7
      //   529: aload 8
      //   531: invokevirtual 224	java/io/InputStream:read	([B)I
      //   534: istore_1
      //   535: iload_1
      //   536: iconst_m1
      //   537: if_icmpeq +48 -> 585
      //   540: aload 6
      //   542: aload 8
      //   544: iconst_0
      //   545: iload_1
      //   546: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
      //   549: goto -22 -> 527
      //   552: astore 8
      //   554: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   557: ifeq +28 -> 585
      //   560: ldc 52
      //   562: iconst_4
      //   563: new 54	java/lang/StringBuilder
      //   566: dup
      //   567: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   570: ldc 230
      //   572: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   575: aload_3
      //   576: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   579: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   582: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   585: aload 7
      //   587: invokevirtual 233	java/io/InputStream:close	()V
      //   590: aload 6
      //   592: invokevirtual 234	java/io/FileOutputStream:close	()V
      //   595: aload_3
      //   596: aload_0
      //   597: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   600: aload_0
      //   601: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   604: invokevirtual 156	com/tencent/mobileqq/business/sougou/WordMatchManager:dM	(I)Ljava/lang/String;
      //   607: invokestatic 240	adyl:aN	(Ljava/lang/String;Ljava/lang/String;)Z
      //   610: ifeq +179 -> 789
      //   613: aload_0
      //   614: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   617: aload_0
      //   618: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   621: aload 5
      //   623: invokevirtual 243	java/net/HttpURLConnection:getLastModified	()J
      //   626: invokevirtual 247	com/tencent/mobileqq/business/sougou/WordMatchManager:ae	(IJ)V
      //   629: iconst_1
      //   630: istore_2
      //   631: goto -575 -> 56
      //   634: astore 6
      //   636: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   639: ifeq +28 -> 667
      //   642: ldc 52
      //   644: iconst_4
      //   645: new 54	java/lang/StringBuilder
      //   648: dup
      //   649: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   652: ldc 249
      //   654: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   657: aload_3
      //   658: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   661: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   664: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   667: iconst_0
      //   668: istore_2
      //   669: goto -613 -> 56
      //   672: astore 8
      //   674: aload 7
      //   676: invokevirtual 233	java/io/InputStream:close	()V
      //   679: aload 6
      //   681: invokevirtual 234	java/io/FileOutputStream:close	()V
      //   684: aload 8
      //   686: athrow
      //   687: astore 6
      //   689: goto -94 -> 595
      //   692: aload_0
      //   693: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   696: iconst_2
      //   697: if_icmpne +87 -> 784
      //   700: aload_0
      //   701: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   704: iconst_1
      //   705: putfield 136	com/tencent/mobileqq/business/sougou/WordMatchManager:bSi	Z
      //   708: aload_0
      //   709: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   712: getfield 252	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$a;
      //   715: getfield 142	com/tencent/mobileqq/business/sougou/WordMatchManager$a:md5	Ljava/lang/String;
      //   718: astore 4
      //   720: aload_0
      //   721: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   724: getfield 252	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$a;
      //   727: astore_3
      //   728: goto -578 -> 150
      //   731: aload_3
      //   732: ifnull +11 -> 743
      //   735: aload_0
      //   736: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   739: aload_3
      //   740: invokevirtual 255	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$a;)V
      //   743: aload_0
      //   744: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   747: aload_0
      //   748: getfield 22	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:cLy	I
      //   751: invokevirtual 258	com/tencent/mobileqq/business/sougou/WordMatchManager:LH	(I)V
      //   754: return
      //   755: aload_0
      //   756: getfield 17	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
      //   759: iload_2
      //   760: invokevirtual 169	com/tencent/mobileqq/business/sougou/WordMatchManager:GU	(Z)V
      //   763: return
      //   764: astore 7
      //   766: goto -176 -> 590
      //   769: astore 6
      //   771: goto -176 -> 595
      //   774: astore 7
      //   776: goto -97 -> 679
      //   779: astore 6
      //   781: goto -97 -> 684
      //   784: aconst_null
      //   785: astore_3
      //   786: goto -636 -> 150
      //   789: iconst_0
      //   790: istore_2
      //   791: goto -735 -> 56
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	794	0	this	TaskHttpDownload
      //   534	12	1	i	int
      //   55	736	2	bool	boolean
      //   129	657	3	localObject1	Object
      //   1	718	4	str1	String
      //   217	53	5	str2	String
      //   427	1	5	localIOException1	IOException
      //   473	149	5	localHttpURLConnection	java.net.HttpURLConnection
      //   352	239	6	localObject2	Object
      //   634	46	6	localFileNotFoundException	java.io.FileNotFoundException
      //   687	1	6	localIOException2	IOException
      //   769	1	6	localIOException3	IOException
      //   779	1	6	localIOException4	IOException
      //   506	169	7	localInputStream	java.io.InputStream
      //   764	1	7	localIOException5	IOException
      //   774	1	7	localIOException6	IOException
      //   525	18	8	arrayOfByte	byte[]
      //   552	1	8	localIOException7	IOException
      //   672	13	8	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   406	412	427	java/io/IOException
      //   540	549	552	java/io/IOException
      //   508	520	634	java/io/FileNotFoundException
      //   520	527	672	finally
      //   527	535	672	finally
      //   540	549	672	finally
      //   554	585	672	finally
      //   485	496	687	java/io/IOException
      //   501	508	687	java/io/IOException
      //   508	520	687	java/io/IOException
      //   636	667	687	java/io/IOException
      //   684	687	687	java/io/IOException
      //   585	590	764	java/io/IOException
      //   590	595	769	java/io/IOException
      //   674	679	774	java/io/IOException
      //   679	684	779	java/io/IOException
    }
  }
  
  public static class a
  {
    public String bwo = "0";
    public long delay = 0L;
    public int flag = 0;
    public String id = "0";
    public String md5 = "0";
    public int type = 0;
  }
  
  public static class b
  {
    boolean bSj = false;
    boolean bSk = false;
    boolean bSl = false;
    Set<Integer> ch = new HashSet();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem);
  }
  
  public static class d
  {
    int cLx = 0;
    WeakReference<WordMatchManager.c> gD = null;
    int requestCode = 0;
    String strContent = "";
    int taskId = 0;
  }
  
  public static abstract interface e
  {
    public abstract void a(WordMatchManager.f paramf);
  }
  
  public static abstract interface f
  {
    public abstract void LJ(int paramInt);
    
    public abstract int a(int paramInt1, String paramString, int paramInt2, WordMatchManager.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager
 * JD-Core Version:    0.7.0.1
 */