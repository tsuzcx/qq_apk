import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahmc
  implements View.OnClickListener
{
  ahmc(ahmb paramahmb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e.hideSoftInputFromWindow();
      ahjj localahjj = new ahjj(this.a.e);
      localahjj.gc(this.a.mActivity.getString(2131693987), this.a.bKu);
      this.a.e.addPreviewView(localahjj.getRootView());
      this.a.dnZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmc
 * JD-Core Version:    0.7.0.1
 */