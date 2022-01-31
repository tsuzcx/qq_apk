import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class uea
  implements Runnable
{
  public uea(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void run()
  {
    File localFile1 = new File(EmojiStickerManager.a(), "qvip_profile_diy_card_guide.png");
    File localFile2 = new File(EmojiStickerManager.a(), "qvip_profile_diy_card_guide_demo.png");
    if ((localFile1.exists()) && (localFile2.exists()))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 320;
      localOptions.inTargetDensity = this.a.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapManager.a(localFile1.getAbsolutePath(), localOptions);
      this.a.b = BitmapManager.a(localFile2.getAbsolutePath(), localOptions);
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(9);
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.a(1004L, "emojiStickerGuideZip_v2", "VipProfileCardDiy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uea
 * JD-Core Version:    0.7.0.1
 */