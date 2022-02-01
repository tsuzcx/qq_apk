import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.b;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.b.a;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class lmf
  implements lpi
{
  public static ComponentContentGridImage.b a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 0) {
      return new ComponentContentGridImage.b.a().a();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    SocializeFeedsInfo.s locals;
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.la != null) && (paramArticleInfo.mSocialFeedInfo.a.la.size() >= 1))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a.la.iterator();
      if (paramArticleInfo.hasNext()) {
        locals = (SocializeFeedsInfo.s)paramArticleInfo.next();
      }
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i == paramInt) {
          return new ComponentContentGridImage.b.a().a(localArrayList1).b(localArrayList2).a();
        }
        i = locals.pic_width;
        int j = locals.pic_height;
        URL localURL = new URL(locals.aii);
        if (locals.aSX != 1) {
          break label270;
        }
        bool = true;
        localArrayList1.add(new SquareCornerTextImageView.a(i, j, localURL, bool));
        localArrayList2.add(new URL(locals.pic_url));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AnswerProteusItem", 2, "Malformed URL: " + localMalformedURLException.getMessage());
      break;
      label270:
      boolean bool = false;
    }
  }
  
  public static int e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.la != null)) {
      return paramArticleInfo.mSocialFeedInfo.a.la.size();
    }
    return 0;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    long l = 0L;
    if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.a.cuin;
    }
    JSONObject localJSONObject = new lku().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).D(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).I(paramBaseArticleInfo).a(paramBaseArticleInfo, "").E();
    if (!kvm.h(paramBaseArticleInfo)) {}
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (lsd)localViewBase.findViewBaseByName("id_middle_body_content");
    lmg locallmg = new lmg(this, paramlie, paramContainer);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((lsd)localObject1).getNativeView();
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).getContent() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((lsd)localObject1).e((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        paramContainer = (ViewGroup)((NativeMiddleBodyView)localObject2).getContent();
        localObject2 = paramlie.a();
        paramInt1 = e((ArticleInfo)localObject2);
        localObject2 = a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label313;
        }
        paramContainer.setVisibility(8);
        ((lsd)localObject1).setOnClickListener(locallmg);
      }
    }
    lsy.a(localViewBase, paramlie.a());
    lsy.i(localViewBase, paramlie);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (lrn)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null)
    {
      localObject1 = (NativeCommentView)paramContainer.getNativeView();
      ((NativeCommentView)localObject1).akP = true;
      paramContainer.setModel(paramlie);
      ((NativeCommentView)localObject1).setShouldCallClick(true);
      paramContainer.setOnClickListener(locallmg);
    }
    llu.a(localViewBase, paramlie);
    lsy.f(localViewBase, paramlie);
    return;
    label313:
    paramContainer.setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)paramContainer.getChildAt(0);
    paramContainer = (ComponentContentUgcImage)paramContainer.getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      paramContainer.setVisibility(0);
      paramContainer.P(paramlie);
    }
    for (;;)
    {
      paramContainer.setPicClickListener(new lmh(this, paramlie));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramlie);
      paramContainer.setVisibility(8);
      ((ComponentContentGridImage)localObject3).P(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmf
 * JD-Core Version:    0.7.0.1
 */