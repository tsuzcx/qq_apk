import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.3.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tkj
  implements View.OnClickListener
{
  public tkj(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onClick(View paramView)
  {
    GdtInterstitialFragmentForJS.a(this.a).orientation = GdtInterstitialFragmentForJS.r(this.a.getActivity());
    if (GdtInterstitialFragmentForJS.a(this.a) == null)
    {
      str = "ad is not loaded";
      Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
    }
    for (;;)
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), str, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (GdtInterstitialFragmentForJS.a(this.a) == null)
      {
        str = "ad is loading";
      }
      else
      {
        if (GdtInterstitialFragmentForJS.a(this.a).getErrorCode() == 0) {
          break;
        }
        str = GdtInterstitialFragmentForJS.a(this.a).getErrorMessage();
      }
    }
    if (GdtInterstitialFragmentForJS.a(this.a).show(this.a.getActivity())) {}
    for (String str = "正在打开插屏";; str = "打开插屏错误")
    {
      AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragmentForJS.3.1(this), 0, 5000L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */