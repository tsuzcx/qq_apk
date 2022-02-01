import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.util.ArrayList;

public class sgy
  extends FlingGestureHandler
{
  private CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StUser e;
  private ArrayList<View> nX;
  
  public sgy(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity = new TopGestureLayout(paramActivity);
    paramActivity.setInterceptScrollRLFlag(true);
    setTopLayout(paramActivity);
    if (this.mTopLayout != null)
    {
      paramActivity = new Rect();
      this.mTopLayout.setInterceptTouchEventListener(new sgz(this, paramActivity));
    }
    onStart();
  }
  
  public boolean MI()
  {
    return true;
  }
  
  public void a(CertifiedAccountMeta.StUser paramStUser)
  {
    this.e = paramStUser;
  }
  
  public void ed(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.nX == null) {
        this.nX = new ArrayList();
      }
    } while (this.nX.contains(paramView));
    this.nX.add(paramView);
  }
  
  public void flingRToL()
  {
    if (this.mTopLayout != null)
    {
      if (this.e == null) {
        break label29;
      }
      rzd.a(this.mTopLayout.getContext(), this.e);
    }
    label29:
    while (this.a == null) {
      return;
    }
    rzd.a(this.mTopLayout.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgy
 * JD-Core Version:    0.7.0.1
 */