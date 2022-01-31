import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ygs
  implements View.OnLayoutChangeListener
{
  public ygs(AvatarPendantAdapter paramAvatarPendantAdapter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    View localView = paramView.findViewById(2131372277);
    TextView localTextView = (TextView)paramView.findViewById(2131372278);
    paramInt1 = ((ImageView)paramView.findViewById(2131372279)).getRight() - localView.getWidth();
    if (paramInt1 > 0) {
      ThreadManager.getUIHandler().post(new ygt(this, localTextView, paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygs
 * JD-Core Version:    0.7.0.1
 */