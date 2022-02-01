import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class lni
  implements lpi
{
  private Map<String, Object> a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return null;
    }
    return paramTemplateBean.getDataAttribute(paramViewBase.getName());
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    Object localObject1;
    boolean bool2;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
      localJSONObject = new JSONObject();
      paramInt = awit.Qh();
      bool2 = awit.aMN();
      if (paramBaseArticleInfo == null) {}
    }
    try
    {
      i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label827;
      }
      muj.bz(i);
      label74:
      if (bool2)
      {
        localJSONObject.put("left_play_count", muj.bw(paramBaseArticleInfo.mVideoPlayCount));
        localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
      }
      localJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!aqiw.isWifiConnected(BaseApplicationImpl.getContext()))) {
        break label993;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        boolean bool1;
        Object localObject2;
        Object localObject3;
        label827:
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
        continue;
        localJSONObject.put("right_cover_image_url", localException.getVideoCoverUrlWithSmartCut(true).getFile());
        continue;
        if (((VideoColumnInfo)localObject2).aHc != 0)
        {
          localJSONObject.put("column_tips_left", "栏目");
          localJSONObject.put("column_name_left", ((VideoColumnInfo)localObject2).columnName);
          localJSONObject.put("readinjoy_column_icon_left", "readinjoy_column_icon_white");
        }
        if (((VideoColumnInfo)localObject3).aHc != 0)
        {
          localJSONObject.put("column_tips_right", "栏目");
          localJSONObject.put("column_name_right", ((VideoColumnInfo)localObject3).columnName);
          localJSONObject.put("readinjoy_column_icon_right", "readinjoy_column_icon_white");
          continue;
          String str = "";
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          localObject2 = "";
        }
      }
    }
    paramBaseArticleInfo.isShowGif = bool1;
    if (paramBaseArticleInfo.isShowGif)
    {
      localJSONObject.put("left_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      localJSONObject.put("left_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      long l;
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        localJSONObject.put("left_account_uin", l + "");
        localObject2 = kxm.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("left_account_small_icon_url", localObject2);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        localJSONObject.put("left_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        localObject3 = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "#00a5e0";
        }
        localJSONObject.put("left_item_subscript_bg_color", localObject2);
      }
      if (localObject1 != null)
      {
        i = ((BaseArticleInfo)localObject1).getCommentCount();
        if (i <= 0) {
          break label867;
        }
        muj.bz(i);
        if (bool2)
        {
          localJSONObject.put("right_play_count", muj.bw(((BaseArticleInfo)localObject1).mVideoPlayCount));
          localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        }
        localJSONObject.put("right_article_title", ((BaseArticleInfo)localObject1).mTitle);
        if ((!((BaseArticleInfo)localObject1).isUseGif) || (!aqiw.isWifiConnected(BaseApplicationImpl.getContext()))) {
          break label999;
        }
        bool1 = true;
        ((BaseArticleInfo)localObject1).isShowGif = bool1;
        if (!((BaseArticleInfo)localObject1).isShowGif) {
          break label870;
        }
        localJSONObject.put("right_cover_gif", ((BaseArticleInfo)localObject1).gifCoverUrl);
        localJSONObject.put("right_cover_url", ((BaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true).getFile());
        if ((((BaseArticleInfo)localObject1).isAccountShown) && (((BaseArticleInfo)localObject1).mPartnerAccountInfo != null))
        {
          l = ((BaseArticleInfo)localObject1).mPartnerAccountInfo.uint64_uin.get();
          localJSONObject.put("right_account_uin", l + "");
          localObject2 = kxm.a(((BaseArticleInfo)localObject1).mPartnerAccountInfo.bytes_v_icon_url);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("right_account_small_icon_url", localObject2);
          }
        }
        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).mVideoArticleSubsColor))
        {
          localJSONObject.put("right_item_subscript_text", ((BaseArticleInfo)localObject1).mVideoArticleSubsText);
          localObject3 = ((BaseArticleInfo)localObject1).mVideoArticleSubsColor;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = "#00a5e0";
          }
          localJSONObject.put("right_item_subscript_bg_color", localObject2);
        }
      }
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.columnEntrances != null) && (!paramBaseArticleInfo.columnEntrances.isEmpty()) && (localObject1 != null) && (((BaseArticleInfo)localObject1).columnEntrances != null) && (!((BaseArticleInfo)localObject1).columnEntrances.isEmpty()))
      {
        localObject2 = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
        localObject3 = (VideoColumnInfo)((BaseArticleInfo)localObject1).columnEntrances.get(0);
        if ((localObject2 != null) && (localObject3 != null))
        {
          if ((((VideoColumnInfo)localObject2).aHc == 0) || (((VideoColumnInfo)localObject2).aHc != ((VideoColumnInfo)localObject3).aHc)) {
            break label891;
          }
          llu.am(paramBaseArticleInfo, localJSONObject);
        }
      }
      localJSONObject.put("title_num", paramInt + "");
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
        break label1005;
      }
      localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.aHc);
      localJSONObject.put("column_id_1", localObject2);
      if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
        break label986;
      }
      localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.aHc);
      localJSONObject.put("column_id_2", localObject1);
      localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      llu.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      break label74;
      localJSONObject.put("left_cover_image_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = paramlie.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label105;
      }
    }
    label105:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        lrh.a(paramContainer, paramlie, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        lrh.a(paramContainer, paramlie, "id_right_account_name");
      }
      lri.a(localArticleInfo2, paramContainer, paramlie);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {}
    for (paramContainer = (ArticleInfo)localArticleInfo.mSubArtilceList.get(0); (localArticleInfo == null) || (paramContainer == null); paramContainer = null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1124: 
      if (("id_left_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_left_item_gif_imageview".equals(paramViewBase.getViewId())))
      {
        VideoReport.setElementId(paramViewBase.getNativeView(), "card");
        VideoReport.setElementParams(paramViewBase.getNativeView(), new lal().a(localArticleInfo.mChannelID).a(localArticleInfo.innerUniqueID).build());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), localArticleInfo.innerUniqueID);
      }
      paramViewBase.setOnClickListener(new lnj(this, paramlie, localArticleInfo));
      return true;
    case 1125: 
      if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
      {
        VideoReport.setElementId(paramViewBase.getNativeView(), "card");
        VideoReport.setElementParams(paramViewBase.getNativeView(), new lal().a(paramContainer.mChannelID).a(paramContainer.innerUniqueID).build());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramContainer.innerUniqueID);
      }
      paramViewBase.setOnClickListener(new lnk(this, paramlie, paramContainer, localArticleInfo));
      return true;
    case 1157: 
    case 1158: 
      paramViewBase.setOnClickListener(new lnl(this, paramInt, paramlie, localArticleInfo, paramContainer));
      return true;
    case 1159: 
    case 1160: 
      paramViewBase.setOnClickListener(new lnm(this, paramInt, paramlie, localArticleInfo, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new lnn(this, localArticleInfo, paramlie));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lni
 * JD-Core Version:    0.7.0.1
 */