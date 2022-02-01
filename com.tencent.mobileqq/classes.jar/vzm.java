import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

class vzm
  extends LinearLayoutManager
{
  vzm(vzl paramvzl, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzm
 * JD-Core Version:    0.7.0.1
 */