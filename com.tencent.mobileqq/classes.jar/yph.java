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

class yph
  implements woy<xcg, xee>
{
  yph(ypg paramypg, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull xcg paramxcg, @Nullable xee paramxee, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqg != null) {
        this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqg.a(paramErrorMessage);
      }
      return;
    }
    if (paramxee == null)
    {
      this.jdField_a_of_type_Ypg.jdField_a_of_type_Ypi.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Ypg.a());
        return;
      }
      yuk.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramxcg = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramxcg.mergeFrom(paramxee.a);
        paramxee = paramxcg.vid_list.get().listIterator();
        paramErrorMessage = paramxcg.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Ypg.jdField_a_of_type_Ypi.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Ypg.jdField_a_of_type_Ypi;
        if (paramxcg.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((wta)wth.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramxcg.share_to_discover.get()));
          if (!paramxee.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Ypg.jdField_a_of_type_Ypi.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramxee.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramxcg)
      {
        yuk.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramxcg);
        if (this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh != null)
        {
          this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Ypg.a());
          return;
        }
        yuk.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramxcg.is_end.has()) || (paramxcg.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Ypg.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Ypg.a());
        return;
      }
      yuk.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramxee = new qqstory_service.ReqTodayStoryVidList();
    paramxee.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramxee.cookie.set(paramxcg.cookie.get());
    wow.a().a(new xcg(this.jdField_a_of_type_JavaLangString, paramxee, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yph
 * JD-Core Version:    0.7.0.1
 */