import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lqy
  implements ViewBase.OnClickListener
{
  private int aPw;
  private ArticleInfo b;
  private Context mContext;
  private String mScheme;
  
  public lqy(ArticleInfo paramArticleInfo, Context paramContext, int paramInt, String paramString)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
    this.aPw = paramInt;
    this.mScheme = paramString;
  }
  
  private void aNd()
  {
    aqhv localaqhv = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, this.mScheme);
    if (localaqhv != null) {
      localaqhv.ace();
    }
  }
  
  private void reportClick(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", this.b.mAlgorithmID + "");
      localJSONObject.put("folder_status", kxm.aMw);
      localJSONObject.put("feeds_type", kxm.a(this.b));
      localJSONObject.put("channel_id", "" + this.b.mChannelID);
      localJSONObject.put("feeds_source", kxm.f(this.b));
      localJSONObject.put("imei", kxm.iT());
      localJSONObject.put("imsi", kxm.iU());
      localJSONObject.put("rowkey", this.b.innerUniqueID);
      localJSONObject.put("comment", this.b.mSocialFeedInfo.ahL);
      localJSONObject.put("topic_id", "" + this.b.businessId);
      localJSONObject.put("kandian_mode", "" + kxm.nR());
      localJSONObject.put("mark_type", paramString);
      kbp.a(null, String.valueOf(kxm.a(this.b, this.aPw)), "0X80097CB", "0X80097CB", 0, 0, String.valueOf(this.b.mSocialFeedInfo.mFeedId), String.valueOf(this.b.mArticleID), String.valueOf(this.b.mStrategyId), localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("OnTopicDeliverClickListener", 2, "report error:" + paramString.toString());
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.b == null) {}
    do
    {
      return;
      if ((this.b.mSocialFeedInfo != null) && (this.b.mSocialFeedInfo.a != null) && ((this.aPw == 72) || (this.aPw == 73)))
      {
        reportClick("4");
        return;
      }
    } while (TextUtils.isEmpty(this.mScheme));
    aNd();
    try
    {
      if (TextUtils.isEmpty(this.b.proteusItemsData)) {
        break label130;
      }
      paramViewBase = new JSONObject(this.b.proteusItemsData).optString("biz_type", "");
      boolean bool = TextUtils.isEmpty(paramViewBase);
      if (bool) {
        break label130;
      }
    }
    catch (Exception paramViewBase)
    {
      for (;;)
      {
        QLog.d("OnTopicDeliverClickListener", 2, "OnTopicDeliverClickListener", paramViewBase);
        paramViewBase = "1";
      }
    }
    reportClick(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqy
 * JD-Core Version:    0.7.0.1
 */