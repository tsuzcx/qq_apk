import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class uzb
  implements View.OnClickListener
{
  uzb(uyy paramuyy) {}
  
  public void onClick(View paramView)
  {
    uze localuze;
    if (uyy.a(this.a) != null)
    {
      localuze = (uze)uyy.a(this.a).get();
      if (localuze != null) {
        switch (paramView.getId())
        {
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localuze.a(uzf.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */