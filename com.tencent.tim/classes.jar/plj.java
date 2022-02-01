import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class plj
  extends RecyclerView.OnScrollListener
{
  private long hY;
  private final long hZ = 20L;
  
  plj(plh paramplh) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (plh.b(this.this$0)))
    {
      ram.d("FredguoFix", "set needAnimated to false, break animation");
      plh.a(this.this$0).a(plh.a(this.this$0));
      plh.b(this.this$0, false);
      plh.a(this.this$0, false);
    }
    if (paramInt == 0)
    {
      plh.d(this.this$0, false);
      this.hY = 0L;
      if (plh.a(this.this$0).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (plh.c(this.this$0))
      {
        ram.d("FredguoFix", "animated to false, play animation done");
        plh.a(this.this$0, false);
        plh.a(this.this$0).a(plh.a(this.this$0));
      }
      this.this$0.blz();
      return;
    }
    plh.d(this.this$0, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.hY) >= 20L)
    {
      this.hY = l;
      this.this$0.blz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plj
 * JD-Core Version:    0.7.0.1
 */