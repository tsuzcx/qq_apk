import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uvi
  extends uvh
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private List<usv> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public uvi(urv paramurv)
  {
    super(paramurv);
  }
  
  private usv a(List<usv> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (usv)paramList.get(i);
      if (localObject != null)
      {
        localObject = (stSimpleMetaFeed)((usv)localObject).a();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.jdField_a_of_type_JavaLangString))) {
          return (usv)paramList.remove(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  private void a(usv paramusv)
  {
    Object localObject = a();
    if ((paramusv == null) || (localObject == null) || (((urv)localObject).a() == null) || (((urv)localObject).a().a() == null)) {}
    do
    {
      do
      {
        return;
        uqf.d("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + ((urv)localObject).a().getItemCount());
        uek localuek = ((urv)localObject).a().a().jdField_a_of_type_Uek;
        if ((localuek instanceof utq)) {
          ((utq)localuek).b(paramusv);
        }
        localObject = (usv)((urv)localObject).a().a(0);
      } while (localObject == null);
      paramusv = (stSimpleMetaFeed)paramusv.a();
    } while (paramusv == null);
    if (paramusv.floatingLayerCardStyle != null) {
      paramusv.floatingLayerCardStyle.cardType = 3;
    }
    ((usv)localObject).a(paramusv);
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && (localObject != null))
    {
      localObject = ((urv)localObject).a();
      if ((localObject != null) && (((WSPlayerManager)localObject).e()))
      {
        uqf.d("terry_ark", "WSVerticalForArkCardPresenter isPlayError");
        return true;
      }
    }
    return false;
  }
  
  public List<usv> a(ArrayList paramArrayList)
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
    uqf.d("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    urv localurv = a();
    if (localurv == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramViewHolder instanceof uuy));
      paramViewHolder = (uuy)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      uhe localuhe = new uhe(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      wjj.a().dispatch(localuhe);
    } while (paramViewHolder.jdField_a_of_type_JavaLangObject == null);
    localurv.b(((usv)paramViewHolder.jdField_a_of_type_JavaLangObject).a());
  }
  
  public void a(List<usv> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (a(paramBoolean2))
    {
      ((urv)localObject).a().a(paramList);
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      return;
    }
    if (paramBoolean2) {}
    for (localObject = a(paramList);; localObject = null)
    {
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      a((usv)localObject);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    return a(paramBoolean2);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    uqf.d("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + paramBoolean1 + " isFirst = " + paramBoolean2 + " from = " + paramString);
    paramString = a();
    if ((paramString != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null))
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilList = paramString.a();
      }
      usg.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id, 10007, paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaUtilList, this, null);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    usg.a().a();
  }
  
  public void c()
  {
    super.c();
    urv localurv = a();
    if ((localurv != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)) {
      localurv.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvi
 * JD-Core Version:    0.7.0.1
 */