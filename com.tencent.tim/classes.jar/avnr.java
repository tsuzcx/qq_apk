import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;

public class avnr
  implements EnterCallback
{
  public avnr(ReaderShadowImpl.1 param1, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.a.b != null) {
      this.a.b.onCloseLoadingView();
    }
    avoc.u("ReaderShadowImpl", "[onCloseLoadingView] formId = " + this.a.azL);
  }
  
  public void onEnterComplete()
  {
    if (this.a.b != null) {
      this.a.b.onEnterComplete();
    }
    if (this.a.azL == 1002L) {
      avof.ar(this.a.val$context, String.valueOf(System.currentTimeMillis() - this.azM), "0");
    }
    for (;;)
    {
      avoc.u("ReaderShadowImpl", "[onEnterComplete] formId = " + this.a.azL);
      return;
      if (this.a.azL == 1003L) {
        avof.ar(this.a.val$context, String.valueOf(System.currentTimeMillis() - this.azM), "1");
      }
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.a.b != null) {
      this.a.b.onShowLoadingView(paramView);
    }
    avoc.u("ReaderShadowImpl", "[onShowLoadingView] formId = " + this.a.azL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnr
 * JD-Core Version:    0.7.0.1
 */