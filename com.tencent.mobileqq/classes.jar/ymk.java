import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.game.ApolloGameView.Director;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;

public class ymk
  implements Runnable
{
  public ymk(ApolloGameView paramApolloGameView, Intent paramIntent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      ApolloGameView.Director localDirector = new ApolloGameView.Director();
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra(ApolloGameView.Director.TITLE);
      if (!TextUtils.isEmpty(str)) {
        localDirector.title = str;
      }
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra(ApolloGameView.Director.FOREGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.frontColor = str;
      }
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra(ApolloGameView.Director.BACKGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.bgColor = str;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a = localDirector;
      this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameView.a();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("Director", localDirector);
    }
    ApolloFragmentManager.a().a(this.jdField_a_of_type_AndroidContentIntent, ApolloWebViewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymk
 * JD-Core Version:    0.7.0.1
 */