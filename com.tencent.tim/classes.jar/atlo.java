import android.content.Context;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class atlo
{
  private static String cHo;
  private static int eqq = -1;
  private aths.a a = new atls(this);
  private Boolean aU;
  private CloudFileCallbackCenter b = new atlp(this);
  private int boq;
  private CloudFileUploadingStatusBar c;
  private atgg d;
  private boolean dig;
  private byte[] hK;
  private Runnable ir;
  private Context mContext;
  private int mFailCount;
  private int mTotalCount;
  private HashMap<Long, FileManagerEntity> qe = new HashMap();
  private FileManagerEntity r;
  
  public atlo(Context paramContext, CloudFileUploadingStatusBar paramCloudFileUploadingStatusBar)
  {
    this.mContext = paramContext;
    this.aU = Boolean.valueOf(true);
    this.c = paramCloudFileUploadingStatusBar;
  }
  
  public atlo(Context paramContext, byte[] paramArrayOfByte, CloudFileUploadingStatusBar paramCloudFileUploadingStatusBar)
  {
    this.mContext = paramContext;
    this.aU = Boolean.valueOf(false);
    this.hK = paramArrayOfByte;
    this.c = paramCloudFileUploadingStatusBar;
  }
  
  private void dfh()
  {
    atgi.a().a(this.b);
    aths.a().a(this.a);
  }
  
  private void elV()
  {
    atgi.c(this.b);
    aths.a().b(this.a);
  }
  
  private void etI()
  {
    if (this.aU.booleanValue())
    {
      QLog.d("CloudFileUploadingStatusController", 1, "checkUploadList is Root directory, so fetch again");
      etJ();
      return;
    }
    atgi.a().a(this.hK, new atlr(this));
  }
  
  private void etJ()
  {
    if (this.d != null)
    {
      QLog.d("CloudFileUploadingStatusController", 1, "fetchList mCloudFileSDKCallback exist, so need not to fetch again");
      return;
    }
    QLog.d("CloudFileUploadingStatusController", 1, "fetchList again");
    this.c.setHasUploading(true);
    this.d = new atlq(this);
    atgi.a().e(this.d);
  }
  
  private void etK()
  {
    etY();
    this.c.setTaskCount(this.boq, this.mFailCount, this.mTotalCount);
  }
  
  private void etY()
  {
    Iterator localIterator = this.qe.values().iterator();
    int i = 3;
    Object localObject1 = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (FileManagerEntity)localIterator.next();
      if (((FileManagerEntity)localObject2).uploadFile.uploadStatus == 3)
      {
        if (localObject1 != null) {
          break label166;
        }
        localObject1 = localObject2;
        i = 3;
      }
      label166:
      for (;;)
      {
        break;
        if (((FileManagerEntity)localObject2).uploadFile.uploadStatus == 4)
        {
          if ((localObject1 == null) || (i == 3))
          {
            localObject1 = localObject2;
            i = 4;
          }
        }
        else if ((((FileManagerEntity)localObject2).uploadFile.uploadStatus == 1) || (((FileManagerEntity)localObject2).uploadFile.uploadStatus == 0))
        {
          if ((localObject1 == null) || (i == 3) || (i == 4))
          {
            localObject1 = localObject2;
            i = 1;
          }
        }
        else {
          QLog.e("CloudFileUploadingStatusController", 1, "changeSelectedThumb task status[" + ((FileManagerEntity)localObject2).uploadFile.uploadStatus + "] not processed");
        }
      }
    }
    if (localObject1 == null)
    {
      this.r = null;
      if ((this.qe.size() == 0) && (this.aU.booleanValue()) && (this.c != null) && (this.c.getVisibility() == 0) && (aueh.fileExistsAndNotEmpty(cHo))) {
        this.c.setThumbPath(cHo, eqq);
      }
    }
    while (this.r == localObject1) {
      return;
    }
    QLog.d("CloudFileUploadingStatusController", 1, "changeSelectedThumb selectedShowEntity path [" + localObject1.uploadFile.uploadPath + "]");
    i = audx.fM(localObject1.uploadFile.uploadPath);
    if (i == 0)
    {
      localObject2 = aqhs.bytes2HexStr(audx.t(localObject1.uploadFile.uploadPath));
      if (localObject2 == null)
      {
        QLog.d("CloudFileUploadingStatusController", 1, "thumb file name is null, filepath " + localObject1.uploadFile.uploadPath);
        this.c.setThumbPath(localObject1.uploadFile.uploadPath, i);
        cHo = localObject1.uploadFile.uploadPath;
      }
    }
    for (;;)
    {
      eqq = i;
      return;
      localObject2 = ((String)localObject2).toUpperCase();
      localObject2 = audn.a().wb() + auef.D(5, (String)localObject2);
      if (aueh.fileExistsAndNotEmpty((String)localObject2))
      {
        QLog.d("CloudFileUploadingStatusController", 1, "thumb is exist " + (String)localObject2);
        this.c.setThumbPath((String)localObject2, i);
        cHo = (String)localObject2;
      }
      else
      {
        QLog.d("CloudFileUploadingStatusController", 1, "thumb is not exist " + (String)localObject2);
        this.c.setThumbPath(localObject1.uploadFile.uploadPath, i);
        cHo = localObject1.uploadFile.uploadPath;
        continue;
        this.c.setThumbPath(localObject1.uploadFile.uploadPath, i);
        cHo = localObject1.uploadFile.uploadPath;
      }
    }
  }
  
  public void onPause()
  {
    if (!this.dig) {
      return;
    }
    QLog.d("CloudFileUploadingStatusController", 1, "onPause");
    this.dig = false;
    elV();
    this.c.setHasUploading(false);
  }
  
  public void onResume()
  {
    if (this.dig) {
      return;
    }
    this.dig = true;
    QLog.d("CloudFileUploadingStatusController", 1, "onResume");
    this.c.setTaskCount(0, 0, 0);
    dfh();
    etI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlo
 * JD-Core Version:    0.7.0.1
 */