import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class lnx
  implements lty.c
{
  lnx(lnv paramlnv, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("multiVideoColumnInfo", 1, "position : " + paramInt);
    paramViewBase = this.j.multiVideoColumnInfo.iO;
    if ((paramInt >= 0) && (paramInt < paramViewBase.size()) && (paramViewBase.get(paramInt) != null) && (((mie)paramViewBase.get(paramInt)).a != null))
    {
      paramTemplateBean = ((mie)paramViewBase.get(paramInt)).a;
      muj.a(this.e.getContext(), paramTemplateBean);
      lnv.a(this.a, this.j, 2, paramTemplateBean.WT, ((mie)paramViewBase.get(paramInt)).rowKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnx
 * JD-Core Version:    0.7.0.1
 */