import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.VoiceResStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wkx
  implements PreloadManager.d
{
  public wkx(CustomizeStrategyFactory.VoiceResStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      Object localObject = paramPathResult + File.separator;
      localObject = (String)localObject + "aio.png";
      localObject = SafeBitmapFactory.decodeFile((String)localObject, aqhu.a((String)localObject, (int)(CustomizeStrategyFactory.density * 47.0F + 0.5D)));
      if (localObject != null) {
        this.a.val$info.icon = ((Bitmap)localObject);
      }
      this.a.val$info.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VOICE_LOCK_RES info.icon=" + this.a.val$info.icon + ",resPath=" + this.a.val$info.resPath);
      }
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().b(this.a.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkx
 * JD-Core Version:    0.7.0.1
 */