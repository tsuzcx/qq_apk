import com.tencent.widget.AbsListView;

public class hut
  implements Runnable
{
  public hut(AbsListView paramAbsListView) {}
  
  public void run()
  {
    if (this.a.f)
    {
      AbsListView localAbsListView = this.a;
      this.a.g = false;
      localAbsListView.f = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hut
 * JD-Core Version:    0.7.0.1
 */