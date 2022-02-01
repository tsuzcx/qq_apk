import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher.b;
import com.tencent.mobileqq.app.QQAppInterface;

final class kmv
  implements CommentItemShowDispatcher.b
{
  kmv(CommentItemShowDispatcher paramCommentItemShowDispatcher, int paramInt, QQAppInterface paramQQAppInterface, ktm paramktm) {}
  
  public ktm a()
  {
    return this.jdField_a_of_type_Ktm;
  }
  
  public void aED()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.a(this.aKe);
    kmt.aEC();
    if ((localObject != null) && (((CommentItemShowDispatcher.a)localObject).f != null) && (((CommentItemShowDispatcher.a)localObject).f.a != null))
    {
      float f = ((CommentItemShowDispatcher.a)localObject).kD;
      long l = ((CommentItemShowDispatcher.a)localObject).exposureTime;
      localObject = ((CommentItemShowDispatcher.a)localObject).f.a.advertisementInfo;
      jzk.a(this.val$app, jzk.aFZ, (AdvertisementInfo)localObject, f, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmv
 * JD-Core Version:    0.7.0.1
 */