import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class ulu
  implements uqy
{
  ulu(uls paramuls, long paramLong, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(urj paramurj)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uya.a(uls.a(), "评论列表请求耗时：" + l + "毫秒");
    uvw.a().a(l, paramurj.jdField_a_of_type_Urg, "", false);
    if (!paramurj.a()) {
      uvw.a().a(l, paramurj.jdField_a_of_type_Urg, paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
    }
    uls.a(this.jdField_a_of_type_Uls, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramurj.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        uya.d(uls.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      uya.d(uls.a(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList1 = (ArrayList)uls.a(this.jdField_a_of_type_Uls).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label607;
        }
      }
    }
    label326:
    label607:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = uls.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        uls.a(this.jdField_a_of_type_Uls).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        uya.d(uls.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        uls.a(this.jdField_a_of_type_Uls, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        uya.d(uls.a(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramurj = this.jdField_a_of_type_Uls.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramurj.b), paramurj.jdField_a_of_type_JavaLangString, localObject, Integer.valueOf(this.jdField_a_of_type_Uls.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        vli.a().dispatch(paramurj);
        return;
        uls.a(this.jdField_a_of_type_Uls).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = uls.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        uls.b(this.jdField_a_of_type_Uls).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        uls.a(this.jdField_a_of_type_Uls).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        uya.d(uls.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label326;
        uya.d(uls.a(), "获取评论失败new！");
        uvw.a().a(l, paramurj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */