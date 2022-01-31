import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class yzo
  implements Runnable
{
  public yzo(ApolloGameActivity paramApolloGameActivity, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (ApolloGameActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity) != null) && (ApolloGameActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity).game != null))
      {
        int i = AIOUtils.a(28.0F, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.getResources());
        Bitmap localBitmap = ImageUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable, i, i);
        if (localBitmap != null)
        {
          int j = (int)(localBitmap.getWidth() / 3.0F);
          Object localObject = RoundedBitmapDrawableFactory.create(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.getResources(), localBitmap);
          ((RoundedBitmapDrawable)localObject).setCornerRadius(j);
          ((RoundedBitmapDrawable)localObject).setAntiAlias(true);
          localObject = new ActivityManager.TaskDescription(ApolloGameActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity).game.name, ImageUtil.a((Drawable)localObject, i, i));
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity.setTaskDescription((ActivityManager.TaskDescription)localObject);
          localBitmap.recycle();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.ApolloGameActivity", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzo
 * JD-Core Version:    0.7.0.1
 */