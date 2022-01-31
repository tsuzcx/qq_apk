import com.tencent.widget.AbsListView;

public class fgr
  implements Runnable
{
  public fgr(AbsListView paramAbsListView) {}
  
  public void run()
  {
    if (this.a.g)
    {
      AbsListView localAbsListView = this.a;
      this.a.h = false;
      localAbsListView.g = false;
      AbsListView.a(this.a, false);
      if ((AbsListView.n(this.a) & 0x2) == 0) {
        AbsListView.b(this.a, false);
      }
      if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgr
 * JD-Core Version:    0.7.0.1
 */