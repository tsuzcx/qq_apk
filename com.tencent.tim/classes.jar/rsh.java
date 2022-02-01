import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rsh
  implements View.OnClickListener
{
  public rsh(InnerListView paramInnerListView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((InnerListView.a(this.c) != null) && (InnerListView.a(this.c) != null)) {
      InnerListView.a(this.c).a(this.c, paramView, this.Ic);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsh
 * JD-Core Version:    0.7.0.1
 */