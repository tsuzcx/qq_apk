import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ofd<V extends oer, P extends oeu<V>>
  implements oet
{
  private oes<V, P> a;
  
  public ofd(oes<V, P> paramoes)
  {
    if (paramoes == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramoes;
  }
  
  private V a()
  {
    oer localoer = this.a.a();
    if (localoer == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localoer;
  }
  
  private P b()
  {
    oeu localoeu = this.a.b();
    if (localoeu == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localoeu;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    oeu localoeu = this.a.b();
    paramBundle = localoeu;
    if (localoeu == null) {
      paramBundle = this.a.a();
    }
    this.a.a(paramBundle);
  }
  
  public void onDestroy()
  {
    b().destroy();
  }
  
  public void onDestroyView()
  {
    b().detachView();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    b().a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofd
 * JD-Core Version:    0.7.0.1
 */