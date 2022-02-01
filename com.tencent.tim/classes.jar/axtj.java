import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;

class axtj
  implements AbsListView.e
{
  int bqx = 0;
  
  axtj(axti paramaxti) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bqx = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      aurd.hide(this.this$0.mRootView);
    }
    while ((paramInt != 0) || (this.this$0.nw == null) || (this.bqx < this.this$0.nw.size())) {
      return;
    }
    axti.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtj
 * JD-Core Version:    0.7.0.1
 */