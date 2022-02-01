import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.util.ArrayList;

public class zjs
  extends FlingGestureHandler
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StUser jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList;
  
  public zjs(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity = new TopGestureLayout(paramActivity);
    paramActivity.setInterceptScrollRLFlag(true);
    setTopLayout(paramActivity);
    if (this.mTopLayout != null)
    {
      paramActivity = new Rect();
      this.mTopLayout.setInterceptTouchEventListener(new zjt(this, paramActivity));
    }
    onStart();
  }
  
  public void a(CertifiedAccountMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = paramStUser;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramView));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void flingRToL()
  {
    if (this.mTopLayout != null)
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser == null) {
        break label29;
      }
      zbh.a(this.mTopLayout.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    }
    label29:
    while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    zbh.a(this.mTopLayout.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjs
 * JD-Core Version:    0.7.0.1
 */