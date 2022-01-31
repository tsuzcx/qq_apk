import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

public class twl
  extends trr
{
  public twl(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public QCirclePolymorphicAniView a()
  {
    if (QCirclePersonalDetailFragment.a(this.a) != null) {
      return (QCirclePolymorphicAniView)QCirclePersonalDetailFragment.b(this.a).findViewById(2131373173);
    }
    return null;
  }
  
  public tuk a()
  {
    if ((QCirclePersonalDetailFragment.a(this.a) == null) && (QCirclePersonalDetailFragment.c(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)QCirclePersonalDetailFragment.d(this.a).findViewById(2131373125);
      QCirclePersonalDetailFragment.a(this.a, new tuk(this.a.getActivity()));
      QCirclePersonalDetailFragment.a(this.a).a(this.a.getActivity(), localViewStub);
    }
    return QCirclePersonalDetailFragment.a(this.a);
  }
  
  public void a(Object paramObject)
  {
    if (this.a.a != null) {
      this.a.a.a("share_action_show_share_sheet", paramObject);
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twl
 * JD-Core Version:    0.7.0.1
 */