import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class apfn
  implements apfl.a
{
  protected Timer K;
  protected apfl a;
  protected apfn.a a;
  smq.m a;
  public int bYf;
  public boolean bkn = true;
  protected TroopFileProtoReqMgr.b c;
  public TroopFileTransferManager.Item c;
  protected boolean cQk;
  public String coy;
  protected String coz;
  protected String mFileDir;
  public String mFilePath;
  protected int mStatus = 0;
  public String mTmpFilePath;
  public long mTroopUin;
  
  protected apfn(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, apfn.a parama)
  {
    this.jdField_a_of_type_Smq$m = new apfo(this);
    this.mTroopUin = paramLong;
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Apfn$a = parama;
    this.bYf = paramInt;
    this.coy = apfm.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (ahav.getFileType(ahbj.getExtension(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.cQk = true;
    }
  }
  
  public static apfn a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, apfn.a parama)
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
    if (paramInt == 0)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "getWoker. nThumbSize=0");
      return null;
    }
    return new apfn(paramLong, paramItem, paramInt, parama);
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
  
  public String Bd()
  {
    return this.coy;
  }
  
  public void IC(String paramString) {}
  
  public void RC(boolean paramBoolean)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    if ((!paramBoolean) && (!ahav.b(new VFSFile(this.mTmpFilePath), new VFSFile(this.mFilePath))))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] renameFile fail  mFilePath:" + this.mFilePath);
      if (aqhq.fileExistsAndNotEmpty(this.mFilePath)) {
        WG(apue.a.dWl);
      }
    }
    do
    {
      return;
      WE(3);
      dZj();
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onFetchSuc  mFilePath:" + this.mFilePath);
      if (!paramBoolean) {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.bYf == 640) && (!ahbj.isFileExists(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.mTroopUin, 383)))) {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      ahbh.d(this.mFilePath, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      apdw.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_Apfn$a == null);
    this.jdField_a_of_type_Apfn$a.a(Bd(), true, 0, this);
  }
  
  protected void WE(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  public void WF(int paramInt)
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_Apfl.RB(true);
    }
  }
  
  public void WG(int paramInt)
  {
    this.bkn = true;
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
    dYY();
    if (!TextUtils.isEmpty(this.mTmpFilePath)) {
      aqhq.deleteFile(this.mTmpFilePath);
    }
    WE(4);
    dZi();
    apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onFetchErr  errCode:" + paramInt);
    this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == apue.a.dWv) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    }
    for (;;)
    {
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if (this.jdField_a_of_type_Apfn$a != null) {
        this.jdField_a_of_type_Apfn$a.a(Bd(), false, paramInt, this);
      }
      return;
      if (paramInt == apue.a.dWm) {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
      } else {
        this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
      }
    }
  }
  
  public UUID a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.bkn) {}
    while (!paramBoolean) {
      return;
    }
    apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i;
    if (paramInt == -5000) {
      i = apue.a.dWe;
    }
    for (;;)
    {
      WG(i);
      return;
      if (paramInt == -5001)
      {
        i = apue.a.dWd;
      }
      else if (paramInt == 9039)
      {
        i = apue.a.dWk;
      }
      else if (paramInt == 9004)
      {
        i = apue.a.dWh;
      }
      else if (paramInt == 9301)
      {
        i = apue.a.dWf;
      }
      else if (paramInt == -5001)
      {
        i = apue.a.dWn;
      }
      else if (this.jdField_a_of_type_Apfl.alZ())
      {
        i = apue.a.dWm;
      }
      else
      {
        i = paramInt;
        if (paramInt == -5003) {
          i = apue.a.dWv;
        }
      }
    }
  }
  
  protected void b(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startFetch app=null");
      WG(apue.a.dWt);
      return;
    }
    aqhq.deleteFile(this.mTmpFilePath);
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = "/ftn_handler/" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + "&pictype=cut&size=" + this.bYf + "*" + this.bYf;
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool1;
    if (this.cQk)
    {
      i = paramInt1;
      if (paramInt1 <= 0) {
        i = 443;
      }
      localObject1 = localObject2;
      bool1 = bool2;
      if (apsv.bU(localQQAppInterface))
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = true;
          localObject1 = paramString;
        }
      }
      if (!bool1) {
        break label1240;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    label792:
    label1186:
    label1240:
    for (paramInt1 = 443;; paramInt1 = i)
    {
      localObject2 = "/ftn_video_pic/rkey=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "&filetype=17&size=" + this.bYf + "*" + this.bYf + "&";
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + ":" + paramInt1);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
      {
        if (!agke.a().l(localQQAppInterface, 3)) {
          break label792;
        }
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        paramString = new agke.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, paramInt1);
        paramString = agke.a().a(localQQAppInterface, paramString, 3);
        if ((paramString != null) && (!paramString.alz()))
        {
          if (agke.alt())
          {
            QLog.d("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          agke.a(paramString.Bb, localArrayList, false, false);
          QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopVideo thumb. use IPv6. iplist:" + localArrayList.toString());
        }
      }
      else
      {
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        long l = apef.hr();
        apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + (String)localObject1 + " mTmpFilePath:" + this.mTmpFilePath + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_Apfl != null)
        {
          this.jdField_a_of_type_Apfl.bme();
          this.jdField_a_of_type_Apfl = null;
        }
        this.jdField_a_of_type_Apfl = apfl.a(localQQAppInterface, l, this.mTmpFilePath, 0L, localArrayList, (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.cQk, bool1, paramString);
        if (this.jdField_a_of_type_Apfl != null) {
          break label1186;
        }
        WG(apue.a.dWt);
        return;
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopVideo thumb. use IPv4:");
        localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject3;
        bool1 = bool3;
        if (apsv.bU(localQQAppInterface))
        {
          paramString = localObject3;
          bool1 = bool3;
          if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
          {
            bool1 = true;
            paramString = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
          }
        }
        localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          if (agke.a().l(localQQAppInterface, 3))
          {
            QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
            localObject2 = new agke.a(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
            localObject2 = agke.a().a(localQQAppInterface, (agke.a)localObject2, 3);
            if ((localObject2 != null) && (!((agke.c)localObject2).alz()))
            {
              if (agke.alt())
              {
                QLog.d("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
                localArrayList.clear();
              }
              agke.a(((agke.c)localObject2).Bb, localArrayList, true, false);
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopImage thumb. use IPv6. iplist:" + localArrayList.toString());
            }
            for (;;)
            {
              break;
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.coy + "] [IPv6-File] download troopImage thumb. use IPv4");
              localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
            }
          }
          localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        }
      }
      this.jdField_a_of_type_Apfl.a(this);
      this.jdField_a_of_type_Apfl.dYS();
      this.jdField_a_of_type_Apfl.RA(false);
      if (this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_Apfl.RB(true);
      }
      this.jdField_a_of_type_Apfl.download();
      WE(2);
      return;
    }
  }
  
  public void dYT() {}
  
  public void dYW()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqFetch app=null");
      WG(apue.a.dWt);
      return;
    }
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] reqFetch");
    this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = smq.a(localQQAppInterface, this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.bYf, false, false, this.jdField_a_of_type_Smq$m);
    WE(1);
  }
  
  public void dZh()
  {
    if ((!TextUtils.isEmpty(this.mFileDir)) && (!TextUtils.isEmpty(this.coz))) {
      return;
    }
    this.mFileDir = apfq.Bg();
    this.coz = this.mFileDir;
  }
  
  protected void dZi()
  {
    apfq.b(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.bYf);
    if (this.bYf == 383) {
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void dZj()
  {
    apfq.b(this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.bYf);
    boolean bool = apfq.a(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.bYf, this.mFilePath);
    TroopFileTransferManager.Item localItem;
    if (this.bYf == 383)
    {
      localItem = this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      if (bool) {
        break label58;
      }
    }
    label58:
    for (bool = true;; bool = false)
    {
      localItem.ThumbnailDownloading_Middle_Fail = bool;
      return;
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onDownloadSuccess(String paramString)
  {
    if (this.bkn) {
      return;
    }
    RC(false);
  }
  
  public boolean start()
  {
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] start fetch thumb. filename:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.bkn = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void stop()
  {
    if (this.bkn)
    {
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] stop. but had stoped. mStatus:" + this.mStatus);
      return;
    }
    this.bkn = true;
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] stop fetch. mStatus:" + this.mStatus);
    if (this.mStatus == 2)
    {
      if (this.jdField_a_of_type_Apfl == null) {
        break label199;
      }
      this.jdField_a_of_type_Apfl.bme();
      this.jdField_a_of_type_Apfl = null;
    }
    for (;;)
    {
      dYY();
      if (this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b != null)
      {
        smq.a(apef.getApp(), this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b);
        this.jdField_c_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = null;
      }
      dZi();
      if (!TextUtils.isEmpty(this.mTmpFilePath)) {
        aqhq.deleteFile(this.mTmpFilePath);
      }
      this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      apdw.b(this.mTroopUin, this.jdField_c_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      WE(0);
      return;
      label199:
      apef.b.w("TroopFileDownloadWorker", apef.b.USR, "[" + this.coy + "] stop downloader=null");
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, boolean paramBoolean, int paramInt, apfn paramapfn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfn
 * JD-Core Version:    0.7.0.1
 */