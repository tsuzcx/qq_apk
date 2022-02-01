import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tjv
  implements View.OnClickListener
{
  tjv(tju paramtju) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.a.a() != null)
    {
      bool = this.a.a().load(this.a.getActivity());
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "loading ad data";; str = "load ad data error")
    {
      Toast.makeText(this.a.getActivity().getApplicationContext(), str, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjv
 * JD-Core Version:    0.7.0.1
 */