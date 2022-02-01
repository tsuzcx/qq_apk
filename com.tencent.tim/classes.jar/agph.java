import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class agph
  extends apey
  implements agpm
{
  private SparseIntArray V;
  private SparseIntArray W;
  protected long ZE;
  protected boolean ceG;
  
  protected agph(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    super(paramLong, paramItem, paramBundle, parama);
    diI();
    diJ();
  }
  
  private agph.a a()
  {
    agph.a locala = new agph.a();
    if ((this.jdField_a_of_type_Apeu != null) && ((this.jdField_a_of_type_Apeu instanceof agpl)))
    {
      agpl localagpl = (agpl)this.jdField_a_of_type_Apeu;
      locala.b = localagpl.a();
      locala.resultCode = localagpl.getResultCode();
    }
    return locala;
  }
  
  public static apey a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    if (paramLong == 0L)
    {
      apef.b.e("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "getWoker. item.id=null");
      return null;
    }
    return new agph(paramLong, paramItem, paramBundle, parama);
  }
  
  private int aA(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      return 5;
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
    case 4: 
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 1;
  }
  
  private void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    agph.a locala;
    agpg localagpg;
    Object localObject;
    if (paramInt1 == 0)
    {
      bool = true;
      locala = a();
      localagpg = new agpg(apef.getApp());
      localObject = ahav.lb(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
      localagpg.a(paramInt1, paramInt2, (String)localObject, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
      if ((this.arm <= 0L) || (this.arn < this.arm)) {
        break label193;
      }
      localagpg.jD(this.arm);
      localagpg.jE(this.arn);
      label100:
      if ((locala == null) || (locala.b == null)) {
        break label208;
      }
      localagpg.a(locala.b);
    }
    for (;;)
    {
      localagpg.p(this.ZE);
      localagpg.Oo(this.cXp);
      if ((locala != null) && (locala.b != null)) {
        localagpg.Op(ahbr.df(locala.b.m_strLastServerHost));
      }
      localagpg.Ju(this.cea);
      localagpg.Js(bool);
      return;
      bool = false;
      break;
      label193:
      localagpg.jD(0L);
      localagpg.jE(0L);
      break label100;
      label208:
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.YS > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime = this.YS;
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime);
      }
      if (this.jdField_a_of_type_Apdx$a.arf > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartSize = this.jdField_a_of_type_Apdx$a.arf;
      }
      if (this.jdField_a_of_type_Apdx$a.transferedSize > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uDownloadedSize = this.jdField_a_of_type_Apdx$a.transferedSize;
      }
      if (paramInt3 != 0) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_nSrvReturnCode = paramInt3;
      }
      localagpg.a((ExcitingTransferDownloadCompletedInfo)localObject);
    }
  }
  
  private boolean alW()
  {
    if (aqfo.isExistSDCard()) {}
    for (long l1 = aqfo.getSDCardAvailableSize() * 1024L;; l1 = aqfo.getSystemAvailableSize() * 1024L)
    {
      long l2 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      if ((l2 <= 0L) || (l2 <= l1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private int ax(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (paramInt1 == 101) {
          return 0;
        }
        i = paramInt2;
      } while (paramInt1 == 201);
      if (jN(paramInt1)) {
        return hC(paramInt2);
      }
      if (jM(paramInt1)) {
        return ay(paramInt1, paramInt2);
      }
      if (paramInt1 == 401) {
        return 301;
      }
      if (paramInt1 == 402) {
        return hB(paramInt2);
      }
      if (paramInt1 == 403) {
        return hA(paramInt2);
      }
      if (paramInt1 == 404) {
        return hz(paramInt2);
      }
      if (paramInt1 == 408) {
        return hy(paramInt2);
      }
      if (paramInt1 == 405) {
        return hx(paramInt2);
      }
      if (paramInt1 == 406) {
        return hw(paramInt2);
      }
      if (paramInt1 == 407) {
        return hv(paramInt2);
      }
      if (paramInt1 == 504) {
        return 0;
      }
      if (alW()) {
        return 703;
      }
      if (paramInt1 == 501) {
        return 708;
      }
      if (paramInt1 == 502) {
        return 709;
      }
      if (paramInt1 == 503) {
        return 705;
      }
      if (paramInt1 == 505) {
        return 706;
      }
      if (paramInt1 == 506) {
        return 703;
      }
      i = paramInt2;
    } while (paramInt2 != 0);
    return paramInt1;
  }
  
  private int ay(int paramInt1, int paramInt2)
  {
    int i;
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (paramInt2 != 0);
    if (paramInt1 == 305) {
      return 315;
    }
    if (paramInt1 == 306) {
      return 316;
    }
    return 314;
  }
  
  private int az(int paramInt1, int paramInt2)
  {
    return this.V.get(paramInt1, 9);
  }
  
  private void diI()
  {
    if (this.V == null) {
      this.V = new SparseIntArray();
    }
    this.V.put(0, 0);
    this.V.put(101, 8);
    this.V.put(201, 9);
    this.V.put(300, 3);
    this.V.put(301, 3);
    this.V.put(302, 3);
    this.V.put(303, 3);
    this.V.put(304, 3);
    this.V.put(305, 3);
    this.V.put(306, 3);
    this.V.put(307, 3);
    this.V.put(308, 3);
    this.V.put(400, 3);
    this.V.put(401, 3);
    this.V.put(402, 3);
    this.V.put(403, 3);
    this.V.put(404, 3);
    this.V.put(405, 3);
    this.V.put(406, 3);
    this.V.put(407, 3);
    this.V.put(408, 3);
    this.V.put(501, 7);
    this.V.put(502, 7);
    this.V.put(503, 7);
    this.V.put(505, 7);
    this.V.put(506, 7);
    this.V.put(504, 6);
  }
  
  private void diJ()
  {
    if (this.W == null) {
      this.W = new SparseIntArray();
    }
    this.W.put(0, 0);
    this.W.put(1, 402);
    this.W.put(100, 402);
    this.W.put(101, 402);
    this.W.put(102, 402);
    this.W.put(2, 402);
    this.W.put(3, 402);
    this.W.put(302, 402);
    this.W.put(303, 402);
    this.W.put(304, 402);
    this.W.put(305, 402);
    this.W.put(313, 402);
    this.W.put(309, 402);
    this.W.put(312, 402);
    this.W.put(301, 401);
    this.W.put(300, 407);
    this.W.put(306, 303);
    this.W.put(4, 303);
    this.W.put(307, 303);
    this.W.put(308, 303);
    this.W.put(314, 304);
    this.W.put(315, 305);
    this.W.put(316, 306);
    this.W.put(317, 404);
    this.W.put(318, 408);
    this.W.put(319, 405);
    this.W.put(320, 406);
    this.W.put(5, 201);
    this.W.put(501, 201);
    this.W.put(502, 201);
    this.W.put(503, 201);
    this.W.put(504, 201);
    this.W.put(701, 201);
    this.W.put(702, 201);
    this.W.put(704, 504);
    this.W.put(708, 501);
    this.W.put(709, 502);
    this.W.put(707, 502);
    this.W.put(700, 502);
    this.W.put(710, 506);
    this.W.put(703, 506);
    this.W.put(8, 9037);
    this.W.put(7, 201);
    this.W.put(9, 201);
    this.W.put(901, 201);
    this.W.put(902, 201);
    this.W.put(904, 201);
    this.W.put(10, 201);
    this.W.put(11, 201);
    this.W.put(12, 201);
  }
  
  private void diM()
  {
    int i = 2;
    if (this.YS != 0L) {
      i = 3;
    }
    agpg localagpg = new agpg(apef.getApp());
    Object localObject = ahav.lb(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
    localagpg.a(1, i, (String)localObject, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
    if ((this.arm > 0L) && (this.arn >= this.arm))
    {
      localagpg.jD(this.arm);
      localagpg.jE(this.arn);
    }
    for (;;)
    {
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.YS > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime = this.YS;
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime);
      }
      if (this.jdField_a_of_type_Apdx$a.arf > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartSize = this.jdField_a_of_type_Apdx$a.arf;
      }
      if (this.jdField_a_of_type_Apdx$a.transferedSize > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uDownloadedSize = this.jdField_a_of_type_Apdx$a.transferedSize;
      }
      localagpg.a((ExcitingTransferDownloadCompletedInfo)localObject);
      localagpg.p(this.ZE);
      localagpg.Oo(this.cXp);
      localagpg.Ju(this.cea);
      localagpg.Js(false);
      return;
      localagpg.jD(0L);
      localagpg.jE(0L);
    }
  }
  
  private int hA(int paramInt)
  {
    int i;
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 308;
  }
  
  private int hB(int paramInt)
  {
    int i;
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 309;
  }
  
  private int hC(int paramInt)
  {
    int i;
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 307;
  }
  
  private int hD(int paramInt)
  {
    return this.W.get(paramInt, paramInt);
  }
  
  private int hE(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403))
    {
      i = paramInt;
      if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {
        i = 3;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (aqfo.isExistSDCard()) {}
    for (long l1 = aqfo.getSDCardAvailableSize() * 1024L;; l1 = aqfo.getSystemAvailableSize() * 1024L)
    {
      long l2 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      i = paramInt;
      if (l2 <= 0L) {
        break;
      }
      i = paramInt;
      if (l2 <= l1) {
        break;
      }
      return 506;
    }
  }
  
  private int hv(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 300;
  }
  
  private int hw(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 320;
  }
  
  private int hx(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 319;
  }
  
  private int hy(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 318;
  }
  
  private int hz(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 317;
  }
  
  private boolean jM(int paramInt)
  {
    return (paramInt == 304) || (paramInt == 305) || (paramInt == 306) || (paramInt == 307) || (paramInt == 308);
  }
  
  private boolean jN(int paramInt)
  {
    return (paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400);
  }
  
  protected int Eo()
  {
    if (alV())
    {
      if (this.jdField_a_of_type_Apeu == null) {
        return 0;
      }
      return ahbr.df(this.jdField_a_of_type_Apeu.vz());
    }
    return super.Eo();
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    if (alV())
    {
      paramInt2 = i;
      if (paramBundle != null) {
        paramInt2 = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return ax(paramInt1, paramInt2);
    }
    return super.a(paramInt1, paramInt2, paramBundle);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    if (alV())
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return az(paramInt, i);
    }
    return super.a(paramInt, paramBundle);
  }
  
  protected apeu a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ nSessionID[" + paramLong + "] get ExtfFileDownloader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString3 + " urlParams:" + paramString2);
    this.ZE = paramLong;
    if (ahav.mI(paramString1)) {
      this.ceG = true;
    }
    agpk localagpk = new agpk();
    localagpk.setFileSize(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal);
    localagpk.Je(paramString2);
    localagpk.Jf(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
    int i = 80;
    localagpk.Jv(paramBoolean);
    localagpk.Jg(paramString3);
    if (paramBoolean) {
      i = 443;
    }
    paramString3 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
    paramString2 = paramString3;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
    {
      paramString2 = paramString3;
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
        paramString2 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
      }
    }
    paramString3 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString3 = Bc();
    }
    localagpk.Jd(paramString3);
    paramString2 = new ArrayList();
    paramString2.add(new ExcitingTransferHostInfo(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp, i));
    if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      paramString3 = new ExcitingTransferHostInfo(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, i);
      if (agke.a().l(paramQQAppInterface, 3))
      {
        QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] exciting download troopfile. is config enable IPv6. domain[" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        Object localObject = new agke.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, i);
        localObject = agke.a().a(paramQQAppInterface, (agke.a)localObject, 3);
        if ((localObject != null) && (!((agke.c)localObject).alz()))
        {
          if (agke.alt())
          {
            QLog.d("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] exciting download troopfile. debugIsDisableIPv4OnDoubleStack");
            paramString2.clear();
          }
          i = ((agke.c)localObject).Bb.size() - 1;
          while (i >= 0)
          {
            paramString3 = (agke.b)((agke.c)localObject).Bb.get(i);
            paramString2.add(0, new ExcitingTransferHostInfo(paramString3.vb(), paramString3.mPort));
            i -= 1;
          }
          this.cXp = 2;
          if (((agke.c)localObject).cXn == 1) {
            this.cXp = 3;
          }
          QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] exciting download troopfile use IPv6. iplist:" + paramString2.toString());
        }
      }
    }
    for (;;)
    {
      localagpk.kJ(paramString2);
      paramQQAppInterface = agpl.a(paramQQAppInterface, paramLong, this.mTroopUin, paramString1, localagpk);
      if (paramQQAppInterface == null) {
        break;
      }
      ((agpl)paramQQAppInterface).a(this);
      return paramQQAppInterface;
      QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] exciting download troopfile use IPv4");
      paramString2.add(paramString3);
      this.cXp = 1;
      continue;
      paramString2.add(paramString3);
      this.cXp = 1;
      continue;
      this.cXp = 1;
    }
    QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ [" + this.coy + "] get ExtfFileDownloader fail.");
    return paramQQAppInterface;
  }
  
  public void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int j = 3;
    if (paramExcitingTransferOneSlotComplete != null) {}
    for (int i = paramExcitingTransferOneSlotComplete.m_SrvRetCode;; i = 0)
    {
      jQ(az(paramInt, i), ax(paramInt, i));
      agpi localagpi;
      String str;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_Apdx$a.dTJ = 0;
        this.jdField_a_of_type_Apdx$a.dTK = 0;
        dZa();
        this.jdField_a_of_type_Apdx$a.resultCode = 0;
        this.jdField_a_of_type_Apdx$a.dTI = 0;
        if (paramExcitingTransferOneSlotComplete == null) {
          break label222;
        }
        localagpi = new agpi(apef.getApp());
        localagpi.p(this.ZE);
        str = ahav.lb(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
        i = hE(paramInt);
        if (i != 3) {
          break label207;
        }
        paramInt = 5;
      }
      for (;;)
      {
        localagpi.a(paramInt, i, str, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
        localagpi.a(paramExcitingTransferOneSlotComplete);
        localagpi.Oo(this.cXp);
        localagpi.Op(ahbr.df(paramExcitingTransferOneSlotComplete.m_strIp));
        localagpi.Ju(this.cea);
        localagpi.report();
        return;
        this.jdField_a_of_type_Apdx$a.resultCode = 0;
        this.jdField_a_of_type_Apdx$a.dTI = 0;
        dZb();
        break;
        label207:
        paramInt = j;
        if (i != 506) {
          paramInt = 4;
        }
      }
      label222:
      QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.coy + "] onExtfSubUploaderResult DataReport fail. no rp");
      return;
    }
  }
  
  public void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if ((paramExcitingTransferDownloadSpeedInfo == null) || (paramExcitingTransferDownloadSpeedInfo.mTotalSpeed == 0)) {
      return;
    }
    long l = paramExcitingTransferDownloadSpeedInfo.mTotalSpeed;
    float f;
    if (l > 1048576L)
    {
      f = (float)l / 1048576.0F;
      paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
      paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "MB/s";
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
      return;
      if (l > 1024L)
      {
        f = (float)l / 1024.0F;
        paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "KB/s";
      }
      else
      {
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + l + "KB/s";
      }
    }
  }
  
  protected boolean alV()
  {
    return true;
  }
  
  public void diH()
  {
    this.YS = System.currentTimeMillis();
  }
  
  protected void diK()
  {
    int k = 1;
    int n = 0;
    super.diK();
    if (alV())
    {
      if ((this.jdField_a_of_type_Apdx$a.resultCode == 8) || (this.jdField_a_of_type_Apdx$a.resultCode == 11) || (this.jdField_a_of_type_Apdx$a.resultCode == 12)) {
        diM();
      }
    }
    else {
      return;
    }
    agph.a locala = a();
    int j;
    int i;
    if ((locala != null) && (locala.b != null))
    {
      j = hE(locala.resultCode);
      i = 4;
    }
    for (;;)
    {
      int m = i;
      if (k != 0)
      {
        if (j != 3) {
          break label204;
        }
        m = 5;
      }
      for (;;)
      {
        aP(m, j, n);
        return;
        j = this.jdField_a_of_type_Apdx$a.dTI;
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_Apdx$a.resultCode;
        }
        if (this.YS == 0L)
        {
          k = aA(this.jdField_a_of_type_Apdx$a.resultCode, this.jdField_a_of_type_Apdx$a.dTI);
          if (!this.cQh) {
            break label220;
          }
          n = this.jdField_a_of_type_Apdx$a.dTI;
          i = 2;
          j = 7;
          k = 0;
          break;
        }
        j = hE(hD(i));
        i = 4;
        break;
        label204:
        m = i;
        if (j == 506) {
          m = 3;
        }
      }
      label220:
      j = i;
      i = k;
      k = 0;
    }
  }
  
  protected void diL()
  {
    float f;
    if (alV())
    {
      agph.a locala = a();
      if ((locala != null) && (locala.b != null))
      {
        this.jdField_a_of_type_Apdx$a.arf = locala.b.m_uStartSize;
        this.jdField_a_of_type_Apdx$a.transferedSize = locala.b.m_uDownloadedSize;
        this.jdField_a_of_type_Apdx$a.transferTime = locala.b.m_uTotalTimes;
        if ((this.jdField_a_of_type_Apdx$a.transferedSize <= 0L) || (this.jdField_a_of_type_Apdx$a.transferTime <= 0L)) {
          break label139;
        }
        f = (float)this.jdField_a_of_type_Apdx$a.transferTime / 1000.0F;
      }
    }
    label139:
    for (this.jdField_a_of_type_Apdx$a.speed = (((float)this.jdField_a_of_type_Apdx$a.transferedSize / f));; this.jdField_a_of_type_Apdx$a.speed = 0L)
    {
      super.diL();
      if (alV()) {
        aP(0, 0, 0);
      }
      return;
    }
  }
  
  public void onDownloadSuccess(String paramString)
  {
    if (alV())
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Apdx$a.arf) {
        this.bz = (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Apdx$a.arf);
      }
      if (!aqhq.fileExists(paramString))
      {
        apef.b.e("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "[" + this.coy + "]  onDownloadSuccess but file is not exsited." + paramString);
        jQ(7, 706);
        e(true, apue.a.dVY, apue.a.dWl, 307);
      }
      do
      {
        return;
        long l = ahav.getFileSizes(paramString);
        if ((this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
        {
          apef.b.e("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "[" + this.coy + "]  file size check fail. filesize:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
          jQ(7, 704);
          e(true, apue.a.dVY, apue.a.dWn, 305);
          new File(paramString).delete();
          this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
          return;
        }
        apef.b.i("ExcitingTransfer.ExtfGroupDownloadWorker", apef.b.USR, "[" + this.coy + "] onDownlaodSuc  mFilePath:" + paramString);
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = paramString;
        int i = ahav.getFileType(ahbj.getExtension(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
        if (((i == 2) || (i == 0)) && (!ahbj.isFileExists(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.mTroopUin, 383)))) {
          this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        this.bkn = true;
        this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
        dYY();
        WE(3);
        apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
        paramString = HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
        String str = HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
        a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.mTroopUin), paramString, str, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
        jQ(0, 0);
        diL();
        dYZ();
        apue.jZ(apue.a.RESULT_SUCCESS, 0);
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      } while (this.jdField_a_of_type_Apey$a == null);
      this.jdField_a_of_type_Apey$a.a(a(), true, 0, this);
      return;
    }
    super.onDownloadSuccess(paramString);
  }
  
  public void s(long paramLong1, long paramLong2, long paramLong3) {}
  
  public boolean start()
  {
    this.ceG = false;
    this.YS = 0L;
    return super.start();
  }
  
  public void stop(int paramInt)
  {
    if (alV()) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
    }
    super.stop(paramInt);
  }
  
  class a
  {
    ExcitingTransferDownloadCompletedInfo b;
    int resultCode = 201;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agph
 * JD-Core Version:    0.7.0.1
 */