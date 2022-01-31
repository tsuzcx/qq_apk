import android.app.Activity;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.open.downloadnew.MyAppApi;

public class ymr
  implements Runnable
{
  public ymr(ApolloWebViewFragment paramApolloWebViewFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (MyAppApi.d()) {
      MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymr
 * JD-Core Version:    0.7.0.1
 */