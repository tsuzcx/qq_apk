import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class vou
  implements vfg
{
  vou(vot paramvot, long paramLong, boolean paramBoolean1, vos paramvos, boolean paramBoolean2) {}
  
  public void a(vfr paramvfr)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    vmp.a("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramvfr.a())
    {
      vmp.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Vos != null) {
        this.jdField_a_of_type_Vos.a(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      }
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
    {
      stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      vov localvov = new vov();
      if (this.jdField_a_of_type_Boolean)
      {
        vot.a(this.jdField_a_of_type_Vot, localstGetPersonalFeedListRsp, this.jdField_a_of_type_Vos);
        vot.a(this.jdField_a_of_type_Vot, localstGetPersonalFeedListRsp, localvov);
      }
      vot.a(this.jdField_a_of_type_Vot, localstGetPersonalFeedListRsp.attach_info);
      vot.a(this.jdField_a_of_type_Vot, localstGetPersonalFeedListRsp.is_finished);
      ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
      List localList = WSVerticalDataManager.a().a(localArrayList);
      StringBuilder localStringBuilder = new StringBuilder().append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:").append(localList.size()).append(", isFirst = ").append(this.jdField_a_of_type_Boolean).append(", mAttachInfo = ").append(vot.a(this.jdField_a_of_type_Vot)).append(", isFinish = ").append(localstGetPersonalFeedListRsp.is_finished).append(", size = ");
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        vmp.e("WSArkCardDataManagerLog", i);
        if (paramvfr.jdField_a_of_type_Vfh != null) {
          vkc.a().a(localstGetPersonalFeedListRsp.traceId, paramvfr.jdField_a_of_type_Vfh.a);
        }
        if (this.jdField_a_of_type_Vos == null) {
          break;
        }
        this.jdField_a_of_type_Vos.a(localList, this.b, this.jdField_a_of_type_Boolean, localvov);
        return;
      }
    }
    vmp.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    if (this.jdField_a_of_type_Vos != null) {
      this.jdField_a_of_type_Vos.a(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
    }
    vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vou
 * JD-Core Version:    0.7.0.1
 */