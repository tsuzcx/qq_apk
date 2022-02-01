import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.open.agent.AuthorityAccountView;

public class arop
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public arop(AuthorityAccountView paramAuthorityAccountView, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    View localView = AuthorityAccountView.a(this.this$0).findViewById(2131361882);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (this.pL.getHeight() / 2 + this.pL.getTop() - localView.getHeight() / 2);
    localView.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.pL.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
    }
    this.pL.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arop
 * JD-Core Version:    0.7.0.1
 */