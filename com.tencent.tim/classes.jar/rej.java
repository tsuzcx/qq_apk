import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.List;

class rej
  implements AbsListView.e
{
  int bqx = 0;
  
  rej(reh paramreh) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bqx = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.bqx == reh.a(this.b, reh.a(this.b)).ck().size()) && (!reh.a(this.b, reh.a(this.b)).isEnd()))
    {
      paramAbsListView = reh.a(this.b);
      reh.a(this.b, reh.a(this.b)).c(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rej
 * JD-Core Version:    0.7.0.1
 */