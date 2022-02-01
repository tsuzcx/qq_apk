import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class vxu
  implements vqp<vyj, vyk>
{
  vxu(vxt paramvxt, vxd paramvxd) {}
  
  public void a(@NonNull vyj paramvyj, @Nullable vyk paramvyk, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvyk == null) || (paramErrorMessage.isFail()))
    {
      xvv.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Vxd);
      vxt.a(this.jdField_a_of_type_Vxt, paramErrorMessage);
      return;
    }
    if (paramvyk.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Vxd.jdField_a_of_type_Int != 5)
      {
        xvv.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Vxd + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        vxt.b(this.jdField_a_of_type_Vxt, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      vxt.a(this.jdField_a_of_type_Vxt, vxt.a(paramvyk.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Vxd);
    }
    vxw.a(this.jdField_a_of_type_Vxd, paramvyk.jdField_a_of_type_ArrayOfByte);
    paramvyj = vxt.a(paramvyk.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Vxd.jdField_a_of_type_Int == 12) {}
    vxt.b(this.jdField_a_of_type_Vxt, paramvyj);
    if (this.jdField_a_of_type_Vxd.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Vxt.a != null)
      {
        this.jdField_a_of_type_Vxt.a.c = paramvyk.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramvyj = this.jdField_a_of_type_Vxt.a;
        if (paramvyk.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramvyj.a = bool;
      this.jdField_a_of_type_Vxd.i = paramvyk.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      xvv.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Vxd.jdField_a_of_type_JavaLangString, paramvyk.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */