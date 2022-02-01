import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uqp
  extends ueh<Object>
{
  private WSVerticalPageFragment a;
  private View b;
  private View c;
  
  public uqp(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.a = paramWSVerticalPageFragment;
  }
  
  private void f()
  {
    if (this.a.a() == null) {
      return;
    }
    utw localutw = this.a.a().a();
    if (localutw != null) {
      localutw.e();
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
  
  public void a(boolean paramBoolean, uja paramuja)
  {
    View localView;
    if ((this.b != null) && (paramuja != null))
    {
      paramuja.a(paramBoolean);
      localView = this.b;
      if ((paramuja.a() <= 0) || (!paramBoolean)) {
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
    return 2131559996;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380514);
    urc.a(this.a.getActivity(), localRelativeLayout);
    a(2131380515).setOnClickListener(new uqq(this));
    this.c = a(2131380517);
    this.c.setOnClickListener(new uqr(this));
    this.b = a(2131369021);
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqp
 * JD-Core Version:    0.7.0.1
 */