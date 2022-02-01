import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class agvr
  extends agvk
{
  private long aaf;
  private String bJq;
  private int cYN;
  private apcy d;
  private QQAppInterface mApp;
  private Context mContext;
  private long mTroopUin;
  
  public agvr(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, apcy paramapcy, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramLong;
    this.d = paramapcy;
    this.cYN = paramInt;
    this.mContext = paramContext;
  }
  
  private void djQ()
  {
    if (this.d == null) {}
    while ((TextUtils.isEmpty(this.d.FileName)) || (!this.d.FileName.endsWith(".mp4"))) {
      return;
    }
    String str2 = "3";
    String str1 = str2;
    if (this.mContext != null)
    {
      str1 = str2;
      if ((this.mContext instanceof SplashActivity)) {
        str1 = "1";
      }
    }
    ShortVideoUtils.d(this.mApp.getCurrentAccountUin(), String.valueOf(this.mTroopUin), String.valueOf(0), 1, "3", str1);
  }
  
  public void Jm(String paramString)
  {
    this.bJq = paramString;
  }
  
  public boolean SG()
  {
    return super.SG();
  }
  
  boolean amw()
  {
    if ((this.d.Status == 10) || (this.d.Status == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.d.Id + " status:" + this.d.Status + " resume");
      }
      TroopFileTransferManager.a(this.mTroopUin).c(this.d.Id);
      return true;
    }
    return false;
  }
  
  boolean amx()
  {
    if (this.d == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return false;
              i = ahav.getFileType(getFileName());
              if (i == 2) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileVideo", 1, "id:" + this.d.Id + " type is:" + i + " use old filebrowser:");
            return false;
            if (this.d.Status != 12) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileVideo", 1, "id:" + this.d.Id + " is deleted, return false,(check why is here!)");
          return false;
          if ((this.d.Status != 4) && (this.d.Status != 5)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileVideo", 1, "id:" + this.d.Id + " is forwarding, return false,(check why is here!)");
        return false;
        if (!apbr.a.lY(this.d.Status)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideo", 1, "id:" + this.d.Id + " status:" + this.d.Status + " use old browser!");
      return false;
      if ((ahbj.fileExistsAndNotEmpty(this.d.LocalFile)) || (ahbr.aM(this.mApp))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
    return false;
    return true;
  }
  
  protected int bF()
  {
    int j = -1;
    int i = j;
    if (this.d != null) {
      if ((this.d.Status != 1) && (this.d.Status != 8))
      {
        i = j;
        if (this.d.Status != 0) {}
      }
      else
      {
        i = 2;
      }
    }
    return i;
  }
  
  public void cC(Bundle paramBundle)
  {
    if (this.u != null) {
      paramBundle.putLong("troopfile_shmsgseq", this.u.shmsgseq);
    }
  }
  
  protected String getFileName()
  {
    if ((this.d != null) && (!TextUtils.isEmpty(this.d.FileName))) {
      return this.d.FileName;
    }
    return "";
  }
  
  protected String getFilePath()
  {
    if (this.d != null) {
      return this.d.LocalFile;
    }
    return "";
  }
  
  protected long getFileSize()
  {
    if (this.d != null) {
      return this.d.ProgressTotal;
    }
    return 0L;
  }
  
  public void jO(long paramLong)
  {
    this.aaf = paramLong;
  }
  
  public Intent x()
  {
    if (!ahbj.isFileExists(this.d.LocalFile)) {
      TroopFileTransferManager.a(this.mApp, this.mTroopUin).aBu();
    }
    switch (this.d.Status)
    {
    default: 
      localObject1 = "";
      if (!TextUtils.isEmpty(this.d.FileName)) {
        localObject1 = this.d.FileName;
      }
      Object localObject2 = new apcy();
      ((apcy)localObject2).FileName = ((String)localObject1);
      ((apcy)localObject2).LocalFile = this.d.LocalFile;
      ((apcy)localObject2).ProgressTotal = this.d.ProgressTotal;
      ((apcy)localObject2).ProgressValue = this.d.ProgressValue;
      ((apcy)localObject2).Id = this.d.Id;
      ((apcy)localObject2).uniseq = this.d.uniseq;
      ((apcy)localObject2).TroopUin = this.mTroopUin;
      ((apcy)localObject2).BusId = this.d.BusId;
      ((apcy)localObject2).FilePath = this.d.FilePath;
      ((apcy)localObject2).sha1 = this.d.sha1;
      ((apcy)localObject2).ThumbnailFile_Small = this.d.ThumbnailFile_Small;
      ((apcy)localObject2).ThumbnailFile_Large = this.d.ThumbnailFile_Large;
      ((apcy)localObject2).coc = this.d.coc;
      ((apcy)localObject2).Status = this.d.Status;
      ((apcy)localObject2).yybApkPackageName = this.d.yybApkPackageName;
      ((apcy)localObject2).yybApkName = this.d.yybApkName;
      ((apcy)localObject2).yybApkIconUrl = this.d.yybApkIconUrl;
      apsf.a(this.mApp, this.mTroopUin).d(this.d.Id);
      Object localObject3 = ahav.a((apcy)localObject2);
      if (!TextUtils.isEmpty(this.bJq)) {
        ((FileManagerEntity)localObject3).selfUin = this.bJq;
      }
      if (this.aaf != 0L) {
        ((FileManagerEntity)localObject3).lastTime = this.aaf;
      }
      ((FileManagerEntity)localObject3).bSend = this.mApp.getAccount().equals(((FileManagerEntity)localObject3).selfUin);
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).p(((FileManagerEntity)localObject3).nSessionId);
      ((ForwardFileInfo)localObject1).Oj(4);
      ((ForwardFileInfo)localObject1).setType(10006);
      ((ForwardFileInfo)localObject1).setLocalPath(((apcy)localObject2).LocalFile);
      ((ForwardFileInfo)localObject1).setFileName(((apcy)localObject2).FileName);
      ((ForwardFileInfo)localObject1).setFileSize(((apcy)localObject2).ProgressTotal);
      ((ForwardFileInfo)localObject1).jA(this.mTroopUin);
      ((ForwardFileInfo)localObject1).jB(((apcy)localObject2).uniseq);
      localObject2 = new Intent();
      if (this.cYN == 1)
      {
        localObject3 = apsf.a(this.mApp, this.mTroopUin).a(this.d.mParentId);
        if (localObject3 != null) {
          ((Intent)localObject2).putExtra("leftViewText", ((apbr)localObject3).str_file_name);
        }
      }
      ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("removemementity", true);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("not_forward", true);
      ((Intent)localObject2).putExtra("file_browser_extra_params_uin", String.valueOf(this.mTroopUin));
      if (this.aaf != 0L) {
        ((Intent)localObject2).putExtra("last_time", this.aaf);
      }
      ((Intent)localObject2).putExtra("from_type_troop", this.cYN);
      djQ();
      return localObject2;
    }
    Object localObject1 = "";
    int i = this.d.LocalFile.lastIndexOf("/") + 1;
    if (i < this.d.LocalFile.length()) {
      localObject1 = this.d.LocalFile.substring(i, this.d.LocalFile.length() - 1);
    }
    localObject1 = String.format(this.mContext.getString(2131699524), new Object[] { apsv.oR((String)localObject1) });
    apsd.ck(this.mContext, (String)localObject1);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvr
 * JD-Core Version:    0.7.0.1
 */