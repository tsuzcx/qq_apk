import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class uha
  implements qdh
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public uha(ugx paramugx) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    qhk localqhk = new qhk(this.jdField_a_of_type_Ugx.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Ugx.b(), this.jdField_a_of_type_Ugx.c(), paramInt2, this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.d(), null, this.jdField_a_of_type_Ugx.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      piv.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.a(), localqhk, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      uda.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Ugx.a();
        paramView.a().setTag(2131369656, paramArticleInfo);
        paramView.setTag(2131381183, localqhk);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      uda.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      piv.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.a(), localqhk, paramInt2, "default_feeds");
      uda.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Ugx.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Ugx.a());
        piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new qhk(this.jdField_a_of_type_Ugx.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Ugx.b(), this.jdField_a_of_type_Ugx.c(), paramInt2, this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.d(), null, this.jdField_a_of_type_Ugx.a());
    View localView = rbm.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.a(), this.jdField_a_of_type_Ugx.a());
    if (localView != null)
    {
      localView.setTag(2131381183, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369656, this.jdField_a_of_type_Ugx.a());
      if (paramArticleInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != 1)
          {
            paramView.height = 1;
            localView.setLayoutParams(paramView);
          }
        }
        if (localView != null) {
          break label410;
        }
        paramInt1 = 0;
        label256:
        localObject = this.jdField_a_of_type_Ugx.c() + "";
        if (paramArticleInfo == null) {
          break label415;
        }
      }
    }
    label410:
    label415:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      olh.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Ugx.b() + "", "", false);
      return localView;
      if (localView.getVisibility() != 0) {
        localView.setVisibility(0);
      }
      if (!(localView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
        break;
      }
      paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (paramView.height == -2) {
        break;
      }
      paramView.height = -2;
      localView.setLayoutParams(paramView);
      break;
      QLog.w("AdHandler", 1, "CellFactory.getView = null");
      break;
      paramInt1 = 1;
      break label256;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public spk a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      qhk localqhk = (qhk)this.jdField_a_of_type_AndroidViewView.getTag(2131381183);
      if (localqhk != null)
      {
        Object localObject = localqhk.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localqhk.a() == 6) || (localqhk.a() == 66) || (localqhk.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          szd localszd = this.jdField_a_of_type_Ugx.a();
          if ((localszd != null) && (localszd.a() != null) && (localszd.a() != null)) {
            return localszd.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, localqhk);
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (qhk)this.jdField_a_of_type_AndroidViewView.getTag(2131381183);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(uvp.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    szd localszd;
    do
    {
      return false;
      localszd = this.jdField_a_of_type_Ugx.a();
    } while ((localszd == null) || (localszd.a() == null) || (localszd.a() == null));
    paramView = localszd.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((ukr.a((AdvertisementInfo)localObject, null, localszd.a(), 1)) && (localszd.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */