import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class wyi
  implements Runnable
{
  public wyi(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    localObject2 = null;
    localObject1 = null;
    if (ProfileCardUtil.a()) {}
    for (;;)
    {
      Object localObject3;
      BitmapFactory.Options localOptions;
      boolean bool;
      try
      {
        localObject1 = ProfileCardUtil.b();
        localObject3 = new File((String)localObject1);
        localOptions = new BitmapFactory.Options();
        localObject3 = new BufferedInputStream(new FileInputStream((File)localObject3));
        if (this.a.b.get())
        {
          localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, this.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getWidth(), this.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getHeight()));
          ((BufferedInputStream)localObject3).close();
          localObject1 = BitmapManager.a((String)localObject1, localOptions);
          localObject2 = localObject1;
          if (localObject1 == null) {}
        }
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = this.a.app.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        localObject1 = localObject2;
        if (localObject1 == null) {
          break label239;
        }
        this.a.runOnUiThread(new wyj(this, (Bitmap)localObject1));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("AvatarPendantActivity decode Avatar, bitmap is null:");
          if (localObject1 != null) {
            break label259;
          }
          bool = true;
          QLog.d("Q.dynamicAvatar", 2, bool);
        }
        return;
      }
      catch (Exception localException2)
      {
        label259:
        for (;;)
        {
          label239:
          localObject2 = localObject1;
        }
      }
      localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, 120, 120));
      continue;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AvatarPendantActivity", 2, localException1.toString());
        localObject1 = localObject2;
        continue;
        AvatarPendantActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyi
 * JD-Core Version:    0.7.0.1
 */