import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class uxt
  implements View.OnClickListener
{
  uxt(uxp paramuxp) {}
  
  public void onClick(View paramView)
  {
    uxv localuxv;
    if (uxp.a(this.a) != null)
    {
      localuxv = (uxv)uxp.a(this.a).get();
      if (localuxv != null) {
        switch (paramView.getId())
        {
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localuxv.a(uxw.a);
      continue;
      localuxv.a(uxw.b);
      continue;
      localuxv.a(uxw.c);
      continue;
      localuxv.a(uxw.d);
      continue;
      localuxv.a(uxw.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxt
 * JD-Core Version:    0.7.0.1
 */