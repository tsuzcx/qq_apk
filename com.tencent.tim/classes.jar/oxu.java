import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

class oxu
  extends ovv
{
  oxu(oxo paramoxo) {}
  
  public QCirclePolymorphicAniView a()
  {
    if (oxo.a(this.a) != null) {
      return (QCirclePolymorphicAniView)oxo.a(this.a).findViewById(2131374561);
    }
    return null;
  }
  
  public oyu a()
  {
    if ((oxo.a(this.a) == null) && (oxo.a(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)oxo.a(this.a).findViewById(2131374503);
      oxo.a(this.a, new oyu(this.a.getActivity()));
      oxo.a(this.a).a(this.a.getActivity(), localViewStub);
    }
    return oxo.a(this.a);
  }
  
  public void a(oww.c paramc)
  {
    this.a.a().r("poly_zan_list_show", paramc);
  }
  
  public void ae(Object paramObject)
  {
    this.a.r("share_action_show_share_sheet", paramObject);
  }
  
  public QCircleInitBean b()
  {
    return oxo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxu
 * JD-Core Version:    0.7.0.1
 */