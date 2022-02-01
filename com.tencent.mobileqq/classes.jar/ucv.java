import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ucv<V extends uch, P extends uck<V>>
  implements ucj
{
  private uci<V, P> a;
  
  public ucv(uci<V, P> paramuci)
  {
    if (paramuci == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramuci;
  }
  
  private V a()
  {
    uch localuch = this.a.a();
    if (localuch == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localuch;
  }
  
  private P a()
  {
    uck localuck = this.a.b();
    if (localuck == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localuck;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    uck localuck = this.a.b();
    paramBundle = localuck;
    if (localuck == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucv
 * JD-Core Version:    0.7.0.1
 */