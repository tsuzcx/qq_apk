import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileSocialView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class gjo
  implements Runnable
{
  public gjo(ProfileSocialView paramProfileSocialView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString) {}
  
  public void run()
  {
    int i = (int)(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileSocialView.getResources().getDisplayMetrics().density * 85.0F + 0.5F);
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!ProfileCardUtil.a())) {}
    }
    for (;;)
    {
      try
      {
        Object localObject1 = ProfileCardUtil.c();
        Object localObject4 = new File((String)localObject1);
        localObject3 = new BitmapFactory.Options();
        localObject4 = new FileInputStream((File)localObject4);
        ((BitmapFactory.Options)localObject3).inSampleSize = ((int)ImageUtil.a((InputStream)localObject4, i, i));
        ((InputStream)localObject4).close();
        localObject3 = BitmapManager.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileSocialView.a.b.a(this.jdField_a_of_type_JavaLangString, (byte)1, true);
        }
        localObject3 = localObject1;
        if (localObject1 != null) {
          localObject3 = ImageUtil.a((Bitmap)localObject1, i / 2, i, i);
        }
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileSocialView.a.runOnUiThread(new gjp(this, (Bitmap)localObject3));
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
        }
      }
      Object localObject3 = null;
      continue;
      if (1 == this.jdField_a_of_type_Int)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileSocialView.a.b.a(this.jdField_a_of_type_JavaLangString, (byte)1);
        if ((localObject2 instanceof BitmapDrawable)) {
          localObject2 = ((BitmapDrawable)localObject2).getBitmap();
        }
      }
      else
      {
        if (2 == this.jdField_a_of_type_Int)
        {
          localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileSocialView.getResources(), 2130838017);
          continue;
        }
        localObject2 = ImageUtil.a();
        continue;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gjo
 * JD-Core Version:    0.7.0.1
 */