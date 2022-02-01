import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class mbz
  implements View.OnClickListener
{
  public mbz(ComponentHeaderNewSocial paramComponentHeaderNewSocial, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", kxm.aMw);
      ((JSONObject)localObject2).put("feeds_source", String.valueOf(this.k.mSocialFeedInfo.a.uin));
      ((JSONObject)localObject2).put("tab_source", kxm.nQ());
      ((JSONObject)localObject2).put("kandian_mode", kxm.nR());
      ((JSONObject)localObject2).put("rowkey", this.k.innerUniqueID);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    kbp.a(null, this.k.mSubscribeID, "0X8007B63", "0X8007B63", 0, 0, String.valueOf(this.k.mFeedId), String.valueOf(this.k.mArticleID), "", (String)localObject1, false);
    localObject1 = kwt.acE + String.valueOf(this.k.mFeedId);
    kxm.aJ(this.b.getContext(), (String)localObject1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbz
 * JD-Core Version:    0.7.0.1
 */