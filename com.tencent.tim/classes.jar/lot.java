import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.2;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lot
  extends lom
{
  private odg mShareHelper;
  private nwg mShareUtils;
  
  private void a(ViewBase paramViewBase, lie paramlie, Container paramContainer)
  {
    Object localObject = (lso)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((lso)localObject).a();
      localViewBean = paramlie.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.ajU = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((lso)localObject).a();
    lpd locallpd = new lpd(this);
    lot.a locala = new lot.a(true);
    if ((ndb)paramContainer.getTag(2131376750) == null) {
      paramContainer.setTag(2131376750, new lpe(this, (View)localObject, locala, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(locallpd);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new lpg(this, paramlie, localNativeVideoView, locala, new lpf(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new lou(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new lov(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private List<Integer> aS()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void d(View paramView, String paramString)
  {
    if ((paramView instanceof VideoView))
    {
      Object localObject = (VideoView)paramView;
      long l = ((VideoView)localObject).cD();
      int i;
      if (((VideoView)localObject).isMute()) {
        i = 0;
      }
      try
      {
        for (;;)
        {
          localObject = kxm.b(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          kxm.a(paramView.getContext(), (String)localObject, null);
          return;
          i = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PgcShortContentProteusItem", 1, "buildNewScheme exception, e=" + localException.getMessage());
          String str = paramString;
        }
      }
    }
    QLog.e("PgcShortContentProteusItem", 1, "handleJumpScheme failed, view is not VideoView");
  }
  
  private void d(lie paramlie, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.mShareHelper == null)
    {
      this.mShareHelper = new odg((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, new lot.b(paramlie.a(), new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new low(this));
    }
    paramlie = this.mShareHelper.getActivity().getIntent();
    if ((paramlie != null) && (TextUtils.isEmpty(paramlie.getStringExtra("big_brother_source_key")))) {
      paramlie.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.mShareHelper.a(new List[] { aS() }, 13);
  }
  
  private boolean dK(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void n(ArticleInfo paramArticleInfo)
  {
    String str = kxm.d(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    kbp.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  protected View a(int paramInt, Context paramContext, lie paramlie, lsd paramlsd)
  {
    paramlie = paramlie.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new PgcShortContentProteusItem.1(this, paramContext, paramlie);
    case 110: 
      return new PgcShortContentProteusItem.2(this, paramContext, paramlie);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    lku locallku = new lku();
    label243:
    for (;;)
    {
      try
      {
        long l = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        localNumberFormatException1.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          ReadInJoyUserInfoModule.a(l, null);
          locallku.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih != null)))) {
            locallku.p(paramBaseArticleInfo);
          }
          if ((paramInt != 34) && (paramInt == 85)) {}
          locallku.h(paramBaseArticleInfo);
          if (dK(paramInt)) {
            locallku.z(paramBaseArticleInfo);
          }
          locallku.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            locallku.Q(paramBaseArticleInfo);
          }
          return locallku.E();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label243;
        }
        localNumberFormatException1 = localNumberFormatException1;
        l = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    lsy.i(localViewBase, paramlie);
    lsy.h(localViewBase, paramlie);
    lsy.a(localViewBase, paramlie.a());
    lsy.f(localViewBase, paramlie);
    c(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramlie, paramInt2, localViewBase);
    lsy.e(localViewBase, paramlie);
    lsy.g(localViewBase, paramlie);
  }
  
  protected void a(int paramInt1, lie paramlie, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.getContent() == null) || (paramlie.b() == null)) {}
    for (;;)
    {
      return;
      ndi localndi = paramlie.b();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        mgm.i(paramlie.a());
        paramNativeMiddleBodyView.getContent().setOnClickListener(new lpb(this, paramlie, paramContainer, localndi));
        ((lwl)paramNativeMiddleBodyView.getContent()).P(paramlie);
        return;
      case 111: 
        mgm.i(paramlie.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
        paramContainer = ComponentContentGridImage.a(paramlie, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(paramlie);
        paramNativeMiddleBodyView.P(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new lpa(this, paramlie));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.getContent();
      mgm.i(paramlie.a());
      paramNativeMiddleBodyView.P(paramlie);
      try
      {
        if ((paramlie.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM) && (paramlie.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new lpc(this, paramlie, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException paramlie)
      {
        QLog.e("PgcShortContentProteusItem", 1, paramlie.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, paramlie, paramViewBase);
      paramViewBase.setOnClickListener(new lox(this, paramlie));
      return true;
      paramViewBase.setOnClickListener(new loy(this, paramViewBase, paramlie));
      continue;
      paramViewBase.setOnClickListener(new loz(this, paramlie, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, lie paramlie, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, paramlie, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, paramlie, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
  
  class a
  {
    private boolean akJ;
    
    a(boolean paramBoolean)
    {
      set(paramBoolean);
    }
    
    boolean get()
    {
      return this.akJ;
    }
    
    void set(boolean paramBoolean)
    {
      this.akJ = paramBoolean;
    }
  }
  
  class b
    extends odg.a
  {
    private ArticleInfo b;
    private WeakReference<Activity> mActivityReference;
    
    b(WeakReference<Activity> paramWeakReference)
    {
      this.b = paramWeakReference;
      Object localObject;
      this.mActivityReference = localObject;
    }
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      try
      {
        if ((this.b.mSocialFeedInfo.a.amM) && (this.b.mSocialFeedInfo.a.kY.size() > 0))
        {
          String str1 = ((SocializeFeedsInfo.n)this.b.mSocialFeedInfo.a.kY.get(0)).aii;
          try
          {
            JSONArray localJSONArray = new JSONArray();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("name", "qq_friend");
            localJSONObject.put("webHandle", 0);
            localJSONArray.put(localJSONObject);
            localJSONObject = new JSONObject();
            localJSONObject.put("name", "qzone");
            localJSONObject.put("webHandle", 0);
            localJSONArray.put(localJSONObject);
            localJSONObject = new JSONObject();
            localJSONObject.put("name", "we_chat");
            localJSONObject.put("webHandle", 0);
            localJSONArray.put(localJSONObject);
            localJSONObject = new JSONObject();
            localJSONObject.put("name", "we_chat_circle");
            localJSONObject.put("webHandle", 0);
            localJSONArray.put(localJSONObject);
            localJSONObject = new JSONObject();
            localJSONObject.put("upline", localJSONArray);
            localJSONObject.put("belowline", new JSONArray());
            localJSONObject.put("shareCallBack", "");
            localJSONObject.put("title", this.b.mSocialFeedInfo.a.aih);
            localJSONObject.put("back", true);
            localJSONObject.put("WXShareFromQQKandian", 1);
            localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
            localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
            localJSONObject.put("src_action", "plugin");
            localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
            localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
            localJSONObject.put("desc", ((Activity)this.mActivityReference.get()).getString(2131718523));
            localJSONObject.put("share_url", this.b.getShareUrl());
            localJSONObject.put("keepShareUrl", 1);
            localJSONObject.put("image_url", str1);
            localJSONObject.put("uin", "");
            localJSONObject.put("puin", 0);
            if (lot.a(lot.this) == null) {
              lot.a(lot.this, new nwg());
            }
            str1 = null;
            if (paramActionSheetItem.action == 72) {
              str1 = paramActionSheetItem.uin;
            }
            lot.a(lot.this).a(localJSONObject, paramInt, (Activity)this.mActivityReference.get(), str1, paramActionSheetItem.uinType, paramActionSheetItem.label);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              String str2;
              localJSONException.printStackTrace();
            }
          }
          catch (NullPointerException localNullPointerException2)
          {
            for (;;)
            {
              QLog.e("PgcShortContentProteusItem", 1, localNullPointerException2.toString());
            }
          }
          return super.b(paramInt, paramActionSheetItem);
        }
      }
      catch (NullPointerException localNullPointerException1)
      {
        for (;;)
        {
          QLog.e("PgcShortContentProteusItem", 1, localNullPointerException1.toString());
          str2 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
          continue;
          String str3 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lot
 * JD-Core Version:    0.7.0.1
 */