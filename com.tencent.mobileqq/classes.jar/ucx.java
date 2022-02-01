import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ucx<V extends ucj, P extends ucm<V>>
  implements ucl
{
  private uck<V, P> a;
  
  public ucx(uck<V, P> paramuck)
  {
    if (paramuck == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramuck;
  }
  
  private V a()
  {
    ucj localucj = this.a.a();
    if (localucj == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localucj;
  }
  
  private P a()
  {
    ucm localucm = this.a.b();
    if (localucm == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localucm;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    ucm localucm = this.a.b();
    paramBundle = localucm;
    if (localucm == null) {
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
 * Qualified Name:     ucx
 * JD-Core Version:    0.7.0.1
 */