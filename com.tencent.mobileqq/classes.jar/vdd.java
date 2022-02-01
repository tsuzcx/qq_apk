import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vdd
  extends vdc
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private List<vaq> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public vdd(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  private vaq a(List<vaq> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (vaq)paramList.get(i);
      if (localObject != null)
      {
        localObject = (stSimpleMetaFeed)((vaq)localObject).a();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.jdField_a_of_type_JavaLangString))) {
          return (vaq)paramList.remove(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  private void a(uzq paramuzq, boolean paramBoolean)
  {
    if ((paramuzq instanceof WSVerticalPageFragment))
    {
      paramuzq = ((WSVerticalPageFragment)paramuzq).a();
      if (paramuzq != null) {}
    }
    else
    {
      return;
    }
    paramuzq.f(paramBoolean);
    paramuzq.e(paramBoolean);
  }
  
  private void a(vaq paramvaq)
  {
    uzq localuzq = a();
    Object localObject;
    vct localvct;
    if ((paramvaq != null) && (localuzq != null))
    {
      localObject = localuzq.a();
      if (localObject != null)
      {
        localvct = ((uze)localObject).a();
        if (localvct != null) {
          break label37;
        }
      }
    }
    label37:
    do
    {
      do
      {
        return;
        uya.d("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + ((uze)localObject).getItemCount());
        ula localula = localvct.jdField_a_of_type_Ula;
        if ((localula instanceof vbl)) {
          ((vbl)localula).b(paramvaq);
        }
        localObject = (vaq)((uze)localObject).a(0);
      } while (localObject == null);
      paramvaq = (stSimpleMetaFeed)paramvaq.a();
    } while (paramvaq == null);
    if (paramvaq.floatingLayerCardStyle != null) {
      paramvaq.floatingLayerCardStyle.cardType = 3;
    }
    ((vaq)localObject).a(paramvaq);
    if (localvct.jdField_a_of_type_Urt != null) {
      localvct.jdField_a_of_type_Urt.a = urv.a(paramvaq);
    }
    a(localuzq, paramvaq.isLoop);
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && (localObject != null))
    {
      localObject = ((uzq)localObject).a();
      if ((localObject != null) && (((WSPlayerManager)localObject).e()))
      {
        uya.d("terry_ark", "WSVerticalForArkCardPresenter isPlayError");
        return true;
      }
    }
    return false;
  }
  
  public List<vaq> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)paramArrayList.get(0));
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id;
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.isLoop = true;
      }
      return WSVerticalDataManager.a().a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    uya.d("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    uzq localuzq = a();
    if (localuzq == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramViewHolder instanceof vct));
      paramViewHolder = (vct)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      unv localunv = new unv(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      vli.a().dispatch(localunv);
    } while (paramViewHolder.jdField_a_of_type_JavaLangObject == null);
    localuzq.b(((vaq)paramViewHolder.jdField_a_of_type_JavaLangObject).a());
  }
  
  public void a(List<vaq> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (a(paramBoolean2))
    {
      ((uzq)localObject).a().a(paramList);
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      return;
    }
    if (paramBoolean2) {}
    for (localObject = a(paramList);; localObject = null)
    {
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      a((vaq)localObject);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    return a(paramBoolean2);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    uya.d("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + paramBoolean1 + " isFirst = " + paramBoolean2 + " from = " + paramString);
    paramString = a();
    if ((paramString != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null))
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilList = paramString.a();
      }
      vab.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id, 10007, paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaUtilList, this, null);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    vab.a().a();
  }
  
  public void c()
  {
    super.c();
    uzq localuzq = a();
    if ((localuzq != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)) {
      localuzq.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdd
 * JD-Core Version:    0.7.0.1
 */