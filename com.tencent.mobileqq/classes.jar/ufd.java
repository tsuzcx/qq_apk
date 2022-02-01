import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class ufd
  implements ukd
{
  ufd(ufb paramufb, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(uko paramuko)
  {
    ufb.a(this.jdField_a_of_type_Ufb, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramuko.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        uqf.d(ufb.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      uqf.d(ufb.a(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList1 = (ArrayList)ufb.a(this.jdField_a_of_type_Ufb).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label499;
        }
      }
    }
    label240:
    label499:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = ufb.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        ufb.a(this.jdField_a_of_type_Ufb).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        uqf.d(ufb.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        ufb.a(this.jdField_a_of_type_Ufb, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        uqf.d(ufb.a(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramuko = this.jdField_a_of_type_Ufb.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramuko.b), paramuko.jdField_a_of_type_JavaLangString, localObject, Integer.valueOf(this.jdField_a_of_type_Ufb.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        wjj.a().dispatch(paramuko);
        return;
        ufb.a(this.jdField_a_of_type_Ufb).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = ufb.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        ufb.b(this.jdField_a_of_type_Ufb).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        ufb.a(this.jdField_a_of_type_Ufb).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        uqf.d(ufb.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label240;
        uqf.d(ufb.a(), "获取评论失败new！");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */