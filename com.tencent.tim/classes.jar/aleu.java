import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class aleu
  implements View.OnClickListener
{
  aleu(alet paramalet, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (alet.a(this.a) == this.val$pos) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = alet.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((alev)localIterator.next()).isSelected = false;
      }
      ((alev)alet.a(this.a).get(this.val$pos)).isSelected = true;
      alet.a(this.a, this.val$pos);
      this.a.notifyDataSetChanged();
      if (alet.a(this.a) != null) {
        alet.a(this.a).a((alev)alet.a(this.a).get(this.val$pos));
      }
      anot.a(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aleu
 * JD-Core Version:    0.7.0.1
 */