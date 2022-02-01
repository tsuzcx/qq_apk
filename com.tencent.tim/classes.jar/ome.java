import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;

class ome
  implements ogo
{
  ome(omc paramomc, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void d(JceStruct paramJceStruct)
  {
    ooz.e("WSRecommendFragmentPresenter", "onReadCacheCompleted");
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {}
    WSRecommendFragment localWSRecommendFragment;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramJceStruct = (stSimpleGetFeedListRsp)paramJceStruct;
          } while ((paramJceStruct.feeds == null) || (paramJceStruct.feeds.size() <= 0));
          omc.a(this.a, true);
        } while (omc.a(this.a));
        paramJceStruct = paramJceStruct.feeds;
        localWSRecommendFragment = (WSRecommendFragment)this.a.b();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.c(paramJceStruct, this.axM, this.axN);
    } while ((this.axM) || (omc.a(this.a)));
    ooz.e("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.qA(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */