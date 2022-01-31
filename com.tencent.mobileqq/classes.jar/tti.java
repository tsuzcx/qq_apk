import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;

class tti
  extends trr
{
  tti(ttc paramttc) {}
  
  public QCircleInitBean a()
  {
    return ttc.a(this.a);
  }
  
  public QCirclePolymorphicAniView a()
  {
    if (ttc.a(this.a) != null) {
      return (QCirclePolymorphicAniView)ttc.a(this.a).findViewById(2131373173);
    }
    return null;
  }
  
  public tuk a()
  {
    if ((ttc.a(this.a) == null) && (ttc.a(this.a) != null))
    {
      ViewStub localViewStub = (ViewStub)ttc.a(this.a).findViewById(2131373125);
      ttc.a(this.a, new tuk(this.a.a()));
      ttc.a(this.a).a(this.a.a(), localViewStub);
    }
    return ttc.a(this.a);
  }
  
  public void a(Object paramObject)
  {
    this.a.b("share_action_show_share_sheet", paramObject);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tti
 * JD-Core Version:    0.7.0.1
 */