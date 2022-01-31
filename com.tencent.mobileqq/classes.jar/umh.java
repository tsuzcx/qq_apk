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

class umh
  implements slx<szf, tbd>
{
  umh(umg paramumg, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull szf paramszf, @Nullable tbd paramtbd, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Umg.jdField_a_of_type_Ung != null) {
        this.jdField_a_of_type_Umg.jdField_a_of_type_Ung.a(paramErrorMessage);
      }
      return;
    }
    if (paramtbd == null)
    {
      this.jdField_a_of_type_Umg.jdField_a_of_type_Umi.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Umg.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Umg.jdField_a_of_type_Unh.a(this.jdField_a_of_type_Umg.a());
        return;
      }
      urk.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramszf = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramszf.mergeFrom(paramtbd.a);
        paramtbd = paramszf.vid_list.get().listIterator();
        paramErrorMessage = paramszf.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Umg.jdField_a_of_type_Umi.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Umg.jdField_a_of_type_Umi;
        if (paramszf.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((spz)sqg.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramszf.share_to_discover.get()));
          if (!paramtbd.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Umg.jdField_a_of_type_Umi.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramtbd.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramszf)
      {
        urk.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramszf);
        if (this.jdField_a_of_type_Umg.jdField_a_of_type_Unh != null)
        {
          this.jdField_a_of_type_Umg.jdField_a_of_type_Unh.a(this.jdField_a_of_type_Umg.a());
          return;
        }
        urk.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramszf.is_end.has()) || (paramszf.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Umg.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Umg.jdField_a_of_type_Unh.a(this.jdField_a_of_type_Umg.a());
        return;
      }
      urk.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramtbd = new qqstory_service.ReqTodayStoryVidList();
    paramtbd.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramtbd.cookie.set(paramszf.cookie.get());
    slv.a().a(new szf(this.jdField_a_of_type_JavaLangString, paramtbd, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umh
 * JD-Core Version:    0.7.0.1
 */