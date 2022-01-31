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

class wsb
  implements urr<vez, vgx>
{
  wsb(wsa paramwsa, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull vez paramvez, @Nullable vgx paramvgx, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Wsa.jdField_a_of_type_Wta != null) {
        this.jdField_a_of_type_Wsa.jdField_a_of_type_Wta.a(paramErrorMessage);
      }
      return;
    }
    if (paramvgx == null)
    {
      this.jdField_a_of_type_Wsa.jdField_a_of_type_Wsc.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb.a(this.jdField_a_of_type_Wsa.a());
        return;
      }
      wxe.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramvez = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramvez.mergeFrom(paramvgx.a);
        paramvgx = paramvez.vid_list.get().listIterator();
        paramErrorMessage = paramvez.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Wsa.jdField_a_of_type_Wsc.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Wsa.jdField_a_of_type_Wsc;
        if (paramvez.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((uvt)uwa.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramvez.share_to_discover.get()));
          if (!paramvgx.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Wsa.jdField_a_of_type_Wsc.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramvgx.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramvez)
      {
        wxe.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramvez);
        if (this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb != null)
        {
          this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb.a(this.jdField_a_of_type_Wsa.a());
          return;
        }
        wxe.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramvez.is_end.has()) || (paramvez.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wsa.jdField_a_of_type_Wtb.a(this.jdField_a_of_type_Wsa.a());
        return;
      }
      wxe.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramvgx = new qqstory_service.ReqTodayStoryVidList();
    paramvgx.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramvgx.cookie.set(paramvez.cookie.get());
    urp.a().a(new vez(this.jdField_a_of_type_JavaLangString, paramvgx, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsb
 * JD-Core Version:    0.7.0.1
 */