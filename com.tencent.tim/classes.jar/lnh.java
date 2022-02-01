import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;
import org.json.JSONObject;

class lnh
  implements ViewBase.OnClickListener
{
  lnh(lng paramlng, lie paramlie, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.b.a();
    if (localArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localArticleInfo.getProteusItemData();
    } while (localJSONObject == null);
    ndi localndi = this.b.b();
    if (this.val$id == 1124) {}
    for (boolean bool = true;; bool = false)
    {
      paramViewBase = localArticleInfo;
      if (!bool)
      {
        paramViewBase = localArticleInfo;
        if (localArticleInfo.mSubArtilceList != null)
        {
          paramViewBase = localArticleInfo;
          if (localArticleInfo.mSubArtilceList.size() > 0)
          {
            paramViewBase = localArticleInfo;
            if (localArticleInfo.mSubArtilceList.get(0) != null) {
              paramViewBase = (BaseArticleInfo)localArticleInfo.mSubArtilceList.get(0);
            }
          }
        }
      }
      if (!muj.a(paramViewBase, this.c.getContext())) {
        lng.a(this.a, this.c.getContext(), paramViewBase, localndi);
      }
      lbz.a().H(paramViewBase.mArticleID, System.currentTimeMillis());
      lng.a(this.a, paramViewBase, bool, localJSONObject);
      localndi.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */