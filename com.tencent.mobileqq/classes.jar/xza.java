import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

public abstract class xza<T>
  extends xyz<T>
{
  protected int c = -1;
  
  public xza(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  protected abstract int a();
  
  protected abstract View a();
  
  protected View a(int paramInt)
  {
    if (this.b != null) {
      return this.b.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract void a();
  
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
    paramViewStub.setLayoutResource(a());
    this.b = paramViewStub.inflate();
    if (a() == 2131562258) {
      b(a());
    }
    a();
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.b = paramViewStub.inflate();
      a();
    }
  }
  
  public void b(View paramView)
  {
    if ((paramView != null) && (c())) {
      ((ViewGroup)this.b).addView(paramView);
    }
  }
  
  protected boolean c()
  {
    return (this.b != null) && ((this.b instanceof ViewGroup));
  }
  
  protected void i()
  {
    this.b = a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xza
 * JD-Core Version:    0.7.0.1
 */