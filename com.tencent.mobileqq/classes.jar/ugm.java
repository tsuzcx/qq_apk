import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class ugm
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  ugm(ugk paramugk) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (ugk.b(this.jdField_a_of_type_Ugk)))
    {
      wsv.b("FredguoFix", "set needAnimated to false, break animation");
      ugk.a(this.jdField_a_of_type_Ugk).a(ugk.a(this.jdField_a_of_type_Ugk));
      ugk.b(this.jdField_a_of_type_Ugk, false);
      ugk.a(this.jdField_a_of_type_Ugk, false);
    }
    if (paramInt == 0)
    {
      ugk.d(this.jdField_a_of_type_Ugk, false);
      this.jdField_a_of_type_Long = 0L;
      if (ugk.a(this.jdField_a_of_type_Ugk).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (ugk.c(this.jdField_a_of_type_Ugk))
      {
        wsv.b("FredguoFix", "animated to false, play animation done");
        ugk.a(this.jdField_a_of_type_Ugk, false);
        ugk.a(this.jdField_a_of_type_Ugk).a(ugk.a(this.jdField_a_of_type_Ugk));
      }
      this.jdField_a_of_type_Ugk.d();
      return;
    }
    ugk.d(this.jdField_a_of_type_Ugk, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Ugk.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugm
 * JD-Core Version:    0.7.0.1
 */