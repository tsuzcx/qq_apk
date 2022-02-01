import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ujn<V extends uiz, P extends ujc<V>>
  implements ujb
{
  private uja<V, P> a;
  
  public ujn(uja<V, P> paramuja)
  {
    if (paramuja == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramuja;
  }
  
  private V a()
  {
    uiz localuiz = this.a.a();
    if (localuiz == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localuiz;
  }
  
  private P a()
  {
    ujc localujc = this.a.b();
    if (localujc == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localujc;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    ujc localujc = this.a.b();
    paramBundle = localujc;
    if (localujc == null) {
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
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */