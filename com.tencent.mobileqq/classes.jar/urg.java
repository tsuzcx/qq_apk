import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class urg
  implements ujj
{
  urg(urf paramurf, long paramLong, boolean paramBoolean1, ure paramure, boolean paramBoolean2, Object paramObject) {}
  
  public void a(uju paramuju)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    upe.a("weishi-beacon", "请求播放页（推荐)耗时：" + l + "毫秒");
    unb.a().a(true, l, paramuju.jdField_a_of_type_Ujr.d(), 10007, "chat_page", this.jdField_a_of_type_Boolean);
    if (!paramuju.a())
    {
      upe.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Ure != null) {
        this.jdField_a_of_type_Ure.a(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      return;
      if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stGetPersonalFeedListRsp))
      {
        stGetPersonalFeedListRsp localstGetPersonalFeedListRsp = (stGetPersonalFeedListRsp)paramuju.jdField_a_of_type_JavaLangObject;
        if (this.jdField_a_of_type_Boolean) {
          urf.a(this.jdField_a_of_type_Urf, localstGetPersonalFeedListRsp, this.jdField_a_of_type_Ure);
        }
        urf.a(this.jdField_a_of_type_Urf, localstGetPersonalFeedListRsp.attach_info);
        urf.a(this.jdField_a_of_type_Urf, localstGetPersonalFeedListRsp.is_finished);
        ArrayList localArrayList = localstGetPersonalFeedListRsp.feeds;
        List localList = WSVerticalDataManager.a().a(localArrayList);
        StringBuilder localStringBuilder = new StringBuilder().append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:").append(localList.size()).append(", isFirst = ").append(this.jdField_a_of_type_Boolean).append(", mAttachInfo = ").append(urf.a(this.jdField_a_of_type_Urf)).append(", isFinish = ").append(localstGetPersonalFeedListRsp.is_finished).append(", size = ");
        if (localArrayList != null) {}
        for (int i = localArrayList.size();; i = 0)
        {
          upe.e("WSArkCardDataManagerLog", i);
          if (paramuju.jdField_a_of_type_Ujk != null) {
            ugb.a().a(localstGetPersonalFeedListRsp.traceId, paramuju.jdField_a_of_type_Ujk.a);
          }
          if (this.jdField_a_of_type_Ure == null) {
            break;
          }
          this.jdField_a_of_type_Ure.a(localList, this.b, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
          return;
        }
      }
      upe.d("WSArkCardDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (this.jdField_a_of_type_Ure == null);
    this.jdField_a_of_type_Ure.a(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urg
 * JD-Core Version:    0.7.0.1
 */