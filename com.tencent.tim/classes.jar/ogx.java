import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class ogx
  implements oko
{
  ogx(ogv paramogv, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(okz paramokz)
  {
    ogv.a(this.jdField_a_of_type_Ogv, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramokz.bb instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramokz.bb;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        ooz.e(ogv.access$200(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      ooz.e(ogv.access$200(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.axa)
      {
        localArrayList1 = (ArrayList)ogv.a(this.jdField_a_of_type_Ogv).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label499;
        }
      }
    }
    label240:
    label499:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = ogv.c(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        ogv.a(this.jdField_a_of_type_Ogv).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        ooz.e(ogv.access$200(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        ogv.a(this.jdField_a_of_type_Ogv, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        ooz.e(ogv.access$200(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramokz = this.jdField_a_of_type_Ogv.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localObject, Integer.valueOf(this.jdField_a_of_type_Ogv.hashCode()), Boolean.valueOf(this.axa), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        pmi.a().dispatch(paramokz);
        return;
        ogv.a(this.jdField_a_of_type_Ogv).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = ogv.c(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        ogv.b(this.jdField_a_of_type_Ogv).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        ogv.a(this.jdField_a_of_type_Ogv).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        ooz.e(ogv.access$200(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label240;
        ooz.e(ogv.access$200(), "获取评论失败new！");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogx
 * JD-Core Version:    0.7.0.1
 */