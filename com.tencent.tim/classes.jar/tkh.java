import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class tkh
  implements View.OnClickListener
{
  public tkh(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      str = "loading ad data";
      tgc.b localb = new tgc.b();
      localb.a = GdtInterstitialFragmentForJS.a(this.a);
      GdtInterstitialFragmentForJS.a(this.a, new tgc(localb, new WeakReference(GdtInterstitialFragmentForJS.a(this.a))));
      GdtInterstitialFragmentForJS.a(this.a).c(new WeakReference(this.a.getActivity()));
    }
    for (;;)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), str, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "load ad data error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkh
 * JD-Core Version:    0.7.0.1
 */