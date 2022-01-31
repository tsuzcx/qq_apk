import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

public abstract class wkl<T>
  extends wkk<T>
{
  protected int c = -1;
  
  public wkl(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  protected abstract View a();
  
  protected View a(int paramInt)
  {
    if (this.a != null) {
      return this.a.findViewById(paramInt);
    }
    return null;
  }
  
  protected void a()
  {
    this.a = a();
    g();
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (a())) {
      ((ViewGroup)this.a).addView(paramView);
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    if (this.c != -1)
    {
      a(paramViewStub, this.c);
      return;
    }
    paramViewStub.setLayoutResource(b());
    this.a = paramViewStub.inflate();
    if (b() == 2131562067) {
      a(a());
    }
    g();
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.a = paramViewStub.inflate();
      g();
    }
  }
  
  protected boolean a()
  {
    return (this.a != null) && ((this.a instanceof ViewGroup));
  }
  
  protected abstract int b();
  
  protected abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wkl
 * JD-Core Version:    0.7.0.1
 */