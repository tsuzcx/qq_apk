import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.State;

public class ucw
  extends LinearLayoutManager
{
  public ucw(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    return super.getExtraLayoutSpace(paramState) + uqs.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucw
 * JD-Core Version:    0.7.0.1
 */