import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class abfv
  implements AbsListView.e
{
  abfv(abfr paramabfr) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    abfr.a(this.this$0, paramInt);
    if (paramInt == 0)
    {
      abfr.a(this.this$0, null, null);
      abfr.a(this.this$0).resume();
      return;
    }
    abfr.a(this.this$0).pause();
    abfr.a(this.this$0).edu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfv
 * JD-Core Version:    0.7.0.1
 */