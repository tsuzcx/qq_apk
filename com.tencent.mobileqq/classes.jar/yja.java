import android.graphics.Typeface;
import com.etrump.mixlayout.FontInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.util.LRULinkedHashMap;
import mqq.app.AppRuntime;

public class yja
  implements Runnable
{
  public yja(DiyPendantFetcher paramDiyPendantFetcher, int paramInt, String paramString) {}
  
  public void run()
  {
    if (AvatarPendantUtil.a(String.valueOf(this.jdField_a_of_type_Int))) {
      if (this.jdField_a_of_type_Int != 1)
      {
        ((FontInfo)this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.b.get(Integer.valueOf(this.jdField_a_of_type_Int))).a = Typeface.createFromFile(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.d();
      }
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    ((VasQuickUpdateManager)((QQAppInterface)localAppRuntime).getManager(183)).a(4L, "faceAddon.stickerFont.android." + this.jdField_a_of_type_Int, "DiyPendantFetcher");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */