import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wwe
  implements woy<wwt, wwu>
{
  wwe(wwd paramwwd, wvn paramwvn) {}
  
  public void a(@NonNull wwt paramwwt, @Nullable wwu paramwwu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwwu == null) || (paramErrorMessage.isFail()))
    {
      yuk.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Wvn);
      wwd.a(this.jdField_a_of_type_Wwd, paramErrorMessage);
      return;
    }
    if (paramwwu.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Wvn.jdField_a_of_type_Int != 5)
      {
        yuk.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Wvn + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        wwd.b(this.jdField_a_of_type_Wwd, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      wwd.a(this.jdField_a_of_type_Wwd, wwd.a(paramwwu.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Wvn);
    }
    wwg.a(this.jdField_a_of_type_Wvn, paramwwu.jdField_a_of_type_ArrayOfByte);
    paramwwt = wwd.a(paramwwu.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Wvn.jdField_a_of_type_Int == 12) {}
    wwd.b(this.jdField_a_of_type_Wwd, paramwwt);
    if (this.jdField_a_of_type_Wvn.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Wwd.a != null)
      {
        this.jdField_a_of_type_Wwd.a.c = paramwwu.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramwwt = this.jdField_a_of_type_Wwd.a;
        if (paramwwu.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramwwt.a = bool;
      this.jdField_a_of_type_Wvn.i = paramwwu.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      yuk.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Wvn.jdField_a_of_type_JavaLangString, paramwwu.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwe
 * JD-Core Version:    0.7.0.1
 */