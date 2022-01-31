import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ytd
  implements Runnable
{
  public ytd(ApolloGameShare paramApolloGameShare, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloConstant.n).append(ApolloGameShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130838152);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    Bitmap localBitmap;
    while (localBitmap != null)
    {
      localBitmap = TroopShareUtility.a(localThrowable);
      ApolloGameShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new yte(this));
      WXShareHelper.a().a(ApolloGameShare.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare), ApolloGameShare.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare), localBitmap, ApolloGameShare.c(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare), ApolloGameShare.d(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare), this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytd
 * JD-Core Version:    0.7.0.1
 */