import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

class ttx
  extends trw
{
  ttx(ttr paramttr) {}
  
  public QCircleInitBean a()
  {
    return ttr.a(this.a);
  }
  
  public QCirclePolymorphicAniView a()
  {
    if (ttr.a(this.a) != null) {
      return (QCirclePolymorphicAniView)ttr.a(this.a).findViewById(2131373208);
    }
    return null;
  }
  
  public tuz a()
  {
    if ((ttr.a(this.a) == null) && (ttr.a(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)ttr.a(this.a).findViewById(2131373151);
      ttr.a(this.a, new tuz(this.a.a()));
      ttr.a(this.a).a(this.a.a(), localViewStub);
    }
    return ttr.a(this.a);
  }
  
  public void a(Object paramObject)
  {
    this.a.b("share_action_show_share_sheet", paramObject);
  }
  
  public void a(ttf paramttf)
  {
    this.a.a().a("poly_zan_list_show", paramttf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttx
 * JD-Core Version:    0.7.0.1
 */