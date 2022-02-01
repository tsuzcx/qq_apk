import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;

public class lsy
{
  public static CharSequence a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      long l = paramArticleInfo.mTime;
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.aRW > 0)) {
        l = paramArticleInfo.mSocialFeedInfo.aRW;
      }
      String str2 = "";
      String str1;
      if ((llu.Q(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null)) {
        str1 = paramArticleInfo.mSocialFeedInfo.ahO;
      }
      for (;;)
      {
        paramArticleInfo = str1;
        if (TextUtils.isEmpty(str1)) {
          paramArticleInfo = "";
        }
        return kxm.E(paramArticleInfo, 36);
        str1 = str2;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.ahO)) {
            str1 = "" + " · " + paramArticleInfo.mSocialFeedInfo.ahO;
          }
        }
      }
    }
    return "";
  }
  
  public static void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    label105:
    for (;;)
    {
      return;
      if ((paramArticleInfo.mProteusTemplateBean != null) && (paramArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
      for (paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_biu_time");; paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_biu_time"))
      {
        if (paramViewBase == null) {
          break label105;
        }
        String str = llu.j(paramArticleInfo);
        paramViewBase.setText(str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.proteus", 2, " " + paramArticleInfo + " time : " + str);
        return;
      }
    }
  }
  
  public static void e(ViewBase paramViewBase, lie paramlie)
  {
    String str = "";
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_jump_channel_bar");
    paramViewBase = str;
    boolean bool;
    if (paramlie != null)
    {
      paramViewBase = str;
      if (localViewBase != null)
      {
        bool = kxm.AK();
        if ((!bool) || (!kxm.t(paramlie.a()))) {
          break label93;
        }
        localViewBase.setVisibility(0);
      }
    }
    for (paramViewBase = str;; paramViewBase = "no data bind, isintab:" + bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.proteus", 2, "bindJumpChannel,flag" + false + " resong : " + paramViewBase);
      }
      return;
      label93:
      localViewBase.setVisibility(8);
    }
  }
  
  public static void f(ViewBase paramViewBase, lie paramlie)
  {
    paramViewBase = (lsf)paramViewBase.findViewBaseByName("id_socialize_recommend_follow");
    if (paramViewBase != null) {
      paramViewBase.setModel(paramlie);
    }
  }
  
  public static void g(ViewBase paramViewBase, lie paramlie)
  {
    paramlie = paramlie.a();
    paramViewBase = paramViewBase.findViewBaseByName("id_flow_guide_separator");
    if (paramViewBase != null)
    {
      try
      {
        if (llu.O(paramlie))
        {
          if ((paramlie != null) && (paramlie.isPGCShortContent()))
          {
            paramViewBase.setVisibility(0);
            return;
          }
          paramViewBase.setVisibility(8);
          return;
        }
      }
      catch (JSONException paramViewBase)
      {
        QLog.e("BindViewHelper", 2, paramViewBase.getMessage());
        return;
      }
      paramViewBase.setVisibility(8);
    }
  }
  
  public static void h(ViewBase paramViewBase, lie paramlie)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if (localArticleInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(localArticleInfo.mSubscribeID);
        paramlie = ReadInJoyUserInfoModule.a(l, null);
        if (paramlie == null) {
          break;
        }
        if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper")))
        {
          paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_nickname");
          if (paramViewBase == null) {
            break;
          }
          paramViewBase.setText(paramlie.nick);
          return;
        }
      }
      catch (NumberFormatException paramViewBase)
      {
        paramViewBase.printStackTrace();
        return;
      }
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_nickname");
    }
  }
  
  public static void i(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramlie == null) || (paramlie.a() == null)) {}
    for (;;)
    {
      return;
      ArticleInfo localArticleInfo = paramlie.a();
      if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
      for (paramViewBase = (lro)paramViewBase.findViewBaseByName("id_feeds_info_avator"); paramViewBase != null; paramViewBase = (lro)paramViewBase.findViewBaseByName("id_info_avator"))
      {
        paramViewBase.setModel(paramlie);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsy
 * JD-Core Version:    0.7.0.1
 */