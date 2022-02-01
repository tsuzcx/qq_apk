import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zwq
  implements View.OnClickListener
{
  zwq(zwp paramzwp) {}
  
  public void onClick(View paramView)
  {
    if (zwp.a(this.a) == null)
    {
      zwp.a(this.a, aqha.b(this.a.mActivity, 0, "", null, "", "", new zwr(this), new zws(this)));
      zwp.a(this.a).setCanceledOnTouchOutside(false);
    }
    zwp.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */