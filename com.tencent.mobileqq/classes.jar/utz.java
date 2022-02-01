import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;

class utz
  implements ulb
{
  utz(utx paramutx, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(JceStruct paramJceStruct)
  {
    uya.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
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
          utx.a(this.jdField_a_of_type_Utx, true);
        } while (utx.a(this.jdField_a_of_type_Utx));
        paramJceStruct = paramJceStruct.feeds;
        localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_Utx.a();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramJceStruct, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (utx.a(this.jdField_a_of_type_Utx)));
    uya.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utz
 * JD-Core Version:    0.7.0.1
 */