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

class uzd
  implements syt<tmb, tnz>
{
  uzd(uzc paramuzc, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull tmb paramtmb, @Nullable tnz paramtnz, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Uzc.jdField_a_of_type_Vac != null) {
        this.jdField_a_of_type_Uzc.jdField_a_of_type_Vac.a(paramErrorMessage);
      }
      return;
    }
    if (paramtnz == null)
    {
      this.jdField_a_of_type_Uzc.jdField_a_of_type_Uze.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad != null)
      {
        this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad.a(this.jdField_a_of_type_Uzc.a());
        return;
      }
      veg.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramtmb = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramtmb.mergeFrom(paramtnz.a);
        paramtnz = paramtmb.vid_list.get().listIterator();
        paramErrorMessage = paramtmb.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Uzc.jdField_a_of_type_Uze.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Uzc.jdField_a_of_type_Uze;
        if (paramtmb.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((tcv)tdc.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramtmb.share_to_discover.get()));
          if (!paramtnz.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Uzc.jdField_a_of_type_Uze.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramtnz.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramtmb)
      {
        veg.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramtmb);
        if (this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad != null)
        {
          this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad.a(this.jdField_a_of_type_Uzc.a());
          return;
        }
        veg.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramtmb.is_end.has()) || (paramtmb.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad != null)
      {
        this.jdField_a_of_type_Uzc.jdField_a_of_type_Vad.a(this.jdField_a_of_type_Uzc.a());
        return;
      }
      veg.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramtnz = new qqstory_service.ReqTodayStoryVidList();
    paramtnz.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramtnz.cookie.set(paramtmb.cookie.get());
    syr.a().a(new tmb(this.jdField_a_of_type_JavaLangString, paramtnz, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzd
 * JD-Core Version:    0.7.0.1
 */