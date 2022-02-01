import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class vac
  implements uqy
{
  vac(vab paramvab, long paramLong, boolean paramBoolean1, vaa paramvaa, boolean paramBoolean2, Object paramObject) {}
  
  public void a(urj paramurj)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uya.a("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    uvw.a().a(l, paramurj.jdField_a_of_type_Urg, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramurj.a())
    {
      uya.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Vaa != null) {
        this.jdField_a_of_type_Vaa.a(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      }
      uvw.a().a(l, paramurj.jdField_a_of_type_Urg, paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
    {
      stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramurj.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Boolean) {
        vab.a(this.jdField_a_of_type_Vab, localstGetPersonalFeedListRsp, this.jdField_a_of_type_Vaa);
      }
      vab.a(this.jdField_a_of_type_Vab, localstGetPersonalFeedListRsp.attach_info);
      vab.a(this.jdField_a_of_type_Vab, localstGetPersonalFeedListRsp.is_finished);
      ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
      List localList = WSVerticalDataManager.a().a(localArrayList);
      StringBuilder localStringBuilder = new StringBuilder().append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:").append(localList.size()).append(", isFirst = ").append(this.jdField_a_of_type_Boolean).append(", mAttachInfo = ").append(vab.a(this.jdField_a_of_type_Vab)).append(", isFinish = ").append(localstGetPersonalFeedListRsp.is_finished).append(", size = ");
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        uya.e("WSArkCardDataManagerLog", i);
        if (paramurj.jdField_a_of_type_Uqz != null) {
          uvo.a().a(localstGetPersonalFeedListRsp.traceId, paramurj.jdField_a_of_type_Uqz.a);
        }
        if (this.jdField_a_of_type_Vaa == null) {
          break;
        }
        this.jdField_a_of_type_Vaa.a(localList, this.b, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    uya.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
    }
    uvw.a().a(l, paramurj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vac
 * JD-Core Version:    0.7.0.1
 */