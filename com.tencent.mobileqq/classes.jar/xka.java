import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.BannerManager.IBannerInteract;
import com.tencent.mobileqq.activity.recent.BannerManager.MessageToShowBanner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class xka
  implements BannerManager.IBannerInteract
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @Nullable
  private BannerManager.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  @Nullable
  private final String b;
  
  public xka(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "onEnter: " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner + " / " + this.b + " / " + this.jdField_a_of_type_Int + " / " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    QQBrowserActivity localQQBrowserActivity2 = QQBrowserActivity.class;
    Object localObject = localQQBrowserActivity2;
    if (!TextUtils.isEmpty(this.b)) {}
    try
    {
      localObject = Class.forName(this.b);
      if (BaseActivity.sTopActivity != null)
      {
        localObject = new Intent(localQQAppInterface.getApp(), (Class)localObject);
        ((Intent)localObject).setFlags(this.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("banner_fromBanner", true);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("banner_webview_extra", this.jdField_a_of_type_AndroidOsBundle);
        BaseActivity.sTopActivity.startActivity((Intent)localObject);
      }
      for (;;)
      {
        BannerManager.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "sTopActivity is null");
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QQBrowserActivity localQQBrowserActivity1 = localQQBrowserActivity2;
      }
    }
  }
  
  public void a(@Nullable BannerManager.MessageToShowBanner paramMessageToShowBanner)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner = paramMessageToShowBanner;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    BannerManager.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "banner for " + this.jdField_a_of_type_JavaLangString + " is overrided");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xka
 * JD-Core Version:    0.7.0.1
 */