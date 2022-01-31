import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ukx
  implements PreloadManager.OnGetPathListener
{
  ukx(ukv paramukv) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      paramPathResult = paramPathResult + File.separator;
      this.a.a.specailBackgroundAnimInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult + "anim_bg");
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_SPECAIL_ANIM specailBackgroundAnimInfo=" + this.a.a.specailBackgroundAnimInfo);
      }
      CustomizeStrategyFactory.a().a(this.a.a);
      return;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukx
 * JD-Core Version:    0.7.0.1
 */