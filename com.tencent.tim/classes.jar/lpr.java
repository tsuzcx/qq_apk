import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.search.report.ReportModelDC02528;

class lpr
  implements ViewBase.OnClickListener
{
  lpr(lpq paramlpq, lie paramlie, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.b.a();
    Object localObject2 = new ReportModelDC02528().module("all_result").action("clk_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(localArticleInfo.mArticleContentUrl);
    Object localObject1;
    String str1;
    String str2;
    if ((paramViewBase instanceof lst))
    {
      localObject1 = ((lst)paramViewBase).getText();
      amub.a(null, ((ReportModelDC02528)localObject2).ver4((String)localObject1).ver5(localArticleInfo.mTitle).ver6(ByteStringMicro.copyFromUtf8(localArticleInfo.innerUniqueID).toStringUtf8()).ver7("{jumpurl:" + paramViewBase.getEventAttachedData() + ",clk_index:" + paramViewBase.getClickEvnet().substring("search_word_click_".length()) + "}").session_id(localArticleInfo.mSearchWordSessionId));
      amxk.g((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.c.getContext(), paramViewBase.getEventAttachedData());
      localObject1 = (acnm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(111);
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str1 = localArticleInfo.mSearchWordSessionId;
      str2 = localArticleInfo.mArticleContentUrl;
      if (!(paramViewBase instanceof lst)) {
        break label261;
      }
    }
    label261:
    for (paramViewBase = ((lst)paramViewBase).getText();; paramViewBase = "")
    {
      ((acnm)localObject1).a((QQAppInterface)localObject2, "clk_Kdfeedsback_list", str1, str2, paramViewBase, localArticleInfo.mTitle, ByteStringMicro.copyFromUtf8(localArticleInfo.innerUniqueID).toStringUtf8());
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */