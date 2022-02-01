import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class lqw
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqw(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a;
    if (paramArticleInfo != null)
    {
      paramArticleInfo = paramArticleInfo.wendaUrl;
      kxm.aL(paramContext, paramArticleInfo);
      QLog.i("OnSuperTopicClickListener", 2, "jumpToWendaRefer jumpUrl +" + paramArticleInfo);
    }
  }
  
  private void aNb()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.proteusItemsData))) {}
    try
    {
      Object localObject = new JSONObject(this.b.proteusItemsData);
      QLog.d("OnSuperTopicClickListener", 2, new Object[] { "mArticleInfo.proteusItemsData = ", this.b.proteusItemsData });
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("id_super_topic".equals(str))
        {
          localObject = ((JSONObject)localObject).getJSONObject(str).getString("super_topic_jump_url");
          QLog.d("OnSuperTopicClickListener", 2, new Object[] { "jumpToSuperTopic, jumpUrl = ", localObject });
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            kxm.a(this.mContext, (String)localObject, null);
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("OnSuperTopicClickListener", 2, "jumpToSuperTopic", localJSONException);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((kxm.s(this.b)) || (kxm.t(this.b)))
    {
      a(this.b, this.mContext);
      kbp.a(this.b);
      return;
    }
    aNb();
    kbp.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqw
 * JD-Core Version:    0.7.0.1
 */