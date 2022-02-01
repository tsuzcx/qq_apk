import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;

public class lnb
  implements lpi
{
  private void a(View paramView, Activity paramActivity, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramActivity == null)) {
      return;
    }
    paramView.setAlpha(1.0F);
    QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772378);
    Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772379);
    localAnimation1.setFillAfter(true);
    localAnimation1.setAnimationListener(new lnc(this, paramView, localAnimation2));
    localAnimation2.setAnimationListener(new lnd(this, paramView, paramBoolean, paramActivity, paramArticleInfo));
    paramView.startAnimation(localAnimation1);
    lbz.a().i(paramArticleInfo);
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label226;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("video_image_url", str);
        paramJSONObject.put("video_duration", kwz.ba(paramBaseArticleInfo.mVideoDuration));
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {}
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).aHc != 0)
          {
            localObject = ((VideoColumnInfo)localObject).columnName;
            continue;
          }
        }
        localObject = null;
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      continue;
      label226:
      String str = null;
    }
  }
  
  private void a(Container paramContainer, lie paramlie)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new lne(this, paramlie, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new lnf(this, paramlie, paramContainer));
    }
  }
  
  private static void ao(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
        paramJSONObject.put("middle_content_cover_img_url", paramBaseArticleInfo.mFirstPagePicUrl);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) {
          paramJSONObject.put("middle_content_txt", paramBaseArticleInfo.mTitle);
        }
        QLog.d("CommentBiuProteusItem", 1, "coverImgUrl=" + paramBaseArticleInfo.mFirstPagePicUrl + ", middle_content_txt=" + paramBaseArticleInfo.mTitle);
        return;
        paramJSONObject.put("middle_content_cover_default_img", "article_no_img");
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("CommentBiuProteusItem", 1, "getImageDatmiddle_content_cover_img_urlaJson error, msg=" + paramBaseArticleInfo);
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY != null))
        {
          i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size();
          break label142;
          QLog.d("CommentBiuProteusItem", 1, "getShortContentDataJson,count=" + i);
        }
        else
        {
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
          {
            i = j;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la != null) {
              i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size();
            }
          }
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      label142:
      if ((i <= 0) || (paramMobileQQ == null)) {}
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    Object localObject1 = new JSONObject();
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null))
    {
      QLog.d("CommentBiuProteusItem", 1, "getDataJson error!");
      return localObject1;
    }
    Object localObject2 = kxm.getAppRuntime();
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getApplication();
    }
    localObject2 = new lku();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
    }
    ((lku)localObject2).v(paramBaseArticleInfo).a("RIJ_biucomment_with_social_header").n(paramBaseArticleInfo).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).b(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).w(paramBaseArticleInfo).u(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).a(paramBaseArticleInfo, "");
    if ("RIJ_biucomment_without_social_header".equals("RIJ_biucomment_with_social_header")) {
      ((lku)localObject2).b(paramBaseArticleInfo, "id_bottom_dislike_button");
    }
    while ((paramBaseArticleInfo.isPGCShortContent()) || (kxm.I(paramBaseArticleInfo)))
    {
      localObject2 = ((lku)localObject2).o(paramBaseArticleInfo).E();
      b(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
      ((lku)localObject2).j(paramBaseArticleInfo);
    }
    if (kxm.J(paramBaseArticleInfo))
    {
      localObject2 = ((lku)localObject2).o(paramBaseArticleInfo).E();
      a(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
    }
    if (kxm.H(paramBaseArticleInfo))
    {
      localObject1 = ((lku)localObject2).E();
      ao(paramBaseArticleInfo, (JSONObject)localObject1);
      return localObject1;
    }
    localObject1 = new JSONObject();
    QLog.d("CommentBiuProteusItem", 1, "error! no type find!,info=" + paramBaseArticleInfo);
    return localObject1;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    for (;;)
    {
      try
      {
        ViewBase localViewBase = paramContainer.getVirtualView();
        Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
        if ((paramlie != null) && (paramlie.a() != null) && (paramlie.a().showBreathAnimation) && (paramlie.a() != null) && (paramlie.a().getCurActivity() != null)) {
          a(((ImageBase)localObject).getNativeView(), paramlie.a().getCurActivity(), paramlie.a(), true);
        }
        localObject = (lrn)localViewBase.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((lrn)localObject).setModel(paramlie);
        }
        lsy.i(localViewBase, paramlie);
        if (paramlie != null) {
          lsy.a(localViewBase, paramlie.a());
        }
        llu.a(localViewBase, paramlie);
        a(paramContainer, paramlie);
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (paramlie != null)
        {
          paramContainer = paramlie.a();
          paramInt1 = paramInt2;
          if (paramContainer != null)
          {
            if ((paramContainer.isPGCShortContent()) || (kxm.J(paramContainer))) {
              break label262;
            }
            paramInt1 = paramInt2;
            if (kxm.I(paramContainer)) {
              break label262;
            }
          }
        }
        if (paramInt1 == 0) {
          break;
        }
        paramContainer = (lsw)localViewBase.findViewBaseByName("id_summary");
        if (paramContainer != null)
        {
          paramContainer.setModel(paramlie);
          return;
        }
        QLog.d("CommentBiuProteusItem", 1, "bindView error!,summaryView is null= ");
        return;
      }
      catch (Exception paramContainer)
      {
        QLog.d("CommentBiuProteusItem", 1, "bindView error!,msg= " + paramContainer);
        return;
      }
      label262:
      paramInt1 = 1;
    }
  }
  
  public void a(lie paramlie, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((paramlie != null) && (paramlie.a() != null) && (paramContainer != null) && (paramlie.b() != null))
    {
      kxm.b(paramlie.b().getActivity(), paramlie.a());
      kxm.a(paramlie.b().getActivity(), paramlie.a(), paramlie.b(), paramlie.nh());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */