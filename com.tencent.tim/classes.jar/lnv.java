import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lnv
  implements lpi
{
  private String F(String paramString, int paramInt)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("click_area", Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("jump_report_info", paramString1);
    }
    if ((paramInt == 2) && (!TextUtils.isEmpty(paramString2))) {
      localHashMap.put("click_rowkey", paramString2);
    }
    if (mgk.a().a(paramArticleInfo, false, mgk.aRi)) {
      localHashMap.put("jump_src", Integer.valueOf(mgn.j(paramArticleInfo)));
    }
    ndi.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    paramInt = 0;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo.iO.size() == 0) || (paramBaseArticleInfo.multiVideoColumnInfo.iO.get(0) == null)) {
      return new JSONObject();
    }
    Object localObject1 = BaseApplicationImpl.getContext();
    if (localObject1 != null) {}
    for (localObject1 = ((Context)localObject1).getResources().getString(2131718437);; localObject1 = "")
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      paramBaseArticleInfo = paramBaseArticleInfo.multiVideoColumnInfo;
      Object localObject2;
      if (paramBaseArticleInfo.amw)
      {
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribed_card_cell");
        paramInt = 0;
        if (paramInt < paramBaseArticleInfo.iO.size())
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("style_ID", "ReadInJoy_multi_video_subscribed_video_cell");
          mie localmie = (mie)paramBaseArticleInfo.iO.get(paramInt);
          ((JSONObject)localObject2).put("video_jump_url", localmie.a.jumpUrl);
          ((JSONObject)localObject2).put("video_cover_url", localmie.picUrl);
          ((JSONObject)localObject2).put("video_title_text", localmie.title);
          ((JSONObject)localObject2).put("rowkey", localmie.rowKey);
          String str1 = awit.gM(localmie.playCount);
          String str2 = awit.gN(localmie.duration);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localmie.playCount > 0)) {
            ((JSONObject)localObject2).put("video_info_text", String.format((String)localObject1, new Object[] { str1, str2 }));
          }
          for (;;)
          {
            localJSONArray.put(paramInt, localObject2);
            paramInt += 1;
            break;
            ((JSONObject)localObject2).put("video_info_text", str2);
          }
        }
      }
      else
      {
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribe_card_cell");
        localJSONObject.put("bottom_color", paramBaseArticleInfo.color);
        localJSONObject.put("topic_desc_text", paramBaseArticleInfo.ahl);
        localJSONObject.put("bg_cover_img_url", paramBaseArticleInfo.bgUrl);
        while (paramInt < paramBaseArticleInfo.iO.size())
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("style_ID", "ReadInJoy_multi_video_subscribe_video_cell");
          localObject2 = (mie)paramBaseArticleInfo.iO.get(paramInt);
          ((JSONObject)localObject1).put("video_jump_url", ((mie)localObject2).a.jumpUrl);
          ((JSONObject)localObject1).put("video_cover_url", ((mie)localObject2).picUrl);
          ((JSONObject)localObject1).put("video_title_text", ((mie)localObject2).title);
          ((JSONObject)localObject1).put("rowkey", ((mie)localObject2).rowKey);
          ((JSONObject)localObject1).put("video_duration_text", awit.gN(((mie)localObject2).duration));
          localJSONArray.put(paramInt, localObject1);
          paramInt += 1;
        }
      }
      localJSONObject.put("column_data", localJSONArray);
      localJSONObject.put("topic_title_text", paramBaseArticleInfo.columnName);
      localJSONObject.put("from_text", F(paramBaseArticleInfo.appName, 20));
      localJSONObject.put("from_icon_url", paramBaseArticleInfo.appIconUrl);
      localJSONObject.put("title_icon_url", paramBaseArticleInfo.ahk);
      QLog.d("multiVideoColumnInfo", 1, localJSONObject.toString());
      return localJSONObject;
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo == null) || (localArticleInfo.multiVideoColumnInfo == null)) {
      return;
    }
    ViewBase localViewBase = paramContainer.getVirtualView();
    if (localArticleInfo.multiVideoColumnInfo.updateCount > 0) {
      if (localArticleInfo.multiVideoColumnInfo.updateCount <= 99) {
        break label167;
      }
    }
    label167:
    for (Object localObject = "99+";; localObject = Integer.toString(localArticleInfo.multiVideoColumnInfo.updateCount))
    {
      localObject = String.format(paramContainer.getContext().getResources().getString(2131718438), new Object[] { localObject });
      TextBase localTextBase = (TextBase)localViewBase.findViewBaseByName("id_topic_bubble");
      if (localTextBase != null)
      {
        localTextBase.setVisibility(0);
        localTextBase.setText((CharSequence)localObject);
      }
      localObject = (ltp)localViewBase.findViewBaseByName("id_column_list");
      ((ltp)localObject).setModel(paramlie);
      ((ltp)localObject).a(new lnw(this, localArticleInfo, paramContainer));
      ((ltp)localObject).a(new lnx(this, localArticleInfo, paramContainer));
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramViewBase.getClickEvnet();
      } while ((TextUtils.isEmpty(str)) || (!str.startsWith("multi_video_column_")));
      paramlie = paramlie.a();
      if ("multi_video_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new lny(this, paramlie, paramContainer));
        return true;
      }
    } while (!"multi_video_column_tail_click".equals(str));
    paramViewBase.setOnClickListener(new lnz(this, paramlie, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnv
 * JD-Core Version:    0.7.0.1
 */