import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajxy
  implements View.OnClickListener
{
  ajxy(ajxw paramajxw) {}
  
  public void onClick(View paramView)
  {
    ajxw.a(this.a).commentList.clear();
    ajxw.a(this.a).start();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxy
 * JD-Core Version:    0.7.0.1
 */