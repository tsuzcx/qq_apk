import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uvq
  extends uvh
{
  private String a;
  
  public uvq(urv paramurv)
  {
    super(paramurv);
  }
  
  public List<usv> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.a = ((stSimpleMetaFeed)paramArrayList.get(0)).id;
    }
    return WSVerticalDataManager.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    uqf.d("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof uuy))
    {
      paramViewHolder = (uuy)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new uhe(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      wjj.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(String paramString, usf paramusf, long paramLong)
  {
    paramString = new uoq(paramString);
    paramString = new uko(paramString, null, new uvr(this, paramLong, paramString, paramusf), 4002);
    ukh.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(this.a, this, System.currentTimeMillis());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvq
 * JD-Core Version:    0.7.0.1
 */