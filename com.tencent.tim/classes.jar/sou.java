import android.view.View;
import com.tencent.biz.ui.RefreshView;
import com.tencent.widget.ListView;

public class sou
  implements auuo
{
  public sou(RefreshView paramRefreshView) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.d.mState == 2)
    {
      this.d.b.pn();
      return;
    }
    this.d.b.Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.d.mState != 2)
    {
      RefreshView.a(this.d, false);
      this.d.cD(RefreshView.a(this.d));
      this.d.b.S(0L);
      this.d.mState = 2;
      RefreshView.a(this.d);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.d.mState != 2) {
      this.d.b.R(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.d.ps();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sou
 * JD-Core Version:    0.7.0.1
 */