import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vbp
  implements View.OnClickListener
{
  vbp(vbo paramvbo) {}
  
  public void onClick(View paramView)
  {
    if (vbo.a(this.a)) {
      vbo.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */