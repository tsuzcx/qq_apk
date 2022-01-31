import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class ysz
  implements Runnable
{
  public ysz(ApolloGameActivity paramApolloGameActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (ApolloGameActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloGameActivity).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */