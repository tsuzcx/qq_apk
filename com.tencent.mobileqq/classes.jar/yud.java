import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.store.ApolloImageShareLayout;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;

public class yud
  implements Runnable
{
  public yud(ApolloViewController paramApolloViewController, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) == null) || (ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) == null)) {
      return;
    }
    if (ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) == null)
    {
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController, new ApolloImageShareLayout(this.jdField_a_of_type_AndroidAppActivity));
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).a(ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).getWidth(), ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).getHeight(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).roleId, ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).dressIds, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a);
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).addView(ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController), new FrameLayout.LayoutParams(-1, -1));
    }
    ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).a(ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).roleId, ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).dressIds, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yud
 * JD-Core Version:    0.7.0.1
 */