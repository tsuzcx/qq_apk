import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.b;

public class rsi
  implements View.OnLongClickListener
{
  public rsi(InnerListView paramInnerListView, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((InnerListView.a(this.c) != null) && (InnerListView.a(this.c) != null)) {
      return InnerListView.a(this.c).a(this.c, paramView, this.Ic);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsi
 * JD-Core Version:    0.7.0.1
 */