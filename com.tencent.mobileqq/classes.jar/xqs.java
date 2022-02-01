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

class xqs
  implements vqp<wdw, wfu>
{
  xqs(xqr paramxqr, qqstory_service.ReqTodayStoryVidList paramReqTodayStoryVidList, String paramString) {}
  
  public void a(@NonNull wdw paramwdw, @Nullable wfu paramwfu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      if (this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrr != null) {
        this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrr.a(paramErrorMessage);
      }
      return;
    }
    if (paramwfu == null)
    {
      this.jdField_a_of_type_Xqr.jdField_a_of_type_Xqt.jdField_a_of_type_Int = paramErrorMessage.errorCode;
      if (this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs != null)
      {
        this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs.a(this.jdField_a_of_type_Xqr.a());
        return;
      }
      xvv.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramwdw = new qqstory_service.RspTodayStoryVidList();
    for (;;)
    {
      try
      {
        paramwdw.mergeFrom(paramwfu.a);
        paramwfu = paramwdw.vid_list.get().listIterator();
        paramErrorMessage = paramwdw.feed_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramErrorMessage)) {
          this.jdField_a_of_type_Xqr.jdField_a_of_type_Xqt.jdField_a_of_type_JavaLangString = paramErrorMessage;
        }
        paramErrorMessage = this.jdField_a_of_type_Xqr.jdField_a_of_type_Xqt;
        if (paramwdw.share_to_discover.get() == 1)
        {
          bool = true;
          paramErrorMessage.jdField_a_of_type_Boolean = bool;
          ((vuq)vux.a(10)).b("qqstory_my_story_have_contributed", Integer.valueOf(paramwdw.share_to_discover.get()));
          if (!paramwfu.hasNext()) {
            break;
          }
          this.jdField_a_of_type_Xqr.jdField_a_of_type_Xqt.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)paramwfu.next()).toStringUtf8());
          continue;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramwdw)
      {
        xvv.c("GetMyStoryVideoListStep", "协议返回错误, RspGetBatchUserVidList", paramwdw);
        if (this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs != null)
        {
          this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs.a(this.jdField_a_of_type_Xqr.a());
          return;
        }
        xvv.d("GetMyStoryVideoListStep", "finish callBack is null");
        return;
      }
    }
    if ((!paramwdw.is_end.has()) || (paramwdw.is_end.get() == 1))
    {
      if (this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs != null)
      {
        this.jdField_a_of_type_Xqr.jdField_a_of_type_Xrs.a(this.jdField_a_of_type_Xqr.a());
        return;
      }
      xvv.d("GetMyStoryVideoListStep", "finish callBack is null");
      return;
    }
    paramwfu = new qqstory_service.ReqTodayStoryVidList();
    paramwfu.date.set(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$ReqTodayStoryVidList.date.get());
    paramwfu.cookie.set(paramwdw.cookie.get());
    vqn.a().a(new wdw(this.jdField_a_of_type_JavaLangString, paramwfu, null), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqs
 * JD-Core Version:    0.7.0.1
 */