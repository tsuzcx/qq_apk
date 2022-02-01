import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vdl
  extends vdc
{
  private String a;
  
  public vdl(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  public List<vaq> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(0);
        localstSimpleMetaFeed.isLoop = true;
        this.a = localstSimpleMetaFeed.id;
      }
      return WSVerticalDataManager.a().a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    uya.d("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof vct))
    {
      paramViewHolder = (vct)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new unv(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      vli.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(String paramString, vaa paramvaa, long paramLong)
  {
    paramString = new urj(new uwk(paramString), null, new vdm(this, paramLong, paramvaa), 4002);
    urc.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(this.a, this, System.currentTimeMillis());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdl
 * JD-Core Version:    0.7.0.1
 */