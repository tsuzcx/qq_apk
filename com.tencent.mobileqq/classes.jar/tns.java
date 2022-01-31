import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class tns
  extends tnn
{
  public tns(tmj paramtmj)
  {
    super(paramtmj);
  }
  
  public List<tmv> a(ArrayList paramArrayList)
  {
    return tms.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    tlo.d("comment", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof tnj))
    {
      paramViewHolder = new ygc(4, new Object[] { Integer.valueOf(paramInt), ((tnj)paramViewHolder).a });
      umc.a().dispatch(paramViewHolder);
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tms.a().a(2, paramBoolean1, paramBoolean2, null, null, this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tns
 * JD-Core Version:    0.7.0.1
 */