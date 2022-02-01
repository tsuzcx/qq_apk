import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class nme
  implements ljc.c
{
  nme(nmd.a parama) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    nmd.a.a(this.this$0, true);
    Context localContext = this.this$0.itemView.getContext();
    ArticleInfo localArticleInfo = this.this$0.g.articleInfo;
    if (this.this$0.g.d.FP()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = kxm.a(localContext, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          nns.c(this.this$0.g.articleInfo, "0X800898B", paramString.toString());
          return;
          paramString = "1";
          break;
          paramInt = 2;
        }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nme
 * JD-Core Version:    0.7.0.1
 */