import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class ush
  implements ukd
{
  ush(usg paramusg, long paramLong, boolean paramBoolean1, usf paramusf, boolean paramBoolean2, Object paramObject) {}
  
  public void a(uko paramuko)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uqf.a("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    uoc.a().a(true, l, paramuko.jdField_a_of_type_Ukl.d(), 10007, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramuko.a())
    {
      uqf.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Usf != null) {
        this.jdField_a_of_type_Usf.a(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      return;
      if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
      {
        stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramuko.jdField_a_of_type_JavaLangObject;
        if (this.jdField_a_of_type_Boolean) {
          usg.a(this.jdField_a_of_type_Usg, localstGetPersonalFeedListRsp, this.jdField_a_of_type_Usf);
        }
        usg.a(this.jdField_a_of_type_Usg, localstGetPersonalFeedListRsp.attach_info);
        usg.a(this.jdField_a_of_type_Usg, localstGetPersonalFeedListRsp.is_finished);
        ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
        List localList = WSVerticalDataManager.a().a(localArrayList);
        StringBuilder localStringBuilder = new StringBuilder().append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:").append(localList.size()).append(", isFirst = ").append(this.jdField_a_of_type_Boolean).append(", mAttachInfo = ").append(usg.a(this.jdField_a_of_type_Usg)).append(", isFinish = ").append(localstGetPersonalFeedListRsp.is_finished).append(", size = ");
        if (localArrayList != null) {}
        for (int i = localArrayList.size();; i = 0)
        {
          uqf.e("WSArkCardDataManagerLog", i);
          if (paramuko.jdField_a_of_type_Uke != null) {
            unu.a().a(localstGetPersonalFeedListRsp.traceId, paramuko.jdField_a_of_type_Uke.a);
          }
          if (this.jdField_a_of_type_Usf == null) {
            break;
          }
          this.jdField_a_of_type_Usf.a(localList, this.b, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
          return;
        }
      }
      uqf.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (this.jdField_a_of_type_Usf == null);
    this.jdField_a_of_type_Usf.a(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */