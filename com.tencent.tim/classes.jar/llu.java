import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.d;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.g;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.h;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.i;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.p;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.RequestSearchWord.Rcmd;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class llu
{
  static void A(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("url", kxm.a(paramBaseArticleInfo, paramBaseArticleInfo.mArticleContentUrl));
    new JSONObject();
    paramJSONObject.put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
    Object localObject1 = paramBaseArticleInfo.mTitle;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramJSONObject.put("artilce_title_text", localObject1);
    }
    if (paramBaseArticleInfo.getVideoDuration() > 0) {
      paramJSONObject.put("video_play_duration", jll.formatTime(paramBaseArticleInfo.getVideoDuration()));
    }
    if (paramBaseArticleInfo.getVideoDuration() <= 0) {
      paramJSONObject.put("subcribe_name_text", paramBaseArticleInfo.mSubscribeName);
    }
    B(paramBaseArticleInfo, paramJSONObject);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    mhr.a locala;
    JSONObject localJSONObject;
    Object localObject2;
    BaseArticleInfo localBaseArticleInfo;
    if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP != null))
    {
      localArrayList1 = new ArrayList();
      localObject1 = new JSONArray();
      localArrayList2 = new ArrayList();
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.iP.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          locala = (mhr.a)localIterator.next();
          if (locala != null)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("style_ID", locala.aht);
            new JSONObject();
            localJSONObject.put("article_large_imge_url", locala.ahr);
            if (locala.aSb == 1) {}
            localJSONObject.put("rowkey", locala.ahs);
            localArrayList1.add(locala.ahs);
            localJSONObject.put("subcribe_name_text", locala.subscribeName);
            localJSONObject.put("subscribe_id", locala.subscribeID);
            localJSONObject.put("artilce_title_text", locala.articleTitle);
            if (kxm.dF(locala.articleContentUrl))
            {
              localObject2 = kxm.a(locala.articleContentUrl, locala, paramBaseArticleInfo);
              localBaseArticleInfo = new BaseArticleInfo();
              localBaseArticleInfo.mArticleContentUrl = locala.articleContentUrl;
              localBaseArticleInfo.mSubscribeName = locala.subscribeName;
              localBaseArticleInfo.mSubscribeID = locala.subscribeID;
              localBaseArticleInfo.mTitle = locala.articleTitle;
              if (locala.a != null)
              {
                localJSONObject.put("video_play_duration", jll.formatTime(locala.a.duration));
                localBaseArticleInfo.mVideoDuration = locala.a.duration;
                localBaseArticleInfo.busiType = locala.a.businessType;
                localBaseArticleInfo.mVideoVid = locala.a.vid;
                localBaseArticleInfo.mVideoJsonWidth = locala.a.width;
                localBaseArticleInfo.mVideoJsonHeight = locala.a.height;
              }
            }
          }
        }
      }
    }
    label726:
    for (;;)
    {
      try
      {
        localBaseArticleInfo.mVideoCoverUrl = new URL(locala.ahr);
        if ((paramBaseArticleInfo.isPGCShortContent()) && (locala.aSd == 1)) {}
        localArrayList2.add(localBaseArticleInfo);
        localJSONObject.put("url", localObject2);
        ((JSONArray)localObject1).put(localJSONObject);
        if (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData)) {
          break label726;
        }
        localObject2 = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        if (localObject2 != null)
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("remoteDatas");
          localObject1 = kxm.b((JSONArray)localObject1, (JSONArray)localObject2);
          break;
          localObject2 = locala.articleContentUrl;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        QLog.d("Util", 2, localMalformedURLException.getMessage());
        continue;
        localObject2 = null;
        continue;
      }
      paramJSONObject.put("jump_url", paramBaseArticleInfo.mNewPolymericInfo.aho);
      paramJSONObject.put("datas", localObject1);
      paramBaseArticleInfo.mGroupSubArticleList = localArrayList2;
      paramJSONObject.put("all_rowkey", localArrayList1.toString());
      QLog.d("Util", 1, "bindDynamicCommonInfo polymetric card : " + paramJSONObject.toString() + ", packType : " + paramBaseArticleInfo.mNewPolymericInfo.aRX);
      QLog.d("Util", 1, "bindDynamicCommonInfo : " + paramJSONObject.toString());
      return;
    }
  }
  
  static void B(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindTripleImageData, info is null or outData is null.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      JSONArray localJSONArray = ndi.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, info.mJsonPictureList = ", paramBaseArticleInfo.mJsonPictureList });
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      {
        QLog.d("Util", 1, "bindTripleImageData, json picture list is empty.");
        return;
      }
      i = 0;
      if (i < localJSONArray.length())
      {
        localObject = localJSONArray.optJSONObject(i);
        if (localObject == null) {}
        for (localObject = paramBaseArticleInfo.mFirstPagePicUrl;; localObject = ((JSONObject)localObject).optString("picture"))
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
    }
    else
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, mPictures length = ", Integer.valueOf(paramBaseArticleInfo.mPictures.length) });
      i = 0;
      if (i < paramBaseArticleInfo.mPictures.length)
      {
        if (paramBaseArticleInfo.mPictures[i] == null) {}
        for (localObject = paramBaseArticleInfo.mSinglePicture;; localObject = paramBaseArticleInfo.mPictures[i])
        {
          if (localObject != null) {
            localArrayList.add(((URL)localObject).getFile());
          }
          i += 1;
          break;
        }
      }
    }
    int i = 0;
    label241:
    if (i < localArrayList.size())
    {
      localObject = "gallery_triple_img_url_" + (i + 1);
      if (!TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
        break label340;
      }
    }
    label340:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = (String)localArrayList.get(i))
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, key = ", localObject, ", value = ", paramBaseArticleInfo });
      paramJSONObject.put((String)localObject, paramBaseArticleInfo);
      i += 1;
      break label241;
      break;
    }
  }
  
  static void C(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((!V(paramBaseArticleInfo)) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (!kxm.AS()))) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    int i = localSocializeFeedsInfo.mLikeCount;
    int j = localSocializeFeedsInfo.mCommentCount;
    QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(i), " commentCount = ", Integer.valueOf(j) });
    boolean bool = S(paramBaseArticleInfo);
    paramJSONObject.put("like_count", "");
    Object localObject1;
    String str;
    if (bool)
    {
      localObject1 = "like_selected_state";
      if (localSocializeFeedsInfo.aSH != 1) {
        break label389;
      }
      str = "1";
      label133:
      paramJSONObject.put((String)localObject1, str);
      if (!bool) {
        break label397;
      }
      localObject1 = "like_text";
      label152:
      str = awit.gM(i);
      if (i <= 0) {
        break label405;
      }
      label162:
      paramJSONObject.put((String)localObject1, str);
      if (!bool) {
        break label413;
      }
      localObject1 = "comment_text";
      label181:
      str = awit.gM(j);
      if (j <= 0) {
        break label421;
      }
      label191:
      paramJSONObject.put((String)localObject1, str);
      if ((!localSocializeFeedsInfo.DB()) || (!(paramBaseArticleInfo instanceof ArticleInfo))) {
        break label457;
      }
      localObject1 = (ArticleInfo)paramBaseArticleInfo;
      if ((ndi.P((ArticleInfo)localObject1)) || (!kvm.i((BaseArticleInfo)localObject1))) {
        break label470;
      }
    }
    label327:
    label457:
    label470:
    for (i = 0;; i = 1)
    {
      if (i == 0)
      {
        str = "0";
        localObject1 = "0.5";
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p != null)
        {
          localObject2 = localObject1;
          if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.aSZ != 0) {
            localObject2 = "0.5";
          }
        }
        paramJSONObject.put("biu_alpha", localObject2);
        paramJSONObject.put("biu_enable", str);
        i = localSocializeFeedsInfo.aSI;
        if (i > 0)
        {
          paramJSONObject.put("biu_count", awit.gM(i));
          paramJSONObject.put("setArticleInfo", paramBaseArticleInfo);
          if (!bool) {
            break label443;
          }
          paramBaseArticleInfo = "share_text";
          label345:
          paramJSONObject.put(paramBaseArticleInfo, "");
          localObject1 = new JSONObject();
          if (!bool) {
            break label450;
          }
        }
        for (paramBaseArticleInfo = "id_social_bottom_style_a";; paramBaseArticleInfo = "id_social_bottom")
        {
          paramJSONObject.put(paramBaseArticleInfo, localObject1);
          return;
          localObject1 = "selected_state";
          break;
          str = "0";
          break label133;
          localObject1 = "like_count";
          break label152;
          str = "";
          break label162;
          localObject1 = "comment_count";
          break label181;
          str = "";
          break label191;
          paramJSONObject.put("biu_count", "Biu");
          break label327;
          paramBaseArticleInfo = "share_title";
          break label345;
        }
        localObject1 = "1.0";
        str = "1";
      }
    }
  }
  
  static void D(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    int j = 0;
    if ((paramBaseArticleInfo == null) || ((paramBaseArticleInfo instanceof ArticleInfo))) {}
    label244:
    for (;;)
    {
      return;
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      int i;
      if (localObject != null)
      {
        j = ((SocializeFeedsInfo)localObject).mLikeCount;
        i = ((SocializeFeedsInfo)localObject).aSI;
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(j), " biuCount = ", Integer.valueOf(i) });
      }
      for (;;)
      {
        if ((j <= 0) && (i <= 0)) {
          break label244;
        }
        paramJSONObject.put("id_social_separator_line", new JSONObject());
        paramJSONObject.put("id_social_data_wrapper", new JSONObject());
        if (j > 0)
        {
          paramBaseArticleInfo = new JSONObject();
          paramJSONObject.put("social_data_like", "");
          paramJSONObject.put("id_social_data_like", paramBaseArticleInfo);
        }
        if ((j > 0) && (i > 0)) {
          paramJSONObject.put("id_social_data_dot", new JSONObject());
        }
        if (i <= 0) {
          break;
        }
        paramBaseArticleInfo = awit.gM(i) + "Biu";
        localObject = new JSONObject();
        ((JSONObject)localObject).put("social_data_biu", paramBaseArticleInfo);
        paramJSONObject.put("id_social_data_biu", localObject);
        return;
        i = 0;
      }
    }
  }
  
  static void E(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      return;
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (((localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null) || (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() <= 0) || ((localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() == 1) && ((TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj)) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj, ":")) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.get(0)).ahj, "："))))) && (TextUtils.isEmpty(localSocializeFeedsInfo.ahL)));
    JSONObject localJSONObject = new JSONObject();
    long l = 0L;
    if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
    }
    localJSONObject.put("pre_account_uin", String.valueOf(l));
    if ((ndi.ah(paramBaseArticleInfo)) && (X(paramBaseArticleInfo))) {
      localJSONObject.put("feeds_pre_account_uin", String.valueOf(l));
    }
    paramJSONObject.put("id_biu_comment", localJSONObject);
  }
  
  private static JSONObject F()
  {
    return new JSONObject();
  }
  
  static void F(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo.r localr;
    do
    {
      do
      {
        return;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null);
      localr = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r;
    } while (((!mas.H((ArticleInfo)paramBaseArticleInfo)) || (ndi.an(paramBaseArticleInfo))) && (!kxm.a(localr)) && (TextUtils.isEmpty(localr.ail)));
    paramJSONObject.put("id_article_comment", new JSONObject());
  }
  
  static void G(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("id_middle_body_wrapper", new JSONObject());
  }
  
  static void H(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("id_summary", new JSONObject());
  }
  
  static void I(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null)
    {
      localJSONObject.put("pre_account_uin", String.valueOf(paramBaseArticleInfo.mSubscribeID));
      if ((ndi.ah(paramBaseArticleInfo)) && (X(paramBaseArticleInfo))) {
        localJSONObject.put("feeds_pre_account_uin", String.valueOf(paramBaseArticleInfo.mSubscribeID));
      }
    }
    paramJSONObject.put("id_article_comment", localJSONObject);
  }
  
  static void J(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (kvm.h(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() <= 0)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void K(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (kvm.h(paramBaseArticleInfo)) {}
    while (ndi.an(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void L(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!ndi.ao(paramBaseArticleInfo))
    {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
      if (paramBaseArticleInfo.mFeedType == 30) {
        paramJSONObject.remove("id_summary");
      }
    }
  }
  
  static void M(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (kvm.h(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void N(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
    {
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_topic_tag", new JSONObject());
      if (!TextUtils.isEmpty(paramBaseArticleInfo.businessNamePrefix))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_topic_pre", "topic_pre_image");
        paramJSONObject.put("id_capsule_topic_pre", localJSONObject);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_topic_name", kxm.E(paramBaseArticleInfo.businessName, g(paramBaseArticleInfo)));
      paramJSONObject.put("id_capsule_topic_name", localJSONObject);
    }
  }
  
  static void O(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Util", 2, "bindCommunityCapsule info or socialFeedInfo is null");
      }
    }
    SocializeFeedsInfo.d locald;
    do
    {
      do
      {
        return;
        locald = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
      } while (locald == null);
      if ((!TextUtils.isEmpty(locald.name)) && (!TextUtils.isEmpty(locald.headUrl))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Util", 2, "bindCommunityCapsule buluoInfo name or headUrl is empty");
    return;
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_community_tag", new JSONObject());
    if (!TextUtils.isEmpty(locald.headUrl))
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("capsule_community_pre", locald.headUrl);
      paramJSONObject.put("id_capsule_community_pre", localJSONObject);
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("capsule_community_name", kxm.E(locald.name, g(paramBaseArticleInfo)));
    paramJSONObject.put("id_capsule_community_name", localJSONObject);
    kbp.a(null, "", "0X8009BA5", "0X8009BA5", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), locald.bid + "", paramBaseArticleInfo.mChannelID + "", "", false);
  }
  
  public static boolean O(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    if (!TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData)) {
      return new JSONObject(paramBaseArticleInfo.proteusItemsData).has("module_bottom_name");
    }
    return false;
  }
  
  static void P(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      do
      {
        return;
        localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
        if (localSocializeFeedsInfo.mFollowStatus != 1) {
          break;
        }
      } while ((ndi.ah(paramBaseArticleInfo)) && (!U(paramBaseArticleInfo)));
      paramJSONObject.put("selected_status", "0");
      return;
    } while ((localSocializeFeedsInfo.mFollowStatus != 2) || (!T(paramBaseArticleInfo)));
    new JSONObject();
    paramJSONObject.put("selected_status", "1");
  }
  
  private static boolean P(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    String str;
    if (ndi.S((ArticleInfo)paramBaseArticleInfo)) {
      str = "ugcShowPostTimeLabel";
    }
    for (;;)
    {
      if ((W(paramBaseArticleInfo)) && (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if (ndi.ag(paramBaseArticleInfo))
        {
          str = "commentShowPostTimeLabel";
          break;
        }
        if (ndi.O((ArticleInfo)paramBaseArticleInfo))
        {
          str = "biuShowPostTimeLabel";
          break;
        }
        if (!ndi.L((ArticleInfo)paramBaseArticleInfo)) {
          break label102;
        }
        str = "pgcShowPostTimeLabel";
        break;
      }
      label102:
      str = "";
    }
  }
  
  static void Q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      do
      {
        return;
        localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
        if (localSocializeFeedsInfo.mFollowStatus != 1) {
          break;
        }
      } while ((ndi.ah(paramBaseArticleInfo)) && (!U(paramBaseArticleInfo)));
      new JSONObject();
      paramJSONObject.put("selected_status", "0");
      return;
    } while ((localSocializeFeedsInfo.mFollowStatus != 2) || (!T(paramBaseArticleInfo)));
    new JSONObject();
    paramJSONObject.put("selected_status", "1");
  }
  
  public static boolean Q(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    if (paramBaseArticleInfo == null) {}
    do
    {
      return false;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (paramBaseArticleInfo == null);
    if (paramBaseArticleInfo.mFollowStatus == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  static void R(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u;
        } while (paramBaseArticleInfo == null);
        if ((TextUtils.isEmpty(paramBaseArticleInfo.ain)) || (TextUtils.isEmpty(paramBaseArticleInfo.wendaUrl))) {
          break;
        }
        paramJSONObject.put("id_super_topic", new JSONObject());
        localJSONObject = new JSONObject();
        if (TextUtils.isEmpty(paramBaseArticleInfo.aio)) {
          paramBaseArticleInfo.aio = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
        }
        localJSONObject.put("super_topic_avator_url", paramBaseArticleInfo.aio);
        paramJSONObject.put("id_super_topic_avator", localJSONObject);
        if (!TextUtils.isEmpty(paramBaseArticleInfo.aix))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("super_topic_button_title", paramBaseArticleInfo.aix);
          paramJSONObject.put("id_super_topic_button", localJSONObject);
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("super_topic_name", paramBaseArticleInfo.ain);
        paramJSONObject.put("id_super_topic_name", localJSONObject);
        paramJSONObject.put("id_super_topic_subname", new JSONObject());
      } while (TextUtils.isEmpty(paramBaseArticleInfo.aip));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("super_topic_hot_icon_url", paramBaseArticleInfo.aip);
      paramJSONObject.put("id_super_topic_hot_icon", localJSONObject);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Util", 2, "bindSuperTopic something is null,wendaInfo.wendaUrl=" + paramBaseArticleInfo.wendaUrl + ",wendaInfo.questionDes=" + paramBaseArticleInfo.ain);
  }
  
  private static boolean R(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.size() > 0);
  }
  
  public static void S(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (!mhc.ac(paramBaseArticleInfo))) {
      return;
    }
    paramJSONObject.put("id_pack_bottom", new JSONObject());
    paramJSONObject.put("id_pack_bottom_separator_line", new JSONObject());
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("pack_bottom_imageview", "qqreadinjoy_kandian_down_arrow.png");
    paramJSONObject.put("id_pack_bottom_imageview", paramBaseArticleInfo);
  }
  
  private static boolean S(BaseArticleInfo paramBaseArticleInfo)
  {
    return (ndi.ag(paramBaseArticleInfo)) || (ndi.ah(paramBaseArticleInfo));
  }
  
  static void T(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h;
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_common_tag", new JSONObject());
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.appIcon))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_pre_url", paramBaseArticleInfo.appIcon);
        paramJSONObject.put("id_capsule_common_pre", localJSONObject);
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.appName))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_name", paramBaseArticleInfo.appName);
        paramJSONObject.put("id_capsule_common_name", localJSONObject);
      }
    }
  }
  
  private static boolean T(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramBaseArticleInfo != null) {}
    for (boolean bool1 = paramBaseArticleInfo.needShowFollwedButton;; bool1 = false)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo != null)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.isNeedShowBtnWhenFollowed)
          {
            bool1 = bool2;
            if (ndi.ah(paramBaseArticleInfo)) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  static void U(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p == null)) {}
    int i;
    long l;
    do
    {
      return;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p;
      i = paramBaseArticleInfo.aSZ;
      l = paramBaseArticleInfo.vR;
    } while ((kxm.getLongAccountUin() != l) || (i == 0));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_privacy_tag", new JSONObject());
    paramBaseArticleInfo = "";
    if (i == 1) {
      paramBaseArticleInfo = "readinjoy_privacy_vis_some.png";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_privacy_pre", paramBaseArticleInfo);
      paramJSONObject.put("id_capsule_privacy_pre", localJSONObject);
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("capsule_privacy_name", "");
      paramJSONObject.put("id_capsule_privacy_name", paramBaseArticleInfo);
      return;
      if (i == 2) {
        paramBaseArticleInfo = "readinjoy_privacy_vis_self.png";
      }
    }
  }
  
  private static boolean U(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    String str;
    if (ndi.S((ArticleInfo)paramBaseArticleInfo)) {
      str = "ugcShowFollowBtn";
    }
    for (;;)
    {
      if ((W(paramBaseArticleInfo)) && (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if (ndi.ag(paramBaseArticleInfo))
        {
          str = "commentShowFollowBtn";
          break;
        }
        if (ndi.O((ArticleInfo)paramBaseArticleInfo))
        {
          str = "biuShowFollowBtn";
          break;
        }
        if (!ndi.L((ArticleInfo)paramBaseArticleInfo)) {
          break label102;
        }
        str = "pgcShowFollowBtn";
        break;
      }
      label102:
      str = "";
    }
  }
  
  public static void V(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i == null)) {}
    SocializeFeedsInfo.i locali;
    do
    {
      return;
      locali = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i;
    } while ((TextUtils.isEmpty(locali.name)) || (TextUtils.isEmpty(locali.iconUrl)));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_lbs_tag", new JSONObject());
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_pre_url", locali.iconUrl);
    paramJSONObject.put("id_capsule_lbs_pre", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_name", kxm.E(locali.name, g(paramBaseArticleInfo)));
    paramJSONObject.put("id_capsule_lbs_name", localJSONObject);
  }
  
  private static boolean V(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      QLog.d("Util", 2, "info == null");
      return false;
    }
    if (paramBaseArticleInfo.mSocialFeedInfo == null)
    {
      QLog.d("Util", 2, "info == " + paramBaseArticleInfo);
      return false;
    }
    return true;
  }
  
  public static void W(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("id_socialize_recommend_follow", new JSONObject());
  }
  
  public static boolean W(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID == 0L) && (ndi.ai(paramBaseArticleInfo));
  }
  
  static void X(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    new JSONObject();
    paramJSONObject.put("social_header_fold", "social_header_fold");
  }
  
  static void X(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("id_comment_edit", new JSONObject());
    paramJSONObject.put("id_comment_edit_label", new JSONObject());
  }
  
  public static boolean X(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID == 0L) && (ndi.aj(paramBaseArticleInfo));
  }
  
  public static void Y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = new JSONObject();
    if (paramBaseArticleInfo.hasAwesome)
    {
      if (mgt.aRv == 1)
      {
        ((JSONObject)localObject).put("icon_awesome_url", paramBaseArticleInfo.icon_url);
        ((JSONObject)localObject).put("icon_jump_url", paramBaseArticleInfo.jump_url);
        if (paramBaseArticleInfo.icon_height != 0) {
          ((JSONObject)localObject).put("icon_awesome_wh_rate", paramBaseArticleInfo.icon_with / paramBaseArticleInfo.icon_height);
        }
        paramJSONObject.put("id_icon_awesome", localObject);
      }
      if (mgt.aRv == 2)
      {
        localObject = new mgt();
        ((mgt)localObject).rawkey = paramBaseArticleInfo.rawkey;
        ((mgt)localObject).icon_height = paramBaseArticleInfo.icon_height;
        ((mgt)localObject).icon_with = paramBaseArticleInfo.icon_with;
        ((mgt)localObject).uin = paramBaseArticleInfo.uin;
        ((mgt)localObject).icon_url = paramBaseArticleInfo.icon_url;
        ((mgt)localObject).nick_name = paramBaseArticleInfo.nick_name;
        ((mgt)localObject).avatar = paramBaseArticleInfo.avatar;
        ((mgt)localObject).comment_id = paramBaseArticleInfo.comment_id;
        ((mgt)localObject).jump_url = paramBaseArticleInfo.jump_url;
        ((mgt)localObject).content = paramBaseArticleInfo.content;
        ((mgt)localObject).d = paramBaseArticleInfo;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("awesomeCommentInfo", localObject);
        paramJSONObject.put("id_awesomeview_mutlilines", localJSONObject);
      }
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.icon_url)) && ((mgt.aRv == 1) || (mgt.aRv == 2))) {
        mgt.d(paramBaseArticleInfo, "0X8009B76");
      }
      QLog.d("Util", 2, "bindAwesomeCommentInfo: " + paramJSONObject);
    }
  }
  
  static void Y(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = awit.y("kd_topic_recommend_card_jump_switch");
    if ((localObject instanceof Boolean)) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      QLog.d("Util", 1, new Object[] { "bindTopicRecommendCardJumpWrapper, isJumpSwitchOn = ", Boolean.valueOf(bool) });
      if (bool) {
        paramJSONObject.put("id_jump_wrapper", new JSONObject());
      }
      return;
    }
  }
  
  static void Z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = lbz.a().aO(paramBaseArticleInfo.mArticleID);
        paramJSONObject.optString("style_ID");
        if (TextUtils.isEmpty(paramJSONObject.optString("article_main_body_text"))) {
          break label70;
        }
        if (!bool) {
          break label81;
        }
        paramBaseArticleInfo = "#999999";
        paramJSONObject.put("article_main_body_text_color", paramBaseArticleInfo);
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      paramJSONObject.put("readable_title_text_color", paramBaseArticleInfo);
      return;
      paramBaseArticleInfo = "#262626";
      continue;
      label70:
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        continue;
        label81:
        paramBaseArticleInfo = "#737373";
      }
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.optJSONObject("id_ad_biu_small_image_ugc") != null) {
      return;
    }
    c(paramAdvertisementInfo, paramJSONObject);
    paramJSONObject.put("id_ad_biu_small_image_ugc", new JSONObject());
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
    throws JSONException
  {
    if (paramJSONArray == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], outData is null.");
      return;
    }
    if (paramBaseArticleInfo == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], info is null");
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.size() > 0))
    {
      paramInt = 0;
      label48:
      Object localObject;
      if (paramInt < paramBaseArticleInfo.size())
      {
        localObject = (ArticleInfo)paramBaseArticleInfo.get(paramInt);
        if (localObject != null) {
          break label91;
        }
        QLog.i("Util", 1, "[bindSmallVideo], item articleInfo is null.");
      }
      for (;;)
      {
        paramInt += 1;
        break label48;
        break;
        label91:
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_long_video_cell");
          localObject = (mhr.a)((ArticleInfo)localObject).mNewPolymericInfo.iP.get(0);
          localJSONObject.put("article_large_imge_url", kxm.c(((mhr.a)localObject).ahr, Utils.dp2px(165.0D), Utils.dp2px(293.0D)));
          if (((mhr.a)localObject).a != null) {
            localJSONObject.put("video_play_duration", jll.formatTime(((mhr.a)localObject).a.duration));
          }
          QLog.i("Util", 1, "[bindSmallVideo], item = " + localJSONObject);
          paramJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localJSONException);
        }
        catch (Exception localException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localException);
        }
      }
    }
    QLog.i("Util", 1, "[bindSmallVideo], dataList is empty.");
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("info_source_text", el(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_info_source", localJSONObject);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.vIconUrl)) {
      paramJSONObject.put("icon_v_url", paramBaseArticleInfo.vIconUrl);
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, Long paramLong)
    throws JSONException
  {
    new JSONObject();
    paramJSONObject.put("info_avator_uin", paramLong);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if (paramBaseArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
      } while ((kys.dt((int)paramBaseArticleInfo.mChannelID)) || (paramBaseArticleInfo.isCloseDislike == 1));
      if (O(paramBaseArticleInfo))
      {
        QLog.d("Util", 1, "[bindDislikeButtonForChannel] new bottom bar has dislike btn, so return");
        return;
      }
      localJSONObject = new JSONObject();
      if (ndi.ah(paramBaseArticleInfo))
      {
        localJSONObject.put("dislike_img", "dislike_img");
        paramJSONObject.put("id_bottom_dislike_button_style_a", localJSONObject);
        return;
      }
      if (!odv.aT(paramBaseArticleInfo.mChannelID)) {
        break;
      }
    } while ((kxm.A(paramBaseArticleInfo)) || (kxm.r(paramBaseArticleInfo)));
    localJSONObject.put("feeds_dislike_icon", "feedback_more");
    localJSONObject.put("bottom_dislike_img", "feedback_more");
    paramJSONObject.put(paramString, localJSONObject);
    return;
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    localJSONObject.put("bottom_dislike_img", "feeds_dislike");
    paramJSONObject.put(paramString, localJSONObject);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (!"guide_card_type".equals(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if ("1".equals(String.valueOf(paramObject)))
        {
          QLog.d("Util", 1, "bindSpecialData, show flow guide separator.");
          paramJSONObject.put("flow_guide_separator_color", "#f2f2f2");
          return;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("Util", 1, "bindSpecialData, e = ", paramBaseArticleInfo);
      }
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = lbz.a().aO(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (!bool) {
        break label81;
      }
    }
    label81:
    for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#262626")
    {
      localJSONObject.put("title_text_color", paramBaseArticleInfo);
      localJSONObject.put("article_title_text_line_space", "0");
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean, String paramString)
    throws JSONException
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = lbz.a().aO(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        localJSONObject.put("title_text_color", paramBaseArticleInfo);
      }
    }
    for (;;)
    {
      localJSONObject.put("article_title_text_line_space", paramString);
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
      paramBaseArticleInfo = "#262626";
      break;
      localJSONObject.put("title_text_color", "#ffffff");
    }
  }
  
  public static void a(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramViewBase == null) || (paramlie == null)) {}
    long l;
    do
    {
      ArticleInfo localArticleInfo;
      do
      {
        return;
        localArticleInfo = paramlie.a();
      } while ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null));
      l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      paramlie = (lst)paramViewBase.findViewBaseByName("id_nickname");
      if (ndi.ah(localArticleInfo)) {
        paramlie = (lst)paramViewBase.findViewBaseByName("id_feeds_nickname");
      }
    } while (paramlie == null);
    paramlie.em(l);
  }
  
  public static void a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.proteusItemsData == null)) {
      return;
    }
    QLog.d("Util", 2, "addProteusDynamicData" + paramBaseArticleInfo.proteusItemsData);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramBaseArticleInfo.proteusItemsData);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = localJSONObject.opt(str);
        if (localObject != null) {
          paramJSONObject.put(str, localObject);
        }
        a(paramBaseArticleInfo, paramJSONObject, str, localObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("Util", 2, "addProteusDynamicData", localJSONException);
      QLog.d("Util", 1, "addProteusDynamicData | " + paramJSONObject.toString());
      Z(paramBaseArticleInfo, paramJSONObject);
    }
  }
  
  static void aa(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    Object localObject1;
    double d;
    label25:
    Object localObject3;
    do
    {
      return;
      localObject1 = jzk.a(paramBaseArticleInfo);
      if (localObject1 != null) {
        break;
      }
      d = 0.0D;
      localObject3 = ((AdvertisementInfo)paramBaseArticleInfo).mLocalInfo;
    } while (localObject3 == null);
    if (QLog.isColorLevel()) {
      QLog.d("Util", 2, "bindAdPositionInfoNew localInfo ->" + localObject3);
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject1 = ((mho)localObject3).aaW;
        paramBaseArticleInfo = ((mho)localObject3).store_address;
        localObject2 = ((mho)localObject3).distance_description;
        localObject3 = ((mho)localObject3).store_url;
        i = jzp.o((String)localObject1, 3000);
        if (d > 0.0D) {
          break label247;
        }
        localObject1 = "";
        d = 0.0D;
        localStringBuilder = new StringBuilder();
        if (d == 0.0D) {
          break label383;
        }
        if (d <= i) {
          break label258;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = 1;
        if (i == 0) {
          break label368;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ad_Location", paramBaseArticleInfo);
        ((JSONObject)localObject2).put("ad_Location_content", localObject1);
        ((JSONObject)localObject2).put("ad_url", localObject3);
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("ad_Location", localObject2);
        paramJSONObject.put("id_view_ad_locationView", paramBaseArticleInfo);
        return;
        d = jzk.a((double[])localObject1, BaseApplicationImpl.getContext());
        break label25;
        label247:
        d = Math.ceil(d);
        localObject1 = null;
        continue;
        label258:
        if (d < 1000.0D)
        {
          localStringBuilder.append((int)d).append('m');
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          continue;
        }
        if (d >= i) {
          break label370;
        }
        long l = Math.round(d / 1000.0D);
        if (l < 1000L) {
          localStringBuilder.append(l).append("km");
        }
        for (;;)
        {
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          break;
          localStringBuilder.append("999km");
        }
      }
      int i = 0;
      continue;
      label368:
      break;
      label370:
      Object localObject2 = paramBaseArticleInfo;
      paramBaseArticleInfo = (BaseArticleInfo)localObject1;
      localObject1 = localObject2;
      continue;
      label383:
      paramBaseArticleInfo = "";
      localObject1 = localObject2;
    }
  }
  
  static void ab(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null) || (!paramBaseArticleInfo.isAccountShown)) {
      return;
    }
    paramJSONObject.put("info_avator_uin", paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get());
    paramJSONObject.put("partner_nickname_text", kxm.ew(ReadInJoyUserInfoModule.getDefaultNickName()));
    paramJSONObject.put("partner_info_text", kxm.E(paramBaseArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), 36));
    P(paramBaseArticleInfo, paramJSONObject);
    String str2 = "";
    String str1 = str2;
    if (paramBaseArticleInfo.mPartnerAccountInfo.has())
    {
      str1 = str2;
      if (paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.has())
      {
        str1 = paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8();
        paramJSONObject.put("partner_head_jump_url", str1);
      }
    }
    int i = kxm.c(paramBaseArticleInfo);
    paramJSONObject.put("account_expose_card", i);
    paramJSONObject.put("partner_jump_url", paramBaseArticleInfo.mArticleContentUrl);
    QLog.d("Util", 1, new Object[] { "bindPartnerInfo, partner_head_jump_url = ", str1, " proteusItemsData=", paramBaseArticleInfo.proteusItemsData, "  partner_jump_url=", paramBaseArticleInfo.mArticleContentUrl, " ,account_expose_card=", Integer.valueOf(i) });
  }
  
  public static void ac(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    int i;
    if (TextUtils.isEmpty(paramBaseArticleInfo.mSearchWordTitle))
    {
      paramJSONObject.remove(lpq.afs);
      int j = paramBaseArticleInfo.mSearchWords.size();
      i = 0;
      label28:
      if (i >= j) {
        return;
      }
      RequestSearchWord.Rcmd localRcmd = (RequestSearchWord.Rcmd)paramBaseArticleInfo.mSearchWords.get(i);
      if (localRcmd == null) {
        break label112;
      }
      paramJSONObject.put(lpq.bp[i], localRcmd.word.get().toStringUtf8());
      paramJSONObject.put(lpq.bo[i], localRcmd.jmp_url.get());
    }
    for (;;)
    {
      i += 1;
      break label28;
      paramJSONObject.put(lpq.afs, paramBaseArticleInfo.mSearchWordTitle);
      break;
      label112:
      paramJSONObject.remove(lpq.bp[i]);
      paramJSONObject.remove(lpq.bo[i]);
    }
  }
  
  private static void ad(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = paramBaseArticleInfo.mNewPolymericInfo.aRX;
    String str3 = "";
    String str4 = "";
    String str2;
    String str1;
    if ((ndi.am(paramBaseArticleInfo)) || (ndi.al(paramBaseArticleInfo)))
    {
      str2 = BaseApplicationImpl.getContext().getString(2131718538);
      str1 = "poly_topic";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        paramJSONObject.put("corner_text", str2);
        paramJSONObject.put("corner_icon", str1);
      }
      return;
      if ((i == 27) || ((i == 18) && (!paramBaseArticleInfo.isPGCShortContent())) || (i == 31) || ((kxm.B(paramBaseArticleInfo)) && (!kxm.n(paramBaseArticleInfo))))
      {
        str2 = BaseApplicationImpl.getContext().getString(2131718332);
        str1 = "poly_article";
      }
      else if (i == 52)
      {
        str1 = "poly_gallery";
        str2 = str3;
      }
      else if (i != 48)
      {
        str1 = str4;
        str2 = str3;
        if (i != 49) {}
      }
      else
      {
        str1 = str4;
        str2 = str3;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          str1 = str4;
          str2 = str3;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null)
          {
            str1 = str4;
            str2 = str3;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a != null)
            {
              str1 = "poly_gallery";
              str2 = str3;
            }
          }
        }
      }
    }
  }
  
  private static void ae(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((lbz.a().ap(null)) && ((paramBaseArticleInfo instanceof AdvertisementInfo)))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {
        break label33;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label33:
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble("latitude");
        double d2 = paramBaseArticleInfo.getDouble("longitude");
        paramBaseArticleInfo = aczc.a("readinjoy_feed_ad_distance");
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.a != null))
        {
          double d3 = paramBaseArticleInfo.a.cd;
          double d4 = paramBaseArticleInfo.a.ce;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramBaseArticleInfo = jzk.b(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
            paramJSONObject.put("id_ad_position_container", new JSONObject());
            paramJSONObject.put("ad_position", paramBaseArticleInfo);
            return;
          }
        }
      }
      catch (Exception paramBaseArticleInfo) {}
    }
  }
  
  public static void af(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.tipsWording))
      {
        paramJSONObject.put("live_hot_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/0be49e55346742bd847bcef3941ec4d4.png");
        paramJSONObject.put("live_hot_text", paramBaseArticleInfo.tipsWording);
      }
      if (paramBaseArticleInfo.status != 0) {
        break label92;
      }
      paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/d3d83721dfe84278a19c8927e2253f10.png");
    }
    for (;;)
    {
      paramJSONObject.put("live_show", "1");
      return;
      label92:
      paramJSONObject.put("live_status_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/b7e14064b3d1417788352c8a47d1e85a.gif");
      paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/84cf4158acb64cc0a7bf1d3a8f1b9d27.png");
    }
  }
  
  public static void ag(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_icon", "ReadInJoy/rij_play_icon.png");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ah(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_audio_icon", "video_audio_mute");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ai(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_title", paramBaseArticleInfo.mTitle);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void aj(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_count", muj.bw((int)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.vQ) + "播放");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ak(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_duration", muj.av(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.duration * 1000L));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void al(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_vid", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.vid);
      paramJSONObject.put("pgc_video_content_cover", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.pic_url);
      paramJSONObject.put("pgc_video_content_busitype", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.aSY);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void am(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
    {
      paramBaseArticleInfo.isShowColumnAnimation = true;
      paramBaseArticleInfo = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
      if (paramBaseArticleInfo.aHc != 0)
      {
        paramJSONObject.put("column_tips", "栏目");
        paramJSONObject.put("column_name", paramBaseArticleInfo.columnName);
        paramJSONObject.put("readinjoy_column_icon", paramBaseArticleInfo.aiO);
        paramJSONObject.put("readinjoy_column_arrow", "readinjoy_column_arrow");
      }
    }
  }
  
  static void an(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo != null) {}
    try
    {
      paramJSONObject.put("pgc_video_rowkey", paramBaseArticleInfo.innerUniqueID);
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("Util", 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.optJSONObject("id_ad_biu_small_image_pgc") != null) {
      return;
    }
    c(paramAdvertisementInfo, paramJSONObject);
    paramJSONObject.put("id_ad_biu_small_image_pgc", new JSONObject());
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramBaseArticleInfo.mGroupSubArticleList != null) && (paramBaseArticleInfo.mGroupSubArticleList.size() > 0))
    {
      Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
      if (localIterator.hasNext())
      {
        paramBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        paramInt = paramBaseArticleInfo.mNewPolymericInfo.aRX;
        if (kxm.n(paramBaseArticleInfo))
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_gallery");
          label83:
          if (!kxm.l(paramBaseArticleInfo)) {
            break label330;
          }
          localJSONObject.put("article_large_imge_url", k(paramBaseArticleInfo));
          if (aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
            break label304;
          }
          localJSONObject.put("id_play_text_container", new JSONObject());
          localJSONObject.put("id_layout_bottom_cover", new JSONObject());
          localJSONObject.put("id_play_text_icon", new JSONObject());
          if (aqux.Mv() != 1) {
            break label292;
          }
          label166:
          if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP.size() > 0) && (paramBaseArticleInfo.mNewPolymericInfo.iP.get(0) != null)) {
            localJSONObject.put("artilce_title_text", ((mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0)).articleTitle);
          }
          if (!lbz.a().aO(paramBaseArticleInfo.mArticleID)) {
            break label323;
          }
        }
        label292:
        label304:
        label323:
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          paramJSONArray.put(localJSONObject);
          break;
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_img");
          break label83;
          if (paramBaseArticleInfo.mXGFileSize <= 0L) {
            break label166;
          }
          break label166;
          localJSONObject.put("id_play_icon", new JSONObject());
          break label166;
        }
        label330:
        localJSONObject.put("article_large_imge_url", kxm.a(((mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0)).ahr, true, true).getFile());
        ad(paramBaseArticleInfo, localJSONObject);
        ae(paramBaseArticleInfo, localJSONObject);
        if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP.size() > 0) && (paramBaseArticleInfo.mNewPolymericInfo.iP.get(0) != null)) {
          localJSONObject.put("artilce_title_text", ((mhr.a)paramBaseArticleInfo.mNewPolymericInfo.iP.get(0)).articleTitle);
        }
        if (lbz.a().aO(paramBaseArticleInfo.mArticleID)) {}
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          break;
        }
      }
    }
  }
  
  static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    new JSONObject();
    String str = paramString;
    if (paramBaseArticleInfo != null)
    {
      str = paramString;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.ahN)) {
          str = paramBaseArticleInfo.mSocialFeedInfo.ahN;
        }
      }
    }
    paramJSONObject.put("biu_tips_text", str);
  }
  
  public static void b(ViewBase paramViewBase, lie paramlie)
  {
    if ((paramViewBase == null) || (paramlie == null)) {}
    lst locallst;
    do
    {
      return;
      paramlie = paramlie.a();
      locallst = (lst)paramViewBase.findViewBaseByName("id_pack_bottom_label");
      paramViewBase = paramViewBase.findViewBaseByName("id_pack_bottom");
    } while ((locallst == null) || (paramViewBase == null));
    if ((paramlie != null) && (paramlie.mSocialFeedInfo != null) && (paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (mhc.ac(paramlie)))
    {
      long l = paramlie.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      locallst.setVisibility(0);
      paramViewBase.setVisibility(0);
      return;
    }
    paramViewBase.setVisibility(8);
  }
  
  public static void c(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null)
    {
      localObject = paramAdvertisementInfo.mAdImg;
      localJSONObject.put("image_url", localObject);
      paramJSONObject.put("id_inner_small_img", localJSONObject);
      paramJSONObject.put("id_area_right_of_img", new JSONObject());
      paramJSONObject.put("id_dislike_button", new JSONObject());
      localJSONObject = new JSONObject();
      if (paramAdvertisementInfo == null) {
        break label212;
      }
      localObject = paramAdvertisementInfo.mAdTxt;
      label91:
      localJSONObject.put("text_title", localObject);
      paramJSONObject.put("id_inner_title", localJSONObject);
      localJSONObject = new JSONObject();
      if (paramAdvertisementInfo == null) {
        break label219;
      }
      localObject = "广告";
      label125:
      localJSONObject.put("text_default", localObject);
      paramJSONObject.put("id_info_status", localJSONObject);
      localJSONObject = new JSONObject();
      if (paramAdvertisementInfo == null) {
        break label226;
      }
    }
    label212:
    label219:
    label226:
    for (Object localObject = paramAdvertisementInfo.mAdCorporateImageName;; localObject = "")
    {
      localJSONObject.put("text_app", localObject);
      paramJSONObject.put("id_view_app", localJSONObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", paramAdvertisementInfo);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      return;
      localObject = "";
      break;
      localObject = "";
      break label91;
      localObject = "";
      break label125;
    }
  }
  
  static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText))
    {
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        paramJSONObject.put("id_info_operate_parent", new JSONObject());
        paramJSONObject.put("id_large_cell_container", new JSONObject());
        localJSONObject1 = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      }
    }
    else {
      try
      {
        if (localJSONObject1.has("AdsIconText"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Util", 2, "detail ad  bindSubscriptText adInconText:" + localJSONObject1.optString("AdsIconText"));
          }
          if (!TextUtils.isEmpty(localJSONObject1.optString("AdsIconText")))
          {
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("info_status_text", localJSONObject1.optString("AdsIconText"));
            localJSONObject3.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
            paramJSONObject.put("id_info_status", localJSONObject3);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("info_status_text", el(paramBaseArticleInfo.mArticleSubscriptText));
    localJSONObject2.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
    paramJSONObject.put("id_info_status", localJSONObject2);
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a != null))
    {
      localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.agI;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("artilce_title_text", localObject1);
      if (!lbz.a().aO(paramBaseArticleInfo.mArticleID)) {
        break label508;
      }
      localObject1 = "#999999";
      ((JSONObject)localObject2).put("title_text_color", localObject1);
      paramJSONObject.put("id_artilce_title", localObject2);
      localObject1 = "";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.agJ)) {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.agJ;
      }
      ((JSONObject)localObject2).put("summary_text", localObject1);
      paramJSONObject.put("id_summary", localObject2);
      i = 12;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_small_imge_url", kxm.c(paramString, Utils.rp2px(114.0D), Utils.rp2px(87.0D)));
        paramJSONObject.put("id_article_small_imge", localObject1);
        i = 7;
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiv)) {
        break label532;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("info_status_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiv);
      paramString = "#fe6c6c";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiw)) {
        paramString = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiw;
      }
      ((JSONObject)localObject1).put("info_status_text_color", paramString);
      ((JSONObject)localObject1).put("setBorderColorString", paramString);
      paramJSONObject.put("id_info_status", localObject1);
      i -= 3;
    }
    label532:
    for (;;)
    {
      localObject2 = new StringBuilder();
      paramString = "0";
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.aRt > 0) {
        paramString = awit.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a.aRt, 990000L, "99万", "0");
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiu))
      {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiu;
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        if (((String)localObject1).length() > i) {
          paramBaseArticleInfo = ((String)localObject1).substring(0, i - 1) + "...";
        }
        ((StringBuilder)localObject2).append(paramBaseArticleInfo).append("的回答 · ").append(paramString).append("赞同");
      }
      for (;;)
      {
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("nickname_text", ((StringBuilder)localObject2).toString());
        paramJSONObject.put("id_nickname", paramBaseArticleInfo);
        return;
        label508:
        localObject1 = "#000000";
        break;
        ((StringBuilder)localObject2).append(paramString).append("赞同");
      }
    }
  }
  
  static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramBaseArticleInfo = jzk.a(paramBaseArticleInfo, BaseApplicationImpl.getContext(), "latitude", "longitude");
    if (!TextUtils.isEmpty(paramBaseArticleInfo))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad_Location", paramBaseArticleInfo);
      paramJSONObject.put("id_view_ad_coordinateView", localJSONObject);
    }
  }
  
  static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("article_model", paramBaseArticleInfo);
      paramJSONObject.put("id_view_AdBanner", localJSONObject);
    }
  }
  
  private static String el(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (kys.dt((int)paramBaseArticleInfo.mChannelID)) {}
    while (paramBaseArticleInfo.isCloseDislike == 1) {
      return;
    }
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    paramJSONObject.put("id_dislike_button", localJSONObject);
  }
  
  private static int g(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = h(paramBaseArticleInfo);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    QLog.d("Util", 1, new Object[] { "getCapsuleMaxStrLen, count = ", Integer.valueOf(i), "len = ", Integer.valueOf(48 / i) });
    return 48 / i;
  }
  
  static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.hasFamilyCommentIcon()))
    {
      i(paramBaseArticleInfo, paramJSONObject);
      return;
    }
    h(paramBaseArticleInfo, paramJSONObject);
  }
  
  private static int h(BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if (paramBaseArticleInfo != null) {
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
      {
        i = 1;
        j = i;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          j = i;
          Object localObject;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i;
            j = i;
            if (!TextUtils.isEmpty(((SocializeFeedsInfo.i)localObject).name))
            {
              j = i;
              if (!TextUtils.isEmpty(((SocializeFeedsInfo.i)localObject).iconUrl)) {
                j = i + 1;
              }
            }
          }
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p;
            int k = ((SocializeFeedsInfo.p)localObject).aSZ;
            long l = ((SocializeFeedsInfo.p)localObject).vR;
            i = j;
            if (kxm.getLongAccountUin() == l)
            {
              i = j;
              if (k != 0) {
                i = j + 1;
              }
            }
          }
          j = i;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d != null)
          {
            paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
            j = i;
            if (!TextUtils.isEmpty(paramBaseArticleInfo.name))
            {
              j = i;
              if (TextUtils.isEmpty(paramBaseArticleInfo.headUrl)) {}
            }
          }
        }
      }
    }
    for (int j = i + 1;; j = 0)
    {
      QLog.d("Util", 1, new Object[] { "getCapsuleCount = ", Integer.valueOf(j) });
      return j;
      i = 0;
      break;
    }
  }
  
  static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    long l = 0L;
    if (paramBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBaseArticleInfo.mCommentCount > 0L)
    {
      l = paramBaseArticleInfo.mCommentCount;
      label41:
      if (!awit.a(paramBaseArticleInfo, l)) {
        break label126;
      }
      if (l <= 99990000L) {
        break label128;
      }
      localStringBuilder.append("9999万+");
      label68:
      if (paramBaseArticleInfo.mFeedType == 39) {
        break label188;
      }
      localStringBuilder.append("评论");
    }
    for (;;)
    {
      localJSONObject.put("article_comment_num", localStringBuilder.toString());
      paramJSONObject.put("id_comment_num", localJSONObject);
      return;
      if (paramBaseArticleInfo.mVideoCommentCount <= 0) {
        break label41;
      }
      l = paramBaseArticleInfo.mVideoCommentCount;
      break label41;
      label126:
      break;
      label128:
      if (l > 10000L)
      {
        double d = l / 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
        break label68;
      }
      localStringBuilder.append(l);
      break label68;
      label188:
      localStringBuilder.append("人在玩");
    }
  }
  
  static void i(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.familyCommentInfo == null)) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.agS)) || (TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.agT))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("family_icon_url", paramBaseArticleInfo.familyCommentInfo.agS);
    localJSONObject.put("family_jump_schema", paramBaseArticleInfo.familyCommentInfo.agT);
    if (paramBaseArticleInfo.familyCommentInfo.BT > 0) {
      localJSONObject.put("family_icon_wh_rate", paramBaseArticleInfo.familyCommentInfo.aOw / paramBaseArticleInfo.familyCommentInfo.BT);
    }
    paramJSONObject.put("id_img_family_icon", localJSONObject);
  }
  
  public static String j(BaseArticleInfo paramBaseArticleInfo)
  {
    int i = 1;
    String str2 = "";
    long l;
    String str1;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.aRW > 0))
    {
      l = paramBaseArticleInfo.mSocialFeedInfo.aRW;
      if (l <= 0L) {
        break label274;
      }
      str1 = kxl.c(l, true);
      label46:
      if ((!ndi.ah(paramBaseArticleInfo)) || (P(paramBaseArticleInfo))) {
        str2 = str1 + " ";
      }
      if ((!ndi.ah(paramBaseArticleInfo)) || (T(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSocialFeedInfo.mFollowStatus != 2)) {
        break label376;
      }
    }
    for (;;)
    {
      if ((paramBaseArticleInfo.mFeedType == 32) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.gameName)))
      {
        str1 = " · " + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.gameName;
        label181:
        if (TextUtils.isEmpty(str1)) {
          break label290;
        }
      }
      for (;;)
      {
        label189:
        Object localObject = str2;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          localObject = str2;
          if (!TextUtils.isEmpty(str1))
          {
            localObject = new StringBuilder().append(str2);
            if ((TextUtils.isEmpty(str2)) || (i == 0)) {
              break label361;
            }
          }
        }
        label274:
        label290:
        label361:
        for (paramBaseArticleInfo = " · ";; paramBaseArticleInfo = "")
        {
          localObject = paramBaseArticleInfo + str1;
          return kxm.E((String)localObject, 36);
          l = paramBaseArticleInfo.mTime;
          break;
          str1 = "";
          break label46;
          str1 = "";
          break label181;
          if (((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) && (ndi.L((ArticleInfo)paramBaseArticleInfo))) || (ndi.S((ArticleInfo)paramBaseArticleInfo)))
          {
            str1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.ahV;
            break label189;
          }
          if (paramBaseArticleInfo.mSocialFeedInfo == null) {
            break label368;
          }
          str1 = paramBaseArticleInfo.mSocialFeedInfo.ahO;
          break label189;
        }
        label368:
        str1 = "";
      }
      label376:
      i = 0;
    }
  }
  
  static void j(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo.mSocialFeedInfo == null) {
      return;
    }
    localObject = new JSONObject();
    long l1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSubscribeID)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        localNumberFormatException.printStackTrace();
        continue;
        ((JSONObject)localObject).put("selected_state", "0");
      }
    }
    ((JSONObject)localObject).put("info_avator_uin", l1);
    ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
    paramJSONObject.put("id_info_avator", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("nickname_text", kxm.ew(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localObject);
    paramJSONObject.put("id_view_nickname", new JSONObject());
    localJSONObject = new JSONObject();
    localObject = "";
    if (paramBaseArticleInfo.mSocialFeedInfo.mCommentCount > 0) {
      localObject = awit.a(paramBaseArticleInfo.mSocialFeedInfo.mCommentCount, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_comment_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("comment_count", "");
    paramJSONObject.put("id_comment_button", localObject);
    localJSONObject = new JSONObject();
    localObject = "";
    if (paramBaseArticleInfo.mSocialFeedInfo.mLikeCount > 0) {
      localObject = awit.a(paramBaseArticleInfo.mSocialFeedInfo.mLikeCount, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_like_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("like_count", "");
    if (paramBaseArticleInfo.mSocialFeedInfo.aSH == 1)
    {
      ((JSONObject)localObject).put("selected_state", "1");
      paramJSONObject.put("id_like_button", localObject);
      paramJSONObject.put("id_share_button", new JSONObject());
      paramJSONObject.put("id_img_biu_right", new JSONObject());
      paramJSONObject.put("id_biu_separator", new JSONObject());
      paramJSONObject.put("id_view_comment", new JSONObject());
      paramJSONObject.put("id_view_like", new JSONObject());
      paramJSONObject.put("id_view_share", new JSONObject());
      paramJSONObject.put("id_img_biu_bottom", new JSONObject());
      return;
    }
  }
  
  private static String k(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSinglePicture != null) && (paramBaseArticleInfo.mNewPolymericInfo != null) && (!paramBaseArticleInfo.mNewPolymericInfo.amy))
    {
      String str = paramBaseArticleInfo.mSinglePicture.getFile();
      Pair localPair = kwz.j();
      str = kxm.c(str, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      paramBaseArticleInfo.mSinglePicture = kxm.b(str);
      paramBaseArticleInfo.mNewPolymericInfo.amy = true;
      if (QLog.isColorLevel()) {
        QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + str);
      }
    }
    return paramBaseArticleInfo.mSinglePicture.getFile();
  }
  
  static void k(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null) || (!paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.DD())) {
      return;
    }
    new JSONObject();
    paramJSONObject.put("star_postmark", "readinjoy_star_postmark.png");
  }
  
  static void l(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo == null) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelIconUrl)) || (TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelText))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramJSONObject.put("id_label_wrapper", localJSONObject);
    paramJSONObject.put("id_label_header", localJSONObject);
    paramJSONObject.put("id_label_separator_line", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_icon_url", paramBaseArticleInfo.mDianDianLabelIconUrl);
    paramJSONObject.put("id_label_icon", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_text", paramBaseArticleInfo.mDianDianLabelText);
    paramJSONObject.put("id_label_text", localJSONObject);
  }
  
  static void m(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject.put("id_separator", new JSONObject());
  }
  
  static void n(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = paramBaseArticleInfo.multiBiuSameContentList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramBaseArticleInfo = new JSONObject();
      localObject = ((List)localObject).iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        MultiBiuSameContent localMultiBiuSameContent = (MultiBiuSameContent)((Iterator)localObject).next();
        paramBaseArticleInfo.put(localMultiBiuSameContent.mUin + "" + i, localMultiBiuSameContent.mUin);
        i += 1;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("uin_list", paramBaseArticleInfo);
      paramJSONObject.put("id_friends_biu", localObject);
      paramJSONObject.put("id_friends_biu_wrapper", new JSONObject());
      paramJSONObject.put("id_friends_biu_separator_line", new JSONObject());
    }
  }
  
  static void o(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      if (1 == ((SocializeFeedsInfo)localObject).aSN)
      {
        paramBaseArticleInfo = ((SocializeFeedsInfo)localObject).ahQ;
        localObject = ((SocializeFeedsInfo)localObject).ahR;
        if ((!TextUtils.isEmpty(paramBaseArticleInfo)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          JSONObject localJSONObject = F();
          localJSONObject.put("jump_channel_bar_url", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_bar", localJSONObject);
          paramBaseArticleInfo = F();
          paramBaseArticleInfo.put("jump_channel_name", localObject);
          paramJSONObject.put("id_jump_channel_name", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_separator", F());
        }
      }
    }
  }
  
  static void p(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if (paramBaseArticleInfo.b != null) {
        kxm.a(paramJSONObject, paramBaseArticleInfo.b);
      }
    }
  }
  
  static void q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (ndi.ah(paramBaseArticleInfo))
    {
      if (X(paramBaseArticleInfo))
      {
        paramJSONObject.put("id_social_header_padding_view", localJSONObject);
        return;
      }
      paramJSONObject.put("id_feeds_social_header_wrapper", localJSONObject);
      paramJSONObject.put("id_feeds_social_header", localJSONObject);
      return;
    }
    paramJSONObject.put("id_social_header_wrapper", localJSONObject);
    paramJSONObject.put("id_social_header", localJSONObject);
  }
  
  static void r(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    new JSONObject();
    paramJSONObject.put("nickname_text", kxm.ew(paramBaseArticleInfo.mSubscribeName));
  }
  
  static void s(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.ahV))
    {
      localJSONObject.put("short_content_desc_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.ahV);
      paramJSONObject.put("id_description_label", localJSONObject);
    }
  }
  
  static void t(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null)) {
      return;
    }
    paramBaseArticleInfo = ReadInJoyUserInfoModule.getDefaultNickName();
    new JSONObject();
    paramJSONObject.put("nickname_text", kxm.ew(paramBaseArticleInfo));
  }
  
  static void u(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramBaseArticleInfo == null) {}
    do
    {
      return;
      paramBaseArticleInfo = j(paramBaseArticleInfo);
    } while (TextUtils.isEmpty(paramBaseArticleInfo));
    paramJSONObject.put("biu_time_text", paramBaseArticleInfo);
  }
  
  static void v(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a == null)) {
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a;
    paramJSONObject.put("id_account_card_container", F());
    paramJSONObject.put("id_cmp_account_card", F());
    JSONObject localJSONObject = F();
    localJSONObject.put("cmp_account_card_avator", paramBaseArticleInfo.ahS);
    paramJSONObject.put("id_cmp_account_card_avator", localJSONObject);
    localJSONObject = F();
    localJSONObject.put("cmp_account_card_name", paramBaseArticleInfo.accountNick);
    paramJSONObject.put("id_cmp_account_card_name", localJSONObject);
    localJSONObject = F();
    localJSONObject.put("cmp_account_card_desc", paramBaseArticleInfo.ahT);
    paramJSONObject.put("id_cmp_account_card_desc", localJSONObject);
  }
  
  static void w(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!R(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicRecommendHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_name", paramBaseArticleInfo.businessNamePrefix + paramBaseArticleInfo.businessName);
    paramJSONObject.put("id_topic_name", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_avator_url", ((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).picUrl);
    paramJSONObject.put("id_topic_avator", localObject);
    y(paramBaseArticleInfo, paramJSONObject);
    JSONObject localJSONObject;
    int i;
    if ((kxm.i((ArticleInfo)paramBaseArticleInfo)) || (kxm.l((ArticleInfo)paramBaseArticleInfo)))
    {
      localJSONObject = new JSONObject();
      if (((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).isFollow != 1) {
        break label325;
      }
      i = 1;
      if (i == 0) {
        break label330;
      }
    }
    label325:
    label330:
    for (localObject = "1";; localObject = "0")
    {
      localJSONObject.put("selected_status", localObject);
      paramJSONObject.put("id_follow_button", localJSONObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_name_only", paramBaseArticleInfo.businessName);
      paramJSONObject.put("id_topic_name_only", localObject);
      paramJSONObject.put("id_topic_more", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_pre", paramBaseArticleInfo.businessNamePrefix);
      paramJSONObject.put("id_topic_pre", localObject);
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("topic_arrow_img", "topic_arrow_image");
      paramJSONObject.put("id_topic_arrow_img", paramBaseArticleInfo);
      return;
      i = 0;
      break;
    }
  }
  
  static void x(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject = BaseApplicationImpl.getContext();
    if ((!R(paramBaseArticleInfo)) || (localObject == null))
    {
      QLog.d("Util", 1, "bindTopicPackHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    localObject = (mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("topic_name", ((mih.b)localObject).businessNamePrefix + " " + ((mih.b)localObject).businessName);
    paramJSONObject.put("id_topic_name", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("topic_avator_url", ((mih.b)localObject).picUrl);
    paramJSONObject.put("id_topic_avator", localJSONObject);
    paramJSONObject.put("id_topic_recommend_biu_time", new JSONObject());
    localObject = new JSONObject();
    int i;
    if (((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).isFollow == 1)
    {
      i = 1;
      if (i == 0) {
        break label238;
      }
    }
    label238:
    for (paramBaseArticleInfo = "1";; paramBaseArticleInfo = "0")
    {
      ((JSONObject)localObject).put("selected_status", paramBaseArticleInfo);
      paramJSONObject.put("id_follow_button", localObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      return;
      i = 0;
      break;
    }
  }
  
  static void y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!R(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicTimeAndReason failed, not topicInfo.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((kxm.j((ArticleInfo)paramBaseArticleInfo)) || (kxm.m((ArticleInfo)paramBaseArticleInfo)))
    {
      if (paramBaseArticleInfo.mTime > 0L) {
        localStringBuilder.append(kxl.c(paramBaseArticleInfo.mRecommendTime, true));
      }
    }
    else if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mTopicRecommendFeedsInfo.aiI)) {
        break label141;
      }
      localStringBuilder.append(paramBaseArticleInfo.mTopicRecommendFeedsInfo.aiI);
    }
    for (;;)
    {
      paramJSONObject.put("id_topic_recommend_biu_time", new JSONObject());
      return;
      localStringBuilder.append("刚刚");
      break;
      label141:
      if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0) != null) {
        localStringBuilder.append(awit.gL(((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).aTk) + "人参与");
      }
    }
  }
  
  static void z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = null;
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindCommonInfo, info or outData is null.");
      return;
    }
    a(paramBaseArticleInfo, paramJSONObject, true);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_large_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_small_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_small_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("text", paramBaseArticleInfo.mSubscribeName);
    paramJSONObject.put("id_subcribe_name", localObject1);
    Object localObject4 = "";
    Object localObject5 = "";
    String str = "";
    Object localObject2;
    Object localObject3;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localJSONArray = ndi.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = str;
      if (localJSONArray != null)
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = str;
        if (localJSONArray.length() >= 3)
        {
          localObject1 = localJSONArray.optJSONObject(0);
          if (localObject1 != null) {
            break label324;
          }
          localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
          localObject1 = localJSONArray.optJSONObject(1);
          if (localObject1 != null) {
            break label335;
          }
          localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;
          label222:
          localObject1 = localJSONArray.optJSONObject(2);
          if (localObject1 != null) {
            break label347;
          }
        }
      }
      label324:
      label335:
      label347:
      for (localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject1 = ((JSONObject)localObject1).optString("picture"))
      {
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        localObject4 = localObject2;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url1", localObject4);
        paramJSONObject.put("id_multi_img_1", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject3);
        paramJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", paramBaseArticleInfo);
        paramJSONObject.put("id_multi_img_3", localObject1);
        return;
        localObject2 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject3 = ((JSONObject)localObject1).optString("picture");
        break label222;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label381:
      if (localObject1 == null) {
        break label485;
      }
      localObject1 = ((URL)localObject1).getFile();
      label390:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label490;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label413:
      if (localObject2 == null) {
        break label500;
      }
      localObject2 = ((URL)localObject2).getFile();
      label422:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label505;
      }
    }
    label485:
    label490:
    label500:
    label505:
    for (localObject5 = paramBaseArticleInfo.mSinglePicture;; localObject5 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = localObject1;
      localObject3 = localObject2;
      paramBaseArticleInfo = localJSONArray;
      if (localObject5 == null) {
        break;
      }
      paramBaseArticleInfo = ((URL)localObject5).getFile();
      localObject4 = localObject1;
      localObject3 = localObject2;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label381;
      localObject1 = null;
      break label390;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label413;
      localObject2 = null;
      break label422;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llu
 * JD-Core Version:    0.7.0.1
 */