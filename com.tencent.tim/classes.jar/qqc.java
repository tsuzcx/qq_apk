import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class qqc
  implements View.OnClickListener
{
  qqc(qqa.f paramf) {}
  
  public void onClick(View paramView)
  {
    qqa.a locala = new qqa.a();
    if (this.a.b.aEI) {
      this.a.b.aEI = false;
    }
    for (locala.sortType = 0;; locala.sortType = 1)
    {
      pmi.a().dispatch(locala);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.b.aEI = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqc
 * JD-Core Version:    0.7.0.1
 */