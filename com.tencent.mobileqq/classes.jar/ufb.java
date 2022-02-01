import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class ufb
  implements ujj
{
  ufb(uez paramuez, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(uju paramuju)
  {
    uez.a(this.jdField_a_of_type_Uez, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramuju.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        upe.d(uez.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      upe.d(uez.a(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList1 = (ArrayList)uez.a(this.jdField_a_of_type_Uez).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label499;
        }
      }
    }
    label240:
    label499:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = uez.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        uez.a(this.jdField_a_of_type_Uez).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        upe.d(uez.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        uez.a(this.jdField_a_of_type_Uez, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        upe.d(uez.a(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramuju = this.jdField_a_of_type_Uez.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramuju.b), paramuju.jdField_a_of_type_JavaLangString, localObject, Integer.valueOf(this.jdField_a_of_type_Uez.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        wfo.a().dispatch(paramuju);
        return;
        uez.a(this.jdField_a_of_type_Uez).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = uez.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        uez.b(this.jdField_a_of_type_Uez).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        uez.a(this.jdField_a_of_type_Uez).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        upe.d(uez.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label240;
        upe.d(uez.a(), "获取评论失败new！");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufb
 * JD-Core Version:    0.7.0.1
 */