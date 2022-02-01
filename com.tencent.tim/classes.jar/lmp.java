import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class lmp
  implements lpi
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ndi paramndi)
  {
    int i = a(paramArticleInfo, paramndi);
    paramndi = paramndi.a();
    if (paramndi != null) {
      paramndi.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, lie paramlie, int paramInt)
  {
    ndi.a locala = paramlie.b().a();
    paramlie = paramlie.a();
    if ((paramlie != null) && (locala != null)) {
      locala.a(paramContext, paramlie, 0, paramlie.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private View b(int paramInt, Context paramContext, lie paramlie)
  {
    paramlie = paramlie.a();
    if ((paramlie != null) && (paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size() > 0) && (ComponentContentGridImage.Q(paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size(), paramlie.mSocialFeedInfo.aSG) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size() > 0) && (ComponentContentGridImage.Q(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size(), localArticleInfo.mSocialFeedInfo.aSG) == 1))
    {
      c(paramInt1, paramlie, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.getContent() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramlie);
      paramNativeMiddleBodyView.setGalleryClickListener(new lmu(this, paramlie, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + paramlie.a());
  }
  
  private void c(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.getContent() instanceof AdapterView)) {
      paramNativeMiddleBodyView.getContent().setOnClickListener(new lmv(this, paramlie, paramContainer, paramInt2));
    }
    ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
  }
  
  private void c(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramViewBase == null) || (paramlie == null) || (paramlie.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    ndi localndi = paramlie.b();
    paramViewBase.getNativeView().setOnClickListener(new lmw(this, localndi, paramlie));
  }
  
  public int a(ArticleInfo paramArticleInfo, ndi paramndi)
  {
    return kvp.M(paramndi.nh(), kxm.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, lie paramlie)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 35: 
    case 114: 
      return new ComponentContentGridImage(paramContext);
    case 49: 
    case 62: 
    case 63: 
      return b(paramInt, paramContext, paramlie);
    case 10: 
    case 12: 
    case 94: 
    case 95: 
      return new PgcSmallView(paramInt, paramContext);
    case 11: 
    case 28: 
      return new ComponentContentPgcVideo(paramContext);
    case 27: 
      return new ComponentContentBig(paramContext);
    case 113: 
      return new ComponentPGCShortContentBig(paramContext);
    case 33: 
      return new ComponentContentBig(paramContext);
    }
    return null;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    Object localObject = new lku();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
    }
    if (((paramInt != 35) || (paramBaseArticleInfo.isPGCShortContent())) || ((paramInt != 33) || (paramInt != 33))) {
      ((lku)localObject).A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      ((lku)localObject).o(paramBaseArticleInfo);
      ((lku)localObject).a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        ((lku)localObject).z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label315;
      }
      ((lku)localObject).a("ReadInjoy_biu_small_pgc_cell");
      label254:
      localObject = ((lku)localObject).E();
      if (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_cell")) {
        break label327;
      }
      kni.a(paramBaseArticleInfo, (JSONObject)localObject, 2);
    }
    label315:
    label327:
    while (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_small_pgc_cell"))
    {
      return localObject;
      if ((!paramBaseArticleInfo.mSocialFeedInfo.DB()) || (kvm.i(paramBaseArticleInfo))) {
        break;
      }
      ((lku)localObject).o(paramBaseArticleInfo);
      break;
      ((lku)localObject).a("ReadInjoy_biu_cell");
      break label254;
    }
    kni.a(paramBaseArticleInfo, (JSONObject)localObject, 1);
    return localObject;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    lsd locallsd = (lsd)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (locallsd != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)locallsd.getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramlie);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label319;
        }
      }
    }
    label319:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      locallsd.e((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, paramlie, localNativeMiddleBodyView, paramInt2, paramContainer);
      lsy.i(localViewBase, paramlie);
      localObject = (lrp)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((lrp)localObject).setModel(paramlie);
      }
      localObject = (lsw)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((lsw)localObject).setModel(paramlie);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((lsw)localObject).setOnClickListener(new lmq(this, paramContainer, paramlie, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new lmr(this, paramContainer, paramlie, paramInt2));
      }
      lsy.a(localViewBase, paramlie.a());
      c(localViewBase, paramlie);
      llu.a(localViewBase, paramlie);
      llu.b(localViewBase, paramlie);
      lsy.e(localViewBase, paramlie);
      lsy.f(localViewBase, paramlie);
      lsy.g(localViewBase, paramlie);
      kni.a(paramlie, localViewBase, paramContainer, paramInt1);
      return;
    }
  }
  
  protected void a(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.getContent() == null) || (paramlie.b() == null)) {
      return;
    }
    ndi localndi = paramlie.b();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramlie);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new lms(this, paramlie));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 27: 
    case 28: 
    case 33: 
    case 94: 
    case 95: 
    case 112: 
    case 113: 
      if ((paramNativeMiddleBodyView.getContent() instanceof AdapterView))
      {
        wja.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + paramlie.a()));
        return;
      }
      paramNativeMiddleBodyView.getContent().setOnClickListener(new lmt(this, localndi, paramlie));
      ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
      return;
    }
    b(paramInt1, paramlie, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmp
 * JD-Core Version:    0.7.0.1
 */