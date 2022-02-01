import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class lzr
  implements View.OnClickListener
{
  lzr(lzp paramlzp, ArticleInfo paramArticleInfo, mih parammih) {}
  
  public void onClick(View paramView)
  {
    kxm.c = this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    kxm.aJ(this.a.context, this.jdField_d_of_type_Mih.b.url);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", kxm.aMw);
      localJSONObject.put("kandian_mode", "" + kxm.nR());
      localJSONObject.put("tab_source", "" + kxm.nQ());
      kbp.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lzr
 * JD-Core Version:    0.7.0.1
 */