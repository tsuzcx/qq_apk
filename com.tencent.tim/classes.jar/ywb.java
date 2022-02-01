import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ywb
  implements View.OnClickListener
{
  ywb(ywa paramywa) {}
  
  public void onClick(View paramView)
  {
    ywa.a locala = (ywa.a)paramView.getTag();
    if ((locala == null) || (!(locala instanceof ywa.a))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.g.eiZ();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).eiW();
      }
      ywa.a(this.a, locala.a);
      this.a.tu.add(ywa.a(this.a).remove(this.a.getCount() - locala.mPosition - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywb
 * JD-Core Version:    0.7.0.1
 */