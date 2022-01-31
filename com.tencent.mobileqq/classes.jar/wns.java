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

class wns
  implements uni<vaq, vco>
{
  wns(wnr paramwnr, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull vaq paramvaq, @Nullable vco paramvco, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Wnr.jdField_a_of_type_Wor != null) {
        this.jdField_a_of_type_Wnr.jdField_a_of_type_Wor.a(paramErrorMessage);
      }
      return;
    }
    if (paramvco == null)
    {
      this.jdField_a_of_type_Wnr.jdField_a_of_type_Wnt.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos.a(this.jdField_a_of_type_Wnr.a());
        return;
      }
      wsv.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramvaq = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramvaq.mergeFrom(paramvco.a);
        paramvco = paramvaq.vid_list.get().listIterator();
        paramErrorMessage = paramvaq.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Wnr.jdField_a_of_type_Wnt.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Wnr.jdField_a_of_type_Wnt;
        if (paramvaq.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((urk)urr.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramvaq.share_to_discover.get()));
          if (!paramvco.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Wnr.jdField_a_of_type_Wnt.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramvco.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramvaq)
      {
        wsv.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramvaq);
        if (this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos != null)
        {
          this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos.a(this.jdField_a_of_type_Wnr.a());
          return;
        }
        wsv.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramvaq.is_end.has()) || (paramvaq.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wnr.jdField_a_of_type_Wos.a(this.jdField_a_of_type_Wnr.a());
        return;
      }
      wsv.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramvco = new qqstory_service.ReqTodayStoryVidList();
    paramvco.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramvco.cookie.set(paramvaq.cookie.get());
    ung.a().a(new vaq(this.jdField_a_of_type_JavaLangString, paramvco, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */