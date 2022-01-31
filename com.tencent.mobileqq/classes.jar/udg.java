import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

class udg
  extends LinearLayoutManager
{
  udg(udf paramudf, Context paramContext, int paramInt, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udg
 * JD-Core Version:    0.7.0.1
 */