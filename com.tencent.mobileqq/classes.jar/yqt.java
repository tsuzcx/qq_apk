import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;

public class yqt
  implements Runnable
{
  public yqt(ApolloStoreActivity paramApolloStoreActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (ApolloStoreActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqt
 * JD-Core Version:    0.7.0.1
 */