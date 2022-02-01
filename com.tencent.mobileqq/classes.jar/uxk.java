import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class uxk<V extends uww, P extends uwz<V>>
  implements uwy
{
  private uwx<V, P> a;
  
  public uxk(uwx<V, P> paramuwx)
  {
    if (paramuwx == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramuwx;
  }
  
  private V a()
  {
    uww localuww = this.a.a();
    if (localuww == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localuww;
  }
  
  private P a()
  {
    uwz localuwz = this.a.b();
    if (localuwz == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localuwz;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    uwz localuwz = this.a.b();
    paramBundle = localuwz;
    if (localuwz == null) {
      paramBundle = this.a.a();
    }
    this.a.a(paramBundle);
  }
  
  public void a(View paramView, @Nullable Bundle paramBundle)
  {
    a().a(a());
  }
  
  public void b()
  {
    a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxk
 * JD-Core Version:    0.7.0.1
 */