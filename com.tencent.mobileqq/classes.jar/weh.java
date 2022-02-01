import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class weh
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  weh(wef paramwef) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (wef.b(this.jdField_a_of_type_Wef)))
    {
      yqp.b("FredguoFix", "set needAnimated to false, break animation");
      wef.a(this.jdField_a_of_type_Wef).a(wef.a(this.jdField_a_of_type_Wef));
      wef.b(this.jdField_a_of_type_Wef, false);
      wef.a(this.jdField_a_of_type_Wef, false);
    }
    if (paramInt == 0)
    {
      wef.d(this.jdField_a_of_type_Wef, false);
      this.jdField_a_of_type_Long = 0L;
      if (wef.a(this.jdField_a_of_type_Wef).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (wef.c(this.jdField_a_of_type_Wef))
      {
        yqp.b("FredguoFix", "animated to false, play animation done");
        wef.a(this.jdField_a_of_type_Wef, false);
        wef.a(this.jdField_a_of_type_Wef).a(wef.a(this.jdField_a_of_type_Wef));
      }
      this.jdField_a_of_type_Wef.d();
      return;
    }
    wef.d(this.jdField_a_of_type_Wef, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Wef.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weh
 * JD-Core Version:    0.7.0.1
 */