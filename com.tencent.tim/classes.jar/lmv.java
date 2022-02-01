import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class lmv
  implements View.OnClickListener
{
  lmv(lmp paramlmp, lie paramlie, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((SocializeFeedsInfo.m)localObject).kY;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (SocializeFeedsInfo.n)((SocializeFeedsInfo.m)localObject).kY.get(0);
      lmp.a(this.a, this.c.getContext(), this.b.a(), (int)((SocializeFeedsInfo.n)localObject).vP, this.b.a().innerUniqueID, this.val$position, 0, this.b.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmv
 * JD-Core Version:    0.7.0.1
 */