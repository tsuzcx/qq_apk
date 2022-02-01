import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker.3;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class apgb
  extends apfu
  implements apfs, apft.a, apfx.b
{
  protected Timer K;
  protected long YS;
  public apdx.a a;
  protected apfr a;
  protected apfx.c a;
  smq.o jdField_a_of_type_Smq$o = new apgd(this);
  smq.q jdField_a_of_type_Smq$q = new apgc(this);
  protected long arl;
  protected long art;
  protected long aru;
  public boolean bkn = true;
  protected long bz;
  protected TroopFileProtoReqMgr.b c;
  protected int cXp = 0;
  protected boolean cea;
  protected byte[] dU;
  protected Bundle mExtras;
  protected int mStatus = 0;
  
  protected apgb(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apfx.c paramc)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_Apdx$a = new apdx.a();
    this.jdField_a_of_type_Apfx$c = paramc;
    this.mExtras = paramBundle;
  }
  
  public static apgb a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apfx.c paramc)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "getWoker. item.id=null");
    }
    return new apgb(paramLong, paramItem, paramBundle, paramc);
  }
  
  private boolean a(Bundle paramBundle, long paramLong)
  {
    if (paramLong != this.mTroopUin) {}
    do
    {
      return false;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(a())));
    if (this.bkn)
    {
      apef.b.w("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onReqUploadFileResult.but stoped");
      return false;
    }
    return true;
  }
  
  private void dYY()
  {
    try
    {
      if (this.K != null)
      {
        this.K.cancel();
        this.K = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dYZ()
  {
    this.jdField_a_of_type_Apdx$a.reset();
    this.YS = 0L;
    this.aru = 0L;
    this.bz = 0L;
  }
  
  public String Bh()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath;
  }
  
  public String Bi()
  {
    return agoy.t(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
  }
  
  public String Bj()
  {
    return agoy.t(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
  }
  
  protected int Eo()
  {
    if (this.jdField_a_of_type_Apfr == null) {
      return 0;
    }
    return ahbr.dg(this.jdField_a_of_type_Apfr.getUrl());
  }
  
  public void IC(String paramString)
  {
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onChangeUrl:" + paramString);
  }
  
  public int Lp()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId;
  }
  
  public void RC(boolean paramBoolean)
  {
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onUploadSuc. bHit:" + paramBoolean);
    dYY();
    WE(5);
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 6);
    dZm();
    Object localObject = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
    String str = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.mTroopUin), (String)localObject, str, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    this.jdField_a_of_type_Apdx$a.cQb = paramBoolean;
    jQ(0, 0);
    diZ();
    if (!alF()) {
      dZp();
    }
    dYZ();
    localObject = apef.getApp();
    str = this.mTroopUin + "";
    StringBuilder localStringBuilder = new StringBuilder();
    if ("/".equals(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mParentId)) {}
    for (int i = 0;; i = 1)
    {
      anot.a((QQAppInterface)localObject, "P_CliOper", "Grp_files", "", "oper", "upload_suc", 0, 0, str, i + "", "", "");
      apue.jY(apue.a.RESULT_SUCCESS, 0);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = null;
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = null;
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = null;
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = null;
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      if (this.jdField_a_of_type_Apfx$c != null) {
        this.jdField_a_of_type_Apfx$c.a(a(), true, 0, this);
      }
      return;
    }
  }
  
  protected void RE(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] startUpload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    if (this.jdField_a_of_type_Apfr != null)
    {
      this.jdField_a_of_type_Apfr.bme();
      this.jdField_a_of_type_Apfr.a(null);
    }
    String str1 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey);
    String str2 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    long l = apef.hr();
    Object localObject2;
    boolean bool1;
    Object localObject1;
    if (alF())
    {
      boolean bool2 = false;
      localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (apsv.bR(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
        {
          bool1 = true;
          localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
        }
      }
      apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] startUpload. nSessionId:" + l + " use custom fileuploader bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      this.jdField_a_of_type_Apfr = a(localQQAppInterface, l, paramBoolean, bool1, (String)localObject1);
      if (this.jdField_a_of_type_Apfr == null)
      {
        this.jdField_a_of_type_Apdx$a.resultCode = 9;
        this.jdField_a_of_type_Apdx$a.dTI = 904;
        e(true, apue.a.dVY, apue.a.dWt, 1);
      }
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp);
      if ((!paramBoolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))) {
        if (agke.a().l(localQQAppInterface, 3))
        {
          QLog.i("TroopFileUploadWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. is config enable IPv6. domain[" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
          localObject1 = new agke.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns, 0);
          localObject1 = agke.a().a(localQQAppInterface, (agke.a)localObject1, 3);
          if ((localObject1 != null) && (!((agke.c)localObject1).alz()))
          {
            if (agke.alt())
            {
              QLog.d("TroopFileUploadWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. debugIsDisableIPv4OnDoubleStack");
              localArrayList.clear();
            }
            agke.a(((agke.c)localObject1).Bb, localArrayList, true, false);
            this.cXp = 2;
            if (((agke.c)localObject1).cXn == 1) {
              this.cXp = 3;
            }
            QLog.i("TroopFileUploadWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. use IPv6. iplist:" + localArrayList.toString());
          }
        }
      }
      for (;;)
      {
        bool1 = false;
        localObject2 = null;
        paramBoolean = bool1;
        localObject1 = localObject2;
        if (apsv.bR(localQQAppInterface))
        {
          paramBoolean = bool1;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
          {
            paramBoolean = true;
            localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
          }
        }
        this.cea = paramBoolean;
        apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] startUpload. nSessionId:" + l + " UseLastUploadIp=false firstIP=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " bUseHttps:" + paramBoolean + " httpsDomain:" + (String)localObject1);
        this.jdField_a_of_type_Apfr = apge.a(localQQAppInterface, l, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, str1, str2, localArrayList, "/ftn_handler", paramBoolean, (String)localObject1);
        break;
        localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        this.cXp = 1;
        QLog.i("TroopFileUploadWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. use IPv4");
        continue;
        localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        this.cXp = 1;
        continue;
        this.cXp = 1;
      }
    }
    this.YS = System.currentTimeMillis();
    this.jdField_a_of_type_Apdx$a.arf = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Apfr.a(this);
    this.jdField_a_of_type_Apfr.ame();
    WE(3);
  }
  
  protected void WE(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  protected apfr a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return null;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.art != paramLong1) {
      return;
    }
    if (this.bkn)
    {
      apef.b.w("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. but had stop");
      return;
    }
    if (this.aru != 0L)
    {
      this.jdField_a_of_type_Apdx$a.arh = (System.currentTimeMillis() - this.aru);
      this.aru = 0L;
    }
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. errCode:" + paramInt);
    if (paramInt != 0)
    {
      int i = 1;
      int j = apue.a.dWi;
      if (paramInt == -2)
      {
        this.jdField_a_of_type_Apdx$a.resultCode = 5;
        this.jdField_a_of_type_Apdx$a.dTI = 501;
        i = 102;
        paramInt = apue.a.dWp;
      }
      for (;;)
      {
        e(true, apue.a.dVY, paramInt, i);
        return;
        if (paramInt == -1)
        {
          this.jdField_a_of_type_Apdx$a.resultCode = 7;
          this.jdField_a_of_type_Apdx$a.dTI = 700;
          i = 201;
          paramInt = apue.a.dWd;
        }
        else if (paramInt == -4)
        {
          this.jdField_a_of_type_Apdx$a.resultCode = 5;
          this.jdField_a_of_type_Apdx$a.dTI = 502;
          i = 205;
          paramInt = apue.a.dWb;
        }
        else if (paramInt == -3)
        {
          this.jdField_a_of_type_Apdx$a.resultCode = 7;
          this.jdField_a_of_type_Apdx$a.dTI = 701;
          i = 203;
          paramInt = apue.a.dWg;
        }
        else
        {
          this.jdField_a_of_type_Apdx$a.resultCode = 5;
          this.jdField_a_of_type_Apdx$a.dTI = 503;
          paramInt = j;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. md5 or sha is null");
      this.jdField_a_of_type_Apdx$a.resultCode = 5;
      this.jdField_a_of_type_Apdx$a.dTI = 503;
      e(true, apue.a.dVY, apue.a.dWi, 211);
      return;
    }
    if ((paramLong2 != 0L) && (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramArrayOfByte1;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = paramArrayOfByte2;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
    this.dU = paramArrayOfByte3;
    if (paramBundle != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = paramBundle.getInt("_with_", 0);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = paramBundle.getInt("_height_", 0);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramBundle.getInt("_duration_", 0);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    dZn();
  }
  
  protected final void a(apcy paramapcy, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
    localFileManagerEntity.peerNick = aqgv.F(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.mTroopUin;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = agoy.t(ahav.A(paramapcy.LocalFile));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = agoy.t(ahav.x(paramapcy.LocalFile));
      }
    }
    localFileManagerEntity.str10Md5 = aqhs.bytes2HexStr(ahav.t(paramapcy.LocalFile));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramapcy.LocalFile).lastModified();
      label229:
      localQQAppInterface.a().s(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().u(localFileManagerEntity);
      return;
    }
    catch (Exception paramapcy)
    {
      break label229;
    }
  }
  
  protected void a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, apsd.a parama)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    WE(6);
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, parama);
    diY();
    dYZ();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      apue.M(paramInt1, paramInt2, str);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + parama.errorCode);
    if (this.jdField_a_of_type_Apfx$c != null) {
      this.jdField_a_of_type_Apfx$c.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.bkn) {
      return;
    }
    int i = apef.eN(paramString1);
    int k = i;
    if (i == 0) {
      k = apef.eO(paramString2);
    }
    int i5 = apef.eP(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = hH(paramInt);
      j = aB(paramInt, i5);
      if (paramInt == 9050) {
        i = 4;
      }
      jQ(i, j);
      this.jdField_a_of_type_Apdx$a.dTJ = i5;
      this.jdField_a_of_type_Apdx$a.dTK = k;
      dZo();
      this.jdField_a_of_type_Apdx$a.dTJ = 0;
      this.jdField_a_of_type_Apdx$a.dTK = 0;
      this.jdField_a_of_type_Apdx$a.resultCode = 0;
      this.jdField_a_of_type_Apdx$a.dTI = 0;
      return;
    }
    apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    int i1 = hH(paramInt);
    int i3 = aB(paramInt, i5);
    int i4 = 1;
    int i2 = apue.a.dWa;
    int m;
    int n;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      j = 306;
      m = apue.a.dVY;
      paramInt = apue.a.dWh;
      i = 106;
      n = i1;
    }
    for (;;)
    {
      jQ(n, j);
      this.jdField_a_of_type_Apdx$a.dTJ = i5;
      this.jdField_a_of_type_Apdx$a.dTK = k;
      e(true, m, paramInt, i);
      return;
      if (paramInt == 9343)
      {
        j = 313;
        paramInt = apue.a.dWz;
        m = i2;
        i = i4;
        n = i1;
      }
      else if (paramInt == 9303)
      {
        n = 7;
        j = 707;
        m = apue.a.dVY;
        paramInt = apue.a.dWg;
        i = 203;
      }
      else if (paramInt == 9042)
      {
        j = 311;
        paramInt = apue.a.dWd;
        i = 206;
        m = i2;
        n = i1;
      }
      else if ((k == -38006) || (k == -38007) || (k == -38020))
      {
        j = 311;
        i = 206;
        paramInt = k;
        m = i2;
        n = i1;
      }
      else if (this.jdField_a_of_type_Apfr.alZ())
      {
        n = 4;
        if (k != 0) {
          paramInt = k;
        }
        i = 105;
        m = i2;
        j = i3;
      }
      else
      {
        m = i2;
        i = i4;
        j = i3;
        n = i1;
        if (k != 0)
        {
          paramInt = k;
          m = i2;
          i = i4;
          j = i3;
          n = i1;
        }
      }
    }
  }
  
  public boolean aAY()
  {
    return true;
  }
  
  protected int aB(int paramInt1, int paramInt2)
  {
    return apdx.aQ(paramInt1, paramInt2);
  }
  
  public void aK(long paramLong1, long paramLong2)
  {
    this.aru = System.currentTimeMillis();
    int j = 0;
    int i = j;
    if (paramLong2 != 0L)
    {
      i = j;
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
        i = 1;
      }
    }
    apue.ebQ();
    if (i != 0)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    }
  }
  
  protected boolean alF()
  {
    return false;
  }
  
  public void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.bkn) {}
    while (!paramBoolean) {
      return;
    }
    jQ(3, 312);
    e(true, apue.a.dWa, apue.a.dWs, 102);
  }
  
  public void dYV()
  {
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    WE(7);
  }
  
  protected void dZn()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] reqUploadFile app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] reqUploadFile");
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    diT();
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, Long.valueOf(this.mTroopUin).longValue(), this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Smq$q);
    WE(2);
  }
  
  protected final void dZo()
  {
    int i = 1;
    apdx.a locala;
    if (alF())
    {
      this.jdField_a_of_type_Apdx$a.fromType = 1;
      this.jdField_a_of_type_Apdx$a.dTL = this.cXp;
      this.jdField_a_of_type_Apdx$a.dTM = Eo();
      locala = this.jdField_a_of_type_Apdx$a;
      if (!this.cea) {
        break label86;
      }
    }
    for (;;)
    {
      locala.afE = i;
      apdx.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUpDetail", this.jdField_a_of_type_Apdx$a);
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected final void dZp()
  {
    int i = 1;
    apdx.a locala;
    if (alF())
    {
      this.jdField_a_of_type_Apdx$a.fromType = 1;
      this.jdField_a_of_type_Apdx$a.dTL = this.cXp;
      this.jdField_a_of_type_Apdx$a.dTM = Eo();
      locala = this.jdField_a_of_type_Apdx$a;
      if (!this.cea) {
        break label86;
      }
    }
    for (;;)
    {
      locala.afE = i;
      apdx.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Apdx$a, "actGroupFileUpDetail");
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  public void dgA()
  {
    if (this.bkn) {
      return;
    }
    RC(false);
  }
  
  public void dgB()
  {
    if (this.bkn) {
      return;
    }
    apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onOutDate. upload fail");
    jQ(3, 302);
    this.jdField_a_of_type_Apdx$a.dTK = -29120;
    e(true, apue.a.dWa, -29120, 206);
  }
  
  public void dgC()
  {
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onRetrySend");
    if (this.jdField_a_of_type_Apfr != null) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Apfr.EG();
    }
    this.YS = System.currentTimeMillis();
    this.jdField_a_of_type_Apdx$a.arf = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Apdx$a.dTJ = 0;
    this.jdField_a_of_type_Apdx$a.dTK = 0;
    this.jdField_a_of_type_Apdx$a.resultCode = -1;
    this.jdField_a_of_type_Apdx$a.dTI = 0;
    this.jdField_a_of_type_Apdx$a.errMsg = "";
    this.jdField_a_of_type_Apdx$a.cow = "";
  }
  
  public void dgz()
  {
    if (this.bkn) {
      return;
    }
    new Handler().postDelayed(new TroopFileUploadWorker.3(this), 200L);
  }
  
  protected void diT() {}
  
  protected void diU()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] reqReUpload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] reqReUpload");
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Smq$o);
    WE(2);
  }
  
  protected void diY()
  {
    int i = 1;
    apdx.a locala;
    if (alF())
    {
      this.jdField_a_of_type_Apdx$a.fromType = 1;
      this.jdField_a_of_type_Apdx$a.dTL = this.cXp;
      this.jdField_a_of_type_Apdx$a.dTM = Eo();
      locala = this.jdField_a_of_type_Apdx$a;
      if (!this.cea) {
        break label86;
      }
    }
    for (;;)
    {
      locala.afE = i;
      apdx.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUp", this.jdField_a_of_type_Apdx$a);
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void diZ()
  {
    int i = 1;
    apdx.a locala;
    if (alF())
    {
      this.jdField_a_of_type_Apdx$a.fromType = 1;
      this.jdField_a_of_type_Apdx$a.dTL = this.cXp;
      this.jdField_a_of_type_Apdx$a.dTM = Eo();
      locala = this.jdField_a_of_type_Apdx$a;
      if (!this.cea) {
        break label86;
      }
    }
    for (;;)
    {
      locala.afE = i;
      apdx.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Apdx$a, "actGroupFileUp");
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    WE(6);
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramInt3);
    diY();
    dYZ();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      apue.M(paramInt1, paramInt2, str);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Apfx$c != null) {
      this.jdField_a_of_type_Apfx$c.a(a(), false, paramInt2, this);
    }
  }
  
  public String getFilePath()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile;
  }
  
  public long getFileSize()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
  }
  
  public int getImgHeight()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height;
  }
  
  public int getImgWidth()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width;
  }
  
  public int getVideoDuration()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration;
  }
  
  protected int hH(int paramInt)
  {
    return 3;
  }
  
  protected void jQ(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Apfr != null)
    {
      this.jdField_a_of_type_Apdx$a.url = this.jdField_a_of_type_Apfr.getUrl();
      this.jdField_a_of_type_Apdx$a.serverIp = this.jdField_a_of_type_Apfr.vC();
      this.jdField_a_of_type_Apdx$a.port = this.jdField_a_of_type_Apfr.EH();
      this.jdField_a_of_type_Apdx$a.proxyType = this.jdField_a_of_type_Apfr.getProxyType();
    }
    this.jdField_a_of_type_Apdx$a.resultCode = paramInt1;
    this.jdField_a_of_type_Apdx$a.dTI = paramInt2;
    long l2 = this.bz;
    long l1 = l2;
    if (paramInt1 == 0)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Apfr != null)
      {
        this.jdField_a_of_type_Apdx$a.arf = this.jdField_a_of_type_Apfr.fG();
        this.jdField_a_of_type_Apdx$a.cQb = this.jdField_a_of_type_Apfr.alC();
        if (!this.jdField_a_of_type_Apdx$a.cQb) {
          break label246;
        }
      }
    }
    label246:
    for (l1 = 0L;; l1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Apfr.fG())
    {
      this.jdField_a_of_type_Apdx$a.transferedSize = l1;
      if (this.YS != 0L)
      {
        this.jdField_a_of_type_Apdx$a.transferTime = (System.currentTimeMillis() - this.YS);
        if ((this.jdField_a_of_type_Apdx$a.transferedSize <= 0L) || (this.jdField_a_of_type_Apdx$a.transferTime <= 0L)) {
          break;
        }
        float f = (float)this.jdField_a_of_type_Apdx$a.transferTime / 1000.0F;
        this.jdField_a_of_type_Apdx$a.speed = (((float)this.jdField_a_of_type_Apdx$a.transferedSize / f));
      }
      return;
    }
    this.jdField_a_of_type_Apdx$a.speed = 0L;
  }
  
  public void jm(long paramLong)
  {
    if (this.bkn) {
      return;
    }
    if (paramLong > this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {}
    for (this.bz += paramLong - this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;; this.bz = paramLong)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong;
      paramLong = System.currentTimeMillis();
      if ((this.arl != 0L) && (paramLong - this.arl < 1500L)) {
        break;
      }
      this.arl = paramLong;
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  protected void scanFile()
  {
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    this.art = apft.a().a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, this, null);
    if (this.art == 0L)
    {
      this.jdField_a_of_type_Apdx$a.resultCode = 5;
      this.jdField_a_of_type_Apdx$a.dTI = 504;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    WE(1);
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] scanFile. cookie:" + this.art);
  }
  
  public boolean start()
  {
    this.bkn = false;
    this.jdField_a_of_type_Apdx$a.reset();
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer = false;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = null;
    this.jdField_a_of_type_Apdx$a.startTime = System.currentTimeMillis();
    this.cea = false;
    boolean bool2;
    if (this.mExtras != null)
    {
      bool2 = this.mExtras.getBoolean("_wifi2mobile_resume_", false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause == 2) {
          this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 0;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] start filepath:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile + " bResueFromW2MPause:" + bool1);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
      {
        apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] no network");
        this.bkn = true;
        WE(6);
        apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
        this.jdField_a_of_type_Apdx$a.resultCode = 9;
        this.jdField_a_of_type_Apdx$a.dTI = 901;
        diY();
        this.jdField_a_of_type_Apdx$a.reset();
        apue.jY(apue.a.dVY, apue.a.dWh);
        return false;
      }
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 == null) {
        scanFile();
      }
      for (;;)
      {
        return true;
        if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath == null) {
          dZn();
        } else {
          diU();
        }
      }
    }
  }
  
  public void stop(int paramInt)
  {
    int j = 2;
    if ((this.bkn) && (this.mStatus != 7))
    {
      apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] stop. but had stoped. mStatus:" + this.mStatus);
      return;
    }
    this.bkn = true;
    jQ(8, 0);
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] stop. mStatus:" + this.mStatus + " reason:" + paramInt);
    int i;
    if (this.mStatus == 1)
    {
      apft.a().lM(this.art);
      dYY();
      if (this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b != null)
      {
        smq.a(apef.getApp(), this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b);
        this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
      }
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
      i = 8;
      if (paramInt != 1) {
        break label303;
      }
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 2;
      i = 11;
    }
    for (;;)
    {
      apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      WE(0);
      this.jdField_a_of_type_Apdx$a.resultCode = i;
      diY();
      dYZ();
      return;
      if (this.mStatus != 3) {
        break;
      }
      if (this.jdField_a_of_type_Apfr != null)
      {
        this.jdField_a_of_type_Apfr.bme();
        this.jdField_a_of_type_Apfr = null;
        break;
      }
      apef.b.w("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] stop upload. uploader=null");
      break;
      label303:
      if (paramInt == 2)
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        i = 12;
      }
      else if (paramInt == 3)
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        i = 11;
        j = 3;
      }
    }
  }
  
  protected void v(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    WE(6);
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    diY();
    dYZ();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      apue.M(paramInt1, paramInt2, str);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.coy + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Apfx$c != null) {
      this.jdField_a_of_type_Apfx$c.a(a(), false, paramInt2, this);
    }
  }
  
  public void y(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.art != paramLong1) {}
    while (this.bkn) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ScanPos = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgb
 * JD-Core Version:    0.7.0.1
 */