import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class tjw
{
  private static Bundle a(spk paramspk, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label278:
    label288:
    int i;
    label372:
    Bundle localBundle2;
    if (paramspk.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label878;
      }
      localBundle1.putString("VIDEO_H5_URL", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", pkg.a(((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramspk.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramspk.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramspk.jdField_d_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramspk.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramspk.jdField_b_of_type_JavaLangString);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_SUMMARY", paramBaseArticleInfo.mTitle);
      if (paramspk.jdField_f_of_type_Int != 6) {
        break label907;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      if (paramspk.jdField_f_of_type_Int != 1) {
        break label932;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label937;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramspk.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramspk.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramspk.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramspk.jdField_g_of_type_JavaLangString);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramspk.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramspk.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramspk.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_START_POSI", spm.a(0, paramspk.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramspk.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramspk.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramspk.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramspk.jdField_f_of_type_Int != 1) {
        break label942;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramspk.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramspk.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramspk.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", pkg.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle2.putInt("req_type", 140);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdof.a(localBundle2)).getBytes());
      return localBundle1;
      if (paramspk.jdField_f_of_type_Int == 6)
      {
        if (ppe.g(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaLangString);
          if (ppe.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((rrs)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label878:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", pkg.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label907:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label278;
      label932:
      bool = false;
      break label288;
      label937:
      i = 1;
      break label372;
      label942:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "https://puui.qpic.cn/qqvideo_ori/0/" + paramString1 + "_496_280/0";
    pqx.a(paramString1, paramString3, paramString2, paramString4, new tjx());
    return str;
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    spk localspk = new spk();
    localspk.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localspk.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localspk.h = paramArticleInfo.thirdUin;
    localspk.i = paramArticleInfo.thirdUinName;
    localspk.k = paramArticleInfo.mSubscribeID;
    localspk.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localspk.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    rqa localrqa = new rqa();
    localrqa.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localrqa.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    localspk.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
    localspk.jdField_f_of_type_Int = paramArticleInfo.busiType;
    localspk.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
    localspk.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
    localrqa.jdField_a_of_type_Int = paramArticleInfo.busiType;
    localspk.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localspk.jdField_b_of_type_JavaLangString = str;
      localspk.j = paramArticleInfo.innerUniqueID;
      localrqa.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localspk.a = localrqa;
      localspk.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localspk.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
      localspk.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
      new rqg().jdField_a_of_type_Int = 409409;
      a(paramActivity, localspk, paramArticleInfo);
      return;
    }
  }
  
  public static void a(Activity paramActivity, spk paramspk, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramspk.jdField_d_of_type_Long + ",vid : " + paramspk.jdField_c_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramspk, paramBaseArticleInfo);
    if (paramspk.jdField_f_of_type_Int == 2)
    {
      localObject = swx.a(paramspk.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((sxc)localObject).jdField_a_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((sxc)localObject).b);
      }
    }
    localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    localBundle.putInt("VIDEO_FROM_TYPE", 10);
    Object localObject = new Intent(paramActivity, VideoFeedsPlayActivity.class);
    ((Intent)localObject).addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      localBundle.putBoolean("param_needSmooth", sqp.a().d());
      sqp.a().d(true);
      localBundle.putBoolean("param_needAlertInXg", sge.d());
    }
    if (paramspk.jdField_f_of_type_Int == 6) {
      localBundle.putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
    }
    ((Intent)localObject).putExtras(localBundle);
    int i = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i = 1;
    }
    for (;;)
    {
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      int j = 0;
      try
      {
        boolean bool = plw.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        j = bool;
      }
      catch (Exception paramspk)
      {
        label321:
        break label321;
      }
      if (j == 0) {
        break;
      }
      paramspk = new Intent();
      paramspk.putExtras(localBundle);
      ssn.a(paramActivity, paramspk, i);
      paramActivity.overridePendingTransition(2130772011, 2130772012);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
    paramActivity.startActivityForResult((Intent)localObject, i);
    paramActivity.overridePendingTransition(2130772070, 2130772071);
  }
  
  public static void a(List<BaseData> paramList, String paramString, int paramInt1, int paramInt2)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          ;;
          while (TextUtils.isEmpty(paramString)) {}
          paramList = paramList.iterator();
        } while (!paramList.hasNext());
        localObject = (BaseData)paramList.next();
      } while (!(localObject instanceof ProteusItemData));
      localObject = (ProteusItemData)localObject;
    } while (((ProteusItemData)localObject).u != 3);
    a(((ProteusItemData)localObject).c, paramString, paramInt1, paramInt2);
  }
  
  public static void a(JSONObject paramJSONObject, Activity paramActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    try
    {
      int i = paramJSONObject.getInt("mVideoJsonWidth");
      int j = paramJSONObject.getInt("mVideoJsonHeight");
      String str = paramJSONObject.getString("mVideoVid");
      int k = paramJSONObject.getInt("busiType");
      paramJSONObject = paramJSONObject.getString("mVideoCoverUrl");
      ArticleInfo localArticleInfo = new ArticleInfo();
      localArticleInfo.mVideoJsonWidth = i;
      localArticleInfo.mVideoJsonHeight = j;
      localArticleInfo.mVideoVid = str;
      localArticleInfo.busiType = k;
      localArticleInfo.mVideoCoverUrl = pqa.a(paramJSONObject);
      localArticleInfo.mArticleContentUrl = paramArticleInfo.mArticleContentUrl;
      localArticleInfo.mTitle = paramArticleInfo.mTitle;
      paramJSONObject = new JSONObject();
      if (paramFastWebArticleInfo != null)
      {
        localArticleInfo.thirdIcon = paramFastWebArticleInfo.jdField_g_of_type_JavaLangString;
        localArticleInfo.thirdName = paramFastWebArticleInfo.jdField_e_of_type_JavaLangString;
        localArticleInfo.thirdUin = String.valueOf(paramFastWebArticleInfo.jdField_d_of_type_Long);
        if (!paramFastWebArticleInfo.c()) {
          break label197;
        }
      }
      label197:
      for (paramJSONObject = "2";; paramJSONObject = "1")
      {
        paramJSONObject = pqf.a(paramActivity, paramArticleInfo, 0, paramJSONObject);
        paramJSONObject.put("vedio_rowkey", str);
        tkj.a(paramArticleInfo, "0X800898F", paramJSONObject.toString());
        a(paramActivity, localArticleInfo);
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "handleVideoClick error! msg=" + paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      paramJSONObject.put("mVideoJsonWidth", paramInt1);
      paramJSONObject.put("mVideoJsonHeight", paramInt2);
      paramJSONObject.put("mVideoCoverUrl", paramString);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "updateVideoInfo error! msg=" + paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    try
    {
      paramJSONObject.put("articleImageUrl", paramString1);
      paramJSONObject.put("play_icon", "video_play_icon");
      paramJSONObject.put("style_ID", "ReadInjoy_article_video_cell");
      paramJSONObject.put("lineup", "0");
      paramJSONObject.put("vedio_rowkey", paramString2);
      paramJSONObject.put("mVideoVid", paramString2);
      paramJSONObject.put("busiType", paramInt3);
      a(paramJSONObject, paramString1, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "insertDynamicData error! msg=" + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjw
 * JD-Core Version:    0.7.0.1
 */