import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lqk
  implements ViewBase.OnClickListener
{
  private nng a;
  private ArticleInfo b;
  private Context mContext;
  private odg mShareHelper;
  private nwg mShareUtils;
  
  public lqk(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
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
  
  private void c(ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.mShareHelper == null)
    {
      this.mShareHelper = new odg((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, new lqk.a(this.b, new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new lql(this));
    }
    paramViewBase = this.mShareHelper.getActivity().getIntent();
    if ((paramViewBase != null) && (TextUtils.isEmpty(paramViewBase.getStringExtra("big_brother_source_key")))) {
      paramViewBase.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    int i;
    if (ndi.S(this.b)) {
      i = 15;
    }
    for (;;)
    {
      this.mShareHelper.a(new List[] { aS() }, i);
      return;
      if (ndi.O(this.b)) {
        i = 16;
      } else if (ndi.ag(this.b)) {
        i = 12;
      } else {
        i = 0;
      }
    }
  }
  
  public static String j(ArticleInfo paramArticleInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      kxm.a(localJSONObject, paramArticleInfo);
      localJSONObject.put("feed_type", 1043);
      localJSONObject.put("version", kct.XU);
      localJSONObject.put("os", "1");
      if (paramArticleInfo != null)
      {
        localJSONObject.put("comment_id", paramArticleInfo.commentId);
        localJSONObject.put("entry", paramArticleInfo.commentSrc);
      }
      if (paramArticleInfo.mChannelID == 0L) {
        localJSONObject.put("place", 1);
      }
      for (;;)
      {
        return localJSONObject.toString();
        if (paramArticleInfo.mChannelID == 70L) {
          localJSONObject.put("place", 2);
        }
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.d("OnShareClickListener", 2, paramArticleInfo.getMessage());
    }
  }
  
  private void n(ArticleInfo paramArticleInfo)
  {
    String str = j(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    kbp.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    c(paramViewBase);
    n(this.b);
  }
  
  class a
    extends odg.a
  {
    private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    private nrl.a jdField_b_of_type_Nrl$a = new lqm(this);
    private WeakReference<Activity> mActivityReference;
    
    a(WeakReference<Activity> paramWeakReference)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramWeakReference;
      Object localObject;
      this.mActivityReference = localObject;
    }
    
    private boolean CD()
    {
      return aqiw.isNetworkAvailable(lqk.a(lqk.this));
    }
    
    private void a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      if (!CD()) {
        return;
      }
      ((lcd)kxm.getAppRuntime().getManager(163)).b().a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, dn(paramInt), this.jdField_b_of_type_Nrl$a);
    }
    
    private void b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      try
      {
        Object localObject = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", "qq_friend");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qzone");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat_circle");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("upline", localObject);
        localJSONObject.put("belowline", new JSONArray());
        localJSONObject.put("shareCallBack", "");
        localJSONObject.put("title", getShareTitle());
        localJSONObject.put("back", true);
        localJSONObject.put("WXShareFromQQKandian", 1);
        localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("src_action", "plugin");
        localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("desc", ((Activity)this.mActivityReference.get()).getString(2131718523));
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
        for (localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.commentShareUrl;; localObject = "")
        {
          localJSONObject.put("share_url", localObject);
          localJSONObject.put("keepShareUrl", 1);
          localJSONObject.put("image_url", getImageUrl());
          localJSONObject.put("uin", "");
          localJSONObject.put("puin", 0);
          if (lqk.a(lqk.this) == null) {
            lqk.a(lqk.this, new nwg());
          }
          localObject = null;
          if (paramActionSheetItem.action == 72) {
            localObject = paramActionSheetItem.uin;
          }
          lqk.a(lqk.this).a(localJSONObject, paramInt, (Activity)this.mActivityReference.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
          return;
        }
        return;
      }
      catch (JSONException paramActionSheetItem)
      {
        QLog.d("OnShareClickListener", 2, paramActionSheetItem.getMessage());
      }
    }
    
    private int dn(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        return 0;
      case 3: 
        return 1;
      case 9: 
        return 2;
      }
      return 3;
    }
    
    private int jdMethod_do(int paramInt)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return 2;
      case 1: 
        return 3;
      case 2: 
        return 9;
      }
      return 10;
    }
    
    private String getImageUrl()
    {
      String str = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        str = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
      }
      QLog.d("OnShareClickListener", 2, "getImageUrl | shareImgUrl : " + str);
      return str;
    }
    
    private String getShareTitle()
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
      }
      return "";
    }
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      if ((ndi.O(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ndi.S(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        a(paramInt, paramActionSheetItem);
      }
      for (;;)
      {
        return super.b(paramInt, paramActionSheetItem);
        b(paramInt, paramActionSheetItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqk
 * JD-Core Version:    0.7.0.1
 */