import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

public class ypv
  implements Runnable
{
  public ypv(ApolloWebGameActivity paramApolloWebGameActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (ApolloWebGameActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloWebGameActivity).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypv
 * JD-Core Version:    0.7.0.1
 */