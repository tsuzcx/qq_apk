import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class ukv
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  ukv(ukt paramukt) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (ukt.b(this.jdField_a_of_type_Ukt)))
    {
      wxe.b("FredguoFix", "set needAnimated to false, break animation");
      ukt.a(this.jdField_a_of_type_Ukt).a(ukt.a(this.jdField_a_of_type_Ukt));
      ukt.b(this.jdField_a_of_type_Ukt, false);
      ukt.a(this.jdField_a_of_type_Ukt, false);
    }
    if (paramInt == 0)
    {
      ukt.d(this.jdField_a_of_type_Ukt, false);
      this.jdField_a_of_type_Long = 0L;
      if (ukt.a(this.jdField_a_of_type_Ukt).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (ukt.c(this.jdField_a_of_type_Ukt))
      {
        wxe.b("FredguoFix", "animated to false, play animation done");
        ukt.a(this.jdField_a_of_type_Ukt, false);
        ukt.a(this.jdField_a_of_type_Ukt).a(ukt.a(this.jdField_a_of_type_Ukt));
      }
      this.jdField_a_of_type_Ukt.d();
      return;
    }
    ukt.d(this.jdField_a_of_type_Ukt, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Ukt.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukv
 * JD-Core Version:    0.7.0.1
 */