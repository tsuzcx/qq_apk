import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONException;
import org.json.JSONObject;

public class lps
  implements lpi
{
  protected View a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 22: 
    case 80: 
      return new ComponentContentUgcImage(paramContext);
    case 36: 
      return new ComponentContentGridImage(paramContext);
    case 23: 
    case 120: 
      return new ComponentContentUgcVideo(paramContext);
    }
    return new ComponentContentUGCVoice(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.cuin;
      }
    }
    return new lku().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).q(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).y(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).D(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).H(paramBaseArticleInfo).L(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo).O(paramBaseArticleInfo).P(paramBaseArticleInfo).E();
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    lsd locallsd = (lsd)localViewBase.findViewBaseByName("id_middle_body_content");
    if (locallsd != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)locallsd.getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        locallsd.e(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramlie, localNativeMiddleBodyView);
    }
    lsy.i(localViewBase, paramlie);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (lrn)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null) {
      paramContainer.setModel(paramlie);
    }
    lsy.a(localViewBase, paramlie.a());
    llu.a(localViewBase, paramlie);
    lsy.e(localViewBase, paramlie);
    lsy.f(localViewBase, paramlie);
  }
  
  protected void a(int paramInt, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.getContent() == null) || (paramlie.b() == null)) {
      return;
    }
    ndi localndi = paramlie.b();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 22: 
    case 80: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.getContent()).P(paramlie);
      return;
    case 36: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramlie);
      paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new lpt(this, paramlie, localndi));
      return;
    case 23: 
    case 120: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.P(paramlie);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new lpu(this, paramInt, localndi, paramlie));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.getContent()).P(paramlie);
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lps
 * JD-Core Version:    0.7.0.1
 */