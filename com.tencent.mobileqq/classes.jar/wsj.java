import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wsj
  implements wld<wsy, wsz>
{
  wsj(wsi paramwsi, wrs paramwrs) {}
  
  public void a(@NonNull wsy paramwsy, @Nullable wsz paramwsz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwsz == null) || (paramErrorMessage.isFail()))
    {
      yqp.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Wrs);
      wsi.a(this.jdField_a_of_type_Wsi, paramErrorMessage);
      return;
    }
    if (paramwsz.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Wrs.jdField_a_of_type_Int != 5)
      {
        yqp.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Wrs + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        wsi.b(this.jdField_a_of_type_Wsi, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      wsi.a(this.jdField_a_of_type_Wsi, wsi.a(paramwsz.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Wrs);
    }
    wsl.a(this.jdField_a_of_type_Wrs, paramwsz.jdField_a_of_type_ArrayOfByte);
    paramwsy = wsi.a(paramwsz.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Wrs.jdField_a_of_type_Int == 12) {}
    wsi.b(this.jdField_a_of_type_Wsi, paramwsy);
    if (this.jdField_a_of_type_Wrs.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Wsi.a != null)
      {
        this.jdField_a_of_type_Wsi.a.c = paramwsz.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramwsy = this.jdField_a_of_type_Wsi.a;
        if (paramwsz.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramwsy.a = bool;
      this.jdField_a_of_type_Wrs.i = paramwsz.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      yqp.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Wrs.jdField_a_of_type_JavaLangString, paramwsz.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsj
 * JD-Core Version:    0.7.0.1
 */