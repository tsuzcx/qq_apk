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

class ylm
  implements wld<wyl, xaj>
{
  ylm(yll paramyll, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull wyl paramwyl, @Nullable xaj paramxaj, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Yll.jdField_a_of_type_Yml != null) {
        this.jdField_a_of_type_Yll.jdField_a_of_type_Yml.a(paramErrorMessage);
      }
      return;
    }
    if (paramxaj == null)
    {
      this.jdField_a_of_type_Yll.jdField_a_of_type_Yln.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm.a(this.jdField_a_of_type_Yll.a());
        return;
      }
      yqp.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramwyl = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramwyl.mergeFrom(paramxaj.a);
        paramxaj = paramwyl.vid_list.get().listIterator();
        paramErrorMessage = paramwyl.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Yll.jdField_a_of_type_Yln.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Yll.jdField_a_of_type_Yln;
        if (paramwyl.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((wpf)wpm.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramwyl.share_to_discover.get()));
          if (!paramxaj.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Yll.jdField_a_of_type_Yln.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramxaj.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramwyl)
      {
        yqp.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramwyl);
        if (this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm != null)
        {
          this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm.a(this.jdField_a_of_type_Yll.a());
          return;
        }
        yqp.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramwyl.is_end.has()) || (paramwyl.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Yll.jdField_a_of_type_Ymm.a(this.jdField_a_of_type_Yll.a());
        return;
      }
      yqp.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramxaj = new qqstory_service.ReqTodayStoryVidList();
    paramxaj.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramxaj.cookie.set(paramwyl.cookie.get());
    wlb.a().a(new wyl(this.jdField_a_of_type_JavaLangString, paramxaj, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylm
 * JD-Core Version:    0.7.0.1
 */