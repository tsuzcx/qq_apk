import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lnj
  implements ViewBase.OnClickListener
{
  lnj(lni paramlni, lie paramlie, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    TemplateBean localTemplateBean = this.b.a().mProteusTemplateBean;
    if (localTemplateBean != null)
    {
      paramViewBase = lni.a(this.a, localTemplateBean, paramViewBase);
      this.b.b().a(true, (ArticleInfo)this.h, (ArticleInfo)this.h, this.h.innerUniqueID, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnj
 * JD-Core Version:    0.7.0.1
 */