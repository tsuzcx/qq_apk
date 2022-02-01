import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tjw
  implements View.OnClickListener
{
  tjw(tju paramtju) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() == null) {
      Toast.makeText(this.a.getActivity().getApplicationContext(), "error", 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.a.a().isLoaded()) {
        Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
      } else if (this.a.a().isInvalidated()) {
        Toast.makeText(this.a.getActivity().getApplicationContext(), "ad is invalidated", 0).show();
      } else {
        this.a.onShow();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjw
 * JD-Core Version:    0.7.0.1
 */