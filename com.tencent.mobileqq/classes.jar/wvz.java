import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.videostory.capture.widgets.BeautyAndFilterPanelViewStubHolder.1;
import com.tencent.biz.videostory.capture.widgets.BeautyAndFilterPanelViewStubHolder.2;
import dov.com.qq.im.AECamera.View.AEProviderContainerView;

public class wvz
  extends wvy
{
  private AEProviderContainerView a;
  
  public wvz(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2131297572));
  }
  
  public void a(auti paramauti)
  {
    a(new BeautyAndFilterPanelViewStubHolder.1(this, paramauti));
  }
  
  public void a(bgxh parambgxh, wus paramwus)
  {
    a(new BeautyAndFilterPanelViewStubHolder.2(this, parambgxh, paramwus));
  }
  
  public void a(wsh paramwsh)
  {
    if (!a()) {
      return;
    }
    this.a.setCaptureMode(paramwsh);
  }
  
  public void b()
  {
    a();
    this.a.setVisibility(0);
    this.a.b();
  }
  
  public boolean b()
  {
    if (!a()) {
      return false;
    }
    return this.a.b();
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.a.a();
  }
  
  public void d()
  {
    if (!a()) {
      return;
    }
    this.a.d();
  }
  
  public void e()
  {
    if (!a()) {
      return;
    }
    this.a.f();
  }
  
  public void f()
  {
    if (!a()) {
      return;
    }
    this.a.c();
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    this.a.g();
  }
  
  public void h()
  {
    if (!a()) {
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvz
 * JD-Core Version:    0.7.0.1
 */