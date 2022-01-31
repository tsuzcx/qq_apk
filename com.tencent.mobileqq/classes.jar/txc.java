import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

public class txc
  extends trw
{
  public txc(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public QCirclePolymorphicAniView a()
  {
    if (QCirclePersonalDetailFragment.a(this.a) != null) {
      return (QCirclePolymorphicAniView)QCirclePersonalDetailFragment.b(this.a).findViewById(2131373208);
    }
    return null;
  }
  
  public tuz a()
  {
    if ((QCirclePersonalDetailFragment.a(this.a) == null) && (QCirclePersonalDetailFragment.c(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)QCirclePersonalDetailFragment.d(this.a).findViewById(2131373151);
      QCirclePersonalDetailFragment.a(this.a, new tuz(this.a.getActivity()));
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
  
  public void a(ttf paramttf)
  {
    if (QCirclePersonalDetailFragment.a(this.a) != null) {
      QCirclePersonalDetailFragment.a(this.a).a("poly_zan_list_show", paramttf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */