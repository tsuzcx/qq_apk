import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class fn
  implements Runnable
{
  public fn(FontManager paramFontManager) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.a();
      if (this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
      {
        float f = FontManager.a(this.a).getApplication().getResources().getDisplayMetrics().density;
        this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(f);
        this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(this.a);
        Thread.sleep(1000L);
        this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(FontManager.jdField_a_of_type_JavaLangString);
        Thread.sleep(1000L);
        Object localObject = ((FriendsManagerImp)FontManager.a(this.a).getManager(8)).a(FontManager.a(this.a).getAccount());
        if ((localObject != null) && (0L != ((ExtensionInfo)localObject).uVipFont))
        {
          localObject = this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(((ExtensionInfo)localObject).uVipFont);
          if (localObject != null) {
            this.a.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a((int)((fg)localObject).jdField_a_of_type_Long, ((fg)localObject).jdField_a_of_type_JavaLangString, true);
          }
        }
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
      }
      throw new Exception("create font engine Instance fail");
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FontManager", 2, "init font engine fail " + localThrowable.getMessage());
      }
      ReportController.b(FontManager.a(this.a), "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fn
 * JD-Core Version:    0.7.0.1
 */