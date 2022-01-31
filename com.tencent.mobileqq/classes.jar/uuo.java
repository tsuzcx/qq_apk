import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class uuo
  implements uni<uvd, uve>
{
  uuo(uun paramuun, utx paramutx) {}
  
  public void a(@NonNull uvd paramuvd, @Nullable uve paramuve, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramuve == null) || (paramErrorMessage.isFail()))
    {
      wsv.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Utx);
      uun.a(this.jdField_a_of_type_Uun, paramErrorMessage);
      return;
    }
    if (paramuve.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Utx.jdField_a_of_type_Int != 5)
      {
        wsv.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Utx + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        uun.b(this.jdField_a_of_type_Uun, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      uun.a(this.jdField_a_of_type_Uun, uun.a(paramuve.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Utx);
    }
    uuq.a(this.jdField_a_of_type_Utx, paramuve.jdField_a_of_type_ArrayOfByte);
    paramuvd = uun.a(paramuve.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Utx.jdField_a_of_type_Int == 12) {}
    uun.b(this.jdField_a_of_type_Uun, paramuvd);
    if (this.jdField_a_of_type_Utx.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Uun.a != null)
      {
        this.jdField_a_of_type_Uun.a.c = paramuve.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramuvd = this.jdField_a_of_type_Uun.a;
        if (paramuve.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramuvd.a = bool;
      this.jdField_a_of_type_Utx.i = paramuve.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      wsv.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Utx.jdField_a_of_type_JavaLangString, paramuve.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuo
 * JD-Core Version:    0.7.0.1
 */