import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.qphone.base.util.QLog;

public class aroo
  implements View.OnLayoutChangeListener
{
  public aroo(AuthorityAccountView paramAuthorityAccountView, RelativeLayout paramRelativeLayout) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getHeight();
    paramInt2 = this.val$layout.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, paramInt1 + " /  / " + paramInt2);
    }
    paramView = (RelativeLayout.LayoutParams)this.val$layout.getLayoutParams();
    if (paramView == null) {
      paramView = new RelativeLayout.LayoutParams(-1, -2);
    }
    for (;;)
    {
      paramView.addRule(12);
      this.val$layout.setLayoutParams(paramView);
      return;
      paramView.height = -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aroo
 * JD-Core Version:    0.7.0.1
 */