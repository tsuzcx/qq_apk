import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;

class tir
  implements tcm
{
  tir(tip paramtip, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(JceStruct paramJceStruct)
  {
    tlo.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
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
          tip.a(this.jdField_a_of_type_Tip, true);
        } while (tip.a(this.jdField_a_of_type_Tip));
        paramJceStruct = paramJceStruct.feeds;
        localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_Tip.a();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramJceStruct, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (tip.a(this.jdField_a_of_type_Tip)));
    tlo.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tir
 * JD-Core Version:    0.7.0.1
 */