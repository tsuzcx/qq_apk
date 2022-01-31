import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class ule
  implements PreloadManager.OnGetPathListener
{
  ule(uld paramuld) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      paramPathResult = SafeBitmapFactory.decodeFile(paramPathResult, ImageUtil.a(paramPathResult, (int)(CustomizeStrategyFactory.a * 300.0F + 0.5D)));
      if (paramPathResult != null) {
        this.a.a.background = paramPathResult;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "ThemeCustomizeStrategy info.background=" + this.a.a.background);
      }
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ule
 * JD-Core Version:    0.7.0.1
 */