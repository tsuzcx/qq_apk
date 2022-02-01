import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequestException;
import java.util.ArrayList;
import rx.Subscriber;

class ulj
  extends Subscriber<ArrayList<stSimpleMetaFeed>>
{
  ulj(ulf paramulf, WSRecommendFragment paramWSRecommendFragment, boolean paramBoolean1, boolean paramBoolean2, uju paramuju, long paramLong, boolean paramBoolean3) {}
  
  public void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(paramArrayList, this.jdField_a_of_type_Boolean, this.b, true, this.c);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof WeishiRequestException))
    {
      paramThrowable = (WeishiRequestException)paramThrowable;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(paramThrowable.code, paramThrowable.msg, this.jdField_a_of_type_Boolean, this.b);
    }
    for (;;)
    {
      ulf.a(this.jdField_a_of_type_Ulf, this.jdField_a_of_type_Uju, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(-1, paramThrowable.getMessage(), this.jdField_a_of_type_Boolean, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */