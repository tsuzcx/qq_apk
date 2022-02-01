import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class lom
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
  
  private View b(int paramInt, Context paramContext, lie paramlie)
  {
    paramlie = paramlie.a();
    if ((paramlie != null) && (paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.a != null) && (paramlie.mSocialFeedInfo.a.kY != null) && (paramlie.mSocialFeedInfo.a.kY.size() > 0) && (ComponentContentGridImage.Q(paramlie.mSocialFeedInfo.a.kY.size(), paramlie.mSocialFeedInfo.aSG) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null) && (localArticleInfo.mSocialFeedInfo.a.kY != null) && (localArticleInfo.mSocialFeedInfo.a.kY.size() > 0) && (ComponentContentGridImage.Q(localArticleInfo.mSocialFeedInfo.a.kY.size(), localArticleInfo.mSocialFeedInfo.aSG) == 1))
    {
      c(paramInt1, paramlie, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
    paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramlie);
    paramNativeMiddleBodyView.setGalleryClickListener(new lor(this, paramlie, paramContainer, paramInt2));
  }
  
  private void b(Context paramContext, lie paramlie, int paramInt)
  {
    ndi.a locala = paramlie.b().a();
    paramlie = paramlie.a();
    if ((paramlie != null) && (locala != null)) {
      locala.a(paramContext, paramlie, 0, paramlie.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void c(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.getContent().setOnClickListener(new los(this, paramlie, paramContainer, paramInt2));
    ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
  }
  
  public int a(ArticleInfo paramArticleInfo, ndi paramndi)
  {
    return kvp.M(paramndi.nh(), kxm.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, lie paramlie, lsd paramlsd)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramlsd.CF())
      {
        paramContext.aQm = paramlsd.getComPaddingLeft();
        paramContext.aQn = paramlsd.getComPaddingRight();
      }
      return paramContext;
    case 16: 
    case 20: 
    case 83: 
    case 86: 
      return new PgcSmallView(paramInt, paramContext);
    case 17: 
    case 19: 
    case 32: 
    case 84: 
      return new ComponentContentPgcVideo(paramContext);
    case 18: 
      return new ComponentContentBig(paramContext);
    case 48: 
    case 64: 
    case 65: 
      return b(paramInt, paramContext, paramlie);
    case 29: 
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentBig(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    auvk.traceBegin("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    lku locallku = new lku();
    try
    {
      l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      auvk.traceBegin("PgcProteusItem.bindArticleComment");
      if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null) && (paramBaseArticleInfo.mSocialFeedInfo.a.aih != null)))) {
        locallku.p(paramBaseArticleInfo);
      }
      auvk.traceEnd();
      auvk.traceBegin("PgcProteusItem.bindReadArticle");
      if ((paramInt != 34) && (paramInt == 85)) {}
      auvk.traceEnd();
      if (paramInt == 29) {}
      auvk.traceBegin("PgcProteusItem.bindTopicCapsule");
      if (paramInt != 29) {
        locallku.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
      }
      auvk.traceEnd();
      auvk.traceBegin("PgcProteusItem.bindPublicAccountFollowButton");
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (ndi.R((ArticleInfo)paramBaseArticleInfo))) {
        locallku.h(paramBaseArticleInfo);
      }
      auvk.traceEnd();
      locallku.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      auvk.traceBegin("PgcProteusItem.bindMiddleBody");
      locallku.z(paramBaseArticleInfo);
      auvk.traceEnd();
      auvk.traceEnd();
      nxr.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
      return locallku.E();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        long l1 = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    long l = System.currentTimeMillis();
    auvk.traceBegin("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    c(paramlie, localViewBase);
    b(paramlie, localViewBase);
    b(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    auvk.traceBegin("PgcProteusItem.bindView.bindJumpChannel");
    lsy.e(localViewBase, paramlie);
    auvk.traceEnd();
    auvk.traceBegin("PgcProteusItem.bindView.bindSocialCommon");
    lsy.f(localViewBase, paramlie);
    auvk.traceEnd();
    auvk.traceBegin("PgcProteusItem.bindView.bindFlowGuideSperator");
    lsy.g(localViewBase, paramlie);
    auvk.traceEnd();
    auvk.traceEnd();
    nxr.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2, ViewBase paramViewBase)
  {
    auvk.traceBegin("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new lon(this, paramContainer, paramlie, paramInt2));
    }
    auvk.traceEnd();
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
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramlie);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new lop(this, paramlie));
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 31: 
    case 32: 
    case 83: 
    case 84: 
    case 86: 
      paramNativeMiddleBodyView.getContent().setOnClickListener(new loq(this, paramlie, localndi));
      ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, paramlie, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, lie paramlie, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (lrn)paramViewBase.findViewBaseByName("id_article_comment");
    auvk.traceBegin("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new loo(this, paramContainer, paramlie, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.setModel(paramlie);
    }
    auvk.traceEnd();
  }
  
  protected void b(lie paramlie, ViewBase paramViewBase)
  {
    auvk.traceBegin("PgcProteusItem.bindView.bindBiuTime");
    lsy.a(paramViewBase, paramlie.a());
    auvk.traceEnd();
  }
  
  protected void c(int paramInt1, Container paramContainer, lie paramlie, int paramInt2, ViewBase paramViewBase)
  {
    auvk.traceBegin("PgcProteusItem.bindView.findViewBaseByName");
    lsd locallsd = (lsd)paramViewBase.findViewBaseByName("id_middle_body_content");
    auvk.traceEnd();
    auvk.traceBegin("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (locallsd != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)locallsd.getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramlie, locallsd);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      locallsd.e(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      auvk.traceBegin("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramlie, localNativeMiddleBodyView, paramInt2, paramContainer);
      auvk.traceEnd();
      auvk.traceEnd();
      return;
    }
  }
  
  protected void c(lie paramlie, ViewBase paramViewBase)
  {
    lsy.i(paramViewBase, paramlie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lom
 * JD-Core Version:    0.7.0.1
 */