import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class uyx
  implements urr<uzm, uzn>
{
  uyx(uyw paramuyw, uyg paramuyg) {}
  
  public void a(@NonNull uzm paramuzm, @Nullable uzn paramuzn, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramuzn == null) || (paramErrorMessage.isFail()))
    {
      wxe.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Uyg);
      uyw.a(this.jdField_a_of_type_Uyw, paramErrorMessage);
      return;
    }
    if (paramuzn.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Uyg.jdField_a_of_type_Int != 5)
      {
        wxe.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Uyg + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        uyw.b(this.jdField_a_of_type_Uyw, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      uyw.a(this.jdField_a_of_type_Uyw, uyw.a(paramuzn.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Uyg);
    }
    uyz.a(this.jdField_a_of_type_Uyg, paramuzn.jdField_a_of_type_ArrayOfByte);
    paramuzm = uyw.a(paramuzn.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Uyg.jdField_a_of_type_Int == 12) {}
    uyw.b(this.jdField_a_of_type_Uyw, paramuzm);
    if (this.jdField_a_of_type_Uyg.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Uyw.a != null)
      {
        this.jdField_a_of_type_Uyw.a.c = paramuzn.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramuzm = this.jdField_a_of_type_Uyw.a;
        if (paramuzn.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramuzm.a = bool;
      this.jdField_a_of_type_Uyg.i = paramuzn.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      wxe.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Uyg.jdField_a_of_type_JavaLangString, paramuzn.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyx
 * JD-Core Version:    0.7.0.1
 */