import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class vdn
  extends vdc
{
  public vdn(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(0);
      if ((localstSimpleMetaFeed.imgReplacements != null) && (localstSimpleMetaFeed.imgReplacements.size() > 1)) {
        ((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(1)).img = ((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(0)).img;
      }
      if ((localstSimpleMetaFeed.images != null) && (localstSimpleMetaFeed.images.size() > 1)) {
        ((stMetaUgcImage)localstSimpleMetaFeed.images.get(1)).url = ((stMetaUgcImage)localstSimpleMetaFeed.images.get(0)).url;
      }
    }
    return paramArrayList;
  }
  
  public List<vaq> a(ArrayList paramArrayList)
  {
    return WSVerticalDataManager.a().a(a(paramArrayList));
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    uya.d("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    uzq localuzq = a();
    if (localuzq == null) {}
    do
    {
      do
      {
        return;
        if ((paramViewHolder instanceof vct))
        {
          paramViewHolder = new unv(4, new Object[] { Integer.valueOf(paramInt), ((vct)paramViewHolder).a });
          vli.a().dispatch(paramViewHolder);
        }
      } while (paramInt <= 0);
      if (umu.a().a(paramInt, 2))
      {
        localuzq.a(paramInt, 2);
        return;
      }
    } while (umu.a().d(2) != paramInt);
    localuzq.a(umu.a().a(2));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    uzq localuzq = a();
    if (localuzq == null) {
      return false;
    }
    WSVerticalDataManager.a().a(2, paramBoolean1, paramBoolean2, paramString, localuzq.a(), this, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdn
 * JD-Core Version:    0.7.0.1
 */