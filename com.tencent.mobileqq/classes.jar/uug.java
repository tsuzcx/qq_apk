import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uug
  extends uuf
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private List<uru> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public uug(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  private uru a(List<uru> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (uru)paramList.get(i);
      if (localObject != null)
      {
        localObject = (stSimpleMetaFeed)((uru)localObject).a();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.jdField_a_of_type_JavaLangString))) {
          return (uru)paramList.remove(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  private void a(uru paramuru)
  {
    Object localObject = a();
    if ((paramuru == null) || (localObject == null) || (((uqu)localObject).a() == null) || (((uqu)localObject).a().a() == null)) {}
    do
    {
      do
      {
        return;
        upe.d("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + ((uqu)localObject).a().getItemCount());
        uei localuei = ((uqu)localObject).a().a().jdField_a_of_type_Uei;
        if ((localuei instanceof usp)) {
          ((usp)localuei).b(paramuru);
        }
        localObject = (uru)((uqu)localObject).a().a(0);
      } while (localObject == null);
      paramuru = (stSimpleMetaFeed)paramuru.a();
    } while (paramuru == null);
    if (paramuru.floatingLayerCardStyle != null) {
      paramuru.floatingLayerCardStyle.cardType = 3;
    }
    ((uru)localObject).a(paramuru);
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && (localObject != null))
    {
      localObject = ((uqu)localObject).a();
      if ((localObject != null) && (((WSPlayerManager)localObject).e()))
      {
        upe.d("terry_ark", "WSVerticalForArkCardPresenter isPlayError");
        return true;
      }
    }
    return false;
  }
  
  public List<uru> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)paramArrayList.get(0));
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) {
        break label62;
      }
    }
    label62:
    for (String str = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id;; str = "")
    {
      this.jdField_a_of_type_JavaLangString = str;
      return WSVerticalDataManager.a().a(paramArrayList);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    upe.d("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    uqu localuqu = a();
    if (localuqu == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramViewHolder instanceof utw));
      paramViewHolder = (utw)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      uhc localuhc = new uhc(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      wfo.a().dispatch(localuhc);
    } while (paramViewHolder.jdField_a_of_type_JavaLangObject == null);
    localuqu.b(((uru)paramViewHolder.jdField_a_of_type_JavaLangObject).a());
  }
  
  public void a(List<uru> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (a(paramBoolean2))
    {
      ((uqu)localObject).a().a(paramList);
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      return;
    }
    if (paramBoolean2) {}
    for (localObject = a(paramList);; localObject = null)
    {
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      a((uru)localObject);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    return a(paramBoolean2);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    upe.d("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + paramBoolean1 + " isFirst = " + paramBoolean2 + " from = " + paramString);
    paramString = a();
    if ((paramString != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null))
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilList = paramString.a();
      }
      urf.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id, 10007, paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaUtilList, this, null);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    urf.a().a();
  }
  
  public void c()
  {
    super.c();
    uqu localuqu = a();
    if ((localuqu != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)) {
      localuqu.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uug
 * JD-Core Version:    0.7.0.1
 */