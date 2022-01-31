package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BaseTransProcessor
  implements AppConstants.RichMediaErrorCode, INetEngine.INetEngineListener, ITransProcessor, ProtoReqManager.IProtoRespBack, RichProtoProc.RichProtoCallback, IHttpCommunicatorListener
{
  public static final String A = "param_step";
  public static final String B = "param_DownMode";
  public static final String C = "param_CostEach";
  public static final String D = "param_BdhTrans";
  public static final String E = "X-piccachetime";
  public static final String F = "param_segspercnt";
  public static final String G = "param_sessionKey";
  public static final String K = "BaseTransProcessor";
  public static String L;
  static final String M = "ptt";
  protected static final String N = "s";
  protected static final String O = "tr";
  protected static final String P = "ht";
  protected static final String Q = "pic";
  protected static final String R = "sn";
  protected static INetEngine.IBreakDownFix a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final int aA = 3;
  public static final int aB = 4;
  public static final int ax = 0;
  public static final int ay = 1;
  public static final int az = 2;
  public static final String g = "ftn";
  public static final String h = "pttcenter";
  public static final String i = "picplatform";
  public static final String j = "param_FailCode";
  public static final String k = "param_errorDesc";
  public static final String l = "param_reason";
  public static final String m = "serverip";
  public static final String n = "param_Server";
  public static final String o = "param_grpUin";
  public static final String p = "param_Retry";
  public static final String q = "param_fileid";
  public static final String r = "param_rspHeader";
  public static final String s = "param_reqHeader";
  public static final String t = "param_picSize";
  public static final String u = "param_picmd5";
  public static final String v = "param_uuid";
  public static final String w = "param_url";
  public static final String x = "param_fromUin";
  public static final String y = "param_toUin";
  public static final String z = "param_sliceNum";
  String H = "P";
  String I = "Q";
  public String J = "";
  public long a;
  public QQAppInterface a;
  BaseTransProcessor.StepInfo jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
  public FileMsg a;
  public INetEngine a;
  NetReq jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
  public TransFileController a;
  public TransferRequest a;
  RichProto.RichProtoReq jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = false;
  protected int aC = 0;
  private int aj;
  private int ak;
  private int al;
  int an = -9528;
  int ao = -9529;
  int ap = -9530;
  int aq = -9531;
  int ar = -9532;
  int as = -9533;
  public int at = 9001;
  int au = -1;
  int av = 0;
  int aw = 0;
  long jdField_b_of_type_Long;
  public BaseTransProcessor.StepInfo b;
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long = 0L;
  public BaseTransProcessor.StepInfo c;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  long jdField_d_of_type_Long = 0L;
  BaseTransProcessor.StepInfo jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
  boolean jdField_d_of_type_Boolean = false;
  long e;
  public boolean e;
  boolean f = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    L = "param_reason";
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new gra();
  }
  
  public BaseTransProcessor(TransFileController paramTransFileController)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTransFileController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg();
    this.jdField_a_of_type_Long = System.nanoTime();
  }
  
  public BaseTransProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTransFileController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = paramTransferRequest;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aJ = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    paramTransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    paramTransFileController.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    m();
  }
  
  public BaseTransProcessor(String paramString1, String paramString2, boolean paramBoolean, TransFileController paramTransFileController)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTransFileController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg(paramString1, paramString2, i1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
      return;
      i1 = 1;
    }
  }
  
  public BaseTransProcessor(String paramString, boolean paramBoolean, TransFileController paramTransFileController)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTransFileController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg(paramString, null, i1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
      return;
      i1 = 1;
    }
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return "S_" + paramInt + "_" + paramLong;
  }
  
  public static String a(long paramLong)
  {
    return "T_" + paramLong;
  }
  
  public static String a(Exception paramException)
  {
    return AbstractImageDownloader.a(paramException);
  }
  
  public static String a(String paramString)
  {
    return "C_" + paramString;
  }
  
  public static String a(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static void a(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        TransProcessorHandler localTransProcessorHandler;
        Object localObject2;
        do
        {
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
              localObject2 = localTransProcessorHandler.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localTransProcessorHandler.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localTransProcessorHandler.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  public static void a(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramTransProcessorHandler);
      return;
    }
  }
  
  public static boolean a(int paramInt, HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(L, a("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(L, a("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  public static String b(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  private void b(NetResp paramNetResp)
  {
    long l1 = 0L;
    if ((paramNetResp.jdField_e_of_type_Long != 0L) && (this.f)) {
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label205;
      }
    }
    for (int i1 = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = paramNetResp.jdField_e_of_type_Long - i1;
      this.jdField_d_of_type_Long += l3;
      this.jdField_c_of_type_Long += l2;
      this.jdField_e_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.aC).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.aC += 1;
      return;
      label205:
      this.f = false;
    }
  }
  
  public static void b(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramTransProcessorHandler);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        d(1002);
      }
    }
    else {
      return;
    }
    d(2002);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i1 = d();
      if (i1 > this.aj) {
        this.aj = i1;
      }
    }
  }
  
  public int a()
  {
    return this.al;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
  }
  
  @Deprecated
  public FileMsg.StepBaseInfo a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      }
    }
  }
  
  public FileMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
  }
  
  public TransferRequest a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return AppConstants.an + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + FileMsg.a() + ".amr";
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.al = paramInt;
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt1);
      if (localStepBaseInfo != null) {
        localStepBaseInfo.jdField_b_of_type_Int = paramInt2;
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, long paramLong)
  {
    a("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.al + " mProgress:" + this.aj);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.at == 9001))
    {
      String str = AbstractImageDownloader.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l1 = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    boolean bool;
    if ((l1 > 60000L) || (paramInt1 == 1005))
    {
      bool = true;
      if (l1 <= 60000L) {
        break label209;
      }
      RichMediaUtil.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      RichMediaUtil.a(bool, "image_sending_" + this.at + "_" + this.J);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt1);
      if (localStepBaseInfo != null)
      {
        localStepBaseInfo.jdField_a_of_type_Int = paramInt2;
        localStepBaseInfo.jdField_a_of_type_JavaLangString = paramString;
        localStepBaseInfo.jdField_c_of_type_Long = paramLong;
        localStepBaseInfo.jdField_a_of_type_Boolean = false;
        c(paramInt1);
      }
      a(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt1);
      if (localStepBaseInfo != null)
      {
        localStepBaseInfo.jdField_a_of_type_Int = paramInt2;
        localStepBaseInfo.jdField_a_of_type_JavaLangString = paramString;
        localStepBaseInfo.jdField_a_of_type_Boolean = false;
        c(paramInt1);
      }
      a(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, long paramLong)
  {
    a(paramInt, 0, paramLong);
  }
  
  @Deprecated
  public void a(int paramInt, MessageObserver.StatictisInfo paramStatictisInfo, String paramString)
  {
    try
    {
      a(paramInt, false, paramStatictisInfo, paramString);
      return;
    }
    finally
    {
      paramStatictisInfo = finally;
      throw paramStatictisInfo;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, BaseTransProcessor.StepInfo paramStepInfo)
  {
    this.at = paramInt;
    this.J = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramStepInfo != null)
    {
      paramStepInfo.b();
      paramStepInfo.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt);
      if ((localStepBaseInfo != null) && ((localStepBaseInfo.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localStepBaseInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @Deprecated
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 493	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(I)Lcom/tencent/mobileqq/transfile/FileMsg$StepBaseInfo;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +19 -> 30
    //   14: iload_2
    //   15: ifeq +18 -> 33
    //   18: aload 4
    //   20: aload 4
    //   22: getfield 584	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:jdField_c_of_type_Int	I
    //   25: iload_3
    //   26: iadd
    //   27: putfield 584	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:jdField_c_of_type_Int	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload 4
    //   35: aload 4
    //   37: getfield 586	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:jdField_d_of_type_Int	I
    //   40: iload_3
    //   41: iadd
    //   42: putfield 586	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:jdField_d_of_type_Int	I
    //   45: goto -15 -> 30
    //   48: astore 4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 4
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	BaseTransProcessor
    //   0	55	1	paramInt1	int
    //   0	55	2	paramBoolean	boolean
    //   0	55	3	paramInt2	int
    //   7	29	4	localStepBaseInfo	FileMsg.StepBaseInfo
    //   48	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	48	finally
    //   18	30	48	finally
    //   33	45	48	finally
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    FileMsg.StepBaseInfo localStepBaseInfo;
    for (;;)
    {
      try
      {
        localStepBaseInfo = a(paramInt);
        if (localStepBaseInfo == null) {
          return;
        }
        if (!paramBoolean) {
          break;
        }
        if (paramInt != 1) {
          break label148;
        }
        if (paramStatictisInfo == null)
        {
          paramInt = i1;
          localStepBaseInfo.jdField_d_of_type_Int = paramInt;
          localStepBaseInfo.jdField_c_of_type_Int = 1;
          continue;
        }
        paramInt = paramStatictisInfo.jdField_c_of_type_Int - 1;
      }
      finally {}
      continue;
      for (;;)
      {
        localStepBaseInfo.jdField_d_of_type_Int = paramInt;
        break;
        label84:
        paramInt = paramStatictisInfo.jdField_c_of_type_Int;
      }
    }
    localStepBaseInfo.jdField_c_of_type_Int = 0;
    if (paramInt == 1)
    {
      if (paramStatictisInfo == null) {}
      for (paramInt = i3;; paramInt = paramStatictisInfo.jdField_c_of_type_Int)
      {
        localStepBaseInfo.jdField_d_of_type_Int = paramInt;
        break;
      }
    }
    for (;;)
    {
      label127:
      localStepBaseInfo.jdField_d_of_type_Int = paramInt;
      break;
      label148:
      do
      {
        paramInt = paramStatictisInfo.jdField_c_of_type_Int;
        paramInt += 1;
        break label127;
        if (paramStatictisInfo != null) {
          break label84;
        }
        paramInt = i2;
        break;
      } while (paramStatictisInfo != null);
      paramInt = i4;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo, String paramString)
  {
    int i1 = 9351;
    FileMsg.StepBaseInfo localStepBaseInfo;
    for (;;)
    {
      try
      {
        localStepBaseInfo = a(paramInt);
        if (localStepBaseInfo == null)
        {
          if (!paramBoolean)
          {
            if (paramInt == 3) {
              a(paramInt, i1, paramString + "info null");
            }
          }
          else {
            return;
          }
          i1 = 9044;
          continue;
        }
        if (!paramBoolean) {
          break;
        }
        if (paramStatictisInfo == null)
        {
          localStepBaseInfo.jdField_d_of_type_Int = 0;
          localStepBaseInfo.jdField_c_of_type_Int = 1;
          continue;
        }
        localStepBaseInfo.jdField_d_of_type_Int = (paramStatictisInfo.jdField_c_of_type_Int - 1);
      }
      finally {}
      localStepBaseInfo.jdField_c_of_type_Int = 1;
    }
    if (paramStatictisInfo.jdField_b_of_type_Int == 2900)
    {
      paramStatictisInfo.jdField_b_of_type_Int = -9527;
      if (paramInt == 3) {
        paramString = b(paramStatictisInfo.jdField_d_of_type_Long);
      }
    }
    for (;;)
    {
      label146:
      a(paramInt, paramStatictisInfo.jdField_b_of_type_Int, paramString);
      localStepBaseInfo.jdField_c_of_type_Long = paramStatictisInfo.jdField_d_of_type_Long;
      localStepBaseInfo.jdField_b_of_type_Int = paramStatictisInfo.jdField_c_of_type_Int;
      if (paramStatictisInfo != null) {
        break label259;
      }
      localStepBaseInfo.jdField_d_of_type_Int = 1;
      localStepBaseInfo.jdField_c_of_type_Int = 0;
      break;
      paramString = a(paramStatictisInfo.jdField_d_of_type_Long);
      continue;
      if (paramStatictisInfo.jdField_b_of_type_Int == 1002) {
        break label277;
      }
      if (paramStatictisInfo.jdField_b_of_type_Int != 1013) {
        break label298;
      }
      break label277;
      label229:
      paramStatictisInfo.jdField_b_of_type_Int = i1;
      paramString = paramStatictisInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      paramStatictisInfo.jdField_b_of_type_Int = i1;
      paramString = paramStatictisInfo.jdField_a_of_type_JavaLangString;
      break label146;
      label259:
      localStepBaseInfo.jdField_d_of_type_Int = paramStatictisInfo.jdField_c_of_type_Int;
      localStepBaseInfo.jdField_c_of_type_Int = 0;
      break;
      label277:
      if (paramInt == 3)
      {
        i1 = 9350;
        break label229;
      }
      i1 = 9311;
      break label229;
      label298:
      if (paramInt != 3) {
        i1 = 9044;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramLong);
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, NetResp paramNetResp, boolean paramBoolean)
  {
    if ((paramStepInfo == null) || (paramNetResp == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramStepInfo.jdField_b_of_type_Int += 1;
      paramStepInfo.jdField_c_of_type_Int += paramNetResp.i - 1;
      paramStepInfo.b();
      paramStepInfo.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramStepInfo.jdField_c_of_type_Int += paramNetResp.i;
    if (paramNetResp.jdField_a_of_type_Long == -9527L) {}
    for (String str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a((int)paramNetResp.jdField_a_of_type_Long, paramNetResp.jdField_a_of_type_JavaLangString, str, paramStepInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramNetResp.jdField_a_of_type_Long == -9527L) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramStepInfo.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    if ((paramStepInfo != null) && (paramRespCommon != null))
    {
      paramStepInfo.b();
      paramStepInfo.jdField_b_of_type_Int = paramRespCommon.jdField_e_of_type_Int;
      paramStepInfo.jdField_c_of_type_Int = paramRespCommon.f;
      if (paramRespCommon.jdField_c_of_type_Int == 0) {
        paramStepInfo.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramStepInfo.jdField_a_of_type_Int = 0;
    a(paramRespCommon.jdField_d_of_type_Int, paramRespCommon.jdField_d_of_type_JavaLangString, paramRespCommon.jdField_e_of_type_JavaLangString, paramStepInfo);
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo == null) {
      return;
    }
    paramStepInfo.b();
    if (paramBoolean2)
    {
      paramStepInfo.jdField_c_of_type_Int = (paramStatictisInfo.jdField_c_of_type_Int - 1);
      paramStepInfo.jdField_b_of_type_Int = 1;
      paramStepInfo.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramStatictisInfo.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramStatictisInfo.jdField_d_of_type_Long);; str = a(paramStatictisInfo.jdField_d_of_type_Long))
      {
        a(i1, "", str, paramStepInfo);
        paramStepInfo.jdField_c_of_type_Int = paramStatictisInfo.jdField_c_of_type_Int;
        paramStepInfo.jdField_b_of_type_Int = 0;
        paramStepInfo.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramStatictisInfo.jdField_b_of_type_Int == 1002) || (paramStatictisInfo.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(NetReq paramNetReq, int paramInt1, int paramInt2) {}
  
  public void a(NetResp paramNetResp)
  {
    b(paramNetResp);
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq) {}
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp) {}
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i1;
    int i2;
    int i3;
    if (paramHttpMsg != null)
    {
      i1 = paramHttpMsg.jdField_d_of_type_Int;
      i2 = paramHttpMsg.jdField_e_of_type_Int;
      i3 = paramHttpMsg.f;
      if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
      }
      if (!"POST".equals(paramHttpMsg.d())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i3, i1, i2, paramHttpMsg.i);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  void a(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {
      a(9039, paramIOException);
    }
    do
    {
      return;
      if (paramIOException.contains("ENOSPC"))
      {
        a(9040, paramIOException);
        return;
      }
      if (paramIOException.contains("Read-only"))
      {
        a(9039, paramIOException);
        return;
      }
    } while ("mounted".equals(str));
    a(9039, paramIOException);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool = false;
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    }
    if ((this instanceof BuddyTransfileProcessor))
    {
      i1 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null) {
        break label89;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      RichMediaUtil.a(RichMediaUtil.b(i1), bool, RichMediaUtil.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof C2CPicUploadProcessor)) {
        break;
      }
      i1 = 0;
      break;
      label89:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.at != 9001;
  }
  
  protected boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg2 == null) {}
    do
    {
      return false;
      paramHttpMsg1 = paramHttpMsg2.c();
    } while ((paramHttpMsg1 != null) && (paramHttpMsg1.contains("HttpCommunicator closed or msg caceled!")));
    return true;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public int b()
  {
    int i2 = 0;
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = this.aj;
    }
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null);
      i1 = i2;
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long * 100L / this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long;
  }
  
  protected String b()
  {
    return null;
  }
  
  public void b() {}
  
  @Deprecated
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.ak = paramInt1;
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        TransProcessorHandler localTransProcessorHandler;
        do
        {
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
              localObject3 = localTransProcessorHandler.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localTransProcessorHandler.obtainMessage();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.v = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        ((Message)localObject4).arg1 = paramInt2;
        localTransProcessorHandler.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  @Deprecated
  public void b(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      FileMsg.StepTransInfo localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.jdField_a_of_type_Int = paramInt1;
      localStepTransInfo.jdField_a_of_type_Boolean = false;
      localStepTransInfo.jdField_a_of_type_JavaLangString = paramString;
      localStepTransInfo.jdField_e_of_type_Int = paramInt2;
      localStepTransInfo.jdField_c_of_type_Long = paramLong;
      a(localStepTransInfo.jdField_a_of_type_Int, localStepTransInfo.jdField_a_of_type_JavaLangString);
      c(2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  protected void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected int c()
  {
    return this.ak;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u;
  }
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt);
      if (localStepBaseInfo != null) {
        localStepBaseInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long = paramLong;
  }
  
  protected void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int d()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long * 100L / this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u != 1003) {
                i1 = 99;
              }
            }
          }
        }
      }
    }
    return i1;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.v;
  }
  
  void d()
  {
    long l1 = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      a(9366, "account switch");
    }
    a("onError", "elapsed:" + l1 + " errCode:" + this.at + " errDesc:" + this.J + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    c(false);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(a());
  }
  
  public void d(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
  }
  
  public int e()
  {
    return 0;
  }
  
  void e()
  {
    long l1 = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    a("onSuccess", "elapsed:" + l1 + ",key:" + a());
    c(true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramInt);
  }
  
  protected boolean e()
  {
    return (!this.jdField_e_of_type_Boolean) && (!this.jdField_c_of_type_Boolean);
  }
  
  public int f()
  {
    return 0;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      q();
      c();
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean) {
        break label176;
      }
    }
    label176:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_e_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("cancel", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(a());
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null)
        {
          TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          if (localTransferResult != null)
          {
            localTransferResult.jdField_d_of_type_Int = -1;
            localTransferResult.jdField_a_of_type_Long = 9037L;
            localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
          }
        }
        a("notify", "start");
        notifyAll();
        a("notify", "end");
        return 0;
      }
      finally {}
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  protected void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.aw = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public void n()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a(), Integer.valueOf(this.aw));
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 2000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  void o()
  {
    this.at = 0;
    this.J = "";
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor
 * JD-Core Version:    0.7.0.1
 */