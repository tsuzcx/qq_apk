import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class lmo
  implements ViewBase.OnClickListener
{
  lmo(lmm paramlmm, lie paramlie, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.b.a();
    String str = paramViewBase.mSocialFeedInfo.a.aiq;
    kxm.a(this.c.getContext(), str, null);
    ndi.g(paramViewBase, (int)paramViewBase.mChannelID);
    odv.J(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmo
 * JD-Core Version:    0.7.0.1
 */