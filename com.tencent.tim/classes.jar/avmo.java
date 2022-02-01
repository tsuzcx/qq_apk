import android.app.Activity;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.ReaderSplashImpl.3.1;

public class avmo
  implements EnterCallback
{
  avmo(avml paramavml) {}
  
  public void onCloseLoadingView() {}
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    avml.a(this.a).runOnUiThread(new ReaderSplashImpl.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmo
 * JD-Core Version:    0.7.0.1
 */