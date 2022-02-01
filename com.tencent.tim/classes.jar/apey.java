import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.UUID;

public class apey
  implements apev
{
  protected Timer K;
  protected long YS;
  protected apdx.a a;
  protected apeu a;
  protected apey.a a;
  smq.m a;
  protected long arl;
  protected long arm;
  protected long arn;
  public boolean bkn = true;
  protected long bz;
  protected TroopFileProtoReqMgr.b c;
  public TroopFileTransferManager.Item c;
  protected boolean cQh;
  protected int cXp = 0;
  protected boolean cea;
  public String coy;
  public String coz;
  protected Bundle mExtras;
  protected String mFileDir;
  protected String mFilePath;
  protected int mStatus = 0;
  public String mTmpFilePath;
  protected long mTroopUin;
  
  protected apey(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    this.jdField_a_of_type_Apdx$a = new apdx.a();
    this.jdField_a_of_type_Smq$m = new apez(this);
    this.mTroopUin = paramLong;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Apey$a = parama;
    if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.coy = paramItem;
      this.mExtras = paramBundle;
      return;
    }
  }
  
  public static String Bc()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static apey a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, apey.a parama)
  {
    if (paramLong == 0L)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "getWoker. item.id=null");
      return null;
    }
    return new apey(paramLong, paramItem, paramBundle, parama);
  }
  
  protected int Eo()
  {
    if (this.jdField_a_of_type_Apeu == null) {
      return 0;
    }
    return ahbr.dg(this.jdField_a_of_type_Apeu.getUrl());
  }
  
  public void IC(String paramString)
  {
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onChangeUrl:" + paramString);
  }
  
  protected void WE(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return apdx.aQ(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  protected apeu a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    return null;
  }
  
  public UUID a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  protected final void a(apcy paramapcy, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
    localFileManagerEntity.peerNick = aqgv.F(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
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
      label264:
      localQQAppInterface.a().s(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().u(localFileManagerEntity);
      return;
    }
    catch (Exception paramapcy)
    {
      break label264;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.bkn) {
      return;
    }
    int i = apef.eN(paramString1);
    int n = i;
    if (i == 0) {
      n = apef.eO(paramString2);
    }
    int i5 = apef.eP(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i5, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      jQ(i, j);
      this.jdField_a_of_type_Apdx$a.dTJ = i5;
      this.jdField_a_of_type_Apdx$a.dTK = n;
      dZa();
      this.jdField_a_of_type_Apdx$a.dTJ = 0;
      this.jdField_a_of_type_Apdx$a.dTK = 0;
      this.jdField_a_of_type_Apdx$a.resultCode = 0;
      this.jdField_a_of_type_Apdx$a.dTI = 0;
      return;
    }
    apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onHasErr. download fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i5, paramBundle);
    int i4 = 1;
    int i3 = apue.a.dWa;
    int k;
    int m;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      k = 306;
      j = apue.a.dVY;
      paramInt = apue.a.dWh;
      i = 106;
      m = i1;
    }
    for (;;)
    {
      jQ(m, k);
      this.jdField_a_of_type_Apdx$a.dTJ = i5;
      this.jdField_a_of_type_Apdx$a.dTK = n;
      e(true, j, paramInt, i);
      return;
      if (paramInt == -5000)
      {
        m = 7;
        k = 708;
        j = apue.a.dVY;
        paramInt = apue.a.dWe;
        i = 303;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 709;
        j = apue.a.dVY;
        paramInt = apue.a.dWd;
        i = 304;
      }
      else if (paramInt == 9039)
      {
        m = 7;
        k = 710;
        j = apue.a.dVY;
        paramInt = apue.a.dWk;
        i = 308;
      }
      else if (paramInt == 9004)
      {
        m = 3;
        k = 306;
        j = apue.a.dVY;
        paramInt = apue.a.dWh;
        i = 106;
      }
      else if (paramInt == 9301)
      {
        m = 7;
        k = 705;
        j = apue.a.dVY;
        paramInt = apue.a.dWf;
        i = 306;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 704;
        j = apue.a.dVY;
        paramInt = apue.a.dWn;
        i = 305;
      }
      else if (this.jdField_a_of_type_Apeu.alZ())
      {
        m = 4;
        paramInt = apue.a.dWm;
        i = 105;
        j = i3;
        k = i2;
      }
      else
      {
        j = i3;
        i = i4;
        k = i2;
        m = i1;
        if (n != 0)
        {
          paramInt = n;
          j = i3;
          i = i4;
          k = i2;
          m = i1;
        }
      }
    }
  }
  
  public boolean aAV()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.mFileDir)) && (!TextUtils.isEmpty(this.coz))) {
      bool = false;
    }
    VFSFile localVFSFile;
    do
    {
      return bool;
      this.mFileDir = acbn.bmg;
      localVFSFile = new VFSFile(this.mFileDir);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      this.coz = acbn.bmj;
      bool = true;
      localVFSFile = new VFSFile(this.coz);
    } while (localVFSFile.exists());
    return true | localVFSFile.mkdirs();
  }
  
  protected boolean alV()
  {
    return false;
  }
  
  public void dYT()
  {
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onRetryDownload");
    if (this.jdField_a_of_type_Apeu != null) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Apeu.Ez();
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
  
  public void dYV()
  {
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    WE(5);
  }
  
  public void dYW()
  {
    this.cQh = false;
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqDownload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqDownload");
    Object localObject = apef.a(this.mTroopUin);
    if (localObject != null)
    {
      apbr localapbr = ((apsf)localObject).a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localapbr != null)
      {
        localObject = ((apsf)localObject).a(localapbr.mParentId);
        if (localObject != null)
        {
          localapbr.Status = 8;
          ((apbr)localObject).a(localapbr);
        }
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_Smq$m);
    WE(1);
    this.arm = anaz.gQ();
    apue.ebR();
  }
  
  protected void dYX()
  {
    long l = new VFSFile(this.mTmpFilePath).length();
    if ((this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "]  file size check fail. filesize:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
      jQ(7, 704);
      e(true, apue.a.dVY, apue.a.dWn, 305);
      new VFSFile(this.mTmpFilePath).delete();
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
    }
    label438:
    do
    {
      return;
      int j;
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() > 85)
      {
        j = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.lastIndexOf('.');
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() - 85;
        if (i != 0) {
          break label438;
        }
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, 85);
      }
      for (;;)
      {
        localObject2 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
        {
          localObject1 = localObject2;
          if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
            localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = Bc();
        }
        this.mFilePath = new VFSFile(this.mFileDir + (String)localObject2).getAbsoluteFile().toString();
        if (aqhq.fileExists(this.mFilePath)) {
          this.mFilePath = ahav.kW(this.mFilePath);
        }
        if (ahav.b(new VFSFile(this.mTmpFilePath), new VFSFile(this.mFilePath))) {
          break;
        }
        apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] renameFile fail  mFilePath:" + this.mFilePath);
        jQ(7, 706);
        e(true, apue.a.dVY, apue.a.dWl, 307);
        return;
        if (i > j)
        {
          localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j) + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i);
          this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
        }
      }
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onDownlaodSuc  mFilePath:" + this.mFilePath);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = this.mFilePath;
      int i = ahav.getFileType(ahbj.getExtension(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
      if (((i == 2) || (i == 0)) && (!ahbj.isFileExists(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.mTroopUin, 383)))) {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      this.bkn = true;
      this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
      dYY();
      WE(3);
      apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
      Object localObject1 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
      Object localObject2 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
      a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.mTroopUin), (String)localObject1, (String)localObject2, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
      jQ(0, 0);
      diL();
      if (!alV()) {
        dZb();
      }
      dYZ();
      apue.jZ(apue.a.RESULT_SUCCESS, 0);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    } while (this.jdField_a_of_type_Apey$a == null);
    this.jdField_a_of_type_Apey$a.a(a(), true, 0, this);
  }
  
  protected void dYY()
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
  
  protected void dYZ()
  {
    this.jdField_a_of_type_Apdx$a.reset();
    this.YS = 0L;
    this.bz = 0L;
  }
  
  protected final void dZa()
  {
    int i = 1;
    apdx.a locala;
    if (alV())
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
      apdx.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDownDetail", this.jdField_a_of_type_Apdx$a);
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void dZb()
  {
    int i = 1;
    apdx.a locala;
    if (alV())
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
      apdx.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Apdx$a, "actGroupFileDownDetail");
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void diK()
  {
    int i = 1;
    apdx.a locala;
    if (alV())
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
      apdx.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDown", this.jdField_a_of_type_Apdx$a);
      return;
      this.jdField_a_of_type_Apdx$a.fromType = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void diL()
  {
    int i = 1;
    apdx.a locala;
    if (alV())
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
      apdx.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Apdx$a, "actGroupFileDown");
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
    WE(4);
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    diK();
    dYZ();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      apue.N(paramInt1, paramInt2, str);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onDownloadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Apey$a != null) {
      this.jdField_a_of_type_Apey$a.a(a(), false, paramInt2, this);
    }
  }
  
  public long hs()
  {
    return this.mTroopUin;
  }
  
  protected void jQ(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Apeu != null)
    {
      this.jdField_a_of_type_Apdx$a.url = this.jdField_a_of_type_Apeu.getUrl();
      this.jdField_a_of_type_Apdx$a.serverIp = this.jdField_a_of_type_Apeu.vz();
      this.jdField_a_of_type_Apdx$a.port = this.jdField_a_of_type_Apeu.EA();
      this.jdField_a_of_type_Apdx$a.proxyType = this.jdField_a_of_type_Apeu.getProxyType();
    }
    this.jdField_a_of_type_Apdx$a.resultCode = paramInt1;
    this.jdField_a_of_type_Apdx$a.dTI = paramInt2;
    this.jdField_a_of_type_Apdx$a.transferedSize = this.bz;
    if (this.YS != 0L)
    {
      this.jdField_a_of_type_Apdx$a.transferTime = (System.currentTimeMillis() - this.YS);
      if ((this.bz > 0L) && (this.jdField_a_of_type_Apdx$a.transferTime > 0L))
      {
        float f = (float)this.jdField_a_of_type_Apdx$a.transferTime / 1000.0F;
        this.jdField_a_of_type_Apdx$a.speed = (((float)this.bz / f));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Apdx$a.speed = 0L;
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2)
  {
    if (this.bkn) {
      return;
    }
    if (paramLong1 > this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {}
    for (this.bz += paramLong1 - this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;; this.bz = paramLong1)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong1;
      paramLong1 = System.currentTimeMillis();
      if ((this.arl != 0L) && (paramLong1 - this.arl < 1500L)) {
        break;
      }
      this.arl = paramLong1;
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  public void onDownloadSuccess(String paramString)
  {
    if (this.bkn) {
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Apdx$a.arf) {
      this.bz = (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Apdx$a.arf);
    }
    dYX();
  }
  
  public boolean start()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] start filepath is null");
      return false;
    }
    this.bkn = false;
    this.jdField_a_of_type_Apdx$a.startTime = System.currentTimeMillis();
    this.arm = 0L;
    this.arn = 0L;
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
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] start filename:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " bResueFromW2MPause:" + bool1);
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      Object localObject = apef.a(this.mTroopUin);
      if (localObject != null)
      {
        localObject = ((apsf)localObject).a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
        if (localObject != null) {
          this.jdField_a_of_type_Apdx$a.ari = ((apbr)localObject).dTh;
        }
      }
      if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
      {
        apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] no network");
        this.bkn = true;
        WE(4);
        this.jdField_a_of_type_Apdx$a.resultCode = 9;
        this.jdField_a_of_type_Apdx$a.dTI = 901;
        diK();
        this.jdField_a_of_type_Apdx$a.reset();
        apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
        apue.jZ(apue.a.dVY, apue.a.dWh);
        return false;
      }
      ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
      return true;
    }
  }
  
  protected void startDownload()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startDownload app=null");
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 902;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
    }
    if (this.jdField_a_of_type_Apeu != null)
    {
      this.jdField_a_of_type_Apeu.bme();
      this.jdField_a_of_type_Apeu = null;
    }
    String str = "/ftn_handler/" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + aqhs.String2HexString(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    Object localObject1;
    long l;
    boolean bool1;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)) {
      if (agke.a().l(localQQAppInterface, 3))
      {
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopfile. is config enable IPv6. domain[" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        localObject1 = new agke.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
        localObject1 = agke.a().a(localQQAppInterface, (agke.a)localObject1, 3);
        if ((localObject1 != null) && (!((agke.c)localObject1).alz()))
        {
          if (agke.alt())
          {
            QLog.d("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopfile. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          agke.a(((agke.c)localObject1).Bb, localArrayList, true, false);
          this.cXp = 2;
          if (((agke.c)localObject1).cXn == 1) {
            this.cXp = 3;
          }
          QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopfile. use IPv6. iplist:" + localArrayList.toString());
          this.YS = System.currentTimeMillis();
          this.jdField_a_of_type_Apdx$a.arf = ahbj.getFileSize(this.mTmpFilePath);
          l = apef.hr();
          boolean bool2 = false;
          Object localObject2 = null;
          bool1 = bool2;
          localObject1 = localObject2;
          if (apsv.bS(localQQAppInterface))
          {
            bool1 = bool2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
            {
              bool1 = true;
              localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
            }
          }
          this.cea = bool1;
          apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str + " mTmpFilePath:" + this.mTmpFilePath + " bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
          if (!alV()) {
            break label745;
          }
        }
      }
    }
    label745:
    for (this.jdField_a_of_type_Apeu = a(localQQAppInterface, l, this.mTmpFilePath, str, bool1, (String)localObject1);; this.jdField_a_of_type_Apeu = apfa.a(localQQAppInterface, l, this.mTmpFilePath, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject1))
    {
      if (this.jdField_a_of_type_Apeu != null) {
        break label783;
      }
      this.jdField_a_of_type_Apdx$a.resultCode = 9;
      this.jdField_a_of_type_Apdx$a.dTI = 903;
      e(true, apue.a.dVY, apue.a.dWt, 1);
      return;
      QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopfile. use IPv4");
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      this.cXp = 1;
      break;
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      this.cXp = 1;
      break;
      this.cXp = 1;
      break;
    }
    label783:
    this.jdField_a_of_type_Apeu.a(this);
    this.jdField_a_of_type_Apeu.download();
    WE(2);
  }
  
  public void stop(int paramInt)
  {
    int i = 8;
    if ((this.bkn) && (this.mStatus != 5))
    {
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] stop. but had stoped. mStatus:" + this.mStatus);
      return;
    }
    this.bkn = true;
    jQ(8, 0);
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] stop. mStatus:" + this.mStatus);
    if (this.jdField_a_of_type_Apeu != null)
    {
      this.jdField_a_of_type_Apeu.bme();
      this.jdField_a_of_type_Apeu = null;
    }
    dYY();
    if (this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b != null)
    {
      smq.a(apef.getApp(), this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b);
      this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
    int j = 9;
    if (paramInt == 1)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 2;
      i = 11;
    }
    for (;;)
    {
      apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      WE(0);
      this.jdField_a_of_type_Apdx$a.resultCode = i;
      diK();
      dYZ();
      return;
      if (paramInt == 2)
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        i = 12;
      }
      else if (paramInt == 3)
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        j = 10;
        i = 11;
      }
    }
  }
  
  protected void v(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    WE(4);
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    diK();
    dYZ();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      apue.N(paramInt1, paramInt2, str);
    }
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Apey$a != null) {
      this.jdField_a_of_type_Apey$a.a(a(), false, paramInt2, this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(UUID paramUUID, boolean paramBoolean, int paramInt, apey paramapey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apey
 * JD-Core Version:    0.7.0.1
 */