import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class oss
  extends oso
{
  private String mFeedId;
  
  public oss(oqi.b paramb)
  {
    super(paramb);
  }
  
  public void a(String paramString, oqm paramoqm, long paramLong)
  {
    paramString = new ons(paramString);
    paramString = new okz(paramString, null, new ost(this, paramLong, paramString, paramoqm), 4002);
    oks.a().b(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(this.mFeedId, this, System.currentTimeMillis());
    return true;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    ooz.e("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof osf))
    {
      paramViewHolder = (osf)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.mCurrentPageIndex = 1;
      paramViewHolder = new sct(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.be });
      pmi.a().dispatch(paramViewHolder);
    }
  }
  
  public List<oqr> d(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.mFeedId = ((stSimpleMetaFeed)paramArrayList.get(0)).id;
    }
    return oqp.a().e(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oss
 * JD-Core Version:    0.7.0.1
 */