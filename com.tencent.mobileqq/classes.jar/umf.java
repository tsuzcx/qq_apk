import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;

class umf
  implements uel
{
  umf(umd paramumd, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(JceStruct paramJceStruct)
  {
    uqf.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
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
          umd.a(this.jdField_a_of_type_Umd, true);
        } while (umd.a(this.jdField_a_of_type_Umd));
        paramJceStruct = paramJceStruct.feeds;
        localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_Umd.a();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramJceStruct, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (umd.a(this.jdField_a_of_type_Umd)));
    uqf.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umf
 * JD-Core Version:    0.7.0.1
 */