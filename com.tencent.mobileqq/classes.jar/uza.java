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

class uza
  implements syq<tly, tnw>
{
  uza(uyz paramuyz, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull tly paramtly, @Nullable tnw paramtnw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzz != null) {
        this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzz.a(paramErrorMessage);
      }
      return;
    }
    if (paramtnw == null)
    {
      this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzb.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyz.a());
        return;
      }
      ved.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramtly = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramtly.mergeFrom(paramtnw.a);
        paramtnw = paramtly.vid_list.get().listIterator();
        paramErrorMessage = paramtly.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzb.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzb;
        if (paramtly.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((tcs)tcz.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramtly.share_to_discover.get()));
          if (!paramtnw.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Uyz.jdField_a_of_type_Uzb.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramtnw.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramtly)
      {
        ved.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramtly);
        if (this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa != null)
        {
          this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyz.a());
          return;
        }
        ved.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramtly.is_end.has()) || (paramtly.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Uyz.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyz.a());
        return;
      }
      ved.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramtnw = new qqstory_service.ReqTodayStoryVidList();
    paramtnw.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramtnw.cookie.set(paramtly.cookie.get());
    syo.a().a(new tly(this.jdField_a_of_type_JavaLangString, paramtnw, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */