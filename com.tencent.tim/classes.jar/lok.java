import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class lok
  implements View.OnClickListener
{
  lok(loj paramloj, ArticleInfo paramArticleInfo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.d == null) || (this.d.mTopicRecommendFeedsInfo == null) || (this.d.mTopicRecommendFeedsInfo.ld == null) || (this.d.mTopicRecommendFeedsInfo.ld.isEmpty())) {
      QLog.d("PackProteusItem", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
    }
    String str1;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = ((mih.b)this.d.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
    } while (TextUtils.isEmpty(str1));
    String str2 = kxm.a("1", this.d);
    if (odv.aT(this.d.mChannelID)) {}
    for (Object localObject = "0X800935C";; localObject = "0X8007BA3")
    {
      kbp.a(null, "", (String)localObject, (String)localObject, 0, 0, String.valueOf(this.d.mFeedId), String.valueOf(this.d.mArticleID), "" + this.d.mStrategyId, str2, false);
      localObject = new Intent(this.val$context, PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", str1);
      this.val$context.startActivity((Intent)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lok
 * JD-Core Version:    0.7.0.1
 */