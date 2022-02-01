import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loj
  implements lpi
{
  private lku a(lku paramlku, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramlku;
    int i;
    if (paramBaseArticleInfo != null)
    {
      localObject = paramlku;
      if (paramBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = paramlku;
        if (paramBaseArticleInfo.mGroupSubArticleList.size() > 0)
        {
          QLog.d("PackProteusItem", 2, "mGroupSubArticleList: " + paramBaseArticleInfo.mGroupSubArticleList.size());
          localObject = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
          i = i((BaseArticleInfo)localObject);
          localObject = c((ArticleInfo)localObject, paramInt);
        }
      }
    }
    try
    {
      paramlku.a("jump_url", localObject);
      if (i == 1)
      {
        localObject = b(paramlku, paramInt, paramBaseArticleInfo);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 1, "[buildProteusCollectionView], e = " + localJSONException);
        }
        lku locallku = paramlku;
      } while (i != 2);
    }
    return c(paramlku, paramInt, paramBaseArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, lie paramlie)
  {
    if ((paramArticleInfo == null) || (paramViewBase == null) || (paramlie == null))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
      return;
    }
    paramViewBase = (ltp)paramViewBase.findViewBaseByName("id_proteus_collection_view");
    if (paramViewBase == null)
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], proteus_collection_view is null.");
      return;
    }
    List localList = paramArticleInfo.mGroupSubArticleList;
    if ((localList == null) || (localList.isEmpty()))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], dataList is empty");
      return;
    }
    paramViewBase.a(new lol(this, localList, paramArticleInfo, paramlie));
  }
  
  private void a(lie paramlie, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (paramlie.nh() == 56)
    {
      paramComponentPolymericView.setDividerWidth(wja.dp2px(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(aqcx.dip2px(paramContext, 6.0F), 0, aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 5.0F));
    }
    for (;;)
    {
      paramComponentPolymericView.setClipToPadding(false);
      paramComponentPolymericView.setClipChildren(false);
      return;
      paramComponentPolymericView.setDividerWidth(wja.dp2px(3.0F, paramContext.getResources()));
      if (kxm.v(paramlie.a())) {
        paramComponentPolymericView.setPadding(aqcx.dip2px(paramContext, 6.0F), 0, aqcx.dip2px(paramContext, 12.0F), aqcx.dip2px(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(aqcx.dip2px(paramContext, 6.0F), 0, aqcx.dip2px(paramContext, 12.0F), 0);
      }
    }
  }
  
  private lku b(lku paramlku, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      llu.a(paramBaseArticleInfo, paramInt, localJSONArray);
      paramlku.a("datas", localJSONArray);
      return paramlku;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramlku;
  }
  
  private String c(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null)
    {
      QLog.i("PackProteusItem", 1, "[getJumpUrl], articleInfo is null.");
      return "";
    }
    Object localObject3 = "";
    long l2 = 0L;
    long l1;
    Object localObject1;
    if ((ndi.K(paramArticleInfo)) || (ndi.R(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
        localObject1 = kwt.acJ + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramArticleInfo.mSubscribeID))) {
          break label376;
        }
        try
        {
          l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException paramArticleInfo)
        {
          QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + paramArticleInfo);
          continue;
        }
        localObject3 = kwt.acJ + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        QLog.i("PackProteusItem", 1, "[getJumpUlr], url = " + (String)localObject3 + ", uin = " + l2);
        return localObject3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + localNumberFormatException);
        l1 = l2;
        continue;
      }
      Object localObject2;
      if (!ndi.ak(paramArticleInfo))
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramInt != 76) {}
      }
      else
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
            localObject2 = kwt.acF + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label376:
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null))
            {
              l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
              localObject3 = kwt.acF + aqgo.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localObject2;
              if (paramArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localObject2;
                if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null)
                {
                  l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
                  localObject3 = kwt.acF + aqgo.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private lku c(lku paramlku, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      llu.b(paramBaseArticleInfo, paramInt, localJSONArray);
      paramlku.a("datas", localJSONArray);
      return paramlku;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramlku;
  }
  
  private void d(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramViewBase == null) || (paramlie == null) || (paramlie.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new lok(this, paramlie.a(), localContext));
  }
  
  public static int i(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    switch (paramBaseArticleInfo.mNewPolymericInfo.aRX)
    {
    default: 
      if (!kxm.l(paramBaseArticleInfo)) {
        break;
      }
    }
    while ((kxm.n(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSinglePicture != null))
    {
      return 2;
      return 1;
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
    lku locallku = new lku();
    if (paramBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return locallku.c(paramBaseArticleInfo).j(paramBaseArticleInfo).r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_topic_cell").E();
    }
    if ((kxm.x(paramBaseArticleInfo)) || (kxm.y(paramBaseArticleInfo))) {
      return locallku.r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").E();
    }
    long l2;
    if (paramInt == 76)
    {
      l2 = l1;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        l2 = l1;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null) {
          l2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
        }
      }
      paramBaseArticleInfo = a(locallku, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l2).g(paramBaseArticleInfo).f(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").E();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    if ((paramInt == 77) || (paramInt == 78))
    {
      try
      {
        l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 2, "newpolymeric card pgc parse uin error uin = " + 0L + " error = " + localNumberFormatException);
        }
      }
      paramBaseArticleInfo = a(locallku, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).g(paramBaseArticleInfo).d(paramBaseArticleInfo).h(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").E();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    QLog.e("PackProteusItem", 2, "newpolymeric card wrong articleinfo and viewType articleinfo = " + paramBaseArticleInfo);
    return null;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (lsd)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localObject != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)((lsd)localObject).getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        ComponentPolymericPullAnimatorView localComponentPolymericPullAnimatorView = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), paramlie);
        if ((localComponentPolymericPullAnimatorView == null) || (!(localComponentPolymericPullAnimatorView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label198;
        }
        localObject = (RelativeLayout.LayoutParams)localComponentPolymericPullAnimatorView.getLayoutParams();
        if (localComponentPolymericPullAnimatorView != null)
        {
          a(paramlie, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localComponentPolymericPullAnimatorView).a());
          localNativeMiddleBodyView.a(localComponentPolymericPullAnimatorView, (RelativeLayout.LayoutParams)localObject);
        }
      }
      a(paramlie, localNativeMiddleBodyView);
    }
    else
    {
      paramContainer = paramlie.a();
      if (kxm.E(paramContainer)) {
        break label213;
      }
      lsy.i(localViewBase, paramlie);
      lsy.a(localViewBase, paramlie.a());
      if (paramInt1 == 76) {
        llu.a(localViewBase, paramlie);
      }
    }
    for (;;)
    {
      localObject = localViewBase.findViewBaseByName("id_proteus_collection_view");
      if ((localObject instanceof ltp)) {
        ((ltp)localObject).setModel(paramlie);
      }
      a(localViewBase, paramContainer, paramlie);
      return;
      label198:
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      break;
      label213:
      d(localViewBase, paramlie);
      if (((NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time") != null) && (paramContainer.mTopicRecommendFeedsInfo != null) && (paramContainer.mTopicRecommendFeedsInfo.ld != null) && (paramContainer.mTopicRecommendFeedsInfo.ld.size() > 0))
      {
        localObject = (mih.b)paramContainer.mTopicRecommendFeedsInfo.ld.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("PackProteusItem", 2, "PackProteusItem update articleInfo UI articleID = " + paramContainer.mArticleID + ", mRecommendSeq =" + paramContainer.mRecommendSeq + "，followType=" + ((mih.b)localObject).isFollow);
        }
      }
    }
  }
  
  protected void a(lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.getContent() == null) || (paramlie.b() == null)) {
      return;
    }
    paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.getContent();
    paramNativeMiddleBodyView.aOB();
    paramNativeMiddleBodyView.a().P(paramlie);
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     loj
 * JD-Core Version:    0.7.0.1
 */