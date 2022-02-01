import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class lml
  implements ViewBase.OnClickListener
{
  lml(lmj paramlmj, BaseArticleInfo paramBaseArticleInfo, lie paramlie, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.g == null) || (this.g.columnEntrances == null) || (this.g.columnEntrances.isEmpty())) {
      return;
    }
    QLog.i("BigImageVideoProteusItem", 1, "" + this.g.columnEntrances);
    paramViewBase = (VideoColumnInfo)this.g.columnEntrances.get(0);
    QLog.i("BigImageVideoProteusItem", 1, "" + paramViewBase);
    if ((paramViewBase.h != null) && (paramViewBase.h.jumpType != 3)) {
      muj.a(this.b.a().getContext(), paramViewBase.h);
    }
    kvx.a(this.g, this.g.mProteusTemplateBean, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lml
 * JD-Core Version:    0.7.0.1
 */