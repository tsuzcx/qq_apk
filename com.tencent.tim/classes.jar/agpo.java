import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class agpo
  extends agpd
{
  List<Integer> Bz = null;
  private long ZJ;
  private long ZK;
  public final agpe a;
  private ExcitingTransferDownloadCompletedInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
  private ExcitingTransferDownloaderFirstPkgRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  private boolean ceH;
  Map<Integer, Integer> kF = null;
  
  public agpo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Agpe = new agpe();
  }
  
  private boolean ama()
  {
    if (aqfo.isExistSDCard()) {}
    for (long l = aqfo.getSDCardAvailableSize() * 1024L; this.jdField_a_of_type_Agpe.ZD > l; l = aqfo.getSystemAvailableSize() * 1024L) {
      return true;
    }
    return false;
  }
  
  private long c(long paramLong, int paramInt)
  {
    if (paramLong == 9004L) {
      return paramLong;
    }
    if ((paramLong != 0L) && (paramInt != 0))
    {
      diR();
      if (this.Bz.indexOf(Integer.valueOf(paramInt)) >= 0) {
        return 9042L;
      }
      return paramInt;
    }
    diS();
    if (paramLong < 300L) {}
    switch ((int)paramLong)
    {
    default: 
      if ((!AppNetConnInfo.isNetSupport()) || (this.mApp.isLogin())) {
        return 9004L;
      }
      break;
    case 0: 
      return 0L;
    case 101: 
      return 9037L;
    case 201: 
      return 9001L;
    }
    diS();
    if (this.kF.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.kF.get(Long.valueOf(paramLong))).intValue();
    }
    switch ((int)paramLong)
    {
    default: 
      return paramLong;
    case 501: 
    case 502: 
    case 503: 
    case 505: 
      if (ama()) {
        return 9040L;
      }
      return 9003L;
    case 506: 
      return 9040L;
    }
    return 9082L;
  }
  
  private void diR()
  {
    if (this.Bz != null) {
      return;
    }
    this.Bz = new ArrayList();
    this.Bz.add(Integer.valueOf(-29120));
    this.Bz.add(Integer.valueOf(-29120));
    this.Bz.add(Integer.valueOf(-29150));
    this.Bz.add(Integer.valueOf(-21122));
    this.Bz.add(Integer.valueOf(-28123));
    this.Bz.add(Integer.valueOf(-25081));
    this.Bz.add(Integer.valueOf(-28126));
    this.Bz.add(Integer.valueOf(-6101));
    this.Bz.add(Integer.valueOf(-7003));
    this.Bz.add(Integer.valueOf(-403));
    this.Bz.add(Integer.valueOf(-9006));
    this.Bz.add(Integer.valueOf(-9004));
    this.Bz.add(Integer.valueOf(-9017));
    this.Bz.add(Integer.valueOf(-2813));
  }
  
  private void diS()
  {
    if (this.kF != null) {
      return;
    }
    this.kF = new HashMap();
    this.kF.put(Integer.valueOf(300), Integer.valueOf(9052));
    this.kF.put(Integer.valueOf(301), Integer.valueOf(9052));
    this.kF.put(Integer.valueOf(302), Integer.valueOf(9052));
    this.kF.put(Integer.valueOf(303), Integer.valueOf(9052));
    this.kF.put(Integer.valueOf(400), Integer.valueOf(9052));
    this.kF.put(Integer.valueOf(304), Integer.valueOf(304));
    this.kF.put(Integer.valueOf(305), Integer.valueOf(305));
    this.kF.put(Integer.valueOf(306), Integer.valueOf(306));
    this.kF.put(Integer.valueOf(307), Integer.valueOf(307));
    this.kF.put(Integer.valueOf(308), Integer.valueOf(308));
    this.kF.put(Integer.valueOf(401), Integer.valueOf(9343));
    this.kF.put(Integer.valueOf(402), Integer.valueOf(9321));
    this.kF.put(Integer.valueOf(403), Integer.valueOf(9050));
    this.kF.put(Integer.valueOf(405), Integer.valueOf(9058));
    this.kF.put(Integer.valueOf(406), Integer.valueOf(9058));
    this.kF.put(Integer.valueOf(407), Integer.valueOf(9009));
    this.kF.put(Integer.valueOf(408), Integer.valueOf(-9527));
    this.kF.put(Integer.valueOf(404), Integer.valueOf(9056));
  }
  
  public void Ju(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cYA = i;
      return;
    }
  }
  
  protected HashMap<String, String> K()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null)
    {
      localHashMap.put("serverip", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_Server", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_ftnIP", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_retry", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uRetryTimes));
      localHashMap.put("param_FailCode", String.valueOf(c(this.jdField_a_of_type_Agpe.ZB, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode)));
      localHashMap.put("param_fsized", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize));
      localHashMap.put("param_ipStackType", String.valueOf(ahbr.getIPStackType()));
      localHashMap.put("param_realTransferType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uProxyType));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes != 0L) {
        localHashMap.put("param_speed", String.valueOf((float)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize / 1048576L) / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes));
      }
    }
    for (;;)
    {
      localHashMap.put("param_uuid", "");
      localHashMap.put("param_MD5", "");
      localHashMap.put("param_fsizeo", String.valueOf(this.jdField_a_of_type_Agpe.ZD));
      localHashMap.put("param_PeerUin", String.valueOf(this.jdField_a_of_type_Agpe.ZC));
      localHashMap.put("param_url", String.valueOf(""));
      localHashMap.put("param_rspHeader", String.valueOf(""));
      localHashMap.put("param_nSessionId", String.valueOf(""));
      localHashMap.put("param_fromType", String.valueOf("1"));
      localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
      localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
      localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
      localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
      localHashMap.put("param_ishttps", String.valueOf(this.cYA));
      return localHashMap;
      localHashMap.put("param_speed", "0");
      continue;
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Agpe.ZB));
    }
  }
  
  public void Oo(int paramInt)
  {
    this.cXp = paramInt;
  }
  
  public void Op(int paramInt)
  {
    this.cYz = paramInt;
  }
  
  public void Oq(int paramInt)
  {
    this.ZJ = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    agpe localagpe = new agpe();
    localagpe.cYx = this.jdField_a_of_type_Agpe.cYx;
    localagpe.cYw = this.jdField_a_of_type_Agpe.cYw;
    localagpe.ZC = this.jdField_a_of_type_Agpe.ZC;
    localagpe.bIP = this.jdField_a_of_type_Agpe.bIP;
    localagpe.ZD = this.jdField_a_of_type_Agpe.ZD;
    localagpe.ZA = paramInt1;
    localagpe.ZB = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
    if (paramExcitingTransferOneSlotComplete != null) {
      localHashMap.put("param_ipAddrType", String.valueOf(ahbr.df(paramExcitingTransferOneSlotComplete.m_strIp)));
    }
    for (;;)
    {
      localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
      localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
      localHashMap.put("param_ishttps", String.valueOf(this.cYA));
      super.a(localagpe, paramExcitingTransferOneSlotComplete, localHashMap);
      return;
      localHashMap.put("param_ipAddrType", String.valueOf(0));
    }
  }
  
  protected boolean alQ()
  {
    return true;
  }
  
  public void c(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.m_uStartTime);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  public void diF()
  {
    this.jdField_a_of_type_Agpe.ZA = 5L;
    this.ZJ = 3L;
    this.jdField_a_of_type_Agpe.ZB = 9004L;
    Js(false);
  }
  
  public void diG()
  {
    this.jdField_a_of_type_Agpe.ZA = 1L;
    if (this.ceH) {}
    for (this.ZJ = 3L;; this.ZJ = 2L)
    {
      this.jdField_a_of_type_Agpe.ZB = 9037L;
      Js(false);
      return;
    }
  }
  
  public void diO()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = anaz.gQ();
  }
  
  public void diP()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = anaz.gQ();
  }
  
  public void diQ()
  {
    this.ceH = true;
  }
  
  protected HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Agpe != null) {
      localHashMap.putAll(this.jdField_a_of_type_Agpe.getReportData());
    }
    localHashMap.put("param_SubReason", String.valueOf(this.ZJ));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.getReportData());
    }
    if (this.ZK != 0L) {
      localHashMap.put("param_SrvRetCode", String.valueOf(this.ZK));
    }
    localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
    localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
    localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
    localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
    localHashMap.put("param_ishttps", String.valueOf(this.cYA));
    return localHashMap;
  }
  
  public void jF(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize != -1L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramLong;
  }
  
  public void jG(long paramLong)
  {
    this.jdField_a_of_type_Agpe.ZA = 2L;
    this.ZJ = 2L;
    this.jdField_a_of_type_Agpe.ZB = paramLong;
    Js(false);
  }
  
  public void jH(long paramLong)
  {
    this.jdField_a_of_type_Agpe.ZA = 2L;
    this.ZJ = 7L;
    this.ZK = paramLong;
    this.jdField_a_of_type_Agpe.ZB = paramLong;
    Js(false);
  }
  
  protected String s(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "actFileDown";
    }
    return "actPDFileDownload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpo
 * JD-Core Version:    0.7.0.1
 */