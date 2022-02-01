import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class ahxw
  implements ahxo.a
{
  public void Pw(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(5L, "font.diycard.android." + paramInt, "HiBoomDownloader");
    }
  }
  
  public String getFontPath()
  {
    return aldy.bVX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxw
 * JD-Core Version:    0.7.0.1
 */