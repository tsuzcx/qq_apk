import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

public class yxm
  implements OnItemSelectListener
{
  public yxm(ApolloGameInfoFragment paramApolloGameInfoFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 1) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */