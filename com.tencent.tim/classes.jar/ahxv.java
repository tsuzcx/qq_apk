import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class ahxv
  implements ahxo.a
{
  public void Pw(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((VasQuickUpdateManager)((AppRuntime)localObject).getManager(184)).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((ahxs)((AppRuntime)localObject).getManager(219)).a(paramInt);
      ((ahxr)localObject).isDownloading = true;
      ((ahxr)localObject).progress = 0;
    }
  }
  
  public String getFontPath()
  {
    return ahxo.bLY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxv
 * JD-Core Version:    0.7.0.1
 */