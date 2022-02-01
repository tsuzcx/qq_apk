import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class lor
  implements ComponentContentGridImage.c
{
  lor(lom paramlom, lie paramlie, Container paramContainer, int paramInt) {}
  
  public void rr(int paramInt)
  {
    Object localObject = this.b.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((SocializeFeedsInfo.m)localObject).kY;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    localObject = (SocializeFeedsInfo.n)((SocializeFeedsInfo.m)localObject).kY.get(paramInt);
    lom.a(this.a, this.c.getContext(), this.b.a(), (int)((SocializeFeedsInfo.n)localObject).vP, this.b.a().innerUniqueID, this.val$position, paramInt, this.b.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lor
 * JD-Core Version:    0.7.0.1
 */