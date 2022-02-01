import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.List;

class ayie
  implements AbsListView.e
{
  int bqx = 0;
  
  ayie(ayic paramayic) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bqx = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.bqx == ayic.a(this.b, ayic.a(this.b)).ck().size()) && (!ayic.a(this.b, ayic.a(this.b)).isEnd()))
    {
      paramAbsListView = ayic.a(this.b);
      ayic.a(this.b, ayic.a(this.b)).c(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayie
 * JD-Core Version:    0.7.0.1
 */