import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileUtils.1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class athv
  extends atgd
{
  private boolean dhN;
  private boolean dhO;
  
  public athv(CloudFileUtils.1 param1) {}
  
  private void etG()
  {
    this.a.val$app.getApplication().getSharedPreferences("OfflineFileMerge" + this.a.val$app.getCurrentUin(), 0).edit().putLong("LastRequestTime", NetConnInfoCenter.getServerTimeMillis()).commit();
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileUtils", 2, "process over , updata last process time");
    }
    Object localObject1 = new ArrayList(this.a.val$app.a().eV());
    Object localObject2;
    if (this.a.a != null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll((Collection)localObject1);
      this.a.a.nH((List)localObject2);
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        ateh localateh = (ateh)this.a.val$app.getBusinessHandler(180);
        if (((FileManagerEntity)localObject2).peerType == 3000) {
          localateh.c((FileManagerEntity)localObject2, false);
        } else if ((((FileManagerEntity)localObject2).peerType != 1) && (((FileManagerEntity)localObject2).peerType != 6000)) {
          localateh.a((FileManagerEntity)localObject2, false);
        }
      }
    }
    this.a.val$app.removeObserver(this);
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<OfflineFileInfo> paramList, int paramInt2, String paramString)
  {
    if (paramInt2 == 0) {
      if (paramBoolean) {
        this.dhN = true;
      }
    }
    for (;;)
    {
      if ((this.dhN) && (this.dhO)) {
        etG();
      }
      return;
      ((ateh)this.a.val$app.getBusinessHandler(180)).kO(paramList.size() + paramInt1, 30);
      continue;
      this.dhN = true;
    }
  }
  
  public void b(int paramInt1, boolean paramBoolean, List<OfflineFileInfo> paramList, int paramInt2, String paramString)
  {
    if (paramInt2 == 0) {
      if (paramBoolean) {
        this.dhO = true;
      }
    }
    for (;;)
    {
      if ((this.dhN) && (this.dhO)) {
        etG();
      }
      return;
      ((ateh)this.a.val$app.getBusinessHandler(180)).kP(paramList.size() + paramInt1, 30);
      continue;
      this.dhO = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athv
 * JD-Core Version:    0.7.0.1
 */