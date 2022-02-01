import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTodayStoryVidList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class yfn
  implements wfk<wsr, wup>
{
  yfn(yfm paramyfm, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull wsr paramwsr, @Nullable wup paramwup, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygm != null) {
        this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygm.a(paramErrorMessage);
      }
      return;
    }
    if (paramwup == null)
    {
      this.jdField_a_of_type_Yfm.jdField_a_of_type_Yfo.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn.a(this.jdField_a_of_type_Yfm.a());
        return;
      }
      ykq.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramwsr = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramwsr.mergeFrom(paramwup.a);
        paramwup = paramwsr.vid_list.get().listIterator();
        paramErrorMessage = paramwsr.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Yfm.jdField_a_of_type_Yfo.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Yfm.jdField_a_of_type_Yfo;
        if (paramwsr.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((wjl)wjs.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramwsr.share_to_discover.get()));
          if (!paramwup.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Yfm.jdField_a_of_type_Yfo.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramwup.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramwsr)
      {
        ykq.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramwsr);
        if (this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn != null)
        {
          this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn.a(this.jdField_a_of_type_Yfm.a());
          return;
        }
        ykq.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramwsr.is_end.has()) || (paramwsr.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Yfm.jdField_a_of_type_Ygn.a(this.jdField_a_of_type_Yfm.a());
        return;
      }
      ykq.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramwup = new qqstory_service.ReqTodayStoryVidList();
    paramwup.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramwup.cookie.set(paramwsr.cookie.get());
    wfi.a().a(new wsr(this.jdField_a_of_type_JavaLangString, paramwup, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfn
 * JD-Core Version:    0.7.0.1
 */