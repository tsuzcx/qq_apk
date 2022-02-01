import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class lng
  implements lpi
{
  private void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, ndi paramndi)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramBaseArticleInfo.mVideoDownloadBarInfo.get() != null))
    {
      localUrlJumpInfo = UrlJumpInfo.a(paramBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info);
      if (localUrlJumpInfo != null) {
        muj.a(paramContext, localUrlJumpInfo);
      }
    }
    while (paramndi == null)
    {
      UrlJumpInfo localUrlJumpInfo;
      do
      {
        return;
      } while (paramndi == null);
      paramndi.a(ndi.a(paramBaseArticleInfo), paramBaseArticleInfo, false, false);
      return;
    }
    paramndi.a(ndi.a(paramBaseArticleInfo), paramBaseArticleInfo, false, false);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null)) {
      return;
    }
    if (paramBaseArticleInfo.mVideoColumnInfo != null) {}
    for (int i = paramBaseArticleInfo.mVideoColumnInfo.aHc;; i = -1)
    {
      if (paramBoolean) {}
      for (int j = 0;; j = 1)
      {
        paramBaseArticleInfo = new nce.a(null, null, null, null).W(Integer.valueOf("1031").intValue()).h(paramBaseArticleInfo.getInnerUniqueID()).ab(j).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).u(paramBaseArticleInfo.mSubscribeName).f(paramBaseArticleInfo);
        if (i != -1) {
          paramBaseArticleInfo.aa(i);
        }
        paramBaseArticleInfo = paramBaseArticleInfo.a().toJsonString();
        kbp.a(null, null, "0X8007625", "0X8007625", 0, 0, "", "", "", paramBaseArticleInfo, false);
        kbp.a(null, null, "0X800A5A9", "0X800A5A9", 0, 0, "", "", "", paramBaseArticleInfo, false);
        return;
      }
    }
  }
  
  private void b(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    TextView localTextView;
    if ((paramBaseArticleInfo != null) && (paramViewBase != null) && ((paramViewBase.getNativeView() instanceof TextView)))
    {
      localTextView = (TextView)paramViewBase.getNativeView();
      if (!lbz.a().aO(paramBaseArticleInfo.mArticleID)) {
        break label51;
      }
    }
    label51:
    for (paramViewBase = "#999999";; paramViewBase = "#000000")
    {
      localTextView.setTextColor(Color.parseColor(paramViewBase));
      return;
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
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.size() == 0) || (paramBaseArticleInfo.mSubArtilceList.get(0) == null)) {
      return new JSONObject();
    }
    localJSONObject1 = paramBaseArticleInfo.getProteusItemData();
    if (localJSONObject1 == null) {
      return null;
    }
    localJSONObject2 = new JSONObject();
    localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    str1 = paramBaseArticleInfo.getInnerUniqueID();
    str2 = localBaseArticleInfo.getInnerUniqueID();
    str3 = "[" + str1 + "," + str2 + "]";
    localJSONObject3 = new JSONObject();
    localJSONObject3.put("all_rowkey", str3);
    localObject3 = null;
    localObject1 = null;
    localObject4 = null;
    localObject8 = null;
    localObject7 = null;
    localObject2 = localObject3;
    try
    {
      if (paramBaseArticleInfo.mVideoColumnInfo != null)
      {
        localObject2 = localObject3;
        localObject1 = String.valueOf(paramBaseArticleInfo.mVideoColumnInfo.aHc);
      }
      localObject2 = localObject1;
      if (localBaseArticleInfo.mVideoColumnInfo == null) {
        break label1359;
      }
      localObject2 = localObject1;
      paramInt = localBaseArticleInfo.mVideoColumnInfo.aHc;
      localObject2 = String.valueOf(paramInt);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject7;
            localObject5 = localObject2;
            localObject6 = localObject1;
            localObject4 = localObject8;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject4 = localObject8;
              localObject3 = "[" + (String)localObject1 + "," + (String)localObject2 + "]";
              localObject4 = localObject3;
              localJSONObject3.put("column_id", localObject3);
              localObject6 = localObject1;
              localObject5 = localObject2;
            }
          }
          localJSONObject3.put("double_videocard_jump_page", localJSONObject1.optString("double_videocard_jump_page"));
          localJSONObject3.put("double_videocard_jump_src", localJSONObject1.optString("double_videocard_jump_src"));
          localJSONObject2.put("id_double_video_cell", localJSONObject3);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("rowkey_1", str1);
          ((JSONObject)localObject1).put("column_id_1", localObject6);
          ((JSONObject)localObject1).put("double_videocard_jump_page", localJSONObject1.optString("double_videocard_jump_page"));
          ((JSONObject)localObject1).put("double_videocard_jump_src", localJSONObject1.optString("double_videocard_jump_src"));
          ((JSONObject)localObject1).put("article_jump_url_1", localJSONObject1.optString("article_jump_url_1"));
          localJSONObject2.put("id_container_1", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("cover_image_url_1", kxm.c(paramBaseArticleInfo.mFirstPagePicUrl, aqnm.dpToPx(180.5F), aqnm.dpToPx(102.0F)));
          localJSONObject2.put("cover_image_1", localObject1);
          localJSONObject2.put("id_paly_wrapper_1", new JSONObject());
          localObject1 = new JSONObject();
          localObject2 = muj.a(paramBaseArticleInfo.mVideoDuration * 1000);
          if (localObject2 != null)
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              ((JSONObject)localObject1).put("video_duration_1", localObject2);
              localJSONObject2.put("id_video_play_duration_1", localObject1);
            }
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("article_title_1", paramBaseArticleInfo.mTitle);
          if (!lbz.a().aO(paramBaseArticleInfo.mArticleID)) {
            continue;
          }
          localObject1 = "#999999";
          ((JSONObject)localObject2).put("article_title_1_color", localObject1);
          ((JSONObject)localObject2).put("article_title_1_textsize", kyu.getFontSize());
          localJSONObject2.put("id_artilce_title_1", localObject2);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("info_source_1", paramBaseArticleInfo.mSubscribeName);
          localObject1 = "#A6A6A6";
          if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptColor)) {
            localObject1 = paramBaseArticleInfo.mArticleSubscriptColor;
          }
          ((JSONObject)localObject2).put("info_source_color1", localObject1);
          localJSONObject2.put("id_info_source", localObject2);
          localObject1 = new JSONObject();
          if (!TextUtils.isEmpty(muj.by(paramBaseArticleInfo.mVideoCommentCount))) {
            localJSONObject2.put("id_comment_num", localObject1);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("rowkey_2", str2);
          ((JSONObject)localObject1).put("column_id_2", localObject5);
          ((JSONObject)localObject1).put("double_videocard_jump_page", localJSONObject1.optString("double_videocard_jump_page"));
          ((JSONObject)localObject1).put("double_videocard_jump_src", localJSONObject1.optString("double_videocard_jump_src"));
          ((JSONObject)localObject1).put("article_jump_url_2", localJSONObject1.optString("article_jump_url_2"));
          localJSONObject2.put("id_container_1", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("cover_image_url_2", kxm.c(localBaseArticleInfo.mFirstPagePicUrl, aqnm.dpToPx(180.5F), aqnm.dpToPx(102.0F)));
          localJSONObject2.put("cover_image_2", localObject1);
          localJSONObject2.put("id_play_wrapper_2", new JSONObject());
          localObject1 = new JSONObject();
          localObject2 = muj.a(localBaseArticleInfo.mVideoDuration * 1000);
          if (localObject2 != null)
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              ((JSONObject)localObject1).put("video_duration_2", localObject2);
              localJSONObject2.put("id_video_play_duration_2", localObject1);
            }
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("article_title_2", localBaseArticleInfo.mTitle);
          if (!lbz.a().aO(localBaseArticleInfo.mArticleID)) {
            continue;
          }
          localObject1 = "#999999";
          ((JSONObject)localObject2).put("article_title_2_color", localObject1);
          ((JSONObject)localObject2).put("article_title_2_textsize", kyu.getFontSize());
          localJSONObject2.put("id_artilce_title_2", localObject2);
          localObject2 = new JSONObject();
          localObject1 = "#A6A6A6";
          if (!TextUtils.isEmpty(localBaseArticleInfo.mArticleSubscriptColor)) {
            localObject1 = localBaseArticleInfo.mArticleSubscriptColor;
          }
          ((JSONObject)localObject2).put("info_source_color2", localObject1);
          ((JSONObject)localObject2).put("info_source_2", localBaseArticleInfo.mSubscribeName);
          localJSONObject2.put("id_info_source_2", localObject2);
          localObject1 = new JSONObject();
          if (!TextUtils.isEmpty(muj.by(localBaseArticleInfo.mVideoCommentCount))) {
            localJSONObject2.put("id_comment_num_2", localObject1);
          }
          localJSONObject2.put("style_ID", "ReadInjoy_double_short_video_cell");
          localJSONObject1.put("all_rowkey", str3);
          localJSONObject1.put("column_id", localObject3);
          localJSONObject1.put("columnId_1", localObject6);
          localJSONObject1.put("columnId_2", localObject5);
          localJSONObject1.put("rowKey_1", str1);
          localJSONObject1.put("rowKey_2", str2);
          localJSONObject1.put("subscript", "[" + paramBaseArticleInfo.mSubscribeName + "," + localBaseArticleInfo.mSubscribeName + "]");
          localJSONObject1.put("subscript_1", paramBaseArticleInfo.mSubscribeName);
          localJSONObject1.put("subscript_2", localBaseArticleInfo.mSubscribeName);
          paramBaseArticleInfo.proteusItemsData = localJSONObject1.toString();
          return localJSONObject2;
        }
        catch (Exception localException2)
        {
          Object localObject5;
          Object localObject6;
          continue;
        }
        localException1 = localException1;
        localObject3 = null;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject5 = localObject2;
        localObject6 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("DoubleShortVideoProteus", 2, "getDataJson: " + localException1.getMessage());
          localObject3 = localObject4;
          localObject5 = localObject2;
          localObject6 = localObject1;
          continue;
          localObject1 = "#000000";
          continue;
          localObject1 = "#000000";
          continue;
          localObject2 = null;
        }
      }
    }
    localObject3 = localObject7;
    localObject5 = localObject2;
    localObject6 = localObject1;
    localObject4 = localObject8;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if (paramContainer == null) {}
    do
    {
      return;
      b(paramContainer.findViewBaseByName("id_artilce_title_1"), paramlie.a());
    } while ((paramlie.a() == null) || (paramlie.a().mSubArtilceList == null) || (paramlie.a().mSubArtilceList.size() <= 0) || (paramlie.a().mSubArtilceList.get(0) == null));
    b(paramContainer.findViewBaseByName("id_artilce_title_2"), (BaseArticleInfo)paramlie.a().mSubArtilceList.get(0));
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new lnh(this, paramlie, paramInt, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lng
 * JD-Core Version:    0.7.0.1
 */