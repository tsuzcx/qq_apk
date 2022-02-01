import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;

class axtn
  implements AbsListView.e
{
  int bqx = 0;
  
  axtn(axtm paramaxtm) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bqx = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (axtm.a(this.this$0).eL() != null) && (this.bqx == axtm.a(this.this$0).eL().size() - 1)) {
      axtm.a(this.this$0).btk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtn
 * JD-Core Version:    0.7.0.1
 */