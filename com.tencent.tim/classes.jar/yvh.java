import android.widget.TextView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class yvh
  implements AbsListView.e
{
  yvh(yvg paramyvg) {}
  
  private boolean c(AbsListView paramAbsListView)
  {
    return (paramAbsListView.getChildAt(paramAbsListView.getChildCount() - 1) == this.b.LV) && (this.b.LV.getBottom() == this.b.LV.getBottom());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (c(paramAbsListView))) {
      this.b.cmh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvh
 * JD-Core Version:    0.7.0.1
 */