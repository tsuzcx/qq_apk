import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class lud
  implements ViewBase.OnClickListener
{
  lud(ltz paramltz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.this$0.a != null) && (this.a.this$0.a.a() != null)) {
      kvx.a(this.a.this$0.a.a(), this.a.b, paramViewBase);
    }
    kvx.a(this.a.b, paramViewBase);
    if ((lty.a(this.a.this$0) != null) && (this.a.val$position < lty.a(this.a.this$0).size()))
    {
      kxm.a(lty.a(this.a.this$0).getContext(), (BaseArticleInfo)lty.a(this.a.this$0).get(this.a.val$position), paramViewBase.getEventAttachedData());
      return;
    }
    kxm.aJ(lty.a(this.a.this$0).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lud
 * JD-Core Version:    0.7.0.1
 */