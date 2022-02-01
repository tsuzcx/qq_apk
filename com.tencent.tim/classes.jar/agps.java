import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class agps
  extends apgb
  implements agqd
{
  protected List<String> BA;
  protected List<String> BB;
  protected long ZU;
  private boolean ceI;
  private boolean ceJ = true;
  private Map<Integer, Integer> kG;
  private Map<Integer, Integer> kH;
  private Map<Integer, Integer> kI;
  protected long mFileSize;
  protected int mLanPort;
  protected long mTroopCode;
  
  protected agps(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apfx.c paramc)
  {
    super(paramLong, paramItem, paramBundle, paramc);
  }
  
  private int EC()
  {
    if ((this.jdField_a_of_type_Apfr != null) && ((this.jdField_a_of_type_Apfr instanceof agqb))) {
      return ((agqb)this.jdField_a_of_type_Apfr).EF();
    }
    return 0;
  }
  
  private void Jx(boolean paramBoolean)
  {
    QLog.w("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] setCloseExtfAbility:" + this.ceI + "->" + paramBoolean);
    this.ceI = paramBoolean;
  }
  
  private void Or(int paramInt)
  {
    boolean bool = true;
    Object localObject = a();
    agpr localagpr = new agpr(apef.getApp());
    localagpr.setResult(paramInt);
    int i = EC();
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localagpr.a((ExcitingTransferUploadResultRp)localObject);
        paramInt = ahbr.df(((ExcitingTransferUploadResultRp)localObject).m_strServerIp);
        localagpr.p(this.ZU);
        localObject = ahav.lb(this.c.LocalFile);
        localagpr.a(this.c.troopuin, this.mTroopCode, this.c.FileName, (String)localObject, this.mFileSize);
        localagpr.Jw(this.jdField_a_of_type_Apdx$a.cQb);
        long l = System.currentTimeMillis() - this.jdField_a_of_type_Apdx$a.startTime;
        if (l <= 0L) {
          break label380;
        }
        localagpr.jJ(l);
        label152:
        l = this.jdField_a_of_type_Apdx$a.arh;
        if (l <= 0L) {
          break label389;
        }
        localagpr.jI(l);
      }
    }
    for (;;)
    {
      localagpr.Oo(i);
      localagpr.Op(paramInt);
      localagpr.Ju(this.cea);
      localagpr.Js(bool);
      return;
      bool = false;
      break;
      label217:
      float f;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new ExcitingTransferUploadResultRp();
        ((ExcitingTransferUploadResultRp)localObject).m_nResult = paramInt;
        if (this.YS > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.YS);
        }
        if (this.jdField_a_of_type_Apdx$a.arf > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Apdx$a.arf;
        }
        if (this.jdField_a_of_type_Apdx$a.transferedSize > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Apdx$a.transferedSize;
        }
        if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime <= 0L) || (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize <= 0L)) {
          break label371;
        }
        f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
      }
      label371:
      for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
      {
        ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
        localagpr.a((ExcitingTransferUploadResultRp)localObject);
        paramInt = 0;
        break;
        bool = false;
        break label217;
      }
      label380:
      localagpr.jJ(0L);
      break label152;
      label389:
      localagpr.jI(0L);
    }
  }
  
  public static apgb a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apfx.c paramc)
  {
    if (paramLong == 0L)
    {
      apef.b.e("ExcitingTransfer.TroopFileUploadWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("ExcitingTransfer.TroopFileUploadWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      apef.b.e("ExcitingTransfer.TroopFileUploadWorker", apef.b.USR, "getWoker. item.id=null");
    }
    return new agps(paramLong, paramItem, paramBundle, paramc);
  }
  
  private ExcitingTransferUploadResultRp a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Apfr != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_Apfr instanceof agqb)) {
        localObject1 = ((agqb)this.jdField_a_of_type_Apfr).b();
      }
    }
    return localObject1;
  }
  
  private void diM()
  {
    agpr localagpr = new agpr(apef.getApp());
    localagpr.setResult(33);
    localagpr.p(this.ZU);
    Object localObject = ahav.lb(this.c.LocalFile);
    localagpr.a(this.c.troopuin, this.mTroopCode, this.c.FileName, (String)localObject, this.mFileSize);
    localagpr.Jw(false);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Apdx$a.startTime;
    label119:
    float f;
    if (l > 0L)
    {
      localagpr.jJ(l);
      l = this.jdField_a_of_type_Apdx$a.arh;
      if (l <= 0L) {
        break label297;
      }
      localagpr.jI(l);
      localObject = new ExcitingTransferUploadResultRp();
      if (this.YS > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.YS);
      }
      if (this.jdField_a_of_type_Apdx$a.arf > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Apdx$a.arf;
      }
      if (this.jdField_a_of_type_Apdx$a.transferedSize > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Apdx$a.transferedSize;
      }
      if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime <= 0L) || (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize <= 0L)) {
        break label306;
      }
      f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
    }
    label297:
    label306:
    for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
    {
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localagpr.a((ExcitingTransferUploadResultRp)localObject);
      localagpr.Oo(EC());
      localagpr.Ju(this.cea);
      localagpr.Js(false);
      return;
      localagpr.jJ(0L);
      break;
      localagpr.jI(0L);
      break label119;
    }
  }
  
  private void diV()
  {
    if (this.kH != null) {
      return;
    }
    this.kH = new HashMap();
    this.kH.put(Integer.valueOf(0), Integer.valueOf(0));
    this.kH.put(Integer.valueOf(1), Integer.valueOf(307));
    this.kH.put(Integer.valueOf(2), Integer.valueOf(901));
    this.kH.put(Integer.valueOf(3), Integer.valueOf(300));
    this.kH.put(Integer.valueOf(4), Integer.valueOf(307));
    this.kH.put(Integer.valueOf(5), Integer.valueOf(309));
    this.kH.put(Integer.valueOf(6), Integer.valueOf(308));
    this.kH.put(Integer.valueOf(7), Integer.valueOf(10));
    this.kH.put(Integer.valueOf(8), Integer.valueOf(707));
    this.kH.put(Integer.valueOf(9), Integer.valueOf(4));
    this.kH.put(Integer.valueOf(10), Integer.valueOf(4));
    this.kH.put(Integer.valueOf(11), Integer.valueOf(9));
    this.kH.put(Integer.valueOf(12), Integer.valueOf(309));
    this.kH.put(Integer.valueOf(13), Integer.valueOf(312));
    this.kH.put(Integer.valueOf(14), Integer.valueOf(309));
    this.kH.put(Integer.valueOf(15), Integer.valueOf(309));
    this.kH.put(Integer.valueOf(16), Integer.valueOf(300));
    this.kH.put(Integer.valueOf(17), Integer.valueOf(9));
    this.kH.put(Integer.valueOf(18), Integer.valueOf(307));
    this.kH.put(Integer.valueOf(19), Integer.valueOf(4));
    this.kH.put(Integer.valueOf(20), Integer.valueOf(4));
    this.kH.put(Integer.valueOf(30), Integer.valueOf(2));
    this.kH.put(Integer.valueOf(31), Integer.valueOf(1));
    this.kH.put(Integer.valueOf(32), Integer.valueOf(503));
    this.kH.put(Integer.valueOf(33), Integer.valueOf(8));
  }
  
  private void diW()
  {
    if (this.kG != null) {
      return;
    }
    this.kG = new HashMap();
    this.kG.put(Integer.valueOf(0), Integer.valueOf(0));
    this.kG.put(Integer.valueOf(1), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(2), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(3), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(4), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(5), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(6), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(10), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(12), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(13), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(14), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(15), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(16), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(18), Integer.valueOf(3));
    this.kG.put(Integer.valueOf(9), Integer.valueOf(4));
    this.kG.put(Integer.valueOf(19), Integer.valueOf(4));
    this.kG.put(Integer.valueOf(20), Integer.valueOf(4));
    this.kG.put(Integer.valueOf(17), Integer.valueOf(9));
    this.kG.put(Integer.valueOf(11), Integer.valueOf(9));
    this.kG.put(Integer.valueOf(7), Integer.valueOf(10));
    this.kG.put(Integer.valueOf(8), Integer.valueOf(7));
    this.kG.put(Integer.valueOf(30), Integer.valueOf(1));
    this.kG.put(Integer.valueOf(31), Integer.valueOf(1));
    this.kG.put(Integer.valueOf(32), Integer.valueOf(5));
    this.kG.put(Integer.valueOf(33), Integer.valueOf(8));
  }
  
  private void diX()
  {
    if (this.kI != null) {
      return;
    }
    this.kI = new HashMap();
    this.kI.put(Integer.valueOf(0), Integer.valueOf(0));
    this.kI.put(Integer.valueOf(1), Integer.valueOf(31));
    this.kI.put(Integer.valueOf(100), Integer.valueOf(31));
    this.kI.put(Integer.valueOf(101), Integer.valueOf(31));
    this.kI.put(Integer.valueOf(102), Integer.valueOf(31));
    this.kI.put(Integer.valueOf(2), Integer.valueOf(30));
    this.kI.put(Integer.valueOf(3), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(300), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(301), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(302), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(303), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(304), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(305), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(313), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(309), Integer.valueOf(5));
    this.kI.put(Integer.valueOf(306), Integer.valueOf(2));
    this.kI.put(Integer.valueOf(901), Integer.valueOf(2));
    this.kI.put(Integer.valueOf(4), Integer.valueOf(1));
    this.kI.put(Integer.valueOf(307), Integer.valueOf(1));
    this.kI.put(Integer.valueOf(308), Integer.valueOf(1));
    this.kI.put(Integer.valueOf(312), Integer.valueOf(13));
    this.kI.put(Integer.valueOf(5), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(501), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(502), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(503), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(504), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(701), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(702), Integer.valueOf(32));
    this.kI.put(Integer.valueOf(7), Integer.valueOf(11));
    this.kI.put(Integer.valueOf(700), Integer.valueOf(11));
    this.kI.put(Integer.valueOf(703), Integer.valueOf(11));
    this.kI.put(Integer.valueOf(704), Integer.valueOf(11));
    this.kI.put(Integer.valueOf(707), Integer.valueOf(8));
    this.kI.put(Integer.valueOf(708), Integer.valueOf(8));
    this.kI.put(Integer.valueOf(709), Integer.valueOf(8));
    this.kI.put(Integer.valueOf(710), Integer.valueOf(8));
    this.kI.put(Integer.valueOf(8), Integer.valueOf(33));
    this.kI.put(Integer.valueOf(9), Integer.valueOf(17));
    this.kI.put(Integer.valueOf(902), Integer.valueOf(17));
    this.kI.put(Integer.valueOf(904), Integer.valueOf(17));
    this.kI.put(Integer.valueOf(10), Integer.valueOf(7));
    this.kI.put(Integer.valueOf(11), Integer.valueOf(11));
    this.kI.put(Integer.valueOf(12), Integer.valueOf(11));
  }
  
  private int hD(int paramInt)
  {
    diX();
    if (this.kI.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.kI.get(Integer.valueOf(paramInt))).intValue();
    }
    return 17;
  }
  
  private int hF(int paramInt)
  {
    diV();
    if (this.kH.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.kH.get(Integer.valueOf(paramInt))).intValue();
    }
    return 9;
  }
  
  private int hG(int paramInt)
  {
    diW();
    if (this.kG.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.kG.get(Integer.valueOf(paramInt))).intValue();
    }
    return 9;
  }
  
  protected apfr a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "^_^ nSessionID[" + paramLong + "] get ExtfFileUploader. bIsHttps:" + paramBoolean2 + " strHttpsDomain:" + paramString + " bResend:" + paramBoolean1);
    if ((TroopManager)paramQQAppInterface.getManager(52) == null)
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] getCustomFileUploader.troopManager=null");
      return null;
    }
    this.mTroopCode = this.c.troopuin;
    Object localObject1 = null;
    if (!TextUtils.isEmpty(this.c.FilePath)) {
      localObject1 = this.c.FilePath.getBytes();
    }
    if (localObject1 == null)
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] getCustomFileUploader. uuid err");
      return null;
    }
    this.ZU = paramLong;
    this.mFileSize = ahav.getFileSizes(this.c.LocalFile);
    agqb.a locala = new agqb.a(this.c.LocalFile, null, this.c.Md5, null, this.dU, this.c.Sha, this.mTroopCode, (byte[])localObject1, this.c.CheckKey);
    ArrayList localArrayList1 = new ArrayList();
    if ((this.BA != null) && (this.BA.size() > 0))
    {
      localObject3 = this.BA.iterator();
      for (localObject1 = "";; localObject1 = (String)localObject1 + "[" + (String)localObject2 + ":" + this.mLanPort + "] ")
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject3).next();
        localArrayList1.add(new ExcitingTransferHostInfo((String)localObject2, this.mLanPort));
      }
    }
    Object localObject2 = "";
    Object localObject3 = "";
    ArrayList localArrayList2 = new ArrayList();
    localObject1 = localObject3;
    if (this.BB != null)
    {
      localObject1 = localObject3;
      if (this.BB.size() > 0)
      {
        localObject3 = this.BB.iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = (String)localObject1 + "[" + str + ":" + this.mLanPort + "] ")
        {
          str = (String)((Iterator)localObject3).next();
          localArrayList2.add(new ExcitingTransferHostInfo(str, this.mLanPort));
        }
      }
    }
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] ExtfGroupFileUploader LanIpV4list:" + (String)localObject2);
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] ExtfGroupFileUploader LanIpV6list:" + (String)localObject1);
    paramString = new agqc(localArrayList1, localArrayList2, paramBoolean2, paramString, null);
    paramQQAppInterface = agqb.a(paramQQAppInterface, paramLong, this.c.troopuin, locala, paramString);
    if (paramQQAppInterface != null)
    {
      ((agqb)paramQQAppInterface).a(this);
      return paramQQAppInterface;
    }
    QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "^_^ [" + this.coy + "] get ExtfFileUploader fail.");
    return paramQQAppInterface;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    boolean bool = true;
    this.cXp = EC();
    jQ(hG(paramInt), hF(paramInt));
    agpt localagpt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Apdx$a.dTJ = 0;
      this.jdField_a_of_type_Apdx$a.dTK = 0;
      dZo();
      this.jdField_a_of_type_Apdx$a.resultCode = 0;
      this.jdField_a_of_type_Apdx$a.dTI = 0;
      if (paramExcitingTransferUploaderRp == null) {
        break label211;
      }
      localagpt = new agpt(apef.getApp());
      localagpt.p(this.ZU);
      String str = ahav.lb(this.c.LocalFile);
      localagpt.setResult(paramInt);
      localagpt.a(this.c.troopuin, this.mTroopCode, this.c.FileName, str, this.mFileSize);
      localagpt.a(paramExcitingTransferUploaderRp);
      localagpt.Oo(EC());
      localagpt.Op(ahbr.df(paramExcitingTransferUploaderRp.m_strServerIp));
      localagpt.Ju(this.cea);
      if (paramInt != 0) {
        break label206;
      }
    }
    for (;;)
    {
      localagpt.Js(bool);
      return;
      this.jdField_a_of_type_Apdx$a.resultCode = 0;
      this.jdField_a_of_type_Apdx$a.dTI = 0;
      dZp();
      break;
      label206:
      bool = false;
    }
    label211:
    QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] onExtfSubUploaderResult DataReport fail. no rp");
  }
  
  protected void a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody)
  {
    if ((alF()) && (paramUploadFileRspBody != null))
    {
      if (paramUploadFileRspBody.str_upload_ip_lan_v4.has()) {
        this.BA = paramUploadFileRspBody.str_upload_ip_lan_v4.get();
      }
      if (paramUploadFileRspBody.str_upload_ip_lan_v6.has()) {
        this.BB = paramUploadFileRspBody.str_upload_ip_lan_v6.get();
      }
      if (paramUploadFileRspBody.uint32_upload_port.has()) {
        this.mLanPort = paramUploadFileRspBody.uint32_upload_port.get();
      }
      if ("[" + this.coy + "] onReqUploadFileRspSuc LanIpV4list:{" + this.BA == null) {
        break label128;
      }
      paramUploadFileRspBody = this.BA.toString();
    }
    for (;;)
    {
      QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, paramUploadFileRspBody);
      return;
      label128:
      if ("} LanIpV6List:{" + this.BB != null) {
        paramUploadFileRspBody = this.BB.toString();
      } else {
        paramUploadFileRspBody = "} LanPort:" + this.mLanPort;
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.bkn) {
      return;
    }
    if ((this.ceJ) && (paramBoolean) && (alF()))
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "*_* [" + this.coy + "] exciting tansfer fail. ftnUploader try again");
      Or(paramInt);
      Jx(true);
      this.c.FilePath = null;
      start();
      return;
    }
    super.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  protected int aB(int paramInt1, int paramInt2)
  {
    if (alF()) {
      return hF(paramInt1);
    }
    return super.aB(paramInt1, paramInt2);
  }
  
  protected boolean alF()
  {
    return !amb();
  }
  
  public boolean amb()
  {
    return this.ceI;
  }
  
  protected void diT()
  {
    if (alF()) {}
    for (this.c.bExtfTransfer = true;; this.c.bExtfTransfer = false)
    {
      QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.coy + "] onBeforeReqUploadFile bExtfTransfer:" + this.c.bExtfTransfer);
      return;
    }
  }
  
  protected void diU()
  {
    if (alF())
    {
      dZn();
      return;
    }
    super.diU();
  }
  
  protected void diY()
  {
    if (alF()) {
      this.cXp = EC();
    }
    super.diY();
    if (alF())
    {
      if ((this.jdField_a_of_type_Apdx$a.resultCode == 8) || (this.jdField_a_of_type_Apdx$a.resultCode == 11) || (this.jdField_a_of_type_Apdx$a.resultCode == 12)) {
        diM();
      }
    }
    else {
      return;
    }
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = a();
    int j;
    if (localExcitingTransferUploadResultRp != null) {
      j = (int)localExcitingTransferUploadResultRp.m_nResult;
    }
    for (;;)
    {
      Or(j);
      return;
      j = this.jdField_a_of_type_Apdx$a.dTI;
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_Apdx$a.resultCode;
      }
      j = i;
      if (this.YS != 0L) {
        j = hD(i);
      }
    }
  }
  
  protected void diZ()
  {
    if (alF()) {
      this.cXp = EC();
    }
    super.diZ();
    if (alF()) {
      Or(0);
    }
  }
  
  public void dja()
  {
    this.YS = System.currentTimeMillis();
  }
  
  protected int hH(int paramInt)
  {
    if (alF()) {
      return hG(paramInt);
    }
    return super.hH(paramInt);
  }
  
  public boolean start()
  {
    this.BA = null;
    this.BB = null;
    this.YS = 0L;
    return super.start();
  }
  
  public void u(long paramLong1, long paramLong2, long paramLong3)
  {
    float f;
    String str;
    if (paramLong3 > 1048576L)
    {
      f = (float)paramLong3 / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      str = "加速上传 " + str + "MB/s";
    }
    for (;;)
    {
      this.c.mExcitingSpeed = str;
      return;
      if (paramLong3 > 1024L)
      {
        f = (float)paramLong3 / 1024.0F;
        str = new DecimalFormat("0.00").format(f);
        str = "加速上传 " + str + "KB/s";
      }
      else
      {
        str = "加速上传 " + paramLong3 + "KB/s";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agps
 * JD-Core Version:    0.7.0.1
 */