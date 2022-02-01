import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class aacf
  extends aquy
{
  public aacf(PreloadManager paramPreloadManager, DownloadParam paramDownloadParam, PreloadManager.d paramd, WeakReference paramWeakReference) {}
  
  public void onDoneFile(aquz paramaquz)
  {
    super.onDoneFile(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "RealTime onDoneFile|" + paramaquz.errCode + "|" + paramaquz.key + "|" + ((File)paramaquz.ov.get(paramaquz.key)).getAbsolutePath());
    }
    Object localObject2;
    Object localObject1;
    if ((paramaquz.errCode == 0) && (paramaquz.ov != null) && (!TextUtils.isEmpty(paramaquz.key)))
    {
      localObject2 = (File)paramaquz.ov.get(paramaquz.key);
      if (localObject2 == null)
      {
        localObject1 = "";
        localObject1 = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localObject2 == null) || (!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label242;
        }
        if ((TextUtils.isEmpty(this.b.md5ForChecked)) || (this.b.md5ForChecked.equalsIgnoreCase((String)localObject1))) {
          break label224;
        }
        if (this.a != null) {
          this.a.onResult(2, PreloadManager.PathResult.getFailRes(paramaquz.key));
        }
        PreloadManager.e(paramaquz.key, false, this.b.filePos);
      }
    }
    label224:
    label242:
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((File)localObject2).getAbsolutePath();
          break;
          aadj.d(paramaquz.key, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.b.filePos);
        } while (!PreloadManager.a((PreloadManager)this.eN.get()));
        if (paramaquz.errCode != 0) {
          break label339;
        }
        localObject1 = aadj.a(paramaquz.key, this.b.isForceUnzip, 0, this.b.filePos);
        localObject2 = new PreloadManager.PathResult();
        ((PreloadManager.PathResult)localObject2).url = paramaquz.key;
        ((PreloadManager.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
        ((PreloadManager.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
      } while (this.a == null);
      this.a.onResult(0, (PreloadManager.PathResult)localObject2);
      return;
    } while (this.a == null);
    label339:
    this.a.onResult(1, PreloadManager.PathResult.getFailRes(paramaquz.key, paramaquz.errCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacf
 * JD-Core Version:    0.7.0.1
 */