import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.BannerManager.IBannerInteract;
import com.tencent.mobileqq.activity.recent.BannerManager.MessageToShowBanner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.ref.WeakReference;

public class xgu
  implements BannerManager.IBannerInteract
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final Intent jdField_a_of_type_AndroidContentIntent;
  @Nullable
  private BannerManager.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  @NonNull
  private final String b;
  @NonNull
  private final String c;
  @NonNull
  private final String d;
  
  public xgu(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull Intent paramIntent, @NonNull String paramString4, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.d = paramString4;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner == null) {}
    BaseActivity localBaseActivity;
    do
    {
      do
      {
        return;
      } while ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
      localBaseActivity = BaseActivity.sTopActivity;
    } while ((localBaseActivity == null) || (localBaseActivity.isFinishing()));
    try
    {
      Class localClass = Class.forName(this.jdField_b_of_type_JavaLangString).asSubclass(Activity.class);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("banner_fromBanner", true);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(this.jdField_a_of_type_Int);
      localPluginParams.e = this.jdField_a_of_type_JavaLangString;
      localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
      localPluginParams.jdField_b_of_type_JavaLangString = this.c;
      localPluginParams.jdField_a_of_type_JavaLangString = this.d;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
      localPluginParams.jdField_b_of_type_Int = -1;
      IPluginManager.a(localBaseActivity, localPluginParams);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("Q.recent.banner", 1, "return to plugin error, can not find the ckass " + this.jdField_b_of_type_JavaLangString);
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
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgu
 * JD-Core Version:    0.7.0.1
 */