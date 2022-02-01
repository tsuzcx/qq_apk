import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uuo
  extends uuf
{
  private String a;
  
  public uuo(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  public List<uru> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.a = ((stSimpleMetaFeed)paramArrayList.get(0)).id;
    }
    return WSVerticalDataManager.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    upe.d("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof utw))
    {
      paramViewHolder = (utw)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new uhc(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      wfo.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(String paramString, ure paramure, long paramLong)
  {
    paramString = new unp(paramString);
    paramString = new uju(paramString, null, new uup(this, paramLong, paramString, paramure), 4002);
    ujn.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(this.a, this, System.currentTimeMillis());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuo
 * JD-Core Version:    0.7.0.1
 */