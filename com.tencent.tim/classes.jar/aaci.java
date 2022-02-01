import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.a;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class aaci
  extends aquy
{
  public aaci(PreloadManager paramPreloadManager, String paramString, PreloadManager.a parama) {}
  
  public void onDoneFile(aquz paramaquz)
  {
    int i = -5;
    super.onDoneFile(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadModule|done" + paramaquz.key);
    }
    Object localObject = paramaquz.getParams();
    PreloadModule localPreloadModule = (PreloadModule)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResource)((Bundle)localObject).getSerializable("resource");
    if (aagd.j(localPreloadModule.mid, this.val$id))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModule|done code" + paramaquz.errCode);
      }
      if (paramaquz.errCode != 0) {
        break label168;
      }
      i = 0;
      if (localObject != null) {
        break label183;
      }
    }
    label168:
    label183:
    for (localObject = null;; localObject = ((PreloadResource)localObject).getResInfo(localPreloadModule))
    {
      this.a.onDownloadResFinished(localPreloadModule.mid, i, ((File)paramaquz.ov.get(paramaquz.key)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (paramaquz.errCode == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaci
 * JD-Core Version:    0.7.0.1
 */