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
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONException;
import org.json.JSONObject;

public class lmx
  implements lpi
{
  private void c(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramViewBase == null) || (paramlie == null) || (paramlie.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new lmy(this, paramlie.a(), localContext));
  }
  
  protected View a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 25: 
    case 81: 
      return new ComponentContentUgcImage(paramContext);
    case 37: 
      return new ComponentContentGridImage(paramContext);
    case 26: 
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
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.uin;
      }
    }
    JSONObject localJSONObject = new lku().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).y(paramBaseArticleInfo).A(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).a("ReadInjoy_biu_cell").E(paramBaseArticleInfo).B(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).F(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo).O(paramBaseArticleInfo).P(paramBaseArticleInfo).E();
    kni.a(paramBaseArticleInfo, localJSONObject, 2);
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject2 = (lsd)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localObject2 != null)
    {
      localObject1 = (NativeMiddleBodyView)((lsd)localObject2).getNativeView();
      if (((NativeMiddleBodyView)localObject1).getContent() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ((lsd)localObject2).e(localLayoutParams);
        localObject2 = a(paramInt1, paramContainer.getContext());
        if (localObject2 != null) {
          ((NativeMiddleBodyView)localObject1).a((View)localObject2, localLayoutParams);
        }
      }
      a(paramInt1, paramlie, (NativeMiddleBodyView)localObject1);
    }
    lsy.i(localViewBase, paramlie);
    Object localObject1 = (lrp)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((lrp)localObject1).setModel(paramlie);
    }
    localObject1 = (lsw)localViewBase.findViewBaseByName("id_summary");
    if (localObject1 != null) {
      ((lsw)localObject1).setModel(paramlie);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    lsy.a(localViewBase, paramlie.a());
    llu.a(localViewBase, paramlie);
    c(localViewBase, paramlie);
    llu.b(localViewBase, paramlie);
    lsy.e(localViewBase, paramlie);
    lsy.f(localViewBase, paramlie);
    kni.a(paramlie, localViewBase, paramContainer, paramInt1);
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
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.getContent()).P(paramlie);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramlie);
      paramNativeMiddleBodyView.P(ComponentContentGridImage.a(paramlie.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new lmz(this, paramlie, localndi));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.P(paramlie);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new lna(this, paramlie, localndi));
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
 * Qualified Name:     lmx
 * JD-Core Version:    0.7.0.1
 */