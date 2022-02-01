import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class nlh
  implements ljc.c
{
  public nlh(AuthorData paramAuthorData) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    this.b.pQ(true);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    ArticleInfo localArticleInfo = this.b.articleInfo;
    if (this.b.d.FP()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = kxm.a(localBaseApplication, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          nns.c(this.b.articleInfo, "0X800898B", paramString.toString());
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
 * Qualified Name:     nlh
 * JD-Core Version:    0.7.0.1
 */