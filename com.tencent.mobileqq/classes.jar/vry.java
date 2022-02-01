import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vry
  extends vrx
{
  private static final int b = ScreenUtil.dip2px(42.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private List<vpj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean c;
  
  public vry(voi paramvoi)
  {
    super(paramvoi);
  }
  
  private String a(Object paramObject)
  {
    if ((paramObject instanceof vov)) {
      return ((vov)paramObject).b;
    }
    return "";
  }
  
  private vpj a(List<vpj> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (vpj)paramList.get(i);
      if (localObject != null)
      {
        localObject = (stSimpleMetaFeed)((vpj)localObject).a();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.jdField_a_of_type_JavaLangString))) {
          return (vpj)paramList.remove(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  private void a(int paramInt, voi paramvoi)
  {
    if ((paramInt == 1) && (this.c))
    {
      paramvoi = paramvoi.a();
      if (paramvoi != null)
      {
        this.c = false;
        paramvoi.a(paramvoi.b().get(0));
      }
    }
  }
  
  private void a(voi paramvoi, String paramString)
  {
    if ((paramvoi == null) || (paramvoi.c()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramvoi = QQToast.a(BaseApplicationImpl.getContext(), paramString, 1);
    paramvoi.b(4);
    paramvoi.a(QQToast.a(4));
    paramvoi.a();
    vmp.e("WSVerticalForArkCardPresenter", "[WSVerticalForArkCardPresenter.java][showToast] toastTips:" + paramString);
  }
  
  private void a(voi paramvoi, boolean paramBoolean)
  {
    if ((paramvoi instanceof WSVerticalPageFragment))
    {
      paramvoi = ((WSVerticalPageFragment)paramvoi).a();
      if (paramvoi != null) {}
    }
    else
    {
      return;
    }
    paramvoi.f(paramBoolean);
    paramvoi.e(paramBoolean);
  }
  
  private void a(vpj paramvpj)
  {
    voi localvoi = a();
    Object localObject;
    vrn localvrn;
    if ((paramvpj != null) && (localvoi != null))
    {
      localObject = localvoi.a();
      if (localObject != null)
      {
        localvrn = ((vnw)localObject).a();
        if (localvrn != null) {
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
        vmp.d("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + ((vnw)localObject).getItemCount());
        uyx localuyx = localvrn.jdField_a_of_type_Uyx;
        if ((localuyx instanceof vqe)) {
          ((vqe)localuyx).b(paramvpj);
        }
        localObject = (vpj)((vnw)localObject).a(0);
      } while (localObject == null);
      paramvpj = (stSimpleMetaFeed)paramvpj.a();
    } while (paramvpj == null);
    if (paramvpj.floatingLayerCardStyle != null) {
      paramvpj.floatingLayerCardStyle.cardType = 3;
    }
    ((vpj)localObject).a(paramvpj);
    if (localvrn.jdField_a_of_type_Vgb != null) {
      localvrn.jdField_a_of_type_Vgb.a = vgd.a(paramvpj);
    }
    a(localvoi, paramvpj.isLoop);
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramObject instanceof vov))
    {
      paramObject = (vov)paramObject;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))) {
        break label92;
      }
    }
    label92:
    for (bool1 = bool2;; bool1 = false)
    {
      vmp.e("WSVerticalForArkCardPresenter", "[isIntentFeedVideoInvalid] isInvalid:" + bool1 + ", mIntentFeedId:" + this.jdField_a_of_type_JavaLangString + ", params.mFeedId:" + paramObject.jdField_a_of_type_JavaLangString);
      return bool1;
    }
  }
  
  private boolean a(List<vpj> paramList)
  {
    paramList = (vpj)paramList.get(0);
    if ((paramList != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && ((paramList.a() instanceof stSimpleMetaFeed)))
    {
      paramList = (stSimpleMetaFeed)paramList.a();
      boolean bool = TextUtils.equals(paramList.video_url, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url);
      vmp.d("WSVerticalForArkCardPresenter", "[isSameUrlForArkAndFirstFeed] isSame:" + bool + ", intentUrl:" + this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url + ", firstUrl:" + paramList.video_url);
      return bool;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, List<vpj> paramList)
  {
    if ((paramBoolean) && (!a(paramList))) {
      return d();
    }
    return false;
  }
  
  private void b(voi paramvoi)
  {
    if (!(paramvoi instanceof WSVerticalPageFragment)) {
      return;
    }
    ((WSVerticalPageFragment)paramvoi).f();
  }
  
  private boolean d()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((voi)localObject).a();
      if ((localObject != null) && ((((WSPlayerManager)localObject).e()) || ((!((WSPlayerManager)localObject).c()) && (!((WSPlayerManager)localObject).b()))))
      {
        vmp.d("WSVerticalForArkCardPresenter", "[isFirstVideoPlayInvalid] state:" + ((WSPlayerManager)localObject).a());
        return true;
      }
    }
    return false;
  }
  
  public List<vpj> a(ArrayList paramArrayList)
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
    vmp.d("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    voi localvoi = a();
    if (localvoi == null) {
      return;
    }
    if ((paramViewHolder instanceof vrn))
    {
      paramViewHolder = (vrn)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      vbv localvbv = new vbv(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      wad.a().dispatch(localvbv);
      if (paramViewHolder.jdField_a_of_type_JavaLangObject != null) {
        localvoi.b(((vpj)paramViewHolder.jdField_a_of_type_JavaLangObject).a());
      }
    }
    a(paramInt, localvoi);
  }
  
  public void a(blij<vpj> paramblij, int paramInt)
  {
    super.a(paramblij, paramInt);
    if ((paramInt == 1) && (this.c)) {
      b(a());
    }
  }
  
  public void a(List<vpj> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (paramBoolean2)
    {
      boolean bool = a(paramObject);
      this.c = bool;
      if (bool)
      {
        super.a(paramList, paramBoolean1, true, paramObject);
        a((voi)localObject, a(paramObject));
        return;
      }
    }
    if (a(paramBoolean2, paramList))
    {
      super.a(paramList, paramBoolean1, true, paramObject);
      return;
    }
    if (paramBoolean2) {}
    for (localObject = a(paramList);; localObject = null)
    {
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      a((vpj)localObject);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    vmp.d("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + paramBoolean1 + " isFirst = " + paramBoolean2 + " from = " + paramString);
    paramString = a();
    if ((paramString != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null))
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilList = paramString.a();
      }
      vot.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id, 10007, paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaUtilList, this, null);
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<vpj> paramList, Object paramObject)
  {
    if (a(paramObject)) {
      return false;
    }
    return a(paramBoolean2, paramList);
  }
  
  public int b()
  {
    return b;
  }
  
  public void b()
  {
    super.b();
    vot.a().a();
  }
  
  public void c()
  {
    super.c();
    voi localvoi = a();
    if ((localvoi != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)) {
      localvoi.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vry
 * JD-Core Version:    0.7.0.1
 */