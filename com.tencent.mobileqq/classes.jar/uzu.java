import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class uzu
  implements vfg
{
  uzu(uzs paramuzs, long paramLong, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(vfr paramvfr)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    vmp.a(uzs.a(), "评论列表请求耗时：" + l + "毫秒");
    vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, "", false);
    if (!paramvfr.a()) {
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
    }
    uzs.a(this.jdField_a_of_type_Uzs, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramvfr.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        vmp.d(uzs.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      vmp.d(uzs.a(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList1 = (ArrayList)uzs.a(this.jdField_a_of_type_Uzs).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label607;
        }
      }
    }
    label326:
    label607:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = uzs.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        uzs.a(this.jdField_a_of_type_Uzs).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        vmp.d(uzs.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        uzs.a(this.jdField_a_of_type_Uzs, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        vmp.d(uzs.a(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramvfr = this.jdField_a_of_type_Uzs.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramvfr.b), paramvfr.jdField_a_of_type_JavaLangString, localObject, Integer.valueOf(this.jdField_a_of_type_Uzs.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        wad.a().dispatch(paramvfr);
        return;
        uzs.a(this.jdField_a_of_type_Uzs).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = uzs.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        uzs.b(this.jdField_a_of_type_Uzs).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        uzs.a(this.jdField_a_of_type_Uzs).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        vmp.d(uzs.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label326;
        vmp.d(uzs.a(), "获取评论失败new！");
        vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzu
 * JD-Core Version:    0.7.0.1
 */