import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class lnr
  implements lpi
{
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private void aN(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_kandian_hotnews");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    if (muj.isIntentAvailable(paramContext, localIntent)) {
      paramContext.startActivity(localIntent);
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
    JSONObject localJSONObject = new JSONObject(paramBaseArticleInfo.proteusItemsData);
    long l1 = localJSONObject.getLong("updateTime") * 1000L - 10800000L;
    paramBaseArticleInfo = "";
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L) {
      paramBaseArticleInfo = (int)((l2 - l1) / 86400000L) + "天前";
    }
    for (;;)
    {
      localJSONObject.put("updateTimeStr", paramBaseArticleInfo);
      if (!aqiz.isAppInstalled(BaseApplicationImpl.getContext(), "com.tencent.reading")) {
        break;
      }
      localJSONObject.put("jump_page", "3");
      return localJSONObject;
      if (l2 - l1 > 3600000L) {
        paramBaseArticleInfo = (int)((l2 - l1) / 3600000L) + "小时前";
      } else if (l2 - l1 > 60000L) {
        paramBaseArticleInfo = (int)((l2 - l1) / 60000L) + "分钟前";
      }
    }
    localJSONObject.put("jump_page", "2");
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    if ((paramViewBase != null) && (!TextUtils.isEmpty(paramViewBase.getClickEvnet())) && (paramViewBase.getClickEvnet().startsWith("cmd_kandian_ten_click"))) {}
    try
    {
      kfq.ma(a(paramlie.a().weishiUGInfo.bytes_report_base_url) + a(paramlie.a().weishiUGInfo.bytes_exposure_report_tail));
      label80:
      paramViewBase.setOnClickListener(new lns(this, paramlie, paramContainer));
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnr
 * JD-Core Version:    0.7.0.1
 */