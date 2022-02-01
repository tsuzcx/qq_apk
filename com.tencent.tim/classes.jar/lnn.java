import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class lnn
  implements ViewBase.OnClickListener
{
  lnn(lni paramlni, BaseArticleInfo paramBaseArticleInfo, lie paramlie) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.g.columnEntrances == null) || (this.g.columnEntrances.isEmpty())) {
      return;
    }
    VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)this.g.columnEntrances.get(0);
    if ((localVideoColumnInfo.h != null) && (localVideoColumnInfo.h.jumpType != 3)) {
      muj.a(this.b.a().getContext(), localVideoColumnInfo.h);
    }
    kvx.a(this.g, this.g.mProteusTemplateBean, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnn
 * JD-Core Version:    0.7.0.1
 */