import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public abstract class osf
  extends orc<oqr>
{
  public ola a;
  public ole b;
  
  public osf(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  protected boolean Hh()
  {
    return false;
  }
  
  protected boolean Hi()
  {
    return true;
  }
  
  protected boolean Hj()
  {
    return true;
  }
  
  public void bey()
  {
    super.bey();
    if (this.a != null) {
      this.a.bey();
    }
  }
  
  public void bez()
  {
    if (this.a != null) {
      this.a.bez();
    }
  }
  
  public void g(oqr paramoqr)
  {
    super.P(paramoqr);
    if (this.a != null) {
      this.a.setData(paramoqr);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.c != null) && (this.c.a() != null))
    {
      this.c.a().setLoopback(Hh());
      this.c.a().oE(Hh());
    }
    if (this.c != null)
    {
      this.c.qU(Hi());
      this.c.qV(Hj());
    }
    if (this.a != null) {
      this.a.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osf
 * JD-Core Version:    0.7.0.1
 */