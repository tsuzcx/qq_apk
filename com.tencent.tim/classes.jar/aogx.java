import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeIPCModule.2.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class aogx
  implements aqqm
{
  aogx(String paramString, ajdq paramajdq) {}
  
  public void I(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("ThemeIPCModule", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    aogy localaogy;
    if (paramInt == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localaogy = new aogy().a(this.val$themeId);
      localaogy.a(localBaseApplication, paramString1, paramString2);
    }
    for (paramString1 = localaogy;; paramString1 = null)
    {
      ThreadManagerV2.getUIHandlerV2().post(new ThemeIPCModule.2.1(this, paramString1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogx
 * JD-Core Version:    0.7.0.1
 */