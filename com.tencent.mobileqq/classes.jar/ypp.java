import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager;
import com.tencent.mobileqq.apollo.game.ApolloGameView;

public class ypp
  implements View.OnClickListener
{
  public ypp(ApolloGameView paramApolloGameView, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ApolloFragmentManager.a().a(null);
    if (ApolloFragmentManager.a().a() <= 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypp
 * JD-Core Version:    0.7.0.1
 */