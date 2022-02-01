import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;

class rdq
  implements AbsListView.e
{
  int bqx = 0;
  
  rdq(rdp paramrdp) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bqx = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.this$0.kd != null) && (this.bqx == this.this$0.kd.size() - 1)) {
      this.this$0.btk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdq
 * JD-Core Version:    0.7.0.1
 */