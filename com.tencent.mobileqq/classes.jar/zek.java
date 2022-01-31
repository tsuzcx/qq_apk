import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder;
import com.tencent.mobileqq.app.QQAppInterface;

public class zek
  implements View.OnClickListener
{
  public zek(ApolloGameViewBinder paramApolloGameViewBinder) {}
  
  public void onClick(View paramView)
  {
    if (ApolloGameViewBinder.a(this.a) != null)
    {
      paramView = (ApolloGameManager)ApolloGameViewBinder.a(this.a).getManager(210);
      if (paramView != null) {
        paramView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zek
 * JD-Core Version:    0.7.0.1
 */