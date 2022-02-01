import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class osb
  extends ogm<oqr>
{
  private osc a;
  private osf d;
  private ViewStub u;
  
  public osb(Context paramContext, osf paramosf)
  {
    super(paramContext);
    this.d = paramosf;
  }
  
  private stSimpleMetaFeed b()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localoqr.B();
    }
    return null;
  }
  
  private void c(oqr paramoqr)
  {
    if ((b() != null) && (b().new_icon != null) && (b().new_icon.tag_type == 0))
    {
      if (this.a == null)
      {
        this.a = new osc(this.mContext, this.d);
        this.a.initLayout(this.u);
      }
      this.a.setData(paramoqr);
    }
  }
  
  protected void Hp() {}
  
  public void b(oqr paramoqr)
  {
    super.setData(paramoqr);
    c(paramoqr);
  }
  
  protected int gn()
  {
    return 2131560227;
  }
  
  protected void initView()
  {
    this.u = ((ViewStub)findViewById(2131381559));
  }
  
  protected void onRecycle()
  {
    if (this.a != null) {
      this.a.onRecycle();
    }
  }
  
  protected void onUpdateUI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osb
 * JD-Core Version:    0.7.0.1
 */