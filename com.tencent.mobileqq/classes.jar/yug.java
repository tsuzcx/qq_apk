import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

public class yug
  implements OnItemSelectListener
{
  public yug(ApolloGameInfoFragment paramApolloGameInfoFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 1) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yug
 * JD-Core Version:    0.7.0.1
 */