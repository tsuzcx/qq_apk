import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lnk
  implements ViewBase.OnClickListener
{
  lnk(lni paramlni, lie paramlie, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    TemplateBean localTemplateBean = this.b.a().mProteusTemplateBean;
    if (localTemplateBean != null)
    {
      paramViewBase = lni.a(this.a, localTemplateBean, paramViewBase);
      this.b.b().a(false, (ArticleInfo)this.i, (ArticleInfo)this.h, this.i.innerUniqueID, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnk
 * JD-Core Version:    0.7.0.1
 */