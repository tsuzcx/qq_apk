import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class tnq
  extends tnn
{
  private String a;
  
  public tnq(tmj paramtmj)
  {
    super(paramtmj);
  }
  
  public List<tmv> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.a = ((stSimpleMetaFeed)paramArrayList.get(0)).id;
    }
    return tms.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    tlo.d("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof tnj))
    {
      paramViewHolder = new ybt(4, new Object[] { Integer.valueOf(paramInt), ((tnj)paramViewHolder).a });
      uht.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(String paramString, tmr paramtmr)
  {
    paramString = new the(new tkg(paramString), null, new tnr(this, paramtmr), 4002);
    tgx.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(this.a, this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnq
 * JD-Core Version:    0.7.0.1
 */