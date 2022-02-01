import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

public class paj
  extends ovv
{
  public paj(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public QCirclePolymorphicAniView a()
  {
    if (QCirclePersonalDetailFragment.a(this.a) != null) {
      return (QCirclePolymorphicAniView)QCirclePersonalDetailFragment.b(this.a).findViewById(2131374561);
    }
    return null;
  }
  
  public oyu a()
  {
    if ((QCirclePersonalDetailFragment.a(this.a) == null) && (QCirclePersonalDetailFragment.c(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)QCirclePersonalDetailFragment.d(this.a).findViewById(2131374503);
      QCirclePersonalDetailFragment.a(this.a, new oyu(this.a.getActivity()));
      QCirclePersonalDetailFragment.a(this.a).a(this.a.getActivity(), localViewStub);
    }
    return QCirclePersonalDetailFragment.a(this.a);
  }
  
  public void a(oww.c paramc)
  {
    if (QCirclePersonalDetailFragment.a(this.a) != null) {
      QCirclePersonalDetailFragment.a(this.a).l("poly_zan_list_show", paramc);
    }
  }
  
  public void ae(Object paramObject)
  {
    if (this.a.a != null) {
      this.a.a.l("share_action_show_share_sheet", paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     paj
 * JD-Core Version:    0.7.0.1
 */