import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class wic
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  wic(wia paramwia) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (wia.b(this.jdField_a_of_type_Wia)))
    {
      yuk.b("FredguoFix", "set needAnimated to false, break animation");
      wia.a(this.jdField_a_of_type_Wia).a(wia.a(this.jdField_a_of_type_Wia));
      wia.b(this.jdField_a_of_type_Wia, false);
      wia.a(this.jdField_a_of_type_Wia, false);
    }
    if (paramInt == 0)
    {
      wia.d(this.jdField_a_of_type_Wia, false);
      this.jdField_a_of_type_Long = 0L;
      if (wia.a(this.jdField_a_of_type_Wia).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (wia.c(this.jdField_a_of_type_Wia))
      {
        yuk.b("FredguoFix", "animated to false, play animation done");
        wia.a(this.jdField_a_of_type_Wia, false);
        wia.a(this.jdField_a_of_type_Wia).a(wia.a(this.jdField_a_of_type_Wia));
      }
      this.jdField_a_of_type_Wia.d();
      return;
    }
    wia.d(this.jdField_a_of_type_Wia, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Wia.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wic
 * JD-Core Version:    0.7.0.1
 */