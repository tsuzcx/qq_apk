import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class lol
  implements lty.c
{
  lol(loj paramloj, List paramList, ArticleInfo paramArticleInfo, lie paramlie) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramInt < 0) || (paramInt >= this.in.size()))
    {
      QLog.i("PackProteusItem", 1, "[onItemClick] position overflow, position = " + paramInt + ", size = " + this.in.size());
      return;
    }
    try
    {
      this.d.invalidateProteusTemplateBean();
      paramTemplateBean = (BaseArticleInfo)this.in.get(paramInt);
      this.b.b().a().a(paramTemplateBean, paramViewBase.getNativeView(), paramInt, paramInt);
      return;
    }
    catch (Exception paramViewBase)
    {
      QLog.e("PackProteusItem", 1, "[onItemClick], e = " + paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lol
 * JD-Core Version:    0.7.0.1
 */