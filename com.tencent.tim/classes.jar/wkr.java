import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;

public class wkr
  implements PreloadManager.d
{
  public wkr(CustomizeStrategyFactory.PanelStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramPathResult, aqhu.a(paramPathResult, (int)(CustomizeStrategyFactory.density * 50.0F + 0.5D)));
      if (localBitmap != null) {
        this.a.val$info.icon = localBitmap;
      }
      this.a.val$info.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy info.icon=" + this.a.val$info.icon + ",resPath=" + this.a.val$info.resPath);
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
 * Qualified Name:     wkr
 * JD-Core Version:    0.7.0.1
 */