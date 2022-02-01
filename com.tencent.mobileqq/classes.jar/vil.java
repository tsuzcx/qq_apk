import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;

class vil
  implements uyy
{
  vil(vij paramvij, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(JceStruct paramJceStruct)
  {
    vmp.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
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
          vij.a(this.jdField_a_of_type_Vij, true);
        } while (vij.a(this.jdField_a_of_type_Vij));
        paramJceStruct = paramJceStruct.feeds;
        localWSRecommendFragment = (WSRecommendFragment)this.jdField_a_of_type_Vij.a();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramJceStruct, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (vij.a(this.jdField_a_of_type_Vij)));
    vmp.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vil
 * JD-Core Version:    0.7.0.1
 */