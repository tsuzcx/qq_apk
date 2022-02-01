import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

class pip
  extends LinearLayoutManager
{
  pip(pio parampio, Context paramContext, int paramInt, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pip
 * JD-Core Version:    0.7.0.1
 */