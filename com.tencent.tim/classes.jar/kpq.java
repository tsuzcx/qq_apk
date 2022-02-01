import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

class kpq
  implements lij.a
{
  kpq(kpp paramkpp) {}
  
  public void pv(int paramInt)
  {
    if ((kpp.a(this.a) != null) && (kpp.a(this.a).articleInfo != null))
    {
      if (kpp.a(this.a).articleInfo.mSocialFeedInfo == null) {
        kpp.a(this.a).articleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      kpp.a(this.a).articleInfo.mSocialFeedInfo.a.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpq
 * JD-Core Version:    0.7.0.1
 */