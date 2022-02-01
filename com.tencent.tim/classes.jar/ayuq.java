import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayuq
  implements View.OnClickListener
{
  ayuq(ayup paramayup) {}
  
  public void onClick(View paramView)
  {
    if (!ayup.a(this.a).bwI) {
      ayup.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ayup.a(this.a).dAO)
      {
        arxa.a().showToast(2131718261);
        ayup.a(this.a).dAO = false;
        ayup.a(this.a).setSelected(false);
        ayup.a(this.a).dAL = false;
        ayup.a(this.a).afI(3008);
      }
      else
      {
        arxa.a().showToast(2131718263);
        ayup.a(this.a).dAO = true;
        ayup.a(this.a).setSelected(true);
        ayup.a(this.a).dAL = true;
        ayup.a(this.a).afI(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuq
 * JD-Core Version:    0.7.0.1
 */