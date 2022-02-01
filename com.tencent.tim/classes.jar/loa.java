import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loa
  implements lpi
{
  private void c(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject = paramArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (mhr.a)((mhr)localObject).iP.get(paramInt);
    localHashMap.put("rowkey", ((mhr.a)localObject).ahs);
    if (!TextUtils.isEmpty(((mhr.a)localObject).aha)) {
      localHashMap.put("jump_report_info", ((mhr.a)localObject).aha);
    }
    ndi.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  private void c(ArticleInfo paramArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
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
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    mhr localmhr = paramBaseArticleInfo.mNewPolymericInfo;
    localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
    localJSONObject1.put("common_header_text", localmhr.ahm);
    localJSONObject1.put("topic_header_big_icon_url", localmhr.topIconUrl);
    localJSONObject1.put("topic_header_small_icon_url", localmhr.ahp);
    localJSONObject1.put("topic_header_desc_text", localmhr.ahn);
    String str2;
    String str1;
    label175:
    label177:
    mhr.a locala;
    switch (localmhr.aRY)
    {
    default: 
      localJSONObject1.put("empty_header_visibility", "1");
      switch (localmhr.aRZ)
      {
      default: 
        str2 = "195";
        str1 = "148";
        paramInt = 0;
        if (paramInt >= localmhr.iP.size()) {
          break label398;
        }
        locala = (mhr.a)localmhr.iP.get(paramInt);
        if (locala != null) {}
        break;
      }
      break;
    }
    for (;;)
    {
      paramInt += 1;
      break label177;
      localJSONObject1.put("common_header_visibility", "1");
      break;
      localJSONObject1.put("topic_header_visibility", "1");
      break;
      str2 = "260";
      str1 = "146";
      break label175;
      str2 = "315";
      str1 = "236";
      break label175;
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("style_ID", "ReadInJoy_video_set_card_collection_cell");
      localJSONObject2.put("videoWidth", str1);
      localJSONObject2.put("videoHeight", str2);
      localJSONObject2.put("video_cover_url", locala.ahr);
      localJSONObject2.put("video_title_text", locala.articleTitle);
      localJSONObject2.put("play_count_text", locala.ahu);
      localJSONObject2.put("comment_count_text", locala.commentCount + "评论");
      localJSONObject2.put("rowkey", locala.ahs);
      localJSONArray.put(paramInt, localJSONObject2);
    }
    label398:
    if (paramBaseArticleInfo.mNewPolymericInfo.g == null) {
      localJSONObject1.put("canScroll", "0");
    }
    for (;;)
    {
      localJSONObject1.put("video_data", localJSONArray);
      localJSONObject1.put("card_jump_report_info", "");
      QLog.d("NewPolymericMultiVideoProteusItem", 1, localJSONObject1.toString());
      return localJSONObject1;
      localJSONObject1.put("canScroll", "1");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if (localArticleInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContainer.getVirtualView();
      ltp localltp = (ltp)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
      localltp.setModel(paramlie);
      localltp.a(new lob(this, localArticleInfo, paramContainer));
      localltp.a(new loc(this, localArticleInfo, paramlie));
      paramlie = paramContainer.getLayoutParams();
      localObject = ((ViewBase)localObject).getComLayoutParams();
    } while ((paramlie == null) || (localObject == null));
    paramlie.width = ((Layout.Params)localObject).mLayoutWidth;
    paramlie.height = ((Layout.Params)localObject).mLayoutHeight;
    paramContainer.setLayoutParams(paramlie);
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
      } while (TextUtils.isEmpty(str));
      paramlie = paramlie.a();
    } while (!"cmd_video_set_card_click".equals(str));
    paramViewBase.setOnClickListener(new lod(this, paramlie, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     loa
 * JD-Core Version:    0.7.0.1
 */