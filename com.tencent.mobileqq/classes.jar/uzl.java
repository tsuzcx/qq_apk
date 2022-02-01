import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uzl
  extends ukz<Object>
{
  private WSVerticalPageFragment a;
  private View b;
  private View c;
  
  public uzl(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.a = paramWSVerticalPageFragment;
  }
  
  private void f()
  {
    if (this.a.a() == null) {
      return;
    }
    vct localvct = this.a.a().a();
    if (localvct != null) {
      localvct.d();
    }
    g();
  }
  
  private void g()
  {
    if (this.a.a() != null) {
      this.a.a().a(this.a.a());
    }
  }
  
  protected void a() {}
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.c != null)
    {
      localView = this.c;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, uqp paramuqp)
  {
    View localView;
    if ((this.b != null) && (paramuqp != null))
    {
      paramuqp.a(paramBoolean);
      localView = this.b;
      if ((paramuqp.a() <= 0) || (!paramBoolean)) {
        break label42;
      }
    }
    label42:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected int b()
  {
    return 2131560008;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380426);
    uzy.a(this.a.getActivity(), localRelativeLayout);
    a(2131380427).setOnClickListener(new uzm(this));
    this.c = a(2131380429);
    this.c.setOnClickListener(new uzn(this));
    this.b = a(2131369142);
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */